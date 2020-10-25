package es.jlarriba.jrmapi.http;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * HTTP methods.
 *
 * @author jlarriba
 */
public class Net {
    
    private static final Logger LOGGER = LogManager.getLogger();
    private HttpClient client;
    
    public Net() {
        this.client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .build();
    }
    
    public String get(String url, String token, String docID) {
        return get(url + "?withBlob=true&doc=" + docID, token);
    }

    public String get(String url, String token) {
        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .build();

        return sendRequest(request);
    }
    
    public void getStream(String url, String token, File file) {
        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .header("Authorization", "Bearer " + token)
                .build();

        sendRequest(request, file);
    }
    
    public String post(String url, String token) {
        return post(url, token, BodyPublishers.noBody());
    }
    
    public String post(String url, String token, Object payload) {
        return post(url, token, BodyPublishers.ofString(new Gson().toJson(payload)));
    }
    
    private String post(String url, String token, BodyPublisher bodyPublisher) {
        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .POST(bodyPublisher)
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                //.header("Content-Length", "0")
                .build();

        return sendRequest(request);
    }
    
    public String put(String url, String token) {
        return put(url, token, null);
    }

    public String put(String url, String token, List<Object> payload) {
        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .PUT(BodyPublishers.ofString(new Gson().toJson(payload)))
                .header("Authorization", "Bearer " + token)
                .build();
        return sendRequest(request);
    }

    public String putStream(String url, String token, File file) {
        try {
        HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                .PUT(BodyPublishers.ofFile(file.toPath()))
                .header("Authorization", "Bearer " + token)
                .build();
        return sendRequest(request);
        } catch (FileNotFoundException e) {
            LOGGER.error("file does not exist", e);
        }
        return "";
    }
    
    private String sendRequest(HttpRequest request) {
        String res = null;

        try {
            LOGGER.debug(request.uri());
            LOGGER.debug(Arrays.asList(request.headers()));
            
            var response = client.send(request, BodyHandlers.ofString());
            LOGGER.debug(response.statusCode());
            if (response.statusCode() == 200) {
                res = response.body();
            } else {
                LOGGER.warn(response.body());
            }
        } catch (IOException | InterruptedException e) {
            LOGGER.error("Error while launching request", e);
        }

        return res;
    }
    
    private void sendRequest(HttpRequest request, File file) {
        try {
            LOGGER.debug(request.uri());
            var response = client.send(request, BodyHandlers.ofFile(file.toPath()));
            LOGGER.debug(response.statusCode());
        } catch (IOException | InterruptedException e) {
            LOGGER.error("Error while launching request", e);
        }
    }
}

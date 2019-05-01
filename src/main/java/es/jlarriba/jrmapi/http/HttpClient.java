/*
 * Copyright 2019 jlarriba.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package es.jlarriba.jrmapi.http;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author jlarriba
 */
public class HttpClient {

    private static final Logger LOGGER = LogManager.getLogger();
    
    private final RequestConfig requestConfig;
    
    public HttpClient() {
        this.requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(5000)
                .setConnectTimeout(5000)
                .setSocketTimeout(2000)
                .build();
    }
    
    public String get(String url, String token, String docID) {
        return get(url + "?withBlob=true&doc=" + docID, token);
    }

    public String get(String url, String token) {
        HttpUriRequest request = RequestBuilder.get(url)
                    .setConfig(requestConfig)
                    .addHeader("Authorization", "Bearer " + token)
                    .addHeader("Content-Type", "application/json")
                    .build();

        return sendRequest(request);
    }

    public void getStream(String url, String token, File file) {
        HttpUriRequest request = RequestBuilder.get(url)
                    .setConfig(requestConfig)
                    .addHeader("Authorization", "Bearer " + token)
                    .build();

        sendRequest(request, file);
    }

    public String post(String url, String token) {
        HttpUriRequest request = RequestBuilder.post(url)
                    .setConfig(requestConfig)
                    .addHeader("Authorization", "Bearer " + token)
                    .addHeader("Content-Type", "application/json")
                    .build();

        return sendRequest(request);
    }

    public String put(String url, String token) {
        return put(url, token, null);
    }

    public String put(String url, String token, List<Object> payload) {
        try {
            HttpUriRequest request = RequestBuilder.put(url)
                    .setConfig(requestConfig)
                    .addHeader("Authorization", "Bearer " + token)
                    .setEntity(new StringEntity(new Gson().toJson(payload)))
                    .build();
            LOGGER.debug("JSON: " + new Gson().toJson(payload));
            return sendRequest(request);
        } catch (UnsupportedEncodingException ex) {
            LOGGER.error("Error decoding payload:",  ex);
        }
        
        return "";
    }

    public String putStream(String url, String token, File file) {
        HttpUriRequest request = RequestBuilder.put(url)
                .setConfig(requestConfig)
                .addHeader("Authorization", "Bearer " + token)
                .setEntity(new FileEntity(file))
                .build();
        
        return sendRequest(request);
    }

    private String sendRequest(HttpUriRequest request) {
        CloseableHttpClient instance = HttpClientBuilder.create().build();
        CloseableHttpResponse response;
        String res = null;

        try {
            LOGGER.debug(request.getURI());
            LOGGER.debug(Arrays.asList(request.getAllHeaders()));
            
            response = instance.execute(request);
            LOGGER.debug(response.getStatusLine().getStatusCode() + " " + response.getStatusLine().getReasonPhrase());
            if (response.getStatusLine().getStatusCode() == 200) {
                res = new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
                        .lines().parallel().collect(Collectors.joining("\n"));
            } else {
                LOGGER.debug(new BufferedReader(new InputStreamReader(response.getEntity().getContent()))
                        .lines().parallel().collect(Collectors.joining("\n")));
            }
            response.close();
        } catch (IOException e) {
            LOGGER.error("Error while launching request", e);
        }

        return res;
    }

    private void sendRequest(HttpUriRequest request, File file) {
        CloseableHttpClient instance = HttpClientBuilder.create().build();
        CloseableHttpResponse response;

        try {
            LOGGER.debug(request.getURI());
            response = instance.execute(request);
            LOGGER.debug(response.getStatusLine().getStatusCode() + " " + response.getStatusLine().getReasonPhrase());
            if (response.getStatusLine().getStatusCode() == 200) {
                // Copy the inputstream being downloaded from the server to a File.
                Files.copy(response.getEntity().getContent(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);

            }
            response.close();
        } catch (IOException e) {
            LOGGER.error("Error while launching request", e);
        }
    }
}

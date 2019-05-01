/*
 * Copyright 2019 juanlarriba.
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
package es.jlarriba.jrmapi;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import es.jlarriba.jrmapi.http.HttpClient;
import es.jlarriba.jrmapi.model.DeleteDocument;
import java.util.ArrayList;
import java.util.List;
import es.jlarriba.jrmapi.model.Document;
import es.jlarriba.jrmapi.model.MetadataDocument;
import es.jlarriba.jrmapi.model.UploadDocumentRequest;
import es.jlarriba.jrmapi.model.UploadDocumentResponse;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author juanlarriba
 */
public class Jrmapi {
    private static final Logger LOGGER = LogManager.getLogger();
    
    private static final String BASE_URL = "https://document-storage-production-dot-remarkable-production.appspot.com";
    private static final String LIST_DOCS = BASE_URL + "/document-storage/json/2/docs";
    private static final String UPDATE_STATUS = BASE_URL + "/document-storage/json/2/upload/update-status";
    private static final String UPLOAD_REQUEST = BASE_URL + "/document-storage/json/2/upload/request";
    private static final String DELETE = BASE_URL + "/document-storage/json/2/delete";
    
    private final Gson gson;
    private final String userToken;
    private final HttpClient http;
    
    public Jrmapi() {
        Authentication auth = new Authentication();
        userToken = auth.newUserToken();
        http = new HttpClient();
        gson = new Gson();
    }
    
    public List<Document> listDocs() {
        
        String response = http.get(LIST_DOCS, userToken);
        LOGGER.debug(response);
        return gson.fromJson(response, new TypeToken<List<Document>>(){}.getType());
    }
    
    public void fetchDoc(Document doc, String path) {
        String response = http.get(LIST_DOCS, userToken, doc.getID());
        List<Document> docs = gson.fromJson(response, new TypeToken<List<Document>>(){}.getType());
        if (path.charAt(path.length() - 1) == '/') 
            path += "";
        else 
            path += "/";
        File file = new File(path + doc.getVissibleName() + ".zip");
        LOGGER.debug("Download file to " + path + doc.getVissibleName() + ".zip");
        http.getStream(docs.get(0).getBlobURLGet(), userToken, file);
    }
    
    public void createDir(String name, String parentID) {
        String id = UUID.randomUUID().toString();
        UploadDocumentRequest docRequest = new UploadDocumentRequest();
        docRequest.setID(id);
        docRequest.setType("CollectionType");
        docRequest.setVersion(1);
        
        List<Object> uploadRequest = new ArrayList<>();
        uploadRequest.add(docRequest);
        String response = http.put(UPLOAD_REQUEST, userToken, uploadRequest);
        
        List<UploadDocumentResponse> docResponse = gson.fromJson(response, new TypeToken<List<UploadDocumentResponse>>(){}.getType());
        http.putStream(docResponse.get(0).getBlobURLPut(), userToken, Utils.createZipDirectory(id));
        
        MetadataDocument metadataDoc = new MetadataDocument();
        metadataDoc.setID(id);
        metadataDoc.setModifiedClient(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'+02:00'")));
        metadataDoc.setParent(parentID);
        metadataDoc.setType("CollectionType");
        metadataDoc.setVersion(1);
        metadataDoc.setVissibleName(name);
        
        List<Object> uploadMetadataDoc = new ArrayList<>();
        uploadMetadataDoc.add(metadataDoc);
        
        http.put(UPDATE_STATUS, userToken, uploadMetadataDoc);
    }
    
    public void uploadDoc(File file, String parentID) {
        String id = UUID.randomUUID().toString();
        UploadDocumentRequest docRequest = new UploadDocumentRequest();
        docRequest.setID(id);
        docRequest.setType("DocumentType");
        docRequest.setVersion(1);
        
        List<Object> uploadRequest = new ArrayList<>();
        uploadRequest.add(docRequest);
        String response = http.put(UPLOAD_REQUEST, userToken, uploadRequest);
        
        List<UploadDocumentResponse> docResponse = gson.fromJson(response, new TypeToken<List<UploadDocumentResponse>>(){}.getType());
        http.putStream(docResponse.get(0).getBlobURLPut(), userToken, Utils.createZipDocument(id, file));
        
        MetadataDocument metadataDoc = new MetadataDocument();
        metadataDoc.setID(id);
        metadataDoc.setModifiedClient(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS'+02:00'")));
        metadataDoc.setParent(parentID);
        metadataDoc.setType("DocumentType");
        metadataDoc.setVersion(1);
        metadataDoc.setVissibleName(FilenameUtils.getBaseName(file.getAbsolutePath()));
        
        List<Object> uploadMetadataDoc = new ArrayList<>();
        uploadMetadataDoc.add(metadataDoc);
        
        http.put(UPDATE_STATUS, userToken, uploadMetadataDoc);
    }
    
    public void deleteEntry(Document doc) {
        DeleteDocument deleteDoc = new DeleteDocument();
        deleteDoc.setVersion(doc.getVersion());
        deleteDoc.setID(doc.getID());
        
        List<Object> uploadDeleteDoc = new ArrayList<>();
        uploadDeleteDoc.add(deleteDoc);
        
        http.put(DELETE, userToken, uploadDeleteDoc);
    }
    
    public void moveEntry(Document doc) {
        
    }
}

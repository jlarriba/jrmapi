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
import com.google.gson.GsonBuilder;
import java.io.File;
import java.util.List;
import org.junit.jupiter.api.Test;
import es.jlarriba.jrmapi.model.Document;

/**
 * Integration Test.
 * 
 * @author juanlarriba
 */
public class TestApi {
    
    @Test
    public void testListDocs() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Jrmapi api = new Jrmapi();
        Authentication auth = new Authentication();
        System.out.println(auth.userToken());
        List<Document> docs = api.listDocs();
        System.out.println(gson.toJson(docs));
/*        
        api.fetchDoc(docs.get(1), "/a/download/directory");
        api.createDir("test_api", "");
        Document doc = new Document();
        doc.setID("b55b09b6-c636-4f9a-8309-2a0faa13a07b");
        doc.setVersion(1);
        api.deleteEntry(doc);
        api.uploadDoc(new File("/a/pdf/file.pdf"), "");
*/        
    }
}

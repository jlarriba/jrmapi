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
import es.jlarriba.jrmapi.model.Content;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author juanlarriba
 */
public class Utils {
    
    private static final Logger LOGGER = LogManager.getLogger();
    
    public static File createZipDirectory(String id) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(id + ".content"));
            writer.write("{}");
            writer.close();
        
            String sourceFile = id + ".content";
            FileOutputStream fos = new FileOutputStream("jrmapi.zip");
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            File fileToZip = new File(sourceFile);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);
            
            byte[] bytes = new byte[1024];
            int length;
            while((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            
            zipOut.close();
            fis.close();
            fos.close();
            
            return new File("jrmapi.zip");
        } catch (IOException e) {
            LOGGER.error("Problem creating ZIP file: ", e);
        }
        
        return null;
    }
    
    public static File createZipDocument(String id, File file) {
        try {
            String ext = FilenameUtils.getExtension(file.getAbsolutePath());
            File destFile = new File(id + "." + ext);
            destFile.createNewFile();
            
            FileUtils.copyFile(file, destFile);
            
            File pagedata = new File(id + ".pagedata");
            pagedata.createNewFile();
            
            BufferedWriter writerContent = new BufferedWriter(new FileWriter(id + ".content"));
            writerContent.write(new Gson().toJson(createZipContent(ext)));
            writerContent.close();
            
            List<String> srcFiles = new ArrayList<>();
            srcFiles.add(id + ".content");
            srcFiles.add(id + ".pagedata");
            srcFiles.add(id + "." + ext);
        
            FileOutputStream fos = new FileOutputStream("jrmapi.zip");
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            for (String srcFile : srcFiles) {
                File fileToZip = new File(srcFile);
                FileInputStream fis = new FileInputStream(fileToZip);
                ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                zipOut.putNextEntry(zipEntry);

                byte[] bytes = new byte[1024];
                int length;
                while((length = fis.read(bytes)) >= 0) {
                    zipOut.write(bytes, 0, length);
                }
                fis.close();
            }
            zipOut.close();
            fos.close();
            
            return new File("jrmapi.zip");
        } catch (IOException e) {
            LOGGER.error("Problem creating ZIP file: ", e);
        }
        
        return null;
    }
    
    private static Content createZipContent(String ext) {
        Content content = new Content();
        content.setExtraMetadata(new HashMap<>());
        content.setTransform(new HashMap<>());
        content.setLastOpenedPage(0);
        content.setLineHeight(-1);
        content.setMargins(100);
        content.setTextScale(1);
        content.setFileType(ext);
        
        return content;
    }
}

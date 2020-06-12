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

import es.jlarriba.jrmapi.http.Net;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author juanlarriba
 */
public class Authentication {
    private static final Logger LOGGER = LogManager.getLogger();
    
    private static String DEVICE_AUTH_URL = "https://my.remarkable.com/token/json/2/device/new";
    private static String USER_AUTH_URL = "https://my.remarkable.com/token/json/2/user/new";
    
    public String userToken() {
        Net net = new Net();
        return net.post(USER_AUTH_URL, authProperties().getProperty("devicetoken"));
    }
    
    private Properties authProperties() {
        Properties properties = new Properties();
        String userHome = System.getProperty("user.home");
        try {
            InputStream is = new FileInputStream(new File(userHome + "/.rmapi"));
            properties.load(is);
        } catch (IOException e) {
            LOGGER.error("cannot find ~/.rmapi");
        }
        
        return properties;
    }
}

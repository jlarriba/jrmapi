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

/**
 *
 * @author juanlarriba
 */
public class Authentication {
    private static String DEVICE_AUTH_URL = "https://my.remarkable.com/token/json/2/device/new";
    private static String USER_AUTH_URL = "https://my.remarkable.com/token/json/2/user/new";
    
    private static final String USER_TOKEN = "";
    //private static final String DEVICE_TOKEN = "";
    
    public String newUserToken() {
        //return HttpClient.post(USER_AUTH_URL, DEVICE_TOKEN);
        return USER_TOKEN;
    }
}

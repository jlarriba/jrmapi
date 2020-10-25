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
import es.jlarriba.jrmapi.model.DeviceRegistration;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

/**
 * My.Remarkable.com Authentication.
 * 
 * @author juanlarriba
 */
public class Authentication {

    private static final String DEVICE_AUTH_URL = "https://my.remarkable.com/token/json/2/device/new";
    private static final String USER_AUTH_URL = "https://my.remarkable.com/token/json/2/user/new";

    private static final File RMAPI_PROPERTIES_FILE = new File(System.getProperty("user.home"), "/.rmapi");
    private static final String DEVICETOKEN_PROPERTY_NAME = "devicetoken";

    private final Net net = new Net();

    /**
     * Register new "device" (or app,or service).
     * See https://github.com/splitbrain/ReMarkableAPI/wiki/Authentication#registering-a-device.
     * 
     * @param oneTimeCodeValid5Min the one time code that's valid for 5 minutes
     *                             which was obtained by the end-user on
     *                             https://my.remarkable.com/connect/desktop
     *                             (https://my.remarkable.com/connect/mobile)
     * @param deviceUUID           a UUID-4 to identify the client
     * 
     * @return new token in plain text
     */
    public String registerDevice(String oneTimeCodeValid5Min, UUID deviceUUID) {
        return net.post(DEVICE_AUTH_URL, "", new DeviceRegistration().code(oneTimeCodeValid5Min)
                .deviceDesc("mobile-android").deviceID(deviceUUID.toString()));
    }

    /**
     * Refresh Bearer Token.
     * See https://github.com/splitbrain/ReMarkableAPI/wiki/Authentication#refreshing-a-token.
     */
    public String userToken() {
        return net.post(USER_AUTH_URL, getDeviceToken());
    }

    protected String getDeviceToken() {
        try {
            Properties properties = new Properties();
            InputStream is = new FileInputStream(RMAPI_PROPERTIES_FILE);
            properties.load(is);
            return properties.getProperty(DEVICETOKEN_PROPERTY_NAME);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read " + RMAPI_PROPERTIES_FILE, e);
        }
    }

    public void registerDeviceAndSaveDeviceToken(String oneTimeCodeValid5Min) throws IOException {
        var newDeviceToken = registerDevice(oneTimeCodeValid5Min, UUID.randomUUID());
        var properties = new Properties();
        properties.setProperty(DEVICETOKEN_PROPERTY_NAME, newDeviceToken);
        var os = new FileOutputStream(RMAPI_PROPERTIES_FILE);
        properties.store(os, "https://github.com/jlarriba/jrmapi");
        os.close();
    }

    public static void main(String[] args) throws IOException {

        System.out.println("OTP: " + args[0]);
        Authentication auth = new Authentication();
        auth.registerDeviceAndSaveDeviceToken(args[0]);
        System.out.println("New SAVED Device Token: " + auth.getDeviceToken());
    }
}

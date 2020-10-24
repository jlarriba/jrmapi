/*
 * Copyright 2020 Michael Vorburger.ch.
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
package es.jlarriba.jrmapi.model;

/**
 * Device Registration payload body.
 * See https://github.com/splitbrain/ReMarkableAPI/wiki/Authentication#registering-a-device
 * 
 * {
 *   "code": "gliuqtne",
 *   "deviceDesc": "desktop-windows",
 *   "deviceID": "701c3752-1025-4770-af43-5ddcfa4dabb2"
 * }
 *  
 * @author Michael Vorburger.ch
 */
public class DeviceRegistration {

    private String code;
    private String deviceDesc;
    private String deviceID;

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public DeviceRegistration deviceID(String deviceID) {
        this.deviceID = deviceID;
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DeviceRegistration code(String code) {
        this.code = code;
        return this;
    }

    public String getDeviceDesc() {
        return deviceDesc;
    }

    public void setDeviceDesc(String deviceDesc) {
        this.deviceDesc = deviceDesc;
    }

    public DeviceRegistration deviceDesc(String deviceDesc) {
        this.deviceDesc = deviceDesc;
        return this;
    }
}

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
package es.jlarriba.jrmapi.model;

/**
 *[{
    "ID": "1dd71dfc-a463-4317-9428-ece0bff128b9",
    "Type": "CollectionType",
    "Version": 1
}]
 * @author juanlarriba
 */
public class UploadDocumentRequest {
    private String ID;
    private String Type;
    private int Version;

    /**
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * @return the Type
     */
    public String getType() {
        return Type;
    }

    /**
     * @param Type the Type to set
     */
    public void setType(String Type) {
        this.Type = Type;
    }

    /**
     * @return the Version
     */
    public int getVersion() {
        return Version;
    }

    /**
     * @param Version the Version to set
     */
    public void setVersion(int Version) {
        this.Version = Version;
    }
}

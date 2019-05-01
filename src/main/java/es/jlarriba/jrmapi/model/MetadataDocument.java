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
 * {
 *  "ID":"a728025a-01a5-435c-b04b-852b9d23af47",
 *  "Parent":"",
 *  "VissibleName":"test1",
 *  "Type":"CollectionType",
 *  "Version":1,
 *  "ModifiedClient":"2019-04-27T22:31:47.623755+02:00"
 * }
 * @author juanlarriba
 */
public class MetadataDocument {
    private String ID;
    private String Parent;
    private String VissibleName;
    private String Type;
    private int Version;
    private String ModifiedClient;

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
     * @return the Parent
     */
    public String getParent() {
        return Parent;
    }

    /**
     * @param Parent the Parent to set
     */
    public void setParent(String Parent) {
        this.Parent = Parent;
    }

    /**
     * @return the VissibleName
     */
    public String getVissibleName() {
        return VissibleName;
    }

    /**
     * @param VissibleName the VissibleName to set
     */
    public void setVissibleName(String VissibleName) {
        this.VissibleName = VissibleName;
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

    /**
     * @return the ModifiedClient
     */
    public String getModifiedClient() {
        return ModifiedClient;
    }

    /**
     * @param ModifiedClient the ModifiedClient to set
     */
    public void setModifiedClient(String ModifiedClient) {
        this.ModifiedClient = ModifiedClient;
    }
}

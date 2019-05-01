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

import java.util.Date;

/**
 *
 * {
        "ID": "07f6f637-b17d-4c9a-8a14-55ef397d7a98",
        "Version": 1,
        "Message": "",
        "Success": true,
        "BlobURLGet": "",
        "BlobURLGetExpires": "0001-01-01T00:00:00Z",
        "ModifiedClient": "2019-03-17T19:35:07.295295Z",
        "Type": "DocumentType",
        "VissibleName": "Sender, Ramon J. - Viaje a la aldea del crimen",
        "CurrentPage": 0,
        "Bookmarked": false,
        "Parent": ""
    }
    * 
 * @author juanlarriba
 */
public class Document {
    
    private String ID;
    private int Version;
    private String Message;
    private boolean Success;
    private String BlobURLGet;
    private Date BlobURLGetExpires;
    private Date ModifiedClient;
    private String Type;
    private String VissibleName;
    private int CurrentPage;
    private boolean Bookmarked;
    private String Parent;

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
     * @return the Message
     */
    public String getMessage() {
        return Message;
    }

    /**
     * @param Message the Message to set
     */
    public void setMessage(String Message) {
        this.Message = Message;
    }

    /**
     * @return the Success
     */
    public boolean isSuccess() {
        return Success;
    }

    /**
     * @param Success the Success to set
     */
    public void setSuccess(boolean Success) {
        this.Success = Success;
    }

    /**
     * @return the BlobURLGet
     */
    public String getBlobURLGet() {
        return BlobURLGet;
    }

    /**
     * @param BlobURLGet the BlobURLGet to set
     */
    public void setBlobURLGet(String BlobURLGet) {
        this.BlobURLGet = BlobURLGet;
    }

    /**
     * @return the BlobURLGetExpires
     */
    public Date getBlobURLGetExpires() {
        return BlobURLGetExpires;
    }

    /**
     * @param BlobURLGetExpires the BlobURLGetExpires to set
     */
    public void setBlobURLGetExpires(Date BlobURLGetExpires) {
        this.BlobURLGetExpires = BlobURLGetExpires;
    }

    /**
     * @return the ModifiedClient
     */
    public Date getModifiedClient() {
        return ModifiedClient;
    }

    /**
     * @param ModifiedClient the ModifiedClient to set
     */
    public void setModifiedClient(Date ModifiedClient) {
        this.ModifiedClient = ModifiedClient;
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
     * @return the CurrentPage
     */
    public int getCurrentPage() {
        return CurrentPage;
    }

    /**
     * @param CurrentPage the CurrentPage to set
     */
    public void setCurrentPage(int CurrentPage) {
        this.CurrentPage = CurrentPage;
    }

    /**
     * @return the Bookmarked
     */
    public boolean isBookmarked() {
        return Bookmarked;
    }

    /**
     * @param Bookmarked the Bookmarked to set
     */
    public void setBookmarked(boolean Bookmarked) {
        this.Bookmarked = Bookmarked;
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
}

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
 *[
    {
        "ID": "1dd71dfc-a463-4317-9428-ece0bff128b9",
        "Version": 1,
        "Message": "",
        "Success": true,
        "BlobURLPut": "generated-url,
        "BlobURLPutExpires": "2019-04-25T16:02:52.536577772Z"
    }
]
 * @author juanlarriba
 */
public class UploadDocumentResponse {
    private String ID;
    private int Version;
    private String Message;
    private boolean Success;
    private String BlobURLPut;
    private Date BlobURLPutExpires;

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
     * @return the BlobURLPut
     */
    public String getBlobURLPut() {
        return BlobURLPut;
    }

    /**
     * @param BlobURLPut the BlobURLPut to set
     */
    public void setBlobURLPut(String BlobURLPut) {
        this.BlobURLPut = BlobURLPut;
    }

    /**
     * @return the BlobURLPutExpires
     */
    public Date getBlobURLPutExpires() {
        return BlobURLPutExpires;
    }

    /**
     * @param BlobURLPutExpires the BlobURLPutExpires to set
     */
    public void setBlobURLPutExpires(Date BlobURLPutExpires) {
        this.BlobURLPutExpires = BlobURLPutExpires;
    }
}

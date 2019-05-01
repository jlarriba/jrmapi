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
        "BlobURLPut": "https://storage.googleapis.com/remarkable-production-document-storage/user-auth0%7C5c0675464df2a410aeb2feb2/1dd71dfc-a463-4317-9428-ece0bff128b9?Expires=1556208172&GoogleAccessId=remarkable-production%40appspot.gserviceaccount.com&Signature=Lmf%2B5IKZ7yzRbMvRfSfAOpINHffkcV0jWuhhNC8dto3t%2BJgCGF6BPLaLjcwM%2F5%2BrGaAUn68Kqv%2B9g6hiaeD0dcWnbt6SN%2BoxbhPFj3Jb1EqgCNA9F2X7BXEdbIRTNY1gpNyS5Pyaa33FmgRBtdGbIBmvDnt9NrFgtgucZdgiSH9DYXVU5iSfDKxv%2FDvUOcQdIkIcPQJ5fpIZLKJSeDoMDXh4KKsRqlP4Xokw%2FXpi2pB3DSf0WDa59hvr5pVrw%2FQxrxNcuMNsssrGE4%2BiE4ZyO3LJMENvrCcjagiURwbWJa7CzTw3kTGqBErqU9AqdEIaEfOM%2FU4YKdscuYfcJelLJQ%3D%3D",
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

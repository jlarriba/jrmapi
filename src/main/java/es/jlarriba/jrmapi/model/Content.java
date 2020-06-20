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

import java.util.Map;

/**
 * {
 *      "extraMetadata":{},
 *      "fileType":"epub",
 *      "pageCount":0,
 *      "lastOpenedPage":0,
 *      "lineHeight":-1,
 *      "margins":180,
 *      "textScale":1,
 *      "transform":{}
 * }
 * @author juanlarriba
 */
public class Content {
    private Map<String, String> extraMetadata;
    private String fileType;
    private int pageCount;
    private int lastOpenedPage;
    private int lineHeight;
    private int margins;
    private int textScale;
    private Map<String, String> transform;

    /**
     * @return the extraMetadata
     */
    public Map<String, String> getExtraMetadata() {
        return extraMetadata;
    }

    /**
     * @param extraMetadata the extraMetadata to set
     */
    public void setExtraMetadata(Map<String, String> extraMetadata) {
        this.extraMetadata = extraMetadata;
    }

    /**
     * @return the fileType
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * @param fileType the fileType to set
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * @return the lastOpenedPage
     */
    public int getLastOpenedPage() {
        return lastOpenedPage;
    }

    /**
     * @param lastOpenedPage the lastOpenedPage to set
     */
    public void setLastOpenedPage(int lastOpenedPage) {
        this.lastOpenedPage = lastOpenedPage;
    }

    /**
     * @return the lineHeight
     */
    public int getLineHeight() {
        return lineHeight;
    }

    /**
     * @param lineHeight the lineHeight to set
     */
    public void setLineHeight(int lineHeight) {
        this.lineHeight = lineHeight;
    }

    /**
     * @return the margins
     */
    public int getMargins() {
        return margins;
    }

    /**
     * @param margins the margins to set
     */
    public void setMargins(int margins) {
        this.margins = margins;
    }

    /**
     * @return the textScale
     */
    public int getTextScale() {
        return textScale;
    }

    /**
     * @param textScale the textScale to set
     */
    public void setTextScale(int textScale) {
        this.textScale = textScale;
    }

    /**
     * @return the transform
     */
    public Map<String, String> getTransform() {
        return transform;
    }

    /**
     * @param transform the transform to set
     */
    public void setTransform(Map<String, String> transform) {
        this.transform = transform;
    }
}

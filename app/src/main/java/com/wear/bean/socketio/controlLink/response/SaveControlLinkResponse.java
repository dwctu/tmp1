package com.wear.bean.socketio.controlLink.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* loaded from: classes3.dex */
public class SaveControlLinkResponse<T> implements Serializable {

    @SerializedName(XHTMLText.CODE)
    private Integer code;

    @SerializedName("data")
    private InnerData data;

    @SerializedName("message")
    private String message;

    @SerializedName("result")
    private Boolean result;

    public static class InnerData {
        private String longTimeControlLinkId;
        private String longTimeControlLinkUrl;

        public String getLongTimeControlLinkId() {
            return this.longTimeControlLinkId;
        }

        public String getLongTimeControlLinkUrl() {
            return this.longTimeControlLinkUrl;
        }

        public void setLongTimeControlLinkId(String str) {
            this.longTimeControlLinkId = str;
        }

        public void setLongTimeControlLinkUrl(String str) {
            this.longTimeControlLinkUrl = str;
        }
    }

    public Integer getCode() {
        return this.code;
    }

    public InnerData getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public Boolean getResult() {
        return this.result;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public void setData(InnerData innerData) {
        this.data = innerData;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResult(Boolean bool) {
        this.result = bool;
    }
}

package com.wear.bean.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* loaded from: classes3.dex */
public class NoLogicGiftCardResponse implements Serializable {

    @SerializedName(XHTMLText.CODE)
    private Integer code;

    @SerializedName("data")
    private DataDTO dataX;

    @SerializedName("message")
    private String message;

    @SerializedName("result")
    private Boolean result;

    public static class DataDTO implements Serializable {

        @SerializedName("link")
        private String link;

        public String getLink() {
            return this.link;
        }

        public void setLink(String str) {
            this.link = str;
        }
    }

    public Integer getCode() {
        return this.code;
    }

    public DataDTO getDataX() {
        return this.dataX;
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

    public void setDataX(DataDTO dataDTO) {
        this.dataX = dataDTO;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResult(Boolean bool) {
        this.result = bool;
    }
}

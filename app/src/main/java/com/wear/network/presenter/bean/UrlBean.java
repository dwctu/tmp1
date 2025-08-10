package com.wear.network.presenter.bean;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* loaded from: classes3.dex */
public class UrlBean implements Serializable {

    @SerializedName(XHTMLText.CODE)
    private Integer code;

    @SerializedName("data")
    private DataDTO data;

    @SerializedName("message")
    private String message;

    @SerializedName("result")
    private Boolean result;

    public static class DataDTO implements Serializable {

        @SerializedName(ImagesContract.URL)
        private String url;

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public Integer getCode() {
        return this.code;
    }

    public DataDTO getData() {
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

    public void setData(DataDTO dataDTO) {
        this.data = dataDTO;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResult(Boolean bool) {
        this.result = bool;
    }
}

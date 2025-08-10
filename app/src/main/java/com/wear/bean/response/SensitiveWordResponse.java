package com.wear.bean.response;

import com.google.gson.annotations.SerializedName;
import com.wear.bean.SensitiveWord;
import java.io.Serializable;
import java.util.List;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* loaded from: classes3.dex */
public class SensitiveWordResponse implements Serializable {

    @SerializedName(XHTMLText.CODE)
    private Integer code;

    @SerializedName("data")
    private List<SensitiveWord> data;

    @SerializedName("message")
    private String message;

    @SerializedName("result")
    private Boolean result;

    public Integer getCode() {
        return this.code;
    }

    public List<SensitiveWord> getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public Boolean isResult() {
        return this.result;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public void setData(List<SensitiveWord> list) {
        this.data = list;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResult(Boolean bool) {
        this.result = bool;
    }
}

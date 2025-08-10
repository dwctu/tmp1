package com.wear.bean.response;

import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* loaded from: classes3.dex */
public class NewYearPatternResponse implements Serializable {

    @SerializedName(XHTMLText.CODE)
    private Integer code;

    @SerializedName("data")
    private DataDTO data;

    @SerializedName("message")
    private Object message;

    @SerializedName("result")
    private Boolean result;

    public static class DataDTO {

        @SerializedName("patternList")
        private List<PatternListDTO> patternList;

        public static class PatternListDTO {

            @SerializedName("patternId")
            private String patternId;

            @SerializedName(ImagesContract.URL)
            private String url;

            public String getPatternId() {
                return this.patternId;
            }

            public String getUrl() {
                return this.url;
            }

            public void setPatternId(String str) {
                this.patternId = str;
            }

            public void setUrl(String str) {
                this.url = str;
            }
        }

        public List<PatternListDTO> getPatternList() {
            return this.patternList;
        }

        public void setPatternList(List<PatternListDTO> list) {
            this.patternList = list;
        }
    }

    public Integer getCode() {
        return this.code;
    }

    public DataDTO getData() {
        return this.data;
    }

    public Object getMessage() {
        return this.message;
    }

    public Boolean isResult() {
        return this.result;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public void setData(DataDTO dataDTO) {
        this.data = dataDTO;
    }

    public void setMessage(Object obj) {
        this.message = obj;
    }

    public void setResult(Boolean bool) {
        this.result = bool;
    }
}

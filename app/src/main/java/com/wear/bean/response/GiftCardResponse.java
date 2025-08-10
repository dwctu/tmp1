package com.wear.bean.response;

import com.google.gson.annotations.SerializedName;
import com.wear.bean.GiftCard;
import java.io.Serializable;
import java.util.List;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* loaded from: classes3.dex */
public class GiftCardResponse implements Serializable {

    @SerializedName(XHTMLText.CODE)
    private Integer code;

    @SerializedName("data")
    private DataDTO data;

    @SerializedName("message")
    private String message;

    @SerializedName("result")
    private Boolean result;

    public static class DataDTO implements Serializable {

        @SerializedName("acceptedNum")
        private int acceptedNum;

        @SerializedName("list")
        private List<GiftCard> list;

        public int getAcceptedNum() {
            return this.acceptedNum;
        }

        public List<GiftCard> getList() {
            return this.list;
        }

        public void setAcceptedNum(int i) {
            this.acceptedNum = i;
        }

        public void setList(List<GiftCard> list) {
            this.list = list;
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

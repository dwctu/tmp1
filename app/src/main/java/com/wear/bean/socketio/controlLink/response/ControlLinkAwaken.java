package com.wear.bean.socketio.controlLink.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* loaded from: classes3.dex */
public class ControlLinkAwaken implements Serializable {

    @SerializedName(XHTMLText.CODE)
    private Integer code;

    @SerializedName("data")
    private Awaken data;

    @SerializedName("message")
    private String message;

    @SerializedName("result")
    private Boolean result;

    public static class Awaken implements Serializable {
        private String conflictPoints;
        private String errorCode;
        private Boolean isConflict;

        @SerializedName("linkId")
        private String linkId;
        private boolean result;

        public Boolean getConflict() {
            return this.isConflict;
        }

        public String getConflictPoints() {
            return this.conflictPoints;
        }

        public String getErrorCode() {
            return this.errorCode;
        }

        public String getLinkId() {
            return this.linkId;
        }

        public boolean isResult() {
            return this.result;
        }

        public void setConflictPoints(String str) {
            this.conflictPoints = str;
        }

        public void setErrorCode(String str) {
            this.errorCode = str;
        }

        public void setIsConflict(Boolean bool) {
            this.isConflict = bool;
        }

        public void setLinkId(String str) {
            this.linkId = str;
        }

        public void setResult(boolean z) {
            this.result = z;
        }
    }

    public Integer getCode() {
        return this.code;
    }

    public Awaken getData() {
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

    public void setData(Awaken awaken) {
        this.data = awaken;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResult(Boolean bool) {
        this.result = bool;
    }
}

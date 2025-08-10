package com.wear.bean.socketio.controlLink.request;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public class SaveControlLinkRequest implements Serializable {

    @SerializedName("description")
    private String description;

    @SerializedName(TypedValues.TransitionType.S_DURATION)
    private Integer duration;

    @SerializedName("hashTags")
    private List<String> hashTags;
    private String id;

    @SerializedName("repeat")
    private Boolean repeat;

    @SerializedName("shareTophy")
    private boolean shareTophy;

    @SerializedName("toys")
    private List<ToysDTO> toys;

    @SerializedName("allowReqToJoiner")
    private boolean allowReqToJoiner = false;

    @SerializedName("allowReqToCreator")
    private boolean allowReqToCreator = false;

    @SerializedName("openControlPermission")
    private boolean openControlPermission = false;

    public static class ToysDTO implements Serializable {

        @SerializedName("symbol")
        private String symbol;

        @SerializedName("toyId")
        private String toyId;

        @SerializedName("toyName")
        private String toyName;

        @SerializedName("toyType")
        private String toyType;

        @SerializedName("toyVersion")
        private String toyVersion;

        public String getSymbol() {
            return this.symbol;
        }

        public String getToyId() {
            return this.toyId;
        }

        public String getToyName() {
            return this.toyName;
        }

        public String getToyType() {
            return this.toyType;
        }

        public String getToyVersion() {
            return this.toyVersion;
        }

        public void setSymbol(String str) {
            this.symbol = str;
        }

        public void setToyId(String str) {
            this.toyId = str;
        }

        public void setToyName(String str) {
            this.toyName = str;
        }

        public void setToyType(String str) {
            this.toyType = str;
        }

        public void setToyVersion(String str) {
            this.toyVersion = str;
        }
    }

    public String getDescription() {
        return this.description;
    }

    public Integer getDuration() {
        return this.duration;
    }

    public List<String> getHashTags() {
        return this.hashTags;
    }

    public String getId() {
        return this.id;
    }

    public Boolean getRepeat() {
        return this.repeat;
    }

    public boolean getShareTophy() {
        return this.shareTophy;
    }

    public List<ToysDTO> getToys() {
        return this.toys;
    }

    public boolean isAllowReqToCreator() {
        return this.allowReqToCreator;
    }

    public boolean isAllowReqToJoiner() {
        return this.allowReqToJoiner;
    }

    public boolean isOpenControlPermission() {
        return this.openControlPermission;
    }

    public void setAllowReqToCreator(boolean z) {
        this.allowReqToCreator = z;
    }

    public void setAllowReqToJoiner(boolean z) {
        this.allowReqToJoiner = z;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDuration(Integer num) {
        this.duration = num;
    }

    public void setHashTags(List<String> list) {
        this.hashTags = list;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setOpenControlPermission(boolean z) {
        this.openControlPermission = z;
    }

    public void setRepeat(Boolean bool) {
        this.repeat = bool;
    }

    public void setShareTophy(boolean z) {
        this.shareTophy = z;
    }

    public void setToys(List<ToysDTO> list) {
        this.toys = list;
    }
}

package com.wear.bean.socketio.controlLink.response;

import androidx.annotation.NonNull;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* loaded from: classes3.dex */
public class ControlLinkListResponse implements Serializable {

    @SerializedName(XHTMLText.CODE)
    private Integer code;

    @SerializedName("data")
    private DataDTO data;

    @SerializedName("message")
    private String message;

    @SerializedName("result")
    private Boolean result;

    public static class DataDTO implements Serializable {

        @SerializedName("hasNextPage")
        private Boolean hasNextPage;

        @SerializedName("longTimeControlLinkList")
        private List<LongTimeControlLinkListDTO> longTimeControlLinkList;

        @SerializedName("pageNo")
        private int pageNo;

        @SerializedName("pageSize")
        private int pageSize;

        public static class LongTimeControlLinkListDTO implements Serializable, Cloneable {
            public static String ACTIVE = "active";
            public static String ALL = "all";
            public static String EXPIRED = "expired";
            public static String WAITING = "waiting";

            @SerializedName("controlledTimes")
            private int controlledTimes;

            @SerializedName("currentStatus")
            private String currentStatus;

            @SerializedName("description")
            private String description;

            @SerializedName(TypedValues.TransitionType.S_DURATION)
            private int duration;

            @SerializedName("expiredTimestamp")
            private Long expiredTimestamp;

            @SerializedName("hashTags")
            private List<String> hashTags;

            @SerializedName("lastActiveSessionId")
            private String lastActiveSessionId;

            @SerializedName("longTimeControlLinkId")
            private String longTimeControlLinkId;

            @SerializedName("longTimeControlLinkUrl")
            private String longTimeControlLinkUrl;

            @SerializedName("nextOnWaitingTimestamp")
            private long nextOnWaitingTimestamp;

            @SerializedName("repeat")
            private Boolean repeat;

            @SerializedName("rewaiting")
            private boolean rewaiting;

            @SerializedName("shareTophy")
            private boolean shareTophy;

            @SerializedName("toys")
            private List<ToysDTO> toys;
            public boolean isEdit = true;
            public boolean isAddingTime = false;

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

                public void setToyType(String str) {
                    this.toyType = str;
                }

                public void setToyVersion(String str) {
                    this.toyVersion = str;
                }
            }

            @NonNull
            @NotNull
            public Object clone() {
                try {
                    return (LongTimeControlLinkListDTO) super.clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            public Integer getControlledTimes() {
                return Integer.valueOf(this.controlledTimes);
            }

            public String getCurrentStatus() {
                return this.currentStatus;
            }

            public String getDescription() {
                return this.description;
            }

            public int getDuration() {
                return this.duration;
            }

            public Long getExpiredTimestamp() {
                return this.expiredTimestamp;
            }

            public List<String> getHashTags() {
                return this.hashTags;
            }

            public String getLastActiveSessionId() {
                return this.lastActiveSessionId;
            }

            public String getLongTimeControlLinkId() {
                return this.longTimeControlLinkId;
            }

            public String getLongTimeControlLinkUrl() {
                return this.longTimeControlLinkUrl;
            }

            public long getNextOnWaitingTimestamp() {
                return this.nextOnWaitingTimestamp;
            }

            public Boolean getRepeat() {
                return this.repeat;
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

            public boolean isRewaiting() {
                return this.rewaiting;
            }

            public boolean isShareTophy() {
                return this.shareTophy;
            }

            public void setAllowReqToCreator(boolean z) {
                this.allowReqToCreator = z;
            }

            public void setAllowReqToJoiner(boolean z) {
                this.allowReqToJoiner = z;
            }

            public void setControlledTimes(Integer num) {
                this.controlledTimes = num.intValue();
            }

            public void setCurrentStatus(String str) {
                this.currentStatus = str;
            }

            public void setDescription(String str) {
                this.description = str;
            }

            public void setDuration(int i) {
                this.duration = i;
            }

            public void setExpiredTimestamp(Long l) {
                this.expiredTimestamp = l;
            }

            public void setHashTags(List<String> list) {
                this.hashTags = list;
            }

            public void setLastActiveSessionId(String str) {
                this.lastActiveSessionId = str;
            }

            public void setLongTimeControlLinkId(String str) {
                this.longTimeControlLinkId = str;
            }

            public void setLongTimeControlLinkUrl(String str) {
                this.longTimeControlLinkUrl = str;
            }

            public void setNextOnWaitingTimestamp(long j) {
                this.nextOnWaitingTimestamp = j;
            }

            public void setOpenControlPermission(boolean z) {
                this.openControlPermission = z;
            }

            public void setRepeat(Boolean bool) {
                this.repeat = bool;
            }

            public void setRewaiting(boolean z) {
                this.rewaiting = z;
            }

            public void setShareTophy(boolean z) {
                this.shareTophy = z;
            }

            public void setToys(List<ToysDTO> list) {
                this.toys = list;
            }
        }

        public Boolean getHasNextPage() {
            return this.hasNextPage;
        }

        public List<LongTimeControlLinkListDTO> getLongTimeControlLinkList() {
            return this.longTimeControlLinkList;
        }

        public int getPageNo() {
            return this.pageNo;
        }

        public int getPageSize() {
            return this.pageSize;
        }

        public void setHasNextPage(Boolean bool) {
            this.hasNextPage = bool;
        }

        public void setLongTimeControlLinkList(List<LongTimeControlLinkListDTO> list) {
            this.longTimeControlLinkList = list;
        }

        public void setPageNo(int i) {
            this.pageNo = i;
        }

        public void setPageSize(int i) {
            this.pageSize = i;
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

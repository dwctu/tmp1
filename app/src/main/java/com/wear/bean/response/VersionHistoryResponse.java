package com.wear.bean.response;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import java.io.Serializable;
import java.util.List;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* loaded from: classes3.dex */
public class VersionHistoryResponse implements Serializable {

    @SerializedName(XHTMLText.CODE)
    private Integer code;

    @SerializedName("data")
    private DataDTO data;

    @SerializedName("message")
    private String message;

    @SerializedName("result")
    private Boolean result;

    public static class DataDTO implements Serializable {

        @SerializedName("currentPage")
        private Integer currentPage;

        @SerializedName("firstPage")
        private Boolean firstPage;

        @SerializedName("lastPage")
        private Boolean lastPage;

        @SerializedName("maxPagesToDisplay")
        private Integer maxPagesToDisplay;

        @SerializedName("minPagesToDisplay")
        private Integer minPagesToDisplay;

        @SerializedName("pageItems")
        private List<PageItemsDTO> pageItems;

        @SerializedName("pageSize")
        private Integer pageSize;

        @SerializedName("totalItems")
        private Integer totalItems;

        @SerializedName("totalPages")
        private Integer totalPages;

        public static class PageItemsDTO implements Serializable {

            @SerializedName(MLApplicationSetting.BundleKeyConstants.AppInfo.appName)
            private String appName;

            @SerializedName("created")
            private String created;

            @SerializedName("forceUp")
            private Boolean forceUp;

            @SerializedName(TtmlNode.ATTR_ID)
            private String id;

            @SerializedName("needToDisplay")
            private Integer needToDisplay;

            @SerializedName("platform")
            private String platform;

            @SerializedName("platformVerLangList")
            private List<PlatformVerLangListDTO> platformVerLangList;

            @SerializedName("releaseTime")
            private String releaseTime;

            @SerializedName("releaseTimeStamp")
            private Long releaseTimeStamp;

            @SerializedName("status")
            private Integer status;

            @SerializedName("updateInformation")
            private Object updateInformation;

            @SerializedName("updated")
            private String updated;

            @SerializedName("uploadFile")
            private Object uploadFile;

            @SerializedName(ImagesContract.URL)
            private String url;

            @SerializedName("version")
            private String version;

            public static class PlatformVerLangListDTO implements Serializable {

                @SerializedName("created")
                private String created;

                @SerializedName("description")
                private String description;

                @SerializedName(TtmlNode.ATTR_ID)
                private String id;

                @SerializedName("lang")
                private String lang;

                @SerializedName("noticeBody")
                private String noticeBody;

                @SerializedName("noticeTitle")
                private String noticeTitle;

                @SerializedName("platformVerId")
                private String platformVerId;

                @SerializedName("updated")
                private String updated;

                public String getCreated() {
                    return this.created;
                }

                public String getDescription() {
                    return this.description;
                }

                public String getId() {
                    return this.id;
                }

                public String getLang() {
                    return this.lang;
                }

                public String getNoticeBody() {
                    return this.noticeBody;
                }

                public String getNoticeTitle() {
                    return this.noticeTitle;
                }

                public String getPlatformVerId() {
                    return this.platformVerId;
                }

                public String getUpdated() {
                    return this.updated;
                }

                public void setCreated(String str) {
                    this.created = str;
                }

                public void setDescription(String str) {
                    this.description = str;
                }

                public void setId(String str) {
                    this.id = str;
                }

                public void setLang(String str) {
                    this.lang = str;
                }

                public void setNoticeBody(String str) {
                    this.noticeBody = str;
                }

                public void setNoticeTitle(String str) {
                    this.noticeTitle = str;
                }

                public void setPlatformVerId(String str) {
                    this.platformVerId = str;
                }

                public void setUpdated(String str) {
                    this.updated = str;
                }
            }

            public String getAppName() {
                return this.appName;
            }

            public String getCreated() {
                return this.created;
            }

            public Boolean getForceUp() {
                return this.forceUp;
            }

            public String getId() {
                return this.id;
            }

            public Integer getNeedToDisplay() {
                return this.needToDisplay;
            }

            public String getPlatform() {
                return this.platform;
            }

            public List<PlatformVerLangListDTO> getPlatformVerLangList() {
                return this.platformVerLangList;
            }

            public String getReleaseTime() {
                return this.releaseTime;
            }

            public Long getReleaseTimeStamp() {
                return this.releaseTimeStamp;
            }

            public Integer getStatus() {
                return this.status;
            }

            public Object getUpdateInformation() {
                return this.updateInformation;
            }

            public String getUpdated() {
                return this.updated;
            }

            public Object getUploadFile() {
                return this.uploadFile;
            }

            public String getUrl() {
                return this.url;
            }

            public String getVersion() {
                return this.version;
            }

            public void setAppName(String str) {
                this.appName = str;
            }

            public void setCreated(String str) {
                this.created = str;
            }

            public void setForceUp(Boolean bool) {
                this.forceUp = bool;
            }

            public void setId(String str) {
                this.id = str;
            }

            public void setNeedToDisplay(Integer num) {
                this.needToDisplay = num;
            }

            public void setPlatform(String str) {
                this.platform = str;
            }

            public void setPlatformVerLangList(List<PlatformVerLangListDTO> list) {
                this.platformVerLangList = list;
            }

            public void setReleaseTime(String str) {
                this.releaseTime = str;
            }

            public void setReleaseTimeStamp(Long l) {
                this.releaseTimeStamp = l;
            }

            public void setStatus(Integer num) {
                this.status = num;
            }

            public void setUpdateInformation(Object obj) {
                this.updateInformation = obj;
            }

            public void setUpdated(String str) {
                this.updated = str;
            }

            public void setUploadFile(Object obj) {
                this.uploadFile = obj;
            }

            public void setUrl(String str) {
                this.url = str;
            }

            public void setVersion(String str) {
                this.version = str;
            }
        }

        public Integer getCurrentPage() {
            return this.currentPage;
        }

        public Boolean getFirstPage() {
            return this.firstPage;
        }

        public Boolean getLastPage() {
            return this.lastPage;
        }

        public Integer getMaxPagesToDisplay() {
            return this.maxPagesToDisplay;
        }

        public Integer getMinPagesToDisplay() {
            return this.minPagesToDisplay;
        }

        public List<PageItemsDTO> getPageItems() {
            return this.pageItems;
        }

        public Integer getPageSize() {
            return this.pageSize;
        }

        public Integer getTotalItems() {
            return this.totalItems;
        }

        public Integer getTotalPages() {
            return this.totalPages;
        }

        public void setCurrentPage(Integer num) {
            this.currentPage = num;
        }

        public void setFirstPage(Boolean bool) {
            this.firstPage = bool;
        }

        public void setLastPage(Boolean bool) {
            this.lastPage = bool;
        }

        public void setMaxPagesToDisplay(Integer num) {
            this.maxPagesToDisplay = num;
        }

        public void setMinPagesToDisplay(Integer num) {
            this.minPagesToDisplay = num;
        }

        public void setPageItems(List<PageItemsDTO> list) {
            this.pageItems = list;
        }

        public void setPageSize(Integer num) {
            this.pageSize = num;
        }

        public void setTotalItems(Integer num) {
            this.totalItems = num;
        }

        public void setTotalPages(Integer num) {
            this.totalPages = num;
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

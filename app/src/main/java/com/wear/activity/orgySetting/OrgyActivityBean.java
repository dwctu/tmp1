package com.wear.activity.orgySetting;

import java.util.List;

/* loaded from: classes3.dex */
public class OrgyActivityBean {
    private long endTime;
    private int id;
    private String joinId;
    private String joinStatus;
    private String lang;
    private String name;
    private String openType;
    private String platform;
    private Boolean socketOnDateServer;
    private List<StageListBean> stageList;
    private long startTime;
    private String userGroupId;
    private int vibrateToys;

    public static class StageListBean {
        private int appDisplayTimeBtn;
        private String appImgType;
        private int appStartDisplayTime;
        private String appStartDisplayType;
        private int appStartDuration;
        private List<AppStartImgBean> appStartImg;
        private int appStartLimitType;
        private int appStartPage;
        private int bannerBar;
        private BannerTitleBean bannerTitle;
        private String eachDay;
        private int fixedBtnEntrance;
        private List<FixedBtnImgBean> fixedBtnImg;
        private String fixedBtnName;
        private boolean isNow;
        private int orgyPhaseMark;
        private String orgyPhaseUrl;
        private long phaseEndTime;
        private int phaseId;
        private String phaseName;
        private long phaseStartTime;
        private int showCount;
        private int showJoinBtn;
        private int wayJoinType;

        public static class AppStartImgBean {
            private int count;
            private String id;
            private String name;
            private String url;

            public int getCount() {
                return this.count;
            }

            public String getId() {
                return this.id;
            }

            public String getName() {
                return this.name;
            }

            public String getUrl() {
                return this.url;
            }

            public void setCount(int i) {
                this.count = i;
            }

            public void setId(String str) {
                this.id = str;
            }

            public void setName(String str) {
                this.name = str;
            }

            public void setUrl(String str) {
                this.url = str;
            }
        }

        public static class BannerTitleBean {
            private String cancelTitle;
            private String cancelTitle2;
            private long endTimestamp;
            private String joinedTitle;
            private String joinedTitle2;
            private String notJoinedTitle;
            private String notJoinedTitle2;
            private long startTimestamp;
            private String title;
            private String title2;

            public String getCancelTitle() {
                return this.cancelTitle;
            }

            public String getCancelTitle2() {
                return this.cancelTitle2;
            }

            public long getEndTimestamp() {
                return this.endTimestamp;
            }

            public String getJoinedTitle() {
                return this.joinedTitle;
            }

            public String getJoinedTitle2() {
                return this.joinedTitle2;
            }

            public String getNotJoinedTitle() {
                return this.notJoinedTitle;
            }

            public String getNotJoinedTitle2() {
                return this.notJoinedTitle2;
            }

            public long getStartTimestamp() {
                return this.startTimestamp;
            }

            public String getTitle() {
                return this.title;
            }

            public String getTitle2() {
                return this.title2;
            }

            public void setCancelTitle(String str) {
                this.cancelTitle = str;
            }

            public void setCancelTitle2(String str) {
                this.cancelTitle2 = str;
            }

            public void setEndTimestamp(long j) {
                this.endTimestamp = j;
            }

            public void setJoinedTitle(String str) {
                this.joinedTitle = str;
            }

            public void setJoinedTitle2(String str) {
                this.joinedTitle2 = str;
            }

            public void setNotJoinedTitle(String str) {
                this.notJoinedTitle = str;
            }

            public void setNotJoinedTitle2(String str) {
                this.notJoinedTitle2 = str;
            }

            public void setStartTimestamp(long j) {
                this.startTimestamp = j;
            }

            public void setTitle(String str) {
                this.title = str;
            }

            public void setTitle2(String str) {
                this.title2 = str;
            }
        }

        public static class FixedBtnImgBean {
            private String name;
            private String url;

            public String getName() {
                return this.name;
            }

            public String getUrl() {
                return this.url;
            }

            public void setName(String str) {
                this.name = str;
            }

            public void setUrl(String str) {
                this.url = str;
            }
        }

        public int getAppDisplayTimeBtn() {
            return this.appDisplayTimeBtn;
        }

        public String getAppImgType() {
            return this.appImgType;
        }

        public int getAppStartDisplayTime() {
            return this.appStartDisplayTime;
        }

        public String getAppStartDisplayType() {
            return this.appStartDisplayType;
        }

        public int getAppStartDuration() {
            return this.appStartDuration;
        }

        public List<AppStartImgBean> getAppStartImg() {
            return this.appStartImg;
        }

        public int getAppStartLimitType() {
            return this.appStartLimitType;
        }

        public int getAppStartPage() {
            return this.appStartPage;
        }

        public int getBannerBar() {
            return this.bannerBar;
        }

        public BannerTitleBean getBannerTitle() {
            return this.bannerTitle;
        }

        public String getEachDay() {
            return this.eachDay;
        }

        public int getFixedBtnEntrance() {
            return this.fixedBtnEntrance;
        }

        public List<FixedBtnImgBean> getFixedBtnImg() {
            return this.fixedBtnImg;
        }

        public String getFixedBtnName() {
            return this.fixedBtnName;
        }

        public int getOrgyPhaseMark() {
            return this.orgyPhaseMark;
        }

        public String getOrgyPhaseUrl() {
            return this.orgyPhaseUrl;
        }

        public long getPhaseEndTime() {
            return this.phaseEndTime;
        }

        public int getPhaseId() {
            return this.phaseId;
        }

        public String getPhaseName() {
            return this.phaseName;
        }

        public long getPhaseStartTime() {
            return this.phaseStartTime;
        }

        public int getShowCount() {
            return this.showCount;
        }

        public int getShowJoinBtn() {
            return this.showJoinBtn;
        }

        public int getWayJoinType() {
            return this.wayJoinType;
        }

        public boolean isNow() {
            return this.isNow;
        }

        public void setAppDisplayTimeBtn(int i) {
            this.appDisplayTimeBtn = i;
        }

        public void setAppImgType(String str) {
            this.appImgType = str;
        }

        public void setAppStartDisplayTime(int i) {
            this.appStartDisplayTime = i;
        }

        public void setAppStartDisplayType(String str) {
            this.appStartDisplayType = str;
        }

        public void setAppStartDuration(int i) {
            this.appStartDuration = i;
        }

        public void setAppStartImg(List<AppStartImgBean> list) {
            this.appStartImg = list;
        }

        public void setAppStartLimitType(int i) {
            this.appStartLimitType = i;
        }

        public void setAppStartPage(int i) {
            this.appStartPage = i;
        }

        public void setBannerBar(int i) {
            this.bannerBar = i;
        }

        public void setBannerTitle(BannerTitleBean bannerTitleBean) {
            this.bannerTitle = bannerTitleBean;
        }

        public void setEachDay(String str) {
            this.eachDay = str;
        }

        public void setFixedBtnEntrance(int i) {
            this.fixedBtnEntrance = i;
        }

        public void setFixedBtnImg(List<FixedBtnImgBean> list) {
            this.fixedBtnImg = list;
        }

        public void setFixedBtnName(String str) {
            this.fixedBtnName = str;
        }

        public void setNow(boolean z) {
            this.isNow = z;
        }

        public void setOrgyPhaseMark(int i) {
            this.orgyPhaseMark = i;
        }

        public void setOrgyPhaseUrl(String str) {
            this.orgyPhaseUrl = str;
        }

        public void setPhaseEndTime(long j) {
            this.phaseEndTime = j;
        }

        public void setPhaseId(int i) {
            this.phaseId = i;
        }

        public void setPhaseName(String str) {
            this.phaseName = str;
        }

        public void setPhaseStartTime(long j) {
            this.phaseStartTime = j;
        }

        public void setShowCount(int i) {
            this.showCount = i;
        }

        public void setShowJoinBtn(int i) {
            this.showJoinBtn = i;
        }

        public void setWayJoinType(int i) {
            this.wayJoinType = i;
        }
    }

    public long getEndTime() {
        return this.endTime;
    }

    public int getId() {
        return this.id;
    }

    public String getJoinId() {
        return this.joinId;
    }

    public String getJoinStatus() {
        return this.joinStatus;
    }

    public String getLang() {
        return this.lang;
    }

    public String getName() {
        return this.name;
    }

    public String getOpenType() {
        return this.openType;
    }

    public String getPlatform() {
        return this.platform;
    }

    public Boolean getSocketOnDateServer() {
        return this.socketOnDateServer;
    }

    public List<StageListBean> getStageList() {
        return this.stageList;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public String getUserGroupId() {
        return this.userGroupId;
    }

    public int getVibrateToys() {
        return this.vibrateToys;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setJoinId(String str) {
        this.joinId = str;
    }

    public void setJoinStatus(String str) {
        this.joinStatus = str;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOpenType(String str) {
        this.openType = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setSocketOnDateServer(Boolean bool) {
        this.socketOnDateServer = bool;
    }

    public void setStageList(List<StageListBean> list) {
        this.stageList = list;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public void setUserGroupId(String str) {
        this.userGroupId = str;
    }

    public void setVibrateToys(int i) {
        this.vibrateToys = i;
    }
}

package com.wear.bean;

import java.util.List;

/* loaded from: classes3.dex */
public class TipSetting {
    private String code;
    private DataBean data;
    private String message;
    private boolean result;

    public static class DataBean {
        private List<LevelSettingsBean> levelSettings;
        private boolean openAppFeedback;
        private String platform;

        public static class LevelSettingsBean {
            private String levelP;
            private String levelR;
            private String levelV;
            private String time;
            private String token1;
            private String token2;
            private String toyid;
            private String toytype;

            public String getLevelP() {
                return this.levelP;
            }

            public String getLevelR() {
                return this.levelR;
            }

            public String getLevelV() {
                return this.levelV;
            }

            public String getTime() {
                return this.time;
            }

            public String getToken1() {
                return this.token1;
            }

            public String getToken2() {
                return this.token2;
            }

            public String getToyid() {
                return this.toyid;
            }

            public String getToytype() {
                return this.toytype;
            }

            public void setLevelP(String str) {
                this.levelP = str;
            }

            public void setLevelR(String str) {
                this.levelR = str;
            }

            public void setLevelV(String str) {
                this.levelV = str;
            }

            public void setTime(String str) {
                this.time = str;
            }

            public void setToken1(String str) {
                this.token1 = str;
            }

            public void setToken2(String str) {
                this.token2 = str;
            }

            public void setToyid(String str) {
                this.toyid = str;
            }

            public void setToytype(String str) {
                this.toytype = str;
            }
        }

        public List<LevelSettingsBean> getLevelSettings() {
            return this.levelSettings;
        }

        public String getPlatform() {
            return this.platform;
        }

        public boolean isOpenAppFeedback() {
            return this.openAppFeedback;
        }

        public void setLevelSettings(List<LevelSettingsBean> list) {
            this.levelSettings = list;
        }

        public void setOpenAppFeedback(boolean z) {
            this.openAppFeedback = z;
        }

        public void setPlatform(String str) {
            this.platform = str;
        }
    }

    public String getCode() {
        return this.code;
    }

    public DataBean getData() {
        return this.data;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isResult() {
        return this.result;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setResult(boolean z) {
        this.result = z;
    }
}

package com.wear.bean;

/* loaded from: classes3.dex */
public class AVersionBean {
    private VersionBean version;

    public static class VersionBean {
        private String apkUrl;
        private String changes;
        private String currentVersion;
        private boolean force;
        private boolean result;
        private String url;

        public String getApkUrl() {
            return this.apkUrl;
        }

        public String getChanges() {
            return this.changes;
        }

        public String getCurrentVersion() {
            return this.currentVersion;
        }

        public String getUrl() {
            return this.url;
        }

        public boolean isForce() {
            return this.force;
        }

        public boolean isResult() {
            return this.result;
        }

        public void setApkUrl(String str) {
            this.apkUrl = str;
        }

        public void setChanges(String str) {
            this.changes = str;
        }

        public void setCurrentVersion(String str) {
            this.currentVersion = str;
        }

        public void setForce(boolean z) {
            this.force = z;
        }

        public void setResult(boolean z) {
            this.result = z;
        }

        public void setUrl(String str) {
            this.url = str;
        }
    }

    public VersionBean getVersion() {
        return this.version;
    }

    public void setVersion(VersionBean versionBean) {
        this.version = versionBean;
    }
}

package com.wear.bean;

import java.util.List;

/* loaded from: classes3.dex */
public class TipShowRank {
    private String modelId;
    private String platform;
    private String showId;
    private List<UserRankListBean> userRankList;

    public static class UserRankListBean {
        private int rank;
        private int totalTip;
        private String userName;

        public int getRank() {
            return this.rank;
        }

        public int getTotalTip() {
            return this.totalTip;
        }

        public String getUserName() {
            return this.userName;
        }

        public void setRank(int i) {
            this.rank = i;
        }

        public void setTotalTip(int i) {
            this.totalTip = i;
        }

        public void setUserName(String str) {
            this.userName = str;
        }
    }

    public String getModelId() {
        return this.modelId;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getShowId() {
        return this.showId;
    }

    public List<UserRankListBean> getUserRankList() {
        return this.userRankList;
    }

    public void setModelId(String str) {
        this.modelId = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setShowId(String str) {
        this.showId = str;
    }

    public void setUserRankList(List<UserRankListBean> list) {
        this.userRankList = list;
    }
}

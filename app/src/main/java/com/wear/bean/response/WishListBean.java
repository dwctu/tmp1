package com.wear.bean.response;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public class WishListBean implements Serializable {
    private int code;
    private DataBean data;
    private String message;
    private boolean result;

    public static class DataBean implements Serializable {
        private WishFanFundBean wishFanFund;
        private String wishListAvatar;
        private String wishListDesc;
        private String wishListName;
        private String wishListUrl;
        private List<WishToyListBean> wishToyList;

        public static class WishFanFundBean implements Serializable {
            private String desc;
            private String funded;
            private int peopleContributedNum;
            private String totalCost;
            private String toyName;

            public String getDesc() {
                return this.desc;
            }

            public String getFunded() {
                return this.funded;
            }

            public int getPeopleContributedNum() {
                return this.peopleContributedNum;
            }

            public String getTotalCost() {
                return this.totalCost;
            }

            public String getToyName() {
                return this.toyName;
            }

            public void setDesc(String str) {
                this.desc = str;
            }

            public void setFunded(String str) {
                this.funded = str;
            }

            public void setPeopleContributedNum(int i) {
                this.peopleContributedNum = i;
            }

            public void setTotalCost(String str) {
                this.totalCost = str;
            }

            public void setToyName(String str) {
                this.toyName = str;
            }
        }

        public static class WishToyListBean implements Serializable {
            private String toyName;
            private String toyNote;

            public String getToyName() {
                return this.toyName;
            }

            public String getToyNote() {
                return this.toyNote;
            }

            public void setToyName(String str) {
                this.toyName = str;
            }

            public void setToyNote(String str) {
                this.toyNote = str;
            }
        }

        public WishFanFundBean getWishFanFund() {
            return this.wishFanFund;
        }

        public String getWishListAvatar() {
            return this.wishListAvatar;
        }

        public String getWishListDesc() {
            return this.wishListDesc;
        }

        public String getWishListName() {
            return this.wishListName;
        }

        public String getWishListUrl() {
            return this.wishListUrl;
        }

        public List<WishToyListBean> getWishToyList() {
            return this.wishToyList;
        }

        public void setWishFanFund(WishFanFundBean wishFanFundBean) {
            this.wishFanFund = wishFanFundBean;
        }

        public void setWishListAvatar(String str) {
            this.wishListAvatar = str;
        }

        public void setWishListDesc(String str) {
            this.wishListDesc = str;
        }

        public void setWishListName(String str) {
            this.wishListName = str;
        }

        public void setWishListUrl(String str) {
            this.wishListUrl = str;
        }

        public void setWishToyList(List<WishToyListBean> list) {
            this.wishToyList = list;
        }
    }

    public int getCode() {
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

    public void setCode(int i) {
        this.code = i;
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

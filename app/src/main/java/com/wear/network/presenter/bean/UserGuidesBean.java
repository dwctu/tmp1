package com.wear.network.presenter.bean;

import java.util.List;

/* loaded from: classes3.dex */
public class UserGuidesBean {
    private int code;
    private DataBean data;
    private String message;
    private boolean result;

    public static class DataBean {
        private List<RemoteGuideBean> remoteGuide;

        public static class RemoteGuideBean {
            private boolean isSelect;
            private List<Menu1Bean> menu1;
            private String menu1Key;

            public static class Menu1Bean {
                private List<Menu2Bean> menu2;
                private String menu2Key;

                public static class Menu2Bean {
                    private String cLink;
                    private String title;

                    public String getCLink() {
                        return this.cLink;
                    }

                    public String getTitle() {
                        return this.title;
                    }

                    public void setCLink(String str) {
                        this.cLink = str;
                    }

                    public void setTitle(String str) {
                        this.title = str;
                    }
                }

                public List<Menu2Bean> getMenu2() {
                    return this.menu2;
                }

                public String getMenu2Key() {
                    return this.menu2Key;
                }

                public void setMenu2(List<Menu2Bean> list) {
                    this.menu2 = list;
                }

                public void setMenu2Key(String str) {
                    this.menu2Key = str;
                }
            }

            public List<Menu1Bean> getMenu1() {
                return this.menu1;
            }

            public String getMenu1Key() {
                return this.menu1Key;
            }

            public boolean isSelect() {
                return this.isSelect;
            }

            public void setMenu1(List<Menu1Bean> list) {
                this.menu1 = list;
            }

            public void setMenu1Key(String str) {
                this.menu1Key = str;
            }

            public void setSelect(boolean z) {
                this.isSelect = z;
            }
        }

        public List<RemoteGuideBean> getRemoteGuide() {
            return this.remoteGuide;
        }

        public void setRemoteGuide(List<RemoteGuideBean> list) {
            this.remoteGuide = list;
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

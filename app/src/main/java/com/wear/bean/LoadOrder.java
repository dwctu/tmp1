package com.wear.bean;

import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class LoadOrder {
    private OrderConfigBean orderConfig;

    public static class OrderBean {
        private String cmd;
        private String path;
        private List<Integer> range;
        private String toy;

        public String getCmd() {
            return this.cmd;
        }

        public String getPath() {
            return this.path;
        }

        public List<Integer> getRange() {
            return this.range;
        }

        public String getToy() {
            return this.toy;
        }

        public void setCmd(String str) {
            this.cmd = str;
        }

        public void setPath(String str) {
            this.path = str;
        }

        public void setRange(List<Integer> list) {
            this.range = list;
        }

        public void setToy(String str) {
            this.toy = str;
        }
    }

    public static class OrderConfigBean {
        private Map<String, String> error;
        private Map<String, OrderBean> order;

        public Map<String, String> getError() {
            return this.error;
        }

        public Map<String, OrderBean> getOrder() {
            return this.order;
        }

        public void setError(Map<String, String> map) {
            this.error = map;
        }

        public void setOrder(Map<String, OrderBean> map) {
            this.order = map;
        }
    }

    public OrderConfigBean getOrderConfig() {
        return this.orderConfig;
    }

    public void setOrderConfig(OrderConfigBean orderConfigBean) {
        this.orderConfig = orderConfigBean;
    }
}

package com.wear.bean;

import com.google.gson.Gson;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class ToyMacOrderPacket {
    private List<ToyMultiMacOrder> orders;

    public static class ToyMultiMacOrder {
        private List<ToySingleMacOrder> order;

        public List<ToySingleMacOrder> getOrder() {
            return this.order;
        }

        public void setOrder(List<ToySingleMacOrder> list) {
            this.order = list;
        }
    }

    public static class ToySingleMacOrder {
        private List<Map<String, Object>> funcLevels;
        private String toymac;

        public List<Map<String, Object>> getFuncLevels() {
            return this.funcLevels;
        }

        public String getToymac() {
            return this.toymac;
        }

        public void setFuncLevels(List<Map<String, Object>> list) {
            this.funcLevels = list;
        }

        public void setToymac(String str) {
            this.toymac = str;
        }
    }

    public List<ToyMultiMacOrder> getOrders() {
        return this.orders;
    }

    public void setOrders(List<ToyMultiMacOrder> list) {
        this.orders = list;
    }

    public String toString() {
        return new Gson().toJson(this.orders);
    }
}

package com.wear.bean;

import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class ToyFuncOrderPacket {
    private List<ToySingleFuncOrder> orders;

    public static class ToySingleFuncOrder {
        private List<Map<String, Object>> funcLevels;

        public List<Map<String, Object>> getFuncLevels() {
            return this.funcLevels;
        }

        public void setFuncLevels(List<Map<String, Object>> list) {
            this.funcLevels = list;
        }
    }

    public List<ToySingleFuncOrder> getOrders() {
        return this.orders;
    }

    public void setOrders(List<ToySingleFuncOrder> list) {
        this.orders = list;
    }
}

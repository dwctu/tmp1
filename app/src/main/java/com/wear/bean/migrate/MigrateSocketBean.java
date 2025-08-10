package com.wear.bean.migrate;

import com.alibaba.fastjson.JSONObject;
import com.broadcom.bt.util.io.IOUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.wear.util.WearUtils;
import dc.nd3;

/* loaded from: classes3.dex */
public class MigrateSocketBean<T> {
    public static final String MIG_AUTH_TC = "mig_auth_tc";
    public static final String MIG_AUTH_TS = "mig_auth_ts";
    public static final String MIG_HEART_BEAT_TC = "mig_heart_beat_tc";
    public static final String MIG_HEART_BEAT_TS = "mig_heart_beat_ts";
    public static final String MIG_INTERRUPTED_TC = "mig_interrupted_tc";
    public static final String MIG_INTERRUPTED_TS = "mig_interrupted_ts";
    public static final String MIG_READY_TC = "mig_ready_tc";
    public static final String MIG_READY_TS = "mig_ready_ts";
    public static final String MIG_TRANSFER_COMPLETE_TC = "mig_transfer_complete_tc";
    public static final String MIG_TRANSFER_COMPLETE_TS = "mig_transfer_complete_ts";
    public static final String MIG_TRANSFER_MSGS_TC = "mig_transfer_msgs_tc";
    public static final String MIG_TRANSFER_MSGS_TS = "mig_transfer_msgs_ts";
    public static final String MIG_UNZIP_TS = "mig_unzip_ts";
    private T data;
    private String event;

    public static class Builder {
        public static String buildAuthTc(MigrateAuthTcBean migrateAuthTcBean) {
            Gson gson = WearUtils.A;
            return gson.toJson(new MigrateSocketBean(MigrateSocketBean.MIG_AUTH_TC, encrypt(gson.toJson(migrateAuthTcBean))));
        }

        public static String buildAuthTs(MigrateAuthTsBean migrateAuthTsBean) {
            Gson gson = WearUtils.A;
            return gson.toJson(new MigrateSocketBean(MigrateSocketBean.MIG_AUTH_TS, encrypt(gson.toJson(migrateAuthTsBean))));
        }

        public static String buildHeartBeatTc() {
            return WearUtils.A.toJson(new MigrateSocketBean(MigrateSocketBean.MIG_HEART_BEAT_TC, ""));
        }

        public static String buildHeartBeatTs() {
            return WearUtils.A.toJson(new MigrateSocketBean(MigrateSocketBean.MIG_HEART_BEAT_TS, ""));
        }

        public static String buildInterruptedTc() {
            return WearUtils.A.toJson(new MigrateSocketBean(MigrateSocketBean.MIG_HEART_BEAT_TC, ""));
        }

        public static String buildInterruptedTs() {
            return WearUtils.A.toJson(new MigrateSocketBean(MigrateSocketBean.MIG_HEART_BEAT_TS, ""));
        }

        public static String buildMsgsTc(int i, String str, byte[] bArr, int i2) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(FirebaseAnalytics.Param.INDEX, (Object) Integer.valueOf(i));
            jSONObject2.put("messages", (Object) str);
            jSONObject2.put("attachments", (Object) bArr);
            jSONObject2.put("flag", (Object) Integer.valueOf(i2));
            jSONObject.put("event", (Object) MigrateSocketBean.MIG_TRANSFER_MSGS_TC);
            jSONObject.put("data", (Object) jSONObject2);
            return jSONObject.toJSONString();
        }

        public static String buildMsgsTs(MigrateMsgsTsBean migrateMsgsTsBean) {
            Gson gson = WearUtils.A;
            return gson.toJson(new MigrateSocketBean(MigrateSocketBean.MIG_TRANSFER_MSGS_TS, encrypt(gson.toJson(migrateMsgsTsBean))));
        }

        public static String buildReadyTc(MigrateReadyTcBean migrateReadyTcBean) {
            Gson gson = WearUtils.A;
            return gson.toJson(new MigrateSocketBean(MigrateSocketBean.MIG_READY_TC, encrypt(gson.toJson(migrateReadyTcBean))));
        }

        public static String buildReadyTs(MigrateReadyTsBean migrateReadyTsBean) {
            Gson gson = WearUtils.A;
            return gson.toJson(new MigrateSocketBean(MigrateSocketBean.MIG_READY_TS, encrypt(gson.toJson(migrateReadyTsBean))));
        }

        public static String buildTransferCompleteTc() {
            return WearUtils.A.toJson(new MigrateSocketBean(MigrateSocketBean.MIG_TRANSFER_COMPLETE_TC, ""));
        }

        public static String buildTransferCompleteTs() {
            return WearUtils.A.toJson(new MigrateSocketBean(MigrateSocketBean.MIG_TRANSFER_COMPLETE_TS, ""));
        }

        public static String buildUnzipTs() {
            return WearUtils.A.toJson(new MigrateSocketBean(MigrateSocketBean.MIG_UNZIP_TS, ""));
        }

        private static String encrypt(String str) {
            return nd3.t(str).replaceAll(IOUtils.LINE_SEPARATOR_UNIX, "").replaceAll("\r", "");
        }
    }

    public MigrateSocketBean(String str, T t) {
        this.event = str;
        this.data = t;
    }

    public T getData() {
        return this.data;
    }

    public String getEvent() {
        return this.event;
    }

    public String getdecryptDate() {
        return nd3.h(String.valueOf(this.data));
    }
}

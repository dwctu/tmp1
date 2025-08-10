package org.apache.cordova.errcode;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: ErrorCode.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001: \t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'(B\u0017\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u0082\u0001 )*+,-./0123456789:;<=>?@ABCDEFGH¨\u0006I"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode;", "", XHTMLText.CODE, "", "message", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getMessage", "Error10000", "Error10001", "Error10002", "Error20100", "Error20101", "Error20200", "Error20201", "Error20202", "Error20203", "Error21100", "Error21101", "Error21102", "Error21103", "Error21106", "Error21107", "Error21200", "Error21201", "Error21202", "Error21203", "Error21204", "Error21205", "Error21206", "Error21207", "Error21208", "Error21209", "Error21210", "Error30000", "Error30001", "Error30002", "Error30003", "Error30004", "Error30005", "Lorg/apache/cordova/errcode/ErrorCode$Error10000;", "Lorg/apache/cordova/errcode/ErrorCode$Error10001;", "Lorg/apache/cordova/errcode/ErrorCode$Error10002;", "Lorg/apache/cordova/errcode/ErrorCode$Error20100;", "Lorg/apache/cordova/errcode/ErrorCode$Error20101;", "Lorg/apache/cordova/errcode/ErrorCode$Error20200;", "Lorg/apache/cordova/errcode/ErrorCode$Error20201;", "Lorg/apache/cordova/errcode/ErrorCode$Error20202;", "Lorg/apache/cordova/errcode/ErrorCode$Error20203;", "Lorg/apache/cordova/errcode/ErrorCode$Error21100;", "Lorg/apache/cordova/errcode/ErrorCode$Error21101;", "Lorg/apache/cordova/errcode/ErrorCode$Error21102;", "Lorg/apache/cordova/errcode/ErrorCode$Error21103;", "Lorg/apache/cordova/errcode/ErrorCode$Error21106;", "Lorg/apache/cordova/errcode/ErrorCode$Error21107;", "Lorg/apache/cordova/errcode/ErrorCode$Error21200;", "Lorg/apache/cordova/errcode/ErrorCode$Error21201;", "Lorg/apache/cordova/errcode/ErrorCode$Error21202;", "Lorg/apache/cordova/errcode/ErrorCode$Error21203;", "Lorg/apache/cordova/errcode/ErrorCode$Error21204;", "Lorg/apache/cordova/errcode/ErrorCode$Error21205;", "Lorg/apache/cordova/errcode/ErrorCode$Error21206;", "Lorg/apache/cordova/errcode/ErrorCode$Error21207;", "Lorg/apache/cordova/errcode/ErrorCode$Error21208;", "Lorg/apache/cordova/errcode/ErrorCode$Error21209;", "Lorg/apache/cordova/errcode/ErrorCode$Error21210;", "Lorg/apache/cordova/errcode/ErrorCode$Error30000;", "Lorg/apache/cordova/errcode/ErrorCode$Error30001;", "Lorg/apache/cordova/errcode/ErrorCode$Error30002;", "Lorg/apache/cordova/errcode/ErrorCode$Error30003;", "Lorg/apache/cordova/errcode/ErrorCode$Error30004;", "Lorg/apache/cordova/errcode/ErrorCode$Error30005;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ErrorCode {

    @NotNull
    private final String code;

    @NotNull
    private final String message;

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error10000;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error10000 extends ErrorCode {

        @NotNull
        public static final Error10000 INSTANCE = new Error10000();

        private Error10000() {
            super("10000", "Unknown error", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error10001;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error10001 extends ErrorCode {

        @NotNull
        public static final Error10001 INSTANCE = new Error10001();

        private Error10001() {
            super("10001", "Invalid parameter", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error10002;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error10002 extends ErrorCode {

        @NotNull
        public static final Error10002 INSTANCE = new Error10002();

        private Error10002() {
            super("10002", "Request failed", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error20100;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error20100 extends ErrorCode {

        @NotNull
        public static final Error20100 INSTANCE = new Error20100();

        private Error20100() {
            super("20100", "Failed to parse data", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error20101;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error20101 extends ErrorCode {

        @NotNull
        public static final Error20101 INSTANCE = new Error20101();

        private Error20101() {
            super("20101", "Command handling error", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error20200;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error20200 extends ErrorCode {

        @NotNull
        public static final Error20200 INSTANCE = new Error20200();

        private Error20200() {
            super("20200", "Audio session setup error", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error20201;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error20201 extends ErrorCode {

        @NotNull
        public static final Error20201 INSTANCE = new Error20201();

        private Error20201() {
            super("20201", "Audio recorder permission not granted", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error20202;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error20202 extends ErrorCode {

        @NotNull
        public static final Error20202 INSTANCE = new Error20202();

        private Error20202() {
            super("20202", "Audio recorder self not exist", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error20203;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error20203 extends ErrorCode {

        @NotNull
        public static final Error20203 INSTANCE = new Error20203();

        private Error20203() {
            super("20203", "Audio recorder setup error", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error21100;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error21100 extends ErrorCode {

        @NotNull
        public static final Error21100 INSTANCE = new Error21100();

        private Error21100() {
            super("21100", "Device motion unavailable", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error21101;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error21101 extends ErrorCode {

        @NotNull
        public static final Error21101 INSTANCE = new Error21101();

        private Error21101() {
            super("21101", "Device motion error", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error21102;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error21102 extends ErrorCode {

        @NotNull
        public static final Error21102 INSTANCE = new Error21102();

        private Error21102() {
            super("21102", "Device motion not exist", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error21103;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error21103 extends ErrorCode {

        @NotNull
        public static final Error21103 INSTANCE = new Error21103();

        private Error21103() {
            super("21103", "Device motion self not exist", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error21106;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error21106 extends ErrorCode {

        @NotNull
        public static final Error21106 INSTANCE = new Error21106();

        private Error21106() {
            super("21106", "Device sensor error", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error21107;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error21107 extends ErrorCode {

        @NotNull
        public static final Error21107 INSTANCE = new Error21107();

        private Error21107() {
            super("21107", "Accelerometer sensor error", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error21200;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error21200 extends ErrorCode {

        @NotNull
        public static final Error21200 INSTANCE = new Error21200();

        private Error21200() {
            super("21200", "User login authorization cancelled", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error21201;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error21201 extends ErrorCode {

        @NotNull
        public static final Error21201 INSTANCE = new Error21201();

        private Error21201() {
            super("21201", "User not logged into Remote", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error21202;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error21202 extends ErrorCode {

        @NotNull
        public static final Error21202 INSTANCE = new Error21202();

        private Error21202() {
            super("21202", "Failed to retrieve user info", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error21203;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error21203 extends ErrorCode {

        @NotNull
        public static final Error21203 INSTANCE = new Error21203();

        private Error21203() {
            super("21203", "User account list empty", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error21204;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error21204 extends ErrorCode {

        @NotNull
        public static final Error21204 INSTANCE = new Error21204();

        private Error21204() {
            super("21204", "Failed to retrieve user auth code", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error21205;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error21205 extends ErrorCode {

        @NotNull
        public static final Error21205 INSTANCE = new Error21205();

        private Error21205() {
            super("21205", "Privacy policy not provided. Request not allowed", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error21206;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error21206 extends ErrorCode {

        @NotNull
        public static final Error21206 INSTANCE = new Error21206();

        private Error21206() {
            super("21206", "User denied the privacy policy. Request not allowed", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error21207;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error21207 extends ErrorCode {

        @NotNull
        public static final Error21207 INSTANCE = new Error21207();

        private Error21207() {
            super("21207", "Lovense Remote does not have permission to save images to the user's album", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error21208;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error21208 extends ErrorCode {

        @NotNull
        public static final Error21208 INSTANCE = new Error21208();

        private Error21208() {
            super("21208", "The user denied your app permission to save images to their album", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error21209;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error21209 extends ErrorCode {

        @NotNull
        public static final Error21209 INSTANCE = new Error21209();

        private Error21209() {
            super("21209", "The app has not yet requested permission to save images to the user's album", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error21210;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error21210 extends ErrorCode {

        @NotNull
        public static final Error21210 INSTANCE = new Error21210();

        private Error21210() {
            super("21210", "The photo save failed", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error30000;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error30000 extends ErrorCode {

        @NotNull
        public static final Error30000 INSTANCE = new Error30000();

        private Error30000() {
            super("30000", "Invalid command", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error30001;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error30001 extends ErrorCode {

        @NotNull
        public static final Error30001 INSTANCE = new Error30001();

        private Error30001() {
            super("30001", "Toy not found", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error30002;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error30002 extends ErrorCode {

        @NotNull
        public static final Error30002 INSTANCE = new Error30002();

        private Error30002() {
            super("30002", "Toy not connected", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error30003;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error30003 extends ErrorCode {

        @NotNull
        public static final Error30003 INSTANCE = new Error30003();

        private Error30003() {
            super("30003", "Toy does not support this command", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error30004;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error30004 extends ErrorCode {

        @NotNull
        public static final Error30004 INSTANCE = new Error30004();

        private Error30004() {
            super("30004", "HTTP server not started or disabled", null);
        }
    }

    /* compiled from: ErrorCode.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lorg/apache/cordova/errcode/ErrorCode$Error30005;", "Lorg/apache/cordova/errcode/ErrorCode;", "()V", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Error30005 extends ErrorCode {

        @NotNull
        public static final Error30005 INSTANCE = new Error30005();

        private Error30005() {
            super("30005", "No connected toy supports feedback mode", null);
        }
    }

    private ErrorCode(String str, String str2) {
        this.code = str;
        this.message = str2;
    }

    public /* synthetic */ ErrorCode(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }
}

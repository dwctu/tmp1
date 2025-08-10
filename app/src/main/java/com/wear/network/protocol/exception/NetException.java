package com.wear.network.protocol.exception;

/* loaded from: classes3.dex */
public class NetException extends RuntimeException {
    public static String A013 = "A013";
    public static String API_REQUEST_FAILED = "A007";
    public static String API_REQUEST_TIME_OUT = "A006";
    public static String APP_DATA_ERROR = "A002";
    public static String CONTROL_LINK_CREATE_SOCKET_ERROR = "A014";
    public static String LOCAL_UN_DEFINE_ERROR = "A000";
    public static String NET_CONNECT_ERROR = "A001";
    public static String NOT_PERMISSION = "A003";
    public static String NULL_PORINT_ERROR = "A012";
    public static String SERVER_REQUEST_FAILED = "A008";
    public static String SERVER_UN_DEFINE_ERROR = "S000";
    public static String SERVICE_DATA_ERROR = "A005";
    public static String SOCKET_CONNECT_ERROR = "A010";
    public static String SOCKET_TIME_OUT = "A009";
    public static String SPOTIFY_DATA_ERROR = "B002";
    public static String TOKEN_REFLASH_ERROR = "A011";
    public static String UPLOAD_FILE_TOO_LARGE = "B4000";
    public static String USER_CANCEL = "A004";
    public static String VIDEO_TOO_LARGE = "70095";
    public static String XMPP_CONNECT_ERROR_EXCEPTION = "B004";
    public static String XMPP_LOGIN_ERROR = "B001";
    public static String XMPP_LOGIN_ERROR_EXCEPTION = "B005";
    public static String XMPP_LOGIN_ERROR_TIME = "B003";
    public static String XMPP_LOGIN_OTHER_ERROR_EXCEPTION = "B007";
    public String code;
    public String message;

    public NetException(String str, String str2) {
        super(str2);
        this.code = str;
        this.message = str2;
    }

    public String getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public void setCode(String str) {
        this.code = str;
    }
}

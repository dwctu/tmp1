package com.google.firebase.database;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* loaded from: classes2.dex */
public class DatabaseError {
    public static final int DATA_STALE = -1;
    public static final int DISCONNECTED = -4;
    public static final int EXPIRED_TOKEN = -6;
    public static final int INVALID_TOKEN = -7;
    public static final int MAX_RETRIES = -8;
    public static final int NETWORK_ERROR = -24;
    public static final int OPERATION_FAILED = -2;
    public static final int OVERRIDDEN_BY_SET = -9;
    public static final int PERMISSION_DENIED = -3;
    public static final int UNAVAILABLE = -10;
    public static final int UNKNOWN_ERROR = -999;
    public static final int USER_CODE_EXCEPTION = -11;
    public static final int WRITE_CANCELED = -25;
    private static final Map<String, Integer> errorCodes;
    private static final Map<Integer, String> errorReasons;
    private final int code;
    private final String details;
    private final String message;

    static {
        HashMap map = new HashMap();
        errorReasons = map;
        map.put(-1, "The transaction needs to be run again with current data");
        map.put(-2, "The server indicated that this operation failed");
        map.put(-3, "This client does not have permission to perform this operation");
        map.put(-4, "The operation had to be aborted due to a network disconnect");
        map.put(-6, "The supplied auth token has expired");
        map.put(-7, "The supplied auth token was invalid");
        map.put(-8, "The transaction had too many retries");
        map.put(-9, "The transaction was overridden by a subsequent set");
        map.put(-10, "The service is unavailable");
        map.put(-11, "User code called from the Firebase Database runloop threw an exception:\n");
        map.put(-24, "The operation could not be performed due to a network error");
        map.put(-25, "The write was canceled by the user.");
        map.put(Integer.valueOf(UNKNOWN_ERROR), "An unknown error occurred");
        HashMap map2 = new HashMap();
        errorCodes = map2;
        map2.put("datastale", -1);
        map2.put(SaslStreamElements.SASLFailure.ELEMENT, -2);
        map2.put("permission_denied", -3);
        map2.put("disconnected", -4);
        map2.put("expired_token", -6);
        map2.put("invalid_token", -7);
        map2.put("maxretries", -8);
        map2.put("overriddenbyset", -9);
        map2.put("unavailable", -10);
        map2.put("network_error", -24);
        map2.put("write_canceled", -25);
    }

    private DatabaseError(int i, String str) {
        this(i, str, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static DatabaseError fromCode(int i) {
        Map<Integer, String> map = errorReasons;
        if (map.containsKey(Integer.valueOf(i))) {
            return new DatabaseError(i, map.get(Integer.valueOf(i)), null);
        }
        throw new IllegalArgumentException("Invalid Firebase Database error code: " + i);
    }

    @NonNull
    public static DatabaseError fromException(@NonNull Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return new DatabaseError(-11, errorReasons.get(-11) + stringWriter.toString());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static DatabaseError fromStatus(String str) {
        return fromStatus(str, null);
    }

    public int getCode() {
        return this.code;
    }

    @NonNull
    public String getDetails() {
        return this.details;
    }

    @NonNull
    public String getMessage() {
        return this.message;
    }

    @NonNull
    public DatabaseException toException() {
        return new DatabaseException("Firebase Database error: " + this.message);
    }

    public String toString() {
        return "DatabaseError: " + this.message;
    }

    private DatabaseError(int i, String str, String str2) {
        this.code = i;
        this.message = str;
        this.details = str2 == null ? "" : str2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static DatabaseError fromStatus(String str, String str2) {
        return fromStatus(str, str2, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static DatabaseError fromStatus(String str, String str2, String str3) {
        Integer numValueOf = errorCodes.get(str.toLowerCase(Locale.US));
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(UNKNOWN_ERROR);
        }
        if (str2 == null) {
            str2 = errorReasons.get(numValueOf);
        }
        return new DatabaseError(numValueOf.intValue(), str2, str3);
    }
}

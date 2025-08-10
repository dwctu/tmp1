package com.spotify.sdk.android.player;

import com.huawei.hms.framework.network.grs.GrsBaseInfo;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'kSpErrorGeneralPlaybackError' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class Error {
    private static final /* synthetic */ Error[] $VALUES;
    public static final Error UNKNOWN;
    public static final Error kSpAlreadyPrefetching;
    public static final Error kSpErrorAPIRateLimited;
    public static final Error kSpErrorAdIsPlaying;
    public static final Error kSpErrorAlreadyInitialized;
    public static final Error kSpErrorApplicationBanned;
    public static final Error kSpErrorContextFailed;
    public static final Error kSpErrorCorruptTrack;
    public static final Error kSpErrorFailed;
    public static final Error kSpErrorGeneralLoginError;
    public static final Error kSpErrorGeneralPlaybackError;
    public static final Error kSpErrorInitFailed;
    public static final Error kSpErrorInvalidArgument;
    public static final Error kSpErrorLoginBadCredentials;
    public static final Error kSpErrorNeedsPremium;
    public static final Error kSpErrorNotActiveDevice;
    public static final Error kSpErrorNullArgument;
    public static final Error kSpErrorOk;
    public static final Error kSpErrorPlaybackCappingLimitReached;
    public static final Error kSpErrorPlaybackErrorStart;
    public static final Error kSpErrorPlaybackRateLimited;
    public static final Error kSpErrorPrefetchItemUnavailable;
    public static final Error kSpErrorTravelRestriction;
    public static final Error kSpErrorUninitialized;
    public static final Error kSpErrorUnsupported;
    public static final Error kSpErrorWrongAPIVersion;
    public static final Error kSpPrefetchDownloadFailed;
    public static final Error kSpStorageReadError;
    public static final Error kSpStorageWriteError;
    private final int nativeCode;

    static {
        Error error = new Error(GrsBaseInfo.CountryCodeSource.UNKNOWN, 0, -1);
        UNKNOWN = error;
        Error error2 = new Error("kSpErrorOk", 1, 0);
        kSpErrorOk = error2;
        Error error3 = new Error("kSpErrorFailed", 2, 1);
        kSpErrorFailed = error3;
        Error error4 = new Error("kSpErrorInitFailed", 3, 2);
        kSpErrorInitFailed = error4;
        Error error5 = new Error("kSpErrorWrongAPIVersion", 4, 3);
        kSpErrorWrongAPIVersion = error5;
        Error error6 = new Error("kSpErrorNullArgument", 5, 4);
        kSpErrorNullArgument = error6;
        Error error7 = new Error("kSpErrorInvalidArgument", 6, 5);
        kSpErrorInvalidArgument = error7;
        Error error8 = new Error("kSpErrorUninitialized", 7, 6);
        kSpErrorUninitialized = error8;
        Error error9 = new Error("kSpErrorAlreadyInitialized", 8, 7);
        kSpErrorAlreadyInitialized = error9;
        Error error10 = new Error("kSpErrorLoginBadCredentials", 9, 8);
        kSpErrorLoginBadCredentials = error10;
        Error error11 = new Error("kSpErrorNeedsPremium", 10, 9);
        kSpErrorNeedsPremium = error11;
        Error error12 = new Error("kSpErrorTravelRestriction", 11, 10);
        kSpErrorTravelRestriction = error12;
        Error error13 = new Error("kSpErrorApplicationBanned", 12, 11);
        kSpErrorApplicationBanned = error13;
        Error error14 = new Error("kSpErrorGeneralLoginError", 13, 12);
        kSpErrorGeneralLoginError = error14;
        Error error15 = new Error("kSpErrorUnsupported", 14, 13);
        kSpErrorUnsupported = error15;
        Error error16 = new Error("kSpErrorNotActiveDevice", 15, 14);
        kSpErrorNotActiveDevice = error16;
        Error error17 = new Error("kSpErrorAPIRateLimited", 16, 15);
        kSpErrorAPIRateLimited = error17;
        Error error18 = new Error("kSpErrorPlaybackErrorStart", 17, 1000);
        kSpErrorPlaybackErrorStart = error18;
        Error error19 = new Error("kSpErrorGeneralPlaybackError", 18, error18.nativeCode + 1);
        kSpErrorGeneralPlaybackError = error19;
        Error error20 = new Error("kSpErrorPlaybackRateLimited", 19, error18.nativeCode + 2);
        kSpErrorPlaybackRateLimited = error20;
        Error error21 = new Error("kSpErrorPlaybackCappingLimitReached", 20, error18.nativeCode + 3);
        kSpErrorPlaybackCappingLimitReached = error21;
        Error error22 = new Error("kSpErrorAdIsPlaying", 21, error18.nativeCode + 4);
        kSpErrorAdIsPlaying = error22;
        Error error23 = new Error("kSpErrorCorruptTrack", 22, error18.nativeCode + 5);
        kSpErrorCorruptTrack = error23;
        Error error24 = new Error("kSpErrorContextFailed", 23, error18.nativeCode + 6);
        kSpErrorContextFailed = error24;
        Error error25 = new Error("kSpErrorPrefetchItemUnavailable", 24, error18.nativeCode + 7);
        kSpErrorPrefetchItemUnavailable = error25;
        Error error26 = new Error("kSpAlreadyPrefetching", 25, error18.nativeCode + 8);
        kSpAlreadyPrefetching = error26;
        Error error27 = new Error("kSpStorageReadError", 26, error18.nativeCode + 9);
        kSpStorageReadError = error27;
        Error error28 = new Error("kSpStorageWriteError", 27, error18.nativeCode + 10);
        kSpStorageWriteError = error28;
        Error error29 = new Error("kSpPrefetchDownloadFailed", 28, error18.nativeCode + 11);
        kSpPrefetchDownloadFailed = error29;
        $VALUES = new Error[]{error, error2, error3, error4, error5, error6, error7, error8, error9, error10, error11, error12, error13, error14, error15, error16, error17, error18, error19, error20, error21, error22, error23, error24, error25, error26, error27, error28, error29};
    }

    private Error(String str, int i, int i2) {
        this.nativeCode = i2;
    }

    public static Error fromNativeError(int i) {
        for (Error error : values()) {
            if (error.nativeCode == i) {
                return error;
            }
        }
        return UNKNOWN;
    }

    public static Error valueOf(String str) {
        return (Error) Enum.valueOf(Error.class, str);
    }

    public static Error[] values() {
        return (Error[]) $VALUES.clone();
    }
}

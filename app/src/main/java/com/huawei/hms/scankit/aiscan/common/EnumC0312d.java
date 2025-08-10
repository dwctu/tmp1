package com.huawei.hms.scankit.aiscan.common;

import java.util.List;

/* compiled from: DecodeHintType.java */
/* renamed from: com.huawei.hms.scankit.aiscan.common.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public enum EnumC0312d {
    OTHER(Object.class),
    POSSIBLE_FORMATS(List.class),
    PHOTO_MODE(Void.TYPE),
    PHOTO_MODE_NUM(Integer.TYPE),
    NEED_JNI(Void.TYPE),
    CHARACTER_SET(String.class),
    RETURN_CODABAR_START_END(Void.class),
    NEED_RESULT_POINT_CALLBACK(A.class),
    ALLOWED_EAN_EXTENSIONS(int[].class);

    private final Class<?> k;

    EnumC0312d(Class cls) {
        this.k = cls;
    }
}

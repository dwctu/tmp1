package com.huawei.hms.mlsdk.common;

import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class AppSettingHolder<T> {
    private final String persistenceKey;
    private final T setting;

    private AppSettingHolder(String str, T t) {
        Objects.requireNonNull(str, "Null PersistentKey");
        Objects.requireNonNull(t, "Null setting");
        this.persistenceKey = str;
        this.setting = t;
    }

    public static <T> AppSettingHolder<T> create(String str, T t) {
        return new AppSettingHolder<>(str, t);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AppSettingHolder)) {
            return false;
        }
        AppSettingHolder appSettingHolder = (AppSettingHolder) obj;
        return this.persistenceKey.equals(appSettingHolder.persistenceKey) && this.setting.equals(appSettingHolder.setting);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.persistenceKey, this.setting});
    }

    public final String toString() {
        String str = this.persistenceKey;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 97 + String.valueOf(String.valueOf(this.setting)).length());
        sb.append("MlModelDriverInstanceKey{persistentKey=");
        sb.append(str);
        sb.append(", setting=");
        sb.append(this.setting);
        sb.append("}");
        return sb.toString();
    }
}

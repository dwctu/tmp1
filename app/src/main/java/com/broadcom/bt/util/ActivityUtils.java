package com.broadcom.bt.util;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class ActivityUtils {
    public static String getProperty(String str, Intent intent, Bundle bundle) {
        String string = bundle != null ? bundle.getString(str) : null;
        return TextUtils.isEmpty(string) ? intent.getStringExtra(str) : string;
    }
}

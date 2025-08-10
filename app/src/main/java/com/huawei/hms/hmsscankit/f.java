package com.huawei.hms.hmsscankit;

import com.google.android.material.datepicker.UtcDates;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/* compiled from: RemoteDecoder.java */
/* loaded from: classes3.dex */
public class f extends SimpleDateFormat {
    public f(String str) {
        super(str);
        setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
    }
}

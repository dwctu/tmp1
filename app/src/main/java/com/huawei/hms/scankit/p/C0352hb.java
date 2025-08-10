package com.huawei.hms.scankit.p;

import com.google.android.material.datepicker.UtcDates;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/* compiled from: HaLog60001.java */
/* renamed from: com.huawei.hms.scankit.p.hb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0352hb extends SimpleDateFormat {
    public final /* synthetic */ C0356ib a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0352hb(C0356ib c0356ib, String str) {
        super(str);
        this.a = c0356ib;
        setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
    }
}

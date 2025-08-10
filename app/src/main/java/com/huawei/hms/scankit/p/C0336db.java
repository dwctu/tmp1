package com.huawei.hms.scankit.p;

import com.google.android.material.datepicker.UtcDates;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/* compiled from: HaLog60000.java */
/* renamed from: com.huawei.hms.scankit.p.db, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0336db extends SimpleDateFormat {
    public final /* synthetic */ C0344fb a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0336db(C0344fb c0344fb, String str) {
        super(str);
        this.a = c0344fb;
        setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
    }
}

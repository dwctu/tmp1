package com.huawei.hms.scankit;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import com.huawei.hms.scankit.p.C0338e;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* compiled from: DecodeThread.java */
/* loaded from: classes3.dex */
public final class m extends Thread {
    private Context a;
    private final C0338e b;
    private final Map<EnumC0312d, Object> c;
    private Handler d;
    private HandlerC0308a e;
    private Rect g;
    private boolean h = true;
    private final CountDownLatch f = new CountDownLatch(1);

    public m(Context context, C0338e c0338e, HandlerC0308a handlerC0308a, Collection<BarcodeFormat> collection, Map<EnumC0312d, ?> map, String str, com.huawei.hms.scankit.aiscan.common.A a) {
        this.a = context;
        this.b = c0338e;
        this.e = handlerC0308a;
        EnumMap enumMap = new EnumMap(EnumC0312d.class);
        this.c = enumMap;
        if (map != null) {
            enumMap.putAll(map);
        }
        if (collection == null || collection.isEmpty()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            collection = EnumSet.noneOf(BarcodeFormat.class);
            if (defaultSharedPreferences.getBoolean("preferences_decode_1D_product", true)) {
                collection.addAll(i.a);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_1D_industrial", true)) {
                collection.addAll(i.b);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_QR", true)) {
                collection.addAll(i.d);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_Data_Matrix", true)) {
                collection.addAll(i.e);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_Aztec", false)) {
                collection.addAll(i.f);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_PDF417", false)) {
                collection.addAll(i.g);
            }
        }
        enumMap.put((EnumMap) EnumC0312d.POSSIBLE_FORMATS, (EnumC0312d) collection);
        if (str != null) {
            enumMap.put((EnumMap) EnumC0312d.CHARACTER_SET, (EnumC0312d) str);
        }
        enumMap.put((EnumMap) EnumC0312d.NEED_RESULT_POINT_CALLBACK, (EnumC0312d) a);
        com.huawei.hms.scankit.util.a.c("DecodeThread", "Hints: " + enumMap);
    }

    public void a(Rect rect) {
        this.g = rect;
    }

    public void b() {
        this.a = null;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.d = new j(this.a, this.b, this.e, this.c, this.g, this.h);
        this.f.countDown();
        Looper.loop();
    }

    public Handler a() throws InterruptedException {
        try {
            this.f.await();
        } catch (InterruptedException unused) {
            com.huawei.hms.scankit.util.a.b("exception", "InterruptedException");
        }
        return this.d;
    }

    public void a(boolean z) {
        this.h = z;
    }
}

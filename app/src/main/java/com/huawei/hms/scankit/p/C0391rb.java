package com.huawei.hms.scankit.p;

import android.content.Context;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.slf4j.Logger;

/* compiled from: HiAnalyticsLogExecutor.java */
/* renamed from: com.huawei.hms.scankit.p.rb, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0391rb {
    private static volatile C0391rb a = new C0391rb();
    private volatile boolean d;
    private volatile long e;
    private Timer b = new Timer();
    private volatile boolean c = true;
    private final Lock f = new ReentrantLock();
    private List<a> g = new ArrayList(5);

    /* compiled from: HiAnalyticsLogExecutor.java */
    /* renamed from: com.huawei.hms.scankit.p.rb$a */
    public class a {
        private String a;
        private LinkedHashMap<String, String> b;

        public /* synthetic */ a(C0391rb c0391rb, String str, LinkedHashMap linkedHashMap, C0388qb c0388qb) {
            this(str, linkedHashMap);
        }

        private a(String str, LinkedHashMap<String, String> linkedHashMap) {
            this.a = str;
            this.b = linkedHashMap;
        }
    }

    /* compiled from: HiAnalyticsLogExecutor.java */
    /* renamed from: com.huawei.hms.scankit.p.rb$b */
    public class b extends TimerTask {
        private b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                C0391rb.this.c = true;
                HmsHiAnalyticsUtils.onReport();
            } catch (Exception e) {
                com.huawei.hms.scankit.util.a.b("ScanHiAnalytics", e.getMessage());
            }
        }

        public /* synthetic */ b(C0391rb c0391rb, C0388qb c0388qb) {
            this();
        }
    }

    private C0391rb() {
    }

    private synchronized void b(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (this.d) {
            c(str, linkedHashMap);
        } else {
            if (this.g.size() >= 100) {
                return;
            }
            this.g.add(new a(this, str, linkedHashMap, null));
        }
    }

    private void c(String str, LinkedHashMap<String, String> linkedHashMap) {
        HmsHiAnalyticsUtils.onEvent(0, str, linkedHashMap);
        HmsHiAnalyticsUtils.onEvent(1, str, linkedHashMap);
        if (this.c) {
            this.c = false;
            this.b.schedule(new b(this, null), 3000L);
        }
        com.huawei.hms.scankit.util.a.a("ScanHiAnalytics", linkedHashMap.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (!this.f.tryLock() || this.d) {
            return;
        }
        try {
            Context context = DynamicModuleInitializer.getContext();
            if (context == null) {
                return;
            }
            String strA = a(context);
            if (strA != null && !strA.isEmpty()) {
                HmsHiAnalyticsUtils.init(context, false, false, false, strA, context.getPackageName());
                HmsHiAnalyticsUtils.enableLog();
                b();
            }
        } finally {
            this.f.unlock();
        }
    }

    public static C0391rb a() {
        return a;
    }

    public void a(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (this.d) {
            c(str, linkedHashMap);
        } else {
            b(str, linkedHashMap);
            c();
        }
    }

    private synchronized void b() {
        this.d = true;
        for (a aVar : this.g) {
            c(aVar.a, aVar.b);
        }
        this.g = null;
    }

    private void c() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.e > 6000) {
            this.e = jCurrentTimeMillis;
            new C0388qb(this, "ScanHiAnalytics").start();
        }
    }

    private String a(Context context) {
        try {
            GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
            String strA = new C0324ab(context, false).a();
            StringBuilder sb = new StringBuilder();
            sb.append("getCollectURL:localCountryCode ");
            sb.append(strA);
            sb.toString();
            if (strA != null && !strA.isEmpty() && !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(strA)) {
                grsBaseInfo.setSerCountry(strA.toUpperCase(Locale.ENGLISH));
            }
            String strSynGetGrsUrl = new GrsClient(context, grsBaseInfo).synGetGrsUrl("com.huawei.cloud.mlkithianalytics", Logger.ROOT_LOGGER_NAME);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("grs get url success: ");
            sb2.append(strSynGetGrsUrl);
            sb2.append("  countryCode = ");
            sb2.append(grsBaseInfo.getSerCountry());
            sb2.toString();
            return strSynGetGrsUrl;
        } catch (RuntimeException | Exception unused) {
            return null;
        }
    }
}

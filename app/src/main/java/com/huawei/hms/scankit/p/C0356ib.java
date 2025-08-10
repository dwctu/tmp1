package com.huawei.hms.scankit.p;

import android.os.Bundle;
import android.util.SparseArray;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.ml.scan.HmsScan;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Timer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: HaLog60001.java */
/* renamed from: com.huawei.hms.scankit.p.ib, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0356ib extends AbstractC0380ob {
    private volatile String h;
    private volatile String i;
    private boolean j;
    private volatile long k;
    private b l;

    /* compiled from: HaLog60001.java */
    /* renamed from: com.huawei.hms.scankit.p.ib$a */
    public static class a {
        private int a;
        private String b;
        private String c;
        private long d;
        private long e;
        private String f;
        private String g;
        private boolean h;
        private int i;
        private boolean j;

        public /* synthetic */ a(long j, String str, String str2, boolean z, int i, int i2, C0348gb c0348gb) {
            this(j, str, str2, z, i, i2);
        }

        private a(long j, String str, String str2, boolean z, int i, int i2) {
            this.d = j;
            this.b = str;
            this.c = str2;
            this.h = z;
            this.i = i;
            this.a = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a b(String str) {
            this.g = str;
            return this;
        }

        public a a(int i) {
            this.a = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a a(long j) {
            this.e = j;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a a(boolean z) {
            this.j = z;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a a(String str) {
            this.f = str;
            return this;
        }
    }

    /* compiled from: HaLog60001.java */
    /* renamed from: com.huawei.hms.scankit.p.ib$b */
    public class b {
        private String a;
        private Timer b;
        private volatile boolean c;
        private List<a> d;
        private List<a> e;

        /* compiled from: HaLog60001.java */
        /* renamed from: com.huawei.hms.scankit.p.ib$b$a */
        public class a {
            private StringBuilder a;
            private AtomicInteger[] b;
            private String[] c;
            private long[] d;

            private a() {
                this.a = new StringBuilder(100);
                this.b = new AtomicInteger[]{new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger()};
                this.c = new String[]{"lt10K:", "lt100K:", "lt1M:", "lt3M:", "lt10M:", "lt40M:", "gt40M:"};
                this.d = new long[]{10240, 102400, 1048576, 3145728, 10485760, 41943040, Long.MAX_VALUE};
            }

            /* JADX INFO: Access modifiers changed from: private */
            public String a() {
                StringBuilder sb = this.a;
                sb.delete(0, sb.length());
                this.a.append("{");
                for (int i = 0; i < this.b.length; i++) {
                    this.a.append(this.c[i]);
                    this.a.append(this.b[i]);
                    this.a.append(",");
                }
                this.a.replace(r0.length() - 1, this.a.length(), "}");
                return this.a.toString();
            }

            public /* synthetic */ a(b bVar, C0348gb c0348gb) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(int i) {
                int i2 = 0;
                while (true) {
                    AtomicInteger[] atomicIntegerArr = this.b;
                    if (i2 >= atomicIntegerArr.length) {
                        return;
                    }
                    if (i <= this.d[i2]) {
                        atomicIntegerArr[i2].addAndGet(1);
                        return;
                    }
                    i2++;
                }
            }
        }

        /* compiled from: HaLog60001.java */
        /* renamed from: com.huawei.hms.scankit.p.ib$b$b, reason: collision with other inner class name */
        public class C0054b {
            private StringBuilder a;
            private SparseArray<AtomicInteger> b;

            private C0054b() {
                this.a = new StringBuilder(60);
                this.b = new C0364kb(this);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void a(int i) {
                if (this.b.get(i) == null) {
                    this.b.put(i, new C0368lb(this));
                } else {
                    this.b.get(i).addAndGet(1);
                }
            }

            public /* synthetic */ C0054b(b bVar, C0348gb c0348gb) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public String a() {
                StringBuilder sb = this.a;
                sb.delete(0, sb.length());
                this.a.append("{");
                for (int i = 0; i < this.b.size(); i++) {
                    this.a.append(this.b.keyAt(i));
                    this.a.append(SignatureImpl.INNER_SEP);
                    this.a.append(this.b.valueAt(i));
                    this.a.append(",");
                }
                this.a.replace(r0.length() - 1, this.a.length(), "}");
                return this.a.toString();
            }
        }

        private b() {
            this.a = b.class.getSimpleName();
            this.b = new Timer();
            this.c = true;
            this.d = new ArrayList(10);
            this.e = new ArrayList(10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(a aVar) {
            if (this.d.size() > 100) {
                return;
            }
            synchronized (this) {
                this.d.add(aVar);
                if (this.c) {
                    this.c = false;
                    this.b.schedule(new C0360jb(this), 1000L);
                }
            }
        }

        public /* synthetic */ b(C0356ib c0356ib, C0348gb c0348gb) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (this.d.size() > 0) {
                synchronized (this) {
                    List<a> list = this.d;
                    List<a> list2 = this.e;
                    this.d = list2;
                    this.e = list;
                    list2.clear();
                }
                a(this.e);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r24v2, types: [java.lang.Boolean] */
        private void a(List<a> list) {
            HashSet<String> hashSet = new HashSet();
            Iterator<a> it = list.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next().c);
            }
            for (String str : hashSet) {
                C0348gb c0348gb = null;
                C0054b c0054b = new C0054b(this, c0348gb);
                a aVar = new a(this, c0348gb);
                long j = Long.MAX_VALUE;
                long j2 = Long.MIN_VALUE;
                String str2 = "";
                String str3 = "";
                String str4 = str3;
                long j3 = 0;
                long j4 = 0;
                long j5 = 0;
                long j6 = 0;
                for (a aVar2 : list) {
                    str2 = aVar2.b;
                    str3 = aVar2.f;
                    str4 = aVar2.g;
                    ?? ValueOf = Boolean.valueOf(aVar2.h);
                    j4 += aVar2.e - aVar2.d;
                    c0054b.a(aVar2.a);
                    aVar.a(aVar2.i);
                    j3++;
                    if (aVar2.j) {
                        j6++;
                    }
                    if (aVar2.a != 0) {
                        j5++;
                    }
                    if (aVar2.e - aVar2.d < j) {
                        j = aVar2.e - aVar2.d;
                    }
                    if (aVar2.e - aVar2.d > j2) {
                        j2 = aVar2.e - aVar2.d;
                    }
                    c0348gb = ValueOf;
                }
                LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
                linkedHashMap.putAll(C0356ib.this.f);
                linkedHashMap.put("result", c0054b.a());
                linkedHashMap.put("imgSizeHistogram", aVar.a());
                linkedHashMap.put("callTime", str2);
                linkedHashMap.put("transId", str);
                if (j3 != 0) {
                    j4 /= j3;
                }
                linkedHashMap.put("costTime", String.valueOf(j4));
                linkedHashMap.put("allCnt", String.valueOf(j3));
                linkedHashMap.put("failCnt", String.valueOf(j5));
                linkedHashMap.put("codeCnt", String.valueOf(j6));
                linkedHashMap.put("scanType", str3);
                linkedHashMap.put("sceneType", str4);
                linkedHashMap.put("min", String.valueOf(j));
                linkedHashMap.put("max", String.valueOf(j2));
                linkedHashMap.put("algPhotoMode", String.valueOf(c0348gb));
                C0391rb.a().a("60001", linkedHashMap);
            }
        }
    }

    public C0356ib(Bundle bundle, String str) {
        super(bundle, DynamicModuleInitializer.getContext());
        this.j = false;
        this.l = new b(this, null);
        this.f.put("apiName", str);
        if (DetailRect.PHOTO_MODE.equals(str)) {
            this.j = true;
        }
    }

    public void a(String str) {
        this.f.put("algapi", str);
    }

    public a a(boolean z, int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                if (this.j) {
                    new a(jCurrentTimeMillis, new C0348gb(this, "yyyyMMddHHmmss.SSS").format(Long.valueOf(jCurrentTimeMillis)), UUID.randomUUID().toString(), z, i, 0, null);
                    return new a(jCurrentTimeMillis, this.h, this.i, z, i, 0, null);
                }
                if (jCurrentTimeMillis - this.k > 1500) {
                    String str = new C0352hb(this, "yyyyMMddHHmmss.SSS").format(Long.valueOf(jCurrentTimeMillis));
                    String string = UUID.randomUUID().toString();
                    if (jCurrentTimeMillis - this.k > 1500) {
                        this.h = str;
                        this.i = string;
                        this.k = jCurrentTimeMillis;
                    }
                }
                new a(jCurrentTimeMillis, this.h, this.i, z, i, 0, null);
                return new a(jCurrentTimeMillis, this.h, this.i, z, i, 0, null);
            } catch (Exception unused) {
                com.huawei.hms.scankit.util.a.b("HaLog6001", "exception happens");
                return new a(jCurrentTimeMillis, this.h, this.i, z, i, 0, null);
            }
        } catch (Throwable unused2) {
            return new a(jCurrentTimeMillis, this.h, this.i, z, i, 0, null);
        }
    }

    public void a(HmsScan[] hmsScanArr, a aVar) {
        try {
            String str = AbstractC0380ob.a;
            String strB = AbstractC0380ob.b;
            if (a()) {
                boolean z = false;
                int i = 0;
                z = false;
                if (hmsScanArr != null && hmsScanArr.length > 0) {
                    int length = hmsScanArr.length;
                    while (i < length) {
                        HmsScan hmsScan = hmsScanArr[i];
                        String strA = AbstractC0380ob.a(hmsScan.scanType);
                        i++;
                        strB = AbstractC0380ob.b(hmsScan.scanTypeForm);
                        str = strA;
                    }
                    z = true;
                }
                this.l.a(aVar.a(System.currentTimeMillis()).a(z).a(str).b(strB));
                this.k = aVar.e;
            }
        } catch (NullPointerException unused) {
            com.huawei.hms.scankit.util.a.b("HaLog60001", "nullPoint");
        } catch (Exception unused2) {
            com.huawei.hms.scankit.util.a.b("HaLog60001", "logEnd Exception");
        }
    }
}

package com.huawei.hms.scankit;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.view.Display;
import android.view.WindowManager;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.aiscan.common.EnumC0312d;
import com.huawei.hms.scankit.p.C0330c;
import com.huawei.hms.scankit.p.C0338e;
import com.huawei.hms.scankit.p.C0342f;
import com.huawei.hms.scankit.p.C0346g;
import com.huawei.hms.scankit.p.C0356ib;
import com.huawei.hms.scankit.p.Fb;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.bouncycastle.crypto.tls.CipherSuite;

/* compiled from: DecodeHandler.java */
/* loaded from: classes3.dex */
public final class j extends Handler {
    private static long a;
    private final Context b;
    private final C0338e c;
    private final HandlerC0308a d;
    private boolean e = true;
    private int f = 50;
    private a g;
    private Rect h;
    private int i;
    private IRemoteFrameDecoderDelegate j;
    private boolean k;

    /* compiled from: DecodeHandler.java */
    public static class a extends AsyncTask<Object, Object, Object> {
        private WeakReference<j> a;
        private List<C0342f.a> e;
        private List<C0342f.a> f;
        private boolean b = true;
        private boolean c = false;
        private int d = 0;
        private int g = 0;
        private int h = 0;

        public a(j jVar) {
            this.a = new WeakReference<>(jVar);
        }

        public void b(int i) {
            this.h = i;
            j jVar = this.a.get();
            if (jVar != null) {
                try {
                    jVar.a(this.h, this.f);
                    StringBuilder sb = new StringBuilder();
                    sb.append("ScanCode handle global value");
                    sb.append(this.h);
                    com.huawei.hms.scankit.util.a.c("DecodeHandler", sb.toString());
                } catch (RuntimeException e) {
                    com.huawei.hms.scankit.util.a.b("DecodeHandler", "RuntimeException: " + e.getMessage());
                } catch (Exception unused) {
                    com.huawei.hms.scankit.util.a.b("DecodeHandler", "Exception");
                }
            }
        }

        @Override // android.os.AsyncTask
        public Object doInBackground(Object... objArr) throws InterruptedException {
            while (!this.c) {
                if (this.b) {
                    try {
                        Thread.sleep(400L);
                    } catch (InterruptedException unused) {
                        com.huawei.hms.scankit.util.a.c("ScankitDecode", "doInBackground  get InterruptedException  error!!!");
                    }
                    this.b = false;
                } else {
                    j jVar = this.a.get();
                    int i = this.g;
                    if (i == 0) {
                        this.b = true;
                    } else if (jVar != null) {
                        try {
                            jVar.a(this.d / i, this.e);
                            StringBuilder sb = new StringBuilder();
                            sb.append("ScanCode handle auto value");
                            sb.append(this.d / this.g);
                            com.huawei.hms.scankit.util.a.c("DecodeHandler", sb.toString());
                            a();
                            this.b = true;
                        } catch (RuntimeException e) {
                            com.huawei.hms.scankit.util.a.b("DecodeHandler", "RuntimeException: " + e.getMessage());
                        } catch (Exception unused2) {
                            com.huawei.hms.scankit.util.a.b("DecodeHandler", "Exception");
                        }
                    }
                }
            }
            return null;
        }

        public void a(int i) {
            this.d += i;
            this.g++;
        }

        public void a(List<Rect> list, int i, int i2, boolean z) {
            if (list == null) {
                com.huawei.hms.scankit.util.a.a("ScankitDecode", "areas is null");
                return;
            }
            if (list.size() == 0) {
                this.f = Collections.singletonList(new C0342f.a(new Rect(-100, -100, 100, 100), 1000));
                return;
            }
            this.f = new ArrayList();
            for (Rect rect : list) {
                int iCenterX = ((rect.centerX() * 2000) / i) - 1000;
                int iCenterY = ((rect.centerY() * 2000) / i2) - 1000;
                int iWidth = ((rect.width() * 2000) / i) / 2;
                int iHeight = ((rect.height() * 2000) / i2) / 2;
                this.f.add(new C0342f.a(new Rect(iCenterX - (iWidth / 2), iCenterY - (iHeight / 2), iCenterX + iWidth, iCenterY + iHeight), 1000 / list.size()));
            }
            list.clear();
        }

        public void b(List<Rect> list, int i, int i2, boolean z) {
            if (list == null) {
                com.huawei.hms.scankit.util.a.a("ScankitDecode", "areas is null");
                return;
            }
            if (list.size() == 0) {
                this.e = Collections.singletonList(new C0342f.a(new Rect(-100, -100, 100, 100), 1000));
                return;
            }
            this.e = new ArrayList();
            if (z) {
                int i3 = (i2 > i ? i2 - i : i - i2) >> 1;
                for (Rect rect : list) {
                    int iCenterY = (((rect.centerY() + i3) * 2000) / i) - 1000;
                    int iCenterX = ((rect.centerX() * 2000) / i2) - 1000;
                    int iHeight = ((rect.height() * 2000) / i) / 2;
                    int iWidth = ((rect.width() * 2000) / i2) / 2;
                    this.e.add(new C0342f.a(new Rect(iCenterY - (iHeight / 2), iCenterX - (iWidth / 2), iCenterY + iHeight, iCenterX + iWidth), 1000 / list.size()));
                }
                return;
            }
            for (Rect rect2 : list) {
                int iCenterX2 = ((rect2.centerX() * 2000) / i) - 1000;
                int iCenterY2 = ((rect2.centerY() * 2000) / i2) - 1000;
                int iWidth2 = ((rect2.width() * 2000) / i) / 2;
                int iHeight2 = ((rect2.height() * 2000) / i2) / 2;
                this.e.add(new C0342f.a(new Rect(iCenterX2 - (iWidth2 / 2), iCenterY2 - (iHeight2 / 2), iCenterX2 + iWidth2, iCenterY2 + iHeight2), 1000 / list.size()));
            }
            list.clear();
        }

        private void a() {
            this.d = 0;
            this.g = 0;
        }
    }

    public j(Context context, C0338e c0338e, HandlerC0308a handlerC0308a, Map<EnumC0312d, Object> map, Rect rect, boolean z) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        this.k = false;
        this.b = context;
        this.c = c0338e;
        this.d = handlerC0308a;
        this.h = rect;
        if (this.g == null) {
            a aVar = new a(this);
            this.g = aVar;
            aVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        }
        this.i = 0;
        this.k = z;
        a(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003f A[Catch: RemoteException -> 0x0057, TryCatch #4 {RemoteException -> 0x0057, blocks: (B:18:0x003b, B:20:0x003f, B:22:0x004c, B:24:0x0050), top: B:31:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004c A[Catch: RemoteException -> 0x0057, TryCatch #4 {RemoteException -> 0x0057, blocks: (B:18:0x003b, B:20:0x003f, B:22:0x004c, B:24:0x0050), top: B:31:0x003b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.content.Context r4) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.ClassNotFoundException {
        /*
            r3 = this;
            java.lang.String r0 = "ScankitDecode"
            boolean r1 = r3.k     // Catch: java.lang.InstantiationException -> L29 java.lang.ClassNotFoundException -> L2f java.lang.IllegalAccessException -> L35
            if (r1 == 0) goto Ld
            java.lang.Class<com.huawei.hms.scankit.DecoderCreator> r4 = com.huawei.hms.scankit.DecoderCreator.class
            java.lang.Object r4 = r4.newInstance()     // Catch: java.lang.InstantiationException -> L29 java.lang.ClassNotFoundException -> L2f java.lang.IllegalAccessException -> L35
            goto L3b
        Ld:
            android.content.Context r4 = com.huawei.hms.hmsscankit.j.d(r4)     // Catch: java.lang.Throwable -> L11 java.lang.InstantiationException -> L29 java.lang.ClassNotFoundException -> L2f java.lang.IllegalAccessException -> L35
        L11:
            java.lang.ClassLoader r1 = r4.getClassLoader()     // Catch: java.lang.InstantiationException -> L29 java.lang.ClassNotFoundException -> L2f java.lang.IllegalAccessException -> L35
            java.lang.String r2 = "com.huawei.hms.scankit.DecoderCreator"
            java.lang.Class r1 = r1.loadClass(r2)     // Catch: java.lang.InstantiationException -> L29 java.lang.ClassNotFoundException -> L2f java.lang.IllegalAccessException -> L35
            java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch: java.lang.InstantiationException -> L29 java.lang.ClassNotFoundException -> L2f java.lang.IllegalAccessException -> L35
            java.lang.String r2 = "com.huawei.hms.scankit.aiscan.common.BarcodeFormat"
            r4.loadClass(r2)     // Catch: java.lang.InstantiationException -> L29 java.lang.ClassNotFoundException -> L2f java.lang.IllegalAccessException -> L35
            java.lang.Object r4 = r1.newInstance()     // Catch: java.lang.InstantiationException -> L29 java.lang.ClassNotFoundException -> L2f java.lang.IllegalAccessException -> L35
            goto L3b
        L29:
            java.lang.String r4 = "InstantiationException"
            com.huawei.hms.scankit.util.a.a(r0, r4)
            goto L3a
        L2f:
            java.lang.String r4 = "ClassNotFoundException"
            com.huawei.hms.scankit.util.a.a(r0, r4)
            goto L3a
        L35:
            java.lang.String r4 = "IllegalAccessException"
            com.huawei.hms.scankit.util.a.a(r0, r4)
        L3a:
            r4 = 0
        L3b:
            boolean r1 = r4 instanceof android.os.IBinder     // Catch: android.os.RemoteException -> L57
            if (r1 == 0) goto L4c
            android.os.IBinder r4 = (android.os.IBinder) r4     // Catch: android.os.RemoteException -> L57
            com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator r4 = com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator.Stub.asInterface(r4)     // Catch: android.os.RemoteException -> L57
            com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate r4 = r4.newRemoteFrameDecoderDelegate()     // Catch: android.os.RemoteException -> L57
            r3.j = r4     // Catch: android.os.RemoteException -> L57
            return
        L4c:
            com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate r4 = r3.j     // Catch: android.os.RemoteException -> L57
            if (r4 != 0) goto L5c
            com.huawei.hms.scankit.s r4 = com.huawei.hms.scankit.s.a()     // Catch: android.os.RemoteException -> L57
            r3.j = r4     // Catch: android.os.RemoteException -> L57
            goto L5c
        L57:
            java.lang.String r4 = "RemoteException"
            com.huawei.hms.scankit.util.a.a(r0, r4)
        L5c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.j.a(android.content.Context):void");
    }

    private boolean c() {
        Context context = this.b;
        if (context == null) {
            return true;
        }
        Object systemService = context.getSystemService("window");
        if (!(systemService instanceof WindowManager)) {
            com.huawei.hms.scankit.util.a.c("ScankitDecode", "isScreenPortrait  getSystemService  WINDOW_SERVICE  error!!!");
            return true;
        }
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x < point.y;
    }

    public boolean b(float f) {
        boolean z;
        HandlerC0308a handlerC0308a = this.d;
        if (handlerC0308a != null && handlerC0308a.a()) {
            return false;
        }
        try {
            C0346g c0346gG = this.c.g();
            if (c0346gG == null) {
                com.huawei.hms.scankit.util.a.c("ScankitDecode", "Zoom not supported,data is null");
                return false;
            }
            int iC = c0346gG.c();
            int iB = c0346gG.b();
            float fIntValue = ((r1.get(iB).intValue() * 1.0f) / 100.0f) * f;
            if (((int) (fIntValue * 100.0f)) > c0346gG.a().get(iC).intValue()) {
                fIntValue = (iC * 1.0f) / 100.0f;
            }
            if (!this.c.i()) {
                com.huawei.hms.scankit.util.a.c("ScankitDecode", "Zoom not supported");
                return false;
            }
            int iA = a(fIntValue);
            if (iA > iB) {
                this.c.c(iA);
                z = true;
            } else {
                this.c.c(iB);
                z = false;
            }
            this.c.a(Collections.singletonList(new C0342f.a(new Rect(-150, -150, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA, CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA), 1000)));
            return z;
        } catch (RuntimeException unused) {
            com.huawei.hms.scankit.util.a.b("ScankitDecode", "Zoom not supported,RuntimeException happen");
            return false;
        } catch (Exception unused2) {
            com.huawei.hms.scankit.util.a.b("ScankitDecode", "Zoom not supported,Exception happen");
            return false;
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws RemoteException, IOException {
        if (message == null || !this.e) {
            return;
        }
        int i = message.what;
        if (i == R.id.scankit_decode) {
            int i2 = this.i;
            if (i2 <= 1) {
                this.i = i2 + 1;
                this.d.sendEmptyMessage(R.id.scankit_decode_failed);
                return;
            } else {
                Object obj = message.obj;
                if (obj instanceof byte[]) {
                    a((byte[]) obj, c());
                    return;
                }
                return;
            }
        }
        if (i != R.id.scankit_quit) {
            com.huawei.hms.scankit.util.a.c("ScankitDecode", "handleMessage  message.what:" + message.what);
            return;
        }
        this.e = false;
        a aVar = this.g;
        if (aVar != null) {
            aVar.c = true;
            this.g.cancel(true);
        }
        Looper.myLooper().quit();
    }

    public float b() {
        if (a() == null) {
            return 1.0f;
        }
        return Math.round(r0.get(r0.size() - 1).intValue() / 100.0f);
    }

    private void a(byte[] bArr, boolean z) throws RemoteException, IOException {
        com.huawei.hms.scankit.aiscan.common.x[] xVarArrDecode;
        int i = this.c.e().x;
        int i2 = this.c.e().y;
        Context context = this.b;
        int rotation = (context == null || !(context instanceof Activity)) ? 0 : ((Activity) context).getWindowManager().getDefaultDisplay().getRotation();
        if (this.d != null) {
            C0356ib.a aVarA = C0318e.b != null ? C0318e.b.a(false, i * i2) : null;
            Bundle bundle = new Bundle();
            bundle.putParcelable("Rect", this.h);
            Point pointA = com.huawei.hms.scankit.util.c.a(this.b);
            if (pointA != null) {
                bundle.putParcelable("Screen", pointA);
            }
            try {
                xVarArrDecode = this.j.decode(bArr, i, i2, rotation, this.d.b(), ObjectWrapper.wrap(bundle));
            } catch (RemoteException unused) {
                xVarArrDecode = null;
            }
            if (xVarArrDecode != null && xVarArrDecode.length > 0 && xVarArrDecode[0] != null) {
                if (this.d.d() && xVarArrDecode[0].j() != 1.0f && System.currentTimeMillis() - a > 1000) {
                    com.huawei.hms.scankit.util.a.c("ScankitDecode", "need to zoom" + xVarArrDecode[0].j());
                    if (a(xVarArrDecode[0].j(), xVarArrDecode, aVarA)) {
                        a = System.currentTimeMillis();
                        return;
                    }
                }
                if (xVarArrDecode[0].i() == null) {
                    if (xVarArrDecode[0].k()) {
                        com.huawei.hms.scankit.util.a.c("ScankitDecode", "ScanCode need to globalexposure" + xVarArrDecode[0].f());
                        this.g.a(xVarArrDecode[0].e(), i, i2, false);
                        this.g.b(xVarArrDecode[0].f());
                    } else {
                        com.huawei.hms.scankit.util.a.c("ScankitDecode", "ScanCode need to exposure" + xVarArrDecode[0].d());
                        this.g.a(xVarArrDecode[0].d());
                        this.g.b(xVarArrDecode[0].c(), i, i2, z);
                    }
                }
                a(xVarArrDecode, bArr, i, i2, aVarA);
                return;
            }
            this.d.sendEmptyMessage(R.id.scankit_decode_failed);
            if (C0318e.b != null) {
                C0318e.b.a((HmsScan[]) null, aVarA);
            }
        }
    }

    private boolean a(float f, com.huawei.hms.scankit.aiscan.common.x[] xVarArr, C0356ib.a aVar) {
        if (!b(f)) {
            return false;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = R.id.scankit_decode_succeeded;
        HmsScan[] hmsScanArrA = Fb.a(xVarArr);
        messageObtain.obj = hmsScanArrA;
        if (C0318e.b != null) {
            C0318e.b.a(hmsScanArrA, aVar);
        }
        this.d.sendMessage(messageObtain);
        return true;
    }

    private void a(com.huawei.hms.scankit.aiscan.common.x[] xVarArr, byte[] bArr, int i, int i2, C0356ib.a aVar) throws IOException {
        if (this.d != null) {
            HmsScan[] hmsScanArrA = Fb.a(xVarArr);
            Message messageObtain = Message.obtain(this.d, R.id.scankit_decode_succeeded, hmsScanArrA);
            if (C0318e.b != null) {
                C0318e.b.a(hmsScanArrA, aVar);
            }
            if (this.d.c()) {
                Bundle bundle = new Bundle();
                a(bArr, i, i2, bundle);
                messageObtain.setData(bundle);
            }
            messageObtain.sendToTarget();
        }
    }

    private static void a(byte[] bArr, int i, int i2, Bundle bundle) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
        bundle.putByteArray("barcode_bitmap", byteArrayOutputStream.toByteArray());
        bundle.putFloat("barcode_scaled_factor", 1.0f);
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused) {
        }
    }

    public void a(int i, List<C0342f.a> list) {
        C0330c c0330cB = this.c.b();
        int iB = c0330cB.b();
        int iC = c0330cB.c();
        int iA = c0330cB.a();
        if (i == 0) {
            return;
        }
        int i2 = iA + i;
        if (i2 <= iB) {
            iB = i2 < iC ? iC : i2;
        }
        this.c.b(iB);
        C0342f c0342fC = this.c.c();
        Rect rectB = c0342fC.b();
        if (c0342fC.a() > 0) {
            if (c0342fC.a() == 1) {
                int iCenterX = rectB.centerX();
                int iCenterY = rectB.centerY();
                if (Math.sqrt(((iCenterX - list.get(0).a.centerX()) * (iCenterX - list.get(0).a.centerX())) + (iCenterY - list.get(0).a.centerY()) + (iCenterY - list.get(0).a.centerY())) > this.f) {
                    list.set(0, new C0342f.a(list.get(0).a, 1000));
                    this.c.a(list.subList(0, 1));
                    return;
                }
                return;
            }
            this.c.a(list);
        }
    }

    public int a(float f) {
        List<Integer> listA = a();
        if (listA == null) {
            return -3;
        }
        if (listA.size() <= 0) {
            return -4;
        }
        if (f == 1.0f) {
            return 0;
        }
        if (f == b()) {
            return listA.size() - 1;
        }
        for (int i = 1; i < listA.size(); i++) {
            float f2 = 100.0f * f;
            if (listA.get(i).intValue() >= f2 && listA.get(i - 1).intValue() <= f2) {
                return i;
            }
        }
        return -1;
    }

    public List<Integer> a() {
        return this.c.g().a();
    }
}

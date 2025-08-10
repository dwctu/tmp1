package dc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.lovense.wear.R;
import com.nostra13.universalimageloader.utils.L;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.is3;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: DownApkUtil.java */
/* loaded from: classes4.dex */
public class ee3 {
    public static final String i = WearUtils.T("downloads").getAbsolutePath();
    public String a;
    public int b;
    public String c = null;
    public boolean d = false;
    public Handler e = new Handler(new a());
    public b f;
    public Context g;
    public boolean h;

    /* compiled from: DownApkUtil.java */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                ee3.this.b = ((Integer) message.obj).intValue();
                String str = "handleMessage: length:" + ee3.this.b;
                if (ee3.this.d) {
                    return false;
                }
                ee3 ee3Var = ee3.this;
                ee3Var.new c(ee3Var.a, ee3.this.b).start();
                return false;
            }
            if (i == 1) {
                b bVar = ee3.this.f;
                if (bVar == null) {
                    return false;
                }
                bVar.b(ah4.e(R.string.file_notfound));
                return false;
            }
            if (i == 2) {
                b bVar2 = ee3.this.f;
                if (bVar2 == null) {
                    return false;
                }
                bVar2.b(ah4.e(R.string.net_connect_error_tip));
                return false;
            }
            if (i != 3) {
                if (i != 4) {
                    return false;
                }
                b bVar3 = ee3.this.f;
                if (bVar3 != null) {
                    bVar3.c();
                }
                ee3 ee3Var2 = ee3.this;
                ee3Var2.q(ee3Var2.g, new File(ee3.i, ee3.this.c));
                return false;
            }
            long jLongValue = ((Long) message.obj).longValue();
            String str2 = "handleMessage: progress:" + jLongValue;
            b bVar4 = ee3.this.f;
            if (bVar4 == null) {
                return false;
            }
            bVar4.a(jLongValue);
            return false;
        }
    }

    /* compiled from: DownApkUtil.java */
    public interface b {
        void a(long j);

        void b(String str);

        void c();
    }

    /* compiled from: DownApkUtil.java */
    public class c extends Thread {
        public String a;
        public int b;

        public c(String str, int i) {
            this.a = str;
            this.b = i;
        }

        /* JADX WARN: Removed duplicated region for block: B:62:0x0173 A[Catch: IOException -> 0x016f, TryCatch #6 {IOException -> 0x016f, blocks: (B:58:0x016b, B:62:0x0173, B:64:0x0178), top: B:71:0x016b }] */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0178 A[Catch: IOException -> 0x016f, TRY_LEAVE, TryCatch #6 {IOException -> 0x016f, blocks: (B:58:0x016b, B:62:0x0173, B:64:0x0178), top: B:71:0x016b }] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x016b A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:85:? A[SYNTHETIC] */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() throws java.lang.Throwable {
            /*
                Method dump skipped, instructions count: 384
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: dc.ee3.c.run():void");
        }
    }

    /* compiled from: DownApkUtil.java */
    public class d extends Thread {
        public String a;

        public d(String str) {
            this.a = "";
            this.a = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.io.RandomAccessFile] */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v2, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.net.HttpURLConnection] */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6 */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws Throwable {
            RandomAccessFile randomAccessFile;
            HttpURLConnection httpURLConnection;
            int contentLength;
            ?? r0 = 0;
            r0 = 0;
            try {
                try {
                    httpURLConnection = (HttpURLConnection) new URL(this.a).openConnection();
                    try {
                        httpURLConnection.setConnectTimeout(3000);
                        httpURLConnection.setRequestMethod("GET");
                        contentLength = httpURLConnection.getResponseCode() == 200 ? httpURLConnection.getContentLength() : -1;
                    } catch (Exception e) {
                        e = e;
                        randomAccessFile = null;
                    } catch (Throwable th) {
                        th = th;
                        randomAccessFile = null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    randomAccessFile = null;
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = null;
                }
                if (contentLength <= 0) {
                    try {
                        httpURLConnection.disconnect();
                        r0.close();
                        return;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        return;
                    }
                }
                ee3.m("lovense_remote.apk");
                File file = new File(ee3.i);
                if (!file.exists()) {
                    file.mkdir();
                }
                ee3.this.c = "lovense_remote.temp";
                File file2 = new File(file, ee3.this.c);
                ee3.n(file2);
                randomAccessFile = new RandomAccessFile(file2, "rwd");
                try {
                    randomAccessFile.setLength(contentLength);
                    ee3.this.e.obtainMessage(0, Integer.valueOf(contentLength)).sendToTarget();
                    httpURLConnection.disconnect();
                    randomAccessFile.close();
                } catch (Exception e4) {
                    e = e4;
                    r0 = httpURLConnection;
                    try {
                        String str = "run: " + e;
                        ee3.this.e.sendEmptyMessage(1);
                        e.printStackTrace();
                        r0.disconnect();
                        randomAccessFile.close();
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            r0.disconnect();
                            randomAccessFile.close();
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    r0 = httpURLConnection;
                    r0.disconnect();
                    randomAccessFile.close();
                    throw th;
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    public static void l() {
        try {
            m("lovense_remote.apk");
            m("lovense_remote.temp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void m(String str) {
        File file = new File(i);
        if (file.exists()) {
            n(new File(file, str));
        }
    }

    public static void n(File file) {
        try {
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static File o() {
        return new File(i, "lovense_remote.apk");
    }

    public static void p(Context context, File file) {
        if (file.exists()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (Build.VERSION.SDK_INT >= 24) {
                Uri uriForFile = FileProvider.getUriForFile(context, WearUtils.x.getPackageName() + ".fileprovider", file);
                intent.addFlags(1);
                intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
            } else {
                intent.setFlags(268435456);
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            }
            ((Activity) context).startActivityForResult(intent, 10087);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void s() {
        ((Activity) this.g).startActivityForResult(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + WearUtils.x.getPackageName())), 10086);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void u() {
        if (this.h) {
            MyApplication.D();
        }
    }

    public final void q(Context context, File file) {
        if (file.exists()) {
            if (Build.VERSION.SDK_INT < 26) {
                p(context, file);
                return;
            }
            if (this.g.getPackageManager().canRequestPackageInstalls()) {
                L.i("8.0手机已经拥有安装未知来源应用的权限，直接安装！", new Object[0]);
                p(context, file);
                return;
            }
            String strE = ah4.e(R.string.common_cancel);
            if (this.h) {
                strE = ah4.e(R.string.common_exit);
            }
            cs3.d(this.g, ah4.e(R.string.apk_update_request_android_o_permission), ah4.e(R.string.common_ok), strE, new is3.d() { // from class: dc.mc3
                @Override // dc.is3.d
                public final void doConfirm() {
                    this.a.s();
                }
            }, new is3.c() { // from class: dc.nc3
                @Override // dc.is3.c
                public final void doCancel() {
                    this.a.u();
                }
            }).show();
        }
    }

    public void v(File file) {
        File file2 = new File(i);
        if (!file2.exists()) {
            file2.mkdir();
        }
        this.c = "lovense_remote.apk";
        file.renameTo(new File(file2, this.c));
    }

    public final void w(long j, long j2) {
        Message message = new Message();
        StringBuilder sb = new StringBuilder();
        sb.append("sendProgress: percent：");
        sb.append(j);
        sb.append("   ");
        sb.append(j2);
        sb.append("   ");
        long j3 = (j * 100) / j2;
        sb.append(j3);
        sb.toString();
        message.obj = Long.valueOf(j3);
        message.what = 3;
        this.e.sendMessage(message);
    }

    public void x(String str, Context context, boolean z, b bVar) {
        this.a = str;
        this.f = bVar;
        this.g = context;
        this.d = false;
        this.h = z;
        this.e.removeCallbacksAndMessages(null);
        if (str == null || TextUtils.isEmpty(str)) {
            bVar.b(ah4.e(R.string.file_notfound));
        } else {
            new d(str).start();
        }
    }

    public void y() {
        this.d = true;
        this.e.removeCallbacksAndMessages(null);
    }
}

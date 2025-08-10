package dc;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.lovense.wear.R;
import com.wear.util.WearUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/* compiled from: DownVideoUtil.java */
/* loaded from: classes4.dex */
public class fe3 {
    public static final String g = WearUtils.T("video").getAbsolutePath();
    public String a;
    public int b;
    public String c;
    public boolean d = false;
    public Handler e = new Handler(new a());
    public b f;

    /* compiled from: DownVideoUtil.java */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            b bVar;
            int i = message.what;
            if (i == 0) {
                fe3.this.b = ((Integer) message.obj).intValue();
                String str = "handleMessage: length:" + fe3.this.b;
                if (fe3.this.d) {
                    return false;
                }
                fe3 fe3Var = fe3.this;
                fe3Var.new c(fe3Var.a, fe3.this.b).start();
                return false;
            }
            if (i == 1) {
                b bVar2 = fe3.this.f;
                if (bVar2 == null) {
                    return false;
                }
                bVar2.b(ah4.e(R.string.file_notfound));
                return false;
            }
            if (i == 2) {
                b bVar3 = fe3.this.f;
                if (bVar3 == null) {
                    return false;
                }
                bVar3.b(ah4.e(R.string.net_connect_error_tip));
                return false;
            }
            if (i != 3) {
                if (i != 4 || (bVar = fe3.this.f) == null) {
                    return false;
                }
                bVar.c(fe3.g + "/" + fe3.this.c);
                return false;
            }
            long jLongValue = ((Long) message.obj).longValue();
            String str2 = "handleMessage: progress:" + jLongValue;
            b bVar4 = fe3.this.f;
            if (bVar4 == null) {
                return false;
            }
            bVar4.a(jLongValue);
            return false;
        }
    }

    /* compiled from: DownVideoUtil.java */
    public interface b {
        void a(long j);

        void b(String str);

        void c(String str);
    }

    /* compiled from: DownVideoUtil.java */
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
            throw new UnsupportedOperationException("Method not decompiled: dc.fe3.c.run():void");
        }
    }

    /* compiled from: DownVideoUtil.java */
    public class d extends Thread {
        public String a;

        public d(String str) {
            this.a = "";
            this.a = str;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws Throwable {
            fe3.this.j(this.a, fe3.g + "/" + fe3.this.c);
        }
    }

    public static File h(String str) {
        return new File(g, str);
    }

    public static final void i(Object obj) throws IOException {
        if (obj != null) {
            try {
                if (obj instanceof Closeable) {
                    ((Closeable) obj).close();
                } else if (obj instanceof Socket) {
                    ((Socket) obj).close();
                } else {
                    if (!(obj instanceof ServerSocket)) {
                        throw new IllegalArgumentException("Unknown object to close");
                    }
                    ((ServerSocket) obj).close();
                }
            } catch (IOException unused) {
            }
        }
    }

    public static void k(File file) {
        try {
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x00ab: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:35:0x00ab */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j(java.lang.String r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 == 0) goto L7
            return
        L7:
            r0 = 0
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            r2 = 1
            r1.setPriority(r2)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            java.net.URLConnection r1 = r1.openConnection()     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch: java.lang.Throwable -> L96 java.lang.Exception -> L98
            r3 = 5000(0x1388, float:7.006E-42)
            r1.setConnectTimeout(r3)     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> Laa
            r3 = 60000(0xea60, float:8.4078E-41)
            r1.setReadTimeout(r3)     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> Laa
            r1.setDoInput(r2)     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> Laa
            java.io.InputStream r3 = r1.getInputStream()     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> Laa
            java.io.File r4 = new java.io.File     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> Laa
            r4.<init>(r8)     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> Laa
            boolean r8 = r4.exists()     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> Laa
            if (r8 == 0) goto L3b
            r4.delete()     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> Laa
        L3b:
            r4.createNewFile()     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> Laa
            r8 = 0
            r4.setReadable(r2, r8)     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> Laa
            r4.setWritable(r2, r8)     // Catch: java.lang.Exception -> L94 java.lang.Throwable -> Laa
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L92 java.lang.Throwable -> Laa
            r0.<init>()     // Catch: java.lang.Exception -> L92 java.lang.Throwable -> Laa
            java.lang.String r2 = "downloadUrl "
            r0.append(r2)     // Catch: java.lang.Exception -> L92 java.lang.Throwable -> Laa
            r0.append(r7)     // Catch: java.lang.Exception -> L92 java.lang.Throwable -> Laa
            java.lang.String r7 = "\n save to "
            r0.append(r7)     // Catch: java.lang.Exception -> L92 java.lang.Throwable -> Laa
            r0.append(r4)     // Catch: java.lang.Exception -> L92 java.lang.Throwable -> Laa
            r0.toString()     // Catch: java.lang.Exception -> L92 java.lang.Throwable -> Laa
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch: java.lang.Exception -> L92 java.lang.Throwable -> Laa
            r7.<init>(r4)     // Catch: java.lang.Exception -> L92 java.lang.Throwable -> Laa
            r0 = 8192(0x2000, float:1.148E-41)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Exception -> L92 java.lang.Throwable -> Laa
        L66:
            int r2 = r3.read(r0)     // Catch: java.lang.Throwable -> L8a
            r5 = -1
            if (r2 == r5) goto L71
            r7.write(r0, r8, r2)     // Catch: java.lang.Throwable -> L8a
            goto L66
        L71:
            r7.flush()     // Catch: java.lang.Throwable -> L8a
            java.io.FileDescriptor r8 = r7.getFD()     // Catch: java.lang.Throwable -> L8a
            r8.sync()     // Catch: java.lang.Throwable -> L8a
            i(r7)     // Catch: java.lang.Exception -> L92 java.lang.Throwable -> Laa
            i(r3)     // Catch: java.lang.Exception -> L92 java.lang.Throwable -> Laa
            android.os.Handler r7 = r6.e     // Catch: java.lang.Exception -> L92 java.lang.Throwable -> Laa
            r8 = 4
            r7.sendEmptyMessage(r8)     // Catch: java.lang.Exception -> L92 java.lang.Throwable -> Laa
            if (r1 == 0) goto La9
            goto La6
        L8a:
            r8 = move-exception
            i(r7)     // Catch: java.lang.Exception -> L92 java.lang.Throwable -> Laa
            i(r3)     // Catch: java.lang.Exception -> L92 java.lang.Throwable -> Laa
            throw r8     // Catch: java.lang.Exception -> L92 java.lang.Throwable -> Laa
        L92:
            r0 = r4
            goto L99
        L94:
            goto L99
        L96:
            r7 = move-exception
            goto Lac
        L98:
            r1 = r0
        L99:
            if (r0 == 0) goto L9e
            r0.delete()     // Catch: java.lang.Throwable -> Laa
        L9e:
            android.os.Handler r7 = r6.e     // Catch: java.lang.Throwable -> Laa
            r8 = 2
            r7.sendEmptyMessage(r8)     // Catch: java.lang.Throwable -> Laa
            if (r1 == 0) goto La9
        La6:
            r1.disconnect()
        La9:
            return
        Laa:
            r7 = move-exception
            r0 = r1
        Lac:
            if (r0 == 0) goto Lb1
            r0.disconnect()
        Lb1:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.fe3.j(java.lang.String, java.lang.String):void");
    }

    public void l(File file) {
        File file2 = new File(g);
        if (!file2.exists()) {
            file2.mkdir();
        }
        file.renameTo(new File(file2, this.c));
    }

    public final void m(long j, long j2) {
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

    public void n(String str, String str2, Context context, boolean z, b bVar) {
        this.a = str;
        this.c = str2;
        this.f = bVar;
        this.d = false;
        this.e.removeCallbacksAndMessages(null);
        if (str == null || TextUtils.isEmpty(str)) {
            bVar.b(ah4.e(R.string.file_notfound));
        } else {
            new d(str).start();
        }
    }
}

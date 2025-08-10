package dc;

import android.text.TextUtils;
import com.wear.util.WearUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

/* compiled from: WebJsDownUtil.java */
/* loaded from: classes4.dex */
public class fl3 {
    public static final String a = WearUtils.T("downloads").getAbsolutePath();
    public static String b = "https://test-front.lovense.com/surfease-js/interactive-video/remote_pattern.js";
    public static String c = "https://surfease.lovense-api.com/UploadFiles/surfease/interactive-video/remote_pattern.js";

    /* compiled from: WebJsDownUtil.java */
    public class a extends Thread {
        public String a;
        public String b;

        public a(String str, String str2) {
            this.a = "";
            this.b = "";
            this.a = str;
            this.b = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws Throwable {
            fl3.this.b(this.a, fl3.a + "/" + this.b);
        }
    }

    public static final void a(Object obj) throws IOException {
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

    public void b(String str, String str2) throws Throwable {
        HttpURLConnection httpURLConnection;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str3 = "downloadJs: " + str + "    fileSavePath:" + str2;
        HttpURLConnection httpURLConnection2 = null;
        file = null;
        File file = null;
        try {
            Thread.currentThread().setPriority(1);
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                try {
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.setReadTimeout(60000);
                    httpURLConnection.setDoInput(true);
                    InputStream inputStream = httpURLConnection.getInputStream();
                    File file2 = new File(str2);
                    if (file2.exists()) {
                        String str4 = "downloadJs:file exists to delete " + file2.delete();
                    }
                    file2.createNewFile();
                    file2.setReadable(true, false);
                    file2.setWritable(true, false);
                    try {
                        String str5 = "downloadUrl " + str + "\n save to " + file2;
                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                        byte[] bArr = new byte[8192];
                        while (true) {
                            try {
                                int i = inputStream.read(bArr);
                                if (i == -1) {
                                    break;
                                } else {
                                    fileOutputStream.write(bArr, 0, i);
                                }
                            } catch (Throwable th) {
                                a(fileOutputStream);
                                a(inputStream);
                                throw th;
                            }
                        }
                        fileOutputStream.flush();
                        fileOutputStream.getFD().sync();
                        a(fileOutputStream);
                        a(inputStream);
                        String str6 = "download complete url=" + str + ", fileSize= " + file2.length();
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (!str.endsWith(".js")) {
                            return;
                        }
                    } catch (Exception e) {
                        e = e;
                        file = file2;
                        ye3.d("S0005", str + "#" + e.toString());
                        if (file != null) {
                            file.delete();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (!str.endsWith(".js")) {
                            return;
                        }
                        yk3.c().k();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    if (str.endsWith(".js")) {
                        yk3.c().k();
                    }
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            httpURLConnection = null;
        } catch (Throwable th3) {
            th = th3;
        }
        yk3.c().k();
    }

    public void c() {
        if (WearUtils.v) {
            new a(b, "vibemate_pattern.js").start();
        } else {
            new a(c, "vibemate_pattern.js").start();
        }
    }
}

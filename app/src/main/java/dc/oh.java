package dc;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.HttpException;
import com.google.common.net.HttpHeaders;
import dc.ih;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* compiled from: HttpUrlFetcher.java */
/* loaded from: classes.dex */
public class oh implements ih<InputStream> {

    @VisibleForTesting
    public static final b g = new a();
    public final ek a;
    public final int b;
    public final b c;
    public HttpURLConnection d;
    public InputStream e;
    public volatile boolean f;

    /* compiled from: HttpUrlFetcher.java */
    public static class a implements b {
        @Override // dc.oh.b
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* compiled from: HttpUrlFetcher.java */
    public interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public oh(ek ekVar, int i) {
        this(ekVar, i, g);
    }

    public static boolean e(int i) {
        return i / 100 == 2;
    }

    public static boolean f(int i) {
        return i / 100 == 3;
    }

    @Override // dc.ih
    public void a() throws IOException {
        InputStream inputStream = this.e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.d = null;
    }

    public final InputStream b(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.e = op.e(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                String str = "Got non empty content encoding: " + httpURLConnection.getContentEncoding();
            }
            this.e = httpURLConnection.getInputStream();
        }
        return this.e;
    }

    @Override // dc.ih
    @NonNull
    public sg c() {
        return sg.REMOTE;
    }

    @Override // dc.ih
    public void cancel() {
        this.f = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // dc.ih
    public void d(@NonNull of ofVar, @NonNull ih.a<? super InputStream> aVar) {
        StringBuilder sb;
        String str = "HttpUrlFetcher";
        long jB = rp.b();
        try {
            try {
                aVar.e(g(this.a.h(), 0, null, this.a.e()));
                str = str;
            } catch (IOException e) {
                Log.isLoggable("HttpUrlFetcher", 3);
                aVar.b(e);
                str = str;
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    sb = new StringBuilder();
                }
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                double dA = rp.a(jB);
                sb.append(dA);
                sb.toString();
                str = dA;
            }
        } catch (Throwable th) {
            if (Log.isLoggable(str, 2)) {
                String str2 = "Finished http url fetcher fetch in " + rp.a(jB);
            }
            throw th;
        }
    }

    public final InputStream g(URL url, int i, URL url2, Map<String, String> map) throws IOException {
        if (i >= 5) {
            throw new HttpException("Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new HttpException("In re-direct loop");
                }
            } catch (URISyntaxException unused) {
            }
        }
        this.d = this.c.a(url);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            this.d.addRequestProperty(entry.getKey(), entry.getValue());
        }
        this.d.setConnectTimeout(this.b);
        this.d.setReadTimeout(this.b);
        this.d.setUseCaches(false);
        this.d.setDoInput(true);
        this.d.setInstanceFollowRedirects(false);
        this.d.connect();
        this.e = this.d.getInputStream();
        if (this.f) {
            return null;
        }
        int responseCode = this.d.getResponseCode();
        if (e(responseCode)) {
            return b(this.d);
        }
        if (!f(responseCode)) {
            if (responseCode == -1) {
                throw new HttpException(responseCode);
            }
            throw new HttpException(this.d.getResponseMessage(), responseCode);
        }
        String headerField = this.d.getHeaderField(HttpHeaders.LOCATION);
        if (TextUtils.isEmpty(headerField)) {
            throw new HttpException("Received empty or null redirect url");
        }
        URL url3 = new URL(url, headerField);
        a();
        return g(url3, i + 1, url, map);
    }

    @Override // dc.ih
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @VisibleForTesting
    public oh(ek ekVar, int i, b bVar) {
        this.a = ekVar;
        this.b = i;
        this.c = bVar;
    }
}

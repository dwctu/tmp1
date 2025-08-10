package dc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.broadcom.bt.util.io.IOUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* compiled from: DefaultLottieFetchResult.java */
/* loaded from: classes.dex */
public class db implements gb {

    @NonNull
    public final HttpURLConnection a;

    public db(@NonNull HttpURLConnection httpURLConnection) {
        this.a = httpURLConnection;
    }

    public final String b(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        sb.append(line);
                        sb.append('\n');
                    } else {
                        try {
                            break;
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception e) {
                    throw e;
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb.toString();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.disconnect();
    }

    @Override // dc.gb
    @Nullable
    public String error() {
        try {
            if (isSuccessful()) {
                return null;
            }
            return "Unable to fetch " + this.a.getURL() + ". Failed with " + this.a.getResponseCode() + IOUtils.LINE_SEPARATOR_UNIX + b(this.a);
        } catch (IOException e) {
            dd.d("get error failed ", e);
            return e.getMessage();
        }
    }

    @Override // dc.gb
    public boolean isSuccessful() {
        try {
            return this.a.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // dc.gb
    @Nullable
    public String r() {
        return this.a.getContentType();
    }

    @Override // dc.gb
    @NonNull
    public InputStream u() throws IOException {
        return this.a.getInputStream();
    }
}

package dc;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;
import no.nordicsemi.android.dfu.DfuBaseService;

/* compiled from: NetworkFetcher.java */
/* loaded from: classes.dex */
public class kb {

    @NonNull
    public final jb a;

    @NonNull
    public final ib b;

    public kb(@NonNull jb jbVar, @NonNull ib ibVar) {
        this.a = jbVar;
        this.b = ibVar;
    }

    @Nullable
    @WorkerThread
    public final f7 a(@NonNull String str, @Nullable String str2) {
        Pair<fb, InputStream> pairA;
        if (str2 == null || (pairA = this.a.a(str)) == null) {
            return null;
        }
        fb fbVar = (fb) pairA.first;
        InputStream inputStream = (InputStream) pairA.second;
        n7<f7> n7VarS = fbVar == fb.ZIP ? g7.s(new ZipInputStream(inputStream), str) : g7.i(inputStream, str);
        if (n7VarS.b() != null) {
            return n7VarS.b();
        }
        return null;
    }

    @NonNull
    @WorkerThread
    public final n7<f7> b(@NonNull String str, @Nullable String str2) throws IOException {
        dd.a("Fetching " + str);
        Closeable closeable = null;
        try {
            try {
                gb gbVarA = this.b.a(str);
                if (!gbVarA.isSuccessful()) {
                    n7<f7> n7Var = new n7<>(new IllegalArgumentException(gbVarA.error()));
                    if (gbVarA != null) {
                        try {
                            gbVarA.close();
                        } catch (IOException e) {
                            dd.d("LottieFetchResult close failed ", e);
                        }
                    }
                    return n7Var;
                }
                n7<f7> n7VarD = d(str, gbVarA.u(), gbVarA.r(), str2);
                StringBuilder sb = new StringBuilder();
                sb.append("Completed fetch from network. Success: ");
                sb.append(n7VarD.b() != null);
                dd.a(sb.toString());
                if (gbVarA != null) {
                    try {
                        gbVarA.close();
                    } catch (IOException e2) {
                        dd.d("LottieFetchResult close failed ", e2);
                    }
                }
                return n7VarD;
            } catch (Exception e3) {
                n7<f7> n7Var2 = new n7<>(e3);
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException e4) {
                        dd.d("LottieFetchResult close failed ", e4);
                    }
                }
                return n7Var2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException e5) {
                    dd.d("LottieFetchResult close failed ", e5);
                }
            }
            throw th;
        }
    }

    @NonNull
    @WorkerThread
    public n7<f7> c(@NonNull String str, @Nullable String str2) {
        f7 f7VarA = a(str, str2);
        if (f7VarA != null) {
            return new n7<>(f7VarA);
        }
        dd.a("Animation for " + str + " not found in cache. Fetching from network.");
        return b(str, str2);
    }

    @NonNull
    public final n7<f7> d(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2, @Nullable String str3) throws IOException {
        fb fbVar;
        n7<f7> n7VarF;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains(DfuBaseService.MIME_TYPE_ZIP) || str.split("\\?")[0].endsWith(".lottie")) {
            dd.a("Handling zip response.");
            fbVar = fb.ZIP;
            n7VarF = f(str, inputStream, str3);
        } else {
            dd.a("Received json response.");
            fbVar = fb.JSON;
            n7VarF = e(str, inputStream, str3);
        }
        if (str3 != null && n7VarF.b() != null) {
            this.a.e(str, fbVar);
        }
        return n7VarF;
    }

    @NonNull
    public final n7<f7> e(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        return str2 == null ? g7.i(inputStream, null) : g7.i(new FileInputStream(new File(this.a.f(str, inputStream, fb.JSON).getAbsolutePath())), str);
    }

    @NonNull
    public final n7<f7> f(@NonNull String str, @NonNull InputStream inputStream, @Nullable String str2) throws IOException {
        return str2 == null ? g7.s(new ZipInputStream(inputStream), null) : g7.s(new ZipInputStream(new FileInputStream(this.a.f(str, inputStream, fb.ZIP))), str);
    }
}

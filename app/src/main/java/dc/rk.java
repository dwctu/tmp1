package dc;

import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamEncoder.java */
/* loaded from: classes.dex */
public class rk implements vg<InputStream> {
    public final zi a;

    public rk(zi ziVar) {
        this.a = ziVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // dc.vg
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull InputStream inputStream, @NonNull File file, @NonNull ah ahVar) throws Throwable {
        byte[] bArr = (byte[]) this.a.c(65536, byte[].class);
        boolean z = false;
        ?? r1 = 0;
        r1 = 0;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    while (true) {
                        try {
                            int i = inputStream.read(bArr);
                            r1 = -1;
                            if (i == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, i);
                        } catch (IOException unused) {
                            r1 = fileOutputStream;
                            Log.isLoggable("StreamEncoder", 3);
                            if (r1 != 0) {
                                r1.close();
                                r1 = r1;
                            }
                            this.a.put(bArr);
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            r1 = fileOutputStream;
                            if (r1 != 0) {
                                try {
                                    r1.close();
                                } catch (IOException unused2) {
                                }
                            }
                            this.a.put(bArr);
                            throw th;
                        }
                    }
                    fileOutputStream.close();
                    z = true;
                    fileOutputStream.close();
                } catch (IOException unused3) {
                }
            } catch (IOException unused4) {
            }
            this.a.put(bArr);
            return z;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}

package dc;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ThumbnailStreamOpener.java */
/* loaded from: classes.dex */
public class yh {
    public static final uh f = new uh();
    public final uh a;
    public final xh b;
    public final zi c;
    public final ContentResolver d;
    public final List<ImageHeaderParser> e;

    public yh(List<ImageHeaderParser> list, xh xhVar, zi ziVar, ContentResolver contentResolver) {
        this(list, f, xhVar, ziVar, contentResolver);
    }

    public int a(Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = this.d.openInputStream(uri);
                int iB = wg.b(this.e, inputStreamOpenInputStream, this.c);
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return iB;
            } catch (Throwable th) {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException | NullPointerException unused3) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                String str = "Failed to open uri: " + uri;
            }
            if (inputStreamOpenInputStream == null) {
                return -1;
            }
            try {
                inputStreamOpenInputStream.close();
                return -1;
            } catch (IOException unused4) {
                return -1;
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0043: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:24:0x0043 */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0046  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String b(@androidx.annotation.NonNull android.net.Uri r5) throws java.lang.Throwable {
        /*
            r4 = this;
            r0 = 0
            dc.xh r1 = r4.b     // Catch: java.lang.Throwable -> L20 java.lang.SecurityException -> L22
            android.database.Cursor r1 = r1.a(r5)     // Catch: java.lang.Throwable -> L20 java.lang.SecurityException -> L22
            if (r1 == 0) goto L1a
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.SecurityException -> L23 java.lang.Throwable -> L42
            if (r2 == 0) goto L1a
            r2 = 0
            java.lang.String r5 = r1.getString(r2)     // Catch: java.lang.SecurityException -> L23 java.lang.Throwable -> L42
            if (r1 == 0) goto L19
            r1.close()
        L19:
            return r5
        L1a:
            if (r1 == 0) goto L1f
            r1.close()
        L1f:
            return r0
        L20:
            r5 = move-exception
            goto L44
        L22:
            r1 = r0
        L23:
            java.lang.String r2 = "ThumbStreamOpener"
            r3 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r3)     // Catch: java.lang.Throwable -> L42
            if (r2 == 0) goto L3c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L42
            r2.<init>()     // Catch: java.lang.Throwable -> L42
            java.lang.String r3 = "Failed to query for thumbnail for Uri: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L42
            r2.append(r5)     // Catch: java.lang.Throwable -> L42
            r2.toString()     // Catch: java.lang.Throwable -> L42
        L3c:
            if (r1 == 0) goto L41
            r1.close()
        L41:
            return r0
        L42:
            r5 = move-exception
            r0 = r1
        L44:
            if (r0 == 0) goto L49
            r0.close()
        L49:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.yh.b(android.net.Uri):java.lang.String");
    }

    public final boolean c(File file) {
        return this.a.a(file) && 0 < this.a.c(file);
    }

    public InputStream d(Uri uri) throws Throwable {
        String strB = b(uri);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        File fileB = this.a.b(strB);
        if (!c(fileB)) {
            return null;
        }
        Uri uriFromFile = Uri.fromFile(fileB);
        try {
            return this.d.openInputStream(uriFromFile);
        } catch (NullPointerException e) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + uriFromFile).initCause(e));
        }
    }

    public yh(List<ImageHeaderParser> list, uh uhVar, xh xhVar, zi ziVar, ContentResolver contentResolver) {
        this.a = uhVar;
        this.b = xhVar;
        this.c = ziVar;
        this.d = contentResolver;
        this.e = list;
    }
}

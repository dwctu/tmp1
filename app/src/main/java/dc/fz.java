package dc;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.zip.DataFormatException;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.compress.packet.Compressed;

/* compiled from: ZipHelper.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxhttp/utils/ZipHelper;", "", "()V", "Companion", "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class fz {

    @NotNull
    public static final a a = new a(null);

    /* compiled from: ZipHelper.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\nJ\u001e\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0007J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bJ\u001c\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\nH\u0007¨\u0006\u0014"}, d2 = {"Lcom/component/dxhttp/utils/ZipHelper$Companion;", "", "()V", "closeQuietly", "", "closeable", "Ljava/io/Closeable;", "compressForGzip", "", TypedValues.Custom.S_STRING, "", "compressForZlib", "bytesToCompress", "stringToCompress", "decompressForGzip", Compressed.ELEMENT, "charsetName", "decompressForZlib", "bytesToDecompress", "decompressToStringForZlib", "dxHttp_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Closeable closeable) throws IOException {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception unused) {
                }
            }
        }

        @JvmStatic
        @JvmOverloads
        @Nullable
        public final String b(@NotNull byte[] compressed, @Nullable String str) throws Throwable {
            ByteArrayInputStream byteArrayInputStream;
            GZIPInputStream gZIPInputStream;
            Intrinsics.checkNotNullParameter(compressed, "compressed");
            int length = compressed.length;
            Closeable closeable = null;
            try {
                byteArrayInputStream = new ByteArrayInputStream(compressed);
            } catch (IOException e) {
                e = e;
                gZIPInputStream = null;
                byteArrayInputStream = null;
            } catch (Throwable th) {
                th = th;
                byteArrayInputStream = null;
            }
            try {
                gZIPInputStream = new GZIPInputStream(byteArrayInputStream, length);
            } catch (IOException e2) {
                e = e2;
                gZIPInputStream = null;
            } catch (Throwable th2) {
                th = th2;
                a(closeable);
                a(byteArrayInputStream);
                throw th;
            }
            try {
                try {
                    StringBuilder sb = new StringBuilder();
                    byte[] bArr = new byte[length];
                    Ref.IntRef intRef = new Ref.IntRef();
                    while (true) {
                        int i = gZIPInputStream.read(bArr);
                        intRef.element = i;
                        if (i == -1) {
                            String string = sb.toString();
                            a(gZIPInputStream);
                            a(byteArrayInputStream);
                            return string;
                        }
                        Charset charsetForName = Charset.forName(str);
                        Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
                        sb.append(new String(bArr, 0, i, charsetForName));
                    }
                } catch (Throwable th3) {
                    th = th3;
                    closeable = gZIPInputStream;
                    a(closeable);
                    a(byteArrayInputStream);
                    throw th;
                }
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                a(gZIPInputStream);
                a(byteArrayInputStream);
                return null;
            }
        }

        @NotNull
        public final byte[] c(@NotNull byte[] bytesToDecompress) throws DataFormatException {
            Intrinsics.checkNotNullParameter(bytesToDecompress, "bytesToDecompress");
            int i = 0;
            byte[] bArr = new byte[0];
            Inflater inflater = new Inflater();
            int length = bytesToDecompress.length;
            inflater.setInput(bytesToDecompress, 0, length);
            ArrayList arrayList = new ArrayList();
            while (!inflater.needsInput()) {
                try {
                    byte[] bArr2 = new byte[length];
                    int iInflate = inflater.inflate(bArr2);
                    for (int i2 = 0; i2 < iInflate; i2++) {
                        arrayList.add(Byte.valueOf(bArr2[i2]));
                    }
                } catch (DataFormatException e) {
                    e.printStackTrace();
                }
            }
            int size = arrayList.size();
            bArr = new byte[size];
            while (i < size) {
                int i3 = i + 1;
                bArr[i] = ((Number) arrayList.get(i)).byteValue();
                i = i3;
            }
            inflater.end();
            return bArr;
        }

        @JvmStatic
        @JvmOverloads
        @Nullable
        public final String d(@NotNull byte[] bytesToDecompress, @NotNull String charsetName) throws DataFormatException {
            Intrinsics.checkNotNullParameter(bytesToDecompress, "bytesToDecompress");
            Intrinsics.checkNotNullParameter(charsetName, "charsetName");
            byte[] bArrC = c(bytesToDecompress);
            try {
                int length = bArrC.length;
                Charset charsetForName = Charset.forName(charsetName);
                Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
                return new String(bArrC, 0, length, charsetForName);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}

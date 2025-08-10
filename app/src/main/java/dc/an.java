package dc;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: StreamGifDecoder.java */
/* loaded from: classes.dex */
public class an implements ch<InputStream, GifDrawable> {
    public final List<ImageHeaderParser> a;
    public final ch<ByteBuffer, GifDrawable> b;
    public final zi c;

    public an(List<ImageHeaderParser> list, ch<ByteBuffer, GifDrawable> chVar, zi ziVar) {
        this.a = list;
        this.b = chVar;
        this.c = ziVar;
    }

    public static byte[] e(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (IOException unused) {
            Log.isLoggable("StreamGifDecoder", 5);
            return null;
        }
    }

    @Override // dc.ch
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public ti<GifDrawable> b(@NonNull InputStream inputStream, int i, int i2, @NonNull ah ahVar) throws IOException {
        byte[] bArrE = e(inputStream);
        if (bArrE == null) {
            return null;
        }
        return this.b.b(ByteBuffer.wrap(bArrE), i, i2, ahVar);
    }

    @Override // dc.ch
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull InputStream inputStream, @NonNull ah ahVar) throws IOException {
        return !((Boolean) ahVar.c(zm.b)).booleanValue() && wg.e(this.a, inputStream, this.c) == ImageHeaderParser.ImageType.GIF;
    }
}

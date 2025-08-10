package dc;

import android.media.MediaExtractor;
import org.jetbrains.annotations.NotNull;

/* compiled from: IFileContainer.kt */
/* loaded from: classes3.dex */
public interface ch1 {
    void a();

    void b();

    void c(@NotNull MediaExtractor mediaExtractor);

    void close();

    int read(@NotNull byte[] bArr, int i, int i2);

    void skip(long j);
}

package dc;

import android.media.MediaExtractor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: FileContainer.kt */
/* loaded from: classes3.dex */
public final class bh1 implements ch1 {
    public RandomAccessFile a;
    public final File b;

    public bh1(@NotNull File file) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(file, "file");
        this.b = file;
        xh1.c.d("AnimPlayer.FileContainer", "FileContainer init");
        if (file.exists() && file.isFile() && file.canRead()) {
            return;
        }
        throw new FileNotFoundException("Unable to read " + file);
    }

    @Override // dc.ch1
    public void a() {
        this.a = new RandomAccessFile(this.b, StreamManagement.AckRequest.ELEMENT);
    }

    @Override // dc.ch1
    public void b() throws IOException {
        RandomAccessFile randomAccessFile = this.a;
        if (randomAccessFile != null) {
            randomAccessFile.close();
        }
    }

    @Override // dc.ch1
    public void c(@NotNull MediaExtractor extractor) throws IOException {
        Intrinsics.checkParameterIsNotNull(extractor, "extractor");
        extractor.setDataSource(this.b.toString());
    }

    @Override // dc.ch1
    public void close() {
    }

    @Override // dc.ch1
    public int read(@NotNull byte[] b, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(b, "b");
        RandomAccessFile randomAccessFile = this.a;
        if (randomAccessFile != null) {
            return randomAccessFile.read(b, i, i2);
        }
        return -1;
    }

    @Override // dc.ch1
    public void skip(long j) throws IOException {
        RandomAccessFile randomAccessFile = this.a;
        if (randomAccessFile != null) {
            randomAccessFile.skipBytes((int) j);
        }
    }
}

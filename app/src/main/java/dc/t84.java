package dc;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* compiled from: InflaterInputStream.java */
/* loaded from: classes5.dex */
public class t84 extends s84 {
    public Inflater c;
    public byte[] d;
    public byte[] e;
    public int f;

    public t84(r84<?> r84Var, int i) {
        super(r84Var);
        this.e = new byte[1];
        this.c = new Inflater(true);
        this.d = new byte[i];
    }

    @Override // dc.s84
    public void b(InputStream inputStream, int i) throws IOException {
        Inflater inflater = this.c;
        if (inflater != null) {
            inflater.end();
            this.c = null;
        }
        super.b(inputStream, i);
    }

    @Override // dc.s84, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Inflater inflater = this.c;
        if (inflater != null) {
            inflater.end();
        }
        super.close();
    }

    @Override // dc.s84
    public int f(PushbackInputStream pushbackInputStream) throws IOException {
        int remaining = this.c.getRemaining();
        if (remaining > 0) {
            pushbackInputStream.unread(e(), this.f - remaining, remaining);
        }
        return remaining;
    }

    public final void j() throws IOException {
        byte[] bArr = this.d;
        int i = super.read(bArr, 0, bArr.length);
        this.f = i;
        if (i == -1) {
            throw new EOFException("Unexpected end of input stream");
        }
        this.c.setInput(this.d, 0, i);
    }

    @Override // dc.s84, java.io.InputStream
    public int read() throws IOException {
        if (read(this.e) == -1) {
            return -1;
        }
        return this.e[0];
    }

    @Override // dc.s84, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // dc.s84, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws DataFormatException, IOException {
        while (true) {
            try {
                int iInflate = this.c.inflate(bArr, i, i2);
                if (iInflate != 0) {
                    return iInflate;
                }
                if (!this.c.finished() && !this.c.needsDictionary()) {
                    if (this.c.needsInput()) {
                        j();
                    }
                }
                return -1;
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        }
    }
}

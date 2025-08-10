package okhttp3.internal.cache;

import dc.ee4;
import dc.nd4;
import dc.rd4;
import java.io.IOException;

/* loaded from: classes5.dex */
public class FaultHidingSink extends rd4 {
    private boolean hasErrors;

    public FaultHidingSink(ee4 ee4Var) {
        super(ee4Var);
    }

    @Override // dc.rd4, dc.ee4, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (IOException e) {
            this.hasErrors = true;
            onException(e);
        }
    }

    @Override // dc.rd4, dc.ee4, java.io.Flushable
    public void flush() throws IOException {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e) {
            this.hasErrors = true;
            onException(e);
        }
    }

    public void onException(IOException iOException) {
    }

    @Override // dc.rd4, dc.ee4
    public void write(nd4 nd4Var, long j) throws IOException {
        if (this.hasErrors) {
            nd4Var.skip(j);
            return;
        }
        try {
            super.write(nd4Var, j);
        } catch (IOException e) {
            this.hasErrors = true;
            onException(e);
        }
    }
}

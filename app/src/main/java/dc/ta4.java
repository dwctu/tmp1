package dc;

import android.database.CharArrayBuffer;
import net.sqlcipher.CursorWindow;
import net.sqlcipher.StaleDataException;

/* compiled from: AbstractWindowedCursor.java */
/* loaded from: classes5.dex */
public abstract class ta4 extends sa4 {
    public CursorWindow n;

    @Override // dc.sa4
    public void b() {
        super.b();
        if (this.n == null) {
            throw new StaleDataException("Access closed cursor");
        }
    }

    @Override // dc.sa4, android.database.Cursor
    public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
        b();
        synchronized (this.d) {
            if (m(i)) {
                super.copyStringToBuffer(i, charArrayBuffer);
            }
        }
        this.n.copyStringToBuffer(this.f, i, charArrayBuffer);
    }

    @Override // dc.sa4, android.database.Cursor
    public byte[] getBlob(int i) {
        b();
        synchronized (this.d) {
            if (!m(i)) {
                return this.n.getBlob(this.f, i);
            }
            return (byte[]) f(i);
        }
    }

    @Override // android.database.Cursor
    public double getDouble(int i) {
        b();
        synchronized (this.d) {
            if (!m(i)) {
                return this.n.getDouble(this.f, i);
            }
            return ((Number) f(i)).doubleValue();
        }
    }

    @Override // android.database.Cursor
    public float getFloat(int i) {
        b();
        synchronized (this.d) {
            if (!m(i)) {
                return this.n.getFloat(this.f, i);
            }
            return ((Number) f(i)).floatValue();
        }
    }

    @Override // android.database.Cursor
    public int getInt(int i) {
        b();
        synchronized (this.d) {
            if (!m(i)) {
                return this.n.getInt(this.f, i);
            }
            return ((Number) f(i)).intValue();
        }
    }

    @Override // dc.sa4, android.database.Cursor
    public long getLong(int i) {
        b();
        synchronized (this.d) {
            if (!m(i)) {
                return this.n.getLong(this.f, i);
            }
            return ((Number) f(i)).longValue();
        }
    }

    @Override // android.database.Cursor
    public short getShort(int i) {
        b();
        synchronized (this.d) {
            if (!m(i)) {
                return this.n.getShort(this.f, i);
            }
            return ((Number) f(i)).shortValue();
        }
    }

    @Override // dc.sa4, android.database.Cursor
    public String getString(int i) {
        b();
        synchronized (this.d) {
            if (!m(i)) {
                return this.n.getString(this.f, i);
            }
            return (String) f(i);
        }
    }

    @Override // android.database.Cursor, dc.va4
    public int getType(int i) {
        b();
        return this.n.getType(this.f, i);
    }

    @Override // android.database.Cursor
    public boolean isNull(int i) {
        b();
        synchronized (this.d) {
            if (m(i)) {
                return f(i) == null;
            }
            return this.n.isNull(this.f, i);
        }
    }

    @Override // dc.sa4, android.database.CrossProcessCursor
    /* renamed from: j */
    public CursorWindow getWindow() {
        return this.n;
    }
}

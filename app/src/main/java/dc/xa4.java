package dc;

import android.database.CursorWrapper;

/* compiled from: CursorWrapper.java */
/* loaded from: classes5.dex */
public class xa4 extends CursorWrapper implements va4 {
    public final va4 a;

    public xa4(va4 va4Var) {
        super(va4Var);
        this.a = va4Var;
    }

    @Override // android.database.CursorWrapper
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public va4 getWrappedCursor() {
        return this.a;
    }

    @Override // android.database.CursorWrapper, android.database.Cursor, dc.va4
    public int getType(int i) {
        return this.a.getType(i);
    }
}

package dc;

import android.database.CrossProcessCursor;
import android.database.CursorWindow;

/* compiled from: CrossProcessCursorWrapper.java */
/* loaded from: classes5.dex */
public class ua4 extends xa4 implements CrossProcessCursor {
    public ua4(va4 va4Var) {
        super(va4Var);
    }

    @Override // android.database.CrossProcessCursor
    public void fillWindow(int i, CursorWindow cursorWindow) {
        za4.b(this, i, cursorWindow);
    }

    @Override // android.database.CrossProcessCursor
    public CursorWindow getWindow() {
        return null;
    }

    @Override // android.database.CrossProcessCursor
    public boolean onMove(int i, int i2) {
        return true;
    }
}

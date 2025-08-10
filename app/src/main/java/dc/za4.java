package dc;

import android.database.CursorWindow;
import net.sqlcipher.database.SQLiteProgram;

/* compiled from: DatabaseUtils.java */
/* loaded from: classes5.dex */
public class za4 {
    public static void a(SQLiteProgram sQLiteProgram, int i, Object obj) {
        if (obj == null) {
            sQLiteProgram.bindNull(i);
            return;
        }
        if ((obj instanceof Double) || (obj instanceof Float)) {
            sQLiteProgram.bindDouble(i, ((Number) obj).doubleValue());
            return;
        }
        if (obj instanceof Number) {
            sQLiteProgram.bindLong(i, ((Number) obj).longValue());
            return;
        }
        if (obj instanceof Boolean) {
            if (((Boolean) obj).booleanValue()) {
                sQLiteProgram.bindLong(i, 1L);
                return;
            } else {
                sQLiteProgram.bindLong(i, 0L);
                return;
            }
        }
        if (obj instanceof byte[]) {
            sQLiteProgram.bindBlob(i, (byte[]) obj);
        } else {
            sQLiteProgram.bindString(i, obj.toString());
        }
    }

    public static void b(va4 va4Var, int i, CursorWindow cursorWindow) {
        boolean zPutNull;
        if (i < 0 || i >= va4Var.getCount()) {
            return;
        }
        int position = va4Var.getPosition();
        int columnCount = va4Var.getColumnCount();
        cursorWindow.clear();
        cursorWindow.setStartPosition(i);
        cursorWindow.setNumColumns(columnCount);
        if (va4Var.moveToPosition(i)) {
            while (cursorWindow.allocRow()) {
                int i2 = 0;
                while (true) {
                    if (i2 >= columnCount) {
                        break;
                    }
                    int type = va4Var.getType(i2);
                    if (type == 0) {
                        zPutNull = cursorWindow.putNull(i, i2);
                    } else if (type == 1) {
                        zPutNull = cursorWindow.putLong(va4Var.getLong(i2), i, i2);
                    } else if (type == 2) {
                        zPutNull = cursorWindow.putDouble(va4Var.getDouble(i2), i, i2);
                    } else if (type != 4) {
                        String string = va4Var.getString(i2);
                        zPutNull = string != null ? cursorWindow.putString(string, i, i2) : cursorWindow.putNull(i, i2);
                    } else {
                        byte[] blob = va4Var.getBlob(i2);
                        zPutNull = blob != null ? cursorWindow.putBlob(blob, i, i2) : cursorWindow.putNull(i, i2);
                    }
                    if (!zPutNull) {
                        cursorWindow.freeLastRow();
                        break;
                    }
                    i2++;
                }
                i++;
                if (!va4Var.moveToNext()) {
                    break;
                }
            }
        }
        va4Var.moveToPosition(position);
    }
}

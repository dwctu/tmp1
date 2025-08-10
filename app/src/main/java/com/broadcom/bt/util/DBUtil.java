package com.broadcom.bt.util;

import android.database.Cursor;

/* loaded from: classes.dex */
public class DBUtil {
    public static final String TAG = "DBUtil";

    public static StringBuilder appendSelection(StringBuilder sb, String str, String str2, String str3) {
        if (sb != null) {
            if (sb.length() > 0) {
                sb.append(" AND ");
            }
            sb.append("(");
            sb.append(str);
            sb.append(" ");
            sb.append(str2);
            sb.append(" ");
            sb.append(str3);
            sb.append(" ");
            sb.append(")");
        }
        return sb;
    }

    public static boolean getBooleanFromInt(Cursor cursor, int i, boolean z) {
        try {
            return 1 == cursor.getInt(i);
        } catch (Exception unused) {
            String str = "Unable to get boolean value from col " + i;
            return z;
        }
    }

    public static int getInt(Cursor cursor, int i, int i2) {
        try {
            return cursor.getInt(i);
        } catch (Exception unused) {
            String str = "Unable to get int value from col " + i;
            return i2;
        }
    }

    public static long getLong(Cursor cursor, int i, long j) {
        try {
            return cursor.getLong(i);
        } catch (Exception unused) {
            String str = "Unable to get long value from col " + i;
            return j;
        }
    }

    public static Cursor getNonEmptyCursorOrClose(Cursor cursor) {
        if (cursor == null || cursor.moveToFirst()) {
            return cursor;
        }
        safeClose(cursor);
        return null;
    }

    public static void safeClose(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception unused) {
            }
        }
    }

    public static boolean safeMoveToFirst(Cursor cursor) {
        return cursor != null && cursor.moveToFirst();
    }

    public static StringBuilder appendSelection(StringBuilder sb, String str) {
        if (sb != null) {
            if (sb.length() > 0) {
                sb.append(" AND ");
            }
            sb.append(str);
        }
        return sb;
    }
}

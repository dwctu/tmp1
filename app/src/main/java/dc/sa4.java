package dc;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObservable;
import android.database.ContentObserver;
import android.database.CrossProcessCursor;
import android.database.CursorWindow;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import net.sqlcipher.CursorIndexOutOfBoundsException;

/* compiled from: AbstractCursor.java */
/* loaded from: classes5.dex */
public abstract class sa4 implements CrossProcessCursor, va4 {
    public ContentResolver h;
    public Uri j;
    public ContentObserver k;
    public boolean m;
    public DataSetObservable a = new DataSetObservable();
    public ContentObservable b = new ContentObservable();
    public Bundle c = Bundle.EMPTY;
    public boolean i = false;
    public final Object l = new Object();
    public int f = -1;
    public int e = -1;
    public Long g = null;
    public HashMap<Long, Map<String, Object>> d = new HashMap<>();

    /* compiled from: AbstractCursor.java */
    public static class a extends ContentObserver {
        public WeakReference<sa4> a;

        public a(sa4 sa4Var) {
            super(null);
            this.a = new WeakReference<>(sa4Var);
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return false;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            sa4 sa4Var = this.a.get();
            if (sa4Var != null) {
                sa4Var.q(false);
            }
        }
    }

    public void b() {
        if (-1 == this.f || getCount() == this.f) {
            throw new CursorIndexOutOfBoundsException(this.f, getCount());
        }
    }

    @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.i = true;
        this.b.unregisterAll();
        e();
    }

    @Override // android.database.Cursor
    public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
        String string = getString(i);
        if (string == null) {
            charArrayBuffer.sizeCopied = 0;
            return;
        }
        char[] cArr = charArrayBuffer.data;
        if (cArr == null || cArr.length < string.length()) {
            charArrayBuffer.data = string.toCharArray();
        } else {
            string.getChars(0, string.length(), cArr, 0);
        }
        charArrayBuffer.sizeCopied = string.length();
    }

    @Override // android.database.Cursor
    public void deactivate() {
        e();
    }

    public void e() {
        ContentObserver contentObserver = this.k;
        if (contentObserver != null) {
            this.h.unregisterContentObserver(contentObserver);
            this.m = false;
        }
        this.a.notifyInvalidated();
    }

    public Object f(int i) {
        return this.d.get(this.g).get(getColumnNames()[i]);
    }

    @Override // android.database.CrossProcessCursor
    public void fillWindow(int i, CursorWindow cursorWindow) {
        za4.b(this, i, cursorWindow);
    }

    public void finalize() {
        ContentObserver contentObserver = this.k;
        if (contentObserver == null || !this.m) {
            return;
        }
        this.h.unregisterContentObserver(contentObserver);
    }

    @Override // android.database.Cursor
    public byte[] getBlob(int i) {
        throw new UnsupportedOperationException("getBlob is not supported");
    }

    @Override // android.database.Cursor
    public int getColumnCount() {
        return getColumnNames().length;
    }

    @Override // android.database.Cursor
    public int getColumnIndex(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        if (iLastIndexOf != -1) {
            new Exception();
            String str2 = "requesting column name with table name -- " + str;
            str = str.substring(iLastIndexOf + 1);
        }
        String[] columnNames = getColumnNames();
        int length = columnNames.length;
        for (int i = 0; i < length; i++) {
            if (columnNames[i].equalsIgnoreCase(str)) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.database.Cursor
    public int getColumnIndexOrThrow(String str) {
        int columnIndex = getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist");
    }

    @Override // android.database.Cursor
    public String getColumnName(int i) {
        return getColumnNames()[i];
    }

    @Override // android.database.Cursor
    public abstract String[] getColumnNames();

    @Override // android.database.Cursor
    public abstract int getCount();

    @Override // android.database.Cursor
    public Bundle getExtras() {
        return this.c;
    }

    @Override // android.database.Cursor
    public abstract long getLong(int i);

    @Override // android.database.Cursor
    public Uri getNotificationUri() {
        return this.j;
    }

    @Override // android.database.Cursor
    public final int getPosition() {
        return this.f;
    }

    @Override // android.database.Cursor
    public abstract String getString(int i);

    @Override // android.database.Cursor
    public boolean getWantsAllOnMoveCalls() {
        return false;
    }

    @Override // android.database.Cursor
    public final boolean isAfterLast() {
        return getCount() == 0 || this.f == getCount();
    }

    @Override // android.database.Cursor
    public final boolean isBeforeFirst() {
        return getCount() == 0 || this.f == -1;
    }

    @Override // android.database.Cursor
    public boolean isClosed() {
        return this.i;
    }

    @Override // android.database.Cursor
    public final boolean isFirst() {
        return this.f == 0 && getCount() != 0;
    }

    @Override // android.database.Cursor
    public final boolean isLast() {
        int count = getCount();
        return this.f == count + (-1) && count != 0;
    }

    @Override // android.database.CrossProcessCursor
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public net.sqlcipher.CursorWindow getWindow() {
        return null;
    }

    public boolean m(int i) {
        Map<String, Object> map;
        return this.e != -1 && this.d.size() > 0 && (map = this.d.get(this.g)) != null && map.containsKey(getColumnNames()[i]);
    }

    @Override // android.database.Cursor
    public final boolean move(int i) {
        return moveToPosition(this.f + i);
    }

    @Override // android.database.Cursor
    public final boolean moveToFirst() {
        return moveToPosition(0);
    }

    @Override // android.database.Cursor
    public final boolean moveToLast() {
        return moveToPosition(getCount() - 1);
    }

    @Override // android.database.Cursor
    public final boolean moveToNext() {
        return moveToPosition(this.f + 1);
    }

    @Override // android.database.Cursor
    public final boolean moveToPosition(int i) {
        int count = getCount();
        if (i >= count) {
            this.f = count;
            return false;
        }
        if (i < 0) {
            this.f = -1;
            return false;
        }
        int i2 = this.f;
        if (i == i2) {
            return true;
        }
        boolean zOnMove = onMove(i2, i);
        if (zOnMove) {
            this.f = i;
            int i3 = this.e;
            if (i3 != -1) {
                this.g = Long.valueOf(getLong(i3));
            }
        } else {
            this.f = -1;
        }
        return zOnMove;
    }

    @Override // android.database.Cursor
    public final boolean moveToPrevious() {
        return moveToPosition(this.f - 1);
    }

    @Override // android.database.CrossProcessCursor
    public boolean onMove(int i, int i2) {
        return true;
    }

    public void p() {
        this.a.notifyChanged();
    }

    public void q(boolean z) {
        synchronized (this.l) {
            this.b.dispatchChange(z);
            Uri uri = this.j;
            if (uri != null && z) {
                this.h.notifyChange(uri, this.k);
            }
        }
    }

    @Override // android.database.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
        this.b.registerObserver(contentObserver);
    }

    @Override // android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.a.registerObserver(dataSetObserver);
    }

    @Override // android.database.Cursor
    public boolean requery() {
        ContentObserver contentObserver = this.k;
        if (contentObserver != null && !this.m) {
            this.h.registerContentObserver(this.j, true, contentObserver);
            this.m = true;
        }
        this.a.notifyChanged();
        return true;
    }

    @Override // android.database.Cursor
    public Bundle respond(Bundle bundle) {
        return Bundle.EMPTY;
    }

    @Override // android.database.Cursor
    public void setExtras(Bundle bundle) {
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        this.c = bundle;
    }

    @Override // android.database.Cursor
    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        synchronized (this.l) {
            this.j = uri;
            this.h = contentResolver;
            ContentObserver contentObserver = this.k;
            if (contentObserver != null) {
                contentResolver.unregisterContentObserver(contentObserver);
            }
            a aVar = new a(this);
            this.k = aVar;
            this.h.registerContentObserver(this.j, true, aVar);
            this.m = true;
        }
    }

    @Override // android.database.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver) {
        if (this.i) {
            return;
        }
        this.b.unregisterObserver(contentObserver);
    }

    @Override // android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.a.unregisterObserver(dataSetObserver);
    }
}

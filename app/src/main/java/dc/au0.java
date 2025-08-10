package dc;

import com.google.android.exoplayer2.offline.DownloadCursor;

/* compiled from: DownloadCursor.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class au0 {
    public static boolean $default$isAfterLast(DownloadCursor _this) {
        return _this.getCount() == 0 || _this.getPosition() == _this.getCount();
    }

    public static boolean $default$isBeforeFirst(DownloadCursor _this) {
        return _this.getCount() == 0 || _this.getPosition() == -1;
    }

    public static boolean $default$isFirst(DownloadCursor _this) {
        return _this.getPosition() == 0 && _this.getCount() != 0;
    }

    public static boolean $default$isLast(DownloadCursor _this) {
        int count = _this.getCount();
        return _this.getPosition() == count + (-1) && count != 0;
    }
}

package dc;

import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadManager;
import java.util.Comparator;

/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class ut0 implements Comparator {
    public static final /* synthetic */ ut0 a = new ut0();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return DownloadManager.InternalHandler.compareStartTimes((Download) obj, (Download) obj2);
    }
}

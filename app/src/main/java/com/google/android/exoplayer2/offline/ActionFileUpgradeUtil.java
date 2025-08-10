package com.google.android.exoplayer2.offline;

import android.database.SQLException;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.File;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class ActionFileUpgradeUtil {

    public interface DownloadIdProvider {
        String getId(DownloadRequest downloadRequest);
    }

    private ActionFileUpgradeUtil() {
    }

    public static void mergeRequest(DownloadRequest downloadRequest, DefaultDownloadIndex defaultDownloadIndex, boolean z, long j) throws IOException, SQLException {
        Download download;
        Download download2 = defaultDownloadIndex.getDownload(downloadRequest.id);
        if (download2 != null) {
            download = DownloadManager.mergeRequest(download2, downloadRequest, download2.stopReason, j);
        } else {
            download = new Download(downloadRequest, z ? 3 : 0, j, j, -1L, 0, 0);
        }
        defaultDownloadIndex.putDownload(download);
    }

    @WorkerThread
    public static void upgradeAndDelete(File file, @Nullable DownloadIdProvider downloadIdProvider, DefaultDownloadIndex defaultDownloadIndex, boolean z, boolean z2) throws IOException {
        ActionFile actionFile = new ActionFile(file);
        if (actionFile.exists()) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (DownloadRequest downloadRequestCopyWithId : actionFile.load()) {
                    if (downloadIdProvider != null) {
                        downloadRequestCopyWithId = downloadRequestCopyWithId.copyWithId(downloadIdProvider.getId(downloadRequestCopyWithId));
                    }
                    mergeRequest(downloadRequestCopyWithId, defaultDownloadIndex, z2, jCurrentTimeMillis);
                }
                actionFile.delete();
            } catch (Throwable th) {
                if (z) {
                    actionFile.delete();
                }
                throw th;
            }
        }
    }
}

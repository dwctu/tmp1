package com.google.android.vending.expansion.downloader.impl;

import android.R;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Messenger;
import androidx.core.app.NotificationCompat;
import com.google.android.vending.expansion.downloader.DownloadProgressInfo;
import com.google.android.vending.expansion.downloader.DownloaderClientMarshaller;
import com.google.android.vending.expansion.downloader.Helpers;
import com.google.android.vending.expansion.downloader.IDownloaderClient;
import dc.he;

/* loaded from: classes2.dex */
public class DownloadNotification implements IDownloaderClient {
    public static final String LOGTAG = "DownloadNotification";
    public static final int NOTIFICATION_ID = -908767821;
    private NotificationCompat.Builder mActiveDownloadBuilder;
    private NotificationCompat.Builder mBuilder;
    private IDownloaderClient mClientProxy;
    private PendingIntent mContentIntent;
    private final Context mContext;
    private NotificationCompat.Builder mCurrentBuilder;
    private String mCurrentText;
    private CharSequence mCurrentTitle;
    private CharSequence mLabel;
    private final NotificationManager mNotificationManager;
    private DownloadProgressInfo mProgressInfo;
    private int mState = -1;

    public DownloadNotification(Context context, CharSequence charSequence) {
        this.mContext = context;
        this.mLabel = charSequence;
        this.mNotificationManager = (NotificationManager) context.getSystemService("notification");
        this.mActiveDownloadBuilder = new NotificationCompat.Builder(context);
        this.mBuilder = new NotificationCompat.Builder(context);
        this.mActiveDownloadBuilder.setPriority(-1);
        this.mActiveDownloadBuilder.setCategory("progress");
        this.mBuilder.setPriority(-1);
        this.mBuilder.setCategory("progress");
        this.mCurrentBuilder = this.mBuilder;
    }

    public PendingIntent getClientIntent() {
        return this.mContentIntent;
    }

    @Override // com.google.android.vending.expansion.downloader.IDownloaderClient
    public void onDownloadProgress(DownloadProgressInfo downloadProgressInfo) {
        this.mProgressInfo = downloadProgressInfo;
        IDownloaderClient iDownloaderClient = this.mClientProxy;
        if (iDownloaderClient != null) {
            iDownloaderClient.onDownloadProgress(downloadProgressInfo);
        }
        long j = downloadProgressInfo.mOverallTotal;
        if (j <= 0) {
            this.mBuilder.setTicker(this.mCurrentTitle);
            this.mBuilder.setSmallIcon(R.drawable.stat_sys_download);
            this.mBuilder.setContentTitle(this.mCurrentTitle);
            this.mBuilder.setContentText(this.mCurrentText);
            this.mCurrentBuilder = this.mBuilder;
        } else {
            this.mActiveDownloadBuilder.setProgress((int) j, (int) downloadProgressInfo.mOverallProgress, false);
            this.mActiveDownloadBuilder.setContentText(Helpers.getDownloadProgressString(downloadProgressInfo.mOverallProgress, downloadProgressInfo.mOverallTotal));
            this.mActiveDownloadBuilder.setSmallIcon(R.drawable.stat_sys_download);
            this.mActiveDownloadBuilder.setTicker(((Object) this.mLabel) + ": " + this.mCurrentText);
            this.mActiveDownloadBuilder.setContentTitle(this.mLabel);
            this.mActiveDownloadBuilder.setContentInfo(this.mContext.getString(he.time_remaining_notification, Helpers.getTimeRemaining(downloadProgressInfo.mTimeRemaining)));
            this.mCurrentBuilder = this.mActiveDownloadBuilder;
        }
        this.mNotificationManager.notify(NOTIFICATION_ID, this.mCurrentBuilder.build());
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009b  */
    @Override // com.google.android.vending.expansion.downloader.IDownloaderClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onDownloadStateChanged(int r7) {
        /*
            r6 = this;
            com.google.android.vending.expansion.downloader.IDownloaderClient r0 = r6.mClientProxy
            if (r0 == 0) goto L7
            r0.onDownloadStateChanged(r7)
        L7:
            int r0 = r6.mState
            if (r7 == r0) goto Lb3
            r6.mState = r7
            r0 = 1
            if (r7 == r0) goto Lb3
            android.app.PendingIntent r1 = r6.mContentIntent
            if (r1 != 0) goto L16
            goto Lb3
        L16:
            r1 = 17301634(0x1080082, float:2.497962E-38)
            r2 = 17301642(0x108008a, float:2.4979642E-38)
            r3 = 0
            if (r7 == 0) goto L51
            r4 = 7
            if (r7 == r4) goto L4c
            r4 = 2
            if (r7 == r4) goto L47
            r4 = 3
            if (r7 == r4) goto L47
            r4 = 4
            if (r7 == r4) goto L3f
            r4 = 5
            if (r7 == r4) goto L4c
            switch(r7) {
                case 15: goto L3a;
                case 16: goto L3a;
                case 17: goto L3a;
                case 18: goto L3a;
                case 19: goto L3a;
                default: goto L31;
            }
        L31:
            int r7 = com.google.android.vending.expansion.downloader.Helpers.getDownloaderStringResourceIDFromState(r7)
            r1 = 17301642(0x108008a, float:2.4979642E-38)
        L38:
            r2 = 1
            goto L57
        L3a:
            int r7 = com.google.android.vending.expansion.downloader.Helpers.getDownloaderStringResourceIDFromState(r7)
            goto L53
        L3f:
            r1 = 17301633(0x1080081, float:2.4979616E-38)
            int r7 = com.google.android.vending.expansion.downloader.Helpers.getDownloaderStringResourceIDFromState(r7)
            goto L38
        L47:
            int r7 = com.google.android.vending.expansion.downloader.Helpers.getDownloaderStringResourceIDFromState(r7)
            goto L38
        L4c:
            int r7 = com.google.android.vending.expansion.downloader.Helpers.getDownloaderStringResourceIDFromState(r7)
            goto L56
        L51:
            int r7 = dc.he.state_unknown
        L53:
            r1 = 17301642(0x108008a, float:2.4979642E-38)
        L56:
            r2 = 0
        L57:
            android.content.Context r4 = r6.mContext
            java.lang.String r7 = r4.getString(r7)
            r6.mCurrentText = r7
            java.lang.CharSequence r7 = r6.mLabel
            r6.mCurrentTitle = r7
            androidx.core.app.NotificationCompat$Builder r7 = r6.mCurrentBuilder
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.CharSequence r5 = r6.mLabel
            r4.append(r5)
            java.lang.String r5 = ": "
            r4.append(r5)
            java.lang.String r5 = r6.mCurrentText
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r7.setTicker(r4)
            androidx.core.app.NotificationCompat$Builder r7 = r6.mCurrentBuilder
            r7.setSmallIcon(r1)
            androidx.core.app.NotificationCompat$Builder r7 = r6.mCurrentBuilder
            java.lang.CharSequence r1 = r6.mCurrentTitle
            r7.setContentTitle(r1)
            androidx.core.app.NotificationCompat$Builder r7 = r6.mCurrentBuilder
            java.lang.String r1 = r6.mCurrentText
            r7.setContentText(r1)
            if (r2 == 0) goto L9b
            androidx.core.app.NotificationCompat$Builder r7 = r6.mCurrentBuilder
            r7.setOngoing(r0)
            goto La5
        L9b:
            androidx.core.app.NotificationCompat$Builder r7 = r6.mCurrentBuilder
            r7.setOngoing(r3)
            androidx.core.app.NotificationCompat$Builder r7 = r6.mCurrentBuilder
            r7.setAutoCancel(r0)
        La5:
            android.app.NotificationManager r7 = r6.mNotificationManager
            int r0 = com.google.android.vending.expansion.downloader.impl.DownloadNotification.NOTIFICATION_ID
            androidx.core.app.NotificationCompat$Builder r1 = r6.mCurrentBuilder
            android.app.Notification r1 = r1.build()
            r7.notify(r0, r1)
        Lb3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.vending.expansion.downloader.impl.DownloadNotification.onDownloadStateChanged(int):void");
    }

    @Override // com.google.android.vending.expansion.downloader.IDownloaderClient
    public void onServiceConnected(Messenger messenger) {
    }

    public void resendState() {
        IDownloaderClient iDownloaderClient = this.mClientProxy;
        if (iDownloaderClient != null) {
            iDownloaderClient.onDownloadStateChanged(this.mState);
        }
    }

    public void setClientIntent(PendingIntent pendingIntent) {
        this.mBuilder.setContentIntent(pendingIntent);
        this.mActiveDownloadBuilder.setContentIntent(pendingIntent);
        this.mContentIntent = pendingIntent;
    }

    public void setMessenger(Messenger messenger) {
        IDownloaderClient iDownloaderClientCreateProxy = DownloaderClientMarshaller.CreateProxy(messenger);
        this.mClientProxy = iDownloaderClientCreateProxy;
        DownloadProgressInfo downloadProgressInfo = this.mProgressInfo;
        if (downloadProgressInfo != null) {
            iDownloaderClientCreateProxy.onDownloadProgress(downloadProgressInfo);
        }
        int i = this.mState;
        if (i != -1) {
            this.mClientProxy.onDownloadStateChanged(i);
        }
    }
}

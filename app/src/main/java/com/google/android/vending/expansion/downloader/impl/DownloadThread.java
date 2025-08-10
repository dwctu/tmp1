package com.google.android.vending.expansion.downloader.impl;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import com.google.android.vending.expansion.downloader.Constants;
import com.google.android.vending.expansion.downloader.Helpers;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;
import com.google.common.net.HttpHeaders;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

/* loaded from: classes2.dex */
public class DownloadThread {
    private Context mContext;
    private final DownloadsDB mDB;
    private DownloadInfo mInfo;
    private final DownloadNotification mNotification;
    private DownloaderService mService;
    private String mUserAgent;

    public static class InnerState {
        public int mBytesNotified;
        public int mBytesSoFar;
        public int mBytesThisSession;
        public boolean mContinuingDownload;
        public String mHeaderContentDisposition;
        public String mHeaderContentLength;
        public String mHeaderContentLocation;
        public String mHeaderETag;
        public long mTimeLastNotification;

        private InnerState() {
            this.mBytesSoFar = 0;
            this.mBytesThisSession = 0;
            this.mContinuingDownload = false;
            this.mBytesNotified = 0;
            this.mTimeLastNotification = 0L;
        }
    }

    public class RetryDownload extends Throwable {
        private static final long serialVersionUID = 6196036036517540229L;

        private RetryDownload() {
        }
    }

    public static class State {
        public String mFilename;
        public String mNewUri;
        public int mRedirectCount;
        public String mRequestUri;
        public FileOutputStream mStream;
        public boolean mCountRetry = false;
        public int mRetryAfter = 0;
        public boolean mGotData = false;

        public State(DownloadInfo downloadInfo, DownloaderService downloaderService) {
            this.mRedirectCount = 0;
            this.mRedirectCount = downloadInfo.mRedirectCount;
            this.mRequestUri = downloadInfo.mUri;
            this.mFilename = downloaderService.generateTempSaveFileName(downloadInfo.mFileName);
        }
    }

    public DownloadThread(DownloadInfo downloadInfo, DownloaderService downloaderService, DownloadNotification downloadNotification) {
        this.mContext = downloaderService;
        this.mInfo = downloadInfo;
        this.mService = downloaderService;
        this.mNotification = downloadNotification;
        this.mDB = DownloadsDB.getDB(downloaderService);
        this.mUserAgent = "APKXDL (Linux; U; Android " + Build.VERSION.RELEASE + ";" + Locale.getDefault().toString() + "; " + Build.DEVICE + "/" + Build.ID + ")" + downloaderService.getPackageName();
    }

    private void addRequestHeaders(InnerState innerState, HttpURLConnection httpURLConnection) {
        if (innerState.mContinuingDownload) {
            String str = innerState.mHeaderETag;
            if (str != null) {
                httpURLConnection.setRequestProperty(HttpHeaders.IF_MATCH, str);
            }
            httpURLConnection.setRequestProperty(HttpHeaders.RANGE, "bytes=" + innerState.mBytesSoFar + Constants.FILENAME_SEQUENCE_SEPARATOR);
        }
    }

    private boolean cannotResume(InnerState innerState) {
        return innerState.mBytesSoFar > 0 && innerState.mHeaderETag == null;
    }

    private void checkConnectivity(State state) throws StopRequest {
        int networkAvailabilityState = this.mService.getNetworkAvailabilityState(this.mDB);
        if (networkAvailabilityState == 2) {
            throw new StopRequest(DownloaderService.STATUS_WAITING_FOR_NETWORK, "waiting for network to return");
        }
        if (networkAvailabilityState == 3) {
            throw new StopRequest(DownloaderService.STATUS_QUEUED_FOR_WIFI, "waiting for wifi");
        }
        if (networkAvailabilityState == 5) {
            throw new StopRequest(DownloaderService.STATUS_WAITING_FOR_NETWORK, "roaming is not allowed");
        }
        if (networkAvailabilityState == 6) {
            throw new StopRequest(DownloaderService.STATUS_QUEUED_FOR_WIFI_OR_CELLULAR_PERMISSION, "waiting for wifi or for download over cellular to be authorized");
        }
    }

    private void checkPausedOrCanceled(State state) throws StopRequest {
        if (this.mService.getControl() == 1 && this.mService.getStatus() == 193) {
            throw new StopRequest(this.mService.getStatus(), "download paused");
        }
    }

    private void cleanupDestination(State state, int i) throws IOException {
        closeDestination(state);
        if (state.mFilename == null || !DownloaderService.isStatusError(i)) {
            return;
        }
        new File(state.mFilename).delete();
        state.mFilename = null;
    }

    private void closeDestination(State state) throws IOException {
        try {
            FileOutputStream fileOutputStream = state.mStream;
            if (fileOutputStream != null) {
                fileOutputStream.close();
                state.mStream = null;
            }
        } catch (IOException unused) {
        }
    }

    private void executeDownload(State state, HttpURLConnection httpURLConnection) throws StopRequest, RetryDownload, IOException, NumberFormatException {
        InnerState innerState = new InnerState();
        checkPausedOrCanceled(state);
        setupDestinationFile(state, innerState);
        addRequestHeaders(innerState, httpURLConnection);
        checkConnectivity(state);
        this.mNotification.onDownloadStateChanged(3);
        handleExceptionalStatus(state, innerState, httpURLConnection, sendRequest(state, httpURLConnection));
        processResponseHeaders(state, innerState, httpURLConnection);
        InputStream inputStreamOpenResponseEntity = openResponseEntity(state, httpURLConnection);
        this.mNotification.onDownloadStateChanged(4);
        transferData(state, innerState, new byte[4096], inputStreamOpenResponseEntity);
    }

    private void finalizeDestinationFile(State state) throws Throwable {
        syncDestination(state);
        String str = state.mFilename;
        String strGenerateSaveFileName = Helpers.generateSaveFileName(this.mService, this.mInfo.mFileName);
        if (state.mFilename.equals(strGenerateSaveFileName)) {
            return;
        }
        File file = new File(str);
        File file2 = new File(strGenerateSaveFileName);
        DownloadInfo downloadInfo = this.mInfo;
        long j = downloadInfo.mTotalBytes;
        if (j == -1 || downloadInfo.mCurrentBytes != j) {
            throw new StopRequest(DownloaderService.STATUS_FILE_DELIVERED_INCORRECTLY, "file delivered with incorrect size. probably due to network not browser configured");
        }
        if (!file.renameTo(file2)) {
            throw new StopRequest(492, "unable to finalize destination file");
        }
    }

    private int getFinalStatusForHttpError(State state) {
        if (this.mService.getNetworkAvailabilityState(this.mDB) != 1) {
            return DownloaderService.STATUS_WAITING_FOR_NETWORK;
        }
        if (this.mInfo.mNumFailed < 5) {
            state.mCountRetry = true;
            return DownloaderService.STATUS_WAITING_TO_RETRY;
        }
        String str = "reached max retries for " + this.mInfo.mNumFailed;
        return 495;
    }

    private void handleEndOfStream(State state, InnerState innerState) throws StopRequest {
        DownloadInfo downloadInfo = this.mInfo;
        downloadInfo.mCurrentBytes = innerState.mBytesSoFar;
        this.mDB.updateDownload(downloadInfo);
        String str = innerState.mHeaderContentLength;
        if ((str == null || innerState.mBytesSoFar == Integer.parseInt(str)) ? false : true) {
            if (!cannotResume(innerState)) {
                throw new StopRequest(getFinalStatusForHttpError(state), "closed socket before end of file");
            }
            throw new StopRequest(489, "mismatched content length");
        }
    }

    private void handleExceptionalStatus(State state, InnerState innerState, HttpURLConnection httpURLConnection, int i) throws StopRequest, RetryDownload, NumberFormatException {
        if (i == 503 && this.mInfo.mNumFailed < 5) {
            handleServiceUnavailable(state, httpURLConnection);
        }
        if (i != (innerState.mContinuingDownload ? 206 : 200)) {
            handleOtherStatus(state, innerState, i);
        } else {
            state.mRedirectCount = 0;
        }
    }

    private void handleOtherStatus(State state, InnerState innerState, int i) throws StopRequest {
        throw new StopRequest(!DownloaderService.isStatusError(i) ? (i < 300 || i >= 400) ? (innerState.mContinuingDownload && i == 200) ? 489 : 494 : 493 : i, "http error " + i);
    }

    private void handleServiceUnavailable(State state, HttpURLConnection httpURLConnection) throws StopRequest, NumberFormatException {
        state.mCountRetry = true;
        String headerField = httpURLConnection.getHeaderField(HttpHeaders.RETRY_AFTER);
        if (headerField != null) {
            try {
                int i = Integer.parseInt(headerField);
                state.mRetryAfter = i;
                if (i >= 0) {
                    if (i < 30) {
                        state.mRetryAfter = 30;
                    } else if (i > 86400) {
                        state.mRetryAfter = Constants.MAX_RETRY_AFTER;
                    }
                    int iNextInt = state.mRetryAfter + Helpers.sRandom.nextInt(31);
                    state.mRetryAfter = iNextInt;
                    state.mRetryAfter = iNextInt * 1000;
                } else {
                    state.mRetryAfter = 0;
                }
            } catch (NumberFormatException unused) {
            }
        }
        throw new StopRequest(DownloaderService.STATUS_WAITING_TO_RETRY, "got 503 Service Unavailable, will retry later");
    }

    private void logNetworkState() {
        StringBuilder sb = new StringBuilder();
        sb.append("Net ");
        sb.append(this.mService.getNetworkAvailabilityState(this.mDB) == 1 ? "Up" : "Down");
        sb.toString();
    }

    private void notifyDownloadCompleted(int i, boolean z, int i2, int i3, boolean z2, String str) {
        updateDownloadDatabase(i, z, i2, i3, z2, str);
        DownloaderService.isStatusCompleted(i);
    }

    private InputStream openResponseEntity(State state, HttpURLConnection httpURLConnection) throws StopRequest {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException e) {
            logNetworkState();
            throw new StopRequest(getFinalStatusForHttpError(state), "while getting entity: " + e.toString(), e);
        }
    }

    private void processResponseHeaders(State state, InnerState innerState, HttpURLConnection httpURLConnection) throws StopRequest {
        if (innerState.mContinuingDownload) {
            return;
        }
        readResponseHeaders(state, innerState, httpURLConnection);
        try {
            DownloaderService downloaderService = this.mService;
            DownloadInfo downloadInfo = this.mInfo;
            state.mFilename = downloaderService.generateSaveFile(downloadInfo.mFileName, downloadInfo.mTotalBytes);
            try {
                state.mStream = new FileOutputStream(state.mFilename);
            } catch (FileNotFoundException e) {
                try {
                    if (new File(Helpers.getSaveFilePath(this.mService)).mkdirs()) {
                        state.mStream = new FileOutputStream(state.mFilename);
                    }
                } catch (Exception unused) {
                    throw new StopRequest(492, "while opening destination file: " + e.toString(), e);
                }
            }
            updateDatabaseFromHeaders(state, innerState);
            checkConnectivity(state);
        } catch (DownloaderService.GenerateSaveFileError e2) {
            throw new StopRequest(e2.mStatus, e2.mMessage);
        }
    }

    private int readFromResponse(State state, InnerState innerState, byte[] bArr, InputStream inputStream) throws StopRequest {
        try {
            return inputStream.read(bArr);
        } catch (IOException e) {
            logNetworkState();
            this.mInfo.mCurrentBytes = innerState.mBytesSoFar;
            this.mDB.updateDownload(this.mInfo);
            if (cannotResume(innerState)) {
                throw new StopRequest(489, "while reading response: " + e.toString() + ", can't resume interrupted download with no ETag", e);
            }
            throw new StopRequest(getFinalStatusForHttpError(state), "while reading response: " + e.toString(), e);
        }
    }

    private void readResponseHeaders(State state, InnerState innerState, HttpURLConnection httpURLConnection) throws StopRequest {
        String headerField = httpURLConnection.getHeaderField("Content-Disposition");
        if (headerField != null) {
            innerState.mHeaderContentDisposition = headerField;
        }
        String headerField2 = httpURLConnection.getHeaderField(HttpHeaders.CONTENT_LOCATION);
        if (headerField2 != null) {
            innerState.mHeaderContentLocation = headerField2;
        }
        String headerField3 = httpURLConnection.getHeaderField(HttpHeaders.ETAG);
        if (headerField3 != null) {
            innerState.mHeaderETag = headerField3;
        }
        String headerField4 = httpURLConnection.getHeaderField(HttpHeaders.TRANSFER_ENCODING);
        String str = headerField4 != null ? headerField4 : null;
        String headerField5 = httpURLConnection.getHeaderField("Content-Type");
        if (headerField5 != null && !headerField5.equals("application/vnd.android.obb")) {
            throw new StopRequest(DownloaderService.STATUS_FILE_DELIVERED_INCORRECTLY, "file delivered with incorrect Mime type");
        }
        if (str == null) {
            long contentLength = httpURLConnection.getContentLength();
            if (headerField5 != null && (contentLength == -1 || contentLength == this.mInfo.mTotalBytes)) {
                innerState.mHeaderContentLength = Long.toString(contentLength);
            }
        }
        if (innerState.mHeaderContentLength == null && (str == null || !str.equalsIgnoreCase("chunked"))) {
            throw new StopRequest(495, "can't know size of download, giving up");
        }
    }

    private void reportProgress(State state, InnerState innerState) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i = innerState.mBytesSoFar;
        if (i - innerState.mBytesNotified <= 4096 || jCurrentTimeMillis - innerState.mTimeLastNotification <= 1000) {
            return;
        }
        DownloadInfo downloadInfo = this.mInfo;
        downloadInfo.mCurrentBytes = i;
        this.mDB.updateDownloadCurrentBytes(downloadInfo);
        innerState.mBytesNotified = innerState.mBytesSoFar;
        innerState.mTimeLastNotification = jCurrentTimeMillis;
        long j = innerState.mBytesThisSession;
        DownloaderService downloaderService = this.mService;
        downloaderService.notifyUpdateBytes(j + downloaderService.mBytesSoFar);
    }

    private int sendRequest(State state, HttpURLConnection httpURLConnection) throws StopRequest {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e) {
            logNetworkState();
            throw new StopRequest(getFinalStatusForHttpError(state), "while trying to execute request: " + e.toString(), e);
        } catch (IllegalArgumentException e2) {
            throw new StopRequest(495, "while trying to execute request: " + e2.toString(), e2);
        }
    }

    private void setupDestinationFile(State state, InnerState innerState) throws StopRequest, IOException {
        String str = state.mFilename;
        if (str != null) {
            if (!Helpers.isFilenameValid(str)) {
                throw new StopRequest(492, "found invalid internal destination filename");
            }
            File file = new File(state.mFilename);
            if (file.exists()) {
                long length = file.length();
                if (length == 0) {
                    file.delete();
                    state.mFilename = null;
                } else {
                    if (this.mInfo.mETag == null) {
                        file.delete();
                        throw new StopRequest(489, "Trying to resume a download that can't be resumed");
                    }
                    try {
                        state.mStream = new FileOutputStream(state.mFilename, true);
                        innerState.mBytesSoFar = (int) length;
                        long j = this.mInfo.mTotalBytes;
                        if (j != -1) {
                            innerState.mHeaderContentLength = Long.toString(j);
                        }
                        innerState.mHeaderETag = this.mInfo.mETag;
                        innerState.mContinuingDownload = true;
                    } catch (FileNotFoundException e) {
                        throw new StopRequest(492, "while opening destination for resuming: " + e.toString(), e);
                    }
                }
            }
        }
        if (state.mStream != null) {
            closeDestination(state);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.io.FileDescriptor] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void syncDestination(com.google.android.vending.expansion.downloader.impl.DownloadThread.State r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.String r0 = "file "
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L20 java.lang.RuntimeException -> L23 java.io.IOException -> L29 java.io.SyncFailedException -> L47 java.io.FileNotFoundException -> L66
            java.lang.String r3 = r7.mFilename     // Catch: java.lang.Throwable -> L20 java.lang.RuntimeException -> L23 java.io.IOException -> L29 java.io.SyncFailedException -> L47 java.io.FileNotFoundException -> L66
            r4 = 1
            r2.<init>(r3, r4)     // Catch: java.lang.Throwable -> L20 java.lang.RuntimeException -> L23 java.io.IOException -> L29 java.io.SyncFailedException -> L47 java.io.FileNotFoundException -> L66
            java.io.FileDescriptor r1 = r2.getFD()     // Catch: java.lang.RuntimeException -> L17 java.io.IOException -> L19 java.io.SyncFailedException -> L1c java.io.FileNotFoundException -> L1e java.lang.Throwable -> L86
            r1.sync()     // Catch: java.lang.RuntimeException -> L17 java.io.IOException -> L19 java.io.SyncFailedException -> L1c java.io.FileNotFoundException -> L1e java.lang.Throwable -> L86
        L12:
            r2.close()     // Catch: java.lang.Throwable -> L85
            goto L85
        L17:
            r1 = r2
            goto L23
        L19:
            r0 = move-exception
            r1 = r2
            goto L2a
        L1c:
            r1 = move-exception
            goto L4b
        L1e:
            r1 = move-exception
            goto L6a
        L20:
            r7 = move-exception
            goto L88
        L23:
            if (r1 == 0) goto L85
        L25:
            r1.close()     // Catch: java.lang.Throwable -> L85
            goto L85
        L29:
            r0 = move-exception
        L2a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L20
            r2.<init>()     // Catch: java.lang.Throwable -> L20
            java.lang.String r3 = "IOException trying to sync "
            r2.append(r3)     // Catch: java.lang.Throwable -> L20
            java.lang.String r7 = r7.mFilename     // Catch: java.lang.Throwable -> L20
            r2.append(r7)     // Catch: java.lang.Throwable -> L20
            java.lang.String r7 = ": "
            r2.append(r7)     // Catch: java.lang.Throwable -> L20
            r2.append(r0)     // Catch: java.lang.Throwable -> L20
            r2.toString()     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L85
            goto L25
        L47:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L4b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L86
            r3.<init>()     // Catch: java.lang.Throwable -> L86
            r3.append(r0)     // Catch: java.lang.Throwable -> L86
            java.lang.String r7 = r7.mFilename     // Catch: java.lang.Throwable -> L86
            r3.append(r7)     // Catch: java.lang.Throwable -> L86
            java.lang.String r7 = " sync failed: "
            r3.append(r7)     // Catch: java.lang.Throwable -> L86
            r3.append(r1)     // Catch: java.lang.Throwable -> L86
            r3.toString()     // Catch: java.lang.Throwable -> L86
            if (r2 == 0) goto L85
            goto L12
        L66:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L6a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L86
            r3.<init>()     // Catch: java.lang.Throwable -> L86
            r3.append(r0)     // Catch: java.lang.Throwable -> L86
            java.lang.String r7 = r7.mFilename     // Catch: java.lang.Throwable -> L86
            r3.append(r7)     // Catch: java.lang.Throwable -> L86
            java.lang.String r7 = " not found: "
            r3.append(r7)     // Catch: java.lang.Throwable -> L86
            r3.append(r1)     // Catch: java.lang.Throwable -> L86
            r3.toString()     // Catch: java.lang.Throwable -> L86
            if (r2 == 0) goto L85
            goto L12
        L85:
            return
        L86:
            r7 = move-exception
            r1 = r2
        L88:
            if (r1 == 0) goto L8d
            r1.close()     // Catch: java.lang.Throwable -> L8d
        L8d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.vending.expansion.downloader.impl.DownloadThread.syncDestination(com.google.android.vending.expansion.downloader.impl.DownloadThread$State):void");
    }

    private void transferData(State state, InnerState innerState, byte[] bArr, InputStream inputStream) throws StopRequest, IOException {
        while (true) {
            int fromResponse = readFromResponse(state, innerState, bArr, inputStream);
            if (fromResponse == -1) {
                handleEndOfStream(state, innerState);
                return;
            }
            state.mGotData = true;
            writeDataToDestination(state, bArr, fromResponse);
            innerState.mBytesSoFar += fromResponse;
            innerState.mBytesThisSession += fromResponse;
            reportProgress(state, innerState);
            checkPausedOrCanceled(state);
        }
    }

    private void updateDatabaseFromHeaders(State state, InnerState innerState) {
        DownloadInfo downloadInfo = this.mInfo;
        downloadInfo.mETag = innerState.mHeaderETag;
        this.mDB.updateDownload(downloadInfo);
    }

    private void updateDownloadDatabase(int i, boolean z, int i2, int i3, boolean z2, String str) {
        DownloadInfo downloadInfo = this.mInfo;
        downloadInfo.mStatus = i;
        downloadInfo.mRetryAfter = i2;
        downloadInfo.mRedirectCount = i3;
        downloadInfo.mLastMod = System.currentTimeMillis();
        if (!z) {
            this.mInfo.mNumFailed = 0;
        } else if (z2) {
            this.mInfo.mNumFailed = 1;
        } else {
            this.mInfo.mNumFailed++;
        }
        this.mDB.updateDownload(this.mInfo);
    }

    private String userAgent() {
        return this.mUserAgent;
    }

    private void writeDataToDestination(State state, byte[] bArr, int i) throws StopRequest, IOException {
        try {
            if (state.mStream == null) {
                state.mStream = new FileOutputStream(state.mFilename, true);
            }
            state.mStream.write(bArr, 0, i);
            closeDestination(state);
        } catch (IOException e) {
            if (!Helpers.isExternalMediaMounted()) {
                throw new StopRequest(499, "external media not mounted while writing destination file");
            }
            if (Helpers.getAvailableBytes(Helpers.getFilesystemRoot(state.mFilename)) < i) {
                throw new StopRequest(498, "insufficient space while writing destination file", e);
            }
            throw new StopRequest(492, "while writing destination file: " + e.toString(), e);
        }
    }

    public void run() throws SecurityException, IOException, IllegalArgumentException {
        Process.setThreadPriority(10);
        State state = new State(this.mInfo, this.mService);
        PowerManager.WakeLock wakeLock = null;
        try {
            try {
                PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) this.mContext.getSystemService("power")).newWakeLock(1, Constants.TAG);
                wakeLockNewWakeLock.acquire();
                boolean z = false;
                while (!z) {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(state.mRequestUri).openConnection();
                    httpURLConnection.setRequestProperty("User-Agent", userAgent());
                    try {
                        executeDownload(state, httpURLConnection);
                        httpURLConnection.disconnect();
                        z = true;
                    } catch (RetryDownload unused) {
                        httpURLConnection.disconnect();
                    } catch (Throwable th) {
                        httpURLConnection.disconnect();
                        throw th;
                    }
                }
                finalizeDestinationFile(state);
                if (wakeLockNewWakeLock != null) {
                    wakeLockNewWakeLock.release();
                }
                cleanupDestination(state, 200);
                notifyDownloadCompleted(200, state.mCountRetry, state.mRetryAfter, state.mRedirectCount, state.mGotData, state.mFilename);
            } catch (StopRequest e) {
                String str = "Aborting request for download " + this.mInfo.mFileName + ": " + e.getMessage();
                e.printStackTrace();
                int i = e.mFinalStatus;
                if (0 != 0) {
                    wakeLock.release();
                }
                cleanupDestination(state, i);
                notifyDownloadCompleted(i, state.mCountRetry, state.mRetryAfter, state.mRedirectCount, state.mGotData, state.mFilename);
            } catch (Throwable th2) {
                String str2 = "Exception for " + this.mInfo.mFileName + ": " + th2;
            }
        } finally {
            if (0 != 0) {
                wakeLock.release();
            }
            cleanupDestination(state, 491);
            notifyDownloadCompleted(491, state.mCountRetry, state.mRetryAfter, state.mRedirectCount, state.mGotData, state.mFilename);
        }
    }

    public class StopRequest extends Throwable {
        private static final long serialVersionUID = 6338592678988347973L;
        public int mFinalStatus;

        public StopRequest(int i, String str) {
            super(str);
            this.mFinalStatus = i;
        }

        public StopRequest(int i, String str, Throwable th) {
            super(str, th);
            this.mFinalStatus = i;
        }
    }
}

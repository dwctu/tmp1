package io.agora.utils;

import android.os.AsyncTask;
import java.util.Map;

/* loaded from: classes4.dex */
public class HttpAsyncTask extends AsyncTask<HttpAsyncTaskParam, Void, Void> {
    private static final int RESPONSE_COMPLETED = 1;
    private static final int RESPONSE_COMPLETED_REASON_NONE = 0;
    private static final int RESPONSE_COMPLETED_REASON_OTHER_ERROR = 4;
    private static final int RESPONSE_COMPLETED_REASON_SOCKET_TIMEOUT = 3;
    private static final int RESPONSE_COMPLETED_REASON_SUCCESS = 1;
    private static final int RESPONSE_COMPLETED_REASON_UNKNOWN_HOST = 2;
    private static final int RESPONSE_ON_GOING = 0;
    private static final int SIZE_FOR_CALLBACK = 16384;
    private static final String TAG = "HttpAsyncTask";
    private long nativeHandle;

    public HttpAsyncTask(long j) {
        this.nativeHandle = -1L;
        this.nativeHandle = j;
    }

    private static native int nativeNotifyResponse(long j, int i, int i2, int i3, byte[] bArr, int i4, Map<String, String> map);

    private int notifyNativeResponse(int i, int i2, int i3, byte[] bArr, Map<String, String> map) {
        return nativeNotifyResponse(this.nativeHandle, i, i2, i3, bArr, bArr != null ? bArr.length : 0, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01f4 A[Catch: Exception -> 0x020c, SocketTimeoutException -> 0x0221, UnknownHostException -> 0x0223, TRY_ENTER, TryCatch #9 {SocketTimeoutException -> 0x0221, UnknownHostException -> 0x0223, Exception -> 0x020c, blocks: (B:7:0x001b, B:9:0x0026, B:10:0x002a, B:12:0x0032, B:14:0x0036, B:15:0x003e, B:17:0x0044, B:18:0x005a, B:20:0x005e, B:22:0x0064, B:24:0x0068, B:26:0x006e, B:27:0x00a4, B:29:0x00a8, B:31:0x00ae, B:32:0x00b5, B:34:0x00c7, B:35:0x00cf, B:37:0x00d9, B:38:0x00dc, B:40:0x00e0, B:41:0x00f1, B:43:0x0100, B:44:0x0108, B:46:0x010e, B:54:0x0130, B:55:0x0134, B:57:0x014a, B:59:0x014e, B:62:0x0153, B:64:0x0159, B:108:0x01fc, B:67:0x0167, B:92:0x01ce, B:105:0x01f4, B:112:0x0208, B:113:0x020b, B:11:0x002d), top: B:131:0x001b }] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v7 */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Void doInBackground(io.agora.utils.HttpAsyncTaskParam... r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 559
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.agora.utils.HttpAsyncTask.doInBackground(io.agora.utils.HttpAsyncTaskParam[]):java.lang.Void");
    }
}

package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.AmazonClientException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.retry.RetryUtils;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class DownloadTask implements Callable<Boolean> {
    public static final Log d = LogFactory.b(DownloadTask.class);
    public final AmazonS3 a;
    public final TransferRecord b;
    public final TransferStatusUpdater c;

    public DownloadTask(TransferRecord transferRecord, AmazonS3 amazonS3, TransferStatusUpdater transferStatusUpdater) {
        this.b = transferRecord;
        this.a = amazonS3;
        this.c = transferStatusUpdater;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean call() throws Throwable {
        try {
            if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                d.b("Thread:[" + Thread.currentThread().getId() + "]: Network wasn't available.");
                this.c.l(this.b.a, TransferState.WAITING_FOR_NETWORK);
                return Boolean.FALSE;
            }
        } catch (TransferUtilityException e) {
            d.d("TransferUtilityException: [" + e + "]");
        }
        this.c.l(this.b.a, TransferState.IN_PROGRESS);
        ProgressListener progressListenerF = this.c.f(this.b.a);
        try {
            TransferRecord transferRecord = this.b;
            GetObjectRequest getObjectRequest = new GetObjectRequest(transferRecord.k, transferRecord.l);
            TransferUtility.b(getObjectRequest);
            File file = new File(this.b.m);
            long length = file.length();
            if (length > 0) {
                d.a(String.format("Resume transfer %d from %d bytes", Integer.valueOf(this.b.a), Long.valueOf(length)));
                getObjectRequest.x(length, -1L);
            }
            getObjectRequest.h(progressListenerF);
            S3Object s3ObjectC = this.a.c(getObjectRequest);
            if (s3ObjectC == null) {
                this.c.i(this.b.a, new IllegalStateException("AmazonS3.getObject returns null"));
                this.c.l(this.b.a, TransferState.FAILED);
                return Boolean.FALSE;
            }
            long jV = s3ObjectC.j().v();
            this.c.k(this.b.a, length, jV, true);
            b(s3ObjectC.f(), file);
            this.c.k(this.b.a, jV, jV, true);
            this.c.l(this.b.a, TransferState.COMPLETED);
            return Boolean.TRUE;
        } catch (Exception e2) {
            if (TransferState.PENDING_CANCEL.equals(this.b.j)) {
                TransferStatusUpdater transferStatusUpdater = this.c;
                int i = this.b.a;
                TransferState transferState = TransferState.CANCELED;
                transferStatusUpdater.l(i, transferState);
                d.b("Transfer is " + transferState);
                return Boolean.FALSE;
            }
            if (TransferState.PENDING_PAUSE.equals(this.b.j)) {
                TransferStatusUpdater transferStatusUpdater2 = this.c;
                int i2 = this.b.a;
                TransferState transferState2 = TransferState.PAUSED;
                transferStatusUpdater2.l(i2, transferState2);
                d.b("Transfer is " + transferState2);
                new ProgressEvent(0L).c(32);
                progressListenerF.a(new ProgressEvent(0L));
                return Boolean.FALSE;
            }
            try {
                if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                    Log log = d;
                    log.b("Thread:[" + Thread.currentThread().getId() + "]: Network wasn't available.");
                    this.c.l(this.b.a, TransferState.WAITING_FOR_NETWORK);
                    log.a("Network Connection Interrupted: Moving the TransferState to WAITING_FOR_NETWORK");
                    new ProgressEvent(0L).c(32);
                    progressListenerF.a(new ProgressEvent(0L));
                    return Boolean.FALSE;
                }
            } catch (TransferUtilityException e3) {
                d.d("TransferUtilityException: [" + e3 + "]");
            }
            if (RetryUtils.b(e2)) {
                d.b("Transfer is interrupted. " + e2);
                this.c.l(this.b.a, TransferState.FAILED);
                return Boolean.FALSE;
            }
            d.a("Failed to download: " + this.b.a + " due to " + e2.getMessage());
            this.c.i(this.b.a, e2);
            this.c.l(this.b.a, TransferState.FAILED);
            return Boolean.FALSE;
        }
    }

    public final void b(InputStream inputStream, File file) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, file.length() > 0));
            } catch (SocketTimeoutException e) {
                e = e;
            } catch (IOException e2) {
                e = e2;
            }
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i != -1) {
                        bufferedOutputStream.write(bArr, 0, i);
                    } else {
                        try {
                            break;
                        } catch (IOException e3) {
                            d.f("got exception", e3);
                        }
                    }
                }
                bufferedOutputStream.close();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        d.f("got exception", e4);
                    }
                }
            } catch (SocketTimeoutException e5) {
                e = e5;
                String str = "SocketTimeoutException: Unable to retrieve contents over network: " + e.getMessage();
                d.d(str);
                throw new AmazonClientException(str, e);
            } catch (IOException e6) {
                e = e6;
                throw new AmazonClientException("Unable to store object contents to disk: " + e.getMessage(), e);
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream2 = bufferedOutputStream;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e7) {
                        d.f("got exception", e7);
                    }
                }
                if (inputStream == null) {
                    throw th;
                }
                try {
                    inputStream.close();
                    throw th;
                } catch (IOException e8) {
                    d.f("got exception", e8);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}

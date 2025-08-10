package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.AbortedException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobileconnectors.s3.transferutility.UploadTask;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.model.UploadPartResult;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class UploadPartTask implements Callable<Boolean> {
    public static final Log f = LogFactory.b(UploadPartTask.class);
    public final UploadTask.UploadPartTaskMetadata a;
    public final UploadPartTaskProgressListener b;
    public final UploadPartRequest c;
    public final AmazonS3 d;
    public final TransferDBUtil e;

    public class UploadPartTaskProgressListener implements ProgressListener {
        public final UploadTask.UploadTaskProgressListener a;
        public long b;

        public UploadPartTaskProgressListener(UploadTask.UploadTaskProgressListener uploadTaskProgressListener) {
            this.a = uploadTaskProgressListener;
        }

        @Override // com.amazonaws.event.ProgressListener
        public void a(ProgressEvent progressEvent) {
            if (32 == progressEvent.b()) {
                UploadPartTask.f.a("Reset Event triggered. Resetting the bytesCurrent to 0.");
                this.b = 0L;
            } else {
                this.b += progressEvent.a();
            }
            this.a.b(UploadPartTask.this.c.s(), this.b);
        }
    }

    public UploadPartTask(UploadTask.UploadPartTaskMetadata uploadPartTaskMetadata, UploadTask.UploadTaskProgressListener uploadTaskProgressListener, UploadPartRequest uploadPartRequest, AmazonS3 amazonS3, TransferDBUtil transferDBUtil) {
        this.a = uploadPartTaskMetadata;
        this.b = new UploadPartTaskProgressListener(uploadTaskProgressListener);
        this.c = uploadPartRequest;
        this.d = amazonS3;
        this.e = transferDBUtil;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Boolean call() throws Exception {
        this.a.c = TransferState.IN_PROGRESS;
        this.c.h(this.b);
        int i = 1;
        while (true) {
            try {
                UploadPartResult uploadPartResultD = this.d.d(this.c);
                f(TransferState.PART_COMPLETED);
                this.e.q(this.c.n(), uploadPartResultD.h());
                return Boolean.TRUE;
            } catch (AbortedException unused) {
                f.a("Upload part aborted.");
                e();
                return Boolean.FALSE;
            } catch (Exception e) {
                Log log = f;
                log.d("Unexpected error occurred: " + e);
                e();
                try {
                    if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                        log.b("Thread: [" + Thread.currentThread().getId() + "]: Network wasn't available.");
                        UploadTask.UploadPartTaskMetadata uploadPartTaskMetadata = this.a;
                        TransferState transferState = TransferState.WAITING_FOR_NETWORK;
                        uploadPartTaskMetadata.c = transferState;
                        this.e.s(this.c.n(), transferState);
                        log.b("Network Connection Interrupted: Moving the TransferState to WAITING_FOR_NETWORK");
                        return Boolean.FALSE;
                    }
                } catch (TransferUtilityException e2) {
                    f.d("TransferUtilityException: [" + e2 + "]");
                }
                if (i >= 3) {
                    f(TransferState.FAILED);
                    f.c("Encountered error uploading part ", e);
                    throw e;
                }
                long jD = d(i);
                Log log2 = f;
                log2.b("Retrying in " + jD + " ms.");
                TimeUnit.MILLISECONDS.sleep(jD);
                log2.e("Retry attempt: " + i, e);
                i++;
            }
        }
    }

    public final long d(int i) {
        return ((1 << i) * 1000) + ((long) (Math.random() * 1000.0d));
    }

    public final void e() {
        ProgressEvent progressEvent = new ProgressEvent(0L);
        progressEvent.c(32);
        this.b.a(progressEvent);
    }

    public final void f(TransferState transferState) {
        this.a.c = transferState;
        this.e.s(this.c.n(), transferState);
    }
}

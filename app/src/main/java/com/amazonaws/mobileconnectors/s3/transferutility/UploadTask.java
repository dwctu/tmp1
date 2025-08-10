package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.AmazonClientException;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.retry.RetryUtils;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CompleteMultipartUploadRequest;
import com.amazonaws.services.s3.model.InitiateMultipartUploadRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.ObjectTagging;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.SSEAwsKeyManagementParams;
import com.amazonaws.services.s3.model.Tag;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.services.s3.util.Mimetypes;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class UploadTask implements Callable<Boolean> {
    public static final Log g = LogFactory.b(UploadTask.class);
    public static final Map<String, CannedAccessControlList> h = new HashMap();
    public final AmazonS3 a;
    public final TransferRecord b;
    public final TransferDBUtil c;
    public final TransferStatusUpdater d;
    public Map<Integer, UploadPartTaskMetadata> e = new HashMap();
    public List<UploadPartRequest> f;

    public class UploadPartTaskMetadata {
        public Future<Boolean> a;
        public long b;
        public TransferState c;

        public UploadPartTaskMetadata(UploadTask uploadTask) {
        }
    }

    public class UploadTaskProgressListener implements ProgressListener {
        public long a;
        public final long b;

        public UploadTaskProgressListener(long j) {
            this.a = j;
            this.b = j;
        }

        @Override // com.amazonaws.event.ProgressListener
        public void a(ProgressEvent progressEvent) {
        }

        public synchronized void b(int i, long j) {
            UploadPartTaskMetadata uploadPartTaskMetadata = UploadTask.this.e.get(Integer.valueOf(i));
            if (uploadPartTaskMetadata == null) {
                UploadTask.g.b("Update received for unknown part. Ignoring.");
                return;
            }
            uploadPartTaskMetadata.b = j;
            long j2 = this.b;
            Iterator<Map.Entry<Integer, UploadPartTaskMetadata>> it = UploadTask.this.e.entrySet().iterator();
            while (it.hasNext()) {
                j2 += it.next().getValue().b;
            }
            if (j2 > this.a && j2 <= UploadTask.this.b.f) {
                UploadTask.this.d.k(UploadTask.this.b.a, j2, UploadTask.this.b.f, true);
                this.a = j2;
            }
        }
    }

    static {
        for (CannedAccessControlList cannedAccessControlList : CannedAccessControlList.values()) {
            h.put(cannedAccessControlList.toString(), cannedAccessControlList);
        }
    }

    public UploadTask(TransferRecord transferRecord, AmazonS3 amazonS3, TransferDBUtil transferDBUtil, TransferStatusUpdater transferStatusUpdater) {
        this.b = transferRecord;
        this.a = amazonS3;
        this.c = transferDBUtil;
        this.d = transferStatusUpdater;
    }

    public static CannedAccessControlList h(String str) {
        if (str == null) {
            return null;
        }
        return h.get(str);
    }

    public final void a(int i, String str, String str2, String str3) {
        Log log = g;
        log.b("Aborting the multipart since complete multipart failed.");
        try {
            this.a.e(new AbortMultipartUploadRequest(str, str2, str3));
            log.a("Successfully aborted multipart upload: " + i);
        } catch (AmazonClientException e) {
            g.e("Failed to abort the multipart upload: " + i, e);
        }
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Boolean call() throws Exception {
        try {
            if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                g.b("Network not connected. Setting the state to WAITING_FOR_NETWORK.");
                this.d.l(this.b.a, TransferState.WAITING_FOR_NETWORK);
                return Boolean.FALSE;
            }
        } catch (TransferUtilityException e) {
            g.d("TransferUtilityException: [" + e + "]");
        }
        this.d.l(this.b.a, TransferState.IN_PROGRESS);
        TransferRecord transferRecord = this.b;
        int i = transferRecord.c;
        return (i == 1 && transferRecord.e == 0) ? j() : i == 0 ? k() : Boolean.FALSE;
    }

    public final void f(int i, String str, String str2, String str3) throws AmazonClientException {
        CompleteMultipartUploadRequest completeMultipartUploadRequest = new CompleteMultipartUploadRequest(str, str2, str3, this.c.m(i));
        TransferUtility.a(completeMultipartUploadRequest);
        this.a.a(completeMultipartUploadRequest);
    }

    public final PutObjectRequest g(TransferRecord transferRecord) {
        File file = new File(transferRecord.m);
        PutObjectRequest putObjectRequest = new PutObjectRequest(transferRecord.k, transferRecord.l, file);
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.L(file.length());
        String str = transferRecord.s;
        if (str != null) {
            objectMetadata.H(str);
        }
        String str2 = transferRecord.q;
        if (str2 != null) {
            objectMetadata.J(str2);
        }
        String str3 = transferRecord.r;
        if (str3 != null) {
            objectMetadata.K(str3);
        }
        String str4 = transferRecord.p;
        if (str4 != null) {
            objectMetadata.N(str4);
        } else {
            objectMetadata.N(Mimetypes.a().b(file));
        }
        String str5 = transferRecord.t;
        if (str5 != null) {
            putObjectRequest.G(str5);
        }
        String str6 = transferRecord.v;
        if (str6 != null) {
            objectMetadata.c(str6);
        }
        if (transferRecord.w != null) {
            objectMetadata.Q(new Date(Long.valueOf(transferRecord.w).longValue()));
        }
        String str7 = transferRecord.x;
        if (str7 != null) {
            objectMetadata.f(str7);
        }
        Map<String, String> map = transferRecord.u;
        if (map != null) {
            objectMetadata.R(map);
            String str8 = transferRecord.u.get("x-amz-tagging");
            if (str8 != null) {
                try {
                    String[] strArrSplit = str8.split(ContainerUtils.FIELD_DELIMITER);
                    ArrayList arrayList = new ArrayList();
                    for (String str9 : strArrSplit) {
                        String[] strArrSplit2 = str9.split("=");
                        arrayList.add(new Tag(strArrSplit2[0], strArrSplit2[1]));
                    }
                    putObjectRequest.H(new ObjectTagging(arrayList));
                } catch (Exception e) {
                    g.c("Error in passing the object tags as request headers.", e);
                }
            }
            String str10 = transferRecord.u.get("x-amz-website-redirect-location");
            if (str10 != null) {
                putObjectRequest.D(str10);
            }
            String str11 = transferRecord.u.get("x-amz-request-payer");
            if (str11 != null) {
                putObjectRequest.U("requester".equals(str11));
            }
        }
        String str12 = transferRecord.z;
        if (str12 != null) {
            objectMetadata.M(str12);
        }
        String str13 = transferRecord.y;
        if (str13 != null) {
            putObjectRequest.E(new SSEAwsKeyManagementParams(str13));
        }
        putObjectRequest.C(objectMetadata);
        putObjectRequest.A(h(transferRecord.A));
        return putObjectRequest;
    }

    public final String i(PutObjectRequest putObjectRequest) {
        InitiateMultipartUploadRequest initiateMultipartUploadRequest = new InitiateMultipartUploadRequest(putObjectRequest.n(), putObjectRequest.r());
        initiateMultipartUploadRequest.x(putObjectRequest.o());
        initiateMultipartUploadRequest.z(putObjectRequest.s());
        initiateMultipartUploadRequest.A(putObjectRequest.u());
        initiateMultipartUploadRequest.B(putObjectRequest.x());
        TransferUtility.a(initiateMultipartUploadRequest);
        return this.a.b(initiateMultipartUploadRequest).h();
    }

    public final Boolean j() throws ExecutionException {
        long j;
        String str = this.b.n;
        if (str == null || str.isEmpty()) {
            PutObjectRequest putObjectRequestG = g(this.b);
            TransferUtility.a(putObjectRequestG);
            try {
                this.b.n = i(putObjectRequestG);
                TransferDBUtil transferDBUtil = this.c;
                TransferRecord transferRecord = this.b;
                transferDBUtil.r(transferRecord.a, transferRecord.n);
                j = 0;
            } catch (AmazonClientException e) {
                g.c("Error initiating multipart upload: " + this.b.a + " due to " + e.getMessage(), e);
                this.d.i(this.b.a, e);
                this.d.l(this.b.a, TransferState.FAILED);
                return Boolean.FALSE;
            }
        } else {
            long jL = this.c.l(this.b.a);
            if (jL > 0) {
                g.b(String.format("Resume transfer %d from %d bytes", Integer.valueOf(this.b.a), Long.valueOf(jL)));
            }
            j = jL;
        }
        UploadTaskProgressListener uploadTaskProgressListener = new UploadTaskProgressListener(j);
        TransferStatusUpdater transferStatusUpdater = this.d;
        TransferRecord transferRecord2 = this.b;
        transferStatusUpdater.k(transferRecord2.a, j, transferRecord2.f, false);
        TransferDBUtil transferDBUtil2 = this.c;
        TransferRecord transferRecord3 = this.b;
        this.f = transferDBUtil2.g(transferRecord3.a, transferRecord3.n);
        g.b("Multipart upload " + this.b.a + " in " + this.f.size() + " parts.");
        for (UploadPartRequest uploadPartRequest : this.f) {
            TransferUtility.a(uploadPartRequest);
            UploadPartTaskMetadata uploadPartTaskMetadata = new UploadPartTaskMetadata(this);
            uploadPartTaskMetadata.b = 0L;
            uploadPartTaskMetadata.c = TransferState.WAITING;
            this.e.put(Integer.valueOf(uploadPartRequest.s()), uploadPartTaskMetadata);
            uploadPartTaskMetadata.a = TransferThreadPool.c(new UploadPartTask(uploadPartTaskMetadata, uploadTaskProgressListener, uploadPartRequest, this.a, this.c));
        }
        try {
            Iterator<UploadPartTaskMetadata> it = this.e.values().iterator();
            boolean zBooleanValue = true;
            while (it.hasNext()) {
                zBooleanValue &= it.next().a.get().booleanValue();
            }
            if (!zBooleanValue) {
                try {
                    if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                        g.b("Network not connected. Setting the state to WAITING_FOR_NETWORK.");
                        this.d.l(this.b.a, TransferState.WAITING_FOR_NETWORK);
                        return Boolean.FALSE;
                    }
                } catch (TransferUtilityException e2) {
                    g.d("TransferUtilityException: [" + e2 + "]");
                }
            }
            g.b("Completing the multi-part upload transfer for " + this.b.a);
            try {
                TransferRecord transferRecord4 = this.b;
                f(transferRecord4.a, transferRecord4.k, transferRecord4.l, transferRecord4.n);
                TransferStatusUpdater transferStatusUpdater2 = this.d;
                TransferRecord transferRecord5 = this.b;
                int i = transferRecord5.a;
                long j2 = transferRecord5.f;
                transferStatusUpdater2.k(i, j2, j2, true);
                this.d.l(this.b.a, TransferState.COMPLETED);
                return Boolean.TRUE;
            } catch (AmazonClientException e3) {
                g.c("Failed to complete multipart: " + this.b.a + " due to " + e3.getMessage(), e3);
                TransferRecord transferRecord6 = this.b;
                a(transferRecord6.a, transferRecord6.k, transferRecord6.l, transferRecord6.n);
                this.d.i(this.b.a, e3);
                this.d.l(this.b.a, TransferState.FAILED);
                return Boolean.FALSE;
            }
        } catch (Exception e4) {
            g.d("Upload resulted in an exception. " + e4);
            Iterator<UploadPartTaskMetadata> it2 = this.e.values().iterator();
            while (it2.hasNext()) {
                it2.next().a.cancel(true);
            }
            if (TransferState.PENDING_CANCEL.equals(this.b.j)) {
                TransferStatusUpdater transferStatusUpdater3 = this.d;
                int i2 = this.b.a;
                TransferState transferState = TransferState.CANCELED;
                transferStatusUpdater3.l(i2, transferState);
                g.b("Transfer is " + transferState);
                return Boolean.FALSE;
            }
            if (TransferState.PENDING_PAUSE.equals(this.b.j)) {
                TransferStatusUpdater transferStatusUpdater4 = this.d;
                int i3 = this.b.a;
                TransferState transferState2 = TransferState.PAUSED;
                transferStatusUpdater4.l(i3, transferState2);
                g.b("Transfer is " + transferState2);
                return Boolean.FALSE;
            }
            for (UploadPartTaskMetadata uploadPartTaskMetadata2 : this.e.values()) {
                TransferState transferState3 = TransferState.WAITING_FOR_NETWORK;
                if (transferState3.equals(uploadPartTaskMetadata2.c)) {
                    g.b("Individual part is WAITING_FOR_NETWORK.");
                    this.d.l(this.b.a, transferState3);
                    return Boolean.FALSE;
                }
            }
            try {
                if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                    g.b("Network not connected. Setting the state to WAITING_FOR_NETWORK.");
                    this.d.l(this.b.a, TransferState.WAITING_FOR_NETWORK);
                    return Boolean.FALSE;
                }
            } catch (TransferUtilityException e5) {
                g.d("TransferUtilityException: [" + e5 + "]");
            }
            if (RetryUtils.b(e4)) {
                g.b("Transfer is interrupted. " + e4);
                this.d.l(this.b.a, TransferState.FAILED);
                return Boolean.FALSE;
            }
            g.c("Error encountered during multi-part upload: " + this.b.a + " due to " + e4.getMessage(), e4);
            this.d.i(this.b.a, e4);
            this.d.l(this.b.a, TransferState.FAILED);
            return Boolean.FALSE;
        }
    }

    public final Boolean k() {
        PutObjectRequest putObjectRequestG = g(this.b);
        ProgressListener progressListenerF = this.d.f(this.b.a);
        long length = putObjectRequestG.p().length();
        TransferUtility.b(putObjectRequestG);
        putObjectRequestG.h(progressListenerF);
        try {
            this.a.f(putObjectRequestG);
            this.d.k(this.b.a, length, length, true);
            this.d.l(this.b.a, TransferState.COMPLETED);
            return Boolean.TRUE;
        } catch (Exception e) {
            if (TransferState.PENDING_CANCEL.equals(this.b.j)) {
                TransferStatusUpdater transferStatusUpdater = this.d;
                int i = this.b.a;
                TransferState transferState = TransferState.CANCELED;
                transferStatusUpdater.l(i, transferState);
                g.b("Transfer is " + transferState);
                return Boolean.FALSE;
            }
            if (TransferState.PENDING_PAUSE.equals(this.b.j)) {
                TransferStatusUpdater transferStatusUpdater2 = this.d;
                int i2 = this.b.a;
                TransferState transferState2 = TransferState.PAUSED;
                transferStatusUpdater2.l(i2, transferState2);
                g.b("Transfer is " + transferState2);
                new ProgressEvent(0L).c(32);
                progressListenerF.a(new ProgressEvent(0L));
                return Boolean.FALSE;
            }
            try {
                if (TransferNetworkLossHandler.c() != null && !TransferNetworkLossHandler.c().e()) {
                    Log log = g;
                    log.b("Thread:[" + Thread.currentThread().getId() + "]: Network wasn't available.");
                    this.d.l(this.b.a, TransferState.WAITING_FOR_NETWORK);
                    log.a("Network Connection Interrupted: Moving the TransferState to WAITING_FOR_NETWORK");
                    new ProgressEvent(0L).c(32);
                    progressListenerF.a(new ProgressEvent(0L));
                    return Boolean.FALSE;
                }
            } catch (TransferUtilityException e2) {
                g.d("TransferUtilityException: [" + e2 + "]");
            }
            if (RetryUtils.b(e)) {
                g.b("Transfer is interrupted. " + e);
                this.d.l(this.b.a, TransferState.FAILED);
                return Boolean.FALSE;
            }
            g.a("Failed to upload: " + this.b.a + " due to " + e.getMessage());
            this.d.i(this.b.a, e);
            this.d.l(this.b.a, TransferState.FAILED);
            return Boolean.FALSE;
        }
    }
}

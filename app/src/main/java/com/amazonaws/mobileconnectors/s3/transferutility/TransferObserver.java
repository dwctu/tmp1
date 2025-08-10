package com.amazonaws.mobileconnectors.s3.transferutility;

import java.io.File;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes.dex */
public class TransferObserver {
    public final int a;
    public String b;
    public String c;
    public long d;
    public long e;
    public TransferState f;
    public String g;
    public TransferListener h;
    public TransferStatusListener i;

    public class TransferStatusListener implements TransferListener {
        public TransferStatusListener() {
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void a(int i, TransferState transferState) {
            TransferObserver.this.f = transferState;
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void b(int i, long j, long j2) {
            TransferObserver.this.e = j;
            TransferObserver.this.d = j2;
        }

        @Override // com.amazonaws.mobileconnectors.s3.transferutility.TransferListener
        public void c(int i, Exception exc) {
        }
    }

    public TransferObserver(int i, TransferDBUtil transferDBUtil, String str, String str2, File file) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.g = file.getAbsolutePath();
        this.d = file.length();
        this.f = TransferState.WAITING;
    }

    public void d() {
        synchronized (this) {
            TransferListener transferListener = this.h;
            if (transferListener != null) {
                TransferStatusUpdater.j(this.a, transferListener);
                this.h = null;
            }
            TransferStatusListener transferStatusListener = this.i;
            if (transferStatusListener != null) {
                TransferStatusUpdater.j(this.a, transferStatusListener);
                this.i = null;
            }
        }
    }

    public void e(TransferListener transferListener) {
        synchronized (this) {
            d();
            if (this.i == null) {
                TransferStatusListener transferStatusListener = new TransferStatusListener();
                this.i = transferStatusListener;
                TransferStatusUpdater.g(this.a, transferStatusListener);
            }
            if (transferListener != null) {
                this.h = transferListener;
                transferListener.a(this.a, this.f);
                TransferStatusUpdater.g(this.a, this.h);
            }
        }
    }

    public String toString() {
        return "TransferObserver{id=" + this.a + ", bucket='" + this.b + "', key='" + this.c + "', bytesTotal=" + this.d + ", bytesTransferred=" + this.e + ", transferState=" + this.f + ", filePath='" + this.g + '\'' + MessageFormatter.DELIM_STOP;
    }

    public TransferObserver(int i, TransferDBUtil transferDBUtil, String str, String str2, File file, TransferListener transferListener) {
        this(i, transferDBUtil, str, str2, file);
        e(transferListener);
    }
}

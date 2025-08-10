package com.amazonaws.retry;

import com.amazonaws.AbortedException;
import com.amazonaws.AmazonServiceException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;

/* loaded from: classes.dex */
public class RetryUtils {
    public static boolean a(AmazonServiceException amazonServiceException) {
        if (amazonServiceException == null) {
            return false;
        }
        String strA = amazonServiceException.a();
        return "RequestTimeTooSkewed".equals(strA) || "RequestExpired".equals(strA) || "InvalidSignatureException".equals(strA) || "SignatureDoesNotMatch".equals(strA);
    }

    public static boolean b(Throwable th) {
        if (th instanceof AbortedException) {
            return true;
        }
        if (th.getCause() == null) {
            return false;
        }
        Throwable cause = th.getCause();
        return (cause instanceof InterruptedException) || ((cause instanceof InterruptedIOException) && !(cause instanceof SocketTimeoutException));
    }

    public static boolean c(AmazonServiceException amazonServiceException) {
        if (amazonServiceException == null) {
            return false;
        }
        String strA = amazonServiceException.a();
        return "Throttling".equals(strA) || "ThrottlingException".equals(strA) || "ProvisionedThroughputExceededException".equals(strA);
    }
}

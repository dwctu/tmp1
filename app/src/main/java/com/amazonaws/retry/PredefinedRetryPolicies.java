package com.amazonaws.retry;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.retry.RetryPolicy;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Random;

/* loaded from: classes.dex */
public class PredefinedRetryPolicies {
    public static final RetryPolicy a = new RetryPolicy(RetryPolicy.RetryCondition.a, RetryPolicy.BackoffStrategy.a, 0, false);
    public static final RetryPolicy.RetryCondition c = new SDKDefaultRetryCondition();
    public static final RetryPolicy.BackoffStrategy d = new SDKDefaultBackoffStrategy(100, 20000);
    public static final RetryPolicy b = a();

    public static final class SDKDefaultBackoffStrategy implements RetryPolicy.BackoffStrategy {
        public final Random b;
        public final int c;
        public final int d;

        @Override // com.amazonaws.retry.RetryPolicy.BackoffStrategy
        public final long a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i) {
            if (i <= 0) {
                return 0L;
            }
            return this.b.nextInt(Math.min(this.d, (1 << i) * this.c));
        }

        public SDKDefaultBackoffStrategy(int i, int i2) {
            this.b = new Random();
            this.c = i;
            this.d = i2;
        }
    }

    public static class SDKDefaultRetryCondition implements RetryPolicy.RetryCondition {
        @Override // com.amazonaws.retry.RetryPolicy.RetryCondition
        public boolean a(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i) {
            if ((amazonClientException.getCause() instanceof IOException) && !(amazonClientException.getCause() instanceof InterruptedIOException)) {
                return true;
            }
            if (!(amazonClientException instanceof AmazonServiceException)) {
                return false;
            }
            AmazonServiceException amazonServiceException = (AmazonServiceException) amazonClientException;
            int iE = amazonServiceException.e();
            return iE == 500 || iE == 503 || iE == 502 || iE == 504 || RetryUtils.c(amazonServiceException) || RetryUtils.a(amazonServiceException);
        }
    }

    static {
        b();
    }

    public static RetryPolicy a() {
        return new RetryPolicy(c, d, 3, true);
    }

    public static RetryPolicy b() {
        return new RetryPolicy(c, d, 10, true);
    }
}

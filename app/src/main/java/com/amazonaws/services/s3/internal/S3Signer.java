package com.amazonaws.services.s3.internal;

import com.amazonaws.Request;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.auth.AbstractAWSSigner;
import com.amazonaws.auth.SigningAlgorithm;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.HttpUtils;
import com.google.common.net.HttpHeaders;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes.dex */
public class S3Signer extends AbstractAWSSigner {
    public static final Log d = LogFactory.b(S3Signer.class);
    public final String a;
    public final String b;
    public final Set<String> c;

    public S3Signer() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public void a(Request<?> request, AWSCredentials aWSCredentials, Date date) throws UnsupportedEncodingException {
        if (this.b == null) {
            throw new UnsupportedOperationException("Cannot sign a request using a dummy S3Signer instance with no resource path");
        }
        if (aWSCredentials == null || aWSCredentials.b() == null) {
            d.a("Canonical string will not be signed, as no AWS Secret Key was provided");
            return;
        }
        AWSCredentials aWSCredentialsSanitizeCredentials = sanitizeCredentials(aWSCredentials);
        if (aWSCredentialsSanitizeCredentials instanceof AWSSessionCredentials) {
            addSessionCredentials(request, (AWSSessionCredentials) aWSCredentialsSanitizeCredentials);
        }
        String strB = HttpUtils.b(request.s().getPath(), this.b, true);
        Date signatureDate = getSignatureDate(getTimeOffset(request));
        if (date == null) {
            date = signatureDate;
        }
        request.i("Date", ServiceUtils.c(date));
        String strA = RestUtils.a(this.a, strB, request, null, this.c);
        d.a("Calculated string to sign:\n\"" + strA + "\"");
        request.i(HttpHeaders.AUTHORIZATION, "AWS " + aWSCredentialsSanitizeCredentials.a() + SignatureImpl.INNER_SEP + super.signAndBase64Encode(strA, aWSCredentialsSanitizeCredentials.b(), SigningAlgorithm.HmacSHA1));
    }

    @Override // com.amazonaws.auth.AbstractAWSSigner
    public void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.i("x-amz-security-token", aWSSessionCredentials.getSessionToken());
    }

    @Override // com.amazonaws.auth.Signer
    public void sign(Request<?> request, AWSCredentials aWSCredentials) throws UnsupportedEncodingException {
        a(request, aWSCredentials, null);
    }

    public S3Signer(String str, String str2) {
        this(str, str2, null);
    }

    public S3Signer(String str, String str2, Collection<String> collection) {
        if (str2 != null) {
            this.a = str;
            this.b = str2;
            this.c = collection == null ? null : Collections.unmodifiableSet(new HashSet(collection));
            return;
        }
        throw new IllegalArgumentException("Parameter resourcePath is empty");
    }
}

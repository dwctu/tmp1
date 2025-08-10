package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.AwsHostNameUtils;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.HttpUtils;
import com.amazonaws.util.StringUtils;
import com.broadcom.bt.util.io.IOUtils;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import org.aspectj.runtime.reflect.SignatureImpl;

/* loaded from: classes.dex */
public class AWS4Signer extends AbstractAWSSigner implements ServiceAwareSigner, RegionAwareSigner {
    public static final String ALGORITHM = "AWS4-HMAC-SHA256";
    private static final String DATE_PATTERN = "yyyyMMdd";
    private static final long MAX_EXPIRATION_TIME_IN_SECONDS = 604800;
    private static final long MILLISEC = 1000;
    public static final String TERMINATOR = "aws4_request";
    private static final String TIME_PATTERN = "yyyyMMdd'T'HHmmss'Z'";
    public static final Log log = LogFactory.b(AWS4Signer.class);
    public boolean doubleUrlEncode;
    public Date overriddenDate;
    public String regionName;
    public String serviceName;

    public static class HeaderSigningResult {
        public final String a;
        public final String b;
        public final byte[] c;
        public final byte[] d;

        public HeaderSigningResult(String str, String str2, byte[] bArr, byte[] bArr2) {
            this.a = str;
            this.b = str2;
            this.c = bArr;
            this.d = bArr2;
        }

        public String a() {
            return this.a;
        }

        public byte[] b() {
            byte[] bArr = this.c;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }

        public String c() {
            return this.b;
        }

        public byte[] d() {
            byte[] bArr = this.d;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
    }

    public AWS4Signer() {
        this(true);
    }

    public void addHostHeader(Request<?> request) {
        String host = request.s().getHost();
        if (HttpUtils.e(request.s())) {
            host = host + SignatureImpl.INNER_SEP + request.s().getPort();
        }
        request.i(HttpHeaders.HOST, host);
    }

    @Override // com.amazonaws.auth.AbstractAWSSigner
    public void addSessionCredentials(Request<?> request, AWSSessionCredentials aWSSessionCredentials) {
        request.i("x-amz-security-token", aWSSessionCredentials.getSessionToken());
    }

    public String calculateContentHash(Request<?> request) throws IOException {
        InputStream binaryRequestPayloadStream = getBinaryRequestPayloadStream(request);
        binaryRequestPayloadStream.mark(-1);
        String strA = BinaryUtils.a(hash(binaryRequestPayloadStream));
        try {
            binaryRequestPayloadStream.reset();
            return strA;
        } catch (IOException e) {
            throw new AmazonClientException("Unable to reset stream after calculating AWS4 signature", e);
        }
    }

    public String calculateContentHashPresign(Request<?> request) {
        return calculateContentHash(request);
    }

    public final HeaderSigningResult computeSignature(Request<?> request, String str, String str2, String str3, String str4, AWSCredentials aWSCredentials) {
        String strExtractRegionName = extractRegionName(request.s());
        String strExtractServiceName = extractServiceName(request.s());
        String str5 = str + "/" + strExtractRegionName + "/" + strExtractServiceName + "/" + TERMINATOR;
        String stringToSign = getStringToSign(str3, str2, str5, getCanonicalRequest(request, str4));
        String str6 = "AWS4" + aWSCredentials.b();
        Charset charset = StringUtils.a;
        byte[] bytes = str6.getBytes(charset);
        SigningAlgorithm signingAlgorithm = SigningAlgorithm.HmacSHA256;
        byte[] bArrSign = sign(TERMINATOR, sign(strExtractServiceName, sign(strExtractRegionName, sign(str, bytes, signingAlgorithm), signingAlgorithm), signingAlgorithm), signingAlgorithm);
        return new HeaderSigningResult(str2, str5, bArrSign, sign(stringToSign.getBytes(charset), bArrSign, signingAlgorithm));
    }

    public String extractRegionName(URI uri) {
        String str = this.regionName;
        return str != null ? str : AwsHostNameUtils.a(uri.getHost(), this.serviceName);
    }

    public String extractServiceName(URI uri) {
        String str = this.serviceName;
        return str != null ? str : AwsHostNameUtils.c(uri);
    }

    public String getCanonicalRequest(Request<?> request, String str) {
        String str2 = request.n().toString() + IOUtils.LINE_SEPARATOR_UNIX + getCanonicalizedResourcePath(request.d() != null ? HttpUtils.c(request.s().getPath(), request.d()) : HttpUtils.a(request.s().getPath(), request.q()), this.doubleUrlEncode) + IOUtils.LINE_SEPARATOR_UNIX + getCanonicalizedQueryString(request) + IOUtils.LINE_SEPARATOR_UNIX + getCanonicalizedHeaderString(request) + IOUtils.LINE_SEPARATOR_UNIX + getSignedHeadersString(request) + IOUtils.LINE_SEPARATOR_UNIX + str;
        log.a("AWS4 Canonical Request: '\"" + str2 + "\"");
        return str2;
    }

    public String getCanonicalizedHeaderString(Request<?> request) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.addAll(request.getHeaders().keySet());
        Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            if (needsSign(str)) {
                String strReplaceAll = StringUtils.b(str).replaceAll("\\s+", " ");
                String str2 = request.getHeaders().get(str);
                sb.append(strReplaceAll);
                sb.append(SignatureImpl.INNER_SEP);
                if (str2 != null) {
                    sb.append(str2.replaceAll("\\s+", " "));
                }
                sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            }
        }
        return sb.toString();
    }

    public final long getDateFromRequest(Request<?> request) {
        Date signatureDate = getSignatureDate(getTimeOffset(request));
        Date date = this.overriddenDate;
        if (date != null) {
            signatureDate = date;
        }
        return signatureDate.getTime();
    }

    public final String getDateStamp(long j) {
        return DateUtils.c(DATE_PATTERN, new Date(j));
    }

    public String getScope(Request<?> request, String str) {
        return str + "/" + extractRegionName(request.s()) + "/" + extractServiceName(request.s()) + "/" + TERMINATOR;
    }

    public String getSignedHeadersString(Request<?> request) {
        ArrayList<String> arrayList = new ArrayList();
        arrayList.addAll(request.getHeaders().keySet());
        Collections.sort(arrayList, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            if (needsSign(str)) {
                if (sb.length() > 0) {
                    sb.append(";");
                }
                sb.append(StringUtils.b(str));
            }
        }
        return sb.toString();
    }

    public String getStringToSign(String str, String str2, String str3, String str4) {
        String str5 = str + IOUtils.LINE_SEPARATOR_UNIX + str2 + IOUtils.LINE_SEPARATOR_UNIX + str3 + IOUtils.LINE_SEPARATOR_UNIX + BinaryUtils.a(hash(str4));
        log.a("AWS4 String to Sign: '\"" + str5 + "\"");
        return str5;
    }

    public final String getTimeStamp(long j) {
        return DateUtils.c(TIME_PATTERN, new Date(j));
    }

    public boolean needsSign(String str) {
        return "date".equalsIgnoreCase(str) || HttpHeaders.CONTENT_MD5.equalsIgnoreCase(str) || "host".equalsIgnoreCase(str) || str.startsWith("x-amz") || str.startsWith("X-Amz");
    }

    public void overrideDate(Date date) {
        this.overriddenDate = date;
    }

    public void presignRequest(Request<?> request, AWSCredentials aWSCredentials, Date date) {
        long time = date != null ? (date.getTime() - System.currentTimeMillis()) / 1000 : 604800L;
        if (time > MAX_EXPIRATION_TIME_IN_SECONDS) {
            throw new AmazonClientException("Requests that are pre-signed by SigV4 algorithm are valid for at most 7 days. The expiration date set on the current request [" + getTimeStamp(date.getTime()) + "] has exceeded this limit.");
        }
        addHostHeader(request);
        AWSCredentials aWSCredentialsSanitizeCredentials = sanitizeCredentials(aWSCredentials);
        if (aWSCredentialsSanitizeCredentials instanceof AWSSessionCredentials) {
            request.g("X-Amz-Security-Token", ((AWSSessionCredentials) aWSCredentialsSanitizeCredentials).getSessionToken());
        }
        long dateFromRequest = getDateFromRequest(request);
        String dateStamp = getDateStamp(dateFromRequest);
        String str = aWSCredentialsSanitizeCredentials.a() + "/" + getScope(request, dateStamp);
        String timeStamp = getTimeStamp(dateFromRequest);
        request.g("X-Amz-Algorithm", ALGORITHM);
        request.g("X-Amz-Date", timeStamp);
        request.g("X-Amz-SignedHeaders", getSignedHeadersString(request));
        request.g("X-Amz-Expires", Long.toString(time));
        request.g("X-Amz-Credential", str);
        request.g("X-Amz-Signature", BinaryUtils.a(computeSignature(request, dateStamp, timeStamp, ALGORITHM, calculateContentHashPresign(request), aWSCredentialsSanitizeCredentials).d()));
    }

    public void processRequestPayload(Request<?> request, HeaderSigningResult headerSigningResult) {
    }

    @Override // com.amazonaws.auth.RegionAwareSigner
    public void setRegionName(String str) {
        this.regionName = str;
    }

    @Override // com.amazonaws.auth.ServiceAwareSigner
    public void setServiceName(String str) {
        this.serviceName = str;
    }

    @Override // com.amazonaws.auth.Signer
    public void sign(Request<?> request, AWSCredentials aWSCredentials) throws IOException {
        AWSCredentials aWSCredentialsSanitizeCredentials = sanitizeCredentials(aWSCredentials);
        if (aWSCredentialsSanitizeCredentials instanceof AWSSessionCredentials) {
            addSessionCredentials(request, (AWSSessionCredentials) aWSCredentialsSanitizeCredentials);
        }
        addHostHeader(request);
        long dateFromRequest = getDateFromRequest(request);
        String dateStamp = getDateStamp(dateFromRequest);
        String scope = getScope(request, dateStamp);
        String strCalculateContentHash = calculateContentHash(request);
        String timeStamp = getTimeStamp(dateFromRequest);
        request.i("X-Amz-Date", timeStamp);
        if (request.getHeaders().get("x-amz-content-sha256") != null && "required".equals(request.getHeaders().get("x-amz-content-sha256"))) {
            request.i("x-amz-content-sha256", strCalculateContentHash);
        }
        String str = aWSCredentialsSanitizeCredentials.a() + "/" + scope;
        HeaderSigningResult headerSigningResultComputeSignature = computeSignature(request, dateStamp, timeStamp, ALGORITHM, strCalculateContentHash, aWSCredentialsSanitizeCredentials);
        request.i(HttpHeaders.AUTHORIZATION, "AWS4-HMAC-SHA256 " + ("Credential=" + str) + ", " + ("SignedHeaders=" + getSignedHeadersString(request)) + ", " + ("Signature=" + BinaryUtils.a(headerSigningResultComputeSignature.d())));
        processRequestPayload(request, headerSigningResultComputeSignature);
    }

    public AWS4Signer(boolean z) {
        this.doubleUrlEncode = z;
    }
}

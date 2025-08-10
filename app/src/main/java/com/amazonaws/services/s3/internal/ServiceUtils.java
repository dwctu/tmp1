package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.Request;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.S3ClientOptions;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazonaws.util.DateUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

/* loaded from: classes.dex */
public class ServiceUtils {
    public static final Log a = LogFactory.b(ServiceUtils.class);

    public static URL a(Request<?> request) {
        return b(request, false);
    }

    public static URL b(Request<?> request, boolean z) throws UnsupportedEncodingException {
        String str;
        boolean z2 = true;
        String strB = S3HttpUtils.b(request.q(), true);
        if (z && strB.startsWith("/")) {
            strB = strB.substring(1);
        }
        String str2 = request.s() + ("/" + strB).replaceAll("(?<=/)/", "%2F");
        for (String str3 : request.getParameters().keySet()) {
            if (z2) {
                str = str2 + "?";
                z2 = false;
            } else {
                str = str2 + ContainerUtils.FIELD_DELIMITER;
            }
            str2 = str + str3 + "=" + S3HttpUtils.b(request.getParameters().get(str3), false);
        }
        try {
            return new URL(str2);
        } catch (MalformedURLException e) {
            throw new AmazonClientException("Unable to convert request to well formed URL: " + e.getMessage(), e);
        }
    }

    public static String c(Date date) {
        return DateUtils.d(date);
    }

    public static String d(List<String> list) {
        String str = "";
        boolean z = true;
        for (String str2 : list) {
            if (!z) {
                str = str + ", ";
            }
            str = str + str2;
            z = false;
        }
        return str;
    }

    public static Date e(String str) {
        return DateUtils.h(str);
    }

    public static Date f(String str) {
        return DateUtils.i(str);
    }

    public static String g(String str) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.startsWith("\"")) {
            strTrim = strTrim.substring(1);
        }
        return strTrim.endsWith("\"") ? strTrim.substring(0, strTrim.length() - 1) : strTrim;
    }

    public static boolean h(AmazonWebServiceRequest amazonWebServiceRequest, S3ClientOptions s3ClientOptions) {
        if ((s3ClientOptions != null && s3ClientOptions.b()) || System.getProperty("com.amazonaws.services.s3.disableGetObjectMD5Validation") != null) {
            return true;
        }
        if (amazonWebServiceRequest instanceof GetObjectRequest) {
            GetObjectRequest getObjectRequest = (GetObjectRequest) amazonWebServiceRequest;
            if (getObjectRequest.p() != null || getObjectRequest.r() != null) {
                return true;
            }
        } else {
            if (!(amazonWebServiceRequest instanceof PutObjectRequest)) {
                return (amazonWebServiceRequest instanceof UploadPartRequest) && ((UploadPartRequest) amazonWebServiceRequest).u() != null;
            }
            PutObjectRequest putObjectRequest = (PutObjectRequest) amazonWebServiceRequest;
            ObjectMetadata objectMetadataS = putObjectRequest.s();
            if ((objectMetadataS != null && objectMetadataS.z() != null) || putObjectRequest.v() != null) {
                return true;
            }
            if (putObjectRequest.u() != null && (putObjectRequest.u().b() != null || putObjectRequest.u().a() != null)) {
                return true;
            }
        }
        return false;
    }
}

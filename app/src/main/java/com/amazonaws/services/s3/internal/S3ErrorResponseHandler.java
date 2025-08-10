package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.http.HttpResponseHandler;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.util.IOUtils;
import com.amazonaws.util.XpathUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.w3c.dom.Document;

/* loaded from: classes.dex */
public class S3ErrorResponseHandler implements HttpResponseHandler<AmazonServiceException> {
    public static final Log a = LogFactory.b(S3ErrorResponseHandler.class);

    @Override // com.amazonaws.http.HttpResponseHandler
    public boolean b() {
        return false;
    }

    public final AmazonServiceException.ErrorType c(int i) {
        return i >= 500 ? AmazonServiceException.ErrorType.Service : AmazonServiceException.ErrorType.Client;
    }

    @Override // com.amazonaws.http.HttpResponseHandler
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public AmazonServiceException a(HttpResponse httpResponse) throws IOException {
        InputStream inputStreamB = httpResponse.b();
        if (inputStreamB == null) {
            return e(httpResponse.f(), httpResponse);
        }
        try {
            String string = IOUtils.toString(inputStreamB);
            try {
                Document documentD = XpathUtils.d(string);
                String strB = XpathUtils.b("Error/Message", documentD);
                String strB2 = XpathUtils.b("Error/Code", documentD);
                String strB3 = XpathUtils.b("Error/RequestId", documentD);
                String strB4 = XpathUtils.b("Error/HostId", documentD);
                AmazonS3Exception amazonS3Exception = new AmazonS3Exception(strB);
                int iE = httpResponse.e();
                amazonS3Exception.k(iE);
                amazonS3Exception.h(c(iE));
                amazonS3Exception.f(strB2);
                amazonS3Exception.i(strB3);
                amazonS3Exception.p(strB4);
                amazonS3Exception.o(httpResponse.c().get("X-Amz-Cf-Id"));
                return amazonS3Exception;
            } catch (Exception e) {
                Log log = a;
                if (log.isDebugEnabled()) {
                    log.e("Failed in parsing the response as XML: " + string, e);
                }
                return e(string, httpResponse);
            }
        } catch (IOException e2) {
            if (a.isDebugEnabled()) {
                a.e("Failed in reading the error response", e2);
            }
            return e(httpResponse.f(), httpResponse);
        }
    }

    public final AmazonS3Exception e(String str, HttpResponse httpResponse) {
        AmazonS3Exception amazonS3Exception = new AmazonS3Exception(str);
        int iE = httpResponse.e();
        amazonS3Exception.f(iE + " " + httpResponse.f());
        amazonS3Exception.k(iE);
        amazonS3Exception.h(c(iE));
        Map<String, String> mapC = httpResponse.c();
        amazonS3Exception.i(mapC.get("x-amz-request-id"));
        amazonS3Exception.p(mapC.get("x-amz-id-2"));
        amazonS3Exception.o(mapC.get("X-Amz-Cf-Id"));
        HashMap map = new HashMap();
        map.put("x-amz-bucket-region", mapC.get("x-amz-bucket-region"));
        amazonS3Exception.n(map);
        return amazonS3Exception;
    }
}

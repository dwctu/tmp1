package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.transform.Unmarshaller;
import java.io.InputStream;
import java.util.Map;

/* loaded from: classes.dex */
public class S3XmlResponseHandler<T> extends AbstractS3ResponseHandler<T> {
    public static final Log e = LogFactory.c("com.amazonaws.request");
    public Unmarshaller<T, InputStream> c;
    public Map<String, String> d;

    public S3XmlResponseHandler(Unmarshaller<T, InputStream> unmarshaller) {
        this.c = unmarshaller;
    }

    @Override // com.amazonaws.http.HttpResponseHandler
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public AmazonWebServiceResponse<T> a(HttpResponse httpResponse) throws Exception {
        AmazonWebServiceResponse<T> amazonWebServiceResponseC = c(httpResponse);
        this.d = httpResponse.c();
        if (this.c != null) {
            Log log = e;
            log.h("Beginning to parse service response XML");
            T tA = this.c.a(httpResponse.b());
            log.h("Done parsing service response XML");
            amazonWebServiceResponseC.d(tA);
        }
        return amazonWebServiceResponseC;
    }
}

package com.amazonaws.services.s3.internal;

import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.http.HttpResponse;
import com.amazonaws.util.StringUtils;
import java.io.InputStream;

/* loaded from: classes.dex */
public class S3StringResponseHandler extends AbstractS3ResponseHandler<String> {
    @Override // com.amazonaws.http.HttpResponseHandler
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public AmazonWebServiceResponse<String> a(HttpResponse httpResponse) throws Exception {
        AmazonWebServiceResponse<String> amazonWebServiceResponseC = c(httpResponse);
        byte[] bArr = new byte[1024];
        StringBuilder sb = new StringBuilder();
        InputStream inputStreamB = httpResponse.b();
        while (true) {
            int i = inputStreamB.read(bArr);
            if (i <= 0) {
                amazonWebServiceResponseC.d(sb.toString());
                return amazonWebServiceResponseC;
            }
            sb.append(new String(bArr, 0, i, StringUtils.a));
        }
    }
}

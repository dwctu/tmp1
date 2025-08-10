package com.amazonaws.services.s3.model.transform;

import com.amazonaws.services.s3.internal.XmlWriter;
import com.amazonaws.services.s3.model.PartETag;
import com.google.common.net.HttpHeaders;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class RequestXmlFactory {
    public static byte[] a(List<PartETag> list) {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.d("CompleteMultipartUpload");
        if (list != null) {
            Collections.sort(list, new Comparator<PartETag>() { // from class: com.amazonaws.services.s3.model.transform.RequestXmlFactory.1
                @Override // java.util.Comparator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(PartETag partETag, PartETag partETag2) {
                    if (partETag.b() < partETag2.b()) {
                        return -1;
                    }
                    return partETag.b() > partETag2.b() ? 1 : 0;
                }
            });
            for (PartETag partETag : list) {
                xmlWriter.d("Part");
                xmlWriter.d("PartNumber");
                xmlWriter.e(Integer.toString(partETag.b()));
                xmlWriter.b();
                xmlWriter.d(HttpHeaders.ETAG);
                xmlWriter.e(partETag.a());
                xmlWriter.b();
                xmlWriter.b();
            }
        }
        xmlWriter.b();
        return xmlWriter.c();
    }
}

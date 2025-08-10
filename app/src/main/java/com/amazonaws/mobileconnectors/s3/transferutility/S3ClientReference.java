package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.services.s3.AmazonS3;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class S3ClientReference {
    public static Map<Integer, AmazonS3> a = new ConcurrentHashMap();

    public static AmazonS3 a(Integer num) {
        return a.get(num);
    }

    public static void b(Integer num, AmazonS3 amazonS3) {
        a.put(num, amazonS3);
    }

    public static void c(Integer num) {
        a.remove(num);
    }
}

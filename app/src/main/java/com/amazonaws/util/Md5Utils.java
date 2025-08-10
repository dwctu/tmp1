package com.amazonaws.util;

import com.amazonaws.logging.LogFactory;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public class Md5Utils {
    public static byte[] a(File file) throws IOException {
        return b(new FileInputStream(file));
    }

    public static byte[] b(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                byte[] bArr = new byte[16384];
                while (true) {
                    int i = bufferedInputStream.read(bArr, 0, 16384);
                    if (i == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, i);
                }
                return messageDigest.digest();
            } finally {
                try {
                    bufferedInputStream.close();
                } catch (Exception e) {
                    LogFactory.b(Md5Utils.class).a("Unable to close input stream of hash candidate: " + e);
                }
            }
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static String c(File file) throws IOException {
        return Base64.encodeAsString(a(file));
    }

    public static String d(InputStream inputStream) throws IOException {
        return Base64.encodeAsString(b(inputStream));
    }
}

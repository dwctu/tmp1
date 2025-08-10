package org.jivesoftware.smackx.bytestreams.socks5;

import java.io.DataInputStream;
import java.io.IOException;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.util.SHA1;

/* loaded from: classes5.dex */
public class Socks5Utils {
    public static String createDigest(String str, String str2, String str3) {
        return SHA1.hex(str + str2 + str3);
    }

    public static byte[] receiveSocks5Message(DataInputStream dataInputStream) throws SmackException, IOException {
        byte[] bArr = new byte[5];
        dataInputStream.readFully(bArr, 0, 5);
        if (bArr[3] != 3) {
            throw new SmackException("Unsupported SOCKS5 address type");
        }
        int i = bArr[4];
        byte[] bArr2 = new byte[i + 7];
        System.arraycopy(bArr, 0, bArr2, 0, 5);
        dataInputStream.readFully(bArr2, 5, i + 2);
        return bArr2;
    }
}

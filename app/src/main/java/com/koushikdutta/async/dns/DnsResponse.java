package com.koushikdutta.async.dns;

import com.broadcom.bt.util.io.IOUtils;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.http.Multimap;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class DnsResponse {
    public InetSocketAddress source;
    public ArrayList<InetAddress> addresses = new ArrayList<>();
    public ArrayList<String> names = new ArrayList<>();
    public Multimap txt = new Multimap();

    public static DnsResponse parse(ByteBufferList byteBufferList) {
        ByteBuffer all = byteBufferList.getAll();
        byteBufferList.add(all.duplicate());
        byteBufferList.order(ByteOrder.BIG_ENDIAN);
        byteBufferList.getShort();
        byteBufferList.getShort();
        short s = byteBufferList.getShort();
        short s2 = byteBufferList.getShort();
        short s3 = byteBufferList.getShort();
        short s4 = byteBufferList.getShort();
        for (int i = 0; i < s; i++) {
            parseName(byteBufferList, all);
            byteBufferList.getShort();
            byteBufferList.getShort();
        }
        DnsResponse dnsResponse = new DnsResponse();
        for (int i2 = 0; i2 < s2; i2++) {
            parseName(byteBufferList, all);
            short s5 = byteBufferList.getShort();
            byteBufferList.getShort();
            byteBufferList.getInt();
            int i3 = byteBufferList.getShort();
            if (s5 == 1) {
                try {
                    byte[] bArr = new byte[i3];
                    byteBufferList.get(bArr);
                    dnsResponse.addresses.add(InetAddress.getByAddress(bArr));
                } catch (Exception unused) {
                }
            } else if (s5 == 12) {
                dnsResponse.names.add(parseName(byteBufferList, all));
            } else if (s5 == 16) {
                ByteBufferList byteBufferList2 = new ByteBufferList();
                byteBufferList.get(byteBufferList2, i3);
                dnsResponse.parseTxt(byteBufferList2);
            } else {
                byteBufferList.get(new byte[i3]);
            }
        }
        for (int i4 = 0; i4 < s3; i4++) {
            parseName(byteBufferList, all);
            byteBufferList.getShort();
            byteBufferList.getShort();
            byteBufferList.getInt();
            try {
                byteBufferList.get(new byte[byteBufferList.getShort()]);
            } catch (Exception unused2) {
            }
        }
        for (int i5 = 0; i5 < s4; i5++) {
            parseName(byteBufferList, all);
            short s6 = byteBufferList.getShort();
            byteBufferList.getShort();
            byteBufferList.getInt();
            int i6 = byteBufferList.getShort();
            if (s6 == 16) {
                try {
                    ByteBufferList byteBufferList3 = new ByteBufferList();
                    byteBufferList.get(byteBufferList3, i6);
                    dnsResponse.parseTxt(byteBufferList3);
                } catch (Exception unused3) {
                }
            } else {
                byteBufferList.get(new byte[i6]);
            }
        }
        return dnsResponse;
    }

    private static String parseName(ByteBufferList byteBufferList, ByteBuffer byteBuffer) {
        byteBufferList.order(ByteOrder.BIG_ENDIAN);
        String str = "";
        while (true) {
            int i = byteBufferList.get() & 255;
            if (i == 0) {
                return str;
            }
            if ((i & 192) == 192) {
                int i2 = (byteBufferList.get() & 255) | ((i & 63) << 8);
                if (str.length() > 0) {
                    str = str + ".";
                }
                ByteBufferList byteBufferList2 = new ByteBufferList();
                ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                byteBufferDuplicate.get(new byte[i2]);
                byteBufferList2.add(byteBufferDuplicate);
                return str + parseName(byteBufferList2, byteBuffer);
            }
            byte[] bArr = new byte[i];
            byteBufferList.get(bArr);
            if (str.length() > 0) {
                str = str + ".";
            }
            str = str + new String(bArr);
        }
    }

    public void parseTxt(ByteBufferList byteBufferList) {
        while (byteBufferList.hasRemaining()) {
            byte[] bArr = new byte[byteBufferList.get() & 255];
            byteBufferList.get(bArr);
            String[] strArrSplit = new String(bArr).split("=");
            this.txt.add(strArrSplit[0], strArrSplit[1]);
        }
    }

    public String toString() {
        Iterator<InetAddress> it = this.addresses.iterator();
        String str = "addresses:\n";
        while (it.hasNext()) {
            str = str + it.next().toString() + IOUtils.LINE_SEPARATOR_UNIX;
        }
        String str2 = str + "names:\n";
        Iterator<String> it2 = this.names.iterator();
        while (it2.hasNext()) {
            str2 = str2 + it2.next() + IOUtils.LINE_SEPARATOR_UNIX;
        }
        return str2;
    }
}

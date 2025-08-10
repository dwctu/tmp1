package com.wear.network.protocol.cookie.persistence;

import dc.ic4;
import dc.nd3;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class SerializableCookie implements Serializable {
    private static final long serialVersionUID = -8594045714036645534L;
    private transient ic4 cookie;
    private static final String TAG = SerializableCookie.class.getSimpleName();
    private static long NON_VALID_EXPIRES_AT = -1;

    private static String byteArrayToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            int i = b & 255;
            if (i < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(i));
        }
        return sb.toString();
    }

    private static byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        ic4.a aVar = new ic4.a();
        aVar.g((String) objectInputStream.readObject());
        aVar.j((String) objectInputStream.readObject());
        long j = objectInputStream.readLong();
        if (j != NON_VALID_EXPIRES_AT) {
            aVar.d(j);
        }
        String str = (String) objectInputStream.readObject();
        aVar.b(str);
        aVar.h((String) objectInputStream.readObject());
        if (objectInputStream.readBoolean()) {
            aVar.i();
        }
        if (objectInputStream.readBoolean()) {
            aVar.f();
        }
        if (objectInputStream.readBoolean()) {
            aVar.e(str);
        }
        this.cookie = aVar.a();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.cookie.h());
        objectOutputStream.writeObject(this.cookie.t());
        objectOutputStream.writeLong(this.cookie.q() ? this.cookie.d() : NON_VALID_EXPIRES_AT);
        objectOutputStream.writeObject(this.cookie.b());
        objectOutputStream.writeObject(this.cookie.o());
        objectOutputStream.writeBoolean(this.cookie.r());
        objectOutputStream.writeBoolean(this.cookie.f());
        objectOutputStream.writeBoolean(this.cookie.e());
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0023 A[EXC_TOP_SPLITTER, PHI: r1 r3
  0x0023: PHI (r1v7 java.io.ObjectInputStream) = (r1v5 java.io.ObjectInputStream), (r1v6 java.io.ObjectInputStream), (r1v8 java.io.ObjectInputStream) binds: [B:19:0x0033, B:22:0x0037, B:8:0x001b] A[DONT_GENERATE, DONT_INLINE]
  0x0023: PHI (r3v9 dc.ic4) = (r3v3 dc.ic4), (r3v3 dc.ic4), (r3v13 dc.ic4) binds: [B:19:0x0033, B:22:0x0037, B:8:0x001b] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public dc.ic4 decode(java.lang.String r3) throws java.lang.Throwable {
        /*
            r2 = this;
            java.lang.String r0 = dc.nd3.e(r3)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto Lb
            goto Lc
        Lb:
            r3 = r0
        Lc:
            byte[] r3 = hexStringToByteArray(r3)
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream
            r0.<init>(r3)
            r3 = 0
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L29 java.lang.ClassNotFoundException -> L32 java.io.IOException -> L36
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L29 java.lang.ClassNotFoundException -> L32 java.io.IOException -> L36
            java.lang.Object r0 = r1.readObject()     // Catch: java.lang.Throwable -> L27 java.lang.ClassNotFoundException -> L33 java.io.IOException -> L37
            com.wear.network.protocol.cookie.persistence.SerializableCookie r0 = (com.wear.network.protocol.cookie.persistence.SerializableCookie) r0     // Catch: java.lang.Throwable -> L27 java.lang.ClassNotFoundException -> L33 java.io.IOException -> L37
            dc.ic4 r3 = r0.cookie     // Catch: java.lang.Throwable -> L27 java.lang.ClassNotFoundException -> L33 java.io.IOException -> L37
        L23:
            r1.close()     // Catch: java.io.IOException -> L3a
            goto L3a
        L27:
            r3 = move-exception
            goto L2c
        L29:
            r0 = move-exception
            r1 = r3
            r3 = r0
        L2c:
            if (r1 == 0) goto L31
            r1.close()     // Catch: java.io.IOException -> L31
        L31:
            throw r3
        L32:
            r1 = r3
        L33:
            if (r1 == 0) goto L3a
            goto L23
        L36:
            r1 = r3
        L37:
            if (r1 == 0) goto L3a
            goto L23
        L3a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.network.protocol.cookie.persistence.SerializableCookie.decode(java.lang.String):dc.ic4");
    }

    public String encode(ic4 ic4Var) throws Throwable {
        ObjectOutputStream objectOutputStream;
        this.cookie = ic4Var;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (IOException unused) {
            objectOutputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            objectOutputStream.writeObject(this);
            try {
                objectOutputStream.close();
            } catch (IOException unused2) {
            }
            return nd3.o(byteArrayToHexString(byteArrayOutputStream.toByteArray()));
        } catch (IOException unused3) {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException unused4) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream2 = objectOutputStream;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }
}

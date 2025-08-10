package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.util.Strings;

/* loaded from: classes5.dex */
public class ServerName {
    public Object name;
    public short nameType;

    public ServerName(short s, Object obj) {
        if (!isCorrectType(s, obj)) {
            throw new IllegalArgumentException("'name' is not an instance of the correct type");
        }
        this.nameType = s;
        this.name = obj;
    }

    public static boolean isCorrectType(short s, Object obj) {
        if (s == 0) {
            return obj instanceof String;
        }
        throw new IllegalArgumentException("'name' is an unsupported value");
    }

    public static ServerName parse(InputStream inputStream) throws IOException {
        short uint8 = TlsUtils.readUint8(inputStream);
        if (uint8 != 0) {
            throw new TlsFatalAlert((short) 50);
        }
        byte[] opaque16 = TlsUtils.readOpaque16(inputStream);
        if (opaque16.length >= 1) {
            return new ServerName(uint8, Strings.fromUTF8ByteArray(opaque16));
        }
        throw new TlsFatalAlert((short) 50);
    }

    public void encode(OutputStream outputStream) throws IOException {
        TlsUtils.writeUint8(this.nameType, outputStream);
        if (this.nameType != 0) {
            throw new TlsFatalAlert((short) 80);
        }
        byte[] uTF8ByteArray = Strings.toUTF8ByteArray((String) this.name);
        if (uTF8ByteArray.length < 1) {
            throw new TlsFatalAlert((short) 80);
        }
        TlsUtils.writeOpaque16(uTF8ByteArray, outputStream);
    }

    public String getHostName() {
        if (isCorrectType((short) 0, this.name)) {
            return (String) this.name;
        }
        throw new IllegalStateException("'name' is not a HostName string");
    }

    public Object getName() {
        return this.name;
    }

    public short getNameType() {
        return this.nameType;
    }
}

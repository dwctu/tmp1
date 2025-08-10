package org.bouncycastle.asn1;

import com.broadcom.bt.util.io.FilenameUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.util.Arrays;

/* loaded from: classes5.dex */
public class DERObjectIdentifier extends ASN1Primitive {
    private static final long LONG_LIMIT = 72057594037927808L;
    private static ASN1ObjectIdentifier[][] cache = new ASN1ObjectIdentifier[256][];
    private byte[] body;
    public String identifier;

    public DERObjectIdentifier(String str) {
        if (str == null) {
            throw new IllegalArgumentException("'identifier' cannot be null");
        }
        if (isValidIdentifier(str)) {
            this.identifier = str;
            return;
        }
        throw new IllegalArgumentException("string " + str + " not an OID");
    }

    public DERObjectIdentifier(DERObjectIdentifier dERObjectIdentifier, String str) {
        if (!isValidBranchID(str, 0)) {
            throw new IllegalArgumentException("string " + str + " not a valid OID branch");
        }
        this.identifier = dERObjectIdentifier.getId() + "." + str;
    }

    public DERObjectIdentifier(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        long j = 0;
        BigInteger bigIntegerShiftLeft = null;
        for (int i = 0; i != bArr.length; i++) {
            int i2 = bArr[i] & 255;
            if (j <= LONG_LIMIT) {
                long j2 = j + (i2 & 127);
                if ((i2 & 128) == 0) {
                    if (z) {
                        if (j2 < 40) {
                            stringBuffer.append('0');
                        } else if (j2 < 80) {
                            stringBuffer.append('1');
                            j2 -= 40;
                        } else {
                            stringBuffer.append('2');
                            j2 -= 80;
                        }
                        z = false;
                    }
                    stringBuffer.append(FilenameUtils.EXTENSION_SEPARATOR);
                    stringBuffer.append(j2);
                    j = 0;
                } else {
                    j = j2 << 7;
                }
            } else {
                BigInteger bigIntegerOr = (bigIntegerShiftLeft == null ? BigInteger.valueOf(j) : bigIntegerShiftLeft).or(BigInteger.valueOf(i2 & 127));
                if ((i2 & 128) == 0) {
                    if (z) {
                        stringBuffer.append('2');
                        bigIntegerOr = bigIntegerOr.subtract(BigInteger.valueOf(80L));
                        z = false;
                    }
                    stringBuffer.append(FilenameUtils.EXTENSION_SEPARATOR);
                    stringBuffer.append(bigIntegerOr);
                    j = 0;
                    bigIntegerShiftLeft = null;
                } else {
                    bigIntegerShiftLeft = bigIntegerOr.shiftLeft(7);
                }
            }
        }
        this.identifier = stringBuffer.toString();
        this.body = Arrays.clone(bArr);
    }

    private void doOutput(ByteArrayOutputStream byteArrayOutputStream) {
        OIDTokenizer oIDTokenizer = new OIDTokenizer(this.identifier);
        int i = Integer.parseInt(oIDTokenizer.nextToken()) * 40;
        String strNextToken = oIDTokenizer.nextToken();
        if (strNextToken.length() <= 18) {
            writeField(byteArrayOutputStream, i + Long.parseLong(strNextToken));
        } else {
            writeField(byteArrayOutputStream, new BigInteger(strNextToken).add(BigInteger.valueOf(i)));
        }
        while (oIDTokenizer.hasMoreTokens()) {
            String strNextToken2 = oIDTokenizer.nextToken();
            if (strNextToken2.length() <= 18) {
                writeField(byteArrayOutputStream, Long.parseLong(strNextToken2));
            } else {
                writeField(byteArrayOutputStream, new BigInteger(strNextToken2));
            }
        }
    }

    public static ASN1ObjectIdentifier fromOctetString(byte[] bArr) {
        if (bArr.length < 3) {
            return new ASN1ObjectIdentifier(bArr);
        }
        int i = bArr[bArr.length - 2] & 255;
        int i2 = bArr[bArr.length - 1] & Byte.MAX_VALUE;
        synchronized (cache) {
            ASN1ObjectIdentifier[][] aSN1ObjectIdentifierArr = cache;
            ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr2 = aSN1ObjectIdentifierArr[i];
            if (aSN1ObjectIdentifierArr2 == null) {
                aSN1ObjectIdentifierArr2 = new ASN1ObjectIdentifier[128];
                aSN1ObjectIdentifierArr[i] = aSN1ObjectIdentifierArr2;
            }
            ASN1ObjectIdentifier aSN1ObjectIdentifier = aSN1ObjectIdentifierArr2[i2];
            if (aSN1ObjectIdentifier == null) {
                ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(bArr);
                aSN1ObjectIdentifierArr2[i2] = aSN1ObjectIdentifier2;
                return aSN1ObjectIdentifier2;
            }
            if (Arrays.areEqual(bArr, aSN1ObjectIdentifier.getBody())) {
                return aSN1ObjectIdentifier;
            }
            int i3 = (i + 1) & 255;
            ASN1ObjectIdentifier[][] aSN1ObjectIdentifierArr3 = cache;
            ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr4 = aSN1ObjectIdentifierArr3[i3];
            if (aSN1ObjectIdentifierArr4 == null) {
                aSN1ObjectIdentifierArr4 = new ASN1ObjectIdentifier[128];
                aSN1ObjectIdentifierArr3[i3] = aSN1ObjectIdentifierArr4;
            }
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = aSN1ObjectIdentifierArr4[i2];
            if (aSN1ObjectIdentifier3 == null) {
                ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier(bArr);
                aSN1ObjectIdentifierArr4[i2] = aSN1ObjectIdentifier4;
                return aSN1ObjectIdentifier4;
            }
            if (Arrays.areEqual(bArr, aSN1ObjectIdentifier3.getBody())) {
                return aSN1ObjectIdentifier3;
            }
            int i4 = (i2 + 1) & 127;
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = aSN1ObjectIdentifierArr4[i4];
            if (aSN1ObjectIdentifier5 != null) {
                return Arrays.areEqual(bArr, aSN1ObjectIdentifier5.getBody()) ? aSN1ObjectIdentifier5 : new ASN1ObjectIdentifier(bArr);
            }
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = new ASN1ObjectIdentifier(bArr);
            aSN1ObjectIdentifierArr4[i4] = aSN1ObjectIdentifier6;
            return aSN1ObjectIdentifier6;
        }
    }

    public static ASN1ObjectIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1ObjectIdentifier)) {
            return (ASN1ObjectIdentifier) obj;
        }
        if (obj instanceof DERObjectIdentifier) {
            return new ASN1ObjectIdentifier(((DERObjectIdentifier) obj).getId());
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Encodable aSN1Encodable = (ASN1Encodable) obj;
            if (aSN1Encodable.toASN1Primitive() instanceof ASN1ObjectIdentifier) {
                return (ASN1ObjectIdentifier) aSN1Encodable.toASN1Primitive();
            }
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        byte[] bArr = (byte[]) obj;
        if (bArr[0] != 6) {
            return fromOctetString(bArr);
        }
        try {
            return (ASN1ObjectIdentifier) ASN1Primitive.fromByteArray(bArr);
        } catch (IOException e) {
            throw new IllegalArgumentException("failed to construct sequence from byte[]: " + e.getMessage());
        }
    }

    public static ASN1ObjectIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        return (z || (object instanceof DERObjectIdentifier)) ? getInstance(object) : fromOctetString(ASN1OctetString.getInstance(aSN1TaggedObject.getObject()).getOctets());
    }

    private static boolean isValidBranchID(String str, int i) {
        boolean z;
        char cCharAt;
        int length = str.length();
        do {
            z = false;
            while (true) {
                length--;
                if (length < i) {
                    return z;
                }
                cCharAt = str.charAt(length);
                if ('0' > cCharAt || cCharAt > '9') {
                    break;
                }
                z = true;
            }
            if (cCharAt != '.') {
                break;
            }
        } while (z);
        return false;
    }

    private static boolean isValidIdentifier(String str) {
        char cCharAt;
        if (str.length() < 3 || str.charAt(1) != '.' || (cCharAt = str.charAt(0)) < '0' || cCharAt > '2') {
            return false;
        }
        return isValidBranchID(str, 2);
    }

    private void writeField(ByteArrayOutputStream byteArrayOutputStream, long j) {
        byte[] bArr = new byte[9];
        int i = 8;
        bArr[8] = (byte) (((int) j) & 127);
        while (j >= 128) {
            j >>= 7;
            i--;
            bArr[i] = (byte) ((((int) j) & 127) | 128);
        }
        byteArrayOutputStream.write(bArr, i, 9 - i);
    }

    private void writeField(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int iBitLength = (bigInteger.bitLength() + 6) / 7;
        if (iBitLength == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        byte[] bArr = new byte[iBitLength];
        int i = iBitLength - 1;
        for (int i2 = i; i2 >= 0; i2--) {
            bArr[i2] = (byte) ((bigInteger.intValue() & 127) | 128);
            bigInteger = bigInteger.shiftRight(7);
        }
        bArr[i] = (byte) (bArr[i] & Byte.MAX_VALUE);
        byteArrayOutputStream.write(bArr, 0, iBitLength);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof DERObjectIdentifier) {
            return this.identifier.equals(((DERObjectIdentifier) aSN1Primitive).identifier);
        }
        return false;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        byte[] body = getBody();
        aSN1OutputStream.write(6);
        aSN1OutputStream.writeLength(body.length);
        aSN1OutputStream.write(body);
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public int encodedLength() throws IOException {
        int length = getBody().length;
        return StreamUtil.calculateBodyLength(length) + 1 + length;
    }

    public synchronized byte[] getBody() {
        if (this.body == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            doOutput(byteArrayOutputStream);
            this.body = byteArrayOutputStream.toByteArray();
        }
        return this.body;
    }

    public String getId() {
        return this.identifier;
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive, org.bouncycastle.asn1.ASN1Object
    public int hashCode() {
        return this.identifier.hashCode();
    }

    @Override // org.bouncycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        return getId();
    }
}

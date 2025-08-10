package org.bouncycastle.asn1.x509;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.util.Strings;

/* loaded from: classes5.dex */
public abstract class X509NameEntryConverter {
    public boolean canBePrintable(String str) {
        return DERPrintableString.isPrintableString(str);
    }

    public ASN1Primitive convertHexEncoded(String str, int i) throws IOException {
        String lowerCase = Strings.toLowerCase(str);
        int length = (lowerCase.length() - i) / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 != length; i2++) {
            int i3 = (i2 * 2) + i;
            char cCharAt = lowerCase.charAt(i3);
            char cCharAt2 = lowerCase.charAt(i3 + 1);
            if (cCharAt < 'a') {
                bArr[i2] = (byte) ((cCharAt - '0') << 4);
            } else {
                bArr[i2] = (byte) (((cCharAt - 'a') + 10) << 4);
            }
            if (cCharAt2 < 'a') {
                bArr[i2] = (byte) (((byte) (cCharAt2 - '0')) | bArr[i2]);
            } else {
                bArr[i2] = (byte) (((byte) ((cCharAt2 - 'a') + 10)) | bArr[i2]);
            }
        }
        return new ASN1InputStream(bArr).readObject();
    }

    public abstract ASN1Primitive getConvertedValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str);
}

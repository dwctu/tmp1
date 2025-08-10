package org.bouncycastle.asn1.util;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BERApplicationSpecific;
import org.bouncycastle.asn1.BERConstructedOctetString;
import org.bouncycastle.asn1.BEROctetString;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.BERSet;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.DERApplicationSpecific;
import org.bouncycastle.asn1.DERBMPString;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERBoolean;
import org.bouncycastle.asn1.DEREnumerated;
import org.bouncycastle.asn1.DERExternal;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERT61String;
import org.bouncycastle.asn1.DERUTCTime;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.DERVisibleString;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes5.dex */
public class ASN1Dump {
    private static final int SAMPLE_SIZE = 32;
    private static final String TAB = "    ";

    public static void _dumpAsString(String str, boolean z, ASN1Primitive aSN1Primitive, StringBuffer stringBuffer) {
        StringBuilder sb;
        BigInteger value;
        String str2;
        String strOutputApplicationSpecific;
        String time;
        StringBuilder sb2;
        int length;
        String property = System.getProperty("line.separator");
        if (!(aSN1Primitive instanceof ASN1Sequence)) {
            if (aSN1Primitive instanceof ASN1TaggedObject) {
                String str3 = str + TAB;
                stringBuffer.append(str);
                stringBuffer.append(aSN1Primitive instanceof BERTaggedObject ? "BER Tagged [" : "Tagged [");
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive;
                stringBuffer.append(Integer.toString(aSN1TaggedObject.getTagNo()));
                stringBuffer.append(']');
                if (!aSN1TaggedObject.isExplicit()) {
                    stringBuffer.append(" IMPLICIT ");
                }
                stringBuffer.append(property);
                if (!aSN1TaggedObject.isEmpty()) {
                    _dumpAsString(str3, z, aSN1TaggedObject.getObject(), stringBuffer);
                    return;
                } else {
                    stringBuffer.append(str3);
                    stringBuffer.append("EMPTY");
                }
            } else if (aSN1Primitive instanceof ASN1Set) {
                Enumeration objects = ((ASN1Set) aSN1Primitive).getObjects();
                String str4 = str + TAB;
                stringBuffer.append(str);
                stringBuffer.append(aSN1Primitive instanceof BERSet ? "BER Set" : "DER Set");
                while (true) {
                    stringBuffer.append(property);
                    while (objects.hasMoreElements()) {
                        Object objNextElement = objects.nextElement();
                        if (objNextElement == null) {
                            break;
                        } else {
                            _dumpAsString(str4, z, objNextElement instanceof ASN1Primitive ? (ASN1Primitive) objNextElement : ((ASN1Encodable) objNextElement).toASN1Primitive(), stringBuffer);
                        }
                    }
                    return;
                    stringBuffer.append(str4);
                    stringBuffer.append("NULL");
                }
            } else {
                if (!(aSN1Primitive instanceof ASN1OctetString)) {
                    if (aSN1Primitive instanceof ASN1ObjectIdentifier) {
                        sb = new StringBuilder();
                        sb.append(str);
                        sb.append("ObjectIdentifier(");
                        sb.append(((ASN1ObjectIdentifier) aSN1Primitive).getId());
                    } else if (aSN1Primitive instanceof DERBoolean) {
                        sb = new StringBuilder();
                        sb.append(str);
                        sb.append("Boolean(");
                        sb.append(((DERBoolean) aSN1Primitive).isTrue());
                    } else {
                        if (!(aSN1Primitive instanceof ASN1Integer)) {
                            if (aSN1Primitive instanceof DERBitString) {
                                DERBitString dERBitString = (DERBitString) aSN1Primitive;
                                stringBuffer.append(str + "DER Bit String[" + dERBitString.getBytes().length + ", " + dERBitString.getPadBits() + "] ");
                                if (z) {
                                    strOutputApplicationSpecific = dumpBinaryDataAsString(str, dERBitString.getBytes());
                                }
                            } else {
                                if (aSN1Primitive instanceof DERIA5String) {
                                    sb = new StringBuilder();
                                    sb.append(str);
                                    sb.append("IA5String(");
                                    time = ((DERIA5String) aSN1Primitive).getString();
                                } else if (aSN1Primitive instanceof DERUTF8String) {
                                    sb = new StringBuilder();
                                    sb.append(str);
                                    sb.append("UTF8String(");
                                    time = ((DERUTF8String) aSN1Primitive).getString();
                                } else if (aSN1Primitive instanceof DERPrintableString) {
                                    sb = new StringBuilder();
                                    sb.append(str);
                                    sb.append("PrintableString(");
                                    time = ((DERPrintableString) aSN1Primitive).getString();
                                } else if (aSN1Primitive instanceof DERVisibleString) {
                                    sb = new StringBuilder();
                                    sb.append(str);
                                    sb.append("VisibleString(");
                                    time = ((DERVisibleString) aSN1Primitive).getString();
                                } else if (aSN1Primitive instanceof DERBMPString) {
                                    sb = new StringBuilder();
                                    sb.append(str);
                                    sb.append("BMPString(");
                                    time = ((DERBMPString) aSN1Primitive).getString();
                                } else if (aSN1Primitive instanceof DERT61String) {
                                    sb = new StringBuilder();
                                    sb.append(str);
                                    sb.append("T61String(");
                                    time = ((DERT61String) aSN1Primitive).getString();
                                } else if (aSN1Primitive instanceof DERUTCTime) {
                                    sb = new StringBuilder();
                                    sb.append(str);
                                    sb.append("UTCTime(");
                                    time = ((DERUTCTime) aSN1Primitive).getTime();
                                } else if (aSN1Primitive instanceof DERGeneralizedTime) {
                                    sb = new StringBuilder();
                                    sb.append(str);
                                    sb.append("GeneralizedTime(");
                                    time = ((DERGeneralizedTime) aSN1Primitive).getTime();
                                } else {
                                    if (aSN1Primitive instanceof BERApplicationSpecific) {
                                        str2 = ASN1Encoding.BER;
                                    } else if (aSN1Primitive instanceof DERApplicationSpecific) {
                                        str2 = ASN1Encoding.DER;
                                    } else if (aSN1Primitive instanceof DEREnumerated) {
                                        sb = new StringBuilder();
                                        sb.append(str);
                                        sb.append("DER Enumerated(");
                                        value = ((DEREnumerated) aSN1Primitive).getValue();
                                    } else {
                                        if (aSN1Primitive instanceof DERExternal) {
                                            DERExternal dERExternal = (DERExternal) aSN1Primitive;
                                            stringBuffer.append(str + "External " + property);
                                            StringBuilder sb3 = new StringBuilder();
                                            sb3.append(str);
                                            sb3.append(TAB);
                                            String string = sb3.toString();
                                            if (dERExternal.getDirectReference() != null) {
                                                stringBuffer.append(string + "Direct Reference: " + dERExternal.getDirectReference().getId() + property);
                                            }
                                            if (dERExternal.getIndirectReference() != null) {
                                                stringBuffer.append(string + "Indirect Reference: " + dERExternal.getIndirectReference().toString() + property);
                                            }
                                            if (dERExternal.getDataValueDescriptor() != null) {
                                                _dumpAsString(string, z, dERExternal.getDataValueDescriptor(), stringBuffer);
                                            }
                                            stringBuffer.append(string + "Encoding: " + dERExternal.getEncoding() + property);
                                            _dumpAsString(string, z, dERExternal.getExternalContent(), stringBuffer);
                                            return;
                                        }
                                        sb = new StringBuilder();
                                        sb.append(str);
                                        sb.append(aSN1Primitive.toString());
                                        sb.append(property);
                                        strOutputApplicationSpecific = sb.toString();
                                    }
                                    strOutputApplicationSpecific = outputApplicationSpecific(str2, str, z, aSN1Primitive, property);
                                }
                                sb.append(time);
                                sb.append(") ");
                                sb.append(property);
                                strOutputApplicationSpecific = sb.toString();
                            }
                            stringBuffer.append(strOutputApplicationSpecific);
                            return;
                        }
                        sb = new StringBuilder();
                        sb.append(str);
                        sb.append("Integer(");
                        value = ((ASN1Integer) aSN1Primitive).getValue();
                        sb.append(value);
                    }
                    sb.append(")");
                    sb.append(property);
                    strOutputApplicationSpecific = sb.toString();
                    stringBuffer.append(strOutputApplicationSpecific);
                    return;
                }
                ASN1OctetString aSN1OctetString = (ASN1OctetString) aSN1Primitive;
                if ((aSN1Primitive instanceof BEROctetString) || (aSN1Primitive instanceof BERConstructedOctetString)) {
                    sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append("BER Constructed Octet String");
                    sb2.append("[");
                    length = aSN1OctetString.getOctets().length;
                } else {
                    sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append("DER Octet String");
                    sb2.append("[");
                    length = aSN1OctetString.getOctets().length;
                }
                sb2.append(length);
                sb2.append("] ");
                stringBuffer.append(sb2.toString());
                if (z) {
                    strOutputApplicationSpecific = dumpBinaryDataAsString(str, aSN1OctetString.getOctets());
                    stringBuffer.append(strOutputApplicationSpecific);
                    return;
                }
            }
            stringBuffer.append(property);
            return;
        }
        Enumeration objects2 = ((ASN1Sequence) aSN1Primitive).getObjects();
        String str5 = str + TAB;
        stringBuffer.append(str);
        stringBuffer.append(aSN1Primitive instanceof BERSequence ? "BER Sequence" : aSN1Primitive instanceof DERSequence ? "DER Sequence" : "Sequence");
        while (true) {
            stringBuffer.append(property);
            while (objects2.hasMoreElements()) {
                Object objNextElement2 = objects2.nextElement();
                if (objNextElement2 == null || objNextElement2.equals(DERNull.INSTANCE)) {
                    break;
                } else {
                    _dumpAsString(str5, z, objNextElement2 instanceof ASN1Primitive ? (ASN1Primitive) objNextElement2 : ((ASN1Encodable) objNextElement2).toASN1Primitive(), stringBuffer);
                }
            }
            return;
            stringBuffer.append(str5);
            stringBuffer.append("NULL");
        }
    }

    private static String calculateAscString(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = i; i3 != i + i2; i3++) {
            if (bArr[i3] >= 32 && bArr[i3] <= 126) {
                stringBuffer.append((char) bArr[i3]);
            }
        }
        return stringBuffer.toString();
    }

    public static String dumpAsString(Object obj) {
        return dumpAsString(obj, false);
    }

    public static String dumpAsString(Object obj, boolean z) {
        ASN1Primitive aSN1Primitive;
        StringBuffer stringBuffer = new StringBuffer();
        if (obj instanceof ASN1Primitive) {
            aSN1Primitive = (ASN1Primitive) obj;
        } else {
            if (!(obj instanceof ASN1Encodable)) {
                return "unknown object type " + obj.toString();
            }
            aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
        }
        _dumpAsString("", z, aSN1Primitive, stringBuffer);
        return stringBuffer.toString();
    }

    private static String dumpBinaryDataAsString(String str, byte[] bArr) {
        String strCalculateAscString;
        String property = System.getProperty("line.separator");
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = str + TAB;
        stringBuffer.append(property);
        for (int i = 0; i < bArr.length; i += 32) {
            int length = bArr.length - i;
            stringBuffer.append(str2);
            if (length > 32) {
                stringBuffer.append(new String(Hex.encode(bArr, i, 32)));
                stringBuffer.append(TAB);
                strCalculateAscString = calculateAscString(bArr, i, 32);
            } else {
                stringBuffer.append(new String(Hex.encode(bArr, i, bArr.length - i)));
                for (int length2 = bArr.length - i; length2 != 32; length2++) {
                    stringBuffer.append("  ");
                }
                stringBuffer.append(TAB);
                strCalculateAscString = calculateAscString(bArr, i, bArr.length - i);
            }
            stringBuffer.append(strCalculateAscString);
            stringBuffer.append(property);
        }
        return stringBuffer.toString();
    }

    private static String outputApplicationSpecific(String str, String str2, boolean z, ASN1Primitive aSN1Primitive, String str3) {
        DERApplicationSpecific dERApplicationSpecific = (DERApplicationSpecific) aSN1Primitive;
        StringBuffer stringBuffer = new StringBuffer();
        if (!dERApplicationSpecific.isConstructed()) {
            return str2 + str + " ApplicationSpecific[" + dERApplicationSpecific.getApplicationTag() + "] (" + new String(Hex.encode(dERApplicationSpecific.getContents())) + ")" + str3;
        }
        try {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(dERApplicationSpecific.getObject(16));
            stringBuffer.append(str2 + str + " ApplicationSpecific[" + dERApplicationSpecific.getApplicationTag() + "]" + str3);
            Enumeration objects = aSN1Sequence.getObjects();
            while (objects.hasMoreElements()) {
                _dumpAsString(str2 + TAB, z, (ASN1Primitive) objects.nextElement(), stringBuffer);
            }
        } catch (IOException e) {
            stringBuffer.append(e);
        }
        return stringBuffer.toString();
    }
}

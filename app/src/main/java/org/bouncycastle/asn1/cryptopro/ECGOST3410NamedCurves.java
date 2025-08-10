package org.bouncycastle.asn1.cryptopro;

import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.math.ec.ECCurve;

/* loaded from: classes5.dex */
public class ECGOST3410NamedCurves {
    public static final Hashtable names;
    public static final Hashtable objIds;
    public static final Hashtable params;

    static {
        Hashtable hashtable = new Hashtable();
        objIds = hashtable;
        Hashtable hashtable2 = new Hashtable();
        params = hashtable2;
        Hashtable hashtable3 = new Hashtable();
        names = hashtable3;
        BigInteger bigInteger = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639319");
        BigInteger bigInteger2 = new BigInteger("115792089237316195423570985008687907853073762908499243225378155805079068850323");
        ECCurve.Fp fp = new ECCurve.Fp(bigInteger, new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639316"), new BigInteger("166"));
        ECDomainParameters eCDomainParameters = new ECDomainParameters(fp, fp.createPoint(new BigInteger("1"), new BigInteger("64033881142927202683649881450433473985931760268884941288852745803908878638612")), bigInteger2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_A;
        hashtable2.put(aSN1ObjectIdentifier, eCDomainParameters);
        BigInteger bigInteger3 = new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639319");
        BigInteger bigInteger4 = new BigInteger("115792089237316195423570985008687907853073762908499243225378155805079068850323");
        ECCurve.Fp fp2 = new ECCurve.Fp(bigInteger3, new BigInteger("115792089237316195423570985008687907853269984665640564039457584007913129639316"), new BigInteger("166"));
        ECDomainParameters eCDomainParameters2 = new ECDomainParameters(fp2, fp2.createPoint(new BigInteger("1"), new BigInteger("64033881142927202683649881450433473985931760268884941288852745803908878638612")), bigInteger4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchA;
        hashtable2.put(aSN1ObjectIdentifier2, eCDomainParameters2);
        BigInteger bigInteger5 = new BigInteger("57896044618658097711785492504343953926634992332820282019728792003956564823193");
        BigInteger bigInteger6 = new BigInteger("57896044618658097711785492504343953927102133160255826820068844496087732066703");
        ECCurve.Fp fp3 = new ECCurve.Fp(bigInteger5, new BigInteger("57896044618658097711785492504343953926634992332820282019728792003956564823190"), new BigInteger("28091019353058090096996979000309560759124368558014865957655842872397301267595"));
        ECDomainParameters eCDomainParameters3 = new ECDomainParameters(fp3, fp3.createPoint(new BigInteger("1"), new BigInteger("28792665814854611296992347458380284135028636778229113005756334730996303888124")), bigInteger6);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_B;
        hashtable2.put(aSN1ObjectIdentifier3, eCDomainParameters3);
        BigInteger bigInteger7 = new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502619");
        BigInteger bigInteger8 = new BigInteger("70390085352083305199547718019018437840920882647164081035322601458352298396601");
        ECCurve.Fp fp4 = new ECCurve.Fp(bigInteger7, new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502616"), new BigInteger("32858"));
        ECDomainParameters eCDomainParameters4 = new ECDomainParameters(fp4, fp4.createPoint(new BigInteger("0"), new BigInteger("29818893917731240733471273240314769927240550812383695689146495261604565990247")), bigInteger8);
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchB;
        hashtable2.put(aSN1ObjectIdentifier4, eCDomainParameters4);
        BigInteger bigInteger9 = new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502619");
        BigInteger bigInteger10 = new BigInteger("70390085352083305199547718019018437840920882647164081035322601458352298396601");
        ECCurve.Fp fp5 = new ECCurve.Fp(bigInteger9, new BigInteger("70390085352083305199547718019018437841079516630045180471284346843705633502616"), new BigInteger("32858"));
        ECDomainParameters eCDomainParameters5 = new ECDomainParameters(fp5, fp5.createPoint(new BigInteger("0"), new BigInteger("29818893917731240733471273240314769927240550812383695689146495261604565990247")), bigInteger10);
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_C;
        hashtable2.put(aSN1ObjectIdentifier5, eCDomainParameters5);
        hashtable.put("GostR3410-2001-CryptoPro-A", aSN1ObjectIdentifier);
        hashtable.put("GostR3410-2001-CryptoPro-B", aSN1ObjectIdentifier3);
        hashtable.put("GostR3410-2001-CryptoPro-C", aSN1ObjectIdentifier5);
        hashtable.put("GostR3410-2001-CryptoPro-XchA", aSN1ObjectIdentifier2);
        hashtable.put("GostR3410-2001-CryptoPro-XchB", aSN1ObjectIdentifier4);
        hashtable3.put(aSN1ObjectIdentifier, "GostR3410-2001-CryptoPro-A");
        hashtable3.put(aSN1ObjectIdentifier3, "GostR3410-2001-CryptoPro-B");
        hashtable3.put(aSN1ObjectIdentifier5, "GostR3410-2001-CryptoPro-C");
        hashtable3.put(aSN1ObjectIdentifier2, "GostR3410-2001-CryptoPro-XchA");
        hashtable3.put(aSN1ObjectIdentifier4, "GostR3410-2001-CryptoPro-XchB");
    }

    public static ECDomainParameters getByName(String str) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) objIds.get(str);
        if (aSN1ObjectIdentifier != null) {
            return (ECDomainParameters) params.get(aSN1ObjectIdentifier);
        }
        return null;
    }

    public static ECDomainParameters getByOID(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (ECDomainParameters) params.get(aSN1ObjectIdentifier);
    }

    public static String getName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (String) names.get(aSN1ObjectIdentifier);
    }

    public static Enumeration getNames() {
        return objIds.keys();
    }

    public static ASN1ObjectIdentifier getOID(String str) {
        return (ASN1ObjectIdentifier) objIds.get(str);
    }
}

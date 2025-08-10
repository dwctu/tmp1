package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: MultiFormatWriter.java */
/* loaded from: classes3.dex */
public final class Ob implements Pb {
    @Override // com.huawei.hms.scankit.p.Pb
    public C0417y a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<Jc, ?> map) throws WriterException {
        Pb c0392rc;
        switch (Nb.a[barcodeFormat.ordinal()]) {
            case 1:
                c0392rc = new C0392rc();
                break;
            case 2:
                c0392rc = new C0412wc();
                break;
            case 3:
                c0392rc = new C0389qc();
                break;
            case 4:
                c0392rc = new C0404uc();
                break;
            case 5:
                c0392rc = new Gc();
                break;
            case 6:
                c0392rc = new C0381oc();
                break;
            case 7:
                c0392rc = new C0385pc();
                break;
            case 8:
                c0392rc = new C0377nc();
                break;
            case 9:
                c0392rc = new C0396sc();
                break;
            case 10:
                c0392rc = new C0416xc();
                break;
            case 11:
                c0392rc = new C0373mc();
                break;
            case 12:
                c0392rc = new Yb();
                break;
            case 13:
                c0392rc = new Qb();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + barcodeFormat);
        }
        return c0392rc.a(str, barcodeFormat, i, i2, map);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(3:(5:(1:59)(2:61|(1:63)(4:64|(1:66)(1:(1:69)(2:70|(1:72)(2:73|(1:75)(2:76|(1:78)(2:79|(1:81)(2:82|(1:84)(2:85|(1:87)(2:88|(1:90)(2:91|(1:93)(2:94|(1:96)(1:97)))))))))))|67|(7:201|106|202|(3:145|146|(1:148)(9:149|(4:151|(3:153|(2:155|212)(2:156|211)|157)|210|158)|209|159|160|161|(4:167|(1:169)(1:170)|(1:176)(1:177)|178)|172|173))(4:111|112|113|(1:115)(6:116|(4:118|(3:120|(2:129|(2:131|208)(2:132|206))(2:128|207)|133)|205|140)|204|141|142|143))|174|(0)(0)|178)(2:104|105)))|202|(3:145|146|(0)(0))(0)|(0)(0)|178)|201|106) */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x02a3, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x02a4, code lost:
    
        r17 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x02b9, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x02ba, code lost:
    
        r17 = r4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x021b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x021c A[Catch: Exception -> 0x01e6, IllegalArgumentException -> 0x01e9, OutOfMemoryError -> 0x01ec, TryCatch #1 {OutOfMemoryError -> 0x01ec, blocks: (B:106:0x012e, B:109:0x0134, B:111:0x0138, B:113:0x0155, B:116:0x015c, B:120:0x01b1, B:122:0x01b5, B:124:0x01b9, B:126:0x01bd, B:128:0x01c1, B:133:0x01e3, B:129:0x01d2, B:131:0x01d8, B:132:0x01de, B:140:0x01ef, B:141:0x01f2, B:146:0x0215, B:149:0x021c, B:153:0x022e, B:155:0x0234, B:157:0x023f, B:156:0x023a, B:158:0x0242, B:159:0x0245), top: B:201:0x012e }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0294  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.graphics.Bitmap a(java.lang.String r28, int r29, int r30, int r31, com.huawei.hms.ml.scan.HmsBuildBitmapOption r32) throws com.huawei.hms.hmsscankit.WriterException {
        /*
            Method dump skipped, instructions count: 773
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.Ob.a(java.lang.String, int, int, int, com.huawei.hms.ml.scan.HmsBuildBitmapOption):android.graphics.Bitmap");
    }
}

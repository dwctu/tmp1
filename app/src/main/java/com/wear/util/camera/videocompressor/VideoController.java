package com.wear.util.camera.videocompressor;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import dc.wi3;
import java.io.File;
import java.nio.ByteBuffer;

@SuppressLint({"NewApi"})
/* loaded from: classes4.dex */
public class VideoController {
    public static volatile VideoController e;
    public String a;
    public boolean b = true;
    public int c;
    public int d;

    public interface a {
        void onProgress(float f);
    }

    public static native int convertVideoFrame(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i, int i2, int i3, int i4, int i5);

    public static VideoController d() {
        VideoController videoController = e;
        if (videoController == null) {
            synchronized (VideoController.class) {
                videoController = e;
                if (videoController == null) {
                    videoController = new VideoController();
                    e = videoController;
                }
            }
        }
        return videoController;
    }

    public static boolean e(int i) {
        if (i == 39 || i == 2130706688) {
            return true;
        }
        switch (i) {
            case 19:
            case 20:
            case 21:
                return true;
            default:
                return false;
        }
    }

    public static MediaCodecInfo g(String str) {
        int codecCount = MediaCodecList.getCodecCount();
        MediaCodecInfo mediaCodecInfo = null;
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                for (String str2 : codecInfoAt.getSupportedTypes()) {
                    if (str2.equalsIgnoreCase(str)) {
                        if (!codecInfoAt.getName().equals("OMX.SEC.avc.enc") || codecInfoAt.getName().equals("OMX.SEC.AVC.Encoder")) {
                            return codecInfoAt;
                        }
                        mediaCodecInfo = codecInfoAt;
                    }
                }
            }
        }
        return mediaCodecInfo;
    }

    @SuppressLint({"NewApi"})
    public static int h(MediaCodecInfo mediaCodecInfo, String str) {
        int i;
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = capabilitiesForType.colorFormats;
            if (i2 >= iArr.length) {
                return i3;
            }
            i = iArr[i2];
            if (e(i)) {
                if (!mediaCodecInfo.getName().equals("OMX.SEC.AVC.Encoder") || i != 19) {
                    break;
                }
                i3 = i;
            }
            i2++;
        }
        return i;
    }

    public final int a(int i, int i2) {
        int i3 = 1;
        if (i * i2 > 2073600) {
            while ((i / i3) * (i2 / i3) > 2073600) {
                i3 *= 2;
            }
        }
        return i3;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:(1:452)|(3:495|61|(1:63)(12:64|65|66|(1:68)|69|(1:394)|395|482|396|400|429|(2:431|432)(1:521)))(1:80)|497|81|(8:476|83|84|(3:467|86|(3:88|(2:90|(2:98|99)(2:96|97))(3:100|(1:102)(2:103|(1:105)(2:106|(2:108|97)(2:109|(1:111)(1:112))))|99)|113)(2:114|115))(1:118)|119|(16:121|(16:123|124|125|141|142|(1:144)|145|146|493|147|148|(4:478|150|474|151)(1:157)|486|158|159|(18:459|161|162|448|167|168|(3:461|170|(12:172|173|179|(2:181|(7:450|183|(2:185|(4:187|(1:189)(1:190)|191|(1:193)(1:194)))(5:195|(1:197)|(2:202|203)|207|(1:(8:212|472|213|214|(1:216)(3:218|(2:220|(1:222))(2:224|(2:226|(1:228))(1:(4:231|232|(1:234)(1:236)|(8:238|239|(5:455|241|242|(3:244|245|(1:247))(2:249|(7:251|(3:255|(1:519)(2:261|(4:514|263|264|265)(1:520))|266)|516|267|268|(1:271)|272))|274)(1:277)|278|(1:280)(1:281)|282|(3:510|284|513)(7:470|285|286|(1:288)(3:289|(2:292|(2:480|294)(1:(5:300|301|(2:303|(1:305)(1:306))(3:307|(1:314)(1:313)|315)|316|(8:491|318|319|(3:324|325|(5:327|463|328|(1:330)(1:331)|332)(2:333|(1:335)))(1:336)|337|(3:339|(1:341)(2:342|(1:344))|345)(1:346)|347|512)(0))(3:505|348|349)))|295)|296|347|512)|511)(3:508|352|353))(3:507|354|355)))|223)|217|(0)(0)|511)))|198|(3:200|202|203)|207|(9:(0)|212|472|213|214|(0)(0)|217|(0)(0)|511))(2:207|(9:(0)|212|472|213|214|(0)(0)|217|(0)(0)|511)))|506|361|381|(1:383)|(1:385)|(1:387)|(1:389)|390)(1:174))(1:177)|178|179|(0)|506|361|381|(0)|(0)|(0)|(0)|390)(18:453|165|166|448|167|168|(0)(0)|178|179|(0)|506|361|381|(0)|(0)|(0)|(0)|390))|140|141|142|(0)|145|146|493|147|148|(0)(0)|486|158|159|(0)(0))(16:126|(2:128|(15:130|125|141|142|(0)|145|146|493|147|148|(0)(0)|486|158|159|(0)(0)))(2:131|(16:138|124|125|141|142|(0)|145|146|493|147|148|(0)(0)|486|158|159|(0)(0)))|140|141|142|(0)|145|146|493|147|148|(0)(0)|486|158|159|(0)(0))|429|(0)(0))(1:391)|392|(0)|395|482|396|400|429|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(16:121|(16:123|124|125|141|142|(1:144)|145|146|493|147|148|(4:478|150|474|151)(1:157)|486|158|159|(18:459|161|162|448|167|168|(3:461|170|(12:172|173|179|(2:181|(7:450|183|(2:185|(4:187|(1:189)(1:190)|191|(1:193)(1:194)))(5:195|(1:197)|(2:202|203)|207|(1:(8:212|472|213|214|(1:216)(3:218|(2:220|(1:222))(2:224|(2:226|(1:228))(1:(4:231|232|(1:234)(1:236)|(8:238|239|(5:455|241|242|(3:244|245|(1:247))(2:249|(7:251|(3:255|(1:519)(2:261|(4:514|263|264|265)(1:520))|266)|516|267|268|(1:271)|272))|274)(1:277)|278|(1:280)(1:281)|282|(3:510|284|513)(7:470|285|286|(1:288)(3:289|(2:292|(2:480|294)(1:(5:300|301|(2:303|(1:305)(1:306))(3:307|(1:314)(1:313)|315)|316|(8:491|318|319|(3:324|325|(5:327|463|328|(1:330)(1:331)|332)(2:333|(1:335)))(1:336)|337|(3:339|(1:341)(2:342|(1:344))|345)(1:346)|347|512)(0))(3:505|348|349)))|295)|296|347|512)|511)(3:508|352|353))(3:507|354|355)))|223)|217|(0)(0)|511)))|198|(3:200|202|203)|207|(9:(0)|212|472|213|214|(0)(0)|217|(0)(0)|511))(2:207|(9:(0)|212|472|213|214|(0)(0)|217|(0)(0)|511)))|506|361|381|(1:383)|(1:385)|(1:387)|(1:389)|390)(1:174))(1:177)|178|179|(0)|506|361|381|(0)|(0)|(0)|(0)|390)(18:453|165|166|448|167|168|(0)(0)|178|179|(0)|506|361|381|(0)|(0)|(0)|(0)|390))|140|141|142|(0)|145|146|493|147|148|(0)(0)|486|158|159|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x0440, code lost:
    
        r43 = r7;
        r2 = r44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x06fc, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x06fd, code lost:
    
        r49 = r8;
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:373:0x0703, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x0704, code lost:
    
        r49 = r8;
        r1 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x0753, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x0754, code lost:
    
        r0.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:401:0x0770, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x0772, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x0773, code lost:
    
        r2 = "time = ";
        r12 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:407:0x0778, code lost:
    
        r2 = "time = ";
        r1 = r0;
        r4 = r12;
        r13 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x0784, code lost:
    
        r1 = r0;
        r4 = r12;
        r13 = r13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0323 A[Catch: all -> 0x01a3, Exception -> 0x0263, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x01a3, blocks: (B:83:0x01c4, B:86:0x01d2, B:88:0x01dc, B:92:0x01ee, B:94:0x01f6, B:113:0x022e, B:119:0x0273, B:121:0x0295, B:123:0x0299, B:124:0x02a6, B:141:0x02f0, B:144:0x0323, B:145:0x0333, B:147:0x033b, B:150:0x0342, B:151:0x034b, B:158:0x035c, B:161:0x036d, B:167:0x0387, B:170:0x0397, B:172:0x03a3, B:183:0x03cb, B:185:0x03d1, B:187:0x03d7, B:189:0x03dd, B:191:0x03e4, B:193:0x03eb, B:194:0x03fc, B:190:0x03e0, B:200:0x0417, B:202:0x041f, B:213:0x0450, B:285:0x055d, B:294:0x0574, B:300:0x059a, B:303:0x05a0, B:316:0x05b9, B:318:0x05be, B:324:0x05cb, B:328:0x05d4, B:330:0x05e2, B:332:0x05fb, B:337:0x0647, B:339:0x064d, B:341:0x0653, B:342:0x0659, B:344:0x0663, B:380:0x0711, B:381:0x0719, B:383:0x071e, B:385:0x0723, B:387:0x0728, B:389:0x0730, B:394:0x073c, B:333:0x05ff, B:335:0x060f, B:322:0x05c5, B:307:0x05a8, B:309:0x05ac, B:348:0x0689, B:349:0x06a1, B:220:0x0463, B:222:0x0469, B:226:0x0478, B:228:0x047f, B:231:0x0487, B:234:0x048d, B:238:0x0496, B:241:0x049b, B:245:0x04a4, B:247:0x04aa, B:278:0x0540, B:282:0x0549, B:251:0x04b2, B:255:0x04cb, B:257:0x04cf, B:259:0x04d5, B:261:0x04db, B:263:0x04e1, B:265:0x04f1, B:268:0x0515, B:271:0x0521, B:272:0x052b, B:266:0x0503, B:352:0x06a4, B:353:0x06c3, B:236:0x0490, B:354:0x06c4, B:355:0x06de, B:165:0x037b, B:128:0x02ae, B:130:0x02ba, B:136:0x02d2, B:138:0x02da, B:100:0x0204, B:103:0x020e, B:106:0x0218, B:109:0x0222, B:114:0x025b, B:115:0x0262, B:65:0x0195), top: B:452:0x0178 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03c5  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x043d A[ADDED_TO_REGION, EDGE_INSN: B:209:0x043d->B:509:0x0440 BREAK  A[LOOP:1: B:208:0x043b->B:511:0x043b]] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x063f  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x071e A[Catch: all -> 0x01a3, Exception -> 0x01a5, TryCatch #3 {all -> 0x01a3, blocks: (B:83:0x01c4, B:86:0x01d2, B:88:0x01dc, B:92:0x01ee, B:94:0x01f6, B:113:0x022e, B:119:0x0273, B:121:0x0295, B:123:0x0299, B:124:0x02a6, B:141:0x02f0, B:144:0x0323, B:145:0x0333, B:147:0x033b, B:150:0x0342, B:151:0x034b, B:158:0x035c, B:161:0x036d, B:167:0x0387, B:170:0x0397, B:172:0x03a3, B:183:0x03cb, B:185:0x03d1, B:187:0x03d7, B:189:0x03dd, B:191:0x03e4, B:193:0x03eb, B:194:0x03fc, B:190:0x03e0, B:200:0x0417, B:202:0x041f, B:213:0x0450, B:285:0x055d, B:294:0x0574, B:300:0x059a, B:303:0x05a0, B:316:0x05b9, B:318:0x05be, B:324:0x05cb, B:328:0x05d4, B:330:0x05e2, B:332:0x05fb, B:337:0x0647, B:339:0x064d, B:341:0x0653, B:342:0x0659, B:344:0x0663, B:380:0x0711, B:381:0x0719, B:383:0x071e, B:385:0x0723, B:387:0x0728, B:389:0x0730, B:394:0x073c, B:333:0x05ff, B:335:0x060f, B:322:0x05c5, B:307:0x05a8, B:309:0x05ac, B:348:0x0689, B:349:0x06a1, B:220:0x0463, B:222:0x0469, B:226:0x0478, B:228:0x047f, B:231:0x0487, B:234:0x048d, B:238:0x0496, B:241:0x049b, B:245:0x04a4, B:247:0x04aa, B:278:0x0540, B:282:0x0549, B:251:0x04b2, B:255:0x04cb, B:257:0x04cf, B:259:0x04d5, B:261:0x04db, B:263:0x04e1, B:265:0x04f1, B:268:0x0515, B:271:0x0521, B:272:0x052b, B:266:0x0503, B:352:0x06a4, B:353:0x06c3, B:236:0x0490, B:354:0x06c4, B:355:0x06de, B:165:0x037b, B:128:0x02ae, B:130:0x02ba, B:136:0x02d2, B:138:0x02da, B:100:0x0204, B:103:0x020e, B:106:0x0218, B:109:0x0222, B:114:0x025b, B:115:0x0262, B:65:0x0195), top: B:452:0x0178 }] */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0723 A[Catch: all -> 0x01a3, Exception -> 0x01a5, TryCatch #3 {all -> 0x01a3, blocks: (B:83:0x01c4, B:86:0x01d2, B:88:0x01dc, B:92:0x01ee, B:94:0x01f6, B:113:0x022e, B:119:0x0273, B:121:0x0295, B:123:0x0299, B:124:0x02a6, B:141:0x02f0, B:144:0x0323, B:145:0x0333, B:147:0x033b, B:150:0x0342, B:151:0x034b, B:158:0x035c, B:161:0x036d, B:167:0x0387, B:170:0x0397, B:172:0x03a3, B:183:0x03cb, B:185:0x03d1, B:187:0x03d7, B:189:0x03dd, B:191:0x03e4, B:193:0x03eb, B:194:0x03fc, B:190:0x03e0, B:200:0x0417, B:202:0x041f, B:213:0x0450, B:285:0x055d, B:294:0x0574, B:300:0x059a, B:303:0x05a0, B:316:0x05b9, B:318:0x05be, B:324:0x05cb, B:328:0x05d4, B:330:0x05e2, B:332:0x05fb, B:337:0x0647, B:339:0x064d, B:341:0x0653, B:342:0x0659, B:344:0x0663, B:380:0x0711, B:381:0x0719, B:383:0x071e, B:385:0x0723, B:387:0x0728, B:389:0x0730, B:394:0x073c, B:333:0x05ff, B:335:0x060f, B:322:0x05c5, B:307:0x05a8, B:309:0x05ac, B:348:0x0689, B:349:0x06a1, B:220:0x0463, B:222:0x0469, B:226:0x0478, B:228:0x047f, B:231:0x0487, B:234:0x048d, B:238:0x0496, B:241:0x049b, B:245:0x04a4, B:247:0x04aa, B:278:0x0540, B:282:0x0549, B:251:0x04b2, B:255:0x04cb, B:257:0x04cf, B:259:0x04d5, B:261:0x04db, B:263:0x04e1, B:265:0x04f1, B:268:0x0515, B:271:0x0521, B:272:0x052b, B:266:0x0503, B:352:0x06a4, B:353:0x06c3, B:236:0x0490, B:354:0x06c4, B:355:0x06de, B:165:0x037b, B:128:0x02ae, B:130:0x02ba, B:136:0x02d2, B:138:0x02da, B:100:0x0204, B:103:0x020e, B:106:0x0218, B:109:0x0222, B:114:0x025b, B:115:0x0262, B:65:0x0195), top: B:452:0x0178 }] */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0728 A[Catch: all -> 0x01a3, Exception -> 0x01a5, TryCatch #3 {all -> 0x01a3, blocks: (B:83:0x01c4, B:86:0x01d2, B:88:0x01dc, B:92:0x01ee, B:94:0x01f6, B:113:0x022e, B:119:0x0273, B:121:0x0295, B:123:0x0299, B:124:0x02a6, B:141:0x02f0, B:144:0x0323, B:145:0x0333, B:147:0x033b, B:150:0x0342, B:151:0x034b, B:158:0x035c, B:161:0x036d, B:167:0x0387, B:170:0x0397, B:172:0x03a3, B:183:0x03cb, B:185:0x03d1, B:187:0x03d7, B:189:0x03dd, B:191:0x03e4, B:193:0x03eb, B:194:0x03fc, B:190:0x03e0, B:200:0x0417, B:202:0x041f, B:213:0x0450, B:285:0x055d, B:294:0x0574, B:300:0x059a, B:303:0x05a0, B:316:0x05b9, B:318:0x05be, B:324:0x05cb, B:328:0x05d4, B:330:0x05e2, B:332:0x05fb, B:337:0x0647, B:339:0x064d, B:341:0x0653, B:342:0x0659, B:344:0x0663, B:380:0x0711, B:381:0x0719, B:383:0x071e, B:385:0x0723, B:387:0x0728, B:389:0x0730, B:394:0x073c, B:333:0x05ff, B:335:0x060f, B:322:0x05c5, B:307:0x05a8, B:309:0x05ac, B:348:0x0689, B:349:0x06a1, B:220:0x0463, B:222:0x0469, B:226:0x0478, B:228:0x047f, B:231:0x0487, B:234:0x048d, B:238:0x0496, B:241:0x049b, B:245:0x04a4, B:247:0x04aa, B:278:0x0540, B:282:0x0549, B:251:0x04b2, B:255:0x04cb, B:257:0x04cf, B:259:0x04d5, B:261:0x04db, B:263:0x04e1, B:265:0x04f1, B:268:0x0515, B:271:0x0521, B:272:0x052b, B:266:0x0503, B:352:0x06a4, B:353:0x06c3, B:236:0x0490, B:354:0x06c4, B:355:0x06de, B:165:0x037b, B:128:0x02ae, B:130:0x02ba, B:136:0x02d2, B:138:0x02da, B:100:0x0204, B:103:0x020e, B:106:0x0218, B:109:0x0222, B:114:0x025b, B:115:0x0262, B:65:0x0195), top: B:452:0x0178 }] */
    /* JADX WARN: Removed duplicated region for block: B:389:0x0730 A[Catch: all -> 0x01a3, Exception -> 0x01a5, TryCatch #3 {all -> 0x01a3, blocks: (B:83:0x01c4, B:86:0x01d2, B:88:0x01dc, B:92:0x01ee, B:94:0x01f6, B:113:0x022e, B:119:0x0273, B:121:0x0295, B:123:0x0299, B:124:0x02a6, B:141:0x02f0, B:144:0x0323, B:145:0x0333, B:147:0x033b, B:150:0x0342, B:151:0x034b, B:158:0x035c, B:161:0x036d, B:167:0x0387, B:170:0x0397, B:172:0x03a3, B:183:0x03cb, B:185:0x03d1, B:187:0x03d7, B:189:0x03dd, B:191:0x03e4, B:193:0x03eb, B:194:0x03fc, B:190:0x03e0, B:200:0x0417, B:202:0x041f, B:213:0x0450, B:285:0x055d, B:294:0x0574, B:300:0x059a, B:303:0x05a0, B:316:0x05b9, B:318:0x05be, B:324:0x05cb, B:328:0x05d4, B:330:0x05e2, B:332:0x05fb, B:337:0x0647, B:339:0x064d, B:341:0x0653, B:342:0x0659, B:344:0x0663, B:380:0x0711, B:381:0x0719, B:383:0x071e, B:385:0x0723, B:387:0x0728, B:389:0x0730, B:394:0x073c, B:333:0x05ff, B:335:0x060f, B:322:0x05c5, B:307:0x05a8, B:309:0x05ac, B:348:0x0689, B:349:0x06a1, B:220:0x0463, B:222:0x0469, B:226:0x0478, B:228:0x047f, B:231:0x0487, B:234:0x048d, B:238:0x0496, B:241:0x049b, B:245:0x04a4, B:247:0x04aa, B:278:0x0540, B:282:0x0549, B:251:0x04b2, B:255:0x04cb, B:257:0x04cf, B:259:0x04d5, B:261:0x04db, B:263:0x04e1, B:265:0x04f1, B:268:0x0515, B:271:0x0521, B:272:0x052b, B:266:0x0503, B:352:0x06a4, B:353:0x06c3, B:236:0x0490, B:354:0x06c4, B:355:0x06de, B:165:0x037b, B:128:0x02ae, B:130:0x02ba, B:136:0x02d2, B:138:0x02da, B:100:0x0204, B:103:0x020e, B:106:0x0218, B:109:0x0222, B:114:0x025b, B:115:0x0262, B:65:0x0195), top: B:452:0x0178 }] */
    /* JADX WARN: Removed duplicated region for block: B:394:0x073c A[Catch: all -> 0x01a3, Exception -> 0x01a5, TRY_LEAVE, TryCatch #3 {all -> 0x01a3, blocks: (B:83:0x01c4, B:86:0x01d2, B:88:0x01dc, B:92:0x01ee, B:94:0x01f6, B:113:0x022e, B:119:0x0273, B:121:0x0295, B:123:0x0299, B:124:0x02a6, B:141:0x02f0, B:144:0x0323, B:145:0x0333, B:147:0x033b, B:150:0x0342, B:151:0x034b, B:158:0x035c, B:161:0x036d, B:167:0x0387, B:170:0x0397, B:172:0x03a3, B:183:0x03cb, B:185:0x03d1, B:187:0x03d7, B:189:0x03dd, B:191:0x03e4, B:193:0x03eb, B:194:0x03fc, B:190:0x03e0, B:200:0x0417, B:202:0x041f, B:213:0x0450, B:285:0x055d, B:294:0x0574, B:300:0x059a, B:303:0x05a0, B:316:0x05b9, B:318:0x05be, B:324:0x05cb, B:328:0x05d4, B:330:0x05e2, B:332:0x05fb, B:337:0x0647, B:339:0x064d, B:341:0x0653, B:342:0x0659, B:344:0x0663, B:380:0x0711, B:381:0x0719, B:383:0x071e, B:385:0x0723, B:387:0x0728, B:389:0x0730, B:394:0x073c, B:333:0x05ff, B:335:0x060f, B:322:0x05c5, B:307:0x05a8, B:309:0x05ac, B:348:0x0689, B:349:0x06a1, B:220:0x0463, B:222:0x0469, B:226:0x0478, B:228:0x047f, B:231:0x0487, B:234:0x048d, B:238:0x0496, B:241:0x049b, B:245:0x04a4, B:247:0x04aa, B:278:0x0540, B:282:0x0549, B:251:0x04b2, B:255:0x04cb, B:257:0x04cf, B:259:0x04d5, B:261:0x04db, B:263:0x04e1, B:265:0x04f1, B:268:0x0515, B:271:0x0521, B:272:0x052b, B:266:0x0503, B:352:0x06a4, B:353:0x06c3, B:236:0x0490, B:354:0x06c4, B:355:0x06de, B:165:0x037b, B:128:0x02ae, B:130:0x02ba, B:136:0x02d2, B:138:0x02da, B:100:0x0204, B:103:0x020e, B:106:0x0218, B:109:0x0222, B:114:0x025b, B:115:0x0262, B:65:0x0195), top: B:452:0x0178 }] */
    /* JADX WARN: Removed duplicated region for block: B:421:0x07ab  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x07b0  */
    /* JADX WARN: Removed duplicated region for block: B:431:0x080f  */
    /* JADX WARN: Removed duplicated region for block: B:437:0x0818  */
    /* JADX WARN: Removed duplicated region for block: B:439:0x081d  */
    /* JADX WARN: Removed duplicated region for block: B:453:0x037b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:459:0x036d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:461:0x0397 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:470:0x055d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:478:0x0342 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:510:0x0553 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:521:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013a  */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v15, types: [android.media.MediaExtractor] */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r13v10, types: [dc.wi3] */
    /* JADX WARN: Type inference failed for: r50v0, types: [com.wear.util.camera.videocompressor.VideoController] */
    /* JADX WARN: Type inference failed for: r5v2, types: [dc.xi3] */
    @android.annotation.TargetApi(16)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean b(java.lang.String r51, java.lang.String r52, int r53, com.wear.util.camera.videocompressor.VideoController.a r54) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2114
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.util.camera.videocompressor.VideoController.b(java.lang.String, java.lang.String, int, com.wear.util.camera.videocompressor.VideoController$a):boolean");
    }

    public final void c(boolean z, boolean z2) {
        if (this.b) {
            this.b = false;
        }
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(16)
    public final long f(MediaExtractor mediaExtractor, wi3 wi3Var, MediaCodec.BufferInfo bufferInfo, long j, long j2, File file, boolean z) throws Exception {
        long j3;
        boolean z2;
        int i = i(mediaExtractor, z);
        if (i < 0) {
            return -1L;
        }
        mediaExtractor.selectTrack(i);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
        int iA = wi3Var.a(trackFormat, z);
        int integer = trackFormat.getInteger("max-input-size");
        long j4 = 0;
        if (j > 0) {
            mediaExtractor.seekTo(j, 0);
        } else {
            mediaExtractor.seekTo(0L, 0);
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(integer);
        long j5 = -1;
        boolean z3 = false;
        while (!z3) {
            int sampleTrackIndex = mediaExtractor.getSampleTrackIndex();
            if (sampleTrackIndex == i) {
                int sampleData = mediaExtractor.readSampleData(byteBufferAllocateDirect, 0);
                bufferInfo.size = sampleData;
                if (sampleData < 0) {
                    bufferInfo.size = 0;
                    j3 = j4;
                } else {
                    long sampleTime = mediaExtractor.getSampleTime();
                    bufferInfo.presentationTimeUs = sampleTime;
                    if (j > 0 && j5 == -1) {
                        j5 = sampleTime;
                    }
                    j3 = 0;
                    if (j2 < 0 || sampleTime < j2) {
                        bufferInfo.offset = 0;
                        bufferInfo.flags = mediaExtractor.getSampleFlags();
                        wi3Var.q(iA, byteBufferAllocateDirect, bufferInfo, z);
                        mediaExtractor.advance();
                    }
                }
            } else {
                j3 = j4;
                z2 = sampleTrackIndex == -1;
            }
            if (z2) {
                z3 = true;
            }
            j4 = j3;
        }
        mediaExtractor.unselectTrack(i);
        return j5;
    }

    @TargetApi(16)
    public final int i(MediaExtractor mediaExtractor, boolean z) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            String string = mediaExtractor.getTrackFormat(i).getString("mime");
            if (z) {
                if (string.startsWith("audio/")) {
                    return i;
                }
            } else if (string.startsWith("video/")) {
                return i;
            }
        }
        return -5;
    }
}

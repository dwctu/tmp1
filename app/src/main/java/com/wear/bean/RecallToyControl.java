package com.wear.bean;

import com.epicgames.unreal.psoservices.PSOProgramService;
import com.lovense.wear.R;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.be3;
import dc.zt3;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* loaded from: classes3.dex */
public class RecallToyControl {
    public String address;
    public String authorName;
    public BufferedWriter bw;
    public String function;
    public FileWriter fw;
    public String id;
    public MediaPattern mediaPattern;
    public String name;
    public File tempSaveFile;
    public String[] funcArgs = null;
    private boolean isOverTime = false;
    private int timeIndex = 0;
    private String funString = "";
    private ToyBean lastToyBean = null;
    private List<String> datas = new ArrayList();

    public RecallToyControl(String str) {
        this.authorName = "";
        this.authorName = str;
        if (WearUtils.e1(str)) {
            this.authorName = "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0009 A[Catch: all -> 0x0018, TryCatch #0 {, blocks: (B:4:0x0003, B:5:0x0005, B:7:0x0009, B:8:0x0014), top: B:14:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized com.wear.bean.ToyBean setAndGet(com.wear.bean.ToyBean r1, boolean r2) {
        /*
            r0 = this;
            monitor-enter(r0)
            if (r2 == 0) goto L5
            r0.lastToyBean = r1     // Catch: java.lang.Throwable -> L18
        L5:
            com.wear.bean.ToyBean r1 = r0.lastToyBean     // Catch: java.lang.Throwable -> L18
            if (r1 != 0) goto L14
            com.wear.bean.ToyBean r1 = new com.wear.bean.ToyBean     // Catch: java.lang.Throwable -> L18
            r1.<init>()     // Catch: java.lang.Throwable -> L18
            r0.lastToyBean = r1     // Catch: java.lang.Throwable -> L18
            r2 = 0
            r1.setAll(r2)     // Catch: java.lang.Throwable -> L18
        L14:
            com.wear.bean.ToyBean r1 = r0.lastToyBean     // Catch: java.lang.Throwable -> L18
            monitor-exit(r0)
            return r1
        L18:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.bean.RecallToyControl.setAndGet(com.wear.bean.ToyBean, boolean):com.wear.bean.ToyBean");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0053 A[Catch: all -> 0x00f8, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x001e, B:7:0x0022, B:11:0x0034, B:10:0x0031, B:12:0x0038, B:14:0x003c, B:16:0x0042, B:18:0x0053, B:19:0x0057, B:21:0x006e, B:23:0x0078, B:25:0x0085, B:26:0x00ef), top: B:32:0x0001, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void closeSaveFile() {
        /*
            r8 = this;
            monitor-enter(r8)
            java.io.PrintStream r0 = java.lang.System.out     // Catch: java.lang.Throwable -> Lf8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf8
            r1.<init>()     // Catch: java.lang.Throwable -> Lf8
            java.lang.String r2 = "receiveToyCode.closeSaveFile="
            r1.append(r2)     // Catch: java.lang.Throwable -> Lf8
            java.io.File r2 = r8.tempSaveFile     // Catch: java.lang.Throwable -> Lf8
            r1.append(r2)     // Catch: java.lang.Throwable -> Lf8
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lf8
            r0.println(r1)     // Catch: java.lang.Throwable -> Lf8
            java.io.FileWriter r0 = r8.fw     // Catch: java.lang.Throwable -> Lf8
            r1 = 0
            if (r0 == 0) goto L38
            java.io.BufferedWriter r0 = r8.bw     // Catch: java.lang.Throwable -> Lf8
            if (r0 == 0) goto L38
            r0.flush()     // Catch: java.io.IOException -> L30 java.lang.Throwable -> Lf8
            java.io.BufferedWriter r0 = r8.bw     // Catch: java.io.IOException -> L30 java.lang.Throwable -> Lf8
            r0.close()     // Catch: java.io.IOException -> L30 java.lang.Throwable -> Lf8
            java.io.FileWriter r0 = r8.fw     // Catch: java.io.IOException -> L30 java.lang.Throwable -> Lf8
            r0.close()     // Catch: java.io.IOException -> L30 java.lang.Throwable -> Lf8
            goto L34
        L30:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> Lf8
        L34:
            r8.bw = r1     // Catch: java.lang.Throwable -> Lf8
            r8.fw = r1     // Catch: java.lang.Throwable -> Lf8
        L38:
            java.io.File r0 = r8.tempSaveFile     // Catch: java.lang.Throwable -> Lf8
            if (r0 == 0) goto Lf6
            boolean r0 = r0.exists()     // Catch: java.lang.Throwable -> Lf8
            if (r0 == 0) goto Lf6
            java.io.File r0 = r8.tempSaveFile     // Catch: java.lang.Throwable -> Lf8
            java.lang.String r0 = r0.getPath()     // Catch: java.lang.Throwable -> Lf8
            java.lang.String r0 = com.wear.util.WearUtils.N1(r0)     // Catch: java.lang.Throwable -> Lf8
            boolean r2 = dc.rf3.o(r0)     // Catch: java.lang.Throwable -> Lf8
            r3 = 1
            if (r2 != r3) goto L57
            java.lang.String r0 = dc.rf3.r(r0)     // Catch: java.lang.Throwable -> Lf8
        L57:
            java.lang.String r2 = "$$"
            java.lang.String r4 = "7MoL49w1Yo5HNeH2"
            java.lang.String r0 = r0.replace(r2, r4)     // Catch: java.lang.Throwable -> Lf8
            com.wear.bean.Pattern r2 = new com.wear.bean.Pattern     // Catch: java.lang.Throwable -> Lf8
            r2.<init>()     // Catch: java.lang.Throwable -> Lf8
            r2.setDataNoCheckFormat(r0)     // Catch: java.lang.Throwable -> Lf8
            r2.setDataString(r0)     // Catch: java.lang.Throwable -> Lf8
            com.wear.bean.MediaPattern r4 = r8.mediaPattern     // Catch: java.lang.Throwable -> Lf8
            if (r4 == 0) goto Lef
            java.lang.String r4 = r2.getData()     // Catch: java.lang.Throwable -> Lf8
            boolean r4 = com.wear.util.WearUtils.e1(r4)     // Catch: java.lang.Throwable -> Lf8
            if (r4 != 0) goto Lef
            java.lang.String r4 = r2.getData()     // Catch: java.lang.Throwable -> Lf8
            java.lang.String r5 = ";"
            java.lang.String[] r4 = r4.split(r5)     // Catch: java.lang.Throwable -> Lf8
            int r4 = r4.length     // Catch: java.lang.Throwable -> Lf8
            if (r4 <= 0) goto Lef
            java.lang.String r4 = r2.getData()     // Catch: java.lang.Throwable -> Lf8
            java.lang.String r5 = ";"
            java.lang.String[] r4 = r4.split(r5)     // Catch: java.lang.Throwable -> Lf8
            int r4 = r4.length     // Catch: java.lang.Throwable -> Lf8
            r5 = 100
            java.lang.String r4 = r2.calculateTime(r4, r5)     // Catch: java.lang.Throwable -> Lf8
            java.io.PrintStream r5 = java.lang.System.out     // Catch: java.lang.Throwable -> Lf8
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lf8
            r6.<init>()     // Catch: java.lang.Throwable -> Lf8
            java.lang.String r7 = "datas.size():"
            r6.append(r7)     // Catch: java.lang.Throwable -> Lf8
            java.lang.String r2 = r2.getData()     // Catch: java.lang.Throwable -> Lf8
            java.lang.String r7 = ";"
            java.lang.String[] r2 = r2.split(r7)     // Catch: java.lang.Throwable -> Lf8
            int r2 = r2.length     // Catch: java.lang.Throwable -> Lf8
            r6.append(r2)     // Catch: java.lang.Throwable -> Lf8
            java.lang.String r2 = " ->recallTimes:"
            r6.append(r2)     // Catch: java.lang.Throwable -> Lf8
            r6.append(r4)     // Catch: java.lang.Throwable -> Lf8
            java.lang.String r2 = r6.toString()     // Catch: java.lang.Throwable -> Lf8
            r5.println(r2)     // Catch: java.lang.Throwable -> Lf8
            com.wear.bean.MediaPattern r2 = r8.mediaPattern     // Catch: java.lang.Throwable -> Lf8
            com.wear.bean.Pattern r2 = r2.getPattern()     // Catch: java.lang.Throwable -> Lf8
            r2.setTimer(r4)     // Catch: java.lang.Throwable -> Lf8
            com.wear.bean.MediaPattern r2 = r8.mediaPattern     // Catch: java.lang.Throwable -> Lf8
            com.wear.bean.Pattern r2 = r2.getPattern()     // Catch: java.lang.Throwable -> Lf8
            java.lang.String r2 = r2.getId()     // Catch: java.lang.Throwable -> Lf8
            java.lang.String r0 = com.wear.util.WearUtils.r0(r0)     // Catch: java.lang.Throwable -> Lf8
            com.wear.util.WearUtils.l2(r2, r0)     // Catch: java.lang.Throwable -> Lf8
            dc.ue2 r0 = dc.xe2.L0()     // Catch: java.lang.Throwable -> Lf8
            com.wear.bean.MediaPattern r2 = r8.mediaPattern     // Catch: java.lang.Throwable -> Lf8
            com.wear.bean.Pattern r2 = r2.getPattern()     // Catch: java.lang.Throwable -> Lf8
            r0.t(r2, r3)     // Catch: java.lang.Throwable -> Lf8
            com.wear.dao.MediaPatternDao r0 = com.wear.dao.DaoUtils.getMediaPatternDao()     // Catch: java.lang.Throwable -> Lf8
            com.wear.bean.MediaPattern r2 = r8.mediaPattern     // Catch: java.lang.Throwable -> Lf8
            r0.addIfNotExist(r2)     // Catch: java.lang.Throwable -> Lf8
        Lef:
            java.io.File r0 = r8.tempSaveFile     // Catch: java.lang.Throwable -> Lf8
            r0.delete()     // Catch: java.lang.Throwable -> Lf8
            r8.tempSaveFile = r1     // Catch: java.lang.Throwable -> Lf8
        Lf6:
            monitor-exit(r8)
            return
        Lf8:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.bean.RecallToyControl.closeSaveFile():void");
    }

    public void createHeadFile(String str) {
        if (WearUtils.e1(str)) {
            return;
        }
        this.isOverTime = false;
        this.timeIndex = 0;
        this.mediaPattern = new MediaPattern();
        Pattern pattern = new Pattern();
        pattern.setToyFunc(this.function);
        pattern.setEmail(zt3.k);
        pattern.setCreator(zt3.k);
        pattern.setAuthor(this.authorName);
        pattern.setCreated(be3.I());
        pattern.setName(String.format(ah4.e(R.string.pattern_dialog_title_format), be3.m(be3.l)));
        if (!WearUtils.e1(this.function) && this.function.equals("pos")) {
            pattern.setToyTag(this.function);
        }
        this.mediaPattern.setPattern(pattern, str);
        if (!WearUtils.e1(this.function)) {
            this.funcArgs = this.function.split(",");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("V:1;T:" + this.name + ";F:" + this.function + ";S:100;M:" + PatternHead.P_M_DEF + ";#" + System.getProperty("line.separator"));
        WearUtils.n2(arrayList, pattern.getId(), false);
        StringBuilder sb = new StringBuilder();
        sb.append("temp/");
        sb.append(pattern.getId());
        sb.append("temp");
        this.tempSaveFile = WearUtils.e0(sb.toString());
        this.datas.clear();
        if (!this.tempSaveFile.exists()) {
            this.tempSaveFile = null;
            return;
        }
        try {
            this.fw = new FileWriter(this.tempSaveFile, true);
            this.bw = new BufferedWriter(this.fw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAddress() {
        return this.address;
    }

    public String getId() {
        return this.id;
    }

    public MediaPattern getMediaPattern() {
        return this.mediaPattern;
    }

    public void pushCommand(ToyBean toyBean) {
        setAndGet(toyBean, true);
    }

    public void recallTimer100() {
        ToyBean andGet;
        String[] strArr;
        if (this.isOverTime || (andGet = setAndGet(null, false)) == null || (strArr = this.funcArgs) == null) {
            return;
        }
        this.funString = "";
        for (String str : strArr) {
            if (!WearUtils.e1(str)) {
                if (str.toLowerCase().equals(PSOProgramService.VS_Key)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.funString);
                    sb.append(andGet.getV() == -1 ? 0 : andGet.getV());
                    sb.append(",");
                    this.funString = sb.toString();
                } else if (str.toLowerCase().equals("v1")) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.funString);
                    sb2.append(andGet.getV1() == -1 ? 0 : andGet.getV1());
                    sb2.append(",");
                    this.funString = sb2.toString();
                } else if (str.toLowerCase().equals("v2")) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.funString);
                    sb3.append(andGet.getV2() == -1 ? 0 : andGet.getV2());
                    sb3.append(",");
                    this.funString = sb3.toString();
                } else if (str.toLowerCase().equals("v3")) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(this.funString);
                    sb4.append(andGet.getV3() == -1 ? 0 : andGet.getV3());
                    sb4.append(",");
                    this.funString = sb4.toString();
                } else if (str.toLowerCase().equals(StreamManagement.AckRequest.ELEMENT)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(this.funString);
                    sb5.append(andGet.getR() == -1 ? 0 : andGet.getR());
                    sb5.append(",");
                    this.funString = sb5.toString();
                } else if (str.toLowerCase().equals("p")) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(this.funString);
                    sb6.append(andGet.getP() == -1 ? 0 : andGet.getP());
                    sb6.append(",");
                    this.funString = sb6.toString();
                } else if (str.toLowerCase().equals("s")) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(this.funString);
                    sb7.append(andGet.getS() == -1 ? 0 : andGet.getS());
                    sb7.append(",");
                    this.funString = sb7.toString();
                } else if (str.equals("f")) {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(this.funString);
                    sb8.append(andGet.getF() == -1 ? 0 : andGet.getF());
                    sb8.append(",");
                    this.funString = sb8.toString();
                } else if (str.equals("t")) {
                    StringBuilder sb9 = new StringBuilder();
                    sb9.append(this.funString);
                    sb9.append(andGet.getT() == -1 ? 0 : andGet.getT());
                    sb9.append(",");
                    this.funString = sb9.toString();
                } else if (str.equals("pos")) {
                    StringBuilder sb10 = new StringBuilder();
                    sb10.append(this.funString);
                    sb10.append(andGet.getPos() == -1 ? 0 : andGet.getPos() / 5);
                    sb10.append(",");
                    this.funString = sb10.toString();
                }
            }
        }
        if (this.funString.endsWith(",")) {
            String str2 = this.funString;
            this.funString = str2.substring(0, str2.length() - 1);
        }
        if (WearUtils.e1(this.funString) || this.fw == null || this.bw == null) {
            return;
        }
        try {
            this.datas.add(this.funString);
            if (this.datas.size() >= 10) {
                int i = this.timeIndex + 1;
                this.timeIndex = i;
                if (i >= 3599) {
                    this.isOverTime = true;
                }
                this.bw.write(WearUtils.G1(this.datas, ";") + ";");
                this.bw.flush();
                this.datas.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setFunction(String str) {
        this.function = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }
}

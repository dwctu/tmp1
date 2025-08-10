package com.wear.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.nd3;
import dc.pc1;
import java.util.List;
import org.aspectj.runtime.reflect.SignatureImpl;

@DatabaseTable(tableName = "tb_program_pattern")
/* loaded from: classes3.dex */
public class ProgramPattern extends BaseEntity {
    public static final int eachSleepTime = 160;
    public static final String writePatternChar = ",w";
    public static final String writePatternChar100 = "f";

    @DatabaseField
    private String author;

    @DatabaseField
    private String btAddress;

    @DatabaseField
    private String data;

    @DatabaseField
    private String email;

    @DatabaseField
    private String index;

    @DatabaseField
    private String name;

    @DatabaseField
    private String timer;
    private int uploadToToyTotalComman = 0;

    public interface UploadToyListener {
        void finish(String str);

        void params(String str, int i);
    }

    public void addData(String str) {
        if (this.data == null) {
            this.data = "";
        }
        this.data += str;
    }

    public void calculateTime(int i) {
        if (WearUtils.e1(this.data)) {
            return;
        }
        int iFloor = (int) Math.floor(this.data.length() * (i / 1000.0f));
        if (this.data.length() % (1000 / i) != 0) {
            iFloor++;
        }
        System.out.println("pd-->" + this.data.length() + " sec:" + iFloor);
        this.timer = WearUtils.Q(iFloor <= 0 ? 1L : iFloor);
    }

    public String getAuthor() {
        return this.author;
    }

    public String getBtAddress() {
        return this.btAddress;
    }

    public String getData() {
        return this.data;
    }

    public String getEmail() {
        String strF = nd3.f(this.email);
        return WearUtils.e1(strF) ? this.email : strF;
    }

    public String getIndex() {
        return this.index;
    }

    public String getName() {
        return this.name;
    }

    public String getOldEmail() {
        return this.email;
    }

    public String getTimer() {
        return this.timer;
    }

    public int getUploadToToyTotalComman() {
        return this.uploadToToyTotalComman;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    public void setBtAddress(String str) {
        this.btAddress = str;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setEmail(String str) {
        this.email = nd3.p(str);
    }

    public void setIndex(String str) {
        this.index = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setTimer(String str) {
        this.timer = str;
    }

    public void setUploadToToyTotalComman(int i) {
        this.uploadToToyTotalComman = i;
    }

    public String[] splitData() {
        if (WearUtils.e1(this.data)) {
            return null;
        }
        String[] strArr = new String[this.data.length()];
        for (int i = 0; i < this.data.length(); i++) {
            String strValueOf = "0";
            if (!"0".equals(String.valueOf(this.data.charAt(i)))) {
                strValueOf = String.valueOf(((Integer.valueOf(String.valueOf(this.data.charAt(i))).intValue() * 2) + 2) * 5);
            }
            strArr[i] = strValueOf;
        }
        return strArr;
    }

    public boolean writeToToy(boolean z, MyApplication myApplication, final pc1 pc1Var, final Toy toy, final UploadToyListener uploadToyListener) throws InterruptedException {
        String string;
        boolean z2 = false;
        if (WearUtils.e1(getIndex()) || this.data == null) {
            return false;
        }
        boolean z3 = true;
        boolean z4 = !toy.getType().toLowerCase().equals("domi".toLowerCase()) || toy.getVersion().intValue() > 37;
        int i = z4 ? 5 : 9;
        if (z && this.data.length() == 2) {
            z2 = true;
        }
        if (this.data.length() <= i && !z2) {
            uploadToyListener.params(writePatternChar, 1);
            String str = "Ps:" + getIndex() + SignatureImpl.INNER_SEP + this.data + ",w1;";
            String str2 = "command=" + str;
            try {
                Thread.sleep(160L);
            } catch (InterruptedException unused) {
            }
            pc1Var.l(toy.getAddress(), str);
            uploadToyListener.finish(writePatternChar);
            return true;
        }
        String str3 = this.data;
        if (z2) {
            i = 1;
        }
        List<String> listU = WearUtils.U(str3, i);
        uploadToyListener.params(writePatternChar, listU.size());
        int i2 = 1;
        for (String str4 : listU) {
            if (z4 == z3) {
                StringBuilder sb = new StringBuilder();
                sb.append("Pl");
                sb.append(getIndex());
                sb.append(SignatureImpl.INNER_SEP);
                sb.append(i2);
                sb.append("/");
                sb.append(listU.size());
                sb.append(SignatureImpl.INNER_SEP);
                sb.append(str4);
                sb.append(writePatternChar);
                sb.append(i2 >= 100 ? "f" : Integer.valueOf(i2));
                sb.append(";");
                string = sb.toString();
            } else {
                string = "Pl" + getIndex() + SignatureImpl.INNER_SEP + i2 + "/" + listU.size() + SignatureImpl.INNER_SEP + str4 + ";";
            }
            final String str5 = string;
            final int i3 = i2 + 1;
            String str6 = "pl.command=" + str5;
            final int size = listU.size();
            final boolean z5 = z4;
            WearUtils.x.l.postDelayed(new Runnable() { // from class: com.wear.bean.ProgramPattern.1
                @Override // java.lang.Runnable
                public void run() {
                    pc1Var.l(toy.getAddress(), str5);
                    if (i3 <= size || z5) {
                        return;
                    }
                    WearUtils.x.l.postDelayed(new Runnable() { // from class: com.wear.bean.ProgramPattern.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            if (i3 > size) {
                                uploadToyListener.finish(ProgramPattern.writePatternChar);
                            }
                        }
                    }, 160L);
                }
            }, i3 * 160);
            i2 = i3;
            z3 = true;
        }
        return true;
    }

    public void setData(Pattern pattern, int i, List<List<String>> list) throws NumberFormatException {
        String vibrateSplit_0_20_TO_BT_0_9;
        if (pattern == null) {
            return;
        }
        if (pattern.getData() == null) {
            pattern.setData(WearUtils.N1(pattern.getFile().getPath()));
        }
        if (WearUtils.e1(pattern.getData())) {
            return;
        }
        if (pattern.getHead() == null) {
            vibrateSplit_0_20_TO_BT_0_9 = WearUtils.W1(pattern.getData());
        } else {
            vibrateSplit_0_20_TO_BT_0_9 = pattern.getHead().getVibrateSplit_0_20_TO_BT_0_9(pattern.getData(), list);
            if (WearUtils.e1(vibrateSplit_0_20_TO_BT_0_9)) {
                return;
            }
        }
        String str = "data09String=" + vibrateSplit_0_20_TO_BT_0_9;
        String strX1 = WearUtils.X1(vibrateSplit_0_20_TO_BT_0_9, i);
        String str2 = "date_each_5=" + strX1;
        String strReplaceAll = strX1.replaceAll(",", "");
        if (i == 100) {
            if (strReplaceAll.length() >= 500) {
                strReplaceAll = strReplaceAll.substring(0, 500);
            }
        } else if (strReplaceAll.length() >= 100) {
            strReplaceAll = strReplaceAll.substring(0, 100);
        }
        String str3 = "dataString=" + strReplaceAll;
        String str4 = "dataString.length()=" + strReplaceAll.length() + " dataString.getBytes().length=" + strReplaceAll.getBytes().length;
        this.data = strReplaceAll;
    }
}

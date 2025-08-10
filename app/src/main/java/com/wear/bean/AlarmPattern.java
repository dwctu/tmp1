package com.wear.bean;

import com.epicgames.unreal.psoservices.PSOProgramService;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.util.WearUtils;
import dc.nd3;
import java.io.File;

@DatabaseTable(tableName = "tb_alarm_pattern")
/* loaded from: classes3.dex */
public class AlarmPattern extends BaseEntity {

    @DatabaseField
    private String alarmUrl;

    @DatabaseField
    private String author;
    private boolean checkMd5 = true;

    @DatabaseField
    private String creator;
    private String data;

    @DatabaseField
    private String email;
    private PatternHead head;
    private boolean isExist;
    private int likeCount;

    @DatabaseField
    private String name;
    private String path;

    @DatabaseField
    private boolean shared;

    @DatabaseField
    private int sortId;

    @DatabaseField
    private String text;

    @DatabaseField
    private String timer;

    @DatabaseField
    private String toyFunc;
    private String toyTag;

    public AlarmPattern() {
        setId(WearUtils.E());
    }

    public String getAlarmUrl() {
        return this.alarmUrl;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getCreator() {
        String strF = nd3.f(this.creator);
        return WearUtils.e1(strF) ? this.creator : strF;
    }

    public String getData() {
        return this.data;
    }

    public String getEmail() {
        String strF = nd3.f(this.email);
        return WearUtils.e1(strF) ? this.email : strF;
    }

    public File getFile() {
        return new File(WearUtils.T("pattern"), getId());
    }

    public PatternHead getHead() {
        return this.head;
    }

    public int getLikeCount() {
        return this.likeCount;
    }

    public String getName() {
        return this.name;
    }

    public String getOldCreator() {
        return this.creator;
    }

    public String getOldEmail() {
        return this.email;
    }

    public String getPath() {
        return this.path;
    }

    public int getSortId() {
        return this.sortId;
    }

    public String getText() {
        return this.text;
    }

    public String getTimer() {
        return this.timer;
    }

    public String getToyFunc() {
        return this.toyFunc;
    }

    public String getToyTag() {
        return this.toyTag;
    }

    public boolean isCheckMd5() {
        return this.checkMd5;
    }

    public boolean isExist() {
        return this.isExist;
    }

    public boolean isShared() {
        return this.shared;
    }

    public void setAlarmUrl(String str) {
        this.alarmUrl = str;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    public void setCreator(String str) {
        this.creator = nd3.p(str);
    }

    public void setData(String str) {
        this.data = str;
        if (str.indexOf("#") > 0) {
            String strReplace = str.replace("#\n;", "#").replace("#\n", "#");
            this.head = new PatternHead(strReplace.substring(0, strReplace.indexOf("#")));
            String strSubstring = strReplace.substring(strReplace.indexOf("#") + 1, strReplace.length());
            this.data = strSubstring;
            this.data = strSubstring.replace(System.getProperty("line.separator"), "");
            if (this.head.getFunction() == null || (this.head.getFunction().indexOf(",") == -1 && this.head.getFunction().length() > 1)) {
                this.data = "";
                this.checkMd5 = false;
            }
            if (!WearUtils.e1(this.head.getVersion()) || WearUtils.q1(this.head.getVersion())) {
                int iIntValue = Integer.valueOf(this.head.getVersion()).intValue();
                if (WearUtils.e1(this.head.getMd())) {
                    if (iIntValue == 1) {
                        this.checkMd5 = true;
                    } else {
                        this.checkMd5 = false;
                    }
                } else if (!WearUtils.r0(str.replace(this.head.getMd(), PatternHead.P_M)).equals(this.head.getMd())) {
                    this.checkMd5 = false;
                }
            } else {
                this.checkMd5 = false;
            }
            if (this.checkMd5) {
                return;
            }
            this.data = "";
        }
    }

    public void setEmail(String str) {
        this.email = nd3.p(str);
    }

    public void setExist(boolean z) {
        this.isExist = z;
    }

    public void setLikeCount(int i) {
        this.likeCount = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setShared(boolean z) {
        this.shared = z;
    }

    public void setSortId(int i) {
        this.sortId = i;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTimer(String str) {
        this.timer = str;
    }

    public void setToyFunc(String str) {
        if (WearUtils.e1(str)) {
            str = PSOProgramService.VS_Key;
        }
        this.toyFunc = str;
    }

    public void setToyTag(String str) {
        this.toyTag = str;
    }

    public AlarmPattern(String str) {
        setId(str);
    }

    public AlarmPattern(Pattern pattern) {
        setId(pattern.getId());
        this.name = pattern.getName();
        this.text = pattern.getText();
        this.shared = pattern.isShared();
        this.timer = pattern.getTimer();
        this.email = pattern.getEmail();
        this.creator = nd3.p(pattern.getCreator());
        this.author = pattern.getAuthor();
        this.sortId = pattern.getSortId();
        this.toyTag = pattern.getToyTag();
        this.toyFunc = pattern.getToyFunc();
        this.data = pattern.getData();
    }
}

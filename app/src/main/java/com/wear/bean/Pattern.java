package com.wear.bean;

import android.text.TextUtils;
import android.util.LruCache;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.lovense.wear.R;
import com.wear.bean.handlerbean.IHandlerPattern;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.nd3;
import dc.sg3;
import java.io.File;

@DatabaseTable(tableName = "tb_pattern")
/* loaded from: classes3.dex */
public class Pattern extends BaseEntity implements IHandlerPattern {
    public static final LruCache<String, Pattern> CACHE = new LruCache<>(10);
    public static final String DOWNLOAD = "download";

    @DatabaseField
    private String author;
    private String cdnPath;

    @DatabaseField
    private String creator;
    private String data;

    @DatabaseField
    private String email;

    @DatabaseField
    private String emails;
    private int favoritesCount;
    private PatternHead head;
    private String hidePatternId;

    @DatabaseField
    private boolean isAllFun;

    @DatabaseField
    private boolean isAnony;
    private boolean isExist;
    private String isNeedReport;
    private String isShowReview;

    @DatabaseField
    private long lastUpdTime;
    private int likeCount;

    @DatabaseField
    private String name;

    @DatabaseField
    private String path;
    private String patternStoreTag;

    @DatabaseField
    private boolean shared;

    @DatabaseField
    private int sortId;
    private String syncFialMsg;

    @DatabaseField
    private int syncStatus;
    private String tagAvatarUrl;
    private String tagName;

    @DatabaseField
    private String text;

    @DatabaseField
    private String timer;

    @DatabaseField
    private String toyFeature;

    @DatabaseField
    private String toyFunc;

    @DatabaseField
    private String toyName;

    @DatabaseField
    private String toySymbol;
    private String toyTag;

    @DatabaseField
    private String toyVersion;
    private boolean favorite = false;

    @DatabaseField
    private String status = AppMeasurementSdk.ConditionalUserProperty.ACTIVE;

    @DatabaseField
    private Boolean isOnline = Boolean.FALSE;
    private int downloadStatus = -1;
    private boolean checkMd5 = true;
    private boolean isShowFormatToast = true;

    public Pattern() {
        setId(WearUtils.E());
    }

    private boolean sameEmail(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return str.equals(str2);
    }

    public boolean PatternhasTargetEmail(String str) {
        boolean z = false;
        for (String str2 : this.emails.split(",")) {
            if (sameEmail(str, nd3.f(str2))) {
                z = true;
            }
        }
        return z;
    }

    public String calculateTime(int i, int i2) {
        if (i <= 0) {
            return "00:01";
        }
        int iFloor = (int) Math.floor(i * (i2 / 1000.0f));
        if (i % (1000 / i2) != 0) {
            iFloor++;
        }
        return WearUtils.Q(iFloor <= 0 ? 1L : iFloor);
    }

    @Override // com.wear.bean.handlerbean.IHandlerPattern
    public void del() {
        setStatus("removed");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return getId().equals(((Pattern) obj).getId());
    }

    public String getAuthor() {
        return this.author;
    }

    @Override // com.wear.bean.handlerbean.IHandlerPattern
    public String getBeanId() {
        return getId();
    }

    @Override // com.wear.bean.handlerbean.IHandlerPattern
    public int getCSortId() {
        return getSortId();
    }

    public String getCdnPath() {
        return this.cdnPath;
    }

    @Override // com.wear.bean.handlerbean.IHandlerPattern
    public long getCdtTime() {
        return getCreated() == null ? getLastUpdTime() : getCreated().getTime();
    }

    public String getCreator() {
        String strF = nd3.f(this.creator);
        return WearUtils.e1(strF) ? this.creator : strF;
    }

    public String getData() {
        return this.data;
    }

    public int getDownloadStatus() {
        return this.downloadStatus;
    }

    public String getEmail() {
        String strF = nd3.f(this.email);
        return WearUtils.e1(strF) ? this.email : strF;
    }

    public String getEmails(boolean z) {
        String strF;
        if (z) {
            strF = nd3.f(this.emails);
            if (WearUtils.e1(strF)) {
                strF = this.emails;
            }
        } else {
            strF = this.emails;
        }
        return TextUtils.isEmpty(strF) ? this.email : strF;
    }

    public int getFavoritesCount() {
        return this.favoritesCount;
    }

    public File getFile() {
        return new File(WearUtils.T("pattern"), getId());
    }

    public PatternHead getHead() {
        return this.head;
    }

    public String getHidePatternId() {
        return this.hidePatternId;
    }

    public String getIsNeedReport() {
        return this.isNeedReport;
    }

    public String getIsShowReview() {
        return this.isShowReview;
    }

    public long getLastUpdTime() {
        long j = this.lastUpdTime;
        return j == 0 ? getCreated().getTime() : j;
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

    public Boolean getOnline() {
        return this.isOnline;
    }

    public String getPath() {
        return this.path;
    }

    public String getPatternStoreTag() {
        return this.patternStoreTag;
    }

    public int getSortId() {
        return this.sortId;
    }

    public String getStatus() {
        if (TextUtils.isEmpty(this.status)) {
            this.status = AppMeasurementSdk.ConditionalUserProperty.ACTIVE;
        }
        return this.status;
    }

    public String getSyncFialMsg() {
        return this.syncFialMsg;
    }

    public int getSyncStatus() {
        return this.syncStatus;
    }

    public String getTagAvatarUrl() {
        return this.tagAvatarUrl;
    }

    public String getTagName() {
        return this.tagName;
    }

    public String getText() {
        return this.text;
    }

    public String getTimer() {
        return this.timer;
    }

    public String getToyFeature() {
        return this.toyFeature;
    }

    public String getToyFunc() {
        return this.toyFunc;
    }

    public String getToyName() {
        return this.toyName;
    }

    public String getToySymbol() {
        return this.toySymbol;
    }

    public String getToyTag() {
        return this.toyTag;
    }

    public String getToyVersion() {
        return this.toyVersion;
    }

    public boolean isAllFun() {
        return this.isAllFun;
    }

    public boolean isAnony() {
        return this.isAnony;
    }

    public boolean isCheckMd5() {
        return this.checkMd5;
    }

    @Override // com.wear.bean.handlerbean.IHandlerPattern
    public boolean isDel() {
        return "removed".equals(this.status);
    }

    public boolean isDownload() {
        return !WearUtils.e1(this.status) && this.status.equals(DOWNLOAD);
    }

    public boolean isExist() {
        return this.isExist;
    }

    public boolean isFavorite() {
        return this.favorite;
    }

    public boolean isShared() {
        return this.shared;
    }

    public boolean isSystemPattern() {
        return "system".equals(getAuthor()) && "system".equals(getCreator());
    }

    @Override // com.wear.bean.handlerbean.IHandlerPattern
    public boolean neverSync() {
        int i = this.syncStatus;
        return i == 2 || i == 3;
    }

    public void setAllFun(boolean z) {
        this.isAllFun = z;
    }

    public void setAnony(boolean z) {
        this.isAnony = z;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    public void setCdnPath(String str) {
        this.cdnPath = str;
    }

    public void setCreator(String str) {
        this.creator = nd3.p(str);
    }

    public void setData(String str) {
        this.data = str;
        if (str.indexOf("#") <= 0) {
            if (WearUtils.e1(str) || !str.contains("result")) {
                return;
            }
            this.checkMd5 = false;
            this.data = "";
            return;
        }
        String strReplace = str.replace("#\n;", "#").replace("#\n", "#");
        this.head = new PatternHead(strReplace.substring(0, strReplace.indexOf("#")));
        String strSubstring = strReplace.substring(strReplace.indexOf("#") + 1, strReplace.length());
        this.data = strSubstring;
        this.data = strSubstring.replace(System.getProperty("line.separator"), "");
        if ((this.head.getFunction() == null || (this.head.getFunction().indexOf(",") == -1 && this.head.getFunction().length() > 1)) && !this.head.getFunction().equals("pos")) {
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
        if (!this.checkMd5) {
            this.data = "";
        }
        if (isCheckMd5() || !this.isShowFormatToast) {
            return;
        }
        MyApplication myApplication = WearUtils.x;
        if (MyApplication.H() != null) {
            MyApplication myApplication2 = WearUtils.x;
            MyApplication.H().runOnUiThread(new Runnable() { // from class: com.wear.bean.Pattern.1
                @Override // java.lang.Runnable
                public void run() {
                    MyApplication myApplication3 = WearUtils.x;
                    sg3.i(MyApplication.H(), R.string.pattern_format_error);
                }
            });
        }
    }

    public boolean setDataNoCheckFormat(String str) {
        this.isShowFormatToast = false;
        setData(str);
        this.isShowFormatToast = true;
        return isCheckMd5();
    }

    public void setDataString(String str) {
        if (str.indexOf("#") > 0) {
            String strReplace = str.replace("#\n;", "#").replace("#\n", "#");
            String strSubstring = strReplace.substring(strReplace.indexOf("#") + 1, strReplace.length());
            this.data = strSubstring;
            this.data = strSubstring.replace(System.getProperty("line.separator"), "");
        }
    }

    public void setDownloadStatus(int i) {
        this.downloadStatus = i;
    }

    public void setEmail(String str) {
        String strP = nd3.p(str);
        this.email = strP;
        setEmails(strP, false);
    }

    public void setEmails(String str, boolean z) {
        if (z) {
            this.emails = nd3.p(str);
        } else {
            this.emails = str;
        }
    }

    public void setExist(boolean z) {
        this.isExist = z;
    }

    public void setFavorite(boolean z) {
        this.favorite = z;
    }

    public void setFavoritesCount(int i) {
        this.favoritesCount = i;
    }

    public void setHidePatternId(String str) {
        this.hidePatternId = str;
    }

    public void setIsNeedReport(String str) {
        this.isNeedReport = str;
    }

    public void setIsShowReview(String str) {
        this.isShowReview = str;
    }

    public void setLastUpdTime(long j) {
        this.lastUpdTime = j;
    }

    public void setLikeCount(int i) {
        this.likeCount = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOnline(Boolean bool) {
        this.isOnline = bool;
    }

    public void setPath(String str) {
        this.path = str;
    }

    public void setPatternStoreTag(String str) {
        this.patternStoreTag = str;
    }

    public void setShared(boolean z) {
        this.shared = z;
    }

    public void setSortId(int i) {
        this.sortId = i;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setSyncFialMsg(String str) {
        this.syncFialMsg = str;
    }

    public void setSyncStatus(int i) {
        this.syncStatus = i;
    }

    public void setTagAvatarUrl(String str) {
        this.tagAvatarUrl = str;
    }

    public void setTagName(String str) {
        this.tagName = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTimer(String str) {
        this.timer = str;
    }

    public void setToyFeature(String str) {
        this.toyFeature = str;
    }

    public void setToyFunc(String str) {
        if (WearUtils.e1(str)) {
            str = PSOProgramService.VS_Key;
        }
        this.toyFunc = str;
    }

    public void setToyName(String str) {
        this.toyName = str;
    }

    public void setToySymbol(String str) {
        this.toySymbol = str;
    }

    public void setToyTag(String str) {
        this.toyTag = str;
    }

    public void setToyVersion(String str) {
        this.toyVersion = str;
    }

    @Override // com.wear.bean.handlerbean.IHandlerPattern
    public boolean syncSuc() {
        return this.syncStatus == 0;
    }

    @Override // com.wear.bean.handlerbean.IHandlerPattern
    public boolean useless() {
        return !getFile().exists() && TextUtils.isEmpty(getPath());
    }

    public Pattern(String str) {
        setId(str);
    }
}

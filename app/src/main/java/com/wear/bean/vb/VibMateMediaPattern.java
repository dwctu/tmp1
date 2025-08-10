package com.wear.bean.vb;

import androidx.annotation.Nullable;
import com.wear.bean.PatternHead;
import com.wear.util.WearUtils;
import java.io.File;

/* loaded from: classes3.dex */
public class VibMateMediaPattern {
    private String accountId;
    private String coverPicture;

    @Nullable
    private String data;
    private boolean disLike;
    private int dislikeCount;
    private String duration;
    private String email;
    private PatternHead head;
    private int id;
    private int isAnonymous;
    private boolean isDelete;
    private boolean isLike;
    private int likeCount;
    private String manifestUrl;
    private String patternUrl;
    private String patternUrls;
    private String remark;
    private int status;
    private String title;
    private String uploadDate;
    private String uploader;
    private String userName;
    private int videoId;
    private String viewCount;
    private String webUrl;
    private boolean checkMd5 = true;
    private boolean isPlaying = false;
    private boolean isLoading = false;
    private boolean isDownload = false;
    private boolean canPlayPattern = true;
    private String countDownString = "";
    private String viewKey = "";
    private String[] arr = null;

    public String getAccountId() {
        return this.accountId;
    }

    public String[] getArr() {
        if (this.arr == null && !WearUtils.e1(this.data)) {
            if (getHead() == null) {
                this.arr = this.data.split(",");
            } else {
                this.arr = this.data.split(";");
            }
        }
        return this.arr;
    }

    public boolean getCanPlayPattern() {
        return this.canPlayPattern;
    }

    public boolean getCheckMd5() {
        return this.checkMd5;
    }

    public String getCountDownString() {
        return this.countDownString;
    }

    public String getCoverPicture() {
        return this.coverPicture;
    }

    @Nullable
    public String getData() {
        return this.data;
    }

    public boolean getDisLike() {
        return this.disLike;
    }

    public int getDislikeCount() {
        return this.dislikeCount;
    }

    public String getDuration() {
        return this.duration;
    }

    public String getEmail() {
        return this.email;
    }

    public File getFile() {
        return new File(WearUtils.T("mediaPattern"), String.valueOf(getId()));
    }

    public PatternHead getHead() {
        return this.head;
    }

    public int getId() {
        return this.id;
    }

    public int getIsAnonymous() {
        return this.isAnonymous;
    }

    public boolean getIsDelete() {
        return this.isDelete;
    }

    public boolean getIsDownload() {
        return this.isDownload;
    }

    public boolean getIsLike() {
        return this.isLike;
    }

    public boolean getIsLoading() {
        return this.isLoading;
    }

    public boolean getIsPlaying() {
        return this.isPlaying;
    }

    public int getLikeCount() {
        return this.likeCount;
    }

    public String getManifestUrl() {
        return this.manifestUrl;
    }

    public String getPatternUrl() {
        return this.patternUrl;
    }

    public String getPatternUrls() {
        return this.patternUrls;
    }

    public String getRemark() {
        return this.remark;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public String getUploadDate() {
        return this.uploadDate;
    }

    public String getUploader() {
        return this.uploader;
    }

    public String getUserName() {
        return this.userName;
    }

    public int getVideoId() {
        return this.videoId;
    }

    public String getViewCount() {
        return this.viewCount;
    }

    public String getViewKey() {
        return this.viewKey;
    }

    public String getWebUrl() {
        return this.webUrl;
    }

    public boolean isCanPlayPattern() {
        return this.canPlayPattern;
    }

    public boolean isCheckMd5() {
        return this.checkMd5;
    }

    public boolean isDelete() {
        return this.isDelete;
    }

    public boolean isDisLike() {
        return this.disLike;
    }

    public boolean isDownload() {
        return this.isDownload;
    }

    public boolean isLike() {
        return this.isLike;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }

    public void setAccountId(String str) {
        this.accountId = str;
    }

    public void setCanPlayPattern(boolean z) {
        this.canPlayPattern = z;
    }

    public void setCheckMd5(boolean z) {
        this.checkMd5 = z;
    }

    public void setCountDownString(String str) {
        this.countDownString = str;
    }

    public void setCoverPicture(String str) {
        this.coverPicture = str;
    }

    public void setData(String str) throws NumberFormatException {
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
        if (this.head.getFunction() == null || (this.head.getFunction().indexOf(",") == -1 && this.head.getFunction().length() > 1)) {
            this.data = "";
        }
        if (!WearUtils.e1(this.head.getVersion()) || WearUtils.q1(this.head.getVersion())) {
            int i = Integer.parseInt(this.head.getVersion());
            if (WearUtils.e1(this.head.getMd())) {
                if (i == 1) {
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
        isCheckMd5();
    }

    public boolean setDataNoCheckFormat(String str) {
        setData(str);
        return isCheckMd5();
    }

    public void setDelete(boolean z) {
        this.isDelete = z;
    }

    public void setDisLike(boolean z) {
        this.disLike = z;
    }

    public void setDislikeCount(int i) {
        this.dislikeCount = i;
    }

    public void setDownload(boolean z) {
        this.isDownload = z;
    }

    public void setDuration(String str) {
        this.duration = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    public void setHead(PatternHead patternHead) {
        this.head = patternHead;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setIsAnonymous(int i) {
        this.isAnonymous = i;
    }

    public void setIsDelete(boolean z) {
        this.isDelete = z;
    }

    public void setIsDownload(boolean z) {
        this.isDownload = z;
    }

    public void setIsLike(boolean z) {
        this.isLike = z;
    }

    public void setIsLoading(boolean z) {
        this.isLoading = z;
    }

    public void setIsPlaying(boolean z) {
        this.isPlaying = z;
    }

    public void setLike(boolean z) {
        this.isLike = z;
    }

    public void setLikeCount(int i) {
        this.likeCount = i;
    }

    public void setLoading(boolean z) {
        this.isLoading = z;
    }

    public void setManifestUrl(String str) {
        this.manifestUrl = str;
    }

    public void setPatternUrl(String str) {
        this.patternUrl = str;
    }

    public void setPatternUrls(String str) {
        this.patternUrls = str;
    }

    public void setPlaying(boolean z) {
        this.isPlaying = z;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUploadDate(String str) {
        this.uploadDate = str;
    }

    public void setUploader(String str) {
        this.uploader = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setVideoId(int i) {
        this.videoId = i;
    }

    public void setViewCount(String str) {
        this.viewCount = str;
    }

    public void setViewKey(String str) {
        this.viewKey = str;
    }

    public void setWebUrl(String str) {
        this.webUrl = str;
    }
}

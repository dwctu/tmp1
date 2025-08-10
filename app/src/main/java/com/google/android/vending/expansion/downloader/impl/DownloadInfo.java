package com.google.android.vending.expansion.downloader.impl;

import com.google.android.vending.expansion.downloader.Helpers;

/* loaded from: classes2.dex */
public class DownloadInfo {
    public int mControl;
    public long mCurrentBytes;
    public String mETag;
    public final String mFileName;
    public int mFuzz = Helpers.sRandom.nextInt(1001);
    public final int mIndex;
    public boolean mInitialized;
    public long mLastMod;
    public int mNumFailed;
    public int mRedirectCount;
    public int mRetryAfter;
    public int mStatus;
    public long mTotalBytes;
    public String mUri;

    public DownloadInfo(int i, String str, String str2) {
        this.mFileName = str;
        this.mIndex = i;
    }

    public void logVerboseInfo() {
        String str = "FILENAME: " + this.mFileName;
        String str2 = "URI     : " + this.mUri;
        String str3 = "FILENAME: " + this.mFileName;
        String str4 = "CONTROL : " + this.mControl;
        String str5 = "STATUS  : " + this.mStatus;
        String str6 = "FAILED_C: " + this.mNumFailed;
        String str7 = "RETRY_AF: " + this.mRetryAfter;
        String str8 = "REDIRECT: " + this.mRedirectCount;
        String str9 = "LAST_MOD: " + this.mLastMod;
        String str10 = "TOTAL   : " + this.mTotalBytes;
        String str11 = "CURRENT : " + this.mCurrentBytes;
        String str12 = "ETAG    : " + this.mETag;
    }

    public void resetDownload() {
        this.mCurrentBytes = 0L;
        this.mETag = "";
        this.mLastMod = 0L;
        this.mStatus = 0;
        this.mControl = 0;
        this.mNumFailed = 0;
        this.mRetryAfter = 0;
        this.mRedirectCount = 0;
    }

    public long restartTime(long j) {
        if (this.mNumFailed == 0) {
            return j;
        }
        int i = this.mRetryAfter;
        return i > 0 ? this.mLastMod + i : this.mLastMod + ((this.mFuzz + 1000) * 30 * (1 << (r0 - 1)));
    }
}

package com.broadcom.bt.map;

import android.os.Parcel;
import android.os.Parcelable;
import com.broadcom.bt.util.io.IOUtils;

/* loaded from: classes.dex */
public class FolderInfo implements Parcelable {
    public static final Parcelable.Creator<FolderInfo> CREATOR = new Parcelable.Creator<FolderInfo>() { // from class: com.broadcom.bt.map.FolderInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FolderInfo createFromParcel(Parcel parcel) {
            return new FolderInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FolderInfo[] newArray(int i) {
            return new FolderInfo[i];
        }
    };
    public static final long MODE_READ_ONLY = 1;
    public static final String VIRTUAL_FOLDER_DELETED = "deleted";
    public static final String VIRTUAL_FOLDER_DRAFT = "draft";
    public static final String VIRTUAL_FOLDER_INBOX = "inbox";
    public static final String VIRTUAL_FOLDER_OUTBOX = "outbox";
    public static final String VIRTUAL_FOLDER_SENT = "sent";
    public String mCreatedDateTimeMS;
    public String mFolderId;
    public String mFolderName;
    public long mFolderSizeBytes;
    public long mMode;
    public String mVirtualName;

    public FolderInfo(Parcel parcel) {
        this.mVirtualName = "";
        this.mFolderName = "";
        this.mFolderSizeBytes = 0L;
        this.mCreatedDateTimeMS = "";
        this.mMode = 0L;
        this.mFolderName = parcel.readString();
        this.mFolderSizeBytes = parcel.readLong();
        this.mCreatedDateTimeMS = parcel.readString();
        this.mMode = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void dumpState(StringBuilder sb, String str) {
        sb.append(str);
        sb.append("Name    :");
        String str2 = this.mFolderName;
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(str);
        sb.append("Size    : ");
        sb.append(this.mFolderSizeBytes);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(str);
        sb.append("Created : ");
        sb.append(this.mCreatedDateTimeMS);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(str);
        sb.append("Mode : ");
        sb.append(this.mMode);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
    }

    public boolean isReadOnly() {
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mFolderName);
        parcel.writeLong(this.mFolderSizeBytes);
        parcel.writeString(this.mCreatedDateTimeMS);
        parcel.writeLong(this.mMode);
    }

    public FolderInfo(String str, String str2, String str3, long j, String str4, long j2) {
        this.mVirtualName = "";
        this.mFolderName = "";
        this.mFolderSizeBytes = 0L;
        this.mCreatedDateTimeMS = "";
        this.mMode = 0L;
        this.mFolderId = str;
        this.mVirtualName = str3;
        this.mFolderName = str3;
        this.mFolderSizeBytes = j;
        this.mCreatedDateTimeMS = str4;
        this.mMode = j2;
    }

    public FolderInfo() {
        this.mVirtualName = "";
        this.mFolderName = "";
        this.mFolderSizeBytes = 0L;
        this.mCreatedDateTimeMS = "";
        this.mMode = 0L;
    }
}

package com.broadcom.bt.map;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class MessageListFilter implements Parcelable {
    public static final Parcelable.Creator<MessageListFilter> CREATOR = new Parcelable.Creator<MessageListFilter>() { // from class: com.broadcom.bt.map.MessageListFilter.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageListFilter createFromParcel(Parcel parcel) {
            return new MessageListFilter(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageListFilter[] newArray(int i) {
            return new MessageListFilter[i];
        }
    };
    public static final byte MAP_FILTER_MSGTYPE_EMAIL = 4;
    public static final byte MAP_FILTER_MSGTYPE_MMS = 8;
    public static final byte MAP_FILTER_MSGTYPE_SMS_CDMA = 2;
    public static final byte MAP_FILTER_MSGTYPE_SMS_GSM = 1;
    public static final int MAX_MESSAGE_LIST_SIZE = 1024;
    public static final int NOT_SET = -1;
    private static final String TAG = "MessageListFilter";
    public int mListStartOffset;
    public int mMaxListCount;
    public byte mMsgMask;
    public String mOriginator;
    public String mPeriodBegin;
    public String mPeriodEnd;
    public byte mPriorityStatus;
    public byte mReadStatus;
    public String mRecipient;
    public byte mSubjectLength;

    public void debugDump() {
        String str = "mMsgMask:" + ((int) this.mMsgMask);
        String str2 = "mMaxListCount:" + this.mMaxListCount;
        String str3 = "mListStartOffset:" + this.mListStartOffset;
        String str4 = "mSubjectLength:" + ((int) this.mSubjectLength);
        String str5 = "mPeriodBegin:" + this.mPeriodBegin;
        String str6 = "mPeriodEnd:" + this.mPeriodEnd;
        String str7 = "mReadStatus:" + ((int) this.mReadStatus);
        String str8 = "mRecipient:" + this.mRecipient;
        String str9 = "mOriginator:" + this.mOriginator;
        String str10 = "mPriorityStatus:" + ((int) this.mPriorityStatus);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean filterIsPriority() {
        return this.mPriorityStatus == 1;
    }

    public boolean filterRead() {
        return this.mReadStatus == 2;
    }

    public boolean listStartOffsetSet() {
        return this.mListStartOffset > -1;
    }

    public boolean maxListCountSet() {
        return this.mMaxListCount > -1;
    }

    public boolean originatorFilterSet() {
        String str = this.mOriginator;
        return (str == null || str.length() <= 0 || "*".equals(this.mOriginator)) ? false : true;
    }

    public boolean periodBeginFilterSet() {
        String str = this.mPeriodBegin;
        return str != null && str.length() >= 8;
    }

    public boolean periodEndFilterSet() {
        String str = this.mPeriodEnd;
        return str != null && str.length() >= 8;
    }

    public boolean priorityStatusFilterSet() {
        byte b = this.mPriorityStatus;
        return b == 1 || b == 2;
    }

    public boolean readStatusFilterSet() {
        byte b = this.mReadStatus;
        return b == 1 || b == 2;
    }

    public boolean recipientFilterSet() {
        String str = this.mRecipient;
        return (str == null || str.length() <= 0 || "*".equals(this.mRecipient)) ? false : true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.mMsgMask);
        parcel.writeInt(this.mMaxListCount);
        parcel.writeInt(this.mListStartOffset);
        parcel.writeByte(this.mSubjectLength);
        parcel.writeString(this.mPeriodBegin);
        parcel.writeString(this.mPeriodEnd);
        parcel.writeByte(this.mReadStatus);
        parcel.writeString(this.mRecipient);
        parcel.writeString(this.mOriginator);
        parcel.writeByte(this.mPriorityStatus);
    }

    public MessageListFilter() {
        this.mMaxListCount = -1;
        this.mListStartOffset = -1;
        this.mReadStatus = (byte) 0;
        this.mPriorityStatus = (byte) 0;
    }

    private MessageListFilter(Parcel parcel) {
        this.mMaxListCount = -1;
        this.mListStartOffset = -1;
        this.mReadStatus = (byte) 0;
        this.mPriorityStatus = (byte) 0;
        this.mMsgMask = parcel.readByte();
        this.mMaxListCount = parcel.readInt();
        this.mListStartOffset = parcel.readInt();
        this.mSubjectLength = parcel.readByte();
        this.mPeriodBegin = parcel.readString();
        this.mPeriodEnd = parcel.readString();
        this.mReadStatus = parcel.readByte();
        this.mRecipient = parcel.readString();
        this.mOriginator = parcel.readString();
        this.mPriorityStatus = parcel.readByte();
    }
}

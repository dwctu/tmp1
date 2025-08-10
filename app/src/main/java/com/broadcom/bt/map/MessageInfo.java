package com.broadcom.bt.map;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.broadcom.bt.util.io.IOUtils;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MessageInfo implements Parcelable {
    public static final Parcelable.Creator<MessageInfo> CREATOR = new Parcelable.Creator<MessageInfo>() { // from class: com.broadcom.bt.map.MessageInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageInfo createFromParcel(Parcel parcel) {
            return new MessageInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageInfo[] newArray(int i) {
            return new MessageInfo[i];
        }
    };
    public static final int IOP_MAX_SUBJECT_LENGTH = 20;
    private static final String IOP_SUBJECT_TRAILER = " ...";
    private static final int IOP_SUBJECT_TRAILER_LENGTH = 4;
    public static final int MAP_MSG_MASK_ATTACHMENT_SIZE = 1024;
    public static final int MAP_MSG_MASK_DATETIME = 2;
    public static final int MAP_MSG_MASK_PRIORITY = 2048;
    public static final int MAP_MSG_MASK_PROTECTED = 16384;
    public static final int MAP_MSG_MASK_READ = 4096;
    public static final int MAP_MSG_MASK_RECEPTION_STATUS = 256;
    public static final int MAP_MSG_MASK_RECIPIENT_ADDRESSING = 32;
    public static final int MAP_MSG_MASK_RECIPIENT_NAME = 16;
    public static final int MAP_MSG_MASK_SENDER_ADDRESSING = 8;
    public static final int MAP_MSG_MASK_SENDER_NAME = 4;
    public static final int MAP_MSG_MASK_SENT = 8192;
    public static final int MAP_MSG_MASK_SIZE = 128;
    public static final int MAP_MSG_MASK_SUBJECT = 1;
    public static final int MAP_MSG_MASK_TEXT = 512;
    public static final int MAP_MSG_MASK_TYPE = 64;
    public static final int MAP_MSG_REPLYTO_ADDRESSING = 32768;
    public static final byte MSG_RECEPTION_STATUS_COMPLETE = 0;
    public static final byte MSG_RECEPTION_STATUS_FRACTION = 1;
    public static final byte MSG_RECEPTION_STATUS_NOTIFICATION = 2;
    public static final byte MSG_TYPE_EMAIL = 1;
    public static final byte MSG_TYPE_MMS = 8;
    public static final byte MSG_TYPE_SMS_CDMA = 4;
    public static final byte MSG_TYPE_SMS_GSM = 2;
    private static final String TAG = "BtMap.MessageInfo";
    public int mAttachmentSize;
    public String mDateTime;
    public boolean mIsHighPriority;
    public boolean mIsOutbound;
    public boolean mIsProtected;
    public boolean mIsRead;
    public boolean mIsSent;
    public boolean mIsText;
    public String mMsgHandle;
    public int mMsgSize;
    public byte mMsgType;
    public long mParameterMask;
    public byte mReceptionStatus;
    public ArrayList<PersonInfo> mRecipient;
    public ArrayList<String> mRecipientAddress;
    public String mReplyToAddress;
    public PersonInfo mSender;
    public String mSenderAddress;
    public String mSubject;

    public MessageInfo(Parcel parcel) {
        this.mParameterMask = 0L;
        this.mMsgSize = 0;
        this.mAttachmentSize = 0;
        this.mIsText = false;
        this.mIsHighPriority = false;
        this.mIsRead = false;
        this.mIsSent = false;
        this.mIsProtected = false;
        this.mMsgHandle = "";
        this.mSubject = "";
        this.mDateTime = "";
        this.mReplyToAddress = "";
        this.mRecipient = new ArrayList<>();
        this.mRecipientAddress = new ArrayList<>();
        this.mParameterMask = parcel.readLong();
        this.mMsgSize = parcel.readInt();
        this.mAttachmentSize = parcel.readInt();
        if (parcel.readByte() != 0) {
            this.mIsText = true;
        } else {
            this.mIsText = false;
        }
        if (parcel.readByte() != 0) {
            this.mIsHighPriority = true;
        } else {
            this.mIsHighPriority = false;
        }
        if (parcel.readByte() != 0) {
            this.mIsRead = true;
        } else {
            this.mIsRead = false;
        }
        if (parcel.readByte() != 0) {
            this.mIsSent = true;
        } else {
            this.mIsSent = false;
        }
        if (parcel.readByte() != 0) {
            this.mIsProtected = true;
        } else {
            this.mIsProtected = false;
        }
        this.mMsgHandle = parcel.readString();
        this.mMsgType = parcel.readByte();
        this.mReceptionStatus = parcel.readByte();
        this.mSubject = parcel.readString();
        this.mDateTime = parcel.readString();
        if (parcel.readInt() > 0) {
            this.mSender = new PersonInfo(parcel);
        }
        if (parcel.readInt() > 0) {
            this.mSenderAddress = parcel.readString();
        }
        int i = parcel.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.mRecipient.add(new PersonInfo(parcel));
        }
        int i3 = parcel.readInt();
        for (int i4 = 0; i4 < i3; i4++) {
            this.mRecipientAddress.add(parcel.readString());
        }
        if (parcel.readInt() > 0) {
            this.mReplyToAddress = parcel.readString();
        }
    }

    public void addRecipient(String str, PersonInfo personInfo) {
        if (str == null) {
            return;
        }
        this.mRecipientAddress.add(str);
        this.mRecipient.add(personInfo);
        StringBuilder sb = new StringBuilder();
        sb.append("addRecipient: address=");
        sb.append(str);
        sb.append(", pInfo=");
        sb.append(personInfo == null ? "null" : personInfo.getDisplayName());
        sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void dumpState(StringBuilder sb, String str) {
        sb.append(str);
        sb.append("messageHandle  = ");
        sb.append(this.mMsgHandle);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(str);
        sb.append("messageType = ");
        sb.append((int) this.mMsgType);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(str);
        sb.append("messageSize = ");
        sb.append(this.mMsgSize);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(str);
        sb.append("attachmentSize = ");
        sb.append(this.mAttachmentSize);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(str);
        sb.append("parameterMask = ");
        sb.append(this.mParameterMask);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(str);
        sb.append("isText = ");
        sb.append(this.mIsText);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(str);
        sb.append("isHighPriority = ");
        sb.append(this.mIsHighPriority);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(str);
        sb.append("isRead = ");
        sb.append(this.mIsRead);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(str);
        sb.append("isSent = ");
        sb.append(this.mIsSent);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(str);
        sb.append("isProtected = ");
        sb.append(this.mIsProtected);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(str);
        sb.append("receptionStatus = ");
        sb.append((int) this.mReceptionStatus);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(str);
        sb.append("subject = ");
        String str2 = this.mSubject;
        if (str2 == null) {
            str2 = "";
        }
        sb.append(str2);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(str);
        sb.append("date_time = ");
        sb.append(this.mDateTime);
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(str);
        sb.append("sender=");
        PersonInfo personInfo = this.mSender;
        if (personInfo != null) {
            personInfo.dumpState(sb, str);
        }
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(str);
        sb.append("senderAddress = ");
        sb.append(getSenderAddress(false));
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(str);
        ArrayList<PersonInfo> arrayList = this.mRecipient;
        int size = arrayList == null ? 0 : arrayList.size();
        sb.append("recipient mRecipient =");
        sb.append(size);
        for (int i = 0; i < size; i++) {
            PersonInfo personInfo2 = this.mRecipient.get(i);
            if (personInfo2 != null) {
                personInfo2.dumpState(sb, str);
            }
        }
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(str);
        sb.append("recipientAddress = ");
        sb.append(getRecipientAddress(false));
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
        sb.append(str);
        sb.append("replyToAddress = ");
        sb.append(getReplyToAddress(false));
        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
    }

    public String getRecipientAddress(boolean z) {
        ArrayList<String> arrayList = this.mRecipientAddress;
        if (arrayList == null || arrayList.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.mRecipientAddress.size(); i++) {
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(this.mRecipientAddress.get(i));
        }
        return z ? sb.toString() : TextUtils.htmlEncode(sb.toString());
    }

    public String getRecipientDisplayName(boolean z) {
        ArrayList<PersonInfo> arrayList = this.mRecipient;
        if (arrayList == null || arrayList.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.mRecipient.size(); i++) {
            PersonInfo personInfo = this.mRecipient.get(i);
            if (personInfo != null) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(personInfo.getDisplayName());
            }
        }
        return z ? sb.toString() : TextUtils.htmlEncode(sb.toString());
    }

    public String getReplyToAddress(boolean z) {
        String str = this.mReplyToAddress;
        return (str == null || str.length() == 0) ? "" : z ? this.mReplyToAddress : TextUtils.htmlEncode(this.mReplyToAddress);
    }

    public String getSenderAddress(boolean z) {
        String str = this.mSenderAddress;
        return str == null ? "" : z ? str : TextUtils.htmlEncode(str);
    }

    public String getSenderDisplayName(boolean z) {
        PersonInfo personInfo = this.mSender;
        return personInfo == null ? "" : z ? personInfo.getDisplayName() : TextUtils.htmlEncode(personInfo.getDisplayName());
    }

    public String getSubject(boolean z) {
        return z ? this.mSubject : TextUtils.htmlEncode(this.mSubject);
    }

    public void setReplyTo(String str, PersonInfo personInfo) {
        String str2;
        if (str == null) {
            return;
        }
        this.mReplyToAddress = str;
        StringBuilder sb = new StringBuilder();
        sb.append("setReplyToNameInfo:address= ");
        sb.append(str);
        sb.append(", pInfo=");
        if (personInfo == null) {
            str2 = "null";
        } else {
            str2 = personInfo.mFamilyName + ", " + personInfo.mGivenName + ", " + personInfo.getDisplayName();
        }
        sb.append(str2);
        sb.toString();
    }

    public void setSender(String str, PersonInfo personInfo) {
        String str2;
        if (str == null) {
            return;
        }
        this.mSenderAddress = str;
        this.mSender = personInfo;
        StringBuilder sb = new StringBuilder();
        sb.append("setSenderNameInfo: address=");
        sb.append(str);
        if (personInfo == null) {
            str2 = "null";
        } else {
            str2 = personInfo.mFamilyName + " " + personInfo.mGivenName + " " + personInfo.getDisplayName();
        }
        sb.append(str2);
        sb.toString();
    }

    public void setSubject(String str, int i) {
        if (str == null) {
            this.mSubject = null;
            return;
        }
        if (i <= 0 || i > 20) {
            i = 20;
        }
        if (str.length() <= i) {
            this.mSubject = str;
            return;
        }
        int i2 = IOP_SUBJECT_TRAILER_LENGTH;
        if (i <= i2) {
            this.mSubject = str.substring(0, i);
            return;
        }
        this.mSubject = str.substring(0, i - i2) + IOP_SUBJECT_TRAILER;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        toString(sb);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.mParameterMask);
        parcel.writeInt(this.mMsgSize);
        parcel.writeInt(this.mAttachmentSize);
        if (this.mIsText) {
            parcel.writeByte((byte) 1);
        } else {
            parcel.writeByte((byte) 0);
        }
        if (this.mIsHighPriority) {
            parcel.writeByte((byte) 1);
        } else {
            parcel.writeByte((byte) 0);
        }
        if (this.mIsRead) {
            parcel.writeByte((byte) 1);
        } else {
            parcel.writeByte((byte) 0);
        }
        if (this.mIsSent) {
            parcel.writeByte((byte) 1);
        } else {
            parcel.writeByte((byte) 0);
        }
        if (this.mIsProtected) {
            parcel.writeByte((byte) 1);
        } else {
            parcel.writeByte((byte) 0);
        }
        parcel.writeString(this.mMsgHandle);
        parcel.writeByte(this.mMsgType);
        parcel.writeByte(this.mReceptionStatus);
        parcel.writeString(this.mSubject);
        parcel.writeString(this.mDateTime);
        int i2 = this.mSender == null ? 0 : 1;
        parcel.writeInt(i2);
        if (i2 == 1) {
            this.mSender.writeToParcel(parcel, i);
        }
        int i3 = this.mSenderAddress == null ? 0 : 1;
        parcel.writeInt(i3);
        if (i3 == 1) {
            parcel.writeString(this.mSenderAddress);
        }
        ArrayList<PersonInfo> arrayList = this.mRecipient;
        int size = arrayList == null ? 0 : arrayList.size();
        parcel.writeInt(size);
        for (int i4 = 0; i4 < size; i4++) {
            PersonInfo personInfo = this.mRecipient.get(i4);
            if (personInfo != null) {
                personInfo.writeToParcel(parcel, i);
            }
        }
        ArrayList<String> arrayList2 = this.mRecipientAddress;
        int size2 = arrayList2 == null ? 0 : arrayList2.size();
        parcel.writeInt(size2);
        for (int i5 = 0; i5 < size2; i5++) {
            parcel.writeString(this.mRecipientAddress.get(i5));
        }
        int i6 = this.mReplyToAddress != null ? 1 : 0;
        parcel.writeInt(i6);
        if (i6 > 0) {
            parcel.writeString(this.mReplyToAddress);
        }
    }

    public void toString(StringBuilder sb) {
        dumpState(sb, "");
    }

    public MessageInfo() {
        this.mParameterMask = 0L;
        this.mMsgSize = 0;
        this.mAttachmentSize = 0;
        this.mIsText = false;
        this.mIsHighPriority = false;
        this.mIsRead = false;
        this.mIsSent = false;
        this.mIsProtected = false;
        this.mMsgHandle = "";
        this.mSubject = "";
        this.mDateTime = "";
        this.mReplyToAddress = "";
        this.mRecipient = new ArrayList<>();
        this.mRecipientAddress = new ArrayList<>();
    }
}

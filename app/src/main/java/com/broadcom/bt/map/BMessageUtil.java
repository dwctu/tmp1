package com.broadcom.bt.map;

import com.broadcom.bt.util.bmsg.BMessage;
import com.broadcom.bt.util.bmsg.BMessageBody;
import com.broadcom.bt.util.bmsg.BMessageBodyContent;
import com.broadcom.bt.util.bmsg.BMessageEnvelope;
import com.broadcom.bt.util.bmsg.BMessageVCard;
import com.broadcom.bt.util.bmsg.BMessageVCardProperty;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BMessageUtil {
    private static final String TAG = "BtMap.BMessageUtil";

    public static BMessageBody findMessageBody(BMessageEnvelope bMessageEnvelope) {
        int i = 1;
        while (bMessageEnvelope != null) {
            String str = "Finding message body in envelope level #" + i;
            BMessageBody body = bMessageEnvelope.getBody();
            if (body != null) {
                return body;
            }
            bMessageEnvelope = bMessageEnvelope.getChildEnvelope();
            i++;
        }
        return null;
    }

    public static BMessageVCardProperty findRecipientProperty(BMessageEnvelope bMessageEnvelope, byte b) {
        BMessageVCardProperty property;
        int i = 1;
        while (bMessageEnvelope != null) {
            String str = "Finding recipient in envelope level #" + i;
            BMessageVCard recipient = bMessageEnvelope.getRecipient();
            if (recipient != null && (property = recipient.getProperty(b)) != null) {
                return property;
            }
            bMessageEnvelope = bMessageEnvelope.getChildEnvelope();
            i++;
        }
        return null;
    }

    public static void setBMessageHeaderInfo(BMessage bMessage, byte b, String str, MessageInfo messageInfo) {
        if (bMessage != null) {
            if (b == 0 || b == 1) {
                bMessage.setReadStatus(messageInfo.mIsRead);
                bMessage.setFolder(str);
                setBMessageType(bMessage, messageInfo);
                BMessageVCard bMessageVCardAddOriginator = bMessage.addOriginator();
                PersonInfo personInfo = messageInfo.mSender;
                String str2 = messageInfo.mSenderAddress;
                bMessageVCardAddOriginator.setVersion(b);
                if (personInfo == null) {
                    bMessageVCardAddOriginator.addProperty((byte) 0, "", null);
                } else {
                    bMessageVCardAddOriginator.addProperty((byte) 0, personInfo.toVcardField_N(), null);
                    bMessageVCardAddOriginator.addProperty((byte) 1, personInfo.toVcardField_FN(), null);
                }
                bMessageVCardAddOriginator.addProperty((byte) 2, str2, null);
                BMessageEnvelope bMessageEnvelopeAddEnvelope = bMessage.addEnvelope();
                ArrayList<String> arrayList = messageInfo.mRecipientAddress;
                int size = arrayList == null ? 0 : arrayList.size();
                ArrayList<PersonInfo> arrayList2 = messageInfo.mRecipient;
                int size2 = arrayList2 == null ? 0 : arrayList2.size();
                int i = 0;
                while (i < size) {
                    String str3 = messageInfo.mRecipientAddress.get(i);
                    PersonInfo personInfo2 = i < size2 ? messageInfo.mRecipient.get(i) : null;
                    BMessageVCard bMessageVCardAddRecipient = bMessageEnvelopeAddEnvelope.addRecipient();
                    bMessageVCardAddRecipient.setVersion(b);
                    if (personInfo2 == null) {
                        bMessageVCardAddRecipient.addProperty((byte) 0, "", null);
                    } else {
                        bMessageVCardAddRecipient.addProperty((byte) 0, personInfo2.toVcardField_N(), null);
                        bMessageVCardAddRecipient.addProperty((byte) 1, personInfo2.toVcardField_FN(), null);
                    }
                    bMessageVCardAddRecipient.addProperty((byte) 2, str3, null);
                    i++;
                }
            }
        }
    }

    public static void setBMessageType(BMessage bMessage, MessageInfo messageInfo) {
        if (messageInfo != null) {
            byte b = messageInfo.mMsgType;
            if ((b & 1) == 1) {
                bMessage.setMessageType((byte) 1);
                return;
            }
            if ((b & 4) == 4) {
                bMessage.setMessageType((byte) 4);
            } else if ((b & 2) == 2) {
                bMessage.setMessageType((byte) 2);
            } else if ((b & 8) == 8) {
                bMessage.setMessageType((byte) 8);
            }
        }
    }

    public static BMessage toBMessage(MessageInfo messageInfo, String str, byte b, String str2) {
        BMessage bMessage;
        try {
            bMessage = new BMessage();
        } catch (Throwable unused) {
            bMessage = null;
        }
        try {
            setBMessageHeaderInfo(bMessage, (byte) 0, str, messageInfo);
            BMessageBody bMessageBodyAddBody = bMessage.getEnvelope().addBody();
            bMessageBodyAddBody.setCharSet((byte) 1);
            BMessageBodyContent bMessageBodyContentAddContent = bMessageBodyAddBody.addContent();
            if (b == 0 && messageInfo.mMsgType == 2) {
                ArrayList<String> arrayList = messageInfo.mRecipientAddress;
                String strEncodeSMSDeliverPDU = bMessage.encodeSMSDeliverPDU(str2, (arrayList == null || arrayList.size() < 1) ? "" : messageInfo.mRecipientAddress.get(0), messageInfo.mSenderAddress, messageInfo.mDateTime);
                if (strEncodeSMSDeliverPDU != null) {
                    String str3 = "Native charset requested - encoding succeeded - " + strEncodeSMSDeliverPDU;
                    bMessageBodyAddBody.setCharSet(b);
                    bMessageBodyAddBody.setEncoding((byte) 1);
                    str2 = strEncodeSMSDeliverPDU;
                }
            }
            bMessageBodyContentAddContent.addMessageContent(str2);
        } catch (Throwable unused2) {
            if (bMessage != null) {
                bMessage.finish();
                return null;
            }
            return bMessage;
        }
        return bMessage;
    }
}

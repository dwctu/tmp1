package com.wear.protocol;

import com.wear.util.WearUtils;

/* loaded from: classes3.dex */
public class EntityGiftCard extends DataEntityAbstract {
    private String amount;
    private String cardImage;
    private String cardLink;
    private String cardName;
    private Long expireTime;
    private String msgId;
    private String receiverNote;
    private String refundLink;
    private String senderNote;
    private String showExpireItem;
    private int status;

    public EntityGiftCard() {
        setMsgId(WearUtils.E());
    }

    public String getAmount() {
        return this.amount;
    }

    public String getCardImage() {
        return this.cardImage;
    }

    public String getCardLink() {
        return this.cardLink;
    }

    public String getCardName() {
        return this.cardName;
    }

    @Override // com.wear.protocol.DataEntityAbstract
    public MessageType getEntityType() {
        return MessageType.giftcard;
    }

    public Long getExpireTime() {
        return this.expireTime;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public String getReceiverNote() {
        return this.receiverNote;
    }

    public String getRefundLink() {
        return this.refundLink;
    }

    public String getSenderNote() {
        return this.senderNote;
    }

    public String getShowExpireItem() {
        return this.showExpireItem;
    }

    public int getStatus() {
        return this.status;
    }

    public void setAmount(String str) {
        this.amount = str;
    }

    public void setCardImage(String str) {
        this.cardImage = str;
    }

    public void setCardLink(String str) {
        this.cardLink = str;
    }

    public void setCardName(String str) {
        this.cardName = str;
    }

    public void setExpireTime(Long l) {
        this.expireTime = l;
    }

    public void setMsgId(String str) {
        this.msgId = str;
    }

    public void setReceiverNote(String str) {
        this.receiverNote = str;
    }

    public void setRefundLink(String str) {
        this.refundLink = str;
    }

    public void setSenderNote(String str) {
        this.senderNote = str;
    }

    public void setShowExpireItem(String str) {
        this.showExpireItem = str;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public EntityGiftCard(String str) {
        EntityGiftCard entityGiftCard = (EntityGiftCard) fromJsonToDecrypt(str, EntityGiftCard.class);
        this.amount = entityGiftCard.getAmount();
        this.cardLink = entityGiftCard.getCardLink();
        this.status = entityGiftCard.getStatus();
        this.msgId = entityGiftCard.getMsgId();
        this.cardName = entityGiftCard.getCardName();
        this.expireTime = entityGiftCard.getExpireTime();
        this.receiverNote = entityGiftCard.getReceiverNote();
        this.senderNote = entityGiftCard.getSenderNote();
        this.refundLink = entityGiftCard.getRefundLink();
        this.cardImage = entityGiftCard.getCardImage();
        this.showExpireItem = entityGiftCard.getShowExpireItem();
    }
}

package com.wear.bean;

import com.google.gson.annotations.SerializedName;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.protocol.EntityGiftCard;
import java.io.Serializable;

@DatabaseTable(tableName = "tb_gift_card")
/* loaded from: classes3.dex */
public class GiftCard extends BaseEntity implements Serializable {

    @SerializedName("amount")
    @DatabaseField
    private String amount;

    @SerializedName("cardImage")
    @DatabaseField
    private String cardImage;

    @SerializedName("cardLink")
    @DatabaseField
    private String cardLink;

    @SerializedName("cardName")
    @DatabaseField
    private String cardName;

    @SerializedName("expireTime")
    @DatabaseField
    private Long expireTime;

    @SerializedName("receiverNote")
    @DatabaseField
    private String receiverNote;

    @SerializedName("refundLink")
    @DatabaseField
    private String refundLink;

    @SerializedName("senderNote")
    @DatabaseField
    private String senderNote;

    @SerializedName("showExpireItem")
    @DatabaseField
    private String showExpireItem;

    @SerializedName("status")
    @DatabaseField
    private int status;

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

    public Long getExpireTime() {
        return this.expireTime;
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

    public EntityGiftCard toEntityGiftCard() {
        EntityGiftCard entityGiftCard = new EntityGiftCard();
        entityGiftCard.setCardImage(this.cardImage);
        entityGiftCard.setCardLink(this.cardLink);
        entityGiftCard.setCardName(this.cardName);
        entityGiftCard.setAmount(this.amount);
        entityGiftCard.setExpireTime(this.expireTime);
        entityGiftCard.setStatus(this.status);
        entityGiftCard.setRefundLink(this.refundLink);
        entityGiftCard.setReceiverNote(this.receiverNote);
        entityGiftCard.setSenderNote(this.senderNote);
        entityGiftCard.setShowExpireItem(this.showExpireItem);
        return entityGiftCard;
    }
}

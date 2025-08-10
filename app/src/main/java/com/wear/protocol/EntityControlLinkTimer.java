package com.wear.protocol;

/* loaded from: classes3.dex */
public class EntityControlLinkTimer extends DataEntityAbstract {
    private boolean isCancel;
    private boolean reachMaxAbnormalCount;
    private int remainTime;

    public EntityControlLinkTimer() {
    }

    @Override // com.wear.protocol.DataEntityAbstract
    public MessageType getEntityType() {
        return MessageType.controllinktimer;
    }

    public int getRemainTime() {
        return this.remainTime;
    }

    public boolean isCancel() {
        return this.isCancel;
    }

    public boolean isReachMaxAbnormalCount() {
        return this.reachMaxAbnormalCount;
    }

    public void setCancel(boolean z) {
        this.isCancel = z;
    }

    public void setReachMaxAbnormalCount(boolean z) {
        this.reachMaxAbnormalCount = z;
    }

    public void setRemainTime(int i) {
        this.remainTime = i;
    }

    public EntityControlLinkTimer(String str) {
        EntityControlLinkTimer entityControlLinkTimer = (EntityControlLinkTimer) fromJsonToDecrypt(str, EntityControlLinkTimer.class);
        this.remainTime = entityControlLinkTimer.remainTime;
        this.reachMaxAbnormalCount = entityControlLinkTimer.reachMaxAbnormalCount;
        this.isCancel = entityControlLinkTimer.isCancel;
    }
}

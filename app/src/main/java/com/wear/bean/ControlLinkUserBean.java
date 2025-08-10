package com.wear.bean;

import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.protocol.CommunMessage;
import java.util.List;
import org.jivesoftware.smack.packet.Presence;

/* loaded from: classes3.dex */
public class ControlLinkUserBean implements IPeopleInfo {
    private String avatarToC;
    private String tags;
    private String userEmail;
    private String userId;
    private String userName;

    public ControlLinkUserBean(String str, String str2, String str3) {
        this.userName = str;
        this.userId = str2;
        this.tags = str3;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public long getAddTime() {
        return 0L;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo, com.wear.bean.handlerbean.IContactInfo
    public String getAvatar() {
        return this.avatarToC;
    }

    public String getAvatarToC() {
        return this.avatarToC;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public CommunMessage getDraftMessage() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public Object getFlag() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getId() {
        return this.userId;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public CommunMessage getLastMessage() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public BaseEntity getLastOfficialNotice() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public List<Toy> getLinkedToys2() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getMoodMessage() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getRemark() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public long getSetTop() {
        return 0L;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo, com.wear.bean.handlerbean.IContactInfo
    /* renamed from: getShowName */
    public String getShowNickName() {
        return this.userName;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public Presence.Mode getStatusMode() {
        return null;
    }

    public String getTags() {
        return this.tags;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getTempName() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IItemType
    public int getTempViewType() {
        return 0;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getToyStatus() {
        return null;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public String getUserId() {
        return this.userId;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getUserJid() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getUserName() {
        return this.userName;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public boolean isDateIng() {
        return false;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public boolean isExit() {
        return false;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public boolean isFriend() {
        return false;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public boolean isGroup() {
        return false;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public boolean isOnline() {
        return false;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public boolean isShowInFriendsList() {
        return false;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String isSupportGroup() {
        return null;
    }

    public void setAvatarToC(String str) {
        this.avatarToC = str;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setDraftMessage(CommunMessage communMessage) {
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setFlag(Object obj) {
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setLastMessage(CommunMessage communMessage) {
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setLastOfficialNotice(BaseEntity baseEntity) {
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setRemark(String str) {
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setSetTop(long j) {
    }

    public void setTags(String str) {
        this.tags = str;
    }

    public void setUserEmail(String str) {
        this.userEmail = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public boolean showBykey(String str) {
        return false;
    }
}

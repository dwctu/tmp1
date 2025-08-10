package com.wear.bean.official;

import com.lovense.wear.R;
import com.wear.bean.BaseEntity;
import com.wear.bean.Toy;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.protocol.CommunMessage;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.packet.Presence;

/* compiled from: OfficialAcount.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\n\u0010 \u001a\u0004\u0018\u00010\u001cH\u0016J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$H\u0016J\b\u0010&\u001a\u00020\u0003H\u0016J\b\u0010'\u001a\u00020\u0003H\u0016J\b\u0010(\u001a\u00020\u0015H\u0016J\b\u0010)\u001a\u00020\u0003H\u0016J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u0003H\u0016J\b\u0010-\u001a\u00020\u0006H\u0016J\b\u0010.\u001a\u00020\u0003H\u0016J\b\u0010/\u001a\u00020\u0003H\u0016J\b\u00100\u001a\u00020\u0003H\u0016J\b\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u000202H\u0016J\b\u00104\u001a\u000202H\u0016J\b\u00105\u001a\u000202H\u0016J\b\u00106\u001a\u000202H\u0016J\b\u00107\u001a\u000202H\u0016J\b\u00108\u001a\u00020\u0003H\u0016J\u0012\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010<\u001a\u00020:2\b\u0010=\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010>\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010?\u001a\u00020:2\b\u0010@\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010A\u001a\u00020:2\b\u0010B\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010C\u001a\u00020:2\u0006\u0010D\u001a\u00020\u0015H\u0016J\u0012\u0010E\u001a\u0002022\b\u0010F\u001a\u0004\u0018\u00010\u0003H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\nR\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\b\"\u0004\b\u0018\u0010\n¨\u0006G"}, d2 = {"Lcom/wear/bean/official/OfficialAcount;", "Lcom/wear/bean/handlerbean/IPeopleInfo;", "showNickName", "", "(Ljava/lang/String;)V", "avatarRes", "", "getAvatarRes", "()I", "setAvatarRes", "(I)V", "message", "Lcom/wear/bean/official/OfficialMsg;", "getMessage", "()Lcom/wear/bean/official/OfficialMsg;", "setMessage", "(Lcom/wear/bean/official/OfficialMsg;)V", "muteFlag", "getMuteFlag", "setMuteFlag", "setTop", "", "unreadMessagesNumber", "getUnreadMessagesNumber", "setUnreadMessagesNumber", "getAddTime", "getAvatar", "getDraftMessage", "Lcom/wear/protocol/CommunMessage;", "getFlag", "", "getId", "getLastMessage", "getLastOfficialNotice", "Lcom/wear/bean/BaseEntity;", "getLinkedToys2", "", "Lcom/wear/bean/Toy;", "getMoodMessage", "getRemark", "getSetTop", "getShowName", "getStatusMode", "Lorg/jivesoftware/smack/packet/Presence$Mode;", "getTempName", "getTempViewType", "getToyStatus", "getUserJid", "getUserName", "isDateIng", "", "isExit", "isFriend", "isGroup", "isOnline", "isShowInFriendsList", "isSupportGroup", "setDraftMessage", "", "communMessage", "setFlag", "flag", "setLastMessage", "setLastOfficialNotice", "officialnotice", "setRemark", "remark", "setSetTop", "top", "showBykey", "key", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class OfficialAcount implements IPeopleInfo {
    private int avatarRes;

    @Nullable
    private OfficialMsg message;
    private int muteFlag;
    private long setTop;

    @NotNull
    private String showNickName;
    private int unreadMessagesNumber;

    public OfficialAcount(@NotNull String showNickName) {
        Intrinsics.checkNotNullParameter(showNickName, "showNickName");
        this.showNickName = showNickName;
        this.avatarRes = R.drawable.avatar_official;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public long getAddTime() {
        return 0L;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo, com.wear.bean.handlerbean.IContactInfo
    @NotNull
    public String getAvatar() {
        return String.valueOf(this.avatarRes);
    }

    public final int getAvatarRes() {
        return this.avatarRes;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    @Nullable
    public CommunMessage getDraftMessage() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    @NotNull
    public Object getFlag() {
        return "null";
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    @NotNull
    public String getId() {
        return "lovenseRemoteOfficial";
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    @Nullable
    public CommunMessage getLastMessage() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    @Nullable
    public BaseEntity getLastOfficialNotice() {
        return this.message;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    @NotNull
    public List<Toy> getLinkedToys2() {
        return new ArrayList();
    }

    @Nullable
    public final OfficialMsg getMessage() {
        return this.message;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    @NotNull
    public String getMoodMessage() {
        return "";
    }

    public final int getMuteFlag() {
        return this.muteFlag;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    @NotNull
    public String getRemark() {
        return "";
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public long getSetTop() {
        return this.setTop;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo, com.wear.bean.handlerbean.IContactInfo
    @NotNull
    /* renamed from: getShowName, reason: from getter */
    public String getShowNickName() {
        return this.showNickName;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    @NotNull
    public Presence.Mode getStatusMode() {
        return Presence.Mode.dnd;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    @NotNull
    public String getTempName() {
        return "";
    }

    @Override // com.wear.bean.handlerbean.IItemType
    public int getTempViewType() {
        return 0;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    @NotNull
    public String getToyStatus() {
        return "";
    }

    public final int getUnreadMessagesNumber() {
        return this.unreadMessagesNumber;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    @NotNull
    public String getUserJid() {
        return "lovenseRemoteOfficial";
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    @NotNull
    public String getUserName() {
        return this.showNickName;
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
        return true;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    @NotNull
    public String isSupportGroup() {
        return "";
    }

    public final void setAvatarRes(int i) {
        this.avatarRes = i;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setDraftMessage(@Nullable CommunMessage communMessage) {
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setFlag(@Nullable Object flag) {
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setLastMessage(@Nullable CommunMessage communMessage) {
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setLastOfficialNotice(@Nullable BaseEntity officialnotice) {
        this.message = officialnotice instanceof OfficialMsg ? (OfficialMsg) officialnotice : null;
    }

    public final void setMessage(@Nullable OfficialMsg officialMsg) {
        this.message = officialMsg;
    }

    public final void setMuteFlag(int i) {
        this.muteFlag = i;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setRemark(@Nullable String remark) {
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setSetTop(long top) {
        this.setTop = top;
    }

    public final void setUnreadMessagesNumber(int i) {
        this.unreadMessagesNumber = i;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public boolean showBykey(@Nullable String key) {
        return true;
    }
}

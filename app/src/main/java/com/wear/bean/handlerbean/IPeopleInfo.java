package com.wear.bean.handlerbean;

import com.wear.bean.BaseEntity;
import com.wear.bean.Toy;
import com.wear.protocol.CommunMessage;
import java.util.List;
import org.jivesoftware.smack.packet.Presence;

/* loaded from: classes3.dex */
public interface IPeopleInfo extends IItemType, IContactInfo {
    long getAddTime();

    String getAvatar();

    CommunMessage getDraftMessage();

    Object getFlag();

    String getId();

    CommunMessage getLastMessage();

    BaseEntity getLastOfficialNotice();

    List<Toy> getLinkedToys2();

    String getMoodMessage();

    String getRemark();

    long getSetTop();

    String getShowName();

    Presence.Mode getStatusMode();

    String getTempName();

    String getToyStatus();

    String getUserJid();

    String getUserName();

    boolean isDateIng();

    boolean isExit();

    boolean isFriend();

    boolean isGroup();

    boolean isOnline();

    boolean isShowInFriendsList();

    String isSupportGroup();

    void setDraftMessage(CommunMessage communMessage);

    void setFlag(Object obj);

    void setLastMessage(CommunMessage communMessage);

    void setLastOfficialNotice(BaseEntity baseEntity);

    void setRemark(String str);

    void setSetTop(long j);

    boolean showBykey(String str);
}

package com.wear.bean;

import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.MessageType;
import com.wear.util.WearUtils;
import dc.h12;
import dc.ob2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.jivesoftware.smack.packet.Presence;

/* loaded from: classes3.dex */
public class Account extends BaseEntity implements IPeopleInfo {
    private String addFriendFromGroup;
    private String age;
    private String avatar;
    private String avatarBitmapUrl;
    private String controlLinkId;
    private boolean controlLinkJoiner;
    private ArrayList<Toy> controlLinkToys;
    private String controlLinkUserId;
    private String deviceAppVersion;
    private String deviceToken;
    private String deviceType;
    private String emailAndPassMd5;
    private String gender;
    private transient String liveFriendId;
    private transient int liveStatus;
    private String moodMessage;
    private String name;
    private String password;
    private String uid;
    private String userCode;
    public transient MessageType currentControlType = MessageType.live;
    private transient boolean isLDRMutualControl = false;
    private transient String acceptVideoRequestJid = null;
    private transient Presence.Mode statusMode = Presence.Mode.chat;

    public Account(String str) {
        setId(str);
        this.name = WearUtils.L0();
    }

    public void clearControlLinkToys() {
        ArrayList<Toy> arrayList = this.controlLinkToys;
        if (arrayList != null) {
            arrayList.clear();
            this.controlLinkToys = null;
        }
    }

    public String getAcceptVideoRequestJid() {
        return this.acceptVideoRequestJid;
    }

    public String getAddFriendFromGroup() {
        return this.addFriendFromGroup;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public long getAddTime() {
        return 0L;
    }

    public String getAge() {
        return this.age;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo, com.wear.bean.handlerbean.IContactInfo
    public String getAvatar() {
        return WearUtils.e1(this.avatar) ? "" : this.avatar;
    }

    public String getAvatarBitmapUrl() {
        return this.avatarBitmapUrl;
    }

    public String getControlLinkId() {
        return this.controlLinkId;
    }

    public ArrayList<Toy> getControlLinkToys() {
        if (this.controlLinkToys == null) {
            this.controlLinkToys = new ArrayList<>();
        }
        return this.controlLinkToys;
    }

    public String getControlLinkUserId() {
        return this.controlLinkUserId;
    }

    public MessageType getCurrentControlType() {
        return this.currentControlType;
    }

    public String getDeviceAppVersion() {
        return this.deviceAppVersion;
    }

    public String getDeviceToken() {
        return this.deviceToken;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public CommunMessage getDraftMessage() {
        return null;
    }

    public String getEmailAndPassMd5() {
        return this.emailAndPassMd5;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public Object getFlag() {
        return null;
    }

    public String getGender() {
        return this.gender;
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

    public String getLiveFriendId() {
        return this.liveFriendId;
    }

    public int getLiveStatus() {
        return this.liveStatus;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getMoodMessage() {
        return this.moodMessage;
    }

    public String getPassword() {
        return this.password;
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
        return null;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public Presence.Mode getStatusMode() {
        return this.statusMode;
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

    public String getUid() {
        return this.uid;
    }

    public String getUserCode() {
        return this.userCode;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getUserJid() {
        return WearUtils.i0(getId());
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getUserName() {
        return this.name;
    }

    public boolean isControlLinkJoiner() {
        return this.controlLinkJoiner;
    }

    public void isControlLinkToys(Toy toy) {
        if (this.controlLinkToys == null) {
            this.controlLinkToys = new ArrayList<>();
        }
        this.controlLinkToys.add(toy);
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

    public boolean isLDRMutualControl() {
        return this.isLDRMutualControl;
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

    public void setAcceptVideoRequestJid(String str) {
        this.acceptVideoRequestJid = str;
    }

    public void setAddFriendFromGroup(String str) {
        this.addFriendFromGroup = str;
    }

    public void setAge(String str) {
        this.age = str;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setAvatarBitmapUrl(String str) {
        this.avatarBitmapUrl = str;
    }

    public void setControlLinkId(String str) {
        this.controlLinkId = str;
    }

    public void setControlLinkJoiner(boolean z) {
        this.controlLinkJoiner = z;
    }

    public void setControlLinkToys(Toy toy) {
        if (this.controlLinkToys == null) {
            this.controlLinkToys = new ArrayList<>();
        }
        Iterator<Toy> it = this.controlLinkToys.iterator();
        while (it.hasNext()) {
            if (it.next().getDeviceId().equals(toy.getDeviceId())) {
                return;
            }
        }
        this.controlLinkToys.add(toy);
    }

    public void setControlLinkUserId(String str) {
        this.controlLinkUserId = str;
    }

    public void setCurrentControlType(MessageType messageType) {
        this.currentControlType = messageType;
    }

    public void setDeviceAppVersion(String str) {
        this.deviceAppVersion = str;
    }

    public void setDeviceToken(String str) {
        this.deviceToken = str;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setDraftMessage(CommunMessage communMessage) {
    }

    public void setEmailAndPassMd5(String str) {
        this.emailAndPassMd5 = str;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setFlag(Object obj) {
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public void setLDRMutualControl(boolean z) {
        this.isLDRMutualControl = z;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setLastMessage(CommunMessage communMessage) {
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setLastOfficialNotice(BaseEntity baseEntity) {
    }

    public void setLiveFriendId(String str) {
        this.liveFriendId = str;
    }

    public void setLiveStatus(int i) {
        if (i != this.liveStatus) {
            ob2.o().I();
        }
        this.liveStatus = i;
        if (i == 0) {
            h12.D.isControlChat = false;
        } else {
            h12.D.isControlChat = true;
            EventBus.getDefault().post(h12.D);
        }
    }

    public void setMoodMessage(String str) {
        this.moodMessage = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setRemark(String str) {
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setSetTop(long j) {
    }

    public void setStatusMode(Presence.Mode mode) {
        if (mode != null) {
            if (mode == Presence.Mode.chat || mode == Presence.Mode.dnd || mode == Presence.Mode.away) {
                this.statusMode = mode;
            }
        }
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public boolean showBykey(String str) {
        return false;
    }
}

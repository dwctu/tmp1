package com.wear.bean;

import android.text.TextUtils;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import com.wear.bean.SyncLinkToy;
import com.wear.bean.chat.ToyInfo;
import com.wear.bean.handlerbean.HandlerUser;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.protocol.CommunMessage;
import com.wear.util.WearUtils;
import dc.be3;
import dc.jf3;
import dc.nd3;
import dc.tu1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jivesoftware.smack.packet.Presence;

@DatabaseTable(tableName = "tb_user")
/* loaded from: classes3.dex */
public class User extends BaseEntity implements HandlerUser, IPeopleInfo {
    public static final String EN_ABLE_AGORAIO = "enableAgoraIO";
    public static final String FEATURE_IS_SUPPORT_CONTROLLINK_FRIEND_REQUEST = "isSupportControlLinkFriendRequest";
    public static final String FEATURE_IS_SUPPORT_CONTROLLINK_PERMISSION_REQUEST = "isSupportControlLinkPermissionRequest";
    public static final String FEATURE_IS_SUPPORT_LDR_FILL_ORDER = "isSupportLDRFillOrder";
    public static final String FEATURE_IS_SUPPORT_LDR_FILL_SOLACE = "isSupportSolaceTapButtonControl";
    public static final String FEATURE_IS_SUPPORT_LDR_TOUCH_PANEL = "isSupportLdrTouchPanel";
    private transient boolean addMessage;
    private long addTime;
    private String age;

    @DatabaseField
    private String avatar;
    private String avatarBitmapUrl;
    private String deviceAppVersion;
    private String deviceToken;
    private String deviceType;
    private transient CommunMessage draftMessage;
    private boolean enableAgoraIO;
    private Object flag;

    @DatabaseField
    private String gender;
    private boolean isSupportControlLinkPermissionRequest;
    private String isSupportGroup;
    private boolean isSupportLDRFillOrder;
    private boolean isSupportLdrTouchPanel;
    private boolean isSupportSolaceTapButtonControl;
    private transient CommunMessage lastMessage;
    private String moodMessage;

    @DatabaseField
    private String name;
    private transient boolean online;
    private transient String remark;

    @DatabaseField
    private String remoteAccountId;
    private String remotePlatform;
    private String remoteVersion;
    private transient String supportType;
    private transient String tempAvatar;
    private transient String tempName;
    private int tempViewType;
    private transient String toyDeviceId;
    private transient String toyName;
    private transient String toyStatus;

    @DatabaseField
    private String userCode;
    private transient Presence.Mode statusMode = Presence.Mode.chat;
    private transient Presence.Type chatType = Presence.Type.unavailable;
    private int friendType = 0;
    private transient List<Toy> linkedToys = new ArrayList();
    private boolean isTyping = false;
    private transient int iagree = 0;
    private transient int fagree = 0;
    private String friendGTMTime = "";
    private long setTop = 0;
    private transient int supportAggregation = -1;

    public User() {
    }

    public void addFriendType(int i) {
        this.friendType = i | this.friendType;
    }

    @Override // com.wear.bean.handlerbean.HandlerUser
    public boolean addSendToMe() {
        return haveFriendType(4);
    }

    @Override // com.wear.bean.handlerbean.HandlerUser
    public boolean canAutomaticAddFriend() {
        if (haveFriendType(8)) {
            return true;
        }
        return this.iagree == 1 && this.fagree == 1;
    }

    @Override // com.wear.bean.handlerbean.HandlerUser
    public boolean canSendMsg() {
        return isFriend() || isDateIng();
    }

    public void controlLinkOfflineChangeToy(boolean z) {
        List<Toy> list = this.linkedToys;
        if (list == null) {
            this.linkedToys = new ArrayList();
            return;
        }
        Iterator<Toy> it = list.iterator();
        while (it.hasNext()) {
            it.next().setStatus(0);
        }
    }

    public void deleteFriendType(int i) {
        this.friendType = (~i) & this.friendType;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public long getAddTime() {
        return this.addTime;
    }

    public String getAge() {
        return this.age;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo, com.wear.bean.handlerbean.IContactInfo
    public String getAvatar() {
        return (!isDateIng() || TextUtils.isEmpty(getTempAvatar())) ? WearUtils.e1(this.avatar) ? "" : this.avatar : getTempAvatar();
    }

    public String getAvatarBitmapUrl() {
        return this.avatarBitmapUrl;
    }

    public synchronized ArrayList<Toy> getCLLinkedToys2() {
        ArrayList<Toy> arrayList = new ArrayList<>();
        List<Toy> list = this.linkedToys;
        if (list == null) {
            this.linkedToys = new ArrayList();
            return arrayList;
        }
        Iterator<Toy> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public Presence.Type getChatType() {
        Presence.Type type = this.chatType;
        return type == null ? Presence.Type.unavailable : type;
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
        return this.draftMessage;
    }

    public int getFagree() {
        return this.fagree;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public Object getFlag() {
        return this.flag;
    }

    public String getFriendGTMTime() {
        return (!WearUtils.e1(this.friendGTMTime) && WearUtils.q1(this.friendGTMTime)) ? this.friendGTMTime : be3.o();
    }

    public int getFriendType() {
        return this.friendType;
    }

    public String getGender() {
        return this.gender;
    }

    public int getIagree() {
        return this.iagree;
    }

    @Override // com.wear.bean.BaseEntity
    public String getId() {
        String strF = nd3.f(super.getId());
        return WearUtils.e1(strF) ? super.getId() : strF;
    }

    public String getIsSupportGroup() {
        return this.isSupportGroup;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public CommunMessage getLastMessage() {
        return this.lastMessage;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public BaseEntity getLastOfficialNotice() {
        return null;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getMoodMessage() {
        return this.moodMessage;
    }

    public String getOldId() {
        return super.getId();
    }

    public boolean getOnline() {
        return this.online;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getRemark() {
        return this.remark;
    }

    public String getRemoteAccountId() {
        return this.remoteAccountId;
    }

    public String getRemotePlatform() {
        return this.remotePlatform;
    }

    public String getRemoteVersion() {
        return this.remoteVersion;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public long getSetTop() {
        return this.setTop;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo, com.wear.bean.handlerbean.IContactInfo
    /* renamed from: getShowName */
    public String getShowNickName() {
        if (isDateIng()) {
            return getTempName();
        }
        String remark = getRemark();
        return !WearUtils.e1(remark) ? remark : getUserName();
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public Presence.Mode getStatusMode() {
        return isGroup() ? Presence.Mode.chat : this.statusMode;
    }

    public Integer getSupportAggregation() {
        return Integer.valueOf(this.supportAggregation);
    }

    public String getSupportType() {
        return this.supportType;
    }

    public String getTempAvatar() {
        return this.tempAvatar;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getTempName() {
        return WearUtils.e1(this.tempName) ? !WearUtils.e1(getRemark()) ? getRemark() : getUserName() : this.tempName;
    }

    @Override // com.wear.bean.handlerbean.IItemType
    public int getTempViewType() {
        return 0;
    }

    public String getToyDeviceId() {
        return this.toyDeviceId;
    }

    public String getToyName() {
        return this.toyName;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String getToyStatus() {
        return this.toyStatus;
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

    public boolean haveFriendType(int i) {
        return (this.friendType & i) == i;
    }

    public boolean isAddMessage() {
        return this.addMessage;
    }

    public boolean isControlLink() {
        return haveFriendType(64);
    }

    @Override // com.wear.bean.handlerbean.HandlerUser, com.wear.bean.handlerbean.IPeopleInfo
    public boolean isDateIng() {
        return haveFriendType(32);
    }

    @Override // com.wear.bean.handlerbean.HandlerUser
    public boolean isDeleteByFriend() {
        return haveFriendType(8);
    }

    public boolean isEnableAgoraIO() {
        return this.enableAgoraIO;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public boolean isExit() {
        return false;
    }

    @Override // com.wear.bean.handlerbean.HandlerUser, com.wear.bean.handlerbean.IPeopleInfo
    public boolean isFriend() {
        return isOnlyFriendType(1);
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public boolean isGroup() {
        return false;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public boolean isOnline() {
        boolean z = this.online;
        Presence.Mode mode = this.statusMode;
        if (mode != null && (mode == Presence.Mode.away || WearUtils.x.i.n(getUserJid()) || isDeleteByFriend())) {
            z = false;
        }
        if (isDateIng()) {
            return true;
        }
        if (Presence.Type.unavailable == this.chatType) {
            return false;
        }
        return z;
    }

    public boolean isOnlyFriendType(int i) {
        return this.friendType == i;
    }

    public boolean isRealOnLine() {
        return isDateIng() || getChatType() != Presence.Type.unavailable;
    }

    @Override // com.wear.bean.handlerbean.HandlerUser, com.wear.bean.handlerbean.IPeopleInfo
    public boolean isShowInFriendsList() {
        return haveFriendType(1) || isDeleteByFriend() || isGroup();
    }

    public boolean isSupportControlLinkPermissionRequest() {
        return this.isSupportControlLinkPermissionRequest;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public String isSupportGroup() {
        return this.isSupportGroup;
    }

    public boolean isSupportLDRFillOrder() {
        return this.isSupportLDRFillOrder;
    }

    public boolean isSupportLdrTouchPanel() {
        return this.isSupportLdrTouchPanel;
    }

    public boolean isSupportSolaceTapButtonControl() {
        return this.isSupportSolaceTapButtonControl;
    }

    public boolean isTyping() {
        return this.isTyping;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isUserOnline() {
        /*
            r4 = this;
            org.jivesoftware.smack.packet.Presence$Mode r0 = r4.statusMode
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1f
            org.jivesoftware.smack.packet.Presence$Mode r3 = org.jivesoftware.smack.packet.Presence.Mode.away
            if (r0 == r3) goto L2e
            com.wear.util.MyApplication r0 = com.wear.util.WearUtils.x
            dc.n82 r0 = r0.i
            java.lang.String r3 = r4.getUserJid()
            boolean r0 = r0.n(r3)
            if (r0 != 0) goto L2e
            boolean r0 = r4.isDeleteByFriend()
            if (r0 != 0) goto L2e
            goto L2d
        L1f:
            boolean r0 = r4.isDateIng()
            if (r0 == 0) goto L26
            return r2
        L26:
            org.jivesoftware.smack.packet.Presence$Type r0 = org.jivesoftware.smack.packet.Presence.Type.unavailable
            org.jivesoftware.smack.packet.Presence$Type r3 = r4.chatType
            if (r0 != r3) goto L2d
            goto L2e
        L2d:
            r1 = 1
        L2e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "flag===="
            r0.append(r2)
            r0.append(r1)
            r0.toString()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.bean.User.isUserOnline():boolean");
    }

    public int lastMessageComp(User user) {
        if (getLastMessage() != null && user.getLastMessage() == null) {
            return -1;
        }
        if (getLastMessage() != null || user.getLastMessage() == null) {
            return (getLastMessage() == null || user.getLastMessage() == null) ? (getLastMessage() == null && user.getLastMessage() == null) ? getUserName().compareTo(user.getUserName()) : getUserName().compareTo(user.getUserName()) : user.getLastMessage().getCreated().compareTo(getLastMessage().getCreated());
        }
        return 1;
    }

    public void resetAddFriendInfo() {
        this.iagree = 0;
        this.fagree = 0;
    }

    public void resetFriendType(int i) {
        this.friendType = i;
    }

    public void setAddMessage(boolean z) {
        this.addMessage = z;
    }

    public void setAddTime(long j) {
        this.addTime = j;
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

    public void setChatType(Presence.Type type) {
        this.chatType = type;
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
        this.draftMessage = communMessage;
    }

    public void setEnableAgoraIO(boolean z) {
        this.enableAgoraIO = z;
    }

    public void setFagree(int i) {
        this.fagree = i;
    }

    public void setFeature(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        if (!this.isSupportLdrTouchPanel && list.contains(FEATURE_IS_SUPPORT_LDR_TOUCH_PANEL)) {
            this.isSupportLdrTouchPanel = true;
        }
        if (!this.isSupportLDRFillOrder && list.contains(FEATURE_IS_SUPPORT_LDR_FILL_ORDER)) {
            this.isSupportLDRFillOrder = true;
        }
        if (!this.isSupportSolaceTapButtonControl && list.contains(FEATURE_IS_SUPPORT_LDR_FILL_SOLACE)) {
            this.isSupportSolaceTapButtonControl = true;
        }
        if (!this.isSupportControlLinkPermissionRequest && list.contains(FEATURE_IS_SUPPORT_CONTROLLINK_PERMISSION_REQUEST)) {
            this.isSupportControlLinkPermissionRequest = true;
        }
        this.enableAgoraIO = list.contains(EN_ABLE_AGORAIO);
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setFlag(Object obj) {
        this.flag = obj;
    }

    public void setFriendGTMTime(String str) {
        this.friendGTMTime = str;
    }

    public void setFriendType(int i) {
        this.friendType = i;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public void setIagree(int i) {
        this.iagree = i;
    }

    @Override // com.wear.bean.BaseEntity
    public void setId(String str) {
        super.setId(nd3.p(str));
    }

    public void setIsSupportGroup(String str) {
        this.isSupportGroup = str;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setLastMessage(CommunMessage communMessage) {
        this.lastMessage = communMessage;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setLastOfficialNotice(BaseEntity baseEntity) {
    }

    public void setMoodMessage(String str) {
        this.moodMessage = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOnline(boolean z) {
        this.online = z;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setRemark(String str) {
        this.remark = str;
    }

    public void setRemoteAccountId(String str) {
        String str2 = "setRemoteAccountId: " + str + "   " + getId();
        this.remoteAccountId = str;
    }

    public void setRemotePlatform(String str) {
        this.remotePlatform = str;
    }

    public void setRemoteVersion(String str) {
        this.remoteVersion = str;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public void setSetTop(long j) {
        this.setTop = j;
    }

    public void setStatusMode(Presence.Mode mode) {
        if (mode != null) {
            if (mode == Presence.Mode.chat || mode == Presence.Mode.dnd || mode == Presence.Mode.away) {
                this.statusMode = mode;
            }
        }
    }

    public void setSupportAggregation(int i) {
        this.supportAggregation = i;
    }

    public void setSupportControlLinkPermissionRequest(boolean z) {
        this.isSupportControlLinkPermissionRequest = z;
    }

    public void setSupportLDRFillOrder(boolean z) {
        this.isSupportLDRFillOrder = z;
    }

    public void setSupportLdrTouchPanel(boolean z) {
        this.isSupportLdrTouchPanel = z;
    }

    public void setSupportSolaceTapButtonControl(boolean z) {
        this.isSupportSolaceTapButtonControl = z;
    }

    public void setSupportType(String str) {
        this.supportType = str;
    }

    public void setTempAvatar(String str) {
        this.tempAvatar = str;
    }

    public void setTempName(String str) {
        this.tempName = str;
    }

    public void setToyDeviceId(String str) {
        this.toyDeviceId = str;
    }

    public void setToyName(String str) {
        this.toyName = str;
    }

    public void setToyStatus(String str) {
        this.toyStatus = str;
    }

    public void setTyping(boolean z) {
        this.isTyping = z;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public boolean showBykey(String str) {
        String userName = getUserName();
        if (!TextUtils.isEmpty(userName) && userName.toLowerCase().contains(str.toLowerCase())) {
            return true;
        }
        String remark = getRemark();
        return !TextUtils.isEmpty(remark) && remark.toLowerCase().contains(str.toLowerCase());
    }

    public String toString() {
        return getId() + "===" + this.name;
    }

    public void updateControlLinkToy(boolean z, ControlLinkBean controlLinkBean) {
        List<Toy> list = this.linkedToys;
        if (list == null) {
            this.linkedToys = new ArrayList();
        } else {
            list.clear();
        }
        if (!z) {
            List<ControlLinkJoinerToyBean> toys = controlLinkBean.getJoiner().getToys();
            if (toys == null || toys.size() <= 0) {
                setToyName(null);
                setToyStatus(null);
                return;
            }
            boolean z2 = false;
            for (ControlLinkJoinerToyBean controlLinkJoinerToyBean : toys) {
                if (!WearUtils.e1(controlLinkJoinerToyBean.getId())) {
                    Toy toy = new Toy();
                    toy.setDeviceId(controlLinkJoinerToyBean.getId());
                    tu1.a(toy);
                    try {
                        toy.setVersion(Integer.valueOf(Integer.parseInt(controlLinkJoinerToyBean.getType().split(";")[0].split(SignatureImpl.INNER_SEP)[1])));
                    } catch (Exception unused) {
                    }
                    toy.setName(jf3.b(controlLinkJoinerToyBean.getType()));
                    toy.synNameToType();
                    toy.setWorkMode(controlLinkJoinerToyBean.getWorkMode());
                    toy.setStatus(WearUtils.y1(controlLinkJoinerToyBean.getStatus()) ? 1 : 0);
                    toy.setBattery(!WearUtils.e1(controlLinkJoinerToyBean.getBattery()) ? Integer.parseInt(controlLinkJoinerToyBean.getBattery()) : 60);
                    toy.setIsSelect(Integer.valueOf(WearUtils.y1(controlLinkJoinerToyBean.getIsControl()) ? 1 : 0));
                    try {
                        toy.setVersion(Integer.valueOf(controlLinkJoinerToyBean.getFVersion() != null ? Integer.parseInt(controlLinkJoinerToyBean.getFVersion()) : 0));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                    this.linkedToys.add(toy);
                    if (!z2 && toy.getStatus() == 1) {
                        setToyName(Toy.NAME_MAP.get(toy.getType()));
                        setToyStatus(toy.getStatus() == 1 ? "true" : "false");
                        setToyDeviceId(toy.getDeviceId());
                        z2 = true;
                    }
                }
            }
            if (z2) {
                return;
            }
            setToyName(null);
            setToyStatus(null);
            return;
        }
        List<ControlLinkCreatorToyBean> toys2 = controlLinkBean.getCreator().getToys();
        if (toys2 == null || toys2.size() <= 0) {
            setToyName(null);
            setToyStatus(null);
            return;
        }
        boolean z3 = false;
        for (ControlLinkCreatorToyBean controlLinkCreatorToyBean : toys2) {
            if (!WearUtils.e1(controlLinkCreatorToyBean.getId())) {
                Toy toy2 = new Toy();
                toy2.setDeviceId(controlLinkCreatorToyBean.getId());
                tu1.a(toy2);
                try {
                    toy2.setVersion(Integer.valueOf(Integer.parseInt(controlLinkCreatorToyBean.getType().split(";")[0].split(SignatureImpl.INNER_SEP)[1])));
                } catch (Exception unused2) {
                }
                toy2.setName(jf3.b(controlLinkCreatorToyBean.getType()));
                toy2.synNameToType();
                toy2.setStatus(WearUtils.y1(controlLinkCreatorToyBean.getStatus()) ? 1 : 0);
                toy2.setBattery(!WearUtils.e1(controlLinkCreatorToyBean.getBattery()) ? Integer.parseInt(controlLinkCreatorToyBean.getBattery()) : 60);
                toy2.setIsSelect(Integer.valueOf(WearUtils.y1(controlLinkCreatorToyBean.getStatus()) ? 1 : 0));
                toy2.setWorkMode(controlLinkCreatorToyBean.getWorkMode());
                if (!WearUtils.e1(controlLinkCreatorToyBean.getFVersion())) {
                    try {
                        toy2.setVersion(Integer.valueOf(Integer.parseInt(controlLinkCreatorToyBean.getFVersion())));
                    } catch (NumberFormatException e2) {
                        e2.printStackTrace();
                    }
                }
                this.linkedToys.add(toy2);
                if (!z3 && toy2.getStatus() == 1) {
                    setToyName(Toy.NAME_MAP.get(toy2.getType()));
                    setToyStatus(toy2.getStatus() == 1 ? "true" : "false");
                    setToyDeviceId(toy2.getDeviceId());
                    z3 = true;
                }
            }
        }
        if (z3) {
            return;
        }
        setToyName(null);
        setToyStatus(null);
    }

    public void updateSyncLinkToy(String str) {
        SyncLinkToy syncLinkToy = (SyncLinkToy) WearUtils.A.fromJson(str, SyncLinkToy.class);
        List<Toy> list = this.linkedToys;
        if (list == null) {
            this.linkedToys = new ArrayList();
        } else {
            list.clear();
        }
        if (syncLinkToy == null) {
            setToyName(null);
            setToyStatus(null);
            return;
        }
        setRemotePlatform(syncLinkToy.getPlatform());
        setRemoteVersion(syncLinkToy.getVersion());
        if (syncLinkToy.getToys() == null) {
            setToyName(null);
            setToyStatus(null);
            return;
        }
        boolean z = false;
        for (SyncLinkToy.ToysBean toysBean : syncLinkToy.getToys()) {
            if (!WearUtils.e1(toysBean.getId())) {
                Toy toy = new Toy();
                toy.setDeviceId(toysBean.getId());
                tu1.a(toy);
                try {
                    toy.setVersion(Integer.valueOf(Integer.parseInt(toysBean.getType().split(";")[0].split(SignatureImpl.INNER_SEP)[1])));
                } catch (Exception unused) {
                }
                toy.setName(jf3.b(toysBean.getType()));
                toy.synNameToType();
                toy.setStatus(WearUtils.y1(toysBean.getStatus()) ? 1 : 0);
                toy.setBattery(toysBean.getBattery());
                toy.setIsSelect(Integer.valueOf(toysBean.isControl() ? 1 : 0));
                toy.setWorkMode(toysBean.getWorkMode());
                try {
                    toy.setVersion(Integer.valueOf(Integer.parseInt(toysBean.getfVersion())));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
                this.linkedToys.add(toy);
                if (!z && toy.getStatus() == 1) {
                    setToyName(Toy.NAME_MAP.get(toy.getType()));
                    setToyStatus(toy.getStatus() == 1 ? "true" : "false");
                    setToyDeviceId(toy.getDeviceId());
                    z = true;
                }
            }
        }
        if (z) {
            return;
        }
        setToyName(null);
        setToyStatus(null);
    }

    @Override // com.wear.bean.handlerbean.IPeopleInfo
    public ArrayList<Toy> getLinkedToys2() {
        ArrayList<Toy> arrayList = new ArrayList<>();
        if (this.linkedToys == null) {
            this.linkedToys = new ArrayList();
            return arrayList;
        }
        Iterator it = new ArrayList(this.linkedToys).iterator();
        while (it.hasNext()) {
            Toy toy = (Toy) it.next();
            if (toy != null && toy.getStatus() == 1 && toy.isSelect()) {
                arrayList.add(toy);
            }
        }
        return arrayList;
    }

    public User(String str) {
        setId(str);
        this.name = WearUtils.L0();
    }

    public void updateSyncLinkToy(List<ToyInfo> list) throws Exception {
        List<Toy> list2 = this.linkedToys;
        if (list2 == null) {
            this.linkedToys = new ArrayList();
        } else {
            list2.clear();
        }
        boolean z = false;
        for (ToyInfo toyInfo : list) {
            if (!WearUtils.e1(toyInfo.getDeviceType())) {
                try {
                    Toy toy = new Toy();
                    toy.setDeviceType(toyInfo.getDeviceType());
                    toy.setDeviceId(toyInfo.getMac());
                    tu1.a(toy);
                    toy.setBattery(Integer.parseInt(toyInfo.getBattery()));
                    toy.setVersion(Integer.valueOf(Integer.parseInt(toyInfo.getDeviceType().split(";")[0].split(SignatureImpl.INNER_SEP)[1])));
                    toy.setType(Toy.generateType(toyInfo.getDeviceTypeSymblo(toyInfo.getDeviceType())));
                    toy.setName(jf3.b(toyInfo.getFullName()));
                    toy.synNameToType();
                    toy.setStatus(WearUtils.y1(toyInfo.getStatus()) ? 1 : 0);
                    toy.setIsSelect(1);
                    toy.setWorkMode(toyInfo.getWorkMode());
                    this.linkedToys.add(toy);
                    if (!z && toy.getStatus() == 1) {
                        setToyName(Toy.NAME_MAP.get(toy.getType()));
                        setToyStatus(toy.getStatus() == 1 ? "true" : "false");
                        setToyDeviceId(toy.getDeviceId());
                        z = true;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        if (z) {
            return;
        }
        setToyName(null);
        setToyStatus(null);
    }
}

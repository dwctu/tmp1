package dc;

import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.wear.bean.BlockDates;
import com.wear.bean.UserSettingsBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntityLive;
import com.wear.protocol.EntitySync;
import com.wear.protocol.EntitySystem;
import com.wear.protocol.EntityVideo;
import com.wear.protocol.EntityVoice;
import com.wear.protocol.MessageType;
import com.wear.util.MyApplication;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: BlockWork.java */
/* loaded from: classes3.dex */
public class n82 {
    public BlockDates a;
    public BlockDates b;

    /* compiled from: BlockWork.java */
    public class a implements zn2<String> {
        public final /* synthetic */ d a;
        public final /* synthetic */ String b;

        public a(d dVar, String str) {
            this.a = dVar;
            this.b = str;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            NormalResponse normalResponse = (NormalResponse) new Gson().fromJson(str, NormalResponse.class);
            if (normalResponse == null) {
                MyApplication myApplication = WearUtils.x;
                if (MyApplication.H() != null) {
                    MyApplication myApplication2 = WearUtils.x;
                    sg3.j(MyApplication.H(), R.string.common_serverError, " [" + NetException.SERVICE_DATA_ERROR + "]");
                }
                d dVar = this.a;
                if (dVar != null) {
                    dVar.a(false);
                    return;
                }
                return;
            }
            if (normalResponse.isResult()) {
                n82.this.x(this.a);
                n82.this.A(true, this.b);
                HashMap map = new HashMap();
                map.put("who_oppo", this.b);
                map.put("invite_result", 2);
                ye3.d("F0012", WearUtils.A.toJson(map));
                return;
            }
            MyApplication myApplication3 = WearUtils.x;
            if (MyApplication.H() != null) {
                MyApplication myApplication4 = WearUtils.x;
                sg3.k(MyApplication.H(), normalResponse.getMessage());
            }
            d dVar2 = this.a;
            if (dVar2 != null) {
                dVar2.a(false);
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            MyApplication myApplication = WearUtils.x;
            if (MyApplication.H() != null) {
                MyApplication myApplication2 = WearUtils.x;
                sg3.k(MyApplication.H(), netException.getMessage());
            }
            d dVar = this.a;
            if (dVar != null) {
                dVar.a(false);
            }
        }
    }

    /* compiled from: BlockWork.java */
    public class b implements zn2<String> {
        public final /* synthetic */ d a;
        public final /* synthetic */ String b;

        public b(d dVar, String str) {
            this.a = dVar;
            this.b = str;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            NormalResponse normalResponse = (NormalResponse) new Gson().fromJson(str, NormalResponse.class);
            if (normalResponse == null) {
                MyApplication myApplication = WearUtils.x;
                if (MyApplication.H() != null) {
                    MyApplication myApplication2 = WearUtils.x;
                    sg3.j(MyApplication.H(), R.string.common_serverError, " [" + NetException.SERVICE_DATA_ERROR + "]");
                }
                d dVar = this.a;
                if (dVar != null) {
                    dVar.a(false);
                    return;
                }
                return;
            }
            if (!normalResponse.isResult()) {
                if (ve0.a() != null) {
                    sg3.k(ve0.a(), normalResponse.getMessage());
                }
                d dVar2 = this.a;
                if (dVar2 != null) {
                    dVar2.a(false);
                    return;
                }
                return;
            }
            n82.this.x(this.a);
            for (String str2 : this.b.split(",")) {
                n82.this.A(false, str2);
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            MyApplication myApplication = WearUtils.x;
            if (MyApplication.H() != null) {
                MyApplication myApplication2 = WearUtils.x;
                sg3.k(MyApplication.H(), netException.getMessage());
            }
            d dVar = this.a;
            if (dVar != null) {
                dVar.a(false);
            }
        }
    }

    /* compiled from: BlockWork.java */
    public class c implements zn2<String> {
        public final /* synthetic */ d a;

        public c(d dVar) {
            this.a = dVar;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class);
            if (normalResponse == null || !normalResponse.isResult() || normalResponse.getData() == null || WearUtils.e1(normalResponse.getData().toString())) {
                d dVar = this.a;
                if (dVar != null) {
                    dVar.a(false);
                    return;
                }
                return;
            }
            n82.this.w(nd3.j(normalResponse.getData().toString()), false);
            d dVar2 = this.a;
            if (dVar2 != null) {
                dVar2.a(true);
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            d dVar = this.a;
            if (dVar != null) {
                dVar.a(false);
            }
        }
    }

    /* compiled from: BlockWork.java */
    public interface d {
        void a(boolean z);
    }

    public final void A(boolean z, String str) {
        EntitySystem entitySystem = new EntitySystem();
        if (z) {
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T300.toString(), EntitySystem.SystemOPTCode.C306.toString(), null);
        } else {
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T300.toString(), EntitySystem.SystemOPTCode.C307.toString(), null);
        }
        zb2 zb2VarO = zb2.O();
        MyApplication myApplication = WearUtils.x;
        zb2VarO.F0(MyApplication.H(), str, entitySystem);
    }

    public void B(boolean z, String str) {
        EntitySystem entitySystem = new EntitySystem();
        if (z) {
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T300.toString(), EntitySystem.SystemOPTCode.C311.toString(), null);
        } else {
            entitySystem.addDataToArray(EntitySystem.SystemOPTType.T300.toString(), EntitySystem.SystemOPTCode.C312.toString(), null);
        }
        zb2 zb2VarO = zb2.O();
        MyApplication myApplication = WearUtils.x;
        zb2VarO.F0(MyApplication.H(), str, entitySystem);
    }

    public void C(String str, boolean z) {
        if (WearUtils.e1(str)) {
            return;
        }
        if (!z) {
            if (this.a.getByMessageMuteList() != null) {
                this.a.getByMessageMuteList().remove(str.trim());
            }
        } else {
            if (m(str)) {
                return;
            }
            if (this.a.getByMessageMuteList() == null) {
                this.a.setByMessageMuteList(new ArrayList());
            }
            BlockDates blockDates = this.a;
            if (blockDates != null) {
                blockDates.getByMessageMuteList().add(str.trim());
            }
        }
    }

    public boolean D(String str, boolean z) {
        return z && (k(str) || p(str) || l(str));
    }

    public void E(String str, long j) {
        UserSettingsBean userSettingsBeanG = g(str);
        if (userSettingsBeanG != null) {
            userSettingsBeanG.setSetTop(j);
            return;
        }
        UserSettingsBean userSettingsBean = new UserSettingsBean();
        userSettingsBean.setJid(str);
        userSettingsBean.setSetTop(j);
        BlockDates blockDates = this.a;
        if (blockDates != null) {
            blockDates.addUserSettings(userSettingsBean);
        }
    }

    public void F(String str, int i) {
        UserSettingsBean userSettingsBeanG = g(str);
        if (userSettingsBeanG != null) {
            userSettingsBeanG.setMuteFlag(i);
            return;
        }
        UserSettingsBean userSettingsBean = new UserSettingsBean();
        userSettingsBean.setJid(str);
        userSettingsBean.setMuteFlag(i);
        BlockDates blockDates = this.a;
        if (blockDates != null) {
            blockDates.addUserSettings(userSettingsBean);
        }
    }

    public void b(String str, int i, d dVar) {
        String strP = WearUtils.y.p();
        HashMap map = new HashMap();
        map.put(PSOProgramService.JobID_Key, strP);
        map.put("friendJid", nd3.w(str));
        map.put("type", Integer.valueOf(i));
        tn2.x(WearUtils.x).l("/api/user/addBlack", map, new a(dVar, str));
    }

    public void c(String str, String str2) {
        UserSettingsBean userSettingsBeanG = g(str);
        if (userSettingsBeanG != null) {
            userSettingsBeanG.setRemark(str2);
            return;
        }
        UserSettingsBean userSettingsBean = new UserSettingsBean();
        userSettingsBean.setJid(str);
        userSettingsBean.setRemark(str2);
        BlockDates blockDates = this.a;
        if (blockDates != null) {
            blockDates.addUserSettings(userSettingsBean);
        }
    }

    public void d() {
        this.b = null;
    }

    public boolean e(String str, MessageType messageType, DataEntityAbstract dataEntityAbstract) {
        boolean zS;
        if (!k(str) && !p(str)) {
            return false;
        }
        MessageType messageType2 = MessageType.system;
        boolean z = true;
        if (messageType == messageType2) {
            if (messageType == messageType2) {
                zS = r(str, messageType, dataEntityAbstract);
            } else if (messageType == messageType2) {
                zS = s(messageType, dataEntityAbstract);
            } else {
                z = false;
            }
            z = true ^ zS;
        }
        MessageType messageType3 = MessageType.live;
        if (messageType == messageType3 || messageType == MessageType.sync || messageType == MessageType.video || messageType == MessageType.voice) {
            String string = messageType == messageType3 ? ((EntityLive) dataEntityAbstract).getLiveOPTType().toString() : messageType == MessageType.sync ? ((EntitySync) dataEntityAbstract).getSyncOPTType().toString() : messageType == MessageType.video ? ((EntityVideo) dataEntityAbstract).getVideoOPTType().toString() : messageType == MessageType.voice ? ((EntityVoice) dataEntityAbstract).getVoiceOPTType().toString() : "";
            if (string.equals(EntityLive.LiveOPTType.end.toString()) || string.equals(EntitySync.SyncOPTType.end.toString()) || string.equals(EntityVideo.VideoOPTType.end.toString()) || string.equals(EntityVoice.VoiceOPTType.end.toString())) {
                return false;
            }
        }
        return z;
    }

    public List<String> f(int i) {
        BlockDates blockDates = this.a;
        if (blockDates != null) {
            if (i == 0) {
                return blockDates.getBlockedFriends();
            }
            if (i == 1) {
                return blockDates.getRejectedRequests();
            }
        }
        return null;
    }

    public UserSettingsBean g(String str) {
        List<UserSettingsBean> userSettings;
        if (this.a != null && !WearUtils.e1(str) && (userSettings = this.a.getUserSettings()) != null) {
            for (UserSettingsBean userSettingsBean : userSettings) {
                if (!WearUtils.e1(userSettingsBean.getJid()) && str.trim().equals(userSettingsBean.getJid().trim())) {
                    return userSettingsBean;
                }
            }
        }
        return null;
    }

    public boolean h() {
        BlockDates blockDates = this.a;
        return (blockDates == null || blockDates.getBlockedFriends() == null) ? false : true;
    }

    public boolean i() {
        BlockDates blockDates = this.a;
        return (blockDates == null || blockDates.getRejectedRequests() == null) ? false : true;
    }

    public void j(String str, boolean z) {
        if (z) {
            BlockDates blockDates = (BlockDates) WearUtils.A.fromJson(str, BlockDates.class);
            this.a = blockDates;
            BlockDates blockDates2 = this.b;
            if (blockDates2 != null) {
                blockDates.setBlockedFriends(blockDates2.getBlockedFriends());
                this.a.setRejectedRequests(this.b.getRejectedRequests());
                this.a.setFriendBlack(this.b.getFriendBlack());
            }
        } else {
            BlockDates blockDates3 = (BlockDates) WearUtils.A.fromJson(str, BlockDates.class);
            this.b = blockDates3;
            BlockDates blockDates4 = this.a;
            if (blockDates4 != null) {
                blockDates4.setBlockedFriends(blockDates3.getBlockedFriends());
                this.a.setRejectedRequests(this.b.getRejectedRequests());
                this.a.setFriendBlack(this.b.getFriendBlack());
            }
        }
        if (this.a != null) {
            db2.A().c = this.a.getUid();
            if (!WearUtils.e1(this.a.getUid())) {
                eg3.i(WearUtils.x, "control_uid_simple_key", WearUtils.e1(this.a.getUid()) ? "" : this.a.getUid());
            }
        } else {
            WearUtils.x.j = -1;
        }
        db2.A().J();
    }

    public boolean k(String str) {
        BlockDates blockDates = this.a;
        return (blockDates == null || blockDates.getBlockedFriends() == null || WearUtils.e1(str) || !this.a.getBlockedFriends().contains(str)) ? false : true;
    }

    public boolean l(String str) {
        BlockDates blockDates = this.a;
        return (blockDates == null || blockDates.getFriendBlack() == null || !this.a.getFriendBlack().contains(str)) ? false : true;
    }

    public boolean m(String str) {
        BlockDates blockDates = this.a;
        return (blockDates == null || blockDates.getByMessageMuteList() == null || !this.a.getByMessageMuteList().contains(str)) ? false : true;
    }

    public boolean n(String str) {
        return k(str) || p(str) || l(str);
    }

    public boolean o(String str) {
        UserSettingsBean userSettingsBeanG = g(str);
        return userSettingsBeanG != null && userSettingsBeanG.getMuteFlag() > 0;
    }

    public boolean p(String str) {
        BlockDates blockDates = this.a;
        return (blockDates == null || blockDates.getRejectedRequests() == null || WearUtils.e1(str) || !this.a.getRejectedRequests().contains(str)) ? false : true;
    }

    public boolean q(String str) {
        return k(str) || p(str);
    }

    public boolean r(String str, MessageType messageType, DataEntityAbstract dataEntityAbstract) {
        EntitySystem entitySystem;
        if (messageType == MessageType.system && (entitySystem = (EntitySystem) dataEntityAbstract) != null && entitySystem.getData() != null) {
            Iterator<EntitySystem.EntityArray> it = entitySystem.getData().iterator();
            while (it.hasNext()) {
                EntitySystem.EntityArray next = it.next();
                if (next.getSysOPTCode() == EntitySystem.SystemOPTCode.C306 || next.getSysOPTCode() == EntitySystem.SystemOPTCode.C307) {
                    fp1.d(WearUtils.g0(str));
                    return true;
                }
            }
        }
        return false;
    }

    public boolean s(MessageType messageType, DataEntityAbstract dataEntityAbstract) {
        EntitySystem entitySystem;
        if (messageType == MessageType.system && (entitySystem = (EntitySystem) dataEntityAbstract) != null && entitySystem.getData() != null) {
            Iterator<EntitySystem.EntityArray> it = entitySystem.getData().iterator();
            while (it.hasNext()) {
                EntitySystem.EntityArray next = it.next();
                if (next.getSysOPTCode() == EntitySystem.SystemOPTCode.C311 || next.getSysOPTCode() == EntitySystem.SystemOPTCode.C312) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean t(MessageType messageType, DataEntityAbstract dataEntityAbstract) {
        EntitySystem entitySystem;
        if (messageType == MessageType.system && (entitySystem = (EntitySystem) dataEntityAbstract) != null && entitySystem.getData() != null) {
            Iterator<EntitySystem.EntityArray> it = entitySystem.getData().iterator();
            while (it.hasNext()) {
                if (it.next().getSysOPTCode() == EntitySystem.SystemOPTCode.C322) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean u(MessageType messageType, DataEntityAbstract dataEntityAbstract) {
        return t(messageType, dataEntityAbstract) || v(messageType, dataEntityAbstract);
    }

    public boolean v(MessageType messageType, DataEntityAbstract dataEntityAbstract) {
        EntitySystem entitySystem;
        if (messageType == MessageType.system && (entitySystem = (EntitySystem) dataEntityAbstract) != null && entitySystem.getData() != null) {
            Iterator<EntitySystem.EntityArray> it = entitySystem.getData().iterator();
            while (it.hasNext()) {
                if (it.next().getSysOPTCode() == EntitySystem.SystemOPTCode.C323) {
                    return true;
                }
            }
        }
        return false;
    }

    public void w(String str, boolean z) {
        j(str, z);
        ch3.n().M(str);
    }

    public void x(d dVar) {
        String strP = WearUtils.y.p();
        HashMap map = new HashMap();
        map.put(PSOProgramService.JobID_Key, nd3.w(strP));
        tn2.x(WearUtils.x).l("/api/user/getBlackList", map, new c(dVar));
    }

    public void y(String str, d dVar) {
        String strP = WearUtils.y.p();
        HashMap map = new HashMap();
        map.put(PSOProgramService.JobID_Key, strP);
        map.put("friendJid", nd3.w(str));
        tn2.x(WearUtils.x).l("/api/user/removeBlack", map, new b(dVar, str));
    }

    public void z(String str) {
        UserSettingsBean userSettingsBeanG = g(str);
        if (userSettingsBeanG != null) {
            userSettingsBeanG.setRemark("");
            userSettingsBeanG.setSetTop(0L);
        }
    }
}

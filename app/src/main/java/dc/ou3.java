package dc;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.wear.bean.Account;
import com.wear.bean.CommentFilterBean;
import com.wear.bean.Toy;
import com.wear.bean.ToyBean;
import com.wear.bean.User;
import com.wear.bean.UserControlLink;
import com.wear.bean.UserRoulette;
import com.wear.bean.controlmutlitoys.Ball2CurveEventBean;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.bean.socketio.controlLink.request.SendCommandRequest;
import com.wear.bean.socketio.controlLink.request.ToyCommandBean;
import com.wear.dao.DaoUtils;
import com.wear.main.longDistance.control.ChatSyncControl;
import com.wear.main.longDistance.control.ChatVideoControl;
import com.wear.main.longDistance.control.LDRControl;
import com.wear.protocol.CommunMessage;
import com.wear.protocol.DataEntityAbstract;
import com.wear.protocol.EntityToy;
import com.wear.protocol.MessageType;
import com.wear.util.WearUtils;
import dc.ToyControlBuilder;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: ToyTranslationListener.java */
/* loaded from: classes4.dex */
public class ou3 {
    public static String a = "";
    public static String c;
    public static Map<String, CommentFilterBean> b = new HashMap();
    public static Map<String, List<String>> d = new HashMap();

    public static Pair<String[], String[]> A(List<String> list, List<String> list2) {
        HashMap map = new HashMap();
        i(map, list, list2);
        return du1.b(map);
    }

    public static String[] B(String[] strArr, String str) {
        HashMap map = new HashMap();
        i(map, Arrays.asList(strArr), new ArrayList(Arrays.asList(str.split(","))));
        Pair<String, String> pairC = du1.c(map);
        return new String[]{pairC.getFirst(), pairC.getSecond()};
    }

    public static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String[] strArrSplit = str.split(",");
            String[] strArrSplit2 = str2.split(",");
            if (strArrSplit.length != strArrSplit2.length) {
                return false;
            }
            for (int i = 0; i < strArrSplit.length; i++) {
                List<String> arrayList = d.containsKey(strArrSplit[i]) ? d.get(strArrSplit[i]) : null;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    d.put(strArrSplit[i], arrayList);
                }
                if (e(strArrSplit2[i], arrayList)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b(String str, String str2, String str3) {
        CommentFilterBean commentFilterBean = b.get(str);
        String str4 = str2 + str3;
        boolean z = true;
        if (commentFilterBean == null) {
            commentFilterBean = new CommentFilterBean();
            b.put(str, commentFilterBean);
        } else if (commentFilterBean.getLastLevel1().equals(str4) && commentFilterBean.getLastLevel2().equals(str4) && commentFilterBean.getLastLevel3().equals(str4) && commentFilterBean.getLastLevel4().equals(str4) && commentFilterBean.getLastLevel5().equals(str4)) {
            z = false;
        }
        commentFilterBean.setLastLevel5(commentFilterBean.getLastLevel4());
        commentFilterBean.setLastLevel4(commentFilterBean.getLastLevel3());
        commentFilterBean.setLastLevel3(commentFilterBean.getLastLevel2());
        commentFilterBean.setLastLevel2(commentFilterBean.getLastLevel1());
        commentFilterBean.setLastLevel1(str4);
        return z;
    }

    public static void c() {
        d.clear();
    }

    public static void d() {
        b.clear();
    }

    public static boolean e(String str, List<String> list) {
        boolean z = true;
        if (list.size() >= 5) {
            Iterator<String> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (!it.next().equals(str)) {
                    break;
                }
            }
            list.remove(0);
        }
        list.add(str);
        return z;
    }

    public static void f() {
        d.clear();
    }

    public static void g() {
        du3.e().t();
    }

    public static void h(EntityToy entityToy, String str, String str2, boolean z) {
        LDRControl lDRControlO = na2.m().o();
        if (lDRControlO == null || !lDRControlO.e) {
            entityToy.createToyBean(str, str2, z);
        } else if (lDRControlO.g == null) {
            entityToy.createToyBean(str, str2, z);
        } else {
            entityToy.setAllFuncValue(str, str2, z);
        }
    }

    @NonNull
    public static Map<String, String> i(Map<String, String> map, List<String> list, List<String> list2) {
        int size = list2.size();
        for (int i = size; i < list.size(); i++) {
            if (size == 1) {
                list2.add(list2.get(0));
            } else {
                list2.add("0");
            }
        }
        int i2 = 0;
        for (String str : list) {
            boolean z = (str.equals("v1") || str.equals("v2")) && !list.contains(PSOProgramService.VS_Key);
            boolean z2 = (map.containsKey(PSOProgramService.VS_Key) || map.containsKey("s") || map.containsKey("t")) ? false : true;
            boolean z3 = str.equals(PSOProgramService.VS_Key) || str.equals("s") || str.equals("t");
            if (z2 && (z3 || z)) {
                map.put(PSOProgramService.VS_Key, list2.get(i2));
                map.put("s", list2.get(i2));
                map.put("t", list2.get(i2));
            }
            if (!z) {
                map.put(str, list2.get(i2));
            }
            i2++;
        }
        return map;
    }

    public static String j(String str) {
        return !TextUtils.isEmpty(str) ? str.replaceAll(SignatureImpl.INNER_SEP, "").toLowerCase() : "";
    }

    public static void k(ToyCommandBean toyCommandBean, boolean z) {
        HashMap<String, ToyBean> type;
        if (toyCommandBean.getCate().equals(EntityToy.ToyOPTType.all.toString())) {
            Account accountU = ch3.n().u();
            ArrayList<Toy> arrayListP = (accountU == null || accountU.isControlLinkJoiner()) ? pc1.a.P() : accountU.getControlLinkToys();
            if (toyCommandBean.getAll() == null) {
                du3.e().m(toyCommandBean);
                return;
            } else if (z) {
                z(toyCommandBean.getVersion(), arrayListP, toyCommandBean.getAll());
                return;
            } else {
                y(toyCommandBean.getVersion(), arrayListP, toyCommandBean.getAll());
                return;
            }
        }
        if (toyCommandBean.getCate().equals(EntityToy.ToyOPTType.id.toString())) {
            HashMap<String, ToyBean> id = toyCommandBean.getId();
            if (id != null) {
                for (Map.Entry<String, ToyBean> entry : id.entrySet()) {
                    Toy toyR = pc1.a.R(entry.getKey());
                    if (toyR != null) {
                        if (z) {
                            p(toyR, entry.getValue());
                        } else {
                            n(toyR, entry.getValue());
                        }
                    }
                }
                return;
            }
            return;
        }
        if (!toyCommandBean.getCate().equals(EntityToy.ToyOPTType.type.toString()) || (type = toyCommandBean.getType()) == null) {
            return;
        }
        for (Map.Entry<String, ToyBean> entry2 : type.entrySet()) {
            for (Toy toy : pc1.a.S(entry2.getKey())) {
                if (z) {
                    p(toy, entry2.getValue());
                } else {
                    n(toy, entry2.getValue());
                }
            }
        }
    }

    public static void l(EntityToy entityToy, boolean z) {
        HashMap<String, ToyBean> type;
        if (td3.c() != null) {
            td3.c().e(entityToy);
        }
        if (entityToy.getMac() != null || entityToy.getFunc() != null) {
            du3.e().n(entityToy);
            return;
        }
        if (entityToy.getToyOPTType() == EntityToy.ToyOPTType.all) {
            ArrayList<Toy> arrayListP = pc1.a.P();
            if (z) {
                z(entityToy.getVersion(), arrayListP, entityToy.getAll());
                return;
            } else {
                y(entityToy.getVersion(), arrayListP, entityToy.getAll());
                return;
            }
        }
        if (entityToy.getToyOPTType() == EntityToy.ToyOPTType.id) {
            HashMap<String, ToyBean> id = entityToy.getId();
            if (id != null) {
                for (Map.Entry<String, ToyBean> entry : id.entrySet()) {
                    Toy toyR = pc1.a.R(entry.getKey());
                    if (toyR != null) {
                        if (z) {
                            p(toyR, entry.getValue());
                        } else {
                            n(toyR, entry.getValue());
                        }
                    }
                }
                return;
            }
            return;
        }
        if (entityToy.getToyOPTType() != EntityToy.ToyOPTType.type || (type = entityToy.getType()) == null) {
            return;
        }
        for (Map.Entry<String, ToyBean> entry2 : type.entrySet()) {
            for (Toy toy : pc1.a.S(entry2.getKey())) {
                if (z) {
                    p(toy, entry2.getValue());
                } else {
                    n(toy, entry2.getValue());
                }
            }
        }
    }

    public static void m(DataEntityAbstract dataEntityAbstract, IPeopleInfo iPeopleInfo) {
        CommunMessage communMessage = new CommunMessage();
        communMessage.sendEntity(dataEntityAbstract);
        communMessage.setId(WearUtils.E());
        communMessage.setFrom(WearUtils.y.p());
        communMessage.setTo(iPeopleInfo.getUserJid());
        if (iPeopleInfo.isDateIng()) {
            communMessage.setSendType(2);
        }
        if (zb2.O().l0(communMessage)) {
            DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
            zb2.O().i0(communMessage);
        }
        zb2.O().z0(iPeopleInfo.getUserJid(), dataEntityAbstract);
    }

    public static void n(Toy toy, ToyBean toyBean) {
        if (toyBean != null) {
            if (!toyBean.isStopAll() || (toy.isBAToy() && fk2.a.c(toy.getAddress()) == ek2.POSITION)) {
                v(toy, toyBean, true);
                return;
            }
            if (toy == null) {
                rq1.d.q();
                return;
            }
            String str = "sendCommand: 停止指令" + toy.getAddress();
            rq1.d.r(toy.getAddress());
        }
    }

    public static void o(Toy toy, ToyBean toyBean) {
        if (toyBean == null) {
            return;
        }
        ek2 ek2VarC = fk2.a.c(toy.getAddress());
        if (qa2.a()) {
            pc1.a.d0(toy, toyBean.getT(), false, true);
            return;
        }
        if (ek2VarC == ek2.POSITION) {
            dk2.a.e(toy.getAddress(), toyBean.getPos(), true);
        } else {
            if (ek2VarC != ek2.SPEED || toyBean.getT() == -1) {
                return;
            }
            pc1.a.d0(toy, toyBean.getT(), false, true);
        }
    }

    public static void p(Toy toy, ToyBean toyBean) {
        if (toyBean != null) {
            if (!toyBean.isStopAll()) {
                v(toy, toyBean, false);
                return;
            }
            if (toy == null) {
                rq1.d.q();
                return;
            }
            String str = "sendCommandWithSystemMsg: 停止指令" + toy.getAddress();
            rq1.d.r(toy.getAddress());
        }
    }

    public static void q(User user, MessageType messageType, String str, String str2, boolean z) {
        if (messageType == null || user == null) {
            return;
        }
        if (user.isControlLink() && (user instanceof UserControlLink)) {
            ToyCommandBean toyCommandBean = new ToyCommandBean();
            toyCommandBean.setCate(EntityToy.ToyOPTType.all.toString());
            if (user.isSupportLDRFillOrder()) {
                toyCommandBean.setAllValueFunc(str, str2, z);
            } else {
                toyCommandBean.setAllFunc(str, str2, z);
            }
            ToyBean all = toyCommandBean.getAll();
            boolean z2 = false;
            if (all != null && !all.isStopAll()) {
                z2 = true;
            }
            eq2.f().h(new SendCommandRequest(WearUtils.A.toJson(toyCommandBean), ((UserControlLink) user).getLinkId(), z2));
            return;
        }
        if (!(user instanceof UserRoulette)) {
            EntityToy entityToy = new EntityToy();
            h(entityToy, str, str2, z);
            entityToy.setCate(EntityToy.ToyOPTType.all.toString());
            if (zb2.O().I0(entityToy, user.getId())) {
                return;
            }
            zb2.O().z0(user.getUserJid(), entityToy);
            return;
        }
        EntityToy entityToy2 = new EntityToy();
        h(entityToy2, str, str2, z);
        entityToy2.setCate(EntityToy.ToyOPTType.all.toString());
        String strN = nd3.n(WearUtils.A.toJson(entityToy2));
        if (strN != null) {
            ht2.a.y(user.getUserCode(), "SyncControl", strN, "ToyRoulette");
        }
    }

    public static void r(User user, MessageType messageType, List<Ball2CurveEventBean> list) {
        if (list == null || list.size() == 0 || messageType == null || user == null) {
            return;
        }
        boolean z = false;
        if (messageType != MessageType.live && messageType != MessageType.video && messageType != MessageType.voice) {
            if (messageType == MessageType.sync) {
                if (user.isControlLink() && (user instanceof UserControlLink)) {
                    ToyCommandBean toyCommandBean = new ToyCommandBean();
                    toyCommandBean.setCate(EntityToy.ToyOPTType.all.toString());
                    Ball2CurveEventBean ball2CurveEventBean = list.get(0);
                    toyCommandBean.setAllFunc(ball2CurveEventBean.getFunction(), ball2CurveEventBean.getGroups(), ball2CurveEventBean.isRotateChange());
                    ToyBean all = toyCommandBean.getAll();
                    eq2.f().h(new SendCommandRequest(WearUtils.A.toJson(toyCommandBean), ((UserControlLink) user).getLinkId(), (all == null || all.isStopAll()) ? false : true));
                    return;
                }
                EntityToy entityToy = new EntityToy();
                Ball2CurveEventBean ball2CurveEventBean2 = list.get(0);
                h(entityToy, ball2CurveEventBean2.getFunction(), ball2CurveEventBean2.getGroups(), ball2CurveEventBean2.isRotateChange());
                entityToy.setCate(EntityToy.ToyOPTType.all.toString());
                if (zb2.O().I0(entityToy, user.getId())) {
                    return;
                }
                zb2.O().z0(user.getUserJid(), entityToy);
                return;
            }
            return;
        }
        if (user.isControlLink() && (user instanceof UserControlLink)) {
            ToyCommandBean toyCommandBean2 = new ToyCommandBean();
            toyCommandBean2.setCate(EntityToy.ToyOPTType.id.toString());
            for (Ball2CurveEventBean ball2CurveEventBean3 : list) {
                String strJ = j(ball2CurveEventBean3.getToyAddress());
                toyCommandBean2.addId(strJ, ball2CurveEventBean3.getFunction(), ball2CurveEventBean3.getGroups(), ball2CurveEventBean3.isRotateChange());
                HashMap<String, ToyBean> id = toyCommandBean2.getId();
                if (!z && !WearUtils.e1(strJ) && id != null && id.get(strJ) != null && !id.get(strJ).isStopAll()) {
                    z = true;
                }
            }
            eq2.f().h(new SendCommandRequest(WearUtils.A.toJson(toyCommandBean2), ((UserControlLink) user).getLinkId(), z));
            return;
        }
        if (user instanceof UserRoulette) {
            EntityToy entityToy2 = new EntityToy();
            entityToy2.setVersion(4);
            for (Ball2CurveEventBean ball2CurveEventBean4 : list) {
                entityToy2.addId(j(ball2CurveEventBean4.getToyAddress()), ball2CurveEventBean4.getFunction(), ball2CurveEventBean4.getGroups(), ball2CurveEventBean4.isRotateChange());
            }
            entityToy2.setCate(EntityToy.ToyOPTType.id.toString());
            String strN = nd3.n(WearUtils.A.toJson(entityToy2));
            if (strN != null) {
                ht2.a.y(user.getUserCode(), "LiveControl", strN, "ToyRoulette");
                return;
            }
            return;
        }
        EntityToy entityToy3 = new EntityToy();
        entityToy3.setVersion(4);
        for (Ball2CurveEventBean ball2CurveEventBean5 : list) {
            entityToy3.addId(j(ball2CurveEventBean5.getToyAddress()), ball2CurveEventBean5.getFunction(), ball2CurveEventBean5.getGroups(), ball2CurveEventBean5.isRotateChange());
        }
        entityToy3.setCate(EntityToy.ToyOPTType.id.toString());
        if (dh3.h(user)) {
            du3.e().x(user.getLinkedToys2());
            du3.e().w(entityToy3, user);
        } else {
            if (zb2.O().I0(entityToy3, user.getId())) {
                return;
            }
            zb2.O().z0(user.getUserJid(), entityToy3);
        }
    }

    public static void s(DataEntityAbstract dataEntityAbstract, IPeopleInfo iPeopleInfo) {
        zb2.O().z0(iPeopleInfo.getUserJid(), dataEntityAbstract);
    }

    public static void t(DataEntityAbstract dataEntityAbstract, IPeopleInfo iPeopleInfo) {
        if (iPeopleInfo != null && (iPeopleInfo instanceof UserControlLink)) {
            dq2.w().C(dataEntityAbstract, (UserControlLink) iPeopleInfo);
        }
    }

    public static void u(DataEntityAbstract dataEntityAbstract, IPeopleInfo iPeopleInfo) {
        CommunMessage communMessage = new CommunMessage();
        communMessage.sendEntity(dataEntityAbstract);
        communMessage.setId(WearUtils.E());
        communMessage.setFrom(iPeopleInfo.getUserJid());
        communMessage.setTo(ch3.n().u().getUserJid());
        if (iPeopleInfo.isDateIng()) {
            communMessage.setSendType(2);
        }
        if (zb2.O().l0(communMessage)) {
            DaoUtils.getCommunMessageDao().updateOrAdd(communMessage);
            CommunMessage communMessage2 = (CommunMessage) WearUtils.w(communMessage);
            DataEntityAbstract dataEntityAbstractSyncDecryptBean = communMessage.syncDecryptBean();
            if (communMessage2 != null) {
                communMessage2.setDataBean(dataEntityAbstractSyncDecryptBean);
            }
            zb2.O().i0(communMessage2);
        }
        communMessage.setId(WearUtils.E());
        communMessage.setFrom(ch3.n().u().getUserJid());
        communMessage.setTo(iPeopleInfo.getUserJid());
        zb2.O().y0(communMessage);
    }

    public static void v(Toy toy, ToyBean toyBean, boolean z) {
        if (!mp1.h() && z && toy.isBAToy()) {
            o(toy, toyBean);
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Field field : ToyBean.class.getDeclaredFields()) {
            if (!field.getName().equals("time")) {
                field.setAccessible(true);
                try {
                    if (!TextUtils.equals("-1", String.valueOf(field.get(toyBean)))) {
                        arrayList.add(field.getName());
                        arrayList2.add(String.valueOf(field.get(toyBean)));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        rq1.d.o(toy.getAddress(), arrayList, arrayList2, new ToyControlBuilder(false, true, false, (z && toy.isBAToy()) ? qa2.a() ? ToyControlBuilder.a.SPEED : ToyControlBuilder.a.SETTING_ONLY : ToyControlBuilder.a.SETTING_FIRST));
    }

    public static void w(IPeopleInfo iPeopleInfo) {
        if (iPeopleInfo == null) {
            return;
        }
        EntityToy entityToy = new EntityToy();
        ToyBean toyBean = new ToyBean();
        toyBean.setAll(0);
        entityToy.setAll(toyBean);
        EntityToy.ToyOPTType toyOPTType = EntityToy.ToyOPTType.all;
        entityToy.setCate(toyOPTType.toString());
        if (iPeopleInfo instanceof UserControlLink) {
            UserControlLink userControlLink = (UserControlLink) iPeopleInfo;
            if (userControlLink.isControlLink()) {
                ToyCommandBean toyCommandBean = new ToyCommandBean();
                toyCommandBean.setCate(toyOPTType.toString());
                ToyBean toyBean2 = new ToyBean();
                toyBean2.setAll(0);
                toyCommandBean.setAll(toyBean2);
                eq2.f().h(new SendCommandRequest(WearUtils.A.toJson(toyCommandBean), userControlLink.getLinkId(), false));
                return;
            }
        }
        if (iPeopleInfo instanceof UserRoulette) {
            ht2.a.y(iPeopleInfo.getId(), "SyncControl", nd3.n(WearUtils.A.toJson(entityToy)), "ToyRoulette");
        } else {
            if (zb2.O().I0(entityToy, iPeopleInfo.getId())) {
                return;
            }
            zb2.O().z0(iPeopleInfo.getUserJid(), entityToy);
        }
    }

    public static void x(User user, String str, String str2, boolean z) {
        if (user != null) {
            if (user.isControlLink() && (user instanceof UserControlLink)) {
                ToyCommandBean toyCommandBean = new ToyCommandBean();
                toyCommandBean.setVersion(4);
                toyCommandBean.setCate(EntityToy.ToyOPTType.all.toString());
                toyCommandBean.setAllFunc(str, str2, z);
                ToyBean all = toyCommandBean.getAll();
                boolean z2 = false;
                if (all != null && !all.isStopAll()) {
                    z2 = true;
                }
                eq2.f().h(new SendCommandRequest(WearUtils.A.toJson(toyCommandBean), ((UserControlLink) user).getLinkId(), z2));
                return;
            }
            if (!(user instanceof UserRoulette)) {
                EntityToy entityToy = new EntityToy();
                h(entityToy, str, str2, z);
                entityToy.setCate(EntityToy.ToyOPTType.all.toString());
                if (zb2.O().I0(entityToy, user.getId())) {
                    return;
                }
                zb2.O().z0(user.getUserJid(), entityToy);
                return;
            }
            EntityToy entityToy2 = new EntityToy();
            h(entityToy2, str, str2, z);
            entityToy2.setCate(EntityToy.ToyOPTType.all.toString());
            String strN = nd3.n(WearUtils.A.toJson(entityToy2));
            if (strN != null) {
                ht2.a.y(user.getUserCode(), "SyncControl", strN, "ToyRoulette");
            }
        }
    }

    public static void y(int i, List<Toy> list, ToyBean toyBean) {
        if (toyBean == null || list == null || list.size() <= 0) {
            return;
        }
        for (Toy toy : list) {
            if (!toyBean.isStopAll() || (toy.isBAToy() && fk2.a.c(toy.getAddress()) == ek2.POSITION)) {
                String str = "sendVersionCommand: 发送指令" + toy.getAddress() + "  " + toyBean.toString();
                v(toy, toyBean, true);
            } else if (toy != null) {
                String str2 = "sendVersionCommand: 停止指令" + toy.getAddress();
                rq1.d.r(toy.getAddress());
            } else {
                rq1.d.q();
            }
        }
    }

    public static void z(int i, List<Toy> list, ToyBean toyBean) {
        if (toyBean == null || list == null || list.size() <= 0) {
            return;
        }
        for (Toy toy : list) {
            if (!toyBean.isStopAll()) {
                String str = "sendVersionCommandWithSystemMsg: 发送指令" + toy.getAddress() + "  " + toyBean.toString();
                if (ChatSyncControl.N0().r()) {
                    ChatSyncControl.N0().p.k0(toyBean);
                }
                if (ChatVideoControl.a1().r()) {
                    ChatVideoControl.a1().o.k0(toyBean);
                }
                v(toy, toyBean, false);
            } else if (toy != null) {
                String str2 = "sendVersionCommandWithSystemMsg: 停止指令" + toy.getAddress();
                rq1.d.r(toy.getAddress());
            } else {
                rq1.d.q();
            }
        }
    }
}

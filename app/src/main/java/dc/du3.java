package dc;

import android.os.Handler;
import android.os.Looper;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.wear.bean.Toy;
import com.wear.bean.ToyBean;
import com.wear.bean.ToyFuncOrderPacket;
import com.wear.bean.ToyMacOrderPacket;
import com.wear.bean.User;
import com.wear.bean.socketio.controlLink.request.ToyCommandBean;
import com.wear.protocol.EntityToy;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* compiled from: PolymerizationInstructionsPool.java */
/* loaded from: classes4.dex */
public class du3 {
    public static du3 i;
    public User c;
    public EntityToy e;
    public Runnable g;
    public Disposable h;
    public List<EntityToy> a = new ArrayList();
    public List<Toy> b = new ArrayList();
    public Handler d = new Handler(Looper.getMainLooper());
    public boolean f = false;

    /* compiled from: PolymerizationInstructionsPool.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (du3.this.a.size() > 0) {
                du3.this.f = true;
                du3 du3Var = du3.this;
                du3Var.v(du3Var.e);
            }
            du3.this.d.postDelayed(this, 500L);
        }
    }

    public du3() {
        a aVar = new a();
        this.g = aVar;
        aVar.run();
    }

    public static du3 e() {
        if (i == null) {
            synchronized (du3.class) {
                if (i == null) {
                    i = new du3();
                }
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(List list, Long l) throws Exception {
        List list2;
        if (!list.isEmpty() && (list2 = (List) list.remove(0)) != null && !list2.isEmpty()) {
            for (Object obj : list2) {
                if (obj instanceof ToyCommandBean) {
                    ou3.k((ToyCommandBean) obj, false);
                } else if (obj instanceof EntityToy) {
                    ou3.l((EntityToy) obj, false);
                }
            }
        }
        if (list.isEmpty()) {
            this.h.dispose();
        }
    }

    public static Map<String, Object> k(Object obj) {
        HashMap map = new HashMap();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                map.put(field.getName(), field.get(obj));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public Map<String, Object> f(List<String> list, List<Integer> list2) {
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < list.size(); i2++) {
            map.put(list.get(i2), list2.get(i2));
        }
        return map;
    }

    public ToyFuncOrderPacket.ToySingleFuncOrder i(EntityToy entityToy) {
        ToyFuncOrderPacket.ToySingleFuncOrder toySingleFuncOrder = new ToyFuncOrderPacket.ToySingleFuncOrder();
        if (entityToy.getToyOPTType() == EntityToy.ToyOPTType.all) {
            ToyBean all = entityToy.getAll();
            ArrayList arrayList = new ArrayList();
            Map<String, Object> mapK = k(all);
            for (String str : mapK.keySet()) {
                String string = mapK.get(str).toString();
                HashMap map = new HashMap();
                if (!string.equals("-1")) {
                    map.put("f", str);
                    map.put("lv", string);
                    arrayList.add(map);
                }
            }
            toySingleFuncOrder.setFuncLevels(arrayList);
        }
        return toySingleFuncOrder;
    }

    public ToyMacOrderPacket.ToyMultiMacOrder j(EntityToy entityToy) throws NumberFormatException {
        ToyMacOrderPacket.ToyMultiMacOrder toyMultiMacOrder = new ToyMacOrderPacket.ToyMultiMacOrder();
        ArrayList arrayList = new ArrayList();
        if (entityToy.getToyOPTType() == EntityToy.ToyOPTType.id) {
            HashMap<String, ToyBean> id = entityToy.getId();
            Set<String> setKeySet = id.keySet();
            setKeySet.iterator();
            ArrayList arrayList2 = new ArrayList(setKeySet);
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                ToyMacOrderPacket.ToySingleMacOrder toySingleMacOrder = new ToyMacOrderPacket.ToySingleMacOrder();
                toySingleMacOrder.setToymac((String) arrayList2.get(i2));
                Map<String, Object> mapK = k(id.get(arrayList2.get(i2)));
                ArrayList arrayList3 = new ArrayList();
                for (String str : mapK.keySet()) {
                    HashMap map = new HashMap();
                    int i3 = Integer.parseInt(mapK.get(str).toString());
                    if (i3 != -1) {
                        map.put("f", str);
                        map.put("lv", Integer.valueOf(i3));
                        if (!str.equals("time")) {
                            arrayList3.add(map);
                        }
                        toySingleMacOrder.setFuncLevels(arrayList3);
                    }
                }
                arrayList.add(toySingleMacOrder);
            }
        }
        toyMultiMacOrder.setOrder(arrayList);
        return toyMultiMacOrder;
    }

    public List<List<String>> l(String str) {
        User user;
        List<List<String>> arrayList = new ArrayList<>();
        if (str == null || (user = this.c) == null) {
            return arrayList;
        }
        if (this.b == null) {
            this.b = user.getCLLinkedToys2();
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            if (this.b.get(i2).getDeviceId().equals(str)) {
                if (this.b.get(i2).getToyConfigDataBean() == null) {
                    this.b = this.c.getCLLinkedToys2();
                }
                try {
                    arrayList = this.b.get(i2).getToyConfigDataBean().getMotors();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public void m(ToyCommandBean toyCommandBean) {
        if (toyCommandBean != null) {
            EntityToy entityToy = new EntityToy();
            entityToy.setCate(toyCommandBean.getCate());
            entityToy.setVersion(toyCommandBean.getVersion());
            entityToy.setLineType(1);
            if (toyCommandBean.getMac() != null) {
                entityToy.setMac(toyCommandBean.getMac());
                q(entityToy);
            } else if (toyCommandBean.getFunc() != null) {
                entityToy.setFunc(toyCommandBean.getFunc());
                o(entityToy);
            }
        }
    }

    public void n(EntityToy entityToy) {
        if (entityToy != null) {
            if (entityToy.getMac() != null) {
                q(entityToy);
            } else if (entityToy.getFunc() != null) {
                o(entityToy);
            }
        }
    }

    public void o(EntityToy entityToy) {
        if (entityToy != null) {
            List<ToyFuncOrderPacket.ToySingleFuncOrder> orders = entityToy.getFunc().getOrders();
            List<List<Object>> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < orders.size(); i2++) {
                List<Map<String, Object>> funcLevels = orders.get(i2).getFuncLevels();
                List<String> arrayList2 = new ArrayList<>();
                List<Integer> arrayList3 = new ArrayList<>();
                Map<String, Object> mapK = k(new ToyBean());
                List<Object> arrayList4 = new ArrayList<>();
                arrayList.add(arrayList4);
                for (int i3 = 0; i3 < funcLevels.size(); i3++) {
                    Map<String, Object> map = funcLevels.get(i3);
                    Iterator<String> it = map.keySet().iterator();
                    while (it.hasNext()) {
                        String string = it.next().toString();
                        if (string.equals("f")) {
                            arrayList2.add(map.get(string).toString());
                        } else if (string.equals("lv")) {
                            arrayList3.add(Integer.valueOf((int) Double.parseDouble(map.get(string).toString())));
                        }
                    }
                }
                mapK.putAll(f(arrayList2, arrayList3));
                ToyBean toyBean = (ToyBean) new Gson().fromJson(new Gson().toJson(mapK), ToyBean.class);
                if (toyBean != null) {
                    int t = toyBean.getT();
                    if (entityToy.getVersion() == 0) {
                        t = toyBean.getV();
                    }
                    int i4 = t;
                    int s = toyBean.getS();
                    if (entityToy.getVersion() < 2) {
                        s = toyBean.getV();
                    }
                    int i5 = s;
                    if (toyBean.getV() == -1 && toyBean.getV1() != -1) {
                        toyBean.setV(toyBean.getV1());
                    }
                    na2.m().s(toyBean.getV(), toyBean.getR(), toyBean.getP(), i4, i5, toyBean.getF(), toyBean.getD(), toyBean.getPos());
                }
                if (entityToy.getLineType() == 1) {
                    ToyCommandBean toyCommandBean = new ToyCommandBean();
                    toyCommandBean.setCate(EntityToy.ToyOPTType.all.name());
                    toyCommandBean.setAll(toyBean);
                    toyCommandBean.setVersion(4);
                    arrayList4.add(toyCommandBean);
                } else {
                    EntityToy entityToy2 = new EntityToy();
                    entityToy2.setCate(EntityToy.ToyOPTType.all.name());
                    entityToy2.setAll(toyBean);
                    entityToy2.setVersion(4);
                    arrayList4.add(entityToy2);
                }
            }
            r(arrayList);
        }
    }

    public ToyBean p(EntityToy entityToy) {
        ToyBean toyBean = new ToyBean();
        if (entityToy != null) {
            List<ToyFuncOrderPacket.ToySingleFuncOrder> orders = entityToy.getFunc().getOrders();
            if (orders.size() > 0) {
                List<Map<String, Object>> funcLevels = orders.get(0).getFuncLevels();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Map<String, Object> mapK = k(new ToyBean());
                for (int i2 = 0; i2 < funcLevels.size(); i2++) {
                    Map<String, Object> map = funcLevels.get(i2);
                    Iterator<String> it = map.keySet().iterator();
                    while (it.hasNext()) {
                        String string = it.next().toString();
                        if (string.equals("f")) {
                            arrayList.add(map.get(string).toString());
                        } else if (string.equals("lv")) {
                            arrayList2.add(Integer.valueOf((int) Double.parseDouble(map.get(string).toString())));
                        }
                    }
                }
                mapK.putAll(f(arrayList, arrayList2));
                return (ToyBean) new Gson().fromJson(new Gson().toJson(mapK), ToyBean.class);
            }
        }
        return toyBean;
    }

    public void q(EntityToy entityToy) {
        ArrayList arrayList;
        if (entityToy != null) {
            List<ToyMacOrderPacket.ToyMultiMacOrder> orders = entityToy.getMac().getOrders();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < orders.size(); i2++) {
                List<ToyMacOrderPacket.ToySingleMacOrder> order = orders.get(i2).getOrder();
                ArrayList arrayList3 = new ArrayList();
                arrayList2.add(arrayList3);
                int i3 = 0;
                while (i3 < order.size()) {
                    HashMap<String, ToyBean> map = new HashMap<>();
                    String toymac = order.get(i3).getToymac();
                    List<Map<String, Object>> funcLevels = order.get(i3).getFuncLevels();
                    new ToyBean();
                    ToyBean toyBean = new ToyBean();
                    toyBean.setAll(-1);
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    Map<String, Object> mapK = k(toyBean);
                    for (int i4 = 0; i4 < funcLevels.size(); i4++) {
                        Map<String, Object> map2 = funcLevels.get(i4);
                        Iterator<String> it = map2.keySet().iterator();
                        while (it.hasNext()) {
                            String string = it.next().toString();
                            List<ToyMacOrderPacket.ToyMultiMacOrder> list = orders;
                            if (string.equals("f")) {
                                arrayList4.add(map2.get(string).toString());
                            } else {
                                if (string.equals("lv")) {
                                    String string2 = map2.get(string).toString();
                                    arrayList = arrayList2;
                                    arrayList5.add(Integer.valueOf((int) Double.parseDouble(string2)));
                                }
                                arrayList2 = arrayList;
                                orders = list;
                            }
                            arrayList = arrayList2;
                            arrayList2 = arrayList;
                            orders = list;
                        }
                    }
                    List<ToyMacOrderPacket.ToyMultiMacOrder> list2 = orders;
                    ArrayList arrayList6 = arrayList2;
                    mapK.putAll(f(arrayList4, arrayList5));
                    map.put(toymac, (ToyBean) new Gson().fromJson(new Gson().toJson(mapK), ToyBean.class));
                    if (entityToy.getLineType() == 1) {
                        ToyCommandBean toyCommandBean = new ToyCommandBean();
                        toyCommandBean.setCate(EntityToy.ToyOPTType.id.name());
                        toyCommandBean.setId(map);
                        toyCommandBean.setVersion(4);
                        arrayList3.add(toyCommandBean);
                    } else {
                        EntityToy entityToy2 = new EntityToy();
                        entityToy2.setCate(EntityToy.ToyOPTType.id.name());
                        entityToy2.setId(map);
                        entityToy2.setVersion(4);
                        arrayList3.add(entityToy2);
                    }
                    i3++;
                    arrayList2 = arrayList6;
                    orders = list2;
                }
            }
            r(arrayList2);
        }
    }

    public final void r(final List<List<Object>> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        t();
        this.h = Observable.interval(0L, 100L, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).subscribe(new Consumer() { // from class: dc.qt3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.a.h(list, (Long) obj);
            }
        });
    }

    public void s(EntityToy entityToy) {
        ToyMacOrderPacket toyMacOrderPacket = new ToyMacOrderPacket();
        ToyFuncOrderPacket toyFuncOrderPacket = new ToyFuncOrderPacket();
        ArrayList arrayList = new ArrayList();
        toyMacOrderPacket.setOrders(new ArrayList());
        ArrayList arrayList2 = new ArrayList();
        toyMacOrderPacket.setOrders(new ArrayList());
        EntityToy entityToy2 = new EntityToy();
        int i2 = 0;
        if (entityToy.getToyOPTType() == EntityToy.ToyOPTType.id) {
            while (i2 < this.a.size()) {
                arrayList.add(j(this.a.get(i2)));
                i2++;
            }
            toyMacOrderPacket.setOrders(arrayList);
            entityToy2.setMac(toyMacOrderPacket);
            entityToy2.setCate(EntityToy.ToyOPTType.id.name());
        } else {
            while (i2 < this.a.size()) {
                arrayList2.add(i(this.a.get(i2)));
                i2++;
            }
            toyFuncOrderPacket.setOrders(arrayList2);
            entityToy2.setFunc(toyFuncOrderPacket);
            entityToy2.setCate(EntityToy.ToyOPTType.all.name());
        }
        xe3.a("Live", "聚合指令发送的玩具震动信息：" + JSON.toJSONString(entityToy2));
        if (!zb2.O().I0(entityToy2, this.c.getId())) {
            zb2.O().z0(this.c.getUserJid(), entityToy2);
        }
        this.a.clear();
    }

    public void t() {
        Disposable disposable = this.h;
        if (disposable == null || disposable.isDisposed()) {
            return;
        }
        this.h.dispose();
    }

    public void u(User user) {
        this.c = user;
        EntityToy entityToy = new EntityToy();
        HashMap<String, ToyBean> map = new HashMap<>();
        for (int i2 = 0; i2 < user.getCLLinkedToys2().size(); i2++) {
            map.put(user.getCLLinkedToys2().get(i2).getAddress(), y(l(user.getCLLinkedToys2().get(i2).getDeviceId())));
        }
        entityToy.setId(map);
        entityToy.setCate(EntityToy.ToyOPTType.id.name());
        for (int i3 = 0; i3 < 5; i3++) {
            v(entityToy);
        }
    }

    public synchronized void v(EntityToy entityToy) {
        xe3.a("Live", "指令聚合发送的玩具震动信息：" + JSON.toJSONString(entityToy));
        this.a.add(entityToy);
        if (this.a.size() == 5) {
            s(entityToy);
        } else {
            this.e = entityToy;
            if (this.f) {
                this.a.remove(r0.size() - 1);
                this.f = false;
                s(entityToy);
            }
        }
    }

    public void w(EntityToy entityToy, User user) {
        this.c = user;
        v(entityToy);
    }

    public synchronized void x(List<Toy> list) {
        if (list != null) {
            this.b.clear();
            this.b.addAll(list);
        }
    }

    public ToyBean y(List<List<String>> list) {
        ToyBean toyBean = new ToyBean();
        toyBean.setAll(-1);
        Map<String, Object> mapK = k(toyBean);
        for (String str : mapK.keySet()) {
            if (str != null && list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (list.get(i2).contains(str)) {
                        mapK.put(str, 0);
                    }
                }
            }
        }
        return (ToyBean) new Gson().fromJson(new Gson().toJson(mapK), ToyBean.class);
    }
}

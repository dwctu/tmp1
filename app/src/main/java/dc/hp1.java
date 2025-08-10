package dc;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.huawei.hms.framework.common.ContainerUtils;
import com.lovense.wear.R;
import com.wear.bean.BackWork;
import com.wear.dao.DaoUtils;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: WorkAction.java */
/* loaded from: classes3.dex */
public class hp1 {

    /* compiled from: WorkAction.java */
    public class a implements zn2<String> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;

        public a(String str, String str2, String str3, boolean z) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = z;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            if (WearUtils.e1(str)) {
                return;
            }
            NormalResponse normalResponse = (NormalResponse) new Gson().fromJson(str, NormalResponse.class);
            if (normalResponse == null || !normalResponse.isResult()) {
                if (this.d) {
                    sg3.h(R.string.patterns_result_update_name_failed);
                    return;
                }
                return;
            }
            if (!WearUtils.y1(this.a)) {
                WearUtils.x.i.F(WearUtils.j0(this.b), 0);
                if (WearUtils.k1(this.b)) {
                    WearUtils.x.i.B(false, WearUtils.j0(this.b));
                }
            } else if (normalResponse.getData() != null) {
                WearUtils.x.i.F(WearUtils.j0(this.b), 1);
                if (WearUtils.k1(this.b)) {
                    WearUtils.x.i.B(true, WearUtils.j0(this.b));
                }
            }
            DaoUtils.getBackWorkDao().delete(ExifInterface.GPS_MEASUREMENT_3D, this.c);
            if (this.d) {
                return;
            }
            fp1.d(null);
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            if (this.d) {
                sg3.l(netException.getMessage());
            }
        }
    }

    /* compiled from: WorkAction.java */
    public class b implements zn2<String> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;

        public b(String str, String str2, String str3, boolean z) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = z;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            if (WearUtils.e1(str)) {
                return;
            }
            NormalResponse normalResponse = (NormalResponse) new Gson().fromJson(str, NormalResponse.class);
            if (normalResponse == null || !normalResponse.isResult()) {
                if (this.d) {
                    sg3.h(R.string.patterns_result_update_name_failed);
                    return;
                }
                return;
            }
            if (!WearUtils.y1(this.a)) {
                WearUtils.x.i.E(WearUtils.i0(this.b), 0L);
            } else if (normalResponse.getData() != null && WearUtils.q1(normalResponse.getData().toString().trim())) {
                WearUtils.x.i.E(WearUtils.i0(this.b), Long.valueOf(normalResponse.getData().toString().trim()).longValue());
            }
            DaoUtils.getBackWorkDao().delete("1", this.c);
            if (this.d) {
                return;
            }
            fp1.d(null);
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            if (this.d) {
                sg3.l(netException.getMessage());
            }
        }
    }

    /* compiled from: WorkAction.java */
    public class c implements zn2<String> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ d e;

        public c(String str, String str2, String str3, boolean z, d dVar) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = z;
            this.e = dVar;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            if (WearUtils.e1(str)) {
                return;
            }
            NormalResponse normalResponse = (NormalResponse) new Gson().fromJson(str, NormalResponse.class);
            if (normalResponse == null || !normalResponse.isResult()) {
                if (this.d) {
                    sg3.h(R.string.patterns_result_update_name_failed);
                    return;
                }
                return;
            }
            WearUtils.x.i.c(WearUtils.j0(this.a), this.b);
            DaoUtils.getBackWorkDao().delete("2", this.c);
            if (!this.d) {
                fp1.d(null);
            }
            d dVar = this.e;
            if (dVar != null) {
                dVar.a();
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            if (this.d) {
                sg3.l(netException.getMessage());
            }
        }
    }

    /* compiled from: WorkAction.java */
    public interface d {
        void a();
    }

    public static void a(String str, Map<String, String> map, boolean z, d dVar, String str2) {
        if (WearUtils.x == null || WearUtils.y.u() == null || map == null) {
            return;
        }
        if (z) {
            BackWork backWork = new BackWork();
            backWork.setWorkId("2");
            backWork.setTargetEmail(str2);
            backWork.setOwner(WearUtils.y.u().getId());
            backWork.setStaticParams(str);
            backWork.setStatus(WearUtils.A.toJson(map));
            DaoUtils.getBackWorkDao().updateOrAddToWork(backWork);
        }
        String str3 = map.get("nickName");
        String str4 = map.get("friendEmail");
        Map<String, Object> map2 = new HashMap<>();
        for (String str5 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            try {
                String[] strArrSplit = str5.split("=");
                if (strArrSplit.length == 2) {
                    map2.put(strArrSplit[0], strArrSplit[1]);
                } else if (strArrSplit.length > 2) {
                    String str6 = strArrSplit[0];
                    String str7 = strArrSplit[1];
                    for (int i = 2; i < strArrSplit.length; i++) {
                        str7 = "=" + strArrSplit[i];
                    }
                    map2.put(str6, str7.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for (String str8 : map2.keySet()) {
            String str9 = tn2.g;
            String str10 = "updateReMark: key=" + str8 + "   value:" + String.valueOf(map2.get(str8));
        }
        tn2.x(WearUtils.x).l("/api/user/updateRemark", map2, new c(str4, str3, str2, z, dVar));
    }

    public static void b(String str, Map<String, String> map, boolean z, String str2) {
        if (WearUtils.x == null || WearUtils.y.u() == null || map == null) {
            return;
        }
        if (z) {
            BackWork backWork = new BackWork();
            backWork.setWorkId(ExifInterface.GPS_MEASUREMENT_3D);
            backWork.setTargetEmail(str2);
            backWork.setOwner(WearUtils.y.u().getId());
            backWork.setStaticParams(str);
            backWork.setStatus(WearUtils.A.toJson(map));
            DaoUtils.getBackWorkDao().updateOrAddToWork(backWork);
        }
        String str3 = map.get("isChecked");
        String str4 = map.get("friendEmail");
        HashMap map2 = new HashMap();
        for (String str5 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            try {
                String[] strArrSplit = str5.split("=");
                if (strArrSplit.length == 2) {
                    map2.put(strArrSplit[0], strArrSplit[1]);
                } else if (strArrSplit.length > 2) {
                    String str6 = strArrSplit[0];
                    String str7 = strArrSplit[1];
                    for (int i = 2; i < strArrSplit.length; i++) {
                        str7 = "=" + strArrSplit[i];
                    }
                    map2.put(str6, str7.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        tn2.x(WearUtils.x).l("/api/user/messageMute", map2, new a(str3, str4, str2, z));
    }

    public static void c(String str, Map<String, String> map, boolean z, String str2) {
        if (WearUtils.x == null || WearUtils.y.u() == null || map == null) {
            return;
        }
        if (z) {
            BackWork backWork = new BackWork();
            backWork.setWorkId("1");
            backWork.setTargetEmail(str2);
            backWork.setOwner(WearUtils.y.u().getId());
            backWork.setStaticParams(str);
            backWork.setStatus(WearUtils.A.toJson(map));
            DaoUtils.getBackWorkDao().updateOrAddToWork(backWork);
        }
        String str3 = map.get("isChecked");
        String str4 = map.get("friendEmail");
        HashMap map2 = new HashMap();
        for (String str5 : str.split(ContainerUtils.FIELD_DELIMITER)) {
            try {
                String[] strArrSplit = str5.split("=");
                if (strArrSplit.length == 2) {
                    map2.put(strArrSplit[0], strArrSplit[1]);
                } else if (strArrSplit.length > 2) {
                    String str6 = strArrSplit[0];
                    String str7 = strArrSplit[1];
                    for (int i = 2; i < strArrSplit.length; i++) {
                        str7 = "=" + strArrSplit[i];
                    }
                    map2.put(str6, str7.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        tn2.x(WearUtils.x).l("/api/user/updateSetTop", map2, new b(str3, str4, str2, z));
    }
}

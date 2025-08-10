package dc;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lovense.wear.R;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.bean.socketio.controlLink.request.DisableControlLinkRequest;
import com.wear.bean.socketio.controlLink.request.ReactivateControlLinkRequest;
import com.wear.bean.socketio.controlLink.request.SaveControlLinkRequest;
import com.wear.bean.socketio.controlLink.response.ControlLinkAwaken;
import com.wear.bean.socketio.controlLink.response.ControlLinkCheckStatusResponse;
import com.wear.bean.socketio.controlLink.response.ControlLinkListResponse;
import com.wear.bean.socketio.controlLink.response.ReactivateControlLinkResponse;
import com.wear.bean.socketio.controlLink.response.SaveControlLinkResponse;
import com.wear.network.presenter.bean.BaseResponseBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.is3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ControlLinkSingle.java */
/* loaded from: classes3.dex */
public class l22 {
    public static l22 l;
    public j c;
    public k d;
    public i e;
    public boolean a = false;
    public final List<ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO> b = new ArrayList();
    public int f = 1;
    public boolean g = true;
    public String h = TtmlNode.COMBINE_ALL;
    public String i = "";
    public int j = 0;
    public boolean k = false;

    /* compiled from: ControlLinkSingle.java */
    public class a implements yn2<ControlLinkListResponse> {
        public a() {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(ControlLinkListResponse controlLinkListResponse) {
            if (!controlLinkListResponse.getResult().booleanValue() || controlLinkListResponse.getCode().intValue() != 200) {
                sg3.l(controlLinkListResponse.getMessage());
                return;
            }
            if (controlLinkListResponse.getData() != null) {
                l22.this.g = controlLinkListResponse.getData().getHasNextPage().booleanValue();
                l22.this.f = controlLinkListResponse.getData().getPageNo();
                if (l22.this.f == 1) {
                    l22.this.b.clear();
                    l22.this.b.addAll(controlLinkListResponse.getData().getLongTimeControlLinkList());
                } else {
                    l22.this.b.addAll(controlLinkListResponse.getData().getLongTimeControlLinkList());
                }
                j jVar = l22.this.c;
                if (jVar != null) {
                    jVar.R();
                }
                k kVar = l22.this.d;
                if (kVar != null) {
                    kVar.j();
                }
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            if (bu1.b()) {
                return;
            }
            sg3.l(netException.getMessage());
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: ControlLinkSingle.java */
    public class b implements yn2<ReactivateControlLinkResponse> {
        public b() {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(ReactivateControlLinkResponse reactivateControlLinkResponse) {
            if (reactivateControlLinkResponse.getResult().booleanValue() && reactivateControlLinkResponse.getCode().equals(200)) {
                l22.this.s(true, true);
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            sg3.l(netException.getMessage());
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: ControlLinkSingle.java */
    public class c implements yn2<BaseResponseBeanNew<String>> {
        public c() {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew<String> baseResponseBeanNew) {
            if (baseResponseBeanNew.result) {
                l22.this.s(true, true);
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            sg3.l(netException.getMessage());
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: ControlLinkSingle.java */
    public class d implements yn2<BaseResponseBean> {
        public d() {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBean baseResponseBean) {
            c83.R1().D1();
            l22.this.s(false, true);
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            sg3.h(R.string.control_link_end_failed);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: ControlLinkSingle.java */
    public class e implements yn2<SaveControlLinkResponse> {
        public final /* synthetic */ StringBuilder a;

        public e(StringBuilder sb) {
            this.a = sb;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(SaveControlLinkResponse saveControlLinkResponse) {
            if (saveControlLinkResponse.getResult().booleanValue() && saveControlLinkResponse.getCode().intValue() == 200) {
                SaveControlLinkResponse.InnerData data = saveControlLinkResponse.getData();
                if (!TextUtils.isEmpty(data.getLongTimeControlLinkUrl())) {
                    this.a.append(data.getLongTimeControlLinkUrl());
                    WearUtils.p(this.a.toString(), WearUtils.x);
                    sg3.h(R.string.system_copy_success);
                    l22 l22Var = l22.this;
                    l22Var.a = false;
                    l22Var.s(true, true);
                }
            }
            if (saveControlLinkResponse.getResult().booleanValue() || saveControlLinkResponse.getCode().intValue() != 40010) {
                return;
            }
            sg3.l(saveControlLinkResponse.getMessage());
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            sg3.l(netException.message);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: ControlLinkSingle.java */
    public class f implements yn2<BaseResponseBeanNew> {
        public f() {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(BaseResponseBeanNew baseResponseBeanNew) {
            if (baseResponseBeanNew.result && baseResponseBeanNew.code == 0) {
                c83.R1().y2(true);
                l22.this.s(true, true);
                l22.this.a = true;
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            sg3.l(netException.message);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: ControlLinkSingle.java */
    public class g implements yn2<ControlLinkCheckStatusResponse> {
        public final /* synthetic */ ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO a;

        /* compiled from: ControlLinkSingle.java */
        public class a implements is3.d {
            public a() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                l22.n().v(g.this.a);
            }
        }

        public g(l22 l22Var, ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO) {
            this.a = longTimeControlLinkListDTO;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(ControlLinkCheckStatusResponse controlLinkCheckStatusResponse) {
            if (!controlLinkCheckStatusResponse.getResult().booleanValue() || controlLinkCheckStatusResponse.getCode().intValue() != 200) {
                if (controlLinkCheckStatusResponse.getCode().intValue() == 50022) {
                    sg3.l(ah4.e(R.string.control_link_end_failed));
                }
            } else if (controlLinkCheckStatusResponse.getData() != null) {
                if (controlLinkCheckStatusResponse.getData().getAllReallyExpired().booleanValue()) {
                    l22.n().v(this.a);
                } else {
                    cs3.c(WearUtils.x, ah4.e(R.string.link_end_control_notice), ah4.e(R.string.common_generate), ah4.e(R.string.common_cancel), new a()).show();
                }
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            sg3.l(netException.getMessage());
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: ControlLinkSingle.java */
    public class h implements yn2<ControlLinkAwaken> {
        public final /* synthetic */ boolean a;

        public h(boolean z) {
            this.a = z;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(ControlLinkAwaken controlLinkAwaken) {
            l22.this.k = false;
            if (!controlLinkAwaken.getResult().booleanValue() || controlLinkAwaken.getData() == null) {
                return;
            }
            if (!TextUtils.isEmpty(controlLinkAwaken.getData().getLinkId())) {
                l22.this.i = controlLinkAwaken.getData().getLinkId();
            }
            ControlLinkAwaken.Awaken awaken = new ControlLinkAwaken.Awaken();
            if (TextUtils.isEmpty(l22.this.i)) {
                return;
            }
            awaken.setLinkId(l22.this.i);
            if (na2.m().i()) {
                awaken.setIsConflict(Boolean.TRUE);
                awaken.setResult(false);
            } else {
                awaken.setResult(true);
            }
            if (l22.this.e != null) {
                HashMap map = new HashMap();
                map.put("elementContent", this.a ? "2" : "1");
                map.put("linkId", l22.this.i);
                l22.this.e.p0(awaken, map);
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            l22.this.k = false;
            if (!l22.this.q(netException.code)) {
                sg3.l(netException.message);
                return;
            }
            ControlLinkAwaken.Awaken awaken = new ControlLinkAwaken.Awaken();
            awaken.setLinkId(l22.this.i);
            awaken.setErrorCode(netException.code);
            awaken.setIsConflict(Boolean.FALSE);
            awaken.setResult(false);
            if (TextUtils.equals(netException.code, "5009106")) {
                sg3.l(ah4.e(R.string.cant_open_own_link));
            }
            if (l22.this.e != null) {
                HashMap map = new HashMap();
                map.put("elementContent", this.a ? "2" : "1");
                map.put("linkId", l22.this.i);
                l22.this.e.p0(awaken, map);
            }
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: ControlLinkSingle.java */
    public interface i {
        void p0(ControlLinkAwaken.Awaken awaken, Map<String, String> map);
    }

    /* compiled from: ControlLinkSingle.java */
    public interface j {
        void R();
    }

    /* compiled from: ControlLinkSingle.java */
    public interface k {
        void j();
    }

    public static l22 n() {
        if (l == null) {
            synchronized (l22.class) {
                if (l == null) {
                    l = new l22();
                }
            }
        }
        return l;
    }

    public static boolean p(String str) {
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains("com/t2/");
    }

    public void A(int i2) {
        this.f = i2;
    }

    public void f(String str, boolean z) {
        HashMap map = new HashMap();
        map.put("shortCode", str);
        if (this.k) {
            return;
        }
        this.k = true;
        tn2.x(WearUtils.x).h("/api/remote/controllink/awaken", WearUtils.A.toJson(map), new h(z));
    }

    public void g(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO) {
        tn2.x(WearUtils.x).h("/app/long_time_control_link/checkStatus", "", new g(this, longTimeControlLinkListDTO));
    }

    public void h() {
        tn2.x(WearUtils.x).h("/app/long_time_control_link/deleteAll", "", new f());
    }

    public void i(String str) {
        tn2.x(WearUtils.x).h("/app/long_time_control_link/disable", ro2.c(new DisableControlLinkRequest(str)), new c());
    }

    public void j(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO) {
        HashMap map = new HashMap();
        map.put("longTimeControlLinkId", longTimeControlLinkListDTO.getLongTimeControlLinkId());
        tn2.x(WearUtils.x).h("app/long_time_control_link/end", WearUtils.A.toJson(map), new d());
    }

    public List<ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO> k() {
        return this.b;
    }

    public int l() {
        return this.j;
    }

    public ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO m() {
        if (this.b.size() == 0) {
            return null;
        }
        return this.b.get(0);
    }

    public int o() {
        return this.f;
    }

    public boolean q(String str) {
        return TextUtils.equals(str, "5009101") || TextUtils.equals(str, "5009102") || TextUtils.equals(str, "5009103") || TextUtils.equals(str, "5009104") || TextUtils.equals(str, "5009105") || TextUtils.equals(str, "5009106");
    }

    public boolean r() {
        return this.g;
    }

    public void s(boolean z, boolean z2) {
        if (MyApplication.O) {
            if (!this.a || z) {
                String str = "?pageSize=20&pageNo=" + (z2 ? 1 : 1 + o()) + "&linkStatus=" + this.h;
                tn2.x(WearUtils.x).d("/app/long_time_control_link/list" + str, new a());
            }
        }
    }

    public void t(boolean z) {
        s(z, false);
    }

    public void u(String str) {
        tn2.x(WearUtils.x).h("/app/long_time_control_link/reactive", ro2.c(new ReactivateControlLinkRequest(str)), new b());
    }

    public void v(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO) {
        List<ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ToysDTO> toys = longTimeControlLinkListDTO.getToys();
        long[] jArrK = be3.K(longTimeControlLinkListDTO.getDuration());
        String strZ = be3.z((int) jArrK[0], (int) jArrK[1], (int) jArrK[2]);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(longTimeControlLinkListDTO.getDescription())) {
            sb.append(longTimeControlLinkListDTO.getDescription());
            sb.append(" ");
        }
        if (toys.size() > 1) {
            sb.append("[");
            sb.append(toys.get(0).getToyName());
            sb.append(", ");
            sb.append(toys.get(1).getToyName());
            sb.append("] ");
        } else {
            sb.append("[");
            sb.append(toys.get(0).getToyName());
            sb.append("] ");
        }
        if (longTimeControlLinkListDTO.getHashTags() != null && longTimeControlLinkListDTO.getHashTags().size() > 0) {
            for (String str : longTimeControlLinkListDTO.getHashTags()) {
                sb.append("[");
                sb.append(str);
                sb.append("]");
            }
        }
        sb.append(" [");
        sb.append(strZ);
        sb.append("] ");
        ArrayList arrayList = new ArrayList();
        for (ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ToysDTO toysDTO : toys) {
            SaveControlLinkRequest.ToysDTO toysDTO2 = new SaveControlLinkRequest.ToysDTO();
            toysDTO2.setToyId(toysDTO.getToyId());
            toysDTO2.setToyType(toysDTO.getToyType());
            toysDTO2.setToyVersion(toysDTO.getToyVersion());
            toysDTO2.setSymbol(toysDTO.getSymbol());
            toysDTO2.setToyName(toysDTO.getToyName());
            arrayList.add(toysDTO2);
        }
        SaveControlLinkRequest saveControlLinkRequest = new SaveControlLinkRequest();
        saveControlLinkRequest.setHashTags(longTimeControlLinkListDTO.getHashTags());
        saveControlLinkRequest.setDescription(longTimeControlLinkListDTO.getDescription());
        saveControlLinkRequest.setDuration(Integer.valueOf(longTimeControlLinkListDTO.getDuration()));
        saveControlLinkRequest.setRepeat(longTimeControlLinkListDTO.getRepeat());
        saveControlLinkRequest.setShareTophy(longTimeControlLinkListDTO.isShareTophy());
        saveControlLinkRequest.setToys(arrayList);
        saveControlLinkRequest.setAllowReqToCreator(longTimeControlLinkListDTO.isAllowReqToCreator());
        saveControlLinkRequest.setAllowReqToJoiner(longTimeControlLinkListDTO.isAllowReqToJoiner());
        saveControlLinkRequest.setOpenControlPermission(longTimeControlLinkListDTO.isOpenControlPermission());
        tn2.x(WearUtils.x).h("/app/long_time_control_link/save", WearUtils.A.toJson(saveControlLinkRequest), new e(sb));
    }

    public void w(i iVar) {
        this.e = iVar;
    }

    public void x(j jVar) {
        this.c = jVar;
    }

    public void y(int i2) {
        this.j = i2;
    }

    public void z(k kVar) {
        this.d = kVar;
    }
}

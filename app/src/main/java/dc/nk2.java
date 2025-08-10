package dc;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.wear.bean.Toy;
import com.wear.bean.VideoPatternEndType;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.bean.socketio.videoPattern.MPHeartbeatRequest;
import com.wear.bean.socketio.videoPattern.MPHeartbeatResponse;
import com.wear.bean.socketio.videoPattern.MPPlayMediaResponse;
import com.wear.bean.socketio.videoPattern.MPRemoteGetFileResponse;
import com.wear.bean.socketio.videoPattern.ModifyVideoPatternDTOResponse;
import com.wear.bean.socketio.videoPattern.StartPreviewModeDTOResponse;
import com.wear.bean.socketio.videoPattern.StopWatchVideoStatusDTOResponse;
import com.wear.bean.socketio.videoPattern.VideoProgressStatusDTOResponse;
import com.wear.util.WearUtils;
import java.io.File;
import java.util.ArrayList;

/* compiled from: VideoPatternControlManagerImpl.java */
/* loaded from: classes3.dex */
public class nk2 implements tf2 {
    public static nk2 a;

    public static nk2 b() {
        if (a == null) {
            synchronized (nk2.class) {
                if (a == null) {
                    a = new nk2();
                }
            }
        }
        return a;
    }

    public void a(rf2 rf2Var, mf2 mf2Var) {
        uf2.v().r(rf2Var, mf2Var);
    }

    public void c(rf2 rf2Var) {
        uf2.v().E(rf2Var);
    }

    @Override // dc.tf2
    public void connectSuc() {
        mk2.P().a0();
    }

    public void d() {
    }

    @Override // dc.tf2
    public void disConnect() {
        mk2.P().Z();
    }

    public void e(String str) {
    }

    public void f(BaseResponseBeanNew baseResponseBeanNew) {
        mk2.P().X(baseResponseBeanNew);
    }

    public void g(BaseResponseBeanNew baseResponseBeanNew) {
        mk2.P().c0(baseResponseBeanNew);
    }

    public void h(VideoProgressStatusDTOResponse videoProgressStatusDTOResponse) {
        mk2.P().B0(videoProgressStatusDTOResponse);
    }

    public void i(ModifyVideoPatternDTOResponse modifyVideoPatternDTOResponse) {
        mk2.P().j0(modifyVideoPatternDTOResponse);
    }

    public void j() {
        mk2.P().K0(false, 2);
    }

    public void k(MPHeartbeatResponse mPHeartbeatResponse) {
        if (mk2.P().h0()) {
            MPHeartbeatRequest mPHeartbeatRequest = new MPHeartbeatRequest();
            mPHeartbeatRequest.setAckId(WearUtils.E());
            mPHeartbeatRequest.setColaId(mPHeartbeatResponse.getColaId());
            ArrayList<Toy> arrayListO = pc1.a.o();
            ArrayList arrayList = new ArrayList();
            for (Toy toy : arrayListO) {
                MPHeartbeatRequest.ToyInfo toyInfo = new MPHeartbeatRequest.ToyInfo();
                toyInfo.setToyType(toy.getType());
                toyInfo.setToyVersion(String.valueOf(toy.getToyVersion()));
                toyInfo.setConnect(toy.isConnected());
                arrayList.add(toyInfo);
            }
            mPHeartbeatRequest.setToys(arrayList);
            a(mPHeartbeatRequest, null);
            mk2.P().k0();
        }
    }

    public void l(MPRemoteGetFileResponse mPRemoteGetFileResponse) {
        if (!TextUtils.isEmpty(mPRemoteGetFileResponse.getPatternId())) {
            mk2.P().G(1);
        }
        mk2.P().R(mPRemoteGetFileResponse);
    }

    public void m() {
        mk2.P().K0(false, 2);
    }

    public void n(MPPlayMediaResponse mPPlayMediaResponse) {
        if (mk2.P().h0()) {
            mk2.P().A0(mPPlayMediaResponse);
        }
    }

    public void o(ModifyVideoPatternDTOResponse modifyVideoPatternDTOResponse) {
        mk2.P().M(modifyVideoPatternDTOResponse.getPatternId(), modifyVideoPatternDTOResponse.getPattern(), false, true, "", true);
    }

    public void p(StartPreviewModeDTOResponse startPreviewModeDTOResponse) {
        mk2.P().t0(startPreviewModeDTOResponse.isStatus());
        if (startPreviewModeDTOResponse.isDownload()) {
            File fileP0 = WearUtils.P0(startPreviewModeDTOResponse.getPatternId());
            if (fileP0.exists()) {
                fileP0.delete();
            }
            mk2.P().M(startPreviewModeDTOResponse.getPatternId(), startPreviewModeDTOResponse.getPattern(), true, false, "", true);
        }
    }

    public void q(VideoProgressStatusDTOResponse videoProgressStatusDTOResponse) {
        mk2.P().B0(videoProgressStatusDTOResponse);
    }

    public void r(String str) {
        if (mk2.P().h0()) {
            VideoPatternEndType videoPatternEndType = (VideoPatternEndType) JSON.parseObject(str, VideoPatternEndType.class);
            mk2.P().D0();
            mk2.P().G(videoPatternEndType.getEndType());
        }
    }

    public void s(StopWatchVideoStatusDTOResponse stopWatchVideoStatusDTOResponse) {
        mk2.P().D0();
        mk2.P().G(0);
    }
}

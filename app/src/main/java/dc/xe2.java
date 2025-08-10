package dc;

import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.vending.expansion.downloader.Constants;
import com.wear.bean.Account;
import com.wear.bean.AddPatternInfoBean;
import com.wear.bean.Pattern;
import com.wear.bean.PatternData;
import com.wear.bean.PatternFileUploadBean;
import com.wear.bean.PatternUploadBean;
import com.wear.bean.PlayListUploadBean;
import com.wear.bean.Playlist;
import com.wear.bean.PlaylistItems;
import com.wear.bean.PullPatternInfoBean;
import com.wear.bean.Setting;
import com.wear.bean.SyncResultMsg;
import com.wear.bean.event.NetworkInfoEvent;
import com.wear.bean.event.PatternSyncEndEvent;
import com.wear.bean.handlerbean.IHandlerPattern;
import com.wear.bean.request.EditPatternBean;
import com.wear.bean.response.BaseResponseBeanNew;
import com.wear.dao.DaoUtils;
import com.wear.dao.PatternDao;
import com.wear.dao.PlaylistDao;
import com.wear.dao.PlaylistItemsDao;
import com.wear.dao.SettingDao;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.te2;
import dc.ue2;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;

/* compiled from: PatternManagerImpl.java */
/* loaded from: classes3.dex */
public class xe2 implements ue2, we2, ve2 {
    public static final String r = "xe2";
    public final HandlerThread a;
    public Handler b;
    public final HandlerThread c;
    public Handler d;
    public MyApplication e;
    public boolean f;
    public final Object g;
    public final LinkedHashMap<String, Pattern> h;
    public final List<te2.b> i;
    public final o j;
    public final Handler k;
    public boolean l;
    public boolean m;
    public final LinkedHashMap<String, Playlist> n;
    public final LinkedHashMap<String, PlaylistItems> o;
    public LinkedHashMap<String, te2.a> p;
    public List<Pattern> q;

    /* compiled from: PatternManagerImpl.java */
    public class a implements zn2<String> {
        public final /* synthetic */ SyncResultMsg a;
        public final /* synthetic */ LinkedHashMap b;

        /* compiled from: PatternManagerImpl.java */
        /* renamed from: dc.xe2$a$a, reason: collision with other inner class name */
        public class C0228a extends TypeReference<BaseResponseBeanNew<AddPatternInfoBean>> {
            public C0228a(a aVar, Type... typeArr) {
                super(typeArr);
            }
        }

        public a(SyncResultMsg syncResultMsg, LinkedHashMap linkedHashMap) {
            this.a = syncResultMsg;
            this.b = linkedHashMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            xe2.this.g(xe2.r, "/wear/myPattern/edit\n " + str);
            BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) JSON.parseObject(str, new C0228a(this, AddPatternInfoBean.class), new Feature[0]);
            if (baseResponseBeanNew.code != 0) {
                this.a.result = 1;
                Iterator it = this.b.keySet().iterator();
                while (it.hasNext()) {
                    Pattern pattern = (Pattern) this.b.get((String) it.next());
                    if (pattern != null) {
                        pattern.setSyncStatus(1);
                        pattern.setSyncFialMsg("编辑模式失败code!=0");
                    }
                }
                return;
            }
            for (String str2 : ((AddPatternInfoBean) baseResponseBeanNew.data).patternIdSuc) {
                Pattern pattern2 = (Pattern) this.b.get(str2);
                if (pattern2 != null) {
                    pattern2.setSyncStatus(0);
                    pattern2.setSyncFialMsg("");
                }
            }
            for (String str3 : ((AddPatternInfoBean) baseResponseBeanNew.data).patternIdFail) {
                this.a.result = 1;
                Pattern pattern3 = (Pattern) this.b.get(str3);
                if (pattern3 != null) {
                    pattern3.setSyncStatus(1);
                    pattern3.setSyncFialMsg("编辑模式失败code==0,失败数组里");
                }
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            Iterator it = this.b.keySet().iterator();
            while (it.hasNext()) {
                Pattern pattern = (Pattern) this.b.get((String) it.next());
                if (pattern != null) {
                    pattern.setSyncStatus(1);
                    pattern.setSyncFialMsg("编辑模式失败NetException" + netException.getMessage());
                }
            }
            this.a.result = 1;
        }
    }

    /* compiled from: PatternManagerImpl.java */
    public class b implements ue2.a {
        public b() {
        }

        @Override // dc.ue2.a
        public void a(int i, String str) {
            xe2.this.Z("patternSync_downloadContent_fail");
        }

        @Override // dc.ue2.a
        public void b(File file) {
        }
    }

    /* compiled from: PatternManagerImpl.java */
    public class c implements zn2<String> {
        public final /* synthetic */ SyncResultMsg a;
        public final /* synthetic */ List b;
        public final /* synthetic */ LinkedHashMap c;

        public c(SyncResultMsg syncResultMsg, List list, LinkedHashMap linkedHashMap) {
            this.a = syncResultMsg;
            this.b = list;
            this.c = linkedHashMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            xe2.this.g(xe2.r, "/wear/myPattern/uploadBatchPattern\n " + str);
            PatternFileUploadBean patternFileUploadBean = (PatternFileUploadBean) JSON.parseObject(str, PatternFileUploadBean.class);
            int i = 0;
            if (patternFileUploadBean.code != 0) {
                this.a.result = 1;
                while (i < this.b.size()) {
                    Pattern pattern = (Pattern) this.b.get(i);
                    pattern.setSyncStatus(1);
                    pattern.setSyncFialMsg("文件上传code!=0");
                    i++;
                }
                return;
            }
            while (i < this.b.size()) {
                Pattern pattern2 = (Pattern) this.b.get(i);
                String str2 = ((PatternFileUploadBean.PatternFileUploadItem) patternFileUploadBean.data).patternIdSuc.get(pattern2.getId());
                if (!TextUtils.isEmpty(str2)) {
                    pattern2.setPath(str2);
                    PatternUploadBean patternUploadBeanN1 = xe2.this.N1(pattern2);
                    patternUploadBeanN1.setPath(str2);
                    this.c.put(pattern2.getId(), patternUploadBeanN1);
                    synchronized (xe2.this.g) {
                        DaoUtils.getPatternDao().update((PatternDao) pattern2);
                    }
                } else if (pattern2.neverSync()) {
                    continue;
                } else {
                    this.a.result = 1;
                    pattern2.setSyncStatus(3);
                    pattern2.setSyncFialMsg("文件上传code==0，但是在失败数组里");
                    synchronized (xe2.this.g) {
                        DaoUtils.getPatternDao().update((PatternDao) pattern2);
                    }
                }
                i++;
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            xe2.this.g(xe2.r, "/wear/myPattern/uploadBatchPattern\n " + netException.getMessage());
            for (int i = 0; i < this.b.size(); i++) {
                Pattern pattern = (Pattern) this.b.get(i);
                pattern.setSyncStatus(1);
                pattern.setSyncFialMsg("文件上传NetException" + netException.getMessage());
            }
            this.a.result = 1;
        }
    }

    /* compiled from: PatternManagerImpl.java */
    public class d implements zn2<String> {
        public final /* synthetic */ SyncResultMsg a;
        public final /* synthetic */ LinkedHashMap b;

        /* compiled from: PatternManagerImpl.java */
        public class a extends TypeReference<BaseResponseBeanNew<AddPatternInfoBean>> {
            public a(d dVar, Type... typeArr) {
                super(typeArr);
            }
        }

        public d(SyncResultMsg syncResultMsg, LinkedHashMap linkedHashMap) {
            this.a = syncResultMsg;
            this.b = linkedHashMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            xe2.this.g(xe2.r, "/wear/myPattern/add\n " + str);
            BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) JSON.parseObject(str, new a(this, AddPatternInfoBean.class), new Feature[0]);
            if (baseResponseBeanNew.code != 0) {
                this.a.result = 1;
                Iterator it = this.b.keySet().iterator();
                while (it.hasNext()) {
                    Pattern patternK = xe2.this.K((String) it.next());
                    if (patternK != null) {
                        patternK.setSyncStatus(1);
                        patternK.setSyncFialMsg("信息上传失败code！=0");
                    }
                }
                return;
            }
            synchronized (xe2.this.g) {
                for (String str2 : ((AddPatternInfoBean) baseResponseBeanNew.data).patternIdSuc) {
                    Pattern patternK2 = xe2.this.K(str2);
                    if (patternK2 != null) {
                        patternK2.setSyncStatus(0);
                        patternK2.setSyncFialMsg("");
                        DaoUtils.getPatternDao().update((PatternDao) patternK2);
                    }
                }
            }
            for (String str3 : ((AddPatternInfoBean) baseResponseBeanNew.data).patternIdFail) {
                Pattern patternK3 = xe2.this.K(str3);
                if (patternK3 != null) {
                    patternK3.setSyncStatus(1);
                    patternK3.setSyncFialMsg("信息上传失败code==0，在失败数组里");
                }
                this.a.result = 1;
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            xe2.this.g(xe2.r, "/wear/myPattern/add\n " + netException.getMessage());
            Iterator it = this.b.keySet().iterator();
            while (it.hasNext()) {
                Pattern patternK = xe2.this.K((String) it.next());
                if (patternK != null) {
                    patternK.setSyncStatus(1);
                    patternK.setSyncFialMsg("信息上传失败NetException" + netException.getMessage());
                }
            }
            this.a.result = 1;
        }
    }

    /* compiled from: PatternManagerImpl.java */
    public class e implements zn2<String> {
        public final /* synthetic */ String a;

        public e(String str) {
            this.a = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.zn2
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            boolean z;
            xe2.this.g(xe2.r, str);
            PullPatternInfoBean pullPatternInfoBean = (PullPatternInfoBean) JSON.parseObject(str, PullPatternInfoBean.class);
            List<Pattern> listFindSharePatternsByEmail = DaoUtils.getPatternDao().findSharePatternsByEmail(WearUtils.y.r());
            Iterator<Pattern> it = listFindSharePatternsByEmail.iterator();
            while (true) {
                boolean z2 = true;
                PatternUploadBean patternUploadBean = null;
                if (!it.hasNext()) {
                    break;
                }
                Pattern next = it.next();
                Iterator<PatternUploadBean> it2 = ((PatternData) pullPatternInfoBean.data).myPatternList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z2 = false;
                        break;
                    }
                    PatternUploadBean next2 = it2.next();
                    if (!WearUtils.e1(next.getId()) && !WearUtils.e1(next2.getPatternId()) && next.getId().equals(next2.getPatternId())) {
                        patternUploadBean = next2;
                        break;
                    }
                }
                if (!z2) {
                    xe2.L0().d(next, false);
                    DaoUtils.getMediaPatternDao().delById(next.getId());
                } else if (patternUploadBean.getLastUpdTime() != next.getLastUpdTime()) {
                    patternUploadBean.setLastUpdTime(next.getLastUpdTime());
                    patternUploadBean.setOrderDis(next.getSortId());
                    final Pattern patternP1 = xe2.this.P1(next, patternUploadBean);
                    DaoUtils.getPatternDao().updateOrAdd(patternP1);
                    if (!patternP1.getFile().exists()) {
                        xe2.this.z1(new Runnable() { // from class: dc.yd2
                            @Override // java.lang.Runnable
                            public final void run() throws Throwable {
                                Pattern pattern = patternP1;
                                WearUtils.i2(true, pattern.getId(), pattern.getPath(), "pattern", null);
                            }
                        });
                    }
                }
            }
            for (PatternUploadBean patternUploadBean2 : ((PatternData) pullPatternInfoBean.data).myPatternList) {
                Iterator<Pattern> it3 = listFindSharePatternsByEmail.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z = false;
                        break;
                    }
                    Pattern next3 = it3.next();
                    if (!WearUtils.e1(next3.getId()) && !WearUtils.e1(patternUploadBean2.getPatternId()) && next3.getId().equals(patternUploadBean2.getPatternId())) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    final Pattern patternP12 = xe2.this.P1(null, patternUploadBean2);
                    DaoUtils.getPatternDao().updateOrAdd(patternP12);
                    if (!patternP12.getFile().exists()) {
                        xe2.this.z1(new Runnable() { // from class: dc.xd2
                            @Override // java.lang.Runnable
                            public final void run() throws Throwable {
                                Pattern pattern = patternP12;
                                WearUtils.i2(true, pattern.getId(), pattern.getPath(), "pattern", null);
                            }
                        });
                    }
                }
            }
            xe2.this.N0(this.a);
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            xe2.this.N0(this.a);
        }
    }

    /* compiled from: PatternManagerImpl.java */
    public class f implements zn2<String> {
        public final /* synthetic */ String a;

        public f(String str) {
            this.a = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            xe2 xe2Var = xe2.this;
            String str2 = xe2.r;
            xe2Var.g(str2, str);
            PullPatternInfoBean pullPatternInfoBean = (PullPatternInfoBean) JSON.parseObject(str, PullPatternInfoBean.class);
            int size = ((PatternData) pullPatternInfoBean.data).myPatternList.size();
            int size2 = xe2.this.J0().size();
            try {
                xe2.this.g(str2, "线上pattern个数：" + size);
                xe2.this.g(str2, "线上playPattern个数：" + ((PatternData) pullPatternInfoBean.data).myPlayPatternList.size());
                xe2.this.g(str2, "本地pattern个数：" + size2);
                boolean zN0 = xe2.this.n0((PatternData) pullPatternInfoBean.data);
                xe2.this.g(str2, "同步完成");
                EventBus.getDefault().post(new PatternSyncEndEvent());
                if (zN0) {
                    xe2 xe2Var2 = xe2.this;
                    if (xe2Var2.l) {
                        xe2Var2.Z("patternSync_tipSee_open_success");
                    }
                    xe2 xe2Var3 = xe2.this;
                    xe2Var3.l = false;
                    if (!xe2Var3.m) {
                        xe2Var3.Z("patternSync_firstSync_success");
                        xe2.this.m = true;
                    }
                    xe2.this.Z("patternSync_success");
                    xe2 xe2Var4 = xe2.this;
                    xe2Var4.g0("P0003", size, size2, xe2Var4.P0());
                    xe2.this.M1(this.a);
                    return;
                }
                xe2 xe2Var5 = xe2.this;
                if (xe2Var5.l) {
                    xe2Var5.Z("patternSync_tipSee_open_fail");
                }
                xe2 xe2Var6 = xe2.this;
                xe2Var6.l = false;
                if (!xe2Var6.m) {
                    xe2Var6.Z("patternSync_firstSync_fail");
                    xe2.this.m = true;
                }
                xe2.this.Z("patternSync_fail");
                xe2 xe2Var7 = xe2.this;
                xe2Var7.g0("P0004", size, size2, xe2Var7.P0());
                xe2.this.C0(this.a);
            } catch (Exception e) {
                xe2 xe2Var8 = xe2.this;
                if (xe2Var8.l) {
                    xe2Var8.Z("patternSync_tipSee_open_fail");
                }
                xe2 xe2Var9 = xe2.this;
                xe2Var9.l = false;
                if (!xe2Var9.m) {
                    xe2Var9.Z("patternSync_firstSync_fail");
                    xe2.this.m = true;
                }
                xe2.this.Z("patternSync_fail");
                xe2 xe2Var10 = xe2.this;
                xe2Var10.g0("P0004", size, size2, xe2Var10.P0());
                xe2.this.g(xe2.r, e.getMessage());
                xe2.this.C0(this.a);
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            xe2 xe2Var = xe2.this;
            if (xe2Var.l) {
                xe2Var.Z("patternSync_tipSee_open_fail");
            }
            xe2 xe2Var2 = xe2.this;
            xe2Var2.l = false;
            if (!xe2Var2.m) {
                xe2Var2.Z("patternSync_firstSync_fail");
            }
            xe2 xe2Var3 = xe2.this;
            xe2Var3.m = true;
            xe2Var3.Z("patternSync_fail");
            int size = xe2.this.J0().size();
            xe2 xe2Var4 = xe2.this;
            xe2Var4.g0("P0004", -1, size, xe2Var4.P0());
            xe2.this.C0(this.a);
        }
    }

    /* compiled from: PatternManagerImpl.java */
    public class g implements zn2<String> {
        public final /* synthetic */ SyncResultMsg a;
        public final /* synthetic */ LinkedHashMap b;

        /* compiled from: PatternManagerImpl.java */
        public class a extends TypeReference<BaseResponseBeanNew<AddPatternInfoBean>> {
            public a(g gVar, Type... typeArr) {
                super(typeArr);
            }
        }

        public g(SyncResultMsg syncResultMsg, LinkedHashMap linkedHashMap) {
            this.a = syncResultMsg;
            this.b = linkedHashMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            xe2.this.g(xe2.r, "/wear/playPattern/addPatternItem\n " + str);
            BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) JSON.parseObject(str, new a(this, AddPatternInfoBean.class), new Feature[0]);
            if (baseResponseBeanNew.code != 0) {
                this.a.result = 1;
                Iterator it = this.b.keySet().iterator();
                while (it.hasNext()) {
                    PlaylistItems playlistItems = (PlaylistItems) this.b.get((String) it.next());
                    if (playlistItems != null) {
                        playlistItems.setSyncStatus(1);
                        playlistItems.setSyncFialMsg("信息上传失败code！=0");
                    }
                }
                return;
            }
            for (String str2 : ((AddPatternInfoBean) baseResponseBeanNew.data).patternIdSuc) {
                PlaylistItems playlistItems2 = (PlaylistItems) this.b.get(str2);
                if (playlistItems2 != null) {
                    playlistItems2.setSyncStatus(0);
                    playlistItems2.setSyncFialMsg("");
                }
            }
            for (String str3 : ((AddPatternInfoBean) baseResponseBeanNew.data).patternIdFail) {
                this.a.result = 1;
                PlaylistItems playlistItems3 = (PlaylistItems) this.b.get(str3);
                if (playlistItems3 != null) {
                    playlistItems3.setSyncStatus(1);
                    playlistItems3.setSyncFialMsg("信息上传失败code==0，在失败数组里");
                }
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            Iterator it = this.b.keySet().iterator();
            while (it.hasNext()) {
                PlaylistItems playlistItems = (PlaylistItems) this.b.get((String) it.next());
                if (playlistItems != null) {
                    playlistItems.setSyncStatus(1);
                    playlistItems.setSyncFialMsg("信息上传失败NetException");
                }
            }
            this.a.result = 1;
        }
    }

    /* compiled from: PatternManagerImpl.java */
    public class h implements zn2<String> {
        public final /* synthetic */ SyncResultMsg a;
        public final /* synthetic */ LinkedHashMap b;

        /* compiled from: PatternManagerImpl.java */
        public class a extends TypeReference<BaseResponseBeanNew<AddPatternInfoBean>> {
            public a(h hVar, Type... typeArr) {
                super(typeArr);
            }
        }

        public h(SyncResultMsg syncResultMsg, LinkedHashMap linkedHashMap) {
            this.a = syncResultMsg;
            this.b = linkedHashMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            xe2.this.g(xe2.r, "/wear/playPattern/editItemSort\n " + str);
            BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) JSON.parseObject(str, new a(this, AddPatternInfoBean.class), new Feature[0]);
            if (baseResponseBeanNew.code != 0) {
                this.a.result = 1;
                Iterator it = this.b.keySet().iterator();
                while (it.hasNext()) {
                    PlaylistItems playlistItems = (PlaylistItems) this.b.get((String) it.next());
                    if (playlistItems != null) {
                        playlistItems.setSyncStatus(1);
                        playlistItems.setSyncFialMsg("编辑失败code!=0");
                    }
                }
                return;
            }
            for (String str2 : ((AddPatternInfoBean) baseResponseBeanNew.data).patternIdSuc) {
                PlaylistItems playlistItems2 = (PlaylistItems) this.b.get(str2);
                if (playlistItems2 != null) {
                    playlistItems2.setSyncStatus(0);
                    playlistItems2.setSyncFialMsg("");
                }
            }
            for (String str3 : ((AddPatternInfoBean) baseResponseBeanNew.data).patternIdFail) {
                this.a.result = 1;
                PlaylistItems playlistItems3 = (PlaylistItems) this.b.get(str3);
                if (playlistItems3 != null) {
                    playlistItems3.setSyncStatus(1);
                    playlistItems3.setSyncFialMsg("编辑失败code==0,失败数组");
                }
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            Iterator it = this.b.keySet().iterator();
            while (it.hasNext()) {
                PlaylistItems playlistItems = (PlaylistItems) this.b.get((String) it.next());
                if (playlistItems != null) {
                    playlistItems.setSyncStatus(1);
                    playlistItems.setSyncFialMsg("编辑失败NetException");
                }
            }
            this.a.result = 1;
        }
    }

    /* compiled from: PatternManagerImpl.java */
    public class i implements zn2<String> {
        public final /* synthetic */ SyncResultMsg a;
        public final /* synthetic */ LinkedHashMap b;

        /* compiled from: PatternManagerImpl.java */
        public class a extends TypeReference<BaseResponseBeanNew<AddPatternInfoBean>> {
            public a(i iVar, Type... typeArr) {
                super(typeArr);
            }
        }

        public i(SyncResultMsg syncResultMsg, LinkedHashMap linkedHashMap) {
            this.a = syncResultMsg;
            this.b = linkedHashMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            xe2.this.g(xe2.r, "/wear/playPatternItem/delete\n " + str);
            BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) JSON.parseObject(str, new a(this, AddPatternInfoBean.class), new Feature[0]);
            if (baseResponseBeanNew.code != 0) {
                this.a.result = 1;
                Iterator it = this.b.keySet().iterator();
                while (it.hasNext()) {
                    PlaylistItems playlistItems = (PlaylistItems) this.b.get((String) it.next());
                    if (playlistItems != null) {
                        playlistItems.setSyncStatus(1);
                        playlistItems.setSyncFialMsg("删除失败code！=0");
                    }
                }
                return;
            }
            for (String str2 : ((AddPatternInfoBean) baseResponseBeanNew.data).patternIdSuc) {
                PlaylistItems playlistItems2 = (PlaylistItems) this.b.get(str2);
                if (playlistItems2 != null) {
                    xe2.this.G1(playlistItems2);
                }
            }
            for (String str3 : ((AddPatternInfoBean) baseResponseBeanNew.data).patternIdFail) {
                this.a.result = 1;
                PlaylistItems playlistItems3 = (PlaylistItems) this.b.get(str3);
                if (playlistItems3 != null) {
                    playlistItems3.setSyncStatus(1);
                    playlistItems3.setSyncFialMsg("删除失败code==0，在失败数组里");
                }
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            Iterator it = this.b.keySet().iterator();
            while (it.hasNext()) {
                PlaylistItems playlistItems = (PlaylistItems) this.b.get((String) it.next());
                if (playlistItems != null) {
                    playlistItems.setSyncStatus(1);
                    playlistItems.setSyncFialMsg("删除失败NetException");
                }
            }
            this.a.result = 1;
        }
    }

    /* compiled from: PatternManagerImpl.java */
    public class j implements zn2<String> {
        public final /* synthetic */ SyncResultMsg a;
        public final /* synthetic */ LinkedHashMap b;

        /* compiled from: PatternManagerImpl.java */
        public class a extends TypeReference<BaseResponseBeanNew<AddPatternInfoBean>> {
            public a(j jVar, Type... typeArr) {
                super(typeArr);
            }
        }

        public j(SyncResultMsg syncResultMsg, LinkedHashMap linkedHashMap) {
            this.a = syncResultMsg;
            this.b = linkedHashMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            xe2.this.g(xe2.r, "/wear/playPattern/addBatchPattern\n " + str);
            BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) JSON.parseObject(str, new a(this, AddPatternInfoBean.class), new Feature[0]);
            if (baseResponseBeanNew.code != 0) {
                this.a.result = 1;
                Iterator it = this.b.keySet().iterator();
                while (it.hasNext()) {
                    Playlist playlist = (Playlist) this.b.get((String) it.next());
                    if (playlist != null) {
                        playlist.setSyncStatus(1);
                        playlist.setSyncFialMsg("信息上传失败code！=0");
                    }
                }
                return;
            }
            for (String str2 : ((AddPatternInfoBean) baseResponseBeanNew.data).patternIdSuc) {
                Playlist playlist2 = (Playlist) this.b.get(str2);
                if (playlist2 != null) {
                    playlist2.setSyncStatus(0);
                    playlist2.setSyncFialMsg("");
                }
            }
            for (String str3 : ((AddPatternInfoBean) baseResponseBeanNew.data).patternIdFail) {
                this.a.result = 1;
                Playlist playlist3 = (Playlist) this.b.get(str3);
                if (playlist3 != null) {
                    playlist3.setSyncStatus(1);
                    playlist3.setSyncFialMsg("信息上传失败code==0，在失败数组里");
                }
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            Iterator it = this.b.keySet().iterator();
            while (it.hasNext()) {
                Playlist playlist = (Playlist) this.b.get((String) it.next());
                if (playlist != null) {
                    playlist.setSyncStatus(1);
                    playlist.setSyncFialMsg("信息上传失败NetException");
                }
            }
            this.a.result = 1;
        }
    }

    /* compiled from: PatternManagerImpl.java */
    public class k implements zn2<String> {
        public final /* synthetic */ SyncResultMsg a;
        public final /* synthetic */ LinkedHashMap b;

        /* compiled from: PatternManagerImpl.java */
        public class a extends TypeReference<BaseResponseBeanNew<AddPatternInfoBean>> {
            public a(k kVar, Type... typeArr) {
                super(typeArr);
            }
        }

        public k(SyncResultMsg syncResultMsg, LinkedHashMap linkedHashMap) {
            this.a = syncResultMsg;
            this.b = linkedHashMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            xe2.this.g(xe2.r, "/wear/playPattern/edit\n " + str);
            BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) JSON.parseObject(str, new a(this, AddPatternInfoBean.class), new Feature[0]);
            if (baseResponseBeanNew.code != 0) {
                this.a.result = 1;
                Iterator it = this.b.keySet().iterator();
                while (it.hasNext()) {
                    Playlist playlist = (Playlist) this.b.get((String) it.next());
                    if (playlist != null) {
                        playlist.setSyncStatus(1);
                        playlist.setSyncFialMsg("编辑playList失败code!=0");
                    }
                }
                return;
            }
            for (String str2 : ((AddPatternInfoBean) baseResponseBeanNew.data).patternIdSuc) {
                Playlist playlist2 = (Playlist) this.b.get(str2);
                if (playlist2 != null) {
                    playlist2.setSyncStatus(0);
                    playlist2.setSyncFialMsg("");
                }
            }
            for (String str3 : ((AddPatternInfoBean) baseResponseBeanNew.data).patternIdFail) {
                this.a.result = 1;
                Playlist playlist3 = (Playlist) this.b.get(str3);
                if (playlist3 != null) {
                    playlist3.setSyncStatus(1);
                    playlist3.setSyncFialMsg("编辑playList失败code==0,失败数组");
                }
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            Iterator it = this.b.keySet().iterator();
            while (it.hasNext()) {
                Playlist playlist = (Playlist) this.b.get((String) it.next());
                if (playlist != null) {
                    playlist.setSyncStatus(1);
                    playlist.setSyncFialMsg("编辑playList失败NetException");
                }
            }
            this.a.result = 1;
        }
    }

    /* compiled from: PatternManagerImpl.java */
    public class l implements zn2<String> {
        public final /* synthetic */ SyncResultMsg a;
        public final /* synthetic */ LinkedHashMap b;

        /* compiled from: PatternManagerImpl.java */
        public class a extends TypeReference<BaseResponseBeanNew<AddPatternInfoBean>> {
            public a(l lVar, Type... typeArr) {
                super(typeArr);
            }
        }

        public l(SyncResultMsg syncResultMsg, LinkedHashMap linkedHashMap) {
            this.a = syncResultMsg;
            this.b = linkedHashMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            xe2.this.g(xe2.r, "/wear/playPattern/delete\n " + str);
            BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) JSON.parseObject(str, new a(this, AddPatternInfoBean.class), new Feature[0]);
            if (baseResponseBeanNew.code != 0) {
                this.a.result = 1;
                Iterator it = this.b.keySet().iterator();
                while (it.hasNext()) {
                    Playlist playlist = (Playlist) this.b.get((String) it.next());
                    if (playlist != null) {
                        playlist.setSyncStatus(1);
                        playlist.setSyncFialMsg("删除playList失败code!=0");
                    }
                }
                return;
            }
            for (String str2 : ((AddPatternInfoBean) baseResponseBeanNew.data).patternIdSuc) {
                Playlist playlist2 = (Playlist) this.b.get(str2);
                if (playlist2 != null) {
                    xe2.this.F1(playlist2);
                }
            }
            for (String str3 : ((AddPatternInfoBean) baseResponseBeanNew.data).patternIdFail) {
                this.a.result = 1;
                Playlist playlist3 = (Playlist) this.b.get(str3);
                if (playlist3 != null) {
                    playlist3.setSyncStatus(1);
                    playlist3.setSyncFialMsg("删除playList失败code==0,失败数组");
                }
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            Iterator it = this.b.keySet().iterator();
            while (it.hasNext()) {
                Playlist playlist = (Playlist) this.b.get((String) it.next());
                if (playlist != null) {
                    playlist.setSyncStatus(1);
                    playlist.setSyncFialMsg("删除playList NetException" + netException.getMessage());
                }
            }
            this.a.result = 1;
        }
    }

    /* compiled from: PatternManagerImpl.java */
    public class m implements zn2<String> {
        public final /* synthetic */ SyncResultMsg a;
        public final /* synthetic */ List b;
        public final /* synthetic */ LinkedHashMap c;

        /* compiled from: PatternManagerImpl.java */
        public class a extends TypeReference<BaseResponseBeanNew<AddPatternInfoBean>> {
            public a(m mVar, Type... typeArr) {
                super(typeArr);
            }
        }

        public m(SyncResultMsg syncResultMsg, List list, LinkedHashMap linkedHashMap) {
            this.a = syncResultMsg;
            this.b = list;
            this.c = linkedHashMap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            xe2.this.g(xe2.r, "/wear/myPattern/delete\n " + str);
            BaseResponseBeanNew baseResponseBeanNew = (BaseResponseBeanNew) JSON.parseObject(str, new a(this, AddPatternInfoBean.class), new Feature[0]);
            if (baseResponseBeanNew.code != 0) {
                this.a.result = 1;
                StringBuilder sb = new StringBuilder();
                Iterator it = this.b.iterator();
                while (it.hasNext()) {
                    Pattern pattern = (Pattern) this.c.get(((EditPatternBean) it.next()).getPatternId());
                    if (pattern != null) {
                        pattern.setSyncStatus(1);
                        pattern.setSyncFialMsg("删除模式失败code!=0");
                        sb.append(pattern.getId());
                        sb.append(Constants.FILENAME_SEQUENCE_SEPARATOR);
                    }
                }
                ye3.d("S0003", "pattern 删除失败，失败 ids=" + ((Object) sb) + "  msg=" + baseResponseBeanNew.message + "  code=" + baseResponseBeanNew.code + " 本次删除数据大小=" + this.b.size() + "  删除的pattern总数=" + this.c.size());
                return;
            }
            for (String str2 : ((AddPatternInfoBean) baseResponseBeanNew.data).patternIdSuc) {
                Pattern pattern2 = (Pattern) this.c.get(str2);
                if (pattern2 != null) {
                    pattern2.setSyncStatus(0);
                    pattern2.setSyncFialMsg("");
                    xe2.this.b(pattern2);
                }
            }
            StringBuilder sb2 = new StringBuilder();
            for (String str3 : ((AddPatternInfoBean) baseResponseBeanNew.data).patternIdFail) {
                this.a.result = 1;
                Pattern pattern3 = (Pattern) this.c.get(str3);
                if (pattern3 != null) {
                    pattern3.setSyncStatus(1);
                    pattern3.setSyncFialMsg("删除模式失败code==0,失败数组");
                    sb2.append(pattern3.getId());
                    sb2.append(Constants.FILENAME_SEQUENCE_SEPARATOR);
                }
            }
            if (WearUtils.f1(sb2)) {
                return;
            }
            ye3.d("S0003", "pattern 部分删除失败，失败 ids=" + ((Object) sb2) + " 本次删除数据大小=" + this.b.size() + "  删除的pattern总数=" + this.c.size());
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            xe2.this.g(xe2.r, "/wear/myPattern/delete\n " + netException.getMessage());
            StringBuilder sb = new StringBuilder();
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                Pattern pattern = (Pattern) this.c.get(((EditPatternBean) it.next()).getPatternId());
                if (pattern != null) {
                    pattern.setSyncStatus(1);
                    pattern.setSyncFialMsg("删除模式失败NetException" + netException.getMessage());
                    sb.append(pattern.getId());
                    sb.append(Constants.FILENAME_SEQUENCE_SEPARATOR);
                }
            }
            ye3.d("S0003", "pattern 删除失败，失败 ids=" + ((Object) sb) + "  msg=" + netException.getMessage() + " 本次删除数据大小=" + this.b.size() + "  删除的pattern总数=" + this.c.size());
            this.a.result = 1;
        }
    }

    /* compiled from: PatternManagerImpl.java */
    public static final class n {
        public static final ue2 a = new xe2(null);
    }

    /* compiled from: PatternManagerImpl.java */
    public static class o implements Comparator<IHandlerPattern> {
        public final boolean a;

        public o(boolean z) {
            this.a = z;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(IHandlerPattern iHandlerPattern, IHandlerPattern iHandlerPattern2) {
            return iHandlerPattern.getCSortId() == iHandlerPattern2.getCSortId() ? Long.compare(iHandlerPattern2.getCdtTime(), iHandlerPattern.getCdtTime()) : iHandlerPattern.getCSortId() > iHandlerPattern2.getCSortId() ? this.a ? 1 : -1 : this.a ? -1 : 1;
        }
    }

    public /* synthetic */ xe2(e eVar) {
        this();
    }

    public static ue2 L0() {
        return n.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S0(te2.a aVar, String str, LinkedHashMap linkedHashMap) {
        aVar.c = 1;
        B1(str, a0(linkedHashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U0(Pattern pattern) throws Throwable {
        WearUtils.i2(true, pattern.getId(), pattern.getPath(), "pattern", new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W0(te2.a aVar, String str, LinkedHashMap linkedHashMap) {
        aVar.c = 1;
        B1(str, c0(linkedHashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Y0(te2.a aVar, String str, LinkedHashMap linkedHashMap) {
        aVar.c = 1;
        B1(str, e0(linkedHashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void a1(te2.a aVar, String str, LinkedHashMap linkedHashMap) {
        aVar.c = 1;
        B1(str, p0(linkedHashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void c1(te2.a aVar, String str, LinkedHashMap linkedHashMap) {
        aVar.c = 1;
        B1(str, r0(linkedHashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e1(te2.a aVar, String str, LinkedHashMap linkedHashMap) {
        aVar.c = 1;
        B1(str, t0(linkedHashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g1(te2.a aVar, String str, LinkedHashMap linkedHashMap) {
        aVar.c = 1;
        B1(str, v0(linkedHashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void i1(te2.a aVar, String str, LinkedHashMap linkedHashMap) {
        aVar.c = 1;
        B1(str, x0(linkedHashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void k1(te2.a aVar, String str, LinkedHashMap linkedHashMap) {
        aVar.c = 1;
        B1(str, z0(linkedHashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void m1(String str) {
        HashMap map = new HashMap();
        map.put(DataLayout.ELEMENT, 1);
        map.put("pageSize", 100);
        map.put("isShareTag", Boolean.TRUE);
        tn2.x(this.e).q("/wear/myPattern/find", map, new e(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void o1(te2.a aVar, String str) {
        aVar.c = 1;
        synchronized (this.i) {
            this.b.removeCallbacksAndMessages(null);
            this.p.clear();
            this.p.put(str, aVar);
        }
        g(r, "开始获取线上数据");
        Setting settingS = this.e.S();
        boolean zIsFirstInit = settingS.isFirstInit();
        this.m = zIsFirstInit;
        if (!zIsFirstInit) {
            settingS.setFirstInit(true);
            DaoUtils.getSettingDao().update((SettingDao) settingS);
        }
        HashMap map = new HashMap();
        map.put(DataLayout.ELEMENT, 1);
        map.put("pageSize", 2000);
        map.put("isShareTag", Boolean.FALSE);
        K1(5000L);
        S1();
        tn2.x(this.e).q("/wear/myPattern/find", map, new f(str));
    }

    @Override // dc.te2
    public synchronized void A(boolean z) {
        if (this.f || !z) {
            this.f = z;
        } else {
            if (this.l) {
                Z("patternSync_tipSee_open");
            }
            this.f = true;
            j();
        }
    }

    public final void A0(LinkedHashMap<String, PlaylistItems> linkedHashMap) {
        Iterator<Map.Entry<String, PlaylistItems>> it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            PlaylistItems value = it.next().getValue();
            K0().put(value.getId(), value);
            DaoUtils.getPlaylistItemsDao().update((PlaylistItemsDao) value);
        }
    }

    public void A1(Runnable runnable) {
        try {
            if (this.a == Thread.currentThread()) {
                runnable.run();
            } else {
                this.b.post(runnable);
            }
        } catch (Exception e2) {
            g(r, e2.getMessage());
        }
    }

    @Override // dc.te2
    public void B() {
        synchronized (this.g) {
            J0().clear();
            I0().clear();
            K0().clear();
        }
    }

    public final String B0(String str) {
        return WearUtils.B(str);
    }

    public final void B1(String str, SyncResultMsg syncResultMsg) {
        if (syncResultMsg.result == 0) {
            M1(str);
        } else {
            C0(str);
        }
    }

    @Override // dc.ue2
    public List<Pattern> C(String str) {
        ArrayList arrayList;
        if (!TextUtils.isEmpty(str)) {
            return m(str);
        }
        synchronized (this.g) {
            arrayList = new ArrayList();
            Iterator<Map.Entry<String, Pattern>> it = J0().entrySet().iterator();
            while (it.hasNext()) {
                Pattern value = it.next().getValue();
                if (!value.isDel() && TextUtils.isEmpty(value.getEmail()) && !value.isSystemPattern()) {
                    arrayList.add(value);
                }
            }
        }
        return arrayList;
    }

    public final void C0(String str) {
        synchronized (this.i) {
            te2.a aVar = this.p.get(str);
            if (aVar != null) {
                aVar.c = 3;
                Iterator<te2.b> it = this.i.iterator();
                while (it.hasNext()) {
                    it.next().d4(aVar);
                }
            }
            boolean z = true;
            Iterator<String> it2 = this.p.keySet().iterator();
            while (it2.hasNext()) {
                te2.a aVar2 = this.p.get(it2.next());
                if (aVar2 != null && aVar2.c != 3) {
                    z = false;
                }
            }
            if (z) {
                Iterator<te2.b> it3 = this.i.iterator();
                while (it3.hasNext()) {
                    it3.next().G();
                }
                this.k.removeCallbacksAndMessages(null);
                this.k.postDelayed(new Runnable() { // from class: dc.le2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.H1();
                    }
                }, 60000L);
            }
        }
    }

    public final void C1(LinkedHashMap<String, Pattern> linkedHashMap, LinkedHashMap<String, Pattern> linkedHashMap2, LinkedHashMap<String, Pattern> linkedHashMap3) {
        String str = r;
        g(str, "本地pattern数据库修改数据:" + linkedHashMap2.size());
        w0(linkedHashMap2);
        g(str, "本地pattern数据库需要删除数据:" + linkedHashMap3.size());
        q0(linkedHashMap3);
        g(str, "本地pattern数据库添加数据:" + linkedHashMap.size());
        b0(linkedHashMap);
    }

    @Override // dc.te2
    public void D(te2.b bVar) {
        synchronized (this.i) {
            if (this.i.contains(bVar)) {
                this.i.remove(bVar);
            }
        }
    }

    public int D0() {
        Iterator<Map.Entry<String, Pattern>> it = J0().entrySet().iterator();
        int sortId = 0;
        while (it.hasNext()) {
            Pattern value = it.next().getValue();
            if (!value.isDel() && sortId <= value.getSortId() && !value.isSystemPattern()) {
                sortId = value.getSortId();
            }
        }
        return sortId + 1;
    }

    public final void D1(LinkedHashMap<String, Playlist> linkedHashMap, LinkedHashMap<String, Playlist> linkedHashMap2, LinkedHashMap<String, Playlist> linkedHashMap3) {
        String str = r;
        g(str, "本地PlayList数据库修改数据:" + linkedHashMap2.size());
        y0(linkedHashMap2);
        g(str, "本地PlayList数据库需要删除数据:" + linkedHashMap3.size());
        s0(linkedHashMap3);
        g(str, "本地PlayList数据库添加数据:" + linkedHashMap.size());
        d0(linkedHashMap);
    }

    @Override // dc.ue2
    public void E(Pattern pattern, boolean z) {
        if (pattern == null) {
            return;
        }
        LinkedHashMap<String, Pattern> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(pattern.getId(), pattern);
        F(linkedHashMap, z);
    }

    public Playlist E0(String str) {
        Playlist playlist = I0().get(str);
        if (playlist != null) {
            return playlist;
        }
        Playlist playlistFindById = DaoUtils.getPlaylistDao().findById(str);
        if (playlistFindById == null) {
            return null;
        }
        synchronized (this.g) {
            I0().put(str, playlistFindById);
        }
        return playlistFindById;
    }

    public final void E1(LinkedHashMap<String, PlaylistItems> linkedHashMap, LinkedHashMap<String, PlaylistItems> linkedHashMap2, LinkedHashMap<String, PlaylistItems> linkedHashMap3) {
        String str = r;
        g(str, "本地PlaylistItems数据库修改数据:" + linkedHashMap2.size());
        A0(linkedHashMap2);
        g(str, "本地PlaylistItems数据库添加数据:" + linkedHashMap.size());
        f0(linkedHashMap);
        g(str, "本地PlaylistItems数据库需要删除数据:" + linkedHashMap3.size());
        u0(linkedHashMap3);
    }

    @Override // dc.ue2
    public void F(final LinkedHashMap<String, Pattern> linkedHashMap, boolean z) {
        if (linkedHashMap == null) {
            return;
        }
        synchronized (this.g) {
            w0(linkedHashMap);
        }
        if (x1() && z) {
            final String strM0 = M0();
            final te2.a aVar = new te2.a();
            Runnable runnable = new Runnable() { // from class: dc.ge2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.g1(aVar, strM0, linkedHashMap);
                }
            };
            aVar.b = strM0;
            aVar.a = runnable;
            L1(aVar);
            A1(runnable);
        }
    }

    public final int F0() {
        Iterator<Map.Entry<String, PlaylistItems>> it = K0().entrySet().iterator();
        int sortId = 0;
        while (it.hasNext()) {
            PlaylistItems value = it.next().getValue();
            if (!value.isDel() && sortId <= value.getSortId()) {
                sortId = value.getSortId();
            }
        }
        return sortId + 1;
    }

    public void F1(Playlist playlist) {
        I0().remove(playlist.getId());
        DaoUtils.getPlaylistDao().delById(playlist.getId());
    }

    @Override // dc.ve2
    public void G(List<PlaylistItems> list, boolean z) {
        synchronized (this.g) {
            final LinkedHashMap<String, PlaylistItems> linkedHashMap = new LinkedHashMap<>();
            if (i0()) {
                for (PlaylistItems playlistItems : list) {
                    playlistItems.del();
                    playlistItems.setLastUpdTime(System.currentTimeMillis());
                    linkedHashMap.put(playlistItems.getId(), playlistItems);
                }
                u0(linkedHashMap);
            } else {
                for (PlaylistItems playlistItems2 : list) {
                    playlistItems2.del();
                    playlistItems2.setLastUpdTime(System.currentTimeMillis());
                    DaoUtils.getPlaylistItemsDao().update((PlaylistItemsDao) playlistItems2);
                    linkedHashMap.put(playlistItems2.getId(), playlistItems2);
                }
            }
            if (z && x1()) {
                final te2.a aVar = new te2.a();
                final String strM0 = M0();
                Runnable runnable = new Runnable() { // from class: dc.ce2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.e1(aVar, strM0, linkedHashMap);
                    }
                };
                aVar.b = strM0;
                aVar.a = runnable;
                L1(aVar);
                A1(runnable);
            }
        }
    }

    public PlaylistItems G0(String str) {
        PlaylistItems playlistItems = K0().get(str);
        if (playlistItems != null) {
            return playlistItems;
        }
        PlaylistItems playlistItemsFindById = DaoUtils.getPlaylistItemsDao().findById(str);
        if (playlistItemsFindById == null) {
            return null;
        }
        synchronized (this.g) {
            K0().put(str, playlistItemsFindById);
        }
        return playlistItemsFindById;
    }

    public void G1(PlaylistItems playlistItems) {
        K0().remove(playlistItems.getId());
        DaoUtils.getPlaylistItemsDao().delById(playlistItems.getId());
    }

    @Override // dc.te2
    public boolean H() {
        synchronized (this.i) {
            Iterator<String> it = this.p.keySet().iterator();
            while (it.hasNext()) {
                te2.a aVar = this.p.get(it.next());
                if (aVar != null && aVar.c == 3) {
                    return true;
                }
            }
            return false;
        }
    }

    public final int H0() {
        Iterator<Map.Entry<String, Playlist>> it = I0().entrySet().iterator();
        int sortId = 0;
        while (it.hasNext()) {
            Playlist value = it.next().getValue();
            if (!value.isDel() && sortId <= value.getSortId()) {
                sortId = value.getSortId();
            }
        }
        return sortId + 1;
    }

    public final void H1() {
        synchronized (this.i) {
            if (!this.f) {
                this.b.removeCallbacksAndMessages(null);
                this.p.clear();
                return;
            }
            boolean z = false;
            Iterator<String> it = this.p.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                te2.a aVar = this.p.get(it.next());
                if (aVar != null && aVar.c == 1) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                g(r, "重新执行任务，个数为：" + this.p.size());
                if (this.p.size() >= 5) {
                    s();
                } else {
                    Iterator<String> it2 = this.p.keySet().iterator();
                    while (it2.hasNext()) {
                        te2.a aVar2 = this.p.get(it2.next());
                        if (aVar2 != null) {
                            L1(aVar2);
                            A1(aVar2.a);
                        }
                    }
                }
            }
        }
    }

    @Override // dc.ve2
    public List<PlaylistItems> I(String str, String str2) {
        ArrayList arrayList;
        synchronized (this.g) {
            arrayList = new ArrayList();
            Iterator<Map.Entry<String, PlaylistItems>> it = K0().entrySet().iterator();
            while (it.hasNext()) {
                PlaylistItems value = it.next().getValue();
                if (value.getPlaylistId().equals(str2) && I1(str, value.getEmail())) {
                    arrayList.add(value);
                }
            }
            Collections.sort(arrayList, this.j);
        }
        return arrayList;
    }

    public final LinkedHashMap<String, Playlist> I0() {
        return this.n;
    }

    public final boolean I1(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return str.equals(str2);
    }

    @Override // dc.ve2
    public void J(final LinkedHashMap<String, PlaylistItems> linkedHashMap, boolean z) {
        if (linkedHashMap == null || linkedHashMap.size() == 0) {
            return;
        }
        synchronized (this.g) {
            Iterator<Map.Entry<String, PlaylistItems>> it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                PlaylistItems value = it.next().getValue();
                PlaylistItems playlistItemsG0 = G0(value.getId());
                if (playlistItemsG0 == null) {
                    value.setSortId(F0());
                    DaoUtils.getPlaylistItemsDao().addIfNotExist(value);
                } else {
                    m0(playlistItemsG0, value);
                    DaoUtils.getPlaylistItemsDao().updateOrAdd(value);
                }
                K0().put(value.getId(), value);
            }
            if (z && x1()) {
                final String strM0 = M0();
                final te2.a aVar = new te2.a();
                Runnable runnable = new Runnable() { // from class: dc.ee2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.Y0(aVar, strM0, linkedHashMap);
                    }
                };
                aVar.b = strM0;
                aVar.a = runnable;
                L1(aVar);
                A1(runnable);
            }
        }
    }

    public final LinkedHashMap<String, Pattern> J0() {
        return this.h;
    }

    public void J1(List<Pattern> list) {
        this.q = list;
    }

    @Override // dc.ue2
    public Pattern K(String str) {
        Pattern pattern = J0().get(str);
        if (pattern != null) {
            return pattern;
        }
        Pattern patternFindById = DaoUtils.getPatternDao().findById(str);
        if (patternFindById == null) {
            return null;
        }
        synchronized (this.g) {
            J0().put(str, patternFindById);
        }
        return patternFindById;
    }

    public final LinkedHashMap<String, PlaylistItems> K0() {
        return this.o;
    }

    public final void K1(long j2) {
    }

    @Override // dc.we2
    public void L(Playlist playlist, boolean z) {
        synchronized (this.g) {
            Playlist playlistE0 = E0(playlist.getId());
            if (playlistE0 == null) {
                playlist.setSortId(H0());
                DaoUtils.getPlaylistDao().addIfNotExist(playlist);
            } else {
                l0(playlistE0, playlist);
                DaoUtils.getPlaylistDao().updateOrAdd(playlist);
            }
            I0().put(playlist.getId(), playlist);
            if (z && x1()) {
                final LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(playlist.getId(), playlist);
                final String strM0 = M0();
                final te2.a aVar = new te2.a();
                Runnable runnable = new Runnable() { // from class: dc.ae2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.W0(aVar, strM0, linkedHashMap);
                    }
                };
                aVar.b = strM0;
                aVar.a = runnable;
                L1(aVar);
                A1(runnable);
            }
        }
    }

    public final void L1(te2.a aVar) {
        synchronized (this.i) {
            this.p.put(aVar.b, aVar);
            Iterator<te2.b> it = this.i.iterator();
            while (it.hasNext()) {
                it.next().Y(aVar);
            }
        }
    }

    @Override // dc.ve2
    public void M(List<PlaylistItems> list, boolean z) {
        G(list, z);
    }

    public final String M0() {
        return be3.r() + "";
    }

    public final void M1(String str) {
        synchronized (this.i) {
            te2.a aVarRemove = this.p.remove(str);
            if (aVarRemove != null) {
                aVarRemove.c = 2;
                Iterator<te2.b> it = this.i.iterator();
                while (it.hasNext()) {
                    it.next().I3(aVarRemove);
                }
            }
            if (this.p.size() == 0) {
                Iterator<te2.b> it2 = this.i.iterator();
                while (it2.hasNext()) {
                    it2.next().d();
                }
                this.k.removeCallbacksAndMessages(null);
            }
        }
    }

    @Override // dc.we2
    public List<Playlist> N(String str) {
        ArrayList arrayList;
        synchronized (this.g) {
            arrayList = new ArrayList();
            Iterator<Map.Entry<String, Playlist>> it = I0().entrySet().iterator();
            while (it.hasNext()) {
                Playlist value = it.next().getValue();
                if (!value.isDel() && I1(str, value.getEmail())) {
                    arrayList.add(value);
                }
            }
            Collections.sort(arrayList, this.j);
        }
        return arrayList;
    }

    public final void N0(String str) {
        int i2;
        synchronized (this.g) {
            String str2 = r;
            g(str2, "getPatternInfo(email) ");
            List<Pattern> listFindPatternsByEmailOrderBySort = DaoUtils.getPatternDao().findPatternsByEmailOrderBySort(str);
            g(str2, "getPatternInfo(email) " + listFindPatternsByEmailOrderBySort.size());
            J0().clear();
            Iterator<Pattern> it = listFindPatternsByEmailOrderBySort.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Pattern next = it.next();
                if (!next.neverSync()) {
                    next.setSyncStatus(0);
                }
                J0().put(next.getId(), next);
            }
            I0().clear();
            List<Playlist> listFindPlayListByEmailOrderBySort = DaoUtils.getPlaylistDao().findPlayListByEmailOrderBySort(str);
            for (Playlist playlist : listFindPlayListByEmailOrderBySort) {
                I0().put(playlist.getId(), playlist);
            }
            Setting settingS = this.e.S();
            if (settingS == null ? true : settingS.isSortKey()) {
                int size = listFindPlayListByEmailOrderBySort.size();
                for (i2 = 0; i2 < size; i2++) {
                    for (PlaylistItems playlistItems : DaoUtils.getPlaylistItemsDao().findByEmailAndPlaylistCheckOfflineId(str, listFindPlayListByEmailOrderBySort.get(i2).getId())) {
                        K0().put(playlistItems.getId(), playlistItems);
                    }
                }
            } else {
                settingS.setSortKey(true);
                DaoUtils.getSettingDao().update((SettingDao) settingS);
                Q0();
                int size2 = listFindPlayListByEmailOrderBySort.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    Playlist playlist2 = listFindPlayListByEmailOrderBySort.get(i3);
                    playlist2.setSortId(size2 - i3);
                    DaoUtils.getPlaylistDao().update((PlaylistDao) playlist2);
                    List<PlaylistItems> listFindByEmailAndPlaylistCheckOfflineId = DaoUtils.getPlaylistItemsDao().findByEmailAndPlaylistCheckOfflineId(str, playlist2.getId());
                    int size3 = listFindByEmailAndPlaylistCheckOfflineId.size();
                    int i4 = 0;
                    for (PlaylistItems playlistItems2 : listFindByEmailAndPlaylistCheckOfflineId) {
                        i4++;
                        playlistItems2.setSortId(size3 - i4);
                        DaoUtils.getPlaylistItemsDao().update((PlaylistItemsDao) playlistItems2);
                        K0().put(playlistItems2.getId(), playlistItems2);
                    }
                }
            }
            EventBus.getDefault().post(new PatternSyncEndEvent());
        }
    }

    public final PatternUploadBean N1(Pattern pattern) {
        PatternUploadBean patternUploadBean = new PatternUploadBean();
        patternUploadBean.setEmail(pattern.getEmail());
        patternUploadBean.setOwner(pattern.getAuthor());
        patternUploadBean.setFriendEmail(null);
        patternUploadBean.setPatternId(pattern.getId());
        patternUploadBean.setOrderDis(pattern.getSortId());
        patternUploadBean.setToyTag(pattern.getToyFunc());
        patternUploadBean.setTimer(pattern.getTimer());
        patternUploadBean.setShared(pattern.isShared());
        patternUploadBean.setName(B0(pattern.getName()));
        patternUploadBean.setStatus(pattern.getStatus());
        patternUploadBean.setPath(pattern.getPath());
        patternUploadBean.setText(B0(pattern.getText()));
        patternUploadBean.setCdt(pattern.getCreated().getTime());
        patternUploadBean.setCreater(pattern.getCreator());
        patternUploadBean.setIsAnony(pattern.isAnony() ? "true" : "false");
        patternUploadBean.setLastUpdTime(pattern.getLastUpdTime());
        patternUploadBean.setToyFeature(pattern.getToyFeature());
        patternUploadBean.setToyVersion(pattern.getToyVersion());
        patternUploadBean.setToyName(pattern.getToyName());
        patternUploadBean.setToySymbol(pattern.getToySymbol());
        if (pattern.isShared()) {
            patternUploadBean.setType("R");
        } else {
            patternUploadBean.setType("L");
            if (pattern.isDownload()) {
                patternUploadBean.setType("R");
            }
        }
        patternUploadBean.setLastUpdTime(pattern.getLastUpdTime());
        return patternUploadBean;
    }

    @Override // dc.ue2
    public boolean O(String str, String str2) {
        boolean z;
        synchronized (this.g) {
            Pattern patternK = K(str2);
            z = false;
            if (patternK != null && !patternK.isDel() && l(str, patternK.getEmails(false))) {
                z = true;
            }
        }
        return z;
    }

    public List<Pattern> O0() {
        return this.q;
    }

    public final EditPatternBean O1(Pattern pattern) {
        EditPatternBean editPatternBean = new EditPatternBean();
        editPatternBean.setPatternId(pattern.getId());
        editPatternBean.setText(B0(pattern.getText()));
        editPatternBean.setName(B0(pattern.getName()));
        editPatternBean.setLastUpdTime(pattern.getLastUpdTime());
        editPatternBean.setAnony(pattern.isAnony());
        editPatternBean.setOrderDis(pattern.getSortId());
        if (pattern.isShared()) {
            editPatternBean.setType("R");
        } else {
            editPatternBean.setType("L");
        }
        return editPatternBean;
    }

    public final int P0() {
        return y(WearUtils.y.r()).size();
    }

    public final Pattern P1(Pattern pattern, PatternUploadBean patternUploadBean) {
        Account accountU;
        if (pattern == null) {
            pattern = new Pattern();
        }
        pattern.setId(patternUploadBean.getPatternId());
        pattern.setEmail(patternUploadBean.getEmail());
        pattern.setAuthor(patternUploadBean.getOwner());
        pattern.setSortId(patternUploadBean.getOrderDis());
        pattern.setToyFunc(patternUploadBean.getToyTag());
        pattern.setToyFeature(patternUploadBean.getToyFeature());
        pattern.setTimer(patternUploadBean.getTimer());
        pattern.setToyName(patternUploadBean.getToyName());
        pattern.setToySymbol(patternUploadBean.getToySymbol());
        pattern.setToyVersion(patternUploadBean.getToyVersion());
        pattern.setShared(patternUploadBean.isShared());
        pattern.setName(o0(patternUploadBean.getName()));
        pattern.setStatus(patternUploadBean.getStatus());
        pattern.setPath(patternUploadBean.getPath());
        pattern.setAnony(patternUploadBean.isAnony());
        pattern.setEncrypt(true);
        pattern.setText(o0(patternUploadBean.getText()));
        pattern.setCreated(new Date(patternUploadBean.getCdt()));
        pattern.setAnony(patternUploadBean.isAnony());
        if (!patternUploadBean.isSelfMark() || WearUtils.e1(WearUtils.y.r())) {
            pattern.setCreator(patternUploadBean.getCreater());
        } else {
            pattern.setCreator(WearUtils.y.r());
        }
        if ("R".equals(patternUploadBean.getType())) {
            pattern.setShared(true);
            if (!patternUploadBean.isDownload() && (accountU = ch3.n().u()) != null) {
                pattern.setAuthor(accountU.getUserName());
            }
        } else {
            pattern.setShared(false);
        }
        pattern.setLastUpdTime(patternUploadBean.getLastUpdTime());
        return pattern;
    }

    public final void Q0() {
        ArrayList<Pattern> arrayList = new ArrayList();
        Iterator<Map.Entry<String, Pattern>> it = J0().entrySet().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Pattern value = it.next().getValue();
            if (!TextUtils.isEmpty(value.getAuthor()) && !value.isAnony()) {
                z = false;
            }
            value.setAnony(z);
            if (!value.isDel()) {
                arrayList.add(value);
            }
        }
        Collections.sort(arrayList, new o(true));
        int i2 = -1;
        int size = arrayList.size();
        for (Pattern pattern : arrayList) {
            i2++;
            pattern.setSortId(size - i2);
            DaoUtils.getPatternDao().update((PatternDao) pattern);
        }
    }

    public final Playlist Q1(Playlist playlist, Playlist playlist2) {
        if (playlist == null) {
            playlist = new Playlist();
        }
        playlist.setLastUpdTime(playlist2.getLastUpdTime());
        playlist.setStatus(playlist2.getStatus());
        playlist.setSortId(playlist2.getSortId());
        playlist.setEmail(playlist2.getEmail());
        playlist.setName(o0(playlist2.getName()));
        playlist.setId(playlist2.getId());
        playlist.setCreated(playlist2.getCreated());
        return playlist;
    }

    public final PlaylistItems R1(PlaylistItems playlistItems, PlaylistItems playlistItems2) {
        if (playlistItems == null) {
            playlistItems = new PlaylistItems();
        }
        playlistItems.setLastUpdTime(playlistItems2.getLastUpdTime());
        playlistItems.setStatus(playlistItems2.getStatus());
        playlistItems.setSortId(playlistItems2.getSortId());
        playlistItems.setEmail(playlistItems2.getEmail());
        playlistItems.setToyFeature(playlistItems2.getToyFeature());
        return playlistItems;
    }

    public void S1() {
    }

    public void Z(String str) {
        WearUtils.x.q(str, null);
    }

    @Override // dc.we2
    public void a(Playlist playlist, boolean z) {
        synchronized (this.g) {
            final LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(playlist.getId(), playlist);
            if (i0()) {
                F1(playlist);
            } else {
                playlist.del();
                playlist.setLastUpdTime(be3.r());
                DaoUtils.getPlaylistDao().update((PlaylistDao) playlist);
            }
            if (z && x1()) {
                final te2.a aVar = new te2.a();
                final String strM0 = M0();
                Runnable runnable = new Runnable() { // from class: dc.de2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.c1(aVar, strM0, linkedHashMap);
                    }
                };
                aVar.b = strM0;
                aVar.a = runnable;
                L1(aVar);
                A1(runnable);
            }
        }
    }

    public final SyncResultMsg a0(LinkedHashMap<String, Pattern> linkedHashMap) {
        SyncResultMsg syncResultMsg = new SyncResultMsg();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        int size = linkedHashMap.size();
        if (size == 0) {
            return syncResultMsg;
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(linkedHashMap);
        while (true) {
            if (size <= 0) {
                break;
            }
            g(r, "剩余文件个数：" + linkedHashMap3.size());
            ArrayList arrayList = new ArrayList();
            Iterator it = linkedHashMap3.keySet().iterator();
            while (it.hasNext()) {
                Pattern pattern = (Pattern) linkedHashMap3.get((String) it.next());
                if (arrayList.size() >= 10) {
                    break;
                }
                if (pattern != null) {
                    File file = pattern.getFile();
                    if (!TextUtils.isEmpty(pattern.getPath())) {
                        PatternUploadBean patternUploadBeanN1 = N1(pattern);
                        patternUploadBeanN1.setPath(pattern.getPath());
                        linkedHashMap2.put(pattern.getId(), patternUploadBeanN1);
                    } else if (file.exists()) {
                        if (!pattern.neverSync()) {
                            arrayList.add(pattern);
                        }
                    } else if (pattern.neverSync()) {
                        continue;
                    } else {
                        syncResultMsg.result = 1;
                        pattern.setSyncStatus(2);
                        pattern.setSyncFialMsg("文件不存在");
                        synchronized (this.g) {
                            DaoUtils.getPatternDao().update((PatternDao) pattern);
                        }
                    }
                }
            }
            g(r, "即将开始上传文件:" + arrayList.size());
            if (arrayList.size() <= 0) {
                break;
            }
            K1(arrayList.size() <= 1 ? 5000L : 1000L);
            S1();
            tn2.x(this.e).B("/wear/myPattern/uploadBatchPattern", arrayList, new c(syncResultMsg, arrayList, linkedHashMap2));
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedHashMap3.remove(((Pattern) it2.next()).getId());
            }
            size = linkedHashMap3.size();
        }
        int size2 = linkedHashMap2.size();
        while (size2 > 0) {
            g(r, "剩余待上传pattern信息:" + linkedHashMap2.size());
            ArrayList arrayList2 = new ArrayList();
            for (String str : linkedHashMap2.keySet()) {
                if (arrayList2.size() >= 30) {
                    break;
                }
                arrayList2.add((PatternUploadBean) linkedHashMap2.get(str));
            }
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                linkedHashMap2.remove(((PatternUploadBean) it3.next()).getPatternId());
            }
            K1(size2 > 1 ? 1000L : 5000L);
            S1();
            g(r, "开始上传pattern信息:" + arrayList2.size());
            tn2.x(this.e).u("/wear/myPattern/add", WearUtils.A.toJson(arrayList2), new d(syncResultMsg, linkedHashMap2));
            size2 = linkedHashMap2.size();
        }
        return syncResultMsg;
    }

    @Override // dc.ue2
    public void b(Pattern pattern) {
        synchronized (this.g) {
            J0().remove(pattern.getId());
            DaoUtils.getPatternDao().delById(pattern.getId());
        }
    }

    public final void b0(LinkedHashMap<String, Pattern> linkedHashMap) {
        Iterator<Map.Entry<String, Pattern>> it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            final Pattern value = it.next().getValue();
            DaoUtils.getPatternDao().addIfNotExist(value);
            J0().put(value.getId(), value);
            z1(new Runnable() { // from class: dc.ie2
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.a.U0(value);
                }
            });
        }
    }

    @Override // dc.we2
    public void c(Playlist playlist, boolean z) {
        LinkedHashMap<String, Playlist> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(playlist.getId(), playlist);
        i(linkedHashMap, z);
    }

    public final SyncResultMsg c0(LinkedHashMap<String, Playlist> linkedHashMap) {
        SyncResultMsg syncResultMsg = new SyncResultMsg();
        syncResultMsg.type = 1;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        for (int size = linkedHashMap2.size(); size > 0; size = linkedHashMap2.size()) {
            Iterator it = linkedHashMap2.entrySet().iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext() && arrayList.size() < 30) {
                Playlist playlist = (Playlist) ((Map.Entry) it.next()).getValue();
                PlayListUploadBean playListUploadBean = new PlayListUploadBean();
                playListUploadBean.setId(playlist.getId());
                playListUploadBean.setName(B0(playlist.getName()));
                playListUploadBean.setSortId(playlist.getSortId());
                playListUploadBean.setLastUpdTime(playlist.getLastUpdTime());
                playListUploadBean.setCdtTime(playlist.getCreated() == null ? be3.r() : playlist.getCreated().getTime());
                arrayList.add(playListUploadBean);
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedHashMap2.remove(((PlayListUploadBean) it2.next()).getId());
            }
            if (arrayList.size() <= 0) {
                break;
            }
            tn2.x(this.e).u("/wear/playPattern/addBatchPattern", WearUtils.A.toJson(arrayList), new j(syncResultMsg, linkedHashMap));
        }
        return syncResultMsg;
    }

    @Override // dc.ue2
    public void d(Pattern pattern, boolean z) {
        if (pattern == null) {
            return;
        }
        synchronized (this.g) {
            if (pattern.useless() || i0()) {
                b(pattern);
            } else {
                pattern.del();
                pattern.setLastUpdTime(System.currentTimeMillis());
                DaoUtils.getPatternDao().update((PatternDao) pattern);
            }
            if ((z && x1()) || (pattern.isShared() && !pattern.isDownload())) {
                final LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(pattern.getId(), pattern);
                final String strM0 = M0();
                final te2.a aVar = new te2.a();
                Runnable runnable = new Runnable() { // from class: dc.be2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.a1(aVar, strM0, linkedHashMap);
                    }
                };
                aVar.b = strM0;
                aVar.a = runnable;
                if (this.f) {
                    L1(aVar);
                }
                A1(runnable);
            }
        }
    }

    public final void d0(LinkedHashMap<String, Playlist> linkedHashMap) {
        Iterator<Map.Entry<String, Playlist>> it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Playlist value = it.next().getValue();
            DaoUtils.getPlaylistDao().addIfNotExist(value);
            I0().put(value.getId(), value);
        }
    }

    @Override // dc.ue2
    public void e(Pattern pattern) {
        g(r, "添加系统模式：" + pattern.getId() + " email:" + pattern.getEmail());
        DaoUtils.getPatternDao().updateOrAdd(pattern);
    }

    public final SyncResultMsg e0(LinkedHashMap<String, PlaylistItems> linkedHashMap) {
        SyncResultMsg syncResultMsg = new SyncResultMsg();
        syncResultMsg.type = 2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        for (int size = linkedHashMap2.size(); size > 0; size = linkedHashMap2.size()) {
            Iterator it = linkedHashMap2.entrySet().iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext() && arrayList.size() < 30) {
                arrayList.add((PlaylistItems) ((Map.Entry) it.next()).getValue());
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedHashMap2.remove(((PlaylistItems) it2.next()).getId());
            }
            if (arrayList.size() <= 0) {
                break;
            }
            tn2.x(this.e).u("/wear/playPattern/addPatternItem", WearUtils.A.toJson(arrayList), new g(syncResultMsg, linkedHashMap));
        }
        return syncResultMsg;
    }

    @Override // dc.ue2
    public void f(String str, String str2, ue2.a aVar) {
        WearUtils.j2(str, str2, aVar);
    }

    public final void f0(LinkedHashMap<String, PlaylistItems> linkedHashMap) {
        Iterator<Map.Entry<String, PlaylistItems>> it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            PlaylistItems value = it.next().getValue();
            DaoUtils.getPlaylistItemsDao().addIfNotExist(value);
            K0().put(value.getId(), value);
        }
    }

    @Override // dc.ue2
    public void g(String str, String str2) {
    }

    public final void g0(String str, int i2, int i3, int i4) {
        String str2;
        if (i2 == -1) {
            str2 = "net:未知#local:" + i3 + "#final:" + i4;
        } else {
            str2 = "net:" + i2 + "#local:" + i3 + "#final:" + i4;
        }
        if ("P0004".equals(str)) {
            NetworkInfo networkInfoB = hf3.b();
            if (networkInfoB == null) {
                str2 = "notreachable#" + str2;
            } else if (NetworkInfo.State.CONNECTED != networkInfoB.getState() || !networkInfoB.isAvailable()) {
                str2 = "notreachable#" + str2;
            } else if (networkInfoB.getType() != 1 && networkInfoB.getType() != 0) {
                str2 = "unknown#" + str2;
            } else if (networkInfoB.getType() == 1) {
                str2 = "wifi#" + str2;
            } else {
                str2 = "wwan#" + str2;
            }
        }
        ye3.d(str, str2);
    }

    @Override // dc.ve2
    public List<PlaylistItems> h(String str, String str2) {
        ArrayList arrayList;
        synchronized (this.g) {
            arrayList = new ArrayList();
            Iterator<Map.Entry<String, PlaylistItems>> it = K0().entrySet().iterator();
            while (it.hasNext()) {
                PlaylistItems value = it.next().getValue();
                if (value.getPatternId().equals(str2) && !value.isDel() && I1(str, value.getEmail())) {
                    arrayList.add(value);
                }
            }
        }
        return arrayList;
    }

    public final boolean h0(LinkedHashMap<String, Pattern> linkedHashMap, LinkedHashMap<String, Pattern> linkedHashMap2, LinkedHashMap<String, Pattern> linkedHashMap3, LinkedHashMap<String, Playlist> linkedHashMap4, LinkedHashMap<String, Playlist> linkedHashMap5, LinkedHashMap<String, Playlist> linkedHashMap6, LinkedHashMap<String, PlaylistItems> linkedHashMap7, LinkedHashMap<String, PlaylistItems> linkedHashMap8, LinkedHashMap<String, PlaylistItems> linkedHashMap9) {
        String str = r;
        g(str, "线上pattern数据库需要删除数据:" + linkedHashMap3.size());
        boolean z = p0(linkedHashMap3).result == 0;
        g(str, "线上pattern数据库修改数据:" + linkedHashMap2.size());
        SyncResultMsg syncResultMsgV0 = v0(linkedHashMap2);
        if (z) {
            z = syncResultMsgV0.result == 0;
        }
        g(str, "线上pattern数据库添加数据:" + linkedHashMap.size());
        SyncResultMsg syncResultMsgA0 = a0(linkedHashMap);
        if (z) {
            z = syncResultMsgA0.result == 0;
        }
        g(str, "线上PlayList数据库需要删除数据:" + linkedHashMap6.size());
        SyncResultMsg syncResultMsgR0 = r0(linkedHashMap6);
        if (z) {
            z = syncResultMsgR0.result == 0;
        }
        g(str, "线上PlayList数据库修改数据:" + linkedHashMap5.size());
        SyncResultMsg syncResultMsgX0 = x0(linkedHashMap5);
        if (z) {
            z = syncResultMsgX0.result == 0;
        }
        g(str, "线上PlayList数据库添加数据:" + linkedHashMap4.size());
        SyncResultMsg syncResultMsgC0 = c0(linkedHashMap4);
        if (z) {
            z = syncResultMsgC0.result == 0;
        }
        g(str, "线上PlaylistItems数据库需要删除数据:" + linkedHashMap9.size());
        SyncResultMsg syncResultMsgT0 = t0(linkedHashMap9);
        if (z) {
            z = syncResultMsgT0.result == 0;
        }
        g(str, "线上PlaylistItems数据库修改数据:" + linkedHashMap8.size());
        SyncResultMsg syncResultMsgZ0 = z0(linkedHashMap8);
        if (z) {
            z = syncResultMsgZ0.result == 0;
        }
        g(str, "线上PlaylistItems数据库添加数据:" + linkedHashMap7.size());
        SyncResultMsg syncResultMsgE0 = e0(linkedHashMap7);
        if (z) {
            return syncResultMsgE0.result == 0;
        }
        return z;
    }

    @Override // dc.we2
    public void i(final LinkedHashMap<String, Playlist> linkedHashMap, boolean z) {
        if (linkedHashMap == null) {
            return;
        }
        synchronized (this.g) {
            y0(linkedHashMap);
        }
        if (x1() && z) {
            final String strM0 = M0();
            final te2.a aVar = new te2.a();
            Runnable runnable = new Runnable() { // from class: dc.he2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.i1(aVar, strM0, linkedHashMap);
                }
            };
            aVar.b = strM0;
            aVar.a = runnable;
            L1(aVar);
            A1(runnable);
        }
    }

    public final boolean i0() {
        return MyApplication.Z || !this.f;
    }

    @Override // dc.te2
    public void j() {
        if (j0()) {
            s();
        }
    }

    public final boolean j0() {
        return MyApplication.P && !MyApplication.Z && this.f;
    }

    @Override // dc.te2
    public void k(te2.b bVar) {
        synchronized (this.i) {
            if (this.i.contains(bVar)) {
                return;
            }
            this.i.add(bVar);
        }
    }

    public final void k0(Pattern pattern, Pattern pattern2) {
        if (pattern.isDel() || pattern2.isDel()) {
            pattern2.del();
            return;
        }
        if (TextUtils.isEmpty(pattern2.getPath())) {
            pattern2.setPath(pattern.getPath());
        }
        if (TextUtils.isEmpty(pattern2.getName())) {
            pattern2.setName(pattern.getName());
        }
        if (TextUtils.isEmpty(pattern2.getText())) {
            pattern2.setText(pattern.getText());
        }
        if (pattern.isShared()) {
            pattern2.setShared(true);
        }
        String emails = pattern.getEmails(false);
        String emails2 = pattern2.getEmails(false);
        if (TextUtils.isEmpty(emails)) {
            return;
        }
        boolean z = false;
        for (String str : emails.split(",")) {
            if (I1(emails2, str)) {
                z = true;
            }
        }
        if (z) {
            return;
        }
        pattern2.setEmails(emails + "," + emails2, false);
    }

    @Override // dc.ue2
    public boolean l(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return true;
        }
        String[] strArrSplit = str2.split(",");
        int length = strArrSplit.length;
        for (int i2 = 0; i2 < length; i2++) {
            String str3 = strArrSplit[i2];
            String strF = nd3.f(str3);
            if (!WearUtils.e1(strF)) {
                str3 = strF;
            }
            if (I1(str, str3)) {
                return true;
            }
        }
        return false;
    }

    public final void l0(Playlist playlist, Playlist playlist2) {
        if (playlist.isDel() || playlist2.isDel()) {
            playlist2.del();
        }
    }

    @Override // dc.ue2
    public List<Pattern> m(String str) {
        ArrayList arrayList;
        synchronized (this.g) {
            arrayList = new ArrayList();
            Iterator<Map.Entry<String, Pattern>> it = J0().entrySet().iterator();
            while (it.hasNext()) {
                Pattern value = it.next().getValue();
                if (!value.isDel() && l(str, value.getEmail()) && !value.isSystemPattern()) {
                    arrayList.add(value);
                }
            }
        }
        return arrayList;
    }

    public final void m0(PlaylistItems playlistItems, PlaylistItems playlistItems2) {
        if (playlistItems.isDel() || playlistItems2.isDel()) {
            playlistItems2.del();
        }
    }

    @Override // dc.ve2
    public List<PlaylistItems> n(String str, String str2) {
        ArrayList arrayList;
        synchronized (this.g) {
            arrayList = new ArrayList();
            Iterator<Map.Entry<String, PlaylistItems>> it = K0().entrySet().iterator();
            while (it.hasNext()) {
                PlaylistItems value = it.next().getValue();
                if (value.getPlaylistId().equals(str2) && !value.isDel() && I1(str, value.getEmail())) {
                    arrayList.add(value);
                }
            }
            Collections.sort(arrayList, this.j);
        }
        return arrayList;
    }

    public final boolean n0(PatternData patternData) {
        List<PatternUploadBean> list = patternData.myPatternList;
        List<Playlist> list2 = patternData.myPlayPatternList;
        ArrayList arrayList = new ArrayList();
        LinkedHashMap<String, Pattern> linkedHashMap = new LinkedHashMap<>();
        LinkedHashMap<String, Pattern> linkedHashMap2 = new LinkedHashMap<>();
        LinkedHashMap<String, Pattern> linkedHashMap3 = new LinkedHashMap<>();
        LinkedHashMap<String, Pattern> linkedHashMap4 = new LinkedHashMap<>();
        LinkedHashMap<String, Pattern> linkedHashMap5 = new LinkedHashMap<>();
        LinkedHashMap<String, Pattern> linkedHashMap6 = new LinkedHashMap<>();
        LinkedHashMap<String, Playlist> linkedHashMap7 = new LinkedHashMap<>();
        LinkedHashMap<String, Playlist> linkedHashMap8 = new LinkedHashMap<>();
        LinkedHashMap<String, Playlist> linkedHashMap9 = new LinkedHashMap<>();
        LinkedHashMap<String, Playlist> linkedHashMap10 = new LinkedHashMap<>();
        LinkedHashMap<String, Playlist> linkedHashMap11 = new LinkedHashMap<>();
        LinkedHashMap<String, Playlist> linkedHashMap12 = new LinkedHashMap<>();
        LinkedHashMap<String, PlaylistItems> linkedHashMap13 = new LinkedHashMap<>();
        LinkedHashMap<String, PlaylistItems> linkedHashMap14 = new LinkedHashMap<>();
        LinkedHashMap<String, PlaylistItems> linkedHashMap15 = new LinkedHashMap<>();
        LinkedHashMap<String, PlaylistItems> linkedHashMap16 = new LinkedHashMap<>();
        LinkedHashMap<String, PlaylistItems> linkedHashMap17 = new LinkedHashMap<>();
        LinkedHashMap<String, PlaylistItems> linkedHashMap18 = new LinkedHashMap<>();
        synchronized (this.g) {
            u1(list, linkedHashMap, linkedHashMap2, linkedHashMap3, linkedHashMap4, linkedHashMap5, linkedHashMap6);
            q1(list, linkedHashMap);
            C1(linkedHashMap2, linkedHashMap4, linkedHashMap6);
            w1(list2, arrayList, linkedHashMap8, linkedHashMap9, linkedHashMap10, linkedHashMap11, linkedHashMap12);
            t1(list2, linkedHashMap7, linkedHashMap12);
            D1(linkedHashMap8, linkedHashMap10, linkedHashMap12);
            v1(arrayList, linkedHashMap14, linkedHashMap15, linkedHashMap16, linkedHashMap17, linkedHashMap18);
            s1(arrayList, linkedHashMap13, linkedHashMap18);
            E1(linkedHashMap14, linkedHashMap16, linkedHashMap18);
            LinkedHashMap<String, PlaylistItems> linkedHashMap19 = new LinkedHashMap<>();
            r1(linkedHashMap13, linkedHashMap15, linkedHashMap17, linkedHashMap19);
            g(r, "开始清理本地PlaylistItems数据库无用数据" + linkedHashMap19.size());
            u0(linkedHashMap19);
        }
        return h0(linkedHashMap, linkedHashMap3, linkedHashMap5, linkedHashMap7, linkedHashMap9, linkedHashMap11, linkedHashMap13, linkedHashMap15, linkedHashMap17);
    }

    @Override // dc.ve2
    public void o(final LinkedHashMap<String, PlaylistItems> linkedHashMap, boolean z) {
        synchronized (this.g) {
            Iterator<Map.Entry<String, PlaylistItems>> it = K0().entrySet().iterator();
            while (it.hasNext()) {
                DaoUtils.getPlaylistItemsDao().update((PlaylistItemsDao) it.next().getValue());
            }
            if (z && x1()) {
                final String strM0 = M0();
                final te2.a aVar = new te2.a();
                Runnable runnable = new Runnable() { // from class: dc.fe2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.k1(aVar, strM0, linkedHashMap);
                    }
                };
                aVar.b = strM0;
                aVar.a = runnable;
                L1(aVar);
                A1(runnable);
            }
        }
    }

    public final String o0(String str) {
        return WearUtils.u(str);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(NetworkInfoEvent networkInfoEvent) {
        if (!networkInfoEvent.isAvailable) {
            g(r, "网络不可用了:");
        } else {
            g(r, "网络可用了:");
            H1();
        }
    }

    @Override // dc.te2
    public boolean p() {
        boolean z;
        synchronized (this.i) {
            z = this.p.size() == 0;
        }
        return z;
    }

    public final SyncResultMsg p0(LinkedHashMap<String, Pattern> linkedHashMap) {
        SyncResultMsg syncResultMsg = new SyncResultMsg();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        for (int size = linkedHashMap.size(); size > 0; size = linkedHashMap2.size()) {
            g(r, "删除模式：剩余" + linkedHashMap2.size());
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : linkedHashMap2.entrySet()) {
                if (arrayList.size() >= 30) {
                    break;
                }
                arrayList.add(O1((Pattern) entry.getValue()));
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                linkedHashMap2.remove(((EditPatternBean) it.next()).getPatternId());
            }
            g(r, "删除模式：" + arrayList.size());
            if (arrayList.size() <= 0) {
                break;
            }
            K1(arrayList.size() > 1 ? 1000L : 5000L);
            S1();
            tn2.x(this.e).u("/wear/myPattern/delete", WearUtils.A.toJson(arrayList), new m(syncResultMsg, arrayList, linkedHashMap));
        }
        return syncResultMsg;
    }

    @Override // dc.ve2
    public void q(PlaylistItems playlistItems, boolean z) {
        if (playlistItems == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(playlistItems);
        G(arrayList, z);
    }

    public final void q0(LinkedHashMap<String, Pattern> linkedHashMap) {
        Iterator<Map.Entry<String, Pattern>> it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Pattern value = it.next().getValue();
            value.del();
            value.setLastUpdTime(System.currentTimeMillis());
            b(value);
        }
    }

    public final void q1(List<PatternUploadBean> list, LinkedHashMap<String, Pattern> linkedHashMap) {
        Iterator<Map.Entry<String, Pattern>> it = J0().entrySet().iterator();
        while (it.hasNext()) {
            Pattern value = it.next().getValue();
            boolean z = false;
            if (!value.isSystemPattern()) {
                Iterator<PatternUploadBean> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (value.getId().equals(it2.next().getPatternId())) {
                        z = true;
                        break;
                    }
                }
                if (!z && !value.isDel()) {
                    linkedHashMap.put(value.getId(), value);
                }
            }
        }
    }

    @Override // dc.te2
    public boolean r() {
        synchronized (this.i) {
            Iterator<String> it = this.p.keySet().iterator();
            while (it.hasNext()) {
                te2.a aVar = this.p.get(it.next());
                if (aVar != null && aVar.c == 1) {
                    return true;
                }
            }
            return false;
        }
    }

    public final SyncResultMsg r0(LinkedHashMap<String, Playlist> linkedHashMap) {
        SyncResultMsg syncResultMsg = new SyncResultMsg();
        syncResultMsg.type = 1;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        for (int size = linkedHashMap2.size(); size > 0; size = linkedHashMap2.size()) {
            Iterator it = linkedHashMap2.entrySet().iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext() && arrayList.size() < 30) {
                Playlist playlist = (Playlist) ((Map.Entry) it.next()).getValue();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(TtmlNode.ATTR_ID, (Object) playlist.getBeanId());
                arrayList.add(jSONObject);
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedHashMap2.remove(((JSONObject) it2.next()).get(TtmlNode.ATTR_ID));
            }
            if (arrayList.size() <= 0) {
                break;
            }
            K1(arrayList.size() > 1 ? 1000L : 5000L);
            S1();
            tn2.x(this.e).u("/wear/playPattern/delete", WearUtils.A.toJson(arrayList), new l(syncResultMsg, linkedHashMap));
        }
        return syncResultMsg;
    }

    public final void r1(LinkedHashMap<String, PlaylistItems> linkedHashMap, LinkedHashMap<String, PlaylistItems> linkedHashMap2, LinkedHashMap<String, PlaylistItems> linkedHashMap3, LinkedHashMap<String, PlaylistItems> linkedHashMap4) {
        Iterator<String> it = K0().keySet().iterator();
        while (it.hasNext()) {
            PlaylistItems playlistItems = K0().get(it.next());
            if (playlistItems != null && (J0().get(playlistItems.getPatternId()) == null || I0().get(playlistItems.getPlaylistId()) == null)) {
                linkedHashMap4.put(playlistItems.getId(), playlistItems);
                linkedHashMap.remove(playlistItems.getId());
                linkedHashMap2.remove(playlistItems.getId());
                linkedHashMap3.put(playlistItems.getId(), playlistItems);
            }
        }
    }

    @Override // dc.ue2
    public void s() {
        String str = r;
        g(str, "syncPatternToServer1");
        synchronized (this.i) {
            this.b.removeCallbacksAndMessages(null);
            this.p.clear();
        }
        g(str, "syncPatternToServer2");
        final String strM0 = M0();
        final te2.a aVar = new te2.a();
        Runnable runnable = new Runnable() { // from class: dc.ke2
            @Override // java.lang.Runnable
            public final void run() {
                this.a.o1(aVar, strM0);
            }
        };
        aVar.a = runnable;
        aVar.b = strM0;
        L1(aVar);
        A1(runnable);
    }

    public final void s0(LinkedHashMap<String, Playlist> linkedHashMap) {
        Iterator<Map.Entry<String, Playlist>> it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            F1(it.next().getValue());
        }
    }

    public final void s1(List<PlaylistItems> list, LinkedHashMap<String, PlaylistItems> linkedHashMap, LinkedHashMap<String, PlaylistItems> linkedHashMap2) {
        Iterator<Map.Entry<String, PlaylistItems>> it = K0().entrySet().iterator();
        while (it.hasNext()) {
            PlaylistItems value = it.next().getValue();
            boolean z = false;
            Iterator<PlaylistItems> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (value.getId().equals(it2.next().getBeanId())) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                if (value.isDel()) {
                    linkedHashMap2.put(value.getId(), value);
                } else {
                    linkedHashMap.put(value.getId(), value);
                }
            }
        }
    }

    @Override // dc.ue2
    public void t(Pattern pattern, boolean z) {
        synchronized (this.g) {
            Pattern patternK = K(pattern.getId());
            if (patternK == null) {
                pattern.setSortId(D0());
                DaoUtils.getPatternDao().addIfNotExist(pattern);
            } else {
                k0(patternK, pattern);
                DaoUtils.getPatternDao().updateOrAdd(pattern);
            }
            J0().put(pattern.getId(), pattern);
            if (z && x1()) {
                final LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(pattern.getId(), pattern);
                final String strM0 = M0();
                final te2.a aVar = new te2.a();
                Runnable runnable = new Runnable() { // from class: dc.zd2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.S0(aVar, strM0, linkedHashMap);
                    }
                };
                aVar.b = strM0;
                aVar.a = runnable;
                L1(aVar);
                A1(runnable);
            }
        }
    }

    public final SyncResultMsg t0(LinkedHashMap<String, PlaylistItems> linkedHashMap) {
        SyncResultMsg syncResultMsg = new SyncResultMsg();
        syncResultMsg.type = 2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        for (int size = linkedHashMap2.size(); size > 0; size = linkedHashMap2.size()) {
            Iterator it = linkedHashMap2.entrySet().iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext() && arrayList.size() < 30) {
                PlaylistItems playlistItems = (PlaylistItems) ((Map.Entry) it.next()).getValue();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(TtmlNode.ATTR_ID, (Object) playlistItems.getBeanId());
                jSONObject.put("playlistId", (Object) playlistItems.getPlaylistId());
                arrayList.add(jSONObject);
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedHashMap2.remove(((JSONObject) it2.next()).get(TtmlNode.ATTR_ID));
            }
            if (arrayList.size() <= 0) {
                break;
            }
            K1(arrayList.size() > 1 ? 1000L : 5000L);
            S1();
            tn2.x(this.e).u("/wear/playPatternItem/delete", WearUtils.A.toJson(arrayList), new i(syncResultMsg, linkedHashMap));
        }
        return syncResultMsg;
    }

    public final void t1(List<Playlist> list, LinkedHashMap<String, Playlist> linkedHashMap, LinkedHashMap<String, Playlist> linkedHashMap2) {
        Iterator<Map.Entry<String, Playlist>> it = I0().entrySet().iterator();
        while (it.hasNext()) {
            Playlist value = it.next().getValue();
            boolean z = false;
            Iterator<Playlist> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (value.getId().equals(it2.next().getId())) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                if (value.isDel()) {
                    linkedHashMap2.put(value.getId(), value);
                } else {
                    linkedHashMap.put(value.getId(), value);
                }
            }
        }
    }

    @Override // dc.ve2
    public PlaylistItems u(String str, String str2) {
        synchronized (this.g) {
            Iterator<Map.Entry<String, PlaylistItems>> it = K0().entrySet().iterator();
            while (it.hasNext()) {
                PlaylistItems value = it.next().getValue();
                if (value.getPlaylistId().equals(str) && value.getPatternId().equals(str2)) {
                    return value;
                }
            }
            return null;
        }
    }

    public final void u0(LinkedHashMap<String, PlaylistItems> linkedHashMap) {
        Iterator<Map.Entry<String, PlaylistItems>> it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            G1(it.next().getValue());
        }
    }

    public final void u1(List<PatternUploadBean> list, LinkedHashMap<String, Pattern> linkedHashMap, LinkedHashMap<String, Pattern> linkedHashMap2, LinkedHashMap<String, Pattern> linkedHashMap3, LinkedHashMap<String, Pattern> linkedHashMap4, LinkedHashMap<String, Pattern> linkedHashMap5, LinkedHashMap<String, Pattern> linkedHashMap6) {
        for (PatternUploadBean patternUploadBean : list) {
            boolean z = false;
            Iterator<Map.Entry<String, Pattern>> it = J0().entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Pattern value = it.next().getValue();
                if (value.getId().equals(patternUploadBean.getPatternId())) {
                    z = true;
                    if (patternUploadBean.isDel() || value.isDel()) {
                        linkedHashMap6.put(value.getId(), value);
                        if (!patternUploadBean.isDel()) {
                            linkedHashMap5.put(value.getId(), value);
                        }
                    } else {
                        if (value.isAnony() != patternUploadBean.isAnony()) {
                            value.setAnony(patternUploadBean.isAnony());
                        }
                        if (!patternUploadBean.isSync()) {
                            if (value.getLastUpdTime() < patternUploadBean.getLastUpdTime()) {
                                value = P1(value, patternUploadBean);
                                linkedHashMap4.put(value.getId(), value);
                            }
                            linkedHashMap.put(value.getId(), value);
                        } else if (value.getLastUpdTime() > patternUploadBean.getLastUpdTime()) {
                            linkedHashMap3.put(value.getId(), value);
                        } else if (value.getLastUpdTime() < patternUploadBean.getLastUpdTime()) {
                            Pattern patternP1 = P1(value, patternUploadBean);
                            linkedHashMap4.put(patternP1.getId(), patternP1);
                        }
                    }
                }
            }
            if (!z && !patternUploadBean.isDel()) {
                Pattern patternP12 = P1(null, patternUploadBean);
                linkedHashMap2.put(patternP12.getId(), patternP12);
                if (!patternUploadBean.isSync()) {
                    linkedHashMap.put(patternP12.getId(), patternP12);
                }
            }
        }
    }

    @Override // dc.te2
    public void v() {
        this.f = false;
        this.b.removeCallbacksAndMessages(null);
        this.d.removeCallbacksAndMessages(null);
        synchronized (this.i) {
            this.i.clear();
            this.p.clear();
        }
    }

    public final SyncResultMsg v0(LinkedHashMap<String, Pattern> linkedHashMap) {
        SyncResultMsg syncResultMsg = new SyncResultMsg();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        for (int size = linkedHashMap.size(); size > 0; size = linkedHashMap2.size()) {
            g(r, "编辑模式：剩余" + linkedHashMap2.size());
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : linkedHashMap2.entrySet()) {
                if (arrayList.size() >= 30) {
                    break;
                }
                Pattern pattern = (Pattern) entry.getValue();
                if (!pattern.neverSync()) {
                    arrayList.add(O1(pattern));
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                linkedHashMap2.remove(((EditPatternBean) it.next()).getPatternId());
            }
            String str = r;
            g(str, "编辑模式：" + arrayList.size());
            if (arrayList.size() <= 0) {
                break;
            }
            K1(arrayList.size() > 1 ? 1000L : 5000L);
            S1();
            g(str, "编辑模式：" + WearUtils.A.toJson(arrayList));
            tn2.x(this.e).u("/wear/myPattern/edit", WearUtils.A.toJson(arrayList), new a(syncResultMsg, linkedHashMap));
        }
        return syncResultMsg;
    }

    public final void v1(List<PlaylistItems> list, LinkedHashMap<String, PlaylistItems> linkedHashMap, LinkedHashMap<String, PlaylistItems> linkedHashMap2, LinkedHashMap<String, PlaylistItems> linkedHashMap3, LinkedHashMap<String, PlaylistItems> linkedHashMap4, LinkedHashMap<String, PlaylistItems> linkedHashMap5) {
        for (PlaylistItems playlistItems : list) {
            boolean z = false;
            Iterator<Map.Entry<String, PlaylistItems>> it = K0().entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PlaylistItems value = it.next().getValue();
                if (value.getId().equals(playlistItems.getId())) {
                    z = true;
                    if (playlistItems.isDel() || value.isDel()) {
                        linkedHashMap5.put(value.getId(), value);
                        if (!playlistItems.isDel()) {
                            linkedHashMap4.put(value.getId(), value);
                        }
                    } else if (value.getLastUpdTime() > playlistItems.getLastUpdTime()) {
                        linkedHashMap2.put(value.getId(), value);
                    } else if (value.getLastUpdTime() < playlistItems.getLastUpdTime()) {
                        PlaylistItems playlistItemsR1 = R1(value, playlistItems);
                        linkedHashMap3.put(playlistItemsR1.getId(), playlistItemsR1);
                    }
                }
            }
            if (!z && !playlistItems.isDel()) {
                linkedHashMap.put(playlistItems.getId(), playlistItems);
            }
        }
    }

    @Override // dc.ue2
    public List<Pattern> w(String str) {
        ArrayList arrayList;
        synchronized (this.g) {
            arrayList = new ArrayList();
            Iterator<Map.Entry<String, Pattern>> it = J0().entrySet().iterator();
            while (it.hasNext()) {
                Pattern value = it.next().getValue();
                if (!value.isDel() && l(str, value.getEmail()) && !value.isSystemPattern() && value.getToyFunc().equalsIgnoreCase(PSOProgramService.VS_Key) && !value.isShared() && !value.isDownload() && value.isAllFun()) {
                    arrayList.add(value);
                }
            }
        }
        return arrayList;
    }

    public final void w0(LinkedHashMap<String, Pattern> linkedHashMap) {
        Iterator<Map.Entry<String, Pattern>> it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Pattern value = it.next().getValue();
            Pattern patternK = K(value.getId());
            if (patternK != null) {
                k0(patternK, value);
            }
            J0().put(value.getId(), value);
            DaoUtils.getPatternDao().update((PatternDao) value);
        }
    }

    public final void w1(List<Playlist> list, List<PlaylistItems> list2, LinkedHashMap<String, Playlist> linkedHashMap, LinkedHashMap<String, Playlist> linkedHashMap2, LinkedHashMap<String, Playlist> linkedHashMap3, LinkedHashMap<String, Playlist> linkedHashMap4, LinkedHashMap<String, Playlist> linkedHashMap5) {
        for (Playlist playlist : list) {
            boolean z = false;
            Iterator<Map.Entry<String, Playlist>> it = I0().entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Playlist value = it.next().getValue();
                if (value.getId().equals(playlist.getId())) {
                    z = true;
                    if (playlist.isDel() || value.isDel()) {
                        linkedHashMap5.put(value.getId(), value);
                        if (!playlist.isDel()) {
                            linkedHashMap4.put(value.getId(), value);
                        }
                    } else if (value.getLastUpdTime() > playlist.getLastUpdTime()) {
                        linkedHashMap2.put(value.getId(), value);
                    } else if (value.getLastUpdTime() < playlist.getLastUpdTime()) {
                        Playlist playlistQ1 = Q1(value, playlist);
                        linkedHashMap3.put(playlistQ1.getId(), playlistQ1);
                    }
                }
            }
            if (!z && !playlist.isDel()) {
                Playlist playlistQ12 = Q1(null, playlist);
                linkedHashMap.put(playlistQ12.getId(), playlistQ12);
            }
            if (playlist.getMyPatternPlayListItems() != null) {
                list2.addAll(playlist.getMyPatternPlayListItems());
            }
        }
    }

    @Override // dc.te2
    public void x(final String str) {
        g(r, "init(email) ");
        if (TextUtils.isEmpty(str)) {
            N0(null);
            return;
        }
        if (!ch3.n().X()) {
            A1(new Runnable() { // from class: dc.je2
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.m1(str);
                }
            });
            return;
        }
        N0(str);
        if (ch3.n().o() != null) {
            A(ch3.n().X());
        }
    }

    public final SyncResultMsg x0(LinkedHashMap<String, Playlist> linkedHashMap) {
        SyncResultMsg syncResultMsg = new SyncResultMsg();
        syncResultMsg.type = 1;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        for (int size = linkedHashMap2.size(); size > 0; size = linkedHashMap2.size()) {
            Iterator it = linkedHashMap2.entrySet().iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext() && arrayList.size() < 30) {
                Playlist playlist = (Playlist) ((Map.Entry) it.next()).getValue();
                PlayListUploadBean playListUploadBean = new PlayListUploadBean();
                playListUploadBean.setId(playlist.getId());
                playListUploadBean.setName(B0(playlist.getName()));
                playListUploadBean.setSortId(playlist.getSortId());
                playListUploadBean.setLastUpdTime(playlist.getLastUpdTime());
                arrayList.add(playListUploadBean);
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedHashMap2.remove(((PlayListUploadBean) it2.next()).getId());
            }
            if (arrayList.size() <= 0) {
                break;
            }
            tn2.x(this.e).u("/wear/playPattern/edit", WearUtils.A.toJson(arrayList), new k(syncResultMsg, linkedHashMap));
        }
        return syncResultMsg;
    }

    public final boolean x1() {
        return !MyApplication.Z && this.f;
    }

    @Override // dc.ue2
    public List<Pattern> y(String str) {
        ArrayList arrayList;
        synchronized (this.g) {
            arrayList = new ArrayList();
            String str2 = "patterns的长度===" + J0().size();
            Iterator<Map.Entry<String, Pattern>> it = J0().entrySet().iterator();
            while (it.hasNext()) {
                Pattern value = it.next().getValue();
                if (!value.isDel() && l(str, value.getEmails(false)) && !value.isSystemPattern()) {
                    arrayList.add(value);
                }
            }
            Collections.sort(arrayList, this.j);
        }
        return arrayList;
    }

    public final void y0(LinkedHashMap<String, Playlist> linkedHashMap) {
        Iterator<Map.Entry<String, Playlist>> it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Playlist value = it.next().getValue();
            I0().put(value.getId(), value);
            DaoUtils.getPlaylistDao().update((PlaylistDao) value);
        }
    }

    public void y1(Pattern pattern) {
        List<Pattern> list = this.q;
        if (list != null) {
            for (Pattern pattern2 : list) {
                if (pattern2.getId().equals(pattern.getId())) {
                    this.q.remove(pattern2);
                    return;
                }
            }
        }
    }

    @Override // dc.ue2
    public List<Pattern> z(String str, int i2) {
        ArrayList arrayList;
        synchronized (this.g) {
            arrayList = new ArrayList();
            Iterator<Map.Entry<String, Pattern>> it = J0().entrySet().iterator();
            while (it.hasNext()) {
                Pattern value = it.next().getValue();
                if (!value.isDel() && I1(str, value.getEmail()) && WearUtils.C0(value.getTimer()) <= i2) {
                    arrayList.add(value);
                }
            }
            Collections.sort(arrayList, this.j);
        }
        return arrayList;
    }

    public final SyncResultMsg z0(LinkedHashMap<String, PlaylistItems> linkedHashMap) {
        SyncResultMsg syncResultMsg = new SyncResultMsg();
        syncResultMsg.type = 2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap);
        for (int size = linkedHashMap2.size(); size > 0; size = linkedHashMap2.size()) {
            Iterator it = linkedHashMap2.entrySet().iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext() && arrayList.size() < 30) {
                PlaylistItems playlistItems = (PlaylistItems) ((Map.Entry) it.next()).getValue();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(TtmlNode.ATTR_ID, (Object) playlistItems.getBeanId());
                jSONObject.put("sortId", (Object) Integer.valueOf(playlistItems.getSortId()));
                jSONObject.put("lastUpdTime", (Object) Long.valueOf(playlistItems.getLastUpdTime()));
                arrayList.add(jSONObject);
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                linkedHashMap2.remove(((JSONObject) it2.next()).get(TtmlNode.ATTR_ID));
            }
            if (arrayList.size() <= 0) {
                break;
            }
            K1(arrayList.size() > 1 ? 1000L : 5000L);
            S1();
            tn2.x(this.e).u("/wear/playPattern/editItemSort", WearUtils.A.toJson(arrayList), new h(syncResultMsg, linkedHashMap));
        }
        return syncResultMsg;
    }

    public void z1(Runnable runnable) {
        try {
            if (this.c == Thread.currentThread()) {
                runnable.run();
            } else {
                this.d.post(runnable);
            }
        } catch (Exception e2) {
            g(r, e2.getMessage());
        }
    }

    public xe2() {
        this.g = new Object();
        this.h = new LinkedHashMap<>();
        this.i = new ArrayList();
        this.k = new Handler(Looper.getMainLooper());
        this.l = false;
        this.m = true;
        this.n = new LinkedHashMap<>();
        this.o = new LinkedHashMap<>();
        this.p = new LinkedHashMap<>();
        this.e = WearUtils.x;
        HandlerThread handlerThread = new HandlerThread("同步工作线程", 10);
        this.a = handlerThread;
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper());
        HandlerThread handlerThread2 = new HandlerThread("下载模式线程");
        this.c = handlerThread2;
        handlerThread2.start();
        this.d = new Handler(handlerThread2.getLooper());
        this.j = new o(false);
        EventBus.getDefault().register(this);
    }
}

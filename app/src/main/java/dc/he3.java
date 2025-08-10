package dc;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.lovense.wear.R;
import com.wear.bean.EmojisFindFavoriteResponseItems;
import com.wear.bean.FavoriteEmojisBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.NormalResponse;
import com.wear.util.WearUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: EmojisFavoriteUtils.java */
/* loaded from: classes4.dex */
public class he3 {
    public static String a = "add favorite";

    /* compiled from: EmojisFavoriteUtils.java */
    public class a implements zn2<String> {
        public final /* synthetic */ f a;

        public a(he3 he3Var, f fVar) {
            this.a = fVar;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            Map map = null;
            if (WearUtils.e1(str)) {
                f fVar = this.a;
                if (fVar != null) {
                    fVar.a(null);
                    return;
                }
                return;
            }
            NormalResponse normalResponse = (NormalResponse) WearUtils.A.fromJson(str, NormalResponse.class);
            if (normalResponse == null) {
                if (MyApplication.H() != null) {
                    sg3.j(MyApplication.H(), R.string.common_serverError, " [" + NetException.SERVICE_DATA_ERROR + "]");
                    return;
                }
                return;
            }
            if (normalResponse.isResult() && normalResponse.getData() != null) {
                Map map2 = (Map) WearUtils.A.fromJson(str, HashMap.class);
                if (map2 != null && map2.get("data") != null) {
                    map = (Map) map2.get("data");
                }
            } else if (MyApplication.H() != null) {
                sg3.k(MyApplication.H(), normalResponse.getMessage());
            }
            f fVar2 = this.a;
            if (fVar2 != null) {
                fVar2.a(map);
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            f fVar = this.a;
            if (fVar != null) {
                fVar.a(null);
            }
        }
    }

    /* compiled from: EmojisFavoriteUtils.java */
    public class b implements zn2<String> {
        public final /* synthetic */ f a;

        public b(f fVar) {
            this.a = fVar;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            if (WearUtils.e1(str)) {
                f fVar = this.a;
                if (fVar != null) {
                    fVar.a(null);
                    return;
                }
                return;
            }
            WearUtils.E.clear();
            EmojisFindFavoriteResponseItems emojisFindFavoriteResponseItems = (EmojisFindFavoriteResponseItems) WearUtils.A.fromJson(str, EmojisFindFavoriteResponseItems.class);
            if (emojisFindFavoriteResponseItems == null) {
                if (MyApplication.H() != null) {
                    sg3.j(MyApplication.H(), R.string.common_serverError, " [" + NetException.SERVICE_DATA_ERROR + "]");
                    return;
                }
                return;
            }
            List<FavoriteEmojisBean> like = (!emojisFindFavoriteResponseItems.isResult() || emojisFindFavoriteResponseItems.getData() == null) ? null : emojisFindFavoriteResponseItems.getData().getLike();
            if (like != null && like.size() > 0) {
                WearUtils.E = like;
            }
            FavoriteEmojisBean favoriteEmojisBean = new FavoriteEmojisBean();
            favoriteEmojisBean.setId(he3.a);
            favoriteEmojisBean.setLoaded(true);
            WearUtils.E.add(0, favoriteEmojisBean);
            if (WearUtils.E.size() > 1) {
                he3.e(like, 0, this.a);
                return;
            }
            f fVar2 = this.a;
            if (fVar2 != null) {
                fVar2.a(null);
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            f fVar = this.a;
            if (fVar != null) {
                fVar.a(null);
            }
        }
    }

    /* compiled from: EmojisFavoriteUtils.java */
    public class c extends ff3 {
        public final /* synthetic */ File a;
        public final /* synthetic */ FavoriteEmojisBean b;
        public final /* synthetic */ List c;
        public final /* synthetic */ int d;
        public final /* synthetic */ f e;

        public c(File file, FavoriteEmojisBean favoriteEmojisBean, List list, int i, f fVar) {
            this.a = file;
            this.b = favoriteEmojisBean;
            this.c = list;
            this.d = i;
            this.e = fVar;
        }

        @Override // dc.ff3
        public void b(boolean z, Object obj) throws IOException {
            if (!z) {
                he3.e(this.c, this.d + 1, this.e);
                return;
            }
            File file = (File) obj;
            if (!file.exists()) {
                he3.e(this.c, this.d + 1, this.e);
                return;
            }
            WearUtils.q(file, this.a);
            he3.i(this.b.getId());
            he3.e(this.c, this.d + 1, this.e);
        }
    }

    /* compiled from: EmojisFavoriteUtils.java */
    public class d implements zn2<String> {
        public final /* synthetic */ f a;

        public d(he3 he3Var, f fVar) {
            this.a = fVar;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            if (WearUtils.e1(str)) {
                f fVar = this.a;
                if (fVar != null) {
                    fVar.a(null);
                    return;
                }
                return;
            }
            f fVar2 = this.a;
            if (fVar2 != null) {
                fVar2.a(null);
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            f fVar = this.a;
            if (fVar != null) {
                fVar.a(null);
            }
        }
    }

    /* compiled from: EmojisFavoriteUtils.java */
    public class e implements zn2<String> {
        public final /* synthetic */ f a;

        public e(he3 he3Var, f fVar) {
            this.a = fVar;
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(String str) {
            if (WearUtils.e1(str)) {
                f fVar = this.a;
                if (fVar != null) {
                    fVar.a(null);
                    return;
                }
                return;
            }
            f fVar2 = this.a;
            if (fVar2 != null) {
                fVar2.a(null);
            }
        }

        @Override // dc.zn2
        public void onError(NetException netException) {
            f fVar = this.a;
            if (fVar != null) {
                fVar.a(null);
            }
        }
    }

    /* compiled from: EmojisFavoriteUtils.java */
    public interface f {
        void a(Map map);
    }

    public static void e(List<FavoriteEmojisBean> list, int i, f fVar) {
        if (i >= list.size()) {
            if (fVar != null) {
                fVar.a(null);
                return;
            }
            return;
        }
        FavoriteEmojisBean favoriteEmojisBean = list.get(i);
        if (favoriteEmojisBean != null && (WearUtils.e1(favoriteEmojisBean.getId()) || WearUtils.e1(favoriteEmojisBean.getPath()))) {
            e(list, i + 1, fVar);
        }
        File file = new File(WearUtils.Y(), WearUtils.r0(favoriteEmojisBean.getId()));
        if (!file.exists()) {
            WearUtils.E0(true, favoriteEmojisBean.getPath(), new c(file, favoriteEmojisBean, list, i, fVar));
        } else {
            i(favoriteEmojisBean.getId());
            e(list, i + 1, fVar);
        }
    }

    public static void f(f fVar) {
        if (WearUtils.y.u() == null) {
            return;
        }
        tn2.x(WearUtils.x).l("/wear/expression/find", new HashMap(), new b(fVar));
    }

    public static List<FavoriteEmojisBean> g() {
        ArrayList arrayList = new ArrayList();
        for (FavoriteEmojisBean favoriteEmojisBean : WearUtils.E) {
            if (favoriteEmojisBean == null) {
                FirebaseCrashlytics.getInstance().recordException(new Throwable("getLoadedEmojisFavorite FavoriteEmojisBean 为null"));
            } else if (favoriteEmojisBean.isLoaded()) {
                arrayList.add(favoriteEmojisBean);
            }
        }
        return arrayList;
    }

    public static void i(String str) {
        for (FavoriteEmojisBean favoriteEmojisBean : WearUtils.E) {
            if ((WearUtils.e1(favoriteEmojisBean.getId()) ? "" : favoriteEmojisBean.getId()).equals(str)) {
                favoriteEmojisBean.setLoaded(true);
                return;
            }
        }
    }

    public void c(File file, String str, f fVar) {
        if (WearUtils.y.u() == null) {
            if (fVar != null) {
                fVar.a(null);
                return;
            }
            return;
        }
        HashMap map = new HashMap();
        map.put("fileDesc", str);
        if (!file.exists()) {
            if (fVar != null) {
                fVar.a(null);
            }
        } else {
            try {
                tn2.x(WearUtils.x).A("/wear/expression/add", file, map, new a(this, fVar));
            } catch (Exception e2) {
                if (fVar != null) {
                    fVar.a(null);
                }
                e2.printStackTrace();
            }
        }
    }

    public void d(String str, f fVar) {
        if (WearUtils.y.u() == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("ids", str);
        tn2.x(WearUtils.x).l("/wear/expression/delete", map, new e(this, fVar));
    }

    public void h(String str, f fVar) {
        if (WearUtils.y.u() == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("ids", str);
        tn2.x(WearUtils.x).l("/wear/expression/sort", map, new d(this, fVar));
    }
}

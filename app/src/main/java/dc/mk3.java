package dc;

import android.app.Activity;
import android.content.DialogInterface;
import android.util.Base64;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.reflect.TypeToken;
import com.sun.jna.Callback;
import com.wear.bean.Pattern;
import com.wear.bean.vb.DownloadVbBean;
import com.wear.bean.vb.TipConfigBean;
import com.wear.bean.vb.VbPatternAdBean;
import com.wear.bean.vb.VbPatternBean;
import com.wear.bean.vb.VideoAdBean;
import com.wear.bean.vb.VideoBean;
import com.wear.bean.vb.VideoResponse;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.tz;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.Charsets;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout;

/* compiled from: VbUtils.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0004J\u0006\u0010!\u001a\u00020\u001cJ\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u001cJ\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u000e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0004J\u000e\u0010+\u001a\u00020)2\u0006\u0010 \u001a\u00020\u0011J\b\u0010,\u001a\u00020\u001cH\u0002J\u0006\u0010-\u001a\u00020\u001cJ\u0006\u0010.\u001a\u00020\u001cJ\u0006\u0010/\u001a\u00020)J\u0006\u00100\u001a\u00020)J\u0006\u00101\u001a\u00020)J\u001e\u00102\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020\u0004J\u0016\u00105\u001a\u00020\u001c2\u0006\u00106\u001a\u00020\u00042\u0006\u00103\u001a\u00020)J\u000e\u00107\u001a\u00020\u001c2\u0006\u00108\u001a\u000209J\u0006\u0010:\u001a\u00020\u001cJ\u0006\u0010;\u001a\u00020\u001cJ\u0016\u0010<\u001a\u00020\u001c2\u0006\u00108\u001a\u0002092\u0006\u0010=\u001a\u00020>J\u0014\u0010?\u001a\u00020\u001c2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AJ\u0006\u0010C\u001a\u00020\u001cR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000fR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lcom/wear/vibematevideo/VbUtils;", "", "()V", "CACHE_VBPATTERN_LIKE_LIST", "", "getCACHE_VBPATTERN_LIKE_LIST", "()Ljava/lang/String;", "CACHE_VBPATTERN_LIST", "getCACHE_VBPATTERN_LIST", "CACHE_VIDEO_LIST", "getCACHE_VIDEO_LIST", "REMOTE_REMOVE_DISGUISED", "getREMOTE_REMOVE_DISGUISED", "isUploadLogPatternIdList", "", "()Ljava/util/List;", "showAdVbPatternIdList", "", "showVideoList", "Ljava/util/ArrayList;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "tipConfigBean", "Lcom/wear/bean/vb/TipConfigBean;", "tipSyncablePatternsDialog", "Lcom/wear/vibematevideo/ui/dialog/TipSyncablePatternsDialog;", "totalVideoList", "Lcom/wear/bean/vb/VideoBean;", "addPatternAdItemShowLog", "", "patternId", DataLayout.ELEMENT, "addPlayVbPatternId", TtmlNode.ATTR_ID, "configShowVideoList", "getLikeVideoList", "getNewCount", "", "getVideoDataFromServer", "getVideoList", "getVideoListToJs", "hasPatternWithUrl", "", ImagesContract.URL, "inShowAdVbPatternIdList", "initConfig", "initData", "initVideoData", "isShowInteractiveVideo", "isShowNew", "isShowNewCount", "likePattern", "like", "showPatternId", "likeVideo", "webUrl", "navigateToDownloadVb", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroid/app/Activity;", "remoteRemoveDisguise", "saveUseSyncablePatternState", "showTipSyncablePatternDialog", "xy", "", "transformToRemotePatternList", "dataList", "", "Lcom/wear/bean/vb/VbPatternBean;", "updateTipConfig", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class mk3 {

    @NotNull
    public static final String b = "cache_video_list";

    @NotNull
    public static final String c = "cache_vbpattern_list";

    @NotNull
    public static final String d = "cache_vbpattern_like_list";

    @NotNull
    public static final String e = "REMOTE_REMOVE_DISGUISED";

    @Nullable
    public static wl3 h;

    @Nullable
    public static TipConfigBean i;

    @NotNull
    public static final mk3 a = new mk3();

    @NotNull
    public static final List<Long> f = new ArrayList();

    @NotNull
    public static final List<String> g = new ArrayList();

    @NotNull
    public static final ArrayList<VideoBean> j = new ArrayList<>();

    @NotNull
    public static final ArrayList<tq> k = new ArrayList<>();

    /* compiled from: Comparisons.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @SourceDebugExtension({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n*L\n1#1,328:1\n*E\n"})
    public static final class a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            tq tqVar = (tq) t;
            Intrinsics.checkNotNull(tqVar, "null cannot be cast to non-null type com.wear.bean.vb.VideoBean");
            Long lValueOf = Long.valueOf(((VideoBean) tqVar).getLikeTimestamp());
            tq tqVar2 = (tq) t2;
            Intrinsics.checkNotNull(tqVar2, "null cannot be cast to non-null type com.wear.bean.vb.VideoBean");
            return ComparisonsKt__ComparisonsKt.compareValues(lValueOf, Long.valueOf(((VideoBean) tqVar2).getLikeTimestamp()));
        }
    }

    /* compiled from: VbUtils.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/wear/vibematevideo/VbUtils$getVideoDataFromServer$1", "Lcom/wear/network/protocol/callback/ResponseCallBack;", "", "onCompleted", "", "onError", "e", "Lcom/wear/network/protocol/exception/NetException;", "onStart", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements yn2<String> {
        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable String str) {
            ArrayList<VideoBean> data;
            String str2 = "initVideoData onSuccess: " + str;
            if (str != null) {
                try {
                    VideoResponse videoResponse = (VideoResponse) WearUtils.A.fromJson(str, VideoResponse.class);
                    if (videoResponse == null || (data = videoResponse.getData()) == null) {
                        return;
                    }
                    mk3.j.clear();
                    mk3.j.addAll(data);
                    MyApplication myApplication = WearUtils.x;
                    mk3 mk3Var = mk3.a;
                    eg3.i(myApplication, mk3Var.h(), WearUtils.A.toJson(data));
                    mk3Var.q();
                    EventBus.getDefault().post(new sk3());
                    Unit unit = Unit.INSTANCE;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(@Nullable NetException e) {
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: VbUtils.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/wear/vibematevideo/VbUtils$initVideoData$cacheVideoList$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/wear/bean/vb/VideoBean;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c extends TypeToken<List<? extends VideoBean>> {
    }

    /* compiled from: VbUtils.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/wear/vibematevideo/VbUtils$likePattern$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d implements zn2<String> {
        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable String str) {
            String str2 = "onSuccess: " + str;
        }

        @Override // dc.zn2
        public void onError(@Nullable NetException e) {
        }
    }

    /* compiled from: VbUtils.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/wear/vibematevideo/VbUtils$likeVideo$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e implements zn2<String> {
        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable String str) {
        }

        @Override // dc.zn2
        public void onError(@Nullable NetException e) {
        }
    }

    /* compiled from: VbUtils.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/wear/vibematevideo/VbUtils$remoteRemoveDisguise$1", "Lcom/wear/network/protocol/callback/ResponseCallBack;", "", "onCompleted", "", "onError", "e", "Lcom/wear/network/protocol/exception/NetException;", "onStart", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class f implements yn2<String> {
        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            eg3.j(WearUtils.x, mk3.a.k(), true);
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(@Nullable NetException e) {
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: VbUtils.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/wear/vibematevideo/VbUtils$transformToRemotePatternList$1$1", "Lcom/wear/util/MyListener;", Callback.METHOD_NAME, "", "result", "", "message", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class g extends ff3 {
        public final /* synthetic */ Pattern a;

        public g(Pattern pattern) {
            this.a = pattern;
        }

        @Override // dc.ff3
        public void b(boolean z, @Nullable Object obj) {
            if (z) {
                File file = obj instanceof File ? (File) obj : null;
                if (file != null) {
                    this.a.setDataNoCheckFormat(WearUtils.N1(file.getPath()));
                }
            }
        }
    }

    public static final void F(DialogInterface dialogInterface) {
        h = null;
    }

    public static final void s() {
        a.t();
    }

    public final void A(@NotNull String webUrl, boolean z) {
        Intrinsics.checkNotNullParameter(webUrl, "webUrl");
        if (z) {
            ll3.E().e0("Interactive video", "click", "like", webUrl, null);
        }
        HashMap map = new HashMap();
        String strC = tz.a.c();
        if (strC == null) {
            strC = "";
        }
        map.put("deviceUkey", strC);
        map.put("webUrl", webUrl);
        map.put("isLike", Integer.valueOf(z ? 1 : 0));
        tn2.x(WearUtils.x).m("/surfease/anon/video/static/user/like", ro2.c(map), new e());
    }

    public final void B(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        DownloadVbBean downloadVbBean = new DownloadVbBean(null, null, null, 7, null);
        String str = "52_0_" + UUID.randomUUID();
        downloadVbBean.setDownload(Boolean.TRUE);
        StringBuilder sb = new StringBuilder();
        sb.append("id=com.lovense.vibemate&referrer=utm_source%3DCCL%26utm_medium%3DSS%26utm_campaign%3DLive%26utm_content%3D");
        Charset charset = Charsets.UTF_8;
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] bArrEncode = Base64.encode(bytes, 2);
        Intrinsics.checkNotNullExpressionValue(bArrEncode, "encode(uuid.toByteArray(), Base64.NO_WRAP)");
        sb.append(new String(bArrEncode, charset));
        downloadVbBean.setSuffix(sb.toString());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("type", "52");
        linkedHashMap.put("eventType", "2");
        String strC = tz.a.c();
        if (strC == null) {
            strC = "";
        }
        linkedHashMap.put("deviceId", strC);
        linkedHashMap.put("clientType", "h5");
        linkedHashMap.put("resourceType", ExifInterface.GPS_MEASUREMENT_3D);
        linkedHashMap.put("platformType", "2");
        linkedHashMap.put("uuid", str);
        linkedHashMap.put("version", "Android " + if3.d());
        String strB = if3.b();
        Intrinsics.checkNotNullExpressionValue(strB, "getMobileType()");
        linkedHashMap.put("mobileType", strB);
        downloadVbBean.setParams(linkedHashMap);
        ll3.E().U(activity, downloadVbBean, "", 52);
    }

    public final void C() {
        if (eg3.d(WearUtils.x, e, false)) {
            return;
        }
        tz.a aVar = tz.a;
        String strC = aVar.c();
        if (strC == null || strC.length() == 0) {
            return;
        }
        HashMap map = new HashMap();
        String strC2 = aVar.c();
        if (strC2 == null) {
            strC2 = "";
        }
        map.put("deviceUKey", strC2);
        map.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, 404);
        map.put("appType", "andorid");
        map.put("remoteRemoveDisguised", Boolean.TRUE);
        tn2.x(WearUtils.x).g("/surfease/anon/check_device_install_app", map, new f());
    }

    public final void D() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        eg3.j(WearUtils.x, "use_syncable_pattern_state", true);
    }

    public final void E(@NotNull Activity activity, @NotNull int[] xy) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(xy, "xy");
        if (eg3.d(activity, "use_syncable_pattern_state", false)) {
            return;
        }
        int iF = eg3.f(activity, "look_syncable_pattern_count", 0) + 1;
        if (iF < 2) {
            eg3.k(activity, "look_syncable_pattern_count", iF);
            return;
        }
        if (iF == 2 && h == null) {
            wl3 wl3Var = new wl3(activity, xy);
            h = wl3Var;
            wl3Var.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: dc.gk3
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    mk3.F(dialogInterface);
                }
            });
            wl3 wl3Var2 = h;
            if (wl3Var2 != null) {
                wl3Var2.show();
            }
            eg3.k(WearUtils.x, "look_syncable_pattern_count", iF);
        }
    }

    public final void G(@NotNull List<VbPatternBean> dataList) {
        Intrinsics.checkNotNullParameter(dataList, "dataList");
        for (VbPatternBean vbPatternBean : dataList) {
            Pattern pattern = new Pattern();
            pattern.setPath(vbPatternBean.getPatternUrl());
            pattern.setCdnPath(vbPatternBean.getPatternUrl());
            pattern.setId(String.valueOf(vbPatternBean.getId()));
            pattern.setPatternStoreTag(vbPatternBean.getId() + "#vibemate");
            pattern.setName(vbPatternBean.getStaticPatternId());
            pattern.setIsShowReview("0");
            pattern.setStatus("approved");
            pattern.setEmail("vibemate");
            vbPatternBean.setPattern(pattern);
            WearUtils.E0(false, pattern.getCdnPath(), new g(pattern));
        }
    }

    public final void H() {
        TipConfigBean tipConfigBean = i;
        if (tipConfigBean != null) {
            tipConfigBean.setLastLookTime(System.currentTimeMillis());
            tipConfigBean.setLastDay(tipConfigBean.getEndDay());
            eg3.i(WearUtils.x, "look_interactive_video_config", WearUtils.A.toJson(tipConfigBean));
            String str = "updateTipConfig: " + i;
        }
    }

    public final void c(@NotNull String patternId, @NotNull String page) {
        Intrinsics.checkNotNullParameter(patternId, "patternId");
        Intrinsics.checkNotNullParameter(page, "page");
        String str = page + '_' + patternId;
        List<String> list = g;
        if (list.contains(str)) {
            return;
        }
        list.add(str);
        ll3.E().e0(page, "open", "insert ad", patternId, null);
    }

    public final void d(@NotNull String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        List<Long> list = f;
        if (list.isEmpty() || !Intrinsics.areEqual(String.valueOf(((Number) CollectionsKt___CollectionsKt.last((List) list)).longValue()), id)) {
            list.add(Long.valueOf(Long.parseLong(id)));
        }
    }

    public final void e() {
        ArrayList<tq> arrayList = k;
        arrayList.clear();
        arrayList.add(new VideoAdBean(1));
        TipConfigBean tipConfigBean = i;
        if (tipConfigBean == null) {
            arrayList.addAll(j);
        } else {
            Intrinsics.checkNotNull(tipConfigBean);
            int startDay = tipConfigBean.getStartDay();
            TipConfigBean tipConfigBean2 = i;
            Intrinsics.checkNotNull(tipConfigBean2);
            if (startDay == tipConfigBean2.getEndDay()) {
                TipConfigBean tipConfigBean3 = i;
                Intrinsics.checkNotNull(tipConfigBean3);
                int startDay2 = tipConfigBean3.getStartDay();
                while (startDay2 > 0) {
                    ArrayList<tq> arrayList2 = k;
                    ArrayList<VideoBean> arrayList3 = j;
                    ArrayList arrayList4 = new ArrayList();
                    for (Object obj : arrayList3) {
                        if (((VideoBean) obj).getDay() == startDay2) {
                            arrayList4.add(obj);
                        }
                    }
                    arrayList2.addAll(arrayList4);
                    startDay2--;
                }
            } else {
                TipConfigBean tipConfigBean4 = i;
                Intrinsics.checkNotNull(tipConfigBean4);
                int endDay = tipConfigBean4.getEndDay();
                TipConfigBean tipConfigBean5 = i;
                Intrinsics.checkNotNull(tipConfigBean5);
                int startDay3 = tipConfigBean5.getStartDay() + 1;
                if (startDay3 <= endDay) {
                    while (true) {
                        ArrayList<tq> arrayList5 = k;
                        ArrayList<VideoBean> arrayList6 = j;
                        ArrayList<VideoBean> arrayList7 = new ArrayList();
                        for (Object obj2 : arrayList6) {
                            if (((VideoBean) obj2).getDay() == endDay) {
                                arrayList7.add(obj2);
                            }
                        }
                        ArrayList arrayList8 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList7, 10));
                        for (VideoBean videoBean : arrayList7) {
                            videoBean.setLocalNewFlag(1);
                            arrayList8.add(videoBean);
                        }
                        arrayList5.addAll(arrayList8);
                        if (endDay == startDay3) {
                            break;
                        } else {
                            endDay--;
                        }
                    }
                }
                ArrayList<tq> arrayList9 = k;
                if (arrayList9.size() > 1) {
                    arrayList9.add(new VideoAdBean(2));
                }
                TipConfigBean tipConfigBean6 = i;
                Intrinsics.checkNotNull(tipConfigBean6);
                int startDay4 = tipConfigBean6.getStartDay();
                while (startDay4 > 0) {
                    ArrayList<tq> arrayList10 = k;
                    ArrayList<VideoBean> arrayList11 = j;
                    ArrayList<VideoBean> arrayList12 = new ArrayList();
                    for (Object obj3 : arrayList11) {
                        if (((VideoBean) obj3).getDay() == startDay4) {
                            arrayList12.add(obj3);
                        }
                    }
                    ArrayList arrayList13 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList12, 10));
                    for (VideoBean videoBean2 : arrayList12) {
                        videoBean2.setLocalNewFlag(0);
                        arrayList13.add(videoBean2);
                    }
                    arrayList10.addAll(arrayList13);
                    startDay4--;
                }
            }
        }
        if (j.size() > 1) {
            k.add(new VideoAdBean(3));
        }
    }

    @NotNull
    public final String f() {
        return d;
    }

    @NotNull
    public final String g() {
        return c;
    }

    @NotNull
    public final String h() {
        return b;
    }

    @NotNull
    public final ArrayList<tq> i() {
        boolean z;
        ArrayList<tq> arrayList = new ArrayList<>();
        ArrayList<tq> arrayList2 = k;
        if ((arrayList2 instanceof Collection) && arrayList2.isEmpty()) {
            z = false;
        } else {
            for (tq tqVar : arrayList2) {
                if ((tqVar instanceof VideoBean) && ((VideoBean) tqVar).getStaticVideoUserIsLike()) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        if (z) {
            ArrayList<tq> arrayList3 = k;
            ArrayList arrayList4 = new ArrayList();
            for (Object obj : arrayList3) {
                tq tqVar2 = (tq) obj;
                if ((tqVar2 instanceof VideoBean) && ((VideoBean) tqVar2).getStaticVideoUserIsLike()) {
                    arrayList4.add(obj);
                }
            }
            arrayList.addAll(CollectionsKt___CollectionsKt.sortedWith(arrayList4, new a()));
            if (arrayList.size() > 5) {
                arrayList.add(new VbPatternAdBean(2));
            }
        }
        return arrayList;
    }

    public final int j() {
        Integer localNewFlag;
        ArrayList<tq> arrayList = k;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            tq tqVar = (tq) obj;
            if ((tqVar instanceof VideoBean) && (localNewFlag = ((VideoBean) tqVar).getLocalNewFlag()) != null && localNewFlag.intValue() == 1) {
                arrayList2.add(obj);
            }
        }
        return arrayList2.size();
    }

    @NotNull
    public final String k() {
        return e;
    }

    public final void l() {
        tn2.x(WearUtils.x).f("/surfease/anon/video/static/list?platform=android&version=" + WearUtils.q + "&deviceUkey=" + tz.a.c(), new b());
    }

    @NotNull
    public final ArrayList<tq> m() {
        ArrayList<tq> arrayList = new ArrayList<>();
        ArrayList<tq> arrayList2 = k;
        if (arrayList2.size() == 0) {
            arrayList2.add(new VideoAdBean(1));
        } else {
            arrayList.addAll(arrayList2);
        }
        if (arrayList.size() > 1) {
            arrayList.add(new VideoAdBean(4));
        }
        return arrayList;
    }

    @NotNull
    public final ArrayList<tq> n() {
        ArrayList<tq> arrayList = new ArrayList<>();
        ArrayList<tq> arrayList2 = k;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (((tq) obj).getItemType() == 1) {
                arrayList3.add(obj);
            }
        }
        arrayList.addAll(arrayList3);
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean o(@org.jetbrains.annotations.NotNull java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.util.ArrayList<com.wear.bean.vb.VideoBean> r0 = dc.mk3.j
            boolean r1 = r0 instanceof java.util.Collection
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L15
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L15
        L13:
            r2 = 0
            goto L47
        L15:
            java.util.Iterator r0 = r0.iterator()
        L19:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L13
            java.lang.Object r1 = r0.next()
            com.wear.bean.vb.VideoBean r1 = (com.wear.bean.vb.VideoBean) r1
            dc.ll3 r4 = dc.ll3.E()
            java.lang.String r5 = r1.getWebUrl()
            boolean r4 = r4.A(r5, r7)
            if (r4 == 0) goto L44
            java.lang.String r1 = r1.getPatternUrl()
            int r1 = r1.length()
            if (r1 <= 0) goto L3f
            r1 = 1
            goto L40
        L3f:
            r1 = 0
        L40:
            if (r1 == 0) goto L44
            r1 = 1
            goto L45
        L44:
            r1 = 0
        L45:
            if (r1 == 0) goto L19
        L47:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.mk3.o(java.lang.String):boolean");
    }

    public final boolean p(long j2) {
        List list;
        int iCoerceAtMost;
        try {
            list = CollectionsKt___CollectionsKt.toList(CollectionsKt___CollectionsKt.toMutableSet(CollectionsKt___CollectionsKt.reversed(f)));
            iCoerceAtMost = RangesKt___RangesKt.coerceAtMost(3, list.size());
        } catch (Exception e2) {
            FirebaseCrashlytics.getInstance().recordException(new Throwable("inShowAdVbPatternIdList报错", e2));
        }
        if (iCoerceAtMost == 0) {
            return false;
        }
        Iterator it = list.subList(0, iCoerceAtMost).iterator();
        while (it.hasNext()) {
            if (((Number) it.next()).longValue() == j2) {
                return true;
            }
        }
        return false;
    }

    public final void q() {
        Integer num;
        String strConfig = eg3.h(WearUtils.x, "look_interactive_video_config", "");
        Intrinsics.checkNotNullExpressionValue(strConfig, "strConfig");
        if (strConfig.length() == 0) {
            TipConfigBean tipConfigBean = new TipConfigBean(0L, 0L, 0, 0, 0L, 0, 63, null);
            long jG = eg3.g(WearUtils.x, "discover_show_videosnew", 0L);
            if (jG == 0) {
                jG = System.currentTimeMillis();
            }
            tipConfigBean.setFirstTime(jG);
            tipConfigBean.setStartDay(eg3.d(WearUtils.x, "discover_click_videos", false) ? 2 : 1);
            tipConfigBean.setEndDay(tipConfigBean.getStartDay());
            tipConfigBean.setLastDay(tipConfigBean.getStartDay());
            i = tipConfigBean;
        } else {
            try {
                i = (TipConfigBean) WearUtils.A.fromJson(strConfig, TipConfigBean.class);
            } catch (Exception unused) {
            }
        }
        TipConfigBean tipConfigBean2 = i;
        if (tipConfigBean2 != null) {
            if (!be3.G(new Date(tipConfigBean2.getFirstTime())) && !be3.G(new Date(tipConfigBean2.getUpdateEndDayTime()))) {
                tipConfigBean2.setUpdateEndDayTime(System.currentTimeMillis());
                Iterator<T> it = j.iterator();
                if (it.hasNext()) {
                    Integer numValueOf = Integer.valueOf(((VideoBean) it.next()).getDay());
                    while (it.hasNext()) {
                        Integer numValueOf2 = Integer.valueOf(((VideoBean) it.next()).getDay());
                        if (numValueOf.compareTo(numValueOf2) < 0) {
                            numValueOf = numValueOf2;
                        }
                    }
                    num = numValueOf;
                } else {
                    num = null;
                }
                Integer num2 = num;
                if (num2 == null || tipConfigBean2.getEndDay() < num2.intValue()) {
                    tipConfigBean2.setEndDay(tipConfigBean2.getEndDay() + 1);
                }
            }
            if (!be3.G(new Date(tipConfigBean2.getLastLookTime()))) {
                tipConfigBean2.setStartDay(tipConfigBean2.getLastDay());
            }
        }
        String str = "initConfig: " + i;
        eg3.i(WearUtils.x, "look_interactive_video_config", WearUtils.A.toJson(i));
        e();
    }

    public final void r() {
        se0.b().execute(new Runnable() { // from class: dc.hk3
            @Override // java.lang.Runnable
            public final void run() {
                mk3.s();
            }
        });
    }

    public final void t() {
        String strH = eg3.h(WearUtils.x, b, null);
        if (!(strH == null || strH.length() == 0)) {
            List list = (List) WearUtils.A.fromJson(strH, new c().getType());
            if (!(list == null || list.isEmpty())) {
                j.addAll(list);
            }
        }
        l();
    }

    public final boolean u() {
        return (WearUtils.D || "zh" == lg3.f(WearUtils.x)) ? false : true;
    }

    public final boolean v() {
        TipConfigBean tipConfigBean = i;
        return (tipConfigBean == null || be3.G(new Date(tipConfigBean.getFirstTime())) || tipConfigBean.getLastDay() == tipConfigBean.getEndDay()) ? false : true;
    }

    @NotNull
    public final List<String> w() {
        return g;
    }

    public final void z(long j2, boolean z, @NotNull String showPatternId) {
        Intrinsics.checkNotNullParameter(showPatternId, "showPatternId");
        EventBus.getDefault().post(new rk3(j2, z));
        if (z) {
            ll3.E().e0("Syncable patterns", "click", "like", showPatternId, null);
        }
        HashMap map = new HashMap();
        String strC = tz.a.c();
        if (strC == null) {
            strC = "";
        }
        map.put("deviceUkey", strC);
        map.put("patternId", Long.valueOf(j2));
        map.put("isLike", Integer.valueOf(z ? 1 : 0));
        tn2.x(WearUtils.x).m("/surfease/anon/pattern/static/user/like", ro2.c(map), new d());
    }
}

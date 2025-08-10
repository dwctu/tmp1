package com.wear.ui.discover.xremote.activity;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.SkinAppCompatDelegateImpl;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.lovense.wear.R;
import com.spotify.sdk.android.player.Config;
import com.wear.bean.Account;
import com.wear.bean.AppGalleryScanBean;
import com.wear.bean.CheckProtocolBean;
import com.wear.bean.CheckProtocolData;
import com.wear.bean.GalleryAccount;
import com.wear.bean.GalleryDetailData;
import com.wear.bean.GalleryDetailsV2Bean;
import com.wear.bean.GalleryPermission;
import com.wear.bean.GalleryPermissionBean;
import com.wear.bean.XRemoteAppUserBean;
import com.wear.ui.discover.dialog.CacheGalleryBottomDialog;
import com.wear.ui.discover.xremote.activity.XRemoteActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.XRemoteDevDialog;
import com.wear.widget.dialog.XRemoteAuthorizedLoginPop;
import com.wear.widget.dialog.XRemotePermissionPop;
import com.wear.widget.dialog.XRemotePolicyPop;
import dc.a14;
import dc.ac4;
import dc.ad4;
import dc.ah4;
import dc.bc4;
import dc.bd4;
import dc.bs3;
import dc.ce3;
import dc.ch3;
import dc.eg3;
import dc.ff2;
import dc.gg3;
import dc.h04;
import dc.h14;
import dc.kg3;
import dc.ku1;
import dc.lg3;
import dc.n04;
import dc.nd3;
import dc.pc1;
import dc.pg3;
import dc.pj3;
import dc.q61;
import dc.r23;
import dc.s23;
import dc.sg3;
import dc.t23;
import dc.u23;
import dc.u34;
import dc.u51;
import dc.uy3;
import dc.v34;
import dc.vc4;
import dc.wz3;
import dc.yc4;
import dc.ye3;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaActivity;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.errcode.ErrorCode;
import org.apache.cordova.gallery.XRemoteToyPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.helpers.MessageFormatter;
import rx.Subscription;

/* compiled from: XRemoteActivity.kt */
@Metadata(d1 = {"\u0000ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010J\u001a\u00020KH\u0016J\b\u0010L\u001a\u00020KH\u0016J\u0012\u0010M\u001a\u00020K2\b\u0010N\u001a\u0004\u0018\u00010OH\u0014J\u0018\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\f2\u0006\u0010S\u001a\u00020\fH\u0002J4\u0010T\u001a\u00020Q2\u0006\u0010U\u001a\u00020\f2\u0006\u0010V\u001a\u00020\f2\u0006\u0010A\u001a\u00020\f2\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010@\u001a\u00020\bH\u0002J\u0010\u0010W\u001a\u00020Q2\u0006\u0010X\u001a\u00020\fH\u0002J \u0010Y\u001a\u00020\u001a2\u0016\b\u0002\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020K\u0018\u00010[H\u0002J\b\u0010\\\u001a\u00020KH\u0014J \u0010]\u001a\u00020K2\n\b\u0002\u0010^\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010_\u001a\u0004\u0018\u00010 H\u0002J\u0018\u0010`\u001a\u00020K2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\fH\u0002J\b\u0010d\u001a\u00020KH\u0002J\u0012\u0010e\u001a\u00020K2\b\u0010f\u001a\u0004\u0018\u00010\u001cH\u0002J\u0018\u0010g\u001a\u00020K2\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010h\u001a\u00020K2\b\u0010i\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010j\u001a\u00020K2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u001c\u0010k\u001a\u00020K2\b\u0010i\u001a\u0004\u0018\u00010\f2\b\u0010l\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010m\u001a\u00020K2\u0006\u0010c\u001a\u00020\fH\u0002J\b\u0010n\u001a\u00020oH\u0016J\n\u0010p\u001a\u0004\u0018\u00010qH\u0002J\n\u0010r\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010s\u001a\u00020K2\b\u0010i\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010t\u001a\u00020K2\u0006\u0010\u0017\u001a\u00020\u0018J6\u0010u\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010A\u001a\u00020\f2\u0006\u0010c\u001a\u00020\f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\b\u0010v\u001a\u00020KH\u0002J\b\u0010w\u001a\u00020KH\u0002J\b\u0010x\u001a\u00020KH\u0002J\u0010\u0010y\u001a\u00020K2\u0006\u0010z\u001a\u00020\fH\u0002J\u0010\u0010{\u001a\u00020K2\u0006\u0010c\u001a\u00020\fH\u0002J\b\u0010|\u001a\u00020KH\u0002J$\u0010}\u001a\u00020K2\u0006\u0010~\u001a\u00020\u00052\u0006\u0010\u007f\u001a\u00020\u00052\n\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001H\u0014J\u0013\u0010\u0082\u0001\u001a\u00020K2\b\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0016J\u0015\u0010\u0085\u0001\u001a\u00020K2\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001H\u0016J\t\u0010\u0088\u0001\u001a\u00020KH\u0016J\t\u0010\u0089\u0001\u001a\u00020KH\u0016J\t\u0010\u008a\u0001\u001a\u00020KH\u0016J\t\u0010\u008b\u0001\u001a\u00020KH\u0016J\u0013\u0010\u008c\u0001\u001a\u00020K2\b\u0010f\u001a\u0004\u0018\u00010\u001cH\u0016J\u0013\u0010\u008d\u0001\u001a\u00020K2\b\u0010f\u001a\u0004\u0018\u00010\u001cH\u0016J\t\u0010\u008e\u0001\u001a\u00020KH\u0016J\u0013\u0010\u008f\u0001\u001a\u00020K2\b\u0010f\u001a\u0004\u0018\u00010\fH\u0016J\t\u0010\u0090\u0001\u001a\u00020KH\u0016J\u0011\u0010\u0091\u0001\u001a\u00020K2\u0006\u0010f\u001a\u00020 H\u0016J\t\u0010\u0092\u0001\u001a\u00020KH\u0016J\u0012\u0010\u0093\u0001\u001a\u00020K2\u0007\u0010f\u001a\u00030\u0094\u0001H\u0016J\u0014\u0010\u0095\u0001\u001a\u00020K2\t\u0010f\u001a\u0005\u0018\u00010\u0094\u0001H\u0016J\"\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0097\u00012\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\f2\t\u0010f\u001a\u0005\u0018\u00010\u0097\u0001H\u0016J#\u0010\u0099\u0001\u001a\u00020K2\u0007\u0010\u009a\u0001\u001a\u00020O2\u0007\u0010\u009b\u0001\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u001a\u0010\u009c\u0001\u001a\u00020K2\u0007\u0010\u009d\u0001\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u009e\u0001\u001a\u00020K2\u0007\u0010\u009f\u0001\u001a\u00020\fJ1\u0010 \u0001\u001a\u00020K2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\t\u0010¡\u0001\u001a\u0004\u0018\u00010\f2\u000b\b\u0002\u0010¢\u0001\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0003\u0010£\u0001J\u001d\u0010¤\u0001\u001a\u00020K2\b\u0010¥\u0001\u001a\u00030¦\u00012\b\u0010§\u0001\u001a\u00030¨\u0001H\u0002J\u001d\u0010©\u0001\u001a\u00020K2\t\u0010ª\u0001\u001a\u0004\u0018\u00010\f2\u0007\u0010«\u0001\u001a\u00020\bH\u0016J\u001d\u0010¬\u0001\u001a\u00020K2\b\u0010¥\u0001\u001a\u00030¦\u00012\b\u0010§\u0001\u001a\u00030¨\u0001H\u0002J\t\u0010\u00ad\u0001\u001a\u00020KH\u0002J\u0011\u0010®\u0001\u001a\u00020K2\u0006\u0010_\u001a\u00020 H\u0002J\u001a\u0010¯\u0001\u001a\u00020\f2\u0007\u0010°\u0001\u001a\u00020\f2\u0006\u0010A\u001a\u00020\fH\u0002J\u0011\u0010±\u0001\u001a\u00020\f2\u0006\u0010A\u001a\u00020\fH\u0002J\u0012\u0010²\u0001\u001a\u00020K2\u0007\u0010³\u0001\u001a\u00020\u0005H\u0002J\u0012\u0010´\u0001\u001a\u00020K2\u0007\u0010³\u0001\u001a\u00020\u0005H\u0002J\t\u0010µ\u0001\u001a\u00020KH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u0010\u0010)\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R\"\u00104\u001a\b\u0012\u0004\u0012\u00020\f05X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0012\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0004\n\u0002\u0010=R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010@\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010A\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010B\u001a\u0004\u0018\u00010CX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\"\u0010H\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`IX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¶\u0001"}, d2 = {"Lcom/wear/ui/discover/xremote/activity/XRemoteActivity;", "Lorg/apache/cordova/CordovaActivity;", "Lcom/wear/ui/discover/xremote/view/XRemoteView;", "()V", "REQUEST_CODE_CREATE_CUSTOM_USER", "", "REQUEST_TO_MAIN", "accountDidUpdate", "", "Ljava/lang/Boolean;", "allowDomains", "Ljava/util/ArrayList;", "", "getAllowDomains", "()Ljava/util/ArrayList;", "setAllowDomains", "(Ljava/util/ArrayList;)V", RemoteConfigConstants.RequestFieldKey.APP_ID, RemoteConfigConstants.RequestFieldKey.APP_VERSION, "applicationIcon", "applicationName", "btWork", "Lcom/lovense/btservice/work/BtWork;", "callbackContext", "Lorg/apache/cordova/CallbackContext;", "coroutinesJob", "Lkotlinx/coroutines/Job;", "dataBean", "Lcom/wear/bean/XRemoteAppUserBean$DataBean;", "developModel", "isGetAppAccountInfoIng", "mCheckProtocolData", "Lcom/wear/bean/CheckProtocolBean;", "mRotate", "getMRotate", "()Ljava/lang/String;", "setMRotate", "(Ljava/lang/String;)V", "mScope", "getMScope", "setMScope", "mXRemoteAppUserData", "mXRemotePresenter", "Lcom/wear/ui/discover/xremote/model/XRemotePresenter;", "permissionPopWindow", "Lcom/wear/widget/dialog/XRemotePermissionPop;", "polocyPopWindow", "Lcom/wear/widget/dialog/XRemotePolicyPop;", "popupWindow", "Lcom/wear/widget/dialog/XRemoteAuthorizedLoginPop;", "progressDialog", "Lcom/wear/widget/dialog/CustomLoadingDialog;", "scopeArr", "", "getScopeArr", "()[Ljava/lang/String;", "setScopeArr", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "startTime", "", "Ljava/lang/Long;", "subscription", "Lrx/Subscription;", "userInfoDidUpdate", "version", "xRemoteDevDialog", "Lcom/wear/widget/XRemoteDevDialog;", "getXRemoteDevDialog", "()Lcom/wear/widget/XRemoteDevDialog;", "setXRemoteDevDialog", "(Lcom/wear/widget/XRemoteDevDialog;)V", "xremoteAllowDomainList", "Lkotlin/collections/ArrayList;", "argeeProtocolFail", "", "argeeProtocolSuccess", "attachBaseContext", "newBase", "Landroid/content/Context;", "callBackAccountJson", "Lorg/json/JSONObject;", "username", "cToken", "callBackAppInfoJson", "SDKVersion", "language", "callBackAuthCodeJson", "authCode", "countDownCoroutines", "onTick", "Lkotlin/Function1;", "createViews", "dataResult", "xRemoteAppUserData", "checkProtocolData", "dealWithLink", NotificationCompat.MessagingStyle.Message.KEY_DATA_URI, "Landroid/net/Uri;", "result", "dismissProgress", "getAppAccountData", "data", "getAppAccountInfo", "getAppAccountInfoV2", "scope", "getAppBaseInfo", "getAuthCode", "userId", "getConfigJsonData", "getDelegate", "Landroidx/appcompat/app/AppCompatDelegate;", "getGalleryPermissionBean", "Lcom/wear/bean/GalleryPermissionBean;", "getProcessName", "getScope", "getScopeList", "goToXRemoteActivity", "initCokies", "initData", "initView", "injectJavaScript", XHTMLText.CODE, "interceptDevModel", "loadLaunchUrl", "onActivityResult", "requestCode", "resultCode", "intent", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onGetAppAccountFail", "onGetAppAccountListEmpty", "onGetAppAccountMessageFail", "onGetAppAccountSuccess", "onGetAppAccountV2Success", "onGetAppcationError", "onGetAuthCode", "onGetAutoCodeFail", "onGetProtocol", "onGetProtocolError", "onGetWhiteList", "Lcom/wear/bean/GalleryDetailsV2Bean;", "onGetWhiteListError", "onMessage", "", TtmlNode.ATTR_ID, "saveBase64ImageToGallery", "context", "base64Data", "saveImageToPhotosAlbum", "fileData", "setRotate", "rotate", "showAuthorizedLoginPop", "appAccountId", "isAutoCode", "(Lcom/wear/bean/XRemoteAppUserBean$DataBean;Ljava/lang/String;Ljava/lang/Boolean;)V", "showDevelopButton", "it", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "showErrorMsg", "errorMsg", "pullToRefresh", "showNormalButton", "showProgress", "showProtocolPop", "upDateJs", ImagesContract.URL, "upDateTestJs", "updateStatusBar", "orientation", "updateToolBarMarginTop", "webViewSetPath", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class XRemoteActivity extends CordovaActivity implements u23 {

    @NotNull
    public String[] A;

    @Nullable
    public String B;

    @Nullable
    public XRemoteAppUserBean.DataBean C;

    @Nullable
    public CheckProtocolBean D;
    public bs3 c;
    public r23 d;

    @Nullable
    public h14 e;

    @Nullable
    public Subscription g;

    @Nullable
    public CallbackContext h;

    @Nullable
    public XRemoteAppUserBean.DataBean i;

    @Nullable
    public XRemoteAuthorizedLoginPop j;

    @Nullable
    public XRemotePolicyPop k;

    @Nullable
    public XRemotePermissionPop l;

    @Nullable
    public String m;

    @Nullable
    public String n;

    @Nullable
    public String o;

    @Nullable
    public String p;

    @Nullable
    public ArrayList<String> q;
    public boolean r;
    public boolean s;

    @Nullable
    public Boolean v;

    @Nullable
    public Boolean w;

    @Nullable
    public XRemoteDevDialog x;

    @NotNull
    public ArrayList<String> y;

    @Nullable
    public String z;
    public final int a = 1;
    public final int b = 3456789;

    @NotNull
    public final pc1 f = pc1.a;

    @Nullable
    public String t = "";

    @Nullable
    public Long u = 0L;

    /* compiled from: XRemoteActivity.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[XRemoteDevDialog.b.values().length];
            iArr[XRemoteDevDialog.b.COMMON_SETTING.ordinal()] = 1;
            iArr[XRemoteDevDialog.b.COMMON_PATTERNS_TOYS.ordinal()] = 2;
            iArr[XRemoteDevDialog.b.APP_GALLERY_BUTTON_REOPEN.ordinal()] = 3;
            iArr[XRemoteDevDialog.b.CANCEL.ordinal()] = 4;
            a = iArr;
        }
    }

    /* compiled from: XRemoteActivity.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.xremote.activity.XRemoteActivity$countDownCoroutines$1", f = "XRemoteActivity.kt", i = {0, 1}, l = {1636, 1637}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
    public static final class b extends SuspendLambda implements Function2<u34<? super Integer>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        public int label;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            b bVar = new b(continuation);
            bVar.L$0 = obj;
            return bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull u34<? super Integer> u34Var, @Nullable Continuation<? super Unit> continuation) {
            return ((b) create(u34Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0040 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x004d A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004b -> B:12:0x0031). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L29
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r1 = r6.L$0
                dc.u34 r1 = (dc.u34) r1
                kotlin.ResultKt.throwOnFailure(r7)
                r7 = r1
                goto L30
            L17:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1f:
                java.lang.Object r1 = r6.L$0
                dc.u34 r1 = (dc.u34) r1
                kotlin.ResultKt.throwOnFailure(r7)
                r7 = r1
                r1 = r6
                goto L41
            L29:
                kotlin.ResultKt.throwOnFailure(r7)
                java.lang.Object r7 = r6.L$0
                dc.u34 r7 = (dc.u34) r7
            L30:
                r1 = r6
            L31:
                r4 = 0
                java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
                r1.L$0 = r7
                r1.label = r3
                java.lang.Object r4 = r7.emit(r4, r1)
                if (r4 != r0) goto L41
                return r0
            L41:
                r4 = 500(0x1f4, double:2.47E-321)
                r1.L$0 = r7
                r1.label = r2
                java.lang.Object r4 = dc.h04.a(r4, r1)
                if (r4 != r0) goto L31
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.xremote.activity.XRemoteActivity.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: XRemoteActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.xremote.activity.XRemoteActivity$countDownCoroutines$2", f = "XRemoteActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Function1<Integer, Unit> $onTick;
        public /* synthetic */ int I$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super Integer, Unit> function1, Continuation<? super c> continuation) {
            super(2, continuation);
            this.$onTick = function1;
        }

        @Nullable
        public final Object c(int i, @Nullable Continuation<? super Unit> continuation) {
            return ((c) create(Integer.valueOf(i), continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            c cVar = new c(this.$onTick, continuation);
            cVar.I$0 = ((Number) obj).intValue();
            return cVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super Unit> continuation) {
            return c(num.intValue(), continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            int i = this.I$0;
            Function1<Integer, Unit> function1 = this.$onTick;
            if (function1 != null) {
                function1.invoke(Boxing.boxInt(i));
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: XRemoteActivity.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/wear/ui/discover/xremote/activity/XRemoteActivity$getConfigJsonData$1", "Lokhttp3/Callback;", "onFailure", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", SaslStreamElements.Response.ELEMENT, "Lokhttp3/Response;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d implements bc4 {
        public final /* synthetic */ String b;

        public d(String str) {
            this.b = str;
        }

        @Override // dc.bc4
        public void onFailure(@NotNull ac4 call, @NotNull IOException e) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(e, "e");
            sg3.h(R.string.music_record_net_connect_error_tip);
            e.printStackTrace();
        }

        @Override // dc.bc4
        public void onResponse(@NotNull ac4 call, @NotNull ad4 response) throws IOException {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            if (response.f() == 404) {
                sg3.l(ah4.e(R.string.app_gallery_debug_tip1));
                return;
            }
            try {
                if (response.f() != 200 || response.b() == null) {
                    sg3.l(ah4.e(R.string.common_netError));
                    return;
                }
                Gson gson = new Gson();
                bd4 bd4VarB = response.b();
                Intrinsics.checkNotNull(bd4VarB);
                AppGalleryScanBean appGalleryScanBean = (AppGalleryScanBean) gson.fromJson(bd4VarB.string(), AppGalleryScanBean.class);
                List<String> listComponent1 = appGalleryScanBean.component1();
                String version = appGalleryScanBean.getVersion();
                String appId = appGalleryScanBean.getAppId();
                String appVersion = appGalleryScanBean.getAppVersion();
                XRemoteActivity xRemoteActivity = XRemoteActivity.this;
                if (appId == null) {
                    sg3.l(ah4.e(R.string.app_gallery_debug_tip2));
                    return;
                }
                xRemoteActivity.m = appId;
                XRemoteActivity xRemoteActivity2 = XRemoteActivity.this;
                if (appVersion == null) {
                    sg3.l(ah4.e(R.string.app_gallery_debug_tip4));
                    return;
                }
                xRemoteActivity2.p = appVersion;
                XRemoteActivity xRemoteActivity3 = XRemoteActivity.this;
                if (version == null) {
                    sg3.l(ah4.e(R.string.app_gallery_debug_tip3));
                    return;
                }
                xRemoteActivity3.o = version;
                if (pg3.h().g().contains(Uri.parse(this.b).getHost()) || eg3.d(XRemoteActivity.this, "switchWihteList", false)) {
                    XRemoteActivity xRemoteActivity4 = XRemoteActivity.this;
                    Intrinsics.checkNotNull(listComponent1, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
                    xRemoteActivity4.x5((ArrayList) listComponent1);
                }
                XRemoteActivity xRemoteActivity5 = XRemoteActivity.this;
                String str = xRemoteActivity5.m;
                Intrinsics.checkNotNull(str);
                String str2 = XRemoteActivity.this.p;
                Intrinsics.checkNotNull(str2);
                String str3 = XRemoteActivity.this.o;
                Intrinsics.checkNotNull(str3);
                xRemoteActivity5.e5(str, str2, str3, this.b, XRemoteActivity.this.Q4());
            } catch (JsonSyntaxException e) {
                if (e.getCause() instanceof IllegalStateException) {
                    sg3.l("JsonSyntaxException");
                } else {
                    sg3.l(ah4.e(R.string.common_netError));
                }
            }
        }
    }

    /* compiled from: XRemoteActivity.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/wear/ui/discover/xremote/activity/XRemoteActivity$getGalleryPermissionBean$map$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e extends TypeToken<Map<String, ? extends String>> {
    }

    /* compiled from: XRemoteActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f extends Lambda implements Function0<Unit> {
        public final /* synthetic */ CallbackContext $callbackContext;
        public final /* synthetic */ GalleryPermission $galleryPermission;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(GalleryPermission galleryPermission, CallbackContext callbackContext) {
            super(0);
            this.$galleryPermission = galleryPermission;
            this.$callbackContext = callbackContext;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$galleryPermission.setPermission(Boolean.TRUE);
            this.$callbackContext.success();
        }
    }

    /* compiled from: XRemoteActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g extends Lambda implements Function0<Unit> {
        public final /* synthetic */ CallbackContext $callbackContext;
        public final /* synthetic */ GalleryPermission $galleryPermission;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(GalleryPermission galleryPermission, CallbackContext callbackContext) {
            super(0);
            this.$galleryPermission = galleryPermission;
            this.$callbackContext = callbackContext;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$galleryPermission.setPermission(Boolean.FALSE);
            this.$callbackContext.error(s23.a.a(ErrorCode.Error21208.INSTANCE));
        }
    }

    /* compiled from: XRemoteActivity.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/wear/ui/discover/xremote/activity/XRemoteActivity$getScope$1$map$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class h extends TypeToken<Map<String, ? extends String>> {
    }

    /* compiled from: XRemoteActivity.kt */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/wear/ui/discover/xremote/activity/XRemoteActivity$initData$map$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class i extends TypeToken<Map<String, ? extends String>> {
    }

    /* compiled from: XRemoteActivity.kt */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001e\u0010\t\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\n\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"com/wear/ui/discover/xremote/activity/XRemoteActivity$saveImageToPhotosAlbum$1", "Lcom/hjq/permissions/OnPermissionCallback;", "onDenied", "", "permissions", "", "", "never", "", "onGranted", TtmlNode.COMBINE_ALL, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class j implements u51 {
        public final /* synthetic */ CallbackContext b;
        public final /* synthetic */ String c;

        public j(CallbackContext callbackContext, String str) {
            this.b = callbackContext;
            this.c = str;
        }

        @Override // dc.u51
        public void a(@NotNull List<String> permissions, boolean z) {
            CallbackContext callbackContext;
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            if (!z || (callbackContext = this.b) == null) {
                return;
            }
            callbackContext.error(s23.a.a(ErrorCode.Error21107.INSTANCE));
        }

        @Override // dc.u51
        public void b(@NotNull List<String> permissions, boolean z) throws JsonSyntaxException, FileNotFoundException {
            Object next;
            Intrinsics.checkNotNullParameter(permissions, "permissions");
            if (!z) {
                CallbackContext callbackContext = this.b;
                if (callbackContext != null) {
                    callbackContext.error(s23.a.a(ErrorCode.Error21207.INSTANCE));
                    return;
                }
                return;
            }
            GalleryPermissionBean galleryPermissionBeanX4 = XRemoteActivity.this.X4();
            if (galleryPermissionBeanX4 != null) {
                CallbackContext callbackContext2 = this.b;
                XRemoteActivity xRemoteActivity = XRemoteActivity.this;
                String str = this.c;
                if (!Intrinsics.areEqual(galleryPermissionBeanX4.getGalleryAccountId(), ch3.n().o().getRemoteAccountId())) {
                    if (callbackContext2 != null) {
                        callbackContext2.error(s23.a.a(ErrorCode.Error21209.INSTANCE));
                        return;
                    }
                    return;
                }
                List<GalleryPermission> galleryPermission = galleryPermissionBeanX4.getGalleryPermission();
                if (galleryPermission != null) {
                    Iterator<T> it = galleryPermission.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        } else {
                            next = it.next();
                            if (Intrinsics.areEqual(((GalleryPermission) next).getScope(), "scope.writePhotosAlbum")) {
                                break;
                            }
                        }
                    }
                    GalleryPermission galleryPermission2 = (GalleryPermission) next;
                    if (galleryPermission2 != null) {
                        if (!Intrinsics.areEqual(galleryPermission2.getIsPermission(), Boolean.FALSE)) {
                            xRemoteActivity.v5(xRemoteActivity, str, callbackContext2);
                        } else if (callbackContext2 != null) {
                            callbackContext2.error(s23.a.a(ErrorCode.Error21208.INSTANCE));
                        }
                    }
                }
            }
        }
    }

    /* compiled from: XRemoteActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class k extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $appAccountId;
        public final /* synthetic */ XRemoteActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(String str, XRemoteActivity xRemoteActivity) {
            super(0);
            this.$appAccountId = str;
            this.this$0 = xRemoteActivity;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Bundle bundle = new Bundle();
            bundle.putString("applicationId", this.$appAccountId);
            bundle.putString("applicationName", this.this$0.n);
            XRemoteActivity xRemoteActivity = this.this$0;
            pj3.p(xRemoteActivity, XRemoteCreateCustomUserActivity.class, xRemoteActivity.a, bundle);
        }
    }

    /* compiled from: XRemoteActivity.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "account", "Lcom/wear/bean/XRemoteAppUserBean$DataBean$ApplicationAccount;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class l extends Lambda implements Function1<XRemoteAppUserBean.DataBean.ApplicationAccount, Unit> {
        public final /* synthetic */ String $appAccountId;
        public final /* synthetic */ Ref.BooleanRef $isAllow;
        public final /* synthetic */ Boolean $isAutoCode;
        public final /* synthetic */ XRemoteActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(String str, XRemoteActivity xRemoteActivity, Ref.BooleanRef booleanRef, Boolean bool) {
            super(1);
            this.$appAccountId = str;
            this.this$0 = xRemoteActivity;
            this.$isAllow = booleanRef;
            this.$isAutoCode = bool;
        }

        public final void a(@Nullable XRemoteAppUserBean.DataBean.ApplicationAccount applicationAccount) {
            String lowerCase;
            try {
                String str = this.$appAccountId;
                String str2 = this.this$0.n;
                if (str2 != null) {
                    lowerCase = str2.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                } else {
                    lowerCase = null;
                }
                ye3.j("game", "game_success_activation", "click", str, "button", "1", lowerCase, -1L);
                this.$isAllow.element = true;
                if (Intrinsics.areEqual(this.$isAutoCode, Boolean.TRUE)) {
                    XRemoteActivity xRemoteActivity = this.this$0;
                    xRemoteActivity.V4(xRemoteActivity.getZ(), applicationAccount != null ? applicationAccount.getApplicationAccountId() : null);
                } else {
                    CallbackContext callbackContext = this.this$0.h;
                    if (callbackContext != null) {
                        callbackContext.success(new JSONObject(WearUtils.A.toJson(applicationAccount)));
                    }
                }
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(XRemoteAppUserBean.DataBean.ApplicationAccount applicationAccount) {
            a(applicationAccount);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: XRemoteActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class m extends Lambda implements Function0<Unit> {
        public static final m a = new m();

        public m() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* compiled from: XRemoteActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.xremote.activity.XRemoteActivity$showDevelopButton$2$1$1", f = "XRemoteActivity.kt", i = {}, l = {570}, m = "invokeSuspend", n = {}, s = {})
    public static final class n extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public n(Continuation<? super n> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return XRemoteActivity.this.new n(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((n) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (h04.a(500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            XRemoteActivity xRemoteActivity = XRemoteActivity.this;
            String launchUrl = xRemoteActivity.launchUrl;
            Intrinsics.checkNotNullExpressionValue(launchUrl, "launchUrl");
            xRemoteActivity.h5(launchUrl);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: XRemoteActivity.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class o extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ ImageView $ivToyConnect;
        public final /* synthetic */ XRemoteActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(ImageView imageView, XRemoteActivity xRemoteActivity) {
            super(1);
            this.$ivToyConnect = imageView;
            this.this$0 = xRemoteActivity;
        }

        public final void a(int i) {
            this.$ivToyConnect.setImageResource(this.this$0.f.P().size() == 0 ? R.drawable.toy_disconnect : R.drawable.toy_connect);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            a(num.intValue());
            return Unit.INSTANCE;
        }
    }

    /* compiled from: XRemoteActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class p extends Lambda implements Function0<Unit> {
        public final /* synthetic */ CheckProtocolBean $checkProtocolData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(CheckProtocolBean checkProtocolBean) {
            super(0);
            this.$checkProtocolData = checkProtocolBean;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            String protocolUrl;
            try {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String strE = ah4.e(R.string.gallery_developer_privacy_content2);
                Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.galle…veloper_privacy_content2)");
                String str = String.format(strE, Arrays.copyOf(new Object[]{XRemoteActivity.this.n}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                String str2 = XRemoteActivity.this.m;
                String str3 = "";
                String str4 = str2 == null ? "" : str2;
                CheckProtocolData data = this.$checkProtocolData.getData();
                ku1.a("App Galley", "app_gallery_privacy_protection_tips_allow_click", "click", str4, "button", (data == null || (protocolUrl = data.getProtocolUrl()) == null) ? "" : protocolUrl, str, null);
                XRemoteActivity xRemoteActivity = XRemoteActivity.this;
                r23 r23Var = xRemoteActivity.d;
                if (r23Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mXRemotePresenter");
                    r23Var = null;
                }
                String str5 = XRemoteActivity.this.m;
                if (str5 == null) {
                    str5 = "";
                }
                String str6 = XRemoteActivity.this.p;
                if (str6 != null) {
                    str3 = str6;
                }
                xRemoteActivity.g = r23Var.d(str5, str3, XRemoteActivity.this);
                XRemoteActivity.this.L5();
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* compiled from: XRemoteActivity.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class q extends Lambda implements Function0<Unit> {
        public final /* synthetic */ CheckProtocolBean $checkProtocolData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(CheckProtocolBean checkProtocolBean) {
            super(0);
            this.$checkProtocolData = checkProtocolBean;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            String protocolUrl;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String strE = ah4.e(R.string.gallery_developer_privacy_content2);
            Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.galle…veloper_privacy_content2)");
            String str = String.format(strE, Arrays.copyOf(new Object[]{XRemoteActivity.this.n}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            String str2 = XRemoteActivity.this.m;
            String str3 = str2 == null ? "" : str2;
            CheckProtocolData data = this.$checkProtocolData.getData();
            ku1.a("App Galley", "app_gallery_privacy_protection_tips_cancel_click", "click", str3, "button", (data == null || (protocolUrl = data.getProtocolUrl()) == null) ? "" : protocolUrl, str, null);
            CallbackContext callbackContext = XRemoteActivity.this.h;
            if (callbackContext != null) {
                callbackContext.error(s23.a.a(ErrorCode.Error21206.INSTANCE));
            }
        }
    }

    public XRemoteActivity() {
        Boolean bool = Boolean.FALSE;
        this.v = bool;
        this.w = bool;
        this.y = new ArrayList<>();
        this.A = new String[]{"authUser", "authBase"};
        this.B = "";
    }

    public static /* synthetic */ void A5(XRemoteActivity xRemoteActivity, XRemoteAppUserBean.DataBean dataBean, String str, Boolean bool, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            bool = Boolean.FALSE;
        }
        xRemoteActivity.z5(dataBean, str, bool);
    }

    public static final void B5(Ref.BooleanRef isAllow, XRemoteActivity this$0, DialogInterface dialogInterface) {
        CallbackContext callbackContext;
        Intrinsics.checkNotNullParameter(isAllow, "$isAllow");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (isAllow.element || (callbackContext = this$0.h) == null) {
            return;
        }
        callbackContext.error(s23.a.a(ErrorCode.Error21200.INSTANCE));
    }

    public static final void D5(final XRemoteActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.postDelayed(new Runnable() { // from class: dc.e23
            @Override // java.lang.Runnable
            public final void run() {
                XRemoteActivity.E5(this.a);
            }
        }, 200L);
    }

    public static final void E5(XRemoteActivity this$0) {
        String lowerCase;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f.u0();
        Long l2 = this$0.u;
        if ((l2 != null ? l2.longValue() : 0L) > 0) {
            Intent intent = new Intent();
            intent.putExtra(RemoteConfigConstants.RequestFieldKey.APP_ID, this$0.m);
            long jCurrentTimeMillis = System.currentTimeMillis();
            Long l3 = this$0.u;
            intent.putExtra(TypedValues.TransitionType.S_DURATION, jCurrentTimeMillis - (l3 != null ? l3.longValue() : 0L));
            String str = this$0.n;
            if (str != null) {
                lowerCase = str.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            } else {
                lowerCase = null;
            }
            intent.putExtra("applicationName", lowerCase);
            this$0.setResult(this$0.b, intent);
        }
        this$0.finish();
    }

    public static final void F5(final XRemoteActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        XRemoteDevDialog xRemoteDevDialog = new XRemoteDevDialog(this$0, new XRemoteDevDialog.a() { // from class: dc.f23
            @Override // com.wear.widget.XRemoteDevDialog.a
            public final void a(XRemoteDevDialog.b bVar) {
                XRemoteActivity.G5(this.a, bVar);
            }
        });
        this$0.x = xRemoteDevDialog;
        if (xRemoteDevDialog != null) {
            xRemoteDevDialog.show();
        }
    }

    public static final void G5(XRemoteActivity this$0, XRemoteDevDialog.b bVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i2 = bVar == null ? -1 : a.a[bVar.ordinal()];
        if (i2 == 1) {
            new CacheGalleryBottomDialog(this$0, R.layout.dialog_gallery_cache).show();
            return;
        }
        if (i2 == 2) {
            CordovaPlugin plugin = this$0.getPluginManage().getPlugin("appGalleryToy");
            Intrinsics.checkNotNull(plugin, "null cannot be cast to non-null type org.apache.cordova.gallery.XRemoteToyPlugin");
            ((XRemoteToyPlugin) plugin).openMyToysDialog();
        } else {
            if (i2 != 3) {
                return;
            }
            this$0.finish();
            uy3.d(a14.a, null, null, this$0.new n(null), 3, null);
        }
    }

    public static final void I5(final XRemoteActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        view.postDelayed(new Runnable() { // from class: dc.a23
            @Override // java.lang.Runnable
            public final void run() {
                XRemoteActivity.J5(this.a);
            }
        }, 200L);
    }

    public static final void J5(XRemoteActivity this$0) {
        String lowerCase;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f.u0();
        Long l2 = this$0.u;
        if ((l2 != null ? l2.longValue() : 0L) > 0) {
            Intent intent = new Intent();
            intent.putExtra(RemoteConfigConstants.RequestFieldKey.APP_ID, this$0.m);
            long jCurrentTimeMillis = System.currentTimeMillis();
            Long l3 = this$0.u;
            intent.putExtra(TypedValues.TransitionType.S_DURATION, jCurrentTimeMillis - (l3 != null ? l3.longValue() : 0L));
            String str = this$0.n;
            if (str != null) {
                lowerCase = str.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            } else {
                lowerCase = null;
            }
            intent.putExtra("applicationName", lowerCase);
            this$0.setResult(this$0.b, intent);
        }
        this$0.finish();
    }

    public static final void K5(XRemoteActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CordovaPlugin plugin = this$0.getPluginManage().getPlugin("appGalleryToy");
        Intrinsics.checkNotNull(plugin, "null cannot be cast to non-null type org.apache.cordova.gallery.XRemoteToyPlugin");
        ((XRemoteToyPlugin) plugin).openMyToysDialog();
    }

    public static /* synthetic */ void N4(XRemoteActivity xRemoteActivity, XRemoteAppUserBean.DataBean dataBean, CheckProtocolBean checkProtocolBean, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            dataBean = null;
        }
        if ((i2 & 2) != 0) {
            checkProtocolBean = null;
        }
        xRemoteActivity.M4(dataBean, checkProtocolBean);
    }

    public static final void b5(final XRemoteActivity this$0, CallbackContext callbackContext, String str) throws JsonSyntaxException {
        Map linkedHashMap;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callbackContext, "$callbackContext");
        String strH = eg3.h(this$0, "permission_record", "");
        if (strH == null || strH.length() == 0) {
            linkedHashMap = new LinkedHashMap();
        } else {
            Object objFromJson = new Gson().fromJson(strH, new h().getType());
            Intrinsics.checkNotNullExpressionValue(objFromJson, "{\n                    Gs…}.type)\n                }");
            linkedHashMap = (Map) objFromJson;
        }
        final Map mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap);
        String str2 = "map====" + strH;
        this$0.h = callbackContext;
        final GalleryPermissionBean galleryPermissionBean = new GalleryPermissionBean();
        galleryPermissionBean.setGalleryAccountId(ch3.n().o().getRemoteAccountId());
        final GalleryPermission galleryPermission = new GalleryPermission();
        galleryPermission.setScope(str);
        String str3 = this$0.n;
        String str4 = this$0.t;
        XRemotePermissionPop xRemotePermissionPop = new XRemotePermissionPop(this$0, str4 != null ? str4 : "", str3, "Requests to save images to your album.");
        this$0.l = xRemotePermissionPop;
        if (xRemotePermissionPop != null) {
            xRemotePermissionPop.k(new f(galleryPermission, callbackContext), new g(galleryPermission, callbackContext));
        }
        XRemotePermissionPop xRemotePermissionPop2 = this$0.l;
        if (xRemotePermissionPop2 != null) {
            xRemotePermissionPop2.show();
        }
        XRemotePermissionPop xRemotePermissionPop3 = this$0.l;
        if (xRemotePermissionPop3 != null) {
            xRemotePermissionPop3.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: dc.v13
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    XRemoteActivity.c5(galleryPermissionBean, galleryPermission, this$0, mutableMap, dialogInterface);
                }
            });
        }
    }

    public static final void c5(GalleryPermissionBean galleryPermissionBean, GalleryPermission galleryPermission, XRemoteActivity this$0, Map map, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(galleryPermissionBean, "$galleryPermissionBean");
        Intrinsics.checkNotNullParameter(galleryPermission, "$galleryPermission");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(map, "$map");
        List<GalleryPermission> galleryPermission2 = galleryPermissionBean.getGalleryPermission();
        if (galleryPermission2 != null) {
            galleryPermission2.add(galleryPermission);
        }
        String str = this$0.m;
        if (str != null) {
            String json = new Gson().toJson(galleryPermissionBean);
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(galleryPermissionBean)");
            map.put(str, json);
        }
        eg3.i(this$0, "permission_record", new Gson().toJson(map));
    }

    public static final void u5(XRemoteActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t5();
    }

    public final void C5(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(R.layout.game_common_button_develop, viewGroup, true);
        ((ImageView) viewInflate.findViewById(R.id.iv_game_close)).setOnClickListener(new View.OnClickListener() { // from class: dc.w13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XRemoteActivity.D5(this.a, view);
            }
        });
        ((ImageView) viewInflate.findViewById(R.id.iv_game_more)).setOnClickListener(new View.OnClickListener() { // from class: dc.b23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XRemoteActivity.F5(this.a, view);
            }
        });
    }

    @Override // dc.u23
    public void D0() {
        CallbackContext callbackContext = this.h;
        if (callbackContext != null) {
            callbackContext.error(s23.a.a(ErrorCode.Error21202.INSTANCE));
        }
    }

    public final void H5(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View viewInflate = layoutInflater.inflate(R.layout.game_common_button, viewGroup, true);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_toy_connect);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.d23
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XRemoteActivity.K5(this.a, view);
            }
        });
        this.e = L4(new o(imageView, this));
        ((ImageView) viewInflate.findViewById(R.id.iv_game_close)).setOnClickListener(new View.OnClickListener() { // from class: dc.x13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                XRemoteActivity.I5(this.a, view);
            }
        });
    }

    public final JSONObject I4(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("username", str);
        jSONObject.put("cToken", str2);
        return jSONObject;
    }

    public final JSONObject J4(String str, String str2, String str3, boolean z, boolean z2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("SDKVersion", str);
        jSONObject.put("language", str2);
        jSONObject.put("version", str3);
        jSONObject.put("accountDidUpdate", z);
        jSONObject.put("userInfoDidUpdate", z2);
        return jSONObject;
    }

    public final JSONObject K4(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("authCode", str);
        return jSONObject;
    }

    public final h14 L4(Function1<? super Integer, Unit> function1) {
        return v34.n(v34.q(v34.m(v34.k(new b(null)), n04.c()), new c(function1, null)), LifecycleOwnerKt.getLifecycleScope(this));
    }

    public final void L5() {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        bs3 bs3Var = this.c;
        bs3 bs3Var2 = null;
        if (bs3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
            bs3Var = null;
        }
        if (bs3Var.isShowing()) {
            return;
        }
        bs3 bs3Var3 = this.c;
        if (bs3Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        } else {
            bs3Var2 = bs3Var3;
        }
        bs3Var2.show();
    }

    public final void M4(XRemoteAppUserBean.DataBean dataBean, CheckProtocolBean checkProtocolBean) {
        CheckProtocolData data;
        CheckProtocolData data2;
        if (dataBean != null) {
            this.C = dataBean;
        }
        if (checkProtocolBean != null) {
            this.D = checkProtocolBean;
        }
        if (this.C == null || this.D == null) {
            return;
        }
        String protocolStatus = null;
        if (!Intrinsics.areEqual(this.z, "authUser")) {
            CheckProtocolBean checkProtocolBean2 = this.D;
            if (checkProtocolBean2 != null && (data = checkProtocolBean2.getData()) != null) {
                protocolStatus = data.getProtocolStatus();
            }
            if (!Intrinsics.areEqual(protocolStatus, "unaccepted")) {
                R4(this.C);
                return;
            }
            CheckProtocolBean checkProtocolBean3 = this.D;
            Intrinsics.checkNotNull(checkProtocolBean3);
            M5(checkProtocolBean3);
            return;
        }
        CheckProtocolBean checkProtocolBean4 = this.D;
        if (checkProtocolBean4 != null && (data2 = checkProtocolBean4.getData()) != null) {
            protocolStatus = data2.getProtocolStatus();
        }
        if (Intrinsics.areEqual(protocolStatus, "unaccepted")) {
            CheckProtocolBean checkProtocolBean5 = this.D;
            Intrinsics.checkNotNull(checkProtocolBean5);
            M5(checkProtocolBean5);
        } else {
            if (Intrinsics.areEqual(protocolStatus, "accepted")) {
                R4(this.C);
                return;
            }
            CallbackContext callbackContext = this.h;
            if (callbackContext != null) {
                callbackContext.error(s23.a.a(ErrorCode.Error21205.INSTANCE));
            }
        }
    }

    public final void M5(CheckProtocolBean checkProtocolBean) {
        String protocolUrl;
        XRemotePolicyPop xRemotePolicyPop = new XRemotePolicyPop(this, this.t, this.n, checkProtocolBean);
        xRemotePolicyPop.l(new p(checkProtocolBean), new q(checkProtocolBean));
        this.k = xRemotePolicyPop;
        if (xRemotePolicyPop != null) {
            xRemotePolicyPop.show();
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String strE = ah4.e(R.string.gallery_developer_privacy_content2);
        Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.galle…veloper_privacy_content2)");
        String str = String.format(strE, Arrays.copyOf(new Object[]{this.n}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        String str2 = this.m;
        String str3 = str2 == null ? "" : str2;
        CheckProtocolData data = checkProtocolBean.getData();
        ku1.a("App Galley", "app_gallery_privacy_protection_tips_popup_exposure", "exposure", str3, "popup", (data == null || (protocolUrl = data.getProtocolUrl()) == null) ? "" : protocolUrl, str, null);
    }

    @Override // dc.u23
    public void N0() {
        CallbackContext callbackContext = this.h;
        if (callbackContext != null) {
            callbackContext.error(s23.a.a(ErrorCode.Error21204.INSTANCE));
        }
    }

    public final String N5(String str, String str2) {
        String str3 = "javascript:(function() {var script = document.createElement('script');script.src = '" + str + "/appgallery/android/" + str2 + "/cordova.js';document.body.appendChild(script);})()";
        Intrinsics.checkNotNullExpressionValue(str3, "sb.toString()");
        return str3;
    }

    public final void O4(Uri uri, String str) {
        String str2;
        if (WearUtils.e1(this.m) || WearUtils.e1(this.p) || WearUtils.e1(this.o)) {
            str2 = uri.getHost() + "/appgallery_config.json";
        } else {
            str2 = "";
        }
        if (!WearUtils.e1(str2)) {
            W4(str);
            return;
        }
        String str3 = this.m;
        Intrinsics.checkNotNull(str3);
        String str4 = this.p;
        Intrinsics.checkNotNull(str4);
        String str5 = this.o;
        Intrinsics.checkNotNull(str5);
        e5(str3, str4, str5, str, this.y);
    }

    public final void O5(int i2) {
        if (i2 == 2) {
            getWindow().addFlags(1024);
            if (Build.VERSION.SDK_INT >= 23) {
                kg3.k(this, WearUtils.Y0());
                return;
            }
            return;
        }
        getWindow().clearFlags(1024);
        if (Build.VERSION.SDK_INT >= 23) {
            getWindow().getDecorView().setSystemUiVisibility(0);
            getWindow().clearFlags(Integer.MIN_VALUE);
        }
    }

    public final void P4() {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        bs3 bs3Var = this.c;
        bs3 bs3Var2 = null;
        if (bs3Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
            bs3Var = null;
        }
        if (bs3Var.isShowing()) {
            bs3 bs3Var3 = this.c;
            if (bs3Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
            } else {
                bs3Var2 = bs3Var3;
            }
            bs3Var2.dismiss();
        }
    }

    public final void P5(int i2) {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_tool_bar);
        if (linearLayout != null) {
            ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                if (i2 == 2) {
                    layoutParams2.topMargin = ce3.a(this, 16.0f);
                } else {
                    layoutParams2.topMargin = ce3.a(this, 44.0f);
                }
                linearLayout.setLayoutParams(layoutParams2);
            }
        }
    }

    @Override // dc.u23
    public void Q2(@Nullable XRemoteAppUserBean.DataBean dataBean) throws NumberFormatException {
        XRemoteAppUserBean.DataBean dataBean2;
        List<XRemoteAppUserBean.DataBean.ApplicationAccount> applicationAccountList;
        XRemoteAppUserBean.DataBean.Application application;
        this.r = false;
        this.i = dataBean;
        StringBuilder sb = new StringBuilder();
        XRemoteAppUserBean.DataBean dataBean3 = this.i;
        Object obj = null;
        sb.append((dataBean3 == null || (application = dataBean3.getApplication()) == null) ? null : application.getApplicationInfo());
        sb.append('_');
        sb.append(ch3.n().x().getId());
        String strH = eg3.h(this, sb.toString(), null);
        if (!(strH == null || strH.length() == 0)) {
            List listSplit$default = StringsKt__StringsKt.split$default((CharSequence) strH, new String[]{Config.IN_FIELD_SEPARATOR}, false, 0, 6, (Object) null);
            if (listSplit$default.size() == 2) {
                long j2 = Long.parseLong((String) listSplit$default.get(1));
                Object obj2 = listSplit$default.get(0);
                if (System.currentTimeMillis() - j2 < 1209600000 && (dataBean2 = this.i) != null && (applicationAccountList = dataBean2.getApplicationAccountList()) != null) {
                    for (XRemoteAppUserBean.DataBean.ApplicationAccount applicationAccount : applicationAccountList) {
                        if (Intrinsics.areEqual(applicationAccount.getApplicationAccountId(), obj2)) {
                            try {
                                CallbackContext callbackContext = this.h;
                                if (callbackContext != null) {
                                    String username = applicationAccount.getUsername();
                                    String str = "";
                                    if (username == null) {
                                        username = "";
                                    }
                                    String ctoken = applicationAccount.getCtoken();
                                    if (ctoken != null) {
                                        str = ctoken;
                                    }
                                    callbackContext.success(I4(username, str));
                                    return;
                                }
                                return;
                            } catch (JSONException e2) {
                                throw new RuntimeException(e2);
                            }
                        }
                    }
                }
                obj = obj2;
            }
        }
        A5(this, dataBean, (String) obj, null, 4, null);
    }

    @NotNull
    public final ArrayList<String> Q4() {
        return this.y;
    }

    public final void Q5() {
        if (Build.VERSION.SDK_INT >= 28) {
            String strZ4 = Z4();
            if (Intrinsics.areEqual(getPackageName(), strZ4) || strZ4 == null) {
                return;
            }
            WebView.setDataDirectorySuffix(strZ4);
        }
    }

    public final void R4(XRemoteAppUserBean.DataBean dataBean) {
        List<XRemoteAppUserBean.DataBean.ApplicationAccount> applicationAccountList;
        Object next;
        if (dataBean == null || (applicationAccountList = dataBean.getApplicationAccountList()) == null) {
            return;
        }
        if (!Intrinsics.areEqual(this.z, "authBase")) {
            z5(dataBean, "", Boolean.TRUE);
            return;
        }
        Iterator<T> it = applicationAccountList.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (Intrinsics.areEqual(((XRemoteAppUserBean.DataBean.ApplicationAccount) next).getAccountType(), "lovense_user_name")) {
                    break;
                }
            }
        }
        XRemoteAppUserBean.DataBean.ApplicationAccount applicationAccount = (XRemoteAppUserBean.DataBean.ApplicationAccount) next;
        if (applicationAccount != null) {
            V4(this.z, applicationAccount.getApplicationAccountId());
            return;
        }
        CallbackContext callbackContext = this.h;
        if (callbackContext != null) {
            callbackContext.error(s23.a.a(ErrorCode.Error21202.INSTANCE));
        }
    }

    @Override // dc.u23
    public void S1() {
        P4();
        sg3.i(this, R.string.gallery_developer_toast2);
    }

    public final void S4(@Nullable String str, @NotNull CallbackContext callbackContext) {
        Intrinsics.checkNotNullParameter(callbackContext, "callbackContext");
        if (this.r) {
            return;
        }
        this.r = true;
        r23 r23Var = this.d;
        if (r23Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mXRemotePresenter");
            r23Var = null;
        }
        this.g = r23Var.e(str, this);
        this.h = callbackContext;
    }

    @Override // dc.u23
    public void T(@Nullable GalleryDetailsV2Bean galleryDetailsV2Bean) {
        if (galleryDetailsV2Bean == null) {
            sg3.i(this, R.string.gallery_developer_toast2);
            finish();
            return;
        }
        Integer code = galleryDetailsV2Bean.getCode();
        if (code != null && code.intValue() == 1) {
            sg3.l(ah4.e(R.string.app_gallery_debug_tip5));
        } else if (code != null && code.intValue() == 2) {
            sg3.k(this, galleryDetailsV2Bean.getMessage());
        } else if (code != null && code.intValue() == 3) {
            sg3.l(ah4.e(R.string.app_gallery_debug_tip6));
        }
        finish();
    }

    public final void T4(@Nullable String str, @NotNull CallbackContext callbackContext) {
        Intrinsics.checkNotNullParameter(callbackContext, "callbackContext");
        this.h = callbackContext;
        if (!MyApplication.P) {
            callbackContext.error(s23.a.a(ErrorCode.Error21201.INSTANCE));
            return;
        }
        if (!ArraysKt___ArraysKt.contains(this.A, str)) {
            callbackContext.error(s23.a.a(ErrorCode.Error10001.INSTANCE));
            return;
        }
        this.z = str;
        this.r = true;
        r23 r23Var = null;
        this.C = null;
        this.D = null;
        r23 r23Var2 = this.d;
        if (r23Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mXRemotePresenter");
            r23Var2 = null;
        }
        this.g = r23Var2.h(this.m, this.p, this);
        r23 r23Var3 = this.d;
        if (r23Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mXRemotePresenter");
        } else {
            r23Var = r23Var3;
        }
        this.g = r23Var.f(this.m, this.p, this);
    }

    public final void U4(@Nullable CallbackContext callbackContext) {
        String language = lg3.c(lg3.e(this));
        if (callbackContext != null) {
            Intrinsics.checkNotNullExpressionValue(language, "language");
            String APP_VERSION = WearUtils.q;
            Intrinsics.checkNotNullExpressionValue(APP_VERSION, "APP_VERSION");
            Boolean bool = this.w;
            boolean zBooleanValue = bool != null ? bool.booleanValue() : false;
            Boolean bool2 = this.v;
            callbackContext.success(J4("2.0.0", language, APP_VERSION, zBooleanValue, bool2 != null ? bool2.booleanValue() : false));
        }
    }

    @Override // dc.u23
    public void V0() {
        sg3.i(this, R.string.gallery_developer_toast2);
    }

    public final void V4(String str, String str2) {
        this.r = true;
        r23 r23Var = this.d;
        if (r23Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mXRemotePresenter");
            r23Var = null;
        }
        this.g = r23Var.g(str, this.m, str2, this.p, this);
    }

    public final void W4(String str) {
        vc4 vc4Var = new vc4();
        String string = Uri.parse(str).buildUpon().clearQuery().build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "parsedUri.buildUpon().cl…uery().build().toString()");
        String str2 = StringsKt__StringsJVMKt.replace$default(string, "/index.html", "", false, 4, (Object) null) + "/appgallery_config.json";
        String str3 = "Remote/" + WearUtils.q + " (" + Build.MODEL + ";Android" + Build.VERSION.RELEASE + ") AppGallery/2.0.0";
        String str4 = "请求头" + str3;
        yc4.a aVar = new yc4.a();
        aVar.k(str2);
        aVar.e("User-Agent", str3);
        try {
            vc4Var.a(aVar.b()).j(new d(str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final GalleryPermissionBean X4() throws JsonSyntaxException {
        Map linkedHashMap;
        String str;
        String str2 = "";
        String strH = eg3.h(this, "permission_record", "");
        if (strH == null || strH.length() == 0) {
            linkedHashMap = new LinkedHashMap();
        } else {
            Object objFromJson = new Gson().fromJson(strH, new e().getType());
            Intrinsics.checkNotNullExpressionValue(objFromJson, "{\n            Gson().fro…ng>>() {}.type)\n        }");
            linkedHashMap = (Map) objFromJson;
        }
        Map mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap);
        String str3 = this.m;
        if (str3 != null && (str = (String) mutableMap.get(str3)) != null) {
            str2 = str;
        }
        return (GalleryPermissionBean) (str2 != null ? new Gson().fromJson(str2, GalleryPermissionBean.class) : null);
    }

    @Nullable
    /* renamed from: Y4, reason: from getter */
    public final String getZ() {
        return this.z;
    }

    @Override // dc.u23
    public void Z() {
        this.r = false;
        CallbackContext callbackContext = this.h;
        if (callbackContext != null) {
            callbackContext.error(s23.a.a(ErrorCode.Error21202.INSTANCE));
        }
    }

    public final String Z4() {
        Object systemService = getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == Process.myPid()) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public final void a5(@Nullable final String str, @NotNull final CallbackContext callbackContext) {
        Intrinsics.checkNotNullParameter(callbackContext, "callbackContext");
        try {
            runOnUiThread(new Runnable() { // from class: dc.c23
                @Override // java.lang.Runnable
                public final void run() throws JsonSyntaxException {
                    XRemoteActivity.b5(this.a, callbackContext, str);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(@Nullable Context newBase) {
        super.attachBaseContext(newBase);
        Q5();
    }

    @Override // dc.u23
    public void b1(@NotNull CheckProtocolBean data) {
        Intrinsics.checkNotNullParameter(data, "data");
        N4(this, null, data, 1, null);
    }

    @Override // dc.u23
    public void b2(@Nullable String str) {
        CallbackContext callbackContext = this.h;
        if (callbackContext != null) {
            if (str == null) {
                str = "";
            }
            callbackContext.success(K4(str));
        }
    }

    @Override // org.apache.cordova.CordovaActivity
    public void createViews() {
        super.createViews();
        if (eg3.d(this, "switchClearCache", true)) {
            this.appView.clearCache();
        }
        ViewParent parent = this.appView.getView().getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        Uri uri = Uri.parse(this.launchUrl);
        LayoutInflater it = LayoutInflater.from(this);
        if (!this.s || pg3.h().g().contains(uri.getHost())) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            H5(it, viewGroup);
        } else {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            C5(it, viewGroup);
        }
    }

    public final void d5(@NotNull CallbackContext callbackContext) throws JSONException, JsonSyntaxException {
        Intrinsics.checkNotNullParameter(callbackContext, "callbackContext");
        GalleryPermissionBean galleryPermissionBeanX4 = X4();
        if (galleryPermissionBeanX4 == null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("authSetting", MessageFormatter.DELIM_STR);
            String str = "jsonNull====" + jSONObject;
            callbackContext.success(jSONObject);
            return;
        }
        if (Intrinsics.areEqual(galleryPermissionBeanX4.getGalleryAccountId(), ch3.n().o().getRemoteAccountId())) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            List<GalleryPermission> galleryPermission = galleryPermissionBeanX4.getGalleryPermission();
            if (galleryPermission != null) {
                for (GalleryPermission galleryPermission2 : galleryPermission) {
                    String scope = galleryPermission2.getScope();
                    if (scope != null) {
                        Boolean isPermission = galleryPermission2.getIsPermission();
                        linkedHashMap.put(scope, Boolean.valueOf(isPermission != null ? isPermission.booleanValue() : false));
                    }
                }
            }
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                jSONObject2.put((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue());
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("authSetting", jSONObject2);
            String str2 = "jsonString====" + jSONObject3;
            callbackContext.success(jSONObject3);
        }
    }

    public final boolean e5(String str, String str2, String str3, String str4, ArrayList<String> arrayList) {
        boolean zD = eg3.d(this, "switchDevelopModel", false);
        if (WearUtils.e1(str)) {
            sg3.l(ah4.e(R.string.app_gallery_debug_tip2));
            return false;
        }
        if (WearUtils.e1(str2)) {
            sg3.l(ah4.e(R.string.app_gallery_debug_tip4));
            return false;
        }
        if (WearUtils.e1(str3)) {
            sg3.l(ah4.e(R.string.app_gallery_debug_tip3));
            return false;
        }
        if (!zD) {
            sg3.l(ah4.e(R.string.xremote_incorrect_debug_qr));
            return false;
        }
        if (t23.a.a(str3)) {
            Bundle bundle = new Bundle();
            bundle.putString(ImagesContract.URL, str4);
            bundle.putString(RemoteConfigConstants.RequestFieldKey.APP_ID, str);
            bundle.putString(RemoteConfigConstants.RequestFieldKey.APP_VERSION, str2);
            bundle.putString("version", str3);
            bundle.putBoolean("developModel", true);
            if (!WearUtils.g1(arrayList)) {
                bundle.putStringArrayList("xremoteAllowDomainList", arrayList);
            }
            pj3.g(this, XRemoteActivity.class, bundle);
            finish();
        } else {
            sg3.l(ah4.e(R.string.xremote_version_incorrect));
        }
        return true;
    }

    @Override // dc.u23
    public void f3() {
        P4();
        XRemotePolicyPop xRemotePolicyPop = this.k;
        if (xRemotePolicyPop != null && xRemotePolicyPop.isShowing()) {
            xRemotePolicyPop.dismiss();
        }
        R4(this.C);
    }

    public final void f5() throws JsonSyntaxException {
        Map linkedHashMap;
        String remoteAccountId = ch3.n().o().getRemoteAccountId();
        GalleryAccount galleryAccount = new GalleryAccount();
        Account accountU = WearUtils.y.u();
        galleryAccount.setGalleryAccountAvatar(accountU != null ? accountU.getAvatar() : null);
        Account accountU2 = WearUtils.y.u();
        galleryAccount.setGalleryAccountName(accountU2 != null ? accountU2.getUserName() : null);
        galleryAccount.setGalleryRemoteAccountId(remoteAccountId);
        String strE = nd3.e(eg3.h(this, "account_update", ""));
        if (strE == null || strE.length() == 0) {
            linkedHashMap = new LinkedHashMap();
        } else {
            Object objFromJson = new Gson().fromJson(strE, new i().getType());
            Intrinsics.checkNotNullExpressionValue(objFromJson, "{\n            Gson().fro…ng>>() {}.type)\n        }");
            linkedHashMap = (Map) objFromJson;
        }
        Map mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap);
        Gson gson = new Gson();
        String json = gson.toJson(galleryAccount);
        String str = "json=====" + json;
        String str2 = this.m;
        if (str2 != null) {
            if (mutableMap.get(str2) == null) {
                Intrinsics.checkNotNullExpressionValue(json, "json");
                mutableMap.put(str2, json);
            } else if (Intrinsics.areEqual(remoteAccountId, ((GalleryAccount) gson.fromJson((String) mutableMap.get(str2), GalleryAccount.class)).getGalleryRemoteAccountId())) {
                this.w = Boolean.FALSE;
                this.v = Boolean.valueOf(!Intrinsics.areEqual(mutableMap.get(str2), json));
                Intrinsics.checkNotNullExpressionValue(json, "json");
                mutableMap.put(str2, json);
            } else {
                this.w = Boolean.TRUE;
                Intrinsics.checkNotNullExpressionValue(json, "json");
                mutableMap.put(str2, json);
            }
        }
        String str3 = "accountDidUpdate====" + this.w + "userInfoDidUpdate====" + this.v;
        eg3.i(this, "account_update", nd3.o(new Gson().toJson(mutableMap)));
    }

    public final void g5() {
        this.c = new bs3(this);
        this.d = new r23(this);
        Uri uri = Uri.parse(this.launchUrl);
        r23 r23Var = null;
        if (!pg3.h().g().contains(uri.getHost())) {
            String str = this.m;
            if (str == null || str.length() == 0) {
                this.m = uri.getQueryParameter(RemoteConfigConstants.RequestFieldKey.APP_ID);
            }
            String str2 = this.p;
            if (str2 == null || str2.length() == 0) {
                this.p = uri.getQueryParameter(RemoteConfigConstants.RequestFieldKey.APP_VERSION);
            }
            r23 r23Var2 = this.d;
            if (r23Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mXRemotePresenter");
            } else {
                r23Var = r23Var2;
            }
            this.g = r23Var.i(this.m, this.p, this);
            return;
        }
        ArrayList<String> arrayList = this.q;
        if (!(arrayList == null || arrayList.isEmpty())) {
            t5();
            return;
        }
        String str3 = this.m;
        if (str3 == null || str3.length() == 0) {
            this.m = uri.getQueryParameter(RemoteConfigConstants.RequestFieldKey.APP_ID);
        }
        String str4 = this.p;
        if (str4 == null || str4.length() == 0) {
            this.p = uri.getQueryParameter(RemoteConfigConstants.RequestFieldKey.APP_VERSION);
        }
        String str5 = this.m;
        if (str5 != null) {
            if (str5.length() == 0) {
                z = true;
            }
        }
        if (z) {
            finish();
            return;
        }
        r23 r23Var3 = this.d;
        if (r23Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mXRemotePresenter");
        } else {
            r23Var = r23Var3;
        }
        this.g = r23Var.i(this.m, this.p, this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    @NotNull
    public AppCompatDelegate getDelegate() {
        AppCompatDelegate appCompatDelegate = SkinAppCompatDelegateImpl.get(this, this);
        Intrinsics.checkNotNullExpressionValue(appCompatDelegate, "get(this, this)");
        return appCompatDelegate;
    }

    @Override // dc.u23
    public void h1() {
        this.r = false;
        CallbackContext callbackContext = this.h;
        if (callbackContext != null) {
            callbackContext.error(s23.a.a(ErrorCode.Error21202.INSTANCE));
        }
        sg3.i(this, R.string.gallery_developer_toast2);
    }

    public final void h5(String str) {
        this.m = "";
        this.p = "";
        this.o = "";
        Uri uri = Uri.parse(str);
        if (StringsKt__StringsJVMKt.startsWith$default(str, "http", false, 2, null) || StringsKt__StringsJVMKt.startsWith$default(str, "https", false, 2, null)) {
            if (StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "#", false, 2, (Object) null)) {
                Map<String, String> mapT = WearUtils.t(str);
                Intrinsics.checkNotNullExpressionValue(mapT, "dealWithVueLink(result)");
                if (!mapT.isEmpty()) {
                    this.m = mapT.get(RemoteConfigConstants.RequestFieldKey.APP_ID);
                    this.p = mapT.get(RemoteConfigConstants.RequestFieldKey.APP_VERSION);
                    this.o = mapT.get("version");
                }
            } else {
                this.m = uri.getQueryParameter(RemoteConfigConstants.RequestFieldKey.APP_ID);
                this.p = uri.getQueryParameter(RemoteConfigConstants.RequestFieldKey.APP_VERSION);
                this.o = uri.getQueryParameter("version");
            }
            Intrinsics.checkNotNullExpressionValue(uri, "uri");
            O4(uri, str);
        }
    }

    @Override // dc.u23
    public void i3(@Nullable XRemoteAppUserBean.DataBean dataBean) {
        N4(this, dataBean, null, 2, null);
    }

    @Override // dc.u23
    public void m3() {
        CallbackContext callbackContext = this.h;
        if (callbackContext != null) {
            callbackContext.error(s23.a.a(ErrorCode.Error21203.INSTANCE));
        }
    }

    @Override // org.apache.cordova.CordovaActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        XRemoteAppUserBean.DataBean.ApplicationAccount applicationAccount;
        XRemoteAppUserBean.DataBean dataBean;
        List<XRemoteAppUserBean.DataBean.ApplicationAccount> applicationAccountList;
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode != this.a || resultCode != -1 || intent == null || !intent.hasExtra("account") || (applicationAccount = (XRemoteAppUserBean.DataBean.ApplicationAccount) intent.getParcelableExtra("account")) == null || (dataBean = this.i) == null || (applicationAccountList = dataBean.getApplicationAccountList()) == null) {
            return;
        }
        applicationAccountList.add(applicationAccount);
        XRemoteAuthorizedLoginPop xRemoteAuthorizedLoginPop = this.j;
        if (xRemoteAuthorizedLoginPop != null) {
            xRemoteAuthorizedLoginPop.m(applicationAccountList.size() - 1);
        }
    }

    @Override // org.apache.cordova.CordovaActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        String str = this.B;
        if (str != null) {
            if (Intrinsics.areEqual(str, "landscape")) {
                setRequestedOrientation(0);
            } else if (Intrinsics.areEqual(str, "portrait")) {
                setRequestedOrientation(1);
            }
        }
        int iD = gg3.d(this);
        P5(iD);
        O5(iD);
    }

    @Override // org.apache.cordova.CordovaActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xremote);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.getBoolean("cdvStartInBackground", false)) {
                moveTaskToBack(true);
            }
            if (extras.containsKey(ImagesContract.URL)) {
                this.launchUrl = extras.getString(ImagesContract.URL);
            }
            if (extras.containsKey(RemoteConfigConstants.RequestFieldKey.APP_ID)) {
                this.m = extras.getString(RemoteConfigConstants.RequestFieldKey.APP_ID);
            }
            if (extras.containsKey("version")) {
                this.o = extras.getString("version");
            }
            if (extras.containsKey("applicationName")) {
                this.n = extras.getString("applicationName");
            }
            if (extras.containsKey("developModel")) {
                this.s = extras.getBoolean("developModel");
            }
            if (extras.containsKey(RemoteConfigConstants.RequestFieldKey.APP_VERSION)) {
                this.p = extras.getString(RemoteConfigConstants.RequestFieldKey.APP_VERSION);
            }
            if (extras.containsKey("xremoteAllowDomainList")) {
                this.q = extras.getStringArrayList("xremoteAllowDomainList");
            }
            if (extras.containsKey("applicationIconUrl")) {
                this.t = extras.getString("applicationIconUrl");
            }
            if (extras.containsKey("startTime")) {
                this.u = Long.valueOf(extras.getLong("startTime", 0L));
            }
        }
        try {
            g5();
            f5();
        } catch (Exception e2) {
            e2.printStackTrace();
            finish();
        }
        String str = "launchUrl====" + this.launchUrl;
    }

    @Override // org.apache.cordova.CordovaActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        h14 h14Var = this.e;
        if (h14Var != null) {
            h14.a.a(h14Var, null, 1, null);
        }
        Subscription subscription = this.g;
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        ff2.n().C();
        super.onDestroy();
    }

    @Override // org.apache.cordova.CordovaActivity
    @Nullable
    public Object onMessage(@Nullable String id, @Nullable Object data) {
        if (Intrinsics.areEqual("onPageFinished", id)) {
            Uri uri = Uri.parse(this.launchUrl);
            String str = "host" + uri.getHost();
            if (!Intrinsics.areEqual(uri.getHost(), "test-front.lovense.com")) {
                String str2 = this.o;
                if (str2 == null) {
                    str2 = "1";
                }
                this.appView.getEngine().loadUrl(N5("https://cdn.lovense.com", str2), false);
            }
            boolean zD = eg3.d(this, "XRemoteDevelopModel", false);
            String str3 = "switchDevelopModel===== " + zD;
            if (zD && this.s) {
                this.appView.getEngine().loadUrl("javascript:var script = document.createElement('script');\n  script.src = 'https://cdn.bootcss.com/vConsole/3.2.0/vconsole.min.js';\n  script.onload = function() {\n    var vConsole = new VConsole();\n  };\n  document.body.appendChild(script);", false);
            }
            if (pg3.h().g().contains(uri.getHost()) || eg3.d(this, "switchWihteList", false)) {
                String str4 = "";
                ArrayList<String> arrayList = this.q;
                if (arrayList != null) {
                    Iterator<T> it = arrayList.iterator();
                    while (it.hasNext()) {
                        str4 = str4 + ((String) it.next()) + ' ';
                        String str5 = "content==== " + str4;
                    }
                }
                String str6 = str4 + "wss://test10.lovense.comm";
                if (str6.length() > 0) {
                    String strSubstring = str6.substring(0, str6.length() - 1);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    String strReplace$default = StringsKt__StringsJVMKt.replace$default("\n                    var meta = document.createElement('meta');\n                    meta.setAttribute('http-equiv', 'Content-Security-Policy');\n                    meta.content = \"default-src 'self' aaaa ; connect-src 'self' aaaa ; img-src 'self' aaaa data:; media-src 'self' aaaa blob:; script-src 'self' aaaa 'unsafe-eval' 'unsafe-inline';style-src 'self' 'unsafe-inline';\";\n                    document.getElementsByTagName('head')[0].appendChild(meta);\n                    ", "aaaa", strSubstring, false, 4, (Object) null);
                    String str7 = "javascriptCode==== " + strReplace$default;
                    this.appView.getEngine().evaluateJavascript(strReplace$default, null);
                } else {
                    this.appView.getEngine().evaluateJavascript("\n                        var meta = document.createElement('meta');\n                        meta.setAttribute('http-equiv', 'Content-Security-Policy');\n                        meta.content = \"default-src 'self' none ; connect-src 'self' none ;script-src 'self' none ; style-src 'self' 'unsafe-inline';\";\n                        document.getElementsByTagName('head')[0].appendChild(meta);\n                        ", null);
                }
            }
        } else if (Intrinsics.areEqual("onNavigationAttempt", id)) {
            Uri uri2 = Uri.parse(this.launchUrl);
            Uri uri3 = Uri.parse(String.valueOf(data));
            if (Intrinsics.areEqual(this.m, "9c591c4896694344818f507f9a2521fc")) {
                try {
                    this.appView.getEngine().stopLoading();
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse(String.valueOf(data))));
                    return Boolean.FALSE;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else if (!Intrinsics.areEqual(uri2.getHost(), uri3.getHost())) {
                this.appView.getEngine().stopLoading();
            }
        }
        return null;
    }

    @Override // dc.u23
    public void s0(@NotNull GalleryDetailsV2Bean data) {
        Intrinsics.checkNotNullParameter(data, "data");
        GalleryDetailData data2 = data.getData();
        String xremoteApiVersion = null;
        this.q = (ArrayList) (data2 != null ? data2.getXremoteAllowDomainList() : null);
        GalleryDetailData data3 = data.getData();
        String applicationVersion = data3 != null ? data3.getApplicationVersion() : null;
        if (applicationVersion == null || applicationVersion.length() == 0) {
            sg3.i(this, R.string.gallery_developer_toast2);
            finish();
            return;
        }
        GalleryDetailData data4 = data.getData();
        this.t = data4 != null ? data4.getApplicationLogoUrl() : null;
        GalleryDetailData data5 = data.getData();
        this.n = data5 != null ? data5.getApplicationName() : null;
        GalleryDetailData data6 = data.getData();
        this.p = data6 != null ? data6.getApplicationVersion() : null;
        GalleryDetailData data7 = data.getData();
        String xremoteApiVersion2 = data7 != null ? data7.getXremoteApiVersion() : null;
        if (xremoteApiVersion2 == null || xremoteApiVersion2.length() == 0) {
            xremoteApiVersion = Uri.parse(this.launchUrl).getQueryParameter("version");
            if (xremoteApiVersion == null) {
                xremoteApiVersion = "1";
            }
        } else {
            GalleryDetailData data8 = data.getData();
            if (data8 != null) {
                xremoteApiVersion = data8.getXremoteApiVersion();
            }
        }
        this.o = xremoteApiVersion;
        runOnUiThread(new Runnable() { // from class: dc.z13
            @Override // java.lang.Runnable
            public final void run() {
                XRemoteActivity.u5(this.a);
            }
        });
    }

    @Override // dc.ul2
    public void showErrorMsg(@Nullable String errorMsg, boolean pullToRefresh) {
    }

    public final void t5() {
        String str = WearUtils.q;
        String str2 = Build.MODEL;
        String str3 = Build.VERSION.RELEASE;
        StringBuilder sb = new StringBuilder();
        sb.append("Remote/");
        sb.append(str);
        sb.append(" (");
        sb.append(str2);
        sb.append(";Android");
        sb.append(str3);
        sb.append(") AppGallery/2.0.0");
        this.preferences.set("AppendUserAgent", String.valueOf(sb));
        String str4 = this.m;
        if (!(str4 == null || str4.length() == 0)) {
            String str5 = this.p;
            if (!(str5 == null || str5.length() == 0)) {
                String str6 = this.o;
                if (!(str6 == null || str6.length() == 0)) {
                    loadUrl(this.launchUrl);
                    return;
                }
            }
        }
        finish();
    }

    public final void v5(@NotNull Context context, @NotNull String base64Data, @Nullable CallbackContext callbackContext) throws FileNotFoundException {
        OutputStream outputStreamOpenOutputStream;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(base64Data, "base64Data");
        try {
            byte[] bArrDecode = Base64.decode(base64Data, 0);
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
            StringBuilder sb = new StringBuilder();
            sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
            String str = File.separator;
            sb.append(str);
            sb.append("MyApp");
            File file = new File(sb.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = "image_" + System.currentTimeMillis() + ".jpg";
            File file2 = new File(file, str2);
            if (Build.VERSION.SDK_INT < 29) {
                String absolutePath = file2.getAbsolutePath();
                ContentResolver contentResolver = context.getContentResolver();
                Intrinsics.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
                MediaStore.Images.Media.insertImage(contentResolver, absolutePath, str2, (String) null);
                if (callbackContext != null) {
                    callbackContext.success();
                    return;
                }
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", str2);
            contentValues.put("mime_type", MimeTypes.IMAGE_JPEG);
            contentValues.put("relative_path", Environment.DIRECTORY_DCIM + str + "Camera");
            ContentResolver contentResolver2 = context.getContentResolver();
            Intrinsics.checkNotNullExpressionValue(contentResolver2, "context.contentResolver");
            Uri uriInsert = contentResolver2.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            if (uriInsert != null && (outputStreamOpenOutputStream = contentResolver2.openOutputStream(uriInsert)) != null) {
                try {
                    bitmapDecodeByteArray.compress(Bitmap.CompressFormat.JPEG, 100, outputStreamOpenOutputStream);
                    outputStreamOpenOutputStream.flush();
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(outputStreamOpenOutputStream, null);
                } finally {
                }
            }
            if (callbackContext != null) {
                callbackContext.success();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (callbackContext != null) {
                callbackContext.error(s23.a.a(ErrorCode.Error21210.INSTANCE));
            }
        }
    }

    public final void w5(@NotNull String fileData, @Nullable CallbackContext callbackContext) {
        Intrinsics.checkNotNullParameter(fileData, "fileData");
        q61 q61VarM = q61.m(this);
        q61VarM.h("android.permission.WRITE_EXTERNAL_STORAGE");
        q61VarM.j(new j(callbackContext, fileData));
    }

    public final void x5(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.y = arrayList;
    }

    public final void y5(@NotNull String rotate) {
        Intrinsics.checkNotNullParameter(rotate, "rotate");
        this.B = rotate;
        if (Intrinsics.areEqual(rotate, "landscape")) {
            setRequestedOrientation(0);
        } else if (Intrinsics.areEqual(rotate, "portrait")) {
            setRequestedOrientation(1);
        }
    }

    public final void z5(XRemoteAppUserBean.DataBean dataBean, String str, Boolean bool) {
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        if (dataBean != null) {
            XRemoteAuthorizedLoginPop xRemoteAuthorizedLoginPop = new XRemoteAuthorizedLoginPop(this, str, dataBean);
            xRemoteAuthorizedLoginPop.n(new k(str, this), new l(str, this, booleanRef, bool), m.a);
            xRemoteAuthorizedLoginPop.show();
            this.j = xRemoteAuthorizedLoginPop;
            if (xRemoteAuthorizedLoginPop != null) {
                xRemoteAuthorizedLoginPop.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: dc.y13
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        XRemoteActivity.B5(booleanRef, this, dialogInterface);
                    }
                });
            }
        }
    }
}

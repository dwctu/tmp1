package com.wear.ui.chat.pancel.helper.view;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.LinearLayout;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.lovense.wear.R;
import com.wear.ui.chat.pancel.helper.view.PanelSwitchLayout;
import com.wear.ui.chat.pancel.helper.view.pannel.PanelContainer;
import dc.DeviceInfo;
import dc.au2;
import dc.bu2;
import dc.cu2;
import dc.du2;
import dc.lt2;
import dc.nt2;
import dc.ot2;
import dc.qt2;
import dc.st2;
import dc.su2;
import dc.tt2;
import dc.tu2;
import dc.ut2;
import dc.vi1;
import dc.vu2;
import dc.wt2;
import dc.yt2;
import dc.zt2;
import io.agora.rtc2.video.VideoCaptureFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.delay.packet.DelayInformation;

/* compiled from: PanelSwitchLayout.kt */
@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b'\u0018\u0000 »\u00012\u00020\u00012\u00020\u0002:\u0004º\u0001»\u0001B'\b\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB+\b\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\b\u0010W\u001a\u00020XH\u0016JE\u0010Y\u001a\u00020X2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0\u00102\f\u00100\u001a\b\u0012\u0004\u0012\u0002010\u00102\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0010H\u0000¢\u0006\u0002\bZJ\u001f\u0010[\u001a\u00020X2\u0006\u0010S\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u00010VH\u0000¢\u0006\u0002\b\\J\u001c\u0010]\u001a\u00020X2\b\b\u0002\u0010^\u001a\u00020\u00132\b\b\u0002\u0010_\u001a\u00020`H\u0002J\u001f\u0010a\u001a\u00020\u00132\u0006\u00108\u001a\u00020\b2\b\b\u0002\u0010]\u001a\u00020\u0013H\u0000¢\u0006\u0002\bbJ\u0006\u0010c\u001a\u00020XJ\u0018\u0010d\u001a\u00020\b2\u0006\u0010e\u001a\u00020\u00152\u0006\u0010S\u001a\u00020TH\u0002J\u0010\u0010f\u001a\u00020\b2\u0006\u00108\u001a\u00020\bH\u0002J\r\u0010g\u001a\u00020\u000eH\u0000¢\u0006\u0002\bhJ \u0010i\u001a\u00020\b2\u0006\u0010j\u001a\u00020\b2\u0006\u0010k\u001a\u00020\b2\u0006\u0010l\u001a\u00020\bH\u0002J\u0010\u0010m\u001a\u00020\b2\u0006\u0010l\u001a\u00020\bH\u0002J\u0018\u0010n\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010o\u001a\u00020pH\u0002J\u0010\u0010q\u001a\u00020\b2\u0006\u0010o\u001a\u00020pH\u0002J\r\u0010r\u001a\u000203H\u0000¢\u0006\u0002\bsJ \u0010t\u001a\u00020X2\u0006\u0010u\u001a\u00020\b2\u0006\u0010v\u001a\u00020\b2\u0006\u0010w\u001a\u00020\bH\u0002J\r\u0010x\u001a\u00020\u0013H\u0000¢\u0006\u0002\byJ\b\u0010z\u001a\u00020XH\u0002J\"\u0010{\u001a\u00020X2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J)\u0010|\u001a\u00020\u00132\u0006\u0010}\u001a\u00020\b2\u0006\u0010~\u001a\u00020\b2\u0006\u0010\u007f\u001a\u00020\b2\u0007\u0010\u0080\u0001\u001a\u00020\bH\u0002J\u000f\u0010\u0081\u0001\u001a\u00020\u0013H\u0000¢\u0006\u0003\b\u0082\u0001J\u000f\u0010\u0083\u0001\u001a\u00020\u0013H\u0000¢\u0006\u0003\b\u0084\u0001J\u0011\u0010\u0083\u0001\u001a\u00020\u00132\u0006\u00108\u001a\u00020\bH\u0002J\u000f\u0010\u0085\u0001\u001a\u00020\u0013H\u0000¢\u0006\u0003\b\u0086\u0001J\u0011\u0010\u0085\u0001\u001a\u00020\u00132\u0006\u00108\u001a\u00020\bH\u0002J\u000f\u0010\u0087\u0001\u001a\u00020\u0013H\u0000¢\u0006\u0003\b\u0088\u0001J\u0011\u0010\u0087\u0001\u001a\u00020\u00132\u0006\u00108\u001a\u00020\bH\u0002J\t\u0010\u0089\u0001\u001a\u00020XH\u0002J\u001a\u0010\u008a\u0001\u001a\u00020X2\u0006\u0010S\u001a\u00020T2\u0007\u0010\u008b\u0001\u001a\u00020\u0015H\u0002J\t\u0010\u008c\u0001\u001a\u00020XH\u0002J\u001b\u0010\u008d\u0001\u001a\u00020X2\u0007\u0010\u008e\u0001\u001a\u00020V2\u0007\u0010\u008f\u0001\u001a\u00020\u0013H\u0002J\u0012\u0010\u0090\u0001\u001a\u00020X2\u0007\u0010\u0091\u0001\u001a\u00020\u0013H\u0002J\u0011\u0010\u0092\u0001\u001a\u00020X2\u0006\u00108\u001a\u00020\bH\u0002JB\u0010\u0093\u0001\u001a\u00020X2\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u00012\u0007\u0010\u0096\u0001\u001a\u00020\u00132\u0007\u0010\u0097\u0001\u001a\u00020\b2\u0007\u0010\u0098\u0001\u001a\u00020\b2\u0007\u0010\u0099\u0001\u001a\u00020\b2\u0007\u0010\u009a\u0001\u001a\u00020\bH\u0002J\u0012\u0010\u009b\u0001\u001a\u00020X2\u0007\u0010\u008e\u0001\u001a\u00020VH\u0002J\t\u0010\u009c\u0001\u001a\u00020XH\u0014J\t\u0010\u009d\u0001\u001a\u00020XH\u0014J\t\u0010\u009e\u0001\u001a\u00020XH\u0014J3\u0010\u009f\u0001\u001a\u00020X2\u0007\u0010 \u0001\u001a\u00020\u00132\u0006\u0010}\u001a\u00020\b2\u0006\u0010~\u001a\u00020\b2\u0006\u0010\u007f\u001a\u00020\b2\u0007\u0010\u0080\u0001\u001a\u00020\bH\u0014J\u0007\u0010¡\u0001\u001a\u00020XJ\t\u0010¢\u0001\u001a\u00020XH\u0002J\t\u0010£\u0001\u001a\u00020\u0013H\u0002J\u0018\u0010¤\u0001\u001a\u00020X2\u0007\u0010¥\u0001\u001a\u00020\u0013H\u0000¢\u0006\u0003\b¦\u0001J\u001e\u0010§\u0001\u001a\u00020X2\r\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u0002060\u0010H\u0000¢\u0006\u0003\b©\u0001J\u001e\u0010ª\u0001\u001a\u00020X2\r\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0000¢\u0006\u0003\b«\u0001J\u001a\u0010¬\u0001\u001a\u00020X2\u0007\u0010\u00ad\u0001\u001a\u00020`2\u0006\u00108\u001a\u00020\bH\u0003J\u001a\u0010®\u0001\u001a\u00020X2\t\u0010¯\u0001\u001a\u0004\u0018\u00010PH\u0000¢\u0006\u0003\b°\u0001J\t\u0010±\u0001\u001a\u00020\u0013H\u0002J\t\u0010²\u0001\u001a\u00020\u0013H\u0003J\u001a\u0010³\u0001\u001a\u00020X2\t\b\u0002\u0010´\u0001\u001a\u00020\u0013H\u0001¢\u0006\u0003\bµ\u0001J\u0007\u0010¶\u0001\u001a\u00020XJ\u0011\u0010·\u0001\u001a\u00020X2\u0006\u0010u\u001a\u00020\bH\u0002J\u0012\u0010¸\u0001\u001a\u00020X2\u0007\u0010¹\u0001\u001a\u00020\bH\u0002R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010$R\u000e\u0010%\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010'R\u000e\u0010(\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010+\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b,\u0010-R\u0016\u00100\u001a\n\u0012\u0004\u0012\u000201\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082.¢\u0006\u0002\n\u0000R*\u00104\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020605j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u000206`7X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010;\u001a\u00060<R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000RR\u0010=\u001a:\u0012\u0013\u0012\u00110?¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(B\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020C0\u0010¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020\b\u0018\u00010>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HRL\u0010I\u001a4\u0012\u0013\u0012\u00110C¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(J\u0012\u0013\u0012\u00110K¢\u0006\f\b@\u0012\b\bA\u0012\u0004\b\b(L\u0012\u0004\u0012\u00020\b\u0018\u00010>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010F\"\u0004\bN\u0010HR\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Q\u001a\n\u0012\u0004\u0012\u00020R\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020TX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¼\u0001"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/view/PanelSwitchLayout;", "Landroid/widget/LinearLayout;", "Lcom/wear/ui/chat/pancel/helper/interfaces/ViewAssertion;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "animationSpeed", "contentContainer", "Lcom/wear/ui/chat/pancel/helper/view/content/IContentContainer;", "contentScrollMeasurers", "", "Lcom/wear/ui/chat/pancel/helper/interfaces/ContentScrollMeasurer;", "contentScrollOutsizeEnable", "", "deviceRuntime", "Lcom/wear/ui/chat/pancel/helper/device/DeviceRuntime;", "doingCheckout", "editFocusChangeListeners", "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnEditFocusChangeListener;", "enableAndroid11KeyboardFeature", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "hasAttachLister", "isKeyboardShowing", "keyboardAnimationFeature", "keyboardStateRunnable", "Ljava/lang/Runnable;", "keyboardStatusListeners", "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnKeyboardStateListener;", "lastContentHeight", "Ljava/lang/Integer;", "lastKeyboardHeight", "lastNavigationBarShow", "Ljava/lang/Boolean;", "lastPanelHeight", "lastPanelId", "minLimitCloseKeyboardHeight", "minLimitOpenKeyboardHeight", "getMinLimitOpenKeyboardHeight", "()I", "minLimitOpenKeyboardHeight$delegate", "Lkotlin/Lazy;", "panelChangeListeners", "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnPanelChangeListener;", "panelContainer", "Lcom/wear/ui/chat/pancel/helper/view/pannel/PanelContainer;", "panelHeightMeasurers", "Ljava/util/HashMap;", "Lcom/wear/ui/chat/pancel/helper/interfaces/PanelHeightMeasurer;", "Lkotlin/collections/HashMap;", "panelId", "realBounds", "Landroid/graphics/Rect;", "retryCheckoutKbRunnable", "Lcom/wear/ui/chat/pancel/helper/view/PanelSwitchLayout$CheckoutKbRunnable;", "softInputHeightCalculatorOnProgress", "Lkotlin/Function2;", "Landroidx/core/view/WindowInsetsCompat;", "Lkotlin/ParameterName;", "name", "insets", "Landroidx/core/view/WindowInsetsAnimationCompat;", "runningAnimations", "getSoftInputHeightCalculatorOnProgress", "()Lkotlin/jvm/functions/Function2;", "setSoftInputHeightCalculatorOnProgress", "(Lkotlin/jvm/functions/Function2;)V", "softInputHeightCalculatorOnStart", "animation", "Landroidx/core/view/WindowInsetsAnimationCompat$BoundsCompat;", "bounds", "getSoftInputHeightCalculatorOnStart", "setSoftInputHeightCalculatorOnStart", "triggerViewClickInterceptor", "Lcom/wear/ui/chat/pancel/helper/interfaces/TriggerViewClickInterceptor;", "viewClickListeners", "Lcom/wear/ui/chat/pancel/helper/interfaces/listener/OnViewClickListener;", "window", "Landroid/view/Window;", "windowInsetsRootView", "Landroid/view/View;", "assertView", "", "bindListener", "bindListener$app_marketRelease", "bindWindow", "bindWindow$app_marketRelease", "checkoutKeyboard", "retry", DelayInformation.ELEMENT, "", "checkoutPanel", "checkoutPanel$app_marketRelease", "doFinishInflateLayout", "getAndroidQNavHIfNavIsInvisible", "runtime", "getCompatPanelHeight", "getContentContainer", "getContentContainer$app_marketRelease", "getContentContainerHeight", "allHeight", "paddingTop", "scrollOutsideHeight", "getContentContainerTop", "getCurrentNavigationHeight", "deviceInfo", "Lcom/wear/ui/chat/pancel/helper/device/DeviceInfo;", "getCurrentStatusBarHeight", "getPanelContainer", "getPanelContainer$app_marketRelease", "handleKeyboardStateChanged", "keyboardHeight", "realHeight", "contentHeight", "hookSystemBackByPanelSwitcher", "hookSystemBackByPanelSwitcher$app_marketRelease", "initListener", "initView", "isBoundChange", "l", "t", StreamManagement.AckRequest.ELEMENT, "b", "isContentScrollOutsizeEnable", "isContentScrollOutsizeEnable$app_marketRelease", "isKeyboardState", "isKeyboardState$app_marketRelease", "isPanelState", "isPanelState$app_marketRelease", "isResetState", "isResetState$app_marketRelease", "keyboardChangedAnimation", "keyboardChangedListener", "it", "keyboardChangedListener30Impl", "notifyEditFocusChange", "view", "hasFocus", "notifyKeyboardState", "visible", "notifyPanelChange", "notifyPanelSizeChange", "panelView", "Lcom/wear/ui/chat/pancel/helper/view/pannel/IPanelView;", "portrait", "oldWidth", "oldHeight", VideoCaptureFormat.keyWidth, VideoCaptureFormat.keyHeight, "notifyViewClick", "onAttachedToWindow", "onDetachedFromWindow", "onFinishInflate", "onLayout", "changed", "recycle", "releaseKeyboardChangedListener", "reverseResetState", "setContentScrollOutsizeEnable", StreamManagement.Enable.ELEMENT, "setContentScrollOutsizeEnable$app_marketRelease", "setPanelHeightMeasurers", "mutableList", "setPanelHeightMeasurers$app_marketRelease", "setScrollMeasurers", "setScrollMeasurers$app_marketRelease", "setTransition", TypedValues.TransitionType.S_DURATION, "setTriggerViewClickInterceptor", "interceptor", "setTriggerViewClickInterceptor$app_marketRelease", "supportKeyboardAnimation", "supportKeyboardFeature", "toKeyboardState", "async", "toKeyboardState$app_marketRelease", "tryBindKeyboardChangedListener", "trySyncKeyboardHeight", "updatePanelStateByAnimation", "expectHeight", "CheckoutKbRunnable", "Companion", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class PanelSwitchLayout extends LinearLayout {

    @NotNull
    public static final b K = new b(null);
    public static long L;
    public boolean A;

    @Nullable
    public Integer B;

    @Nullable
    public Boolean C;
    public int D;

    @NotNull
    public final Lazy E;
    public int F;
    public boolean G;

    @Nullable
    public List<yt2> a;

    @Nullable
    public List<wt2> b;

    @Nullable
    public List<ut2> c;

    @Nullable
    public List<tt2> d;
    public su2 e;
    public PanelContainer f;
    public Window g;

    @Nullable
    public View h;

    @Nullable
    public st2 i;

    @NotNull
    public final List<ot2> j;

    @NotNull
    public final HashMap<Integer, qt2> k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;

    @Nullable
    public nt2 s;

    @Nullable
    public Rect t;

    @NotNull
    public Runnable u;
    public boolean v;

    @NotNull
    public final a w;

    @Nullable
    public Function2<? super WindowInsetsAnimationCompat, ? super WindowInsetsAnimationCompat.BoundsCompat, Integer> x;

    @Nullable
    public Function2<? super WindowInsetsCompat, ? super List<WindowInsetsAnimationCompat>, Integer> y;

    @Nullable
    public ViewTreeObserver.OnGlobalLayoutListener z;

    /* compiled from: PanelSwitchLayout.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/view/PanelSwitchLayout$CheckoutKbRunnable;", "Ljava/lang/Runnable;", "(Lcom/wear/ui/chat/pancel/helper/view/PanelSwitchLayout;)V", DelayInformation.ELEMENT, "", "getDelay", "()J", "setDelay", "(J)V", "retry", "", "getRetry", "()Z", "setRetry", "(Z)V", "run", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class a implements Runnable {
        public boolean a;
        public long b;

        public a() {
        }

        public final void a(long j) {
            this.b = j;
        }

        public final void b(boolean z) {
            this.a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!PanelSwitchLayout.t(PanelSwitchLayout.this, 0, false, 2, null) && PanelSwitchLayout.this.m != 0 && this.a) {
                PanelSwitchLayout.this.postDelayed(this, this.b);
            }
            this.a = false;
        }
    }

    /* compiled from: PanelSwitchLayout.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/wear/ui/chat/pancel/helper/view/PanelSwitchLayout$Companion;", "", "()V", "TAG", "", "preClickTime", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: PanelSwitchLayout.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/wear/ui/chat/pancel/helper/view/PanelSwitchLayout$initListener$4", "Landroid/view/View$OnClickListener;", "onClick", "", PSOProgramService.VS_Key, "Landroid/view/View;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements View.OnClickListener {
        public final /* synthetic */ vu2 b;
        public final /* synthetic */ View c;

        public c(vu2 vu2Var, View view) {
            this.b = vu2Var;
            this.c = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@NotNull View v) {
            Intrinsics.checkNotNullParameter(v, "v");
            st2 st2Var = PanelSwitchLayout.this.i;
            if (st2Var == null || !st2Var.a(v.getId())) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - PanelSwitchLayout.L <= 500) {
                    au2.g("PanelSwitchLayout#initListener", "panelItem invalid click! preClickTime: " + PanelSwitchLayout.L + " currentClickTime: " + jCurrentTimeMillis);
                    return;
                }
                PanelSwitchLayout.this.f0(v);
                PanelContainer panelContainer = PanelSwitchLayout.this.f;
                if (panelContainer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
                    panelContainer = null;
                }
                int iC = panelContainer.c(this.b);
                if (PanelSwitchLayout.this.m != iC || !this.b.getC() || !this.b.isShowing()) {
                    PanelSwitchLayout.t(PanelSwitchLayout.this, iC, false, 2, null);
                } else if (PanelSwitchLayout.this.m == R.id.chat_more) {
                    this.c.setSelected(false);
                    PanelSwitchLayout.t(PanelSwitchLayout.this, -1, false, 2, null);
                } else {
                    PanelSwitchLayout.r(PanelSwitchLayout.this, false, 0L, 2, null);
                }
                b bVar = PanelSwitchLayout.K;
                PanelSwitchLayout.L = jCurrentTimeMillis;
            }
        }
    }

    /* compiled from: PanelSwitchLayout.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<Integer> {
        public static final d a = new d();

        public d() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Integer invoke() {
            return Integer.valueOf(lt2.a.a());
        }
    }

    @JvmOverloads
    public PanelSwitchLayout(@Nullable Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public PanelSwitchLayout(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    @JvmOverloads
    public PanelSwitchLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.j = new ArrayList();
        this.k = new HashMap<>();
        this.m = -1;
        this.n = -1;
        this.o = -1;
        this.p = 200;
        this.q = true;
        this.r = true;
        this.u = new Runnable() { // from class: dc.hu2
            @Override // java.lang.Runnable
            public final void run() {
                PanelSwitchLayout.T(this.a);
            }
        };
        this.w = new a();
        this.E = LazyKt__LazyJVMKt.lazy(d.a);
        H(attributeSet, i, 0);
    }

    public static final void E(PanelSwitchLayout this$0, View v) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(v, "v");
        this$0.f0(v);
        r(this$0, false, 0L, 3, null);
    }

    public static final void F(PanelSwitchLayout this$0, View v, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(v, "v");
        this$0.b0(v, z);
        r(this$0, false, 0L, 3, null);
    }

    public static final void G(PanelSwitchLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C();
    }

    public static final void Q(Window window, PanelSwitchLayout this$0, nt2 it) {
        Intrinsics.checkNotNullParameter(window, "$window");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        zt2 zt2VarB = zt2.a.b(zt2.d, 0, 1, null);
        zt2.b(zt2VarB, null, "界面每一次变化的信息回调", 1, null);
        zt2VarB.a("windowSoftInputMode", String.valueOf(window.getAttributes().softInputMode));
        zt2VarB.a("currentPanelSwitchLayoutVisible", String.valueOf(this$0.getVisibility() == 0));
        if (this$0.getVisibility() != 0) {
            zt2.b(zt2VarB, null, "skip cal keyboard Height When window is invisible!", 1, null);
        }
        int i = bu2.a.i(window);
        int iH = bu2.h(window);
        DeviceInfo deviceInfoA = it.a(true);
        int iA = this$0.A(deviceInfoA);
        int iZ = this$0.z(it, deviceInfoA);
        int iV = this$0.v(it, window);
        int i2 = iA + iZ + iV;
        zt2VarB.a("screenHeight", String.valueOf(i));
        zt2VarB.a("contentHeight", String.valueOf(iH));
        zt2VarB.a("isFullScreen", String.valueOf(it.getH()));
        zt2VarB.a("isNavigationBarShown", String.valueOf(it.getE()));
        zt2VarB.a("deviceStatusBarH", String.valueOf(deviceInfoA.getStatusBarH()));
        zt2VarB.a("deviceNavigationBarH", String.valueOf(deviceInfoA.getNavigationBarH()));
        if (Build.VERSION.SDK_INT >= 23) {
            WindowInsets rootWindowInsets = window.getDecorView().getRootWindowInsets();
            zt2VarB.a("systemInset", "left(" + rootWindowInsets.getSystemWindowInsetTop() + ") top(" + rootWindowInsets.getSystemWindowInsetLeft() + ") right(" + rootWindowInsets.getSystemWindowInsetRight() + ") bottom(" + rootWindowInsets.getSystemWindowInsetBottom() + ')');
            zt2VarB.a("inset", "left(" + rootWindowInsets.getStableInsetLeft() + ") top(" + rootWindowInsets.getStableInsetTop() + ") right(" + rootWindowInsets.getStableInsetRight() + ") bottom(" + rootWindowInsets.getStableInsetBottom() + ')');
        }
        zt2VarB.a("currentSystemInfo", "statusBarH : " + iA + ", navigationBarH : " + iZ + " 全面屏手势虚拟栏H : " + iV);
        zt2VarB.a("currentSystemH", String.valueOf(i2));
        this$0.C = Boolean.valueOf(it.getE());
        int i3 = (i - iH) - i2;
        int i4 = i3 + iV;
        if (deviceInfoA.getNavigationBarH() > iV) {
            iV = deviceInfoA.getNavigationBarH();
        }
        this$0.F = iV;
        zt2VarB.a("minLimitCloseKeyboardH", String.valueOf(iV));
        zt2VarB.a("minLimitOpenKeyboardH", String.valueOf(this$0.getMinLimitOpenKeyboardHeight()));
        zt2VarB.a("lastKeyboardH", String.valueOf(this$0.D));
        zt2VarB.a("currentKeyboardInfo", "keyboardH : " + i3 + ", realKeyboardH : " + i4 + ", isShown : " + this$0.l);
        this$0.B(i3, i4, iH);
        zt2VarB.c("PanelSwitchLayout#onGlobalLayout");
    }

    public static final WindowInsetsCompat S(PanelSwitchLayout this$0, View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(insets, "insets");
        boolean zIsVisible = insets.isVisible(WindowInsetsCompat.Type.ime());
        int iA = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom;
        boolean zIsVisible2 = insets.isVisible(WindowInsetsCompat.Type.navigationBars());
        int i = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        if (zIsVisible && zIsVisible2) {
            iA -= i;
        }
        if (zIsVisible && iA == 0) {
            Context context = this$0.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            iA = du2.a(context);
        }
        au2.g("PanelSwitchLayout#WindowInsetsListener", "KeyBoardHeight : " + iA + "，isShow " + zIsVisible);
        if (iA != this$0.D) {
            Window window = this$0.g;
            if (window == null) {
                Intrinsics.throwUninitializedPropertyAccessException("window");
                window = null;
            }
            int iH = bu2.h(window);
            nt2 nt2Var = this$0.s;
            this$0.B(iA, (nt2Var != null ? this$0.v(nt2Var, nt2Var.getB()) : 0) + iA, iH);
            au2.g("PanelSwitchLayout#WindowInsetsListener", "requestLayout");
        }
        return ViewCompat.onApplyWindowInsets(view, insets);
    }

    public static final void T(PanelSwitchLayout this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m0(false);
    }

    private final int getMinLimitOpenKeyboardHeight() {
        return ((Number) this.E.getValue()).intValue();
    }

    public static final void q0(PanelSwitchLayout this$0, int i, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        su2 su2Var = null;
        Float f = animatedValue instanceof Float ? (Float) animatedValue : null;
        float fFloatValue = f != null ? f.floatValue() : 0.0f;
        PanelContainer panelContainer = this$0.f;
        if (panelContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
            panelContainer = null;
        }
        panelContainer.setTranslationY(fFloatValue);
        su2 su2Var2 = this$0.e;
        if (su2Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        } else {
            su2Var = su2Var2;
        }
        su2Var.a(this$0.j, i, fFloatValue);
    }

    public static /* synthetic */ void r(PanelSwitchLayout panelSwitchLayout, boolean z, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            j = 200;
        }
        panelSwitchLayout.q(z, j);
    }

    public static /* synthetic */ boolean t(PanelSwitchLayout panelSwitchLayout, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        return panelSwitchLayout.s(i, z);
    }

    public final int A(DeviceInfo deviceInfo) {
        return deviceInfo.getStatusBarH();
    }

    public final void B(int i, int i2, int i3) {
        boolean z = false;
        if (this.l) {
            if (i <= getMinLimitOpenKeyboardHeight()) {
                this.l = false;
                if (K()) {
                    t(this, -1, false, 2, null);
                }
                c0(false);
            } else if (i != this.D) {
                au2.g("PanelSwitchLayout#KeyboardStateChanged", "try to set KeyBoardHeight : " + i2 + "，isShow " + this.l);
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                du2.e(context, i2);
                requestLayout();
            }
        } else if (i > getMinLimitOpenKeyboardHeight()) {
            this.l = true;
            if (i > this.D) {
                au2.g("PanelSwitchLayout#KeyboardStateChanged", "try to set KeyBoardHeight : " + i2 + "，isShow " + this.l);
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                du2.e(context2, i2);
                requestLayout();
            }
            if (!K()) {
                s(0, false);
            }
            c0(true);
        } else {
            Integer num = this.B;
            if (num != null) {
                int iIntValue = num.intValue();
                Boolean bool = this.C;
                if (bool != null) {
                    boolean zBooleanValue = bool.booleanValue();
                    if (iIntValue != i3) {
                        nt2 nt2Var = this.s;
                        if (nt2Var != null && zBooleanValue == nt2Var.getE()) {
                            z = true;
                        }
                        if (!z) {
                            requestLayout();
                            au2.g("PanelSwitchLayout#KeyboardStateChanged", "update layout by navigation visibility State change");
                        }
                    }
                }
            }
        }
        Integer num2 = this.B;
        if (num2 != null && num2.intValue() == i3 && this.D != i) {
            o0(i);
        }
        this.D = i;
        this.B = Integer.valueOf(i3);
    }

    public final boolean C() {
        if (N()) {
            return false;
        }
        su2 su2Var = null;
        if (!K()) {
            t(this, -1, false, 2, null);
            return true;
        }
        if (!this.l) {
            t(this, -1, false, 2, null);
            return false;
        }
        su2 su2Var2 = this.e;
        if (su2Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        } else {
            su2Var = su2Var2;
        }
        su2Var.getH().e(this.l, false);
        return true;
    }

    public final void D() {
        su2 su2Var = this.e;
        if (su2Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            su2Var = null;
        }
        su2Var.getH().b(new View.OnClickListener() { // from class: dc.ku2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PanelSwitchLayout.E(this.a, view);
            }
        });
        su2 su2Var2 = this.e;
        if (su2Var2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            su2Var2 = null;
        }
        su2Var2.getH().f(new View.OnFocusChangeListener() { // from class: dc.ju2
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                PanelSwitchLayout.F(this.a, view, z);
            }
        });
        su2 su2Var3 = this.e;
        if (su2Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            su2Var3 = null;
        }
        su2Var3.getI().d(new Runnable() { // from class: dc.iu2
            @Override // java.lang.Runnable
            public final void run() {
                PanelSwitchLayout.G(this.a);
            }
        });
        PanelContainer panelContainer = this.f;
        if (panelContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
            panelContainer = null;
        }
        SparseArray<vu2> panelSparseArray = panelContainer.getPanelSparseArray();
        int size = panelSparseArray.size();
        for (int i = 0; i < size; i++) {
            vu2 vu2Var = panelSparseArray.get(panelSparseArray.keyAt(i));
            su2 su2Var4 = this.e;
            if (su2Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
                su2Var4 = null;
            }
            View viewC = su2Var4.c(vu2Var.getA());
            if (viewC != null) {
                viewC.setOnClickListener(new c(vu2Var, viewC));
            }
        }
    }

    public final void H(AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, vi1.PanelSwitchLayout, i, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…hLayout, defStyleAttr, 0)");
        this.p = typedArrayObtainStyledAttributes.getInteger(1, this.p);
        this.q = typedArrayObtainStyledAttributes.getBoolean(0, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean I(int r5, int r6, int r7, int r8) {
        /*
            r4 = this;
            android.graphics.Rect r0 = r4.t
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1f
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r3 = r0.left
            if (r3 != r5) goto L1c
            int r3 = r0.top
            if (r3 != r3) goto L1c
            int r3 = r0.right
            if (r3 != r7) goto L1c
            int r0 = r0.bottom
            if (r0 == r8) goto L1a
            goto L1c
        L1a:
            r0 = 0
            goto L1d
        L1c:
            r0 = 1
        L1d:
            if (r0 == 0) goto L20
        L1f:
            r1 = 1
        L20:
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>(r5, r6, r7, r8)
            r4.t = r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.chat.pancel.helper.view.PanelSwitchLayout.I(int, int, int, int):boolean");
    }

    public final boolean J(int i) {
        return i == 0;
    }

    public final boolean K() {
        return J(this.m);
    }

    public final boolean L(int i) {
        return (M(i) || J(i)) ? false : true;
    }

    public final boolean M(int i) {
        return i == -1;
    }

    public final boolean N() {
        return M(this.m);
    }

    public final void O() {
        Window window = this.g;
        Window window2 = null;
        if (window == null) {
            Intrinsics.throwUninitializedPropertyAccessException("window");
            window = null;
        }
        window.setSoftInputMode(51);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        WindowInsetsAnimationCompat.Callback callback = new WindowInsetsAnimationCompat.Callback() { // from class: com.wear.ui.chat.pancel.helper.view.PanelSwitchLayout$keyboardChangedAnimation$callback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            @NotNull
            public WindowInsetsCompat onProgress(@NotNull WindowInsetsCompat insets, @NotNull List<WindowInsetsAnimationCompat> runningAnimations) {
                Object next;
                Intrinsics.checkNotNullParameter(insets, "insets");
                Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
                PanelSwitchLayout panelSwitchLayout = this.a;
                if (panelSwitchLayout.L(panelSwitchLayout.m)) {
                    au2.g("onProgress", "isPanelState: ture");
                } else {
                    su2 su2Var = null;
                    zt2 zt2VarB = zt2.a.b(zt2.d, 0, 1, null);
                    zt2.b(zt2VarB, null, "keyboard animation progress", 1, null);
                    Iterator<T> it = runningAnimations.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                        if ((((WindowInsetsAnimationCompat) next).getTypeMask() & WindowInsetsCompat.Type.ime()) != 0) {
                            break;
                        }
                    }
                    WindowInsetsAnimationCompat windowInsetsAnimationCompat = (WindowInsetsAnimationCompat) next;
                    if (windowInsetsAnimationCompat != null) {
                        float fraction = windowInsetsAnimationCompat.getFraction();
                        int iIntValue = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom;
                        if (booleanRef.element) {
                            if (!(fraction == 0.0f) && iIntValue == 0) {
                                au2.g("onProgress", "键盘高度获取失败，请实现softInputHeightCalculatorOnProgress兼容正确的键盘高度，当前动画进度fraction = " + fraction);
                                Function2<WindowInsetsCompat, List<WindowInsetsAnimationCompat>, Integer> softInputHeightCalculatorOnProgress = this.a.getSoftInputHeightCalculatorOnProgress();
                                iIntValue = softInputHeightCalculatorOnProgress != null ? softInputHeightCalculatorOnProgress.invoke(insets, runningAnimations).intValue() : 0;
                            }
                        }
                        Window window3 = this.a.g;
                        if (window3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("window");
                            window3 = null;
                        }
                        int bottom = window3.getDecorView().getBottom() - iIntValue;
                        zt2VarB.a("fraction", String.valueOf(fraction));
                        zt2VarB.a("softInputHeight", String.valueOf(iIntValue));
                        Window window4 = this.a.g;
                        if (window4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("window");
                            window4 = null;
                        }
                        zt2VarB.a("decorView.bottom", String.valueOf(window4.getDecorView().getBottom()));
                        int height = this.a.getHeight() + bu2.d(this.a)[1];
                        PanelSwitchLayout panelSwitchLayout2 = this.a;
                        int iW = panelSwitchLayout2.w(panelSwitchLayout2.m);
                        if (booleanRef.element) {
                            if (bottom < height) {
                                float f = bottom - height;
                                PanelContainer panelContainer = this.a.f;
                                if (panelContainer == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
                                    panelContainer = null;
                                }
                                if (panelContainer.getTranslationY() > f) {
                                    PanelContainer panelContainer2 = this.a.f;
                                    if (panelContainer2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
                                        panelContainer2 = null;
                                    }
                                    panelContainer2.setTranslationY(f);
                                    su2 su2Var2 = this.a.e;
                                    if (su2Var2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
                                    } else {
                                        su2Var = su2Var2;
                                    }
                                    su2Var.a(this.a.j, iW, f);
                                    zt2VarB.a("translationY", String.valueOf(f));
                                    floatRef.element = f;
                                }
                            }
                        } else if (iIntValue > 0) {
                            float fMin = Math.min(bottom - height, 0);
                            PanelContainer panelContainer3 = this.a.f;
                            if (panelContainer3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
                                panelContainer3 = null;
                            }
                            panelContainer3.setTranslationY(fMin);
                            su2 su2Var3 = this.a.e;
                            if (su2Var3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
                            } else {
                                su2Var = su2Var3;
                            }
                            su2Var.a(this.a.j, iW, fMin);
                            zt2VarB.a("translationY", String.valueOf(fMin));
                        } else {
                            float f2 = floatRef.element;
                            float fMin2 = Math.min(f2 - ((fraction + 0.5f) * f2), 0.0f);
                            PanelContainer panelContainer4 = this.a.f;
                            if (panelContainer4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
                                panelContainer4 = null;
                            }
                            panelContainer4.setTranslationY(fMin2);
                            su2 su2Var4 = this.a.e;
                            if (su2Var4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
                            } else {
                                su2Var = su2Var4;
                            }
                            su2Var.a(this.a.j, iW, fMin2);
                            zt2VarB.a("translationY", String.valueOf(fMin2));
                        }
                        zt2VarB.c("onProgress");
                    }
                }
                return insets;
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            @NotNull
            public WindowInsetsAnimationCompat.BoundsCompat onStart(@NotNull WindowInsetsAnimationCompat animation, @NotNull WindowInsetsAnimationCompat.BoundsCompat bounds) {
                Insets insets;
                Insets insets2;
                Intrinsics.checkNotNullParameter(animation, "animation");
                Intrinsics.checkNotNullParameter(bounds, "bounds");
                int typeMask = animation.getTypeMask() & WindowInsetsCompat.Type.ime();
                Window window3 = this.a.g;
                PanelContainer panelContainer = null;
                if (window3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("window");
                    window3 = null;
                }
                WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(window3.getDecorView());
                booleanRef.element = rootWindowInsets != null ? rootWindowInsets.isVisible(WindowInsetsCompat.Type.ime()) : false;
                au2.g("onStart", "hasSoftInput = " + booleanRef.element);
                if (booleanRef.element && typeMask != 0) {
                    int i = (rootWindowInsets == null || (insets2 = rootWindowInsets.getInsets(WindowInsetsCompat.Type.navigationBars())) == null) ? 0 : insets2.bottom;
                    int iIntValue = (rootWindowInsets == null || (insets = rootWindowInsets.getInsets(WindowInsetsCompat.Type.ime())) == null) ? 0 : insets.bottom;
                    if (iIntValue == 0) {
                        iIntValue = bounds.getUpperBound().bottom;
                    }
                    if (iIntValue == 0) {
                        au2.g("onStart", "键盘高度获取失败，请实现softInputHeightCalculatorOnStart兼容正确的键盘高度");
                        Function2<WindowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat, Integer> softInputHeightCalculatorOnStart = this.a.getSoftInputHeightCalculatorOnStart();
                        iIntValue = softInputHeightCalculatorOnStart != null ? softInputHeightCalculatorOnStart.invoke(animation, bounds).intValue() : 0;
                    }
                    int i2 = iIntValue - i;
                    au2.g("onStart", "keyboard height = " + iIntValue);
                    au2.g("onStart", "realKeyboardH height = " + i2);
                    PanelContainer panelContainer2 = this.a.f;
                    if (panelContainer2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
                        panelContainer2 = null;
                    }
                    int i3 = panelContainer2.getLayoutParams().height;
                    if (i2 > 0 && i3 != i2) {
                        PanelContainer panelContainer3 = this.a.f;
                        if (panelContainer3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
                            panelContainer3 = null;
                        }
                        panelContainer3.getLayoutParams().height = i2;
                        this.a.D = i2;
                        Context context = this.a.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        du2.e(context, i2);
                    }
                    if (iIntValue > 0 && booleanRef.element) {
                        Window window4 = this.a.g;
                        if (window4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("window");
                            window4 = null;
                        }
                        float bottom = (window4.getDecorView().getBottom() - iIntValue) - (bu2.d(this.a)[1] + this.a.getHeight());
                        PanelContainer panelContainer4 = this.a.f;
                        if (panelContainer4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
                        } else {
                            panelContainer = panelContainer4;
                        }
                        if (panelContainer.getTranslationY() < bottom) {
                            this.a.p0(-((int) bottom));
                        }
                    }
                }
                return bounds;
            }
        };
        Window window3 = this.g;
        if (window3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("window");
        } else {
            window2 = window3;
        }
        ViewCompat.setWindowInsetsAnimationCallback(window2.getDecorView(), callback);
    }

    public final void P(final Window window, final nt2 nt2Var) {
        this.z = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: dc.lu2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                PanelSwitchLayout.Q(window, this, nt2Var);
            }
        };
        window.getDecorView().getRootView().getViewTreeObserver().addOnGlobalLayoutListener(this.z);
    }

    public final void R() {
        Window window = this.g;
        if (window == null) {
            return;
        }
        View rootView = this.h;
        if (rootView == null) {
            if (window == null) {
                Intrinsics.throwUninitializedPropertyAccessException("window");
                window = null;
            }
            rootView = window.getDecorView().getRootView();
        }
        ViewCompat.setOnApplyWindowInsetsListener(rootView, new OnApplyWindowInsetsListener() { // from class: dc.gu2
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return PanelSwitchLayout.S(this.a, view, windowInsetsCompat);
            }
        });
    }

    public final void b0(View view, boolean z) {
        List<tt2> list = this.d;
        if (list != null) {
            Iterator<tt2> it = list.iterator();
            while (it.hasNext()) {
                it.next().onFocusChange(view, z);
            }
        }
    }

    public final void c0(boolean z) {
        int iA;
        List<ut2> list = this.c;
        if (list != null) {
            for (ut2 ut2Var : list) {
                if (z) {
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    iA = du2.a(context);
                } else {
                    iA = 0;
                }
                ut2Var.f(z, iA);
            }
        }
    }

    public final void d0(int i) {
        List<wt2> list = this.b;
        if (list != null) {
            for (wt2 wt2Var : list) {
                if (i == -1) {
                    wt2Var.d();
                } else if (i != 0) {
                    PanelContainer panelContainer = this.f;
                    if (panelContainer == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
                        panelContainer = null;
                    }
                    wt2Var.c(panelContainer.d(i));
                } else {
                    wt2Var.e();
                }
            }
        }
    }

    public final void e0(vu2 vu2Var, boolean z, int i, int i2, int i3, int i4) {
        List<wt2> list = this.b;
        if (list != null) {
            Iterator<wt2> it = list.iterator();
            while (it.hasNext()) {
                it.next().b(vu2Var, z, i, i2, i3, i4);
            }
        }
    }

    public final void f0(View view) {
        List<yt2> list = this.a;
        if (list != null) {
            Iterator<yt2> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(view);
            }
        }
    }

    public final void g0() {
        removeCallbacks(this.w);
        removeCallbacks(this.u);
        su2 su2Var = this.e;
        if (su2Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            su2Var = null;
        }
        su2Var.getH().h();
        if (this.A) {
            h0();
        }
    }

    @NotNull
    public final su2 getContentContainer$app_marketRelease() {
        su2 su2Var = this.e;
        if (su2Var != null) {
            return su2Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
        return null;
    }

    @NotNull
    public final PanelContainer getPanelContainer$app_marketRelease() {
        PanelContainer panelContainer = this.f;
        if (panelContainer != null) {
            return panelContainer;
        }
        Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
        return null;
    }

    @Nullable
    public final Function2<WindowInsetsCompat, List<WindowInsetsAnimationCompat>, Integer> getSoftInputHeightCalculatorOnProgress() {
        return this.y;
    }

    @Nullable
    public final Function2<WindowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat, Integer> getSoftInputHeightCalculatorOnStart() {
        return this.x;
    }

    public final void h0() {
        if (this.g == null) {
            return;
        }
        Window window = null;
        if (this.G || l0()) {
            View rootView = this.h;
            if (rootView == null) {
                Window window2 = this.g;
                if (window2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("window");
                    window2 = null;
                }
                rootView = window2.getDecorView().getRootView();
            }
            ViewCompat.setOnApplyWindowInsetsListener(rootView, null);
        } else {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.z;
            if (onGlobalLayoutListener != null) {
                Window window3 = this.g;
                if (window3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("window");
                } else {
                    window = window3;
                }
                window.getDecorView().getRootView().getViewTreeObserver().removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        }
        this.A = false;
    }

    public final boolean i0() {
        return (M(this.n) && !M(this.m)) || (!M(this.n) && M(this.m));
    }

    @TargetApi(19)
    public final void j0(long j, int i) {
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(j);
        TransitionManager.beginDelayedTransition(this, changeBounds);
    }

    public final boolean k0() {
        Window window = this.g;
        if (window == null) {
            return false;
        }
        if (window == null) {
            Intrinsics.throwUninitializedPropertyAccessException("window");
            window = null;
        }
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        return cu2.b(decorView);
    }

    @ChecksSdkIntAtLeast(api = 30)
    public final boolean l0() {
        return Build.VERSION.SDK_INT >= 30;
    }

    @JvmOverloads
    public final void m0(boolean z) {
        if (z) {
            post(this.u);
            return;
        }
        su2 su2Var = this.e;
        if (su2Var == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            su2Var = null;
        }
        su2Var.getH().c();
    }

    public void n() {
        if (getChildCount() != 2) {
            throw new RuntimeException("PanelSwitchLayout -- PanelSwitchLayout should has two children,the first is ContentContainer,the other is PanelContainer！");
        }
        KeyEvent.Callback childAt = getChildAt(0);
        View childAt2 = getChildAt(1);
        if (!(childAt instanceof su2)) {
            throw new RuntimeException("PanelSwitchLayout -- the first view isn't a IContentContainer");
        }
        this.e = (su2) childAt;
        if (!(childAt2 instanceof PanelContainer)) {
            throw new RuntimeException("PanelSwitchLayout -- the second view is a ContentContainer, but the other isn't a PanelContainer！");
        }
        this.f = (PanelContainer) childAt2;
    }

    public final void n0() {
        if (this.A || this.g == null) {
            return;
        }
        if (this.G || l0()) {
            R();
        } else {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.z;
            if (onGlobalLayoutListener != null) {
                Window window = this.g;
                if (window == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("window");
                    window = null;
                }
                window.getDecorView().getRootView().getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
            }
        }
        this.A = true;
    }

    public final void o(@NotNull List<yt2> viewClickListeners, @NotNull List<wt2> panelChangeListeners, @NotNull List<ut2> keyboardStatusListeners, @NotNull List<tt2> editFocusChangeListeners) {
        Intrinsics.checkNotNullParameter(viewClickListeners, "viewClickListeners");
        Intrinsics.checkNotNullParameter(panelChangeListeners, "panelChangeListeners");
        Intrinsics.checkNotNullParameter(keyboardStatusListeners, "keyboardStatusListeners");
        Intrinsics.checkNotNullParameter(editFocusChangeListeners, "editFocusChangeListeners");
        this.a = viewClickListeners;
        this.b = panelChangeListeners;
        this.c = keyboardStatusListeners;
        this.d = editFocusChangeListeners;
    }

    public final void o0(int i) {
        String str = "trySyncKeyboardHeight: " + i;
        if (this.D <= 0 || i <= 0 || !this.G) {
            return;
        }
        PanelContainer panelContainer = this.f;
        if (panelContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
            panelContainer = null;
        }
        if (panelContainer.getTranslationY() == 0.0f) {
            return;
        }
        p0(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        n0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g0();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        u();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b2) {
        int i;
        if (getVisibility() != 0) {
            au2.g("PanelSwitchLayout#onLayout", "isGone，skip");
            return;
        }
        su2 su2Var = null;
        if (this.G) {
            super.onLayout(changed, l, t, r, b2);
            int iW = w(this.m);
            if (this.m == -1 || iW == 0) {
                return;
            }
            PanelContainer panelContainer = this.f;
            if (panelContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
                panelContainer = null;
            }
            float translationY = panelContainer.getTranslationY();
            su2 su2Var2 = this.e;
            if (su2Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            } else {
                su2Var = su2Var2;
            }
            su2Var.a(this.j, iW, translationY);
            return;
        }
        nt2 nt2Var = this.s;
        if (nt2Var == null) {
            super.onLayout(changed, l, t, r, b2);
            return;
        }
        zt2 zt2VarB = zt2.a.b(zt2.d, 0, 1, null);
        DeviceInfo deviceInfoB = nt2.b(nt2Var, false, 1, null);
        int iW2 = w(this.m);
        int paddingTop = getPaddingTop();
        int screenH = deviceInfoB.getScreenH();
        if (nt2Var.getE()) {
            screenH -= deviceInfoB.a(nt2Var.getF(), nt2Var.getG());
        }
        int i2 = screenH - bu2.c(this)[1];
        int iY = y(iW2) + paddingTop;
        int iX = x(i2, paddingTop, iW2);
        int i3 = iY + iX;
        int i4 = i3 + iW2;
        boolean zI = I(l, iY, r, i4);
        zt2VarB.a("changeBounds", String.valueOf(zI));
        if (zI) {
            boolean zI0 = i0();
            zt2VarB.a("reverseResetState", String.valueOf(zI0));
            if (zI0) {
                j0(this.p, this.m);
            }
        } else {
            int i5 = this.o;
            if (i5 != -1 && i5 != iW2) {
                j0(this.p, this.m);
            }
        }
        su2 su2Var3 = this.e;
        if (su2Var3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            su2Var3 = null;
        }
        su2Var3.b(l, iY, r, i3, this.j, iW2, this.r, N(), changed);
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(l);
        sb.append(',');
        sb.append(iY);
        sb.append(',');
        sb.append(r);
        sb.append(',');
        sb.append(i3);
        sb.append(')');
        zt2VarB.a("contentContainer Layout", sb.toString());
        su2 su2Var4 = this.e;
        if (su2Var4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            su2Var4 = null;
        }
        su2Var4.d(iX);
        PanelContainer panelContainer2 = this.f;
        if (panelContainer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
            i = i4;
            panelContainer2 = null;
        } else {
            i = i4;
        }
        panelContainer2.layout(l, i3, r, i);
        StringBuilder sb2 = new StringBuilder();
        sb2.append('(');
        sb2.append(l);
        sb2.append(',');
        sb2.append(i3);
        sb2.append(',');
        sb2.append(r);
        sb2.append(',');
        sb2.append(i);
        sb2.append(')');
        zt2VarB.a("panelContainer Layout", sb2.toString());
        PanelContainer panelContainer3 = this.f;
        if (panelContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
            panelContainer3 = null;
        }
        panelContainer3.b(iW2);
        this.o = iW2;
        su2 su2Var5 = this.e;
        if (su2Var5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            su2Var5 = null;
        }
        su2Var5.getH().d(nt2Var.getH(), this.m, iW2);
        zt2VarB.c("PanelSwitchLayout#onLayout");
    }

    public final void p(@NotNull Window window, @Nullable View view) {
        Intrinsics.checkNotNullParameter(window, "window");
        this.g = window;
        this.h = view;
        boolean z = this.q && k0();
        this.G = z;
        if (z) {
            O();
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.s = new nt2(context, window);
        window.setSoftInputMode(19);
        nt2 nt2Var = this.s;
        if (nt2Var != null) {
            su2 su2Var = this.e;
            if (su2Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
                su2Var = null;
            }
            tu2 inputActionImpl = su2Var.getH();
            boolean h = nt2Var.getH();
            int i = this.m;
            inputActionImpl.d(h, i, w(i));
            if (l0()) {
                R();
            } else {
                P(window, nt2Var);
            }
            this.A = true;
        }
    }

    public final void p0(int i) {
        String str = "updatePanelStateByAnimation: " + i;
        PanelContainer panelContainer = this.f;
        PanelContainer panelContainer2 = null;
        if (panelContainer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
            panelContainer = null;
        }
        float translationY = panelContainer.getTranslationY();
        float f = -i;
        if (!(translationY == f)) {
            final int iW = w(this.m);
            ValueAnimator duration = ValueAnimator.ofFloat(translationY, f).setDuration(this.p);
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: dc.mu2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PanelSwitchLayout.q0(this.a, iW, valueAnimator);
                }
            });
            duration.start();
        }
        PanelContainer panelContainer3 = this.f;
        if (panelContainer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
            panelContainer3 = null;
        }
        int i2 = panelContainer3.getLayoutParams().height;
        if (i <= 0 || i2 == i) {
            return;
        }
        PanelContainer panelContainer4 = this.f;
        if (panelContainer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
        } else {
            panelContainer2 = panelContainer4;
        }
        panelContainer2.getLayoutParams().height = i;
    }

    public final void q(boolean z, long j) {
        removeCallbacks(this.w);
        this.w.b(z);
        this.w.a(j);
        this.w.run();
    }

    public final boolean s(int i, boolean z) {
        if (this.v) {
            au2.g("PanelSwitchLayout#checkoutPanel", "is checkouting,just ignore!");
            return false;
        }
        this.v = true;
        if (i == this.m) {
            au2.g("PanelSwitchLayout#checkoutPanel", "current panelId is " + i + " ,just ignore!");
            this.v = false;
            return false;
        }
        su2 su2Var = null;
        if (i == -1) {
            su2 su2Var2 = this.e;
            if (su2Var2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
                su2Var2 = null;
            }
            su2Var2.getH().e(this.l, false);
            su2 su2Var3 = this.e;
            if (su2Var3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            } else {
                su2Var = su2Var3;
            }
            su2Var.getI().b(false);
            if (this.G) {
                p0(0);
            }
        } else if (i != 0) {
            Pair<Integer, Integer> pair = new Pair<>(Integer.valueOf((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()), Integer.valueOf(w(i)));
            PanelContainer panelContainer = this.f;
            if (panelContainer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
                panelContainer = null;
            }
            Pair<Integer, Integer> pairF = panelContainer.f(i, pair);
            if (!Intrinsics.areEqual(pair.first, pairF.first) || !Intrinsics.areEqual(pair.second, pairF.second)) {
                PanelContainer panelContainer2 = this.f;
                if (panelContainer2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelContainer");
                    panelContainer2 = null;
                }
                vu2 vu2VarD = panelContainer2.d(i);
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                boolean zQ = bu2.q(context);
                Object obj = pairF.first;
                Intrinsics.checkNotNullExpressionValue(obj, "oldSize.first");
                int iIntValue = ((Number) obj).intValue();
                Object obj2 = pairF.second;
                Intrinsics.checkNotNullExpressionValue(obj2, "oldSize.second");
                int iIntValue2 = ((Number) obj2).intValue();
                Object obj3 = pair.first;
                Intrinsics.checkNotNullExpressionValue(obj3, "size.first");
                int iIntValue3 = ((Number) obj3).intValue();
                Object obj4 = pair.second;
                Intrinsics.checkNotNullExpressionValue(obj4, "size.second");
                e0(vu2VarD, zQ, iIntValue, iIntValue2, iIntValue3, ((Number) obj4).intValue());
            }
            su2 su2Var4 = this.e;
            if (su2Var4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
                su2Var4 = null;
            }
            su2Var4.getH().e(this.l, false);
            su2 su2Var5 = this.e;
            if (su2Var5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            } else {
                su2Var = su2Var5;
            }
            su2Var.getI().b(true);
            if (this.G) {
                p0(w(i));
            }
        } else {
            if (z) {
                su2 su2Var6 = this.e;
                if (su2Var6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
                    su2Var6 = null;
                }
                if (!su2Var6.getH().a()) {
                    au2.g("PanelSwitchLayout#checkoutPanel", "system show keyboard fail, just ignore!");
                    this.v = false;
                    return false;
                }
            }
            su2 su2Var7 = this.e;
            if (su2Var7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            } else {
                su2Var = su2Var7;
            }
            su2Var.getI().b(true);
        }
        this.n = this.m;
        this.m = i;
        au2.g("PanelSwitchLayout#checkoutPanel", "checkout success ! lastPanel's id : " + this.n + " , panel's id :" + i);
        requestLayout();
        d0(this.m);
        this.v = false;
        return true;
    }

    public final void setContentScrollOutsizeEnable$app_marketRelease(boolean enable) {
        this.r = enable;
    }

    public final void setPanelHeightMeasurers$app_marketRelease(@NotNull List<qt2> mutableList) {
        Intrinsics.checkNotNullParameter(mutableList, "mutableList");
        for (qt2 qt2Var : mutableList) {
            this.k.put(Integer.valueOf(qt2Var.c()), qt2Var);
        }
    }

    public final void setScrollMeasurers$app_marketRelease(@NotNull List<ot2> mutableList) {
        Intrinsics.checkNotNullParameter(mutableList, "mutableList");
        this.j.addAll(mutableList);
    }

    public final void setSoftInputHeightCalculatorOnProgress(@Nullable Function2<? super WindowInsetsCompat, ? super List<WindowInsetsAnimationCompat>, Integer> function2) {
        this.y = function2;
    }

    public final void setSoftInputHeightCalculatorOnStart(@Nullable Function2<? super WindowInsetsAnimationCompat, ? super WindowInsetsAnimationCompat.BoundsCompat, Integer> function2) {
        this.x = function2;
    }

    public final void setTriggerViewClickInterceptor$app_marketRelease(@Nullable st2 st2Var) {
        this.i = st2Var;
    }

    public final void u() {
        n();
        D();
    }

    public final int v(nt2 nt2Var, Window window) {
        if (nt2Var.getE() || Build.VERSION.SDK_INT < 29 || !bu2.a.m(window, 512)) {
            return 0;
        }
        WindowInsets rootWindowInsets = window.getDecorView().getRootView().getRootWindowInsets();
        au2.g("PanelSwitchLayout#onGlobalLayout", " -> Android Q takes windowInset into calculation When nav is not shown and SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION flag is existed <-");
        au2.g("PanelSwitchLayout#onGlobalLayout", "stableInsetTop is : " + rootWindowInsets.getStableInsetTop());
        au2.g("PanelSwitchLayout#onGlobalLayout", "stableInsetBottom is : " + rootWindowInsets.getStableInsetBottom());
        au2.g("PanelSwitchLayout#onGlobalLayout", "androidQCompatNavH is  " + rootWindowInsets.getStableInsetBottom());
        return rootWindowInsets.getStableInsetBottom();
    }

    public final int w(int i) {
        qt2 qt2Var;
        if (L(i) && (qt2Var = this.k.get(Integer.valueOf(i))) != null) {
            du2 du2Var = du2.a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            if (!du2Var.b(context) || !qt2Var.b()) {
                int iA = qt2Var.a();
                au2.g("PanelSwitchLayout#onLayout", " getCompatPanelHeight by default panel  :" + iA);
                return iA;
            }
        }
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        int iA2 = du2.a(context2);
        au2.g("PanelSwitchLayout#onLayout", " getCompatPanelHeight  :" + iA2);
        return iA2;
    }

    public final int x(int i, int i2, int i3) {
        int i4 = i - i2;
        if (this.r || N()) {
            i3 = 0;
        }
        return i4 - i3;
    }

    public final int y(int i) {
        int i2 = 0;
        if (this.r && !N()) {
            i2 = -i;
        }
        au2.g("PanelSwitchLayout#onLayout", " getContentContainerTop  :" + i2);
        return i2;
    }

    public final int z(nt2 nt2Var, DeviceInfo deviceInfo) {
        if (nt2Var.getE()) {
            return deviceInfo.a(nt2Var.getF(), nt2Var.getG());
        }
        return 0;
    }

    public /* synthetic */ PanelSwitchLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}

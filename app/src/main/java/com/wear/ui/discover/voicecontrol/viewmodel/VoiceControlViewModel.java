package com.wear.ui.discover.voicecontrol.viewmodel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelProvider;
import com.alibaba.fastjson.JSON;
import com.broadcom.bt.util.io.IOUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import com.wear.bean.PatternHead;
import com.wear.bean.data.StraightPatternConfig;
import com.wear.bean.data.VoiceConfig;
import com.wear.bean.data.VoiceControlConfigBean;
import com.wear.bean.data.VoiceModelBean;
import com.wear.bean.data.VoiceModelData;
import com.wear.bean.data.WavePatternConfig;
import com.wear.network.protocol.exception.NetException;
import com.wear.protocol.EntityVideo;
import com.wear.util.WearUtils;
import dc.ScaleVolume;
import dc.VoiceControlCommand;
import dc.VoskResult;
import dc.b13;
import dc.e13;
import dc.eg3;
import dc.h04;
import dc.h14;
import dc.ku1;
import dc.n04;
import dc.pc1;
import dc.ro2;
import dc.rq1;
import dc.rz3;
import dc.s14;
import dc.sg3;
import dc.sy3;
import dc.ti3;
import dc.tn2;
import dc.u34;
import dc.uy3;
import dc.v34;
import dc.w03;
import dc.wz3;
import dc.x03;
import dc.y03;
import dc.yn2;
import dc.zf3;
import dc.zn2;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.random.Random;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;
import org.slf4j.helpers.MessageFormatter;
import org.vosk.Model;
import org.vosk.Recognizer;
import org.vosk.android.RecognitionListener;

/* compiled from: VoiceControlViewModel.kt */
@Metadata(d1 = {"\u0000Ð\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u009b\u00012\u00020\u00012\u00020\u0002:\u0004\u009b\u0001\u009c\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010Z\u001a\u00020\u000f2\u0006\u0010[\u001a\u00020\u0019H\u0002J\b\u0010\\\u001a\u00020\u0015H\u0002J\b\u0010]\u001a\u00020\u0019H\u0002J\u0010\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\tH\u0002J\b\u0010a\u001a\u00020\u0019H\u0002J\u0010\u0010b\u001a\u00020_2\u0006\u0010`\u001a\u00020\tH\u0002J\u0006\u0010c\u001a\u00020_J\u0010\u0010d\u001a\u00020\u00192\u0006\u0010e\u001a\u00020\u0019H\u0002J\b\u0010f\u001a\u00020_H\u0002J\b\u0010g\u001a\u00020_H\u0002J\u0016\u0010h\u001a\u00020_2\u0006\u0010i\u001a\u00020(2\u0006\u0010j\u001a\u00020(J\u0010\u0010k\u001a\u00020\u00192\b\u0010l\u001a\u0004\u0018\u00010\u001cJ\u0006\u0010m\u001a\u00020_J\u0006\u0010n\u001a\u00020_J\u000e\u0010o\u001a\u00020_2\u0006\u0010p\u001a\u00020(J\u0010\u0010q\u001a\u00020_2\u0006\u0010p\u001a\u00020(H\u0002J\u0010\u0010r\u001a\u00020_2\u0006\u0010p\u001a\u00020(H\u0002J\b\u0010s\u001a\u00020_H\u0002J\b\u0010t\u001a\u00020_H\u0002J\u000e\u0010u\u001a\u00020_2\u0006\u0010v\u001a\u00020(J\u000e\u0010w\u001a\u00020_2\u0006\u0010x\u001a\u00020\tJ\u0006\u0010y\u001a\u00020_J\u000e\u0010z\u001a\u00020\t2\u0006\u0010p\u001a\u00020(J\b\u0010{\u001a\u00020\tH\u0002J\b\u0010|\u001a\u00020\tH\u0002J\b\u0010}\u001a\u00020\tH\u0002J\b\u0010~\u001a\u00020_H\u0014J\u001b\u0010\u007f\u001a\u00020_2\u0011\u0010\u0080\u0001\u001a\f\u0018\u00010\u0081\u0001j\u0005\u0018\u0001`\u0082\u0001H\u0016J\t\u0010\u0083\u0001\u001a\u00020_H\u0002J\u0014\u0010\u0084\u0001\u001a\u00020_2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010(H\u0016J\u0014\u0010\u0086\u0001\u001a\u00020_2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010(H\u0016J\u0014\u0010\u0087\u0001\u001a\u00020_2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010(H\u0016J\t\u0010\u0088\u0001\u001a\u00020_H\u0002J\t\u0010\u0089\u0001\u001a\u00020_H\u0016J\u001f\u0010\u008a\u0001\u001a\u00020_2\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001H\u0082@ø\u0001\u0000¢\u0006\u0003\u0010\u008d\u0001J\t\u0010\u008e\u0001\u001a\u00020_H\u0002J\t\u0010\u008f\u0001\u001a\u00020_H\u0002J\u0012\u0010\u0090\u0001\u001a\u00020_2\u0007\u0010\u0091\u0001\u001a\u00020\tH\u0002J\t\u0010\u0092\u0001\u001a\u00020_H\u0002J7\u0010\u0093\u0001\u001a\u00020E2\u0018\b\u0002\u0010\u0094\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020_\u0018\u00010\u0095\u00012\u0012\b\u0002\u0010\u0096\u0001\u001a\u000b\u0012\u0004\u0012\u00020_\u0018\u00010\u0097\u0001H\u0002J\t\u0010\u0098\u0001\u001a\u00020_H\u0002J\u001b\u0010\u0099\u0001\u001a\u00020_2\u0007\u0010\u009a\u0001\u001a\u00020(2\u0007\u0010\u0091\u0001\u001a\u00020\tH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0016\u0010\u0011R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0011R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0011R\u000e\u0010\"\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0013\u001a\u0004\b-\u0010\u0011R$\u00100\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R!\u00105\u001a\b\u0012\u0004\u0012\u00020(0\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u0013\u001a\u0004\b6\u0010\u0011R\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0011R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u000e¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0011R$\u0010=\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b>\u00102\"\u0004\b?\u00104R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010B\u001a\b\u0012\u0004\u0012\u00020(0\u000e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010\u0011R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020(0\u000e¢\u0006\b\n\u0000\u001a\u0004\bG\u0010\u0011R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\u0013\u001a\u0004\bL\u0010\u0011R!\u0010N\u001a\b\u0012\u0004\u0012\u00020O0\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010\u0013\u001a\u0004\bP\u0010\u0011R!\u0010R\u001a\b\u0012\u0004\u0012\u00020S0\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\u0013\u001a\u0004\bT\u0010\u0011R!\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bX\u0010\u0013\u001a\u0004\bW\u0010\u0011R\u000e\u0010Y\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u009d\u0001"}, d2 = {"Lcom/wear/ui/discover/voicecontrol/viewmodel/VoiceControlViewModel;", "Landroidx/lifecycle/ViewModel;", "Lorg/vosk/android/RecognitionListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_patternType", "Lcom/wear/ui/discover/voicecontrol/PatternType;", "_receiveCommand", "", "_showConfirm", "btWork", "Lcom/lovense/btservice/work/BtWork;", "commandValue", "Landroidx/lifecycle/MutableLiveData;", "Lcom/wear/ui/discover/voicecontrol/VoiceControlCommand;", "getCommandValue", "()Landroidx/lifecycle/MutableLiveData;", "commandValue$delegate", "Lkotlin/Lazy;", "debugFrequency", "", "getDebugFrequency", "debugFrequency$delegate", "defaultF", "", "defaultStrongerX", "guideStep", "Lcom/wear/ui/discover/voicecontrol/GuideStep;", "getGuideStep", "interval", "", "isChangePatternType", "isFrequency", "isStartPlay", "lastResultTime", "model", "Lorg/vosk/Model;", "originalCommands", "", "", "patternCommands", "patternHead", "Lcom/wear/bean/PatternHead;", "patternType", "getPatternType", "patternType$delegate", "value", "receiveCommand", "getReceiveCommand", "()Z", "setReceiveCommand", "(Z)V", "recognitionResult", "getRecognitionResult", "recognitionResult$delegate", "scaleHeightLight", "getScaleHeightLight", "scaleVolume", "Lcom/wear/ui/discover/voicecontrol/ScaleVolume;", "getScaleVolume", "showConfirm", "getShowConfirm", "setShowConfirm", "speechService", "Lcom/wear/util/RemoteSpeechService;", "startVoice", "getStartVoice", "timerCoroutines", "Lkotlinx/coroutines/Job;", "topGuide", "getTopGuide", "voiceConfig", "Lcom/wear/bean/data/VoiceConfig;", "voiceModel", "Lcom/wear/bean/data/VoiceModelData;", "getVoiceModel", "voiceModel$delegate", "voskResult", "Lcom/wear/ui/discover/voicecontrol/VoskResult;", "getVoskResult", "voskResult$delegate", "voskStatus", "Lcom/wear/ui/discover/voicecontrol/VoskStatus;", "getVoskStatus", "voskStatus$delegate", "waveFrequency", "getWaveFrequency", "waveFrequency$delegate", "x", "calculateDefault", "i", "calculateFrequency", "calculateStraight", "calculateStronger", "", "isWave", "calculateWave", "calculateWeaker", "cleared", "defaultStrength", "number", "defaultStronger", "defaultWeaker", "downloadModel", ImagesContract.URL, "modelName", "getNumberFromStep", "step", "getVoiceControlConfig", "getVoiceResource", "handleRecognitionResults", "result", "handleSpeedCommand", "handleStrengthCommand", "handleStronger", "handleWeaker", "initModel", "modelPath", "intoMicrophone", "again", "intoNewGuideStop", "isCommand", "isNetworkConnected", "isReceiveControl", "isVoiceControlToy", "onCleared", "onError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onFaster", "onFinalResult", "hypothesis", "onPartialResult", "onResult", "onSlower", "onTimeout", "parseCommands", "file", "Ljava/io/File;", "(Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "playPattern", "postDebugFrequency", "recognizeMicrophone", "newGuide", "startTimer", "startTimerCoroutines", "onTick", "Lkotlin/Function1;", "onFinish", "Lkotlin/Function0;", "stop", "uploadLog", "resultStr", "Companion", "Factory", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes3.dex */
public final class VoiceControlViewModel extends ViewModel implements RecognitionListener {

    @NotNull
    public final Lazy A;

    @NotNull
    public final Lazy B;

    @NotNull
    public final MutableLiveData<Boolean> C;

    @NotNull
    public final Lazy D;

    @NotNull
    public final Lazy E;

    @NotNull
    public final MutableLiveData<Boolean> F;

    @NotNull
    public final Context a;

    @Nullable
    public zf3 b;

    @Nullable
    public h14 c;

    @Nullable
    public Model d;

    @NotNull
    public final pc1 e;

    @Nullable
    public VoiceConfig f;

    @Nullable
    public PatternHead g;

    @NotNull
    public final List<String> h;

    @NotNull
    public final List<String> i;
    public long j;
    public long k;
    public long l;

    @NotNull
    public y03 m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;

    @NotNull
    public final MutableLiveData<w03> s;

    @NotNull
    public final Lazy t;

    @NotNull
    public final MutableLiveData<String> u;

    @NotNull
    public final MutableLiveData<ScaleVolume> v;

    @NotNull
    public final MutableLiveData<String> w;

    @NotNull
    public final Lazy x;

    @NotNull
    public final Lazy y;

    @NotNull
    public final Lazy z;

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/wear/ui/discover/voicecontrol/viewmodel/VoiceControlViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$NewInstanceFactory;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "create", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Factory extends ViewModelProvider.NewInstanceFactory {

        @NotNull
        public final Context a;

        public Factory(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.a = context;
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return new VoiceControlViewModel(this.a);
        }
    }

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[y03.values().length];
            iArr[y03.DEFAULT.ordinal()] = 1;
            iArr[y03.STRAIGHT.ordinal()] = 2;
            iArr[y03.WAVE.ordinal()] = 3;
            a = iArr;
            int[] iArr2 = new int[w03.values().length];
            iArr2[w03.STEP_01.ordinal()] = 1;
            iArr2[w03.STEP_02.ordinal()] = 2;
            iArr2[w03.STEP_03.ordinal()] = 3;
            iArr2[w03.STEP_04.ordinal()] = 4;
            b = iArr2;
        }
    }

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "Lcom/wear/ui/discover/voicecontrol/VoiceControlCommand;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<MutableLiveData<VoiceControlCommand>> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MutableLiveData<VoiceControlCommand> invoke() {
            return new MutableLiveData<>();
        }
    }

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<MutableLiveData<Float>> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MutableLiveData<Float> invoke() {
            return new MutableLiveData<>();
        }
    }

    /* compiled from: CoroutineExceptionHandler.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class d extends AbstractCoroutineContextElement implements rz3 {
        public final /* synthetic */ VoiceControlViewModel a;
        public final /* synthetic */ String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(rz3.a aVar, VoiceControlViewModel voiceControlViewModel, String str) {
            super(aVar);
            this.a = voiceControlViewModel;
            this.b = str;
        }

        @Override // dc.rz3
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            x03 x03Var = x03.a;
            String message = exception.getMessage();
            if (message == null) {
                message = "downloadError";
            }
            x03Var.j(message);
            ti3.b(new File(this.a.a.getExternalFilesDir("wear/model"), this.b));
        }
    }

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel$downloadModel$1", f = "VoiceControlViewModel.kt", i = {}, l = {274}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ String $modelName;
        public final /* synthetic */ String $url;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, String str2, Continuation<? super e> continuation) {
            super(2, continuation);
            this.$url = str;
            this.$modelName = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return VoiceControlViewModel.this.new e(this.$url, this.$modelName, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((e) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                x03 x03Var = x03.a;
                Context context = VoiceControlViewModel.this.a;
                String str = this.$url;
                String str2 = this.$modelName;
                this.label = 1;
                if (x03Var.d(context, str, str2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/wear/ui/discover/voicecontrol/viewmodel/VoiceControlViewModel$getVoiceControlConfig$1", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class f implements zn2<String> {
        public f() {
        }

        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable String str) {
            if (str != null) {
                VoiceControlViewModel voiceControlViewModel = VoiceControlViewModel.this;
                VoiceControlConfigBean voiceControlConfigBean = (VoiceControlConfigBean) ro2.a(str, VoiceControlConfigBean.class);
                voiceControlViewModel.f = voiceControlConfigBean != null ? voiceControlConfigBean.getData() : null;
            }
        }

        @Override // dc.zn2
        public void onError(@Nullable NetException e) {
        }
    }

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000b"}, d2 = {"com/wear/ui/discover/voicecontrol/viewmodel/VoiceControlViewModel$getVoiceResource$1", "Lcom/wear/network/protocol/callback/ResponseCallBack;", "Lcom/wear/bean/data/VoiceModelBean;", "onCompleted", "", "onError", "e", "Lcom/wear/network/protocol/exception/NetException;", "onStart", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class g implements yn2<VoiceModelBean> {
        public g() {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable VoiceModelBean voiceModelBean) {
            if (voiceModelBean != null) {
                VoiceControlViewModel voiceControlViewModel = VoiceControlViewModel.this;
                if (!voiceModelBean.getResult()) {
                    sg3.l(voiceModelBean.getMessage());
                    return;
                }
                voiceControlViewModel.L().postValue(voiceModelBean.getData());
                Context context = voiceControlViewModel.a;
                VoiceModelData data = voiceModelBean.getData();
                eg3.i(context, "modelName", data != null ? data.getModelName() : null);
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(@Nullable NetException e) {
            String modelName;
            File externalFilesDir = VoiceControlViewModel.this.a.getExternalFilesDir("wear/model");
            String strH = eg3.h(VoiceControlViewModel.this.a, "modelName", "");
            VoiceModelData voiceModelDataH = x03.a.h();
            if (voiceModelDataH != null && (modelName = voiceModelDataH.getModelName()) != null) {
                strH = modelName;
            }
            File file = new File(externalFilesDir, strH);
            if (!file.exists() || file.length() <= 0) {
                VoiceControlViewModel.this.O().postValue(e13.STATUS_ERROR);
            } else {
                VoiceControlViewModel.this.L().postValue(new VoiceModelData(false, null, null, null));
            }
            sg3.l(e != null ? e.message : null);
        }

        @Override // dc.yn2
        public void onStart() {
        }
    }

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel$handleRecognitionResults$1", f = "VoiceControlViewModel.kt", i = {}, l = {361, 363}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        /* compiled from: VoiceControlViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel$handleRecognitionResults$1$1", f = "VoiceControlViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public int label;
            public final /* synthetic */ VoiceControlViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(VoiceControlViewModel voiceControlViewModel, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = voiceControlViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.B().setValue(w03.STEP_02);
                return Unit.INSTANCE;
            }
        }

        public h(Continuation<? super h> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return VoiceControlViewModel.this.new h(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((h) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                VoiceControlViewModel.this.N().postValue(new VoskResult("Start", false));
                this.label = 1;
                if (h04.a(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            VoiceControlViewModel.this.N().postValue(new VoskResult("Click the \"Tips\" button", true));
            s14 s14VarC = n04.c();
            a aVar = new a(VoiceControlViewModel.this, null);
            this.label = 2;
            if (sy3.g(s14VarC, aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel$handleRecognitionResults$2", f = "VoiceControlViewModel.kt", i = {}, l = {387, 388}, m = "invokeSuspend", n = {}, s = {})
    public static final class i extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        /* compiled from: VoiceControlViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel$handleRecognitionResults$2$1", f = "VoiceControlViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
            public int label;
            public final /* synthetic */ VoiceControlViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(VoiceControlViewModel voiceControlViewModel, Continuation<? super a> continuation) {
                super(2, continuation);
                this.this$0 = voiceControlViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new a(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
                return ((a) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.B().setValue(w03.STEP_04);
                return Unit.INSTANCE;
            }
        }

        public i(Continuation<? super i> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return VoiceControlViewModel.this.new i(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((i) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                VoiceControlViewModel.this.N().postValue(new VoskResult("Stop", false));
                this.label = 1;
                if (h04.a(3000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            s14 s14VarC = n04.c();
            a aVar = new a(VoiceControlViewModel.this, null);
            this.label = 2;
            if (sy3.g(s14VarC, aVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel$intoMicrophone$1", f = "VoiceControlViewModel.kt", i = {}, l = {TypedValues.AttributesType.TYPE_PATH_ROTATE}, m = "invokeSuspend", n = {}, s = {})
    public static final class j extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public j(Continuation<? super j> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return VoiceControlViewModel.this.new j(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((j) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                VoiceControlViewModel.this.N().postValue(new VoskResult("Click \"Tips\" for more command", false));
                this.label = 1;
                if (h04.a(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            VoiceControlViewModel.this.N().postValue(new VoskResult("Say \"Start\" to begin your voice journey", false));
            return Unit.INSTANCE;
        }
    }

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel$intoNewGuideStop$1", f = "VoiceControlViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class k extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public int label;

        public k(Continuation<? super k> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return VoiceControlViewModel.this.new k(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((k) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            VoiceControlViewModel.this.N().postValue(new VoskResult("Great! Now try: \"Stop\"", true));
            VoiceControlViewModel.this.n0(TtmlNode.START, true);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel$parseCommands$2", f = "VoiceControlViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class l extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ File $file;
        public int label;
        public final /* synthetic */ VoiceControlViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(File file, VoiceControlViewModel voiceControlViewModel, Continuation<? super l> continuation) {
            super(2, continuation);
            this.$file = file;
            this.this$0 = voiceControlViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new l(this.$file, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((l) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            File file = this.$file;
            if (file == null) {
                return null;
            }
            VoiceControlViewModel voiceControlViewModel = this.this$0;
            voiceControlViewModel.h.clear();
            voiceControlViewModel.i.clear();
            String strN1 = WearUtils.N1(file.getPath());
            Intrinsics.checkNotNullExpressionValue(strN1, "readTextFile(it.path)");
            String strReplace$default = StringsKt__StringsJVMKt.replace$default(strN1, "#\n;", "#", false, 4, (Object) null);
            int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) strReplace$default, "#", 0, false, 6, (Object) null);
            String strSubstring = strReplace$default.substring(0, iIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            voiceControlViewModel.g = new PatternHead(strSubstring);
            if (iIndexOf$default > 0) {
                String strSubstring2 = strReplace$default.substring(iIndexOf$default + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
                for (String str : StringsKt__StringsKt.split$default((CharSequence) StringsKt__StringsJVMKt.replace$default(strSubstring2, IOUtils.LINE_SEPARATOR_UNIX, "", false, 4, (Object) null), new String[]{";"}, false, 0, 6, (Object) null)) {
                    if (str.length() > 0) {
                        voiceControlViewModel.h.add(str);
                        voiceControlViewModel.i.add(str);
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "Lcom/wear/ui/discover/voicecontrol/PatternType;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class m extends Lambda implements Function0<MutableLiveData<y03>> {
        public static final m a = new m();

        public m() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MutableLiveData<y03> invoke() {
            return new MutableLiveData<>();
        }
    }

    /* compiled from: CoroutineExceptionHandler.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class n extends AbstractCoroutineContextElement implements rz3 {
        public n(rz3.a aVar) {
            super(aVar);
        }

        @Override // dc.rz3
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            String str = "play pattern Exception " + exception;
        }
    }

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel$playPattern$1", f = "VoiceControlViewModel.kt", i = {0}, l = {1003, 1005}, m = "invokeSuspend", n = {"file"}, s = {"L$1"})
    public static final class o extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public Object L$0;
        public Object L$1;
        public int label;

        public o(Continuation<? super o> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return VoiceControlViewModel.this.new o(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((o) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00c0  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00d3  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x00e0  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x00f7  */
        /* JADX WARN: Removed duplicated region for block: B:64:0x0104 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:65:0x0105  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 280
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel.o.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class p extends Lambda implements Function0<MutableLiveData<String>> {
        public static final p a = new p();

        public p() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MutableLiveData<String> invoke() {
            return new MutableLiveData<>();
        }
    }

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel$recognizeMicrophone$1", f = "VoiceControlViewModel.kt", i = {}, l = {294, 298}, m = "invokeSuspend", n = {}, s = {})
    public static final class q extends SuspendLambda implements Function2<wz3, Continuation<? super Unit>, Object> {
        public final /* synthetic */ boolean $newGuide;
        public int label;
        public final /* synthetic */ VoiceControlViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(boolean z, VoiceControlViewModel voiceControlViewModel, Continuation<? super q> continuation) {
            super(2, continuation);
            this.$newGuide = z;
            this.this$0 = voiceControlViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new q(this.$newGuide, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull wz3 wz3Var, @Nullable Continuation<? super Unit> continuation) {
            return ((q) create(wz3Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$newGuide) {
                    this.this$0.O().postValue(e13.STATE_MIC);
                    this.this$0.B().postValue(w03.STEP_01);
                    this.this$0.N().postValue(new VoskResult("Welcome to beginner mode. Let's get started!", true));
                    this.label = 1;
                    if (h04.a(3000L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.this$0.N().postValue(new VoskResult("Try saying: \"Start\" ", true));
                } else {
                    this.this$0.N().postValue(new VoskResult("Click \"Tips\" for more command", false));
                    this.label = 2;
                    if (h04.a(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    this.this$0.N().postValue(new VoskResult("Say \"Start\" to begin your voice journey", false));
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
                this.this$0.N().postValue(new VoskResult("Try saying: \"Start\" ", true));
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.N().postValue(new VoskResult("Say \"Start\" to begin your voice journey", false));
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "command", "Lcom/wear/ui/discover/voicecontrol/VoiceControlCommand;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class r extends Lambda implements Function1<VoiceControlCommand, Unit> {
        public r() {
            super(1);
        }

        public final void a(@NotNull VoiceControlCommand command) {
            Intrinsics.checkNotNullParameter(command, "command");
            String str = "sendToyCommand : " + command;
            VoiceControlViewModel.this.z().setValue(command);
            if (command.getIsMultiply()) {
                Integer value = command.getValue();
                int iIntValue = value != null ? value.intValue() : 0;
                String str2 = "command value: " + iIntValue;
                rq1.d.j(iIntValue);
                return;
            }
            rq1 rq1Var = rq1.d;
            List<String> listB = command.b();
            if (listB == null) {
                listB = CollectionsKt__CollectionsKt.emptyList();
            }
            List<String> listA = command.a();
            if (listA == null) {
                listA = CollectionsKt__CollectionsKt.emptyList();
            }
            rq1Var.k(listB, listA);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(VoiceControlCommand voiceControlCommand) {
            a(voiceControlCommand);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class s extends Lambda implements Function0<Unit> {
        public static final s a = new s();

        public s() {
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

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/wear/ui/discover/voicecontrol/VoiceControlCommand;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel$startTimerCoroutines$1", f = "VoiceControlViewModel.kt", i = {0, 0, 1, 1}, l = {1102, 1103}, m = "invokeSuspend", n = {"$this$flow", "i", "$this$flow", "i"}, s = {"L$0", "I$0", "L$0", "I$0"})
    public static final class t extends SuspendLambda implements Function2<u34<? super VoiceControlCommand>, Continuation<? super Unit>, Object> {
        public int I$0;
        private /* synthetic */ Object L$0;
        public int label;

        /* compiled from: VoiceControlViewModel.kt */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[y03.values().length];
                iArr[y03.DEFAULT.ordinal()] = 1;
                iArr[y03.STRAIGHT.ordinal()] = 2;
                iArr[y03.WAVE.ordinal()] = 3;
                a = iArr;
            }
        }

        public t(Continuation<? super t> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            t tVar = VoiceControlViewModel.this.new t(continuation);
            tVar.L$0 = obj;
            return tVar;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull u34<? super VoiceControlCommand> u34Var, @Nullable Continuation<? super Unit> continuation) {
            return ((t) create(u34Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00ab A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00ae  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00a9 -> B:29:0x00ac). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
            /*
                r14 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r14.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2f
                if (r1 == r3) goto L23
                if (r1 != r2) goto L1b
                int r1 = r14.I$0
                java.lang.Object r4 = r14.L$0
                dc.u34 r4 = (dc.u34) r4
                kotlin.ResultKt.throwOnFailure(r15)
                r15 = r4
                r4 = r14
                goto Lac
            L1b:
                java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r15.<init>(r0)
                throw r15
            L23:
                int r1 = r14.I$0
                java.lang.Object r4 = r14.L$0
                dc.u34 r4 = (dc.u34) r4
                kotlin.ResultKt.throwOnFailure(r15)
                r15 = r4
                r4 = r14
                goto L99
            L2f:
                kotlin.ResultKt.throwOnFailure(r15)
                java.lang.Object r15 = r14.L$0
                dc.u34 r15 = (dc.u34) r15
                r1 = 0
                r4 = r14
            L38:
                r5 = 2147483647(0x7fffffff, float:NaN)
                if (r1 >= r5) goto Lae
                com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel r5 = com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel.this
                dc.y03 r5 = com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel.j(r5)
                int[] r6 = com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel.t.a.a
                int r5 = r5.ordinal()
                r5 = r6[r5]
                if (r5 == r3) goto L86
                if (r5 == r2) goto L6f
                r6 = 3
                if (r5 != r6) goto L69
                com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel r5 = com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel.this
                int r5 = com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel.d(r5)
                dc.a13 r13 = new dc.a13
                r7 = 1
                java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
                r9 = 0
                r10 = 0
                r11 = 12
                r12 = 0
                r6 = r13
                r6.<init>(r7, r8, r9, r10, r11, r12)
                goto L8c
            L69:
                kotlin.NoWhenBranchMatchedException r15 = new kotlin.NoWhenBranchMatchedException
                r15.<init>()
                throw r15
            L6f:
                com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel r5 = com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel.this
                int r5 = com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel.c(r5)
                dc.a13 r13 = new dc.a13
                r7 = 1
                java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
                r9 = 0
                r10 = 0
                r11 = 12
                r12 = 0
                r6 = r13
                r6.<init>(r7, r8, r9, r10, r11, r12)
                goto L8c
            L86:
                com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel r5 = com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel.this
                dc.a13 r13 = com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel.a(r5, r1)
            L8c:
                r4.L$0 = r15
                r4.I$0 = r1
                r4.label = r3
                java.lang.Object r5 = r15.emit(r13, r4)
                if (r5 != r0) goto L99
                return r0
            L99:
                com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel r5 = com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel.this
                long r5 = com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel.f(r5)
                r4.L$0 = r15
                r4.I$0 = r1
                r4.label = r2
                java.lang.Object r5 = dc.h04.a(r5, r4)
                if (r5 != r0) goto Lac
                return r0
            Lac:
                int r1 = r1 + r3
                goto L38
            Lae:
                kotlin.Unit r15 = kotlin.Unit.INSTANCE
                return r15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel.t.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Lcom/wear/ui/discover/voicecontrol/VoiceControlCommand;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel$startTimerCoroutines$2", f = "VoiceControlViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class u extends SuspendLambda implements Function2<VoiceControlCommand, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Function1<VoiceControlCommand, Unit> $onTick;
        public /* synthetic */ Object L$0;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public u(Function1<? super VoiceControlCommand, Unit> function1, Continuation<? super u> continuation) {
            super(2, continuation);
            this.$onTick = function1;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull VoiceControlCommand voiceControlCommand, @Nullable Continuation<? super Unit> continuation) {
            return ((u) create(voiceControlCommand, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            u uVar = new u(this.$onTick, continuation);
            uVar.L$0 = obj;
            return uVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            VoiceControlCommand voiceControlCommand = (VoiceControlCommand) this.L$0;
            Function1<VoiceControlCommand, Unit> function1 = this.$onTick;
            if (function1 != null) {
                function1.invoke(voiceControlCommand);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/wear/ui/discover/voicecontrol/VoiceControlCommand;", "it", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel$startTimerCoroutines$3", f = "VoiceControlViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class v extends SuspendLambda implements Function3<u34<? super VoiceControlCommand>, Throwable, Continuation<? super Unit>, Object> {
        public final /* synthetic */ Function0<Unit> $onFinish;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(Function0<Unit> function0, Continuation<? super v> continuation) {
            super(3, continuation);
            this.$onFinish = function0;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(@NotNull u34<? super VoiceControlCommand> u34Var, @Nullable Throwable th, @Nullable Continuation<? super Unit> continuation) {
            return new v(this.$onFinish, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Function0<Unit> function0 = this.$onFinish;
            if (function0 != null) {
                function0.invoke();
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "Lcom/wear/bean/data/VoiceModelData;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class w extends Lambda implements Function0<MutableLiveData<VoiceModelData>> {
        public static final w a = new w();

        public w() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MutableLiveData<VoiceModelData> invoke() {
            return new MutableLiveData<>();
        }
    }

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "Lcom/wear/ui/discover/voicecontrol/VoskResult;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class x extends Lambda implements Function0<MutableLiveData<VoskResult>> {
        public static final x a = new x();

        public x() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MutableLiveData<VoskResult> invoke() {
            return new MutableLiveData<>();
        }
    }

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "Lcom/wear/ui/discover/voicecontrol/VoskStatus;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class y extends Lambda implements Function0<MutableLiveData<e13>> {
        public static final y a = new y();

        public y() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MutableLiveData<e13> invoke() {
            return new MutableLiveData<>();
        }
    }

    /* compiled from: VoiceControlViewModel.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/lifecycle/MutableLiveData;", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class z extends Lambda implements Function0<MutableLiveData<Float>> {
        public static final z a = new z();

        public z() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final MutableLiveData<Float> invoke() {
            return new MutableLiveData<>();
        }
    }

    public VoiceControlViewModel(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
        this.e = pc1.a;
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.k = 400L;
        this.m = y03.DEFAULT;
        this.n = true;
        this.o = true;
        this.s = new MutableLiveData<>();
        this.t = LazyKt__LazyJVMKt.lazy(m.a);
        this.u = new MutableLiveData<>();
        this.v = new MutableLiveData<>();
        this.w = new MutableLiveData<>();
        this.x = LazyKt__LazyJVMKt.lazy(y.a);
        this.y = LazyKt__LazyJVMKt.lazy(x.a);
        this.z = LazyKt__LazyJVMKt.lazy(w.a);
        this.A = LazyKt__LazyJVMKt.lazy(b.a);
        this.B = LazyKt__LazyJVMKt.lazy(z.a);
        this.C = new MutableLiveData<>();
        this.D = LazyKt__LazyJVMKt.lazy(p.a);
        this.E = LazyKt__LazyJVMKt.lazy(c.a);
        this.F = new MutableLiveData<>();
    }

    @NotNull
    public final MutableLiveData<Float> A() {
        return (MutableLiveData) this.E.getValue();
    }

    @NotNull
    public final MutableLiveData<w03> B() {
        return this.s;
    }

    public final int C(@Nullable w03 w03Var) {
        int i2 = w03Var == null ? -1 : a.b[w03Var.ordinal()];
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2) {
            return 2;
        }
        if (i2 != 3) {
            return i2 != 4 ? 0 : 4;
        }
        return 3;
    }

    @NotNull
    public final MutableLiveData<y03> D() {
        return (MutableLiveData) this.t.getValue();
    }

    @NotNull
    public final MutableLiveData<String> E() {
        return (MutableLiveData) this.D.getValue();
    }

    @NotNull
    public final MutableLiveData<Boolean> F() {
        return this.F;
    }

    @NotNull
    public final MutableLiveData<ScaleVolume> G() {
        return this.v;
    }

    /* renamed from: H, reason: from getter */
    public final boolean getN() {
        return this.n;
    }

    @NotNull
    public final MutableLiveData<String> I() {
        return this.u;
    }

    @NotNull
    public final MutableLiveData<String> J() {
        return this.w;
    }

    public final void K() {
        tn2.x(this.a).m("/api/voice_control/config", MessageFormatter.DELIM_STR, new f());
    }

    @NotNull
    public final MutableLiveData<VoiceModelData> L() {
        return (MutableLiveData) this.z.getValue();
    }

    public final void M() {
        HashMap map = new HashMap();
        map.put("platform", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
        String APP_VERSION = WearUtils.q;
        Intrinsics.checkNotNullExpressionValue(APP_VERSION, "APP_VERSION");
        map.put("version", APP_VERSION);
        map.put("lang", "en");
        String modelVersion = eg3.h(this.a, "modelVersion", "");
        Intrinsics.checkNotNullExpressionValue(modelVersion, "modelVersion");
        if (modelVersion.length() > 0) {
            map.put("voiceResourceId", modelVersion);
        }
        tn2.x(this.a).g("/voice_control/get_voice_resource", map, new g());
    }

    @NotNull
    public final MutableLiveData<VoskResult> N() {
        return (MutableLiveData) this.y.getValue();
    }

    @NotNull
    public final MutableLiveData<e13> O() {
        return (MutableLiveData) this.x.getValue();
    }

    @NotNull
    public final MutableLiveData<Float> P() {
        return (MutableLiveData) this.B.getValue();
    }

    public final void Q(@NotNull String result) {
        VoiceConfig voiceConfig;
        WavePatternConfig wavePatternConfig;
        VoiceConfig voiceConfig2;
        WavePatternConfig wavePatternConfig2;
        Intrinsics.checkNotNullParameter(result, "result");
        boolean zD = eg3.d(this.a, "newGuide", true);
        if (result.length() == 0) {
            return;
        }
        E().postValue(result);
        if (ArraysKt___ArraysKt.contains(new String[]{"stat", "star", TtmlNode.START}, result) && !this.p) {
            if (!a0()) {
                y03 y03Var = y03.WAVE;
                this.m = y03Var;
                D().setValue(y03Var);
            }
            if (zD && this.n) {
                if (this.s.getValue() == w03.STEP_01) {
                    f0();
                    uy3.d(ViewModelKt.getViewModelScope(this), null, null, new h(null), 3, null);
                    return;
                }
                return;
            }
            f0();
            if (!this.q) {
                y03 y03Var2 = y03.WAVE;
                this.m = y03Var2;
                D().setValue(y03Var2);
            }
            N().postValue(new VoskResult("Start", false));
            n0(TtmlNode.START, false);
            this.j = System.currentTimeMillis();
            O().postValue(e13.STATE_DONE);
            return;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"stop", "stall", "spawn", "spock"}, result) && this.p) {
            if (zD && this.n) {
                n0("stop", true);
                if (this.s.getValue() == w03.STEP_03) {
                    m0();
                    uy3.d(ViewModelKt.getViewModelScope(this), null, null, new i(null), 3, null);
                    return;
                }
                return;
            }
            m0();
            n0("stop", false);
            N().postValue(new VoskResult("Stop", false));
            this.j = System.currentTimeMillis();
            O().postValue(e13.STATE_DONE);
            return;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"faster", "fast her", "foster"}, result) && b0()) {
            y03 y03Var3 = this.m;
            if (y03Var3 == y03.DEFAULT) {
                long j2 = this.k;
                if (j2 >= 200) {
                    this.k = j2 - 100;
                    c0();
                    return;
                }
                return;
            }
            if (y03Var3 != y03.WAVE || (voiceConfig2 = this.f) == null || (wavePatternConfig2 = voiceConfig2.getWavePatternConfig()) == null || wavePatternConfig2.getB() > 5.0f) {
                return;
            }
            wavePatternConfig2.setB(wavePatternConfig2.getB() + 1);
            c0();
            return;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"slower", "so lower", "lower", "slow", "lola"}, result) && b0()) {
            y03 y03Var4 = this.m;
            if (y03Var4 == y03.DEFAULT) {
                long j3 = this.k;
                if (j3 <= 500) {
                    this.k = j3 + 100;
                    d0();
                    return;
                }
                return;
            }
            if (y03Var4 != y03.WAVE || (voiceConfig = this.f) == null || (wavePatternConfig = voiceConfig.getWavePatternConfig()) == null || wavePatternConfig.getB() < 2.0f) {
                return;
            }
            wavePatternConfig.setB(wavePatternConfig.getB() - 1);
            d0();
            return;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"he faught", "default", "the fart", "the it", "different", "the fought", "the default", "the fall", "if all"}, result) && b0()) {
            n0("default", false);
            y03 y03Var5 = y03.DEFAULT;
            this.m = y03Var5;
            this.q = true;
            D().setValue(y03Var5);
            this.k = 400L;
            g0();
            P().postValue(Float.valueOf(p()));
            N().postValue(new VoskResult("Default", false));
            this.j = System.currentTimeMillis();
            O().postValue(e13.STATE_DONE);
            return;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"wave", "wait", "way", "wage"}, result) && b0()) {
            n0("wave", false);
            K();
            this.q = true;
            y03 y03Var6 = y03.WAVE;
            this.m = y03Var6;
            D().setValue(y03Var6);
            N().postValue(new VoskResult("Wave", false));
            this.j = System.currentTimeMillis();
            O().postValue(e13.STATE_DONE);
            return;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"straight", "strike", "stretch it", "jet", "stretch", "jade", "trade", "changing"}, result) && b0()) {
            n0("straight", false);
            K();
            y03 y03Var7 = y03.STRAIGHT;
            this.m = y03Var7;
            D().setValue(y03Var7);
            this.k = 100L;
            this.q = true;
            g0();
            P().postValue(Float.valueOf(p()));
            N().postValue(new VoskResult("Straight", false));
            this.j = System.currentTimeMillis();
            O().postValue(e13.STATE_DONE);
            return;
        }
        if (b13.f(result) && b0()) {
            R(result);
            return;
        }
        if (b13.g(result) && b0()) {
            S(result);
            return;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"stronger"}, result) && b0()) {
            T();
            return;
        }
        if (ArraysKt___ArraysKt.contains(new String[]{"weaker", "waco", "week", "wake", "wake her", "we can", "we cat", "weekend"}, result) && b0()) {
            U();
            return;
        }
        if (TextUtils.equals("yes", result) && this.s.getValue() == w03.STEP_04 && zD && this.n) {
            this.j = System.currentTimeMillis();
            O().postValue(e13.STATE_DONE);
            N().postValue(new VoskResult("Yes", false));
            n0("yes", true);
            return;
        }
        if (TextUtils.equals("no", result) && this.s.getValue() == w03.STEP_04 && zD && this.n) {
            this.j = System.currentTimeMillis();
            O().postValue(e13.STATE_DONE);
            N().postValue(new VoskResult("No", true));
            n0("no", true);
            return;
        }
        if (Y(result)) {
            if (zD && this.n) {
                if (C(this.s.getValue()) > 2 && (this.s.getValue() != w03.STEP_04 || TextUtils.equals("yes", result) || TextUtils.equals("no", result))) {
                    this.w.postValue(result);
                }
            } else if (!ArraysKt___ArraysKt.contains(new String[]{"stat", "star", TtmlNode.START}, result)) {
                this.u.postValue("Say \"Start\" to begin your voice journey");
            }
        }
        String str = "未识别 onResult : " + result;
    }

    public final void R(String str) {
        VoiceConfig voiceConfig;
        WavePatternConfig wavePatternConfig;
        List listSplit$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null);
        if (listSplit$default.size() > 1) {
            int iH = b13.h((String) listSplit$default.get(1));
            if (iH >= 0 && iH < 6) {
                int i2 = a.a[this.m.ordinal()];
                if (i2 == 1) {
                    long j2 = this.k;
                    long j3 = 600 - (iH * 100);
                    if (j2 > j3) {
                        this.C.postValue(Boolean.FALSE);
                    } else if (j2 < j3) {
                        this.C.postValue(Boolean.TRUE);
                    }
                    this.k = 600 - (iH * 100);
                    g0();
                    P().postValue(Float.valueOf(p()));
                } else if (i2 == 3 && (voiceConfig = this.f) != null && (wavePatternConfig = voiceConfig.getWavePatternConfig()) != null) {
                    float f2 = iH + 1.0f;
                    if (wavePatternConfig.getB() > f2) {
                        this.C.postValue(Boolean.FALSE);
                    } else if (wavePatternConfig.getB() < f2) {
                        this.C.postValue(Boolean.TRUE);
                    }
                    wavePatternConfig.setB(f2);
                    g0();
                }
                N().postValue(new VoskResult("Speed " + iH, false));
                n0("speed " + iH, false);
                this.j = System.currentTimeMillis();
                O().postValue(e13.STATE_DONE);
            }
        }
    }

    public final void S(String str) {
        int iH;
        StraightPatternConfig straightPatternConfig;
        WavePatternConfig wavePatternConfig;
        List listSplit$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null);
        if (listSplit$default.size() <= 1 || (iH = b13.h((String) listSplit$default.get(1))) < 0) {
            return;
        }
        int i2 = a.a[this.m.ordinal()];
        if (i2 == 1) {
            this.v.postValue(new ScaleVolume("Strength", v(iH)));
        } else if (i2 == 2) {
            VoiceConfig voiceConfig = this.f;
            if (voiceConfig != null && (straightPatternConfig = voiceConfig.getStraightPatternConfig()) != null) {
                float a2 = iH;
                if (straightPatternConfig.getA() + a2 > 20.0f) {
                    a2 = 20 - straightPatternConfig.getA();
                }
                straightPatternConfig.setD(a2);
            }
            this.v.postValue(new ScaleVolume("Strength", iH));
        } else if (i2 == 3) {
            VoiceConfig voiceConfig2 = this.f;
            if (voiceConfig2 != null && (wavePatternConfig = voiceConfig2.getWavePatternConfig()) != null) {
                float a3 = iH;
                if (wavePatternConfig.getA() + a3 > 20.0f) {
                    a3 = 20 - wavePatternConfig.getA();
                }
                wavePatternConfig.setD(a3);
            }
            this.v.postValue(new ScaleVolume("Strength", iH));
        }
        this.F.postValue(Boolean.TRUE);
        N().postValue(new VoskResult("Strength " + iH, false));
        String str2 = "numberFormat : " + iH;
        n0("strength " + iH, false);
        this.j = System.currentTimeMillis();
        O().postValue(e13.STATE_DONE);
    }

    public final void T() throws NumberFormatException {
        int i2 = a.a[this.m.ordinal()];
        if (i2 == 1) {
            w();
        } else if (i2 == 2) {
            r(false);
        } else if (i2 == 3) {
            r(true);
        }
        N().postValue(new VoskResult("Stronger", false));
        this.j = System.currentTimeMillis();
        O().postValue(e13.STATE_DONE);
        this.F.postValue(Boolean.TRUE);
        n0("stronger", false);
    }

    public final void U() throws NumberFormatException {
        int i2 = a.a[this.m.ordinal()];
        if (i2 == 1) {
            x();
        } else if (i2 == 2) {
            t(false);
        } else if (i2 == 3) {
            t(true);
        }
        N().postValue(new VoskResult("Weaker", false));
        this.j = System.currentTimeMillis();
        O().postValue(e13.STATE_DONE);
        n0("weaker", false);
    }

    public final void V(@NotNull String modelPath) {
        Intrinsics.checkNotNullParameter(modelPath, "modelPath");
        try {
            this.d = new Model(modelPath);
            if (eg3.d(this.a, "newGuide", true)) {
                h0(true);
            } else {
                h0(false);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public final void W(boolean z2) {
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new j(null), 3, null);
    }

    public final void X() {
        uy3.d(ViewModelKt.getViewModelScope(this), null, null, new k(null), 3, null);
    }

    public final boolean Y(@NotNull String result) {
        Intrinsics.checkNotNullParameter(result, "result");
        return ArraysKt___ArraysKt.contains(new String[]{"wave", "wait", "way", "wage"}, result) || ArraysKt___ArraysKt.contains(new String[]{"he faught", "default", "the fart", "the it", "different", "the fought", "the default", "the fall", "if all"}, result) || ArraysKt___ArraysKt.contains(new String[]{"faster", "fast her", "foster"}, result) || ArraysKt___ArraysKt.contains(new String[]{"slower", "so lower", "lower", "slow", "lola"}, result) || b13.f(result) || b13.g(result) || ArraysKt___ArraysKt.contains(new String[]{"wave", "wait", "way", "wage"}, result) || ArraysKt___ArraysKt.contains(new String[]{"stronger"}, result) || ArraysKt___ArraysKt.contains(new String[]{"straight", "strike", "stretch it", "jet", "stretch", "jade", "trade", "changing"}, result) || ArraysKt___ArraysKt.contains(new String[]{"stop", "stall", "spawn", "spock"}, result) || ArraysKt___ArraysKt.contains(new String[]{"stat", "star", TtmlNode.START}, result) || TextUtils.equals(result, "yes") || TextUtils.equals(result, "no") || ArraysKt___ArraysKt.contains(new String[]{"weaker", "waco", "week", "wake", "wake her", "we can", "we cat", "weekend"}, result);
    }

    @NotNull
    public final MutableLiveData<Boolean> Z() {
        return this.C;
    }

    public final boolean a0() {
        Object systemService = this.a.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isAvailable();
        }
        return false;
    }

    public final boolean b0() {
        return this.p && !(eg3.d(this.a, "newGuide", true) && this.n);
    }

    public final void c0() {
        g0();
        this.C.postValue(Boolean.TRUE);
        P().postValue(Float.valueOf(p()));
        N().postValue(new VoskResult("Faster", false));
        this.j = System.currentTimeMillis();
        O().postValue(e13.STATE_DONE);
        n0("faster", false);
    }

    public final void d0() {
        g0();
        this.C.postValue(Boolean.FALSE);
        P().postValue(Float.valueOf(p()));
        N().postValue(new VoskResult("Slower", false));
        this.j = System.currentTimeMillis();
        O().postValue(e13.STATE_DONE);
        n0("slower", false);
    }

    public final Object e0(File file, Continuation<? super Unit> continuation) {
        return sy3.g(n04.b(), new l(file, this, null), continuation);
    }

    public final void f0() {
        n nVar = new n(rz3.H);
        this.p = true;
        O().setValue(e13.STATUS_PLAY);
        k0();
        uy3.d(ViewModelKt.getViewModelScope(this), nVar, null, new o(null), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g0() {
        /*
            r2 = this;
            dc.y03 r0 = r2.m
            int[] r1 = com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel.a.a
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto L34
            r1 = 2
            if (r0 == r1) goto L23
            r1 = 3
            if (r0 == r1) goto L14
            goto L32
        L14:
            com.wear.bean.data.VoiceConfig r0 = r2.f
            if (r0 == 0) goto L32
            com.wear.bean.data.WavePatternConfig r0 = r0.getWavePatternConfig()
            if (r0 == 0) goto L32
            float r0 = r0.getB()
            goto L3b
        L23:
            com.wear.bean.data.VoiceConfig r0 = r2.f
            if (r0 == 0) goto L32
            com.wear.bean.data.StraightPatternConfig r0 = r0.getStraightPatternConfig()
            if (r0 == 0) goto L32
            float r0 = r0.getB()
            goto L3b
        L32:
            r0 = 0
            goto L3b
        L34:
            long r0 = r2.k
            float r0 = (float) r0
            r1 = 1000(0x3e8, float:1.401E-42)
            float r1 = (float) r1
            float r0 = r0 / r1
        L3b:
            androidx.lifecycle.MutableLiveData r1 = r2.A()
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            r1.postValue(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel.g0():void");
    }

    public final void h0(boolean z2) {
        try {
            zf3 zf3Var = new zf3(new Recognizer(this.d, 16000.0f), 16000.0f);
            this.b = zf3Var;
            if (zf3Var != null) {
                zf3Var.g(this);
            }
            uy3.d(ViewModelKt.getViewModelScope(this), null, null, new q(z2, this, null), 3, null);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public final void i0(boolean z2) {
        this.o = z2;
    }

    public final void j0(boolean z2) {
        this.n = z2;
    }

    public final void k0() {
        this.c = l0(new r(), s.a);
    }

    public final h14 l0(Function1<? super VoiceControlCommand, Unit> function1, Function0<Unit> function0) {
        return v34.n(v34.p(v34.q(v34.m(v34.k(new t(null)), n04.c()), new u(function1, null)), new v(function0, null)), ViewModelKt.getViewModelScope(this));
    }

    public final void m0() {
        this.p = false;
        O().setValue(e13.STATUS_STOP);
        h14 h14Var = this.c;
        if (h14Var != null) {
            h14.a.a(h14Var, null, 1, null);
        }
        this.e.u0();
    }

    public final void n0(String str, boolean z2) {
        ku1.a("Voice Control", "voice_control_command_receive", "receive", "voice_control_command", EntityVideo.CHANGE_VOICE_MODEL_KEY, str, Integer.valueOf(z2 ? 1 : 2), null);
    }

    public final VoiceControlCommand o(int i2) {
        String function;
        if (this.h.size() <= 0) {
            return new VoiceControlCommand(true, 0, null, null, 12, null);
        }
        List<String> list = this.h;
        String str = list.get(i2 % list.size());
        PatternHead patternHead = this.g;
        List listSplit$default = (patternHead == null || (function = patternHead.getFunction()) == null) ? null : StringsKt__StringsKt.split$default((CharSequence) function, new String[]{","}, false, 0, 6, (Object) null);
        return (listSplit$default == null || listSplit$default.size() <= 1) ? new VoiceControlCommand(true, Integer.valueOf(Integer.parseInt(str)), null, null, 12, null) : new VoiceControlCommand(false, null, listSplit$default, StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null));
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        u();
    }

    @Override // org.vosk.android.RecognitionListener
    public void onError(@Nullable Exception exception) {
    }

    @Override // org.vosk.android.RecognitionListener
    public void onFinalResult(@Nullable String hypothesis) {
        String str = "onFinalResult " + hypothesis;
    }

    @Override // org.vosk.android.RecognitionListener
    public void onPartialResult(@Nullable String hypothesis) {
        if (System.currentTimeMillis() - this.j > 3000) {
            O().postValue(e13.STATE_MIC);
        }
    }

    @Override // org.vosk.android.RecognitionListener
    public void onResult(@Nullable String hypothesis) {
        if (this.o) {
            Object obj = JSON.parseObject(hypothesis).get("text");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            Q((String) obj);
        }
    }

    @Override // org.vosk.android.RecognitionListener
    public void onTimeout() {
    }

    public final float p() {
        long j2 = this.k;
        if (0 <= j2 && j2 < 101) {
            return 4.2f;
        }
        if (100 <= j2 && j2 < 201) {
            return 3.2f;
        }
        if (200 <= j2 && j2 < 301) {
            return 2.8f;
        }
        if (300 <= j2 && j2 < 401) {
            return 2.2f;
        }
        return 400 <= j2 && j2 < 501 ? 1.8f : 1.2f;
    }

    public final int q() {
        StraightPatternConfig straightPatternConfig;
        StraightPatternConfig straightPatternConfig2;
        StraightPatternConfig straightPatternConfig3;
        VoiceConfig voiceConfig = this.f;
        float b2 = 0.0f;
        float a2 = (voiceConfig == null || (straightPatternConfig3 = voiceConfig.getStraightPatternConfig()) == null) ? 0.0f : straightPatternConfig3.getA();
        VoiceConfig voiceConfig2 = this.f;
        if (voiceConfig2 != null && (straightPatternConfig2 = voiceConfig2.getStraightPatternConfig()) != null) {
            b2 = straightPatternConfig2.getB();
        }
        VoiceConfig voiceConfig3 = this.f;
        double dSin = (a2 * Math.sin(b2 * (this.l - 0.5235987755982988d))) + ((voiceConfig3 == null || (straightPatternConfig = voiceConfig3.getStraightPatternConfig()) == null) ? 2.0f : straightPatternConfig.getD());
        this.l += this.k;
        return MathKt__MathJVMKt.roundToInt(dSin);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void r(boolean r13) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel.r(boolean):void");
    }

    public final int s() {
        WavePatternConfig wavePatternConfig;
        WavePatternConfig wavePatternConfig2;
        WavePatternConfig wavePatternConfig3;
        VoiceConfig voiceConfig = this.f;
        float d2 = 2.0f;
        float a2 = (voiceConfig == null || (wavePatternConfig3 = voiceConfig.getWavePatternConfig()) == null) ? 2.0f : wavePatternConfig3.getA();
        VoiceConfig voiceConfig2 = this.f;
        float b2 = (voiceConfig2 == null || (wavePatternConfig2 = voiceConfig2.getWavePatternConfig()) == null) ? 1.0f : wavePatternConfig2.getB();
        VoiceConfig voiceConfig3 = this.f;
        if (voiceConfig3 != null && (wavePatternConfig = voiceConfig3.getWavePatternConfig()) != null) {
            d2 = wavePatternConfig.getD();
        }
        double dSin = (a2 * Math.sin(b2 * (this.l - 0.5235987755982988d))) + d2;
        this.l += this.k;
        return MathKt__MathJVMKt.roundToInt(dSin);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void t(boolean r12) {
        /*
            Method dump skipped, instructions count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wear.ui.discover.voicecontrol.viewmodel.VoiceControlViewModel.t(boolean):void");
    }

    public final void u() {
        this.p = false;
        zf3 zf3Var = this.b;
        if (zf3Var != null) {
            zf3Var.h();
        }
        zf3 zf3Var2 = this.b;
        if (zf3Var2 != null) {
            zf3Var2.f();
        }
        z().setValue(null);
        m0();
    }

    public final int v(int i2) throws NumberFormatException {
        List listSplit$default;
        String strValueOf;
        String function;
        float f2 = (i2 / 20.0f) + 1.0f;
        int iRoundToInt = 0;
        int i3 = 0;
        for (Object obj : this.i) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            PatternHead patternHead = this.g;
            if (patternHead == null || (function = patternHead.getFunction()) == null) {
                listSplit$default = null;
            } else {
                Intrinsics.checkNotNullExpressionValue(function, "function");
                listSplit$default = StringsKt__StringsKt.split$default((CharSequence) function, new String[]{","}, false, 0, 6, (Object) null);
            }
            String strValueOf2 = "20";
            int iRoundToInt2 = 20;
            if (listSplit$default == null || listSplit$default.size() <= 1) {
                int i5 = Integer.parseInt(str);
                List<String> list = this.h;
                float f3 = i5 * f2;
                if (f3 <= 20.0f) {
                    iRoundToInt2 = MathKt__MathJVMKt.roundToInt(f3);
                    strValueOf2 = String.valueOf(iRoundToInt2);
                }
                list.set(i3, strValueOf2);
                iRoundToInt = iRoundToInt2;
            } else {
                List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null));
                int size = mutableList.size();
                for (int i6 = 0; i6 < size; i6++) {
                    float f4 = Integer.parseInt((String) mutableList.get(i6)) * f2;
                    if (f4 > 20.0f) {
                        strValueOf = "20";
                        iRoundToInt = 20;
                    } else {
                        iRoundToInt = MathKt__MathJVMKt.roundToInt(f4);
                        strValueOf = String.valueOf(iRoundToInt);
                    }
                    mutableList.set(i6, strValueOf);
                }
            }
            i3 = i4;
        }
        return iRoundToInt;
    }

    public final void w() throws NumberFormatException {
        List listSplit$default;
        String function;
        int i2 = this.r + 2;
        int iNextInt = this.r + (i2 >= 0 && i2 < 5 ? Random.INSTANCE.nextInt(2) + 2 : 5 <= i2 && i2 < 10 ? Random.INSTANCE.nextInt(1) + 1 : 0) + 2;
        this.r = iNextInt;
        float f2 = (iNextInt / 20.0f) + 1;
        int i3 = 0;
        for (Object obj : this.h) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            PatternHead patternHead = this.g;
            if (patternHead == null || (function = patternHead.getFunction()) == null) {
                listSplit$default = null;
            } else {
                Intrinsics.checkNotNullExpressionValue(function, "function");
                listSplit$default = StringsKt__StringsKt.split$default((CharSequence) function, new String[]{","}, false, 0, 6, (Object) null);
            }
            if (listSplit$default == null || listSplit$default.size() <= 1) {
                int i5 = Integer.parseInt(str);
                int iMin = Math.min(20, MathKt__MathJVMKt.roundToInt(i5 * f2));
                if (i3 == 0) {
                    this.v.postValue(new ScaleVolume("Stronger", iMin - i5));
                }
                this.h.set(i3, String.valueOf(iMin));
            } else {
                List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null));
                int size = mutableList.size();
                for (int i6 = 0; i6 < size; i6++) {
                    int i7 = Integer.parseInt((String) mutableList.get(i6));
                    int iMin2 = Math.min(20, MathKt__MathJVMKt.roundToInt(i7 * f2));
                    if (i3 == 0) {
                        this.v.postValue(new ScaleVolume("Stronger", iMin2 - i7));
                    }
                    mutableList.set(i6, String.valueOf(iMin2));
                }
            }
            i3 = i4;
        }
    }

    public final void x() throws NumberFormatException {
        List listSplit$default;
        String function;
        if (this.r > 20) {
            this.r = 20;
        }
        int i2 = this.r - 2;
        int iNextInt = (this.r - 2) - (15 <= i2 && i2 < 20 ? Random.INSTANCE.nextInt(2) + 2 : 10 <= i2 && i2 < 15 ? Random.INSTANCE.nextInt(1) + 1 : 0);
        this.r = iNextInt;
        float f2 = iNextInt / 20.0f;
        if (f2 < 0.1f) {
            this.v.postValue(new ScaleVolume("Weaker", 0));
            return;
        }
        int i3 = 0;
        for (Object obj : this.h) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            PatternHead patternHead = this.g;
            if (patternHead == null || (function = patternHead.getFunction()) == null) {
                listSplit$default = null;
            } else {
                Intrinsics.checkNotNullExpressionValue(function, "function");
                listSplit$default = StringsKt__StringsKt.split$default((CharSequence) function, new String[]{","}, false, 0, 6, (Object) null);
            }
            if (listSplit$default == null || listSplit$default.size() <= 1) {
                int i5 = Integer.parseInt(str);
                int iCoerceAtLeast = RangesKt___RangesKt.coerceAtLeast(1, MathKt__MathJVMKt.roundToInt(i5 * f2));
                if (i3 == 0) {
                    this.v.postValue(new ScaleVolume("Weaker", iCoerceAtLeast - i5));
                }
                this.h.set(i3, String.valueOf(iCoerceAtLeast));
            } else {
                List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null));
                int size = mutableList.size();
                for (int i6 = 0; i6 < size; i6++) {
                    int i7 = Integer.parseInt((String) mutableList.get(i6));
                    int iCoerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(1, MathKt__MathJVMKt.roundToInt(i7 * f2));
                    if (i3 == 0) {
                        this.v.postValue(new ScaleVolume("Weaker", iCoerceAtLeast2 - i7));
                    }
                    mutableList.set(i6, String.valueOf(iCoerceAtLeast2));
                }
            }
            i3 = i4;
        }
    }

    public final void y(@NotNull String url, @NotNull String modelName) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(modelName, "modelName");
        uy3.d(ViewModelKt.getViewModelScope(this), new d(rz3.H, this, modelName), null, new e(url, modelName, null), 2, null);
    }

    @NotNull
    public final MutableLiveData<VoiceControlCommand> z() {
        return (MutableLiveData) this.A.getValue();
    }
}

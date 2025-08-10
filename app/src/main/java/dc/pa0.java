package dc;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;

/* compiled from: ToyCommandFunctionConstant.kt */
@Metadata(d1 = {"\u0000\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0003\b÷\u0001\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R\u001b\u0010\f\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\b\u001a\u0004\b\r\u0010\u0006R\u001b\u0010\u000f\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\b\u001a\u0004\b\u0010\u0010\u0006R\u001b\u0010\u0012\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\b\u001a\u0004\b\u0013\u0010\u0006R\u001b\u0010\u0015\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0016\u0010\u0006R\u001b\u0010\u0018\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\b\u001a\u0004\b\u0019\u0010\u0006R\u001b\u0010\u001b\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\b\u001a\u0004\b\u001c\u0010\u0006R\u001b\u0010\u001e\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\b\u001a\u0004\b\u001f\u0010\u0006R\u001b\u0010!\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\b\u001a\u0004\b\"\u0010\u0006R\u001b\u0010$\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\b\u001a\u0004\b%\u0010\u0006R\u001b\u0010'\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\b\u001a\u0004\b(\u0010\u0006R\u001b\u0010*\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\b\u001a\u0004\b+\u0010\u0006R\u001b\u0010-\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\b\u001a\u0004\b.\u0010\u0006R\u001b\u00100\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\b\u001a\u0004\b1\u0010\u0006R\u001b\u00103\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\b\u001a\u0004\b4\u0010\u0006R\u001b\u00106\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\b\u001a\u0004\b7\u0010\u0006R\u001b\u00109\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u0010\b\u001a\u0004\b:\u0010\u0006R\u001b\u0010<\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b>\u0010\b\u001a\u0004\b=\u0010\u0006R\u001b\u0010?\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bA\u0010\b\u001a\u0004\b@\u0010\u0006R\u001b\u0010B\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bD\u0010\b\u001a\u0004\bC\u0010\u0006R\u001b\u0010E\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bG\u0010\b\u001a\u0004\bF\u0010\u0006R\u001b\u0010H\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\b\u001a\u0004\bI\u0010\u0006R\u001b\u0010K\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010\b\u001a\u0004\bL\u0010\u0006R\u001b\u0010N\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bP\u0010\b\u001a\u0004\bO\u0010\u0006R\u001b\u0010Q\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bS\u0010\b\u001a\u0004\bR\u0010\u0006R\u001b\u0010T\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bV\u0010\b\u001a\u0004\bU\u0010\u0006R\u001b\u0010W\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bY\u0010\b\u001a\u0004\bX\u0010\u0006R\u001b\u0010Z\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010\b\u001a\u0004\b[\u0010\u0006R\u001b\u0010]\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b_\u0010\b\u001a\u0004\b^\u0010\u0006R\u001b\u0010`\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bb\u0010\b\u001a\u0004\ba\u0010\u0006R\u001b\u0010c\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\be\u0010\b\u001a\u0004\bd\u0010\u0006R\u001b\u0010f\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bh\u0010\b\u001a\u0004\bg\u0010\u0006R\u001b\u0010i\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bk\u0010\b\u001a\u0004\bj\u0010\u0006R\u001b\u0010l\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bn\u0010\b\u001a\u0004\bm\u0010\u0006R\u001b\u0010o\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bq\u0010\b\u001a\u0004\bp\u0010\u0006R\u001b\u0010r\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bt\u0010\b\u001a\u0004\bs\u0010\u0006R\u001b\u0010u\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bw\u0010\b\u001a\u0004\bv\u0010\u0006R\u001b\u0010x\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\by\u0010\b\u001a\u0004\bQ\u0010\u0006R\u001b\u0010z\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b|\u0010\b\u001a\u0004\b{\u0010\u0006R\u001b\u0010}\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u007f\u0010\b\u001a\u0004\b~\u0010\u0006R\u001e\u0010\u0080\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010\b\u001a\u0005\b\u0081\u0001\u0010\u0006R\u001e\u0010\u0083\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0085\u0001\u0010\b\u001a\u0005\b\u0084\u0001\u0010\u0006R\u001e\u0010\u0086\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0088\u0001\u0010\b\u001a\u0005\b\u0087\u0001\u0010\u0006R\u001e\u0010\u0089\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008b\u0001\u0010\b\u001a\u0005\b\u008a\u0001\u0010\u0006R\u001e\u0010\u008c\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u008e\u0001\u0010\b\u001a\u0005\b\u008d\u0001\u0010\u0006R\u001e\u0010\u008f\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0091\u0001\u0010\b\u001a\u0005\b\u0090\u0001\u0010\u0006R\u001e\u0010\u0092\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0094\u0001\u0010\b\u001a\u0005\b\u0093\u0001\u0010\u0006R\u001e\u0010\u0095\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0097\u0001\u0010\b\u001a\u0005\b\u0096\u0001\u0010\u0006R\u001e\u0010\u0098\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u009a\u0001\u0010\b\u001a\u0005\b\u0099\u0001\u0010\u0006R\u001e\u0010\u009b\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u009d\u0001\u0010\b\u001a\u0005\b\u009c\u0001\u0010\u0006R\u001e\u0010\u009e\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b \u0001\u0010\b\u001a\u0005\b\u009f\u0001\u0010\u0006R\u001e\u0010¡\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b£\u0001\u0010\b\u001a\u0005\b¢\u0001\u0010\u0006R\u001e\u0010¤\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¦\u0001\u0010\b\u001a\u0005\b¥\u0001\u0010\u0006R\u001e\u0010§\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b©\u0001\u0010\b\u001a\u0005\b¨\u0001\u0010\u0006R\u001e\u0010ª\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¬\u0001\u0010\b\u001a\u0005\b«\u0001\u0010\u0006R\u001e\u0010\u00ad\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¯\u0001\u0010\b\u001a\u0005\b®\u0001\u0010\u0006R\u001e\u0010°\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b²\u0001\u0010\b\u001a\u0005\b±\u0001\u0010\u0006R\u001e\u0010³\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bµ\u0001\u0010\b\u001a\u0005\b´\u0001\u0010\u0006R\u001e\u0010¶\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¸\u0001\u0010\b\u001a\u0005\b·\u0001\u0010\u0006R\u001e\u0010¹\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b»\u0001\u0010\b\u001a\u0005\bº\u0001\u0010\u0006R\u001e\u0010¼\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b¾\u0001\u0010\b\u001a\u0005\b½\u0001\u0010\u0006R\u001e\u0010¿\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÁ\u0001\u0010\b\u001a\u0005\bÀ\u0001\u0010\u0006R\u001e\u0010Â\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÄ\u0001\u0010\b\u001a\u0005\bÃ\u0001\u0010\u0006R\u001e\u0010Å\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÇ\u0001\u0010\b\u001a\u0005\bÆ\u0001\u0010\u0006R\u001e\u0010È\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÊ\u0001\u0010\b\u001a\u0005\bÉ\u0001\u0010\u0006R\u001e\u0010Ë\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÍ\u0001\u0010\b\u001a\u0005\bÌ\u0001\u0010\u0006R\u001e\u0010Î\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÐ\u0001\u0010\b\u001a\u0005\bÏ\u0001\u0010\u0006R\u001e\u0010Ñ\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÓ\u0001\u0010\b\u001a\u0005\bÒ\u0001\u0010\u0006R\u001e\u0010Ô\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÖ\u0001\u0010\b\u001a\u0005\bÕ\u0001\u0010\u0006R\u001e\u0010×\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÙ\u0001\u0010\b\u001a\u0005\bØ\u0001\u0010\u0006R\u001e\u0010Ú\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bÜ\u0001\u0010\b\u001a\u0005\bÛ\u0001\u0010\u0006R\u001e\u0010Ý\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bß\u0001\u0010\b\u001a\u0005\bÞ\u0001\u0010\u0006R\u001e\u0010à\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bâ\u0001\u0010\b\u001a\u0005\bá\u0001\u0010\u0006R\u001e\u0010ã\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bå\u0001\u0010\b\u001a\u0005\bä\u0001\u0010\u0006R\u001e\u0010æ\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bè\u0001\u0010\b\u001a\u0005\bç\u0001\u0010\u0006R\u001e\u0010é\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bë\u0001\u0010\b\u001a\u0005\bê\u0001\u0010\u0006R\u001e\u0010ì\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bî\u0001\u0010\b\u001a\u0005\bí\u0001\u0010\u0006R\u001e\u0010ï\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bñ\u0001\u0010\b\u001a\u0005\bð\u0001\u0010\u0006R\u001e\u0010ò\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bô\u0001\u0010\b\u001a\u0005\bó\u0001\u0010\u0006R\u001e\u0010õ\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b÷\u0001\u0010\b\u001a\u0005\bö\u0001\u0010\u0006R\u001e\u0010ø\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\bú\u0001\u0010\b\u001a\u0005\bù\u0001\u0010\u0006¨\u0006û\u0001"}, d2 = {"Lcom/component/dxtoy/core/commandcore/constant/ToyCommandFunctionConstant;", "", "()V", "AA", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "getAA", "()Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "AA$delegate", "Lkotlin/Lazy;", "AP", "getAP", "AP$delegate", "DFU", "getDFU", "DFU$delegate", "ai", "getAi", "ai$delegate", "aiw", "getAiw", "aiw$delegate", "autoSwith", "getAutoSwith", "autoSwith$delegate", "battery", "getBattery", "battery$delegate", "bm", "getBm", "bm$delegate", "changeName", "getChangeName", "changeName$delegate", "collect", "getCollect", "collect$delegate", "deviceInfo", "getDeviceInfo", "deviceInfo$delegate", "deviceType", "getDeviceType", "deviceType$delegate", XHTMLText.EM, "getEm", "em$delegate", "exeM2", "getExeM2", "exeM2$delegate", "flash", "getFlash", "flash$delegate", "getAColor", "getGetAColor", "getAColor$delegate", "getAS", "getGetAS", "getAS$delegate", "getAlight", "getGetAlight", "getAlight$delegate", "getBatch", "getGetBatch", "getBatch$delegate", "getBms", "getGetBms", "getBms$delegate", "getClock", "getGetClock", "getClock$delegate", "getClocks", "getGetClocks", "getClocks$delegate", "getColor", "getGetColor", "getColor$delegate", "getDly", "getGetDly", "getDly$delegate", "getExecutingClock", "getGetExecutingClock", "getExecutingClock$delegate", "getLevel", "getGetLevel", "getLevel$delegate", "getLight", "getGetLight", "getLight$delegate", "getM2", "getGetM2", "getM2$delegate", "getMode", "getGetMode", "getMode$delegate", "getPatten", "getGetPatten", "getPatten$delegate", "getPattenList", "getGetPattenList", "getPattenList$delegate", "getPinC", "getGetPinC", "getPinC$delegate", "getPinS", "getGetPinS", "getPinS$delegate", "getSnrS", "getGetSnrS", "getSnrS$delegate", "getTempC", "getGetTempC", "getTempC$delegate", "getThreshold", "getGetThreshold", "getThreshold$delegate", "getTx", "getGetTx", "getTx$delegate", "getXmachineState", "getGetXmachineState", "getXmachineState$delegate", FirebaseAnalytics.Param.LEVEL, "level$delegate", "patternClear", "getPatternClear", "patternClear$delegate", "plName", "getPlName", "plName$delegate", "powerOff", "getPowerOff", "powerOff$delegate", "preset", "getPreset", "preset$delegate", "psName", "getPsName", "psName$delegate", "rdCtlPan", "getRdCtlPan", "rdCtlPan$delegate", "rdSolo", "getRdSolo", "rdSolo$delegate", "rdTchLvl", "getRdTchLvl", "rdTchLvl$delegate", "removeAllClock", "getRemoveAllClock", "removeAllClock$delegate", "removeClock", "getRemoveClock", "removeClock$delegate", "removePatten", "getRemovePatten", "removePatten$delegate", "resetName", "getResetName", "resetName$delegate", "setAColor", "getSetAColor", "setAColor$delegate", "setALight", "getSetALight", "setALight$delegate", "setBms", "getSetBms", "setBms$delegate", "setBt", "getSetBt", "setBt$delegate", "setClock", "getSetClock", "setClock$delegate", "setColor", "getSetColor", "setColor$delegate", "setCtlPan", "getSetCtlPan", "setCtlPan$delegate", "setDly", "getSetDly", "setDly$delegate", "setGsensor", "getSetGsensor", "setGsensor$delegate", "setGser", "getSetGser", "setGser$delegate", "setHeat", "getSetHeat", "setHeat$delegate", "setLevel", "getSetLevel", "setLevel$delegate", "setLight", "getSetLight", "setLight$delegate", "setM2", "getSetM2", "setM2$delegate", "setMirr", "getSetMirr", "setMirr$delegate", "setNotify", "getSetNotify", "setNotify$delegate", "setPinC", "getSetPinC", "setPinC$delegate", "setPinCode", "getSetPinCode", "setPinCode$delegate", "setPinS", "getSetPinS", "setPinS$delegate", "setPinStatus", "getSetPinStatus", "setPinStatus$delegate", "setSolo", "getSetSolo", "setSolo$delegate", "setTchLvl", "getSetTchLvl", "setTchLvl$delegate", "setThreshold", "getSetThreshold", "setThreshold$delegate", "setTmp", "getSetTmp", "setTmp$delegate", "setTx", "getSetTx", "setTx$delegate", "spaceAll", "getSpaceAll", "spaceAll$delegate", "spaceClear", "getSpaceClear", "spaceClear$delegate", "spaceFree", "getSpaceFree", "spaceFree$delegate", "startMove", "getStartMove", "startMove$delegate", "stopMove", "getStopMove", "stopMove$delegate", "xmachineLdrSingle", "getXmachineLdrSingle", "xmachineLdrSingle$delegate", "core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class pa0 {

    @NotNull
    public static final pa0 a = new pa0();

    @NotNull
    public static final Lazy b = LazyKt__LazyJVMKt.lazy(l.a);

    @NotNull
    public static final Lazy c = LazyKt__LazyJVMKt.lazy(k.a);

    @NotNull
    public static final Lazy d = LazyKt__LazyJVMKt.lazy(g.a);

    @NotNull
    public static final Lazy e = LazyKt__LazyJVMKt.lazy(s.a);

    @NotNull
    public static final Lazy f = LazyKt__LazyJVMKt.lazy(l1.a);

    @NotNull
    public static final Lazy g = LazyKt__LazyJVMKt.lazy(a0.a);

    @NotNull
    public static final Lazy h = LazyKt__LazyJVMKt.lazy(o.a);

    @NotNull
    public static final Lazy i = LazyKt__LazyJVMKt.lazy(r.a);

    @NotNull
    public static final Lazy j = LazyKt__LazyJVMKt.lazy(a1.a);

    @NotNull
    public static final Lazy k = LazyKt__LazyJVMKt.lazy(i.a);

    @NotNull
    public static final Lazy l = LazyKt__LazyJVMKt.lazy(y0.a);

    @NotNull
    public static final Lazy m = LazyKt__LazyJVMKt.lazy(f.a);

    @NotNull
    public static final Lazy n = LazyKt__LazyJVMKt.lazy(q.a);

    @NotNull
    public static final Lazy o = LazyKt__LazyJVMKt.lazy(u.a);

    @NotNull
    public static final Lazy p = LazyKt__LazyJVMKt.lazy(y.a);

    @NotNull
    public static final Lazy q = LazyKt__LazyJVMKt.lazy(v0.a);

    @NotNull
    public static final Lazy r = LazyKt__LazyJVMKt.lazy(w0.a);

    @NotNull
    public static final Lazy s = LazyKt__LazyJVMKt.lazy(v.a);

    @NotNull
    public static final Lazy t = LazyKt__LazyJVMKt.lazy(d1.a);

    @NotNull
    public static final Lazy u = LazyKt__LazyJVMKt.lazy(d.a);

    @NotNull
    public static final Lazy v = LazyKt__LazyJVMKt.lazy(e.a);

    @NotNull
    public static final Lazy w = LazyKt__LazyJVMKt.lazy(r0.a);

    @NotNull
    public static final Lazy x = LazyKt__LazyJVMKt.lazy(o0.a);

    @NotNull
    public static final Lazy y = LazyKt__LazyJVMKt.lazy(y1.a);

    @NotNull
    public static final Lazy z = LazyKt__LazyJVMKt.lazy(a2.a);

    @NotNull
    public static final Lazy A = LazyKt__LazyJVMKt.lazy(z1.a);

    @NotNull
    public static final Lazy B = LazyKt__LazyJVMKt.lazy(x0.a);

    @NotNull
    public static final Lazy C = LazyKt__LazyJVMKt.lazy(d0.a);

    @NotNull
    public static final Lazy D = LazyKt__LazyJVMKt.lazy(e0.a);

    @NotNull
    public static final Lazy E = LazyKt__LazyJVMKt.lazy(n0.a);

    @NotNull
    public static final Lazy F = LazyKt__LazyJVMKt.lazy(q0.a);

    @NotNull
    public static final Lazy G = LazyKt__LazyJVMKt.lazy(f0.a);

    @NotNull
    public static final Lazy H = LazyKt__LazyJVMKt.lazy(p1.a);

    @NotNull
    public static final Lazy I = LazyKt__LazyJVMKt.lazy(q1.a);

    @NotNull
    public static final Lazy J = LazyKt__LazyJVMKt.lazy(g0.a);

    @NotNull
    public static final Lazy K = LazyKt__LazyJVMKt.lazy(r1.a);

    @NotNull
    public static final Lazy L = LazyKt__LazyJVMKt.lazy(s1.a);

    @NotNull
    public static final Lazy M = LazyKt__LazyJVMKt.lazy(m0.a);

    @NotNull
    public static final Lazy N = LazyKt__LazyJVMKt.lazy(k1.a);

    @NotNull
    public static final Lazy O = LazyKt__LazyJVMKt.lazy(z.a);

    @NotNull
    public static final Lazy P = LazyKt__LazyJVMKt.lazy(m1.a);

    @NotNull
    public static final Lazy Q = LazyKt__LazyJVMKt.lazy(b0.a);

    @NotNull
    public static final Lazy R = LazyKt__LazyJVMKt.lazy(n.a);

    @NotNull
    public static final Lazy S = LazyKt__LazyJVMKt.lazy(b1.a);

    @NotNull
    public static final Lazy T = LazyKt__LazyJVMKt.lazy(t.a);

    @NotNull
    public static final Lazy U = LazyKt__LazyJVMKt.lazy(h.a);

    @NotNull
    public static final Lazy V = LazyKt__LazyJVMKt.lazy(m.a);

    @NotNull
    public static final Lazy W = LazyKt__LazyJVMKt.lazy(h0.a);

    @NotNull
    public static final Lazy X = LazyKt__LazyJVMKt.lazy(c1.a);

    @NotNull
    public static final Lazy Y = LazyKt__LazyJVMKt.lazy(n1.a);

    @NotNull
    public static final Lazy Z = LazyKt__LazyJVMKt.lazy(i0.a);

    @NotNull
    public static final Lazy a0 = LazyKt__LazyJVMKt.lazy(w1.a);

    @NotNull
    public static final Lazy b0 = LazyKt__LazyJVMKt.lazy(j1.a);

    @NotNull
    public static final Lazy c0 = LazyKt__LazyJVMKt.lazy(u1.a);

    @NotNull
    public static final Lazy d0 = LazyKt__LazyJVMKt.lazy(u0.a);

    @NotNull
    public static final Lazy e0 = LazyKt__LazyJVMKt.lazy(t1.a);

    @NotNull
    public static final Lazy f0 = LazyKt__LazyJVMKt.lazy(t0.a);

    @NotNull
    public static final Lazy g0 = LazyKt__LazyJVMKt.lazy(f1.a);

    @NotNull
    public static final Lazy h0 = LazyKt__LazyJVMKt.lazy(s0.a);

    @NotNull
    public static final Lazy i0 = LazyKt__LazyJVMKt.lazy(x1.a);

    @NotNull
    public static final Lazy j0 = LazyKt__LazyJVMKt.lazy(k0.a);

    @NotNull
    public static final Lazy k0 = LazyKt__LazyJVMKt.lazy(p0.a);

    @NotNull
    public static final Lazy l0 = LazyKt__LazyJVMKt.lazy(c.a);

    @NotNull
    public static final Lazy m0 = LazyKt__LazyJVMKt.lazy(o1.a);

    @NotNull
    public static final Lazy n0 = LazyKt__LazyJVMKt.lazy(i1.a);

    @NotNull
    public static final Lazy o0 = LazyKt__LazyJVMKt.lazy(b2.a);

    @NotNull
    public static final Lazy p0 = LazyKt__LazyJVMKt.lazy(c2.a);

    @NotNull
    public static final Lazy q0 = LazyKt__LazyJVMKt.lazy(h1.a);

    @NotNull
    public static final Lazy r0 = LazyKt__LazyJVMKt.lazy(z0.a);

    @NotNull
    public static final Lazy s0 = LazyKt__LazyJVMKt.lazy(p.a);

    @NotNull
    public static final Lazy t0 = LazyKt__LazyJVMKt.lazy(e1.a);

    @NotNull
    public static final Lazy u0 = LazyKt__LazyJVMKt.lazy(w.a);

    @NotNull
    public static final Lazy v0 = LazyKt__LazyJVMKt.lazy(c0.a);

    @NotNull
    public static final Lazy w0 = LazyKt__LazyJVMKt.lazy(v1.a);

    @NotNull
    public static final Lazy x0 = LazyKt__LazyJVMKt.lazy(j0.a);

    @NotNull
    public static final Lazy y0 = LazyKt__LazyJVMKt.lazy(d2.a);

    @NotNull
    public static final Lazy z0 = LazyKt__LazyJVMKt.lazy(l0.a);

    @NotNull
    public static final Lazy A0 = LazyKt__LazyJVMKt.lazy(x.a);

    @NotNull
    public static final Lazy B0 = LazyKt__LazyJVMKt.lazy(g1.a);

    @NotNull
    public static final Lazy C0 = LazyKt__LazyJVMKt.lazy(b.a);

    @NotNull
    public static final Lazy D0 = LazyKt__LazyJVMKt.lazy(a.a);

    @NotNull
    public static final Lazy E0 = LazyKt__LazyJVMKt.lazy(j.a);

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<la0> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("AA", null, "AA%s", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a0 extends Lambda implements Function0<la0> {
        public static final a0 a = new a0();

        public a0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("GetLight;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a1 extends Lambda implements Function0<la0> {
        public static final a1 a = new a1();

        public a1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("ALight", null, "ALight:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a2 extends Lambda implements Function0<la0> {
        public static final a2 a = new a2();

        public a2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Space:Free;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<la0> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("AP", null, "AP%s", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b0 extends Lambda implements Function0<la0> {
        public static final b0 a = new b0();

        public b0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("GetM2;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b1 extends Lambda implements Function0<la0> {
        public static final b1 a = new b1();

        public b1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("BMS", null, "BMS:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b2 extends Lambda implements Function0<la0> {
        public static final b2 a = new b2();

        public b2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("StartMove", null, "StartMove:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c extends Lambda implements Function0<la0> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("DFU;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c0 extends Lambda implements Function0<la0> {
        public static final c0 a = new c0();

        public c0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("GetMode;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c1 extends Lambda implements Function0<la0> {
        public static final c1 a = new c1();

        public c1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("BT", null, "BT:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c2 extends Lambda implements Function0<la0> {
        public static final c2 a = new c2();

        public c2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("StopMove;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d extends Lambda implements Function0<la0> {
        public static final d a = new d();

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("AI;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d0 extends Lambda implements Function0<la0> {
        public static final d0 a = new d0();

        public d0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("GetPatten", null, "GetPatten:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d1 extends Lambda implements Function0<la0> {
        public static final d1 a = new d1();

        public d1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("AW", null, "AW:%s:%s:%s:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d2 extends Lambda implements Function0<la0> {
        public static final d2 a = new d2();

        public d2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("SGM;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e extends Lambda implements Function0<la0> {
        public static final e a = new e();

        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("AIW", null, "AIW:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e0 extends Lambda implements Function0<la0> {
        public static final e0 a = new e0();

        public e0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("GetPatten;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class e1 extends Lambda implements Function0<la0> {
        public static final e1 a = new e1();

        public e1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("SetColor", null, "SetColor:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f extends Lambda implements Function0<la0> {
        public static final f a = new f();

        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("AutoSwith", null, "AutoSwith:%s:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f0 extends Lambda implements Function0<la0> {
        public static final f0 a = new f0();

        public f0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("GetPinC;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class f1 extends Lambda implements Function0<la0> {
        public static final f1 a = new f1();

        public f1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("SetCtlPan", null, "SetCtlPan:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g extends Lambda implements Function0<la0> {
        public static final g a = new g();

        public g() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Battery;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g0 extends Lambda implements Function0<la0> {
        public static final g0 a = new g0();

        public g0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("GetPinS;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class g1 extends Lambda implements Function0<la0> {
        public static final g1 a = new g1();

        public g1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("setdly", null, "setdly:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class h extends Lambda implements Function0<la0> {
        public static final h a = new h();

        public h() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("BM;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class h0 extends Lambda implements Function0<la0> {
        public static final h0 a = new h0();

        public h0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("GetSnrS;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class h1 extends Lambda implements Function0<la0> {
        public static final h1 a = new h1();

        public h1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Gsensor", null, "Gsensor:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i extends Lambda implements Function0<la0> {
        public static final i a = new i();

        public i() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("CN", null, "CN:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i0 extends Lambda implements Function0<la0> {
        public static final i0 a = new i0();

        public i0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("GetTempC;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class i1 extends Lambda implements Function0<la0> {
        public static final i1 a = new i1();

        public i1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Gser", null, "Gser:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class j extends Lambda implements Function0<la0> {
        public static final j a = new j();

        public j() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Collect", null, "Collect:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class j0 extends Lambda implements Function0<la0> {
        public static final j0 a = new j0();

        public j0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("GetBkV", null, "GetBkV:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class j1 extends Lambda implements Function0<la0> {
        public static final j1 a = new j1();

        public j1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Heat", null, "Heat:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class k extends Lambda implements Function0<la0> {
        public static final k a = new k();

        public k() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("DeviceInfo;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class k0 extends Lambda implements Function0<la0> {
        public static final k0 a = new k0();

        public k0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("GetTx;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class k1 extends Lambda implements Function0<la0> {
        public static final k1 a = new k1();

        public k1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("SetLevel", null, "SetLevel:%s:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class l extends Lambda implements Function0<la0> {
        public static final l a = new l();

        public l() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("DeviceType;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class l0 extends Lambda implements Function0<la0> {
        public static final l0 a = new l0();

        public l0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("GetRBut;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class l1 extends Lambda implements Function0<la0> {
        public static final l1 a = new l1();

        public l1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Light", null, "Light:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class m extends Lambda implements Function0<la0> {
        public static final m a = new m();

        public m() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("EM;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class m0 extends Lambda implements Function0<la0> {
        public static final m0 a = new m0();

        public m0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Level", null, "Level:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class m1 extends Lambda implements Function0<la0> {
        public static final m1 a = new m1();

        public m1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("SetM2", null, "SetM2:%s:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class n extends Lambda implements Function0<la0> {
        public static final n a = new n();

        public n() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("ExeM2", null, "ExeM2:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class n0 extends Lambda implements Function0<la0> {
        public static final n0 a = new n0();

        public n0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Pattern:Clear;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class n1 extends Lambda implements Function0<la0> {
        public static final n1 a = new n1();

        public n1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Mirr", null, "Mirr:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class o extends Lambda implements Function0<la0> {
        public static final o a = new o();

        public o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Flash;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class o0 extends Lambda implements Function0<la0> {
        public static final o0 a = new o0();

        public o0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Plname", null, "Pl%s:%s/%s:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class o1 extends Lambda implements Function0<la0> {
        public static final o1 a = new o1();

        public o1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Notify", null, "Notify:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class p extends Lambda implements Function0<la0> {
        public static final p a = new p();

        public p() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("GetAColor;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class p0 extends Lambda implements Function0<la0> {
        public static final p0 a = new p0();

        public p0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("PowerOff;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class p1 extends Lambda implements Function0<la0> {
        public static final p1 a = new p1();

        public p1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("SetPinC", null, "SetPinC:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class q extends Lambda implements Function0<la0> {
        public static final q a = new q();

        public q() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("GetAS;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class q0 extends Lambda implements Function0<la0> {
        public static final q0 a = new q0();

        public q0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Preset", null, "Preset:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class q1 extends Lambda implements Function0<la0> {
        public static final q1 a = new q1();

        public q1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("SetPinCode", null, "SetPinCode:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class r extends Lambda implements Function0<la0> {
        public static final r a = new r();

        public r() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("GetAlight;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class r0 extends Lambda implements Function0<la0> {
        public static final r0 a = new r0();

        public r0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Ps", null, "Ps:%s:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class r1 extends Lambda implements Function0<la0> {
        public static final r1 a = new r1();

        public r1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("SetPinS", null, "SetPinS:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class s extends Lambda implements Function0<la0> {
        public static final s a = new s();

        public s() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("GetBatch;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class s0 extends Lambda implements Function0<la0> {
        public static final s0 a = new s0();

        public s0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("RdCtlPan;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class s1 extends Lambda implements Function0<la0> {
        public static final s1 a = new s1();

        public s1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("SetPinStatus", null, "SetPinStatus:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class t extends Lambda implements Function0<la0> {
        public static final t a = new t();

        public t() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("BMS;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class t0 extends Lambda implements Function0<la0> {
        public static final t0 a = new t0();

        public t0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("RdSolo;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class t1 extends Lambda implements Function0<la0> {
        public static final t1 a = new t1();

        public t1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("SetSolo", null, "SetSolo:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class u extends Lambda implements Function0<la0> {
        public static final u a = new u();

        public u() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("AR", null, "AR:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class u0 extends Lambda implements Function0<la0> {
        public static final u0 a = new u0();

        public u0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("RdTchLvl;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class u1 extends Lambda implements Function0<la0> {
        public static final u1 a = new u1();

        public u1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("SetTchLvl", null, "SetTchLvl:%s:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class v extends Lambda implements Function0<la0> {
        public static final v a = new v();

        public v() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("AG;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class v0 extends Lambda implements Function0<la0> {
        public static final v0 a = new v0();

        public v0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("AC;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class v1 extends Lambda implements Function0<la0> {
        public static final v1 a = new v1();

        public v1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("SetBkV", null, "SetBkV:%s:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class w extends Lambda implements Function0<la0> {
        public static final w a = new w();

        public w() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("GetColor;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class w0 extends Lambda implements Function0<la0> {
        public static final w0 a = new w0();

        public w0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("AD", null, "AD:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class w1 extends Lambda implements Function0<la0> {
        public static final w1 a = new w1();

        public w1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("SetTmp", null, "SetTmp:%s:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class x extends Lambda implements Function0<la0> {
        public static final x a = new x();

        public x() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("getdly;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class x0 extends Lambda implements Function0<la0> {
        public static final x0 a = new x0();

        public x0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Remove", null, "Remove:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class x1 extends Lambda implements Function0<la0> {
        public static final x1 a = new x1();

        public x1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("SetTx", null, "SetTx:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class y extends Lambda implements Function0<la0> {
        public static final y a = new y();

        public y() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("AN;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class y0 extends Lambda implements Function0<la0> {
        public static final y0 a = new y0();

        public y0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("RstName;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class y1 extends Lambda implements Function0<la0> {
        public static final y1 a = new y1();

        public y1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Space:All;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class z extends Lambda implements Function0<la0> {
        public static final z a = new z();

        public z() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("GetLevel;", null, null, null, 14, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class z0 extends Lambda implements Function0<la0> {
        public static final z0 a = new z0();

        public z0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("SetAColor", null, "SetAColor:%s;", null, 10, null);
        }
    }

    /* compiled from: ToyCommandFunctionConstant.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/component/dxtoy/core/commandcore/constant/ToyCommandConstant;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class z1 extends Lambda implements Function0<la0> {
        public static final z1 a = new z1();

        public z1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final la0 invoke() {
            return new la0("Space:Clear;", null, null, null, 14, null);
        }
    }

    @NotNull
    public final la0 A() {
        return (la0) Q.getValue();
    }

    @NotNull
    public final la0 A0() {
        return (la0) o0.getValue();
    }

    @NotNull
    public final la0 B() {
        return (la0) v0.getValue();
    }

    @NotNull
    public final la0 B0() {
        return (la0) p0.getValue();
    }

    @NotNull
    public final la0 C() {
        return (la0) C.getValue();
    }

    @NotNull
    public final la0 C0() {
        return (la0) y0.getValue();
    }

    @NotNull
    public final la0 D() {
        return (la0) D.getValue();
    }

    @NotNull
    public final la0 E() {
        return (la0) G.getValue();
    }

    @NotNull
    public final la0 F() {
        return (la0) J.getValue();
    }

    @NotNull
    public final la0 G() {
        return (la0) W.getValue();
    }

    @NotNull
    public final la0 H() {
        return (la0) Z.getValue();
    }

    @NotNull
    public final la0 I() {
        return (la0) x0.getValue();
    }

    @NotNull
    public final la0 J() {
        return (la0) j0.getValue();
    }

    @NotNull
    public final la0 K() {
        return (la0) z0.getValue();
    }

    @NotNull
    public final la0 L() {
        return (la0) M.getValue();
    }

    @NotNull
    public final la0 M() {
        return (la0) E.getValue();
    }

    @NotNull
    public final la0 N() {
        return (la0) x.getValue();
    }

    @NotNull
    public final la0 O() {
        return (la0) k0.getValue();
    }

    @NotNull
    public final la0 P() {
        return (la0) F.getValue();
    }

    @NotNull
    public final la0 Q() {
        return (la0) w.getValue();
    }

    @NotNull
    public final la0 R() {
        return (la0) h0.getValue();
    }

    @NotNull
    public final la0 S() {
        return (la0) f0.getValue();
    }

    @NotNull
    public final la0 T() {
        return (la0) d0.getValue();
    }

    @NotNull
    public final la0 U() {
        return (la0) q.getValue();
    }

    @NotNull
    public final la0 V() {
        return (la0) r.getValue();
    }

    @NotNull
    public final la0 W() {
        return (la0) B.getValue();
    }

    @NotNull
    public final la0 X() {
        return (la0) l.getValue();
    }

    @NotNull
    public final la0 Y() {
        return (la0) r0.getValue();
    }

    @NotNull
    public final la0 Z() {
        return (la0) j.getValue();
    }

    @NotNull
    public final la0 a() {
        return (la0) D0.getValue();
    }

    @NotNull
    public final la0 a0() {
        return (la0) S.getValue();
    }

    @NotNull
    public final la0 b() {
        return (la0) C0.getValue();
    }

    @NotNull
    public final la0 b0() {
        return (la0) X.getValue();
    }

    @NotNull
    public final la0 c() {
        return (la0) u.getValue();
    }

    @NotNull
    public final la0 c0() {
        return (la0) t.getValue();
    }

    @NotNull
    public final la0 d() {
        return (la0) v.getValue();
    }

    @NotNull
    public final la0 d0() {
        return (la0) t0.getValue();
    }

    @NotNull
    public final la0 e() {
        return (la0) m.getValue();
    }

    @NotNull
    public final la0 e0() {
        return (la0) g0.getValue();
    }

    @NotNull
    public final la0 f() {
        return (la0) d.getValue();
    }

    @NotNull
    public final la0 f0() {
        return (la0) B0.getValue();
    }

    @NotNull
    public final la0 g() {
        return (la0) U.getValue();
    }

    @NotNull
    public final la0 g0() {
        return (la0) q0.getValue();
    }

    @NotNull
    public final la0 h() {
        return (la0) k.getValue();
    }

    @NotNull
    public final la0 h0() {
        return (la0) n0.getValue();
    }

    @NotNull
    public final la0 i() {
        return (la0) E0.getValue();
    }

    @NotNull
    public final la0 i0() {
        return (la0) b0.getValue();
    }

    @NotNull
    public final la0 j() {
        return (la0) c.getValue();
    }

    @NotNull
    public final la0 j0() {
        return (la0) N.getValue();
    }

    @NotNull
    public final la0 k() {
        return (la0) b.getValue();
    }

    @NotNull
    public final la0 k0() {
        return (la0) f.getValue();
    }

    @NotNull
    public final la0 l() {
        return (la0) V.getValue();
    }

    @NotNull
    public final la0 l0() {
        return (la0) P.getValue();
    }

    @NotNull
    public final la0 m() {
        return (la0) R.getValue();
    }

    @NotNull
    public final la0 m0() {
        return (la0) Y.getValue();
    }

    @NotNull
    public final la0 n() {
        return (la0) h.getValue();
    }

    @NotNull
    public final la0 n0() {
        return (la0) m0.getValue();
    }

    @NotNull
    public final la0 o() {
        return (la0) s0.getValue();
    }

    @NotNull
    public final la0 o0() {
        return (la0) H.getValue();
    }

    @NotNull
    public final la0 p() {
        return (la0) n.getValue();
    }

    @NotNull
    public final la0 p0() {
        return (la0) I.getValue();
    }

    @NotNull
    public final la0 q() {
        return (la0) i.getValue();
    }

    @NotNull
    public final la0 q0() {
        return (la0) K.getValue();
    }

    @NotNull
    public final la0 r() {
        return (la0) e.getValue();
    }

    @NotNull
    public final la0 r0() {
        return (la0) L.getValue();
    }

    @NotNull
    public final la0 s() {
        return (la0) T.getValue();
    }

    @NotNull
    public final la0 s0() {
        return (la0) e0.getValue();
    }

    @NotNull
    public final la0 t() {
        return (la0) o.getValue();
    }

    @NotNull
    public final la0 t0() {
        return (la0) c0.getValue();
    }

    @NotNull
    public final la0 u() {
        return (la0) s.getValue();
    }

    @NotNull
    public final la0 u0() {
        return (la0) w0.getValue();
    }

    @NotNull
    public final la0 v() {
        return (la0) u0.getValue();
    }

    @NotNull
    public final la0 v0() {
        return (la0) a0.getValue();
    }

    @NotNull
    public final la0 w() {
        return (la0) A0.getValue();
    }

    @NotNull
    public final la0 w0() {
        return (la0) i0.getValue();
    }

    @NotNull
    public final la0 x() {
        return (la0) p.getValue();
    }

    @NotNull
    public final la0 x0() {
        return (la0) y.getValue();
    }

    @NotNull
    public final la0 y() {
        return (la0) O.getValue();
    }

    @NotNull
    public final la0 y0() {
        return (la0) A.getValue();
    }

    @NotNull
    public final la0 z() {
        return (la0) g.getValue();
    }

    @NotNull
    public final la0 z0() {
        return (la0) z.getValue();
    }
}

package dc;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.vending.expansion.downloader.DownloaderClientMarshaller;
import com.wear.bean.Toy;
import com.wear.bean.event.ChangeToyEvent;
import com.wear.dao.DaoUtils;
import com.wear.util.WearUtils;
import dc.jr1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: BtWork.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0019\bÆ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0016\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"J\u0016\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001dJ\u0006\u0010'\u001a\u00020\u0016J\u0010\u0010(\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0005H\u0016J\u0006\u0010)\u001a\u00020\u0016J\u000e\u0010*\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0005J\u0006\u0010+\u001a\u00020\u0016J\u0010\u0010,\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0005H\u0016J\u0006\u0010-\u001a\u00020\u0016J\u0010\u0010.\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010/\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u00100\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0006\u00101\u001a\u00020\u0016J\u000e\u00101\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0005J\u0006\u00102\u001a\u00020\u0016J\u0006\u00103\u001a\u00020\u0016J\u000e\u00103\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0005J\u0012\u00104\u001a\u0004\u0018\u0001052\u0006\u0010 \u001a\u00020\u0005H\u0016J\n\u00106\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u00107\u001a\u0004\u0018\u00010\u001bJ\u0014\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b09H\u0016J\u000e\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00050;H\u0016J\u0018\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u001b0=j\b\u0012\u0004\u0012\u00020\u001b`>H\u0016J\u0010\u0010?\u001a\u0004\u0018\u00010\u001b2\u0006\u0010 \u001a\u00020\u0005J\u0016\u0010@\u001a\u0012\u0012\u0004\u0012\u00020\u001b0=j\b\u0012\u0004\u0012\u00020\u001b`>J\u0018\u0010A\u001a\u0012\u0012\u0004\u0012\u00020\u001b0=j\b\u0012\u0004\u0012\u00020\u001b`>H\u0016J\u0014\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001b09H\u0016J\u0012\u0010C\u001a\u0004\u0018\u00010\u001b2\u0006\u0010 \u001a\u00020\u0005H\u0016J\u0018\u0010D\u001a\u0012\u0012\u0004\u0012\u00020\u001b0=j\b\u0012\u0004\u0012\u00020\u001b`>H\u0016J\u0006\u0010E\u001a\u00020\"J\u0010\u0010F\u001a\u0004\u0018\u00010\u001b2\u0006\u0010 \u001a\u00020\u0005J\u0012\u0010G\u001a\u0004\u0018\u00010\u001b2\b\u0010H\u001a\u0004\u0018\u00010\u0005J\u0016\u0010I\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010;2\u0006\u0010J\u001a\u00020\u0005J\u0010\u0010K\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u0005H\u0016J\u0012\u0010L\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010M\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0005H\u0016J\u0016\u0010N\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0005J\u001e\u0010P\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00052\u0006\u0010Q\u001a\u00020\"2\u0006\u0010R\u001a\u00020\"J\u0010\u0010S\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010T\u001a\u00020\u00162\u0006\u0010T\u001a\u00020\"J\u0016\u0010T\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00052\u0006\u0010T\u001a\u00020\"J\u000e\u0010U\u001a\u00020\u00162\u0006\u0010T\u001a\u00020\"J\u0012\u0010V\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010W\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0005H\u0016J\u001c\u0010X\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010\u00052\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J\b\u0010[\u001a\u00020\u0016H\u0016J\u000e\u0010\\\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010]\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010^\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u000e\u0010_\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0005J\b\u0010`\u001a\u00020\u0016H\u0016J\u000e\u0010a\u001a\u00020\u00162\u0006\u0010b\u001a\u00020\u001dJ\u0010\u0010c\u001a\u00020\u00162\u0006\u0010d\u001a\u00020\u001dH\u0016J;\u0010e\u001a\u00020\u00162\u000e\u0010f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010g2\u000e\u0010h\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010g2\u0006\u0010i\u001a\u00020\u001d2\u0006\u0010j\u001a\u00020\u001d¢\u0006\u0002\u0010kJ;\u0010l\u001a\u00020\u00162\u000e\u0010f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010g2\u000e\u0010h\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010g2\u0006\u0010i\u001a\u00020\u001d2\u0006\u0010j\u001a\u00020\u001d¢\u0006\u0002\u0010kJ(\u0010m\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010h\u001a\u00020\"2\u0006\u0010i\u001a\u00020\u001d2\u0006\u0010j\u001a\u00020\u001dJ\u0010\u0010n\u001a\u00020\u00162\u0006\u0010O\u001a\u00020\u0005H\u0016J\u0018\u0010n\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0005H\u0016J\u001e\u0010o\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010p\u001a\u00020\u00052\u0006\u0010h\u001a\u00020\"J\u0018\u0010q\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0005H\u0016J \u0010r\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010p\u001a\u00020\u00052\u0006\u0010h\u001a\u00020\"J\u001a\u0010s\u001a\u00020\u00162\u0006\u0010t\u001a\u00020\u00052\b\b\u0002\u0010u\u001a\u00020\"H\u0007J\u0016\u0010s\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0005J\u001e\u0010s\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00052\u0006\u0010t\u001a\u00020\u00052\u0006\u0010u\u001a\u00020\"J\u001c\u0010v\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00052\f\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00050xJ\u001a\u0010v\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010\u00052\b\u0010y\u001a\u0004\u0018\u00010zJ.\u0010v\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010\u00052\f\u0010w\u001a\b\u0012\u0004\u0012\u00020\u00050;2\u0006\u0010i\u001a\u00020\u001d2\u0006\u0010j\u001a\u00020\u001dJ\u001e\u0010{\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010y\u001a\u00020z2\u0006\u0010j\u001a\u00020\u001dJ,\u0010{\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00050}2\u0006\u0010i\u001a\u00020\u001d2\u0006\u0010j\u001a\u00020\u001dJ&\u0010{\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010\u00052\f\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00050;2\u0006\u0010i\u001a\u00020\u001dJ \u0010~\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010p\u001a\u00020\u00052\u0006\u0010h\u001a\u00020\"JQ\u0010\u007f\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u000e\u0010f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010g2\u000e\u0010h\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010g2\u0006\u0010i\u001a\u00020\u001d2\u0006\u0010j\u001a\u00020\u001d2\t\b\u0002\u0010\u0080\u0001\u001a\u00020\u001d¢\u0006\u0003\u0010\u0081\u0001JL\u0010\u007f\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0007\u0010\u0082\u0001\u001a\u00020\u001d2\u000f\u0010\u0083\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010;2\u0006\u0010i\u001a\u00020\u001d2\u0006\u0010j\u001a\u00020\u001d2\u0007\u0010\u0080\u0001\u001a\u00020\u001d2\u0007\u0010\u0084\u0001\u001a\u00020\u001dJ'\u0010\u0085\u0001\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010h\u001a\u00020\"2\u0006\u0010i\u001a\u00020\u001d2\u0006\u0010j\u001a\u00020\u001dJ\u0014\u0010\u0086\u0001\u001a\u00020\u00162\t\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u0005H\u0016J.\u0010\u0088\u0001\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010\u00052\u0007\u0010\u0089\u0001\u001a\u00020\"2\u0007\u0010\u008a\u0001\u001a\u00020\"2\u0007\u0010\u008b\u0001\u001a\u00020\"H\u0016J\u0010\u0010\u008c\u0001\u001a\u00020\u00162\u0007\u0010\u008d\u0001\u001a\u00020\u001dJ\u0011\u0010\u008e\u0001\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0011\u0010\u008f\u0001\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0011\u0010\u0090\u0001\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0007\u0010\u0091\u0001\u001a\u00020\u0016J\u0007\u0010\u0092\u0001\u001a\u00020\u0016J\u0011\u0010\u0092\u0001\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010\u0005J\u0019\u0010\u0093\u0001\u001a\u00020\u00162\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0018\u0010\u0094\u0001\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00052\u0007\u0010\u0095\u0001\u001a\u00020\u001dR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0096\u0001"}, d2 = {"Lcom/lovense/btservice/work/BtWork;", "Lcom/wear/component/dxtoy/bluetooth/data/IBtData;", "Lcom/wear/component/dxtoy/bluetooth/workcore/IBtWorkCore;", "()V", "LOG_TAG", "", "btBattery", "Lcom/lovense/btservice/work/BtBattery;", "getBtBattery", "()Lcom/lovense/btservice/work/BtBattery;", "btData", "getBtData", "()Lcom/wear/component/dxtoy/bluetooth/data/IBtData;", "btData$delegate", "Lkotlin/Lazy;", "btWaggle", "Lcom/lovense/btservice/work/BtWaggle;", "getBtWaggle", "()Lcom/lovense/btservice/work/BtWaggle;", "btWaggle$delegate", "btWorkCore", "addIWaggleListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/lovense/btservice/work/IWaggleListener;", "addLinkedToy", "toy", "Lcom/wear/bean/Toy;", "needSaveDb", "", "addLinkedToyToDb", "addToyRssi", MultipleAddresses.Address.ELEMENT, "rssi", "", "checkBTEnable", "context", "Landroid/content/Context;", "needEnable", "clearAllToys", "clearCommand", "closeAll", "containsNowLinkedToy", "disConnectByBluetoothOff", "disconnect", "endAllMoveWaggle", "endGame", "endMirr", "endMoveWaggle", "enterMissionPan", "enterOnlyMissionPan", "exitMissionPan", "getConnectDevice", "Landroid/bluetooth/BluetoothDevice;", "getElementId", "getFirstConnectToy", "getNowLinkedToysMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getNowToyAddress", "", "getNowToys", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getNowToysConnect", "getNowToysConnectList", "getNowToysSelectedList", "getSearchLinkToyMap", "getSearchToy", "getSearchToys", "getTotalSelectToys", "getToy", "getToyByDeviceId", TtmlNode.ATTR_ID, "getToyByDeviceName", "name", "isConnected", "logUUid", "maybeResetRequestConnectToyState", "notifyToyCharacteristic", "message", "onConnectionStateChange", "status", DownloaderClientMarshaller.PARAM_NEW_STATE, "openMirr", "pattern", "patternToRotateAndPap", "readPhy", "readRssi", "registerPhyCallback", "phyCallback", "Lcom/component/dxbluetooth/lib/listener/IBluetoothPhyCallback;", "removeAllSearchToys", "removeIWaggleListener", "removeLinkedToy", "removeSearchToy", "removeToyByContentProvider", "resetBleParams", "resetUseNew", "isUseNew", "scanDevice", StreamManagement.Enable.ELEMENT, "sendAllToyCommands", "funs", "", "value", "needTranslate", "needStrength", "([Ljava/lang/String;[Ljava/lang/String;ZZ)V", "sendAllToyCommandsByToyMode", "sendBaToySpeedCommands", "sendCommand", "sendCommandStrengthSet", "opertion", "sendCommandToBle", "sendCommandWithStrength", "sendFuncCommand", "command", "flag", "sendLvsCommand", "messageList", "Ljava/util/LinkedList;", "toyBean", "Lcom/wear/bean/ToyBean;", "sendMultiCommand", "commands", "", "sendToyCommand", "sendToyCommands", "sendByToyMode", "(Lcom/wear/bean/Toy;[Ljava/lang/String;[Ljava/lang/String;ZZZ)V", "playAllMotors", "createdCommandsByPattern", "isSyncModel", "sendToyCommandsByLDR", "setElementId", "elementId", "setPreferredPhy", "tx", "rx", "phyOptions", "setReconnectOneLoopFlag", "checkCurrentAddress", "startGame", "startMove", "startMoveWaggle", "stopScanAndClearSearchToys", "stopToysAction", "updateLinkedToyToDatabase", "updateSearchToysChooseState", "isSelcect", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class pc1 implements up1, aq1 {

    @NotNull
    public static final pc1 a = new pc1();

    @JvmField
    @NotNull
    public static final String b;

    @NotNull
    public static final Lazy c;

    @NotNull
    public static final aq1 d;

    @NotNull
    public static final Lazy e;

    @NotNull
    public static final ic1 f;

    /* compiled from: BtWork.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/wear/component/dxtoy/bluetooth/data/BtDataProxy;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<tp1> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final tp1 invoke() {
            return new tp1();
        }
    }

    /* compiled from: BtWork.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/lovense/btservice/work/BtWaggle;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b extends Lambda implements Function0<oc1> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final oc1 invoke() {
            return new oc1(pc1.a);
        }
    }

    static {
        String simpleName = pc1.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "BtWork::class.java.simpleName");
        b = simpleName;
        c = LazyKt__LazyJVMKt.lazy(a.a);
        d = new zp1();
        e = LazyKt__LazyJVMKt.lazy(b.a);
        f = new ic1();
    }

    public static /* synthetic */ void k0(pc1 pc1Var, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        pc1Var.h0(str, i);
    }

    public final synchronized void A() {
        for (Toy toy : g().values()) {
            if (toy != null) {
                toy.setUpdateDfu(null);
                toy.setLed(-1);
                toy.setStatus(-1);
                EventBus.getDefault().post(new xc1(toy.getAddress(), -1));
                if (db2.A().i) {
                    db2.A().P();
                }
                h32.i().z();
                pc1 pc1Var = a;
                String address = toy.getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "it.address");
                pc1Var.disconnect(address);
            }
        }
        wi2.e().f("BtWork.disConnectByBluetoothOff()");
        LocalBroadcastManager.getInstance(ve0.a()).sendBroadcast(new Intent("ACTION_TOY_UPDATE"));
    }

    public final synchronized void B() {
        for (Toy toy : P()) {
            if (Intrinsics.areEqual(toy.getType(), "nora") || Intrinsics.areEqual(toy.getType(), "max") || StringsKt__StringsJVMKt.equals(toy.getType(), Toy.TOY_XMACHINE, true)) {
                pc1 pc1VarG = WearUtils.x.G();
                String address = toy.getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "oneToy.address");
                if (pc1VarG.a(address)) {
                    E(toy);
                }
            }
        }
    }

    public final synchronized void C(@Nullable Toy toy) {
        if (toy == null) {
            return;
        }
        M().d(toy);
    }

    public final synchronized void D(@Nullable Toy toy) {
        if (toy == null) {
            return;
        }
        M().e(toy);
    }

    public final synchronized void E(@Nullable Toy toy) {
        if (toy == null) {
            return;
        }
        M().f(toy);
    }

    public final void F() {
        try {
            for (Toy toy : g().values()) {
                Intrinsics.checkNotNullExpressionValue(toy, "getNowLinkedToysMap().values");
                String address = toy.getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "toy.address");
                G(address);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void G(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        Toy toy = g().get(address);
        if (toy != null && toy.isConnected() && toy.isSupportDepthMode()) {
            xe3.a("DepthControl", "SetCtlPan:1;");
            jr1.a.e(address, true);
        }
    }

    public final void H() {
        Toy next;
        try {
            Iterator<Toy> it = g().values().iterator();
            while (it.hasNext() && (next = it.next()) != null && next.isConnected() && next.isSupportDepthMode() && Intrinsics.areEqual(next.getType(), "mission")) {
                xe3.a("DepthControl", "SetCtlPan:1;");
                jr1.a aVar = jr1.a;
                String address = next.getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "toy.address");
                aVar.e(address, true);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void I() {
        try {
            for (Toy toy : g().values()) {
                Intrinsics.checkNotNullExpressionValue(toy, "getNowLinkedToysMap().values");
                String address = toy.getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "toy.address");
                J(address);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void J(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        Toy toy = g().get(address);
        if (toy != null && toy.isConnected() && toy.isSupportDepthMode()) {
            xe3.a("DepthControl", "SetCtlPan:0;");
            jr1.a.e(address, false);
        }
    }

    @NotNull
    public final ic1 K() {
        return f;
    }

    public final up1 L() {
        return (up1) c.getValue();
    }

    @NotNull
    public final oc1 M() {
        return (oc1) e.getValue();
    }

    @Nullable
    public final Toy N() {
        for (Toy toy : g().values()) {
            Intrinsics.checkNotNullExpressionValue(toy, "getNowLinkedToysMap().values");
            Toy toy2 = toy;
            String address = toy2.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "t.address");
            if (a(address)) {
                return toy2;
            }
        }
        return null;
    }

    @Nullable
    public final Toy O(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        for (Toy toy : g().values()) {
            Intrinsics.checkNotNullExpressionValue(toy, "getNowLinkedToysMap().values");
            Toy toy2 = toy;
            if (Intrinsics.areEqual(address, toy2.getAddress())) {
                String address2 = toy2.getAddress();
                Intrinsics.checkNotNullExpressionValue(address2, "t.address");
                if (a(address2)) {
                    return toy2;
                }
            }
        }
        return null;
    }

    @NotNull
    public final ArrayList<Toy> P() {
        Collection<Toy> collectionValues = g().values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "getNowLinkedToysMap().values");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            pc1 pc1Var = a;
            String address = ((Toy) obj).getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "it.address");
            if (pc1Var.a(address)) {
                arrayList.add(obj);
            }
        }
        return new ArrayList<>(arrayList);
    }

    @Nullable
    public final Toy Q(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return g().get(address);
    }

    @Nullable
    public final Toy R(@Nullable String str) {
        if (str == null) {
            return null;
        }
        for (Toy toy : g().values()) {
            Intrinsics.checkNotNullExpressionValue(toy, "getNowLinkedToysMap().values");
            Toy toy2 = toy;
            if (StringsKt__StringsJVMKt.equals(toy2.getAndUpdateDeviceId(), str, true)) {
                return toy2;
            }
        }
        return null;
    }

    @Nullable
    public final List<Toy> S(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (WearUtils.e1(name)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Toy toy : g().values()) {
            if (toy != null) {
                String name2 = toy.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "it.name");
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                String lowerCase = name2.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (!Intrinsics.areEqual(lowerCase, name)) {
                    String type = toy.getType();
                    Locale locale2 = Locale.getDefault();
                    Intrinsics.checkNotNullExpressionValue(locale2, "getDefault()");
                    String lowerCase2 = name.toLowerCase(locale2);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                    if (Intrinsics.areEqual(type, lowerCase2)) {
                    }
                }
                arrayList.add(toy);
            }
        }
        return arrayList;
    }

    public final void T(@NotNull String address, @NotNull String message) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(message, "message");
        EventBus.getDefault().post(new wc1(address, message));
    }

    public final void U(@NotNull String address, int i, int i2) {
        Intrinsics.checkNotNullParameter(address, "address");
        g().get(address);
    }

    public final synchronized void V(@Nullable Toy toy) {
        if (toy == null) {
            return;
        }
        M().l(toy);
    }

    public final void W(int i) {
        if (i != 101 && i == kc1.e && i == kc1.f) {
            return;
        }
        for (Toy toy : g().values()) {
            Intrinsics.checkNotNullExpressionValue(toy, "getNowLinkedToysMap().values");
            String address = toy.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "toy.address");
            X(address, i);
        }
    }

    public final void X(@NotNull String address, int i) {
        Intrinsics.checkNotNullParameter(address, "address");
        String str = "pattern: sendCommand=address:" + address + "pattern=" + i;
        kc1.a.b(g().get(address), i);
    }

    public final void Y(int i) {
        for (Toy toy : g().values()) {
            Intrinsics.checkNotNullExpressionValue(toy, "getNowLinkedToysMap().values");
            Toy toy2 = toy;
            if (Intrinsics.areEqual(toy2.getType(), "nora") || Intrinsics.areEqual(toy2.getType(), "max")) {
                if (Intrinsics.areEqual(toy2.getType(), "nora")) {
                    String address = toy2.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address, "toy.address");
                    StringBuilder sb = new StringBuilder();
                    sb.append("Rotate:");
                    sb.append(Toy.changeSinglefuncLineToTayValue(StreamManagement.AckRequest.ELEMENT, "" + i));
                    sb.append(';');
                    e(address, sb.toString());
                } else if (Intrinsics.areEqual(toy2.getType(), "max")) {
                    String address2 = toy2.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address2, "toy.address");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Air:Level:");
                    sb2.append(Toy.changeSinglefuncLineToTayValue("p", "" + i));
                    sb2.append(';');
                    e(address2, sb2.toString());
                }
            }
        }
    }

    public final void Z(@NotNull yc1 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        M().s(listener);
    }

    @Override // dc.aq1
    public boolean a(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return d.a(address);
    }

    public final void a0(@NotNull String address, boolean z) {
        Intrinsics.checkNotNullParameter(address, "address");
        Toy toy = g().get(address);
        if (toy != null) {
            pc1 pc1Var = a;
            if (pc1Var.a(address)) {
                rp1.a.b(toy);
                pc1Var.disconnect(address);
            }
            pc1Var.g().remove(address);
            EventBus.getDefault().post(new ChangeToyEvent(address, false));
            toy.setIsSelect(0);
            if (z) {
                DaoUtils.getToyDao().delT(toy);
                qg3.d(toy.getAddress());
                hu3.T();
                fk2.a.g(address);
            }
        }
        c(address);
    }

    @Override // dc.aq1
    public void b(@Nullable String str, @Nullable vt vtVar) {
        d.b(str, vtVar);
    }

    public final void b0(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        Toy toy = g().get(address);
        if (toy != null) {
            pc1 pc1Var = a;
            if (pc1Var.a(address)) {
                rp1.a.b(toy);
                pc1Var.disconnect(address);
            }
            pc1Var.g().remove(address);
            EventBus.getDefault().post(new ChangeToyEvent(address, false));
            hu3.T();
        }
    }

    @Override // dc.aq1
    public void c(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        d.c(address);
    }

    public final void c0(@Nullable String[] strArr, @Nullable String[] strArr2, boolean z, boolean z2) {
        lc1.a.d(strArr, strArr2, z, z2);
    }

    @Override // dc.wp1
    @NotNull
    public ConcurrentHashMap<String, Toy> d() {
        return L().d();
    }

    public final void d0(@Nullable Toy toy, int i, boolean z, boolean z2) {
        lc1.a.e(toy, i, z, z2);
    }

    @Override // dc.aq1
    public void disconnect(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        d.disconnect(address);
    }

    @Override // dc.aq1
    public void e(@NotNull String address, @NotNull String message) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(message, "message");
        d.e(address, message);
    }

    public final void e0(@NotNull Toy toy, @NotNull String opertion, int i) {
        Intrinsics.checkNotNullParameter(toy, "toy");
        Intrinsics.checkNotNullParameter(opertion, "opertion");
        lc1.a.f(toy, opertion, i);
    }

    @Override // dc.aq1
    public void f(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        d.f(message);
    }

    public final void f0(@Nullable Toy toy, @NotNull String opertion, int i) {
        Intrinsics.checkNotNullParameter(opertion, "opertion");
        lc1.a.g(toy, opertion, i);
    }

    @Override // dc.vp1
    @NotNull
    public ConcurrentHashMap<String, Toy> g() {
        return L().g();
    }

    @JvmOverloads
    public final void g0(@NotNull String command) {
        Intrinsics.checkNotNullParameter(command, "command");
        k0(this, command, 0, 2, null);
    }

    @Override // dc.wp1
    public void h() {
        L().h();
    }

    @JvmOverloads
    public final void h0(@NotNull String command, int i) {
        Intrinsics.checkNotNullParameter(command, "command");
        lc1.a.i(command, i);
    }

    @Override // dc.aq1
    public void i(boolean z) {
        d.i(z);
    }

    public final void i0(@NotNull String address, @NotNull String message) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(message, "message");
        lc1.a.j(address, message);
    }

    @Override // dc.aq1
    public void j(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        d.j(address);
    }

    public final void j0(@NotNull String address, @NotNull String command, int i) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(command, "command");
        lc1.a.k(address, command, i);
    }

    @Override // dc.aq1
    public void k(@Nullable String str) {
        d.k(str);
    }

    @Override // dc.aq1
    public void l(@NotNull String address, @NotNull String message) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(message, "message");
        d.l(address, message);
    }

    public final void l0(@Nullable String str, @NotNull List<String> messageList, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(messageList, "messageList");
        lc1.a.l(str, messageList, z, z2);
    }

    @Override // dc.vp1
    @NotNull
    public List<String> m() {
        return L().m();
    }

    public final void m0(@Nullable Toy toy, boolean z, @Nullable List<String> list, boolean z2, boolean z3, boolean z4, boolean z5) {
        lc1.a.q(toy, z, list, z2, z3, z4, z5);
    }

    @Override // dc.wp1
    @Nullable
    public Toy n(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return L().n(address);
    }

    public final void n0(@Nullable Toy toy, @Nullable String[] strArr, @Nullable String[] strArr2, boolean z, boolean z2, boolean z3) {
        lc1.a.r(toy, strArr, strArr2, z, z2, z3);
    }

    @Override // dc.vp1
    @NotNull
    public ArrayList<Toy> o() {
        return L().o();
    }

    public final void o0(@NotNull Toy toy, int i, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(toy, "toy");
        lc1.a.t(toy, i, z, z2);
    }

    @Override // dc.vp1
    @NotNull
    public ArrayList<Toy> p() {
        return L().p();
    }

    public final void p0(boolean z) {
    }

    @Override // dc.wp1
    @NotNull
    public ArrayList<Toy> q() {
        return L().q();
    }

    public final synchronized void q0(@Nullable Toy toy) {
        if (toy == null) {
            return;
        }
        M().u(toy);
    }

    @Override // dc.aq1
    @Nullable
    public BluetoothDevice r(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return d.r(address);
    }

    public final synchronized void r0(@Nullable Toy toy) {
        if (toy == null) {
            return;
        }
        M().v(toy);
    }

    @Override // dc.aq1
    public void readPhy(@Nullable String address) {
        d.readPhy(address);
    }

    @Override // dc.aq1
    public void readRssi(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        d.readRssi(address);
    }

    @Override // dc.aq1
    public void resetBleParams() {
        d.resetBleParams();
    }

    @Override // dc.wp1
    public void s(@NotNull Toy toy) {
        Intrinsics.checkNotNullParameter(toy, "toy");
        L().s(toy);
    }

    public final synchronized void s0(@Nullable Toy toy) {
        if (toy == null) {
            return;
        }
        M().w(toy);
    }

    @Override // dc.aq1
    public void setPreferredPhy(@Nullable String address, int tx, int rx2, int phyOptions) {
        d.setPreferredPhy(address, tx, rx2, phyOptions);
    }

    public final void t(@NotNull yc1 listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        M().a(listener);
    }

    public final void t0() {
    }

    public final void u(@NotNull Toy toy) {
        Intrinsics.checkNotNullParameter(toy, "toy");
        if (g().get(toy.getAddress()) == null) {
            ConcurrentHashMap<String, Toy> concurrentHashMapG = g();
            String address = toy.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "toy.address");
            concurrentHashMapG.put(address, toy);
            EventBus.getDefault().post(new ChangeToyEvent(toy.getAddress(), true));
        }
    }

    public final void u0() {
        rq1.d.q();
    }

    public final void v(@NotNull Toy toy, boolean z) {
        Intrinsics.checkNotNullParameter(toy, "toy");
        u(toy);
        if (z) {
            toy.setUpdateTime(System.currentTimeMillis());
            toy.setFormApp("Lovense Remote");
            w(toy);
            qg3.b(toy);
            hu3.T();
        }
    }

    public final void v0(@Nullable String str) {
        rq1.d.r(str);
    }

    public final void w(Toy toy) {
        if (DaoUtils.getToyDao().existToyByEmail(WearUtils.y.r(), toy.getAddress()) || !Toy.NAME_MAP.containsKey(toy.getType())) {
            DaoUtils.getToyDao().update(toy);
        } else {
            DaoUtils.getToyDao().add(toy);
        }
    }

    public final void w0(@Nullable Context context, @NotNull Toy toy) {
        Intrinsics.checkNotNullParameter(toy, "toy");
        DaoUtils.getToyDao().update(toy);
        qg3.j(context, toy);
    }

    public final void x(@NotNull String address, int i) {
        Intrinsics.checkNotNullParameter(address, "address");
        Toy toy = g().get(address);
        if (toy != null) {
            toy.pushRssi(i);
        }
    }

    public final void x0(@NotNull String address, boolean z) {
        Intrinsics.checkNotNullParameter(address, "address");
        Toy toy = d().get(address);
        if (toy != null) {
            toy.setIsSelect(Integer.valueOf(z ? 1 : 0));
        }
    }

    public final boolean y(@NotNull Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = ve0.a().getSystemService("bluetooth");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        BluetoothAdapter adapter = ((BluetoothManager) systemService).getAdapter();
        if (adapter == null) {
            rp1.a.d();
            return false;
        }
        if (adapter.isEnabled()) {
            return true;
        }
        if (!z) {
            return false;
        }
        rp1.a.e();
        Intent intent = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
        intent.addFlags(268435456);
        context.startActivity(intent);
        return false;
    }

    public final boolean z(@NotNull String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return g().containsKey(address);
    }
}

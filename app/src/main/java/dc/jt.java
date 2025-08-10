package dc;

import java.util.HashMap;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: BleConstans.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/component/dxbluetooth/lib/data/BleConstans;", "", "()V", "Companion", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class jt {

    @NotNull
    public static final c a = new c(null);
    public static final UUID b = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");

    @NotNull
    public static final Lazy<HashMap<String, String>> c = LazyKt__LazyJVMKt.lazy(b.a);

    @NotNull
    public static final Lazy<HashMap<String, String>> d = LazyKt__LazyJVMKt.lazy(a.a);

    /* compiled from: BleConstans.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a extends Lambda implements Function0<HashMap<String, String>> {
        public static final a a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final HashMap<String, String> invoke() {
            HashMap<String, String> map = new HashMap<>();
            map.put("00002A43-0000-1000-8000-00805F9B34FB", "Alert Category ID");
            map.put("00002A42-0000-1000-8000-00805F9B34FB", "Alert Category ID Bit Mask");
            map.put("00002A06-0000-1000-8000-00805F9B34FB", "Alert Level");
            map.put("00002A44-0000-1000-8000-00805F9B34FB", "Alert Notification Control Point");
            map.put("00002A3F-0000-1000-8000-00805F9B34FB", "Alert Status");
            map.put("00002A01-0000-1000-8000-00805F9B34FB", "Appearance");
            map.put("00002A19-0000-1000-8000-00805F9B34FB", "Battery Level");
            map.put("00002A49-0000-1000-8000-00805F9B34FB", "Blood Pressure Feature");
            map.put("00002A35-0000-1000-8000-00805F9B34FB", "Blood Pressure Measurement");
            map.put("00002A38-0000-1000-8000-00805F9B34FB", "Body Sensor Location");
            map.put("00002A22-0000-1000-8000-00805F9B34FB", "Boot Keyboard Input Report");
            map.put("00002A32-0000-1000-8000-00805F9B34FB", "Boot Keyboard Output Report");
            map.put("00002A33-0000-1000-8000-00805F9B34FB", "Boot Mouse Input Report");
            map.put("00002A5C-0000-1000-8000-00805F9B34FB", "CSC Feature");
            map.put("00002A5B-0000-1000-8000-00805F9B34FB", "CSC Measurement");
            map.put("00002A2B-0000-1000-8000-00805F9B34FB", "Current Time");
            map.put("00002A66-0000-1000-8000-00805F9B34FB", "Cycling Power Control Point");
            map.put("00002A65-0000-1000-8000-00805F9B34FB", "Cycling Power Feature");
            map.put("00002A63-0000-1000-8000-00805F9B34FB", "Cycling Power Measurement");
            map.put("00002A64-0000-1000-8000-00805F9B34FB", "Cycling Power Vector");
            map.put("00002A08-0000-1000-8000-00805F9B34FB", "Date Time");
            map.put("00002A0A-0000-1000-8000-00805F9B34FB", "Day Date Time");
            map.put("00002A09-0000-1000-8000-00805F9B34FB", "Day of Week");
            map.put("00002A00-0000-1000-8000-00805F9B34FB", "Device Name");
            map.put("00002A0D-0000-1000-8000-00805F9B34FB", "DST Offset");
            map.put("00002A0C-0000-1000-8000-00805F9B34FB", "Exact Time 256");
            map.put("00002A26-0000-1000-8000-00805F9B34FB", "Firmware Revision String");
            map.put("00002A51-0000-1000-8000-00805F9B34FB", "Glucose Feature");
            map.put("00002A18-0000-1000-8000-00805F9B34FB", "Glucose Measurement");
            map.put("00002A34-0000-1000-8000-00805F9B34FB", "Glucose Measurement Context");
            map.put("00002A27-0000-1000-8000-00805F9B34FB", "Hardware Revision String");
            map.put("00002A39-0000-1000-8000-00805F9B34FB", "Heart Rate Control Point");
            map.put("00002A37-0000-1000-8000-00805F9B34FB", "Heart Rate Measurement");
            map.put("00002A4C-0000-1000-8000-00805F9B34FB", "HID Control Point");
            map.put("00002A4A-0000-1000-8000-00805F9B34FB", "HID Information");
            map.put("00002A2A-0000-1000-8000-00805F9B34FB", "IEEE 11073-20601 Regulatory Certification Data List");
            map.put("00002A36-0000-1000-8000-00805F9B34FB", "Intermediate Cuff Pressure");
            map.put("00002A1E-0000-1000-8000-00805F9B34FB", "Intermediate Temperature");
            map.put("00002A6B-0000-1000-8000-00805F9B34FB", "LN Control Point");
            map.put("00002A6A-0000-1000-8000-00805F9B34FB", "LN Feature");
            map.put("00002A0F-0000-1000-8000-00805F9B34FB", "Local Time Information");
            map.put("00002A67-0000-1000-8000-00805F9B34FB", "Location and Speed");
            map.put("00002A29-0000-1000-8000-00805F9B34FB", "Manufacturer Name String");
            map.put("00002A21-0000-1000-8000-00805F9B34FB", "Measurement Interval");
            map.put("00002A24-0000-1000-8000-00805F9B34FB", "Model Number String");
            map.put("00002A68-0000-1000-8000-00805F9B34FB", "Navigation");
            map.put("00002A46-0000-1000-8000-00805F9B34FB", "New Alert");
            map.put("00002A04-0000-1000-8000-00805F9B34FB", "Peripheral Preferred Connection Parameters");
            map.put("00002A02-0000-1000-8000-00805F9B34FB", "Peripheral Privacy Flag");
            map.put("00002A50-0000-1000-8000-00805F9B34FB", "PnP ID");
            map.put("00002A69-0000-1000-8000-00805F9B34FB", "Position Quality");
            map.put("00002A4E-0000-1000-8000-00805F9B34FB", "Protocol Mode");
            map.put("00002A03-0000-1000-8000-00805F9B34FB", "Reconnection Address");
            map.put("00002A52-0000-1000-8000-00805F9B34FB", "Record Access Control Point");
            map.put("00002A14-0000-1000-8000-00805F9B34FB", "Reference Time Information");
            map.put("00002A4D-0000-1000-8000-00805F9B34FB", "Report");
            map.put("00002A4B-0000-1000-8000-00805F9B34FB", "Report Map");
            map.put("00002A40-0000-1000-8000-00805F9B34FB", "Ringer Control Point");
            map.put("00002A41-0000-1000-8000-00805F9B34FB", "Ringer Setting");
            map.put("00002A54-0000-1000-8000-00805F9B34FB", "RSC Feature");
            map.put("00002A53-0000-1000-8000-00805F9B34FB", "RSC Measurement");
            map.put("00002A55-0000-1000-8000-00805F9B34FB", "SC Control Point");
            map.put("00002A4F-0000-1000-8000-00805F9B34FB", "Scan Interval Window");
            map.put("00002A31-0000-1000-8000-00805F9B34FB", "Scan Refresh");
            map.put("00002A5D-0000-1000-8000-00805F9B34FB", "Sensor Location");
            map.put("00002A25-0000-1000-8000-00805F9B34FB", "Serial Number String");
            map.put("00002A05-0000-1000-8000-00805F9B34FB", "Service Changed");
            map.put("00002A28-0000-1000-8000-00805F9B34FB", "Software Revision String");
            map.put("00002A47-0000-1000-8000-00805F9B34FB", "Supported New Alert Category");
            map.put("00002A48-0000-1000-8000-00805F9B34FB", "Supported Unread Alert Category");
            map.put("00002A23-0000-1000-8000-00805F9B34FB", "System ID");
            map.put("00002A1C-0000-1000-8000-00805F9B34FB", "Temperature Measurement");
            map.put("00002A1D-0000-1000-8000-00805F9B34FB", "Temperature Type");
            map.put("00002A12-0000-1000-8000-00805F9B34FB", "Time Accuracy");
            map.put("00002A13-0000-1000-8000-00805F9B34FB", "Time Source");
            map.put("00002A16-0000-1000-8000-00805F9B34FB", "Time Update Control Point");
            map.put("00002A17-0000-1000-8000-00805F9B34FB", "Time Update State");
            map.put("00002A11-0000-1000-8000-00805F9B34FB", "Time with DST");
            map.put("00002A0E-0000-1000-8000-00805F9B34FB", "Time Zone");
            map.put("00002A07-0000-1000-8000-00805F9B34FB", "Tx Power Level");
            map.put("00002A45-0000-1000-8000-00805F9B34FB", "Unread Alert Status");
            return map;
        }
    }

    /* compiled from: BleConstans.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class b extends Lambda implements Function0<HashMap<String, String>> {
        public static final b a = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final HashMap<String, String> invoke() {
            HashMap<String, String> map = new HashMap<>();
            map.put("00001811-0000-1000-8000-00805F9B34FB", "Alert Notification Service");
            map.put("0000180F-0000-1000-8000-00805F9B34FB", "Battery Service");
            map.put("00001810-0000-1000-8000-00805F9B34FB", "Blood Pressure");
            map.put("00001805-0000-1000-8000-00805F9B34FB", "Current Time Service");
            map.put("00001818-0000-1000-8000-00805F9B34FB", "Cycling Power");
            map.put("00001816-0000-1000-8000-00805F9B34FB", "Cycling Speed and Cadence");
            map.put("0000180A-0000-1000-8000-00805F9B34FB", "Device Information");
            map.put("00001800-0000-1000-8000-00805F9B34FB", "Generic Access");
            map.put("00001801-0000-1000-8000-00805F9B34FB", "Generic Attribute");
            map.put("00001808-0000-1000-8000-00805F9B34FB", "Glucose");
            map.put("00001809-0000-1000-8000-00805F9B34FB", "Health Thermometer");
            map.put("0000180D-0000-1000-8000-00805F9B34FB", "Heart Rate");
            map.put("00001812-0000-1000-8000-00805F9B34FB", "Human Interface Device");
            map.put("00001802-0000-1000-8000-00805F9B34FB", "Immediate Alert");
            map.put("00001803-0000-1000-8000-00805F9B34FB", "Link Loss");
            map.put("00001819-0000-1000-8000-00805F9B34FB", "Location and Navigation");
            map.put("00001807-0000-1000-8000-00805F9B34FB", "Next DST Change Service");
            map.put("0000180E-0000-1000-8000-00805F9B34FB", "Phone Alert Status Service");
            map.put("00001806-0000-1000-8000-00805F9B34FB", "Reference Time Update Service");
            map.put("00001814-0000-1000-8000-00805F9B34FB", "Running Speed and Cadence");
            map.put("00001813-0000-1000-8000-00805F9B34FB", "Scan Parameters");
            map.put("00001804-0000-1000-8000-00805F9B34FB", "Tx Power");
            return map;
        }
    }

    /* compiled from: BleConstans.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R'\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u0019\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/component/dxbluetooth/lib/data/BleConstans$Companion;", "", "()V", "BLE_CHARACTERISTICS", "", "", "getBLE_CHARACTERISTICS", "()Ljava/util/Map;", "BLE_CHARACTERISTICS$delegate", "Lkotlin/Lazy;", "BLE_SERVICES", "getBLE_SERVICES", "BLE_SERVICES$delegate", "CLIENT_CHARACTERISTIC_CONFIG", "Ljava/util/UUID;", "kotlin.jvm.PlatformType", "getCLIENT_CHARACTERISTIC_CONFIG", "()Ljava/util/UUID;", "LVS_ID", "hytto-apps.android.components.core:dxbluetooth"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c {
        public c() {
        }

        public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UUID a() {
            return jt.b;
        }
    }
}

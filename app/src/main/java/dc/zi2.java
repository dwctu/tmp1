package dc;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.os.Build;
import android.os.Handler;
import android.os.ParcelUuid;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.vending.expansion.downloader.Constants;
import com.wear.main.toy.ToyDfuActivity;
import com.wear.util.WearUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import no.nordicsemi.android.dfu.DfuBaseService;
import no.nordicsemi.android.support.v18.scanner.BluetoothLeScannerCompat;
import no.nordicsemi.android.support.v18.scanner.ScanCallback;
import no.nordicsemi.android.support.v18.scanner.ScanFilter;
import no.nordicsemi.android.support.v18.scanner.ScanResult;
import no.nordicsemi.android.support.v18.scanner.ScanSettings;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: OneKeyUpload.java */
/* loaded from: classes3.dex */
public class zi2 {
    public static BluetoothAdapter a;
    public static ParcelUuid b;
    public static c e;
    public static String f;
    public static String g;
    public static String h;
    public static boolean i;
    public static final Handler c = new Handler();
    public static boolean d = false;
    public static ScanCallback j = new b();

    /* compiled from: OneKeyUpload.java */
    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            String str = "run: isDestroy=" + zi2.e;
            if (zi2.d) {
                zi2.m();
                if (zi2.e != null) {
                    zi2.e.a(null);
                }
            }
        }
    }

    /* compiled from: OneKeyUpload.java */
    public class b extends ScanCallback {
        @Override // no.nordicsemi.android.support.v18.scanner.ScanCallback
        public void onBatchScanResults(List<ScanResult> list) {
            String str = "";
            for (ScanResult scanResult : list) {
                if (!WearUtils.e1(scanResult.getDevice().getName())) {
                    str = str + scanResult.getDevice().getName() + ",";
                }
            }
            Iterator<ScanResult> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ScanResult next = it.next();
                if (!WearUtils.e1(next.getDevice().getName())) {
                    if (zi2.i ? next.getDevice().getAddress().equals(zi2.f) : next.getDevice().getAddress().equals(zi2.f) || next.getDevice().getName().toLowerCase().startsWith(zi2.g) || next.getDevice().getName().toLowerCase().startsWith("new") || next.getDevice().getName().toLowerCase().startsWith(zi2.h)) {
                        zi2.e.a(new yi2(next).a);
                        zi2.m();
                        sp1.g(next.getDevice().getName() + Constants.FILENAME_SEQUENCE_SEPARATOR + zi2.f);
                        break;
                    }
                }
            }
            sp1.h("扫描结果:" + list.size() + ", deviceName:" + str);
        }

        @Override // no.nordicsemi.android.support.v18.scanner.ScanCallback
        public void onScanFailed(int i) {
            sp1.c("sdk 扫描失败+" + i);
            zi2.e.a(null);
        }

        @Override // no.nordicsemi.android.support.v18.scanner.ScanCallback
        public void onScanResult(int i, ScanResult scanResult) {
        }
    }

    /* compiled from: OneKeyUpload.java */
    public interface c {
        void a(BluetoothDevice bluetoothDevice);
    }

    public static void h(ToyDfuActivity toyDfuActivity, c cVar) {
        e = cVar;
        try {
            f = toyDfuActivity.b;
            String lowerCase = toyDfuActivity.c.toLowerCase();
            g = lowerCase;
            i = toyDfuActivity.s;
            if (!lowerCase.equals("toya") && !g.equals("toyb") && !toyDfuActivity.s) {
                f = j(f);
            }
            g = DfuBaseService.NOTIFICATION_CHANNEL_DFU + g;
            h = WearUtils.e1(toyDfuActivity.d) ? "!@#$%^&" : "dfu-" + toyDfuActivity.d.toLowerCase();
            System.out.println("address:" + f + "  name:" + g + " dfuToyNameKey:" + h);
            ye3.d("Z0009", "address:" + f + "  name:" + g + " dfuToyNameKey:" + h);
            BluetoothAdapter adapter = ((BluetoothManager) toyDfuActivity.getSystemService("bluetooth")).getAdapter();
            a = adapter;
            for (BluetoothDevice bluetoothDevice : adapter.getBondedDevices()) {
                if (bluetoothDevice != null) {
                    String lowerCase2 = "";
                    String address = TextUtils.isEmpty(bluetoothDevice.getAddress()) ? "" : bluetoothDevice.getAddress();
                    if (!TextUtils.isEmpty(bluetoothDevice.getName())) {
                        lowerCase2 = bluetoothDevice.getName().toLowerCase();
                    }
                    System.out.println("device.getAddress()" + address + " name=" + lowerCase2);
                }
            }
            l(toyDfuActivity);
        } catch (Exception e2) {
            ye3.d("Z0011", "action error:" + e2.getMessage());
            e2.printStackTrace();
        }
    }

    public static String i(String str) {
        if ("FF".equals(str)) {
            return "00";
        }
        String upperCase = Integer.toString(Integer.valueOf(str, 16).intValue() + 1, 16).toUpperCase();
        if (upperCase.length() != 1) {
            return upperCase;
        }
        return "0" + upperCase;
    }

    public static String j(String str) {
        String[] strArrSplit = str.split(SignatureImpl.INNER_SEP);
        for (int i2 = 5; i2 >= 0; i2--) {
            String strI = i(strArrSplit[i2]);
            strArrSplit[i2] = strI;
            if (!"00".equals(strI)) {
                break;
            }
        }
        return k(strArrSplit, SignatureImpl.INNER_SEP);
    }

    public static String k(String[] strArr, String str) {
        String str2 = null;
        for (String str3 : strArr) {
            str2 = str2 == null ? str3 : str2 + str + str3;
        }
        return str2;
    }

    public static void l(ToyDfuActivity toyDfuActivity) {
        if (Build.VERSION.SDK_INT >= 31) {
            if (ContextCompat.checkSelfPermission(toyDfuActivity, "android.permission.BLUETOOTH_SCAN") != 0) {
                return;
            }
        } else if (ContextCompat.checkSelfPermission(toyDfuActivity, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            return;
        }
        BluetoothLeScannerCompat scanner = BluetoothLeScannerCompat.getScanner();
        ScanSettings scanSettingsBuild = new ScanSettings.Builder().setScanMode(2).setReportDelay(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS).setUseHardwareBatchingIfSupported(false).build();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ScanFilter.Builder().setServiceUuid(b).build());
        ye3.d("Z0010", "startScan");
        scanner.startScan(arrayList, scanSettingsBuild, j);
        d = true;
        Handler handler = c;
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(new a(), 30000L);
    }

    public static void m() {
        if (d) {
            BluetoothLeScannerCompat.getScanner().stopScan(j);
            d = false;
            ye3.d("Z0012", "stopScan");
        }
    }
}

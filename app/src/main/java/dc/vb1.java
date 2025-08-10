package dc;

import android.bluetooth.BluetoothDevice;
import androidx.annotation.NonNull;

/* compiled from: RssiDevice.java */
/* loaded from: classes3.dex */
public class vb1 implements Comparable<vb1> {
    public BluetoothDevice a;
    public int b;
    public int c = 1;

    public vb1(BluetoothDevice bluetoothDevice, int i, String str, String str2, String str3) {
        this.b = -1;
        this.a = bluetoothDevice;
        this.b = i;
    }

    public void a() {
        this.c++;
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull vb1 vb1Var) {
        if (this.b > vb1Var.e()) {
            return -1;
        }
        return this.b < vb1Var.e() ? 1 : 0;
    }

    public int c() {
        return this.c;
    }

    public BluetoothDevice d() {
        return this.a;
    }

    public int e() {
        return this.b;
    }

    public void f(int i) {
        this.b = i;
    }
}

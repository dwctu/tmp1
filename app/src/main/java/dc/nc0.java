package dc;

import android.bluetooth.BluetoothGattService;
import android.text.TextUtils;
import androidx.multidex.MultiDexExtractor;
import com.component.dxtoy.core.bluetooth.bean.ToyBtDeviceBean;
import com.component.dxtoy.update.bean.ToyUpdateRespBean;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;

/* compiled from: ToyFirmwareUpdate.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ \u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J(\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\r\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u001b\u001a\u00020\u000bJ\u001e\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/component/dxtoy/update/ToyFirmwareUpdate;", "", "()V", "S43_UUID", "", "UPDATE_RESULT_DEVICE_DISCONNECT", "UPDATE_RESULT_FILE_MD5_ERR", "UPDATE_RESULT_NO_FOUND_URL", "UPDATE_RESULT_NO_NEED", "firmwareDir", "closeUpdate", "", "doFirmwareUpdate", MultipleAddresses.Address.ELEMENT, "file", "Ljava/io/File;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/component/dxtoy/update/UpdateListener;", "firmwareDownload", "updateData", "Lcom/component/dxtoy/update/bean/ToyUpdateRespBean;", "filePath", "getConnectedDevice", "Lcom/component/dxtoy/core/toy/ToyInfo;", "deviceAddress", "isSupportOTA", "", "openUpdate", "updateFirmware", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class nc0 {

    @NotNull
    public static final nc0 a = new nc0();

    @NotNull
    public static final String b = ge0.f() + "/wear/cache";

    /* compiled from: ToyFirmwareUpdate.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"com/component/dxtoy/update/ToyFirmwareUpdate$firmwareDownload$1", "Lcom/component/dxtoy/update/DownloadListener;", "onDownloadProgress", "", "fileLength", "", "progress", "onResult", "isSuccess", "", "errMsg", "", "toy_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements lc0 {
        public final /* synthetic */ oc0 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ToyUpdateRespBean c;
        public final /* synthetic */ String d;

        public a(oc0 oc0Var, String str, ToyUpdateRespBean toyUpdateRespBean, String str2) {
            this.a = oc0Var;
            this.b = str;
            this.c = toyUpdateRespBean;
            this.d = str2;
        }

        @Override // dc.lc0
        public void a(boolean z, @Nullable String str) {
            if (!z) {
                this.a.a(false, str);
                return;
            }
            File file = new File(this.b);
            String md5 = this.c.getMd5();
            if (file.exists() && !TextUtils.isEmpty(md5)) {
                String strO = vd0.o(file);
                if (StringsKt__StringsJVMKt.equals(md5, strO, true)) {
                    this.a.b(100);
                    nc0.a.c(this.d, file, this.a);
                    return;
                }
                hx.d("toy update download file", "downloader file md5 is error, delete file and return", new Object[0]);
                de0.l("The file md5 is error md5FromServer = " + md5 + " ;fileMd5 = " + strO);
                file.delete();
            }
            this.a.a(false, "The md5 of firmware-file is error");
        }

        @Override // dc.lc0
        public void b(int i, int i2) {
            this.a.b(i2);
        }
    }

    public static final void d(String address, File file, oc0 listener) {
        Intrinsics.checkNotNullParameter(address, "$address");
        Intrinsics.checkNotNullParameter(file, "$file");
        Intrinsics.checkNotNullParameter(listener, "$listener");
        if (a.g(address)) {
            wc0.a.j(file, address, listener);
        } else {
            qc0.a.h(file, address, null, listener);
        }
    }

    public final void b() {
        hb0.a.j(false);
    }

    public final void c(final String str, final File file, final oc0 oc0Var) {
        se0.c().execute(new Runnable() { // from class: dc.ic0
            @Override // java.lang.Runnable
            public final void run() {
                nc0.d(str, file, oc0Var);
            }
        });
    }

    public final void e(String str, ToyUpdateRespBean toyUpdateRespBean, String str2, oc0 oc0Var) {
        String url = toyUpdateRespBean.getUrl();
        if (url == null || url.length() == 0) {
            oc0Var.a(false, "No found url of firmware to download");
        } else {
            mc0.a.a(url, str2, new a(oc0Var, str2, toyUpdateRespBean, str));
        }
    }

    @Nullable
    public final nb0 f(@Nullable String str) {
        return hb0.a.e().get(str);
    }

    public final boolean g(@Nullable String str) {
        List<BluetoothGattService> serviceList;
        ToyBtDeviceBean toyBtDeviceBean = hb0.a.c().get(str);
        if (toyBtDeviceBean == null || (serviceList = toyBtDeviceBean.getServiceList()) == null) {
            return false;
        }
        if ((serviceList instanceof Collection) && serviceList.isEmpty()) {
            return false;
        }
        Iterator<T> it = serviceList.iterator();
        while (it.hasNext()) {
            if (StringsKt__StringsJVMKt.equals(((BluetoothGattService) it.next()).getUuid().toString(), "1D14D6EE-FD63-4FA1-BFA4-8F47B42119F0", true)) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        hb0.a.j(true);
    }

    public final void j(@NotNull String address, @NotNull ToyUpdateRespBean updateData, @NotNull oc0 listener) {
        byte[] bytes;
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(updateData, "updateData");
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (Intrinsics.areEqual(updateData.getHasUpdate(), Boolean.FALSE)) {
            listener.a(false, "No need to update firmware");
            return;
        }
        String url = updateData.getUrl();
        if (TextUtils.isEmpty(url)) {
            listener.a(false, "No found url of firmware to download");
            return;
        }
        i();
        String str = g(address) ? ".gbl" : MultiDexExtractor.EXTRACTED_SUFFIX;
        StringBuilder sb = new StringBuilder();
        if (url != null) {
            bytes = url.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        } else {
            bytes = null;
        }
        sb.append(sd0.b(bytes));
        sb.append(str);
        String string = sb.toString();
        de0.v("base64 fileName == " + string);
        String strC = sd0.c(string);
        Intrinsics.checkNotNullExpressionValue(strC, "urlEncode(fileName)");
        de0.v("urlEncode fileName == " + strC);
        File file = new File(b, strC);
        String md5 = updateData.getMd5();
        if (file.exists()) {
            String strO = vd0.o(file);
            if (!TextUtils.isEmpty(md5) && StringsKt__StringsJVMKt.equals(md5, strO, true)) {
                listener.b(100);
                c(address, file, listener);
                return;
            }
            file.delete();
            de0.l("The exist file md5 is error md5FromServer = " + md5 + " ;fileMd5 = " + strO);
        }
        vd0.b(file);
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
        e(address, updateData, absolutePath, listener);
    }
}

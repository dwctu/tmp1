package dc;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.broadcom.bt.util.io.IOUtils;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.wear.bean.socketio.msg.BaseSocketIoRec;
import com.wear.bean.socketio.msg.MsgRecReceipt;

/* compiled from: BaseListener.java */
/* loaded from: classes3.dex */
public abstract class nf2 implements of2 {
    @Override // dc.pw3.a
    public void call(Object... objArr) {
        String str = "";
        if (objArr.length > 0) {
            for (Object obj : objArr) {
                try {
                    str = str + obj.toString();
                } catch (Exception e) {
                    FirebaseCrashlytics.getInstance().recordException(e);
                }
            }
            try {
                BaseSocketIoRec baseSocketIoRec = (BaseSocketIoRec) JSON.parseObject(objArr[0].toString(), BaseSocketIoRec.class);
                if (baseSocketIoRec.requestReceipt && !TextUtils.isEmpty(baseSocketIoRec.requestId)) {
                    MsgRecReceipt msgRecReceipt = new MsgRecReceipt();
                    msgRecReceipt.processed = true;
                    msgRecReceipt.requestType = baseSocketIoRec.requestType;
                    msgRecReceipt.receiveId = baseSocketIoRec.requestId;
                    msgRecReceipt.serverTime = System.currentTimeMillis();
                    uf2.v().E(msgRecReceipt);
                }
                a(objArr[0].toString());
            } catch (Exception unused) {
                a(objArr[0].toString());
            } catch (Throwable th) {
                try {
                    a(objArr[0].toString());
                } catch (Exception e2) {
                    FirebaseCrashlytics.getInstance().recordException(e2);
                }
                throw th;
            }
            StringBuilder sb = new StringBuilder();
            for (Object obj2 : objArr) {
                sb.append(obj2.toString());
                sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            b(sb.toString());
        } else {
            try {
                a("");
            } catch (Exception e3) {
                FirebaseCrashlytics.getInstance().recordException(e3);
            }
        }
        xe3.b(uf2.i, getClass().getSimpleName(), str);
    }
}

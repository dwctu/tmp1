package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.AmazonS3;
import com.j256.ormlite.field.FieldType;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class TransferNetworkLossHandler extends BroadcastReceiver {
    public static final Log d = LogFactory.b(TransferNetworkLossHandler.class);
    public static TransferNetworkLossHandler e;
    public final ConnectivityManager a;
    public TransferDBUtil b;
    public TransferStatusUpdater c;

    public TransferNetworkLossHandler(Context context) {
        this.a = (ConnectivityManager) context.getSystemService("connectivity");
        this.b = new TransferDBUtil(context);
        this.c = TransferStatusUpdater.c(context);
    }

    public static synchronized TransferNetworkLossHandler c() throws TransferUtilityException {
        TransferNetworkLossHandler transferNetworkLossHandler;
        transferNetworkLossHandler = e;
        if (transferNetworkLossHandler == null) {
            d.d("TransferNetworkLossHandler is not created. Please call `TransferNetworkLossHandler.getInstance(Context)` to instantiate it before retrieving");
            throw new TransferUtilityException("TransferNetworkLossHandler is not created. Please call `TransferNetworkLossHandler.getInstance(Context)` to instantiate it before retrieving");
        }
        return transferNetworkLossHandler;
    }

    public static synchronized TransferNetworkLossHandler d(Context context) {
        if (e == null) {
            e = new TransferNetworkLossHandler(context);
        }
        return e;
    }

    public boolean e() {
        NetworkInfo activeNetworkInfo = this.a.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public final synchronized void f() {
        for (TransferRecord transferRecord : this.c.e().values()) {
            AmazonS3 amazonS3A = S3ClientReference.a(Integer.valueOf(transferRecord.a));
            if (amazonS3A != null && transferRecord != null && transferRecord.h(amazonS3A, this.c, this.a)) {
                this.c.l(transferRecord.a, TransferState.WAITING_FOR_NETWORK);
            }
        }
    }

    public final synchronized void g() {
        TransferRecord transferRecordD;
        int i = 0;
        TransferState[] transferStateArr = {TransferState.WAITING_FOR_NETWORK};
        d.a("Loading transfers from database...");
        Cursor cursorO = null;
        ArrayList<Integer> arrayList = new ArrayList();
        try {
            cursorO = this.b.o(TransferType.ANY, transferStateArr);
            while (cursorO.moveToNext()) {
                int i2 = cursorO.getInt(cursorO.getColumnIndexOrThrow(FieldType.FOREIGN_ID_FIELD_SUFFIX));
                if (this.c.d(i2) == null) {
                    TransferRecord transferRecord = new TransferRecord(i2);
                    transferRecord.j(cursorO);
                    this.c.b(transferRecord);
                    i++;
                }
                arrayList.add(Integer.valueOf(i2));
            }
            try {
                for (Integer num : arrayList) {
                    AmazonS3 amazonS3A = S3ClientReference.a(num);
                    if (amazonS3A != null && (transferRecordD = this.c.d(num.intValue())) != null && !transferRecordD.f()) {
                        transferRecordD.i(amazonS3A, this.b, this.c, this.a);
                    }
                }
            } catch (Exception e2) {
                d.d("Error in resuming the transfers." + e2.getMessage());
            }
            d.a(i + " transfers are loaded from database.");
        } finally {
            if (cursorO != null) {
                d.a("Closing the cursor for resumeAllTransfers");
                cursorO.close();
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            Log log = d;
            log.b("Network connectivity changed detected.");
            log.b("Network connected: " + e());
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferNetworkLossHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TransferNetworkLossHandler.this.e()) {
                        TransferNetworkLossHandler.this.g();
                    } else {
                        TransferNetworkLossHandler.this.f();
                    }
                }
            }).start();
        }
    }
}

package com.component.dxutilcode.lib.utils;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import dc.ee0;
import dc.xe0;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class MessengerUtils {
    public static ConcurrentHashMap<String, a> a = new ConcurrentHashMap<>();

    public static class ServerService extends Service {
        public final ConcurrentHashMap<Integer, Messenger> a = new ConcurrentHashMap<>();

        @SuppressLint({"HandlerLeak"})
        public final Handler b;
        public final Messenger c;

        public class a extends Handler {
            public a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) throws RemoteException {
                int i = message.what;
                if (i == 0) {
                    ServerService.this.a.put(Integer.valueOf(message.arg1), message.replyTo);
                    return;
                }
                if (i == 1) {
                    ServerService.this.a.remove(Integer.valueOf(message.arg1));
                } else if (i != 2) {
                    super.handleMessage(message);
                } else {
                    ServerService.this.e(message);
                    ServerService.this.d(message);
                }
            }
        }

        public ServerService() {
            a aVar = new a();
            this.b = aVar;
            this.c = new Messenger(aVar);
        }

        public final void d(Message message) {
            String string;
            a aVar;
            Bundle data = message.getData();
            if (data == null || (string = data.getString("MESSENGER_UTILS")) == null || (aVar = (a) MessengerUtils.a.get(string)) == null) {
                return;
            }
            aVar.a(data);
        }

        public final void e(Message message) throws RemoteException {
            Message messageObtain = Message.obtain(message);
            for (Messenger messenger : this.a.values()) {
                if (messenger != null) {
                    try {
                        messenger.send(Message.obtain(messageObtain));
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
            messageObtain.recycle();
        }

        @Override // android.app.Service
        @Nullable
        public IBinder onBind(Intent intent) {
            return this.c.getBinder();
        }

        @Override // android.app.Service
        public int onStartCommand(Intent intent, int i, int i2) throws RemoteException {
            Bundle extras;
            if (Build.VERSION.SDK_INT >= 26) {
                startForeground(1, xe0.w(ee0.a.b, null));
            }
            if (intent != null && (extras = intent.getExtras()) != null) {
                Message messageObtain = Message.obtain(this.b, 2);
                messageObtain.replyTo = this.c;
                messageObtain.setData(extras);
                e(messageObtain);
                d(messageObtain);
            }
            return 2;
        }
    }

    public interface a {
        void a(Bundle bundle);
    }

    static {
        new HashMap();
    }
}

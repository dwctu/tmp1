package com.google.android.vending.expansion.downloader;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.google.android.vending.expansion.downloader.impl.DownloaderService;

/* loaded from: classes2.dex */
public class DownloaderClientMarshaller {
    public static final int DOWNLOAD_REQUIRED = 2;
    public static final int LVL_CHECK_REQUIRED = 1;
    public static final int MSG_ONDOWNLOADPROGRESS = 11;
    public static final int MSG_ONDOWNLOADSTATE_CHANGED = 10;
    public static final int MSG_ONSERVICECONNECTED = 12;
    public static final int NO_DOWNLOAD_REQUIRED = 0;
    public static final String PARAM_MESSENGER = "EMH";
    public static final String PARAM_NEW_STATE = "newState";
    public static final String PARAM_PROGRESS = "progress";

    public static class Proxy implements IDownloaderClient {
        private Messenger mServiceMessenger;

        public Proxy(Messenger messenger) {
            this.mServiceMessenger = messenger;
        }

        private void send(int i, Bundle bundle) throws RemoteException {
            Message messageObtain = Message.obtain((Handler) null, i);
            messageObtain.setData(bundle);
            try {
                this.mServiceMessenger.send(messageObtain);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override // com.google.android.vending.expansion.downloader.IDownloaderClient
        public void onDownloadProgress(DownloadProgressInfo downloadProgressInfo) throws RemoteException {
            Bundle bundle = new Bundle(1);
            bundle.putParcelable("progress", downloadProgressInfo);
            send(11, bundle);
        }

        @Override // com.google.android.vending.expansion.downloader.IDownloaderClient
        public void onDownloadStateChanged(int i) throws RemoteException {
            Bundle bundle = new Bundle(1);
            bundle.putInt(DownloaderClientMarshaller.PARAM_NEW_STATE, i);
            send(10, bundle);
        }

        @Override // com.google.android.vending.expansion.downloader.IDownloaderClient
        public void onServiceConnected(Messenger messenger) {
        }
    }

    public static class Stub implements IStub {
        private boolean mBound;
        private Context mContext;
        private Class<?> mDownloaderServiceClass;
        private IDownloaderClient mItf;
        private Messenger mServiceMessenger;
        public final Messenger mMessenger = new Messenger(new Handler() { // from class: com.google.android.vending.expansion.downloader.DownloaderClientMarshaller.Stub.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 10:
                        Stub.this.mItf.onDownloadStateChanged(message.getData().getInt(DownloaderClientMarshaller.PARAM_NEW_STATE));
                        break;
                    case 11:
                        Bundle data = message.getData();
                        if (Stub.this.mContext != null) {
                            data.setClassLoader(Stub.this.mContext.getClassLoader());
                            Stub.this.mItf.onDownloadProgress((DownloadProgressInfo) message.getData().getParcelable("progress"));
                            break;
                        }
                        break;
                    case 12:
                        Stub.this.mItf.onServiceConnected((Messenger) message.getData().getParcelable("EMH"));
                        break;
                }
            }
        });
        private ServiceConnection mConnection = new ServiceConnection() { // from class: com.google.android.vending.expansion.downloader.DownloaderClientMarshaller.Stub.2
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Stub.this.mServiceMessenger = new Messenger(iBinder);
                Stub.this.mItf.onServiceConnected(Stub.this.mServiceMessenger);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Stub.this.mServiceMessenger = null;
            }
        };

        public Stub(IDownloaderClient iDownloaderClient, Class<?> cls) {
            this.mItf = null;
            this.mItf = iDownloaderClient;
            this.mDownloaderServiceClass = cls;
        }

        @Override // com.google.android.vending.expansion.downloader.IStub
        public void connect(Context context) {
            this.mContext = context;
            Intent intent = new Intent(context, this.mDownloaderServiceClass);
            intent.putExtra("EMH", this.mMessenger);
            if (context.bindService(intent, this.mConnection, 2)) {
                this.mBound = true;
            }
        }

        @Override // com.google.android.vending.expansion.downloader.IStub
        public void disconnect(Context context) {
            if (this.mBound) {
                context.unbindService(this.mConnection);
                this.mBound = false;
            }
            this.mContext = null;
        }

        @Override // com.google.android.vending.expansion.downloader.IStub
        public Messenger getMessenger() {
            return this.mMessenger;
        }
    }

    public static IDownloaderClient CreateProxy(Messenger messenger) {
        return new Proxy(messenger);
    }

    public static IStub CreateStub(IDownloaderClient iDownloaderClient, Class<?> cls) {
        return new Stub(iDownloaderClient, cls);
    }

    public static int startDownloadServiceIfRequired(Context context, PendingIntent pendingIntent, Class<?> cls) throws PackageManager.NameNotFoundException {
        return DownloaderService.startDownloadServiceIfRequired(context, pendingIntent, cls);
    }

    public static int startDownloadServiceIfRequired(Context context, Intent intent, Class<?> cls) throws PackageManager.NameNotFoundException {
        return DownloaderService.startDownloadServiceIfRequired(context, intent, cls);
    }
}

package com.broadcom.bt.map;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import androidx.exifinterface.media.ExifInterface;
import com.broadcom.bt.map.IBluetoothMapDatasourceCallback;
import com.broadcom.bt.util.StringUtil;
import com.broadcom.bt.util.bmsg.BMessage;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.spotify.sdk.android.player.Config;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* loaded from: classes.dex */
public abstract class BaseDataSource implements BluetoothProfile.ServiceListener {
    public static final int CHARSET_NATIVE = 0;
    public static final int CHARSET_UNKNOWN = 2;
    public static final int CHARSET_UTF_8 = 1;
    public static final byte MSG_RECEPTION_STATUS_COMPLETE = 0;
    public static final byte MSG_RECEPTION_STATUS_FRACTION = 1;
    public static final byte MSG_RECEPTION_STATUS_NOTIFICATION = 2;
    public static final byte MSG_TYPE_EMAIL = 1;
    public static final byte MSG_TYPE_MMS = 8;
    public static final byte MSG_TYPE_SMS_CDMA = 4;
    public static final byte MSG_TYPE_SMS_GSM = 2;
    private static final String TAG = "BtMap.BaseDataSource";
    private static final boolean V = true;
    public BluetoothMapDatasourceCallback mCallback;
    public boolean mCleanupAfterClose;
    public BluetoothDevice mConnectedDevice;
    public ContentResolver mContentResolver;
    public Context mContext;
    public EventHandlerThread mEventHandlerThread;
    public EventReceiver mEventReceiver;
    private boolean mHasClientConnected;
    private boolean mHasClientsRegistered;
    public boolean mIsStarted;
    public BluetoothMap mMapService;
    public String mPendingRequest = null;
    private static final Uri MAP_CONTENT_URI = Uri.parse("content://com.broadcom.bt.map");
    private static final String DEFAULT_TMP_DIR_PATH = "/data/data/com.android.bluetooth/files/map";
    private static final File DEFAULT_TMP_DIR = new File(DEFAULT_TMP_DIR_PATH);
    private static final ArrayList<FolderInfo> EMPTY_FOLDER_LIST = new ArrayList<>(0);
    private static final ArrayList<MessageInfo> EMPTY_MESSAGE_LIST = new ArrayList<>(0);
    public static final SimpleDateFormat DATE_TIME_FORMATTER = new SimpleDateFormat("yyyyMMddHHmmss");

    public class BluetoothMapDatasourceCallback extends IBluetoothMapDatasourceCallback.Stub {
        public BluetoothMapDatasourceCallback() {
        }

        @Override // com.broadcom.bt.map.IBluetoothMapDatasourceCallback
        public void onClientConnectionStateChanged(boolean z) throws RemoteException {
            synchronized (this) {
                BaseDataSource.this.mHasClientConnected = z;
            }
            BaseDataSource.this.mEventHandlerThread.mHandler.setClientConnectionStateChanged(z);
        }

        @Override // com.broadcom.bt.map.IBluetoothMapDatasourceCallback
        public void onClientRegistrationChanged(boolean z) throws RemoteException {
            synchronized (this) {
                BaseDataSource.this.mHasClientsRegistered = z;
            }
        }

        @Override // com.broadcom.bt.map.IBluetoothMapDatasourceCallback
        public void onGetFolderListing(RequestId requestId, String str) throws RemoteException {
            BaseDataSource.this.mEventHandlerThread.mHandler.getFolderListing(requestId, str);
        }

        @Override // com.broadcom.bt.map.IBluetoothMapDatasourceCallback
        public void onGetMessage(RequestId requestId, String str, String str2, String str3, boolean z, byte b) throws RemoteException {
            BaseDataSource.this.mEventHandlerThread.mHandler.getMessage(requestId, str, str2, str3, z, b);
        }

        @Override // com.broadcom.bt.map.IBluetoothMapDatasourceCallback
        public void onGetMessageListing(RequestId requestId, String str, MessageListFilter messageListFilter, long j, boolean z) throws RemoteException {
            BaseDataSource.this.mEventHandlerThread.mHandler.getMsgListing(requestId, str, messageListFilter, j, z);
        }

        @Override // com.broadcom.bt.map.IBluetoothMapDatasourceCallback
        public void onPushMessage(RequestId requestId, String str, String str2, String str3, boolean z, boolean z2, int i) throws RemoteException {
            BaseDataSource.this.mEventHandlerThread.mHandler.pushMessage(requestId, str, str2, str3, z, z2, i);
        }

        @Override // com.broadcom.bt.map.IBluetoothMapDatasourceCallback
        public void onSetMessageStatus(RequestId requestId, String str, int i, boolean z) throws RemoteException {
            BaseDataSource.this.mEventHandlerThread.mHandler.setMessageStatus(requestId, str, i, z);
        }

        @Override // com.broadcom.bt.map.IBluetoothMapDatasourceCallback
        public void onStartCompleted(boolean z) throws RemoteException {
            BaseDataSource.this.mEventHandlerThread.mHandler.onStartCompleted(z);
        }

        @Override // com.broadcom.bt.map.IBluetoothMapDatasourceCallback
        public void onStopCompleted(boolean z) throws RemoteException {
            BaseDataSource.this.mEventHandlerThread.mHandler.onStopCompleted(z);
        }

        @Override // com.broadcom.bt.map.IBluetoothMapDatasourceCallback
        public void onUpdateInbox() throws RemoteException {
            BaseDataSource.this.mEventHandlerThread.mHandler.updateInbox();
        }
    }

    public class EventHandler extends Handler {
        private static final int MSG_DEFER_START = 1000;
        private static final int MSG_DEFER_STOP = 1001;
        private static final int MSG_GET_FOLDER_LISTING = 300;
        private static final int MSG_GET_MSG = 302;
        private static final int MSG_GET_MSG_LISTING = 301;
        private static final int MSG_PUSH_MSG = 200;
        private static final int MSG_SET_MSG_STATUS = 304;
        private static final int MSG_START = 1;
        private static final int MSG_START_COMPLETED = 100;
        private static final int MSG_STOP = 2;
        private static final int MSG_STOP_COMPLETED = 102;
        private static final int MSG_UPDATE_INBOX = 303;
        private static final int PENDING_REQUEST_TIMEOUT = 2000;

        public EventHandler() {
        }

        public synchronized void cancelDeferredStart() {
            removeMessages(1000);
        }

        public synchronized void cancelDeferredStop() {
            removeMessages(1001);
        }

        public void cancelPendingRequestTimeout() {
            removeMessages(2000);
        }

        public synchronized void deferStart() {
            if (!hasMessages(1000, null)) {
                sendMessageDelayed(obtainMessage(1000), 500L);
            }
        }

        public synchronized void deferStop() {
            if (!hasMessages(1001, null)) {
                sendMessageDelayed(obtainMessage(1000), 500L);
            }
        }

        public void getFolderListing(RequestId requestId, String str) {
            Message messageObtainMessage = obtainMessage(MSG_GET_FOLDER_LISTING);
            Bundle data = messageObtainMessage.getData();
            data.putParcelable(StreamManagement.AckRequest.ELEMENT, requestId);
            data.putString("p", str);
            sendMessage(messageObtainMessage);
        }

        public void getMessage(RequestId requestId, String str, String str2, String str3, boolean z, byte b) {
            Message messageObtainMessage = obtainMessage(302);
            Bundle data = messageObtainMessage.getData();
            data.putParcelable(StreamManagement.AckRequest.ELEMENT, requestId);
            data.putString("p", str);
            data.putString(PSOProgramService.VS_Key, str2);
            data.putString("m", str3);
            data.putBoolean("a", z);
            data.putByte("c", b);
            sendMessage(messageObtainMessage);
        }

        public void getMsgListing(RequestId requestId, String str, MessageListFilter messageListFilter, long j, boolean z) {
            Message messageObtainMessage = obtainMessage(301);
            Bundle data = messageObtainMessage.getData();
            data.putParcelable(StreamManagement.AckRequest.ELEMENT, requestId);
            data.putString("p", str);
            data.putBoolean("c", z);
            data.putLong("mp", j);
            messageObtainMessage.obj = messageListFilter;
            sendMessage(messageObtainMessage);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws IOException {
            int i = message.what;
            if (i == 1) {
                BaseDataSource.this.onStart();
                return;
            }
            if (i == 2) {
                BaseDataSource.this.onStop(message.arg1 == 1);
                return;
            }
            BMessage bMessage = null;
            if (i == 100) {
                try {
                    if (message.arg1 == 1) {
                        BaseDataSource.this.onStartError();
                    } else {
                        BaseDataSource.this.onStarted();
                    }
                } catch (Throwable unused) {
                }
                synchronized (BaseDataSource.this) {
                    BaseDataSource.this.mPendingRequest = null;
                    cancelPendingRequestTimeout();
                }
                return;
            }
            if (i != 102) {
                if (i == 200) {
                    Bundle data = message.getData();
                    RequestId requestId = (RequestId) data.getParcelable(StreamManagement.AckRequest.ELEMENT);
                    String string = data.getString("u");
                    String string2 = data.getString("f");
                    try {
                        bMessage = BaseDataSource.this.parseBMessage(string);
                    } catch (Throwable unused2) {
                    }
                    BMessage bMessage2 = bMessage;
                    if (bMessage2 != null) {
                        try {
                            BaseDataSource.this.pushMessage((RequestId) data.getParcelable(StreamManagement.AckRequest.ELEMENT), bMessage2, data.getString("f"), data.getString(PSOProgramService.VS_Key), data.getBoolean("t", false), data.getBoolean("ir", false), data.getInt("c", 0));
                            z = false;
                        } catch (Throwable unused3) {
                        }
                    }
                    if (z) {
                        BaseDataSource.this.setPushMessageResult(requestId, bMessage2, string2, false, "");
                        return;
                    }
                    return;
                }
                if (i == 2000) {
                    synchronized (BaseDataSource.this) {
                        BaseDataSource.this.mPendingRequest = null;
                    }
                    return;
                }
                if (i == 1000) {
                    synchronized (BaseDataSource.this) {
                        BaseDataSource.this.mPendingRequest = BluetoothMap.ACTION_START;
                        startPendingRequestTimeout();
                        BaseDataSource baseDataSource = BaseDataSource.this;
                        baseDataSource.mMapService = BluetoothMap.getProxy(baseDataSource.mContext, baseDataSource);
                    }
                    return;
                }
                if (i != 1001) {
                    try {
                        switch (i) {
                            case MSG_GET_FOLDER_LISTING /* 300 */:
                                Bundle data2 = message.getData();
                                RequestId requestId2 = (RequestId) data2.getParcelable(StreamManagement.AckRequest.ELEMENT);
                                String string3 = data2.getString("p");
                                try {
                                    BaseDataSource.this.getFolderListing(requestId2, string3, null);
                                    return;
                                } catch (Throwable unused4) {
                                    BaseDataSource.this.setFolderListingResult(requestId2, string3, false, null);
                                    return;
                                }
                            case 301:
                                Bundle data3 = message.getData();
                                RequestId requestId3 = (RequestId) data3.getParcelable(StreamManagement.AckRequest.ELEMENT);
                                String string4 = data3.getString("p");
                                boolean z = data3.getBoolean("c", true);
                                MessageListFilter messageListFilter = (MessageListFilter) message.obj;
                                if (messageListFilter == null) {
                                    messageListFilter = new MessageListFilter();
                                }
                                long j = data3.getLong("mp", 0L);
                                if (z) {
                                    try {
                                        BaseDataSource.this.getMsgListingCount(requestId3, string4, messageListFilter, new MessageParameterFilter(j));
                                        return;
                                    } catch (Throwable unused5) {
                                        BaseDataSource.this.setMessageListingCountResult(requestId3, string4, false, 0, false);
                                        return;
                                    }
                                } else {
                                    try {
                                        BaseDataSource.this.getMsgListing(requestId3, string4, messageListFilter, new MessageParameterFilter(j));
                                        return;
                                    } catch (Throwable unused6) {
                                        BaseDataSource.this.setMessageListingResult(requestId3, string4, false, null);
                                        return;
                                    }
                                }
                            case 302:
                                Bundle data4 = message.getData();
                                RequestId requestId4 = (RequestId) data4.getParcelable(StreamManagement.AckRequest.ELEMENT);
                                String string5 = data4.getString("m");
                                try {
                                    BaseDataSource.this.getMessage(requestId4, data4.getString("p"), data4.getString(PSOProgramService.VS_Key), string5, data4.getBoolean("a", false), data4.getByte("c", (byte) 0).byteValue());
                                    return;
                                } catch (Throwable unused7) {
                                    BaseDataSource.this.setGetMessageResult(requestId4, string5, false, null);
                                    return;
                                }
                            case 303:
                                BaseDataSource.this.updateInbox();
                                return;
                            case 304:
                                Bundle data5 = message.getData();
                                int i2 = data5.getInt("t", -1);
                                if (i2 == 1) {
                                    BaseDataSource.this.setMessageDeleted((RequestId) data5.getParcelable(StreamManagement.AckRequest.ELEMENT), data5.getString("m"), data5.getBoolean("i", false));
                                    return;
                                }
                                if (i2 == 0) {
                                    BaseDataSource.this.setMessageRead((RequestId) data5.getParcelable(StreamManagement.AckRequest.ELEMENT), data5.getString("m"), data5.getBoolean("i", false));
                                    return;
                                }
                                String str = "MSG_SET_MSG_STATUS: invalid message status type " + i2;
                                return;
                            default:
                                return;
                        }
                    } catch (Throwable unused8) {
                        return;
                    }
                }
            }
            if (message.arg1 == 1) {
                BaseDataSource.this.onStopError();
            } else {
                BaseDataSource baseDataSource2 = BaseDataSource.this;
                baseDataSource2.mIsStarted = false;
                baseDataSource2.onStopped();
                BaseDataSource.this.stopped();
                if (BaseDataSource.this.mCleanupAfterClose) {
                    BaseDataSource.this.cleanup();
                }
            }
            synchronized (BaseDataSource.this) {
                BaseDataSource.this.mPendingRequest = null;
                cancelPendingRequestTimeout();
            }
        }

        public void onStart() {
            sendMessage(obtainMessage(1));
        }

        public void onStartCompleted(boolean z) {
            sendMessage(obtainMessage(100, Integer.valueOf(z ? 1 : 0)));
        }

        public void onStop(boolean z) {
            Message messageObtainMessage = obtainMessage(2);
            messageObtainMessage.arg1 = z ? 1 : 0;
            sendMessage(messageObtainMessage);
        }

        public void onStopCompleted(boolean z) {
            sendMessage(obtainMessage(102, Integer.valueOf(z ? 1 : 0)));
        }

        public void pushMessage(RequestId requestId, String str, String str2, String str3, boolean z, boolean z2, int i) {
            Message messageObtainMessage = obtainMessage(200);
            Bundle data = messageObtainMessage.getData();
            data.putParcelable(StreamManagement.AckRequest.ELEMENT, requestId);
            data.putString("u", str);
            data.putString("f", str2);
            data.putString(PSOProgramService.VS_Key, str3);
            data.putBoolean("t", z);
            data.putBoolean("ir", z2);
            data.putInt("c", i);
            sendMessage(messageObtainMessage);
        }

        public void setClientConnectionStateChanged(boolean z) {
        }

        public void setMessageStatus(RequestId requestId, String str, int i, boolean z) {
            Message messageObtainMessage = obtainMessage(304);
            Bundle data = messageObtainMessage.getData();
            data.putParcelable(StreamManagement.AckRequest.ELEMENT, requestId);
            data.putString("m", str);
            data.putInt("t", i);
            data.putBoolean("i", z);
            sendMessage(messageObtainMessage);
        }

        public void startPendingRequestTimeout() {
            sendMessageDelayed(obtainMessage(2000), 4000L);
        }

        public void updateInbox() {
            sendMessage(obtainMessage(303));
        }
    }

    public class EventHandlerThread extends Thread {
        public EventHandler mHandler;

        public EventHandlerThread() {
            setPriority(10);
        }

        public void finish() {
            Looper looper;
            EventHandler eventHandler = this.mHandler;
            if (eventHandler == null || (looper = eventHandler.getLooper()) == null) {
                return;
            }
            looper.quit();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Looper.prepare();
            this.mHandler = BaseDataSource.this.new EventHandler();
            Looper.loop();
        }
    }

    public class EventReceiver extends BroadcastReceiver {
        private EventReceiver() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void init(Context context, Handler handler) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(BluetoothMap.ACTION_START);
            intentFilter.addAction(BluetoothMap.ACTION_STOP);
            intentFilter.addAction("");
            BaseDataSource.this.mContext.registerReceiver(this, intentFilter, null, handler);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            BaseDataSource baseDataSource;
            String action = intent.getAction();
            if (BluetoothMap.ACTION_START.equals(action)) {
                String str = StringUtil.toNonNullString(BaseDataSource.this.getDatasourceId()) + ": received start action...";
                synchronized (BaseDataSource.this) {
                    BaseDataSource baseDataSource2 = BaseDataSource.this;
                    if (!baseDataSource2.mIsStarted || BluetoothMap.ACTION_STOP.equals(baseDataSource2.mPendingRequest)) {
                        BaseDataSource.this.mEventHandlerThread.mHandler.deferStart();
                    }
                    BaseDataSource.this.mEventHandlerThread.mHandler.cancelDeferredStop();
                }
                return;
            }
            if (BluetoothMap.ACTION_STOP.equals(action)) {
                String str2 = StringUtil.toNonNullString(BaseDataSource.this.getDatasourceId()) + ": received stop action...";
                synchronized (BaseDataSource.this) {
                    BaseDataSource baseDataSource3 = BaseDataSource.this;
                    if (!baseDataSource3.mIsStarted) {
                        String str3 = "DataSource state: mIsStarted=" + BaseDataSource.this.mIsStarted + ", mPendingRequest=" + StringUtil.toNonNullString(BaseDataSource.this.mPendingRequest);
                        if (BluetoothMap.ACTION_START.equals(BaseDataSource.this.mPendingRequest)) {
                            BaseDataSource.this.mEventHandlerThread.mHandler.deferStop();
                        }
                    } else if (!BluetoothMap.ACTION_STOP.equals(baseDataSource3.mPendingRequest)) {
                        synchronized (BaseDataSource.this) {
                            baseDataSource = BaseDataSource.this;
                            baseDataSource.mPendingRequest = BluetoothMap.ACTION_STOP;
                        }
                        baseDataSource.mEventHandlerThread.mHandler.onStopCompleted(false);
                    }
                    BaseDataSource.this.mEventHandlerThread.mHandler.cancelDeferredStart();
                }
                return;
            }
            if (!"".equals(action)) {
                String str4 = "Provider received unhandled event " + action;
                return;
            }
            String stringExtra = intent.getStringExtra("");
            if (stringExtra == null) {
                String str5 = "Received  " + action + ", but remote address not found.. Ignoring disconnect request...";
                return;
            }
            BluetoothDevice bluetoothDevice = BaseDataSource.this.mConnectedDevice;
            if (bluetoothDevice == null || !stringExtra.equalsIgnoreCase(bluetoothDevice.getAddress())) {
                String str6 = "Remote device " + stringExtra + " is not connected MAP client.. Ignoring disconnect request...";
                return;
            }
            String str7 = "Disconnecting connected MAP client " + stringExtra;
            BaseDataSource.this.disconnect(stringExtra);
        }
    }

    private String createBMessageFileName(String str) {
        return getDatasourceId() + Config.IN_FIELD_SEPARATOR + str + Config.IN_FIELD_SEPARATOR + System.currentTimeMillis() + PSOProgramService.LogExt;
    }

    public static final int getBMsgMaxByteLength(BluetoothDevice bluetoothDevice) {
        String name;
        return (bluetoothDevice == null || (name = bluetoothDevice.getName()) == null || !name.startsWith("BMW")) ? -1 : 15000;
    }

    private String getMSETime() {
        String str = DATE_TIME_FORMATTER.format(new Date());
        String str2 = str.substring(0, 8) + ExifInterface.GPS_DIRECTION_TRUE + str.substring(8, 14);
        String str3 = "MSEDateTime :" + str2;
        return str2;
    }

    public static boolean isRootFolder(String str) {
        return "/".equals(str);
    }

    public static boolean isValidFolderPath(String str) {
        return str != null && str.length() >= 1 && str.lastIndexOf(47) <= 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onStart() {
        BluetoothMap bluetoothMap;
        if (this.mIsStarted) {
            String str = "onStart():" + StringUtil.toNonNullString(getDatasourceId()) + ". DataSource is already started!!!";
        }
        String str2 = "onStart(): " + getProviderId() + "/" + getDatasourceId();
        preStart();
        try {
            bluetoothMap = this.mMapService;
        } catch (Throwable unused) {
        }
        if (bluetoothMap == null) {
            return;
        }
        bluetoothMap.registerDatasource(getProviderId(), getProviderDisplayName(), getDatasourceType(), getDatasourceId(), getDatasourceDisplayName(), supportsMessageFiltering(), supportsMessageOffsetBrowsing(), getFolderMappings(), this.mCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop(boolean z) {
        try {
            BluetoothMap bluetoothMap = this.mMapService;
            if (bluetoothMap == null) {
                return;
            }
            bluetoothMap.unregisterDatasource(getProviderId(), getDatasourceId(), z);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void stopped() {
        BluetoothMap bluetoothMap = this.mMapService;
        if (bluetoothMap != null) {
            try {
                bluetoothMap.close();
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized void cleanup() {
        EventReceiver eventReceiver;
        String str = "cleanup():" + StringUtil.toNonNullString(getDatasourceId());
        Context context = this.mContext;
        if (context != null && (eventReceiver = this.mEventReceiver) != null) {
            try {
                context.unregisterReceiver(eventReceiver);
                this.mEventReceiver = null;
            } catch (Throwable unused) {
            }
        }
        EventHandlerThread eventHandlerThread = this.mEventHandlerThread;
        if (eventHandlerThread != null) {
            try {
                eventHandlerThread.finish();
                this.mEventHandlerThread = null;
            } catch (Throwable unused2) {
            }
        }
    }

    public void disconnect(String str) {
        try {
            BluetoothMap bluetoothMap = this.mMapService;
            if (bluetoothMap == null) {
                return;
            }
            bluetoothMap.disconnect(str, getDatasourceId());
        } catch (Throwable unused) {
        }
    }

    public abstract String getDatasourceDisplayName();

    public abstract String getDatasourceId();

    public abstract byte getDatasourceType();

    public synchronized EventHandlerThread getEventHandlerThread() {
        if (this.mEventHandlerThread == null) {
            EventHandlerThread eventHandlerThread = new EventHandlerThread();
            this.mEventHandlerThread = eventHandlerThread;
            eventHandlerThread.start();
            while (this.mEventHandlerThread.mHandler == null) {
                try {
                    Thread.sleep(100L);
                } catch (Exception unused) {
                }
            }
        }
        return this.mEventHandlerThread;
    }

    public abstract void getFolderListing(RequestId requestId, String str, FolderListFilter folderListFilter);

    public abstract String[] getFolderMappings();

    public Handler getHandler() {
        return this.mEventHandlerThread.mHandler;
    }

    public abstract void getMessage(RequestId requestId, String str, String str2, String str3, boolean z, byte b);

    public abstract void getMsgListing(RequestId requestId, String str, MessageListFilter messageListFilter, MessageParameterFilter messageParameterFilter);

    public abstract void getMsgListingCount(RequestId requestId, String str, MessageListFilter messageListFilter, MessageParameterFilter messageParameterFilter);

    public abstract String getProviderDisplayName();

    public abstract String getProviderId();

    public boolean hasConnectedClient() {
        return this.mHasClientConnected;
    }

    public synchronized void init(Context context) {
        String str = "init():" + StringUtil.toNonNullString(getDatasourceId());
        this.mContext = context;
        this.mContentResolver = context.getContentResolver();
        getEventHandlerThread();
        EventReceiver eventReceiver = new EventReceiver();
        this.mEventReceiver = eventReceiver;
        eventReceiver.init(this.mContext, this.mEventHandlerThread.mHandler);
    }

    public boolean isNotificationEnabled() {
        boolean z = this.mHasClientConnected && this.mHasClientsRegistered;
        String str = "isNotificationEnabled(): " + z;
        return z;
    }

    public void notifyDeliveryStateChanged(String str, byte b, String str2, boolean z) {
        BluetoothMap bluetoothMap = this.mMapService;
        if (bluetoothMap == null) {
            return;
        }
        bluetoothMap.sendNotification(getProviderId(), getDatasourceId(), str, b, z ? (byte) 1 : (byte) 3, str2, null);
    }

    public void notifyMessageDeleted(String str, byte b, String str2) {
        this.mMapService.sendNotification(getProviderId(), getDatasourceId(), str, b, (byte) 7, str2, null);
    }

    public void notifyMessageMoved(String str, byte b, String str2, String str3) {
        BluetoothMap bluetoothMap = this.mMapService;
        if (bluetoothMap == null) {
            return;
        }
        bluetoothMap.sendNotification(getProviderId(), getDatasourceId(), str, b, (byte) 8, str2, str3);
    }

    public void notifyNewMessage(String str, byte b, String str2) {
        BluetoothMap bluetoothMap = this.mMapService;
        if (bluetoothMap == null) {
            return;
        }
        bluetoothMap.sendNotification(getProviderId(), getDatasourceId(), str, b, (byte) 0, str2, null);
    }

    public void notifySendStateChanged(String str, byte b, String str2, boolean z) {
        BluetoothMap bluetoothMap = this.mMapService;
        if (bluetoothMap == null) {
            return;
        }
        bluetoothMap.sendNotification(getProviderId(), getDatasourceId(), str, b, z ? (byte) 2 : (byte) 4, str2, null);
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
        String str = "onServiceConnected():" + StringUtil.toNonNullString(getDatasourceId()) + ": Proxy object = " + bluetoothProfile;
        this.mMapService = (BluetoothMap) bluetoothProfile;
        this.mCallback = new BluetoothMapDatasourceCallback();
        this.mEventHandlerThread.mHandler.onStart();
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public void onServiceDisconnected(int i) {
        String str = "onServiceDisconnected():" + StringUtil.toNonNullString(getDatasourceId());
    }

    public void onStartError() {
    }

    public void onStarted() {
    }

    public void onStopError() {
    }

    public void onStopped() {
    }

    public OutputStream openOutputStream(String str, Uri[] uriArr) {
        OutputStream outputStreamOpenOutputStream = null;
        try {
            Uri uriWithAppendedPath = Uri.withAppendedPath(MAP_CONTENT_URI, str);
            outputStreamOpenOutputStream = this.mContext.getContentResolver().openOutputStream(uriWithAppendedPath, "cwt");
            if (uriArr != null) {
                uriArr[0] = uriWithAppendedPath;
            }
        } catch (Throwable unused) {
        }
        return outputStreamOpenOutputStream;
    }

    public BMessage parseBMessage(String str) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        String str2 = "parseBMessage contentUri: " + str;
        BMessage bMessage = null;
        if (str == null) {
            return null;
        }
        if (str.startsWith("file://")) {
            BMessage bMessage2 = BMessage.parse(new File(str.substring(7)));
            if (bMessage2 == null) {
                String str3 = "Unable to parse for BMessage from " + str;
            }
            return bMessage2;
        }
        if (!str.startsWith(MAP_CONTENT_URI.toString())) {
            String str4 = "Unable to parse BMessage from unknown content url " + str;
            return null;
        }
        try {
            parcelFileDescriptorOpenFileDescriptor = this.mContext.getContentResolver().openFileDescriptor(Uri.parse(str), StreamManagement.AckRequest.ELEMENT);
            try {
                bMessage = BMessage.parse(parcelFileDescriptorOpenFileDescriptor.getFd());
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            parcelFileDescriptorOpenFileDescriptor = null;
        }
        if (parcelFileDescriptorOpenFileDescriptor != null) {
            try {
                parcelFileDescriptorOpenFileDescriptor.close();
            } catch (Exception unused3) {
            }
        }
        return bMessage;
    }

    public void preStart() {
    }

    public abstract void pushMessage(RequestId requestId, BMessage bMessage, String str, String str2, boolean z, boolean z2, int i);

    public synchronized void setAutoCleanupOnClose(boolean z) {
        this.mCleanupAfterClose = z;
    }

    public void setFolderListingResult(RequestId requestId, String str, String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            setFolderListingResult(requestId, str, false, null);
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str2 : strArr) {
            FolderInfo folderInfo = new FolderInfo();
            folderInfo.mFolderName = str2;
            arrayList.add(folderInfo);
        }
        setFolderListingResult(requestId, str, true, arrayList);
    }

    public void setGetMessageResult(RequestId requestId, String str, boolean z, BMessage bMessage) throws IOException {
        if (this.mMapService == null) {
            return;
        }
        if (!z) {
            String str2 = "Unable to get BMessage for messageId " + str;
            this.mMapService.returnMessage(requestId, str, null);
            return;
        }
        File fileWriteBMessage = writeBMessage(str, bMessage);
        bMessage.finish();
        if (fileWriteBMessage == null) {
            String str3 = "Error create BMessage for messageId " + str;
            this.mMapService.returnMessage(requestId, str, null);
            return;
        }
        String str4 = "BMessage for messageId " + str + " created in " + fileWriteBMessage.getAbsolutePath();
        this.mMapService.returnMessage(requestId, str, fileWriteBMessage.getAbsolutePath());
    }

    public abstract void setMessageDeleted(RequestId requestId, String str, boolean z);

    public void setMessageDeletedResult(RequestId requestId, String str, boolean z, boolean z2, String str2) {
        BluetoothMap bluetoothMap = this.mMapService;
        if (bluetoothMap == null) {
            return;
        }
        bluetoothMap.setMessageDeletedResult(requestId, str, z, z2, str2);
    }

    public void setMessageListingCountResult(RequestId requestId, String str, boolean z, int i, boolean z2) {
        try {
            BluetoothMap bluetoothMap = this.mMapService;
            if (bluetoothMap == null) {
                return;
            }
            if (z) {
                bluetoothMap.setMessageListingCount(requestId, str, i, getMSETime(), z2);
            } else {
                bluetoothMap.setMessageListingCount(requestId, str, 0, getMSETime(), false);
            }
        } catch (Throwable unused) {
        }
    }

    public void setMessageListingResult(RequestId requestId, String str, boolean z, List<MessageInfo> list) {
        try {
            if (this.mMapService == null) {
                return;
            }
            if (!z || list == null || list.size() <= 0) {
                this.mMapService.setMessageListing(requestId, str, EMPTY_MESSAGE_LIST, getMSETime());
            } else {
                this.mMapService.setMessageListing(requestId, str, list, getMSETime());
            }
        } catch (Throwable unused) {
        }
    }

    public abstract void setMessageRead(RequestId requestId, String str, boolean z);

    public void setPushMessageResult(RequestId requestId, BMessage bMessage, String str, boolean z, String str2) {
        if (bMessage != null) {
            bMessage.finish();
        }
        BluetoothMap bluetoothMap = this.mMapService;
        if (bluetoothMap == null) {
            return;
        }
        if (!z) {
            str2 = null;
        }
        bluetoothMap.setPushMessageResult(requestId, str, str2);
    }

    public synchronized void start() {
        this.mEventHandlerThread.mHandler.deferStart();
    }

    public synchronized void stop(boolean z) {
        if (!this.mIsStarted) {
            String str = "stop():" + StringUtil.toNonNullString(getDatasourceId()) + ". DataSource is already stopped!!!";
        }
        String str2 = "stop(): " + getProviderId() + "/" + getDatasourceId();
        this.mEventHandlerThread.mHandler.onStop(z);
    }

    public abstract boolean supportsMessageFiltering();

    public abstract boolean supportsMessageOffsetBrowsing();

    public abstract void updateInbox();

    public void updateMessageId(String str, String str2) {
        BluetoothMap bluetoothMap = this.mMapService;
        if (bluetoothMap == null) {
            return;
        }
        bluetoothMap.updateMessageId(getProviderId(), getDatasourceId(), str, str2);
    }

    public File writeBMessage(String str, BMessage bMessage) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        String strCreateBMessageFileName = createBMessageFileName(str);
        try {
            boolean zWrite = false;
            try {
                parcelFileDescriptorOpenFileDescriptor = this.mContext.getContentResolver().openFileDescriptor(Uri.withAppendedPath(MAP_CONTENT_URI, strCreateBMessageFileName), "cwt");
                try {
                    zWrite = bMessage.write(parcelFileDescriptorOpenFileDescriptor.getFd());
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                parcelFileDescriptorOpenFileDescriptor = null;
            }
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                try {
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (Exception unused3) {
                }
            }
            if (zWrite) {
                return new File(DEFAULT_TMP_DIR, strCreateBMessageFileName);
            }
            return null;
        } catch (Exception unused4) {
            return null;
        }
    }

    public void setFolderListingResult(RequestId requestId, String str, boolean z, List<FolderInfo> list) {
        try {
            if (this.mMapService == null) {
                return;
            }
            if (z && list != null && list.size() > 0) {
                this.mMapService.setFolderListing(requestId, str, list);
            } else {
                this.mMapService.setFolderListing(requestId, str, EMPTY_FOLDER_LIST);
            }
        } catch (Throwable unused) {
        }
    }
}

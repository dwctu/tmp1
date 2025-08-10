package com.epicgames.unreal.psoservices;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.epicgames.unreal.GameActivity;
import com.epicgames.unreal.Logger;
import com.spotify.sdk.android.player.Config;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public class PSOProgramServiceAccessor {
    public static HandlerThread PSOProgramAccessorHandlerThread = null;
    private static final String TAG = "PSOProgramServiceAccessor";
    public static final boolean bEnableTrace = false;
    public static Messenger mReplyToMe;
    public final AtomicInteger LastServiceIdx = new AtomicInteger(0);
    public OGLServiceInstance[] ServiceInstances;
    private GameActivity mContext;
    public static final Class<?>[] ServiceClassTypes = {OGLProgramService.class, OGLProgramService1.class, OGLProgramService2.class, OGLProgramService3.class, OGLProgramService4.class, OGLProgramService5.class, OGLProgramService6.class, OGLProgramService7.class};
    public static final Class<?>[] VulkanServiceClassTypes = {VulkanProgramService.class, VulkanProgramService1.class, VulkanProgramService2.class, VulkanProgramService3.class, VulkanProgramService4.class, VulkanProgramService5.class, VulkanProgramService6.class, VulkanProgramService7.class};
    private static final ConcurrentHashMap<Integer, JobResponse> SyncObs = new ConcurrentHashMap<>();
    private static final ReadWriteLock ProgramServiceAccessorlock = new ReentrantReadWriteLock();
    private static final Logger Log = GameActivity.Log;
    private static final AtomicInteger JobID = new AtomicInteger(5);
    private static final Object ProgramLinkLock = new Object();
    private static PSOProgramServiceAccessor _PSOProgramServiceAccessor = null;

    public static class IncomingHandler extends Handler {
        public IncomingHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 10) {
                super.handleMessage(message);
                return;
            }
            PSOProgramServiceAccessor.beginTrace("PSOProgramService.MSG_LINKPROGRAM_RESPONSE");
            message.getData().getByteArray(PSOProgramService.CompiledProgram_Key);
            message.getData().getByteArray(PSOProgramService.JobContext_Key);
            int i = message.getData().getInt(PSOProgramService.JobID_Key, -1);
            int i2 = message.getData().getInt(PSOProgramService.ServiceID_Key, -1);
            try {
                PSOProgramServiceAccessor.ProgramServiceAccessorlock.readLock().lock();
                if (i2 >= 0 && i2 < PSOProgramServiceAccessor._PSOProgramServiceAccessor.ServiceInstances.length) {
                    PSOProgramServiceAccessor._PSOProgramServiceAccessor.ServiceInstances[i2].PendingJobs.decrementAndGet();
                }
                PSOProgramServiceAccessor.ProgramServiceAccessorlock.readLock().unlock();
                PSOProgramServiceAccessor.beginTrace("PSOProgramService.MSG_LINKPROGRAM_RESPONSE " + i);
                JobResponse jobResponse = (JobResponse) PSOProgramServiceAccessor.SyncObs.get(Integer.valueOf(i));
                if (jobResponse != null) {
                    synchronized (jobResponse.SyncObj) {
                        jobResponse.data = message.getData();
                        jobResponse.ResponseState = JobResponse.ResponseStateEnum.Responded;
                        jobResponse.SyncObj.notifyAll();
                    }
                } else {
                    PSOProgramServiceAccessor.Log.error("Job " + i + " completed but request already timed out.");
                }
                PSOProgramServiceAccessor.endTrace();
                PSOProgramServiceAccessor.endTrace();
            } catch (Throwable th) {
                PSOProgramServiceAccessor.ProgramServiceAccessorlock.readLock().unlock();
                throw th;
            }
        }
    }

    public static class JNIProgramLinkResponse {
        public byte[] CompiledProgram;
        public String ErrorMessage;
        public boolean bCompileSuccess;
    }

    public static class JobResponse {
        public Bundle data;
        public final Object SyncObj = new Object();
        public ResponseStateEnum ResponseState = ResponseStateEnum.Uninitialized;

        public enum ResponseStateEnum {
            Uninitialized,
            Pending,
            Responded
        }
    }

    public class OGLServiceInstance {
        private final Class ServiceClass;
        private final AtomicInteger mBound = new AtomicInteger(-1);
        private final AtomicInteger PendingJobs = new AtomicInteger(0);
        private final Map<String, Long> LastLogSequencePerUID = new HashMap();
        private final PSOProgramServiceConnection mConnection = new PSOProgramServiceConnection();
        public boolean mShouldUnbind = false;
        public Messenger mService = null;

        public class PSOProgramServiceConnection implements ServiceConnection {
            public final Object mConnectionSync = new Object();

            public PSOProgramServiceConnection() {
            }

            @Override // android.content.ServiceConnection
            public void onBindingDied(ComponentName componentName) {
                PSOProgramServiceAccessor.Log.verbose("onBindingDied" + OGLServiceInstance.this.Name());
                synchronized (this.mConnectionSync) {
                    OGLServiceInstance.this.mBound.set(0);
                }
                OGLServiceInstance.this.mShouldUnbind = false;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                PSOProgramServiceAccessor.Log.verbose("onServiceConnected1 " + OGLServiceInstance.this.Name());
                synchronized (this.mConnectionSync) {
                    OGLServiceInstance.this.mService = new Messenger(iBinder);
                    OGLServiceInstance.this.mBound.set(1);
                    this.mConnectionSync.notifyAll();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                PSOProgramServiceAccessor.Log.verbose("onServiceDisconnected1" + OGLServiceInstance.this.Name());
                synchronized (this.mConnectionSync) {
                    OGLServiceInstance.this.mBound.set(0);
                }
                OGLServiceInstance.this.mShouldUnbind = false;
            }
        }

        public OGLServiceInstance(Class cls) {
            this.ServiceClass = cls;
        }

        public boolean IsServiceBound() {
            return this.mBound.get() == 1;
        }

        public String Name() {
            return this.ServiceClass.getSimpleName();
        }

        public synchronized void ReadBackServiceLog() {
            File[] fileArrListFiles = new File(PSOProgramServiceAccessor.this.mContext.getFilesDir() + PSOProgramService.LogDir).listFiles();
            if (fileArrListFiles == null) {
                PSOProgramServiceAccessor.Log.error("No log files " + Name());
                return;
            }
            for (File file : fileArrListFiles) {
                if (file.getName().contains(Name() + Config.IN_FIELD_SEPARATOR) && file.getName().endsWith(PSOProgramService.LogExt)) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                        while (true) {
                            try {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                String[] strArrSplit = line.split(",");
                                if (strArrSplit.length >= 2) {
                                    String strTrim = strArrSplit[0].trim();
                                    long j = Long.parseLong(strArrSplit[1].trim());
                                    Long l = this.LastLogSequencePerUID.get(strTrim);
                                    long jLongValue = -1;
                                    if (l == null) {
                                        this.LastLogSequencePerUID.put(strTrim, -1L);
                                    } else {
                                        jLongValue = l.longValue();
                                    }
                                    if (j > jLongValue) {
                                        PSOProgramServiceAccessor.Log.error(Name() + " log :" + line);
                                    } else {
                                        j = jLongValue;
                                    }
                                    this.LastLogSequencePerUID.put(strTrim, Long.valueOf(j));
                                }
                            } catch (Throwable th) {
                                try {
                                    bufferedReader.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        }
                        bufferedReader.close();
                    } catch (IOException | NumberFormatException e) {
                        PSOProgramServiceAccessor.Log.error(e.toString());
                        e.printStackTrace();
                    }
                }
            }
        }

        public boolean SendMessage(Message message) throws RemoteException {
            if (this.mBound.get() == 1) {
                this.mService.send(message);
                return true;
            }
            PSOProgramServiceAccessor.Log.error("cannot SendMessage" + Name() + " service unbound!");
            return false;
        }

        public boolean doBindAndWait() {
            boolean zDoBindService;
            synchronized (this.mConnection.mConnectionSync) {
                zDoBindService = doBindService();
                long jNanoTime = System.nanoTime();
                if (zDoBindService) {
                    while (this.mBound.get() == -1) {
                        try {
                            this.mConnection.mConnectionSync.wait(1000L);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (System.nanoTime() - jNanoTime >= 10000000000L) {
                            PSOProgramServiceAccessor.Log.error("OGLRemoteProgramLink " + Name() + " TIMED OUT waiting for service bind " + ((System.nanoTime() - jNanoTime) / 1000000) + "ms.");
                            zDoBindService = false;
                            break;
                        }
                    }
                }
            }
            return zDoBindService;
        }

        public boolean doBindService() {
            PSOProgramServiceAccessor.Log.verbose("doBindService " + Name());
            if (!this.mShouldUnbind) {
                this.mShouldUnbind = PSOProgramServiceAccessor.this.mContext.bindService(new Intent(PSOProgramServiceAccessor.this.mContext, (Class<?>) this.ServiceClass), this.mConnection, 65);
                PSOProgramServiceAccessor.Log.verbose("doBindService " + Name() + " needs unbind " + this.mShouldUnbind + " bound: " + this.mBound);
            }
            return this.mShouldUnbind;
        }

        public void doUnbindService() {
            PSOProgramServiceAccessor.Log.verbose("doUnbindService" + Name());
            if (this.mShouldUnbind) {
                PSOProgramServiceAccessor.this.mContext.unbindService(this.mConnection);
                this.mShouldUnbind = false;
                this.mBound.set(-1);
            }
        }
    }

    public static JNIProgramLinkResponse AndroidThunkJava_OGLRemoteProgramLink(byte[] bArr, String str, String str2, String str3) {
        JNIProgramLinkResponse jNIProgramLinkResponseOGLRemoteProgramLink_internal;
        if (!GameActivity.IsActivityPaused()) {
            return OGLRemoteProgramLink_internal(bArr, str, str2, str3);
        }
        synchronized (ProgramLinkLock) {
            jNIProgramLinkResponseOGLRemoteProgramLink_internal = OGLRemoteProgramLink_internal(bArr, str, str2, str3);
        }
        return jNIProgramLinkResponseOGLRemoteProgramLink_internal;
    }

    public static boolean AndroidThunkJava_StartRemoteProgramLink(int i, boolean z) {
        boolean zStartAndWaitForVulkanServices;
        try {
            if (_PSOProgramServiceAccessor != null) {
                try {
                    ReadWriteLock readWriteLock = ProgramServiceAccessorlock;
                    readWriteLock.writeLock().lock();
                    HandlerThread handlerThread = new HandlerThread("PSOProgramAccessorThread");
                    PSOProgramAccessorHandlerThread = handlerThread;
                    handlerThread.start();
                    mReplyToMe = new Messenger(new IncomingHandler(PSOProgramAccessorHandlerThread.getLooper()));
                    zStartAndWaitForVulkanServices = z ? _PSOProgramServiceAccessor.StartAndWaitForVulkanServices(i) : _PSOProgramServiceAccessor.StartAndWaitForServices(i);
                    readWriteLock.writeLock().unlock();
                } catch (Exception e) {
                    e.printStackTrace();
                    ProgramServiceAccessorlock.writeLock().unlock();
                }
            } else {
                zStartAndWaitForVulkanServices = false;
            }
            if (!zStartAndWaitForVulkanServices) {
                AndroidThunkJava_StopRemoteProgramLink();
            }
            return zStartAndWaitForVulkanServices;
        } catch (Throwable th) {
            ProgramServiceAccessorlock.writeLock().unlock();
            throw th;
        }
    }

    public static void AndroidThunkJava_StopRemoteProgramLink() {
        ReadWriteLock readWriteLock;
        if (_PSOProgramServiceAccessor != null) {
            try {
                try {
                    readWriteLock = ProgramServiceAccessorlock;
                    readWriteLock.writeLock().lock();
                    _PSOProgramServiceAccessor.StopServices();
                    PSOProgramAccessorHandlerThread.quitSafely();
                    mReplyToMe = null;
                } catch (Exception e) {
                    e.printStackTrace();
                    readWriteLock = ProgramServiceAccessorlock;
                }
                readWriteLock.writeLock().unlock();
            } catch (Throwable th) {
                ProgramServiceAccessorlock.writeLock().unlock();
                throw th;
            }
        }
    }

    public static JNIProgramLinkResponse AndroidThunkJava_VKPSOGFXCompile(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        JNIProgramLinkResponse jNIProgramLinkResponseVKPSOGFXCompile_internal;
        if (!GameActivity.IsActivityPaused()) {
            return VKPSOGFXCompile_internal(bArr, bArr2, bArr3, bArr4);
        }
        synchronized (ProgramLinkLock) {
            jNIProgramLinkResponseVKPSOGFXCompile_internal = VKPSOGFXCompile_internal(bArr, bArr2, bArr3, bArr4);
        }
        return jNIProgramLinkResponseVKPSOGFXCompile_internal;
    }

    private void ClearServiceLogDirs() {
        File file = new File(this.mContext.getFilesDir() + PSOProgramService.LogDir);
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                for (File file2 : fileArrListFiles) {
                    file2.delete();
                }
            }
            file.delete();
        }
    }

    private static boolean IsNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private static JNIProgramLinkResponse OGLRemoteProgramLink_internal(byte[] bArr, String str, String str2, String str3) {
        OGLServiceInstance oGLServiceInstance;
        Lock lock;
        try {
            ReadWriteLock readWriteLock = ProgramServiceAccessorlock;
            readWriteLock.readLock().lock();
            PSOProgramServiceAccessor pSOProgramServiceAccessor = _PSOProgramServiceAccessor;
            if (pSOProgramServiceAccessor == null) {
                Log.error("AndroidThunkJava_OGLRemoteProgramLink Called too early ");
            } else {
                if (pSOProgramServiceAccessor.ServiceInstances.length != 0) {
                    int iIncrementAndGet = JobID.incrementAndGet();
                    beginTrace("AndroidThunkJava_OGLRemoteProgramLink " + iIncrementAndGet);
                    boolean z = true;
                    Message messageObtain = Message.obtain(null, 1, 0, 0);
                    Bundle bundle = new Bundle();
                    if (!IsNullOrEmpty(str3)) {
                        bundle.putString("c", str3);
                    } else if (IsNullOrEmpty(str)) {
                        Log.error("Failed to send compile job VS is null ");
                    } else if (IsNullOrEmpty(str2)) {
                        Log.error("Failed to send compile job PS is null ");
                    } else {
                        bundle.putString(PSOProgramService.VS_Key, str);
                        bundle.putString("p", str2);
                    }
                    bundle.putByteArray(PSOProgramService.JobContext_Key, bArr);
                    bundle.putInt(PSOProgramService.JobID_Key, iIncrementAndGet);
                    messageObtain.replyTo = mReplyToMe;
                    JobResponse jobResponse = new JobResponse();
                    synchronized (jobResponse.SyncObj) {
                        SyncObs.put(Integer.valueOf(iIncrementAndGet), jobResponse);
                        messageObtain.setData(bundle);
                        int i = 0;
                        while (true) {
                            PSOProgramServiceAccessor pSOProgramServiceAccessor2 = _PSOProgramServiceAccessor;
                            if (i >= pSOProgramServiceAccessor2.ServiceInstances.length) {
                                oGLServiceInstance = null;
                                break;
                            }
                            int iIncrementAndGet2 = pSOProgramServiceAccessor2.LastServiceIdx.incrementAndGet();
                            OGLServiceInstance[] oGLServiceInstanceArr = _PSOProgramServiceAccessor.ServiceInstances;
                            int length = iIncrementAndGet2 % oGLServiceInstanceArr.length;
                            oGLServiceInstance = oGLServiceInstanceArr[length];
                            if (oGLServiceInstance.IsServiceBound()) {
                                bundle.putInt(PSOProgramService.ServiceID_Key, length);
                                break;
                            }
                            Log.warn("OGLRemoteProgramLink " + oGLServiceInstance.Name() + " (" + iIncrementAndGet + ") was unbound, rebinding and trying next service");
                            oGLServiceInstance.doBindService();
                            oGLServiceInstance.ReadBackServiceLog();
                            i++;
                        }
                        jobResponse.ResponseState = JobResponse.ResponseStateEnum.Pending;
                        if (oGLServiceInstance != null && oGLServiceInstance.SendMessage(messageObtain)) {
                            oGLServiceInstance.PendingJobs.incrementAndGet();
                            long jNanoTime = System.nanoTime();
                            while (jobResponse.ResponseState != JobResponse.ResponseStateEnum.Responded) {
                                jobResponse.SyncObj.wait(1000L);
                                if (System.nanoTime() - jNanoTime >= 10000000000L) {
                                    Log.error("OGLRemoteProgramLink TIMED OUT WAITING " + iIncrementAndGet + " for " + ((System.nanoTime() - jNanoTime) / 1000000) + "ms. pending tasks " + oGLServiceInstance.PendingJobs.get());
                                    SyncObs.remove(Integer.valueOf(iIncrementAndGet));
                                    oGLServiceInstance.ReadBackServiceLog();
                                }
                            }
                            long jNanoTime2 = (System.nanoTime() - jNanoTime) / 1000000;
                            if (jNanoTime2 > 2500) {
                                Log.verbose("OGLRemoteProgramLink responded " + iIncrementAndGet + " total wait time " + jNanoTime2 + " ms. pending tasks " + oGLServiceInstance.PendingJobs.get());
                            }
                            SyncObs.remove(Integer.valueOf(iIncrementAndGet));
                            jobResponse.data.getByteArray(PSOProgramService.JobContext_Key);
                            byte[] byteArray = jobResponse.data.getByteArray(PSOProgramService.CompiledProgram_Key);
                            jobResponse.data.getInt(PSOProgramService.JobID_Key);
                            JNIProgramLinkResponse jNIProgramLinkResponse = new JNIProgramLinkResponse();
                            String string = jobResponse.data.getString("f");
                            if (string != null && !string.isEmpty()) {
                                z = false;
                            }
                            jNIProgramLinkResponse.bCompileSuccess = z;
                            jNIProgramLinkResponse.ErrorMessage = string;
                            jNIProgramLinkResponse.CompiledProgram = byteArray;
                            return jNIProgramLinkResponse;
                        }
                        if (oGLServiceInstance != null) {
                            SyncObs.remove(Integer.valueOf(iIncrementAndGet));
                            oGLServiceInstance.ReadBackServiceLog();
                        } else {
                            Log.error("OGLRemoteProgramLink " + iIncrementAndGet + " no valid bound services.");
                            SyncObs.remove(Integer.valueOf(iIncrementAndGet));
                        }
                        lock = ProgramServiceAccessorlock.readLock();
                        lock.unlock();
                        endTrace();
                        return null;
                    }
                }
                Log.error("AndroidThunkJava_OGLRemoteProgramLink not enabled.");
            }
            lock = readWriteLock.readLock();
            lock.unlock();
            endTrace();
            return null;
        } catch (Exception e) {
            Log.error("OGLRemoteProgramLink FAIL " + e);
            return null;
        } finally {
            ProgramServiceAccessorlock.readLock().unlock();
            endTrace();
        }
    }

    private static JNIProgramLinkResponse VKPSOGFXCompile_internal(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        OGLServiceInstance oGLServiceInstance;
        Lock lock;
        try {
            ReadWriteLock readWriteLock = ProgramServiceAccessorlock;
            readWriteLock.readLock().lock();
            PSOProgramServiceAccessor pSOProgramServiceAccessor = _PSOProgramServiceAccessor;
            if (pSOProgramServiceAccessor == null) {
                Log.error("AndroidThunkJava_VKPSOGFXCompile Called too early ");
            } else if (pSOProgramServiceAccessor.ServiceInstances.length == 0) {
                Log.error("AndroidThunkJava_VKPSOGFXCompile not enabled.");
            } else {
                int iIncrementAndGet = JobID.incrementAndGet();
                beginTrace("AndroidThunkJava_OGLRemoteProgramLink " + iIncrementAndGet);
                boolean z = true;
                Message messageObtain = Message.obtain(null, 1, 0, 0);
                Bundle bundle = new Bundle();
                if (bArr2.length == 0) {
                    Log.error("Failed to send compile job VS is null ");
                } else {
                    if (bArr3.length != 0) {
                        bundle.putByteArray(PSOProgramService.VS_Key, bArr2);
                        bundle.putByteArray("p", bArr3);
                        bundle.putByteArray(PSOProgramService.PSOData_Key, bArr4);
                        bundle.putByteArray(PSOProgramService.JobContext_Key, bArr);
                        bundle.putInt(PSOProgramService.JobID_Key, iIncrementAndGet);
                        messageObtain.replyTo = mReplyToMe;
                        JobResponse jobResponse = new JobResponse();
                        synchronized (jobResponse.SyncObj) {
                            SyncObs.put(Integer.valueOf(iIncrementAndGet), jobResponse);
                            messageObtain.setData(bundle);
                            int i = 0;
                            while (true) {
                                PSOProgramServiceAccessor pSOProgramServiceAccessor2 = _PSOProgramServiceAccessor;
                                if (i >= pSOProgramServiceAccessor2.ServiceInstances.length) {
                                    oGLServiceInstance = null;
                                    break;
                                }
                                int iIncrementAndGet2 = pSOProgramServiceAccessor2.LastServiceIdx.incrementAndGet();
                                OGLServiceInstance[] oGLServiceInstanceArr = _PSOProgramServiceAccessor.ServiceInstances;
                                int length = iIncrementAndGet2 % oGLServiceInstanceArr.length;
                                oGLServiceInstance = oGLServiceInstanceArr[length];
                                if (oGLServiceInstance.IsServiceBound()) {
                                    bundle.putInt(PSOProgramService.ServiceID_Key, length);
                                    break;
                                }
                                Log.warn("OGLRemoteProgramLink " + oGLServiceInstance.Name() + " (" + iIncrementAndGet + ") was unbound, rebinding and trying next service");
                                oGLServiceInstance.doBindService();
                                oGLServiceInstance.ReadBackServiceLog();
                                i++;
                            }
                            jobResponse.ResponseState = JobResponse.ResponseStateEnum.Pending;
                            if (oGLServiceInstance != null && oGLServiceInstance.SendMessage(messageObtain)) {
                                oGLServiceInstance.PendingJobs.incrementAndGet();
                                long jNanoTime = System.nanoTime();
                                while (jobResponse.ResponseState != JobResponse.ResponseStateEnum.Responded) {
                                    jobResponse.SyncObj.wait(1000L);
                                    if (System.nanoTime() - jNanoTime >= 10000000000L) {
                                        Log.error("OGLRemoteProgramLink TIMED OUT WAITING " + iIncrementAndGet + " for " + ((System.nanoTime() - jNanoTime) / 1000000) + "ms. pending tasks " + oGLServiceInstance.PendingJobs.get());
                                        SyncObs.remove(Integer.valueOf(iIncrementAndGet));
                                        oGLServiceInstance.ReadBackServiceLog();
                                    }
                                }
                                long jNanoTime2 = (System.nanoTime() - jNanoTime) / 1000000;
                                if (jNanoTime2 > 2500) {
                                    Log.verbose("OGLRemoteProgramLink responded " + iIncrementAndGet + " total wait time " + jNanoTime2 + " ms. pending tasks " + oGLServiceInstance.PendingJobs.get());
                                }
                                SyncObs.remove(Integer.valueOf(iIncrementAndGet));
                                jobResponse.data.getByteArray(PSOProgramService.JobContext_Key);
                                byte[] byteArray = jobResponse.data.getByteArray(PSOProgramService.CompiledProgram_Key);
                                jobResponse.data.getInt(PSOProgramService.JobID_Key);
                                JNIProgramLinkResponse jNIProgramLinkResponse = new JNIProgramLinkResponse();
                                String string = jobResponse.data.getString("f");
                                if (string != null && !string.isEmpty()) {
                                    z = false;
                                }
                                jNIProgramLinkResponse.bCompileSuccess = z;
                                jNIProgramLinkResponse.ErrorMessage = string;
                                jNIProgramLinkResponse.CompiledProgram = byteArray;
                                return jNIProgramLinkResponse;
                            }
                            if (oGLServiceInstance != null) {
                                SyncObs.remove(Integer.valueOf(iIncrementAndGet));
                                oGLServiceInstance.ReadBackServiceLog();
                            } else {
                                Log.error("OGLRemoteProgramLink " + iIncrementAndGet + " no valid bound services.");
                                SyncObs.remove(Integer.valueOf(iIncrementAndGet));
                            }
                            lock = ProgramServiceAccessorlock.readLock();
                            lock.unlock();
                            endTrace();
                            return null;
                        }
                    }
                    Log.error("Failed to send compile job PS is null ");
                }
            }
            lock = readWriteLock.readLock();
            lock.unlock();
            endTrace();
            return null;
        } catch (Exception e) {
            Log.error("OGLRemoteProgramLink FAIL " + e);
            return null;
        } finally {
            ProgramServiceAccessorlock.readLock().unlock();
            endTrace();
        }
    }

    public static void beginTrace(String str) {
    }

    public static void endTrace() {
    }

    public void Init(GameActivity gameActivity) {
        this.mContext = gameActivity;
        ClearServiceLogDirs();
        _PSOProgramServiceAccessor = this;
    }

    public boolean StartAndWaitForServices(int i) {
        int iMax = Math.max(1, Math.min(i, ServiceClassTypes.length));
        this.ServiceInstances = new OGLServiceInstance[iMax];
        for (int i2 = 0; i2 < iMax; i2++) {
            this.ServiceInstances[i2] = new OGLServiceInstance(ServiceClassTypes[i2]);
        }
        boolean z = true;
        for (OGLServiceInstance oGLServiceInstance : this.ServiceInstances) {
            z = z && oGLServiceInstance.doBindAndWait();
        }
        return z;
    }

    public boolean StartAndWaitForVulkanServices(int i) {
        int iMax = Math.max(1, Math.min(i, VulkanServiceClassTypes.length));
        this.ServiceInstances = new OGLServiceInstance[iMax];
        for (int i2 = 0; i2 < iMax; i2++) {
            this.ServiceInstances[i2] = new OGLServiceInstance(VulkanServiceClassTypes[i2]);
        }
        boolean z = true;
        for (OGLServiceInstance oGLServiceInstance : this.ServiceInstances) {
            z = z && oGLServiceInstance.doBindAndWait();
        }
        return z;
    }

    public void StopServices() {
        if (this.ServiceInstances != null) {
            Log.debug("Stopping OGL Program compile services");
            for (OGLServiceInstance oGLServiceInstance : this.ServiceInstances) {
                oGLServiceInstance.ReadBackServiceLog();
                oGLServiceInstance.doUnbindService();
            }
            this.ServiceInstances = null;
        }
    }
}

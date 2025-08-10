package com.epicgames.unreal.psoservices;

import android.app.Service;
import android.content.Intent;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES31;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.broadcom.bt.util.io.IOUtils;
import com.epicgames.unreal.Logger;
import java.io.File;
import java.io.IOException;
import java.lang.Thread;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/* loaded from: classes.dex */
public class PSOProgramService extends Service implements Logger.ILoggerCallback {
    public static final String CS_Key = "c";
    public static final String CompiledProgram_Key = "cpg";
    public static final String JobContext_Key = "jtx";
    public static final String JobFail = "f";
    public static final String JobID_Key = "jid";
    public static final String LogDir = "/oglservice/";
    public static final String LogExt = ".txt";
    public static final Level LogLevel = Level.WARNING;
    public static final int MSG_LINKPROGRAM = 1;
    public static final int MSG_LINKPROGRAM_RESPONSE = 10;
    public static final String PSOData_Key = "pso";
    public static final String PS_Key = "p";
    public static final String ServiceID_Key = "sid";
    public static final String VS_Key = "v";
    public static final boolean bEnableTestFailures = false;
    public static final boolean bEnableTrace = false;
    public final OGLUncaughtExceptionHandler OGLUncaughtExceptionHandler;
    private FileHandler logFileHandler;
    private EGLContext mEglContext;
    private EGLDisplay mEglDisplay;
    private EGLSurface mEglSurface;
    public final Messenger mMessenger;
    private final String TAG = getClass().getSimpleName();
    private final Logger logger = new Logger(getClass().getSimpleName());

    public static class GLCompileException extends Exception {
        public GLCompileException(String str) {
            super(str);
        }
    }

    public class IncomingHandler extends Handler {
        public IncomingHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            if (message.what != 1) {
                super.handleMessage(message);
                return;
            }
            PSOProgramService.beginTrace("PSOProgramService.handleMessage");
            if (PSOProgramService.this.UseVulkan()) {
                byte[] byteArray = message.getData().getByteArray(PSOProgramService.VS_Key);
                byte[] byteArray2 = message.getData().getByteArray("p");
                byte[] byteArray3 = message.getData().getByteArray(PSOProgramService.PSOData_Key);
                PSOProgramService.this.ProcessVulkanProgramRequest(message.replyTo, message.getData().getInt(PSOProgramService.JobID_Key), message.getData().getInt(PSOProgramService.ServiceID_Key), message.getData().getByteArray(PSOProgramService.JobContext_Key), byteArray, byteArray2, byteArray3);
            } else {
                String string = message.getData().getString(PSOProgramService.VS_Key);
                String string2 = message.getData().getString("p");
                String string3 = message.getData().getString("c");
                PSOProgramService.this.ProcessGLProgramRequest(message.replyTo, message.getData().getInt(PSOProgramService.JobID_Key), message.getData().getInt(PSOProgramService.ServiceID_Key), message.getData().getByteArray(PSOProgramService.JobContext_Key), string, string2, string3);
            }
            PSOProgramService.endTrace();
        }
    }

    public class OGLUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        private final Lock uncaughtWait;

        private OGLUncaughtExceptionHandler() {
            this.uncaughtWait = new ReentrantLock();
        }

        public void init() {
            Thread.setDefaultUncaughtExceptionHandler(this);
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            this.uncaughtWait.lock();
            try {
                StringBuilder sb = new StringBuilder();
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    sb.append(stackTraceElement.toString());
                    sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                    sb.append("-~~ CAUSE ~~- (");
                    sb.append(cause);
                    sb.append(")\n");
                    for (StackTraceElement stackTraceElement2 : cause.getStackTrace()) {
                        sb.append(stackTraceElement2.toString());
                        sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                    }
                }
                StringBuilder sb2 = new StringBuilder("Uncaught java exception!\n" + thread + " thrown uncaught exception: " + th);
                for (Throwable cause2 = th.getCause(); cause2 != null; cause2 = cause2.getCause()) {
                    sb2.append("\nCause ");
                    sb2.append(cause2);
                    sb2.append(IOUtils.LINE_SEPARATOR_UNIX);
                }
                PSOProgramService.this.logger.error(sb2.toString());
                PSOProgramService.this.logger.error("Stack trace:");
                PSOProgramService.this.logger.error(sb.toString());
                PSOProgramService.this.logFileHandler.flush();
                System.exit(0);
            } finally {
                this.uncaughtWait.unlock();
            }
        }
    }

    public PSOProgramService() {
        OGLUncaughtExceptionHandler oGLUncaughtExceptionHandler = new OGLUncaughtExceptionHandler();
        this.OGLUncaughtExceptionHandler = oGLUncaughtExceptionHandler;
        this.mMessenger = new Messenger(new IncomingHandler(Looper.getMainLooper()));
        this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEglContext = EGL14.EGL_NO_CONTEXT;
        this.mEglSurface = EGL14.EGL_NO_SURFACE;
        oGLUncaughtExceptionHandler.init();
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.nio.ByteBuffer CompileAndLink(int r19, java.lang.String r20, java.lang.String r21, java.lang.String r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 399
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.epicgames.unreal.psoservices.PSOProgramService.CompileAndLink(int, java.lang.String, java.lang.String, java.lang.String):java.nio.ByteBuffer");
    }

    private void PrepareLogger() throws IOException {
        String str = getFilesDir().getAbsolutePath() + LogDir;
        new File(str).mkdirs();
        String str2 = str + this.TAG + "_%u_%g" + LogExt;
        String str3 = "log dir : " + str2;
        FileHandler fileHandler = new FileHandler(str2, 32768, 2, true);
        this.logFileHandler = fileHandler;
        fileHandler.setLevel(LogLevel);
        this.logFileHandler.setFormatter(new Formatter() { // from class: com.epicgames.unreal.psoservices.PSOProgramService.1BasicFormatter
            private final Date date = new Date();
            private final int pid = Process.myPid();
            private final String SessionUID = UUID.randomUUID().toString();
            private long SequenceNum = 0;

            @Override // java.util.logging.Formatter
            public String format(LogRecord logRecord) {
                int iMyTid = Process.myTid();
                this.date.setTime(logRecord.getMillis());
                String[] strArrSplit = logRecord.getMessage().split(System.lineSeparator());
                StringBuilder sb = new StringBuilder();
                for (String str4 : strArrSplit) {
                    sb.append(String.format("%s,%20d, %s %10d,%10d, %s %s\n", this.SessionUID, Long.valueOf(this.SequenceNum), this.date.toString(), Integer.valueOf(this.pid), Integer.valueOf(iMyTid), logRecord.getLevel().toString(), str4));
                    this.SequenceNum++;
                }
                return sb.toString();
            }
        });
    }

    public static void beginTrace(String str) {
    }

    private byte[] compileVulkanPSO(int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return CompileVKGFXPSO(bArr, bArr2, bArr3);
    }

    private int createShader(int i, String str) throws GLCompileException {
        int iGlCreateShader = GLES31.glCreateShader(i);
        if (iGlCreateShader == 0) {
            throw new GLCompileException("Failed to create shader type: " + i);
        }
        beginTrace("PSOProgramService.createShader " + i);
        GLES31.glShaderSource(iGlCreateShader, str);
        GLES31.glCompileShader(iGlCreateShader);
        endTrace();
        int[] iArr = new int[1];
        GLES31.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        String strGlGetShaderInfoLog = GLES31.glGetShaderInfoLog(iGlCreateShader);
        GLES31.glDeleteShader(iGlCreateShader);
        String strValueOf = String.valueOf(i);
        switch (i) {
            case 35632:
                strValueOf = "pixel shader";
                break;
            case 35633:
                strValueOf = "vertex shader";
                break;
            case 37305:
                strValueOf = "compute shader";
                break;
        }
        throw new GLCompileException("Failed to compile shader type: " + strValueOf + " log: " + strGlGetShaderInfoLog);
    }

    private void destroyGLContext() {
        EGLSurface eGLSurface = this.mEglSurface;
        if (eGLSurface != EGL14.EGL_NO_SURFACE) {
            EGL14.eglDestroySurface(this.mEglDisplay, eGLSurface);
            this.mEglSurface = EGL14.EGL_NO_SURFACE;
        }
        EGLContext eGLContext = this.mEglContext;
        if (eGLContext != EGL14.EGL_NO_CONTEXT) {
            EGL14.eglDestroyContext(this.mEglDisplay, eGLContext);
            this.mEglContext = EGL14.EGL_NO_CONTEXT;
        }
        this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
    }

    public static void endTrace() {
    }

    private void initGLContext() {
        beginTrace("PSOProgramService.InitContext");
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        this.mEglDisplay = eGLDisplayEglGetDisplay;
        int[] iArr = new int[2];
        boolean zEglInitialize = EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1);
        if (!zEglInitialize) {
            this.logger.error("eglInitialize " + zEglInitialize + " err " + EGL14.eglGetError() + " ver: " + iArr[0] + "." + iArr[1]);
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        EGL14.eglChooseConfig(this.mEglDisplay, new int[]{12352, 4, 12339, 1, 12322, 8, 12324, 8, 12323, 8, 12325, 8, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0);
        this.mEglContext = EGL14.eglCreateContext(this.mEglDisplay, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 3, 12539, 2, 12344}, 0);
        if (EGL14.eglQueryString(this.mEglDisplay, 12373).contains("EGL_KHR_surfaceless_context")) {
            this.mEglSurface = EGL14.EGL_NO_SURFACE;
        } else {
            this.mEglSurface = EGL14.eglCreatePbufferSurface(this.mEglDisplay, eGLConfigArr[0], new int[]{12344}, 0);
        }
        EGLDisplay eGLDisplay = this.mEglDisplay;
        EGLSurface eGLSurface = this.mEglSurface;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEglContext)) {
            this.logger.error("egl makecurrent failed. " + EGL14.eglGetError());
        }
        endTrace();
    }

    private void initVulkanContext() {
        beginTrace("PSOProgramService.InitVulkanContext");
        System.loadLibrary("psoservice");
        InitVKDevice();
        endTrace();
    }

    private void shutdownVulkanContext() {
        ShutdownVKDevice();
    }

    public native byte[] CompileVKGFXPSO(byte[] bArr, byte[] bArr2, byte[] bArr3);

    public native void InitVKDevice();

    @Override // com.epicgames.unreal.Logger.ILoggerCallback
    public void LoggerCallback(String str, String str2, String str3) {
        Level level;
        level = Level.INFO;
        str.hashCode();
        switch (str) {
            case "D/":
                level = Level.INFO;
                break;
            case "E/":
                level = Level.SEVERE;
                break;
            case "V/":
                level = Level.FINE;
                break;
            case "W/":
                level = Level.WARNING;
                break;
        }
        this.logFileHandler.publish(new LogRecord(level, str3));
    }

    public void ProcessGLProgramRequest(Messenger messenger, int i, int i2, byte[] bArr, String str, String str2, String str3) throws Throwable {
        ByteBuffer byteBufferCompileAndLink;
        try {
            byteBufferCompileAndLink = CompileAndLink(i, str, str2, str3);
        } catch (Exception e) {
            SendFail(messenger, i2, i, bArr, e.getMessage());
            byteBufferCompileAndLink = null;
        }
        if (byteBufferCompileAndLink != null) {
            SendSuccess(messenger, i2, i, bArr, byteBufferCompileAndLink.array());
        }
    }

    public void ProcessVulkanProgramRequest(Messenger messenger, int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) throws RemoteException {
        ByteBuffer byteBufferAllocate = null;
        try {
            byte[] bArrCompileVulkanPSO = compileVulkanPSO(i, bArr2, bArr3, bArr4);
            byteBufferAllocate = ByteBuffer.allocate(bArrCompileVulkanPSO.length);
            byteBufferAllocate.order(ByteOrder.nativeOrder());
            byteBufferAllocate.put(bArrCompileVulkanPSO);
        } catch (Exception e) {
            SendFail(messenger, i2, i, bArr, e.getMessage());
        }
        if (byteBufferAllocate != null) {
            SendSuccess(messenger, i2, i, bArr, byteBufferAllocate.array());
        }
    }

    public void SendFail(Messenger messenger, int i, int i2, byte[] bArr, String str) throws RemoteException {
        beginTrace("PSOProgramService.SendFail");
        Message messageObtain = Message.obtain(null, 10, 0, 0);
        Bundle bundle = new Bundle();
        bundle.putByteArray(JobContext_Key, bArr);
        bundle.putInt(JobID_Key, i2);
        bundle.putInt(ServiceID_Key, i);
        bundle.putString("f", str);
        messageObtain.setData(bundle);
        try {
            messenger.send(messageObtain);
        } catch (RemoteException e) {
            this.logger.error(i2 + " SendFail(), failed to send reply " + str + " : " + e);
        }
        endTrace();
    }

    public void SendSuccess(Messenger messenger, int i, int i2, byte[] bArr, byte[] bArr2) throws RemoteException {
        beginTrace("PSOProgramService.SendSuccess");
        Message messageObtain = Message.obtain(null, 10, 0, 0);
        Bundle bundle = new Bundle();
        bundle.putByteArray(JobContext_Key, bArr);
        bundle.putByteArray(CompiledProgram_Key, bArr2);
        bundle.putInt(JobID_Key, i2);
        bundle.putInt(ServiceID_Key, i);
        messageObtain.setData(bundle);
        try {
            messenger.send(messageObtain);
        } catch (RemoteException e) {
            this.logger.error(i2 + " SendSuccess(), failed to send reply : " + e);
            e.printStackTrace();
        }
        endTrace();
    }

    public native void ShutdownVKDevice();

    public boolean UseVulkan() {
        return false;
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        this.logger.debug("onBind " + intent.toString());
        return this.mMessenger.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            PrepareLogger();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Logger.RegisterCallback(this);
        this.logger.verbose("oncreate ");
        if (UseVulkan()) {
            this.logger.verbose("initVulkanContext ");
            initVulkanContext();
        } else {
            this.logger.verbose("initGLContext ");
            initGLContext();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.logger.verbose("onDestroy");
        if (UseVulkan()) {
            shutdownVulkanContext();
        } else {
            destroyGLContext();
        }
        super.onDestroy();
    }
}

package androidx.sqlite.util;

import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class ProcessLock {
    private static final String TAG = "SupportSQLiteLock";
    private static final Map<String, Lock> sThreadLocks = new HashMap();
    private final boolean mFileLevelLock;
    private FileChannel mLockChannel;
    private final File mLockFile;
    private final Lock mThreadLock;

    public ProcessLock(@NonNull String str, @NonNull File file, boolean z) {
        File file2 = new File(file, str + ".lck");
        this.mLockFile = file2;
        this.mThreadLock = getThreadLock(file2.getAbsolutePath());
        this.mFileLevelLock = z;
    }

    private static Lock getThreadLock(String str) {
        Lock reentrantLock;
        Map<String, Lock> map = sThreadLocks;
        synchronized (map) {
            reentrantLock = map.get(str);
            if (reentrantLock == null) {
                reentrantLock = new ReentrantLock();
                map.put(str, reentrantLock);
            }
        }
        return reentrantLock;
    }

    public void lock() throws IOException {
        lock(this.mFileLevelLock);
    }

    public void unlock() {
        FileChannel fileChannel = this.mLockChannel;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.mThreadLock.unlock();
    }

    public void lock(boolean z) throws IOException {
        this.mThreadLock.lock();
        if (z) {
            try {
                File parentFile = this.mLockFile.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileChannel channel = new FileOutputStream(this.mLockFile).getChannel();
                this.mLockChannel = channel;
                channel.lock();
            } catch (IOException unused) {
                this.mLockChannel = null;
            }
        }
    }
}

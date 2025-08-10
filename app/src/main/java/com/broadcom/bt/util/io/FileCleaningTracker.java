package com.broadcom.bt.util.io;

import java.io.File;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collection;
import java.util.Objects;
import java.util.Vector;

/* loaded from: classes.dex */
public class FileCleaningTracker {
    public Thread reaper;
    public ReferenceQueue q = new ReferenceQueue();
    public final Collection trackers = new Vector();
    public volatile boolean exitWhenFinished = false;

    public final class Reaper extends Thread {
        public Reaper() {
            super("File Reaper");
            setPriority(10);
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                if (FileCleaningTracker.this.exitWhenFinished && FileCleaningTracker.this.trackers.size() <= 0) {
                    return;
                }
                try {
                    Tracker tracker = (Tracker) FileCleaningTracker.this.q.remove();
                    if (tracker != null) {
                        tracker.delete();
                        tracker.clear();
                        FileCleaningTracker.this.trackers.remove(tracker);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public static final class Tracker extends PhantomReference {
        private final FileDeleteStrategy deleteStrategy;
        private final String path;

        public Tracker(String str, FileDeleteStrategy fileDeleteStrategy, Object obj, ReferenceQueue referenceQueue) {
            super(obj, referenceQueue);
            this.path = str;
            this.deleteStrategy = fileDeleteStrategy == null ? FileDeleteStrategy.NORMAL : fileDeleteStrategy;
        }

        public boolean delete() {
            return this.deleteStrategy.deleteQuietly(new File(this.path));
        }
    }

    private synchronized void addTracker(String str, Object obj, FileDeleteStrategy fileDeleteStrategy) {
        if (this.exitWhenFinished) {
            throw new IllegalStateException("No new trackers can be added once exitWhenFinished() is called");
        }
        if (this.reaper == null) {
            Reaper reaper = new Reaper();
            this.reaper = reaper;
            reaper.start();
        }
        this.trackers.add(new Tracker(str, fileDeleteStrategy, obj, this.q));
    }

    public synchronized void exitWhenFinished() {
        this.exitWhenFinished = true;
        Thread thread = this.reaper;
        if (thread != null) {
            synchronized (thread) {
                this.reaper.interrupt();
            }
        }
    }

    public int getTrackCount() {
        return this.trackers.size();
    }

    public void track(File file, Object obj) {
        track(file, obj, (FileDeleteStrategy) null);
    }

    public void track(File file, Object obj, FileDeleteStrategy fileDeleteStrategy) {
        Objects.requireNonNull(file, "The file must not be null");
        addTracker(file.getPath(), obj, fileDeleteStrategy);
    }

    public void track(String str, Object obj) {
        track(str, obj, (FileDeleteStrategy) null);
    }

    public void track(String str, Object obj, FileDeleteStrategy fileDeleteStrategy) {
        Objects.requireNonNull(str, "The path must not be null");
        addTracker(str, obj, fileDeleteStrategy);
    }
}

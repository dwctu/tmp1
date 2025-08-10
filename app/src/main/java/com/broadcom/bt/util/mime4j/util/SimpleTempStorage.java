package com.broadcom.bt.util.mime4j.util;

import com.broadcom.bt.util.mime4j.Log;
import com.broadcom.bt.util.mime4j.LogFactory;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

/* loaded from: classes.dex */
public class SimpleTempStorage extends TempStorage {
    private static Log log = LogFactory.getLog(SimpleTempStorage.class);
    private Random random = new Random();
    private TempPath rootPath;

    public class SimpleTempFile implements TempFile {
        private File file;

        @Override // com.broadcom.bt.util.mime4j.util.TempFile
        public void delete() {
        }

        @Override // com.broadcom.bt.util.mime4j.util.TempFile
        public String getAbsolutePath() {
            return this.file.getAbsolutePath();
        }

        @Override // com.broadcom.bt.util.mime4j.util.TempFile
        public InputStream getInputStream() throws IOException {
            return new BufferedInputStream(new FileInputStream(this.file));
        }

        @Override // com.broadcom.bt.util.mime4j.util.TempFile
        public OutputStream getOutputStream() throws IOException {
            return new BufferedOutputStream(new FileOutputStream(this.file));
        }

        @Override // com.broadcom.bt.util.mime4j.util.TempFile
        public boolean isInMemory() {
            return false;
        }

        @Override // com.broadcom.bt.util.mime4j.util.TempFile
        public long length() {
            return this.file.length();
        }

        private SimpleTempFile(File file) {
            this.file = null;
            this.file = file;
            file.deleteOnExit();
        }
    }

    public class SimpleTempPath implements TempPath {
        private File path;

        @Override // com.broadcom.bt.util.mime4j.util.TempPath
        public TempFile createTempFile() throws IOException {
            return SimpleTempStorage.this.createTempFile(this, null, null);
        }

        @Override // com.broadcom.bt.util.mime4j.util.TempPath
        public TempPath createTempPath() throws IOException {
            return SimpleTempStorage.this.createTempPath(this, null);
        }

        @Override // com.broadcom.bt.util.mime4j.util.TempPath
        public void delete() {
        }

        @Override // com.broadcom.bt.util.mime4j.util.TempPath
        public String getAbsolutePath() {
            return this.path.getAbsolutePath();
        }

        @Override // com.broadcom.bt.util.mime4j.util.TempPath
        public TempFile createTempFile(String str, String str2) throws IOException {
            return SimpleTempStorage.this.createTempFile(this, str, str2);
        }

        @Override // com.broadcom.bt.util.mime4j.util.TempPath
        public TempPath createTempPath(String str) throws IOException {
            return SimpleTempStorage.this.createTempPath(this, str);
        }

        private SimpleTempPath(String str) {
            this.path = null;
            this.path = new File(str);
        }

        @Override // com.broadcom.bt.util.mime4j.util.TempPath
        public TempFile createTempFile(String str, String str2, boolean z) throws IOException {
            return SimpleTempStorage.this.createTempFile(this, str, str2);
        }

        private SimpleTempPath(File file) {
            this.path = null;
            this.path = file;
        }
    }

    public SimpleTempStorage() {
        this.rootPath = null;
        this.rootPath = new SimpleTempPath(System.getProperty("java.io.tmpdir"));
    }

    private long createRandomFileId() {
        long jNextLong = this.random.nextLong();
        if (jNextLong >= 0) {
            return jNextLong;
        }
        if (jNextLong == Long.MIN_VALUE) {
            return Long.MAX_VALUE;
        }
        return -jNextLong;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TempFile createTempFile(TempPath tempPath, String str, String str2) throws IOException {
        File file;
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = ".tmp";
        }
        int i = 1000;
        synchronized (this) {
            do {
                long jCreateRandomFileId = createRandomFileId();
                file = new File(tempPath.getAbsolutePath(), str + jCreateRandomFileId + str2);
                i += -1;
                if (!file.exists()) {
                    break;
                }
            } while (i > 0);
            if (file.exists()) {
                throw new IOException("Creating temp file failed: Unable to find unique file name");
            }
            try {
                file.createNewFile();
            } catch (IOException unused) {
                throw new IOException("Creating dir '" + file.getAbsolutePath() + "' failed.");
            }
        }
        return new SimpleTempFile(file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TempPath createTempPath(TempPath tempPath, String str) throws IOException {
        File file;
        if (str == null) {
            str = "";
        }
        int i = 1000;
        do {
            long jCreateRandomFileId = createRandomFileId();
            file = new File(tempPath.getAbsolutePath(), str + jCreateRandomFileId);
            i += -1;
            if (!file.exists()) {
                break;
            }
        } while (i > 0);
        if (!file.exists() && file.mkdirs()) {
            return new SimpleTempPath(file);
        }
        log.error("Unable to mkdirs on " + file.getAbsolutePath());
        throw new IOException("Creating dir '" + file.getAbsolutePath() + "' failed.");
    }

    @Override // com.broadcom.bt.util.mime4j.util.TempStorage
    public TempPath getRootTempPath() {
        return this.rootPath;
    }
}

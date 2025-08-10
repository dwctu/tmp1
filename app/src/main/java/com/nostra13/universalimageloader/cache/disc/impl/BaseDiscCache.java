package com.nostra13.universalimageloader.cache.disc.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.core.DefaultConfigurationFactory;
import com.nostra13.universalimageloader.utils.IoUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public abstract class BaseDiscCache implements DiskCache {
    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
    public static final int DEFAULT_COMPRESS_QUALITY = 100;
    private static final String ERROR_ARG_NULL = " argument must be not null";
    private static final String TEMP_IMAGE_POSTFIX = ".tmp";
    public int bufferSize;
    public final File cacheDir;
    public Bitmap.CompressFormat compressFormat;
    public int compressQuality;
    public final FileNameGenerator fileNameGenerator;
    public final File reserveCacheDir;

    public BaseDiscCache(File file) {
        this(file, null);
    }

    @Override // com.nostra13.universalimageloader.cache.disc.DiscCacheAware
    public void clear() {
        File[] fileArrListFiles = this.cacheDir.listFiles();
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                file.delete();
            }
        }
    }

    @Override // com.nostra13.universalimageloader.cache.disc.DiscCacheAware
    public void close() {
    }

    @Override // com.nostra13.universalimageloader.cache.disc.DiscCacheAware
    public File get(String str) {
        return getFile(str);
    }

    @Override // com.nostra13.universalimageloader.cache.disc.DiscCacheAware
    public File getDirectory() {
        return this.cacheDir;
    }

    public File getFile(String str) {
        File file;
        String strGenerate = this.fileNameGenerator.generate(str);
        File file2 = this.cacheDir;
        if (!file2.exists() && !this.cacheDir.mkdirs() && (file = this.reserveCacheDir) != null && (file.exists() || this.reserveCacheDir.mkdirs())) {
            file2 = this.reserveCacheDir;
        }
        return new File(file2, strGenerate);
    }

    @Override // com.nostra13.universalimageloader.cache.disc.DiscCacheAware
    public boolean remove(String str) {
        return getFile(str).delete();
    }

    @Override // com.nostra13.universalimageloader.cache.disc.DiscCacheAware
    public boolean save(String str, InputStream inputStream, IoUtils.CopyListener copyListener) throws Throwable {
        boolean zCopyStream;
        File file = getFile(str);
        File file2 = new File(file.getAbsolutePath() + TEMP_IMAGE_POSTFIX);
        try {
            try {
                zCopyStream = IoUtils.copyStream(inputStream, new BufferedOutputStream(new FileOutputStream(file2), this.bufferSize), copyListener, this.bufferSize);
            } finally {
            }
        } catch (Throwable th) {
            th = th;
            zCopyStream = false;
        }
        try {
            IoUtils.closeSilently(inputStream);
            boolean z = (!zCopyStream || file2.renameTo(file)) ? zCopyStream : false;
            if (!z) {
                file2.delete();
            }
            return z;
        } catch (Throwable th2) {
            th = th2;
            IoUtils.closeSilently(inputStream);
            if (!((!zCopyStream || file2.renameTo(file)) ? zCopyStream : false)) {
                file2.delete();
            }
            throw th;
        }
    }

    public void setBufferSize(int i) {
        this.bufferSize = i;
    }

    public void setCompressFormat(Bitmap.CompressFormat compressFormat) {
        this.compressFormat = compressFormat;
    }

    public void setCompressQuality(int i) {
        this.compressQuality = i;
    }

    public BaseDiscCache(File file, File file2) {
        this(file, file2, DefaultConfigurationFactory.createFileNameGenerator());
    }

    public BaseDiscCache(File file, File file2, FileNameGenerator fileNameGenerator) {
        this.bufferSize = 32768;
        this.compressFormat = DEFAULT_COMPRESS_FORMAT;
        this.compressQuality = 100;
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (fileNameGenerator != null) {
            this.cacheDir = file;
            this.reserveCacheDir = file2;
            this.fileNameGenerator = fileNameGenerator;
            return;
        }
        throw new IllegalArgumentException("fileNameGenerator argument must be not null");
    }

    @Override // com.nostra13.universalimageloader.cache.disc.DiscCacheAware
    public boolean save(String str, Bitmap bitmap) throws IOException {
        File file = getFile(str);
        File file2 = new File(file.getAbsolutePath() + TEMP_IMAGE_POSTFIX);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2), this.bufferSize);
        try {
            boolean zCompress = bitmap.compress(this.compressFormat, this.compressQuality, bufferedOutputStream);
            IoUtils.closeSilently(bufferedOutputStream);
            if (zCompress && !file2.renameTo(file)) {
                zCompress = false;
            }
            if (!zCompress) {
                file2.delete();
            }
            bitmap.recycle();
            return zCompress;
        } catch (Throwable th) {
            IoUtils.closeSilently(bufferedOutputStream);
            file2.delete();
            throw th;
        }
    }
}

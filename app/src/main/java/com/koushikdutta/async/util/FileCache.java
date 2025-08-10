package com.koushikdutta.async.util;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/* loaded from: classes3.dex */
public class FileCache {
    private static String hashAlgorithm = "MD5";
    public static MessageDigest messageDigest;
    public File directory;
    public boolean loadAsync;
    public boolean loading;
    public long size;
    public Random random = new Random();
    public long blockSize = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
    public Comparator<File> dateCompare = new Comparator<File>() { // from class: com.koushikdutta.async.util.FileCache.1
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            long jLastModified = file.lastModified();
            long jLastModified2 = file2.lastModified();
            if (jLastModified < jLastModified2) {
                return -1;
            }
            return jLastModified2 > jLastModified ? 1 : 0;
        }
    };
    public InternalCache cache = new InternalCache();

    public class CacheEntry {
        public final long size;

        public CacheEntry(File file) {
            this.size = file.length();
        }
    }

    public class InternalCache extends LruCache<String, CacheEntry> {
        public InternalCache() {
            super(FileCache.this.size);
        }

        @Override // com.koushikdutta.async.util.LruCache
        public void entryRemoved(boolean z, String str, CacheEntry cacheEntry, CacheEntry cacheEntry2) {
            super.entryRemoved(z, (boolean) str, cacheEntry, cacheEntry2);
            if (cacheEntry2 == null && !FileCache.this.loading) {
                new File(FileCache.this.directory, str).delete();
            }
        }

        @Override // com.koushikdutta.async.util.LruCache
        public long sizeOf(String str, CacheEntry cacheEntry) {
            return Math.max(FileCache.this.blockSize, cacheEntry.size);
        }
    }

    public static class Snapshot {
        public FileInputStream[] fins;
        public long[] lens;

        public Snapshot(FileInputStream[] fileInputStreamArr, long[] jArr) {
            this.fins = fileInputStreamArr;
            this.lens = jArr;
        }

        public void close() throws IOException {
            StreamUtility.closeQuietly(this.fins);
        }

        public long getLength(int i) {
            return this.lens[i];
        }
    }

    static {
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            MessageDigest messageDigestFindAlternativeMessageDigest = findAlternativeMessageDigest();
            messageDigest = messageDigestFindAlternativeMessageDigest;
            if (messageDigestFindAlternativeMessageDigest == null) {
                throw new RuntimeException(e);
            }
        }
        try {
            messageDigest = (MessageDigest) messageDigest.clone();
        } catch (CloneNotSupportedException unused) {
        }
    }

    public FileCache(File file, long j, boolean z) {
        this.directory = file;
        this.size = j;
        this.loadAsync = z;
        file.mkdirs();
        doLoad();
    }

    private void doLoad() {
        if (this.loadAsync) {
            new Thread() { // from class: com.koushikdutta.async.util.FileCache.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    FileCache.this.load();
                }
            }.start();
        } else {
            load();
        }
    }

    private static MessageDigest findAlternativeMessageDigest() throws NoSuchAlgorithmException {
        MessageDigest messageDigest2;
        if (!"MD5".equals(hashAlgorithm)) {
            return null;
        }
        for (Provider provider : Security.getProviders()) {
            Iterator<Provider.Service> it = provider.getServices().iterator();
            while (it.hasNext()) {
                String algorithm = it.next().getAlgorithm();
                hashAlgorithm = algorithm;
                try {
                    messageDigest2 = MessageDigest.getInstance(algorithm);
                } catch (NoSuchAlgorithmException unused) {
                }
                if (messageDigest2 != null) {
                    return messageDigest2;
                }
            }
        }
        return null;
    }

    public static void removeFiles(File... fileArr) {
        if (fileArr == null) {
            return;
        }
        for (File file : fileArr) {
            file.delete();
        }
    }

    public static synchronized String toKeyString(Object... objArr) {
        messageDigest.reset();
        for (Object obj : objArr) {
            messageDigest.update(obj.toString().getBytes());
        }
        return new BigInteger(1, messageDigest.digest()).toString(16);
    }

    public void clear() {
        removeFiles(this.directory.listFiles());
        this.cache.evictAll();
    }

    public void commitTempFiles(String str, File... fileArr) {
        removePartFiles(str);
        for (int i = 0; i < fileArr.length; i++) {
            File file = fileArr[i];
            File partFile = getPartFile(str, i);
            if (!file.renameTo(partFile)) {
                removeFiles(fileArr);
                remove(str);
                return;
            } else {
                remove(file.getName());
                this.cache.put(getPartName(str, i), new CacheEntry(partFile));
            }
        }
    }

    public boolean exists(String str, int i) {
        return getPartFile(str, i).exists();
    }

    public FileInputStream get(String str) throws IOException {
        return new FileInputStream(touch(getPartFile(str, 0)));
    }

    public File getFile(String str) {
        return touch(getPartFile(str, 0));
    }

    public File getPartFile(String str, int i) {
        return new File(this.directory, getPartName(str, i));
    }

    public String getPartName(String str, int i) {
        return str + "." + i;
    }

    public File getTempFile() {
        File file;
        do {
            file = new File(this.directory, new BigInteger(128, this.random).toString(16));
        } while (file.exists());
        return file;
    }

    public File[] getTempFiles(int i) {
        File[] fileArr = new File[i];
        for (int i2 = 0; i2 < i; i2++) {
            fileArr[i2] = getTempFile();
        }
        return fileArr;
    }

    public Set<String> keySet() {
        HashSet hashSet = new HashSet();
        File[] fileArrListFiles = this.directory.listFiles();
        if (fileArrListFiles == null) {
            return hashSet;
        }
        for (File file : fileArrListFiles) {
            String name = file.getName();
            int iLastIndexOf = name.lastIndexOf(46);
            if (iLastIndexOf != -1) {
                hashSet.add(name.substring(0, iLastIndexOf));
            }
        }
        return hashSet;
    }

    public void load() {
        this.loading = true;
        try {
            File[] fileArrListFiles = this.directory.listFiles();
            if (fileArrListFiles == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            Collections.addAll(arrayList, fileArrListFiles);
            Collections.sort(arrayList, this.dateCompare);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                File file = (File) it.next();
                String name = file.getName();
                this.cache.put(name, new CacheEntry(file));
                this.cache.get(name);
            }
        } finally {
            this.loading = false;
        }
    }

    public void remove(String str) {
        for (int i = 0; this.cache.remove(getPartName(str, i)) != null; i++) {
        }
        removePartFiles(str);
    }

    public void removePartFiles(String str) {
        int i = 0;
        while (true) {
            File partFile = getPartFile(str, i);
            if (!partFile.exists()) {
                return;
            }
            partFile.delete();
            i++;
        }
    }

    public void setBlockSize(long j) {
        this.blockSize = j;
    }

    public void setMaxSize(long j) {
        this.cache.setMaxSize(j);
        doLoad();
    }

    public long size() {
        return this.cache.size();
    }

    public File touch(File file) {
        this.cache.get(file.getName());
        file.setLastModified(System.currentTimeMillis());
        return file;
    }

    public boolean exists(String str) {
        return getPartFile(str, 0).exists();
    }

    public FileInputStream[] get(String str, int i) throws IOException {
        FileInputStream[] fileInputStreamArr = new FileInputStream[i];
        for (int i2 = 0; i2 < i; i2++) {
            try {
                fileInputStreamArr[i2] = new FileInputStream(touch(getPartFile(str, i2)));
            } catch (IOException e) {
                for (int i3 = 0; i3 < i; i3++) {
                    StreamUtility.closeQuietly(fileInputStreamArr[i3]);
                }
                remove(str);
                throw e;
            }
        }
        return fileInputStreamArr;
    }
}

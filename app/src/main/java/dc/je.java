package dc;

import android.content.res.AssetFileDescriptor;
import android.os.ParcelFileDescriptor;
import com.google.common.primitives.UnsignedInts;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collection;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.UShort;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* compiled from: ZipResourceFile.java */
/* loaded from: classes.dex */
public class je {
    public HashMap<String, a> a = new HashMap<>();
    public HashMap<File, ZipFile> b = new HashMap<>();

    /* compiled from: ZipResourceFile.java */
    public static final class a {
        public final File a;
        public final String b;
        public final String c;
        public long d;
        public int e;
        public long f;
        public long g;
        public long h;
        public long i;
        public long j = -1;

        public a(String str, File file, String str2) {
            this.b = str2;
            this.c = str;
            this.a = file;
        }

        public AssetFileDescriptor a() {
            if (this.e != 0) {
                return null;
            }
            try {
                return new AssetFileDescriptor(ParcelFileDescriptor.open(this.a, 268435456), b(), this.i);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }

        public long b() {
            return this.j;
        }

        public File c() {
            return this.a;
        }

        public String d() {
            return this.c;
        }

        public boolean e() {
            return this.e == 0;
        }

        public void f(RandomAccessFile randomAccessFile, ByteBuffer byteBuffer) throws IOException {
            long j = this.d;
            try {
                randomAccessFile.seek(j);
                randomAccessFile.readFully(byteBuffer.array());
                if (byteBuffer.getInt(0) != 67324752) {
                    throw new IOException();
                }
                this.j = j + 30 + (byteBuffer.getShort(26) & UShort.MAX_VALUE) + (byteBuffer.getShort(28) & UShort.MAX_VALUE);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public je(String str) throws IOException {
        ByteBuffer.allocate(4);
        a(str);
    }

    public static int e(RandomAccessFile randomAccessFile) throws IOException {
        return f(randomAccessFile.readInt());
    }

    public static int f(int i) {
        return ((i & 255) << 24) + ((65280 & i) << 8) + ((16711680 & i) >>> 8) + ((i >>> 24) & 255);
    }

    public void a(String str) throws IOException {
        String str2 = str;
        File file = new File(str2);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, StreamManagement.AckRequest.ELEMENT);
        long length = randomAccessFile.length();
        if (length < 22) {
            throw new IOException();
        }
        long j = 65557 > length ? length : 65557L;
        randomAccessFile.seek(0L);
        int iE = e(randomAccessFile);
        if (iE == 101010256) {
            throw new IOException();
        }
        if (iE != 67324752) {
            throw new IOException();
        }
        randomAccessFile.seek(length - j);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) j);
        byte[] bArrArray = byteBufferAllocate.array();
        randomAccessFile.readFully(bArrArray);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        int length2 = bArrArray.length - 22;
        while (length2 >= 0 && (bArrArray[length2] != 80 || byteBufferAllocate.getInt(length2) != 101010256)) {
            length2--;
        }
        if (length2 < 0) {
            String str3 = "Zip: EOCD not found, " + str2 + " is not zip";
        }
        short s = byteBufferAllocate.getShort(length2 + 8);
        long j2 = byteBufferAllocate.getInt(length2 + 12) & UnsignedInts.INT_MASK;
        long j3 = byteBufferAllocate.getInt(length2 + 16) & UnsignedInts.INT_MASK;
        if (j3 + j2 > length) {
            String str4 = "bad offsets (dir " + j3 + ", size " + j2 + ", eocd " + length2 + ")";
            throw new IOException();
        }
        if (s == 0) {
            throw new IOException();
        }
        MappedByteBuffer map = randomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, j3, j2);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        map.order(byteOrder);
        short s2 = UShort.MAX_VALUE;
        byte[] bArr = new byte[65535];
        ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(30);
        byteBufferAllocate2.order(byteOrder);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < s) {
            if (map.getInt(i3) != 33639248) {
                String str5 = "Missed a central dir sig (at " + i3 + ")";
                throw new IOException();
            }
            int i4 = map.getShort(i3 + 28) & s2;
            int i5 = map.getShort(i3 + 30) & s2;
            int i6 = map.getShort(i3 + 32) & s2;
            map.position(i3 + 46);
            map.get(bArr, i, i4);
            map.position(i);
            String str6 = new String(bArr, i, i4);
            a aVar = new a(str2, file, str6);
            aVar.e = map.getShort(i3 + 10) & s2;
            aVar.f = map.getInt(i3 + 12) & UnsignedInts.INT_MASK;
            aVar.g = map.getLong(i3 + 16) & UnsignedInts.INT_MASK;
            aVar.h = map.getLong(i3 + 20) & UnsignedInts.INT_MASK;
            aVar.i = map.getLong(i3 + 24) & UnsignedInts.INT_MASK;
            aVar.d = map.getInt(i3 + 42) & UnsignedInts.INT_MASK;
            byteBufferAllocate2.clear();
            aVar.f(randomAccessFile, byteBufferAllocate2);
            this.a.put(str6, aVar);
            i3 += i4 + 46 + i5 + i6;
            i2++;
            str2 = str;
            bArr = bArr;
            i = 0;
            s2 = UShort.MAX_VALUE;
        }
    }

    public a[] b() {
        Collection<a> collectionValues = this.a.values();
        return (a[]) collectionValues.toArray(new a[collectionValues.size()]);
    }

    public AssetFileDescriptor c(String str) {
        a aVar = this.a.get(str);
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    public InputStream d(String str) throws IOException {
        a aVar = this.a.get(str);
        if (aVar == null) {
            return null;
        }
        if (aVar.e()) {
            return aVar.a().createInputStream();
        }
        ZipFile zipFile = this.b.get(aVar.c());
        if (zipFile == null) {
            zipFile = new ZipFile(aVar.c(), 1);
            this.b.put(aVar.c(), zipFile);
        }
        ZipEntry entry = zipFile.getEntry(str);
        if (entry != null) {
            return zipFile.getInputStream(entry);
        }
        return null;
    }
}

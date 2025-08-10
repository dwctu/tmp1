package androidx.multidex;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.primitives.UnsignedInts;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* loaded from: classes.dex */
public final class ZipUtil {
    private static final int BUFFER_SIZE = 16384;
    private static final int ENDHDR = 22;
    private static final int ENDSIG = 101010256;

    public static class CentralDirectory {
        public long offset;
        public long size;
    }

    public static long computeCrcOfCentralDir(RandomAccessFile randomAccessFile, CentralDirectory centralDirectory) throws IOException {
        CRC32 crc32 = new CRC32();
        long j = centralDirectory.size;
        randomAccessFile.seek(centralDirectory.offset);
        byte[] bArr = new byte[16384];
        int i = randomAccessFile.read(bArr, 0, (int) Math.min(PlaybackStateCompat.ACTION_PREPARE, j));
        while (i != -1) {
            crc32.update(bArr, 0, i);
            j -= i;
            if (j == 0) {
                break;
            }
            i = randomAccessFile.read(bArr, 0, (int) Math.min(PlaybackStateCompat.ACTION_PREPARE, j));
        }
        return crc32.getValue();
    }

    public static CentralDirectory findCentralDirectory(RandomAccessFile randomAccessFile) throws IOException {
        long length = randomAccessFile.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + randomAccessFile.length());
        }
        long j = length - PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        long j2 = j >= 0 ? j : 0L;
        int iReverseBytes = Integer.reverseBytes(ENDSIG);
        do {
            randomAccessFile.seek(length);
            if (randomAccessFile.readInt() == iReverseBytes) {
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                randomAccessFile.skipBytes(2);
                CentralDirectory centralDirectory = new CentralDirectory();
                centralDirectory.size = Integer.reverseBytes(randomAccessFile.readInt()) & UnsignedInts.INT_MASK;
                centralDirectory.offset = Integer.reverseBytes(randomAccessFile.readInt()) & UnsignedInts.INT_MASK;
                return centralDirectory;
            }
            length--;
        } while (length >= j2);
        throw new ZipException("End Of Central Directory signature not found");
    }

    public static long getZipCrc(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, StreamManagement.AckRequest.ELEMENT);
        try {
            return computeCrcOfCentralDir(randomAccessFile, findCentralDirectory(randomAccessFile));
        } finally {
            randomAccessFile.close();
        }
    }
}

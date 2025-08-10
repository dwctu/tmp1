package no.nordicsemi.android.dfu.internal;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import no.nordicsemi.android.dfu.internal.manifest.Manifest;
import no.nordicsemi.android.dfu.internal.manifest.ManifestFile;

/* loaded from: classes5.dex */
public class ArchiveInputStream extends InputStream {
    private static final String APPLICATION_BIN = "application.bin";
    private static final String APPLICATION_HEX = "application.hex";
    private static final String APPLICATION_INIT = "application.dat";
    private static final String BOOTLOADER_BIN = "bootloader.bin";
    private static final String BOOTLOADER_HEX = "bootloader.hex";
    private static final String MANIFEST = "manifest.json";
    private static final String SOFTDEVICE_BIN = "softdevice.bin";
    private static final String SOFTDEVICE_HEX = "softdevice.hex";
    private static final String SYSTEM_INIT = "system.dat";
    private static final String TAG = "DfuArchiveInputStream";

    @Nullable
    private byte[] applicationBytes;

    @Nullable
    private byte[] applicationInitBytes;
    private int applicationSize;

    @Nullable
    private byte[] bootloaderBytes;
    private int bootloaderSize;
    private int bytesRead;
    private int bytesReadFromCurrentSource;
    private int bytesReadFromMarkedSource;
    private final CRC32 crc32;

    @Nullable
    private byte[] currentSource;
    private final Map<String, byte[]> entries;
    private Manifest manifest;

    @Nullable
    private byte[] markedSource;

    @Nullable
    private byte[] softDeviceAndBootloaderBytes;

    @Nullable
    private byte[] softDeviceBytes;
    private int softDeviceSize;

    @Nullable
    private byte[] systemInitBytes;
    private int type;
    private final ZipInputStream zipInputStream;

    /* JADX WARN: Removed duplicated region for block: B:74:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x024a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ArchiveInputStream(java.io.InputStream r6, int r7, int r8) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 655
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.internal.ArchiveInputStream.<init>(java.io.InputStream, int, int):void");
    }

    private void parseZip(int i) throws IOException {
        byte[] bArr = new byte[1024];
        String str = null;
        while (true) {
            ZipEntry nextEntry = this.zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            }
            String strValidateFilename = validateFilename(nextEntry.getName(), ".");
            if (nextEntry.isDirectory()) {
                String str2 = "A directory found in the ZIP: " + strValidateFilename + "!";
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int i2 = this.zipInputStream.read(bArr);
                    if (i2 == -1) {
                        break;
                    } else {
                        byteArrayOutputStream.write(bArr, 0, i2);
                    }
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (strValidateFilename.toLowerCase(Locale.US).endsWith("hex")) {
                    HexInputStream hexInputStream = new HexInputStream(byteArray, i);
                    byteArray = new byte[hexInputStream.available()];
                    hexInputStream.read(byteArray);
                    hexInputStream.close();
                }
                if (MANIFEST.equals(strValidateFilename)) {
                    str = Build.VERSION.SDK_INT >= 19 ? new String(byteArray, StandardCharsets.UTF_8) : new String(byteArray, "UTF-8");
                } else {
                    this.entries.put(strValidateFilename, byteArray);
                }
            }
        }
        if (this.entries.isEmpty()) {
            throw new FileNotFoundException("No files found in the ZIP. Check if the URI provided is valid and the ZIP contains required files on root level, not in a directory.");
        }
        if (str != null) {
            this.manifest = ((ManifestFile) new Gson().fromJson(str, ManifestFile.class)).getManifest();
        }
    }

    private int rawRead(@NonNull byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.currentSource;
        if (bArr2 == null || i < 0 || i2 < 0) {
            return -1;
        }
        int iMin = Math.min(i2, bArr2.length - this.bytesReadFromCurrentSource);
        System.arraycopy(this.currentSource, this.bytesReadFromCurrentSource, bArr, i, iMin);
        this.bytesReadFromCurrentSource += iMin;
        this.bytesRead += iMin;
        this.crc32.update(bArr, i, iMin);
        return iMin;
    }

    private byte[] startNextFile() {
        byte[] bArr;
        byte[] bArr2 = this.currentSource;
        if (bArr2 != this.softDeviceBytes || (bArr = this.bootloaderBytes) == null || (this.type & 2) <= 0) {
            bArr = this.applicationBytes;
            if (bArr2 == bArr || bArr == null || (this.type & 4) <= 0) {
                bArr = null;
                this.currentSource = null;
            } else {
                this.currentSource = bArr;
            }
        } else {
            this.currentSource = bArr;
        }
        this.bytesReadFromCurrentSource = 0;
        return bArr;
    }

    private String validateFilename(@NonNull String str, @NonNull String str2) throws IOException {
        String canonicalPath = new File(str).getCanonicalPath();
        if (canonicalPath.startsWith(new File(str2).getCanonicalPath())) {
            return canonicalPath.substring(1);
        }
        throw new IllegalStateException("File is outside extraction target directory.");
    }

    public int applicationImageSize() {
        if ((this.type & 4) > 0) {
            return this.applicationSize;
        }
        return 0;
    }

    @Override // java.io.InputStream
    public int available() {
        int iSoftDeviceImageSize;
        int i;
        byte[] bArr = this.softDeviceAndBootloaderBytes;
        if (bArr == null || this.softDeviceSize != 0 || this.bootloaderSize != 0 || (this.type & 3) <= 0) {
            iSoftDeviceImageSize = softDeviceImageSize() + bootloaderImageSize() + applicationImageSize();
            i = this.bytesRead;
        } else {
            iSoftDeviceImageSize = bArr.length + applicationImageSize();
            i = this.bytesRead;
        }
        return iSoftDeviceImageSize - i;
    }

    public int bootloaderImageSize() {
        if ((this.type & 2) > 0) {
            return this.bootloaderSize;
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.softDeviceBytes = null;
        this.bootloaderBytes = null;
        this.applicationBytes = null;
        this.softDeviceAndBootloaderBytes = null;
        this.applicationSize = 0;
        this.bootloaderSize = 0;
        this.softDeviceSize = 0;
        this.currentSource = null;
        this.bytesReadFromCurrentSource = 0;
        this.bytesRead = 0;
        this.zipInputStream.close();
    }

    public void fullReset() {
        byte[] bArr;
        byte[] bArr2 = this.softDeviceBytes;
        if (bArr2 != null && (bArr = this.bootloaderBytes) != null && this.currentSource == bArr) {
            this.currentSource = bArr2;
        }
        this.bytesReadFromCurrentSource = 0;
        mark(0);
        reset();
    }

    public byte[] getApplicationInit() {
        return this.applicationInitBytes;
    }

    public int getBytesRead() {
        return this.bytesRead;
    }

    public int getContentType() {
        this.type = 0;
        if (this.softDeviceAndBootloaderBytes != null) {
            this.type = 0 | 3;
        }
        if (this.softDeviceSize > 0) {
            this.type |= 1;
        }
        if (this.bootloaderSize > 0) {
            this.type |= 2;
        }
        if (this.applicationSize > 0) {
            this.type |= 4;
        }
        return this.type;
    }

    public long getCrc32() {
        return this.crc32.getValue();
    }

    public byte[] getSystemInit() {
        return this.systemInitBytes;
    }

    public boolean isSecureDfuRequired() {
        Manifest manifest = this.manifest;
        return manifest != null && manifest.isSecureDfuRequired();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.markedSource = this.currentSource;
        this.bytesReadFromMarkedSource = this.bytesReadFromCurrentSource;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        byte[] bArr = new byte[1];
        if (read(bArr) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public void reset() {
        int i;
        byte[] bArr;
        this.currentSource = this.markedSource;
        int i2 = this.bytesReadFromMarkedSource;
        this.bytesReadFromCurrentSource = i2;
        this.bytesRead = i2;
        this.crc32.reset();
        if (this.currentSource == this.bootloaderBytes && (bArr = this.softDeviceBytes) != null) {
            this.crc32.update(bArr);
            this.bytesRead += this.softDeviceSize;
        }
        byte[] bArr2 = this.currentSource;
        if (bArr2 == null || (i = this.bytesReadFromCurrentSource) <= 0) {
            return;
        }
        this.crc32.update(bArr2, 0, i);
    }

    public int setContentType(int i) {
        byte[] bArr;
        this.type = i;
        int i2 = i & 4;
        if (i2 > 0 && this.applicationBytes == null) {
            this.type = i & (-5);
        }
        int i3 = i & 3;
        if (i3 == 3) {
            if (this.softDeviceBytes == null && this.softDeviceAndBootloaderBytes == null) {
                this.type &= -2;
            }
            if (this.bootloaderBytes == null && this.softDeviceAndBootloaderBytes == null) {
                this.type &= -2;
            }
        } else if (this.softDeviceAndBootloaderBytes != null) {
            this.type &= -4;
        }
        if (i3 > 0 && (bArr = this.softDeviceAndBootloaderBytes) != null) {
            this.currentSource = bArr;
        } else if ((i & 1) > 0) {
            this.currentSource = this.softDeviceBytes;
        } else if ((i & 2) > 0) {
            this.currentSource = this.bootloaderBytes;
        } else if (i2 > 0) {
            this.currentSource = this.applicationBytes;
        }
        this.bytesReadFromCurrentSource = 0;
        mark(0);
        reset();
        return this.type;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return 0L;
    }

    public int softDeviceImageSize() {
        if ((this.type & 1) > 0) {
            return this.softDeviceSize;
        }
        return 0;
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) {
        int iRawRead = rawRead(bArr, i, i2);
        return (i2 <= iRawRead || startNextFile() == null) ? iRawRead : iRawRead + rawRead(bArr, i + iRawRead, i2 - iRawRead);
    }
}

package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@SafeParcelable.Class(creator = "SafeBrowsingDataCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public class SafeBrowsingData extends AbstractSafeParcelable {

    @SafeParcelable.Field(getter = "getMetadata", id = 2)
    private String zzm;

    @SafeParcelable.Field(getter = "getBlacklistsDataHolder", id = 3)
    private DataHolder zzn;

    @SafeParcelable.Field(getter = "getFileDescriptor", id = 4)
    private ParcelFileDescriptor zzo;

    @SafeParcelable.Field(getter = "getLastUpdateTimeMs", id = 5)
    private long zzp;

    @SafeParcelable.Field(getter = "getState", id = 6)
    private byte[] zzq;
    private byte[] zzr;
    private File zzs;
    private static final String TAG = SafeBrowsingData.class.getSimpleName();
    public static final Parcelable.Creator<SafeBrowsingData> CREATOR = new zzj();

    public SafeBrowsingData() {
        this(null, null, null, 0L, null);
    }

    public SafeBrowsingData(long j, byte[] bArr) {
        this(null, null, null, j, bArr);
    }

    public SafeBrowsingData(String str) {
        this(str, null, null, 0L, null);
    }

    public SafeBrowsingData(String str, DataHolder dataHolder) {
        this(str, dataHolder, null, 0L, null);
    }

    @SafeParcelable.Constructor
    public SafeBrowsingData(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) DataHolder dataHolder, @SafeParcelable.Param(id = 4) ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.Param(id = 5) long j, @SafeParcelable.Param(id = 6) byte[] bArr) {
        this.zzm = str;
        this.zzn = dataHolder;
        this.zzo = parcelFileDescriptor;
        this.zzp = j;
        this.zzq = bArr;
    }

    private final FileOutputStream zza() throws Throwable {
        Throwable th;
        File fileCreateTempFile;
        File file = this.zzs;
        if (file == null) {
            return null;
        }
        try {
            fileCreateTempFile = File.createTempFile("xlb", ".tmp", file);
        } catch (IOException unused) {
            fileCreateTempFile = null;
        } catch (Throwable th2) {
            th = th2;
            fileCreateTempFile = null;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
            this.zzo = ParcelFileDescriptor.open(fileCreateTempFile, 268435456);
            if (fileCreateTempFile != null) {
                fileCreateTempFile.delete();
            }
            return fileOutputStream;
        } catch (IOException unused2) {
            if (fileCreateTempFile != null) {
                fileCreateTempFile.delete();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (fileCreateTempFile != null) {
                fileCreateTempFile.delete();
            }
            throw th;
        }
    }

    private static void zza(Closeable closeable) throws IOException {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public byte[] getBlacklists() throws IOException {
        if (this.zzo == null) {
            return null;
        }
        DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.zzo));
        try {
            byte[] bArr = new byte[dataInputStream.readInt()];
            dataInputStream.read(bArr);
            return bArr;
        } catch (IOException unused) {
            return null;
        } finally {
            zza(dataInputStream);
            this.zzo = null;
        }
    }

    public DataHolder getBlacklistsDataHolder() {
        return this.zzn;
    }

    public ParcelFileDescriptor getFileDescriptor() {
        return this.zzo;
    }

    public long getLastUpdateTimeMs() {
        return this.zzp;
    }

    public String getMetadata() {
        return this.zzm;
    }

    public byte[] getState() {
        return this.zzq;
    }

    public void setBlacklists(byte[] bArr) {
        this.zzr = bArr;
    }

    public void setTempDir(File file) {
        if (file != null) {
            this.zzs = file;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) throws IOException {
        boolean z;
        FileOutputStream fileOutputStreamZza;
        if (this.zzo != null || this.zzr == null || (fileOutputStreamZza = zza()) == null) {
            z = false;
        } else {
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(fileOutputStreamZza));
            try {
                dataOutputStream.writeInt(this.zzr.length);
                dataOutputStream.write(this.zzr);
                zza(dataOutputStream);
                z = true;
            } catch (IOException unused) {
                zza(dataOutputStream);
            } catch (Throwable th) {
                zza(dataOutputStream);
                throw th;
            }
        }
        if (z) {
            i |= 1;
        }
        zzj.zza(this, parcel, i);
        this.zzo = null;
    }
}

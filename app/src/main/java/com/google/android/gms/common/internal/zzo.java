package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes2.dex */
public final class zzo implements ServiceConnection, zzs {
    public final /* synthetic */ zzr zza;
    private final Map zzb = new HashMap();
    private int zzc = 2;
    private boolean zzd;

    @Nullable
    private IBinder zze;
    private final zzn zzf;
    private ComponentName zzg;

    public zzo(zzr zzrVar, zzn zznVar) {
        this.zza = zzrVar;
        this.zzf = zznVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.zza.zzb) {
            this.zza.zzd.removeMessages(1, this.zzf);
            this.zze = iBinder;
            this.zzg = componentName;
            Iterator it = this.zzb.values().iterator();
            while (it.hasNext()) {
                ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
            }
            this.zzc = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.zza.zzb) {
            this.zza.zzd.removeMessages(1, this.zzf);
            this.zze = null;
            this.zzg = componentName;
            Iterator it = this.zzb.values().iterator();
            while (it.hasNext()) {
                ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
            }
            this.zzc = 2;
        }
    }

    public final int zza() {
        return this.zzc;
    }

    public final ComponentName zzb() {
        return this.zzg;
    }

    @Nullable
    public final IBinder zzc() {
        return this.zze;
    }

    public final void zzd(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.zzb.put(serviceConnection, serviceConnection2);
    }

    public final void zze(String str, @Nullable Executor executor) {
        this.zzc = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (PlatformVersion.isAtLeastS()) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            zzr zzrVar = this.zza;
            boolean zZza = zzrVar.zzf.zza(zzrVar.zzc, str, this.zzf.zzc(zzrVar.zzc), this, this.zzf.zza(), executor);
            this.zzd = zZza;
            if (zZza) {
                this.zza.zzd.sendMessageDelayed(this.zza.zzd.obtainMessage(1, this.zzf), this.zza.zzh);
            } else {
                this.zzc = 2;
                try {
                    zzr zzrVar2 = this.zza;
                    zzrVar2.zzf.unbindService(zzrVar2.zzc, this);
                } catch (IllegalArgumentException unused) {
                }
            }
        } finally {
            StrictMode.setVmPolicy(vmPolicy);
        }
    }

    public final void zzf(ServiceConnection serviceConnection, String str) {
        this.zzb.remove(serviceConnection);
    }

    public final void zzg(String str) {
        this.zza.zzd.removeMessages(1, this.zzf);
        zzr zzrVar = this.zza;
        zzrVar.zzf.unbindService(zzrVar.zzc, this);
        this.zzd = false;
        this.zzc = 2;
    }

    public final boolean zzh(ServiceConnection serviceConnection) {
        return this.zzb.containsKey(serviceConnection);
    }

    public final boolean zzi() {
        return this.zzb.isEmpty();
    }

    public final boolean zzj() {
        return this.zzd;
    }
}

package com.wear.backgroundservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import dc.bp1;
import dc.cp1;
import java.io.FileDescriptor;

/* loaded from: classes3.dex */
public class MainClientService extends Service implements IBinder {
    public static c d;
    public cp1 a;
    public long b;
    public final bp1.a c = new b();

    public class a implements cp1.a {
        public a(MainClientService mainClientService) {
        }

        @Override // dc.cp1.a
        public void a(long j) {
            if (MainClientService.d != null) {
                MainClientService.d.a(j);
            }
        }
    }

    public class b extends bp1.a {
        public b() {
        }

        @Override // dc.bp1
        public int getPid() throws RemoteException {
            return MainClientService.this.a.d();
        }

        @Override // dc.bp1
        public void n() throws RemoteException {
            MainClientService.this.a.h();
        }

        @Override // dc.bp1
        public void o(boolean z) throws RemoteException {
            MainClientService.this.a.f(true);
        }

        @Override // dc.bp1
        public boolean p() throws RemoteException {
            return MainClientService.this.a.c();
        }

        @Override // dc.bp1
        public void q(long j) throws RemoteException {
            MainClientService.this.a.g(j);
        }
    }

    public interface c {
        void a(long j);
    }

    @Override // android.os.IBinder
    public void dump(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
    }

    @Override // android.os.IBinder
    public void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException {
    }

    @Override // android.os.IBinder
    public String getInterfaceDescriptor() throws RemoteException {
        return null;
    }

    @Override // android.os.IBinder
    public boolean isBinderAlive() {
        return false;
    }

    @Override // android.os.IBinder
    public void linkToDeath(IBinder.DeathRecipient deathRecipient, int i) throws RemoteException {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        bp1.a aVar = this.c;
        aVar.asBinder();
        return aVar;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (this.a == null) {
            this.a = new cp1(this.b, this);
        }
        this.a.e(new a(this));
    }

    @Override // android.os.IBinder
    public boolean pingBinder() {
        return false;
    }

    @Override // android.os.IBinder
    public IInterface queryLocalInterface(String str) {
        return null;
    }

    @Override // android.os.IBinder
    public boolean transact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        return false;
    }

    @Override // android.os.IBinder
    public boolean unlinkToDeath(IBinder.DeathRecipient deathRecipient, int i) {
        return false;
    }
}

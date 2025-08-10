package com.huawei.hms.hmsscankit;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.huawei.hms.feature.dynamic.DeferredLifecycleHelper;
import com.huawei.hms.feature.dynamic.LifecycleDelegate;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.feature.dynamic.OnDelegateCreatedListener;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;
import com.huawei.hms.hmsscankit.api.IOnLightCallback;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.hmsscankit.api.IRemoteViewDelegate;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.scankit.p.C0384pb;

/* loaded from: classes3.dex */
public class RemoteView extends FrameLayout {
    public static final int REQUEST_CODE_PHOTO = 4371;
    private static final String TAG = "ScanKitRemoteView";
    private boolean flagForGallery;
    private Context mContext;
    private boolean mContinuouslyScan;
    private a mRemoteHelper;
    private boolean mReturnedBitmap;

    public static class Builder {
        public Activity mContext;
        public HmsScanAnalyzerOptions mFormat;
        public Rect mRect;
        public boolean mIsCustomed = true;
        public boolean mContinuouslyScan = true;
        public boolean mReturnedBitmap = false;

        public RemoteView build() {
            Activity activity = this.mContext;
            boolean z = this.mIsCustomed;
            HmsScanAnalyzerOptions hmsScanAnalyzerOptions = this.mFormat;
            return new RemoteView(activity, z, hmsScanAnalyzerOptions == null ? 0 : hmsScanAnalyzerOptions.mode, this.mRect).setContinuouslyScan(this.mContinuouslyScan).enableReturnBitmap(this.mReturnedBitmap);
        }

        public Builder enableReturnBitmap() {
            this.mReturnedBitmap = true;
            return this;
        }

        public Builder setBoundingBox(Rect rect) {
            this.mRect = rect;
            return this;
        }

        public Builder setContext(Activity activity) {
            this.mContext = activity;
            return this;
        }

        public Builder setContinuouslyScan(boolean z) {
            this.mContinuouslyScan = z;
            return this;
        }

        public Builder setFormat(int i, int... iArr) {
            this.mFormat = new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(i, iArr).create();
            return this;
        }
    }

    public class a extends DeferredLifecycleHelper<b> {
        private ViewGroup f;
        private Activity g;
        private OnDelegateCreatedListener<b> h;
        private IRemoteViewDelegate i;
        private IOnResultCallback j = null;
        private boolean k;
        private boolean l;
        private int m;
        private IOnLightCallback n;
        private Rect o;
        private Bundle p;
        private boolean q;
        private boolean r;

        public a(Activity activity, ViewGroup viewGroup, boolean z, int i, Rect rect) {
            this.f = viewGroup;
            this.g = activity;
            this.k = z;
            this.m = i;
            this.o = rect;
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper
        public void createDelegate(OnDelegateCreatedListener<b> onDelegateCreatedListener) throws IllegalAccessException, InstantiationException {
            Bundle bundle;
            IRemoteCreator iRemoteCreatorC;
            this.h = onDelegateCreatedListener;
            if (onDelegateCreatedListener == null || getDelegate() != null) {
                return;
            }
            this.i = null;
            try {
                bundle = new Bundle();
                boolean z = this.k;
                if (!z && this.m == 0 && this.o == null) {
                    com.huawei.hms.scankit.util.a.c(RemoteView.TAG, "!mCustomed && mFormatValue == 0 && mRect == null");
                } else {
                    bundle.putBoolean(DetailRect.CUSTOMED_FLAG, z);
                    bundle.putInt(DetailRect.FORMAT_FLAG, this.m);
                    Rect rect = this.o;
                    if (rect != null) {
                        bundle.putParcelable(DetailRect.RECT_FLAG, rect);
                    }
                }
                boolean z2 = this.q;
                if (z2) {
                    bundle.putBoolean(DetailRect.SCAN_OFFSCEEN_FLAG, z2);
                }
                boolean z3 = this.l;
                if (z3) {
                    bundle.putBoolean(DetailRect.DEEPLINK_JUMP_FLAG, z3);
                    bundle.putAll(this.p);
                }
                bundle.putInt(DetailRect.TYPE_TRANS, 3);
                bundle.putBoolean(DetailRect.RETURN_BITMAP, this.r);
                bundle.putAll(C0384pb.a(this.g));
                bundle.putBoolean(DetailRect.SCAN_NEW_UI, true);
                iRemoteCreatorC = j.c(this.g);
            } catch (RemoteException unused) {
                com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
            }
            if (iRemoteCreatorC == null) {
                return;
            }
            this.i = iRemoteCreatorC.newRemoteViewDelegate(ObjectWrapper.wrap(this.g), ObjectWrapper.wrap(bundle));
            IRemoteViewDelegate iRemoteViewDelegate = this.i;
            if (iRemoteViewDelegate == null) {
                return;
            }
            try {
                IOnResultCallback iOnResultCallback = this.j;
                if (iOnResultCallback != null) {
                    iRemoteViewDelegate.setOnResultCallback(iOnResultCallback);
                    this.i.setOnClickListener(ObjectWrapper.wrap(new h(this)));
                }
                this.i.setOnClickListener(ObjectWrapper.wrap(new i(this)));
                IOnLightCallback iOnLightCallback = this.n;
                if (iOnLightCallback != null) {
                    this.i.setOnLightVisbleCallBack(iOnLightCallback);
                }
            } catch (RemoteException unused2) {
                com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
            }
            this.h.onDelegateCreated(new b(this.f, this.i));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(boolean z) {
            this.l = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            IRemoteViewDelegate iRemoteViewDelegate = this.i;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.resumeContinuouslyScan();
                } catch (RemoteException unused) {
                    com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean e() {
            IRemoteViewDelegate iRemoteViewDelegate = this.i;
            if (iRemoteViewDelegate == null) {
                return false;
            }
            try {
                iRemoteViewDelegate.turnOffLight();
                return true;
            } catch (RemoteException unused) {
                com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean f() {
            IRemoteViewDelegate iRemoteViewDelegate = this.i;
            if (iRemoteViewDelegate == null) {
                return false;
            }
            try {
                iRemoteViewDelegate.turnOnLight();
                return true;
            } catch (RemoteException unused) {
                com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
                return false;
            }
        }

        public void b(boolean z) {
            this.r = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            IRemoteViewDelegate iRemoteViewDelegate = this.i;
            if (iRemoteViewDelegate == null) {
                return false;
            }
            try {
                return iRemoteViewDelegate.getLightStatus();
            } catch (RemoteException unused) {
                com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            IRemoteViewDelegate iRemoteViewDelegate = this.i;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.pauseContinuouslyScan();
                } catch (RemoteException unused) {
                    com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Bundle bundle) {
            this.p = bundle;
        }

        public void a(boolean z) {
            this.q = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(IOnResultCallback iOnResultCallback) {
            this.j = iOnResultCallback;
            IRemoteViewDelegate iRemoteViewDelegate = this.i;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.setOnResultCallback(iOnResultCallback);
                } catch (RemoteException unused) {
                    com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(IOnErrorCallback iOnErrorCallback) {
            IRemoteViewDelegate iRemoteViewDelegate = this.i;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.setOnErrorCallback(iOnErrorCallback);
                } catch (RemoteException unused) {
                    com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(IOnLightCallback iOnLightCallback) {
            this.n = iOnLightCallback;
            IRemoteViewDelegate iRemoteViewDelegate = this.i;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.setOnLightVisbleCallBack(iOnLightCallback);
                } catch (RemoteException unused) {
                    com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, int i2, Intent intent) {
            if (i2 == -1 && intent != null && i == 4371) {
                try {
                    HmsScan[] hmsScanArrDecodeWithBitmap = ScanUtil.decodeWithBitmap(RemoteView.this.mContext, com.huawei.hms.scankit.util.b.a(RemoteView.this.mContext, intent), new HmsScanAnalyzerOptions.Creator().setPhotoMode(true).create());
                    IOnResultCallback iOnResultCallback = this.j;
                    if (iOnResultCallback != null) {
                        iOnResultCallback.onResult(hmsScanArrDecodeWithBitmap);
                    }
                } catch (RemoteException unused) {
                    com.huawei.hms.scankit.util.a.b(RemoteView.TAG, "RemoteException in remoteview");
                } catch (Error unused2) {
                    com.huawei.hms.scankit.util.a.b(RemoteView.TAG, "Exception in error");
                } catch (IllegalStateException unused3) {
                    com.huawei.hms.scankit.util.a.b(RemoteView.TAG, "IllegalStateException in remoteview");
                } catch (Exception unused4) {
                    com.huawei.hms.scankit.util.a.b(RemoteView.TAG, "Exception in remoteview");
                }
            }
        }
    }

    public static class b implements LifecycleDelegate {
        private ViewGroup a;
        private View b;
        private IRemoteViewDelegate c;

        public b(ViewGroup viewGroup, IRemoteViewDelegate iRemoteViewDelegate) {
            this.a = viewGroup;
            this.c = iRemoteViewDelegate;
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onCreate(Bundle bundle) {
            try {
                this.c.onCreate(bundle);
                this.b = (View) ObjectWrapper.unwrap(this.c.getView());
                this.a.removeAllViews();
                this.a.addView(this.b);
            } catch (RemoteException unused) {
                com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            return new View(null);
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onDestroy() {
            try {
                this.c.onDestroy();
            } catch (RemoteException unused) {
                com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onDestroyView() {
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onLowMemory() {
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onPause() {
            try {
                this.c.onPause();
            } catch (RemoteException unused) {
                com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onResume() {
            try {
                this.c.onResume();
            } catch (RemoteException unused) {
                com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onSaveInstanceState(Bundle bundle) {
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onStart() {
            try {
                this.c.onStart();
            } catch (RemoteException unused) {
                com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onStop() {
            try {
                this.c.onStop();
            } catch (RemoteException unused) {
                com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
            }
        }
    }

    public RemoteView(Activity activity, boolean z, int i, Rect rect) {
        super(activity);
        this.mContinuouslyScan = true;
        this.mReturnedBitmap = false;
        this.flagForGallery = false;
        this.mContext = activity;
        this.mRemoteHelper = new a(activity, this, z, i, rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPhotoCode(Activity activity) {
        if (!com.huawei.hms.scankit.util.b.b((Context) activity) && activity.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) != 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                activity.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, REQUEST_CODE_PHOTO);
                return;
            }
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            if (com.huawei.hms.scankit.util.b.e(activity)) {
                if (com.huawei.hms.scankit.util.b.a(new Intent(), "com.android.gallery3d", activity) != null) {
                    com.huawei.hms.scankit.util.a.c(TAG, "Start Gallery:com.android.gallery3d");
                    intent.setPackage("com.android.gallery3d");
                } else if (com.huawei.hms.scankit.util.b.a(new Intent(), "com.huawei.photos", activity) != null) {
                    intent.setPackage("com.huawei.photos");
                    com.huawei.hms.scankit.util.a.c(TAG, "Start Gallery:com.huawei.photos");
                }
            }
            intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
            this.flagForGallery = true;
            activity.startActivityForResult(intent, REQUEST_CODE_PHOTO);
        } catch (Exception unused) {
            com.huawei.hms.scankit.util.a.b(TAG, "startPhotoCode Exception");
        }
    }

    public RemoteView enableReturnBitmap(boolean z) {
        this.mReturnedBitmap = z;
        this.mRemoteHelper.b(z);
        return this;
    }

    public boolean getLightStatus() {
        return this.mRemoteHelper.b();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.mRemoteHelper.a(i, i2, intent);
    }

    public void onCreate(Bundle bundle) {
        Context context = this.mContext;
        if ((context instanceof Activity) && ((Activity) context).getWindow() != null) {
            ((Activity) this.mContext).getWindow().setFlags(16777216, 16777216);
        }
        this.mRemoteHelper.onCreate(bundle);
    }

    public final void onDestroy() {
        this.mRemoteHelper.onDestroy();
    }

    public final void onPause() {
        this.mRemoteHelper.onPause();
        if (this.flagForGallery) {
            this.mRemoteHelper.onStop();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr, Activity activity) {
        if (i == 4371 && iArr.length == 1 && iArr[0] == 0) {
            startPhotoCode(activity);
        }
    }

    public final void onResume() {
        this.mRemoteHelper.onResume();
        this.flagForGallery = false;
    }

    public final void onStart() {
        this.mRemoteHelper.onStart();
        this.flagForGallery = false;
    }

    public final void onStop() {
        if (this.flagForGallery) {
            return;
        }
        this.mRemoteHelper.onStop();
    }

    public void pauseContinuouslyScan() {
        this.mRemoteHelper.c();
    }

    public void resumeContinuouslyScan() {
        this.mRemoteHelper.d();
    }

    public void selectPictureFromLocalFile() {
        startPhotoCode((Activity) this.mContext);
    }

    public void selectPictureFromLocalFileFragment(Fragment fragment) {
        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        fragment.startActivityForResult(intent, REQUEST_CODE_PHOTO);
    }

    public RemoteView setContinuouslyScan(boolean z) {
        this.mContinuouslyScan = z;
        return this;
    }

    public void setOnErrorCallback(OnErrorCallback onErrorCallback) {
        this.mRemoteHelper.a(new c(onErrorCallback));
    }

    public void setOnLightVisibleCallback(OnLightVisibleCallBack onLightVisibleCallBack) {
        this.mRemoteHelper.a(new d(onLightVisibleCallBack));
    }

    public void setOnResultCallback(OnResultCallback onResultCallback) {
        this.mRemoteHelper.a(new e(onResultCallback, this.mContinuouslyScan));
    }

    public boolean switchLight() {
        return !getLightStatus() ? this.mRemoteHelper.f() : this.mRemoteHelper.e();
    }

    public RemoteView(Activity activity, boolean z, int i, Rect rect, boolean z2) {
        super(activity);
        this.mContinuouslyScan = true;
        this.mReturnedBitmap = false;
        this.flagForGallery = false;
        this.mContext = activity;
        a aVar = new a(activity, this, z, i, rect);
        this.mRemoteHelper = aVar;
        aVar.a(z2);
    }

    public RemoteView(Activity activity, boolean z, Bundle bundle) {
        super(activity);
        this.mContinuouslyScan = true;
        this.mReturnedBitmap = false;
        this.flagForGallery = false;
        this.mContext = activity;
        a aVar = new a(activity, this, false, 0, null);
        this.mRemoteHelper = aVar;
        aVar.c(z);
        this.mRemoteHelper.a(bundle);
    }
}

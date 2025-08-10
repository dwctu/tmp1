package com.wear.main;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.exoplayer2.C;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lovense.wear.R;
import com.wear.main.account.LockActivity;
import com.wear.main.account.login.LoginActivity;
import com.wear.util.MyApplication;
import dc.ah4;
import dc.cs3;
import dc.eg3;
import dc.ep1;
import dc.is3;
import dc.jl2;
import dc.kl2;
import dc.ol2;
import dc.pj3;
import dc.sg3;
import dc.ul2;
import dc.vl2;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class BaseFragment<P extends vl2, V extends ul2> extends Fragment implements ul2, cs3.b {
    public String a;
    public int b;
    public MyApplication d;
    public FirebaseAnalytics e;
    public Dialog f;
    public kl2 g;
    public P h;
    public Handler c = new Handler(Looper.getMainLooper());
    public Runnable i = new a();
    public Handler j = new Handler(Looper.getMainLooper());

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ep1.b().e("任务超時了啦");
            BaseFragment.this.onCancel();
            BaseFragment.this.y();
            sg3.h(R.string.net_connect_error_tip);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void F() {
        pj3.t(getContext(), LoginActivity.class, 2);
    }

    public int A() {
        return this.b;
    }

    public String B() {
        return this.a;
    }

    public void C() {
        jl2.b bVarE = jl2.e();
        bVarE.a(MyApplication.F());
        bVarE.c(new ol2(this));
        this.g = bVarE.b();
        D();
    }

    public void D() {
    }

    public void I() {
    }

    public void J() {
    }

    public void K(Intent intent) {
    }

    public final void L(Runnable runnable) {
        if (this.c == null) {
            return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            this.c.post(runnable);
        }
    }

    public void M(MyApplication myApplication) {
        this.d = myApplication;
    }

    public void O(int i) {
        this.b = i;
    }

    public void P(String str) {
        this.a = str;
    }

    public void Q() {
    }

    public void R() {
        FragmentActivity activity;
        if (!isAdded() || (activity = getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        this.f.show();
        v();
    }

    public void V(int i) {
        cs3.c(requireContext(), ah4.e(i), ah4.e(R.string.login_title), ah4.e(R.string.common_cancel), new is3.d() { // from class: dc.pv1
            @Override // dc.is3.d
            public final void doConfirm() {
                this.a.F();
            }
        }).show();
    }

    @Override // dc.cs3.b
    public void onCancel() {
        this.j.removeCallbacks(this.i);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        P p = this.h;
        if (p != null) {
            p.onDestroy();
            this.h = null;
        }
        Handler handler = this.c;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.c = null;
        }
        this.j.removeCallbacksAndMessages(null);
        Dialog dialog = this.f;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Q();
        if (this.d.g0() && eg3.a(getActivity(), "passcode_code_key")) {
            this.d.p0(false);
            pj3.h(getActivity(), LockActivity.class, "open_passcode_lock", 0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        MyApplication myApplication = this.d;
        myApplication.p0(myApplication.f0());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.e = FirebaseAnalytics.getInstance(getContext());
        C();
        P p = this.h;
        if (p != null) {
            p.c(this);
        }
        P p2 = this.h;
        if (p2 != null) {
            p2.onCreate();
        }
        this.f = cs3.m(getActivity(), this);
    }

    @Override // dc.ul2
    public void showErrorMsg(String str, boolean z) {
    }

    public void t(String str, HashMap<String, String> map) {
        MyApplication myApplication;
        FirebaseAnalytics firebaseAnalytics = this.e;
        if (firebaseAnalytics == null || (myApplication = this.d) == null) {
            return;
        }
        myApplication.p(firebaseAnalytics, str, map);
    }

    public void u() {
        this.j.removeCallbacks(this.i);
        ep1.b().e("关闭超时计算");
    }

    public final void v() {
        this.j.postDelayed(this.i, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
    }

    public void y() {
        FragmentActivity activity;
        this.j.removeCallbacks(this.i);
        if (!isAdded() || (activity = getActivity()) == null || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        this.f.dismiss();
    }
}

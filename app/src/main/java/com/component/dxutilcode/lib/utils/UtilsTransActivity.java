package com.component.dxutilcode.lib.utils;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class UtilsTransActivity extends AppCompatActivity {
    public static final Map<UtilsTransActivity, a> a = new HashMap();

    public static abstract class a implements Serializable {
        public boolean a(@NonNull UtilsTransActivity utilsTransActivity, MotionEvent motionEvent) {
            return false;
        }

        public void b(@NonNull UtilsTransActivity utilsTransActivity, int i, int i2, Intent intent) {
        }

        public void c(@NonNull UtilsTransActivity utilsTransActivity, @Nullable Bundle bundle) {
        }

        public void d(@NonNull UtilsTransActivity utilsTransActivity, @Nullable Bundle bundle) {
        }

        public void e(@NonNull UtilsTransActivity utilsTransActivity) {
        }

        public void f(@NonNull UtilsTransActivity utilsTransActivity) {
        }

        public void g(@NonNull UtilsTransActivity utilsTransActivity, int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        }

        public void h(@NonNull UtilsTransActivity utilsTransActivity) {
        }

        public void i(@NonNull UtilsTransActivity utilsTransActivity, Bundle bundle) {
        }

        public void j(@NonNull UtilsTransActivity utilsTransActivity) {
        }

        public void k(@NonNull UtilsTransActivity utilsTransActivity) {
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        a aVar = a.get(this);
        if (aVar == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (aVar.a(this, motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        a aVar = a.get(this);
        if (aVar == null) {
            return;
        }
        aVar.b(this, i, i2, intent);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        overridePendingTransition(0, 0);
        Serializable serializableExtra = Build.VERSION.SDK_INT >= 33 ? getIntent().getSerializableExtra("extra_delegate", Serializable.class) : getIntent().getSerializableExtra("extra_delegate");
        if (!(serializableExtra instanceof a)) {
            super.onCreate(bundle);
            finish();
            return;
        }
        a aVar = (a) serializableExtra;
        a.put(this, aVar);
        aVar.c(this, bundle);
        super.onCreate(bundle);
        aVar.d(this, bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Map<UtilsTransActivity, a> map = a;
        a aVar = map.get(this);
        if (aVar == null) {
            return;
        }
        aVar.e(this);
        map.remove(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
        a aVar = a.get(this);
        if (aVar == null) {
            return;
        }
        aVar.f(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        a aVar = a.get(this);
        if (aVar == null) {
            return;
        }
        aVar.g(this, i, strArr, iArr);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        a aVar = a.get(this);
        if (aVar == null) {
            return;
        }
        aVar.h(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        a aVar = a.get(this);
        if (aVar == null) {
            return;
        }
        aVar.i(this, bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        a aVar = a.get(this);
        if (aVar == null) {
            return;
        }
        aVar.j(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        a aVar = a.get(this);
        if (aVar == null) {
            return;
        }
        aVar.k(this);
    }
}

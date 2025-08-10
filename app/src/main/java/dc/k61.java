package dc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/* compiled from: PermissionFragment.java */
/* loaded from: classes2.dex */
public final class k61 extends Fragment implements Runnable {
    public static final List<Integer> g = new ArrayList();
    public boolean a;
    public boolean b;
    public boolean c;

    @Nullable
    public u51 d;

    @Nullable
    public q51 e;
    public int f;

    /* compiled from: PermissionFragment.java */
    public class a implements q51 {
        public a(k61 k61Var) {
        }

        @Override // dc.q51
        public /* synthetic */ void a(Activity activity, List list, u51 u51Var) {
            p51.d(this, activity, list, u51Var);
        }

        @Override // dc.q51
        public /* synthetic */ void b(Activity activity, List list, List list2, boolean z, u51 u51Var) {
            p51.c(this, activity, list, list2, z, u51Var);
        }

        @Override // dc.q51
        public /* synthetic */ void c(Activity activity, List list, boolean z, u51 u51Var) {
            p51.b(this, activity, list, z, u51Var);
        }

        @Override // dc.q51
        public /* synthetic */ void d(Activity activity, List list, List list2, boolean z, u51 u51Var) {
            p51.a(this, activity, list, list2, z, u51Var);
        }
    }

    /* compiled from: PermissionFragment.java */
    public class b implements u51 {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ ArrayList b;
        public final /* synthetic */ ArrayList c;
        public final /* synthetic */ int d;

        /* compiled from: PermissionFragment.java */
        public class a implements q51 {
            public a(b bVar) {
            }

            @Override // dc.q51
            public /* synthetic */ void a(Activity activity, List list, u51 u51Var) {
                p51.d(this, activity, list, u51Var);
            }

            @Override // dc.q51
            public /* synthetic */ void b(Activity activity, List list, List list2, boolean z, u51 u51Var) {
                p51.c(this, activity, list, list2, z, u51Var);
            }

            @Override // dc.q51
            public /* synthetic */ void c(Activity activity, List list, boolean z, u51 u51Var) {
                p51.b(this, activity, list, z, u51Var);
            }

            @Override // dc.q51
            public /* synthetic */ void d(Activity activity, List list, List list2, boolean z, u51 u51Var) {
                p51.a(this, activity, list, list2, z, u51Var);
            }
        }

        /* compiled from: PermissionFragment.java */
        /* renamed from: dc.k61$b$b, reason: collision with other inner class name */
        public class C0193b implements u51 {
            public final /* synthetic */ ArrayList a;
            public final /* synthetic */ int b;
            public final /* synthetic */ ArrayList c;

            public C0193b(ArrayList arrayList, int i, ArrayList arrayList2) {
                this.a = arrayList;
                this.b = i;
                this.c = arrayList2;
            }

            @Override // dc.u51
            public void a(@NonNull List<String> list, boolean z) {
                if (k61.this.isAdded()) {
                    int[] iArr = new int[this.a.size()];
                    for (int i = 0; i < this.a.size(); i++) {
                        iArr[i] = m61.g(this.c, (String) this.a.get(i)) ? -1 : 0;
                    }
                    k61.this.onRequestPermissionsResult(this.b, (String[]) this.a.toArray(new String[0]), iArr);
                }
            }

            @Override // dc.u51
            public void b(@NonNull List<String> list, boolean z) {
                if (z && k61.this.isAdded()) {
                    int[] iArr = new int[this.a.size()];
                    Arrays.fill(iArr, 0);
                    k61.this.onRequestPermissionsResult(this.b, (String[]) this.a.toArray(new String[0]), iArr);
                }
            }
        }

        public b(Activity activity, ArrayList arrayList, ArrayList arrayList2, int i) {
            this.a = activity;
            this.b = arrayList;
            this.c = arrayList2;
            this.d = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void d(Activity activity, ArrayList arrayList, ArrayList arrayList2, int i) {
            k61.c(activity, arrayList, new a(this), new C0193b(arrayList2, i, arrayList));
        }

        @Override // dc.u51
        public void a(@NonNull List<String> list, boolean z) {
            if (k61.this.isAdded()) {
                int[] iArr = new int[this.c.size()];
                Arrays.fill(iArr, -1);
                k61.this.onRequestPermissionsResult(this.d, (String[]) this.c.toArray(new String[0]), iArr);
            }
        }

        @Override // dc.u51
        public void b(@NonNull List<String> list, boolean z) {
            if (z && k61.this.isAdded()) {
                long j = n51.f() ? 150L : 0L;
                final Activity activity = this.a;
                final ArrayList arrayList = this.b;
                final ArrayList arrayList2 = this.c;
                final int i = this.d;
                m61.u(new Runnable() { // from class: dc.k51
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.d(activity, arrayList, arrayList2, i);
                    }
                }, j);
            }
        }
    }

    public static void c(@NonNull Activity activity, @NonNull ArrayList<String> arrayList, @NonNull q51 q51Var, @Nullable u51 u51Var) {
        int iNextInt;
        List<Integer> list;
        k61 k61Var = new k61();
        Bundle bundle = new Bundle();
        do {
            iNextInt = new Random().nextInt((int) Math.pow(2.0d, 8.0d));
            list = g;
        } while (list.contains(Integer.valueOf(iNextInt)));
        list.add(Integer.valueOf(iNextInt));
        bundle.putInt("request_code", iNextInt);
        bundle.putStringArrayList("request_permissions", arrayList);
        k61Var.setArguments(bundle);
        k61Var.setRetainInstance(true);
        k61Var.h(true);
        k61Var.f(u51Var);
        k61Var.g(q51Var);
        k61Var.a(activity);
    }

    public void a(@NonNull Activity activity) {
        activity.getFragmentManager().beginTransaction().add(this, toString()).commitAllowingStateLoss();
    }

    public void b(@NonNull Activity activity) {
        activity.getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
    }

    public void d() {
        Activity activity = getActivity();
        Bundle arguments = getArguments();
        if (activity == null || arguments == null) {
            return;
        }
        int i = arguments.getInt("request_code");
        ArrayList<String> stringArrayList = arguments.getStringArrayList("request_permissions");
        if (stringArrayList == null || stringArrayList.isEmpty()) {
            return;
        }
        if (!n51.l()) {
            int size = stringArrayList.size();
            int[] iArr = new int[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = w51.f(activity, stringArrayList.get(i2)) ? 0 : -1;
            }
            onRequestPermissionsResult(i, (String[]) stringArrayList.toArray(new String[0]), iArr);
            return;
        }
        if (n51.f() && stringArrayList.size() >= 2 && m61.g(stringArrayList, "android.permission.BODY_SENSORS_BACKGROUND")) {
            ArrayList<String> arrayList = new ArrayList<>(stringArrayList);
            arrayList.remove("android.permission.BODY_SENSORS_BACKGROUND");
            i(activity, stringArrayList, arrayList, i);
            return;
        }
        if (n51.c() && stringArrayList.size() >= 2 && m61.g(stringArrayList, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            ArrayList<String> arrayList2 = new ArrayList<>(stringArrayList);
            arrayList2.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
            i(activity, stringArrayList, arrayList2, i);
        } else {
            if (!n51.c() || !m61.g(stringArrayList, "android.permission.ACCESS_MEDIA_LOCATION") || !m61.g(stringArrayList, "android.permission.READ_EXTERNAL_STORAGE")) {
                requestPermissions((String[]) stringArrayList.toArray(new String[stringArrayList.size() - 1]), i);
                return;
            }
            ArrayList<String> arrayList3 = new ArrayList<>(stringArrayList);
            arrayList3.remove("android.permission.ACCESS_MEDIA_LOCATION");
            i(activity, stringArrayList, arrayList3, i);
        }
    }

    public void e() {
        Bundle arguments = getArguments();
        Activity activity = getActivity();
        if (arguments == null || activity == null) {
            return;
        }
        boolean z = false;
        for (String str : arguments.getStringArrayList("request_permissions")) {
            if (w51.j(str) && !w51.f(activity, str) && (n51.d() || !m61.h(str, "android.permission.MANAGE_EXTERNAL_STORAGE"))) {
                o61.e(this, m61.m(activity, m61.b(str)), getArguments().getInt("request_code"));
                z = true;
            }
        }
        if (z) {
            return;
        }
        d();
    }

    public void f(@Nullable u51 u51Var) {
        this.d = u51Var;
    }

    public void g(q51 q51Var) {
        this.e = q51Var;
    }

    public void h(boolean z) {
        this.c = z;
    }

    public void i(@NonNull Activity activity, @NonNull ArrayList<String> arrayList, @NonNull ArrayList<String> arrayList2, int i) {
        ArrayList arrayList3 = new ArrayList(arrayList);
        Iterator<String> it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.remove(it.next());
        }
        c(activity, arrayList2, new a(this), new b(activity, arrayList3, arrayList, i));
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        ArrayList<String> stringArrayList;
        Activity activity = getActivity();
        Bundle arguments = getArguments();
        if (activity == null || arguments == null || this.b || i != arguments.getInt("request_code") || (stringArrayList = arguments.getStringArrayList("request_permissions")) == null || stringArrayList.isEmpty()) {
            return;
        }
        this.b = true;
        m61.t(stringArrayList, this);
    }

    @Override // android.app.Fragment
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        int requestedOrientation = activity.getRequestedOrientation();
        this.f = requestedOrientation;
        if (requestedOrientation != -1) {
            return;
        }
        m61.r(activity);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.d = null;
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        Activity activity = getActivity();
        if (activity == null || this.f != -1 || activity.getRequestedOrientation() == -1) {
            return;
        }
        activity.setRequestedOrientation(-1);
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (strArr.length == 0 || iArr.length == 0) {
            return;
        }
        Bundle arguments = getArguments();
        Activity activity = getActivity();
        if (activity == null || arguments == null || this.e == null || i != arguments.getInt("request_code")) {
            return;
        }
        u51 u51Var = this.d;
        this.d = null;
        q51 q51Var = this.e;
        this.e = null;
        m61.s(activity, strArr, iArr);
        ArrayList arrayListB = m61.b(strArr);
        g.remove(Integer.valueOf(i));
        b(activity);
        List<String> listD = w51.d(arrayListB, iArr);
        if (listD.size() == arrayListB.size()) {
            q51Var.b(activity, arrayListB, listD, true, u51Var);
            q51Var.c(activity, arrayListB, false, u51Var);
            return;
        }
        List<String> listC = w51.c(arrayListB, iArr);
        q51Var.d(activity, arrayListB, listC, w51.i(activity, listC), u51Var);
        if (!listD.isEmpty()) {
            q51Var.b(activity, arrayListB, listD, false, u51Var);
        }
        q51Var.c(activity, arrayListB, false, u51Var);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        if (!this.c) {
            b(getActivity());
        } else {
            if (this.a) {
                return;
            }
            this.a = true;
            e();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (isAdded()) {
            d();
        }
    }
}

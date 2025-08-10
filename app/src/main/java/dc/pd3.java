package dc;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.wear.main.closeRange.music.MusicControl;
import com.wear.main.longDistance.control.ChatDSControl;
import com.wear.main.longDistance.control.ChatGroupControl;
import com.wear.main.longDistance.control.ChatLiveControl;
import com.wear.main.longDistance.control.ChatSyncControl;
import com.wear.main.longDistance.control.ChatVideoControl;
import com.wear.network.protocol.exception.MyException;
import com.wear.ui.home.remote.RemoteControl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: AppMonitor.java */
/* loaded from: classes4.dex */
public class pd3 {
    public List<b> b;
    public boolean c;
    public ArrayList<Activity> a = new ArrayList<>();
    public int d = 0;
    public int e = 0;
    public HashMap<Context, ArrayList<lf3>> f = new HashMap<>();

    /* compiled from: AppMonitor.java */
    public class a implements Application.ActivityLifecycleCallbacks {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            StringBuilder sb = new StringBuilder();
            sb.append(activity.getLocalClassName());
            sb.append(" was Createdactivity==null   ");
            sb.append(activity == null);
            sb.append("     activity.isFinishing()  ");
            sb.append(activity.isFinishing());
            sb.append("    activity.isDestroyed()  ");
            sb.append(activity.isDestroyed());
            xe3.a("Lifecycle", sb.toString());
            pd3.b(pd3.this);
            pd3.this.a.add(activity);
            MusicControl.h0().R(activity);
            RemoteControl.j().o(activity);
            y12.c.a().r(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            StringBuilder sb = new StringBuilder();
            sb.append(activity.getLocalClassName());
            sb.append(" was Destroyedactivity==null  ");
            sb.append(activity == null);
            sb.append("  activity.isFinishing()  ");
            sb.append(activity.isFinishing());
            sb.append("  activity.isDestroyed()");
            sb.append(activity.isDestroyed());
            xe3.a("Lifecycle", sb.toString());
            pd3.c(pd3.this);
            pd3.this.l();
            pd3.this.a.remove(activity);
            ArrayList arrayList = (ArrayList) pd3.this.f.get(activity);
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    try {
                        ((lf3) it.next()).onDestroy();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                ((ArrayList) pd3.this.f.get(activity)).clear();
                pd3.this.f.remove(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            StringBuilder sb = new StringBuilder();
            sb.append(activity.getLocalClassName());
            sb.append(" was Pauseedactivity==null   ");
            sb.append(activity == null);
            sb.append("activity.isFinishing()   ");
            sb.append(activity.isFinishing());
            sb.append("activity.isDestroyed()  ");
            sb.append(activity.isDestroyed());
            xe3.a("Lifecycle", sb.toString());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            xe3.a("Lifecycle", "一共有活着的activity" + pd3.this.e + "     活跃的activity=" + pd3.this.d);
            StringBuilder sb = new StringBuilder();
            sb.append(activity.getLocalClassName());
            sb.append(" was oResumedactivity==null   ");
            sb.append(activity == null);
            sb.append("activity.isFinishing()   ");
            sb.append(activity.isFinishing());
            sb.append("activity.isDestroyed() ");
            sb.append(activity.isDestroyed());
            xe3.a("Lifecycle", sb.toString());
            ChatVideoControl.a1().x(activity);
            ChatSyncControl.N0().x(activity);
            ChatLiveControl.q0().x(activity);
            ChatGroupControl.o1().x(activity);
            ChatDSControl.r1().x(activity);
            MusicControl.h0().J(activity);
            c83.R1().x(activity);
            RemoteControl.j().f(activity);
            y12.c.a().h(activity.getClass());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            StringBuilder sb = new StringBuilder();
            sb.append(activity.getLocalClassName());
            sb.append(" was SaveInstanceStateactivity==null ");
            sb.append(activity == null);
            sb.append("activity.isFinishing()   ");
            sb.append(activity.isFinishing());
            sb.append("activity.isDestroyed()  ");
            sb.append(activity.isDestroyed());
            xe3.a("Lifecycle", sb.toString());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            StringBuilder sb = new StringBuilder();
            sb.append(activity.getLocalClassName());
            sb.append(" was Startedactivity==null   ");
            sb.append(activity == null);
            sb.append("     activity.isFinishing()   ");
            sb.append(activity.isFinishing());
            sb.append("   activity.isDestroyed()  ");
            sb.append(activity.isDestroyed());
            xe3.a("Lifecycle", sb.toString());
            pd3.e(pd3.this);
            pd3.this.m();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            StringBuilder sb = new StringBuilder();
            sb.append(activity.getLocalClassName());
            sb.append(" was Stopedactivity==null    ");
            sb.append(activity == null);
            sb.append("activity.isFinishing()   ");
            sb.append(activity.isFinishing());
            sb.append("activity.isDestroyed() ");
            sb.append(activity.isDestroyed());
            xe3.a("Lifecycle", sb.toString());
            pd3.f(pd3.this);
            pd3.this.m();
        }
    }

    /* compiled from: AppMonitor.java */
    public interface b {
        void n();

        void p();

        void q();
    }

    /* compiled from: AppMonitor.java */
    public static final class c {
        public static final pd3 a = new pd3();
    }

    public static /* synthetic */ int b(pd3 pd3Var) {
        int i = pd3Var.e;
        pd3Var.e = i + 1;
        return i;
    }

    public static /* synthetic */ int c(pd3 pd3Var) {
        int i = pd3Var.e;
        pd3Var.e = i - 1;
        return i;
    }

    public static /* synthetic */ int e(pd3 pd3Var) {
        int i = pd3Var.d;
        pd3Var.d = i + 1;
        return i;
    }

    public static /* synthetic */ int f(pd3 pd3Var) {
        int i = pd3Var.d;
        pd3Var.d = i - 1;
        return i;
    }

    public static pd3 j() {
        return c.a;
    }

    public void k(Context context) {
        if (this.c) {
            return;
        }
        this.a.clear();
        this.b = new CopyOnWriteArrayList();
        p(context);
        this.c = true;
    }

    public final void l() {
        if (this.e == 0) {
            Iterator<b> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().n();
            }
        }
    }

    public final void m() {
        if (this.d > 0) {
            Iterator<b> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().p();
            }
        } else {
            Iterator<b> it2 = this.b.iterator();
            while (it2.hasNext()) {
                it2.next().q();
            }
        }
    }

    public void n(lf3 lf3Var) {
        if (lf3Var == null) {
            return;
        }
        if (lf3Var.getKey() == null) {
            throw new MyException("ObjectLifecycleCallbacks obj getKey() must no null");
        }
        if (this.f.get(lf3Var.getKey()) != null) {
            this.f.get(lf3Var.getKey()).add(lf3Var);
            return;
        }
        ArrayList<lf3> arrayList = new ArrayList<>();
        arrayList.add(lf3Var);
        this.f.put(lf3Var.getKey(), arrayList);
    }

    public void o(b bVar) {
        if (this.b.contains(bVar)) {
            return;
        }
        this.b.add(bVar);
    }

    public final void p(Context context) {
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new a());
    }
}

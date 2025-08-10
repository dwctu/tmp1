package com.wear.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.slf4j.helpers.MessageFormatter;

/* loaded from: classes4.dex */
public class MyDefaultItemAnimator extends SimpleItemAnimator {
    public static TimeInterpolator l;
    public ArrayList<RecyclerView.ViewHolder> a = new ArrayList<>();
    public ArrayList<RecyclerView.ViewHolder> b = new ArrayList<>();
    public ArrayList<j> c = new ArrayList<>();
    public ArrayList<i> d = new ArrayList<>();
    public ArrayList<ArrayList<RecyclerView.ViewHolder>> e = new ArrayList<>();
    public ArrayList<ArrayList<j>> f = new ArrayList<>();
    public ArrayList<ArrayList<i>> g = new ArrayList<>();
    public ArrayList<RecyclerView.ViewHolder> h = new ArrayList<>();
    public ArrayList<RecyclerView.ViewHolder> i = new ArrayList<>();
    public ArrayList<RecyclerView.ViewHolder> j = new ArrayList<>();
    public ArrayList<RecyclerView.ViewHolder> k = new ArrayList<>();

    public class a implements Runnable {
        public final /* synthetic */ ArrayList a;

        public a(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                MyDefaultItemAnimator.this.animateMoveImpl(jVar.a, jVar.b, jVar.c, jVar.d, jVar.e);
            }
            this.a.clear();
            MyDefaultItemAnimator.this.f.remove(this.a);
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ ArrayList a;

        public b(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                MyDefaultItemAnimator.this.a((i) it.next());
            }
            this.a.clear();
            MyDefaultItemAnimator.this.g.remove(this.a);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ ArrayList a;

        public c(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                MyDefaultItemAnimator.this.animateAddImpl((RecyclerView.ViewHolder) it.next());
            }
            this.a.clear();
            MyDefaultItemAnimator.this.e.remove(this.a);
        }
    }

    public class d extends AnimatorListenerAdapter {
        public final /* synthetic */ RecyclerView.ViewHolder a;
        public final /* synthetic */ ViewPropertyAnimator b;

        public d(RecyclerView.ViewHolder viewHolder, ViewPropertyAnimator viewPropertyAnimator) {
            this.a = viewHolder;
            this.b = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.b.setListener(null);
            MyDefaultItemAnimator.this.dispatchRemoveFinished(this.a);
            MyDefaultItemAnimator.this.j.remove(this.a);
            MyDefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            MyDefaultItemAnimator.this.dispatchRemoveStarting(this.a);
        }
    }

    public class e extends AnimatorListenerAdapter {
        public final /* synthetic */ RecyclerView.ViewHolder a;
        public final /* synthetic */ View b;
        public final /* synthetic */ ViewPropertyAnimator c;

        public e(RecyclerView.ViewHolder viewHolder, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.a = viewHolder;
            this.b = view;
            this.c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.c.setListener(null);
            MyDefaultItemAnimator.this.dispatchAddFinished(this.a);
            MyDefaultItemAnimator.this.h.remove(this.a);
            MyDefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            MyDefaultItemAnimator.this.dispatchAddStarting(this.a);
        }
    }

    public class f extends AnimatorListenerAdapter {
        public final /* synthetic */ RecyclerView.ViewHolder a;
        public final /* synthetic */ int b;
        public final /* synthetic */ View c;
        public final /* synthetic */ int d;
        public final /* synthetic */ ViewPropertyAnimator e;

        public f(RecyclerView.ViewHolder viewHolder, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
            this.a = viewHolder;
            this.b = i;
            this.c = view;
            this.d = i2;
            this.e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.b != 0) {
                this.c.setTranslationX(0.0f);
            }
            if (this.d != 0) {
                this.c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.e.setListener(null);
            MyDefaultItemAnimator.this.dispatchMoveFinished(this.a);
            MyDefaultItemAnimator.this.i.remove(this.a);
            MyDefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            MyDefaultItemAnimator.this.dispatchMoveStarting(this.a);
        }
    }

    public class g extends AnimatorListenerAdapter {
        public final /* synthetic */ i a;
        public final /* synthetic */ ViewPropertyAnimator b;
        public final /* synthetic */ View c;

        public g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.a = iVar;
            this.b = viewPropertyAnimator;
            this.c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.b.setListener(null);
            this.c.setAlpha(1.0f);
            this.c.setTranslationX(0.0f);
            this.c.setTranslationY(0.0f);
            MyDefaultItemAnimator.this.dispatchChangeFinished(this.a.a, true);
            MyDefaultItemAnimator.this.k.remove(this.a.a);
            MyDefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            MyDefaultItemAnimator.this.dispatchChangeStarting(this.a.a, true);
        }
    }

    public class h extends AnimatorListenerAdapter {
        public final /* synthetic */ i a;
        public final /* synthetic */ ViewPropertyAnimator b;
        public final /* synthetic */ View c;

        public h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.a = iVar;
            this.b = viewPropertyAnimator;
            this.c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.b.setListener(null);
            this.c.setAlpha(1.0f);
            this.c.setTranslationX(0.0f);
            this.c.setTranslationY(0.0f);
            MyDefaultItemAnimator.this.dispatchChangeFinished(this.a.b, false);
            MyDefaultItemAnimator.this.k.remove(this.a.b);
            MyDefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            MyDefaultItemAnimator.this.dispatchChangeStarting(this.a.b, false);
        }
    }

    public static class j {
        public RecyclerView.ViewHolder a;
        public int b;
        public int c;
        public int d;
        public int e;

        public j(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4) {
            this.a = viewHolder;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }
    }

    public void a(i iVar) {
        RecyclerView.ViewHolder viewHolder = iVar.a;
        View view = viewHolder == null ? null : viewHolder.itemView;
        RecyclerView.ViewHolder viewHolder2 = iVar.b;
        View view2 = viewHolder2 != null ? viewHolder2.itemView : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(getChangeDuration());
            this.k.add(iVar.a);
            duration.translationX(iVar.e - iVar.c);
            duration.translationY(iVar.f - iVar.d);
            duration.setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
            this.k.add(iVar.b);
            viewPropertyAnimatorAnimate.translationX(0.0f).translationY(0.0f).setDuration(getChangeDuration()).alpha(1.0f).setListener(new h(iVar, viewPropertyAnimatorAnimate, view2)).start();
        }
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateAdd(RecyclerView.ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        this.b.add(viewHolder);
        return true;
    }

    public void animateAddImpl(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.h.add(viewHolder);
        viewPropertyAnimatorAnimate.alpha(1.0f).setDuration(getAddDuration()).setListener(new e(viewHolder, view, viewPropertyAnimatorAnimate)).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateChange(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i2, int i3, int i4, int i5) {
        if (viewHolder == viewHolder2) {
            return animateMove(viewHolder, i2, i3, i4, i5);
        }
        float translationX = viewHolder.itemView.getTranslationX();
        float translationY = viewHolder.itemView.getTranslationY();
        viewHolder.itemView.getAlpha();
        resetAnimation(viewHolder);
        int i6 = (int) ((i4 - i2) - translationX);
        int i7 = (int) ((i5 - i3) - translationY);
        viewHolder.itemView.setTranslationX(translationX);
        viewHolder.itemView.setTranslationY(translationY);
        if (viewHolder2 != null) {
            resetAnimation(viewHolder2);
            viewHolder2.itemView.setTranslationX(-i6);
            viewHolder2.itemView.setTranslationY(-i7);
        }
        this.d.add(new i(viewHolder, viewHolder2, i2, i3, i4, i5));
        return true;
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateMove(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
        View view = viewHolder.itemView;
        int translationX = i2 + ((int) view.getTranslationX());
        int translationY = i3 + ((int) viewHolder.itemView.getTranslationY());
        resetAnimation(viewHolder);
        int i6 = i4 - translationX;
        int i7 = i5 - translationY;
        if (i6 == 0 && i7 == 0) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        if (i6 != 0) {
            view.setTranslationX(-i6);
        }
        if (i7 != 0) {
            view.setTranslationY(-i7);
        }
        this.c.add(new j(viewHolder, translationX, translationY, i4, i5));
        return true;
    }

    public void animateMoveImpl(RecyclerView.ViewHolder viewHolder, int i2, int i3, int i4, int i5) {
        View view = viewHolder.itemView;
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        if (i6 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i7 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAnimate = view.animate();
        this.i.add(viewHolder);
        viewPropertyAnimatorAnimate.setDuration(getMoveDuration()).setListener(new f(viewHolder, i6, view, i7, viewPropertyAnimatorAnimate)).start();
    }

    @Override // androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(RecyclerView.ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        this.a.add(viewHolder);
        return true;
    }

    public final void animateRemoveImpl(RecyclerView.ViewHolder viewHolder) {
        ViewPropertyAnimator viewPropertyAnimatorAnimate = viewHolder.itemView.animate();
        this.j.add(viewHolder);
        viewPropertyAnimatorAnimate.setDuration(getRemoveDuration()).setListener(new d(viewHolder, viewPropertyAnimatorAnimate)).start();
    }

    public final void b(i iVar) {
        RecyclerView.ViewHolder viewHolder = iVar.a;
        if (viewHolder != null) {
            c(iVar, viewHolder);
        }
        RecyclerView.ViewHolder viewHolder2 = iVar.b;
        if (viewHolder2 != null) {
            c(iVar, viewHolder2);
        }
    }

    public final boolean c(i iVar, RecyclerView.ViewHolder viewHolder) {
        boolean z = false;
        if (iVar.b == viewHolder) {
            iVar.b = null;
        } else {
            if (iVar.a != viewHolder) {
                return false;
            }
            iVar.a = null;
            z = true;
        }
        viewHolder.itemView.setAlpha(1.0f);
        viewHolder.itemView.setTranslationX(0.0f);
        viewHolder.itemView.setTranslationY(0.0f);
        dispatchChangeFinished(viewHolder, z);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean canReuseUpdatedViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, @NonNull List<Object> list) {
        return !list.isEmpty() || super.canReuseUpdatedViewHolder(viewHolder, list);
    }

    public void cancelAll(List<RecyclerView.ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            list.get(size).itemView.animate().cancel();
        }
    }

    public void dispatchFinishedWhenDone() {
        if (isRunning()) {
            return;
        }
        dispatchAnimationsFinished();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimation(RecyclerView.ViewHolder viewHolder) {
        View view = viewHolder.itemView;
        view.animate().cancel();
        int size = this.c.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (this.c.get(size).a == viewHolder) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                dispatchMoveFinished(viewHolder);
                this.c.remove(size);
            }
        }
        endChangeAnimation(this.d, viewHolder);
        if (this.a.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.b.remove(viewHolder)) {
            view.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
        }
        for (int size2 = this.g.size() - 1; size2 >= 0; size2--) {
            ArrayList<i> arrayList = this.g.get(size2);
            endChangeAnimation(arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.g.remove(size2);
            }
        }
        for (int size3 = this.f.size() - 1; size3 >= 0; size3--) {
            ArrayList<j> arrayList2 = this.f.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (arrayList2.get(size4).a == viewHolder) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    dispatchMoveFinished(viewHolder);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.e.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.ViewHolder> arrayList3 = this.e.get(size5);
            if (arrayList3.remove(viewHolder)) {
                view.setAlpha(1.0f);
                dispatchAddFinished(viewHolder);
                if (arrayList3.isEmpty()) {
                    this.e.remove(size5);
                }
            }
        }
        this.j.remove(viewHolder);
        this.h.remove(viewHolder);
        this.k.remove(viewHolder);
        this.i.remove(viewHolder);
        dispatchFinishedWhenDone();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void endAnimations() {
        int size = this.c.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = this.c.get(size);
            View view = jVar.a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            dispatchMoveFinished(jVar.a);
            this.c.remove(size);
        }
        for (int size2 = this.a.size() - 1; size2 >= 0; size2--) {
            dispatchRemoveFinished(this.a.get(size2));
            this.a.remove(size2);
        }
        int size3 = this.b.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.ViewHolder viewHolder = this.b.get(size3);
            viewHolder.itemView.setAlpha(1.0f);
            dispatchAddFinished(viewHolder);
            this.b.remove(size3);
        }
        for (int size4 = this.d.size() - 1; size4 >= 0; size4--) {
            b(this.d.get(size4));
        }
        this.d.clear();
        if (isRunning()) {
            for (int size5 = this.f.size() - 1; size5 >= 0; size5--) {
                ArrayList<j> arrayList = this.f.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = arrayList.get(size6);
                    View view2 = jVar2.a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    dispatchMoveFinished(jVar2.a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.e.size() - 1; size7 >= 0; size7--) {
                ArrayList<RecyclerView.ViewHolder> arrayList2 = this.e.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.ViewHolder viewHolder2 = arrayList2.get(size8);
                    viewHolder2.itemView.setAlpha(1.0f);
                    dispatchAddFinished(viewHolder2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.e.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.g.size() - 1; size9 >= 0; size9--) {
                ArrayList<i> arrayList3 = this.g.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    b(arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.g.remove(arrayList3);
                    }
                }
            }
            cancelAll(this.j);
            cancelAll(this.i);
            cancelAll(this.h);
            cancelAll(this.k);
            dispatchAnimationsFinished();
        }
    }

    public final void endChangeAnimation(List<i> list, RecyclerView.ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = list.get(size);
            if (c(iVar, viewHolder) && iVar.a == null && iVar.b == null) {
                list.remove(iVar);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public boolean isRunning() {
        return (this.b.isEmpty() && this.d.isEmpty() && this.c.isEmpty() && this.a.isEmpty() && this.i.isEmpty() && this.j.isEmpty() && this.h.isEmpty() && this.k.isEmpty() && this.f.isEmpty() && this.e.isEmpty() && this.g.isEmpty()) ? false : true;
    }

    public final void resetAnimation(RecyclerView.ViewHolder viewHolder) {
        if (l == null) {
            l = new ValueAnimator().getInterpolator();
        }
        viewHolder.itemView.animate().setInterpolator(l);
        endAnimation(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator
    public void runPendingAnimations() {
        boolean z = !this.a.isEmpty();
        boolean z2 = !this.c.isEmpty();
        boolean z3 = !this.d.isEmpty();
        boolean z4 = !this.b.isEmpty();
        if (z || z2 || z4 || z3) {
            Iterator<RecyclerView.ViewHolder> it = this.a.iterator();
            while (it.hasNext()) {
                animateRemoveImpl(it.next());
            }
            this.a.clear();
            if (z2) {
                ArrayList<j> arrayList = new ArrayList<>();
                arrayList.addAll(this.c);
                this.f.add(arrayList);
                this.c.clear();
                a aVar = new a(arrayList);
                if (z) {
                    ViewCompat.postOnAnimationDelayed(arrayList.get(0).a.itemView, aVar, getRemoveDuration());
                } else {
                    aVar.run();
                }
            }
            if (z3) {
                ArrayList<i> arrayList2 = new ArrayList<>();
                arrayList2.addAll(this.d);
                this.g.add(arrayList2);
                this.d.clear();
                b bVar = new b(arrayList2);
                if (z) {
                    ViewCompat.postOnAnimationDelayed(arrayList2.get(0).a.itemView, bVar, getRemoveDuration());
                } else {
                    bVar.run();
                }
            }
            if (z4) {
                ArrayList<RecyclerView.ViewHolder> arrayList3 = new ArrayList<>();
                arrayList3.addAll(this.b);
                this.e.add(arrayList3);
                this.b.clear();
                c cVar = new c(arrayList3);
                if (z || z2 || z3) {
                    ViewCompat.postOnAnimationDelayed(arrayList3.get(0).itemView, cVar, (z ? getRemoveDuration() : 0L) + Math.max(z2 ? getMoveDuration() : 0L, z3 ? getChangeDuration() : 0L));
                } else {
                    cVar.run();
                }
            }
        }
    }

    public static class i {
        public RecyclerView.ViewHolder a;
        public RecyclerView.ViewHolder b;
        public int c;
        public int d;
        public int e;
        public int f;

        public i(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            this.a = viewHolder;
            this.b = viewHolder2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.a + ", newHolder=" + this.b + ", fromX=" + this.c + ", fromY=" + this.d + ", toX=" + this.e + ", toY=" + this.f + MessageFormatter.DELIM_STOP;
        }

        public i(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
            this(viewHolder, viewHolder2);
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
        }
    }
}

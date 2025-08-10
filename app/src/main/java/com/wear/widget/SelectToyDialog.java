package com.wear.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatDialog;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import dc.ah4;
import dc.ce3;
import dc.pc1;
import dc.sg3;
import dc.th4;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes4.dex */
public class SelectToyDialog extends AppCompatDialog {
    public View a;
    public Context b;
    public List<Toy> c;

    @BindView(R.id.cancel_btn)
    public TextView cancelBtn;

    @BindView(R.id.connectedRecyclerView)
    public RecyclerView connectedRecyclerView;
    public List<Toy> d;

    @BindView(R.id.disconnectedRecyclerView)
    public RecyclerView disconnectedRecyclerView;
    public List<Toy> e;
    public ToyAdapter f;
    public ToyAdapter g;
    public pc1 h;
    public e i;

    @BindView(R.id.left_title_1)
    public TextView leftTitle1;

    @BindView(R.id.left_title_2)
    public TextView leftTitle2;

    @BindView(R.id.ok_btn)
    public TextView okBtn;

    public class ToyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        public List<Toy> a;

        public class MyViewHolder extends RecyclerView.ViewHolder {
            public View a;

            @BindView(R.id.toyName)
            public TextView toyName;

            public MyViewHolder(@NonNull @NotNull ToyAdapter toyAdapter, View view) {
                super(view);
                this.a = view;
                ButterKnife.bind(this, view);
            }
        }

        public class MyViewHolder_ViewBinding implements Unbinder {
            public MyViewHolder a;

            @UiThread
            public MyViewHolder_ViewBinding(MyViewHolder myViewHolder, View view) {
                this.a = myViewHolder;
                myViewHolder.toyName = (TextView) Utils.findRequiredViewAsType(view, R.id.toyName, "field 'toyName'", TextView.class);
            }

            @Override // butterknife.Unbinder
            @CallSuper
            public void unbind() {
                MyViewHolder myViewHolder = this.a;
                if (myViewHolder == null) {
                    throw new IllegalStateException("Bindings already cleared.");
                }
                this.a = null;
                myViewHolder.toyName = null;
            }
        }

        public class a implements View.OnClickListener {
            public final /* synthetic */ int a;
            public final /* synthetic */ MyViewHolder b;

            public a(int i, MyViewHolder myViewHolder) {
                this.a = i;
                this.b = myViewHolder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToyAdapter toyAdapter = ToyAdapter.this;
                boolean zD = SelectToyDialog.this.d((Toy) toyAdapter.a.get(this.a));
                this.b.a.setBackground(th4.d(SelectToyDialog.this.b, zD ? R.drawable.item_select_toy_background_selected : R.drawable.item_select_toy_background_unselect));
                this.b.toyName.setTextColor(th4.b(SelectToyDialog.this.b, !zD ? R.color.dialog_toy_select_item_text_color : R.color.white));
            }
        }

        public ToyAdapter(List<Toy> list) {
            this.a = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(@NonNull @NotNull MyViewHolder myViewHolder, int i) {
            myViewHolder.a.setOnClickListener(new a(i, myViewHolder));
            if (this.a.get(i).isF01Toy()) {
                myViewHolder.toyName.setText(this.a.get(i).getToyUINameSpecialForMiniXMachine(1));
            } else {
                myViewHolder.toyName.setText(this.a.get(i).getSimpleFullName());
            }
            boolean zContains = SelectToyDialog.this.c.contains(this.a.get(i));
            myViewHolder.a.setBackground(th4.d(SelectToyDialog.this.b, zContains ? R.drawable.item_select_toy_background_selected : R.drawable.item_select_toy_background_unselect));
            myViewHolder.toyName.setTextColor(th4.b(SelectToyDialog.this.b, !zContains ? R.color.dialog_toy_select_item_text_color : R.color.white));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        @NotNull
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
            return new MyViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_select_toy_layout, viewGroup, false));
        }

        public void o(List<Toy> list) {
            this.a = list;
            notifyDataSetChanged();
        }
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SelectToyDialog.this.cancel();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SelectToyDialog.this.i != null) {
                SelectToyDialog.this.i.a(SelectToyDialog.this.c);
            }
            SelectToyDialog.this.dismiss();
        }
    }

    public class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            SelectToyDialog.this.dismiss();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public class d extends RecyclerView.ItemDecoration {
        public d(SelectToyDialog selectToyDialog) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            rect.top = ce3.a(recyclerView.getContext(), 8.0f);
            rect.bottom = ce3.a(recyclerView.getContext(), 8.0f);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.onDraw(canvas, recyclerView, state);
        }
    }

    public interface e {
        void a(List<Toy> list);
    }

    public SelectToyDialog(Context context, e eVar) {
        super(context, R.style.newBottomDialog);
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new ToyAdapter(this.d);
        this.g = new ToyAdapter(this.e);
        this.b = context;
        this.h = pc1.a;
        this.i = eVar;
    }

    public void c() {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
        animationSet.addAnimation(new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f));
        animationSet.setInterpolator(new AccelerateInterpolator());
        animationSet.setDuration(200L);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new c());
        this.a.setAnimation(animationSet);
        setContentView(this.a);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        c();
    }

    public boolean d(Toy toy) {
        boolean z;
        if (this.c.contains(toy)) {
            this.c.remove(toy);
        } else {
            if (this.c.size() < 2) {
                this.c.add(toy);
                z = true;
                f();
                return z;
            }
            sg3.l(ah4.e(R.string.toast_too_many_toys));
        }
        z = false;
        f();
        return z;
    }

    public void e(List<Toy> list) {
        super.show();
        this.c.clear();
        this.c.addAll(list);
        this.f.o(this.d);
        this.g.o(this.e);
    }

    public final void f() {
        if (this.c.size() == 0) {
            this.okBtn.setEnabled(false);
            this.okBtn.setBackground(th4.d(this.b, R.drawable.ok_to_gray_background));
            this.okBtn.setTextColor(th4.b(this.b, R.color.ok_to_gray_text_color));
        } else {
            this.okBtn.setBackground(th4.d(this.b, R.drawable.dialog_toy_select_ok_background));
            this.okBtn.setTextColor(th4.b(this.b, R.color.dialog_toy_select_ok_color));
            this.okBtn.setEnabled(true);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.height = -2;
        attributes.width = -1;
        attributes.gravity = 81;
        getWindow().setAttributes(attributes);
        View viewInflate = LayoutInflater.from(this.b).inflate(R.layout.dialog_toy_select, (ViewGroup) null);
        this.a = viewInflate;
        ButterKnife.bind(this, viewInflate);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
        animationSet.addAnimation(new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f));
        animationSet.setInterpolator(new AccelerateInterpolator());
        animationSet.setDuration(200L);
        animationSet.setFillAfter(true);
        this.a.setAnimation(animationSet);
        setContentView(this.a);
        this.cancelBtn.setOnClickListener(new a());
        this.okBtn.setOnClickListener(new b());
        this.connectedRecyclerView.setLayoutManager(new GridLayoutManager(this.b, 4, 1, false));
        this.connectedRecyclerView.addItemDecoration(new d(this));
        this.connectedRecyclerView.setAdapter(this.f);
        this.disconnectedRecyclerView.setLayoutManager(new GridLayoutManager(this.b, 4, 1, false));
        this.disconnectedRecyclerView.addItemDecoration(new d(this));
        this.disconnectedRecyclerView.setAdapter(this.g);
        this.d = this.h.P();
        ArrayList<Toy> arrayListO = this.h.o();
        if (arrayListO != null && arrayListO.size() > 0) {
            for (Toy toy : arrayListO) {
                if (!this.d.contains(toy)) {
                    this.e.add(toy);
                }
            }
        }
        if (this.d.size() == 0) {
            this.leftTitle1.setVisibility(8);
        }
        if (this.e.size() == 0) {
            this.leftTitle2.setVisibility(8);
        }
    }
}

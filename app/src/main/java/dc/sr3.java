package dc;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.lovense.wear.R;
import com.wear.adapter.patterns.BindToyListDialogAdapter;
import com.wear.bean.Toy;
import com.wear.bean.ToyConfigInfoBean;
import com.wear.main.MainActivity;
import com.wear.main.account.login.LoginActivity;
import com.wear.ui.discover.chatgpt.ChatGPTActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.is3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: BindToyListDialog.java */
/* loaded from: classes4.dex */
public class sr3 extends Dialog {
    public int a;
    public int b;
    public BindToyListDialogAdapter c;
    public List<Toy> d;
    public c e;
    public GridLayoutManager f;
    public RecyclerView g;
    public Context h;

    /* compiled from: BindToyListDialog.java */
    public class a implements BindToyListDialogAdapter.b {
        public a() {
        }

        @Override // com.wear.adapter.patterns.BindToyListDialogAdapter.b
        public void a(Toy toy) {
            sr3.this.e.a(toy);
        }

        @Override // com.wear.adapter.patterns.BindToyListDialogAdapter.b
        public void b() {
            sr3 sr3Var = sr3.this;
            sr3Var.a = 3;
            sr3Var.d.clear();
            sr3 sr3Var2 = sr3.this;
            sr3Var2.d.addAll(sr3Var2.k(sr3Var2.l()));
            Window window = sr3.this.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.height = ce3.a(sr3.this.h, 300.0f);
            window.setAttributes(attributes);
            ((GridLayoutManager) sr3.this.g.getLayoutManager()).setSpanCount(sr3.this.b);
            sr3.this.c.notifyDataSetChanged();
        }
    }

    /* compiled from: BindToyListDialog.java */
    public class b implements Comparator<Toy> {
        public b(sr3 sr3Var) {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Toy toy, Toy toy2) {
            if (WearUtils.e1(toy.getType()) || WearUtils.e1(toy2.getType())) {
                return 0;
            }
            return Character.compare(toy.getType().charAt(0), toy2.getType().charAt(0));
        }
    }

    /* compiled from: BindToyListDialog.java */
    public interface c {
        void a(Toy toy);
    }

    /* compiled from: BindToyListDialog.java */
    public class d extends RecyclerView.ItemDecoration {
        public int a;
        public int b;

        public d(sr3 sr3Var, int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
            int itemCount = recyclerView.getAdapter().getItemCount();
            int i = this.b;
            int i2 = childAdapterPosition / i;
            int i3 = itemCount / i;
            if (itemCount % i != 0) {
                i3++;
            }
            if (i2 == i3 - 1) {
                rect.bottom = 0;
            } else {
                rect.bottom = this.a;
            }
        }
    }

    public sr3(@NonNull Context context) {
        super(context, R.style.dialog);
        this.a = -1;
        this.b = 4;
        this.d = new ArrayList();
        this.h = context;
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f() {
        pj3.t(this.h, LoginActivity.class, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void h(String str, View view) {
        if (MyApplication.Z) {
            cs3.c(this.h, ah4.e(R.string.common_login_first), ah4.e(R.string.login_title), ah4.e(R.string.common_cancel), new is3.d() { // from class: dc.qp3
                @Override // dc.is3.d
                public final void doConfirm() {
                    this.a.f();
                }
            }).show();
        } else {
            Bundle bundle = new Bundle();
            bundle.putInt("story_chatgpt", 0);
            pj3.g(this.h, ChatGPTActivity.class, bundle);
            ye3.i(str, "chatgpt_pleasure_click", "click", "chatgpt_pleasure", "button");
        }
        dismiss();
    }

    public Toy b(ToyConfigInfoBean toyConfigInfoBean) {
        Toy toy = new Toy();
        toy.setAddress("");
        toy.setName(toyConfigInfoBean.getFullName());
        toy.setDeviceName(null);
        toy.setStatus(1);
        toy.setBattery(50);
        toy.setIsSelect(1);
        toy.setToyConfigDataBean(toyConfigInfoBean);
        toy.setType(toyConfigInfoBean.getType());
        toy.setToyConfigDataBean();
        toy.setSimpleToy(1);
        if (toy.isBAToy()) {
            toy.setAddress("pattern:" + toy.getShowName());
        }
        toy.setVersion(Integer.valueOf(c(toy.getType())));
        return toy;
    }

    public int c(String str) {
        if (str.toLowerCase().equals("max")) {
            return 2;
        }
        if (str.toLowerCase().equals("lush")) {
            return 3;
        }
        return (str.toLowerCase().equals("domi") || str.toLowerCase().equals("hush")) ? 2 : 1;
    }

    public final void d() {
        View viewInflate = LayoutInflater.from(this.h).inflate(R.layout.dialog_layout_choose_toys_creat_pattern, (ViewGroup) null);
        setContentView(viewInflate);
        this.g = (RecyclerView) viewInflate.findViewById(R.id.toy_recyclerview);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.iv_chat_gpt);
        final String str = this.h instanceof MainActivity ? "home" : "my pattern";
        imageView.setVisibility(eg3.d(getContext(), "chatGPTConfig", false) ? 0 : 8);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.rp3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.h(str, view);
            }
        });
        ye3.i(str, "chatgpt_pleasure_exposure", "exposure", "chatgpt_pleasure", "button");
        if (this.d.size() > 0) {
            this.d.clear();
        }
        this.d.addAll(k(m()));
        BindToyListDialogAdapter bindToyListDialogAdapter = new BindToyListDialogAdapter(this.h, this.d);
        this.c = bindToyListDialogAdapter;
        bindToyListDialogAdapter.J0(new a());
        int iMin = Math.min(this.d.size(), 4);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.h, iMin);
        this.f = gridLayoutManager;
        this.g.setLayoutManager(gridLayoutManager);
        this.g.setAdapter(this.c);
        this.g.addItemDecoration(new d(this, ce3.a(this.h, 24.0f), iMin));
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        ((SimpleItemAnimator) this.g.getItemAnimator()).setSupportsChangeAnimations(false);
        window.setAttributes(attributes);
    }

    public List<Toy> i(List<Toy> list) {
        ArrayList arrayList = new ArrayList(list);
        for (int i = 0; i < list.size(); i++) {
            for (int size = list.size() - 1; size > i; size--) {
                if (list.get(i).getType().equals(list.get(size).getType())) {
                    arrayList.remove(list.get(size));
                } else if (list.get(i).isXMachine() && list.get(size).isMiniXMachine()) {
                    arrayList.remove(list.get(size));
                } else if (list.get(i).isMiniXMachine() && list.get(size).isXMachine()) {
                    arrayList.remove(list.get(i));
                }
                if (list.get(size).getType().equals("...") && (list.size() > 12 || list.size() == Toy.toyConfigBean.size())) {
                    arrayList.remove(list.get(size));
                }
            }
        }
        return arrayList;
    }

    public void j(c cVar) {
        this.e = cVar;
    }

    public List<Toy> k(List<Toy> list) {
        List<Toy> arrayList = new ArrayList<>();
        LinkedList linkedList = new LinkedList();
        String[] strArr = {"lush", "gush", "hush", "nora", "max", "edge", "tenera", "xmachine", "flexer", Toy.TOY_FEATURE_GRAVITY, "lapis"};
        int i = this.a;
        if (i == 1) {
            arrayList.addAll(pc1.a.P());
            Toy toy = new Toy();
            toy.setType("...");
            arrayList.add(toy);
            return i(arrayList);
        }
        if (i == 2) {
            arrayList.addAll(pc1.a.o());
            Toy toy2 = new Toy();
            toy2.setType("...");
            arrayList.add(toy2);
            return i(arrayList);
        }
        if (i == 0) {
            List listAsList = Arrays.asList(strArr);
            for (int i2 = 0; i2 < listAsList.size(); i2++) {
                for (int i3 = 0; i3 < list.size(); i3++) {
                    if (list.get(i3).getType().equalsIgnoreCase((String) listAsList.get(i2))) {
                        linkedList.add(i2, list.get(i3));
                    }
                }
            }
        } else {
            List listAsList2 = Arrays.asList(strArr);
            for (int i4 = 0; i4 < listAsList2.size(); i4++) {
                Iterator<Toy> it = list.iterator();
                while (it.hasNext()) {
                    Toy next = it.next();
                    if (next.getType().equalsIgnoreCase((String) listAsList2.get(i4))) {
                        linkedList.add(i4, next);
                        it.remove();
                    }
                }
            }
            if (linkedList.size() > 0) {
                Collections.sort(list, new b(this));
            }
            linkedList.addAll(list);
        }
        pc1 pc1Var = pc1.a;
        if (pc1Var.P().size() > 0) {
            arrayList.addAll(pc1Var.P());
        } else if (pc1Var.o().size() > 0) {
            arrayList.addAll(pc1Var.o());
        }
        arrayList.addAll(linkedList);
        if (this.a != 2) {
            Toy toy3 = new Toy();
            toy3.setType("...");
            arrayList.add(toy3);
        }
        return i(arrayList);
    }

    public List<Toy> l() {
        ArrayList arrayList = new ArrayList();
        for (ToyConfigInfoBean toyConfigInfoBean : Toy.toyConfigBean) {
            if (toyConfigInfoBean.isSelling()) {
                arrayList.add(b(toyConfigInfoBean));
            }
        }
        return arrayList;
    }

    public List<Toy> m() {
        ArrayList arrayList = new ArrayList();
        pc1 pc1Var = pc1.a;
        if (pc1Var.P().size() > 0) {
            arrayList.addAll(pc1Var.P());
            this.a = 1;
        } else if (pc1Var.o().size() > 0) {
            arrayList.addAll(pc1Var.o());
            this.a = 2;
        } else {
            arrayList.addAll(l());
            this.a = 0;
        }
        return arrayList;
    }

    @Override // android.app.Dialog
    public void show() {
        if (this.h != null) {
            super.show();
        }
    }
}

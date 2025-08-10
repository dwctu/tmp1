package com.wear.widget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NavUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.lovense.wear.R;
import com.wear.bean.Toy;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import dc.ah4;
import dc.pc1;
import dc.th4;
import dc.vi1;
import dc.y22;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class MyActionBar extends RelativeLayout implements View.OnClickListener {
    public LinearLayout A;
    public LinearLayout B;
    public TextView C;
    public TextView D;
    public ImageView E;
    public TextView F;
    public ImageView G;
    public AppCompatTextView K;
    public RelativeLayout L;
    public g M;
    public boolean a;
    public boolean b;
    public boolean c;
    public Activity d;
    public LayoutInflater e;
    public RelativeLayout f;
    public ImageView g;
    public ImageView h;
    public ImageView i;
    public TextView j;
    public TextView k;
    public ImageButton l;
    public RelativeLayout m;
    public Button n;
    public LinearLayout o;
    public MediumBoldRadioButton p;
    public MediumBoldRadioButton q;
    public Button r;
    public ConstraintLayout s;
    public ImageView t;
    public View u;
    public TextView v;
    public TextView w;
    public ImageView x;
    public Context y;
    public LinearLayout z;

    public class a implements View.OnClickListener {
        public final /* synthetic */ Activity a;

        public a(MyActionBar myActionBar, Activity activity) {
            this.a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof f)) {
                ((f) tag).performAction(view);
                return;
            }
            Intent parentActivityIntent = NavUtils.getParentActivityIntent(this.a);
            if (parentActivityIntent != null) {
                parentActivityIntent.addFlags(131072);
                this.a.startActivity(parentActivityIntent);
            }
            this.a.finish();
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ Activity a;

        public b(MyActionBar myActionBar, Activity activity) {
            this.a = activity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Intent parentActivityIntent = NavUtils.getParentActivityIntent(this.a);
            if (parentActivityIntent != null) {
                parentActivityIntent.addFlags(131072);
                this.a.startActivity(parentActivityIntent);
            }
            this.a.finish();
        }
    }

    public class c implements View.OnClickListener {
        public c(MyActionBar myActionBar) {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof f)) {
                return;
            }
            ((f) tag).performAction(view);
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ f a;

        public d(MyActionBar myActionBar, f fVar) {
            this.a = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f fVar = this.a;
            if (fVar != null) {
                fVar.performAction(view);
            }
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MyActionBar.this.b) {
                ArrayList<Toy> arrayListP = pc1.a.P();
                String str = "";
                if (arrayListP.isEmpty()) {
                    MyActionBar.this.v.setBackgroundResource(R.drawable.nav_toy_connect);
                    MyActionBar.this.v.setText("");
                    MyActionBar.this.v.setVisibility(0);
                    MyActionBar.this.w.setBackgroundResource(R.drawable.nav_toy_connect);
                    MyActionBar.this.w.setText("");
                    MyActionBar.this.w.setVisibility(8);
                    MyActionBar myActionBar = MyActionBar.this;
                    if (!myActionBar.c) {
                        myActionBar.A.setVisibility(8);
                    }
                    MyActionBar.this.K.setVisibility(8);
                    return;
                }
                MyActionBar myActionBar2 = MyActionBar.this;
                if (!myActionBar2.c) {
                    myActionBar2.D.setVisibility(8);
                    MyActionBar.this.E.setVisibility(8);
                    MyActionBar.this.F.setVisibility(8);
                    MyActionBar.this.G.setVisibility(8);
                }
                for (int i = 0; i < arrayListP.size(); i++) {
                    Toy toy = arrayListP.get(i);
                    MyActionBar.this.r(toy, i);
                    str = i == 0 ? str + toy.getToyUINameSpecialForMiniXMachine(1) : str + "," + toy.getToyUINameSpecialForMiniXMachine(1);
                }
                if (arrayListP.size() <= 2) {
                    MyActionBar.this.C.setVisibility(8);
                    MyActionBar.this.K.setVisibility(8);
                    return;
                }
                MyActionBar.this.v.setVisibility(8);
                MyActionBar.this.w.setVisibility(8);
                MyActionBar.this.K.setVisibility(0);
                MyActionBar.this.K.setText(String.format(ah4.c(R.string.multiple_toys), Integer.valueOf(arrayListP.size())));
                MyActionBar.this.B.setVisibility(8);
                MyActionBar.this.C.setText(arrayListP.size() + " Toys:" + str);
                MyActionBar.this.C.setVisibility(0);
            }
        }
    }

    public interface f {
        void performAction(View view);
    }

    public class g extends BroadcastReceiver {
        public g() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String str = "actionbar: +" + intent.getAction() + ", actiivty: " + MyActionBar.this.d.getClass().getName();
            String action = intent.getAction();
            action.hashCode();
            if (action.equals("ACTION_TOY_UPDATE")) {
                MyActionBar myActionBar = MyActionBar.this;
                if (myActionBar.b) {
                    myActionBar.setRssiImage(WearUtils.x, myActionBar.d);
                }
            }
        }
    }

    public MyActionBar(final Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        String string;
        super(context, attributeSet);
        this.a = false;
        this.b = false;
        this.c = false;
        this.y = context;
        if (isInEditMode()) {
            return;
        }
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.e = layoutInflater;
        RelativeLayout relativeLayout = (RelativeLayout) layoutInflater.inflate(R.layout.actionbar, (ViewGroup) null);
        this.f = relativeLayout;
        this.g = (ImageView) relativeLayout.findViewById(R.id.actionbar_divide);
        this.h = (ImageView) this.f.findViewById(R.id.iv_under_preview);
        this.i = (ImageView) this.f.findViewById(R.id.iv_image_right);
        this.j = (TextView) this.f.findViewById(R.id.actionbar_title);
        this.k = (TextView) this.f.findViewById(R.id.tv_sub_title);
        if (WearUtils.v) {
            this.j.setOnLongClickListener(new View.OnLongClickListener() { // from class: dc.fn3
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return MyActionBar.m(context, view);
                }
            });
        }
        this.l = (ImageButton) this.f.findViewById(R.id.actionbar_back);
        this.m = (RelativeLayout) this.f.findViewById(R.id.rl_actionbar_back);
        this.n = (Button) this.f.findViewById(R.id.actionbar_back_btn);
        this.o = (LinearLayout) this.f.findViewById(R.id.actionbar_tab);
        this.p = (MediumBoldRadioButton) this.f.findViewById(R.id.actionbar_bt1);
        this.q = (MediumBoldRadioButton) this.f.findViewById(R.id.actionbar_bt2);
        this.r = (Button) this.f.findViewById(R.id.actionbar_yes_btn);
        this.s = (ConstraintLayout) this.f.findViewById(R.id.actionbar_yes_cl);
        this.t = (ImageView) this.f.findViewById(R.id.actionbar_yes_image);
        this.u = this.f.findViewById(R.id.actionbar_yes_point);
        this.v = (TextView) this.f.findViewById(R.id.actionbar_yew_image_btn);
        this.w = (TextView) this.f.findViewById(R.id.actionbar_yew_image_btn2);
        this.x = (ImageView) this.f.findViewById(R.id.btn_custom);
        AppCompatTextView appCompatTextView = (AppCompatTextView) this.f.findViewById(R.id.toys_number_text);
        this.K = appCompatTextView;
        appCompatTextView.setBackgroundDrawable(th4.d(getContext(), R.drawable.toys_number_background));
        this.z = (LinearLayout) this.f.findViewById(R.id.actionbar_replace_center_layout);
        this.A = (LinearLayout) this.f.findViewById(R.id.toy_layout);
        this.B = (LinearLayout) this.f.findViewById(R.id.ll_toy_list);
        this.C = (TextView) this.f.findViewById(R.id.toy_name);
        this.D = (TextView) this.f.findViewById(R.id.toy_name_first);
        this.E = (ImageView) this.f.findViewById(R.id.toy_battery_first);
        this.F = (TextView) this.f.findViewById(R.id.toy_name_second);
        this.G = (ImageView) this.f.findViewById(R.id.toy_battery_second);
        this.L = (RelativeLayout) this.f.findViewById(R.id.parent);
        addView(this.f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, vi1.MyActionBar);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(2, 0);
        if (resourceId != 0) {
            string = ah4.e(resourceId);
            ah4.j(this.j, resourceId, new Object[0]);
        } else {
            string = typedArrayObtainStyledAttributes.getString(2);
            this.j.setText(string);
        }
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        if (resourceId2 != 0) {
            this.n.setText(ah4.e(resourceId2));
        } else {
            this.n.setText(typedArrayObtainStyledAttributes.getString(1));
        }
        if (typedArrayObtainStyledAttributes.getBoolean(0, false)) {
            this.n.setVisibility(8);
            if (context instanceof Activity) {
                try {
                    this.l.setOnClickListener(new a(this, (Activity) context));
                    this.l.setVisibility(0);
                    this.m.setVisibility(0);
                    if (WearUtils.e1(string)) {
                        this.g.setVisibility(8);
                    } else {
                        this.g.setVisibility(0);
                        l();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } else {
            this.n.setVisibility(0);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(3, false)) {
            this.o.setVisibility(0);
        }
    }

    public static /* synthetic */ boolean m(Context context, View view) {
        y22.c().b(context);
        return false;
    }

    public View getBarView() {
        return this.f;
    }

    public TextView getLabelStatus() {
        return this.j;
    }

    public String getTitle() {
        return this.j.getText().toString();
    }

    public Button getYesBtn() {
        return this.r;
    }

    public TextView getYesImageBtn() {
        return this.v;
    }

    public TextView getYesImageBtnRight() {
        return this.w;
    }

    public void l() {
        this.g.setVisibility(8);
    }

    public void n() {
        if ((!(this.b) || !(this.d != null)) || this.M != null) {
            return;
        }
        this.M = new g();
        LocalBroadcastManager.getInstance(WearUtils.x).registerReceiver(this.M, new IntentFilter("ACTION_TOY_UPDATE"));
        setRssiImage(WearUtils.x, this.d);
    }

    public final void o(String str, Integer num, f fVar, String str2) {
        if (str != null) {
            this.r.setText(str);
            this.r.setOnClickListener(this);
            this.r.setTag(fVar);
            this.r.setVisibility(0);
        }
        if (num != null) {
            this.v.setBackgroundResource(num.intValue());
            this.v.setOnClickListener(this);
            this.v.setTag(fVar);
            this.v.setVisibility(0);
            if (WearUtils.e1(str2)) {
                return;
            }
            this.v.setTag(R.id.tag1, str2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof f) {
            ((f) tag).performAction(view);
        }
    }

    public void p() {
        Context context = this.y;
        if (context instanceof Activity) {
            try {
                this.n.setOnClickListener(new b(this, (Activity) context));
                this.n.setVisibility(0);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void q(int i) {
        this.n.setText(this.y.getString(i));
        p();
    }

    public final void r(Toy toy, int i) {
        ImageView imageView;
        TextView textView = this.v;
        TextView textView2 = null;
        if (i == 0) {
            textView2 = this.D;
            imageView = this.E;
        } else if (i == 1) {
            textView = this.w;
            textView2 = this.F;
            imageView = this.G;
        } else {
            imageView = null;
        }
        if (toy == null) {
            textView.setBackgroundResource(R.drawable.nav_toy_connect);
            textView.setText("");
            return;
        }
        int battery = toy.getBattery();
        if (this.a && Toy.NAME_MAP.containsKey(toy.getType()) && !this.c) {
            this.A.setVisibility(0);
            if (textView2 != null) {
                this.B.setVisibility(0);
                textView2.setVisibility(0);
                textView2.setText(toy.getToyUINameSpecialForMiniXMachine(1));
            }
            if (battery == -1) {
                this.A.setVisibility(8);
            }
            if (imageView != null) {
                if (toy.isF01Toy()) {
                    imageView.setVisibility(8);
                } else {
                    imageView.setVisibility(0);
                    Toy.updateToyBattery(imageView, battery);
                }
            }
        }
        if (Toy.NAME_MAP.containsKey(toy.getType())) {
            textView.setVisibility(0);
            if (i == 0) {
                this.w.setVisibility(8);
            }
        }
        if (Toy.ICON_MAP.get(toy.getType()) != null) {
            textView.setBackgroundResource(Toy.getToyIconLinkedId(toy.getType(), i, true));
            textView.setText(toy.getToyUINameSpecialForMiniXMachine(2));
        } else {
            textView.setBackgroundResource(R.drawable.nav_toy_connect);
            textView.setText("");
        }
    }

    public void s() {
        if ((this.b) && (this.d != null)) {
            LocalBroadcastManager.getInstance(WearUtils.x).unregisterReceiver(this.M);
        }
    }

    public void setBackAction(int i, f fVar) {
        String strE = ah4.e(i);
        if (TextUtils.isEmpty(strE)) {
            this.l.setVisibility(0);
            this.m.setVisibility(0);
            this.n.setVisibility(8);
        } else {
            this.n.setText(strE);
            this.n.setOnClickListener(this);
            this.n.setTag(fVar);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            this.n.setVisibility(0);
        }
    }

    public void setBackVisibility(int i) {
        this.l.setVisibility(i);
        this.m.setVisibility(i);
    }

    public void setCanterShowFriendToy(boolean z) {
        this.c = z;
    }

    public void setCenterLayoutVisibility(int i) {
        this.z.setVisibility(i);
    }

    public void setIconAction(Integer num, f fVar) {
        this.t.setImageDrawable(th4.d(getContext(), num.intValue()));
        this.t.setOnClickListener(this);
        this.t.setTag(fVar);
        this.s.setVisibility(0);
    }

    public void setImageBackAction(Integer num, f fVar, int i) {
        if (num != null) {
            this.l.setImageResource(num.intValue());
            this.l.setVisibility(0);
            this.m.setVisibility(0);
            this.g.setVisibility(i);
            l();
            this.l.setOnClickListener(null);
            this.l.setOnClickListener(new d(this, fVar));
        }
    }

    public void setImageBackBtnVisibility(int i) {
        this.l.setVisibility(i);
        this.m.setVisibility(i);
        this.g.setVisibility(i);
        l();
    }

    public void setIsUnderReview(int i) {
        this.h.setVisibility(i);
    }

    public void setNewMessagePoint(boolean z) {
        this.u.setVisibility(z ? 0 : 8);
    }

    public void setParentBackgroundColor(int i) {
        RelativeLayout relativeLayout = this.L;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(i);
        }
    }

    public void setRightImage(int i, int i2) {
        if (i > 0) {
            this.i.setImageResource(i);
            this.i.setVisibility(i2);
        }
    }

    public void setRssiImage(MyApplication myApplication, Activity activity) {
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new e());
    }

    public void setSubTitle(String str) {
        if (this.k.getVisibility() == 8) {
            this.k.setVisibility(0);
        }
        this.k.setText(str);
    }

    public void setTabAction(int i, String str, f fVar) {
        MediumBoldRadioButton mediumBoldRadioButton;
        if (i == 0) {
            mediumBoldRadioButton = this.p;
        } else if (i != 1) {
            return;
        } else {
            mediumBoldRadioButton = this.q;
        }
        mediumBoldRadioButton.setText(str);
        mediumBoldRadioButton.setOnClickListener(this);
        mediumBoldRadioButton.setTag(fVar);
    }

    public void setTabSelect(int i) {
        MediumBoldRadioButton mediumBoldRadioButton;
        if (i == 0) {
            mediumBoldRadioButton = this.p;
        } else if (i != 1) {
            return;
        } else {
            mediumBoldRadioButton = this.q;
        }
        mediumBoldRadioButton.setChecked(true);
    }

    public void setTabVisibility(boolean z) {
        if (z) {
            this.o.setVisibility(0);
        } else {
            this.o.setVisibility(8);
        }
    }

    public void setTitle(String str) {
        this.j.setText(str);
    }

    public void setToy(List<Toy> list) {
        if (list == null || list.isEmpty()) {
            this.A.setVisibility(8);
            return;
        }
        this.A.setVisibility(0);
        if (list.size() > 2) {
            this.B.setVisibility(8);
            this.C.setVisibility(0);
            String str = list.size() + " Toys:";
            for (int i = 0; i < list.size(); i++) {
                str = i == 0 ? str + list.get(i).getToyUINameSpecialForMiniXMachine(1) : str + "," + list.get(i).getToyUINameSpecialForMiniXMachine(1);
            }
            this.C.setText(str);
            return;
        }
        this.C.setVisibility(8);
        this.B.setVisibility(0);
        String toyUINameSpecialForMiniXMachine = null;
        String toyUINameSpecialForMiniXMachine2 = (list.size() <= 0 || list.get(0).getStatus() != 1) ? null : list.get(0).getToyUINameSpecialForMiniXMachine(1);
        if (list.size() > 1 && list.get(1).getStatus() == 1) {
            toyUINameSpecialForMiniXMachine = list.get(1).getToyUINameSpecialForMiniXMachine(1);
        }
        if (WearUtils.e1(toyUINameSpecialForMiniXMachine2) && WearUtils.e1(toyUINameSpecialForMiniXMachine)) {
            return;
        }
        if (WearUtils.e1(toyUINameSpecialForMiniXMachine2)) {
            this.D.setVisibility(8);
            this.E.setVisibility(8);
        } else {
            this.D.setVisibility(0);
            this.E.setVisibility(0);
            if (list.get(0).isF01Toy()) {
                this.E.setVisibility(8);
            } else {
                Toy.updateToyBattery(this.E, list.get(0).getBattery());
            }
            this.D.setText(toyUINameSpecialForMiniXMachine2);
        }
        if (WearUtils.e1(toyUINameSpecialForMiniXMachine)) {
            this.F.setVisibility(8);
            this.G.setVisibility(8);
            return;
        }
        this.F.setVisibility(0);
        this.G.setVisibility(0);
        if (list.get(1).isF01Toy()) {
            this.G.setVisibility(8);
        } else {
            Toy.updateToyBattery(this.G, list.get(1).getBattery());
        }
        this.F.setText(toyUINameSpecialForMiniXMachine);
    }

    public void setToysAction(f fVar, boolean z, Activity activity) {
        this.a = z;
        this.b = true;
        this.d = activity;
        this.v.setBackgroundResource(R.drawable.nav_toy_connect);
        this.v.setOnClickListener(this);
        this.v.setTag(fVar);
        this.v.setVisibility(0);
        this.w.setBackgroundResource(R.drawable.nav_toy_connect);
        this.w.setText("");
        this.w.setOnClickListener(this);
        this.w.setTag(fVar);
        this.x.setVisibility(8);
        this.A.setVisibility(8);
        if (!WearUtils.e1("toy")) {
            this.v.setTag(R.id.tag1, "toy");
        }
        this.K.setTag(fVar);
        this.K.setOnClickListener(this);
    }

    public void setToysActionRemote(f fVar, f fVar2, int i, boolean z, Activity activity) {
        this.a = z;
        this.b = true;
        this.d = activity;
        this.v.setBackgroundResource(R.drawable.nav_toy_connect);
        this.v.setOnClickListener(this);
        this.v.setTag(fVar);
        this.v.setVisibility(0);
        this.w.setBackgroundResource(R.drawable.nav_toy_connect);
        this.w.setText("");
        this.w.setOnClickListener(this);
        this.w.setTag(fVar);
        this.x.setVisibility(0);
        this.x.setImageResource(i);
        this.A.setVisibility(8);
        if (!WearUtils.e1("toy")) {
            this.v.setTag(R.id.tag1, "toy");
        }
        this.x.setOnClickListener(this);
        this.x.setTag(fVar2);
        this.K.setTag(fVar);
        this.K.setOnClickListener(this);
    }

    public void setYesAction(String str, f fVar) {
        o(str, null, fVar, null);
    }

    public void setYesActionText(String str) {
        if (str != null) {
            this.r.setText(str);
        }
    }

    public void setYesIconAction(Integer num, f fVar) {
        o(null, num, fVar, num.intValue() == R.drawable.nav_toy_connect ? "toy" : null);
    }

    public void setYesImageRightAction(Integer num, f fVar) {
        if (num != null) {
            this.w.setBackgroundResource(num.intValue());
            this.w.setText("");
            this.w.setTag(fVar);
            this.w.setVisibility(0);
            this.w.setOnClickListener(new c(this));
        }
    }

    public void setYesAction(int i, f fVar) {
        o(ah4.e(i), null, fVar, null);
    }

    public void setYesActionText(int i) {
        if (this.y.getString(i) != null) {
            setYesActionText(this.y.getString(i));
        }
    }

    public void setBackAction(f fVar) {
        this.l.setTag(fVar);
        this.l.setVisibility(0);
        this.m.setVisibility(0);
        this.n.setVisibility(8);
    }
}

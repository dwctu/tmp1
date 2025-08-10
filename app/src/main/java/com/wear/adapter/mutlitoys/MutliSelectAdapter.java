package com.wear.adapter.mutlitoys;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.broadcom.bt.util.io.IOUtils;
import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.lovense.wear.R;
import com.wear.adapter.BaseAdapter;
import com.wear.bean.controlmutlitoys.MultiToyOFunBean;
import com.wear.util.WearUtils;
import com.wear.widget.control.multiToys.MultiControlPanel;
import dc.gm1;
import dc.th4;
import dc.uu1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jivesoftware.smack.sm.packet.StreamManagement;

/* loaded from: classes3.dex */
public class MutliSelectAdapter extends BaseAdapter<MultiToyOFunBean> implements gm1.a {
    public a j;
    public final gm1 k;

    public interface a {
        boolean a(String str, String str2, boolean z);

        void b(String str);
    }

    public MutliSelectAdapter(List<MultiToyOFunBean> list, int i) {
        super(list, i);
        gm1 gm1Var = new gm1();
        this.k = gm1Var;
        gm1Var.d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C(String str, ImageView imageView, ImageView imageView2, View view) {
        a aVar = this.j;
        if (aVar != null) {
            boolean zA = aVar.a(str, "f", false);
            imageView.setImageResource(zA ? R.drawable.toolbar_fingering : R.drawable.toolbar_fingering_unselect);
            imageView2.setImageResource(zA ? R.drawable.mutli_select : R.drawable.mutli_unselect);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E(String str, ImageView imageView, ImageView imageView2, View view) {
        a aVar = this.j;
        if (aVar != null) {
            boolean zA = aVar.a(str, "p", false);
            imageView.setImageResource(zA ? R.drawable.mutli_select_contraction : R.drawable.mutli_unselect_contraction);
            imageView2.setImageResource(zA ? R.drawable.mutli_select : R.drawable.mutli_unselect);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G(String str, ImageView imageView, ImageView imageView2, View view) {
        a aVar = this.j;
        if (aVar != null) {
            boolean zA = aVar.a(str, "pos", false);
            imageView.setImageResource(zA ? R.drawable.mutli_select_position : R.drawable.mutli_unselect_position);
            imageView2.setImageResource(zA ? R.drawable.mutli_select : R.drawable.mutli_unselect);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I(String str, ImageView imageView, ImageView imageView2, ImageView imageView3, MultiToyOFunBean multiToyOFunBean, View view) {
        a aVar = this.j;
        if (aVar != null) {
            boolean zA = aVar.a(str, StreamManagement.AckRequest.ELEMENT, false);
            imageView.setImageResource(zA ? R.drawable.mutli_select_rotation : R.drawable.mutli_unselect_rotation);
            imageView2.setImageResource(zA ? R.drawable.mutli_select : R.drawable.mutli_unselect);
            imageView3.setEnabled(zA);
            if (multiToyOFunBean.isClockWise()) {
                imageView3.setImageDrawable(zA ? th4.d(this.c, R.drawable.chat_traditional_rotation_clockwise_blue) : th4.d(this.c, R.drawable.chat_traditional_rotation_clockwise_disable));
            } else {
                imageView3.setImageDrawable(zA ? th4.d(this.c, R.drawable.chat_traditional_rotation_anticlockwise_blue) : th4.d(this.c, R.drawable.chat_traditional_rotation_anticlockwise_disable));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void K(MultiToyOFunBean multiToyOFunBean, ImageView imageView, String str, View view) {
        multiToyOFunBean.setClockWise(!multiToyOFunBean.isClockWise());
        notifyItemChanged(this.b.indexOf(multiToyOFunBean), imageView);
        a aVar = this.j;
        if (aVar != null) {
            aVar.b(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void M(String str, ImageView imageView, ImageView imageView2, View view) {
        a aVar = this.j;
        if (aVar != null) {
            boolean zA = aVar.a(str, "s", false);
            imageView.setImageResource(zA ? R.drawable.mutli_select_suck : R.drawable.mutli_unselect_suck);
            imageView2.setImageResource(zA ? R.drawable.mutli_select : R.drawable.mutli_unselect);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void O(MultiToyOFunBean multiToyOFunBean, ImageView imageView, ImageView imageView2, View view) {
        if (this.j != null) {
            boolean zA = this.j.a(multiToyOFunBean.getToyAddress(), "t", false);
            imageView.setImageResource(zA ? R.drawable.multi_select_thrusting : R.drawable.multi_unselect_thrusting);
            imageView2.setImageResource(zA ? R.drawable.mutli_select : R.drawable.mutli_unselect);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void Q(String str, ImageView imageView, ImageView imageView2, View view) {
        a aVar = this.j;
        if (aVar != null) {
            boolean zA = aVar.a(str, "v2", false);
            imageView.setImageResource(zA ? R.drawable.mutli_select_vibration2 : R.drawable.mutli_unselect_vibration);
            imageView2.setImageResource(zA ? R.drawable.mutli_select : R.drawable.mutli_unselect);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void S(String str, ImageView imageView, ImageView imageView2, View view) {
        a aVar = this.j;
        if (aVar != null) {
            boolean zA = aVar.a(str, "v3", false);
            imageView.setImageResource(zA ? R.drawable.mutli_select_vibration3 : R.drawable.mutli_unselect_vibration);
            imageView2.setImageResource(zA ? R.drawable.mutli_select : R.drawable.mutli_unselect);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void U(String str, String str2, ImageView imageView, ImageView imageView2, View view) {
        a aVar = this.j;
        if (aVar != null) {
            boolean zA = aVar.a(str, str2, false);
            imageView.setImageResource(zA ? R.drawable.mutli_select_vibration : R.drawable.mutli_unselect_vibration);
            imageView2.setImageResource(zA ? R.drawable.mutli_select : R.drawable.mutli_unselect);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void W(String str, ImageView imageView, ImageView imageView2, View view) {
        a aVar = this.j;
        if (aVar != null) {
            boolean zA = aVar.a(str, "w", false);
            imageView.setImageResource(zA ? R.drawable.mutli_select_swing : R.drawable.mutli_unselect_swing);
            imageView2.setImageResource(zA ? R.drawable.mutli_select : R.drawable.mutli_unselect);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(String str, ImageView imageView, ImageView imageView2, View view) {
        a aVar = this.j;
        if (aVar != null) {
            boolean zA = aVar.a(str, GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG, false);
            imageView.setImageResource(zA ? R.drawable.mutli_select_depth : R.drawable.mutli_unselect_depth);
            imageView2.setImageResource(zA ? R.drawable.mutli_select : R.drawable.mutli_unselect);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void X(List<MultiToyOFunBean> list) {
        this.b = list;
        notifyDataSetChanged();
    }

    public void Y(a aVar) {
        this.j = aVar;
        this.k.b(aVar);
    }

    @Override // com.wear.adapter.BaseAdapter
    /* renamed from: Z, reason: merged with bridge method [inline-methods] */
    public void y(BaseAdapter.ViewHolder viewHolder, MultiToyOFunBean multiToyOFunBean, int i) {
        TextView textView = (TextView) viewHolder.getView(R.id.item_mutli_select_toy_name);
        String strA = uu1.a(multiToyOFunBean.getName(), 3);
        boolean zStartsWith = strA.startsWith("Thrusting");
        if ((multiToyOFunBean.isXMachine() && strA.contains("Mini")) || zStartsWith) {
            if (zStartsWith) {
                strA = strA.replace(" ", IOUtils.LINE_SEPARATOR_UNIX);
            }
            textView.setMaxLines(2);
        } else {
            textView.setMaxLines(1);
        }
        textView.setText(strA);
        String fun = multiToyOFunBean.isFunction() ? multiToyOFunBean.getFun() : multiToyOFunBean.getAllFun();
        if (WearUtils.e1(fun)) {
            return;
        }
        String[] strArrSplit = fun.split(",");
        ArrayList arrayList = new ArrayList(strArrSplit.length);
        Collections.addAll(arrayList, strArrSplit);
        if (MultiControlPanel.A) {
            if (arrayList.contains("v1")) {
                arrayList.remove("v1");
                arrayList.remove("v2");
                arrayList.add(PSOProgramService.VS_Key);
            }
        } else if (arrayList.contains("v1") || arrayList.contains("v2")) {
            arrayList.remove(PSOProgramService.VS_Key);
        }
        this.k.c(viewHolder, multiToyOFunBean, arrayList);
    }

    @Override // dc.gm1.a
    public void a(@NonNull BaseAdapter.ViewHolder viewHolder, final String str, boolean z, boolean z2) {
        ConstraintLayout constraintLayout = (ConstraintLayout) viewHolder.getView(R.id.item_mutli_select_p_layout);
        final ImageView imageView = (ImageView) viewHolder.getView(R.id.item_mutli_select_p_icon);
        final ImageView imageView2 = (ImageView) viewHolder.getView(R.id.item_mutli_select_p_icon_sel);
        if (z) {
            constraintLayout.setVisibility(0);
            imageView.setImageResource(z2 ? R.drawable.mutli_select_contraction : R.drawable.mutli_unselect_contraction);
            imageView2.setImageResource(z2 ? R.drawable.mutli_select : R.drawable.mutli_unselect);
        } else {
            constraintLayout.setVisibility(8);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.xl1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.E(str, imageView, imageView2, view);
            }
        });
    }

    @Override // dc.gm1.a
    public void b(@NonNull BaseAdapter.ViewHolder viewHolder, final String str, boolean z, boolean z2) {
        ConstraintLayout constraintLayout = (ConstraintLayout) viewHolder.getView(R.id.item_mutli_select_v3_layout);
        final ImageView imageView = (ImageView) viewHolder.getView(R.id.item_mutli_select_v3_icon);
        final ImageView imageView2 = (ImageView) viewHolder.getView(R.id.item_mutli_select_v3_icon_sel);
        if (z) {
            constraintLayout.setVisibility(0);
            imageView.setImageResource(z2 ? R.drawable.mutli_select_vibration3 : R.drawable.mutli_unselect_vibration);
            imageView2.setImageResource(z2 ? R.drawable.mutli_select : R.drawable.mutli_unselect);
        } else {
            constraintLayout.setVisibility(8);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.zl1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.S(str, imageView, imageView2, view);
            }
        });
    }

    @Override // dc.gm1.a
    public void c(@NonNull BaseAdapter.ViewHolder viewHolder, final String str, boolean z, boolean z2) {
        ConstraintLayout constraintLayout = (ConstraintLayout) viewHolder.getView(R.id.item_mutli_select_v2_layout);
        final ImageView imageView = (ImageView) viewHolder.getView(R.id.item_mutli_select_v2_icon);
        final ImageView imageView2 = (ImageView) viewHolder.getView(R.id.item_mutli_select_v2_icon_sel);
        if (z) {
            constraintLayout.setVisibility(0);
            imageView.setImageResource(z2 ? R.drawable.mutli_select_vibration2 : R.drawable.mutli_unselect_vibration);
            imageView2.setImageResource(z2 ? R.drawable.mutli_select : R.drawable.mutli_unselect);
        } else {
            constraintLayout.setVisibility(8);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.cm1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Q(str, imageView, imageView2, view);
            }
        });
    }

    @Override // dc.gm1.a
    public void d(@NonNull BaseAdapter.ViewHolder viewHolder, @Nullable final String str, boolean z, boolean z2) {
        ConstraintLayout constraintLayout = (ConstraintLayout) viewHolder.getView(R.id.item_mutli_select_pos_layout);
        final ImageView imageView = (ImageView) viewHolder.getView(R.id.item_mutli_select_pos_icon);
        final ImageView imageView2 = (ImageView) viewHolder.getView(R.id.item_mutli_select_pos_icon_sel);
        if (z) {
            constraintLayout.setVisibility(0);
            imageView.setImageResource(z2 ? R.drawable.mutli_select_position : R.drawable.mutli_unselect_position);
            imageView2.setImageResource(z2 ? R.drawable.mutli_select : R.drawable.mutli_unselect);
        } else {
            constraintLayout.setVisibility(8);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.em1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.G(str, imageView, imageView2, view);
            }
        });
    }

    @Override // dc.gm1.a
    public void e(@NonNull BaseAdapter.ViewHolder viewHolder, final String str, boolean z, boolean z2) {
        ConstraintLayout constraintLayout = (ConstraintLayout) viewHolder.getView(R.id.item_mutli_select_w_layout);
        final ImageView imageView = (ImageView) viewHolder.getView(R.id.item_mutli_select_w_icon);
        final ImageView imageView2 = (ImageView) viewHolder.getView(R.id.item_mutli_select_w_icon_sel);
        if (z) {
            constraintLayout.setVisibility(0);
            imageView.setImageResource(z2 ? R.drawable.mutli_select_swing : R.drawable.mutli_unselect_swing);
            imageView2.setImageResource(z2 ? R.drawable.mutli_select : R.drawable.mutli_unselect);
        } else {
            constraintLayout.setVisibility(8);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.dm1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.W(str, imageView, imageView2, view);
            }
        });
    }

    @Override // dc.gm1.a
    public void f(@NonNull BaseAdapter.ViewHolder viewHolder, final String str, boolean z, boolean z2) {
        ConstraintLayout constraintLayout = (ConstraintLayout) viewHolder.getView(R.id.item_mutli_select_f_layout);
        final ImageView imageView = (ImageView) viewHolder.getView(R.id.item_mutli_select_f_icon);
        final ImageView imageView2 = (ImageView) viewHolder.getView(R.id.item_mutli_select_f_icon_sel);
        if (z) {
            constraintLayout.setVisibility(0);
            imageView.setImageResource(z2 ? R.drawable.toolbar_fingering : R.drawable.toolbar_fingering_unselect);
            imageView2.setImageResource(z2 ? R.drawable.mutli_select : R.drawable.mutli_unselect);
        } else {
            constraintLayout.setVisibility(8);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.bm1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.C(str, imageView, imageView2, view);
            }
        });
    }

    @Override // dc.gm1.a
    public void g(@NonNull BaseAdapter.ViewHolder viewHolder, @NonNull final MultiToyOFunBean multiToyOFunBean, boolean z, boolean z2) {
        ConstraintLayout constraintLayout = (ConstraintLayout) viewHolder.getView(R.id.item_mutli_select_t_layout);
        final ImageView imageView = (ImageView) viewHolder.getView(R.id.item_mutli_select_t_icon);
        final ImageView imageView2 = (ImageView) viewHolder.getView(R.id.item_mutli_select_t_icon_sel);
        if (z) {
            constraintLayout.setVisibility(0);
            imageView.setImageResource(z2 ? R.drawable.multi_select_thrusting : R.drawable.multi_unselect_thrusting);
            imageView2.setImageResource(z2 ? R.drawable.mutli_select : R.drawable.mutli_unselect);
        } else {
            constraintLayout.setVisibility(8);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.yl1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.O(multiToyOFunBean, imageView, imageView2, view);
            }
        });
    }

    @Override // dc.gm1.a
    public void h(@NonNull BaseAdapter.ViewHolder viewHolder, final String str, boolean z, boolean z2) {
        ConstraintLayout constraintLayout = (ConstraintLayout) viewHolder.getView(R.id.item_mutli_select_d_layout);
        final ImageView imageView = (ImageView) viewHolder.getView(R.id.item_mutli_select_d_icon);
        final ImageView imageView2 = (ImageView) viewHolder.getView(R.id.item_mutli_select_d_icon_sel);
        if (z) {
            constraintLayout.setVisibility(0);
            imageView.setImageResource(z2 ? R.drawable.mutli_select_depth : R.drawable.mutli_unselect_depth);
            imageView2.setImageResource(z2 ? R.drawable.mutli_select : R.drawable.mutli_unselect);
        } else {
            constraintLayout.setVisibility(8);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.wl1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.A(str, imageView, imageView2, view);
            }
        });
    }

    @Override // dc.gm1.a
    public void i(@NotNull BaseAdapter.ViewHolder viewHolder, final MultiToyOFunBean multiToyOFunBean, boolean z, boolean z2) {
        final String toyAddress = multiToyOFunBean.getToyAddress();
        ConstraintLayout constraintLayout = (ConstraintLayout) viewHolder.getView(R.id.item_mutli_select_r_layout);
        final ImageView imageView = (ImageView) viewHolder.getView(R.id.item_mutli_select_r_icon);
        final ImageView imageView2 = (ImageView) viewHolder.getView(R.id.item_mutli_select_r_icon_sel);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) viewHolder.getView(R.id.item_mutli_select_nora_rotation_layout);
        final ImageView imageView3 = (ImageView) viewHolder.getView(R.id.item_mutli_select_nora_rotation_icon);
        if (z) {
            constraintLayout.setVisibility(0);
            constraintLayout2.setVisibility(0);
            imageView.setImageResource(z2 ? R.drawable.mutli_select_rotation : R.drawable.mutli_unselect_rotation);
            imageView2.setImageResource(z2 ? R.drawable.mutli_select : R.drawable.mutli_unselect);
            imageView3.setEnabled(z2);
            if (multiToyOFunBean.isClockWise()) {
                imageView3.setImageDrawable(z2 ? th4.d(this.c, R.drawable.chat_traditional_rotation_clockwise_blue) : th4.d(this.c, R.drawable.chat_traditional_rotation_clockwise_disable));
            } else {
                imageView3.setImageDrawable(z2 ? th4.d(this.c, R.drawable.chat_traditional_rotation_anticlockwise_blue) : th4.d(this.c, R.drawable.chat_traditional_rotation_anticlockwise_disable));
            }
        } else {
            constraintLayout2.setVisibility(8);
            constraintLayout.setVisibility(8);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.fm1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.I(toyAddress, imageView, imageView2, imageView3, multiToyOFunBean, view);
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() { // from class: dc.vl1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.K(multiToyOFunBean, imageView3, toyAddress, view);
            }
        });
    }

    @Override // dc.gm1.a
    public void j(@NonNull BaseAdapter.ViewHolder viewHolder, final String str, boolean z, boolean z2) {
        ConstraintLayout constraintLayout = (ConstraintLayout) viewHolder.getView(R.id.item_mutli_select_s_layout);
        final ImageView imageView = (ImageView) viewHolder.getView(R.id.item_mutli_select_s_icon);
        final ImageView imageView2 = (ImageView) viewHolder.getView(R.id.item_mutli_select_s_icon_sel);
        if (z) {
            constraintLayout.setVisibility(0);
            imageView.setImageResource(z2 ? R.drawable.mutli_select_suck : R.drawable.mutli_unselect_suck);
            imageView2.setImageResource(z2 ? R.drawable.mutli_select : R.drawable.mutli_unselect);
        } else {
            constraintLayout.setVisibility(8);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.am1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.M(str, imageView, imageView2, view);
            }
        });
    }

    @Override // dc.gm1.a
    public void k(@NotNull BaseAdapter.ViewHolder viewHolder, final String str, final String str2, boolean z, boolean z2) {
        ConstraintLayout constraintLayout = (ConstraintLayout) viewHolder.getView(R.id.item_mutli_select_v_layout);
        final ImageView imageView = (ImageView) viewHolder.getView(R.id.item_mutli_select_v_icon);
        final ImageView imageView2 = (ImageView) viewHolder.getView(R.id.item_mutli_select_v_icon_sel);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) viewHolder.getView(R.id.item_mutli_select_t_layout);
        if (z) {
            constraintLayout.setVisibility(0);
            constraintLayout2.setVisibility(8);
            imageView.setImageResource(z2 ? R.drawable.mutli_select_vibration : R.drawable.mutli_unselect_vibration);
            imageView2.setImageResource(z2 ? R.drawable.mutli_select : R.drawable.mutli_unselect);
        } else {
            constraintLayout.setVisibility(8);
            constraintLayout2.setVisibility(8);
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: dc.ul1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.U(str, str2, imageView, imageView2, view);
            }
        });
    }
}

package com.wear.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.broadcom.bt.util.io.IOUtils;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.lovense.wear.R;
import com.wang.avi.AVLoadingIndicatorView;
import com.wear.bean.Toy;
import com.wear.bean.socketio.controlLink.request.AddTimeRequest;
import com.wear.bean.socketio.controlLink.response.ControlLinkListResponse;
import com.wear.main.longDistance.controllink.CreateControlLinkActivity;
import com.wear.ui.longDistance.controlLink.ControlLinkChatActivity;
import com.wear.util.MyApplication;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.ao3;
import dc.be3;
import dc.c83;
import dc.cs3;
import dc.eq2;
import dc.is3;
import dc.lg3;
import dc.pc1;
import dc.pj3;
import dc.sg3;
import dc.th4;
import dc.uu1;
import dc.ye3;
import io.agora.rtc2.internal.AudioRoutingController;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import skin.support.widget.SkinCompatTextView;

/* loaded from: classes3.dex */
public class ControlLinkAdapter extends RecyclerView.Adapter<MyViewHolder> {
    public Context p;
    public List<ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO> q;
    public i s;
    public int a = 1;
    public int b = 2;
    public int c = 32;
    public int d = 31;
    public int e = 42;
    public int f = 41;
    public int g = 5;
    public int h = 71;
    public int i = 72;
    public ArrayList<String> j = new ArrayList<>();
    public ArrayList<String> k = new ArrayList<>();
    public ArrayList<String> l = new ArrayList<>();
    public ArrayList<String> m = new ArrayList<>();
    public int n = 0;
    public int o = 0;
    public long r = System.currentTimeMillis();

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.add_time)
        public LinearLayout addTime;

        @BindView(R.id.addTimeImage)
        public ImageView addTimeImage;

        @BindView(R.id.addTimeLoading)
        public AVLoadingIndicatorView addTimeLoading;

        @BindView(R.id.addTimeText)
        public TextView addTimeText;

        @BindView(R.id.bigToy1)
        public SkinCompatTextView bigToy1;

        @BindView(R.id.bigToy2)
        public SkinCompatTextView bigToy2;

        @BindView(R.id.clock)
        public ImageView clock;

        @BindView(R.id.copy_btn)
        public ImageView copyBtn;

        @BindView(R.id.countTime)
        public TextView countTime;

        @BindView(R.id.end)
        public ImageView end;

        @BindView(R.id.enter)
        public ImageView enter;

        @BindView(R.id.line)
        public ImageView line;

        @BindView(R.id.linkText)
        public TextView linkText;

        @BindView(R.id.tv_ispublic)
        public TextView mTvIsPublic;

        @BindView(R.id.more)
        public ImageView more;

        @BindView(R.id.reactivate)
        public LinearLayout reactivate;

        @BindView(R.id.repeat)
        public TextView repeat;

        @BindView(R.id.share)
        public ImageView share;

        @BindView(R.id.tag1)
        public TextView tag1;

        @BindView(R.id.tag2)
        public TextView tag2;

        @BindView(R.id.tag3)
        public TextView tag3;

        @BindView(R.id.tag4)
        public TextView tag4;

        @BindView(R.id.tag_name)
        public TextView tagName;

        @BindView(R.id.timeContainer)
        public ConstraintLayout timeContainer;

        @BindView(R.id.tip)
        public TextView tip;

        @BindView(R.id.title)
        public TextView title;

        public MyViewHolder(@NonNull @NotNull ControlLinkAdapter controlLinkAdapter, View view) {
            super(view);
            ButterKnife.bind(this, view);
            LayoutInflater.from(view.getContext()).inflate(R.layout.control_link_item_layout, (ViewGroup) null, false);
        }
    }

    public class MyViewHolder_ViewBinding implements Unbinder {
        public MyViewHolder a;

        @UiThread
        public MyViewHolder_ViewBinding(MyViewHolder myViewHolder, View view) {
            this.a = myViewHolder;
            myViewHolder.bigToy1 = (SkinCompatTextView) Utils.findRequiredViewAsType(view, R.id.bigToy1, "field 'bigToy1'", SkinCompatTextView.class);
            myViewHolder.bigToy2 = (SkinCompatTextView) Utils.findRequiredViewAsType(view, R.id.bigToy2, "field 'bigToy2'", SkinCompatTextView.class);
            myViewHolder.tagName = (TextView) Utils.findRequiredViewAsType(view, R.id.tag_name, "field 'tagName'", TextView.class);
            myViewHolder.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
            myViewHolder.linkText = (TextView) Utils.findRequiredViewAsType(view, R.id.linkText, "field 'linkText'", TextView.class);
            myViewHolder.copyBtn = (ImageView) Utils.findRequiredViewAsType(view, R.id.copy_btn, "field 'copyBtn'", ImageView.class);
            myViewHolder.tag1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tag1, "field 'tag1'", TextView.class);
            myViewHolder.tag2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tag2, "field 'tag2'", TextView.class);
            myViewHolder.tag3 = (TextView) Utils.findRequiredViewAsType(view, R.id.tag3, "field 'tag3'", TextView.class);
            myViewHolder.tag4 = (TextView) Utils.findRequiredViewAsType(view, R.id.tag4, "field 'tag4'", TextView.class);
            myViewHolder.clock = (ImageView) Utils.findRequiredViewAsType(view, R.id.clock, "field 'clock'", ImageView.class);
            myViewHolder.countTime = (TextView) Utils.findRequiredViewAsType(view, R.id.countTime, "field 'countTime'", TextView.class);
            myViewHolder.timeContainer = (ConstraintLayout) Utils.findRequiredViewAsType(view, R.id.timeContainer, "field 'timeContainer'", ConstraintLayout.class);
            myViewHolder.repeat = (TextView) Utils.findRequiredViewAsType(view, R.id.repeat, "field 'repeat'", TextView.class);
            myViewHolder.tip = (TextView) Utils.findRequiredViewAsType(view, R.id.tip, "field 'tip'", TextView.class);
            myViewHolder.line = (ImageView) Utils.findRequiredViewAsType(view, R.id.line, "field 'line'", ImageView.class);
            myViewHolder.addTime = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.add_time, "field 'addTime'", LinearLayout.class);
            myViewHolder.reactivate = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.reactivate, "field 'reactivate'", LinearLayout.class);
            myViewHolder.more = (ImageView) Utils.findRequiredViewAsType(view, R.id.more, "field 'more'", ImageView.class);
            myViewHolder.end = (ImageView) Utils.findRequiredViewAsType(view, R.id.end, "field 'end'", ImageView.class);
            myViewHolder.share = (ImageView) Utils.findRequiredViewAsType(view, R.id.share, "field 'share'", ImageView.class);
            myViewHolder.enter = (ImageView) Utils.findRequiredViewAsType(view, R.id.enter, "field 'enter'", ImageView.class);
            myViewHolder.addTimeImage = (ImageView) Utils.findRequiredViewAsType(view, R.id.addTimeImage, "field 'addTimeImage'", ImageView.class);
            myViewHolder.addTimeText = (TextView) Utils.findRequiredViewAsType(view, R.id.addTimeText, "field 'addTimeText'", TextView.class);
            myViewHolder.mTvIsPublic = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_ispublic, "field 'mTvIsPublic'", TextView.class);
            myViewHolder.addTimeLoading = (AVLoadingIndicatorView) Utils.findRequiredViewAsType(view, R.id.addTimeLoading, "field 'addTimeLoading'", AVLoadingIndicatorView.class);
        }

        @Override // butterknife.Unbinder
        @CallSuper
        public void unbind() {
            MyViewHolder myViewHolder = this.a;
            if (myViewHolder == null) {
                throw new IllegalStateException("Bindings already cleared.");
            }
            this.a = null;
            myViewHolder.bigToy1 = null;
            myViewHolder.bigToy2 = null;
            myViewHolder.tagName = null;
            myViewHolder.title = null;
            myViewHolder.linkText = null;
            myViewHolder.copyBtn = null;
            myViewHolder.tag1 = null;
            myViewHolder.tag2 = null;
            myViewHolder.tag3 = null;
            myViewHolder.tag4 = null;
            myViewHolder.clock = null;
            myViewHolder.countTime = null;
            myViewHolder.timeContainer = null;
            myViewHolder.repeat = null;
            myViewHolder.tip = null;
            myViewHolder.line = null;
            myViewHolder.addTime = null;
            myViewHolder.reactivate = null;
            myViewHolder.more = null;
            myViewHolder.end = null;
            myViewHolder.share = null;
            myViewHolder.enter = null;
            myViewHolder.addTimeImage = null;
            myViewHolder.addTimeText = null;
            myViewHolder.mTvIsPublic = null;
            myViewHolder.addTimeLoading = null;
        }
    }

    public class a implements ao3.a {
        public a(ControlLinkAdapter controlLinkAdapter) {
        }

        @Override // dc.ao3.a
        public void a(ao3 ao3Var) {
        }

        @Override // dc.ao3.a
        public void b(ao3 ao3Var) {
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO a;
        public final /* synthetic */ ao3 b;

        public b(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO, ao3 ao3Var) {
            this.a = longTimeControlLinkListDTO;
            this.b = ao3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ControlLinkAdapter.this.O(this.a.getLongTimeControlLinkId(), ControlLinkAdapter.this.a);
            this.b.dismiss();
            Bundle bundle = new Bundle();
            ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO = this.a;
            longTimeControlLinkListDTO.isEdit = true;
            bundle.putSerializable(CreateControlLinkActivity.t, longTimeControlLinkListDTO);
            pj3.p((Activity) ControlLinkAdapter.this.p, CreateControlLinkActivity.class, CreateControlLinkActivity.s, bundle);
        }
    }

    public class c implements View.OnClickListener {
        public final /* synthetic */ ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO a;
        public final /* synthetic */ ao3 b;

        public c(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO, ao3 ao3Var) {
            this.a = longTimeControlLinkListDTO;
            this.b = ao3Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ControlLinkAdapter.this.O(this.a.getLongTimeControlLinkId(), ControlLinkAdapter.this.b);
            this.b.dismiss();
            this.a.isEdit = false;
            ControlLinkAdapter.this.q();
            ArrayList arrayList = new ArrayList();
            List<ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ToysDTO> toys = this.a.getToys();
            if (toys != null && toys.size() > 0) {
                for (ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ToysDTO toysDTO : toys) {
                    if (ControlLinkAdapter.this.m.contains(toysDTO.getToyId())) {
                        arrayList.add(toysDTO.getToyName());
                    }
                }
            }
            if (ControlLinkAdapter.this.s != null) {
                ControlLinkAdapter.this.s.u0(this.a, arrayList);
            }
        }
    }

    public class d implements View.OnClickListener {
        public final /* synthetic */ ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO a;
        public final /* synthetic */ ao3 b;
        public final /* synthetic */ int c;

        public d(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO, ao3 ao3Var, int i) {
            this.a = longTimeControlLinkListDTO;
            this.b = ao3Var;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ControlLinkAdapter.this.O(this.a.getLongTimeControlLinkId(), ControlLinkAdapter.this.i);
            this.b.dismiss();
            ControlLinkAdapter.this.q();
            boolean z = ControlLinkAdapter.this.m.size() > 0;
            if (z) {
                z = !this.a.isRewaiting();
            }
            if (ControlLinkAdapter.this.s != null) {
                ControlLinkAdapter.this.s.y3(this.c, this.a.getLongTimeControlLinkId(), z);
            }
        }
    }

    public class e implements View.OnClickListener {
        public final /* synthetic */ ao3 a;
        public final /* synthetic */ ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO b;
        public final /* synthetic */ String c;

        public e(ao3 ao3Var, ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO, String str) {
            this.a = ao3Var;
            this.b = longTimeControlLinkListDTO;
            this.c = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            ControlLinkAdapter.this.P(this.b, this.c);
            ControlLinkAdapter.this.O(this.b.getLongTimeControlLinkId(), ControlLinkAdapter.this.d);
        }
    }

    public class f implements View.OnClickListener {
        public final /* synthetic */ ao3 a;
        public final /* synthetic */ ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO b;

        public f(ao3 ao3Var, ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO) {
            this.a = ao3Var;
            this.b = longTimeControlLinkListDTO;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            if (ControlLinkAdapter.this.s != null) {
                ControlLinkAdapter.this.s.C1(this.b, false);
                ControlLinkAdapter.this.O(this.b.getLongTimeControlLinkId(), ControlLinkAdapter.this.f);
            }
        }
    }

    public class g implements View.OnClickListener {
        public final /* synthetic */ ao3 a;
        public final /* synthetic */ ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO b;

        public g(ao3 ao3Var, ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO) {
            this.a = ao3Var;
            this.b = longTimeControlLinkListDTO;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.a.dismiss();
            if (ControlLinkAdapter.this.s != null) {
                if (this.b.getRepeat().booleanValue()) {
                    ControlLinkAdapter.this.s.A2(this.b.getLongTimeControlLinkId());
                } else {
                    ControlLinkAdapter.this.s.C1(this.b, true);
                    ControlLinkAdapter.this.O(this.b.getLongTimeControlLinkId(), ControlLinkAdapter.this.f);
                }
            }
        }
    }

    public class h implements View.OnClickListener {
        public final /* synthetic */ ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO a;
        public final /* synthetic */ ao3 b;
        public final /* synthetic */ int c;

        public class a implements is3.d {
            public a() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                if (ControlLinkAdapter.this.s != null) {
                    i iVar = ControlLinkAdapter.this.s;
                    h hVar = h.this;
                    iVar.Y3(hVar.c, hVar.a.getLongTimeControlLinkId());
                }
            }
        }

        public class b implements is3.d {
            public b() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                if (ControlLinkAdapter.this.s != null) {
                    i iVar = ControlLinkAdapter.this.s;
                    h hVar = h.this;
                    iVar.Y3(hVar.c, hVar.a.getLongTimeControlLinkId());
                }
            }
        }

        public h(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO, ao3 ao3Var, int i) {
            this.a = longTimeControlLinkListDTO;
            this.b = ao3Var;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ControlLinkAdapter.this.O(this.a.getLongTimeControlLinkId(), ControlLinkAdapter.this.g);
            this.b.dismiss();
            if (this.a.getCurrentStatus().equals(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ACTIVE) || this.a.getCurrentStatus().equals(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.WAITING)) {
                cs3.a(ControlLinkAdapter.this.p, ah4.e(R.string.notification_delete_control_link1), new a()).show();
            } else {
                cs3.a(ControlLinkAdapter.this.p, ah4.e(R.string.notification_delete_control_link2), new b()).show();
            }
        }
    }

    public interface i {
        void A2(String str);

        void C1(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO, boolean z);

        void M3(List<String> list, String str);

        void Y3(int i, String str);

        void u0(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO, List<String> list);

        void y3(int i, String str, boolean z);
    }

    public ControlLinkAdapter(Context context, List<ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO> list) {
        this.p = context;
        this.q = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void C(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO, int i2, View view) {
        if (System.currentTimeMillis() - this.r > ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS) {
            HashMap map = new HashMap();
            map.put(TtmlNode.ATTR_ID, longTimeControlLinkListDTO.getLastActiveSessionId());
            ye3.d("M0052", WearUtils.A.toJson(map));
            eq2.f().h(new AddTimeRequest(longTimeControlLinkListDTO.getLastActiveSessionId(), 300));
            this.r = System.currentTimeMillis();
            longTimeControlLinkListDTO.isAddingTime = true;
            notifyItemChanged(i2, Integer.valueOf(R.id.addTimeImage));
            notifyItemChanged(i2, Integer.valueOf(R.id.addTimeText));
            notifyItemChanged(i2, Integer.valueOf(R.id.addTimeLoading));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void E(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO, View view) {
        Intent intent = new Intent(this.p, (Class<?>) ControlLinkChatActivity.class);
        intent.putExtra("linkId", longTimeControlLinkListDTO.getLastActiveSessionId());
        intent.setFlags(AudioRoutingController.DEVICE_OUT_USB_HEADSET);
        this.p.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void G(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO, int i2, View view) {
        O(longTimeControlLinkListDTO.getLongTimeControlLinkId(), this.h);
        q();
        boolean z = this.m.size() > 0;
        if (z) {
            z = !longTimeControlLinkListDTO.isRewaiting();
        }
        i iVar = this.s;
        if (iVar != null) {
            iVar.y3(i2, longTimeControlLinkListDTO.getLongTimeControlLinkId(), z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void I(StringBuilder sb, View view) {
        WearUtils.p(sb.toString(), this.p);
        sg3.l(ah4.e(R.string.system_copy_success));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void w(int i2, ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO, StringBuilder sb, View view) {
        N(view, i2, longTimeControlLinkListDTO, sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void y(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO, StringBuilder sb, View view) {
        P(longTimeControlLinkListDTO, sb.toString());
        O(longTimeControlLinkListDTO.getLongTimeControlLinkId(), this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void A(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO, View view) {
        i iVar = this.s;
        if (iVar != null) {
            iVar.C1(longTimeControlLinkListDTO, false);
        }
        O(longTimeControlLinkListDTO.getLongTimeControlLinkId(), this.e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder myViewHolder, int i2) {
        ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO = this.q.get(i2);
        final StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(longTimeControlLinkListDTO.getDescription())) {
            sb.append(longTimeControlLinkListDTO.getDescription());
            sb.append(" ");
        }
        if (longTimeControlLinkListDTO.getToys() != null && longTimeControlLinkListDTO.getToys().size() > 0) {
            myViewHolder.bigToy2.setVisibility(8);
            List<ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ToysDTO> toys = longTimeControlLinkListDTO.getToys();
            if (toys.size() > 1) {
                myViewHolder.bigToy2.setVisibility(0);
                ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ToysDTO toysDTO = toys.get(0);
                myViewHolder.bigToy1.setText(uu1.a(toysDTO.getToyName(), 3));
                myViewHolder.bigToy1.setMaxLines(uu1.d(toysDTO.getSymbol()) ? 2 : 1);
                ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ToysDTO toysDTO2 = toys.get(1);
                myViewHolder.bigToy2.setText(uu1.a(toysDTO2.getToyName(), 3));
                myViewHolder.bigToy2.setMaxLines(uu1.d(toysDTO2.getSymbol()) ? 2 : 1);
                sb.append("[");
                sb.append(uu1.a(toysDTO.getToyName(), 1));
                sb.append(", ");
                sb.append(uu1.a(toysDTO2.getToyName(), 1));
                sb.append("] ");
            } else {
                ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ToysDTO toysDTO3 = toys.get(0);
                myViewHolder.bigToy1.setText(uu1.a(toysDTO3.getToyName(), 3));
                myViewHolder.bigToy1.setMaxLines(uu1.d(toysDTO3.getSymbol()) ? 2 : 1);
                sb.append("[");
                sb.append(uu1.a(toysDTO3.getToyName(), 1));
                sb.append("] ");
            }
        }
        String description = longTimeControlLinkListDTO.getDescription();
        TextView textView = myViewHolder.title;
        if (TextUtils.isEmpty(description)) {
            description = longTimeControlLinkListDTO.getLongTimeControlLinkUrl();
        }
        textView.setText(description);
        myViewHolder.linkText.setText(longTimeControlLinkListDTO.getLongTimeControlLinkUrl());
        myViewHolder.copyBtn.setOnClickListener(new View.OnClickListener() { // from class: dc.oj1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.I(sb, view);
            }
        });
        myViewHolder.end.setVisibility(8);
        myViewHolder.addTime.setVisibility(8);
        myViewHolder.share.setVisibility(8);
        myViewHolder.enter.setVisibility(8);
        myViewHolder.reactivate.setVisibility(8);
        String currentStatus = longTimeControlLinkListDTO.getCurrentStatus();
        if (currentStatus.equals(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ACTIVE)) {
            r(myViewHolder, longTimeControlLinkListDTO);
        }
        if (currentStatus.equals(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.WAITING)) {
            u(myViewHolder, longTimeControlLinkListDTO);
        }
        if (currentStatus.equals(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.EXPIRED)) {
            t(myViewHolder, longTimeControlLinkListDTO);
        }
        myViewHolder.tag1.setVisibility(8);
        myViewHolder.tag2.setVisibility(8);
        myViewHolder.tag3.setVisibility(8);
        myViewHolder.tag4.setVisibility(8);
        List<String> hashTags = longTimeControlLinkListDTO.getHashTags();
        if (hashTags != null && hashTags.size() > 0) {
            sb.append("[");
            int i3 = 0;
            int length = 0;
            for (String str : hashTags) {
                if (i3 == 0) {
                    length += str.length();
                    myViewHolder.tag1.setText(str);
                    myViewHolder.tag1.setVisibility(0);
                    sb.append(str);
                }
                if (i3 == 1) {
                    length += str.length();
                    myViewHolder.tag2.setText(str);
                    myViewHolder.tag2.setVisibility(0);
                    sb.append("] ");
                    sb.append("[");
                    sb.append(str);
                }
                if (i3 == 2) {
                    if (length > 20) {
                        myViewHolder.tag4.setText(str);
                        myViewHolder.tag4.setVisibility(0);
                    } else {
                        myViewHolder.tag3.setText(str);
                        myViewHolder.tag3.setVisibility(0);
                    }
                    sb.append("] ");
                    sb.append("[");
                    sb.append(str);
                }
                i3++;
            }
            sb.append("] ");
        }
        long[] jArrK = be3.K(longTimeControlLinkListDTO.getDuration());
        String strZ = be3.z((int) jArrK[0], (int) jArrK[1], (int) jArrK[2]);
        sb.append("[");
        sb.append(strZ);
        sb.append("] ");
        sb.append(IOUtils.LINE_SEPARATOR_UNIX + longTimeControlLinkListDTO.getLongTimeControlLinkUrl());
        s(myViewHolder, i2, longTimeControlLinkListDTO, sb);
        myViewHolder.repeat.setText(longTimeControlLinkListDTO.getRepeat().booleanValue() ? ah4.e(R.string.duration_unlimited) : ah4.e(R.string.control_link_single_use));
        myViewHolder.repeat.setTextColor(th4.b(this.p, R.color.control_link_tag_text_color));
        if (longTimeControlLinkListDTO.isRewaiting()) {
            myViewHolder.repeat.setTextColor(th4.b(this.p, R.color.colorPrimary));
            String str2 = String.format(ah4.e(R.string.control_link_auto_reactivate_countdown), 30);
            if (longTimeControlLinkListDTO.getNextOnWaitingTimestamp() != 0) {
                int nextOnWaitingTimestamp = (int) (((longTimeControlLinkListDTO.getNextOnWaitingTimestamp() - MyApplication.N().h) - System.currentTimeMillis()) / 1000);
                if (nextOnWaitingTimestamp < 0) {
                    nextOnWaitingTimestamp = 0;
                }
                str2 = String.format(ah4.e(R.string.control_link_auto_reactivate_countdown), Integer.valueOf(nextOnWaitingTimestamp));
            }
            myViewHolder.repeat.setText(str2);
        }
        if (longTimeControlLinkListDTO.isShareTophy()) {
            myViewHolder.mTvIsPublic.setText(ah4.e(R.string.control_link_share_publicly));
        } else {
            myViewHolder.mTvIsPublic.setText(ah4.e(R.string.control_link_share_privately));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    @NotNull
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i2) {
        return new MyViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.control_link_item_layout, viewGroup, false));
    }

    public void L(List<ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO> list) {
        this.q = list;
        notifyDataSetChanged();
    }

    public void M(i iVar) {
        this.s = iVar;
    }

    public final void N(View view, int i2, ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO, String str) {
        ao3 ao3Var = new ao3(this.p, R.style.MenuDialogAl, R.layout.control_link_menu_item);
        ao3Var.a(view, 250, 200, 1800, -30, new a(this));
        ao3Var.findViewById(R.id.action_row_0).setOnClickListener(new b(longTimeControlLinkListDTO, ao3Var));
        ao3Var.findViewById(R.id.action_row_1).setOnClickListener(new c(longTimeControlLinkListDTO, ao3Var));
        ao3Var.findViewById(R.id.action_row_1_5).setOnClickListener(new d(longTimeControlLinkListDTO, ao3Var, i2));
        ao3Var.findViewById(R.id.action_row_2).setOnClickListener(new e(ao3Var, longTimeControlLinkListDTO, str));
        ao3Var.findViewById(R.id.action_row_3).setOnClickListener(new f(ao3Var, longTimeControlLinkListDTO));
        ao3Var.findViewById(R.id.action_row_4).setOnClickListener(new g(ao3Var, longTimeControlLinkListDTO));
        ao3Var.findViewById(R.id.action_row_5).setVisibility(0);
        ao3Var.findViewById(R.id.action_row_5).setOnClickListener(new h(longTimeControlLinkListDTO, ao3Var, i2));
        boolean zEquals = longTimeControlLinkListDTO.getCurrentStatus().equals(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.WAITING);
        ao3Var.findViewById(R.id.action_row_0).setVisibility(zEquals ? 0 : 8);
        ao3Var.findViewById(R.id.action_row_0_line).setVisibility(zEquals ? 0 : 8);
        boolean z = true;
        boolean z2 = !longTimeControlLinkListDTO.getCurrentStatus().equals(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.EXPIRED) && longTimeControlLinkListDTO.getRepeat().booleanValue();
        ao3Var.findViewById(R.id.action_row_3).setVisibility(z2 ? 0 : 8);
        ao3Var.findViewById(R.id.action_row_3_line).setVisibility(z2 ? 0 : 8);
        if (longTimeControlLinkListDTO.getCurrentStatus().equals(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.EXPIRED) && !longTimeControlLinkListDTO.isRewaiting()) {
            z = false;
        }
        ao3Var.findViewById(R.id.action_row_4).setVisibility(z ? 0 : 8);
        ao3Var.findViewById(R.id.action_row_4_line).setVisibility(z ? 0 : 8);
        ao3Var.show();
    }

    public final void O(String str, int i2) {
        HashMap map = new HashMap();
        map.put(TtmlNode.ATTR_ID, str);
        map.put("type", Integer.valueOf(i2));
        ye3.d("M0053", WearUtils.A.toJson(map));
    }

    public final void P(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO, String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList<Toy> arrayListP = pc1.a.P();
        if (longTimeControlLinkListDTO.getToys() != null && longTimeControlLinkListDTO.getToys().size() > 0) {
            for (ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ToysDTO toysDTO : longTimeControlLinkListDTO.getToys()) {
                if (!arrayListP.contains(pc1.a.R(toysDTO.getToyId()))) {
                    arrayList.add(toysDTO.getToyName());
                }
            }
        }
        i iVar = this.s;
        if (iVar != null) {
            iVar.M3(arrayList, str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.q.size();
    }

    public final void q() {
        List<ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ToysDTO> toys;
        this.o = 0;
        this.n = 0;
        this.k.clear();
        this.j.clear();
        this.l.clear();
        this.m.clear();
        List<ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO> list = this.q;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO : this.q) {
            if (longTimeControlLinkListDTO.getCurrentStatus().equals(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ACTIVE)) {
                this.o++;
                List<ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ToysDTO> toys2 = longTimeControlLinkListDTO.getToys();
                if (toys2 != null && toys2.size() > 0) {
                    for (ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ToysDTO toysDTO : toys2) {
                        this.j.add(toysDTO.getToyId());
                        if (!this.m.contains(toysDTO.getToyId())) {
                            this.m.add(toysDTO.getToyId());
                        }
                    }
                }
            }
            if (longTimeControlLinkListDTO.getCurrentStatus().equals(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.WAITING)) {
                this.n++;
                List<ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ToysDTO> toys3 = longTimeControlLinkListDTO.getToys();
                if (toys3 != null && toys3.size() > 0) {
                    for (ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ToysDTO toysDTO2 : toys3) {
                        this.k.add(toysDTO2.getToyId());
                        if (!this.m.contains(toysDTO2.getToyId())) {
                            this.m.add(toysDTO2.getToyId());
                        }
                    }
                }
            }
            if (longTimeControlLinkListDTO.getCurrentStatus().equals(ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.EXPIRED) && longTimeControlLinkListDTO.isRewaiting() && (toys = longTimeControlLinkListDTO.getToys()) != null && toys.size() > 0) {
                for (ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ToysDTO toysDTO3 : toys) {
                    this.l.add(toysDTO3.getToyId());
                    if (!this.m.contains(toysDTO3.getToyId())) {
                        this.m.add(toysDTO3.getToyId());
                    }
                }
            }
        }
    }

    public final void r(@NonNull MyViewHolder myViewHolder, ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO) {
        String strZ;
        myViewHolder.tagName.setText(ah4.e(R.string.auto_tip_state_runing));
        c83.R1().w2((ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO) longTimeControlLinkListDTO.clone());
        if (longTimeControlLinkListDTO.getExpiredTimestamp().longValue() == 0 || (longTimeControlLinkListDTO.getExpiredTimestamp().longValue() - (MyApplication.N().h / 2)) - System.currentTimeMillis() <= 0) {
            long[] jArrK = be3.K(longTimeControlLinkListDTO.getDuration());
            strZ = be3.z((int) jArrK[0], (int) jArrK[1], (int) jArrK[2]);
        } else {
            strZ = be3.l((longTimeControlLinkListDTO.getExpiredTimestamp().longValue() - (MyApplication.N().h / 2)) - System.currentTimeMillis());
        }
        myViewHolder.countTime.setText(strZ);
        myViewHolder.tip.setVisibility(8);
        myViewHolder.countTime.setTextColor(th4.b(this.p, R.color.colorPrimary));
        myViewHolder.clock.setImageDrawable(th4.d(this.p, R.drawable.controllink_icon_time2));
        myViewHolder.itemView.setBackground(th4.d(this.p, R.drawable.control_link_item_background_green));
        myViewHolder.addTime.setVisibility(0);
        myViewHolder.enter.setVisibility(0);
        myViewHolder.addTimeImage.setVisibility(longTimeControlLinkListDTO.isAddingTime ? 8 : 0);
        myViewHolder.addTimeText.setVisibility(longTimeControlLinkListDTO.isAddingTime ? 8 : 0);
        myViewHolder.addTimeLoading.setVisibility(longTimeControlLinkListDTO.isAddingTime ? 0 : 8);
    }

    public final void s(@NonNull MyViewHolder myViewHolder, final int i2, final ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO, final StringBuilder sb) {
        myViewHolder.more.setOnClickListener(new View.OnClickListener() { // from class: dc.nj1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.w(i2, longTimeControlLinkListDTO, sb, view);
            }
        });
        myViewHolder.share.setOnClickListener(new View.OnClickListener() { // from class: dc.pj1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.y(longTimeControlLinkListDTO, sb, view);
            }
        });
        myViewHolder.end.setOnClickListener(new View.OnClickListener() { // from class: dc.jj1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.A(longTimeControlLinkListDTO, view);
            }
        });
        myViewHolder.addTime.setOnClickListener(new View.OnClickListener() { // from class: dc.lj1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.C(longTimeControlLinkListDTO, i2, view);
            }
        });
        myViewHolder.enter.setOnClickListener(new View.OnClickListener() { // from class: dc.kj1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.E(longTimeControlLinkListDTO, view);
            }
        });
        myViewHolder.reactivate.setOnClickListener(new View.OnClickListener() { // from class: dc.mj1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.G(longTimeControlLinkListDTO, i2, view);
            }
        });
    }

    public final void t(@NonNull MyViewHolder myViewHolder, ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO) {
        myViewHolder.tagName.setText(ah4.e(R.string.common_state_expired));
        myViewHolder.tip.setVisibility(0);
        long[] jArrK = be3.K(longTimeControlLinkListDTO.getDuration());
        String strZ = be3.z((int) jArrK[0], (int) jArrK[1], (int) jArrK[2]);
        myViewHolder.countTime.setText(strZ);
        myViewHolder.countTime.setText(strZ);
        myViewHolder.countTime.setTextColor(th4.b(this.p, R.color.control_link_tag_text_color));
        myViewHolder.clock.setImageDrawable(th4.d(this.p, R.drawable.controllink_icon_time));
        myViewHolder.itemView.setBackground(th4.d(this.p, R.drawable.control_link_item_background_gray));
        String str = DateFormat.getDateInstance(2, lg3.e(MyApplication.N())).format(new Date(longTimeControlLinkListDTO.getExpiredTimestamp().longValue()));
        String str2 = String.format(ah4.e(R.string.control_link_expired_date), be3.i(be3.e, new Date(longTimeControlLinkListDTO.getExpiredTimestamp().longValue())) + " " + str);
        String str3 = String.format(ah4.e(R.string.control_link_controlled_times), longTimeControlLinkListDTO.getControlledTimes());
        myViewHolder.tip.setText(str2 + IOUtils.LINE_SEPARATOR_UNIX + str3);
        myViewHolder.reactivate.setVisibility(0);
    }

    public final void u(@NonNull MyViewHolder myViewHolder, ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO) {
        myViewHolder.tagName.setText(ah4.e(R.string.common_state_waiting));
        c83.R1().w2((ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO) longTimeControlLinkListDTO.clone());
        long[] jArrK = be3.K(longTimeControlLinkListDTO.getDuration());
        myViewHolder.countTime.setText(be3.z((int) jArrK[0], (int) jArrK[1], (int) jArrK[2]));
        myViewHolder.tip.setVisibility(8);
        myViewHolder.countTime.setTextColor(th4.b(this.p, R.color.control_link_tag_text_color));
        myViewHolder.clock.setImageDrawable(th4.d(this.p, R.drawable.controllink_icon_time));
        myViewHolder.itemView.setBackground(th4.d(this.p, R.drawable.control_link_item_background_yellow));
        myViewHolder.share.setVisibility(0);
    }
}

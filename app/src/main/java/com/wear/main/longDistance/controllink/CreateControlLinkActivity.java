package com.wear.main.longDistance.controllink;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.Toy;
import com.wear.bean.event.ControlLinkDescriptionEvent;
import com.wear.bean.socketio.controlLink.request.SaveControlLinkRequest;
import com.wear.bean.socketio.controlLink.response.ControlLinkCheckStatusResponse;
import com.wear.bean.socketio.controlLink.response.ControlLinkListResponse;
import com.wear.bean.socketio.controlLink.response.SaveControlLinkResponse;
import com.wear.main.toy.ToyActivity;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import com.wear.widget.MyActionBar;
import com.wear.widget.SelectToyDialog;
import com.wear.widget.SwitchView;
import com.wear.widget.TimePickerDialog;
import dc.ah4;
import dc.be3;
import dc.cs3;
import dc.d83;
import dc.eg3;
import dc.is3;
import dc.ku1;
import dc.pc1;
import dc.pj3;
import dc.sg3;
import dc.te3;
import dc.th4;
import dc.tn2;
import dc.ye3;
import dc.yn2;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class CreateControlLinkActivity extends BaseActivity {
    public static int s = 20;
    public static String t = "controlLink";
    public static int u = 21;
    public static int v = 22;
    public pc1 a;

    @BindView(R.id.actionbar)
    public MyActionBar actionBar;
    public String b;

    @BindView(R.id.control_link_permission)
    public SwitchView controlLinkPermission;

    @BindView(R.id.description)
    public TextView description;

    @BindView(R.id.descriptionLinear)
    public RelativeLayout descriptionLinear;

    @BindView(R.id.durationLinear)
    public RelativeLayout durationLinear;

    @BindView(R.id.durationTime)
    public TextView durationTime;

    @BindView(R.id.enter_des)
    public ImageView enterDes;

    @BindView(R.id.enter_duration)
    public ImageView enterDuration;

    @BindView(R.id.enter_toys)
    public ImageView enterToys;
    public String h;
    public int j;
    public int k;
    public int l;

    @BindView(R.id.swi_share_public)
    public SwitchView mSwiSharePublic;

    @BindView(R.id.tv_share_description)
    public TextView mTvShareDescription;
    public String n;

    @BindView(R.id.repeat)
    public TextView repeat;

    @BindView(R.id.save)
    public TextView save;

    @BindView(R.id.sch_receive_from_the_other)
    public SwitchView schReceiveFromTheOther;

    @BindView(R.id.sch_send_to_the_other)
    public SwitchView schSendToTheOther;

    @BindView(R.id.switchButton)
    public SwitchView switchButton;

    @BindView(R.id.tags)
    public TextView tags;

    @BindView(R.id.toy_names)
    public TextView toyNames;

    @BindView(R.id.toysLinear)
    public RelativeLayout toysLinear;

    @BindView(R.id.tv_permission_red)
    public TextView tvPermissionRed;
    public List<Toy> c = new ArrayList();
    public ArrayList<String> d = new ArrayList<>();
    public ArrayList<String> e = new ArrayList<>();
    public boolean f = false;
    public boolean g = false;
    public List<String> i = new ArrayList();
    public int m = 300;
    public boolean o = false;
    public int p = 0;
    public int q = 0;

    public class a implements yn2<ControlLinkCheckStatusResponse> {

        /* renamed from: com.wear.main.longDistance.controllink.CreateControlLinkActivity$a$a, reason: collision with other inner class name */
        public class C0131a implements is3.d {
            public C0131a() {
            }

            @Override // dc.is3.d
            public void doConfirm() {
                CreateControlLinkActivity.this.Q4();
            }
        }

        public a() {
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(ControlLinkCheckStatusResponse controlLinkCheckStatusResponse) {
            if (!controlLinkCheckStatusResponse.getResult().booleanValue() || controlLinkCheckStatusResponse.getCode().intValue() != 200) {
                if (controlLinkCheckStatusResponse.getCode().intValue() == 50022) {
                    sg3.l(ah4.e(R.string.control_link_end_failed));
                }
            } else if (controlLinkCheckStatusResponse.getData() != null) {
                if (controlLinkCheckStatusResponse.getData().getAllReallyExpired().booleanValue()) {
                    CreateControlLinkActivity.this.Q4();
                } else {
                    CreateControlLinkActivity.this.dissDialog();
                    cs3.c(CreateControlLinkActivity.this, ah4.e(R.string.link_end_control_notice), ah4.e(R.string.common_generate), ah4.e(R.string.common_cancel), new C0131a()).show();
                }
            }
        }

        @Override // dc.yn2
        public void onCompleted() {
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            CreateControlLinkActivity.this.dissDialog();
            sg3.l(netException.getMessage());
        }

        @Override // dc.yn2
        public void onStart() {
            CreateControlLinkActivity.this.showDialog();
        }
    }

    public class b extends ClickableSpan {
        public b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            if (!TextUtils.isEmpty("https://play.google.com/store/apps/details?id=com.tophy.android&referrer=utm_source%3Dremote_ctlink%26anid%3Dadmob")) {
                te3.a(CreateControlLinkActivity.this, "https://play.google.com/store/apps/details?id=com.tophy.android&referrer=utm_source%3Dremote_ctlink%26anid%3Dadmob");
            }
            ku1.f("create control link", "create_control_link_tophy_click", "create_control_link_tophy", null, null, null);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(th4.b(CreateControlLinkActivity.this, R.color.control_link_tophyapp_textcolor));
            textPaint.setUnderlineText(false);
        }
    }

    public class c implements MyActionBar.f {
        public c() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            pj3.f(CreateControlLinkActivity.this, ToyActivity.class);
        }
    }

    public class d implements MyActionBar.f {
        public d() {
        }

        @Override // com.wear.widget.MyActionBar.f
        public void performAction(View view) {
            String stringExtra;
            if (CreateControlLinkActivity.this.getIntent() != null && (stringExtra = CreateControlLinkActivity.this.getIntent().getStringExtra("isHome")) != null && TextUtils.equals(stringExtra, "home")) {
                pj3.f(CreateControlLinkActivity.this, ControlLinkNewActivity.class);
            }
            CreateControlLinkActivity.this.finish();
        }
    }

    public class e implements View.OnClickListener {

        public class a implements SelectToyDialog.e {
            public a() {
            }

            @Override // com.wear.widget.SelectToyDialog.e
            public void a(List<Toy> list) {
                CreateControlLinkActivity.this.c = list;
                CreateControlLinkActivity.this.N4();
            }
        }

        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CreateControlLinkActivity.this.a.o().size() == 0) {
                sg3.h(R.string.lan_api_connect_toy_first);
            } else {
                new SelectToyDialog(CreateControlLinkActivity.this, new a()).e(CreateControlLinkActivity.this.c);
            }
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            pj3.q(CreateControlLinkActivity.this, ControlLinkDescriptionActivity.class, ControlLinkDescriptionActivity.d, ControlLinkDescriptionEvent.tag, WearUtils.A.toJson(new ControlLinkDescriptionEvent(CreateControlLinkActivity.this.i, CreateControlLinkActivity.this.h)));
        }
    }

    public class g implements View.OnClickListener {

        public class a implements TimePickerDialog.f {
            public a() {
            }

            @Override // com.wear.widget.TimePickerDialog.f
            public void a(int i, int i2, int i3) {
                String str = "onSelect: 选中时间=" + i + "hour:" + i2 + "min:" + i3;
                CreateControlLinkActivity.this.durationTime.setText(be3.z(i, i2, i3));
                CreateControlLinkActivity.this.m = be3.y(i, i2, i3);
                CreateControlLinkActivity.this.j = i;
                CreateControlLinkActivity.this.k = i2;
                CreateControlLinkActivity.this.l = i3;
            }
        }

        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new TimePickerDialog(CreateControlLinkActivity.this, new a()).l(CreateControlLinkActivity.this.j, CreateControlLinkActivity.this.k, CreateControlLinkActivity.this.l);
        }
    }

    public class h implements CompoundButton.OnCheckedChangeListener {
        public h() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            CreateControlLinkActivity.this.f = z;
        }
    }

    public class i implements CompoundButton.OnCheckedChangeListener {
        public i() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            CreateControlLinkActivity.this.g = z;
        }
    }

    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (CreateControlLinkActivity.this.c == null || CreateControlLinkActivity.this.c.size() == 0) {
                sg3.l(ah4.e(R.string.lan_api_connect_toy_first));
            } else if (CreateControlLinkActivity.this.o) {
                CreateControlLinkActivity.this.Q4();
            } else {
                CreateControlLinkActivity.this.K4();
            }
        }
    }

    public class k implements yn2<SaveControlLinkResponse> {
        public final /* synthetic */ StringBuilder a;
        public final /* synthetic */ String b;

        public k(StringBuilder sb, String str) {
            this.a = sb;
            this.b = str;
        }

        @Override // dc.yn2, dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(SaveControlLinkResponse saveControlLinkResponse) {
            String stringExtra;
            if (saveControlLinkResponse.getResult().booleanValue() && saveControlLinkResponse.getCode().intValue() == 200) {
                SaveControlLinkResponse.InnerData data = saveControlLinkResponse.getData();
                if (!TextUtils.isEmpty(data.getLongTimeControlLinkUrl())) {
                    this.a.append(data.getLongTimeControlLinkUrl());
                    WearUtils.p(this.a.toString(), CreateControlLinkActivity.this);
                    sg3.h(R.string.system_copy_success);
                }
                CreateControlLinkActivity.this.setResult(CreateControlLinkActivity.v);
                if (CreateControlLinkActivity.this.getIntent() != null && (stringExtra = CreateControlLinkActivity.this.getIntent().getStringExtra("isHome")) != null && TextUtils.equals(stringExtra, "home")) {
                    pj3.f(CreateControlLinkActivity.this, ControlLinkNewActivity.class);
                }
                CreateControlLinkActivity.this.P4(data.getLongTimeControlLinkId());
                CreateControlLinkActivity.this.finish();
                String str = "onSuccess: 请求时间=" + this.b + " 结束时间=" + be3.i(be3.a, new Date(System.currentTimeMillis()));
            }
            if (saveControlLinkResponse.getResult().booleanValue() || saveControlLinkResponse.getCode().intValue() != 40010) {
                return;
            }
            sg3.l(saveControlLinkResponse.getMessage());
        }

        @Override // dc.yn2
        public void onCompleted() {
            CreateControlLinkActivity.this.dissDialog();
        }

        @Override // dc.yn2, dc.zn2
        public void onError(NetException netException) {
            if (CreateControlLinkActivity.this.o) {
                sg3.l(ah4.e(R.string.control_link_edit_failed));
            } else {
                sg3.l(netException.message);
            }
        }

        @Override // dc.yn2
        public void onStart() {
            CreateControlLinkActivity.this.showDialog();
        }
    }

    public final void K4() {
        tn2.x(this).h("/app/long_time_control_link/checkStatus", "", new a());
    }

    public final void L4() {
        Toy toyR;
        Toy toyR2;
        Toy toyR3;
        ArrayList<Toy> arrayListP = this.a.P();
        ArrayList<String> arrayList = new ArrayList();
        if (arrayListP.size() > 0) {
            Iterator<Toy> it = arrayListP.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getDeviceId());
            }
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.p = extras.getInt("waitingCount");
            this.q = extras.getInt("activeCount");
            this.d = extras.getStringArrayList("activeToyList");
            this.e = extras.getStringArrayList("waitingToyList");
            ArrayList<String> arrayList2 = this.d;
            if (arrayList2 != null && arrayList2.size() > 0) {
                for (String str : arrayList) {
                    if (!this.d.contains(str) && this.c.size() < 2 && (toyR3 = this.a.R(str)) != null) {
                        this.c.add(toyR3);
                    }
                }
            }
            ArrayList<String> arrayList3 = this.e;
            if (arrayList3 != null && arrayList3.size() > 0) {
                for (String str2 : arrayList) {
                    if (!this.e.contains(str2) && this.c.size() < 2 && (toyR2 = this.a.R(str2)) != null) {
                        this.c.add(toyR2);
                    }
                }
            }
            ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO longTimeControlLinkListDTO = (ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO) extras.getSerializable(t);
            if (longTimeControlLinkListDTO != null) {
                List<ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ToysDTO> toys = longTimeControlLinkListDTO.getToys();
                if (this.p == 0 && this.q == 0 && toys != null && toys.size() > 0 && arrayList.size() > 0) {
                    for (ControlLinkListResponse.DataDTO.LongTimeControlLinkListDTO.ToysDTO toysDTO : toys) {
                        if (arrayList.contains(toysDTO.getToyId()) && (toyR = this.a.R(toysDTO.getToyId())) != null) {
                            this.c.add(toyR);
                        }
                    }
                }
                List<String> hashTags = longTimeControlLinkListDTO.getHashTags();
                if (hashTags != null && hashTags.size() > 0) {
                    Iterator<String> it2 = hashTags.iterator();
                    while (it2.hasNext()) {
                        this.i.add(it2.next());
                    }
                }
                if (longTimeControlLinkListDTO.isEdit) {
                    this.o = true;
                    this.b = longTimeControlLinkListDTO.getLongTimeControlLinkId();
                    this.actionBar.setTitle(ah4.e(R.string.button_edit_control_link));
                }
                this.h = longTimeControlLinkListDTO.getDescription();
                this.m = longTimeControlLinkListDTO.getDuration();
                this.f = longTimeControlLinkListDTO.getRepeat().booleanValue();
                this.schSendToTheOther.setChecked(longTimeControlLinkListDTO.isAllowReqToJoiner());
                this.schReceiveFromTheOther.setChecked(longTimeControlLinkListDTO.isAllowReqToCreator());
                this.mSwiSharePublic.setChecked(longTimeControlLinkListDTO.isShareTophy());
                this.controlLinkPermission.setChecked(longTimeControlLinkListDTO.isOpenControlPermission());
            }
        }
    }

    public final SpannableString M4() {
        String strE = ah4.e(R.string.download_link_tophy);
        String str = String.format(ah4.e(R.string.control_link_share_publicly_des4), strE);
        int iIndexOf = str.indexOf(strE);
        if (iIndexOf == -1) {
            return new SpannableString(str);
        }
        int length = strE.length() + iIndexOf;
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new b(), iIndexOf, length, 17);
        return spannableString;
    }

    public final void N4() {
        ArrayList<Toy> arrayListP;
        String strE = ah4.e(R.string.choose_toys_title);
        StringBuilder sb = new StringBuilder();
        synchronized (new Object()) {
            List<Toy> list = this.c;
            if (list != null && list.size() != 0) {
                List<Toy> list2 = this.c;
                if (list2 != null && list2.size() > 0) {
                    ArrayList<Toy> arrayListO = this.a.o();
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < this.c.size(); i2++) {
                        if (arrayListO.contains(this.c.get(i2))) {
                            if (this.c.get(i2).isF01Toy()) {
                                sb.append(this.c.get(i2).getToyUINameSpecialForMiniXMachine(1));
                                sb.append(", ");
                            } else {
                                sb.append(this.c.get(i2).getSimpleFullName());
                                sb.append(", ");
                            }
                            arrayList.add(this.c.get(i2));
                        }
                    }
                    this.c.clear();
                    this.c.addAll(arrayList);
                    if (sb.length() > 0) {
                        strE = sb.substring(0, sb.length() - 2).toString();
                    }
                }
            } else if (this.p == 0 && this.q == 0 && (arrayListP = this.a.P()) != null && arrayListP.size() > 0) {
                for (int i3 = 0; i3 < arrayListP.size() && i3 < 2; i3++) {
                    if (arrayListP.get(i3).isF01Toy()) {
                        sb.append(arrayListP.get(i3).getToyUINameSpecialForMiniXMachine(1));
                        sb.append(", ");
                    } else {
                        sb.append(arrayListP.get(i3).getSimpleFullName());
                        sb.append(", ");
                    }
                    this.c.add(arrayListP.get(i3));
                }
                strE = sb.substring(0, sb.length() - 2).toString();
            }
        }
        this.toyNames.setText(strE);
        long[] jArrK = be3.K(this.m);
        int i4 = (int) jArrK[0];
        this.j = i4;
        int i5 = (int) jArrK[1];
        this.k = i5;
        int i6 = (int) jArrK[2];
        this.l = i6;
        String strZ = be3.z(i4, i5, i6);
        this.n = strZ;
        this.durationTime.setText(strZ);
        if (this.i.size() != 0) {
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> it = this.i.iterator();
            while (it.hasNext()) {
                sb2.append(it.next());
                sb2.append(",");
            }
            this.tags.setText(sb2.substring(0, sb2.length() - 1));
        }
        this.switchButton.setChecked(this.f);
        this.description.setText(this.h);
        this.description.setVisibility(TextUtils.isEmpty(this.h) ? 8 : 0);
    }

    public final void O4() {
        this.actionBar.setToysAction(new c(), true, this);
        this.actionBar.n();
        this.actionBar.setBackAction(new d());
        this.toysLinear.setOnClickListener(new e());
        this.descriptionLinear.setOnClickListener(new f());
        this.durationLinear.setOnClickListener(new g());
        this.switchButton.setOnCheckedChangeListener(new h());
        this.mSwiSharePublic.setOnCheckedChangeListener(new i());
        this.save.setOnClickListener(new j());
        this.mTvShareDescription.setText(M4());
        this.mTvShareDescription.setHighlightColor(th4.b(this, R.color.transparent));
        this.mTvShareDescription.setMovementMethod(LinkMovementMethod.getInstance());
        this.tvPermissionRed.setVisibility(d83.w().K(this) ? 0 : 8);
        eg3.i(this, "key_first_into_create_contril_link", Boolean.FALSE);
    }

    public void P4(String str) {
        ArrayList arrayList = new ArrayList();
        if (this.switchButton.isChecked()) {
            arrayList.add("unlimited-1");
        } else {
            arrayList.add("unlimited-0");
        }
        if (this.mSwiSharePublic.isChecked()) {
            arrayList.add("share publicly-1");
        } else {
            arrayList.add("share publicly-0");
        }
        if (this.schSendToTheOther.isChecked()) {
            arrayList.add("send to the other-1");
        } else {
            arrayList.add("send to the other-0");
        }
        if (this.schReceiveFromTheOther.isChecked()) {
            arrayList.add("receive from the other-1");
        } else {
            arrayList.add("receive from the other-0");
        }
        if (this.controlLinkPermission.isChecked()) {
            arrayList.add("control permission-1");
        } else {
            arrayList.add("control permission-0");
        }
        HashMap map = new HashMap();
        map.put("page_name", "create control link");
        map.put("event_id", "create_control_link_save_click");
        map.put("event_type", "click");
        map.put("element_id", "create_control_link_save");
        map.put("element_type", "button");
        map.put("element_content", arrayList);
        map.put("element_name", str);
        map.put("toys", WearUtils.x.G().m());
        ye3.e("S0009", map);
    }

    public final void Q4() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.h)) {
            sb.append(this.h);
            sb.append(" ");
        }
        if (this.c.size() > 1) {
            sb.append("[");
            sb.append(this.c.get(0).getToyUINameSpecialForMiniXMachine(1));
            sb.append(", ");
            sb.append(this.c.get(1).getToyUINameSpecialForMiniXMachine(1));
            sb.append("] ");
        } else {
            sb.append("[");
            sb.append(this.c.get(0).getToyUINameSpecialForMiniXMachine(1));
            sb.append("] ");
        }
        List<String> list = this.i;
        if (list != null && list.size() > 0) {
            for (String str : this.i) {
                sb.append("[");
                sb.append(str);
                sb.append("]");
            }
        }
        long[] jArrK = be3.K(this.m);
        int i2 = (int) jArrK[0];
        this.j = i2;
        int i3 = (int) jArrK[1];
        this.k = i3;
        int i4 = (int) jArrK[2];
        this.l = i4;
        String strZ = be3.z(i2, i3, i4);
        this.n = strZ;
        this.durationTime.setText(strZ);
        sb.append(" [");
        sb.append(this.n);
        sb.append("] ");
        ArrayList arrayList = new ArrayList();
        for (Toy toy : this.c) {
            SaveControlLinkRequest.ToysDTO toysDTO = new SaveControlLinkRequest.ToysDTO();
            toysDTO.setToyId(toy.getDeviceId());
            toysDTO.setToyType(toy.getType());
            toysDTO.setToyName(toy.getShowName());
            toysDTO.setToyVersion(toy.getGenerationVersion());
            toysDTO.setSymbol(toy.getToyConfigDataBean().getSymbol().get(0));
            arrayList.add(toysDTO);
        }
        SaveControlLinkRequest saveControlLinkRequest = new SaveControlLinkRequest();
        saveControlLinkRequest.setId(this.b);
        saveControlLinkRequest.setHashTags(this.i);
        saveControlLinkRequest.setDescription(this.h);
        saveControlLinkRequest.setDuration(Integer.valueOf(this.m));
        saveControlLinkRequest.setRepeat(Boolean.valueOf(this.f));
        saveControlLinkRequest.setToys(arrayList);
        saveControlLinkRequest.setShareTophy(this.g);
        saveControlLinkRequest.setAllowReqToCreator(this.schReceiveFromTheOther.isChecked());
        saveControlLinkRequest.setAllowReqToJoiner(this.schSendToTheOther.isChecked());
        saveControlLinkRequest.setOpenControlPermission(this.controlLinkPermission.isChecked());
        tn2.x(this.application).h("/app/long_time_control_link/save", WearUtils.A.toJson(saveControlLinkRequest), new k(sb, be3.i(be3.a, new Date(System.currentTimeMillis()))));
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == ControlLinkDescriptionActivity.d) {
            ControlLinkDescriptionEvent controlLinkDescriptionEvent = (ControlLinkDescriptionEvent) WearUtils.A.fromJson(intent.getStringExtra(ControlLinkDescriptionEvent.tag), ControlLinkDescriptionEvent.class);
            if (controlLinkDescriptionEvent != null) {
                if (controlLinkDescriptionEvent.getSelectedTags() != null) {
                    this.i = controlLinkDescriptionEvent.getSelectedTags();
                } else {
                    this.i.clear();
                }
                if (this.i.size() != 0) {
                    StringBuilder sb = new StringBuilder();
                    Iterator<String> it = this.i.iterator();
                    while (it.hasNext()) {
                        sb.append(it.next());
                        sb.append(",");
                    }
                    this.tags.setText(sb.substring(0, sb.length() - 1));
                } else {
                    this.tags.setText("");
                }
                String content = controlLinkDescriptionEvent.getContent();
                this.h = content;
                this.description.setText(content);
                this.description.setVisibility(TextUtils.isEmpty(this.h) ? 8 : 0);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        String stringExtra;
        super.onBackPressed();
        if (getIntent() != null && (stringExtra = getIntent().getStringExtra("isHome")) != null && TextUtils.equals(stringExtra, "home")) {
            pj3.f(this, ControlLinkNewActivity.class);
        }
        finish();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_create_control_link);
        ButterKnife.bind(this);
        this.a = this.application.G();
        O4();
        L4();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.actionBar.s();
    }

    @Override // com.wear.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.actionBar.setToy(pc1.a.P());
        N4();
    }
}

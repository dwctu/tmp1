package com.wear.main.account;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import butterknife.OnClick;
import com.google.gson.Gson;
import com.lovense.wear.R;
import com.wear.BaseActivity;
import com.wear.bean.PolicyListBean;
import com.wear.network.protocol.exception.NetException;
import com.wear.util.WearUtils;
import dc.ah4;
import dc.eg3;
import dc.lg3;
import dc.pj3;
import dc.tn2;
import dc.vl2;
import dc.wg3;
import dc.zn2;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.sasl.packet.SaslStreamElements;

/* compiled from: NewWarmPromptActivity.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/wear/main/account/NewWarmPromptActivity;", "Lcom/wear/BaseActivity;", "Lcom/wear/network/presenter/base/PresenterLife;", "Landroid/view/View$OnClickListener;", "()V", "listBeans", "", "", "getListBeans", "()Ljava/util/List;", "setListBeans", "(Ljava/util/List;)V", "tvAgree", "Landroid/widget/TextView;", "tvDisagree", "tvTip", "onBackPressed", "", "onClick", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class NewWarmPromptActivity extends BaseActivity<vl2> implements View.OnClickListener {
    public TextView a;
    public TextView b;
    public TextView c;

    @Nullable
    public List<String> d = new ArrayList();

    /* compiled from: NewWarmPromptActivity.kt */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, d2 = {"com/wear/main/account/NewWarmPromptActivity$onClick$2", "Lcom/wear/network/protocol/callback/ResponseSimpleCallBack;", "", "onError", "", "e", "Lcom/wear/network/protocol/exception/NetException;", "onSuccess", SaslStreamElements.Response.ELEMENT, "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements zn2<String> {
        @Override // dc.zn2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable String str) {
        }

        @Override // dc.zn2
        public void onError(@NotNull NetException e) {
            Intrinsics.checkNotNullParameter(e, "e");
        }
    }

    /* compiled from: NewWarmPromptActivity.kt */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/wear/main/account/NewWarmPromptActivity$onCreate$1$provacyClickableSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends ClickableSpan {
        public final /* synthetic */ List<String> a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ NewWarmPromptActivity d;

        public b(List<String> list, int i, String str, NewWarmPromptActivity newWarmPromptActivity) {
            this.a = list;
            this.b = i;
            this.c = str;
            this.d = newWarmPromptActivity;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            String str = this.a.get(this.b) + "?pf=" + wg3.a() + "&lang=" + this.c;
            String str2 = "协议URL====" + str;
            pj3.w(this.d, str);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            super.updateDrawState(ds);
            ds.setColor(this.d.getResources().getColor(R.color.color_accent));
            ds.setUnderlineText(true);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.view.View.OnClickListener
    @OnClick({R.id.tv_agree, R.id.tv_disagree})
    public void onClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        if (id != R.id.tv_agree) {
            if (id != R.id.tv_disagree) {
                return;
            }
            this.application.E();
            return;
        }
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder();
        List<String> list = this.d;
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
        }
        sb.replace(sb.length() - 1, sb.length(), "");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "stringBuilder.toString()");
        map.put("policyType", string);
        tn2.x(WearUtils.x).t("/api/remote/policy/accept", map, new a());
        setResult(11111, new Intent());
        finish();
    }

    @Override // com.wear.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        String str;
        TextView textView;
        int i;
        int i2;
        int iIndexOf$default;
        List<PolicyListBean.DataDTO> data;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warm_prompt);
        View viewFindViewById = findViewById(R.id.tv_tip);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(R.id.tv_tip)");
        this.a = (TextView) viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.tv_agree);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(R.id.tv_agree)");
        this.b = (TextView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R.id.tv_disagree);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(R.id.tv_disagree)");
        this.c = (TextView) viewFindViewById3;
        TextView textView2 = this.b;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvAgree");
            textView2 = null;
        }
        textView2.setOnClickListener(this);
        TextView textView3 = this.c;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDisagree");
            textView3 = null;
        }
        textView3.setOnClickListener(this);
        Serializable serializableExtra = getIntent().getSerializableExtra("listBeans");
        this.d = serializableExtra instanceof List ? (List) serializableExtra : null;
        HashMap map = new HashMap();
        List<String> list = this.d;
        if (list != null) {
            for (String str2 : list) {
                int iHashCode = str2.hashCode();
                if (iHashCode != 299096142) {
                    if (iHashCode != 777657487) {
                        if (iHashCode == 1407694730 && str2.equals("remote_end_user_license")) {
                            map.put("remote_end_user_license", ah4.e(R.string.wokin_eula));
                        }
                    } else if (str2.equals("remote_privacy")) {
                        map.put("remote_privacy", ah4.e(R.string.privacy_policy1));
                    }
                } else if (str2.equals("remote_terms")) {
                    map.put("remote_terms", ah4.e(R.string.terms_and_conditions1));
                }
            }
            int size = list.size();
            if (size == 1) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String strE = ah4.e(R.string.new_terms_notification1);
                Intrinsics.checkNotNullExpressionValue(strE, "getString(R.string.new_terms_notification1)");
                str = String.format(strE, Arrays.copyOf(new Object[]{map.get(list.get(0))}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            } else if (size != 2) {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String strE2 = ah4.e(R.string.new_terms_notification3);
                Intrinsics.checkNotNullExpressionValue(strE2, "getString(R.string.new_terms_notification3)");
                str = String.format(strE2, Arrays.copyOf(new Object[]{map.get(list.get(0)), map.get(list.get(1)), map.get(list.get(2))}, 3));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            } else {
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                String strE3 = ah4.e(R.string.new_terms_notification2);
                Intrinsics.checkNotNullExpressionValue(strE3, "getString(R.string.new_terms_notification2)");
                str = String.format(strE3, Arrays.copyOf(new Object[]{map.get(list.get(0)), map.get(list.get(1))}, 2));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            }
            ArrayList arrayList = new ArrayList();
            PolicyListBean policyListBean = (PolicyListBean) new Gson().fromJson(eg3.h(this, "new_argement_list", ""), PolicyListBean.class);
            if (policyListBean != null && (data = policyListBean.getData()) != null) {
                Intrinsics.checkNotNullExpressionValue(data, "data");
                int size2 = data.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String str3 = "协议Type====" + policyListBean.getData().get(i3).getPolicyType();
                    if (map.get(policyListBean.getData().get(i3).getPolicyType()) != null) {
                        String url = policyListBean.getData().get(i3).getUrl();
                        Intrinsics.checkNotNullExpressionValue(url, "dataDTO.data[i].url");
                        arrayList.add(url);
                    }
                }
            }
            String strC = lg3.c(lg3.e(this));
            SpannableString spannableString = new SpannableString(str);
            int size3 = list.size();
            int i4 = 0;
            while (i4 < size3) {
                String str4 = (String) map.get(list.get(i4));
                if (str4 != null) {
                    i2 = -1;
                    i = i4;
                    iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, str4, 0, false, 6, (Object) null);
                } else {
                    i = i4;
                    i2 = -1;
                    iIndexOf$default = -1;
                }
                if (iIndexOf$default != i2) {
                    b bVar = new b(arrayList, i, strC, this);
                    String str5 = (String) map.get(list.get(i));
                    spannableString.setSpan(bVar, iIndexOf$default, (str5 != null ? str5.length() : 0) + iIndexOf$default, 17);
                }
                i4 = i + 1;
            }
            TextView textView4 = this.a;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTip");
                textView4 = null;
            }
            textView4.setMovementMethod(LinkMovementMethod.getInstance());
            TextView textView5 = this.a;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvTip");
                textView = null;
            } else {
                textView = textView5;
            }
            textView.setText(spannableString);
        }
    }
}

package dc;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.adapter.VMShareUserAdapter;
import com.wear.bean.VMShareDataBean;
import com.wear.bean.handlerbean.IPeopleInfo;
import com.wear.widget.recycler.RecyclerViewItemDecoration;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VMShareDialog.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u000fH\u0003J\u0006\u0010\u0011\u001a\u00020\u000fJ\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/wear/ui/discover/dialog/VMShareDialog;", "Landroid/app/Dialog;", ActivityChooserModel.ATTRIBUTE_ACTIVITY, "Landroidx/appcompat/app/AppCompatActivity;", "user", "", "Lcom/wear/bean/handlerbean/IPeopleInfo;", "vmShareDataBean", "Lcom/wear/bean/VMShareDataBean;", "bottomClickListener", "Lcom/wear/ui/discover/dialog/VMShareDialog$ClickListener;", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/util/List;Lcom/wear/bean/VMShareDataBean;Lcom/wear/ui/discover/dialog/VMShareDialog$ClickListener;)V", "getView", "Landroid/view/View;", "hideKeyboard", "", "initData", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "ClickListener", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class pw2 extends Dialog {

    @NotNull
    public final AppCompatActivity a;

    @Nullable
    public final List<IPeopleInfo> b;

    @Nullable
    public final VMShareDataBean c;

    @Nullable
    public final a d;

    /* compiled from: VMShareDialog.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/wear/ui/discover/dialog/VMShareDialog$ClickListener;", "", "doConfirm", "", "command", "", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a(@Nullable String str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pw2(@NotNull AppCompatActivity activity, @Nullable List<IPeopleInfo> list, @Nullable VMShareDataBean vMShareDataBean, @Nullable a aVar) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.a = activity;
        this.b = list;
        this.c = vMShareDataBean;
        this.d = aVar;
    }

    public static final void d(pw2 this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b();
        this$0.dismiss();
    }

    public static final void e(pw2 this$0, EditText editText, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b();
        a aVar = this$0.d;
        if (aVar != null) {
            aVar.a(editText.getText().toString());
        }
        this$0.dismiss();
    }

    @NotNull
    public final View a() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.dialog_vm_share, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "from(context).inflate(R.…ut.dialog_vm_share, null)");
        return viewInflate;
    }

    public final void b() {
        View decorView;
        Object systemService = getContext().getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        Window window = getWindow();
        inputMethodManager.hideSoftInputFromWindow((window == null || (decorView = window.getDecorView()) == null) ? null : decorView.getWindowToken(), 0);
    }

    @SuppressLint({"ClickableViewAccessibility", "SetTextI18n"})
    public final void c() {
        TextView textView = (TextView) findViewById(R.id.tv_dismiss);
        TextView textView2 = (TextView) findViewById(R.id.tv_send);
        TextView textView3 = (TextView) findViewById(R.id.tv_content);
        final EditText editText = (EditText) findViewById(R.id.et_comment);
        TextView textView4 = (TextView) findViewById(R.id.tv_title);
        StringBuilder sb = new StringBuilder();
        sb.append(ah4.e(R.string.send_to));
        sb.append(" (");
        List<IPeopleInfo> list = this.b;
        sb.append(list != null ? Integer.valueOf(list.size()) : null);
        sb.append(')');
        textView4.setText(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        sb2.append(ah4.e(R.string.type_link));
        sb2.append("] ");
        VMShareDataBean vMShareDataBean = this.c;
        sb2.append(vMShareDataBean != null ? vMShareDataBean.getDesc() : null);
        textView3.setText(sb2.toString());
        textView.setOnClickListener(new View.OnClickListener() { // from class: dc.ow2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                pw2.d(this.a, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: dc.nw2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                pw2.e(this.a, editText, view);
            }
        });
    }

    public final void f() {
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(android.R.color.transparent);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 17;
            attributes.height = -2;
            attributes.width = -2;
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.CommandDialogAnimation);
        }
        VMShareUserAdapter vMShareUserAdapter = new VMShareUserAdapter();
        vMShareUserAdapter.y0(this.b);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_share);
        recyclerView.setAdapter(vMShareUserAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a);
        linearLayoutManager.setOrientation(0);
        recyclerView.addItemDecoration(new RecyclerViewItemDecoration(24));
        recyclerView.setLayoutManager(linearLayoutManager);
        vMShareUserAdapter.notifyDataSetChanged();
    }

    @Override // android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(a());
        f();
        c();
    }
}

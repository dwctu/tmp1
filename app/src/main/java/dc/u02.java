package dc;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.util.WearUtils;

/* compiled from: PatternPlayButtomDialog.java */
/* loaded from: classes3.dex */
public class u02 extends Dialog {
    public RecyclerView.Adapter a;

    public u02(@NonNull Context context, int i) {
        super(context, i);
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b(View view) {
        dismiss();
    }

    public void c(RecyclerView.Adapter adapter) {
        this.a = adapter;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.pattern_play_dialog_layout, (ViewGroup) null);
        setContentView(viewInflate);
        WearUtils.q2(this);
        getWindow().setGravity(80);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        getWindow().setAttributes(attributes);
        setCancelable(true);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: dc.q02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.b(view);
            }
        });
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.recycler_view);
        RecyclerView.Adapter adapter = this.a;
        if (adapter != null) {
            recyclerView.setAdapter(adapter);
        }
    }
}

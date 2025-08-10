package com.wear.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.adapter.PictureUsedDialogAdapter;
import com.wear.bean.PictureUsedBean;
import dc.ce3;
import java.util.ArrayList;
import java.util.LinkedList;

/* loaded from: classes4.dex */
public class PictureUsedDialog extends BottomDialog implements View.OnClickListener {
    public b c;
    public boolean d;
    public boolean e;
    public TextView f;
    public RecyclerView g;
    public LinearLayoutManager h;
    public PictureUsedDialogAdapter i;
    public boolean j;

    public class a implements PictureUsedDialogAdapter.b {
        public a() {
        }

        @Override // com.wear.adapter.PictureUsedDialogAdapter.b
        public void a(int i) {
            PictureUsedDialog.this.c.a(i);
        }
    }

    public interface b {
        void a(int i);
    }

    public PictureUsedDialog(Context context, Boolean bool, Boolean bool2, Boolean bool3, b bVar) {
        super(context);
        this.d = false;
        this.e = false;
        this.c = bVar;
        this.d = bool.booleanValue();
        this.e = bool2.booleanValue();
        this.j = bool3.booleanValue();
    }

    @Override // com.wear.widget.BottomDialog
    public View b() {
        return LayoutInflater.from(getContext()).inflate(R.layout.chat_picture_bottom_dialog, (ViewGroup) null);
    }

    @Override // com.wear.widget.BottomDialog
    public void c(View view) {
        this.g = (RecyclerView) view.findViewById(R.id.recyclerView);
        ArrayList arrayList = new ArrayList();
        int[] iArr = {R.string.comman_forward, R.string.common_save, R.string.common_delete, R.string.comman_hide, R.string.comman_recall, R.string.qrcode_menu};
        int[] iArr2 = {R.drawable.light_share_linear, R.drawable.light_save_linear, R.drawable.light_delete_linear, R.drawable.light_hide_linear, R.drawable.chat_function_recall, R.drawable.light_code_linear};
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        for (int i = 0; i < 6; i++) {
            linkedList.add(i, Integer.valueOf(iArr[i]));
            linkedList2.add(i, Integer.valueOf(iArr2[i]));
        }
        if (!this.d) {
            linkedList.remove(5);
            linkedList2.remove(5);
        }
        if (!this.e) {
            linkedList.remove(4);
            linkedList2.remove(4);
        }
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            PictureUsedBean pictureUsedBean = new PictureUsedBean();
            pictureUsedBean.setUsedName(((Integer) linkedList.get(i2)).intValue());
            pictureUsedBean.setUserImg(((Integer) linkedList2.get(i2)).intValue());
            if (i2 == 3) {
                pictureUsedBean.setHidden(this.j);
            }
            arrayList.add(pictureUsedBean);
        }
        this.i = new PictureUsedDialogAdapter(this.b, arrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.b);
        this.h = linearLayoutManager;
        linearLayoutManager.setOrientation(0);
        this.g.setLayoutManager(this.h);
        this.g.setAdapter(this.i);
        this.g.addItemDecoration(new com.library.flowlayout.SpaceItemDecoration(ce3.a(this.b, 16.0f)));
        TextView textView = (TextView) view.findViewById(R.id.cancel_tv);
        this.f = textView;
        textView.setOnClickListener(this);
        this.i.m(new a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.cancel_tv) {
            return;
        }
        this.c.a(7);
    }
}

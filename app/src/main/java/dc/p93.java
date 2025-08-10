package dc;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.lovense.wear.R;
import com.wear.ui.longDistance.imagepicker.adapter.ImageFoldersAdapter;
import java.util.List;

/* compiled from: ImageFolderPopupWindow.java */
/* loaded from: classes4.dex */
public class p93 extends PopupWindow {
    public Context a;
    public List<y83> b;
    public RecyclerView c;
    public ImageFoldersAdapter d;

    /* compiled from: ImageFolderPopupWindow.java */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 4) {
                return false;
            }
            p93.this.dismiss();
            return false;
        }
    }

    public p93(Context context, List<y83> list) {
        this.a = context;
        this.b = list;
        c();
    }

    public ImageFoldersAdapter a() {
        return this.d;
    }

    public final void b(View view) {
        setContentView(view);
        setWidth(o93.a(this.a)[0]);
        setHeight((int) (r6[1] * 0.62d));
        setBackgroundDrawable(new ColorDrawable());
        setOutsideTouchable(true);
        setFocusable(true);
        setTouchInterceptor(new a());
    }

    public final void c() {
        View viewInflate = LayoutInflater.from(this.a).inflate(R.layout.imagepicker_window_image_folders, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.rv_main_imageFolders);
        this.c = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.a));
        ImageFoldersAdapter imageFoldersAdapter = new ImageFoldersAdapter(this.a, this.b, 0);
        this.d = imageFoldersAdapter;
        this.c.setAdapter(imageFoldersAdapter);
        b(viewInflate);
    }
}

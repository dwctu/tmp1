package dc;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.wear.widget.RecyclerViewNoBugLinearLayoutManager;

/* compiled from: RvHelper.java */
/* loaded from: classes4.dex */
public class cg3 {

    /* compiled from: RvHelper.java */
    public class a extends GridLayoutManager {
        public a(Context context, int i) {
            super(context, i);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    /* compiled from: RvHelper.java */
    public class b extends GridLayoutManager {
        public b(Context context, int i, int i2, boolean z) {
            super(context, i, i2, z);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollVertically() {
            return false;
        }
    }

    public static GridLayoutManager a(RecyclerView recyclerView, RecyclerView.Adapter adapter, int i) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), i);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        return gridLayoutManager;
    }

    public static GridLayoutManager b(RecyclerView recyclerView, RecyclerView.Adapter adapter, int i) {
        a aVar = new a(recyclerView.getContext(), i);
        recyclerView.setLayoutManager(aVar);
        recyclerView.setAdapter(adapter);
        return aVar;
    }

    public static GridLayoutManager c(RecyclerView recyclerView, RecyclerView.Adapter adapter, int i) {
        b bVar = new b(recyclerView.getContext(), i, 1, true);
        recyclerView.setLayoutManager(bVar);
        recyclerView.setAdapter(adapter);
        return bVar;
    }

    public static LinearLayoutManager d(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), 0, false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        return linearLayoutManager;
    }

    public static LinearLayoutManager e(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        RecyclerViewNoBugLinearLayoutManager recyclerViewNoBugLinearLayoutManager = new RecyclerViewNoBugLinearLayoutManager(recyclerView.getContext(), 1, true);
        recyclerViewNoBugLinearLayoutManager.setStackFromEnd(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(recyclerViewNoBugLinearLayoutManager);
        return recyclerViewNoBugLinearLayoutManager;
    }

    public static LinearLayoutManager f(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        RecyclerViewNoBugLinearLayoutManager recyclerViewNoBugLinearLayoutManager = new RecyclerViewNoBugLinearLayoutManager(recyclerView.getContext(), 1, false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(recyclerViewNoBugLinearLayoutManager);
        return recyclerViewNoBugLinearLayoutManager;
    }
}

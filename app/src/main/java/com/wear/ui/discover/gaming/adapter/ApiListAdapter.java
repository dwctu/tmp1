package com.wear.ui.discover.gaming.adapter;

import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.lovense.wear.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ApiListAdapter.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014R&\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/wear/ui/discover/gaming/adapter/ApiListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "()V", "iconApi", "", "", "convert", "", "holder", "item", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ApiListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    @NotNull
    public final Map<String, Map<String, Integer>> z;

    /* compiled from: ApiListAdapter.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u000026\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00030\u0001j\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003`\u0005¨\u0006\u0006"}, d2 = {"com/wear/ui/discover/gaming/adapter/ApiListAdapter$iconApi$1", "Ljava/util/HashMap;", "", "", "", "Lkotlin/collections/HashMap;", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends HashMap<String, Map<String, ? extends Integer>> {
        public a() {
            put("user_info", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("User info", Integer.valueOf(R.drawable.userinfo))));
            put("toy_info", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("Toy info", Integer.valueOf(R.drawable.toyinfo))));
        }

        public /* bridge */ boolean a(String str) {
            return super.containsKey(str);
        }

        public /* bridge */ boolean b(Map<String, Integer> map) {
            return super.containsValue(map);
        }

        public /* bridge */ Map<String, Integer> c(String str) {
            return (Map) super.get(str);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof String) {
                return a((String) obj);
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof Map) {
                return b((Map) obj);
            }
            return false;
        }

        public /* bridge */ Set<Map.Entry<String, Map<String, Integer>>> d() {
            return super.entrySet();
        }

        public /* bridge */ Set<String> e() {
            return super.keySet();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, Map<String, Integer>>> entrySet() {
            return d();
        }

        public /* bridge */ Map<String, Integer> f(String str, Map<String, Integer> map) {
            return (Map) super.getOrDefault(str, map);
        }

        public /* bridge */ int g() {
            return super.size();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof String) {
                return c((String) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof String) ? obj2 : f((String) obj, (Map) obj2);
        }

        public /* bridge */ Collection<Map<String, Integer>> h() {
            return super.values();
        }

        public /* bridge */ Map<String, Integer> i(String str) {
            return (Map) super.remove(str);
        }

        public /* bridge */ boolean k(String str, Map<String, Integer> map) {
            return super.remove(str, map);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return e();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof String) {
                return i((String) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return g();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<Map<String, Integer>> values() {
            return h();
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof String) && (obj2 instanceof Map)) {
                return k((String) obj, (Map) obj2);
            }
            return false;
        }
    }

    public ApiListAdapter() {
        super(R.layout.item_api, null, 2, null);
        this.z = new a();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public void C(@NotNull BaseViewHolder holder, @NotNull String item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Map<String, Integer> map = this.z.get(item);
        if (map != null) {
            holder.setText(R.id.tv_api, (CharSequence) ((Map.Entry) CollectionsKt___CollectionsKt.first(map.entrySet())).getKey());
            ((ImageView) holder.getView(R.id.iv_api)).setImageResource(((Number) ((Map.Entry) CollectionsKt___CollectionsKt.first(map.entrySet())).getValue()).intValue());
        }
    }
}

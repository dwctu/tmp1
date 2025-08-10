package com.wear.main.longDistance.adapter;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.wear.bean.IGroupMember;
import dc.j82;
import dc.k82;
import dc.l82;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ManagerGroupMemberAdapter.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0014¨\u0006\t"}, d2 = {"Lcom/wear/main/longDistance/adapter/ManagerGroupMemberAdapter;", "Lcom/chad/library/adapter/base/BaseProviderMultiAdapter;", "Lcom/wear/bean/IGroupMember;", "()V", "getItemType", "", "data", "", "position", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ManagerGroupMemberAdapter extends BaseProviderMultiAdapter<IGroupMember> {
    public ManagerGroupMemberAdapter() {
        super(null, 1, null);
        I0(new k82());
        I0(new j82());
        I0(new l82());
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int Q0(@NotNull List<? extends IGroupMember> data, int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        return data.get(i).getItemViewType();
    }
}

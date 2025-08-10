package com.wear.main.game.ui;

import androidx.lifecycle.MutableLiveData;
import com.wear.BaseViewModel;
import com.wear.bean.Toy;
import dc.h32;
import dc.pc1;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: NewGameVideModel.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010R&\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/wear/main/game/ui/NewGameVideModel;", "Lcom/wear/BaseViewModel;", "()V", "nowConnectToys", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/wear/bean/Toy;", "getNowConnectToys", "()Landroidx/lifecycle/MutableLiveData;", "setNowConnectToys", "(Landroidx/lifecycle/MutableLiveData;)V", "status", "", "getStatus", "setStatus", "getNowToyLists", "", "startAcceptControl", "stopAcceptControl", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class NewGameVideModel extends BaseViewModel {

    @NotNull
    public MutableLiveData<List<Toy>> a = new MutableLiveData<>();

    @NotNull
    public MutableLiveData<Boolean> b = new MutableLiveData<>();

    @NotNull
    public final MutableLiveData<List<Toy>> b() {
        return this.a;
    }

    public final void c() {
        this.a.postValue(pc1.a.P());
    }

    @NotNull
    public final MutableLiveData<Boolean> d() {
        return this.b;
    }

    public final void e() {
        h32.i().F(1);
        this.b.postValue(Boolean.TRUE);
    }

    public final void f() {
        h32.i().F(0);
        this.b.postValue(Boolean.FALSE);
    }
}

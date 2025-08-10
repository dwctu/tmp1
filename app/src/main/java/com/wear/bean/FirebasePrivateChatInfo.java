package com.wear.bean;

import android.text.TextUtils;
import com.wear.util.WearUtils;
import dc.ch3;
import dc.me3;
import dc.nd3;
import dc.pc1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FirebasePrivateChatInfo.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/wear/bean/FirebasePrivateChatInfo;", "", "friendJid", "", "friendToys", "", "Lcom/wear/bean/Toy;", "(Ljava/lang/String;Ljava/util/List;)V", "friendToyInfo", "Lcom/wear/bean/FirebaseUserToyInfo;", "myToyInfo", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class FirebasePrivateChatInfo {

    @NotNull
    private FirebaseUserToyInfo myToyInfo = new FirebaseUserToyInfo(null, null, 3, null);

    @NotNull
    private FirebaseUserToyInfo friendToyInfo = new FirebaseUserToyInfo(null, null, 3, null);

    public FirebasePrivateChatInfo(@Nullable String str, @Nullable List<? extends Toy> list) {
        if (ch3.n().u() != null) {
            this.myToyInfo.setEncryptJid(nd3.p(ch3.n().p()));
            this.myToyInfo.setToys(me3.b(pc1.a.o()));
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.friendToyInfo.setEncryptJid(nd3.p(str));
        this.friendToyInfo.setToys(me3.b(list));
    }

    @NotNull
    public String toString() {
        String json = WearUtils.A.toJson(this);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(this)");
        return json;
    }
}

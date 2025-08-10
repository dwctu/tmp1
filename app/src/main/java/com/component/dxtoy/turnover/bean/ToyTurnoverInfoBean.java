package com.component.dxtoy.turnover.bean;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import dc.bc0;
import dc.cc0;
import dc.dc0;
import dc.dy;
import dc.rz;
import dc.td0;
import dc.tz;
import dc.ve0;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smack.roster.packet.RosterVer;

/* compiled from: ToyTurnoverInfoBean.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u0014\u0010\u0012\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/component/dxtoy/turnover/bean/ToyTurnoverInfoBean;", "", "()V", "ac", "", "getAc", "()Ljava/lang/String;", "setAc", "(Ljava/lang/String;)V", "devid", "getDevid", "setDevid", "devmd5", "getDevmd5", "setDevmd5", TtmlNode.ATTR_ID, "getId", "setId", "pf", "getPf", "status", "getStatus", "setStatus", RosterVer.ELEMENT, "getVer", "setVer", "Companion", "turnover_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ToyTurnoverInfoBean {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private String ac;

    @Nullable
    private String devid;

    @Nullable
    private String devmd5;

    @Nullable
    private String id;

    @NotNull
    private final String pf = DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE;

    @Nullable
    private String status;

    @Nullable
    private String ver;

    /* compiled from: ToyTurnoverInfoBean.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/component/dxtoy/turnover/bean/ToyTurnoverInfoBean$Companion;", "", "()V", "build", "Lcom/component/dxtoy/turnover/bean/ToyTurnoverInfoBean;", "macId", "", "status", "Lcom/component/dxtoy/turnover/data/ToyTurnoverEum$ConnectState;", "turnover_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ToyTurnoverInfoBean build(@NotNull String macId, @NotNull cc0 status) {
            dy dyVarB;
            String strName;
            String lowerCase;
            Intrinsics.checkNotNullParameter(macId, "macId");
            Intrinsics.checkNotNullParameter(status, "status");
            ToyTurnoverInfoBean toyTurnoverInfoBean = new ToyTurnoverInfoBean();
            toyTurnoverInfoBean.setId(macId);
            toyTurnoverInfoBean.setStatus(status.getState());
            bc0 bc0Var = bc0.a;
            dc0 dc0VarB = bc0Var.b();
            if (dc0VarB == null || (dyVarB = dc0VarB.b()) == null || (strName = dyVarB.name()) == null) {
                lowerCase = null;
            } else {
                lowerCase = strName.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            }
            toyTurnoverInfoBean.setAc(lowerCase);
            dc0 dc0VarB2 = bc0Var.b();
            toyTurnoverInfoBean.setVer(dc0VarB2 != null ? dc0VarB2.a() : null);
            toyTurnoverInfoBean.setDevid(tz.a.c());
            toyTurnoverInfoBean.setDevmd5(td0.b(rz.b(ve0.a())));
            return toyTurnoverInfoBean;
        }
    }

    @Nullable
    public final String getAc() {
        return this.ac;
    }

    @Nullable
    public final String getDevid() {
        return this.devid;
    }

    @Nullable
    public final String getDevmd5() {
        return this.devmd5;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getPf() {
        return this.pf;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }

    @Nullable
    public final String getVer() {
        return this.ver;
    }

    public final void setAc(@Nullable String str) {
        this.ac = str;
    }

    public final void setDevid(@Nullable String str) {
        this.devid = str;
    }

    public final void setDevmd5(@Nullable String str) {
        this.devmd5 = str;
    }

    public final void setId(@Nullable String str) {
        this.id = str;
    }

    public final void setStatus(@Nullable String str) {
        this.status = str;
    }

    public final void setVer(@Nullable String str) {
        this.ver = str;
    }
}

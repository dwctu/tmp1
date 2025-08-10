package dc;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoiceControlExt.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003JH\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/wear/ui/discover/voicecontrol/VoiceControlCommand;", "", "isMultiply", "", "value", "", "functions", "", "", "commands", "(ZLjava/lang/Integer;Ljava/util/List;Ljava/util/List;)V", "getCommands", "()Ljava/util/List;", "getFunctions", "()Z", "getValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(ZLjava/lang/Integer;Ljava/util/List;Ljava/util/List;)Lcom/wear/ui/discover/voicecontrol/VoiceControlCommand;", "equals", "other", "hashCode", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: dc.a13, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class VoiceControlCommand {

    /* renamed from: a, reason: from toString */
    public final boolean isMultiply;

    /* renamed from: b, reason: from toString */
    @Nullable
    public final Integer value;

    /* renamed from: c, reason: from toString */
    @Nullable
    public final List<String> functions;

    /* renamed from: d, reason: from toString */
    @Nullable
    public final List<String> commands;

    public VoiceControlCommand(boolean z, @Nullable Integer num, @Nullable List<String> list, @Nullable List<String> list2) {
        this.isMultiply = z;
        this.value = num;
        this.functions = list;
        this.commands = list2;
    }

    @Nullable
    public final List<String> a() {
        return this.commands;
    }

    @Nullable
    public final List<String> b() {
        return this.functions;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final Integer getValue() {
        return this.value;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsMultiply() {
        return this.isMultiply;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceControlCommand)) {
            return false;
        }
        VoiceControlCommand voiceControlCommand = (VoiceControlCommand) other;
        return this.isMultiply == voiceControlCommand.isMultiply && Intrinsics.areEqual(this.value, voiceControlCommand.value) && Intrinsics.areEqual(this.functions, voiceControlCommand.functions) && Intrinsics.areEqual(this.commands, voiceControlCommand.commands);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z = this.isMultiply;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        Integer num = this.value;
        int iHashCode = (i + (num == null ? 0 : num.hashCode())) * 31;
        List<String> list = this.functions;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.commands;
        return iHashCode2 + (list2 != null ? list2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "VoiceControlCommand(isMultiply=" + this.isMultiply + ", value=" + this.value + ", functions=" + this.functions + ", commands=" + this.commands + ')';
    }

    public /* synthetic */ VoiceControlCommand(boolean z, Integer num, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : list, (i & 8) != 0 ? null : list2);
    }
}

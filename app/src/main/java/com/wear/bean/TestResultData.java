package com.wear.bean;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import dc.of1;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TestKtBean.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J>\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/wear/bean/TestResultData;", "", "command", "", TtmlNode.ATTR_ID, "showRank", "", "source", "Lcom/wear/bean/Source;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/wear/bean/Source;)V", "getCommand", "()Ljava/lang/String;", "getId", "getShowRank", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSource", "()Lcom/wear/bean/Source;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/wear/bean/Source;)Lcom/wear/bean/TestResultData;", "equals", "", "other", "hashCode", "", "toString", "app_marketRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@of1(generateAdapter = true)
/* loaded from: classes3.dex */
public final /* data */ class TestResultData {

    @Nullable
    private final String command;

    @Nullable
    private final String id;

    @Nullable
    private final Long showRank;

    @Nullable
    private final Source source;

    public TestResultData() {
        this(null, null, null, null, 15, null);
    }

    public TestResultData(@Nullable String str, @Nullable String str2, @Nullable Long l, @Nullable Source source) {
        this.command = str;
        this.id = str2;
        this.showRank = l;
        this.source = source;
    }

    public static /* synthetic */ TestResultData copy$default(TestResultData testResultData, String str, String str2, Long l, Source source, int i, Object obj) {
        if ((i & 1) != 0) {
            str = testResultData.command;
        }
        if ((i & 2) != 0) {
            str2 = testResultData.id;
        }
        if ((i & 4) != 0) {
            l = testResultData.showRank;
        }
        if ((i & 8) != 0) {
            source = testResultData.source;
        }
        return testResultData.copy(str, str2, l, source);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getCommand() {
        return this.command;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Long getShowRank() {
        return this.showRank;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Source getSource() {
        return this.source;
    }

    @NotNull
    public final TestResultData copy(@Nullable String command, @Nullable String id, @Nullable Long showRank, @Nullable Source source) {
        return new TestResultData(command, id, showRank, source);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TestResultData)) {
            return false;
        }
        TestResultData testResultData = (TestResultData) other;
        return Intrinsics.areEqual(this.command, testResultData.command) && Intrinsics.areEqual(this.id, testResultData.id) && Intrinsics.areEqual(this.showRank, testResultData.showRank) && Intrinsics.areEqual(this.source, testResultData.source);
    }

    @Nullable
    public final String getCommand() {
        return this.command;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final Long getShowRank() {
        return this.showRank;
    }

    @Nullable
    public final Source getSource() {
        return this.source;
    }

    public int hashCode() {
        String str = this.command;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.id;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.showRank;
        int iHashCode3 = (iHashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Source source = this.source;
        return iHashCode3 + (source != null ? source.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "TestResultData(command=" + this.command + ", id=" + this.id + ", showRank=" + this.showRank + ", source=" + this.source + ')';
    }

    public /* synthetic */ TestResultData(String str, String str2, Long l, Source source, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? 0L : l, (i & 8) != 0 ? null : source);
    }
}

package com.component.dxbilog.lib.bean;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import dc.cs;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jivesoftware.smackx.jiveproperties.packet.JivePropertiesExtension;

/* compiled from: BILogContentBean.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b>\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 Z2\u00020\u0001:\u0003Z[\\B¿\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0011\u0010N\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÈ\u0001\u0010R\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001¢\u0006\u0002\u0010SJ\u0013\u0010T\u001a\u00020U2\b\u0010V\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010W\u001a\u00020XHÖ\u0001J\t\u0010Y\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0019\"\u0004\b\"\u0010\u001bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0019\"\u0004\b(\u0010\u001bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010\u001bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0019\"\u0004\b,\u0010\u001bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0019\"\u0004\b.\u0010\u001bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0019\"\u0004\b6\u0010\u001bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0019\"\u0004\b8\u0010\u001bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0019\"\u0004\b>\u0010\u001bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006]"}, d2 = {"Lcom/component/dxbilog/lib/bean/BILogContentBean;", "Lcom/component/dxbilog/lib/listener/IBILogContentBean;", "page_name", "", "referrer", "page_type", "control_type", TypedValues.TransitionType.S_DURATION, "", "toys", "", "event_id", "event_type", "element_id", "element_type", "element_content", "element_name", "element_data_json", "", JivePropertiesExtension.ELEMENT, "Lcom/component/dxbilog/lib/bean/BILogContentBean$Properties;", "internals", "Lcom/component/dxbilog/lib/bean/BILogContentBean$Internals;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Lcom/component/dxbilog/lib/bean/BILogContentBean$Properties;Lcom/component/dxbilog/lib/bean/BILogContentBean$Internals;)V", "getControl_type", "()Ljava/lang/String;", "setControl_type", "(Ljava/lang/String;)V", "getDuration", "()Ljava/lang/Double;", "setDuration", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getElement_content", "setElement_content", "getElement_data_json", "()Ljava/lang/Object;", "setElement_data_json", "(Ljava/lang/Object;)V", "getElement_id", "setElement_id", "getElement_name", "setElement_name", "getElement_type", "setElement_type", "getEvent_id", "setEvent_id", "getEvent_type", "setEvent_type", "getInternals", "()Lcom/component/dxbilog/lib/bean/BILogContentBean$Internals;", "setInternals", "(Lcom/component/dxbilog/lib/bean/BILogContentBean$Internals;)V", "getPage_name", "setPage_name", "getPage_type", "setPage_type", "getProperties", "()Lcom/component/dxbilog/lib/bean/BILogContentBean$Properties;", "setProperties", "(Lcom/component/dxbilog/lib/bean/BILogContentBean$Properties;)V", "getReferrer", "setReferrer", "getToys", "()Ljava/util/List;", "setToys", "(Ljava/util/List;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Lcom/component/dxbilog/lib/bean/BILogContentBean$Properties;Lcom/component/dxbilog/lib/bean/BILogContentBean$Internals;)Lcom/component/dxbilog/lib/bean/BILogContentBean;", "equals", "", "other", "hashCode", "", "toString", "Companion", "Internals", "Properties", "dxRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class BILogContentBean implements cs {
    public static final int CONTENT_MAX_LENGTH = 128;

    @Nullable
    private String control_type;

    @Nullable
    private Double duration;

    @Nullable
    private String element_content;

    @Nullable
    private Object element_data_json;

    @Nullable
    private String element_id;

    @Nullable
    private String element_name;

    @Nullable
    private String element_type;

    @Nullable
    private String event_id;

    @Nullable
    private String event_type;

    @Nullable
    private Internals internals;

    @Nullable
    private String page_name;

    @Nullable
    private String page_type;

    @Nullable
    private Properties properties;

    @Nullable
    private String referrer;

    @Nullable
    private List<String> toys;

    public BILogContentBean() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    public BILogContentBean(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Double d, @Nullable List<String> list, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable Object obj, @Nullable Properties properties, @Nullable Internals internals) {
        this.page_name = str;
        this.referrer = str2;
        this.page_type = str3;
        this.control_type = str4;
        this.duration = d;
        this.toys = list;
        this.event_id = str5;
        this.event_type = str6;
        this.element_id = str7;
        this.element_type = str8;
        this.element_content = str9;
        this.element_name = str10;
        this.element_data_json = obj;
        this.properties = properties;
        this.internals = internals;
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getPage_name() {
        return this.page_name;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getElement_type() {
        return this.element_type;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final String getElement_content() {
        return this.element_content;
    }

    @Nullable
    /* renamed from: component12, reason: from getter */
    public final String getElement_name() {
        return this.element_name;
    }

    @Nullable
    /* renamed from: component13, reason: from getter */
    public final Object getElement_data_json() {
        return this.element_data_json;
    }

    @Nullable
    /* renamed from: component14, reason: from getter */
    public final Properties getProperties() {
        return this.properties;
    }

    @Nullable
    /* renamed from: component15, reason: from getter */
    public final Internals getInternals() {
        return this.internals;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getReferrer() {
        return this.referrer;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final String getPage_type() {
        return this.page_type;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final String getControl_type() {
        return this.control_type;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final Double getDuration() {
        return this.duration;
    }

    @Nullable
    public final List<String> component6() {
        return this.toys;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final String getEvent_id() {
        return this.event_id;
    }

    @Nullable
    /* renamed from: component8, reason: from getter */
    public final String getEvent_type() {
        return this.event_type;
    }

    @Nullable
    /* renamed from: component9, reason: from getter */
    public final String getElement_id() {
        return this.element_id;
    }

    @NotNull
    public final BILogContentBean copy(@Nullable String page_name, @Nullable String referrer, @Nullable String page_type, @Nullable String control_type, @Nullable Double duration, @Nullable List<String> toys, @Nullable String event_id, @Nullable String event_type, @Nullable String element_id, @Nullable String element_type, @Nullable String element_content, @Nullable String element_name, @Nullable Object element_data_json, @Nullable Properties properties, @Nullable Internals internals) {
        return new BILogContentBean(page_name, referrer, page_type, control_type, duration, toys, event_id, event_type, element_id, element_type, element_content, element_name, element_data_json, properties, internals);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BILogContentBean)) {
            return false;
        }
        BILogContentBean bILogContentBean = (BILogContentBean) other;
        return Intrinsics.areEqual(this.page_name, bILogContentBean.page_name) && Intrinsics.areEqual(this.referrer, bILogContentBean.referrer) && Intrinsics.areEqual(this.page_type, bILogContentBean.page_type) && Intrinsics.areEqual(this.control_type, bILogContentBean.control_type) && Intrinsics.areEqual((Object) this.duration, (Object) bILogContentBean.duration) && Intrinsics.areEqual(this.toys, bILogContentBean.toys) && Intrinsics.areEqual(this.event_id, bILogContentBean.event_id) && Intrinsics.areEqual(this.event_type, bILogContentBean.event_type) && Intrinsics.areEqual(this.element_id, bILogContentBean.element_id) && Intrinsics.areEqual(this.element_type, bILogContentBean.element_type) && Intrinsics.areEqual(this.element_content, bILogContentBean.element_content) && Intrinsics.areEqual(this.element_name, bILogContentBean.element_name) && Intrinsics.areEqual(this.element_data_json, bILogContentBean.element_data_json) && Intrinsics.areEqual(this.properties, bILogContentBean.properties) && Intrinsics.areEqual(this.internals, bILogContentBean.internals);
    }

    @Nullable
    public final String getControl_type() {
        return this.control_type;
    }

    @Nullable
    public final Double getDuration() {
        return this.duration;
    }

    @Nullable
    public final String getElement_content() {
        return this.element_content;
    }

    @Nullable
    public final Object getElement_data_json() {
        return this.element_data_json;
    }

    @Nullable
    public final String getElement_id() {
        return this.element_id;
    }

    @Nullable
    public final String getElement_name() {
        return this.element_name;
    }

    @Nullable
    public final String getElement_type() {
        return this.element_type;
    }

    @Nullable
    public final String getEvent_id() {
        return this.event_id;
    }

    @Nullable
    public final String getEvent_type() {
        return this.event_type;
    }

    @Nullable
    public final Internals getInternals() {
        return this.internals;
    }

    @Nullable
    public final String getPage_name() {
        return this.page_name;
    }

    @Nullable
    public final String getPage_type() {
        return this.page_type;
    }

    @Nullable
    public final Properties getProperties() {
        return this.properties;
    }

    @Nullable
    public final String getReferrer() {
        return this.referrer;
    }

    @Nullable
    public final List<String> getToys() {
        return this.toys;
    }

    public int hashCode() {
        String str = this.page_name;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.referrer;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.page_type;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.control_type;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Double d = this.duration;
        int iHashCode5 = (iHashCode4 + (d == null ? 0 : d.hashCode())) * 31;
        List<String> list = this.toys;
        int iHashCode6 = (iHashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        String str5 = this.event_id;
        int iHashCode7 = (iHashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.event_type;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.element_id;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.element_type;
        int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.element_content;
        int iHashCode11 = (iHashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.element_name;
        int iHashCode12 = (iHashCode11 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Object obj = this.element_data_json;
        int iHashCode13 = (iHashCode12 + (obj == null ? 0 : obj.hashCode())) * 31;
        Properties properties = this.properties;
        int iHashCode14 = (iHashCode13 + (properties == null ? 0 : properties.hashCode())) * 31;
        Internals internals = this.internals;
        return iHashCode14 + (internals != null ? internals.hashCode() : 0);
    }

    public final void setControl_type(@Nullable String str) {
        this.control_type = str;
    }

    public final void setDuration(@Nullable Double d) {
        this.duration = d;
    }

    public final void setElement_content(@Nullable String str) {
        this.element_content = str;
    }

    public final void setElement_data_json(@Nullable Object obj) {
        this.element_data_json = obj;
    }

    public final void setElement_id(@Nullable String str) {
        this.element_id = str;
    }

    public final void setElement_name(@Nullable String str) {
        this.element_name = str;
    }

    public final void setElement_type(@Nullable String str) {
        this.element_type = str;
    }

    public final void setEvent_id(@Nullable String str) {
        this.event_id = str;
    }

    public final void setEvent_type(@Nullable String str) {
        this.event_type = str;
    }

    public final void setInternals(@Nullable Internals internals) {
        this.internals = internals;
    }

    public final void setPage_name(@Nullable String str) {
        this.page_name = str;
    }

    public final void setPage_type(@Nullable String str) {
        this.page_type = str;
    }

    public final void setProperties(@Nullable Properties properties) {
        this.properties = properties;
    }

    public final void setReferrer(@Nullable String str) {
        this.referrer = str;
    }

    public final void setToys(@Nullable List<String> list) {
        this.toys = list;
    }

    @NotNull
    public String toString() {
        return "BILogContentBean(page_name=" + ((Object) this.page_name) + ", referrer=" + ((Object) this.referrer) + ", page_type=" + ((Object) this.page_type) + ", control_type=" + ((Object) this.control_type) + ", duration=" + this.duration + ", toys=" + this.toys + ", event_id=" + ((Object) this.event_id) + ", event_type=" + ((Object) this.event_type) + ", element_id=" + ((Object) this.element_id) + ", element_type=" + ((Object) this.element_type) + ", element_content=" + ((Object) this.element_content) + ", element_name=" + ((Object) this.element_name) + ", element_data_json=" + this.element_data_json + ", properties=" + this.properties + ", internals=" + this.internals + ')';
    }

    /* compiled from: BILogContentBean.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0013"}, d2 = {"Lcom/component/dxbilog/lib/bean/BILogContentBean$Internals;", "", "auto_track_click_time", "", "(Ljava/lang/Long;)V", "getAuto_track_click_time", "()Ljava/lang/Long;", "setAuto_track_click_time", "Ljava/lang/Long;", "component1", "copy", "(Ljava/lang/Long;)Lcom/component/dxbilog/lib/bean/BILogContentBean$Internals;", "equals", "", "other", "hashCode", "", "toString", "", "dxRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final /* data */ class Internals {

        @Nullable
        private Long auto_track_click_time;

        public Internals() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public Internals(@Nullable Long l) {
            this.auto_track_click_time = l;
        }

        public static /* synthetic */ Internals copy$default(Internals internals, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                l = internals.auto_track_click_time;
            }
            return internals.copy(l);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final Long getAuto_track_click_time() {
            return this.auto_track_click_time;
        }

        @NotNull
        public final Internals copy(@Nullable Long auto_track_click_time) {
            return new Internals(auto_track_click_time);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Internals) && Intrinsics.areEqual(this.auto_track_click_time, ((Internals) other).auto_track_click_time);
        }

        @Nullable
        public final Long getAuto_track_click_time() {
            return this.auto_track_click_time;
        }

        public int hashCode() {
            Long l = this.auto_track_click_time;
            if (l == null) {
                return 0;
            }
            return l.hashCode();
        }

        public final void setAuto_track_click_time(@Nullable Long l) {
            this.auto_track_click_time = l;
        }

        @NotNull
        public String toString() {
            return "Internals(auto_track_click_time=" + this.auto_track_click_time + ')';
        }

        public /* synthetic */ Internals(Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : l);
        }
    }

    /* compiled from: BILogContentBean.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010!\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010&\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000f¨\u0006-"}, d2 = {"Lcom/component/dxbilog/lib/bean/BILogContentBean$Properties;", "", "view_type", "", "view_content", "view_check", "", "view_position", "view_class_name", "view_supper_name", "track_type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTrack_type", "()Ljava/lang/String;", "setTrack_type", "(Ljava/lang/String;)V", "getView_check", "()Ljava/lang/Boolean;", "setView_check", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getView_class_name", "setView_class_name", "getView_content", "setView_content", "getView_position", "setView_position", "getView_supper_name", "setView_supper_name", "getView_type", "setView_type", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/component/dxbilog/lib/bean/BILogContentBean$Properties;", "equals", "other", "hashCode", "", "toString", "dxRouter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final /* data */ class Properties {

        @Nullable
        private String track_type;

        @Nullable
        private Boolean view_check;

        @Nullable
        private String view_class_name;

        @Nullable
        private String view_content;

        @Nullable
        private String view_position;

        @Nullable
        private String view_supper_name;

        @Nullable
        private String view_type;

        public Properties() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        public Properties(@Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
            this.view_type = str;
            this.view_content = str2;
            this.view_check = bool;
            this.view_position = str3;
            this.view_class_name = str4;
            this.view_supper_name = str5;
            this.track_type = str6;
        }

        public static /* synthetic */ Properties copy$default(Properties properties, String str, String str2, Boolean bool, String str3, String str4, String str5, String str6, int i, Object obj) {
            if ((i & 1) != 0) {
                str = properties.view_type;
            }
            if ((i & 2) != 0) {
                str2 = properties.view_content;
            }
            String str7 = str2;
            if ((i & 4) != 0) {
                bool = properties.view_check;
            }
            Boolean bool2 = bool;
            if ((i & 8) != 0) {
                str3 = properties.view_position;
            }
            String str8 = str3;
            if ((i & 16) != 0) {
                str4 = properties.view_class_name;
            }
            String str9 = str4;
            if ((i & 32) != 0) {
                str5 = properties.view_supper_name;
            }
            String str10 = str5;
            if ((i & 64) != 0) {
                str6 = properties.track_type;
            }
            return properties.copy(str, str7, bool2, str8, str9, str10, str6);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final String getView_type() {
            return this.view_type;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final String getView_content() {
            return this.view_content;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final Boolean getView_check() {
            return this.view_check;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final String getView_position() {
            return this.view_position;
        }

        @Nullable
        /* renamed from: component5, reason: from getter */
        public final String getView_class_name() {
            return this.view_class_name;
        }

        @Nullable
        /* renamed from: component6, reason: from getter */
        public final String getView_supper_name() {
            return this.view_supper_name;
        }

        @Nullable
        /* renamed from: component7, reason: from getter */
        public final String getTrack_type() {
            return this.track_type;
        }

        @NotNull
        public final Properties copy(@Nullable String view_type, @Nullable String view_content, @Nullable Boolean view_check, @Nullable String view_position, @Nullable String view_class_name, @Nullable String view_supper_name, @Nullable String track_type) {
            return new Properties(view_type, view_content, view_check, view_position, view_class_name, view_supper_name, track_type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Properties)) {
                return false;
            }
            Properties properties = (Properties) other;
            return Intrinsics.areEqual(this.view_type, properties.view_type) && Intrinsics.areEqual(this.view_content, properties.view_content) && Intrinsics.areEqual(this.view_check, properties.view_check) && Intrinsics.areEqual(this.view_position, properties.view_position) && Intrinsics.areEqual(this.view_class_name, properties.view_class_name) && Intrinsics.areEqual(this.view_supper_name, properties.view_supper_name) && Intrinsics.areEqual(this.track_type, properties.track_type);
        }

        @Nullable
        public final String getTrack_type() {
            return this.track_type;
        }

        @Nullable
        public final Boolean getView_check() {
            return this.view_check;
        }

        @Nullable
        public final String getView_class_name() {
            return this.view_class_name;
        }

        @Nullable
        public final String getView_content() {
            return this.view_content;
        }

        @Nullable
        public final String getView_position() {
            return this.view_position;
        }

        @Nullable
        public final String getView_supper_name() {
            return this.view_supper_name;
        }

        @Nullable
        public final String getView_type() {
            return this.view_type;
        }

        public int hashCode() {
            String str = this.view_type;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.view_content;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            Boolean bool = this.view_check;
            int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
            String str3 = this.view_position;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.view_class_name;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.view_supper_name;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.track_type;
            return iHashCode6 + (str6 != null ? str6.hashCode() : 0);
        }

        public final void setTrack_type(@Nullable String str) {
            this.track_type = str;
        }

        public final void setView_check(@Nullable Boolean bool) {
            this.view_check = bool;
        }

        public final void setView_class_name(@Nullable String str) {
            this.view_class_name = str;
        }

        public final void setView_content(@Nullable String str) {
            this.view_content = str;
        }

        public final void setView_position(@Nullable String str) {
            this.view_position = str;
        }

        public final void setView_supper_name(@Nullable String str) {
            this.view_supper_name = str;
        }

        public final void setView_type(@Nullable String str) {
            this.view_type = str;
        }

        @NotNull
        public String toString() {
            return "Properties(view_type=" + ((Object) this.view_type) + ", view_content=" + ((Object) this.view_content) + ", view_check=" + this.view_check + ", view_position=" + ((Object) this.view_position) + ", view_class_name=" + ((Object) this.view_class_name) + ", view_supper_name=" + ((Object) this.view_supper_name) + ", track_type=" + ((Object) this.track_type) + ')';
        }

        public /* synthetic */ Properties(String str, String str2, Boolean bool, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6);
        }
    }

    public /* synthetic */ BILogContentBean(String str, String str2, String str3, String str4, Double d, List list, String str5, String str6, String str7, String str8, String str9, String str10, Object obj, Properties properties, Internals internals, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : d, (i & 32) != 0 ? null : list, (i & 64) != 0 ? null : str5, (i & 128) != 0 ? null : str6, (i & 256) != 0 ? null : str7, (i & 512) != 0 ? null : str8, (i & 1024) != 0 ? null : str9, (i & 2048) != 0 ? null : str10, (i & 4096) != 0 ? null : obj, (i & 8192) != 0 ? null : properties, (i & 16384) == 0 ? internals : null);
    }
}

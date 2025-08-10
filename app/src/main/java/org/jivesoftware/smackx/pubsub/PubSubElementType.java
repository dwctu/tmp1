package org.jivesoftware.smackx.pubsub;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.koushikdutta.async.http.AsyncHttpDelete;
import java.util.Locale;
import org.aspectj.runtime.reflect.SignatureImpl;
import org.jivesoftware.smackx.pubsub.packet.PubSubNamespace;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'CREATE' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class PubSubElementType {
    private static final /* synthetic */ PubSubElementType[] $VALUES;
    public static final PubSubElementType AFFILIATIONS;
    public static final PubSubElementType CONFIGURATION;
    public static final PubSubElementType CONFIGURE;
    public static final PubSubElementType CONFIGURE_OWNER;
    public static final PubSubElementType CREATE;
    public static final PubSubElementType DEFAULT;
    public static final PubSubElementType DELETE;
    public static final PubSubElementType DELETE_EVENT;
    public static final PubSubElementType ITEM;
    public static final PubSubElementType ITEMS;
    public static final PubSubElementType ITEMS_EVENT;
    public static final PubSubElementType ITEM_EVENT;
    public static final PubSubElementType OPTIONS;
    public static final PubSubElementType PUBLISH;
    public static final PubSubElementType PUBLISH_OPTIONS;
    public static final PubSubElementType PURGE_EVENT;
    public static final PubSubElementType PURGE_OWNER;
    public static final PubSubElementType RETRACT;
    public static final PubSubElementType SUBSCRIBE;
    public static final PubSubElementType SUBSCRIPTION;
    public static final PubSubElementType SUBSCRIPTIONS;
    public static final PubSubElementType UNSUBSCRIBE;
    private String eName;
    private PubSubNamespace nSpace;

    static {
        PubSubNamespace pubSubNamespace = PubSubNamespace.BASIC;
        PubSubElementType pubSubElementType = new PubSubElementType("CREATE", 0, "create", pubSubNamespace);
        CREATE = pubSubElementType;
        PubSubNamespace pubSubNamespace2 = PubSubNamespace.OWNER;
        PubSubElementType pubSubElementType2 = new PubSubElementType(AsyncHttpDelete.METHOD, 1, "delete", pubSubNamespace2);
        DELETE = pubSubElementType2;
        PubSubNamespace pubSubNamespace3 = PubSubNamespace.EVENT;
        PubSubElementType pubSubElementType3 = new PubSubElementType("DELETE_EVENT", 2, "delete", pubSubNamespace3);
        DELETE_EVENT = pubSubElementType3;
        PubSubElementType pubSubElementType4 = new PubSubElementType("CONFIGURE", 3, "configure", pubSubNamespace);
        CONFIGURE = pubSubElementType4;
        PubSubElementType pubSubElementType5 = new PubSubElementType("CONFIGURE_OWNER", 4, "configure", pubSubNamespace2);
        CONFIGURE_OWNER = pubSubElementType5;
        PubSubElementType pubSubElementType6 = new PubSubElementType("CONFIGURATION", 5, "configuration", pubSubNamespace3);
        CONFIGURATION = pubSubElementType6;
        PubSubElementType pubSubElementType7 = new PubSubElementType("OPTIONS", 6, "options", pubSubNamespace);
        OPTIONS = pubSubElementType7;
        PubSubElementType pubSubElementType8 = new PubSubElementType("DEFAULT", 7, "default", pubSubNamespace2);
        DEFAULT = pubSubElementType8;
        PubSubElementType pubSubElementType9 = new PubSubElementType("ITEMS", 8, FirebaseAnalytics.Param.ITEMS, pubSubNamespace);
        ITEMS = pubSubElementType9;
        PubSubElementType pubSubElementType10 = new PubSubElementType("ITEMS_EVENT", 9, FirebaseAnalytics.Param.ITEMS, pubSubNamespace3);
        ITEMS_EVENT = pubSubElementType10;
        PubSubElementType pubSubElementType11 = new PubSubElementType("ITEM", 10, "item", pubSubNamespace);
        ITEM = pubSubElementType11;
        PubSubElementType pubSubElementType12 = new PubSubElementType("ITEM_EVENT", 11, "item", pubSubNamespace3);
        ITEM_EVENT = pubSubElementType12;
        PubSubElementType pubSubElementType13 = new PubSubElementType("PUBLISH", 12, "publish", pubSubNamespace);
        PUBLISH = pubSubElementType13;
        PubSubElementType pubSubElementType14 = new PubSubElementType("PUBLISH_OPTIONS", 13, "publish-options", pubSubNamespace);
        PUBLISH_OPTIONS = pubSubElementType14;
        PubSubElementType pubSubElementType15 = new PubSubElementType("PURGE_OWNER", 14, "purge", pubSubNamespace2);
        PURGE_OWNER = pubSubElementType15;
        PubSubElementType pubSubElementType16 = new PubSubElementType("PURGE_EVENT", 15, "purge", pubSubNamespace3);
        PURGE_EVENT = pubSubElementType16;
        PubSubElementType pubSubElementType17 = new PubSubElementType("RETRACT", 16, "retract", pubSubNamespace);
        RETRACT = pubSubElementType17;
        PubSubElementType pubSubElementType18 = new PubSubElementType("AFFILIATIONS", 17, "affiliations", pubSubNamespace);
        AFFILIATIONS = pubSubElementType18;
        PubSubElementType pubSubElementType19 = new PubSubElementType("SUBSCRIBE", 18, "subscribe", pubSubNamespace);
        SUBSCRIBE = pubSubElementType19;
        PubSubElementType pubSubElementType20 = new PubSubElementType("SUBSCRIPTION", 19, "subscription", pubSubNamespace);
        SUBSCRIPTION = pubSubElementType20;
        PubSubElementType pubSubElementType21 = new PubSubElementType("SUBSCRIPTIONS", 20, "subscriptions", pubSubNamespace);
        SUBSCRIPTIONS = pubSubElementType21;
        PubSubElementType pubSubElementType22 = new PubSubElementType("UNSUBSCRIBE", 21, "unsubscribe", pubSubNamespace);
        UNSUBSCRIBE = pubSubElementType22;
        $VALUES = new PubSubElementType[]{pubSubElementType, pubSubElementType2, pubSubElementType3, pubSubElementType4, pubSubElementType5, pubSubElementType6, pubSubElementType7, pubSubElementType8, pubSubElementType9, pubSubElementType10, pubSubElementType11, pubSubElementType12, pubSubElementType13, pubSubElementType14, pubSubElementType15, pubSubElementType16, pubSubElementType17, pubSubElementType18, pubSubElementType19, pubSubElementType20, pubSubElementType21, pubSubElementType22};
    }

    private PubSubElementType(String str, int i, String str2, PubSubNamespace pubSubNamespace) {
        this.eName = str2;
        this.nSpace = pubSubNamespace;
    }

    public static PubSubElementType valueOf(String str) {
        return (PubSubElementType) Enum.valueOf(PubSubElementType.class, str);
    }

    public static PubSubElementType valueOfFromElemName(String str, String str2) {
        int iLastIndexOf = str2.lastIndexOf(35);
        String strSubstring = iLastIndexOf == -1 ? null : str2.substring(iLastIndexOf + 1);
        if (strSubstring == null) {
            return valueOf(str.toUpperCase(Locale.US).replace(SignatureImpl.SEP, '_'));
        }
        return valueOf((str + '_' + strSubstring).toUpperCase(Locale.US));
    }

    public static PubSubElementType[] values() {
        return (PubSubElementType[]) $VALUES.clone();
    }

    public String getElementName() {
        return this.eName;
    }

    public PubSubNamespace getNamespace() {
        return this.nSpace;
    }
}

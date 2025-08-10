package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SpecialNames.kt */
/* loaded from: classes4.dex */
public final class SpecialNames {

    @JvmField
    @NotNull
    public static final Name ANONYMOUS;

    @JvmField
    @NotNull
    public static final Name DEFAULT_NAME_FOR_COMPANION_OBJECT;

    @JvmField
    @NotNull
    public static final Name DESTRUCT;

    @JvmField
    @NotNull
    public static final Name IMPLICIT_SET_PARAMETER;

    @JvmField
    @NotNull
    public static final Name INIT;

    @NotNull
    public static final SpecialNames INSTANCE = new SpecialNames();

    @JvmField
    @NotNull
    public static final Name ITERATOR;

    @JvmField
    @NotNull
    public static final Name LOCAL;

    @JvmField
    @NotNull
    public static final Name NO_NAME_PROVIDED;

    @JvmField
    @NotNull
    public static final Name ROOT_PACKAGE;

    @JvmField
    @NotNull
    public static final Name SAFE_IDENTIFIER_FOR_NO_NAME;

    @JvmField
    @NotNull
    public static final Name THIS;

    @JvmField
    @NotNull
    public static final Name UNARY;

    @JvmField
    @NotNull
    public static final Name UNDERSCORE_FOR_UNUSED_VAR;

    static {
        Name nameSpecial = Name.special("<no name provided>");
        Intrinsics.checkNotNullExpressionValue(nameSpecial, "special(\"<no name provided>\")");
        NO_NAME_PROVIDED = nameSpecial;
        Name nameSpecial2 = Name.special("<root package>");
        Intrinsics.checkNotNullExpressionValue(nameSpecial2, "special(\"<root package>\")");
        ROOT_PACKAGE = nameSpecial2;
        Name nameIdentifier = Name.identifier("Companion");
        Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(\"Companion\")");
        DEFAULT_NAME_FOR_COMPANION_OBJECT = nameIdentifier;
        Name nameIdentifier2 = Name.identifier("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
        Intrinsics.checkNotNullExpressionValue(nameIdentifier2, "identifier(\"no_name_in_P…_4cd0_b7f5_b46aa3cd5d40\")");
        SAFE_IDENTIFIER_FOR_NO_NAME = nameIdentifier2;
        Name nameSpecial3 = Name.special("<anonymous>");
        Intrinsics.checkNotNullExpressionValue(nameSpecial3, "special(ANONYMOUS_STRING)");
        ANONYMOUS = nameSpecial3;
        Name nameSpecial4 = Name.special("<unary>");
        Intrinsics.checkNotNullExpressionValue(nameSpecial4, "special(\"<unary>\")");
        UNARY = nameSpecial4;
        Name nameSpecial5 = Name.special("<this>");
        Intrinsics.checkNotNullExpressionValue(nameSpecial5, "special(\"<this>\")");
        THIS = nameSpecial5;
        Name nameSpecial6 = Name.special("<init>");
        Intrinsics.checkNotNullExpressionValue(nameSpecial6, "special(\"<init>\")");
        INIT = nameSpecial6;
        Name nameSpecial7 = Name.special("<iterator>");
        Intrinsics.checkNotNullExpressionValue(nameSpecial7, "special(\"<iterator>\")");
        ITERATOR = nameSpecial7;
        Name nameSpecial8 = Name.special("<destruct>");
        Intrinsics.checkNotNullExpressionValue(nameSpecial8, "special(\"<destruct>\")");
        DESTRUCT = nameSpecial8;
        Name nameSpecial9 = Name.special("<local>");
        Intrinsics.checkNotNullExpressionValue(nameSpecial9, "special(\"<local>\")");
        LOCAL = nameSpecial9;
        Name nameSpecial10 = Name.special("<unused var>");
        Intrinsics.checkNotNullExpressionValue(nameSpecial10, "special(\"<unused var>\")");
        UNDERSCORE_FOR_UNUSED_VAR = nameSpecial10;
        Name nameSpecial11 = Name.special("<set-?>");
        Intrinsics.checkNotNullExpressionValue(nameSpecial11, "special(\"<set-?>\")");
        IMPLICIT_SET_PARAMETER = nameSpecial11;
    }

    private SpecialNames() {
    }

    @JvmStatic
    @NotNull
    public static final Name safeIdentifier(@Nullable Name name) {
        return (name == null || name.isSpecial()) ? SAFE_IDENTIFIER_FOR_NO_NAME : name;
    }

    public final boolean isSafeIdentifier(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String strAsString = name.asString();
        Intrinsics.checkNotNullExpressionValue(strAsString, "name.asString()");
        return (strAsString.length() > 0) && !name.isSpecial();
    }
}

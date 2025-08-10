package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import androidx.exifinterface.media.ExifInterface;
import com.broadcom.bt.util.io.FilenameUtils;
import com.broadcom.bt.util.io.IOUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.Typography;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;
import org.jetbrains.annotations.NotNull;

/* compiled from: ClassMapperLite.kt */
/* loaded from: classes4.dex */
public final class ClassMapperLite {

    @NotNull
    public static final ClassMapperLite INSTANCE = new ClassMapperLite();

    /* renamed from: kotlin, reason: collision with root package name */
    @NotNull
    private static final String f9kotlin = CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt__CollectionsKt.listOf((Object[]) new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);

    @NotNull
    private static final Map<String, String> map;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listListOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"Boolean", "Z", "Char", "C", "Byte", "B", "Short", ExifInterface.LATITUDE_SOUTH, "Int", "I", "Float", "F", "Long", "J", "Double", "D"});
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, listListOf.size() - 1, 2);
        if (progressionLastElement >= 0) {
            int i = 0;
            while (true) {
                StringBuilder sb = new StringBuilder();
                String str = f9kotlin;
                sb.append(str);
                sb.append(IOUtils.DIR_SEPARATOR_UNIX);
                sb.append((String) listListOf.get(i));
                int i2 = i + 1;
                linkedHashMap.put(sb.toString(), listListOf.get(i2));
                linkedHashMap.put(str + IOUtils.DIR_SEPARATOR_UNIX + ((String) listListOf.get(i)) + "Array", '[' + ((String) listListOf.get(i2)));
                if (i == progressionLastElement) {
                    break;
                } else {
                    i += 2;
                }
            }
        }
        linkedHashMap.put(f9kotlin + "/Unit", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        m1380map$lambda0$add(linkedHashMap, "Any", "java/lang/Object");
        m1380map$lambda0$add(linkedHashMap, "Nothing", "java/lang/Void");
        m1380map$lambda0$add(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum"})) {
            m1380map$lambda0$add(linkedHashMap, str2, "java/lang/" + str2);
        }
        for (String str3 : CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"Iterator", "Collection", "List", "Set", "Map", "ListIterator"})) {
            m1380map$lambda0$add(linkedHashMap, "collections/" + str3, "java/util/" + str3);
            m1380map$lambda0$add(linkedHashMap, "collections/Mutable" + str3, "java/util/" + str3);
        }
        m1380map$lambda0$add(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        m1380map$lambda0$add(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        m1380map$lambda0$add(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        m1380map$lambda0$add(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i3 = 0; i3 < 23; i3++) {
            StringBuilder sb2 = new StringBuilder();
            String str4 = f9kotlin;
            sb2.append(str4);
            sb2.append("/jvm/functions/Function");
            sb2.append(i3);
            m1380map$lambda0$add(linkedHashMap, "Function" + i3, sb2.toString());
            m1380map$lambda0$add(linkedHashMap, "reflect/KFunction" + i3, str4 + "/reflect/KFunction");
        }
        for (String str5 : CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum"})) {
            m1380map$lambda0$add(linkedHashMap, str5 + ".Companion", f9kotlin + "/jvm/internal/" + str5 + "CompanionObject");
        }
        map = linkedHashMap;
    }

    private ClassMapperLite() {
    }

    /* renamed from: map$lambda-0$add, reason: not valid java name */
    private static final void m1380map$lambda0$add(Map<String, String> map2, String str, String str2) {
        map2.put(f9kotlin + IOUtils.DIR_SEPARATOR_UNIX + str, Matrix.MATRIX_TYPE_RANDOM_LT + str2 + ';');
    }

    @JvmStatic
    @NotNull
    public static final String mapClass(@NotNull String classId) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        String str = map.get(classId);
        if (str != null) {
            return str;
        }
        return Matrix.MATRIX_TYPE_RANDOM_LT + StringsKt__StringsJVMKt.replace$default(classId, FilenameUtils.EXTENSION_SEPARATOR, Typography.dollar, false, 4, (Object) null) + ';';
    }
}

package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import com.broadcom.bt.util.io.FilenameUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.Typography;

/* compiled from: ReflectKotlinClassFinder.kt */
/* loaded from: classes4.dex */
public final class ReflectKotlinClassFinderKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String toRuntimeFqName(ClassId classId) {
        String strAsString = classId.getRelativeClassName().asString();
        Intrinsics.checkNotNullExpressionValue(strAsString, "relativeClassName.asString()");
        String strReplace$default = StringsKt__StringsJVMKt.replace$default(strAsString, FilenameUtils.EXTENSION_SEPARATOR, Typography.dollar, false, 4, (Object) null);
        if (classId.getPackageFqName().isRoot()) {
            return strReplace$default;
        }
        return classId.getPackageFqName() + FilenameUtils.EXTENSION_SEPARATOR + strReplace$default;
    }
}

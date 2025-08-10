package kotlin.reflect.jvm.internal.impl.builtins.functions;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsSpiCall;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.util.OperatorNameConventions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FunctionInvokeDescriptor.kt */
/* loaded from: classes4.dex */
public final class FunctionInvokeDescriptor extends SimpleFunctionDescriptorImpl {

    @NotNull
    public static final Factory Factory = new Factory(null);

    /* compiled from: FunctionInvokeDescriptor.kt */
    public static final class Factory {
        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final ValueParameterDescriptor createValueParameter(FunctionInvokeDescriptor functionInvokeDescriptor, int i, TypeParameterDescriptor typeParameterDescriptor) {
            String lowerCase;
            String strAsString = typeParameterDescriptor.getName().asString();
            Intrinsics.checkNotNullExpressionValue(strAsString, "typeParameter.name.asString()");
            if (Intrinsics.areEqual(strAsString, ExifInterface.GPS_DIRECTION_TRUE)) {
                lowerCase = DefaultSettingsSpiCall.INSTANCE_PARAM;
            } else if (Intrinsics.areEqual(strAsString, ExifInterface.LONGITUDE_EAST)) {
                lowerCase = "receiver";
            } else {
                lowerCase = strAsString.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            }
            Annotations empty = Annotations.Companion.getEMPTY();
            Name nameIdentifier = Name.identifier(lowerCase);
            Intrinsics.checkNotNullExpressionValue(nameIdentifier, "identifier(name)");
            SimpleType defaultType = typeParameterDescriptor.getDefaultType();
            Intrinsics.checkNotNullExpressionValue(defaultType, "typeParameter.defaultType");
            SourceElement NO_SOURCE = SourceElement.NO_SOURCE;
            Intrinsics.checkNotNullExpressionValue(NO_SOURCE, "NO_SOURCE");
            return new ValueParameterDescriptorImpl(functionInvokeDescriptor, null, i, empty, nameIdentifier, defaultType, false, false, false, null, NO_SOURCE);
        }

        @NotNull
        public final FunctionInvokeDescriptor create(@NotNull FunctionClassDescriptor functionClass, boolean z) {
            Intrinsics.checkNotNullParameter(functionClass, "functionClass");
            List<TypeParameterDescriptor> declaredTypeParameters = functionClass.getDeclaredTypeParameters();
            FunctionInvokeDescriptor functionInvokeDescriptor = new FunctionInvokeDescriptor(functionClass, null, CallableMemberDescriptor.Kind.DECLARATION, z, null);
            ReceiverParameterDescriptor thisAsReceiverParameter = functionClass.getThisAsReceiverParameter();
            List<ReceiverParameterDescriptor> listEmptyList = CollectionsKt__CollectionsKt.emptyList();
            List<? extends TypeParameterDescriptor> listEmptyList2 = CollectionsKt__CollectionsKt.emptyList();
            ArrayList arrayList = new ArrayList();
            for (Object obj : declaredTypeParameters) {
                if (!(((TypeParameterDescriptor) obj).getVariance() == Variance.IN_VARIANCE)) {
                    break;
                }
                arrayList.add(obj);
            }
            Iterable<IndexedValue> iterableWithIndex = CollectionsKt___CollectionsKt.withIndex(arrayList);
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterableWithIndex, 10));
            for (IndexedValue indexedValue : iterableWithIndex) {
                arrayList2.add(FunctionInvokeDescriptor.Factory.createValueParameter(functionInvokeDescriptor, indexedValue.getIndex(), (TypeParameterDescriptor) indexedValue.getValue()));
            }
            functionInvokeDescriptor.initialize((ReceiverParameterDescriptor) null, thisAsReceiverParameter, listEmptyList, listEmptyList2, (List<ValueParameterDescriptor>) arrayList2, (KotlinType) ((TypeParameterDescriptor) CollectionsKt___CollectionsKt.last((List) declaredTypeParameters)).getDefaultType(), Modality.ABSTRACT, DescriptorVisibilities.PUBLIC);
            functionInvokeDescriptor.setHasSynthesizedParameterNames(true);
            return functionInvokeDescriptor;
        }
    }

    private FunctionInvokeDescriptor(DeclarationDescriptor declarationDescriptor, FunctionInvokeDescriptor functionInvokeDescriptor, CallableMemberDescriptor.Kind kind, boolean z) {
        super(declarationDescriptor, functionInvokeDescriptor, Annotations.Companion.getEMPTY(), OperatorNameConventions.INVOKE, kind, SourceElement.NO_SOURCE);
        setOperator(true);
        setSuspend(z);
        setHasStableParameterNames(false);
    }

    public /* synthetic */ FunctionInvokeDescriptor(DeclarationDescriptor declarationDescriptor, FunctionInvokeDescriptor functionInvokeDescriptor, CallableMemberDescriptor.Kind kind, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(declarationDescriptor, functionInvokeDescriptor, kind, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0053 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor replaceParameterNames(java.util.List<kotlin.reflect.jvm.internal.impl.name.Name> r10) {
        /*
            r9 = this;
            java.util.List r0 = r9.getValueParameters()
            int r0 = r0.size()
            int r1 = r10.size()
            int r0 = r0 - r1
            r1 = 1
            java.lang.String r2 = "valueParameters"
            r3 = 0
            if (r0 != 0) goto L54
            java.util.List r4 = r9.getValueParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            java.util.List r4 = kotlin.collections.CollectionsKt___CollectionsKt.zip(r10, r4)
            boolean r5 = r4 instanceof java.util.Collection
            if (r5 == 0) goto L2a
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L2a
        L28:
            r4 = 1
            goto L51
        L2a:
            java.util.Iterator r4 = r4.iterator()
        L2e:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L28
            java.lang.Object r5 = r4.next()
            kotlin.Pair r5 = (kotlin.Pair) r5
            java.lang.Object r6 = r5.component1()
            kotlin.reflect.jvm.internal.impl.name.Name r6 = (kotlin.reflect.jvm.internal.impl.name.Name) r6
            java.lang.Object r5 = r5.component2()
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r5
            kotlin.reflect.jvm.internal.impl.name.Name r5 = r5.getName()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r5)
            if (r5 != 0) goto L2e
            r4 = 0
        L51:
            if (r4 == 0) goto L54
            return r9
        L54:
            java.util.List r4 = r9.getValueParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r4, r5)
            r2.<init>(r5)
            java.util.Iterator r4 = r4.iterator()
        L6a:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L98
            java.lang.Object r5 = r4.next()
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor) r5
            kotlin.reflect.jvm.internal.impl.name.Name r6 = r5.getName()
            java.lang.String r7 = "it.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            int r7 = r5.getIndex()
            int r8 = r7 - r0
            if (r8 < 0) goto L90
            java.lang.Object r8 = r10.get(r8)
            kotlin.reflect.jvm.internal.impl.name.Name r8 = (kotlin.reflect.jvm.internal.impl.name.Name) r8
            if (r8 == 0) goto L90
            r6 = r8
        L90:
            kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor r5 = r5.copy(r9, r6, r7)
            r2.add(r5)
            goto L6a
        L98:
            kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor r0 = kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor.EMPTY
            kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration r0 = r9.newCopyBuilder(r0)
            boolean r4 = r10 instanceof java.util.Collection
            if (r4 == 0) goto Laa
            boolean r4 = r10.isEmpty()
            if (r4 == 0) goto Laa
        La8:
            r1 = 0
            goto Lc1
        Laa:
            java.util.Iterator r10 = r10.iterator()
        Lae:
            boolean r4 = r10.hasNext()
            if (r4 == 0) goto La8
            java.lang.Object r4 = r10.next()
            kotlin.reflect.jvm.internal.impl.name.Name r4 = (kotlin.reflect.jvm.internal.impl.name.Name) r4
            if (r4 != 0) goto Lbe
            r4 = 1
            goto Lbf
        Lbe:
            r4 = 0
        Lbf:
            if (r4 == 0) goto Lae
        Lc1:
            kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration r10 = r0.setHasSynthesizedParameterNames(r1)
            kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration r10 = r10.setValueParameters(r2)
            kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor r0 = r9.getOriginal()
            kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl$CopyConfiguration r10 = r10.setOriginal(r0)
            java.lang.String r0 = "newCopyBuilder(TypeSubst…   .setOriginal(original)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r10 = super.doSubstitute(r10)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionInvokeDescriptor.replaceParameterNames(java.util.List):kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor");
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.SimpleFunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    @NotNull
    public FunctionDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor newOwner, @Nullable FunctionDescriptor functionDescriptor, @NotNull CallableMemberDescriptor.Kind kind, @Nullable Name name, @NotNull Annotations annotations, @NotNull SourceElement source) {
        Intrinsics.checkNotNullParameter(newOwner, "newOwner");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.checkNotNullParameter(source, "source");
        return new FunctionInvokeDescriptor(newOwner, (FunctionInvokeDescriptor) functionDescriptor, kind, isSuspend());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl
    @Nullable
    public FunctionDescriptor doSubstitute(@NotNull FunctionDescriptorImpl.CopyConfiguration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        FunctionInvokeDescriptor functionInvokeDescriptor = (FunctionInvokeDescriptor) super.doSubstitute(configuration);
        if (functionInvokeDescriptor == null) {
            return null;
        }
        List<ValueParameterDescriptor> valueParameters = functionInvokeDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters, "substituted.valueParameters");
        boolean z = false;
        if ((valueParameters instanceof Collection) && valueParameters.isEmpty()) {
            z = true;
        } else {
            Iterator<T> it = valueParameters.iterator();
            while (it.hasNext()) {
                KotlinType type = ((ValueParameterDescriptor) it.next()).getType();
                Intrinsics.checkNotNullExpressionValue(type, "it.type");
                if (FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type) != null) {
                    break;
                }
            }
            z = true;
        }
        if (z) {
            return functionInvokeDescriptor;
        }
        List<ValueParameterDescriptor> valueParameters2 = functionInvokeDescriptor.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(valueParameters2, "substituted.valueParameters");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(valueParameters2, 10));
        Iterator<T> it2 = valueParameters2.iterator();
        while (it2.hasNext()) {
            KotlinType type2 = ((ValueParameterDescriptor) it2.next()).getType();
            Intrinsics.checkNotNullExpressionValue(type2, "it.type");
            arrayList.add(FunctionTypesKt.extractParameterNameFromFunctionTypeArgument(type2));
        }
        return functionInvokeDescriptor.replaceParameterNames(arrayList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl, kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
    public boolean isTailrec() {
        return false;
    }
}

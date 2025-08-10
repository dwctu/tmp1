package retrofit2.converter.moshi;

import dc.nd4;
import dc.nf1;
import dc.tc4;
import dc.vf1;
import dc.zc4;
import java.io.IOException;
import retrofit2.Converter;

/* loaded from: classes5.dex */
public final class MoshiRequestBodyConverter<T> implements Converter<T, zc4> {
    private static final tc4 MEDIA_TYPE = tc4.c("application/json; charset=UTF-8");
    private final nf1<T> adapter;

    public MoshiRequestBodyConverter(nf1<T> nf1Var) {
        this.adapter = nf1Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // retrofit2.Converter
    public /* bridge */ /* synthetic */ zc4 convert(Object obj) throws IOException {
        return convert((MoshiRequestBodyConverter<T>) obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // retrofit2.Converter
    public zc4 convert(T t) throws IOException {
        nd4 nd4Var = new nd4();
        this.adapter.h(vf1.A(nd4Var), t);
        return zc4.create(MEDIA_TYPE, nd4Var.L());
    }
}

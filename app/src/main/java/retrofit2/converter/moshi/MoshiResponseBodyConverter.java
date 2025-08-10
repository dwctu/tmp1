package retrofit2.converter.moshi;

import com.squareup.moshi.JsonDataException;
import dc.bd4;
import dc.nf1;
import dc.pd4;
import dc.qd4;
import dc.qf1;
import java.io.IOException;
import retrofit2.Converter;

/* loaded from: classes5.dex */
public final class MoshiResponseBodyConverter<T> implements Converter<bd4, T> {
    private static final qd4 UTF8_BOM = qd4.e("EFBBBF");
    private final nf1<T> adapter;

    public MoshiResponseBodyConverter(nf1<T> nf1Var) {
        this.adapter = nf1Var;
    }

    @Override // retrofit2.Converter
    public T convert(bd4 bd4Var) throws IOException {
        pd4 pd4VarSource = bd4Var.source();
        try {
            if (pd4VarSource.t(0L, UTF8_BOM)) {
                pd4VarSource.skip(r3.s());
            }
            qf1 qf1VarL = qf1.L(pd4VarSource);
            T tB = this.adapter.b(qf1VarL);
            if (qf1VarL.O() == qf1.b.END_DOCUMENT) {
                return tB;
            }
            throw new JsonDataException("JSON document was not fully consumed.");
        } finally {
            bd4Var.close();
        }
    }
}

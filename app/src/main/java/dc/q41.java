package dc;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import org.slf4j.helpers.MessageFormatter;

/* compiled from: DecoderConfigDescriptor.java */
@s41(tags = {4})
/* loaded from: classes2.dex */
public class q41 extends n41 {
    public static Logger n = Logger.getLogger(q41.class.getName());
    public int d;
    public int e;
    public int f;
    public int g;
    public long h;
    public long i;
    public r41 j;
    public m41 k;
    public List<y41> l = new ArrayList();
    public byte[] m;

    @Override // dc.n41
    public void e(ByteBuffer byteBuffer) throws IOException {
        int iA;
        this.d = df0.l(byteBuffer);
        int iL = df0.l(byteBuffer);
        this.e = iL >>> 2;
        this.f = (iL >> 1) & 1;
        this.g = df0.i(byteBuffer);
        this.h = df0.j(byteBuffer);
        this.i = df0.j(byteBuffer);
        if (byteBuffer.remaining() > 2) {
            int iPosition = byteBuffer.position();
            n41 n41VarA = x41.a(this.d, byteBuffer);
            int iPosition2 = byteBuffer.position() - iPosition;
            Logger logger = n;
            StringBuilder sb = new StringBuilder();
            sb.append(n41VarA);
            sb.append(" - DecoderConfigDescr1 read: ");
            sb.append(iPosition2);
            sb.append(", size: ");
            sb.append(n41VarA != null ? Integer.valueOf(n41VarA.a()) : null);
            logger.finer(sb.toString());
            if (n41VarA != null && iPosition2 < (iA = n41VarA.a())) {
                byte[] bArr = new byte[iA - iPosition2];
                this.m = bArr;
                byteBuffer.get(bArr);
            }
            if (n41VarA instanceof r41) {
                this.j = (r41) n41VarA;
            }
            if (n41VarA instanceof m41) {
                this.k = (m41) n41VarA;
            }
        }
        while (byteBuffer.remaining() > 2) {
            long jPosition = byteBuffer.position();
            n41 n41VarA2 = x41.a(this.d, byteBuffer);
            long jPosition2 = byteBuffer.position() - jPosition;
            Logger logger2 = n;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(n41VarA2);
            sb2.append(" - DecoderConfigDescr2 read: ");
            sb2.append(jPosition2);
            sb2.append(", size: ");
            sb2.append(n41VarA2 != null ? Integer.valueOf(n41VarA2.a()) : null);
            logger2.finer(sb2.toString());
            if (n41VarA2 instanceof y41) {
                this.l.add((y41) n41VarA2);
            }
        }
    }

    public ByteBuffer f() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(g());
        ef0.i(byteBufferAllocate, 4);
        ef0.i(byteBufferAllocate, g() - 2);
        ef0.i(byteBufferAllocate, this.d);
        ef0.i(byteBufferAllocate, (this.e << 2) | (this.f << 1) | 1);
        ef0.f(byteBufferAllocate, this.g);
        ef0.g(byteBufferAllocate, this.h);
        ef0.g(byteBufferAllocate, this.i);
        m41 m41Var = this.k;
        if (m41Var != null) {
            byteBufferAllocate.put(m41Var.n().array());
        }
        return byteBufferAllocate;
    }

    public int g() {
        m41 m41Var = this.k;
        return (m41Var == null ? 0 : m41Var.o()) + 15;
    }

    public void h(m41 m41Var) {
        this.k = m41Var;
    }

    public void i(long j) {
        this.i = j;
    }

    public void j(int i) {
        this.g = i;
    }

    public void k(long j) {
        this.h = j;
    }

    public void l(int i) {
        this.d = i;
    }

    public void m(int i) {
        this.e = i;
    }

    @Override // dc.n41
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DecoderConfigDescriptor");
        sb.append("{objectTypeIndication=");
        sb.append(this.d);
        sb.append(", streamType=");
        sb.append(this.e);
        sb.append(", upStream=");
        sb.append(this.f);
        sb.append(", bufferSizeDB=");
        sb.append(this.g);
        sb.append(", maxBitRate=");
        sb.append(this.h);
        sb.append(", avgBitRate=");
        sb.append(this.i);
        sb.append(", decoderSpecificInfo=");
        sb.append(this.j);
        sb.append(", audioSpecificInfo=");
        sb.append(this.k);
        sb.append(", configDescriptorDeadBytes=");
        byte[] bArr = this.m;
        if (bArr == null) {
            bArr = new byte[0];
        }
        sb.append(bf0.a(bArr));
        sb.append(", profileLevelIndicationDescriptors=");
        List<y41> list = this.l;
        sb.append(list == null ? "null" : Arrays.asList(list).toString());
        sb.append(MessageFormatter.DELIM_STOP);
        return sb.toString();
    }
}

package dc;

import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonEncodingException;
import dc.qf1;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Objects;
import org.apache.commons.codec.language.bm.ResourceConstants;

/* compiled from: JsonUtf8Reader.java */
/* loaded from: classes3.dex */
public final class sf1 extends qf1 {
    public static final qd4 m = qd4.h("'\\");
    public static final qd4 n = qd4.h("\"\\");
    public static final qd4 o = qd4.h("{}[]:, \n\t\r\f/\\;#=");
    public static final qd4 p = qd4.h("\n\r");
    public static final qd4 q = qd4.h(ResourceConstants.EXT_CMT_END);
    public final pd4 g;
    public final nd4 h;
    public int i = 0;
    public long j;
    public int k;
    public String l;

    public sf1(pd4 pd4Var) {
        Objects.requireNonNull(pd4Var, "source == null");
        this.g = pd4Var;
        this.h = pd4Var.h();
        X(6);
    }

    @Override // dc.qf1
    public int A() throws IOException, NumberFormatException {
        int iK0 = this.i;
        if (iK0 == 0) {
            iK0 = k0();
        }
        if (iK0 == 16) {
            long j = this.j;
            int i = (int) j;
            if (j == i) {
                this.i = 0;
                int[] iArr = this.d;
                int i2 = this.a - 1;
                iArr[i2] = iArr[i2] + 1;
                return i;
            }
            throw new JsonDataException("Expected an int but was " + this.j + " at path " + getPath());
        }
        if (iK0 == 17) {
            this.l = this.h.X(this.k);
        } else if (iK0 == 9 || iK0 == 8) {
            String strQ0 = iK0 == 9 ? q0(n) : q0(m);
            this.l = strQ0;
            try {
                int i3 = Integer.parseInt(strQ0);
                this.i = 0;
                int[] iArr2 = this.d;
                int i4 = this.a - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return i3;
            } catch (NumberFormatException unused) {
            }
        } else if (iK0 != 11) {
            throw new JsonDataException("Expected an int but was " + O() + " at path " + getPath());
        }
        this.i = 11;
        try {
            double d = Double.parseDouble(this.l);
            int i5 = (int) d;
            if (i5 == d) {
                this.l = null;
                this.i = 0;
                int[] iArr3 = this.d;
                int i6 = this.a - 1;
                iArr3[i6] = iArr3[i6] + 1;
                return i5;
            }
            throw new JsonDataException("Expected an int but was " + this.l + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.l + " at path " + getPath());
        }
    }

    @Override // dc.qf1
    public long C() throws IOException, NumberFormatException {
        int iK0 = this.i;
        if (iK0 == 0) {
            iK0 = k0();
        }
        if (iK0 == 16) {
            this.i = 0;
            int[] iArr = this.d;
            int i = this.a - 1;
            iArr[i] = iArr[i] + 1;
            return this.j;
        }
        if (iK0 == 17) {
            this.l = this.h.X(this.k);
        } else if (iK0 == 9 || iK0 == 8) {
            String strQ0 = iK0 == 9 ? q0(n) : q0(m);
            this.l = strQ0;
            try {
                long j = Long.parseLong(strQ0);
                this.i = 0;
                int[] iArr2 = this.d;
                int i2 = this.a - 1;
                iArr2[i2] = iArr2[i2] + 1;
                return j;
            } catch (NumberFormatException unused) {
            }
        } else if (iK0 != 11) {
            throw new JsonDataException("Expected a long but was " + O() + " at path " + getPath());
        }
        this.i = 11;
        try {
            long jLongValueExact = new BigDecimal(this.l).longValueExact();
            this.l = null;
            this.i = 0;
            int[] iArr3 = this.d;
            int i3 = this.a - 1;
            iArr3[i3] = iArr3[i3] + 1;
            return jLongValueExact;
        } catch (ArithmeticException | NumberFormatException unused2) {
            throw new JsonDataException("Expected a long but was " + this.l + " at path " + getPath());
        }
    }

    @Override // dc.qf1
    public <T> T I() throws IOException {
        int iK0 = this.i;
        if (iK0 == 0) {
            iK0 = k0();
        }
        if (iK0 == 7) {
            this.i = 0;
            int[] iArr = this.d;
            int i = this.a - 1;
            iArr[i] = iArr[i] + 1;
            return null;
        }
        throw new JsonDataException("Expected null but was " + O() + " at path " + getPath());
    }

    @Override // dc.qf1
    public String K() throws IOException {
        String strX;
        int iK0 = this.i;
        if (iK0 == 0) {
            iK0 = k0();
        }
        if (iK0 == 10) {
            strX = r0();
        } else if (iK0 == 9) {
            strX = q0(n);
        } else if (iK0 == 8) {
            strX = q0(m);
        } else if (iK0 == 11) {
            strX = this.l;
            this.l = null;
        } else if (iK0 == 16) {
            strX = Long.toString(this.j);
        } else {
            if (iK0 != 17) {
                throw new JsonDataException("Expected a string but was " + O() + " at path " + getPath());
            }
            strX = this.h.X(this.k);
        }
        this.i = 0;
        int[] iArr = this.d;
        int i = this.a - 1;
        iArr[i] = iArr[i] + 1;
        return strX;
    }

    @Override // dc.qf1
    public qf1.b O() throws IOException {
        int iK0 = this.i;
        if (iK0 == 0) {
            iK0 = k0();
        }
        switch (iK0) {
            case 1:
                return qf1.b.BEGIN_OBJECT;
            case 2:
                return qf1.b.END_OBJECT;
            case 3:
                return qf1.b.BEGIN_ARRAY;
            case 4:
                return qf1.b.END_ARRAY;
            case 5:
            case 6:
                return qf1.b.BOOLEAN;
            case 7:
                return qf1.b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return qf1.b.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return qf1.b.NAME;
            case 16:
            case 17:
                return qf1.b.NUMBER;
            case 18:
                return qf1.b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // dc.qf1
    public void V() throws IOException {
        if (p()) {
            this.l = o0();
            this.i = 11;
        }
    }

    @Override // dc.qf1
    public void b() throws IOException {
        int iK0 = this.i;
        if (iK0 == 0) {
            iK0 = k0();
        }
        if (iK0 == 3) {
            X(1);
            this.d[this.a - 1] = 0;
            this.i = 0;
        } else {
            throw new JsonDataException("Expected BEGIN_ARRAY but was " + O() + " at path " + getPath());
        }
    }

    @Override // dc.qf1
    public int b0(qf1.a aVar) throws IOException {
        int iK0 = this.i;
        if (iK0 == 0) {
            iK0 = k0();
        }
        if (iK0 < 12 || iK0 > 15) {
            return -1;
        }
        if (iK0 == 15) {
            return l0(this.l, aVar);
        }
        int iC0 = this.g.c0(aVar.b);
        if (iC0 != -1) {
            this.i = 0;
            this.c[this.a - 1] = aVar.a[iC0];
            return iC0;
        }
        String str = this.c[this.a - 1];
        String strO0 = o0();
        int iL0 = l0(strO0, aVar);
        if (iL0 == -1) {
            this.i = 15;
            this.l = strO0;
            this.c[this.a - 1] = str;
        }
        return iL0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.i = 0;
        this.b[0] = 8;
        this.a = 1;
        this.h.b();
        this.g.close();
    }

    @Override // dc.qf1
    public int d0(qf1.a aVar) throws IOException {
        int iK0 = this.i;
        if (iK0 == 0) {
            iK0 = k0();
        }
        if (iK0 < 8 || iK0 > 11) {
            return -1;
        }
        if (iK0 == 11) {
            return m0(this.l, aVar);
        }
        int iC0 = this.g.c0(aVar.b);
        if (iC0 != -1) {
            this.i = 0;
            int[] iArr = this.d;
            int i = this.a - 1;
            iArr[i] = iArr[i] + 1;
            return iC0;
        }
        String strK = K();
        int iM0 = m0(strK, aVar);
        if (iM0 == -1) {
            this.i = 11;
            this.l = strK;
            this.d[this.a - 1] = r0[r1] - 1;
        }
        return iM0;
    }

    @Override // dc.qf1
    public void e() throws IOException {
        int iK0 = this.i;
        if (iK0 == 0) {
            iK0 = k0();
        }
        if (iK0 == 1) {
            X(3);
            this.i = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + O() + " at path " + getPath());
    }

    @Override // dc.qf1
    public void f() throws IOException {
        int iK0 = this.i;
        if (iK0 == 0) {
            iK0 = k0();
        }
        if (iK0 != 4) {
            throw new JsonDataException("Expected END_ARRAY but was " + O() + " at path " + getPath());
        }
        int i = this.a - 1;
        this.a = i;
        int[] iArr = this.d;
        int i2 = i - 1;
        iArr[i2] = iArr[i2] + 1;
        this.i = 0;
    }

    @Override // dc.qf1
    public void g0() throws IOException {
        if (this.f) {
            qf1.b bVarO = O();
            o0();
            throw new JsonDataException("Cannot skip unexpected " + bVarO + " at " + getPath());
        }
        int iK0 = this.i;
        if (iK0 == 0) {
            iK0 = k0();
        }
        if (iK0 == 14) {
            y0();
        } else if (iK0 == 13) {
            v0(n);
        } else if (iK0 == 12) {
            v0(m);
        } else if (iK0 != 15) {
            throw new JsonDataException("Expected a name but was " + O() + " at path " + getPath());
        }
        this.i = 0;
        this.c[this.a - 1] = "null";
    }

    @Override // dc.qf1
    public void h0() throws IOException {
        if (this.f) {
            throw new JsonDataException("Cannot skip unexpected " + O() + " at " + getPath());
        }
        int i = 0;
        do {
            int iK0 = this.i;
            if (iK0 == 0) {
                iK0 = k0();
            }
            if (iK0 == 3) {
                X(1);
            } else if (iK0 == 1) {
                X(3);
            } else {
                if (iK0 == 4) {
                    i--;
                    if (i < 0) {
                        throw new JsonDataException("Expected a value but was " + O() + " at path " + getPath());
                    }
                    this.a--;
                } else if (iK0 == 2) {
                    i--;
                    if (i < 0) {
                        throw new JsonDataException("Expected a value but was " + O() + " at path " + getPath());
                    }
                    this.a--;
                } else if (iK0 == 14 || iK0 == 10) {
                    y0();
                } else if (iK0 == 9 || iK0 == 13) {
                    v0(n);
                } else if (iK0 == 8 || iK0 == 12) {
                    v0(m);
                } else if (iK0 == 17) {
                    this.h.skip(this.k);
                } else if (iK0 == 18) {
                    throw new JsonDataException("Expected a value but was " + O() + " at path " + getPath());
                }
                this.i = 0;
            }
            i++;
            this.i = 0;
        } while (i != 0);
        int[] iArr = this.d;
        int i2 = this.a;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.c[i2 - 1] = "null";
    }

    @Override // dc.qf1
    public void j() throws IOException {
        int iK0 = this.i;
        if (iK0 == 0) {
            iK0 = k0();
        }
        if (iK0 != 2) {
            throw new JsonDataException("Expected END_OBJECT but was " + O() + " at path " + getPath());
        }
        int i = this.a - 1;
        this.a = i;
        this.c[i] = null;
        int[] iArr = this.d;
        int i2 = i - 1;
        iArr[i2] = iArr[i2] + 1;
        this.i = 0;
    }

    public final void j0() throws IOException {
        if (this.e) {
            return;
        }
        i0("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    public final int k0() throws IOException {
        int[] iArr = this.b;
        int i = this.a;
        int i2 = iArr[i - 1];
        if (i2 == 1) {
            iArr[i - 1] = 2;
        } else if (i2 == 2) {
            int iP0 = p0(true);
            this.h.readByte();
            if (iP0 != 44) {
                if (iP0 != 59) {
                    if (iP0 == 93) {
                        this.i = 4;
                        return 4;
                    }
                    i0("Unterminated array");
                    throw null;
                }
                j0();
            }
        } else {
            if (i2 == 3 || i2 == 5) {
                iArr[i - 1] = 4;
                if (i2 == 5) {
                    int iP02 = p0(true);
                    this.h.readByte();
                    if (iP02 != 44) {
                        if (iP02 != 59) {
                            if (iP02 == 125) {
                                this.i = 2;
                                return 2;
                            }
                            i0("Unterminated object");
                            throw null;
                        }
                        j0();
                    }
                }
                int iP03 = p0(true);
                if (iP03 == 34) {
                    this.h.readByte();
                    this.i = 13;
                    return 13;
                }
                if (iP03 == 39) {
                    this.h.readByte();
                    j0();
                    this.i = 12;
                    return 12;
                }
                if (iP03 != 125) {
                    j0();
                    if (n0((char) iP03)) {
                        this.i = 14;
                        return 14;
                    }
                    i0("Expected name");
                    throw null;
                }
                if (i2 == 5) {
                    i0("Expected name");
                    throw null;
                }
                this.h.readByte();
                this.i = 2;
                return 2;
            }
            if (i2 == 4) {
                iArr[i - 1] = 5;
                int iP04 = p0(true);
                this.h.readByte();
                if (iP04 != 58) {
                    if (iP04 != 61) {
                        i0("Expected ':'");
                        throw null;
                    }
                    j0();
                    if (this.g.request(1L) && this.h.q(0L) == 62) {
                        this.h.readByte();
                    }
                }
            } else if (i2 == 6) {
                iArr[i - 1] = 7;
            } else if (i2 == 7) {
                if (p0(false) == -1) {
                    this.i = 18;
                    return 18;
                }
                j0();
            } else if (i2 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iP05 = p0(true);
        if (iP05 == 34) {
            this.h.readByte();
            this.i = 9;
            return 9;
        }
        if (iP05 == 39) {
            j0();
            this.h.readByte();
            this.i = 8;
            return 8;
        }
        if (iP05 != 44 && iP05 != 59) {
            if (iP05 == 91) {
                this.h.readByte();
                this.i = 3;
                return 3;
            }
            if (iP05 != 93) {
                if (iP05 == 123) {
                    this.h.readByte();
                    this.i = 1;
                    return 1;
                }
                int iS0 = s0();
                if (iS0 != 0) {
                    return iS0;
                }
                int iT0 = t0();
                if (iT0 != 0) {
                    return iT0;
                }
                if (!n0(this.h.q(0L))) {
                    i0("Expected value");
                    throw null;
                }
                j0();
                this.i = 10;
                return 10;
            }
            if (i2 == 1) {
                this.h.readByte();
                this.i = 4;
                return 4;
            }
        }
        if (i2 != 1 && i2 != 2) {
            i0("Unexpected value");
            throw null;
        }
        j0();
        this.i = 7;
        return 7;
    }

    public final int l0(String str, qf1.a aVar) {
        int length = aVar.a.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(aVar.a[i])) {
                this.i = 0;
                this.c[this.a - 1] = str;
                return i;
            }
        }
        return -1;
    }

    public final int m0(String str, qf1.a aVar) {
        int length = aVar.a.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(aVar.a[i])) {
                this.i = 0;
                int[] iArr = this.d;
                int i2 = this.a - 1;
                iArr[i2] = iArr[i2] + 1;
                return i;
            }
        }
        return -1;
    }

    public final boolean n0(int i) throws IOException {
        if (i == 9 || i == 10 || i == 12 || i == 13 || i == 32) {
            return false;
        }
        if (i != 35) {
            if (i == 44) {
                return false;
            }
            if (i != 47 && i != 61) {
                if (i == 123 || i == 125 || i == 58) {
                    return false;
                }
                if (i != 59) {
                    switch (i) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        j0();
        return false;
    }

    public String o0() throws IOException {
        String strQ0;
        int iK0 = this.i;
        if (iK0 == 0) {
            iK0 = k0();
        }
        if (iK0 == 14) {
            strQ0 = r0();
        } else if (iK0 == 13) {
            strQ0 = q0(n);
        } else if (iK0 == 12) {
            strQ0 = q0(m);
        } else {
            if (iK0 != 15) {
                throw new JsonDataException("Expected a name but was " + O() + " at path " + getPath());
            }
            strQ0 = this.l;
        }
        this.i = 0;
        this.c[this.a - 1] = strQ0;
        return strQ0;
    }

    @Override // dc.qf1
    public boolean p() throws IOException {
        int iK0 = this.i;
        if (iK0 == 0) {
            iK0 = k0();
        }
        return (iK0 == 2 || iK0 == 4 || iK0 == 18) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r6.h.skip(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        if (r1 != 47) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        if (r6.g.request(2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        j0();
        r3 = r6.h.q(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
    
        if (r3 == 42) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        if (r3 == 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
    
        r6.h.readByte();
        r6.h.readByte();
        x0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
    
        r6.h.readByte();
        r6.h.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
    
        if (w0() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
    
        i0("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0073, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
    
        if (r1 != 35) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
    
        j0();
        x0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int p0(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            dc.pd4 r2 = r6.g
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L82
            dc.nd4 r2 = r6.h
            long r4 = (long) r1
            byte r1 = r2.q(r4)
            r2 = 10
            if (r1 == r2) goto L80
            r2 = 32
            if (r1 == r2) goto L80
            r2 = 13
            if (r1 == r2) goto L80
            r2 = 9
            if (r1 != r2) goto L25
            goto L80
        L25:
            dc.nd4 r2 = r6.h
            int r3 = r3 + (-1)
            long r3 = (long) r3
            r2.skip(r3)
            r2 = 47
            if (r1 != r2) goto L74
            dc.pd4 r3 = r6.g
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L3c
            return r1
        L3c:
            r6.j0()
            dc.nd4 r3 = r6.h
            r4 = 1
            byte r3 = r3.q(r4)
            r4 = 42
            if (r3 == r4) goto L5c
            if (r3 == r2) goto L4e
            return r1
        L4e:
            dc.nd4 r1 = r6.h
            r1.readByte()
            dc.nd4 r1 = r6.h
            r1.readByte()
            r6.x0()
            goto L1
        L5c:
            dc.nd4 r1 = r6.h
            r1.readByte()
            dc.nd4 r1 = r6.h
            r1.readByte()
            boolean r1 = r6.w0()
            if (r1 == 0) goto L6d
            goto L1
        L6d:
            java.lang.String r7 = "Unterminated comment"
            r6.i0(r7)
            r7 = 0
            throw r7
        L74:
            r2 = 35
            if (r1 != r2) goto L7f
            r6.j0()
            r6.x0()
            goto L1
        L7f:
            return r1
        L80:
            r1 = r3
            goto L2
        L82:
            if (r7 != 0) goto L86
            r7 = -1
            return r7
        L86:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.sf1.p0(boolean):int");
    }

    public final String q0(qd4 qd4Var) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long jK = this.g.k(qd4Var);
            if (jK == -1) {
                i0("Unterminated string");
                throw null;
            }
            if (this.h.q(jK) != 92) {
                if (sb == null) {
                    String strX = this.h.X(jK);
                    this.h.readByte();
                    return strX;
                }
                sb.append(this.h.X(jK));
                this.h.readByte();
                return sb.toString();
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(this.h.X(jK));
            this.h.readByte();
            sb.append(u0());
        }
    }

    public final String r0() throws IOException {
        long jK = this.g.k(o);
        return jK != -1 ? this.h.X(jK) : this.h.V();
    }

    public final int s0() throws IOException {
        int i;
        String str;
        String str2;
        byte bQ = this.h.q(0L);
        if (bQ == 116 || bQ == 84) {
            i = 5;
            str = "true";
            str2 = "TRUE";
        } else if (bQ == 102 || bQ == 70) {
            i = 6;
            str = "false";
            str2 = "FALSE";
        } else {
            if (bQ != 110 && bQ != 78) {
                return 0;
            }
            i = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        int i2 = 1;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (!this.g.request(i3)) {
                return 0;
            }
            byte bQ2 = this.h.q(i2);
            if (bQ2 != str.charAt(i2) && bQ2 != str2.charAt(i2)) {
                return 0;
            }
            i2 = i3;
        }
        if (this.g.request(length + 1) && n0(this.h.q(length))) {
            return 0;
        }
        this.h.skip(length);
        this.i = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0087, code lost:
    
        if (n0(r11) != false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0089, code lost:
    
        if (r6 != 2) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008b, code lost:
    
        if (r7 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0091, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0093, code lost:
    
        if (r10 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0097, code lost:
    
        if (r8 != 0) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0099, code lost:
    
        if (r10 != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x009b, code lost:
    
        if (r10 == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009e, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x009f, code lost:
    
        r16.j = r8;
        r16.h.skip(r5);
        r16.i = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ab, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ac, code lost:
    
        if (r6 == 2) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00af, code lost:
    
        if (r6 == 4) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00b2, code lost:
    
        if (r6 != 7) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b5, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b7, code lost:
    
        r16.k = r5;
        r16.i = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00bd, code lost:
    
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00be, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int t0() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.sf1.t0():int");
    }

    public String toString() {
        return "JsonReader(" + this.g + ")";
    }

    public final char u0() throws IOException {
        int i;
        int i2;
        if (!this.g.request(1L)) {
            i0("Unterminated escape sequence");
            throw null;
        }
        byte b = this.h.readByte();
        if (b == 10 || b == 34 || b == 39 || b == 47 || b == 92) {
            return (char) b;
        }
        if (b == 98) {
            return '\b';
        }
        if (b == 102) {
            return '\f';
        }
        if (b == 110) {
            return '\n';
        }
        if (b == 114) {
            return '\r';
        }
        if (b == 116) {
            return '\t';
        }
        if (b != 117) {
            if (this.e) {
                return (char) b;
            }
            i0("Invalid escape sequence: \\" + ((char) b));
            throw null;
        }
        if (!this.g.request(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + getPath());
        }
        char c = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            byte bQ = this.h.q(i3);
            char c2 = (char) (c << 4);
            if (bQ < 48 || bQ > 57) {
                if (bQ >= 97 && bQ <= 102) {
                    i = bQ - 97;
                } else {
                    if (bQ < 65 || bQ > 70) {
                        i0("\\u" + this.h.X(4L));
                        throw null;
                    }
                    i = bQ - 65;
                }
                i2 = i + 10;
            } else {
                i2 = bQ - 48;
            }
            c = (char) (c2 + i2);
        }
        this.h.skip(4L);
        return c;
    }

    public final void v0(qd4 qd4Var) throws IOException {
        while (true) {
            long jK = this.g.k(qd4Var);
            if (jK == -1) {
                i0("Unterminated string");
                throw null;
            }
            if (this.h.q(jK) != 92) {
                this.h.skip(jK + 1);
                return;
            } else {
                this.h.skip(jK + 1);
                u0();
            }
        }
    }

    public final boolean w0() throws IOException {
        long jG = this.g.g(q);
        boolean z = jG != -1;
        nd4 nd4Var = this.h;
        nd4Var.skip(z ? jG + r1.s() : nd4Var.f0());
        return z;
    }

    @Override // dc.qf1
    public boolean x() throws IOException {
        int iK0 = this.i;
        if (iK0 == 0) {
            iK0 = k0();
        }
        if (iK0 == 5) {
            this.i = 0;
            int[] iArr = this.d;
            int i = this.a - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iK0 == 6) {
            this.i = 0;
            int[] iArr2 = this.d;
            int i2 = this.a - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return false;
        }
        throw new JsonDataException("Expected a boolean but was " + O() + " at path " + getPath());
    }

    public final void x0() throws IOException {
        long jK = this.g.k(p);
        nd4 nd4Var = this.h;
        nd4Var.skip(jK != -1 ? jK + 1 : nd4Var.f0());
    }

    @Override // dc.qf1
    public double y() throws IOException, NumberFormatException {
        int iK0 = this.i;
        if (iK0 == 0) {
            iK0 = k0();
        }
        if (iK0 == 16) {
            this.i = 0;
            int[] iArr = this.d;
            int i = this.a - 1;
            iArr[i] = iArr[i] + 1;
            return this.j;
        }
        if (iK0 == 17) {
            this.l = this.h.X(this.k);
        } else if (iK0 == 9) {
            this.l = q0(n);
        } else if (iK0 == 8) {
            this.l = q0(m);
        } else if (iK0 == 10) {
            this.l = r0();
        } else if (iK0 != 11) {
            throw new JsonDataException("Expected a double but was " + O() + " at path " + getPath());
        }
        this.i = 11;
        try {
            double d = Double.parseDouble(this.l);
            if (this.e || !(Double.isNaN(d) || Double.isInfinite(d))) {
                this.l = null;
                this.i = 0;
                int[] iArr2 = this.d;
                int i2 = this.a - 1;
                iArr2[i2] = iArr2[i2] + 1;
                return d;
            }
            throw new JsonEncodingException("JSON forbids NaN and infinities: " + d + " at path " + getPath());
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.l + " at path " + getPath());
        }
    }

    public final void y0() throws IOException {
        long jK = this.g.k(o);
        nd4 nd4Var = this.h;
        if (jK == -1) {
            jK = nd4Var.f0();
        }
        nd4Var.skip(jK);
    }
}

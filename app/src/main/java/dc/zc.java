package dc;

import androidx.annotation.Nullable;
import dc.xc;
import java.io.EOFException;
import java.io.IOException;
import java.util.Objects;
import org.apache.commons.codec.language.bm.ResourceConstants;

/* compiled from: JsonUtf8Reader.java */
/* loaded from: classes.dex */
public final class zc extends xc {
    public static final qd4 n = qd4.h("'\\");
    public static final qd4 o = qd4.h("\"\\");
    public static final qd4 p = qd4.h("{}[]:, \n\t\r\f/\\;#=");
    public static final qd4 q = qd4.h("\n\r");
    public static final qd4 r = qd4.h(ResourceConstants.EXT_CMT_END);
    public final pd4 h;
    public final nd4 i;
    public int j = 0;
    public long k;
    public int l;

    @Nullable
    public String m;

    public zc(pd4 pd4Var) {
        Objects.requireNonNull(pd4Var, "source == null");
        this.h = pd4Var;
        this.i = pd4Var.a();
        L(6);
    }

    @Override // dc.xc
    public String A() throws IOException {
        String strJ0;
        int iF0 = this.j;
        if (iF0 == 0) {
            iF0 = f0();
        }
        if (iF0 == 14) {
            strJ0 = k0();
        } else if (iF0 == 13) {
            strJ0 = j0(o);
        } else if (iF0 == 12) {
            strJ0 = j0(n);
        } else {
            if (iF0 != 15) {
                throw new vc("Expected a name but was " + K() + " at path " + getPath());
            }
            strJ0 = this.m;
        }
        this.j = 0;
        this.c[this.a - 1] = strJ0;
        return strJ0;
    }

    @Override // dc.xc
    public String C() throws IOException {
        String strX;
        int iF0 = this.j;
        if (iF0 == 0) {
            iF0 = f0();
        }
        if (iF0 == 10) {
            strX = k0();
        } else if (iF0 == 9) {
            strX = j0(o);
        } else if (iF0 == 8) {
            strX = j0(n);
        } else if (iF0 == 11) {
            strX = this.m;
            this.m = null;
        } else if (iF0 == 16) {
            strX = Long.toString(this.k);
        } else {
            if (iF0 != 17) {
                throw new vc("Expected a string but was " + K() + " at path " + getPath());
            }
            strX = this.i.X(this.l);
        }
        this.j = 0;
        int[] iArr = this.d;
        int i = this.a - 1;
        iArr[i] = iArr[i] + 1;
        return strX;
    }

    @Override // dc.xc
    public xc.b K() throws IOException {
        int iF0 = this.j;
        if (iF0 == 0) {
            iF0 = f0();
        }
        switch (iF0) {
            case 1:
                return xc.b.BEGIN_OBJECT;
            case 2:
                return xc.b.END_OBJECT;
            case 3:
                return xc.b.BEGIN_ARRAY;
            case 4:
                return xc.b.END_ARRAY;
            case 5:
            case 6:
                return xc.b.BOOLEAN;
            case 7:
                return xc.b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return xc.b.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return xc.b.NAME;
            case 16:
            case 17:
                return xc.b.NUMBER;
            case 18:
                return xc.b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // dc.xc
    public int O(xc.a aVar) throws IOException {
        int iF0 = this.j;
        if (iF0 == 0) {
            iF0 = f0();
        }
        if (iF0 < 12 || iF0 > 15) {
            return -1;
        }
        if (iF0 == 15) {
            return g0(this.m, aVar);
        }
        int iC0 = this.h.c0(aVar.b);
        if (iC0 != -1) {
            this.j = 0;
            this.c[this.a - 1] = aVar.a[iC0];
            return iC0;
        }
        String str = this.c[this.a - 1];
        String strA = A();
        int iG0 = g0(strA, aVar);
        if (iG0 == -1) {
            this.j = 15;
            this.m = strA;
            this.c[this.a - 1] = str;
        }
        return iG0;
    }

    @Override // dc.xc
    public void V() throws IOException {
        if (this.f) {
            throw new vc("Cannot skip unexpected " + K() + " at " + getPath());
        }
        int iF0 = this.j;
        if (iF0 == 0) {
            iF0 = f0();
        }
        if (iF0 == 14) {
            r0();
        } else if (iF0 == 13) {
            o0(o);
        } else if (iF0 == 12) {
            o0(n);
        } else if (iF0 != 15) {
            throw new vc("Expected a name but was " + K() + " at path " + getPath());
        }
        this.j = 0;
        this.c[this.a - 1] = "null";
    }

    @Override // dc.xc
    public void X() throws IOException {
        if (this.f) {
            throw new vc("Cannot skip unexpected " + K() + " at " + getPath());
        }
        int i = 0;
        do {
            int iF0 = this.j;
            if (iF0 == 0) {
                iF0 = f0();
            }
            if (iF0 == 3) {
                L(1);
            } else if (iF0 == 1) {
                L(3);
            } else {
                if (iF0 == 4) {
                    i--;
                    if (i < 0) {
                        throw new vc("Expected a value but was " + K() + " at path " + getPath());
                    }
                    this.a--;
                } else if (iF0 == 2) {
                    i--;
                    if (i < 0) {
                        throw new vc("Expected a value but was " + K() + " at path " + getPath());
                    }
                    this.a--;
                } else if (iF0 == 14 || iF0 == 10) {
                    r0();
                } else if (iF0 == 9 || iF0 == 13) {
                    o0(o);
                } else if (iF0 == 8 || iF0 == 12) {
                    o0(n);
                } else if (iF0 == 17) {
                    this.i.skip(this.l);
                } else if (iF0 == 18) {
                    throw new vc("Expected a value but was " + K() + " at path " + getPath());
                }
                this.j = 0;
            }
            i++;
            this.j = 0;
        } while (i != 0);
        int[] iArr = this.d;
        int i2 = this.a;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.c[i2 - 1] = "null";
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.j = 0;
        this.b[0] = 8;
        this.a = 1;
        this.i.b();
        this.h.close();
    }

    @Override // dc.xc
    public void e() throws IOException {
        int iF0 = this.j;
        if (iF0 == 0) {
            iF0 = f0();
        }
        if (iF0 == 3) {
            L(1);
            this.d[this.a - 1] = 0;
            this.j = 0;
        } else {
            throw new vc("Expected BEGIN_ARRAY but was " + K() + " at path " + getPath());
        }
    }

    public final void e0() throws IOException {
        if (this.e) {
            return;
        }
        d0("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    @Override // dc.xc
    public void f() throws IOException {
        int iF0 = this.j;
        if (iF0 == 0) {
            iF0 = f0();
        }
        if (iF0 == 1) {
            L(3);
            this.j = 0;
            return;
        }
        throw new vc("Expected BEGIN_OBJECT but was " + K() + " at path " + getPath());
    }

    public final int f0() throws IOException {
        int[] iArr = this.b;
        int i = this.a;
        int i2 = iArr[i - 1];
        if (i2 == 1) {
            iArr[i - 1] = 2;
        } else if (i2 == 2) {
            int iI0 = i0(true);
            this.i.readByte();
            if (iI0 != 44) {
                if (iI0 != 59) {
                    if (iI0 == 93) {
                        this.j = 4;
                        return 4;
                    }
                    d0("Unterminated array");
                    throw null;
                }
                e0();
            }
        } else {
            if (i2 == 3 || i2 == 5) {
                iArr[i - 1] = 4;
                if (i2 == 5) {
                    int iI02 = i0(true);
                    this.i.readByte();
                    if (iI02 != 44) {
                        if (iI02 != 59) {
                            if (iI02 == 125) {
                                this.j = 2;
                                return 2;
                            }
                            d0("Unterminated object");
                            throw null;
                        }
                        e0();
                    }
                }
                int iI03 = i0(true);
                if (iI03 == 34) {
                    this.i.readByte();
                    this.j = 13;
                    return 13;
                }
                if (iI03 == 39) {
                    this.i.readByte();
                    e0();
                    this.j = 12;
                    return 12;
                }
                if (iI03 != 125) {
                    e0();
                    if (h0((char) iI03)) {
                        this.j = 14;
                        return 14;
                    }
                    d0("Expected name");
                    throw null;
                }
                if (i2 == 5) {
                    d0("Expected name");
                    throw null;
                }
                this.i.readByte();
                this.j = 2;
                return 2;
            }
            if (i2 == 4) {
                iArr[i - 1] = 5;
                int iI04 = i0(true);
                this.i.readByte();
                if (iI04 != 58) {
                    if (iI04 != 61) {
                        d0("Expected ':'");
                        throw null;
                    }
                    e0();
                    if (this.h.request(1L) && this.i.q(0L) == 62) {
                        this.i.readByte();
                    }
                }
            } else if (i2 == 6) {
                iArr[i - 1] = 7;
            } else if (i2 == 7) {
                if (i0(false) == -1) {
                    this.j = 18;
                    return 18;
                }
                e0();
            } else if (i2 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iI05 = i0(true);
        if (iI05 == 34) {
            this.i.readByte();
            this.j = 9;
            return 9;
        }
        if (iI05 == 39) {
            e0();
            this.i.readByte();
            this.j = 8;
            return 8;
        }
        if (iI05 != 44 && iI05 != 59) {
            if (iI05 == 91) {
                this.i.readByte();
                this.j = 3;
                return 3;
            }
            if (iI05 != 93) {
                if (iI05 == 123) {
                    this.i.readByte();
                    this.j = 1;
                    return 1;
                }
                int iL0 = l0();
                if (iL0 != 0) {
                    return iL0;
                }
                int iM0 = m0();
                if (iM0 != 0) {
                    return iM0;
                }
                if (!h0(this.i.q(0L))) {
                    d0("Expected value");
                    throw null;
                }
                e0();
                this.j = 10;
                return 10;
            }
            if (i2 == 1) {
                this.i.readByte();
                this.j = 4;
                return 4;
            }
        }
        if (i2 != 1 && i2 != 2) {
            d0("Unexpected value");
            throw null;
        }
        e0();
        this.j = 7;
        return 7;
    }

    public final int g0(String str, xc.a aVar) {
        int length = aVar.a.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(aVar.a[i])) {
                this.j = 0;
                this.c[this.a - 1] = str;
                return i;
            }
        }
        return -1;
    }

    public final boolean h0(int i) throws IOException {
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
        e0();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        r6.i.skip(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        if (r1 != 47) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        if (r6.h.request(2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        e0();
        r3 = r6.i.q(1);
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
    
        r6.i.readByte();
        r6.i.readByte();
        q0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
    
        r6.i.readByte();
        r6.i.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
    
        if (p0() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
    
        d0("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0073, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
    
        if (r1 != 35) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
    
        e0();
        q0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int i0(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            dc.pd4 r2 = r6.h
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L82
            dc.nd4 r2 = r6.i
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
            dc.nd4 r2 = r6.i
            int r3 = r3 + (-1)
            long r3 = (long) r3
            r2.skip(r3)
            r2 = 47
            if (r1 != r2) goto L74
            dc.pd4 r3 = r6.h
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L3c
            return r1
        L3c:
            r6.e0()
            dc.nd4 r3 = r6.i
            r4 = 1
            byte r3 = r3.q(r4)
            r4 = 42
            if (r3 == r4) goto L5c
            if (r3 == r2) goto L4e
            return r1
        L4e:
            dc.nd4 r1 = r6.i
            r1.readByte()
            dc.nd4 r1 = r6.i
            r1.readByte()
            r6.q0()
            goto L1
        L5c:
            dc.nd4 r1 = r6.i
            r1.readByte()
            dc.nd4 r1 = r6.i
            r1.readByte()
            boolean r1 = r6.p0()
            if (r1 == 0) goto L6d
            goto L1
        L6d:
            java.lang.String r7 = "Unterminated comment"
            r6.d0(r7)
            r7 = 0
            throw r7
        L74:
            r2 = 35
            if (r1 != r2) goto L7f
            r6.e0()
            r6.q0()
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
        throw new UnsupportedOperationException("Method not decompiled: dc.zc.i0(boolean):int");
    }

    @Override // dc.xc
    public void j() throws IOException {
        int iF0 = this.j;
        if (iF0 == 0) {
            iF0 = f0();
        }
        if (iF0 != 4) {
            throw new vc("Expected END_ARRAY but was " + K() + " at path " + getPath());
        }
        int i = this.a - 1;
        this.a = i;
        int[] iArr = this.d;
        int i2 = i - 1;
        iArr[i2] = iArr[i2] + 1;
        this.j = 0;
    }

    public final String j0(qd4 qd4Var) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long jK = this.h.k(qd4Var);
            if (jK == -1) {
                d0("Unterminated string");
                throw null;
            }
            if (this.i.q(jK) != 92) {
                if (sb == null) {
                    String strX = this.i.X(jK);
                    this.i.readByte();
                    return strX;
                }
                sb.append(this.i.X(jK));
                this.i.readByte();
                return sb.toString();
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(this.i.X(jK));
            this.i.readByte();
            sb.append(n0());
        }
    }

    public final String k0() throws IOException {
        long jK = this.h.k(p);
        return jK != -1 ? this.i.X(jK) : this.i.V();
    }

    public final int l0() throws IOException {
        int i;
        String str;
        String str2;
        byte bQ = this.i.q(0L);
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
            if (!this.h.request(i3)) {
                return 0;
            }
            byte bQ2 = this.i.q(i2);
            if (bQ2 != str.charAt(i2) && bQ2 != str2.charAt(i2)) {
                return 0;
            }
            i2 = i3;
        }
        if (this.h.request(length + 1) && h0(this.i.q(length))) {
            return 0;
        }
        this.i.skip(length);
        this.j = i;
        return i;
    }

    @Override // dc.xc
    public void m() throws IOException {
        int iF0 = this.j;
        if (iF0 == 0) {
            iF0 = f0();
        }
        if (iF0 != 2) {
            throw new vc("Expected END_OBJECT but was " + K() + " at path " + getPath());
        }
        int i = this.a - 1;
        this.a = i;
        this.c[i] = null;
        int[] iArr = this.d;
        int i2 = i - 1;
        iArr[i2] = iArr[i2] + 1;
        this.j = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0087, code lost:
    
        if (h0(r11) != false) goto L72;
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
    
        r16.k = r8;
        r16.i.skip(r5);
        r16.j = 16;
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
    
        r16.l = r5;
        r16.j = 17;
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
    public final int m0() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: dc.zc.m0():int");
    }

    public final char n0() throws IOException {
        int i;
        int i2;
        if (!this.h.request(1L)) {
            d0("Unterminated escape sequence");
            throw null;
        }
        byte b = this.i.readByte();
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
            d0("Invalid escape sequence: \\" + ((char) b));
            throw null;
        }
        if (!this.h.request(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + getPath());
        }
        char c = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            byte bQ = this.i.q(i3);
            char c2 = (char) (c << 4);
            if (bQ < 48 || bQ > 57) {
                if (bQ >= 97 && bQ <= 102) {
                    i = bQ - 97;
                } else {
                    if (bQ < 65 || bQ > 70) {
                        d0("\\u" + this.i.X(4L));
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
        this.i.skip(4L);
        return c;
    }

    public final void o0(qd4 qd4Var) throws IOException {
        while (true) {
            long jK = this.h.k(qd4Var);
            if (jK == -1) {
                d0("Unterminated string");
                throw null;
            }
            if (this.i.q(jK) != 92) {
                this.i.skip(jK + 1);
                return;
            } else {
                this.i.skip(jK + 1);
                n0();
            }
        }
    }

    @Override // dc.xc
    public boolean p() throws IOException {
        int iF0 = this.j;
        if (iF0 == 0) {
            iF0 = f0();
        }
        return (iF0 == 2 || iF0 == 4 || iF0 == 18) ? false : true;
    }

    public final boolean p0() throws IOException {
        long jG = this.h.g(r);
        boolean z = jG != -1;
        nd4 nd4Var = this.i;
        nd4Var.skip(z ? jG + r1.s() : nd4Var.f0());
        return z;
    }

    @Override // dc.xc
    public boolean q() throws IOException {
        int iF0 = this.j;
        if (iF0 == 0) {
            iF0 = f0();
        }
        if (iF0 == 5) {
            this.j = 0;
            int[] iArr = this.d;
            int i = this.a - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iF0 == 6) {
            this.j = 0;
            int[] iArr2 = this.d;
            int i2 = this.a - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return false;
        }
        throw new vc("Expected a boolean but was " + K() + " at path " + getPath());
    }

    public final void q0() throws IOException {
        long jK = this.h.k(q);
        nd4 nd4Var = this.i;
        nd4Var.skip(jK != -1 ? jK + 1 : nd4Var.f0());
    }

    public final void r0() throws IOException {
        long jK = this.h.k(p);
        nd4 nd4Var = this.i;
        if (jK == -1) {
            jK = nd4Var.f0();
        }
        nd4Var.skip(jK);
    }

    public String toString() {
        return "JsonReader(" + this.h + ")";
    }

    @Override // dc.xc
    public double x() throws IOException, NumberFormatException {
        int iF0 = this.j;
        if (iF0 == 0) {
            iF0 = f0();
        }
        if (iF0 == 16) {
            this.j = 0;
            int[] iArr = this.d;
            int i = this.a - 1;
            iArr[i] = iArr[i] + 1;
            return this.k;
        }
        if (iF0 == 17) {
            this.m = this.i.X(this.l);
        } else if (iF0 == 9) {
            this.m = j0(o);
        } else if (iF0 == 8) {
            this.m = j0(n);
        } else if (iF0 == 10) {
            this.m = k0();
        } else if (iF0 != 11) {
            throw new vc("Expected a double but was " + K() + " at path " + getPath());
        }
        this.j = 11;
        try {
            double d = Double.parseDouble(this.m);
            if (this.e || !(Double.isNaN(d) || Double.isInfinite(d))) {
                this.m = null;
                this.j = 0;
                int[] iArr2 = this.d;
                int i2 = this.a - 1;
                iArr2[i2] = iArr2[i2] + 1;
                return d;
            }
            throw new wc("JSON forbids NaN and infinities: " + d + " at path " + getPath());
        } catch (NumberFormatException unused) {
            throw new vc("Expected a double but was " + this.m + " at path " + getPath());
        }
    }

    @Override // dc.xc
    public int y() throws IOException, NumberFormatException {
        int iF0 = this.j;
        if (iF0 == 0) {
            iF0 = f0();
        }
        if (iF0 == 16) {
            long j = this.k;
            int i = (int) j;
            if (j == i) {
                this.j = 0;
                int[] iArr = this.d;
                int i2 = this.a - 1;
                iArr[i2] = iArr[i2] + 1;
                return i;
            }
            throw new vc("Expected an int but was " + this.k + " at path " + getPath());
        }
        if (iF0 == 17) {
            this.m = this.i.X(this.l);
        } else if (iF0 == 9 || iF0 == 8) {
            String strJ0 = iF0 == 9 ? j0(o) : j0(n);
            this.m = strJ0;
            try {
                int i3 = Integer.parseInt(strJ0);
                this.j = 0;
                int[] iArr2 = this.d;
                int i4 = this.a - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return i3;
            } catch (NumberFormatException unused) {
            }
        } else if (iF0 != 11) {
            throw new vc("Expected an int but was " + K() + " at path " + getPath());
        }
        this.j = 11;
        try {
            double d = Double.parseDouble(this.m);
            int i5 = (int) d;
            if (i5 == d) {
                this.m = null;
                this.j = 0;
                int[] iArr3 = this.d;
                int i6 = this.a - 1;
                iArr3[i6] = iArr3[i6] + 1;
                return i5;
            }
            throw new vc("Expected an int but was " + this.m + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new vc("Expected an int but was " + this.m + " at path " + getPath());
        }
    }
}

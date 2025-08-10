package com.broadcom.bt.util.mime4j.field.address.parser;

import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Vector;

/* loaded from: classes.dex */
public class AddressListParser implements AddressListParserTreeConstants, AddressListParserConstants {
    private static int[] jj_la1_0;
    private static int[] jj_la1_1;
    private final JJCalls[] jj_2_rtns;
    private int jj_endpos;
    private Vector jj_expentries;
    private int[] jj_expentry;
    private int jj_gc;
    private int jj_gen;
    public SimpleCharStream jj_input_stream;
    private int jj_kind;
    private int jj_la;
    private final int[] jj_la1;
    private Token jj_lastpos;
    private int[] jj_lasttokens;
    private final LookaheadSuccess jj_ls;
    public Token jj_nt;
    private int jj_ntk;
    private boolean jj_rescan;
    private Token jj_scanpos;
    private boolean jj_semLA;
    public JJTAddressListParserState jjtree;
    public boolean lookingAhead;
    public Token token;
    public AddressListParserTokenManager token_source;

    public static final class JJCalls {
        public int arg;
        public Token first;
        public int gen;
        public JJCalls next;
    }

    public static final class LookaheadSuccess extends Error {
        private LookaheadSuccess() {
        }
    }

    static {
        jj_la1_0();
        jj_la1_1();
    }

    public AddressListParser(InputStream inputStream) {
        this(inputStream, null);
    }

    private final boolean jj_2_1(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return true ^ jj_3_1();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(0, i);
        }
    }

    private final boolean jj_2_2(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            return !jj_3_2();
        } catch (LookaheadSuccess unused) {
            return true;
        } finally {
            jj_save(1, i);
        }
    }

    private final boolean jj_3R_10() {
        Token token = this.jj_scanpos;
        if (!jj_3R_12()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_scan_token(18);
    }

    private final boolean jj_3R_11() {
        Token token = this.jj_scanpos;
        if (jj_scan_token(9)) {
            this.jj_scanpos = token;
        }
        Token token2 = this.jj_scanpos;
        if (!jj_scan_token(14)) {
            return false;
        }
        this.jj_scanpos = token2;
        return jj_scan_token(31);
    }

    private final boolean jj_3R_12() {
        Token token;
        if (jj_scan_token(14)) {
            return true;
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_13());
        this.jj_scanpos = token;
        return false;
    }

    private final boolean jj_3R_13() {
        Token token = this.jj_scanpos;
        if (jj_scan_token(9)) {
            this.jj_scanpos = token;
        }
        return jj_scan_token(14);
    }

    private final boolean jj_3R_8() {
        return jj_3R_9() || jj_scan_token(8) || jj_3R_10();
    }

    private final boolean jj_3R_9() {
        Token token;
        Token token2 = this.jj_scanpos;
        if (jj_scan_token(14)) {
            this.jj_scanpos = token2;
            if (jj_scan_token(31)) {
                return true;
            }
        }
        do {
            token = this.jj_scanpos;
        } while (!jj_3R_11());
        this.jj_scanpos = token;
        return false;
    }

    private final boolean jj_3_1() {
        return jj_3R_8();
    }

    private final boolean jj_3_2() {
        return jj_3R_8();
    }

    private void jj_add_error_token(int i, int i2) {
        if (i2 >= 100) {
            return;
        }
        int i3 = this.jj_endpos;
        if (i2 == i3 + 1) {
            int[] iArr = this.jj_lasttokens;
            this.jj_endpos = i3 + 1;
            iArr[i3] = i;
            return;
        }
        if (i3 != 0) {
            this.jj_expentry = new int[i3];
            for (int i4 = 0; i4 < this.jj_endpos; i4++) {
                this.jj_expentry[i4] = this.jj_lasttokens[i4];
            }
            Enumeration enumerationElements = this.jj_expentries.elements();
            boolean z = false;
            while (enumerationElements.hasMoreElements()) {
                int[] iArr2 = (int[]) enumerationElements.nextElement();
                if (iArr2.length == this.jj_expentry.length) {
                    int i5 = 0;
                    while (true) {
                        int[] iArr3 = this.jj_expentry;
                        if (i5 >= iArr3.length) {
                            z = true;
                            break;
                        } else {
                            if (iArr2[i5] != iArr3[i5]) {
                                z = false;
                                break;
                            }
                            i5++;
                        }
                    }
                    if (z) {
                        break;
                    }
                }
            }
            if (!z) {
                this.jj_expentries.addElement(this.jj_expentry);
            }
            if (i2 != 0) {
                int[] iArr4 = this.jj_lasttokens;
                this.jj_endpos = i2;
                iArr4[i2 - 1] = i;
            }
        }
    }

    private final Token jj_consume_token(int i) throws ParseException {
        Token token = this.token;
        Token token2 = token.next;
        if (token2 != null) {
            this.token = token2;
        } else {
            Token nextToken = this.token_source.getNextToken();
            token.next = nextToken;
            this.token = nextToken;
        }
        this.jj_ntk = -1;
        if (this.token.kind != i) {
            this.token = token;
            this.jj_kind = i;
            throw generateParseException();
        }
        this.jj_gen++;
        int i2 = this.jj_gc + 1;
        this.jj_gc = i2;
        if (i2 > 100) {
            int i3 = 0;
            this.jj_gc = 0;
            while (true) {
                JJCalls[] jJCallsArr = this.jj_2_rtns;
                if (i3 >= jJCallsArr.length) {
                    break;
                }
                for (JJCalls jJCalls = jJCallsArr[i3]; jJCalls != null; jJCalls = jJCalls.next) {
                    if (jJCalls.gen < this.jj_gen) {
                        jJCalls.first = null;
                    }
                }
                i3++;
            }
        }
        return this.token;
    }

    private static void jj_la1_0() {
        jj_la1_0 = new int[]{2, -2147467200, 8, -2147467200, 80, -2147467200, -2147467200, -2147467200, 8, -2147467200, 256, 264, 8, -2147467264, -2147467264, -2147467264, -2147466752, 512, -2147467264, 16896, 512, 278528};
    }

    private static void jj_la1_1() {
        jj_la1_1 = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    private final int jj_ntk() {
        Token token = this.token;
        Token token2 = token.next;
        this.jj_nt = token2;
        if (token2 != null) {
            int i = token2.kind;
            this.jj_ntk = i;
            return i;
        }
        Token nextToken = this.token_source.getNextToken();
        token.next = nextToken;
        int i2 = nextToken.kind;
        this.jj_ntk = i2;
        return i2;
    }

    private final void jj_rescan_token() {
        this.jj_rescan = true;
        for (int i = 0; i < 2; i++) {
            try {
                JJCalls jJCalls = this.jj_2_rtns[i];
                do {
                    if (jJCalls.gen > this.jj_gen) {
                        this.jj_la = jJCalls.arg;
                        Token token = jJCalls.first;
                        this.jj_scanpos = token;
                        this.jj_lastpos = token;
                        if (i == 0) {
                            jj_3_1();
                        } else if (i == 1) {
                            jj_3_2();
                        }
                    }
                    jJCalls = jJCalls.next;
                } while (jJCalls != null);
            } catch (LookaheadSuccess unused) {
            }
        }
        this.jj_rescan = false;
    }

    private final void jj_save(int i, int i2) {
        JJCalls jJCalls = this.jj_2_rtns[i];
        while (true) {
            if (jJCalls.gen <= this.jj_gen) {
                break;
            }
            JJCalls jJCalls2 = jJCalls.next;
            if (jJCalls2 == null) {
                JJCalls jJCalls3 = new JJCalls();
                jJCalls.next = jJCalls3;
                jJCalls = jJCalls3;
                break;
            }
            jJCalls = jJCalls2;
        }
        jJCalls.gen = (this.jj_gen + i2) - this.jj_la;
        jJCalls.first = this.token;
        jJCalls.arg = i2;
    }

    private final boolean jj_scan_token(int i) {
        Token token = this.jj_scanpos;
        if (token == this.jj_lastpos) {
            this.jj_la--;
            Token token2 = token.next;
            if (token2 == null) {
                Token nextToken = this.token_source.getNextToken();
                token.next = nextToken;
                this.jj_scanpos = nextToken;
                this.jj_lastpos = nextToken;
            } else {
                this.jj_scanpos = token2;
                this.jj_lastpos = token2;
            }
        } else {
            this.jj_scanpos = token.next;
        }
        if (this.jj_rescan) {
            Token token3 = this.token;
            int i2 = 0;
            while (token3 != null && token3 != this.jj_scanpos) {
                i2++;
                token3 = token3.next;
            }
            if (token3 != null) {
                jj_add_error_token(i, i2);
            }
        }
        Token token4 = this.jj_scanpos;
        if (token4.kind != i) {
            return true;
        }
        if (this.jj_la == 0 && token4 == this.jj_lastpos) {
            throw this.jj_ls;
        }
        return false;
    }

    private static void log(String str) {
        System.out.print(str);
    }

    public static void main(String[] strArr) throws Throwable {
        while (true) {
            try {
                AddressListParser addressListParser = new AddressListParser(System.in);
                addressListParser.parseLine();
                ((SimpleNode) addressListParser.jjtree.rootNode()).dump("> ");
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public void ReInit(InputStream inputStream) {
        ReInit(inputStream, null);
    }

    public final void addr_spec() throws Throwable {
        boolean z;
        ASTaddr_spec aSTaddr_spec = new ASTaddr_spec(9);
        this.jjtree.openNodeScope(aSTaddr_spec);
        jjtreeOpenNodeScope(aSTaddr_spec);
        try {
            local_part();
            jj_consume_token(8);
            domain();
            this.jjtree.closeNodeScope((Node) aSTaddr_spec, true);
            jjtreeCloseNodeScope(aSTaddr_spec);
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(aSTaddr_spec);
                z = false;
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
            try {
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                if (!(th instanceof ParseException)) {
                    throw ((Error) th);
                }
                throw ((ParseException) th);
            } catch (Throwable th3) {
                th = th3;
                if (z) {
                    this.jjtree.closeNodeScope((Node) aSTaddr_spec, true);
                    jjtreeCloseNodeScope(aSTaddr_spec);
                }
                throw th;
            }
        }
    }

    public final void address() throws Throwable {
        boolean z;
        ASTaddress aSTaddress = new ASTaddress(2);
        this.jjtree.openNodeScope(aSTaddress);
        jjtreeOpenNodeScope(aSTaddress);
        try {
            if (jj_2_1(Integer.MAX_VALUE)) {
                addr_spec();
            } else {
                int iJj_ntk = this.jj_ntk;
                if (iJj_ntk == -1) {
                    iJj_ntk = jj_ntk();
                }
                if (iJj_ntk != 6) {
                    if (iJj_ntk != 14 && iJj_ntk != 31) {
                        this.jj_la1[5] = this.jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                    }
                    phrase();
                    int iJj_ntk2 = this.jj_ntk;
                    if (iJj_ntk2 == -1) {
                        iJj_ntk2 = jj_ntk();
                    }
                    if (iJj_ntk2 == 4) {
                        group_body();
                    } else {
                        if (iJj_ntk2 != 6) {
                            this.jj_la1[4] = this.jj_gen;
                            jj_consume_token(-1);
                            throw new ParseException();
                        }
                        angle_addr();
                    }
                } else {
                    angle_addr();
                }
            }
            this.jjtree.closeNodeScope((Node) aSTaddress, true);
            jjtreeCloseNodeScope(aSTaddress);
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(aSTaddress);
                z = false;
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
            try {
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                if (!(th instanceof ParseException)) {
                    throw ((Error) th);
                }
                throw ((ParseException) th);
            } catch (Throwable th3) {
                th = th3;
                if (z) {
                    this.jjtree.closeNodeScope((Node) aSTaddress, true);
                    jjtreeCloseNodeScope(aSTaddress);
                }
                throw th;
            }
        }
    }

    public final void address_list() throws Throwable {
        boolean z;
        ASTaddress_list aSTaddress_list = new ASTaddress_list(1);
        this.jjtree.openNodeScope(aSTaddress_list);
        jjtreeOpenNodeScope(aSTaddress_list);
        try {
            int iJj_ntk = this.jj_ntk;
            if (iJj_ntk == -1) {
                iJj_ntk = jj_ntk();
            }
            if (iJj_ntk == 6 || iJj_ntk == 14 || iJj_ntk == 31) {
                address();
            } else {
                this.jj_la1[1] = this.jj_gen;
            }
            while (true) {
                int iJj_ntk2 = this.jj_ntk;
                if (iJj_ntk2 == -1) {
                    iJj_ntk2 = jj_ntk();
                }
                if (iJj_ntk2 != 3) {
                    this.jj_la1[2] = this.jj_gen;
                    this.jjtree.closeNodeScope((Node) aSTaddress_list, true);
                    jjtreeCloseNodeScope(aSTaddress_list);
                    return;
                }
                jj_consume_token(3);
                int iJj_ntk3 = this.jj_ntk;
                if (iJj_ntk3 == -1) {
                    iJj_ntk3 = jj_ntk();
                }
                if (iJj_ntk3 == 6 || iJj_ntk3 == 14 || iJj_ntk3 == 31) {
                    address();
                } else {
                    this.jj_la1[3] = this.jj_gen;
                }
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(aSTaddress_list);
                z = false;
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
            try {
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                if (!(th instanceof ParseException)) {
                    throw ((Error) th);
                }
                throw ((ParseException) th);
            } catch (Throwable th3) {
                th = th3;
                if (z) {
                    this.jjtree.closeNodeScope((Node) aSTaddress_list, true);
                    jjtreeCloseNodeScope(aSTaddress_list);
                }
                throw th;
            }
        }
    }

    public final void angle_addr() throws Throwable {
        boolean z;
        ASTangle_addr aSTangle_addr = new ASTangle_addr(6);
        this.jjtree.openNodeScope(aSTangle_addr);
        jjtreeOpenNodeScope(aSTangle_addr);
        try {
            jj_consume_token(6);
            int iJj_ntk = this.jj_ntk;
            if (iJj_ntk == -1) {
                iJj_ntk = jj_ntk();
            }
            if (iJj_ntk != 8) {
                this.jj_la1[10] = this.jj_gen;
            } else {
                route();
            }
            addr_spec();
            jj_consume_token(7);
            this.jjtree.closeNodeScope((Node) aSTangle_addr, true);
            jjtreeCloseNodeScope(aSTangle_addr);
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(aSTangle_addr);
                z = false;
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
            try {
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                if (!(th instanceof ParseException)) {
                    throw ((Error) th);
                }
                throw ((ParseException) th);
            } catch (Throwable th3) {
                th = th3;
                if (z) {
                    this.jjtree.closeNodeScope((Node) aSTangle_addr, true);
                    jjtreeCloseNodeScope(aSTangle_addr);
                }
                throw th;
            }
        }
    }

    public final void disable_tracing() {
    }

    public final void domain() throws ParseException {
        ASTdomain aSTdomain = new ASTdomain(11);
        this.jjtree.openNodeScope(aSTdomain);
        jjtreeOpenNodeScope(aSTdomain);
        try {
            int iJj_ntk = this.jj_ntk;
            if (iJj_ntk == -1) {
                iJj_ntk = jj_ntk();
            }
            if (iJj_ntk == 14) {
                Token tokenJj_consume_token = jj_consume_token(14);
                while (true) {
                    int iJj_ntk2 = this.jj_ntk;
                    if (iJj_ntk2 == -1) {
                        iJj_ntk2 = jj_ntk();
                    }
                    if (iJj_ntk2 != 9 && iJj_ntk2 != 14) {
                        this.jj_la1[19] = this.jj_gen;
                        break;
                    }
                    int iJj_ntk3 = this.jj_ntk;
                    if (iJj_ntk3 == -1) {
                        iJj_ntk3 = jj_ntk();
                    }
                    if (iJj_ntk3 != 9) {
                        this.jj_la1[20] = this.jj_gen;
                    } else {
                        tokenJj_consume_token = jj_consume_token(9);
                    }
                    String str = tokenJj_consume_token.image;
                    if (str.charAt(str.length() - 1) != '.') {
                        throw new ParseException("Atoms in domain names must be separated by '.'");
                    }
                    tokenJj_consume_token = jj_consume_token(14);
                }
            } else {
                if (iJj_ntk != 18) {
                    this.jj_la1[21] = this.jj_gen;
                    jj_consume_token(-1);
                    throw new ParseException();
                }
                jj_consume_token(18);
            }
        } finally {
            this.jjtree.closeNodeScope((Node) aSTdomain, true);
            jjtreeCloseNodeScope(aSTdomain);
        }
    }

    public final void enable_tracing() {
    }

    public ParseException generateParseException() {
        this.jj_expentries.removeAllElements();
        boolean[] zArr = new boolean[34];
        for (int i = 0; i < 34; i++) {
            zArr[i] = false;
        }
        int i2 = this.jj_kind;
        if (i2 >= 0) {
            zArr[i2] = true;
            this.jj_kind = -1;
        }
        for (int i3 = 0; i3 < 22; i3++) {
            if (this.jj_la1[i3] == this.jj_gen) {
                for (int i4 = 0; i4 < 32; i4++) {
                    int i5 = 1 << i4;
                    if ((jj_la1_0[i3] & i5) != 0) {
                        zArr[i4] = true;
                    }
                    if ((jj_la1_1[i3] & i5) != 0) {
                        zArr[i4 + 32] = true;
                    }
                }
            }
        }
        for (int i6 = 0; i6 < 34; i6++) {
            if (zArr[i6]) {
                int[] iArr = {i6};
                this.jj_expentry = iArr;
                this.jj_expentries.addElement(iArr);
            }
        }
        this.jj_endpos = 0;
        jj_rescan_token();
        jj_add_error_token(0, 0);
        int[][] iArr2 = new int[this.jj_expentries.size()][];
        for (int i7 = 0; i7 < this.jj_expentries.size(); i7++) {
            iArr2[i7] = (int[]) this.jj_expentries.elementAt(i7);
        }
        return new ParseException(this.token, iArr2, AddressListParserConstants.tokenImage);
    }

    public final Token getNextToken() {
        Token token = this.token;
        Token token2 = token.next;
        if (token2 != null) {
            this.token = token2;
        } else {
            Token nextToken = this.token_source.getNextToken();
            token.next = nextToken;
            this.token = nextToken;
        }
        this.jj_ntk = -1;
        this.jj_gen++;
        return this.token;
    }

    public final Token getToken(int i) {
        Token token = this.lookingAhead ? this.jj_scanpos : this.token;
        for (int i2 = 0; i2 < i; i2++) {
            Token nextToken = token.next;
            if (nextToken == null) {
                nextToken = this.token_source.getNextToken();
                token.next = nextToken;
            }
            token = nextToken;
        }
        return token;
    }

    public final void group_body() throws Throwable {
        boolean z;
        ASTgroup_body aSTgroup_body = new ASTgroup_body(5);
        this.jjtree.openNodeScope(aSTgroup_body);
        jjtreeOpenNodeScope(aSTgroup_body);
        try {
            jj_consume_token(4);
            int iJj_ntk = this.jj_ntk;
            if (iJj_ntk == -1) {
                iJj_ntk = jj_ntk();
            }
            if (iJj_ntk == 6 || iJj_ntk == 14 || iJj_ntk == 31) {
                mailbox();
            } else {
                this.jj_la1[7] = this.jj_gen;
            }
            while (true) {
                int iJj_ntk2 = this.jj_ntk;
                if (iJj_ntk2 == -1) {
                    iJj_ntk2 = jj_ntk();
                }
                if (iJj_ntk2 != 3) {
                    this.jj_la1[8] = this.jj_gen;
                    jj_consume_token(5);
                    this.jjtree.closeNodeScope((Node) aSTgroup_body, true);
                    jjtreeCloseNodeScope(aSTgroup_body);
                    return;
                }
                jj_consume_token(3);
                int iJj_ntk3 = this.jj_ntk;
                if (iJj_ntk3 == -1) {
                    iJj_ntk3 = jj_ntk();
                }
                if (iJj_ntk3 == 6 || iJj_ntk3 == 14 || iJj_ntk3 == 31) {
                    mailbox();
                } else {
                    this.jj_la1[9] = this.jj_gen;
                }
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(aSTgroup_body);
                z = false;
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
            try {
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                if (!(th instanceof ParseException)) {
                    throw ((Error) th);
                }
                throw ((ParseException) th);
            } catch (Throwable th3) {
                th = th3;
                if (z) {
                    this.jjtree.closeNodeScope((Node) aSTgroup_body, true);
                    jjtreeCloseNodeScope(aSTgroup_body);
                }
                throw th;
            }
        }
    }

    public void jjtreeCloseNodeScope(Node node) {
        ((SimpleNode) node).lastToken = getToken(0);
    }

    public void jjtreeOpenNodeScope(Node node) {
        ((SimpleNode) node).firstToken = getToken(1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x00b4, code lost:
    
        throw new com.broadcom.bt.util.mime4j.field.address.parser.ParseException("Words in local part must be separated by '.'");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void local_part() throws com.broadcom.bt.util.mime4j.field.address.parser.ParseException {
        /*
            r9 = this;
            com.broadcom.bt.util.mime4j.field.address.parser.ASTlocal_part r0 = new com.broadcom.bt.util.mime4j.field.address.parser.ASTlocal_part
            r1 = 10
            r0.<init>(r1)
            com.broadcom.bt.util.mime4j.field.address.parser.JJTAddressListParserState r1 = r9.jjtree
            r1.openNodeScope(r0)
            r9.jjtreeOpenNodeScope(r0)
            r1 = 1
            int r2 = r9.jj_ntk     // Catch: java.lang.Throwable -> Lb5
            r3 = -1
            if (r2 != r3) goto L19
            int r2 = r9.jj_ntk()     // Catch: java.lang.Throwable -> Lb5
        L19:
            r4 = 14
            r5 = 31
            if (r2 == r4) goto L37
            if (r2 != r5) goto L26
            com.broadcom.bt.util.mime4j.field.address.parser.Token r2 = r9.jj_consume_token(r5)     // Catch: java.lang.Throwable -> Lb5
            goto L3b
        L26:
            int[] r2 = r9.jj_la1     // Catch: java.lang.Throwable -> Lb5
            r4 = 15
            int r5 = r9.jj_gen     // Catch: java.lang.Throwable -> Lb5
            r2[r4] = r5     // Catch: java.lang.Throwable -> Lb5
            r9.jj_consume_token(r3)     // Catch: java.lang.Throwable -> Lb5
            com.broadcom.bt.util.mime4j.field.address.parser.ParseException r2 = new com.broadcom.bt.util.mime4j.field.address.parser.ParseException     // Catch: java.lang.Throwable -> Lb5
            r2.<init>()     // Catch: java.lang.Throwable -> Lb5
            throw r2     // Catch: java.lang.Throwable -> Lb5
        L37:
            com.broadcom.bt.util.mime4j.field.address.parser.Token r2 = r9.jj_consume_token(r4)     // Catch: java.lang.Throwable -> Lb5
        L3b:
            int r6 = r9.jj_ntk     // Catch: java.lang.Throwable -> Lb5
            if (r6 != r3) goto L43
            int r6 = r9.jj_ntk()     // Catch: java.lang.Throwable -> Lb5
        L43:
            r7 = 9
            if (r6 == r7) goto L5c
            if (r6 == r4) goto L5c
            if (r6 == r5) goto L5c
            int[] r2 = r9.jj_la1     // Catch: java.lang.Throwable -> Lb5
            r3 = 16
            int r4 = r9.jj_gen     // Catch: java.lang.Throwable -> Lb5
            r2[r3] = r4     // Catch: java.lang.Throwable -> Lb5
            com.broadcom.bt.util.mime4j.field.address.parser.JJTAddressListParserState r2 = r9.jjtree
            r2.closeNodeScope(r0, r1)
            r9.jjtreeCloseNodeScope(r0)
            return
        L5c:
            int r6 = r9.jj_ntk     // Catch: java.lang.Throwable -> Lb5
            if (r6 != r3) goto L64
            int r6 = r9.jj_ntk()     // Catch: java.lang.Throwable -> Lb5
        L64:
            if (r6 == r7) goto L6f
            int[] r6 = r9.jj_la1     // Catch: java.lang.Throwable -> Lb5
            r7 = 17
            int r8 = r9.jj_gen     // Catch: java.lang.Throwable -> Lb5
            r6[r7] = r8     // Catch: java.lang.Throwable -> Lb5
            goto L73
        L6f:
            com.broadcom.bt.util.mime4j.field.address.parser.Token r2 = r9.jj_consume_token(r7)     // Catch: java.lang.Throwable -> Lb5
        L73:
            java.lang.String r6 = r2.image     // Catch: java.lang.Throwable -> Lb5
            int r7 = r6.length()     // Catch: java.lang.Throwable -> Lb5
            int r7 = r7 - r1
            char r6 = r6.charAt(r7)     // Catch: java.lang.Throwable -> Lb5
            r7 = 46
            if (r6 != r7) goto Lad
            int r2 = r2.kind     // Catch: java.lang.Throwable -> Lb5
            if (r2 == r5) goto Lad
            int r2 = r9.jj_ntk     // Catch: java.lang.Throwable -> Lb5
            if (r2 != r3) goto L8e
            int r2 = r9.jj_ntk()     // Catch: java.lang.Throwable -> Lb5
        L8e:
            if (r2 == r4) goto La8
            if (r2 != r5) goto L97
            com.broadcom.bt.util.mime4j.field.address.parser.Token r2 = r9.jj_consume_token(r5)     // Catch: java.lang.Throwable -> Lb5
            goto L3b
        L97:
            int[] r2 = r9.jj_la1     // Catch: java.lang.Throwable -> Lb5
            r4 = 18
            int r5 = r9.jj_gen     // Catch: java.lang.Throwable -> Lb5
            r2[r4] = r5     // Catch: java.lang.Throwable -> Lb5
            r9.jj_consume_token(r3)     // Catch: java.lang.Throwable -> Lb5
            com.broadcom.bt.util.mime4j.field.address.parser.ParseException r2 = new com.broadcom.bt.util.mime4j.field.address.parser.ParseException     // Catch: java.lang.Throwable -> Lb5
            r2.<init>()     // Catch: java.lang.Throwable -> Lb5
            throw r2     // Catch: java.lang.Throwable -> Lb5
        La8:
            com.broadcom.bt.util.mime4j.field.address.parser.Token r2 = r9.jj_consume_token(r4)     // Catch: java.lang.Throwable -> Lb5
            goto L3b
        Lad:
            com.broadcom.bt.util.mime4j.field.address.parser.ParseException r2 = new com.broadcom.bt.util.mime4j.field.address.parser.ParseException     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r3 = "Words in local part must be separated by '.'"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lb5
            throw r2     // Catch: java.lang.Throwable -> Lb5
        Lb5:
            r2 = move-exception
            com.broadcom.bt.util.mime4j.field.address.parser.JJTAddressListParserState r3 = r9.jjtree
            r3.closeNodeScope(r0, r1)
            r9.jjtreeCloseNodeScope(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.broadcom.bt.util.mime4j.field.address.parser.AddressListParser.local_part():void");
    }

    public final void mailbox() throws Throwable {
        boolean z;
        ASTmailbox aSTmailbox = new ASTmailbox(3);
        this.jjtree.openNodeScope(aSTmailbox);
        jjtreeOpenNodeScope(aSTmailbox);
        try {
            if (jj_2_2(Integer.MAX_VALUE)) {
                addr_spec();
            } else {
                int iJj_ntk = this.jj_ntk;
                if (iJj_ntk == -1) {
                    iJj_ntk = jj_ntk();
                }
                if (iJj_ntk != 6) {
                    if (iJj_ntk != 14 && iJj_ntk != 31) {
                        this.jj_la1[6] = this.jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                    }
                    name_addr();
                } else {
                    angle_addr();
                }
            }
            this.jjtree.closeNodeScope((Node) aSTmailbox, true);
            jjtreeCloseNodeScope(aSTmailbox);
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(aSTmailbox);
                z = false;
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
            try {
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                if (!(th instanceof ParseException)) {
                    throw ((Error) th);
                }
                throw ((ParseException) th);
            } catch (Throwable th3) {
                th = th3;
                if (z) {
                    this.jjtree.closeNodeScope((Node) aSTmailbox, true);
                    jjtreeCloseNodeScope(aSTmailbox);
                }
                throw th;
            }
        }
    }

    public final void name_addr() throws Throwable {
        boolean z;
        ASTname_addr aSTname_addr = new ASTname_addr(4);
        this.jjtree.openNodeScope(aSTname_addr);
        jjtreeOpenNodeScope(aSTname_addr);
        try {
            phrase();
            angle_addr();
            this.jjtree.closeNodeScope((Node) aSTname_addr, true);
            jjtreeCloseNodeScope(aSTname_addr);
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(aSTname_addr);
                z = false;
            } catch (Throwable th2) {
                th = th2;
                z = true;
            }
            try {
                if (th instanceof RuntimeException) {
                    throw ((RuntimeException) th);
                }
                if (!(th instanceof ParseException)) {
                    throw ((Error) th);
                }
                throw ((ParseException) th);
            } catch (Throwable th3) {
                th = th3;
                if (z) {
                    this.jjtree.closeNodeScope((Node) aSTname_addr, true);
                    jjtreeCloseNodeScope(aSTname_addr);
                }
                throw th;
            }
        }
    }

    public ASTaddress_list parse() throws Throwable {
        try {
            parseAll();
            return (ASTaddress_list) this.jjtree.rootNode();
        } catch (TokenMgrError e) {
            throw new ParseException(e.getMessage());
        }
    }

    public final void parseAll() throws Throwable {
        address_list();
        jj_consume_token(0);
    }

    public final void parseLine() throws Throwable {
        address_list();
        int iJj_ntk = this.jj_ntk;
        if (iJj_ntk == -1) {
            iJj_ntk = jj_ntk();
        }
        if (iJj_ntk != 1) {
            this.jj_la1[0] = this.jj_gen;
        } else {
            jj_consume_token(1);
        }
        jj_consume_token(2);
    }

    public final void phrase() throws ParseException {
        ASTphrase aSTphrase = new ASTphrase(8);
        this.jjtree.openNodeScope(aSTphrase);
        jjtreeOpenNodeScope(aSTphrase);
        while (true) {
            try {
                int iJj_ntk = this.jj_ntk;
                if (iJj_ntk == -1) {
                    iJj_ntk = jj_ntk();
                }
                if (iJj_ntk == 14) {
                    jj_consume_token(14);
                } else {
                    if (iJj_ntk != 31) {
                        this.jj_la1[13] = this.jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                    }
                    jj_consume_token(31);
                }
                int iJj_ntk2 = this.jj_ntk;
                if (iJj_ntk2 == -1) {
                    iJj_ntk2 = jj_ntk();
                }
                if (iJj_ntk2 != 14 && iJj_ntk2 != 31) {
                    this.jj_la1[14] = this.jj_gen;
                    return;
                }
            } finally {
                this.jjtree.closeNodeScope((Node) aSTphrase, true);
                jjtreeCloseNodeScope(aSTphrase);
            }
        }
    }

    public final void route() throws Throwable {
        boolean z;
        ASTroute aSTroute = new ASTroute(7);
        this.jjtree.openNodeScope(aSTroute);
        jjtreeOpenNodeScope(aSTroute);
        try {
            jj_consume_token(8);
            domain();
            while (true) {
                int iJj_ntk = this.jj_ntk;
                if (iJj_ntk == -1) {
                    iJj_ntk = jj_ntk();
                }
                if (iJj_ntk != 3 && iJj_ntk != 8) {
                    this.jj_la1[11] = this.jj_gen;
                    jj_consume_token(4);
                    this.jjtree.closeNodeScope((Node) aSTroute, true);
                    jjtreeCloseNodeScope(aSTroute);
                    return;
                }
                while (true) {
                    int iJj_ntk2 = this.jj_ntk;
                    if (iJj_ntk2 == -1) {
                        iJj_ntk2 = jj_ntk();
                    }
                    if (iJj_ntk2 != 3) {
                        break;
                    } else {
                        jj_consume_token(3);
                    }
                }
                this.jj_la1[12] = this.jj_gen;
                jj_consume_token(8);
                domain();
            }
        } catch (Throwable th) {
            try {
                this.jjtree.clearNodeScope(aSTroute);
                z = false;
                try {
                    if (th instanceof RuntimeException) {
                        throw ((RuntimeException) th);
                    }
                    if (!(th instanceof ParseException)) {
                        throw ((Error) th);
                    }
                    throw ((ParseException) th);
                } catch (Throwable th2) {
                    th = th2;
                    if (z) {
                        this.jjtree.closeNodeScope((Node) aSTroute, true);
                        jjtreeCloseNodeScope(aSTroute);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                z = true;
            }
        }
    }

    public AddressListParser(InputStream inputStream, String str) {
        this.jjtree = new JJTAddressListParserState();
        int i = 0;
        this.lookingAhead = false;
        this.jj_la1 = new int[22];
        this.jj_2_rtns = new JJCalls[2];
        this.jj_rescan = false;
        this.jj_gc = 0;
        this.jj_ls = new LookaheadSuccess();
        this.jj_expentries = new Vector();
        this.jj_kind = -1;
        this.jj_lasttokens = new int[100];
        try {
            this.jj_input_stream = new SimpleCharStream(inputStream, str, 1, 1);
            this.token_source = new AddressListParserTokenManager(this.jj_input_stream);
            this.token = new Token();
            this.jj_ntk = -1;
            this.jj_gen = 0;
            for (int i2 = 0; i2 < 22; i2++) {
                this.jj_la1[i2] = -1;
            }
            while (true) {
                JJCalls[] jJCallsArr = this.jj_2_rtns;
                if (i >= jJCallsArr.length) {
                    return;
                }
                jJCallsArr[i] = new JJCalls();
                i++;
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public void ReInit(InputStream inputStream, String str) {
        try {
            this.jj_input_stream.ReInit(inputStream, str, 1, 1);
            this.token_source.ReInit(this.jj_input_stream);
            this.token = new Token();
            this.jj_ntk = -1;
            this.jjtree.reset();
            int i = 0;
            this.jj_gen = 0;
            for (int i2 = 0; i2 < 22; i2++) {
                this.jj_la1[i2] = -1;
            }
            while (true) {
                JJCalls[] jJCallsArr = this.jj_2_rtns;
                if (i >= jJCallsArr.length) {
                    return;
                }
                jJCallsArr[i] = new JJCalls();
                i++;
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public void ReInit(Reader reader) {
        this.jj_input_stream.ReInit(reader, 1, 1);
        this.token_source.ReInit(this.jj_input_stream);
        this.token = new Token();
        this.jj_ntk = -1;
        this.jjtree.reset();
        int i = 0;
        this.jj_gen = 0;
        for (int i2 = 0; i2 < 22; i2++) {
            this.jj_la1[i2] = -1;
        }
        while (true) {
            JJCalls[] jJCallsArr = this.jj_2_rtns;
            if (i >= jJCallsArr.length) {
                return;
            }
            jJCallsArr[i] = new JJCalls();
            i++;
        }
    }

    public void ReInit(AddressListParserTokenManager addressListParserTokenManager) {
        this.token_source = addressListParserTokenManager;
        this.token = new Token();
        this.jj_ntk = -1;
        this.jjtree.reset();
        int i = 0;
        this.jj_gen = 0;
        for (int i2 = 0; i2 < 22; i2++) {
            this.jj_la1[i2] = -1;
        }
        while (true) {
            JJCalls[] jJCallsArr = this.jj_2_rtns;
            if (i >= jJCallsArr.length) {
                return;
            }
            jJCallsArr[i] = new JJCalls();
            i++;
        }
    }

    public AddressListParser(Reader reader) {
        this.jjtree = new JJTAddressListParserState();
        int i = 0;
        this.lookingAhead = false;
        this.jj_la1 = new int[22];
        this.jj_2_rtns = new JJCalls[2];
        this.jj_rescan = false;
        this.jj_gc = 0;
        this.jj_ls = new LookaheadSuccess();
        this.jj_expentries = new Vector();
        this.jj_kind = -1;
        this.jj_lasttokens = new int[100];
        this.jj_input_stream = new SimpleCharStream(reader, 1, 1);
        this.token_source = new AddressListParserTokenManager(this.jj_input_stream);
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (int i2 = 0; i2 < 22; i2++) {
            this.jj_la1[i2] = -1;
        }
        while (true) {
            JJCalls[] jJCallsArr = this.jj_2_rtns;
            if (i >= jJCallsArr.length) {
                return;
            }
            jJCallsArr[i] = new JJCalls();
            i++;
        }
    }

    public AddressListParser(AddressListParserTokenManager addressListParserTokenManager) {
        this.jjtree = new JJTAddressListParserState();
        int i = 0;
        this.lookingAhead = false;
        this.jj_la1 = new int[22];
        this.jj_2_rtns = new JJCalls[2];
        this.jj_rescan = false;
        this.jj_gc = 0;
        this.jj_ls = new LookaheadSuccess();
        this.jj_expentries = new Vector();
        this.jj_kind = -1;
        this.jj_lasttokens = new int[100];
        this.token_source = addressListParserTokenManager;
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (int i2 = 0; i2 < 22; i2++) {
            this.jj_la1[i2] = -1;
        }
        while (true) {
            JJCalls[] jJCallsArr = this.jj_2_rtns;
            if (i >= jJCallsArr.length) {
                return;
            }
            jJCallsArr[i] = new JJCalls();
            i++;
        }
    }
}

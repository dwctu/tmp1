package com.broadcom.bt.util.mime4j.field.contenttype.parser;

import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Vector;

/* loaded from: classes.dex */
public class ContentTypeParser implements ContentTypeParserConstants {
    private static int[] jj_la1_0;
    private Vector jj_expentries;
    private int[] jj_expentry;
    private int jj_gen;
    public SimpleCharStream jj_input_stream;
    private int jj_kind;
    private final int[] jj_la1;
    public Token jj_nt;
    private int jj_ntk;
    private ArrayList paramNames;
    private ArrayList paramValues;
    private String subtype;
    public Token token;
    public ContentTypeParserTokenManager token_source;
    private String type;

    static {
        jj_la1_0();
    }

    public ContentTypeParser(InputStream inputStream) {
        this(inputStream, null);
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
        Token token3 = this.token;
        if (token3.kind == i) {
            this.jj_gen++;
            return token3;
        }
        this.token = token;
        this.jj_kind = i;
        throw generateParseException();
    }

    private static void jj_la1_0() {
        jj_la1_0 = new int[]{2, 16, 2621440};
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

    public static void main(String[] strArr) throws ParseException {
        while (true) {
            try {
                new ContentTypeParser(System.in).parseLine();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    public void ReInit(InputStream inputStream) {
        ReInit(inputStream, null);
    }

    public final void disable_tracing() {
    }

    public final void enable_tracing() {
    }

    public ParseException generateParseException() {
        this.jj_expentries.removeAllElements();
        boolean[] zArr = new boolean[24];
        for (int i = 0; i < 24; i++) {
            zArr[i] = false;
        }
        int i2 = this.jj_kind;
        if (i2 >= 0) {
            zArr[i2] = true;
            this.jj_kind = -1;
        }
        for (int i3 = 0; i3 < 3; i3++) {
            if (this.jj_la1[i3] == this.jj_gen) {
                for (int i4 = 0; i4 < 32; i4++) {
                    if ((jj_la1_0[i3] & (1 << i4)) != 0) {
                        zArr[i4] = true;
                    }
                }
            }
        }
        for (int i5 = 0; i5 < 24; i5++) {
            if (zArr[i5]) {
                int[] iArr = {i5};
                this.jj_expentry = iArr;
                this.jj_expentries.addElement(iArr);
            }
        }
        int[][] iArr2 = new int[this.jj_expentries.size()][];
        for (int i6 = 0; i6 < this.jj_expentries.size(); i6++) {
            iArr2[i6] = (int[]) this.jj_expentries.elementAt(i6);
        }
        return new ParseException(this.token, iArr2, ContentTypeParserConstants.tokenImage);
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

    public ArrayList getParamNames() {
        return this.paramNames;
    }

    public ArrayList getParamValues() {
        return this.paramValues;
    }

    public String getSubType() {
        return this.subtype;
    }

    public final Token getToken(int i) {
        Token token = this.token;
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

    public String getType() {
        return this.type;
    }

    public final void parameter() throws ParseException {
        Token tokenJj_consume_token = jj_consume_token(21);
        jj_consume_token(5);
        String strValue = value();
        this.paramNames.add(tokenJj_consume_token.image);
        this.paramValues.add(strValue);
    }

    public final void parse() throws ParseException {
        Token tokenJj_consume_token = jj_consume_token(21);
        jj_consume_token(3);
        Token tokenJj_consume_token2 = jj_consume_token(21);
        this.type = tokenJj_consume_token.image;
        this.subtype = tokenJj_consume_token2.image;
        while (true) {
            int iJj_ntk = this.jj_ntk;
            if (iJj_ntk == -1) {
                iJj_ntk = jj_ntk();
            }
            if (iJj_ntk != 4) {
                this.jj_la1[1] = this.jj_gen;
                return;
            } else {
                jj_consume_token(4);
                parameter();
            }
        }
    }

    public final void parseAll() throws ParseException {
        parse();
        jj_consume_token(0);
    }

    public final void parseLine() throws ParseException {
        parse();
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

    public final String value() throws ParseException {
        Token tokenJj_consume_token;
        int iJj_ntk = this.jj_ntk;
        if (iJj_ntk == -1) {
            iJj_ntk = jj_ntk();
        }
        if (iJj_ntk == 19) {
            tokenJj_consume_token = jj_consume_token(19);
        } else {
            if (iJj_ntk != 21) {
                this.jj_la1[2] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            }
            tokenJj_consume_token = jj_consume_token(21);
        }
        return tokenJj_consume_token.image;
    }

    public ContentTypeParser(InputStream inputStream, String str) {
        this.paramNames = new ArrayList();
        this.paramValues = new ArrayList();
        this.jj_la1 = new int[3];
        this.jj_expentries = new Vector();
        this.jj_kind = -1;
        try {
            this.jj_input_stream = new SimpleCharStream(inputStream, str, 1, 1);
            this.token_source = new ContentTypeParserTokenManager(this.jj_input_stream);
            this.token = new Token();
            this.jj_ntk = -1;
            this.jj_gen = 0;
            for (int i = 0; i < 3; i++) {
                this.jj_la1[i] = -1;
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
            this.jj_gen = 0;
            for (int i = 0; i < 3; i++) {
                this.jj_la1[i] = -1;
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
        this.jj_gen = 0;
        for (int i = 0; i < 3; i++) {
            this.jj_la1[i] = -1;
        }
    }

    public ContentTypeParser(Reader reader) {
        this.paramNames = new ArrayList();
        this.paramValues = new ArrayList();
        this.jj_la1 = new int[3];
        this.jj_expentries = new Vector();
        this.jj_kind = -1;
        this.jj_input_stream = new SimpleCharStream(reader, 1, 1);
        this.token_source = new ContentTypeParserTokenManager(this.jj_input_stream);
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (int i = 0; i < 3; i++) {
            this.jj_la1[i] = -1;
        }
    }

    public void ReInit(ContentTypeParserTokenManager contentTypeParserTokenManager) {
        this.token_source = contentTypeParserTokenManager;
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (int i = 0; i < 3; i++) {
            this.jj_la1[i] = -1;
        }
    }

    public ContentTypeParser(ContentTypeParserTokenManager contentTypeParserTokenManager) {
        this.paramNames = new ArrayList();
        this.paramValues = new ArrayList();
        this.jj_la1 = new int[3];
        this.jj_expentries = new Vector();
        this.jj_kind = -1;
        this.token_source = contentTypeParserTokenManager;
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (int i = 0; i < 3; i++) {
            this.jj_la1[i] = -1;
        }
    }
}

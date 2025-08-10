package org.jivesoftware.smackx.xhtmlim;

import io.agora.rtc2.video.VideoCaptureFormat;
import org.jivesoftware.smack.util.XmlStringBuilder;

/* loaded from: classes5.dex */
public class XHTMLText {
    public static final String A = "a";
    public static final String BLOCKQUOTE = "blockquote";
    public static final String BR = "br";
    public static final String CITE = "cite";
    public static final String CODE = "code";
    public static final String EM = "em";
    public static final String H = "h";
    public static final String HREF = "href";
    public static final String IMG = "img";
    public static final String LI = "li";
    public static final String NAMESPACE = "http://www.w3.org/1999/xhtml";
    public static final String OL = "ol";
    public static final String P = "p";
    public static final String Q = "q";
    public static final String SPAN = "span";
    public static final String STRONG = "strong";
    public static final String STYLE = "style";
    public static final String UL = "ul";
    private final XmlStringBuilder text = new XmlStringBuilder();

    public XHTMLText(String str, String str2) {
        appendOpenBodyTag(str, str2);
    }

    private XHTMLText appendOpenBodyTag(String str, String str2) {
        this.text.halfOpenElement("body");
        this.text.xmlnsAttribute(NAMESPACE);
        this.text.optElement("style", str);
        this.text.xmllangAttribute(str2);
        this.text.rightAngleBracket();
        return this;
    }

    public XHTMLText append(String str) {
        this.text.escape(str);
        return this;
    }

    public XHTMLText appendBrTag() {
        this.text.emptyElement("br");
        return this;
    }

    public XHTMLText appendCloseAnchorTag() {
        this.text.closeElement("a");
        return this;
    }

    public XHTMLText appendCloseBlockQuoteTag() {
        this.text.closeElement(BLOCKQUOTE);
        return this;
    }

    public XHTMLText appendCloseBodyTag() {
        this.text.closeElement("body");
        return this;
    }

    public XHTMLText appendCloseCodeTag() {
        this.text.closeElement(CODE);
        return this;
    }

    public XHTMLText appendCloseEmTag() {
        this.text.closeElement(EM);
        return this;
    }

    public XHTMLText appendCloseHeaderTag(int i) {
        if (i > 3 || i < 1) {
            throw new IllegalArgumentException("Level must be between 1 and 3");
        }
        this.text.closeElement(H + Integer.toBinaryString(i));
        return this;
    }

    public XHTMLText appendCloseInlinedQuoteTag() {
        this.text.closeElement(Q);
        return this;
    }

    public XHTMLText appendCloseLineItemTag() {
        this.text.closeElement(LI);
        return this;
    }

    public XHTMLText appendCloseOrderedListTag() {
        this.text.closeElement(OL);
        return this;
    }

    public XHTMLText appendCloseParagraphTag() {
        this.text.closeElement("p");
        return this;
    }

    public XHTMLText appendCloseSpanTag() {
        this.text.closeElement("span");
        return this;
    }

    public XHTMLText appendCloseStrongTag() {
        this.text.closeElement(STRONG);
        return this;
    }

    public XHTMLText appendCloseUnorderedListTag() {
        this.text.closeElement(UL);
        return this;
    }

    public XHTMLText appendImageTag(String str, String str2, String str3, String str4, String str5) {
        this.text.halfOpenElement(IMG);
        this.text.optAttribute("align", str);
        this.text.optAttribute("alt", str2);
        this.text.optAttribute(VideoCaptureFormat.keyHeight, str3);
        this.text.optAttribute("src", str4);
        this.text.optAttribute(VideoCaptureFormat.keyWidth, str5);
        this.text.rightAngleBracket();
        return this;
    }

    public XHTMLText appendLineItemTag(String str) {
        this.text.halfOpenElement(LI);
        this.text.optAttribute("style", str);
        this.text.rightAngleBracket();
        return this;
    }

    public XHTMLText appendOpenAnchorTag(String str, String str2) {
        this.text.halfOpenElement("a");
        this.text.optAttribute(HREF, str);
        this.text.optAttribute("style", str2);
        this.text.rightAngleBracket();
        return this;
    }

    public XHTMLText appendOpenBlockQuoteTag(String str) {
        this.text.halfOpenElement(BLOCKQUOTE);
        this.text.optAttribute("style", str);
        this.text.rightAngleBracket();
        return this;
    }

    public XHTMLText appendOpenCiteTag() {
        this.text.openElement(CITE);
        return this;
    }

    public XHTMLText appendOpenCodeTag() {
        this.text.openElement(CODE);
        return this;
    }

    public XHTMLText appendOpenEmTag() {
        this.text.openElement(EM);
        return this;
    }

    public XHTMLText appendOpenHeaderTag(int i, String str) {
        if (i > 3 || i < 1) {
            throw new IllegalArgumentException("Level must be between 1 and 3");
        }
        this.text.halfOpenElement(H + Integer.toString(i));
        this.text.optAttribute("style", str);
        this.text.rightAngleBracket();
        return this;
    }

    public XHTMLText appendOpenInlinedQuoteTag(String str) {
        this.text.halfOpenElement(Q);
        this.text.optAttribute("style", str);
        this.text.rightAngleBracket();
        return this;
    }

    public XHTMLText appendOpenOrderedListTag(String str) {
        this.text.halfOpenElement(OL);
        this.text.optAttribute("style", str);
        this.text.rightAngleBracket();
        return this;
    }

    public XHTMLText appendOpenParagraphTag(String str) {
        this.text.halfOpenElement("p");
        this.text.optAttribute("style", str);
        this.text.rightAngleBracket();
        return this;
    }

    public XHTMLText appendOpenSpanTag(String str) {
        this.text.halfOpenElement("span");
        this.text.optAttribute("style", str);
        this.text.rightAngleBracket();
        return this;
    }

    public XHTMLText appendOpenStrongTag() {
        this.text.openElement(STRONG);
        return this;
    }

    public XHTMLText appendOpenUnorderedListTag(String str) {
        this.text.halfOpenElement(UL);
        this.text.optAttribute("style", str);
        this.text.rightAngleBracket();
        return this;
    }

    public String toString() {
        return this.text.toString();
    }

    public XmlStringBuilder toXML() {
        return this.text;
    }
}

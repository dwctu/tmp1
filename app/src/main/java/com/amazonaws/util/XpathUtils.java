package com.amazonaws.util;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/* loaded from: classes.dex */
public class XpathUtils {
    public static Log a = LogFactory.b(XpathUtils.class);
    public static DocumentBuilderFactory b = DocumentBuilderFactory.newInstance();

    public static Node a(String str, Node node) throws XPathExpressionException {
        if (node == null) {
            return null;
        }
        return (Node) g().evaluate(str, node, XPathConstants.NODE);
    }

    public static String b(String str, Node node) throws XPathExpressionException {
        return e(str, node);
    }

    public static Document c(InputStream inputStream) throws ParserConfigurationException, SAXException, IOException {
        NamespaceRemovingInputStream namespaceRemovingInputStream = new NamespaceRemovingInputStream(inputStream);
        Document document = b.newDocumentBuilder().parse(namespaceRemovingInputStream);
        namespaceRemovingInputStream.close();
        return document;
    }

    public static Document d(String str) throws ParserConfigurationException, SAXException, IOException {
        return c(new ByteArrayInputStream(str.getBytes(StringUtils.a)));
    }

    public static String e(String str, Node node) throws XPathExpressionException {
        if (f(node)) {
            return null;
        }
        if (".".equals(str) || a(str, node) != null) {
            return g().evaluate(str, node).trim();
        }
        return null;
    }

    public static boolean f(Node node) {
        return node == null;
    }

    public static XPath g() {
        return XPathFactory.newInstance().newXPath();
    }
}

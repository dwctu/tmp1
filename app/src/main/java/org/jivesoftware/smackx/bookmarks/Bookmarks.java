package org.jivesoftware.smackx.bookmarks;

import com.epicgames.unreal.psoservices.PSOProgramService;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.iqprivate.packet.PrivateData;
import org.jivesoftware.smackx.iqprivate.provider.PrivateDataProvider;
import org.jivesoftware.smackx.nick.packet.Nick;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class Bookmarks implements PrivateData {
    public static final String ELEMENT = "storage";
    public static final String NAMESPACE = "storage:bookmarks";
    private List<BookmarkedURL> bookmarkedURLS = new ArrayList();
    private List<BookmarkedConference> bookmarkedConferences = new ArrayList();

    public static class Provider implements PrivateDataProvider {
        @Override // org.jivesoftware.smackx.iqprivate.provider.PrivateDataProvider
        public PrivateData parsePrivateData(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            Bookmarks bookmarks = new Bookmarks();
            boolean z = false;
            while (!z) {
                int next = xmlPullParser.next();
                if (next == 2 && ImagesContract.URL.equals(xmlPullParser.getName())) {
                    BookmarkedURL uRLStorage = Bookmarks.getURLStorage(xmlPullParser);
                    if (uRLStorage != null) {
                        bookmarks.addBookmarkedURL(uRLStorage);
                    }
                } else if (next == 2 && "conference".equals(xmlPullParser.getName())) {
                    bookmarks.addBookmarkedConference(Bookmarks.getConferenceStorage(xmlPullParser));
                } else if (next == 3 && Bookmarks.ELEMENT.equals(xmlPullParser.getName())) {
                    z = true;
                }
            }
            return bookmarks;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BookmarkedConference getConferenceStorage(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue("", "name");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "autojoin");
        BookmarkedConference bookmarkedConference = new BookmarkedConference(xmlPullParser.getAttributeValue("", PSOProgramService.JobID_Key));
        bookmarkedConference.setName(attributeValue);
        bookmarkedConference.setAutoJoin(Boolean.valueOf(attributeValue2).booleanValue());
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2 && Nick.ELEMENT_NAME.equals(xmlPullParser.getName())) {
                bookmarkedConference.setNickname(xmlPullParser.nextText());
            } else if (next == 2 && "password".equals(xmlPullParser.getName())) {
                bookmarkedConference.setPassword(xmlPullParser.nextText());
            } else if (next == 2 && "shared_bookmark".equals(xmlPullParser.getName())) {
                bookmarkedConference.setShared(true);
            } else if (next == 3 && "conference".equals(xmlPullParser.getName())) {
                z = true;
            }
        }
        return bookmarkedConference;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BookmarkedURL getURLStorage(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue("", "name");
        String attributeValue2 = xmlPullParser.getAttributeValue("", ImagesContract.URL);
        String attributeValue3 = xmlPullParser.getAttributeValue("", "rss");
        boolean z = false;
        BookmarkedURL bookmarkedURL = new BookmarkedURL(attributeValue2, attributeValue, attributeValue3 != null && "true".equals(attributeValue3));
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2 && "shared_bookmark".equals(xmlPullParser.getName())) {
                bookmarkedURL.setShared(true);
            } else if (next == 3 && ImagesContract.URL.equals(xmlPullParser.getName())) {
                z = true;
            }
        }
        return bookmarkedURL;
    }

    public void addBookmarkedConference(BookmarkedConference bookmarkedConference) {
        this.bookmarkedConferences.add(bookmarkedConference);
    }

    public void addBookmarkedURL(BookmarkedURL bookmarkedURL) {
        this.bookmarkedURLS.add(bookmarkedURL);
    }

    public void clearBookmarkedConferences() {
        this.bookmarkedConferences.clear();
    }

    public void clearBookmarkedURLS() {
        this.bookmarkedURLS.clear();
    }

    public List<BookmarkedConference> getBookmarkedConferences() {
        return this.bookmarkedConferences;
    }

    public List<BookmarkedURL> getBookmarkedURLS() {
        return this.bookmarkedURLS;
    }

    @Override // org.jivesoftware.smackx.iqprivate.packet.PrivateData
    public String getElementName() {
        return ELEMENT;
    }

    @Override // org.jivesoftware.smackx.iqprivate.packet.PrivateData
    public String getNamespace() {
        return NAMESPACE;
    }

    public void removeBookmarkedConference(BookmarkedConference bookmarkedConference) {
        this.bookmarkedConferences.remove(bookmarkedConference);
    }

    public void removeBookmarkedURL(BookmarkedURL bookmarkedURL) {
        this.bookmarkedURLS.remove(bookmarkedURL);
    }

    @Override // org.jivesoftware.smackx.iqprivate.packet.PrivateData
    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        xmlStringBuilder.halfOpenElement(ELEMENT).xmlnsAttribute(NAMESPACE).rightAngleBracket();
        for (BookmarkedURL bookmarkedURL : getBookmarkedURLS()) {
            if (!bookmarkedURL.isShared()) {
                xmlStringBuilder.halfOpenElement(ImagesContract.URL).attribute("name", bookmarkedURL.getName()).attribute(ImagesContract.URL, bookmarkedURL.getURL());
                xmlStringBuilder.condAttribute(bookmarkedURL.isRss(), "rss", "true");
                xmlStringBuilder.closeEmptyElement();
            }
        }
        for (BookmarkedConference bookmarkedConference : getBookmarkedConferences()) {
            if (!bookmarkedConference.isShared()) {
                xmlStringBuilder.halfOpenElement("conference");
                xmlStringBuilder.attribute("name", bookmarkedConference.getName());
                xmlStringBuilder.attribute("autojoin", Boolean.toString(bookmarkedConference.isAutoJoin()));
                xmlStringBuilder.attribute(PSOProgramService.JobID_Key, bookmarkedConference.getJid());
                xmlStringBuilder.rightAngleBracket();
                xmlStringBuilder.optElement(Nick.ELEMENT_NAME, bookmarkedConference.getNickname());
                xmlStringBuilder.optElement("password", bookmarkedConference.getPassword());
                xmlStringBuilder.closeElement("conference");
            }
        }
        xmlStringBuilder.closeElement(ELEMENT);
        return xmlStringBuilder;
    }
}

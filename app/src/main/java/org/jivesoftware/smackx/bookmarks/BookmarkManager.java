package org.jivesoftware.smackx.bookmarks;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smackx.bookmarks.Bookmarks;
import org.jivesoftware.smackx.iqprivate.PrivateDataManager;

/* loaded from: classes5.dex */
public class BookmarkManager {
    private static final Map<XMPPConnection, BookmarkManager> bookmarkManagerMap = new WeakHashMap();
    private final Object bookmarkLock = new Object();
    private Bookmarks bookmarks;
    private PrivateDataManager privateDataManager;

    static {
        PrivateDataManager.addPrivateDataProvider(Bookmarks.ELEMENT, Bookmarks.NAMESPACE, new Bookmarks.Provider());
    }

    private BookmarkManager(XMPPConnection xMPPConnection) throws SmackException, XMPPException {
        this.privateDataManager = PrivateDataManager.getInstanceFor(xMPPConnection);
        bookmarkManagerMap.put(xMPPConnection, this);
    }

    public static synchronized BookmarkManager getBookmarkManager(XMPPConnection xMPPConnection) throws SmackException, XMPPException {
        BookmarkManager bookmarkManager;
        bookmarkManager = bookmarkManagerMap.get(xMPPConnection);
        if (bookmarkManager == null) {
            bookmarkManager = new BookmarkManager(xMPPConnection);
        }
        return bookmarkManager;
    }

    private Bookmarks retrieveBookmarks() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        Bookmarks bookmarks;
        synchronized (this.bookmarkLock) {
            if (this.bookmarks == null) {
                this.bookmarks = (Bookmarks) this.privateDataManager.getPrivateData(Bookmarks.ELEMENT, Bookmarks.NAMESPACE);
            }
            bookmarks = this.bookmarks;
        }
        return bookmarks;
    }

    public void addBookmarkedConference(String str, String str2, boolean z, String str3, String str4) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        retrieveBookmarks();
        BookmarkedConference bookmarkedConference = new BookmarkedConference(str, str2, z, str3, str4);
        List<BookmarkedConference> bookmarkedConferences = this.bookmarks.getBookmarkedConferences();
        if (bookmarkedConferences.contains(bookmarkedConference)) {
            BookmarkedConference bookmarkedConference2 = bookmarkedConferences.get(bookmarkedConferences.indexOf(bookmarkedConference));
            if (bookmarkedConference2.isShared()) {
                throw new IllegalArgumentException("Cannot modify shared bookmark");
            }
            bookmarkedConference2.setAutoJoin(z);
            bookmarkedConference2.setName(str);
            bookmarkedConference2.setNickname(str3);
            bookmarkedConference2.setPassword(str4);
        } else {
            this.bookmarks.addBookmarkedConference(bookmarkedConference);
        }
        this.privateDataManager.setPrivateData(this.bookmarks);
    }

    public void addBookmarkedURL(String str, String str2, boolean z) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        retrieveBookmarks();
        BookmarkedURL bookmarkedURL = new BookmarkedURL(str, str2, z);
        List<BookmarkedURL> bookmarkedURLS = this.bookmarks.getBookmarkedURLS();
        if (bookmarkedURLS.contains(bookmarkedURL)) {
            BookmarkedURL bookmarkedURL2 = bookmarkedURLS.get(bookmarkedURLS.indexOf(bookmarkedURL));
            if (bookmarkedURL2.isShared()) {
                throw new IllegalArgumentException("Cannot modify shared bookmarks");
            }
            bookmarkedURL2.setName(str2);
            bookmarkedURL2.setRss(z);
        } else {
            this.bookmarks.addBookmarkedURL(bookmarkedURL);
        }
        this.privateDataManager.setPrivateData(this.bookmarks);
    }

    public List<BookmarkedConference> getBookmarkedConferences() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        retrieveBookmarks();
        return Collections.unmodifiableList(this.bookmarks.getBookmarkedConferences());
    }

    public List<BookmarkedURL> getBookmarkedURLs() throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        retrieveBookmarks();
        return Collections.unmodifiableList(this.bookmarks.getBookmarkedURLS());
    }

    public void removeBookmarkedConference(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        retrieveBookmarks();
        Iterator<BookmarkedConference> it = this.bookmarks.getBookmarkedConferences().iterator();
        while (it.hasNext()) {
            BookmarkedConference next = it.next();
            if (next.getJid().equalsIgnoreCase(str)) {
                if (next.isShared()) {
                    throw new IllegalArgumentException("Conference is shared and can't be removed");
                }
                it.remove();
                this.privateDataManager.setPrivateData(this.bookmarks);
                return;
            }
        }
    }

    public void removeBookmarkedURL(String str) throws SmackException.NotConnectedException, SmackException.NoResponseException, XMPPException.XMPPErrorException {
        retrieveBookmarks();
        Iterator<BookmarkedURL> it = this.bookmarks.getBookmarkedURLS().iterator();
        while (it.hasNext()) {
            BookmarkedURL next = it.next();
            if (next.getURL().equalsIgnoreCase(str)) {
                if (next.isShared()) {
                    throw new IllegalArgumentException("Cannot delete a shared bookmark.");
                }
                it.remove();
                this.privateDataManager.setPrivateData(this.bookmarks);
                return;
            }
        }
    }
}

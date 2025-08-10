package org.jivesoftware.smack.roster.rosterstore;

import com.broadcom.bt.util.io.IOUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.roster.packet.RosterPacket;
import org.jivesoftware.smack.util.FileUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smack.util.stringencoder.Base32;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes5.dex */
public class DirectoryRosterStore implements RosterStore {
    private static final String ENTRY_PREFIX = "entry-";
    private static final String STORE_ID = "DEFAULT_ROSTER_STORE";
    private static final String VERSION_FILE_NAME = "__version__";
    private final File fileDir;
    private static final Logger LOGGER = Logger.getLogger(DirectoryRosterStore.class.getName());
    private static final FileFilter rosterDirFilter = new FileFilter() { // from class: org.jivesoftware.smack.roster.rosterstore.DirectoryRosterStore.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.getName().startsWith(DirectoryRosterStore.ENTRY_PREFIX);
        }
    };

    private DirectoryRosterStore(File file) {
        this.fileDir = file;
    }

    private boolean addEntryRaw(RosterPacket.Item item) {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder();
        xmlStringBuilder.openElement("item");
        xmlStringBuilder.element("user", item.getUser());
        xmlStringBuilder.optElement("name", item.getName());
        xmlStringBuilder.optElement("type", item.getItemType());
        xmlStringBuilder.optElement("status", item.getItemStatus());
        for (String str : item.getGroupNames()) {
            xmlStringBuilder.openElement("group");
            xmlStringBuilder.element("groupName", str);
            xmlStringBuilder.closeElement("group");
        }
        xmlStringBuilder.closeElement("item");
        return FileUtils.writeFile(getBareJidFile(item.getUser()), xmlStringBuilder.toString());
    }

    private File getBareJidFile(String str) {
        String strEncode = Base32.encode(str);
        return new File(this.fileDir, ENTRY_PREFIX + strEncode);
    }

    private File getVersionFile() {
        return new File(this.fileDir, VERSION_FILE_NAME);
    }

    public static DirectoryRosterStore init(File file) {
        DirectoryRosterStore directoryRosterStore = new DirectoryRosterStore(file);
        if (directoryRosterStore.setRosterVersion("")) {
            return directoryRosterStore;
        }
        return null;
    }

    private void log(String str) {
        System.err.println(str);
    }

    public static DirectoryRosterStore open(File file) {
        DirectoryRosterStore directoryRosterStore = new DirectoryRosterStore(file);
        String file2 = FileUtils.readFile(directoryRosterStore.getVersionFile());
        if (file2 == null || !file2.startsWith("DEFAULT_ROSTER_STORE\n")) {
            return null;
        }
        return directoryRosterStore;
    }

    private RosterPacket.Item readEntry(File file) throws XmlPullParserException, IOException {
        String text;
        String text2;
        String text3;
        String text4;
        String file2 = FileUtils.readFile(file);
        if (file2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
            xmlPullParserNewPullParser.setInput(new StringReader(file2));
            boolean z = false;
            loop0: while (true) {
                text = null;
                text2 = null;
                text3 = null;
                text4 = null;
                while (!z) {
                    int next = xmlPullParserNewPullParser.next();
                    String name = xmlPullParserNewPullParser.getName();
                    if (next == 2) {
                        if (name.equals("item")) {
                            break;
                        }
                        if (name.equals("user")) {
                            xmlPullParserNewPullParser.next();
                            text = xmlPullParserNewPullParser.getText();
                        } else if (name.equals("name")) {
                            xmlPullParserNewPullParser.next();
                            text2 = xmlPullParserNewPullParser.getText();
                        } else if (name.equals("type")) {
                            xmlPullParserNewPullParser.next();
                            text3 = xmlPullParserNewPullParser.getText();
                        } else if (name.equals("status")) {
                            xmlPullParserNewPullParser.next();
                            text4 = xmlPullParserNewPullParser.getText();
                        } else if (name.equals("group")) {
                            xmlPullParserNewPullParser.next();
                            xmlPullParserNewPullParser.next();
                            String text5 = xmlPullParserNewPullParser.getText();
                            if (text5 != null) {
                                arrayList.add(text5);
                            } else {
                                log("Invalid group entry in store entry file " + file);
                            }
                        }
                    } else if (next == 3 && name.equals("item")) {
                        z = true;
                    }
                }
            }
            if (text == null) {
                return null;
            }
            RosterPacket.Item item = new RosterPacket.Item(text, text2);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                item.addGroupName((String) it.next());
            }
            if (text3 != null) {
                try {
                    item.setItemType(RosterPacket.ItemType.valueOf(text3));
                    if (text4 != null) {
                        RosterPacket.ItemStatus itemStatusFromString = RosterPacket.ItemStatus.fromString(text4);
                        if (itemStatusFromString == null) {
                            log("Invalid status in store entry file " + file);
                            return null;
                        }
                        item.setItemStatus(itemStatusFromString);
                    }
                } catch (IllegalArgumentException unused) {
                    log("Invalid type in store entry file " + file);
                    return null;
                }
            }
            return item;
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "readEntry()", (Throwable) e);
            return null;
        } catch (XmlPullParserException e2) {
            log("Invalid group entry in store entry file " + file);
            LOGGER.log(Level.SEVERE, "readEntry()", (Throwable) e2);
            return null;
        }
    }

    private boolean setRosterVersion(String str) {
        return FileUtils.writeFile(getVersionFile(), "DEFAULT_ROSTER_STORE\n" + str);
    }

    @Override // org.jivesoftware.smack.roster.rosterstore.RosterStore
    public boolean addEntry(RosterPacket.Item item, String str) {
        return addEntryRaw(item) && setRosterVersion(str);
    }

    @Override // org.jivesoftware.smack.roster.rosterstore.RosterStore
    public RosterPacket.Item getEntry(String str) {
        return readEntry(getBareJidFile(str));
    }

    @Override // org.jivesoftware.smack.roster.rosterstore.RosterStore
    public String getRosterVersion() {
        String file = FileUtils.readFile(getVersionFile());
        if (file == null) {
            return null;
        }
        String[] strArrSplit = file.split(IOUtils.LINE_SEPARATOR_UNIX, 2);
        if (strArrSplit.length < 2) {
            return null;
        }
        return strArrSplit[1];
    }

    @Override // org.jivesoftware.smack.roster.rosterstore.RosterStore
    public boolean removeEntry(String str, String str2) {
        return getBareJidFile(str).delete() && setRosterVersion(str2);
    }

    @Override // org.jivesoftware.smack.roster.rosterstore.RosterStore
    public boolean resetEntries(Collection<RosterPacket.Item> collection, String str) {
        for (File file : this.fileDir.listFiles(rosterDirFilter)) {
            file.delete();
        }
        Iterator<RosterPacket.Item> it = collection.iterator();
        while (it.hasNext()) {
            if (!addEntryRaw(it.next())) {
                return false;
            }
        }
        return setRosterVersion(str);
    }

    @Override // org.jivesoftware.smack.roster.rosterstore.RosterStore
    public List<RosterPacket.Item> getEntries() throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        for (File file : this.fileDir.listFiles(rosterDirFilter)) {
            RosterPacket.Item entry = readEntry(file);
            if (entry == null) {
                log("Roster store file '" + file + "' is invalid.");
            } else {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }
}

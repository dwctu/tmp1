package org.jivesoftware.smackx.caps.cache;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smack.util.stringencoder.Base32;
import org.jivesoftware.smack.util.stringencoder.StringEncoder;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;

/* loaded from: classes5.dex */
public class SimpleDirectoryPersistentCache implements EntityCapsPersistentCache {
    private static final Logger LOGGER = Logger.getLogger(SimpleDirectoryPersistentCache.class.getName());
    private File cacheDir;
    private StringEncoder filenameEncoder;

    public SimpleDirectoryPersistentCache(File file) {
        this(file, Base32.getStringEncoder());
    }

    private File getFileFor(String str) {
        return new File(this.cacheDir, this.filenameEncoder.encode(str));
    }

    private static DiscoverInfo restoreInfoFromFile(File file) throws Exception {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            String utf = dataInputStream.readUTF();
            if (utf == null) {
                return null;
            }
            return (DiscoverInfo) PacketParserUtils.parseStanza(utf);
        } finally {
            dataInputStream.close();
        }
    }

    private static void writeInfoToFile(File file, DiscoverInfo discoverInfo) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        try {
            dataOutputStream.writeUTF(discoverInfo.toXML().toString());
        } finally {
            dataOutputStream.close();
        }
    }

    @Override // org.jivesoftware.smackx.caps.cache.EntityCapsPersistentCache
    public void addDiscoverInfoByNodePersistent(String str, DiscoverInfo discoverInfo) {
        File fileFor = getFileFor(str);
        try {
            if (fileFor.createNewFile()) {
                writeInfoToFile(fileFor, discoverInfo);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to write disco info to file", (Throwable) e);
        }
    }

    @Override // org.jivesoftware.smackx.caps.cache.EntityCapsPersistentCache
    public void emptyCache() {
        for (File file : this.cacheDir.listFiles()) {
            file.delete();
        }
    }

    @Override // org.jivesoftware.smackx.caps.cache.EntityCapsPersistentCache
    public DiscoverInfo lookup(String str) {
        File fileFor = getFileFor(str);
        if (!fileFor.isFile()) {
            return null;
        }
        try {
            return restoreInfoFromFile(fileFor);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Coud not restore info from file", (Throwable) e);
            return null;
        }
    }

    public SimpleDirectoryPersistentCache(File file, StringEncoder stringEncoder) {
        if (!file.exists()) {
            throw new IllegalStateException("Cache directory \"" + file + "\" does not exist");
        }
        if (file.isDirectory()) {
            this.cacheDir = file;
            this.filenameEncoder = stringEncoder;
        } else {
            throw new IllegalStateException("Cache directory \"" + file + "\" is not a directory");
        }
    }
}

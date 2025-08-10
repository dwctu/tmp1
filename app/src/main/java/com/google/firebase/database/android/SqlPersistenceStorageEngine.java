package com.google.firebase.database.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.UserWriteRecord;
import com.google.firebase.database.core.persistence.PersistenceStorageEngine;
import com.google.firebase.database.core.persistence.PruneForest;
import com.google.firebase.database.core.persistence.TrackedQuery;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.NodeSizeEstimator;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.util.JsonMapper;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class SqlPersistenceStorageEngine implements PersistenceStorageEngine {
    private static final int CHILDREN_NODE_SPLIT_SIZE_THRESHOLD = 16384;
    private static final String CREATE_SERVER_CACHE = "CREATE TABLE serverCache (path TEXT PRIMARY KEY, value BLOB);";
    private static final String CREATE_TRACKED_KEYS = "CREATE TABLE trackedKeys (id INTEGER, key TEXT);";
    private static final String CREATE_TRACKED_QUERIES = "CREATE TABLE trackedQueries (id INTEGER PRIMARY KEY, path TEXT, queryParams TEXT, lastUse INTEGER, complete INTEGER, active INTEGER);";
    private static final String CREATE_WRITES = "CREATE TABLE writes (id INTEGER, path TEXT, type TEXT, part INTEGER, node BLOB, UNIQUE (id, part));";
    private static final String FIRST_PART_KEY = ".part-0000";
    private static final String LOGGER_COMPONENT = "Persistence";
    private static final String PART_KEY_FORMAT = ".part-%04d";
    private static final String PART_KEY_PREFIX = ".part-";
    private static final String PATH_COLUMN_NAME = "path";
    private static final String ROW_ID_COLUMN_NAME = "rowid";
    private static final int ROW_SPLIT_SIZE = 262144;
    private static final String SERVER_CACHE_TABLE = "serverCache";
    private static final String TRACKED_KEYS_ID_COLUMN_NAME = "id";
    private static final String TRACKED_KEYS_KEY_COLUMN_NAME = "key";
    private static final String TRACKED_KEYS_TABLE = "trackedKeys";
    private static final String TRACKED_QUERY_ACTIVE_COLUMN_NAME = "active";
    private static final String TRACKED_QUERY_COMPLETE_COLUMN_NAME = "complete";
    private static final String TRACKED_QUERY_ID_COLUMN_NAME = "id";
    private static final String TRACKED_QUERY_LAST_USE_COLUMN_NAME = "lastUse";
    private static final String TRACKED_QUERY_PARAMS_COLUMN_NAME = "queryParams";
    private static final String TRACKED_QUERY_PATH_COLUMN_NAME = "path";
    private static final String TRACKED_QUERY_TABLE = "trackedQueries";
    private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");
    private static final String VALUE_COLUMN_NAME = "value";
    private static final String WRITES_TABLE = "writes";
    private static final String WRITE_ID_COLUMN_NAME = "id";
    private static final String WRITE_NODE_COLUMN_NAME = "node";
    private static final String WRITE_PART_COLUMN_NAME = "part";
    private static final String WRITE_TYPE_COLUMN_NAME = "type";
    private static final String WRITE_TYPE_MERGE = "m";
    private static final String WRITE_TYPE_OVERWRITE = "o";
    private final SQLiteDatabase database;
    private boolean insideTransaction;
    private final LogWrapper logger;
    private long transactionStart = 0;

    public static class PersistentCacheOpenHelper extends SQLiteOpenHelper {
        private static final int DATABASE_VERSION = 2;

        public PersistentCacheOpenHelper(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 2);
        }

        private void dropTable(SQLiteDatabase sQLiteDatabase, String str) throws SQLException {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
            sQLiteDatabase.execSQL(SqlPersistenceStorageEngine.CREATE_SERVER_CACHE);
            sQLiteDatabase.execSQL(SqlPersistenceStorageEngine.CREATE_WRITES);
            sQLiteDatabase.execSQL(SqlPersistenceStorageEngine.CREATE_TRACKED_QUERIES);
            sQLiteDatabase.execSQL(SqlPersistenceStorageEngine.CREATE_TRACKED_KEYS);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws SQLException {
            Utilities.hardAssert(i2 == 2, "Why is onUpgrade() called with a different version?");
            if (i > 1) {
                throw new AssertionError("We don't handle upgrading to " + i2);
            }
            dropTable(sQLiteDatabase, SqlPersistenceStorageEngine.SERVER_CACHE_TABLE);
            sQLiteDatabase.execSQL(SqlPersistenceStorageEngine.CREATE_SERVER_CACHE);
            dropTable(sQLiteDatabase, SqlPersistenceStorageEngine.TRACKED_QUERY_COMPLETE_COLUMN_NAME);
            sQLiteDatabase.execSQL(SqlPersistenceStorageEngine.CREATE_TRACKED_KEYS);
            sQLiteDatabase.execSQL(SqlPersistenceStorageEngine.CREATE_TRACKED_QUERIES);
        }
    }

    public SqlPersistenceStorageEngine(Context context, com.google.firebase.database.core.Context context2, String str) throws UnsupportedEncodingException {
        try {
            String strEncode = URLEncoder.encode(str, "utf-8");
            this.logger = context2.getLogger(LOGGER_COMPONENT);
            this.database = openDatabase(context, strEncode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String buildAncestorWhereClause(Path path, String[] strArr) {
        int i = 0;
        Utilities.hardAssert(strArr.length >= path.size() + 1);
        StringBuilder sb = new StringBuilder("(");
        while (!path.isEmpty()) {
            sb.append("path");
            sb.append(" = ? OR ");
            strArr[i] = pathToKey(path);
            path = path.getParent();
            i++;
        }
        sb.append("path");
        sb.append(" = ?)");
        strArr[i] = pathToKey(Path.getEmptyPath());
        return sb.toString();
    }

    private String commaSeparatedList(Collection<Long> collection) {
        StringBuilder sb = new StringBuilder();
        Iterator<Long> it = collection.iterator();
        boolean z = true;
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            if (!z) {
                sb.append(",");
            }
            z = false;
            sb.append(jLongValue);
        }
        return sb.toString();
    }

    private Node deserializeNode(byte[] bArr) {
        try {
            return NodeUtilities.NodeFromJSON(JsonMapper.parseJsonValue(new String(bArr, UTF8_CHARSET)));
        } catch (IOException e) {
            throw new RuntimeException("Could not deserialize node: " + new String(bArr, UTF8_CHARSET), e);
        }
    }

    private byte[] joinBytes(List<byte[]> list) {
        Iterator<byte[]> it = list.iterator();
        int length = 0;
        while (it.hasNext()) {
            length += it.next().length;
        }
        byte[] bArr = new byte[length];
        int length2 = 0;
        for (byte[] bArr2 : list) {
            System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return bArr;
    }

    private Node loadNested(Path path) {
        long j;
        Node nodeDeserializeNode;
        Path path2;
        int i;
        Path path3;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Cursor cursorLoadNestedQuery = loadNestedQuery(path, new String[]{"path", "value"});
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        long jCurrentTimeMillis3 = System.currentTimeMillis();
        while (cursorLoadNestedQuery.moveToNext()) {
            try {
                arrayList.add(cursorLoadNestedQuery.getString(0));
                arrayList2.add(cursorLoadNestedQuery.getBlob(1));
            } catch (Throwable th) {
                cursorLoadNestedQuery.close();
                throw th;
            }
        }
        cursorLoadNestedQuery.close();
        long jCurrentTimeMillis4 = System.currentTimeMillis() - jCurrentTimeMillis3;
        long jCurrentTimeMillis5 = System.currentTimeMillis();
        Node nodeEmpty = EmptyNode.Empty();
        HashMap map = new HashMap();
        int i2 = 0;
        boolean z = false;
        while (true) {
            long j2 = jCurrentTimeMillis4;
            if (i2 >= arrayList2.size()) {
                long j3 = jCurrentTimeMillis2;
                for (Map.Entry entry : map.entrySet()) {
                    nodeEmpty = nodeEmpty.updateChild(Path.getRelative(path, (Path) entry.getKey()), (Node) entry.getValue());
                }
                long jCurrentTimeMillis6 = System.currentTimeMillis() - jCurrentTimeMillis5;
                long jCurrentTimeMillis7 = System.currentTimeMillis() - jCurrentTimeMillis;
                if (this.logger.logsDebug()) {
                    this.logger.debug(String.format(Locale.US, "Loaded a total of %d rows for a total of %d nodes at %s in %dms (Query: %dms, Loading: %dms, Serializing: %dms)", Integer.valueOf(arrayList2.size()), Integer.valueOf(NodeSizeEstimator.nodeCount(nodeEmpty)), path, Long.valueOf(jCurrentTimeMillis7), Long.valueOf(j3), Long.valueOf(j2), Long.valueOf(jCurrentTimeMillis6)), new Object[0]);
                }
                return nodeEmpty;
            }
            if (arrayList.get(i2).endsWith(FIRST_PART_KEY)) {
                j = jCurrentTimeMillis2;
                Path path4 = new Path(arrayList.get(i2).substring(0, r13.length() - 10));
                int iSplitNodeRunLength = splitNodeRunLength(path4, arrayList, i2);
                if (this.logger.logsDebug()) {
                    path3 = path4;
                    this.logger.debug("Loading split node with " + iSplitNodeRunLength + " parts.", new Object[0]);
                } else {
                    path3 = path4;
                }
                int i3 = iSplitNodeRunLength + i2;
                nodeDeserializeNode = deserializeNode(joinBytes(arrayList2.subList(i2, i3)));
                i2 = i3 - 1;
                path2 = path3;
            } else {
                j = jCurrentTimeMillis2;
                nodeDeserializeNode = deserializeNode((byte[]) arrayList2.get(i2));
                path2 = new Path(arrayList.get(i2));
            }
            if (path2.getBack() != null && path2.getBack().isPriorityChildName()) {
                map.put(path2, nodeDeserializeNode);
            } else if (path2.contains(path)) {
                Utilities.hardAssert(!z, "Descendants of path must come after ancestors.");
                nodeEmpty = nodeDeserializeNode.getChild(Path.getRelative(path2, path));
            } else {
                if (!path.contains(path2)) {
                    throw new IllegalStateException(String.format("Loading an unrelated row with path %s for %s", path2, path));
                }
                nodeEmpty = nodeEmpty.updateChild(Path.getRelative(path, path2), nodeDeserializeNode);
                i = 1;
                z = true;
                i2 += i;
                jCurrentTimeMillis4 = j2;
                jCurrentTimeMillis2 = j;
            }
            i = 1;
            i2 += i;
            jCurrentTimeMillis4 = j2;
            jCurrentTimeMillis2 = j;
        }
    }

    private Cursor loadNestedQuery(Path path, String[] strArr) {
        String strPathToKey = pathToKey(path);
        String strPathPrefixStartToPrefixEnd = pathPrefixStartToPrefixEnd(strPathToKey);
        String[] strArr2 = new String[path.size() + 3];
        String str = buildAncestorWhereClause(path, strArr2) + " OR (path > ? AND path < ?)";
        strArr2[path.size() + 1] = strPathToKey;
        strArr2[path.size() + 2] = strPathPrefixStartToPrefixEnd;
        return this.database.query(SERVER_CACHE_TABLE, strArr, str, strArr2, null, null, "path");
    }

    private SQLiteDatabase openDatabase(Context context, String str) {
        try {
            SQLiteDatabase writableDatabase = new PersistentCacheOpenHelper(context, str).getWritableDatabase();
            writableDatabase.rawQuery("PRAGMA locking_mode = EXCLUSIVE", null).close();
            writableDatabase.beginTransaction();
            writableDatabase.endTransaction();
            return writableDatabase;
        } catch (SQLiteException e) {
            if (e instanceof SQLiteDatabaseLockedException) {
                throw new DatabaseException("Failed to gain exclusive lock to Firebase Database's offline persistence. This generally means you are using Firebase Database from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing FirebaseDatabase in your Application class. If you are intentionally using Firebase Database from multiple processes, you can only enable offline persistence (i.e. call setPersistenceEnabled(true)) in one of them.", e);
            }
            throw e;
        }
    }

    private String partKey(Path path, int i) {
        return pathToKey(path) + String.format(Locale.US, PART_KEY_FORMAT, Integer.valueOf(i));
    }

    private static String pathPrefixStartToPrefixEnd(String str) {
        Utilities.hardAssert(str.endsWith("/"), "Path keys must end with a '/'");
        return str.substring(0, str.length() - 1) + '0';
    }

    private static String pathToKey(Path path) {
        if (path.isEmpty()) {
            return "/";
        }
        return path.toString() + "/";
    }

    private void pruneTreeRecursive(Path path, final Path path2, ImmutableTree<Long> immutableTree, final ImmutableTree<Long> immutableTree2, PruneForest pruneForest, final List<Pair<Path, Node>> list) {
        if (immutableTree.getValue() == null) {
            Iterator<Map.Entry<ChildKey, ImmutableTree<Long>>> it = immutableTree.getChildren().iterator();
            while (it.hasNext()) {
                Map.Entry<ChildKey, ImmutableTree<Long>> next = it.next();
                ChildKey key = next.getKey();
                pruneTreeRecursive(path, path2.child(key), next.getValue(), immutableTree2.getChild(key), pruneForest.child(next.getKey()), list);
            }
            return;
        }
        int iIntValue = ((Integer) pruneForest.foldKeptNodes(0, new ImmutableTree.TreeVisitor<Void, Integer>() { // from class: com.google.firebase.database.android.SqlPersistenceStorageEngine.1
            @Override // com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor
            public Integer onNodeValue(Path path3, Void r2, Integer num) {
                return Integer.valueOf(immutableTree2.get(path3) == null ? num.intValue() + 1 : num.intValue());
            }
        })).intValue();
        if (iIntValue > 0) {
            Path pathChild = path.child(path2);
            if (this.logger.logsDebug()) {
                this.logger.debug(String.format(Locale.US, "Need to rewrite %d nodes below path %s", Integer.valueOf(iIntValue), pathChild), new Object[0]);
            }
            final Node nodeLoadNested = loadNested(pathChild);
            pruneForest.foldKeptNodes(null, new ImmutableTree.TreeVisitor<Void, Void>() { // from class: com.google.firebase.database.android.SqlPersistenceStorageEngine.2
                @Override // com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor
                public Void onNodeValue(Path path3, Void r4, Void r5) {
                    if (immutableTree2.get(path3) != null) {
                        return null;
                    }
                    list.add(new Pair(path2.child(path3), nodeLoadNested.getChild(path3)));
                    return null;
                }
            });
        }
    }

    private int removeNested(String str, Path path) {
        String strPathToKey = pathToKey(path);
        return this.database.delete(str, "path >= ? AND path < ?", new String[]{strPathToKey, pathPrefixStartToPrefixEnd(strPathToKey)});
    }

    private int saveNested(Path path, Node node) {
        long jEstimateSerializedNodeSize = NodeSizeEstimator.estimateSerializedNodeSize(node);
        if (!(node instanceof ChildrenNode) || jEstimateSerializedNodeSize <= PlaybackStateCompat.ACTION_PREPARE) {
            saveNode(path, node);
            return 1;
        }
        int iSaveNested = 0;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format(Locale.US, "Node estimated serialized size at path %s of %d bytes exceeds limit of %d bytes. Splitting up.", path, Long.valueOf(jEstimateSerializedNodeSize), 16384), new Object[0]);
        }
        for (NamedNode namedNode : node) {
            iSaveNested += saveNested(path.child(namedNode.getName()), namedNode.getNode());
        }
        if (!node.getPriority().isEmpty()) {
            saveNode(path.child(ChildKey.getPriorityKey()), node.getPriority());
            iSaveNested++;
        }
        saveNode(path, EmptyNode.Empty());
        return iSaveNested + 1;
    }

    private void saveNode(Path path, Node node) {
        byte[] bArrSerializeObject = serializeObject(node.getValue(true));
        if (bArrSerializeObject.length < 262144) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("path", pathToKey(path));
            contentValues.put("value", bArrSerializeObject);
            this.database.insertWithOnConflict(SERVER_CACHE_TABLE, null, contentValues, 5);
            return;
        }
        List<byte[]> listSplitBytes = splitBytes(bArrSerializeObject, 262144);
        if (this.logger.logsDebug()) {
            this.logger.debug("Saving huge leaf node with " + listSplitBytes.size() + " parts.", new Object[0]);
        }
        for (int i = 0; i < listSplitBytes.size(); i++) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("path", partKey(path, i));
            contentValues2.put("value", listSplitBytes.get(i));
            this.database.insertWithOnConflict(SERVER_CACHE_TABLE, null, contentValues2, 5);
        }
    }

    private void saveWrite(Path path, long j, String str, byte[] bArr) {
        verifyInsideTransaction();
        this.database.delete(WRITES_TABLE, "id = ?", new String[]{String.valueOf(j)});
        if (bArr.length < 262144) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(TtmlNode.ATTR_ID, Long.valueOf(j));
            contentValues.put("path", pathToKey(path));
            contentValues.put("type", str);
            contentValues.put(WRITE_PART_COLUMN_NAME, (Integer) null);
            contentValues.put(WRITE_NODE_COLUMN_NAME, bArr);
            this.database.insertWithOnConflict(WRITES_TABLE, null, contentValues, 5);
            return;
        }
        List<byte[]> listSplitBytes = splitBytes(bArr, 262144);
        for (int i = 0; i < listSplitBytes.size(); i++) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put(TtmlNode.ATTR_ID, Long.valueOf(j));
            contentValues2.put("path", pathToKey(path));
            contentValues2.put("type", str);
            contentValues2.put(WRITE_PART_COLUMN_NAME, Integer.valueOf(i));
            contentValues2.put(WRITE_NODE_COLUMN_NAME, listSplitBytes.get(i));
            this.database.insertWithOnConflict(WRITES_TABLE, null, contentValues2, 5);
        }
    }

    private byte[] serializeObject(Object obj) {
        try {
            return JsonMapper.serializeJsonValue(obj).getBytes(UTF8_CHARSET);
        } catch (IOException e) {
            throw new RuntimeException("Could not serialize leaf node", e);
        }
    }

    private static List<byte[]> splitBytes(byte[] bArr, int i) {
        int length = ((bArr.length - 1) / i) + 1;
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * i;
            int iMin = Math.min(i, bArr.length - i3);
            byte[] bArr2 = new byte[iMin];
            System.arraycopy(bArr, i3, bArr2, 0, iMin);
            arrayList.add(bArr2);
        }
        return arrayList;
    }

    private int splitNodeRunLength(Path path, List<String> list, int i) {
        int i2 = i + 1;
        String strPathToKey = pathToKey(path);
        if (!list.get(i).startsWith(strPathToKey)) {
            throw new IllegalStateException("Extracting split nodes needs to start with path prefix");
        }
        while (i2 < list.size() && list.get(i2).equals(partKey(path, i2 - i))) {
            i2++;
        }
        if (i2 < list.size()) {
            if (list.get(i2).startsWith(strPathToKey + PART_KEY_PREFIX)) {
                throw new IllegalStateException("Run did not finish with all parts");
            }
        }
        return i2 - i;
    }

    private void updateServerCache(Path path, Node node, boolean z) {
        int iSaveNested;
        int iRemoveNested;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z) {
            int iSaveNested2 = 0;
            int iRemoveNested2 = 0;
            for (NamedNode namedNode : node) {
                iRemoveNested2 += removeNested(SERVER_CACHE_TABLE, path.child(namedNode.getName()));
                iSaveNested2 += saveNested(path.child(namedNode.getName()), namedNode.getNode());
            }
            iSaveNested = iSaveNested2;
            iRemoveNested = iRemoveNested2;
        } else {
            iRemoveNested = removeNested(SERVER_CACHE_TABLE, path);
            iSaveNested = saveNested(path, node);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format(Locale.US, "Persisted a total of %d rows and deleted %d rows for a set at %s in %dms", Integer.valueOf(iSaveNested), Integer.valueOf(iRemoveNested), path.toString(), Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
    }

    private void verifyInsideTransaction() {
        Utilities.hardAssert(this.insideTransaction, "Transaction expected to already be in progress.");
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void beginTransaction() {
        Utilities.hardAssert(!this.insideTransaction, "runInTransaction called when an existing transaction is already in progress.");
        if (this.logger.logsDebug()) {
            this.logger.debug("Starting transaction.", new Object[0]);
        }
        this.database.beginTransaction();
        this.insideTransaction = true;
        this.transactionStart = System.currentTimeMillis();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void close() {
        this.database.close();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void deleteTrackedQuery(long j) {
        verifyInsideTransaction();
        String strValueOf = String.valueOf(j);
        this.database.delete(TRACKED_QUERY_TABLE, "id = ?", new String[]{strValueOf});
        this.database.delete(TRACKED_KEYS_TABLE, "id = ?", new String[]{strValueOf});
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void endTransaction() {
        this.database.endTransaction();
        this.insideTransaction = false;
        long jCurrentTimeMillis = System.currentTimeMillis() - this.transactionStart;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format(Locale.US, "Transaction completed. Elapsed: %dms", Long.valueOf(jCurrentTimeMillis)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public List<TrackedQuery> loadTrackedQueries() {
        String[] strArr = {TtmlNode.ATTR_ID, "path", TRACKED_QUERY_PARAMS_COLUMN_NAME, TRACKED_QUERY_LAST_USE_COLUMN_NAME, TRACKED_QUERY_COMPLETE_COLUMN_NAME, "active"};
        long jCurrentTimeMillis = System.currentTimeMillis();
        Cursor cursorQuery = this.database.query(TRACKED_QUERY_TABLE, strArr, null, null, null, null, TtmlNode.ATTR_ID);
        ArrayList arrayList = new ArrayList();
        while (cursorQuery.moveToNext()) {
            try {
                try {
                    arrayList.add(new TrackedQuery(cursorQuery.getLong(0), QuerySpec.fromPathAndQueryObject(new Path(cursorQuery.getString(1)), JsonMapper.parseJson(cursorQuery.getString(2))), cursorQuery.getLong(3), cursorQuery.getInt(4) != 0, cursorQuery.getInt(5) != 0));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } finally {
                cursorQuery.close();
            }
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format(Locale.US, "Loaded %d tracked queries in %dms", Integer.valueOf(arrayList.size()), Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
        return arrayList;
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public Set<ChildKey> loadTrackedQueryKeys(long j) {
        return loadTrackedQueryKeys(Collections.singleton(Long.valueOf(j)));
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public List<UserWriteRecord> loadUserWrites() {
        byte[] bArrJoinBytes;
        UserWriteRecord userWriteRecord;
        String[] strArr = {TtmlNode.ATTR_ID, "path", "type", WRITE_PART_COLUMN_NAME, WRITE_NODE_COLUMN_NAME};
        long jCurrentTimeMillis = System.currentTimeMillis();
        Cursor cursorQuery = this.database.query(WRITES_TABLE, strArr, null, null, null, null, "id, part");
        ArrayList arrayList = new ArrayList();
        while (cursorQuery.moveToNext()) {
            try {
                try {
                    long j = cursorQuery.getLong(0);
                    Path path = new Path(cursorQuery.getString(1));
                    String string = cursorQuery.getString(2);
                    if (cursorQuery.isNull(3)) {
                        bArrJoinBytes = cursorQuery.getBlob(4);
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        do {
                            arrayList2.add(cursorQuery.getBlob(4));
                            if (!cursorQuery.moveToNext()) {
                                break;
                            }
                        } while (cursorQuery.getLong(0) == j);
                        cursorQuery.moveToPrevious();
                        bArrJoinBytes = joinBytes(arrayList2);
                    }
                    Object jsonValue = JsonMapper.parseJsonValue(new String(bArrJoinBytes, UTF8_CHARSET));
                    if (WRITE_TYPE_OVERWRITE.equals(string)) {
                        userWriteRecord = new UserWriteRecord(j, path, NodeUtilities.NodeFromJSON(jsonValue), true);
                    } else {
                        if (!WRITE_TYPE_MERGE.equals(string)) {
                            throw new IllegalStateException("Got invalid write type: " + string);
                        }
                        userWriteRecord = new UserWriteRecord(j, path, CompoundWrite.fromValue((Map) jsonValue));
                    }
                    arrayList.add(userWriteRecord);
                } catch (IOException e) {
                    throw new RuntimeException("Failed to load writes", e);
                }
            } finally {
                cursorQuery.close();
            }
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format(Locale.US, "Loaded %d writes in %dms", Integer.valueOf(arrayList.size()), Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
        return arrayList;
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void mergeIntoServerCache(Path path, Node node) {
        verifyInsideTransaction();
        updateServerCache(path, node, true);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void overwriteServerCache(Path path, Node node) {
        verifyInsideTransaction();
        updateServerCache(path, node, false);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void pruneCache(Path path, PruneForest pruneForest) {
        int size;
        int size2;
        if (pruneForest.prunesAnything()) {
            verifyInsideTransaction();
            long jCurrentTimeMillis = System.currentTimeMillis();
            Cursor cursorLoadNestedQuery = loadNestedQuery(path, new String[]{ROW_ID_COLUMN_NAME, "path"});
            ImmutableTree<Long> immutableTree = new ImmutableTree<>(null);
            ImmutableTree<Long> immutableTree2 = new ImmutableTree<>(null);
            while (cursorLoadNestedQuery.moveToNext()) {
                long j = cursorLoadNestedQuery.getLong(0);
                Path path2 = new Path(cursorLoadNestedQuery.getString(1));
                if (path.contains(path2)) {
                    Path relative = Path.getRelative(path, path2);
                    if (pruneForest.shouldPruneUnkeptDescendants(relative)) {
                        immutableTree = immutableTree.set(relative, Long.valueOf(j));
                    } else if (pruneForest.shouldKeep(relative)) {
                        immutableTree2 = immutableTree2.set(relative, Long.valueOf(j));
                    } else {
                        this.logger.warn("We are pruning at " + path + " and have data at " + path2 + " that isn't marked for pruning or keeping. Ignoring.");
                    }
                } else {
                    this.logger.warn("We are pruning at " + path + " but we have data stored higher up at " + path2 + ". Ignoring.");
                }
            }
            if (immutableTree.isEmpty()) {
                size = 0;
                size2 = 0;
            } else {
                ArrayList arrayList = new ArrayList();
                pruneTreeRecursive(path, Path.getEmptyPath(), immutableTree, immutableTree2, pruneForest, arrayList);
                Collection<Long> collectionValues = immutableTree.values();
                this.database.delete(SERVER_CACHE_TABLE, "rowid IN (" + commaSeparatedList(collectionValues) + ")", null);
                for (Pair<Path, Node> pair : arrayList) {
                    saveNested(path.child(pair.getFirst()), pair.getSecond());
                }
                size = collectionValues.size();
                size2 = arrayList.size();
            }
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (this.logger.logsDebug()) {
                this.logger.debug(String.format(Locale.US, "Pruned %d rows with %d nodes resaved in %dms", Integer.valueOf(size), Integer.valueOf(size2), Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
            }
        }
    }

    public void purgeCache() {
        verifyInsideTransaction();
        this.database.delete(SERVER_CACHE_TABLE, null, null);
        this.database.delete(WRITES_TABLE, null, null);
        this.database.delete(TRACKED_QUERY_TABLE, null, null);
        this.database.delete(TRACKED_KEYS_TABLE, null, null);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void removeAllUserWrites() {
        verifyInsideTransaction();
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iDelete = this.database.delete(WRITES_TABLE, null, null);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format(Locale.US, "Deleted %d (all) write(s) in %dms", Integer.valueOf(iDelete), Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void removeUserWrite(long j) {
        verifyInsideTransaction();
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iDelete = this.database.delete(WRITES_TABLE, "id = ?", new String[]{String.valueOf(j)});
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format(Locale.US, "Deleted %d write(s) with writeId %d in %dms", Integer.valueOf(iDelete), Long.valueOf(j), Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void resetPreviouslyActiveTrackedQueries(long j) {
        verifyInsideTransaction();
        long jCurrentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("active", Boolean.FALSE);
        contentValues.put(TRACKED_QUERY_LAST_USE_COLUMN_NAME, Long.valueOf(j));
        this.database.updateWithOnConflict(TRACKED_QUERY_TABLE, contentValues, "active = 1", new String[0], 5);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format(Locale.US, "Reset active tracked queries in %dms", Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void saveTrackedQuery(TrackedQuery trackedQuery) {
        verifyInsideTransaction();
        long jCurrentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TtmlNode.ATTR_ID, Long.valueOf(trackedQuery.id));
        contentValues.put("path", pathToKey(trackedQuery.querySpec.getPath()));
        contentValues.put(TRACKED_QUERY_PARAMS_COLUMN_NAME, trackedQuery.querySpec.getParams().toJSON());
        contentValues.put(TRACKED_QUERY_LAST_USE_COLUMN_NAME, Long.valueOf(trackedQuery.lastUse));
        contentValues.put(TRACKED_QUERY_COMPLETE_COLUMN_NAME, Boolean.valueOf(trackedQuery.complete));
        contentValues.put("active", Boolean.valueOf(trackedQuery.active));
        this.database.insertWithOnConflict(TRACKED_QUERY_TABLE, null, contentValues, 5);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format(Locale.US, "Saved new tracked query in %dms", Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void saveTrackedQueryKeys(long j, Set<ChildKey> set) {
        verifyInsideTransaction();
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.database.delete(TRACKED_KEYS_TABLE, "id = ?", new String[]{String.valueOf(j)});
        for (ChildKey childKey : set) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(TtmlNode.ATTR_ID, Long.valueOf(j));
            contentValues.put(TRACKED_KEYS_KEY_COLUMN_NAME, childKey.asString());
            this.database.insertWithOnConflict(TRACKED_KEYS_TABLE, null, contentValues, 5);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format(Locale.US, "Set %d tracked query keys for tracked query %d in %dms", Integer.valueOf(set.size()), Long.valueOf(j), Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void saveUserMerge(Path path, CompoundWrite compoundWrite, long j) {
        verifyInsideTransaction();
        long jCurrentTimeMillis = System.currentTimeMillis();
        saveWrite(path, j, WRITE_TYPE_MERGE, serializeObject(compoundWrite.getValue(true)));
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format(Locale.US, "Persisted user merge in %dms", Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void saveUserOverwrite(Path path, Node node, long j) {
        verifyInsideTransaction();
        long jCurrentTimeMillis = System.currentTimeMillis();
        saveWrite(path, j, WRITE_TYPE_OVERWRITE, serializeObject(node.getValue(true)));
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format(Locale.US, "Persisted user overwrite in %dms", Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public Node serverCache(Path path) {
        return loadNested(path);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public long serverCacheEstimatedSizeInBytes() {
        Cursor cursorRawQuery = this.database.rawQuery(String.format("SELECT sum(length(%s) + length(%s)) FROM %s", "value", "path", SERVER_CACHE_TABLE), null);
        try {
            if (cursorRawQuery.moveToFirst()) {
                return cursorRawQuery.getLong(0);
            }
            throw new IllegalStateException("Couldn't read database result!");
        } finally {
            cursorRawQuery.close();
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void setTransactionSuccessful() {
        this.database.setTransactionSuccessful();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void updateTrackedQueryKeys(long j, Set<ChildKey> set, Set<ChildKey> set2) {
        verifyInsideTransaction();
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strValueOf = String.valueOf(j);
        Iterator<ChildKey> it = set2.iterator();
        while (it.hasNext()) {
            this.database.delete(TRACKED_KEYS_TABLE, "id = ? AND key = ?", new String[]{strValueOf, it.next().asString()});
        }
        for (ChildKey childKey : set) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(TtmlNode.ATTR_ID, Long.valueOf(j));
            contentValues.put(TRACKED_KEYS_KEY_COLUMN_NAME, childKey.asString());
            this.database.insertWithOnConflict(TRACKED_KEYS_TABLE, null, contentValues, 5);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format(Locale.US, "Updated tracked query keys (%d added, %d removed) for tracked query id %d in %dms", Integer.valueOf(set.size()), Integer.valueOf(set2.size()), Long.valueOf(j), Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public Set<ChildKey> loadTrackedQueryKeys(Set<Long> set) {
        String[] strArr = {TRACKED_KEYS_KEY_COLUMN_NAME};
        long jCurrentTimeMillis = System.currentTimeMillis();
        Cursor cursorQuery = this.database.query(true, TRACKED_KEYS_TABLE, strArr, "id IN (" + commaSeparatedList(set) + ")", null, null, null, null, null);
        HashSet hashSet = new HashSet();
        while (cursorQuery.moveToNext()) {
            try {
                hashSet.add(ChildKey.fromString(cursorQuery.getString(0)));
            } finally {
                cursorQuery.close();
            }
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format(Locale.US, "Loaded %d tracked queries keys for tracked queries %s in %dms", Integer.valueOf(hashSet.size()), set.toString(), Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
        return hashSet;
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceStorageEngine
    public void mergeIntoServerCache(Path path, CompoundWrite compoundWrite) {
        verifyInsideTransaction();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator<Map.Entry<Path, Node>> it = compoundWrite.iterator();
        int iRemoveNested = 0;
        int iSaveNested = 0;
        while (it.hasNext()) {
            Map.Entry<Path, Node> next = it.next();
            iRemoveNested += removeNested(SERVER_CACHE_TABLE, path.child(next.getKey()));
            iSaveNested += saveNested(path.child(next.getKey()), next.getValue());
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format(Locale.US, "Persisted a total of %d rows and deleted %d rows for a merge at %s in %dms", Integer.valueOf(iSaveNested), Integer.valueOf(iRemoveNested), path.toString(), Long.valueOf(jCurrentTimeMillis2)), new Object[0]);
        }
    }
}

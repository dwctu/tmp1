package com.google.firebase.database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.DatabaseConfig;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.RepoManager;
import com.google.firebase.database.core.ValidationPath;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.utilities.ParsedUrl;
import com.google.firebase.database.core.utilities.PushIdGenerator;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes2.dex */
public class DatabaseReference extends Query {
    private static DatabaseConfig defaultConfig;

    public interface CompletionListener {
        void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference);
    }

    public DatabaseReference(Repo repo, Path path) {
        super(repo, path);
    }

    private static synchronized DatabaseConfig getDefaultConfig() {
        if (defaultConfig == null) {
            defaultConfig = new DatabaseConfig();
        }
        return defaultConfig;
    }

    public static void goOffline() {
        goOffline(getDefaultConfig());
    }

    public static void goOnline() {
        goOnline(getDefaultConfig());
    }

    private Task<Void> setPriorityInternal(final Node node, CompletionListener completionListener) throws DatabaseException {
        Validation.validateWritablePath(getPath());
        final Pair<Task<Void>, CompletionListener> pairWrapOnComplete = Utilities.wrapOnComplete(completionListener);
        this.repo.scheduleNow(new Runnable() { // from class: com.google.firebase.database.DatabaseReference.2
            @Override // java.lang.Runnable
            public void run() {
                DatabaseReference databaseReference = DatabaseReference.this;
                databaseReference.repo.setValue(databaseReference.getPath().child(ChildKey.getPriorityKey()), node, (CompletionListener) pairWrapOnComplete.getSecond());
            }
        });
        return pairWrapOnComplete.getFirst();
    }

    private Task<Void> setValueInternal(Object obj, Node node, CompletionListener completionListener) throws DatabaseException {
        Validation.validateWritablePath(getPath());
        ValidationPath.validateWithObject(getPath(), obj);
        Object objConvertToPlainJavaTypes = CustomClassMapper.convertToPlainJavaTypes(obj);
        Validation.validateWritableObject(objConvertToPlainJavaTypes);
        final Node nodeNodeFromJSON = NodeUtilities.NodeFromJSON(objConvertToPlainJavaTypes, node);
        final Pair<Task<Void>, CompletionListener> pairWrapOnComplete = Utilities.wrapOnComplete(completionListener);
        this.repo.scheduleNow(new Runnable() { // from class: com.google.firebase.database.DatabaseReference.1
            @Override // java.lang.Runnable
            public void run() {
                DatabaseReference databaseReference = DatabaseReference.this;
                databaseReference.repo.setValue(databaseReference.getPath(), nodeNodeFromJSON, (CompletionListener) pairWrapOnComplete.getSecond());
            }
        });
        return pairWrapOnComplete.getFirst();
    }

    private Task<Void> updateChildrenInternal(Map<String, Object> map, CompletionListener completionListener) {
        Objects.requireNonNull(map, "Can't pass null for argument 'update' in updateChildren()");
        final Map<String, Object> mapConvertToPlainJavaTypes = CustomClassMapper.convertToPlainJavaTypes(map);
        final CompoundWrite compoundWriteFromPathMerge = CompoundWrite.fromPathMerge(Validation.parseAndValidateUpdate(getPath(), mapConvertToPlainJavaTypes));
        final Pair<Task<Void>, CompletionListener> pairWrapOnComplete = Utilities.wrapOnComplete(completionListener);
        this.repo.scheduleNow(new Runnable() { // from class: com.google.firebase.database.DatabaseReference.3
            @Override // java.lang.Runnable
            public void run() {
                DatabaseReference databaseReference = DatabaseReference.this;
                databaseReference.repo.updateChildren(databaseReference.getPath(), compoundWriteFromPathMerge, (CompletionListener) pairWrapOnComplete.getSecond(), mapConvertToPlainJavaTypes);
            }
        });
        return pairWrapOnComplete.getFirst();
    }

    @NonNull
    public DatabaseReference child(@NonNull String str) throws DatabaseException {
        Objects.requireNonNull(str, "Can't pass null for argument 'pathString' in child()");
        if (getPath().isEmpty()) {
            Validation.validateRootPathString(str);
        } else {
            Validation.validatePathString(str);
        }
        return new DatabaseReference(this.repo, getPath().child(new Path(str)));
    }

    public boolean equals(Object obj) {
        return (obj instanceof DatabaseReference) && toString().equals(obj.toString());
    }

    @NonNull
    public FirebaseDatabase getDatabase() {
        return this.repo.getDatabase();
    }

    @Nullable
    public String getKey() {
        if (getPath().isEmpty()) {
            return null;
        }
        return getPath().getBack().asString();
    }

    @Nullable
    public DatabaseReference getParent() {
        Path parent = getPath().getParent();
        if (parent != null) {
            return new DatabaseReference(this.repo, parent);
        }
        return null;
    }

    @NonNull
    public DatabaseReference getRoot() {
        return new DatabaseReference(this.repo, new Path(""));
    }

    public int hashCode() {
        return toString().hashCode();
    }

    @NonNull
    public OnDisconnect onDisconnect() throws DatabaseException {
        Validation.validateWritablePath(getPath());
        return new OnDisconnect(this.repo, getPath());
    }

    @NonNull
    public DatabaseReference push() {
        return new DatabaseReference(this.repo, getPath().child(ChildKey.fromString(PushIdGenerator.generatePushChildName(this.repo.getServerTime()))));
    }

    @NonNull
    public Task<Void> removeValue() {
        return setValue(null);
    }

    public void runTransaction(@NonNull Transaction.Handler handler) throws DatabaseException {
        runTransaction(handler, true);
    }

    public void setHijackHash(final boolean z) {
        this.repo.scheduleNow(new Runnable() { // from class: com.google.firebase.database.DatabaseReference.5
            @Override // java.lang.Runnable
            public void run() {
                DatabaseReference.this.repo.setHijackHash(z);
            }
        });
    }

    @NonNull
    public Task<Void> setPriority(@Nullable Object obj) {
        return setPriorityInternal(PriorityUtilities.parsePriority(this.path, obj), null);
    }

    @NonNull
    public Task<Void> setValue(@Nullable Object obj) {
        return setValueInternal(obj, PriorityUtilities.parsePriority(this.path, null), null);
    }

    public String toString() {
        DatabaseReference parent = getParent();
        if (parent == null) {
            return this.repo.toString();
        }
        try {
            return parent.toString() + "/" + URLEncoder.encode(getKey(), "UTF-8").replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            throw new DatabaseException("Failed to URLEncode key: " + getKey(), e);
        }
    }

    @NonNull
    public Task<Void> updateChildren(@NonNull Map<String, Object> map) {
        return updateChildrenInternal(map, null);
    }

    public DatabaseReference(String str, DatabaseConfig databaseConfig) {
        this(Utilities.parseUrl(str), databaseConfig);
    }

    public static void goOffline(DatabaseConfig databaseConfig) {
        RepoManager.interrupt(databaseConfig);
    }

    public static void goOnline(DatabaseConfig databaseConfig) {
        RepoManager.resume(databaseConfig);
    }

    public void removeValue(@Nullable CompletionListener completionListener) throws DatabaseException {
        setValue((Object) null, completionListener);
    }

    public void runTransaction(@NonNull final Transaction.Handler handler, final boolean z) throws DatabaseException {
        Objects.requireNonNull(handler, "Can't pass null for argument 'handler' in runTransaction()");
        Validation.validateWritablePath(getPath());
        this.repo.scheduleNow(new Runnable() { // from class: com.google.firebase.database.DatabaseReference.4
            @Override // java.lang.Runnable
            public void run() {
                DatabaseReference databaseReference = DatabaseReference.this;
                databaseReference.repo.startTransaction(databaseReference.getPath(), handler, z);
            }
        });
    }

    public void setPriority(@Nullable Object obj, @Nullable CompletionListener completionListener) throws DatabaseException {
        setPriorityInternal(PriorityUtilities.parsePriority(this.path, obj), completionListener);
    }

    @NonNull
    public Task<Void> setValue(@Nullable Object obj, @Nullable Object obj2) {
        return setValueInternal(obj, PriorityUtilities.parsePriority(this.path, obj2), null);
    }

    public void updateChildren(@NonNull Map<String, Object> map, @Nullable CompletionListener completionListener) {
        updateChildrenInternal(map, completionListener);
    }

    private DatabaseReference(ParsedUrl parsedUrl, DatabaseConfig databaseConfig) {
        this(RepoManager.getRepo(databaseConfig, parsedUrl.repoInfo), parsedUrl.path);
    }

    public void setValue(@Nullable Object obj, @Nullable CompletionListener completionListener) throws DatabaseException {
        setValueInternal(obj, PriorityUtilities.parsePriority(this.path, null), completionListener);
    }

    public void setValue(@Nullable Object obj, @Nullable Object obj2, @Nullable CompletionListener completionListener) throws DatabaseException {
        setValueInternal(obj, PriorityUtilities.parsePriority(this.path, obj2), completionListener);
    }
}

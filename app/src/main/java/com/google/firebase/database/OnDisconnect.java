package com.google.firebase.database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.ValidationPath;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.utilities.encoding.CustomClassMapper;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.PriorityUtilities;
import java.util.Map;

/* loaded from: classes2.dex */
public class OnDisconnect {
    private Path path;
    private Repo repo;

    public OnDisconnect(Repo repo, Path path) {
        this.repo = repo;
        this.path = path;
    }

    private Task<Void> cancelInternal(DatabaseReference.CompletionListener completionListener) {
        final Pair<Task<Void>, DatabaseReference.CompletionListener> pairWrapOnComplete = Utilities.wrapOnComplete(completionListener);
        this.repo.scheduleNow(new Runnable() { // from class: com.google.firebase.database.OnDisconnect.3
            @Override // java.lang.Runnable
            public void run() {
                OnDisconnect.this.repo.onDisconnectCancel(OnDisconnect.this.path, (DatabaseReference.CompletionListener) pairWrapOnComplete.getSecond());
            }
        });
        return pairWrapOnComplete.getFirst();
    }

    private Task<Void> onDisconnectSetInternal(Object obj, Node node, DatabaseReference.CompletionListener completionListener) throws DatabaseException {
        Validation.validateWritablePath(this.path);
        ValidationPath.validateWithObject(this.path, obj);
        Object objConvertToPlainJavaTypes = CustomClassMapper.convertToPlainJavaTypes(obj);
        Validation.validateWritableObject(objConvertToPlainJavaTypes);
        final Node nodeNodeFromJSON = NodeUtilities.NodeFromJSON(objConvertToPlainJavaTypes, node);
        final Pair<Task<Void>, DatabaseReference.CompletionListener> pairWrapOnComplete = Utilities.wrapOnComplete(completionListener);
        this.repo.scheduleNow(new Runnable() { // from class: com.google.firebase.database.OnDisconnect.1
            @Override // java.lang.Runnable
            public void run() {
                OnDisconnect.this.repo.onDisconnectSetValue(OnDisconnect.this.path, nodeNodeFromJSON, (DatabaseReference.CompletionListener) pairWrapOnComplete.getSecond());
            }
        });
        return pairWrapOnComplete.getFirst();
    }

    private Task<Void> updateChildrenInternal(final Map<String, Object> map, DatabaseReference.CompletionListener completionListener) throws DatabaseException {
        final Map<Path, Node> andValidateUpdate = Validation.parseAndValidateUpdate(this.path, map);
        final Pair<Task<Void>, DatabaseReference.CompletionListener> pairWrapOnComplete = Utilities.wrapOnComplete(completionListener);
        this.repo.scheduleNow(new Runnable() { // from class: com.google.firebase.database.OnDisconnect.2
            @Override // java.lang.Runnable
            public void run() {
                OnDisconnect.this.repo.onDisconnectUpdate(OnDisconnect.this.path, andValidateUpdate, (DatabaseReference.CompletionListener) pairWrapOnComplete.getSecond(), map);
            }
        });
        return pairWrapOnComplete.getFirst();
    }

    @NonNull
    public Task<Void> cancel() {
        return cancelInternal(null);
    }

    @NonNull
    public Task<Void> removeValue() {
        return setValue(null);
    }

    @NonNull
    public Task<Void> setValue(@Nullable Object obj) {
        return onDisconnectSetInternal(obj, PriorityUtilities.NullPriority(), null);
    }

    @NonNull
    public Task<Void> updateChildren(@NonNull Map<String, Object> map) {
        return updateChildrenInternal(map, null);
    }

    public void cancel(@NonNull DatabaseReference.CompletionListener completionListener) {
        cancelInternal(completionListener);
    }

    public void removeValue(@Nullable DatabaseReference.CompletionListener completionListener) throws DatabaseException {
        setValue((Object) null, completionListener);
    }

    @NonNull
    public Task<Void> setValue(@Nullable Object obj, @Nullable String str) {
        return onDisconnectSetInternal(obj, PriorityUtilities.parsePriority(this.path, str), null);
    }

    public void updateChildren(@NonNull Map<String, Object> map, @Nullable DatabaseReference.CompletionListener completionListener) throws DatabaseException {
        updateChildrenInternal(map, completionListener);
    }

    @NonNull
    public Task<Void> setValue(@Nullable Object obj, double d) {
        return onDisconnectSetInternal(obj, PriorityUtilities.parsePriority(this.path, Double.valueOf(d)), null);
    }

    public void setValue(@Nullable Object obj, @Nullable DatabaseReference.CompletionListener completionListener) throws DatabaseException {
        onDisconnectSetInternal(obj, PriorityUtilities.NullPriority(), completionListener);
    }

    public void setValue(@Nullable Object obj, @Nullable String str, @Nullable DatabaseReference.CompletionListener completionListener) throws DatabaseException {
        onDisconnectSetInternal(obj, PriorityUtilities.parsePriority(this.path, str), completionListener);
    }

    public void setValue(@Nullable Object obj, double d, @Nullable DatabaseReference.CompletionListener completionListener) throws DatabaseException {
        onDisconnectSetInternal(obj, PriorityUtilities.parsePriority(this.path, Double.valueOf(d)), completionListener);
    }

    public void setValue(@Nullable Object obj, @Nullable Map map, @Nullable DatabaseReference.CompletionListener completionListener) throws DatabaseException {
        onDisconnectSetInternal(obj, PriorityUtilities.parsePriority(this.path, map), completionListener);
    }
}

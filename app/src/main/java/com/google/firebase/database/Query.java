package com.google.firebase.database;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.core.ChildEventRegistration;
import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.Repo;
import com.google.firebase.database.core.ValueEventRegistration;
import com.google.firebase.database.core.ZombieEventManager;
import com.google.firebase.database.core.utilities.PushIdGenerator;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.database.core.view.QueryParams;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.snapshot.BooleanNode;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.DoubleNode;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.KeyIndex;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.PathIndex;
import com.google.firebase.database.snapshot.PriorityIndex;
import com.google.firebase.database.snapshot.PriorityUtilities;
import com.google.firebase.database.snapshot.StringNode;
import com.google.firebase.database.snapshot.ValueIndex;

/* loaded from: classes2.dex */
public class Query {
    private final boolean orderByCalled;
    public final QueryParams params;
    public final Path path;
    public final Repo repo;

    public Query(Repo repo, Path path, QueryParams queryParams, boolean z) throws DatabaseException {
        this.repo = repo;
        this.path = path;
        this.params = queryParams;
        this.orderByCalled = z;
        Utilities.hardAssert(queryParams.isValid(), "Validation of queries failed.");
    }

    private void addEventRegistration(final EventRegistration eventRegistration) {
        ZombieEventManager.getInstance().recordEventRegistration(eventRegistration);
        this.repo.scheduleNow(new Runnable() { // from class: com.google.firebase.database.Query.3
            @Override // java.lang.Runnable
            public void run() {
                Query.this.repo.addEventCallback(eventRegistration);
            }
        });
    }

    private void removeEventRegistration(final EventRegistration eventRegistration) {
        ZombieEventManager.getInstance().zombifyForRemove(eventRegistration);
        this.repo.scheduleNow(new Runnable() { // from class: com.google.firebase.database.Query.2
            @Override // java.lang.Runnable
            public void run() {
                Query.this.repo.removeEventCallback(eventRegistration);
            }
        });
    }

    private void validateEqualToCall() {
        if (this.params.hasStart()) {
            throw new IllegalArgumentException("Cannot combine equalTo() with startAt() or startAfter()");
        }
        if (this.params.hasEnd()) {
            throw new IllegalArgumentException("Cannot combine equalTo() with endAt() or endBefore()");
        }
    }

    private void validateLimit(QueryParams queryParams) {
        if (queryParams.hasStart() && queryParams.hasEnd() && queryParams.hasLimit() && !queryParams.hasAnchoredLimit()) {
            throw new IllegalArgumentException("Can't combine startAt(), startAfter(), endAt(), endBefore(), and limit(). Use limitToFirst() or limitToLast() instead");
        }
    }

    private void validateNoOrderByCall() {
        if (this.orderByCalled) {
            throw new IllegalArgumentException("You can't combine multiple orderBy calls!");
        }
    }

    private void validateQueryEndpoints(QueryParams queryParams) {
        if (!queryParams.getIndex().equals(KeyIndex.getInstance())) {
            if (queryParams.getIndex().equals(PriorityIndex.getInstance())) {
                if ((queryParams.hasStart() && !PriorityUtilities.isValidPriority(queryParams.getIndexStartValue())) || (queryParams.hasEnd() && !PriorityUtilities.isValidPriority(queryParams.getIndexEndValue()))) {
                    throw new IllegalArgumentException("When using orderByPriority(), values provided to startAt(), startAfter(), endAt(), endBefore(), or equalTo() must be valid priorities.");
                }
                return;
            }
            return;
        }
        if (queryParams.hasStart()) {
            Node indexStartValue = queryParams.getIndexStartValue();
            if (!Objects.equal(queryParams.getIndexStartName(), ChildKey.getMinName()) || !(indexStartValue instanceof StringNode)) {
                throw new IllegalArgumentException("You must use startAt(String value), startAfter(String value), endAt(String value), endBefore(String value) or equalTo(String value) in combination with orderByKey(). Other type of values or using the version with 2 parameters is not supported");
            }
        }
        if (queryParams.hasEnd()) {
            Node indexEndValue = queryParams.getIndexEndValue();
            if (!queryParams.getIndexEndName().equals(ChildKey.getMaxName()) || !(indexEndValue instanceof StringNode)) {
                throw new IllegalArgumentException("You must use startAt(String value), startAfter(String value), endAt(String value), endBefore(String value) or equalTo(String value) in combination with orderByKey(). Other type of values or using the version with 2 parameters is not supported");
            }
        }
    }

    @NonNull
    public ChildEventListener addChildEventListener(@NonNull ChildEventListener childEventListener) {
        addEventRegistration(new ChildEventRegistration(this.repo, childEventListener, getSpec()));
        return childEventListener;
    }

    public void addListenerForSingleValueEvent(@NonNull final ValueEventListener valueEventListener) {
        addEventRegistration(new ValueEventRegistration(this.repo, new ValueEventListener() { // from class: com.google.firebase.database.Query.1
            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError databaseError) {
                valueEventListener.onCancelled(databaseError);
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot dataSnapshot) {
                Query.this.removeEventListener(this);
                valueEventListener.onDataChange(dataSnapshot);
            }
        }, getSpec()));
    }

    @NonNull
    public ValueEventListener addValueEventListener(@NonNull ValueEventListener valueEventListener) {
        addEventRegistration(new ValueEventRegistration(this.repo, valueEventListener, getSpec()));
        return valueEventListener;
    }

    @NonNull
    public Query endAt(@Nullable String str) {
        return endAt(str, (String) null);
    }

    @NonNull
    public Query endBefore(@Nullable String str) {
        return (str == null || !this.params.getIndex().equals(KeyIndex.getInstance())) ? endAt(str, ChildKey.getMinName().asString()) : endAt(PushIdGenerator.predecessor(str));
    }

    @NonNull
    public Query equalTo(@Nullable String str) {
        validateEqualToCall();
        return startAt(str).endAt(str);
    }

    @NonNull
    public Task<DataSnapshot> get() {
        return this.repo.getValue(this);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Path getPath() {
        return this.path;
    }

    @NonNull
    public DatabaseReference getRef() {
        return new DatabaseReference(this.repo, getPath());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Repo getRepo() {
        return this.repo;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public QuerySpec getSpec() {
        return new QuerySpec(this.path, this.params);
    }

    public void keepSynced(final boolean z) {
        if (!this.path.isEmpty() && this.path.getFront().equals(ChildKey.getInfoKey())) {
            throw new DatabaseException("Can't call keepSynced() on .info paths.");
        }
        this.repo.scheduleNow(new Runnable() { // from class: com.google.firebase.database.Query.4
            @Override // java.lang.Runnable
            public void run() {
                Query query = Query.this;
                query.repo.keepSynced(query.getSpec(), z);
            }
        });
    }

    @NonNull
    public Query limitToFirst(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Limit must be a positive integer!");
        }
        if (this.params.hasLimit()) {
            throw new IllegalArgumentException("Can't call limitToLast on query with previously set limit!");
        }
        return new Query(this.repo, this.path, this.params.limitToFirst(i), this.orderByCalled);
    }

    @NonNull
    public Query limitToLast(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Limit must be a positive integer!");
        }
        if (this.params.hasLimit()) {
            throw new IllegalArgumentException("Can't call limitToLast on query with previously set limit!");
        }
        return new Query(this.repo, this.path, this.params.limitToLast(i), this.orderByCalled);
    }

    @NonNull
    public Query orderByChild(@NonNull String str) throws DatabaseException {
        java.util.Objects.requireNonNull(str, "Key can't be null");
        if (str.equals("$key") || str.equals(".key")) {
            throw new IllegalArgumentException("Can't use '" + str + "' as path, please use orderByKey() instead!");
        }
        if (str.equals("$priority") || str.equals(".priority")) {
            throw new IllegalArgumentException("Can't use '" + str + "' as path, please use orderByPriority() instead!");
        }
        if (str.equals("$value") || str.equals(".value")) {
            throw new IllegalArgumentException("Can't use '" + str + "' as path, please use orderByValue() instead!");
        }
        Validation.validatePathString(str);
        validateNoOrderByCall();
        Path path = new Path(str);
        if (path.size() == 0) {
            throw new IllegalArgumentException("Can't use empty path, use orderByValue() instead!");
        }
        return new Query(this.repo, this.path, this.params.orderBy(new PathIndex(path)), true);
    }

    @NonNull
    public Query orderByKey() {
        validateNoOrderByCall();
        QueryParams queryParamsOrderBy = this.params.orderBy(KeyIndex.getInstance());
        validateQueryEndpoints(queryParamsOrderBy);
        return new Query(this.repo, this.path, queryParamsOrderBy, true);
    }

    @NonNull
    public Query orderByPriority() {
        validateNoOrderByCall();
        QueryParams queryParamsOrderBy = this.params.orderBy(PriorityIndex.getInstance());
        validateQueryEndpoints(queryParamsOrderBy);
        return new Query(this.repo, this.path, queryParamsOrderBy, true);
    }

    @NonNull
    public Query orderByValue() {
        validateNoOrderByCall();
        return new Query(this.repo, this.path, this.params.orderBy(ValueIndex.getInstance()), true);
    }

    public void removeEventListener(@NonNull ValueEventListener valueEventListener) {
        java.util.Objects.requireNonNull(valueEventListener, "listener must not be null");
        removeEventRegistration(new ValueEventRegistration(this.repo, valueEventListener, getSpec()));
    }

    @NonNull
    public Query startAfter(@Nullable String str) {
        return (str == null || !this.params.getIndex().equals(KeyIndex.getInstance())) ? startAt(str, ChildKey.getMaxName().asString()) : startAt(PushIdGenerator.successor(str));
    }

    @NonNull
    public Query startAt(@Nullable String str) {
        return startAt(str, (String) null);
    }

    @NonNull
    public Query endAt(double d) {
        return endAt(d, (String) null);
    }

    @NonNull
    public Query startAt(double d) {
        return startAt(d, (String) null);
    }

    @NonNull
    public Query endAt(boolean z) {
        return endAt(z, (String) null);
    }

    @NonNull
    public Query equalTo(double d) {
        validateEqualToCall();
        return startAt(d).endAt(d);
    }

    public void removeEventListener(@NonNull ChildEventListener childEventListener) {
        java.util.Objects.requireNonNull(childEventListener, "listener must not be null");
        removeEventRegistration(new ChildEventRegistration(this.repo, childEventListener, getSpec()));
    }

    @NonNull
    public Query startAt(boolean z) {
        return startAt(z, (String) null);
    }

    @NonNull
    public Query endAt(@Nullable String str, @Nullable String str2) {
        return endAt(str != null ? new StringNode(str, PriorityUtilities.NullPriority()) : EmptyNode.Empty(), str2);
    }

    @NonNull
    public Query endBefore(double d) {
        return endAt(d, ChildKey.getMinName().asString());
    }

    @NonNull
    public Query startAfter(double d) {
        return startAt(d, ChildKey.getMaxName().asString());
    }

    @NonNull
    public Query startAt(@Nullable String str, @Nullable String str2) {
        return startAt(str != null ? new StringNode(str, PriorityUtilities.NullPriority()) : EmptyNode.Empty(), str2);
    }

    @NonNull
    public Query endBefore(boolean z) {
        return endAt(z, ChildKey.getMinName().asString());
    }

    @NonNull
    public Query equalTo(boolean z) {
        validateEqualToCall();
        return startAt(z).endAt(z);
    }

    @NonNull
    public Query startAfter(boolean z) {
        return startAt(z, ChildKey.getMaxName().asString());
    }

    @NonNull
    public Query endAt(double d, @Nullable String str) {
        return endAt(new DoubleNode(Double.valueOf(d), PriorityUtilities.NullPriority()), str);
    }

    @NonNull
    public Query endBefore(@Nullable String str, @Nullable String str2) throws DatabaseException {
        if (str != null && this.params.getIndex().equals(KeyIndex.getInstance())) {
            str = PushIdGenerator.predecessor(str);
        }
        return endBefore(str != null ? new StringNode(str, PriorityUtilities.NullPriority()) : EmptyNode.Empty(), str2);
    }

    @NonNull
    public Query startAfter(@Nullable String str, @Nullable String str2) throws DatabaseException {
        if (str != null && this.params.getIndex().equals(KeyIndex.getInstance())) {
            str = PushIdGenerator.successor(str);
        }
        return startAfter(str != null ? new StringNode(str, PriorityUtilities.NullPriority()) : EmptyNode.Empty(), str2);
    }

    @NonNull
    public Query startAt(double d, @Nullable String str) {
        return startAt(new DoubleNode(Double.valueOf(d), PriorityUtilities.NullPriority()), str);
    }

    public Query(Repo repo, Path path) {
        this.repo = repo;
        this.path = path;
        this.params = QueryParams.DEFAULT_PARAMS;
        this.orderByCalled = false;
    }

    @NonNull
    public Query endAt(boolean z, @Nullable String str) {
        return endAt(new BooleanNode(Boolean.valueOf(z), PriorityUtilities.NullPriority()), str);
    }

    @NonNull
    public Query equalTo(@Nullable String str, @Nullable String str2) {
        validateEqualToCall();
        return startAt(str, str2).endAt(str, str2);
    }

    @NonNull
    public Query startAt(boolean z, @Nullable String str) {
        return startAt(new BooleanNode(Boolean.valueOf(z), PriorityUtilities.NullPriority()), str);
    }

    private Query endAt(Node node, String str) throws DatabaseException {
        Validation.validateNullableKey(str);
        if (!node.isLeafNode() && !node.isEmpty()) {
            throw new IllegalArgumentException("Can only use simple values for endAt()");
        }
        ChildKey childKeyFromString = str != null ? ChildKey.fromString(str) : null;
        if (!this.params.hasEnd()) {
            QueryParams queryParamsEndAt = this.params.endAt(node, childKeyFromString);
            validateLimit(queryParamsEndAt);
            validateQueryEndpoints(queryParamsEndAt);
            Utilities.hardAssert(queryParamsEndAt.isValid());
            return new Query(this.repo, this.path, queryParamsEndAt, this.orderByCalled);
        }
        throw new IllegalArgumentException("Can't call endAt() or equalTo() multiple times");
    }

    private Query startAt(Node node, String str) throws DatabaseException {
        Validation.validateNullableKey(str);
        if (!node.isLeafNode() && !node.isEmpty()) {
            throw new IllegalArgumentException("Can only use simple values for startAt() and startAfter()");
        }
        if (!this.params.hasStart()) {
            ChildKey childKeyFromString = null;
            if (str != null) {
                if (str.equals(ChildKey.MIN_KEY_NAME)) {
                    childKeyFromString = ChildKey.getMinName();
                } else if (str.equals(ChildKey.MAX_KEY_NAME)) {
                    childKeyFromString = ChildKey.getMaxName();
                } else {
                    childKeyFromString = ChildKey.fromString(str);
                }
            }
            QueryParams queryParamsStartAt = this.params.startAt(node, childKeyFromString);
            validateLimit(queryParamsStartAt);
            validateQueryEndpoints(queryParamsStartAt);
            Utilities.hardAssert(queryParamsStartAt.isValid());
            return new Query(this.repo, this.path, queryParamsStartAt, this.orderByCalled);
        }
        throw new IllegalArgumentException("Can't call startAt(), startAfte(), or equalTo() multiple times");
    }

    @NonNull
    public Query equalTo(double d, @Nullable String str) {
        validateEqualToCall();
        return startAt(d, str).endAt(d, str);
    }

    @NonNull
    public Query endBefore(double d, @Nullable String str) {
        return endBefore(new DoubleNode(Double.valueOf(d), PriorityUtilities.NullPriority()), str);
    }

    @NonNull
    public Query startAfter(double d, @Nullable String str) {
        return startAfter(new DoubleNode(Double.valueOf(d), PriorityUtilities.NullPriority()), str);
    }

    @NonNull
    public Query endBefore(boolean z, @Nullable String str) {
        return endBefore(new BooleanNode(Boolean.valueOf(z), PriorityUtilities.NullPriority()), str);
    }

    @NonNull
    public Query equalTo(boolean z, @Nullable String str) {
        validateEqualToCall();
        return startAt(z, str).endAt(z, str);
    }

    @NonNull
    public Query startAfter(boolean z, @Nullable String str) {
        return startAfter(new BooleanNode(Boolean.valueOf(z), PriorityUtilities.NullPriority()), str);
    }

    private Query endBefore(Node node, String str) {
        return endAt(node, PushIdGenerator.predecessor(str));
    }

    private Query startAfter(Node node, String str) {
        return startAt(node, PushIdGenerator.successor(str));
    }
}

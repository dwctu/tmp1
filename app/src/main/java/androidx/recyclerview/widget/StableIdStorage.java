package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.collection.LongSparseArray;

/* loaded from: classes.dex */
public interface StableIdStorage {

    public static class IsolatedStableIdStorage implements StableIdStorage {
        public long mNextStableId = 0;

        public class WrapperStableIdLookup implements StableIdLookup {
            private final LongSparseArray<Long> mLocalToGlobalLookup = new LongSparseArray<>();

            public WrapperStableIdLookup() {
            }

            @Override // androidx.recyclerview.widget.StableIdStorage.StableIdLookup
            public long localToGlobal(long j) {
                Long lValueOf = this.mLocalToGlobalLookup.get(j);
                if (lValueOf == null) {
                    lValueOf = Long.valueOf(IsolatedStableIdStorage.this.obtainId());
                    this.mLocalToGlobalLookup.put(j, lValueOf);
                }
                return lValueOf.longValue();
            }
        }

        @Override // androidx.recyclerview.widget.StableIdStorage
        @NonNull
        public StableIdLookup createStableIdLookup() {
            return new WrapperStableIdLookup();
        }

        public long obtainId() {
            long j = this.mNextStableId;
            this.mNextStableId = 1 + j;
            return j;
        }
    }

    public static class NoStableIdStorage implements StableIdStorage {
        private final StableIdLookup mNoIdLookup = new StableIdLookup() { // from class: androidx.recyclerview.widget.StableIdStorage.NoStableIdStorage.1
            @Override // androidx.recyclerview.widget.StableIdStorage.StableIdLookup
            public long localToGlobal(long j) {
                return -1L;
            }
        };

        @Override // androidx.recyclerview.widget.StableIdStorage
        @NonNull
        public StableIdLookup createStableIdLookup() {
            return this.mNoIdLookup;
        }
    }

    public static class SharedPoolStableIdStorage implements StableIdStorage {
        private final StableIdLookup mSameIdLookup = new StableIdLookup() { // from class: androidx.recyclerview.widget.StableIdStorage.SharedPoolStableIdStorage.1
            @Override // androidx.recyclerview.widget.StableIdStorage.StableIdLookup
            public long localToGlobal(long j) {
                return j;
            }
        };

        @Override // androidx.recyclerview.widget.StableIdStorage
        @NonNull
        public StableIdLookup createStableIdLookup() {
            return this.mSameIdLookup;
        }
    }

    public interface StableIdLookup {
        long localToGlobal(long j);
    }

    @NonNull
    StableIdLookup createStableIdLookup();
}

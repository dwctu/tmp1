package okhttp3.internal.cache2;

import dc.fe4;
import dc.ge4;
import dc.nd4;
import dc.qd4;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;

/* loaded from: classes5.dex */
public final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    public static final qd4 PREFIX_CLEAN = qd4.h("OkHttp cache v1\n");
    public static final qd4 PREFIX_DIRTY = qd4.h("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    public final long bufferMaxSize;
    public boolean complete;
    public RandomAccessFile file;
    private final qd4 metadata;
    public int sourceCount;
    public fe4 upstream;
    public long upstreamPos;
    public Thread upstreamReader;
    public final nd4 upstreamBuffer = new nd4();
    public final nd4 buffer = new nd4();

    public class RelaySource implements fe4 {
        private FileOperator fileOperator;
        private long sourcePos;
        private final ge4 timeout = new ge4();

        public RelaySource() {
            this.fileOperator = new FileOperator(Relay.this.file.getChannel());
        }

        @Override // dc.fe4, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
        public void close() throws IOException {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            synchronized (Relay.this) {
                Relay relay = Relay.this;
                int i = relay.sourceCount - 1;
                relay.sourceCount = i;
                if (i == 0) {
                    RandomAccessFile randomAccessFile2 = relay.file;
                    relay.file = null;
                    randomAccessFile = randomAccessFile2;
                }
            }
            if (randomAccessFile != null) {
                Util.closeQuietly(randomAccessFile);
            }
        }

        @Override // dc.fe4
        public long read(nd4 nd4Var, long j) throws IOException {
            long j2;
            char c;
            Relay relay;
            if (this.fileOperator == null) {
                throw new IllegalStateException("closed");
            }
            synchronized (Relay.this) {
                while (true) {
                    long j3 = this.sourcePos;
                    Relay relay2 = Relay.this;
                    j2 = relay2.upstreamPos;
                    if (j3 != j2) {
                        long jF0 = j2 - relay2.buffer.f0();
                        long j4 = this.sourcePos;
                        if (j4 >= jF0) {
                            long jMin = Math.min(j, j2 - j4);
                            Relay.this.buffer.m(nd4Var, this.sourcePos - jF0, jMin);
                            this.sourcePos += jMin;
                            return jMin;
                        }
                        c = 2;
                    } else if (!relay2.complete) {
                        if (relay2.upstreamReader == null) {
                            relay2.upstreamReader = Thread.currentThread();
                            c = 1;
                            break;
                        }
                        this.timeout.waitUntilNotified(relay2);
                    } else {
                        return -1L;
                    }
                }
                if (c == 2) {
                    long jMin2 = Math.min(j, j2 - this.sourcePos);
                    this.fileOperator.read(this.sourcePos + 32, nd4Var, jMin2);
                    this.sourcePos += jMin2;
                    return jMin2;
                }
                try {
                    Relay relay3 = Relay.this;
                    long j5 = relay3.upstream.read(relay3.upstreamBuffer, relay3.bufferMaxSize);
                    if (j5 == -1) {
                        Relay.this.commit(j2);
                        synchronized (Relay.this) {
                            Relay relay4 = Relay.this;
                            relay4.upstreamReader = null;
                            relay4.notifyAll();
                        }
                        return -1L;
                    }
                    long jMin3 = Math.min(j5, j);
                    Relay.this.upstreamBuffer.m(nd4Var, 0L, jMin3);
                    this.sourcePos += jMin3;
                    this.fileOperator.write(j2 + 32, Relay.this.upstreamBuffer.clone(), j5);
                    synchronized (Relay.this) {
                        Relay relay5 = Relay.this;
                        relay5.buffer.write(relay5.upstreamBuffer, j5);
                        long jF02 = Relay.this.buffer.f0();
                        Relay relay6 = Relay.this;
                        if (jF02 > relay6.bufferMaxSize) {
                            nd4 nd4Var2 = relay6.buffer;
                            nd4Var2.skip(nd4Var2.f0() - Relay.this.bufferMaxSize);
                        }
                        relay = Relay.this;
                        relay.upstreamPos += j5;
                    }
                    synchronized (relay) {
                        Relay relay7 = Relay.this;
                        relay7.upstreamReader = null;
                        relay7.notifyAll();
                    }
                    return jMin3;
                } catch (Throwable th) {
                    synchronized (Relay.this) {
                        Relay relay8 = Relay.this;
                        relay8.upstreamReader = null;
                        relay8.notifyAll();
                        throw th;
                    }
                }
            }
        }

        @Override // dc.fe4
        public ge4 timeout() {
            return this.timeout;
        }
    }

    private Relay(RandomAccessFile randomAccessFile, fe4 fe4Var, long j, qd4 qd4Var, long j2) {
        this.file = randomAccessFile;
        this.upstream = fe4Var;
        this.complete = fe4Var == null;
        this.upstreamPos = j;
        this.metadata = qd4Var;
        this.bufferMaxSize = j2;
    }

    public static Relay edit(File file, fe4 fe4Var, qd4 qd4Var, long j) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        Relay relay = new Relay(randomAccessFile, fe4Var, 0L, qd4Var, j);
        randomAccessFile.setLength(0L);
        relay.writeHeader(PREFIX_DIRTY, -1L, -1L);
        return relay;
    }

    public static Relay read(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        nd4 nd4Var = new nd4();
        fileOperator.read(0L, nd4Var, 32L);
        if (!nd4Var.J(r2.s()).equals(PREFIX_CLEAN)) {
            throw new IOException("unreadable cache file");
        }
        long j = nd4Var.readLong();
        long j2 = nd4Var.readLong();
        nd4 nd4Var2 = new nd4();
        fileOperator.read(j + 32, nd4Var2, j2);
        return new Relay(randomAccessFile, null, j, nd4Var2.L(), 0L);
    }

    private void writeHeader(qd4 qd4Var, long j, long j2) throws IOException {
        nd4 nd4Var = new nd4();
        nd4Var.j0(qd4Var);
        nd4Var.q0(j);
        nd4Var.q0(j2);
        if (nd4Var.f0() != 32) {
            throw new IllegalArgumentException();
        }
        new FileOperator(this.file.getChannel()).write(0L, nd4Var, 32L);
    }

    private void writeMetadata(long j) throws IOException {
        nd4 nd4Var = new nd4();
        nd4Var.j0(this.metadata);
        new FileOperator(this.file.getChannel()).write(32 + j, nd4Var, this.metadata.s());
    }

    public void commit(long j) throws IOException {
        writeMetadata(j);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j, this.metadata.s());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        Util.closeQuietly(this.upstream);
        this.upstream = null;
    }

    public boolean isClosed() {
        return this.file == null;
    }

    public qd4 metadata() {
        return this.metadata;
    }

    public fe4 newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }
}

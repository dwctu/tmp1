package org.jivesoftware.smackx.bytestreams.socks5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.SmackException;

/* loaded from: classes5.dex */
public class Socks5Proxy {
    private static final Logger LOGGER = Logger.getLogger(Socks5Proxy.class.getName());
    private static boolean localSocks5ProxyEnabled = true;
    private static int localSocks5ProxyPort = -7777;
    private static Socks5Proxy socks5Server;
    private ServerSocket serverSocket;
    private Thread serverThread;
    private final Map<String, Socket> connectionMap = new ConcurrentHashMap();
    private final List<String> allowedConnections = Collections.synchronizedList(new LinkedList());
    private final Set<String> localAddresses = new LinkedHashSet(4);
    private Socks5ServerProcess serverProcess = new Socks5ServerProcess();

    public class Socks5ServerProcess implements Runnable {
        private Socks5ServerProcess() {
        }

        private void establishConnection(Socket socket) throws SmackException, IOException {
            boolean z;
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            if (dataInputStream.read() != 5) {
                throw new SmackException("Only SOCKS5 supported");
            }
            int i = dataInputStream.read();
            byte[] bArr = new byte[i];
            dataInputStream.readFully(bArr);
            byte[] bArr2 = new byte[2];
            bArr2[0] = 5;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = false;
                    break;
                } else {
                    if (bArr[i2] == 0) {
                        z = true;
                        break;
                    }
                    i2++;
                }
            }
            if (!z) {
                bArr2[1] = -1;
                dataOutputStream.write(bArr2);
                dataOutputStream.flush();
                throw new SmackException("Authentication method not supported");
            }
            bArr2[1] = 0;
            dataOutputStream.write(bArr2);
            dataOutputStream.flush();
            byte[] bArrReceiveSocks5Message = Socks5Utils.receiveSocks5Message(dataInputStream);
            String str = new String(bArrReceiveSocks5Message, 5, (int) bArrReceiveSocks5Message[4]);
            if (!Socks5Proxy.this.allowedConnections.contains(str)) {
                bArrReceiveSocks5Message[1] = 5;
                dataOutputStream.write(bArrReceiveSocks5Message);
                dataOutputStream.flush();
                throw new SmackException("Connection is not allowed");
            }
            bArrReceiveSocks5Message[1] = 0;
            dataOutputStream.write(bArrReceiveSocks5Message);
            dataOutputStream.flush();
            Socks5Proxy.this.connectionMap.put(str, socket);
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            while (true) {
                Socket socket = null;
                try {
                } catch (SocketException | IOException unused) {
                } catch (Exception unused2) {
                    if (0 != 0) {
                        socket.close();
                    }
                }
                if (!Socks5Proxy.this.serverSocket.isClosed() && !Thread.currentThread().isInterrupted()) {
                    establishConnection(Socks5Proxy.this.serverSocket.accept());
                }
                return;
            }
        }
    }

    private Socks5Proxy() throws SocketException {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            HashSet hashSet = new HashSet();
            Iterator it = Collections.list(networkInterfaces).iterator();
            while (it.hasNext()) {
                Iterator it2 = Collections.list(((NetworkInterface) it.next()).getInetAddresses()).iterator();
                while (it2.hasNext()) {
                    hashSet.add(((InetAddress) it2.next()).getHostAddress());
                }
            }
            if (hashSet.isEmpty()) {
                throw new IllegalStateException("Could not determine any local host address");
            }
            replaceLocalAddresses(hashSet);
        } catch (SocketException e) {
            throw new IllegalStateException(e);
        }
    }

    public static int getLocalSocks5ProxyPort() {
        return localSocks5ProxyPort;
    }

    public static synchronized Socks5Proxy getSocks5Proxy() {
        if (socks5Server == null) {
            socks5Server = new Socks5Proxy();
        }
        if (isLocalSocks5ProxyEnabled()) {
            socks5Server.start();
        }
        return socks5Server;
    }

    public static boolean isLocalSocks5ProxyEnabled() {
        return localSocks5ProxyEnabled;
    }

    public static void setLocalSocks5ProxyEnabled(boolean z) {
        localSocks5ProxyEnabled = z;
    }

    public static void setLocalSocks5ProxyPort(int i) {
        if (Math.abs(i) > 65535) {
            throw new IllegalArgumentException("localSocks5ProxyPort must be within (-65535,65535)");
        }
        localSocks5ProxyPort = i;
    }

    public void addLocalAddress(String str) {
        if (str == null) {
            return;
        }
        synchronized (this.localAddresses) {
            this.localAddresses.add(str);
        }
    }

    public void addTransfer(String str) {
        this.allowedConnections.add(str);
    }

    public List<String> getLocalAddresses() {
        LinkedList linkedList;
        synchronized (this.localAddresses) {
            linkedList = new LinkedList(this.localAddresses);
        }
        return linkedList;
    }

    public int getPort() {
        if (isRunning()) {
            return this.serverSocket.getLocalPort();
        }
        return -1;
    }

    public Socket getSocket(String str) {
        return this.connectionMap.get(str);
    }

    public boolean isRunning() {
        return this.serverSocket != null;
    }

    public boolean removeLocalAddress(String str) {
        boolean zRemove;
        synchronized (this.localAddresses) {
            zRemove = this.localAddresses.remove(str);
        }
        return zRemove;
    }

    public void removeTransfer(String str) {
        this.allowedConnections.remove(str);
        this.connectionMap.remove(str);
    }

    public void replaceLocalAddresses(Collection<String> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("list must not be null");
        }
        synchronized (this.localAddresses) {
            this.localAddresses.clear();
            this.localAddresses.addAll(collection);
        }
    }

    public synchronized void start() {
        if (isRunning()) {
            return;
        }
        try {
            if (getLocalSocks5ProxyPort() < 0) {
                int iAbs = Math.abs(getLocalSocks5ProxyPort());
                for (int i = 0; i < 65535 - iAbs; i++) {
                    try {
                        this.serverSocket = new ServerSocket(iAbs + i);
                        break;
                    } catch (IOException unused) {
                    }
                }
            } else {
                this.serverSocket = new ServerSocket(getLocalSocks5ProxyPort());
            }
            if (this.serverSocket != null) {
                Thread thread = new Thread(this.serverProcess);
                this.serverThread = thread;
                thread.start();
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "couldn't setup local SOCKS5 proxy on port " + getLocalSocks5ProxyPort(), (Throwable) e);
        }
    }

    public synchronized void stop() {
        if (isRunning()) {
            try {
                this.serverSocket.close();
            } catch (IOException unused) {
            }
            Thread thread = this.serverThread;
            if (thread != null && thread.isAlive()) {
                try {
                    this.serverThread.interrupt();
                    this.serverThread.join();
                } catch (InterruptedException unused2) {
                }
            }
            this.serverThread = null;
            this.serverSocket = null;
        }
    }
}

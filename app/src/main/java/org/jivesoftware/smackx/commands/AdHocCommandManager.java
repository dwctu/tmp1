package org.jivesoftware.smackx.commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.ConnectionCreationListener;
import org.jivesoftware.smack.Manager;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPConnectionRegistry;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler;
import org.jivesoftware.smack.iqrequest.IQRequestHandler;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.XMPPError;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.commands.AdHocCommand;
import org.jivesoftware.smackx.commands.packet.AdHocCommandData;
import org.jivesoftware.smackx.disco.AbstractNodeInformationProvider;
import org.jivesoftware.smackx.disco.ServiceDiscoveryManager;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.disco.packet.DiscoverItems;
import org.jivesoftware.smackx.xdata.Form;

/* loaded from: classes5.dex */
public class AdHocCommandManager extends Manager {
    public static final String NAMESPACE = "http://jabber.org/protocol/commands";
    private static final int SESSION_TIMEOUT = 120;
    private final Map<String, AdHocCommandInfo> commands;
    private final Map<String, LocalCommand> executingCommands;
    private final ServiceDiscoveryManager serviceDiscoveryManager;
    private Thread sessionsSweeper;
    private static final Logger LOGGER = Logger.getLogger(AdHocCommandManager.class.getName());
    private static Map<XMPPConnection, AdHocCommandManager> instances = new WeakHashMap();

    public static class AdHocCommandInfo {
        private LocalCommandFactory factory;
        private String name;
        private String node;
        private String ownerJID;

        public AdHocCommandInfo(String str, String str2, String str3, LocalCommandFactory localCommandFactory) {
            this.node = str;
            this.name = str2;
            this.ownerJID = str3;
            this.factory = localCommandFactory;
        }

        public LocalCommand getCommandInstance() throws IllegalAccessException, InstantiationException {
            return this.factory.getInstance();
        }

        public String getName() {
            return this.name;
        }

        public String getNode() {
            return this.node;
        }

        public String getOwnerJID() {
            return this.ownerJID;
        }
    }

    static {
        XMPPConnectionRegistry.addConnectionCreationListener(new ConnectionCreationListener() { // from class: org.jivesoftware.smackx.commands.AdHocCommandManager.1
            @Override // org.jivesoftware.smack.ConnectionCreationListener
            public void connectionCreated(XMPPConnection xMPPConnection) {
                AdHocCommandManager.getAddHocCommandsManager(xMPPConnection);
            }
        });
    }

    private AdHocCommandManager(XMPPConnection xMPPConnection) {
        super(xMPPConnection);
        this.commands = new ConcurrentHashMap();
        this.executingCommands = new ConcurrentHashMap();
        this.serviceDiscoveryManager = ServiceDiscoveryManager.getInstanceFor(xMPPConnection);
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).addFeature("http://jabber.org/protocol/commands");
        ServiceDiscoveryManager.getInstanceFor(xMPPConnection).setNodeInformationProvider("http://jabber.org/protocol/commands", new AbstractNodeInformationProvider() { // from class: org.jivesoftware.smackx.commands.AdHocCommandManager.2
            @Override // org.jivesoftware.smackx.disco.AbstractNodeInformationProvider, org.jivesoftware.smackx.disco.NodeInformationProvider
            public List<DiscoverItems.Item> getNodeItems() {
                ArrayList arrayList = new ArrayList();
                for (AdHocCommandInfo adHocCommandInfo : AdHocCommandManager.this.getRegisteredCommands()) {
                    DiscoverItems.Item item = new DiscoverItems.Item(adHocCommandInfo.getOwnerJID());
                    item.setName(adHocCommandInfo.getName());
                    item.setNode(adHocCommandInfo.getNode());
                    arrayList.add(item);
                }
                return arrayList;
            }
        });
        xMPPConnection.registerIQRequestHandler(new AbstractIqRequestHandler("command", "http://jabber.org/protocol/commands", IQ.Type.set, IQRequestHandler.Mode.async) { // from class: org.jivesoftware.smackx.commands.AdHocCommandManager.3
            @Override // org.jivesoftware.smack.iqrequest.AbstractIqRequestHandler, org.jivesoftware.smack.iqrequest.IQRequestHandler
            public IQ handleIQRequest(IQ iq) {
                try {
                    return AdHocCommandManager.this.processAdHocCommand((AdHocCommandData) iq);
                } catch (SmackException.NoResponseException | SmackException.NotConnectedException e) {
                    AdHocCommandManager.LOGGER.log(Level.INFO, "processAdHocCommand threw exceptino", e);
                    return null;
                }
            }
        });
        this.sessionsSweeper = null;
    }

    public static synchronized AdHocCommandManager getAddHocCommandsManager(XMPPConnection xMPPConnection) {
        AdHocCommandManager adHocCommandManager;
        adHocCommandManager = instances.get(xMPPConnection);
        if (adHocCommandManager == null) {
            adHocCommandManager = new AdHocCommandManager(xMPPConnection);
            instances.put(xMPPConnection, adHocCommandManager);
        }
        return adHocCommandManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Collection<AdHocCommandInfo> getRegisteredCommands() {
        return this.commands.values();
    }

    private LocalCommand newInstanceOfCmd(String str, String str2) throws XMPPException.XMPPErrorException {
        AdHocCommandInfo adHocCommandInfo = this.commands.get(str);
        try {
            LocalCommand commandInstance = adHocCommandInfo.getCommandInstance();
            commandInstance.setSessionID(str2);
            commandInstance.setName(adHocCommandInfo.getName());
            commandInstance.setNode(adHocCommandInfo.getNode());
            return commandInstance;
        } catch (IllegalAccessException unused) {
            throw new XMPPException.XMPPErrorException(new XMPPError(XMPPError.Condition.internal_server_error));
        } catch (InstantiationException unused2) {
            throw new XMPPException.XMPPErrorException(new XMPPError(XMPPError.Condition.internal_server_error));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public IQ processAdHocCommand(AdHocCommandData adHocCommandData) throws SmackException.NotConnectedException, SmackException.NoResponseException {
        AdHocCommandData adHocCommandData2 = new AdHocCommandData();
        adHocCommandData2.setTo(adHocCommandData.getFrom());
        adHocCommandData2.setStanzaId(adHocCommandData.getStanzaId());
        adHocCommandData2.setNode(adHocCommandData.getNode());
        adHocCommandData2.setId(adHocCommandData.getTo());
        String sessionID = adHocCommandData.getSessionID();
        String node = adHocCommandData.getNode();
        if (sessionID == null) {
            if (!this.commands.containsKey(node)) {
                return respondError(adHocCommandData2, XMPPError.Condition.item_not_found);
            }
            String strRandomString = StringUtils.randomString(15);
            try {
                LocalCommand localCommandNewInstanceOfCmd = newInstanceOfCmd(node, strRandomString);
                adHocCommandData2.setType(IQ.Type.result);
                localCommandNewInstanceOfCmd.setData(adHocCommandData2);
                if (!localCommandNewInstanceOfCmd.hasPermission(adHocCommandData.getFrom())) {
                    return respondError(adHocCommandData2, XMPPError.Condition.forbidden);
                }
                AdHocCommand.Action action = adHocCommandData.getAction();
                if (action != null && action.equals(AdHocCommand.Action.unknown)) {
                    return respondError(adHocCommandData2, XMPPError.Condition.bad_request, AdHocCommand.SpecificErrorCondition.malformedAction);
                }
                if (action != null && !action.equals(AdHocCommand.Action.execute)) {
                    return respondError(adHocCommandData2, XMPPError.Condition.bad_request, AdHocCommand.SpecificErrorCondition.badAction);
                }
                localCommandNewInstanceOfCmd.incrementStage();
                localCommandNewInstanceOfCmd.execute();
                if (localCommandNewInstanceOfCmd.isLastStage()) {
                    adHocCommandData2.setStatus(AdHocCommand.Status.completed);
                } else {
                    adHocCommandData2.setStatus(AdHocCommand.Status.executing);
                    this.executingCommands.put(strRandomString, localCommandNewInstanceOfCmd);
                    if (this.sessionsSweeper == null) {
                        Thread thread = new Thread(new Runnable() { // from class: org.jivesoftware.smackx.commands.AdHocCommandManager.6
                            @Override // java.lang.Runnable
                            public void run() throws InterruptedException {
                                while (true) {
                                    for (String str : AdHocCommandManager.this.executingCommands.keySet()) {
                                        LocalCommand localCommand = (LocalCommand) AdHocCommandManager.this.executingCommands.get(str);
                                        if (localCommand != null) {
                                            if (System.currentTimeMillis() - localCommand.getCreationDate() > 240000) {
                                                AdHocCommandManager.this.executingCommands.remove(str);
                                            }
                                        }
                                    }
                                    try {
                                        Thread.sleep(1000L);
                                    } catch (InterruptedException unused) {
                                    }
                                }
                            }
                        });
                        this.sessionsSweeper = thread;
                        thread.setDaemon(true);
                        this.sessionsSweeper.start();
                    }
                }
                return adHocCommandData2;
            } catch (XMPPException.XMPPErrorException e) {
                XMPPError xMPPError = e.getXMPPError();
                if (XMPPError.Type.CANCEL.equals(xMPPError.getType())) {
                    adHocCommandData2.setStatus(AdHocCommand.Status.canceled);
                    this.executingCommands.remove(strRandomString);
                }
                return respondError(adHocCommandData2, xMPPError);
            }
        }
        LocalCommand localCommand = this.executingCommands.get(sessionID);
        if (localCommand == null) {
            return respondError(adHocCommandData2, XMPPError.Condition.bad_request, AdHocCommand.SpecificErrorCondition.badSessionid);
        }
        if (System.currentTimeMillis() - localCommand.getCreationDate() > 120000) {
            this.executingCommands.remove(sessionID);
            return respondError(adHocCommandData2, XMPPError.Condition.not_allowed, AdHocCommand.SpecificErrorCondition.sessionExpired);
        }
        synchronized (localCommand) {
            AdHocCommand.Action action2 = adHocCommandData.getAction();
            if (action2 != null && action2.equals(AdHocCommand.Action.unknown)) {
                return respondError(adHocCommandData2, XMPPError.Condition.bad_request, AdHocCommand.SpecificErrorCondition.malformedAction);
            }
            if (action2 == null || AdHocCommand.Action.execute.equals(action2)) {
                action2 = localCommand.getExecuteAction();
            }
            if (!localCommand.isValidAction(action2)) {
                return respondError(adHocCommandData2, XMPPError.Condition.bad_request, AdHocCommand.SpecificErrorCondition.badAction);
            }
            try {
                adHocCommandData2.setType(IQ.Type.result);
                localCommand.setData(adHocCommandData2);
                if (AdHocCommand.Action.next.equals(action2)) {
                    localCommand.incrementStage();
                    localCommand.next(new Form(adHocCommandData.getForm()));
                    if (localCommand.isLastStage()) {
                        adHocCommandData2.setStatus(AdHocCommand.Status.completed);
                    } else {
                        adHocCommandData2.setStatus(AdHocCommand.Status.executing);
                    }
                } else if (AdHocCommand.Action.complete.equals(action2)) {
                    localCommand.incrementStage();
                    localCommand.complete(new Form(adHocCommandData.getForm()));
                    adHocCommandData2.setStatus(AdHocCommand.Status.completed);
                    this.executingCommands.remove(sessionID);
                } else if (AdHocCommand.Action.prev.equals(action2)) {
                    localCommand.decrementStage();
                    localCommand.prev();
                } else if (AdHocCommand.Action.cancel.equals(action2)) {
                    localCommand.cancel();
                    adHocCommandData2.setStatus(AdHocCommand.Status.canceled);
                    this.executingCommands.remove(sessionID);
                }
                return adHocCommandData2;
            } catch (XMPPException.XMPPErrorException e2) {
                XMPPError xMPPError2 = e2.getXMPPError();
                if (XMPPError.Type.CANCEL.equals(xMPPError2.getType())) {
                    adHocCommandData2.setStatus(AdHocCommand.Status.canceled);
                    this.executingCommands.remove(sessionID);
                }
                return respondError(adHocCommandData2, xMPPError2);
            }
        }
    }

    private IQ respondError(AdHocCommandData adHocCommandData, XMPPError.Condition condition) {
        return respondError(adHocCommandData, new XMPPError(condition));
    }

    public DiscoverItems discoverCommands(String str) throws SmackException, XMPPException {
        return this.serviceDiscoveryManager.discoverItems(str, "http://jabber.org/protocol/commands");
    }

    public RemoteCommand getRemoteCommand(String str, String str2) {
        return new RemoteCommand(connection(), str2, str);
    }

    public void publishCommands(String str) throws SmackException, XMPPException {
        DiscoverItems discoverItems = new DiscoverItems();
        for (AdHocCommandInfo adHocCommandInfo : getRegisteredCommands()) {
            DiscoverItems.Item item = new DiscoverItems.Item(adHocCommandInfo.getOwnerJID());
            item.setName(adHocCommandInfo.getName());
            item.setNode(adHocCommandInfo.getNode());
            discoverItems.addItem(item);
        }
        this.serviceDiscoveryManager.publishItems(str, "http://jabber.org/protocol/commands", discoverItems);
    }

    public void registerCommand(String str, String str2, final Class<? extends LocalCommand> cls) {
        registerCommand(str, str2, new LocalCommandFactory() { // from class: org.jivesoftware.smackx.commands.AdHocCommandManager.4
            @Override // org.jivesoftware.smackx.commands.LocalCommandFactory
            public LocalCommand getInstance() throws IllegalAccessException, InstantiationException {
                return (LocalCommand) cls.newInstance();
            }
        });
    }

    private static IQ respondError(AdHocCommandData adHocCommandData, XMPPError.Condition condition, AdHocCommand.SpecificErrorCondition specificErrorCondition) {
        return respondError(adHocCommandData, new XMPPError(condition, new AdHocCommandData.SpecificError(specificErrorCondition)));
    }

    public void registerCommand(String str, final String str2, LocalCommandFactory localCommandFactory) {
        this.commands.put(str, new AdHocCommandInfo(str, str2, connection().getUser(), localCommandFactory));
        this.serviceDiscoveryManager.setNodeInformationProvider(str, new AbstractNodeInformationProvider() { // from class: org.jivesoftware.smackx.commands.AdHocCommandManager.5
            @Override // org.jivesoftware.smackx.disco.AbstractNodeInformationProvider, org.jivesoftware.smackx.disco.NodeInformationProvider
            public List<String> getNodeFeatures() {
                ArrayList arrayList = new ArrayList();
                arrayList.add("http://jabber.org/protocol/commands");
                arrayList.add("jabber:x:data");
                return arrayList;
            }

            @Override // org.jivesoftware.smackx.disco.AbstractNodeInformationProvider, org.jivesoftware.smackx.disco.NodeInformationProvider
            public List<DiscoverInfo.Identity> getNodeIdentities() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new DiscoverInfo.Identity("automation", str2, "command-node"));
                return arrayList;
            }
        });
    }

    private static IQ respondError(AdHocCommandData adHocCommandData, XMPPError xMPPError) {
        adHocCommandData.setType(IQ.Type.error);
        adHocCommandData.setError(xMPPError);
        return adHocCommandData;
    }
}

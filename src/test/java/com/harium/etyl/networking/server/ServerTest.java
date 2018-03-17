package com.harium.etyl.networking.server;

import com.harium.etyl.networking.example.server.SimpleServerProtocol;
import com.harium.etyl.networking.core.protocol.Protocol;
import com.harium.etyl.networking.test.DummyServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServerTest {

    private String LISTENER_PREFIX = "/s";

    private DummyServer server;

    private int port = 10999;

    private SimpleServerProtocol serverProtocol;

    @Before
    public void setUp() {
        server = new DummyServer(port);

        serverProtocol = new SimpleServerProtocol(LISTENER_PREFIX, server);
        server.addProtocol(serverProtocol.getPrefix(), serverProtocol);

        server.start();
    }

    @After
    public void finish() {
        server.close();
    }

    @Test
    public void testStartServer() {
        Protocol simpleListener = server.getProtocol(LISTENER_PREFIX);

        Assert.assertFalse(server.getProtocols().isEmpty());
        Assert.assertNotNull(simpleListener);
        Assert.assertFalse(serverProtocol.receivedTcp());
    }

}

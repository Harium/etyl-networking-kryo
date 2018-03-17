package com.harium.etyl.networking.test;

import com.harium.etyl.networking.EtylClient;
import com.harium.etyl.networking.core.protocol.ProtocolHandler;

public class DummyClient extends EtylClient {

    public DummyClient(int tcpPort) {
        super(ProtocolHandler.LOCAL_HOST, tcpPort);
    }

}

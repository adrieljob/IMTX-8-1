// SnmpStatusService.java
package com.snmp;

import org.snmp4j.*;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.*;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class SnmpCheck {

    private static final String TARGET_IP = "10.10.103.103";
    private static final String COMMUNITY = "public";

    private static final Map<String, String> oidMappings = new HashMap<>();

    static {
        oidMappings.put("1", "1.3.6.1.4.1.43768.3.1.1.10.2.8.3.1.1.2.1");
        oidMappings.put("2", "1.3.6.1.4.1.43768.3.1.1.10.2.8.3.1.1.2.2");
        oidMappings.put("3", "1.3.6.1.4.1.43768.3.1.1.10.2.8.3.1.1.2.3");
        oidMappings.put("4", "1.3.6.1.4.1.43768.3.1.1.10.2.8.3.1.1.2.4");
        oidMappings.put("5", "1.3.6.1.4.1.43768.3.1.1.10.2.8.3.1.1.2.5");
        oidMappings.put("6", "1.3.6.1.4.1.43768.3.1.1.10.2.8.3.1.1.2.6");
        oidMappings.put("7", "1.3.6.1.4.1.43768.3.1.1.10.2.8.3.1.1.2.7");
        oidMappings.put("8", "1.3.6.1.4.1.43768.3.1.1.10.2.8.3.1.1.2.8");
    }

    public int getStatusByTxId(String txId) throws IOException {
        String oid = oidMappings.get(txId);
        if (oid == null) return -1;

        TransportMapping<UdpAddress> transport = new DefaultUdpTransportMapping();
        transport.listen();

        Snmp snmp = new Snmp(transport);
        Address targetAddress = GenericAddress.parse("udp:" + TARGET_IP + "/161");
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString(COMMUNITY));
        target.setAddress(targetAddress);
        target.setRetries(2);
        target.setTimeout(1000);
        target.setVersion(SnmpConstants.version2c);

        PDU pdu = new PDU();
        pdu.add(new VariableBinding(new OID(oid)));
        pdu.setType(PDU.GET);

        ResponseEvent responseEvent = snmp.send(pdu, target);

        if (responseEvent.getResponse() != null) {
            int status = responseEvent.getResponse().get(0).getVariable().toInt();
            snmp.close();
            transport.close();
            return status;
        } else {
            snmp.close();
            transport.close();
            return -1;
        }
    }
}

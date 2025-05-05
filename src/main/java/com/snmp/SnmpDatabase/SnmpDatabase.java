package com.snmp.SnmpDatabase;

import org.snmp4j.*;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.*;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class SnmpDatabase {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String targetAddress = "udp:10.10.103.103/161";
    private final String community = "public";

    public Map<String, String> getSnmpValues(String[] oids) {
        Map<String, String> values = new HashMap<>();

        try {
            TransportMapping<UdpAddress> transport = new DefaultUdpTransportMapping();
            Snmp snmp = new Snmp(transport);
            transport.listen();

            CommunityTarget target = new CommunityTarget();
            target.setCommunity(new OctetString(community));
            target.setVersion(SnmpConstants.version2c);
            target.setAddress(GenericAddress.parse(targetAddress));
            target.setRetries(2);
            target.setTimeout(1500);

            for (String oid : oids) {
                PDU pdu = new PDU();
                pdu.add(new VariableBinding(new OID(oid)));
                pdu.setType(PDU.GET);

                ResponseEvent response = snmp.get(pdu, target);
                if (response.getResponse() != null) {
                    values.put(oid, response.getResponse().get(0).toValueString());
                } else {
                    values.put(oid, "N/A");
                }
            }

            snmp.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return values;
    }

    public void saveData(String oid, String value) {
        System.out.println("Salvando OID: " + oid + " com valor: " + value);

        String sql = "INSERT INTO monitoramento2 (oid, valor) VALUES (?, ?)";

        try {
            jdbcTemplate.update(sql, oid, value);
            System.out.println("✅ Dados salvos no banco!");
        } catch (Exception e) {
            System.out.println("❌ Erro ao salvar no banco: " + e.getMessage());
            e.printStackTrace(); // Adiciona isso pra ver o stack trace completo
        }
    }
}

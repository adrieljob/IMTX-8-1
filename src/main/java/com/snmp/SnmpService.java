package com.snmp;

import org.springframework.stereotype.Service;
import org.snmp4j.*;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.*;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

@Service
public class SnmpService {

    private static final String SNMP_ADDRESS = "udp:10.10.103.103/161"; // Endereço SNMP do dispositivo
    private final String GRAFANA_API_URL = "http://localhost:3000/api/dashboards/uid/CMK14AAHk";
    private final String API_KEY = "glsa_uYeB0JJl3KQzii4VuF0TTK7wbTPUZ5Xx_0d31a169";

    // Método para buscar dados do SNMP
    public String getSnmpData(String oid) {
        Snmp snmp = null;
        TransportMapping<UdpAddress> transport = null;

        try {
            transport = new DefaultUdpTransportMapping();
            transport.listen();

            snmp = new Snmp(transport);

            CommunityTarget target = new CommunityTarget();
            target.setCommunity(new OctetString("public"));
            target.setAddress(GenericAddress.parse(SNMP_ADDRESS));
            target.setVersion(SnmpConstants.version2c);
            target.setRetries(5);
            target.setTimeout(10000);

            PDU pdu = new PDU();
            pdu.add(new VariableBinding(new OID(oid)));
            pdu.setType(PDU.GET);

            ResponseEvent response = snmp.send(pdu, target);

            if (response != null && response.getResponse() != null) {
                String valor = response.getResponse().get(0).getVariable().toString();
                System.out.println("📡 Recebido SNMP: OID = " + oid + ", Valor = " + valor);
                return valor;
            } else {
                return "Erro: Nenhuma resposta recebida do dispositivo SNMP.";
            }
        } catch (IOException e) {
            return "Erro na comunicação SNMP: " + e.getMessage();
        } finally {
            if (snmp != null) {
                try {
                    snmp.close();
                } catch (IOException e) {
                    System.err.println("Erro ao fechar conexão SNMP: " + e.getMessage());
                }
            }
            if (transport != null) {
                try {
                    transport.close();
                } catch (IOException e) {
                    System.err.println("Erro ao fechar transporte SNMP: " + e.getMessage());
                }
            }
        }
    }

    // Método para buscar dados do Grafana
    public String getGrafanaData() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_KEY);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(GRAFANA_API_URL, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }


}
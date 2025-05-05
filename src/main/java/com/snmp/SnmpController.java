package com.snmp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/snmp-data")
public class SnmpController {

    private final SnmpService snmpService;
    private final TransportStream transportStream;
    private final SnmpCheck  snmpCheck; // Adicione esta linha

    @Autowired
    public SnmpController(SnmpService snmpService, TransportStream transportStream, SnmpCheck snmpCheck) {
        this.snmpService = snmpService;
        this.transportStream = transportStream;
        this.snmpCheck = snmpCheck; // Inicialize o snmpStatusService
    }

    // Mapeamento das OIDs para os parâmetros
    private static final Map<String, String> oidMappings = new HashMap<>();

    static {
        // TX1
        oidMappings.put("TX1enable", "1.3.6.1.4.1.43768.3.1.1.10.2.8.3.1.1.2.1");           // TX1 enable/disable
        oidMappings.put("tensao36V.1", "1.3.6.1.4.1.43768.3.1.1.10.2.9.1.1.1.3.1");         // Tensão 36V
        oidMappings.put("tensao24V.1", "1.3.6.1.4.1.43768.3.1.1.10.2.9.1.1.1.2.1");         // Tensão 24V
        oidMappings.put("corrente.1", "1.3.6.1.4.1.43768.3.1.1.10.2.9.1.1.1.4.1");          // Corrente
        oidMappings.put("temperatura.1", "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.1.1.3.1");       // Temperatura
        oidMappings.put("temperaturaModulo.1", "1.3.6.1.4.1.43768.3.1.1.10.2.8.2.1.1.7.1"); // Temperatura do módulo
        oidMappings.put("fan1.1", "1.3.6.1.4.1.43768.3.1.1.10.2.8.2.1.1.13.1");             // FAN1 Velocidade
        oidMappings.put("fan2.1", "1.3.6.1.4.1.43768.3.1.1.10.2.8.2.1.1.14.1");             // FAN2 Velocidade
        oidMappings.put("frequencia.1", "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.1.1.4.1");        // Frequência
        oidMappings.put("ethernetCable.1", "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.3.1");    // Ethernet Cable Presente
        oidMappings.put("asiCable.1", "1.3.6.1.4.1.43768.3.1.1.10.2.5.3.1.1.1.2.1");        // ASI Cable Presente
        oidMappings.put("EthernetSpeed.1","1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.4.1");     // Ethernet Speed 1
        oidMappings.put("IPPacketRate.1","1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.5.1");      // IP Packet Rate 1
        oidMappings.put("StreamLocked.1","1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.6.1");      // Stream Locked 1
        oidMappings.put("FECAlarm.1","1.3.6.1.4.1.43768.3.1.1.10.2.10.3.1.1.3.1");          // FEC Alarm 1
        oidMappings.put("IPDecodingAlarm.1","1.3.6.1.4.1.43768.3.1.1.10.2.7.4.2.1.1.4.1");  // IP Decoding Alarm 1
        oidMappings.put("FECD.1","1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.1.1");           // FEC D 1
        oidMappings.put("FECL.1","1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.1.2");           // FEC L 1
        oidMappings.put("TimeOffset.1","1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.1.1.3.1");       // Time Offset 1
        oidMappings.put("InputBitrate.1","1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.6.1.1");     // Input Bitrate 1
        oidMappings.put("ASIFormat.1","1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.3.3.1");        // ASI Format 1
        oidMappings.put("10MHz.1","1.3.6.1.4.1.43768.3.1.1.10.2.7.4.1.1.2.1");              // 10 MHz 1
        oidMappings.put("1PPs.1","1.3.6.1.4.1.43768.3.1.1.10.2.7.4.1.1.3.1");               // 1 PPs 1

        // TX2
        oidMappings.put("TX2enabe", "1.3.6.1.4.1.43768.3.1.1.10.2.8.3.1.1.2.2");            //TX2 enable/disble
        oidMappings.put("tensao36V.2", "1.3.6.1.4.1.43768.3.1.1.10.2.9.1.1.1.3.2");         // Tensão 36V
        oidMappings.put("tensao24V.2", "1.3.6.1.4.1.43768.3.1.1.10.2.9.1.1.1.2.2");         // Tensão 24V
        oidMappings.put("corrente.2", "1.3.6.1.4.1.43768.3.1.1.10.2.9.1.1.1.4.2");          // Corrente
        oidMappings.put("temperatura.2", "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.1.1.3.2");       // Temperatura
        oidMappings.put("temperaturaModulo.2", "1.3.6.1.4.1.43768.3.1.1.10.2.8.2.1.1.7.2"); // Temperatura do módulo
        oidMappings.put("fan1.2", "1.3.6.1.4.1.43768.3.1.1.10.2.8.2.1.1.13.2");             // FAN1 Velocidade
        oidMappings.put("fan2.2", "1.3.6.1.4.1.43768.3.1.1.10.2.8.2.1.1.14.2");             // FAN2 Velocidade
        oidMappings.put("frequencia.2", "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.1.1.4.2");        // Frequência
        oidMappings.put("ethernetCable.2", "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.3.2");    // Ethernet Cable Presente
        oidMappings.put("asiCable.2", "1.3.6.1.4.1.43768.3.1.1.10.2.5.3.1.1.1.2.2");        // ASI Cable Presente
        oidMappings.put("EthernetSpeed.2","1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.4.2");     // Ethernet Speed 3
        oidMappings.put("IPPacketRate.2","1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.5.2");      // IP Packet Rate 3
        oidMappings.put("StreamLocked.2","1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.6.2");      // Stream Locked 3
        oidMappings.put("FECAlarm.2","1.3.6.1.4.1.43768.3.1.1.10.2.10.3.1.1.3.2");          // FEC Alarm 3
        oidMappings.put("IPDecodingAlarm.2","1.3.6.1.4.1.43768.3.1.1.10.2.7.4.2.1.1.4.2");  // IP Decoding Alarm 3
        oidMappings.put("FECD.2","1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.2.1");           // FEC D 3
        oidMappings.put("FECL.2","1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.2.2");           // FEC L 3
        oidMappings.put("TimeOffset.2","1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.1.1.3.2");       // Time Offset 3
        oidMappings.put("InputBitrate.","1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.6.2.1");      // Input Bitrate 3
        oidMappings.put("ASIFormat.2","1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.3.3.2");        // ASI Format 3
        oidMappings.put("10MHz.2","1.3.6.1.4.1.43768.3.1.1.10.2.7.4.1.1.2.2");              // 10 MHz 3
        oidMappings.put("1PPs.2","1.3.6.1.4.1.43768.3.1.1.10.2.7.4.1.1.3.2");               // 1 PPs 3

        // TX3
        oidMappings.put("TX3enable", "1.3.6.1.4.1.43768.3.1.1.10.2.8.3.1.1.2.3");           // TX3 enable/disable
        oidMappings.put("tensao36V.3", "1.3.6.1.4.1.43768.3.1.1.10.2.9.1.1.1.3.3");         // Tensão 36V
        oidMappings.put("tensao24V.3", "1.3.6.1.4.1.43768.3.1.1.10.2.9.1.1.1.2.3");         // Tensão 24V
        oidMappings.put("corrente.3", "1.3.6.1.4.1.43768.3.1.1.10.2.9.1.1.1.4.3");          // Corrente
        oidMappings.put("temperatura.3", "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.1.1.3.3");       // Temperatura
        oidMappings.put("temperaturaModulo.3", "1.3.6.1.4.1.43768.3.1.1.10.2.8.2.1.1.7.3"); // Temperatura do módulo
        oidMappings.put("fan1.3", "1.3.6.1.4.1.43768.3.1.1.10.2.8.2.1.1.13.3");             // FAN1 Velocidade
        oidMappings.put("fan2.3", "1.3.6.1.4.1.43768.3.1.1.10.2.8.2.1.1.14.3");             // FAN1 Velocidade
        oidMappings.put("frequencia.3", "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.1.1.4.3");        // Frequência
        oidMappings.put("ethernetCable.3", "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.3.3");    // Ethernet Cable Presente
        oidMappings.put("asiCable.3", "1.3.6.1.4.1.43768.3.1.1.10.2.5.3.1.1.1.2.3");        // ASI Cable Presente
        oidMappings.put("EthernetSpeed.3","1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.4.3");     // Ethernet Speed 3
        oidMappings.put("IPPacketRate.3","1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.5.3");      // IP Packet Rate 3
        oidMappings.put("StreamLocked.3","1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.6.3");      // Stream Locked 3
        oidMappings.put("FECAlarm.3","1.3.6.1.4.1.43768.3.1.1.10.2.10.3.1.1.3.3");          // FEC Alarm 3
        oidMappings.put("IPDecodingAlarm.3","1.3.6.1.4.1.43768.3.1.1.10.2.7.4.2.1.1.4.3");  // IP Decoding Alarm 3
        oidMappings.put("FECD.3","1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.3.1");           // FEC D 3
        oidMappings.put("FECL.3","1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.3.2");           // FEC L 3
        oidMappings.put("TimeOffset.3","1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.1.1.3.3");       // Time Offset 3
        oidMappings.put("InputBitrate.3","1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.6.3.1");     // Input Bitrate 3
        oidMappings.put("ASIFormat.3","1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.3.3.3");        // ASI Format 3
        oidMappings.put("10MHz.3","1.3.6.1.4.1.43768.3.1.1.10.2.7.4.1.1.2.3");              // 10 MHz 3
        oidMappings.put("1PPs.3","1.3.6.1.4.1.43768.3.1.1.10.2.7.4.1.1.3.3");               // 1 PPs 3

        // TX4
        oidMappings.put("TX4enabe", "1.3.6.1.4.1.43768.3.1.1.10.2.8.3.1.1.2.4");            // TX4 enable/disable
        oidMappings.put("tensao36V.4", "1.3.6.1.4.1.43768.3.1.1.10.2.9.1.1.1.3.4");         // Tensão 36V
        oidMappings.put("tensao24V.4", "1.3.6.1.4.1.43768.3.1.1.10.2.9.1.1.1.2.4");         // Tensão 24V
        oidMappings.put("corrente.4", "1.3.6.1.4.1.43768.3.1.1.10.2.9.1.1.1.4.4");          // Corrente
        oidMappings.put("temperatura.4", "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.1.1.3.4");       // Temperatura
        oidMappings.put("temperaturaModulo.4", "1.3.6.1.4.1.43768.3.1.1.10.2.8.2.1.1.7.4"); // Temperatura do módulo
        oidMappings.put("fan1.4", "1.3.6.1.4.1.43768.3.1.1.10.2.8.2.1.1.13.4");             // FAN1 Velocidade
        oidMappings.put("fan2.4", "1.3.6.1.4.1.43768.3.1.1.10.2.8.2.1.1.14.4");             // FAN2 Velocidade
        oidMappings.put("frequencia.4", "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.1.1.4.4");        // Frequência
        oidMappings.put("ethernetCable.4", "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.3.4");    // Ethernet Cable Presente
        oidMappings.put("asiCable.4", "1.3.6.1.4.1.43768.3.1.1.10.2.5.3.1.1.1.2.4");        // ASI Cable Presente
        oidMappings.put("EthernetSpeed.4","1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.4.4");     // Ethernet Speed 4
        oidMappings.put("IPPacketRate.4","1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.5.4");      // IP Packet Rate 4
        oidMappings.put("StreamLocked.4","1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.6.4");      // Stream Locked 4
        oidMappings.put("FECAlarm.4","1.3.6.1.4.1.43768.3.1.1.10.2.10.3.1.1.3.4");          // FEC Alarm 4
        oidMappings.put("IPDecodingAlarm.4","1.3.6.1.4.1.43768.3.1.1.10.2.7.4.2.1.1.4.4");  // IP Decoding Alarm 4
        oidMappings.put("FECD.4","1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.4.1");           // FEC D 4
        oidMappings.put("FECL.4","1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.4.2");           // FEC L 4
        oidMappings.put("TimeOffset.4","1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.1.1.3.4");       // Time Offset 4
        oidMappings.put("InputBitrate.4","1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.6.4.1");     // Input Bitrate 4
        oidMappings.put("ASIFormat.4","1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.3.3.4");        // ASI Format 4
        oidMappings.put("10MHz.4","1.3.6.1.4.1.43768.3.1.1.10.2.7.4.1.1.2.4");              // 10 MHz 4
        oidMappings.put("1PPs.4","1.3.6.1.4.1.43768.3.1.1.10.2.7.4.1.1.3.4");               // 1 PPs 4

        // TX5
        oidMappings.put("TX5enabe", "1.3.6.1.4.1.43768.3.1.1.10.2.8.3.1.1.2.5");            // TX5 enable/disable
        oidMappings.put("tensao36V.5", "1.3.6.1.4.1.43768.3.1.1.10.2.9.1.1.1.3.5");         // Tensão 36V
        oidMappings.put("tensao24V.5", "1.3.6.1.4.1.43768.3.1.1.10.2.9.1.1.1.2.5");         // Tensão 24V
        oidMappings.put("corrente.5", "1.3.6.1.4.1.43768.3.1.1.10.2.9.1.1.1.4.5");          // Corrente
        oidMappings.put("temperatura.5", "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.1.1.3.5");       // Temperatura
        oidMappings.put("temperaturaModulo.5", "1.3.6.1.4.1.43768.3.1.1.10.2.8.2.1.1.7.5"); // Temperatura do módulo
        oidMappings.put("fan1.5", "1.3.6.1.4.1.43768.3.1.1.10.2.8.2.1.1.13.5");             // FAN1 Velocidade
        oidMappings.put("fan2.5", "1.3.6.1.4.1.43768.3.1.1.10.2.8.2.1.1.14.5");             // FAN2 Velocidade
        oidMappings.put("frequencia.5", "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.1.1.4.5");        // Frequência
        oidMappings.put("ethernetCable.5", "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.3.5");    // Ethernet Cable Presente
        oidMappings.put("asiCable.5", "1.3.6.1.4.1.43768.3.1.1.10.2.5.3.1.1.1.2.5");        // ASI Cable Presente
        oidMappings.put("EthernetSpeed.5","1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.4.3");     // Ethernet Speed 5
        oidMappings.put("IPPacketRate.5","1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.5.5");      // IP Packet Rate 5
        oidMappings.put("StreamLocked.5","1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.6.5");      // Stream Locked 5
        oidMappings.put("FECAlarm.5","1.3.6.1.4.1.43768.3.1.1.10.2.10.3.1.1.3.5");          // FEC Alarm 5
        oidMappings.put("IPDecodingAlarm.5","1.3.6.1.4.1.43768.3.1.1.10.2.7.4.2.1.1.4.5");  // IP Decoding Alarm 5
        oidMappings.put("FECD.5","1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.5.1");           // FEC D 5
        oidMappings.put("FECL.5","1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.5.2");           // FEC L 5
        oidMappings.put("TimeOffset.5","1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.1.1.3.5");       // Time Offset 5
        oidMappings.put("InputBitrate.5","1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.6.5.1");     // Input Bitrate 5
        oidMappings.put("ASIFormat.5","1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.3.3.5");        // ASI Format 5
        oidMappings.put("10MHz.5","1.3.6.1.4.1.43768.3.1.1.10.2.7.4.1.1.2.5");              // 10 MHz 5
        oidMappings.put("1PPs.5","1.3.6.1.4.1.43768.3.1.1.10.2.7.4.1.1.3.5");               // 1 PPs 5

        // TX6
        oidMappings.put("TX6enable", "1.3.6.1.4.1.43768.3.1.1.10.2.8.3.1.1.2.6");           // TX6 enable/disable
        oidMappings.put("tensao36V.6", "1.3.6.1.4.1.43768.3.1.1.10.2.9.1.1.1.3.6");         // Tensão 36V
        oidMappings.put("tensao24V.6", "1.3.6.1.4.1.43768.3.1.1.10.2.9.1.1.1.2.6");         // Tensão V
        oidMappings.put("corrente.6", "1.3.6.1.4.1.43768.3.1.1.10.2.9.1.1.1.4.6");          // Corrente
        oidMappings.put("temperatura.6", "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.1.1.3.6");       // Temperatura
        oidMappings.put("temperaturaModulo.6", "1.3.6.1.4.1.43768.3.1.1.10.2.8.2.1.1.7.6"); // Temperatura do módulo
        oidMappings.put("fan1.6", "1.3.6.1.4.1.43768.3.1.1.10.2.8.2.1.1.13.6");             // FAN1 Velocidade
        oidMappings.put("fan2.6", "1.3.6.1.4.1.43768.3.1.1.10.2.8.2.1.1.14.6");             // FAN2 Velocidade
        oidMappings.put("frequencia.6", "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.1.1.4.6");        // Frequência
        oidMappings.put("ethernetCable.6", "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.3.6");    // Ethernet Cable Presente
        oidMappings.put("asiCable.6", "1.3.6.1.4.1.43768.3.1.1.10.2.5.3.1.1.1.2.6");        // ASI Cable Presente
        oidMappings.put("EthernetSpeed.6","1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.4.6");     // Ethernet Speed 6
        oidMappings.put("IPPacketRate.6","1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.5.6");      // IP Packet Rate 6
        oidMappings.put("StreamLocked.6","1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.6.6");      // Stream Locked 6
        oidMappings.put("FECAlarm.6","1.3.6.1.4.1.43768.3.1.1.10.2.10.3.1.1.3.6");          // FEC Alarm 6
        oidMappings.put("IPDecodingAlarm.6","1.3.6.1.4.1.43768.3.1.1.10.2.7.4.2.1.1.4.6");  // IP Decoding Alarm 6
        oidMappings.put("FECD.6","1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.6.1");           // FEC D 6
        oidMappings.put("FECL.6","1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.6.2");           // FEC L 6
        oidMappings.put("TimeOffset.6","1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.1.1.3.6");       // Time Offset 6
        oidMappings.put("InputBitrate.6","1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.6.6.1");     // Input Bitrate 6
        oidMappings.put("ASIFormat.6","1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.3.3.6");        // ASI Format 6
        oidMappings.put("10MHz.6","1.3.6.1.4.1.43768.3.1.1.10.2.7.4.1.1.2.6");              // 10 MHz 6
        oidMappings.put("1PPs.6","1.3.6.1.4.1.43768.3.1.1.10.2.7.4.1.1.3.6");               // 1 PPs 6

        // TX7
        oidMappings.put("TX7enable", "1.3.6.1.4.1.43768.3.1.1.10.2.8.3.1.1.2.7");           // TX7 enable/disable
        oidMappings.put("tensao36V.7", "1.3.6.1.4.1.43768.3.1.1.10.2.9.1.1.1.3.7");         // Tensão 36V
        oidMappings.put("tensao24V.7", "1.3.6.1.4.1.43768.3.1.1.10.2.9.1.1.1.2.7");         // Tensão 24V
        oidMappings.put("corrente.7", "1.3.6.1.4.1.43768.3.1.1.10.2.9.1.1.1.4.7");          // Corrente
        oidMappings.put("temperatura.7", "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.1.1.3.7");       // Temperatura
        oidMappings.put("temperaturaModulo.7", "1.3.6.1.4.1.43768.3.1.1.10.2.8.2.1.1.7.7"); // Temperatura do módulo
        oidMappings.put("fan1.7", "1.3.6.1.4.1.43768.3.1.1.10.2.8.2.1.1.13.7");             // FAN1 Velocidade
        oidMappings.put("fan2.7", "1.3.6.1.4.1.43768.3.1.1.10.2.8.2.1.1.14.7");             // FAN2 Velocidade
        oidMappings.put("frequencia.7", "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.1.1.4.7");        // Frequência
        oidMappings.put("ethernetCable.7", "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.3.7");    // Ethernet Cable Presente
        oidMappings.put("asiCable.7", "1.3.6.1.4.1.43768.3.1.1.10.2.5.3.1.1.1.2.7");        // ASI Cable Presente
        oidMappings.put("EthernetSpeed.7","1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.4.7");     // Ethernet Speed 7
        oidMappings.put("IPPacketRate.7","1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.5.7");      // IP Packet Rate 7
        oidMappings.put("StreamLocked.7","1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.6.7");      // Stream Locked 7
        oidMappings.put("FECAlarm.7","1.3.6.1.4.1.43768.3.1.1.10.2.10.3.1.1.3.7");          // FEC Alarm 7
        oidMappings.put("IPDecodingAlarm.7","1.3.6.1.4.1.43768.3.1.1.10.2.7.4.2.1.1.4.7");  // IP Decoding Alarm 7
        oidMappings.put("FECD.7","1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.7.1");           // FEC D 7
        oidMappings.put("FECL.7","1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.7.2");           // FEC L 7
        oidMappings.put("TimeOffset.7","1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.1.1.3.7");       // Time Offset 7
        oidMappings.put("InputBitrate.7","1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.6.7.1");     // Input Bitrate 7
        oidMappings.put("ASIFormat.7","1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.3.3.7");        // ASI Format 7
        oidMappings.put("10MHz.7","1.3.6.1.4.1.43768.3.1.1.10.2.7.4.1.1.2.7");              // 10 MHz 7
        oidMappings.put("1PPs.7","1.3.6.1.4.1.43768.3.1.1.10.2.7.4.1.1.3.7");               // 1 PPs 7

        // TX8
        oidMappings.put("TX8enable", "1.3.6.1.4.1.43768.3.1.1.10.2.8.3.1.1.2.8");           // TX8 enable/disable
        oidMappings.put("tensao36V.8", "1.3.6.1.4.1.43768.3.1.1.10.2.9.1.1.1.3.8");         // Tensão 36V
        oidMappings.put("tensao24V.8", "1.3.6.1.4.1.43768.3.1.1.10.2.9.1.1.1.2.8");         // Tensão 24V
        oidMappings.put("corrente.8", "1.3.6.1.4.1.43768.3.1.1.10.2.9.1.1.1.4.8");          // Corrente
        oidMappings.put("temperatura.8", "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.1.1.3.8");       // Temperatura
        oidMappings.put("temperaturaModulo.8", "1.3.6.1.4.1.43768.3.1.1.10.2.8.2.1.1.7.8"); // Temperatura do módulo
        oidMappings.put("fan1.8", "1.3.6.1.4.1.43768.3.1.1.10.2.8.2.1.1.13.8");             // FAN1 Velocidade
        oidMappings.put("fan2.8", "1.3.6.1.4.1.43768.3.1.1.10.2.8.2.1.1.14.8");             // FAN2 Velocidade
        oidMappings.put("frequencia.8", "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.1.1.4.8");        // Frequência
        oidMappings.put("ethernetCable.8", "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.3.8");    // Ethernet Cable Presente
        oidMappings.put("asiCable.8", "1.3.6.1.4.1.43768.3.1.1.10.2.5.3.1.1.1.2.8");        // ASI Cable Presente
        oidMappings.put("EthernetSpeed.8","1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.4.8");     // Ethernet Speed 8
        oidMappings.put("IPPacketRate.8","1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.5.8");      // IP Packet Rate 8
        oidMappings.put("StreamLocked.8","1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.6.8");      // Stream Locked 8
        oidMappings.put("FECAlarm.8","1.3.6.1.4.1.43768.3.1.1.10.2.10.3.1.1.3.8");          // FEC Alarm 8
        oidMappings.put("IPDecodingAlarm.8","1.3.6.1.4.1.43768.3.1.1.10.2.7.4.2.1.1.4.8");  // IP Decoding Alarm 8
        oidMappings.put("FECD.8","1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.8.1");           // FEC D 8
        oidMappings.put("FECL.8","1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.8.2");           // FEC L 8
        oidMappings.put("TimeOffset.8","1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.1.1.3.8");       // Time Offset 8
        oidMappings.put("InputBitrate.8","1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.6.8.1");     // Input Bitrate 8
        oidMappings.put("ASIFormat.8","1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.3.3.8");        // ASI Format 8
        oidMappings.put("10MHz.8","1.3.6.1.4.1.43768.3.1.1.10.2.7.4.1.1.2.8");              // 10 MHz 8
        oidMappings.put("1PPs.8","1.3.6.1.4.1.43768.3.1.1.10.2.7.4.1.1.3.8");               // 1 PPs 8

    }

    @GetMapping("/get-snmp")
    public String getSnmpData(@RequestParam String oid) {
        String mappedOid = oidMappings.get(oid);
        if (mappedOid == null) {
            return "Erro: OID não encontrado para " + oid;
        }
        return snmpService.getSnmpData(mappedOid);
    }

    @GetMapping("/{param}")
    public String getSnmpDataByParam(@PathVariable String param) {
        String oid = oidMappings.get(param);
        if (oid == null) {
            return "OID não encontrada para o parâmetro: " + param;
        }
        return snmpService.getSnmpData(oid);
    }

    @Value("${grafana.base.url}")
    private String grafanaBaseUrl;

    @Value("${grafana.panel.url}")
    private String grafanaPanelUrl;

    @Value("${grafana.auth.token}")
    private String grafanaAuthToken;

    @GetMapping("/grafana-url")
    public Map<String, String> getGrafanaPanelUrl(@RequestParam(name = "item", required = false) String panelId) {
        String url = grafanaBaseUrl + grafanaPanelUrl;
        if (panelId != null && !panelId.isEmpty()) {
            url += "&panelId=" + panelId;
        }

        Map<String, String> response = new HashMap<>();
        response.put("url", url);
        response.put("token", grafanaAuthToken); // opcional
        return response;
    }

    @GetMapping("/transport-stream")
    public List<Map<String, String>> getTransportStreamData() {
        List<Map<String, String>> streams = new ArrayList<>();

        Map<String, String> tx2 = new HashMap<>();
        tx2.put("programNumber", transportStream.getAsiFormat2(""));
        tx2.put("pcrPid", transportStream.getEthernetPacketRate2(""));
        tx2.put("bitrate", transportStream.getTsPacketsPerSecond2(""));
        tx2.put("totalPackets", transportStream.getIpOID_REBUILD_IP_PACKET_2(""));
        tx2.put("ccErrors", transportStream.getIpOID_FEC_D_2(""));
        tx2.put("teiErrors", transportStream.getIpOID_FEC_L_2(""));
        streams.add(tx2);

        Map<String, String> tx3 = new HashMap<>();
        tx3.put("programNumber", transportStream.getAsiFormat3(""));
        tx3.put("pcrPid", transportStream.getEthernetPacketRate3(""));
        tx3.put("bitrate", transportStream.getTsPacketsPerSecond3(""));
        tx3.put("totalPackets", transportStream.getIpOID_REBUILD_IP_PACKET_3(""));
        tx3.put("ccErrors", transportStream.getIpOID_FEC_D_3(""));
        tx3.put("teiErrors", transportStream.getIpOID_FEC_L_3(""));
        streams.add(tx3);

        return streams;
    }
}
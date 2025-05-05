package com.snmp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ts")
public class TransportStreamController {

    private static final String TARGET = "udp:127.0.0.1/161";

    @Autowired
    private TransportStream transportStream;

    // ================= TX3 =================

    @GetMapping("/tx3/cableStatus")
    public String getCableStatus3() {
        return transportStream.getEthernetCableStatus3(TARGET);
    }

    @GetMapping("/tx3/speed")
    public String getSpeed3() {
        return transportStream.getEthernetSpeed3(TARGET);
    }

    @GetMapping("/tx3/packetRate")
    public String getPacketRate3() {
        return transportStream.getEthernetPacketRate3(TARGET);
    }

    @GetMapping("/tx3/locked")
    public String getLockedStatus3() {
        return transportStream.getEthernetLockedStatus3(TARGET);
    }

    @GetMapping("/tx3/fecD")
    public String getFecD3() {
        return transportStream.getIpOID_FEC_D_3(TARGET);
    }

    @GetMapping("/tx3/fecL")
    public String getFecL3() {
        return transportStream.getIpOID_FEC_L_3(TARGET);
    }

    @GetMapping("/tx3/rebuild")
    public String getRebuild3() {
        return transportStream.getIpOID_REBUILD_IP_PACKET_3(TARGET);
    }

    @GetMapping("/tx3/tsPackets")
    public String getTsPackets3() {
        return transportStream.getTsPacketsPerSecond3(TARGET);
    }

    @GetMapping("/tx3/asiFormat")
    public String getAsiFormat3() {
        return transportStream.getAsiFormat3(TARGET);
    }

    // ================= TX2 =================

    @GetMapping("/tx2/cableStatus")
    public String getCableStatus2() {
        return transportStream.getEthernetCableStatus2(TARGET);
    }

    @GetMapping("/tx2/speed")
    public String getSpeed2() {
        return transportStream.getEthernetSpeed2(TARGET);
    }

    @GetMapping("/tx2/packetRate")
    public String getPacketRate2() {
        return transportStream.getEthernetPacketRate2(TARGET);
    }

    @GetMapping("/tx2/locked")
    public String getLockedStatus2() {
        return transportStream.getEthernetLockedStatus2(TARGET);
    }

    @GetMapping("/tx2/fecD")
    public String getFecD2() {
        return transportStream.getIpOID_FEC_D_2(TARGET);
    }

    @GetMapping("/tx2/fecL")
    public String getFecL2() {
        return transportStream.getIpOID_FEC_L_2(TARGET);
    }

    @GetMapping("/tx2/rebuild")
    public String getRebuild2() {
        return transportStream.getIpOID_REBUILD_IP_PACKET_2(TARGET);
    }

    @GetMapping("/tx2/tsPackets")
    public String getTsPackets2() {
        return transportStream.getTsPacketsPerSecond2(TARGET);
    }

    @GetMapping("/tx2/asiFormat")
    public String getAsiFormat2() {
        return transportStream.getAsiFormat2(TARGET);
    }
}

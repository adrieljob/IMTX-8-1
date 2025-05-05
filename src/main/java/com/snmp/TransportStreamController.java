package com.snmp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ts")
public class TransportStreamController {

    private static final String TARGET = "udp:127.0.0.1/161";

    @Autowired
    private TransportStream transportStream;

    // ================= TX1 =================

    @GetMapping("/tx1/cableStatus")
    public String getCableStatus1() {
        return transportStream.getEthernetCableStatus1(TARGET);
    }

    @GetMapping("/tx1/speed")
    public String getSpeed1() {
        return transportStream.getEthernetSpeed1(TARGET);
    }

    @GetMapping("/tx1/packetRate")
    public String getPacketRate1() {
        return transportStream.getEthernetPacketRate1(TARGET);
    }

    @GetMapping("/tx1/locked")
    public String getLockedStatus1() {
        return transportStream.getEthernetLockedStatus1(TARGET);
    }

    @GetMapping("/tx1/fecD")
    public String getFecD1() {
        return transportStream.getIpOID_FEC_D_1(TARGET);
    }

    @GetMapping("/tx1/fecL")
    public String getFecL1() {
        return transportStream.getIpOID_FEC_L_1(TARGET);
    }

    @GetMapping("/tx1/rebuild")
    public String getRebuild1() {
        return transportStream.getIpOID_REBUILD_IP_PACKET_1(TARGET);
    }

    @GetMapping("/tx1/tsPackets")
    public String getTsPackets1() {
        return transportStream.getTsPacketsPerSecond1(TARGET);
    }

    @GetMapping("/tx1/asiFormat")
    public String getAsiFormat1() {
        return transportStream.getAsiFormat1(TARGET);
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
    // ================= TX4 =================

    @GetMapping("/tx4/cableStatus")
    public String getCableStatus4() {
        return transportStream.getEthernetCableStatus4(TARGET);
    }

    @GetMapping("/tx4/speed")
    public String getSpeed4() {
        return transportStream.getEthernetSpeed4(TARGET);
    }

    @GetMapping("/tx4/packetRate")
    public String getPacketRate4() {
        return transportStream.getEthernetPacketRate4(TARGET);
    }

    @GetMapping("/tx4/locked")
    public String getLockedStatus4() {
        return transportStream.getEthernetLockedStatus4(TARGET);
    }

    @GetMapping("/tx4/fecD")
    public String getFecD4() {
        return transportStream.getIpOID_FEC_D_4(TARGET);
    }

    @GetMapping("/tx4/fecL")
    public String getFecL4() {
        return transportStream.getIpOID_FEC_L_4(TARGET);
    }

    @GetMapping("/tx4/rebuild")
    public String getRebuild4() {
        return transportStream.getIpOID_REBUILD_IP_PACKET_4(TARGET);
    }

    @GetMapping("/tx4/tsPackets")
    public String getTsPackets4() {
        return transportStream.getTsPacketsPerSecond4(TARGET);
    }

    @GetMapping("/tx4/asiFormat")
    public String getAsiFormat4() {
        return transportStream.getAsiFormat4(TARGET);
    }

    // ================= TX5 =================

    @GetMapping("/tx5/cableStatus")
    public String getCableStatus5() {
        return transportStream.getEthernetCableStatus5(TARGET);
    }

    @GetMapping("/tx5/speed")
    public String getSpeed5() {
        return transportStream.getEthernetSpeed5(TARGET);
    }

    @GetMapping("/tx5/packetRate")
    public String getPacketRate5() {
        return transportStream.getEthernetPacketRate5(TARGET);
    }

    @GetMapping("/tx5/locked")
    public String getLockedStatus5() {
        return transportStream.getEthernetLockedStatus5(TARGET);
    }

    @GetMapping("/tx5/fecD")
    public String getFecD5() {
        return transportStream.getIpOID_FEC_D_5(TARGET);
    }

    @GetMapping("/tx5/fecL")
    public String getFecL5() {
        return transportStream.getIpOID_FEC_L_5(TARGET);
    }

    @GetMapping("/tx5/rebuild")
    public String getRebuild5() {
        return transportStream.getIpOID_REBUILD_IP_PACKET_5(TARGET);
    }

    @GetMapping("/tx5/tsPackets")
    public String getTsPackets5() {
        return transportStream.getTsPacketsPerSecond5(TARGET);
    }

    @GetMapping("/tx5/asiFormat")
    public String getAsiFormat5() {
        return transportStream.getAsiFormat5(TARGET);
    }

    // ================= TX6 =================

    @GetMapping("/tx6/cableStatus")
    public String getCableStatus6() {
        return transportStream.getEthernetCableStatus6(TARGET);
    }

    @GetMapping("/tx6/speed")
    public String getSpeed6() {
        return transportStream.getEthernetSpeed6(TARGET);
    }

    @GetMapping("/tx6/packetRate")
    public String getPacketRate6() {
        return transportStream.getEthernetPacketRate6(TARGET);
    }

    @GetMapping("/tx6/locked")
    public String getLockedStatus6() {
        return transportStream.getEthernetLockedStatus6(TARGET);
    }

    @GetMapping("/tx6/fecD")
    public String getFecD6() {
        return transportStream.getIpOID_FEC_D_6(TARGET);
    }

    @GetMapping("/tx6/fecL")
    public String getFecL6() {
        return transportStream.getIpOID_FEC_L_6(TARGET);
    }

    @GetMapping("/tx6/rebuild")
    public String getRebuild6() {
        return transportStream.getIpOID_REBUILD_IP_PACKET_6(TARGET);
    }

    @GetMapping("/tx6/tsPackets")
    public String getTsPackets6() {
        return transportStream.getTsPacketsPerSecond6(TARGET);
    }

    @GetMapping("/tx6/asiFormat")
    public String getAsiFormat6() {
        return transportStream.getAsiFormat6(TARGET);
    }

    // ================= TX7 =================

    @GetMapping("/tx7/cableStatus")
    public String getCableStatus7() {
        return transportStream.getEthernetCableStatus7(TARGET);
    }

    @GetMapping("/tx7/speed")
    public String getSpeed7() {
        return transportStream.getEthernetSpeed7(TARGET);
    }

    @GetMapping("/tx7/packetRate")
    public String getPacketRate7() {
        return transportStream.getEthernetPacketRate7(TARGET);
    }

    @GetMapping("/tx7/locked")
    public String getLockedStatus7() {
        return transportStream.getEthernetLockedStatus7(TARGET);
    }

    @GetMapping("/tx7/fecD")
    public String getFecD7() {
        return transportStream.getIpOID_FEC_D_7(TARGET);
    }

    @GetMapping("/tx7/fecL")
    public String getFecL7() {
        return transportStream.getIpOID_FEC_L_7(TARGET);
    }

    @GetMapping("/tx7/rebuild")
    public String getRebuild7() {
        return transportStream.getIpOID_REBUILD_IP_PACKET_7(TARGET);
    }

    @GetMapping("/tx7/tsPackets")
    public String getTsPackets7() {
        return transportStream.getTsPacketsPerSecond7(TARGET);
    }

    @GetMapping("/tx7/asiFormat")
    public String getAsiFormat7() {
        return transportStream.getAsiFormat7(TARGET);
    }

    // ================= TX8 =================

    @GetMapping("/tx8/cableStatus")
    public String getCableStatus8() {
        return transportStream.getEthernetCableStatus8(TARGET);
    }

    @GetMapping("/tx8/speed")
    public String getSpeed8() {
        return transportStream.getEthernetSpeed8(TARGET);
    }

    @GetMapping("/tx8/packetRate")
    public String getPacketRate8() {
        return transportStream.getEthernetPacketRate8(TARGET);
    }

    @GetMapping("/tx8/locked")
    public String getLockedStatus8() {
        return transportStream.getEthernetLockedStatus8(TARGET);
    }

    @GetMapping("/tx8/fecD")
    public String getFecD8() {
        return transportStream.getIpOID_FEC_D_8(TARGET);
    }

    @GetMapping("/tx8/fecL")
    public String getFecL8() {
        return transportStream.getIpOID_FEC_L_8(TARGET);
    }

    @GetMapping("/tx8/rebuild")
    public String getRebuild8() {
        return transportStream.getIpOID_REBUILD_IP_PACKET_8(TARGET);
    }

    @GetMapping("/tx8/tsPackets")
    public String getTsPackets8() {
        return transportStream.getTsPacketsPerSecond8(TARGET);
    }

    @GetMapping("/tx8/asiFormat")
    public String getAsiFormat8() {
        return transportStream.getAsiFormat8(TARGET);
    }
}
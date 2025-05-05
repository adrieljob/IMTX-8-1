package com.snmp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportStream {

    @Autowired
    private SnmpService snmpService;

    public class TransportStreamStatusOids {
        // ================= TX1 =================
        public static final String OID_ETHERNET_CABLE_PRESENT_1 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.3.1";
        public static final String OID_ETHERNET_SPEED_1 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.4.1";
        public static final String OID_ETHERNET_PACKET_RATE_1 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.5.1";
        public static final String OID_ETHERNET_STREAM_LOCKED_1 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.6.1";
        public static final String OID_FEC_D_1 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.1.1";
        public static final String OID_FEC_L_1 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.3.1";
        public static final String OID_REBUILD_IP_PACKET_1 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.1.1.3.1";
        public static final String OID_TS_PACKETS_PER_SECOND_1 = "1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.6.1.1";
        public static final String OID_ASI_FORMAT_1 = "1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.3.1.1";

        // ================= TX2 =================
        public static final String OID_ETHERNET_CABLE_PRESENT_2 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.3.2";
        public static final String OID_ETHERNET_SPEED_2 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.4.2";
        public static final String OID_ETHERNET_PACKET_RATE_2 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.5.2";
        public static final String OID_ETHERNET_STREAM_LOCKED_2 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.6.2";
        public static final String OID_FEC_D_2 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.2.1";
        public static final String OID_FEC_L_2 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.3.1";
        public static final String OID_REBUILD_IP_PACKET_2 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.1.1.3.2";
        public static final String OID_TS_PACKETS_PER_SECOND_2 = "1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.6.2.1";
        public static final String OID_ASI_FORMAT_2 = "1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.3.2.1";

        // ================= TX3 =================
        public static final String OID_ETHERNET_CABLE_PRESENT_3 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.3.3";
        public static final String OID_ETHERNET_SPEED_3 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.4.3";
        public static final String OID_ETHERNET_PACKET_RATE_3 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.5.3";
        public static final String OID_ETHERNET_STREAM_LOCKED_3 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.6.3";
        public static final String OID_FEC_D_3 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.2.2";
        public static final String OID_FEC_L_3 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.3.2";
        public static final String OID_REBUILD_IP_PACKET_3 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.1.1.3.3";
        public static final String OID_TS_PACKETS_PER_SECOND_3 = "1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.6.3.1";
        public static final String OID_ASI_FORMAT_3 = "1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.3.3.1";

        // ================= TX4 =================
        public static final String OID_ETHERNET_CABLE_PRESENT_4 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.3.4";
        public static final String OID_ETHERNET_SPEED_4 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.4.4";
        public static final String OID_ETHERNET_PACKET_RATE_4 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.5.4";
        public static final String OID_ETHERNET_STREAM_LOCKED_4 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.6.4";
        public static final String OID_FEC_D_4 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.2.4";
        public static final String OID_FEC_L_4 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.3.4";
        public static final String OID_REBUILD_IP_PACKET_4 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.1.1.3.4";
        public static final String OID_TS_PACKETS_PER_SECOND_4 = "1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.6.4.1";
        public static final String OID_ASI_FORMAT_4 = "1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.3.4.1";

        // ================= TX5 =================
        public static final String OID_ETHERNET_CABLE_PRESENT_5 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.3.5";
        public static final String OID_ETHERNET_SPEED_5 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.4.5";
        public static final String OID_ETHERNET_PACKET_RATE_5 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.5.5";
        public static final String OID_ETHERNET_STREAM_LOCKED_5 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.6.5";
        public static final String OID_FEC_D_5 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.2.5";
        public static final String OID_FEC_L_5 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.3.5";
        public static final String OID_REBUILD_IP_PACKET_5 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.1.1.3.5";
        public static final String OID_TS_PACKETS_PER_SECOND_5 = "1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.6.5.1";
        public static final String OID_ASI_FORMAT_5 = "1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.3.5.1";

        // ================= TX6 =================
        public static final String OID_ETHERNET_CABLE_PRESENT_6 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.3.6";
        public static final String OID_ETHERNET_SPEED_6 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.4.6";
        public static final String OID_ETHERNET_PACKET_RATE_6 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.5.6";
        public static final String OID_ETHERNET_STREAM_LOCKED_6 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.6.6";
        public static final String OID_FEC_D_6 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.2.6";
        public static final String OID_FEC_L_6 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.3.6";
        public static final String OID_REBUILD_IP_PACKET_6 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.1.1.3.6";
        public static final String OID_TS_PACKETS_PER_SECOND_6 = "1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.6.6.1";
        public static final String OID_ASI_FORMAT_6 = "1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.3.6.1";

        // ================= TX7 =================
        public static final String OID_ETHERNET_CABLE_PRESENT_7 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.3.7";
        public static final String OID_ETHERNET_SPEED_7 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.4.7";
        public static final String OID_ETHERNET_PACKET_RATE_7 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.5.7";
        public static final String OID_ETHERNET_STREAM_LOCKED_7 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.6.7";
        public static final String OID_FEC_D_7 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.2.7";
        public static final String OID_FEC_L_7 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.3.7";
        public static final String OID_REBUILD_IP_PACKET_7 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.1.1.3.7";
        public static final String OID_TS_PACKETS_PER_SECOND_7 = "1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.6.7.1";
        public static final String OID_ASI_FORMAT_7 = "1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.3.7.1";

        // ================= TX8 =================
        public static final String OID_ETHERNET_CABLE_PRESENT_8 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.3.8";
        public static final String OID_ETHERNET_SPEED_8 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.4.8";
        public static final String OID_ETHERNET_PACKET_RATE_8 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.5.8";
        public static final String OID_ETHERNET_STREAM_LOCKED_8 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.6.8";
        public static final String OID_FEC_D_8 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.2.8";
        public static final String OID_FEC_L_8 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.3.8";
        public static final String OID_REBUILD_IP_PACKET_8 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.1.1.3.8";
        public static final String OID_TS_PACKETS_PER_SECOND_8 = "1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.6.8.1";
        public static final String OID_ASI_FORMAT_8 = "1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.3.8.1";
    }

    // ================= TX1 Methods =================
    public String getEthernetCableStatus1(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_CABLE_PRESENT_1);
    }

    public String getEthernetSpeed1(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_SPEED_1);
    }

    public String getEthernetPacketRate1(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_PACKET_RATE_1);
    }

    public String getEthernetLockedStatus1(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_STREAM_LOCKED_1);
    }

    public String getIpOID_FEC_D_1(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_FEC_D_1);
    }

    public String getIpOID_FEC_L_1(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_FEC_L_1);
    }

    public String getIpOID_REBUILD_IP_PACKET_1(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_REBUILD_IP_PACKET_1);
    }

    public String getTsPacketsPerSecond1(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_TS_PACKETS_PER_SECOND_1);
    }

    public String getAsiFormat1(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ASI_FORMAT_1);
    }

    // ================= TX2 Methods =================
    public String getEthernetCableStatus2(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_CABLE_PRESENT_2);
    }

    public String getEthernetSpeed2(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_SPEED_2);
    }

    public String getEthernetPacketRate2(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_PACKET_RATE_2);
    }

    public String getEthernetLockedStatus2(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_STREAM_LOCKED_2);
    }

    public String getIpOID_FEC_D_2(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_FEC_D_2);
    }

    public String getIpOID_FEC_L_2(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_FEC_L_2);
    }

    public String getIpOID_REBUILD_IP_PACKET_2(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_REBUILD_IP_PACKET_2);
    }

    public String getTsPacketsPerSecond2(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_TS_PACKETS_PER_SECOND_2);
    }

    public String getAsiFormat2(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ASI_FORMAT_2);
    }

    // ================= TX3 Methods =================
    public String getEthernetCableStatus3(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_CABLE_PRESENT_3);
    }

    public String getEthernetSpeed3(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_SPEED_3);
    }

    public String getEthernetPacketRate3(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_PACKET_RATE_3);
    }

    public String getEthernetLockedStatus3(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_STREAM_LOCKED_3);
    }

    public String getIpOID_FEC_D_3(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_FEC_D_3);
    }

    public String getIpOID_FEC_L_3(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_FEC_L_3);
    }

    public String getIpOID_REBUILD_IP_PACKET_3(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_REBUILD_IP_PACKET_3);
    }

    public String getTsPacketsPerSecond3(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_TS_PACKETS_PER_SECOND_3);
    }

    public String getAsiFormat3(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ASI_FORMAT_3);
    }

    // ================= TX4 Methods =================
    public String getEthernetCableStatus4(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_CABLE_PRESENT_4);
    }

    public String getEthernetSpeed4(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_SPEED_4);
    }

    public String getEthernetPacketRate4(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_PACKET_RATE_4);
    }

    public String getEthernetLockedStatus4(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_STREAM_LOCKED_4);
    }

    public String getIpOID_FEC_D_4(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_FEC_D_4);
    }

    public String getIpOID_FEC_L_4(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_FEC_L_4);
    }

    public String getIpOID_REBUILD_IP_PACKET_4(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_REBUILD_IP_PACKET_4);
    }

    public String getTsPacketsPerSecond4(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_TS_PACKETS_PER_SECOND_4);
    }

    public String getAsiFormat4(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ASI_FORMAT_4);
    }

    // ================= TX5 Methods =================
    public String getEthernetCableStatus5(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_CABLE_PRESENT_5);
    }

    public String getEthernetSpeed5(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_SPEED_5);
    }

    public String getEthernetPacketRate5(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_PACKET_RATE_5);
    }

    public String getEthernetLockedStatus5(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_STREAM_LOCKED_5);
    }

    public String getIpOID_FEC_D_5(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_FEC_D_5);
    }

    public String getIpOID_FEC_L_5(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_FEC_L_5);
    }

    public String getIpOID_REBUILD_IP_PACKET_5(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_REBUILD_IP_PACKET_5);
    }

    public String getTsPacketsPerSecond5(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_TS_PACKETS_PER_SECOND_5);
    }

    public String getAsiFormat5(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ASI_FORMAT_5);
    }

    // ================= TX6 Methods =================
    public String getEthernetCableStatus6(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_CABLE_PRESENT_6);
    }

    public String getEthernetSpeed6(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_SPEED_6);
    }

    public String getEthernetPacketRate6(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_PACKET_RATE_6);
    }

    public String getEthernetLockedStatus6(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_STREAM_LOCKED_6);
    }

    public String getIpOID_FEC_D_6(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_FEC_D_6);
    }

    public String getIpOID_FEC_L_6(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_FEC_L_6);
    }

    public String getIpOID_REBUILD_IP_PACKET_6(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_REBUILD_IP_PACKET_6);
    }

    public String getTsPacketsPerSecond6(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_TS_PACKETS_PER_SECOND_6);
    }

    public String getAsiFormat6(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ASI_FORMAT_6);
    }

    // ================= TX7 Methods =================
    public String getEthernetCableStatus7(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_CABLE_PRESENT_7);
    }

    public String getEthernetSpeed7(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_SPEED_7);
    }

    public String getEthernetPacketRate7(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_PACKET_RATE_7);
    }

    public String getEthernetLockedStatus7(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_STREAM_LOCKED_7);
    }

    public String getIpOID_FEC_D_7(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_FEC_D_7);
    }

    public String getIpOID_FEC_L_7(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_FEC_L_7);
    }

    public String getIpOID_REBUILD_IP_PACKET_7(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_REBUILD_IP_PACKET_7);
    }

    public String getTsPacketsPerSecond7(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_TS_PACKETS_PER_SECOND_7);
    }

    public String getAsiFormat7(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ASI_FORMAT_7);
    }

    // ================= TX8 Methods =================
    public String getEthernetCableStatus8(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_CABLE_PRESENT_8);
    }

    public String getEthernetSpeed8(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_SPEED_8);
    }

    public String getEthernetPacketRate8(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_PACKET_RATE_8);
    }

    public String getEthernetLockedStatus8(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_STREAM_LOCKED_8);
    }

    public String getIpOID_FEC_D_8(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_FEC_D_8);
    }

    public String getIpOID_FEC_L_8(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_FEC_L_8);
    }

    public String getIpOID_REBUILD_IP_PACKET_8(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_REBUILD_IP_PACKET_8);
    }

    public String getTsPacketsPerSecond8(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_TS_PACKETS_PER_SECOND_8);
    }

    public String getAsiFormat8(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ASI_FORMAT_8);
    }
}
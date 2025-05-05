package com.snmp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportStream{

    @Autowired
    private SnmpService snmpService;

    public class TransportStreamStatusOids {

        public static final String OID_ETHERNET_CABLE_PRESENT_2 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.3.2";
        public static final String OID_ETHERNET_CABLE_PRESENT_3 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.3.3";
        public static final String OID_ETHERNET_SPEED_2 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.4.2";
        public static final String OID_ETHERNET_SPEED_3 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.4.3";
        public static final String OID_ETHERNET_PACKET_RATE_2 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.5.2";
        public static final String OID_ETHERNET_PACKET_RATE_3 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.5.3";
        public static final String OID_ETHERNET_STREAM_LOCKED_2 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.6.2";
        public static final String OID_ETHERNET_STREAM_LOCKED_3 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.1.1.1.6.3";
        public static final String OID_FEC_ALARM_2 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.3.1.1.3.2";
        public static final String OID_FEC_ALARM_3 = "1.3.6.1.4.1.43768.3.1.1.10.2.10.3.1.1.3.3";
        public static final String OID_IP_DECODING_ALARM_2 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.4.2.1.1.4.2";
        public static final String OID_IP_DECODING_ALARM_3 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.4.2.1.1.4.3";
        public static final String OID_FEC_D_2 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.2.1";
        public static final String OID_FEC_L_2 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.3.1";
        public static final String OID_FEC_D_3 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.2.2";
        public static final String OID_FEC_L_3 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.2.1.6.3.2";
        public static final String OID_REBUILD_IP_PACKET_2 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.1.1.3.2";
        public static final String OID_REBUILD_IP_PACKET_3 = "1.3.6.1.4.1.43768.3.1.1.10.2.7.2.2.1.1.3.3";
        public static final String OID_TS_PACKETS_PER_SECOND_2 = "1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.6.2.1";
        public static final String OID_TS_PACKETS_PER_SECOND_3 = "1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.6.3.1";
        public static final String OID_ASI_FORMAT_2 = "1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.3.2.1";
        public static final String OID_ASI_FORMAT_3 = "1.3.6.1.4.1.43768.3.1.1.10.2.5.1.2.1.3.3.1";

    }
    public String getEthernetCableStatus2(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_CABLE_PRESENT_2);
    }

    public String getEthernetCableStatus3(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_CABLE_PRESENT_3);
    }

    public String getEthernetSpeed2(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_SPEED_2);
    }

    public String getEthernetSpeed3(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_SPEED_3);
    }

    public String getEthernetPacketRate2(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_PACKET_RATE_2);
    }

    public String getEthernetPacketRate3(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_PACKET_RATE_3);
    }

    public String getEthernetLockedStatus2(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_STREAM_LOCKED_2);
    }

    public String getEthernetLockedStatus3(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ETHERNET_STREAM_LOCKED_3);
    }

    public String getFecAlarm2(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_FEC_ALARM_2);
    }

    public String getFecAlarm3(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_FEC_ALARM_3);
    }

    public String getIpDecodingAlarm2(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_IP_DECODING_ALARM_2);
    }

    public String getIpDecodingAlarm3(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_IP_DECODING_ALARM_3);
    }

    public String getIpOID_FEC_D_2(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_FEC_D_2);
    }

    public String getIpOID_FEC_D_3(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_FEC_D_3);
    }

    public String getIpOID_FEC_L_2(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_FEC_L_2);
    }

    public String getIpOID_FEC_L_3(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_FEC_L_3);
    }

    public String getIpOID_REBUILD_IP_PACKET_2(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_REBUILD_IP_PACKET_2);
    }

    public String getIpOID_REBUILD_IP_PACKET_3(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_REBUILD_IP_PACKET_3);
    }

    public String getTsPacketsPerSecond2(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_TS_PACKETS_PER_SECOND_2);
    }

    public String getTsPacketsPerSecond3(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_TS_PACKETS_PER_SECOND_3);
    }

    public String getAsiFormat2(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ASI_FORMAT_2);
    }

    public String getAsiFormat3(String target) {
        return snmpService.getSnmpData(TransportStreamStatusOids.OID_ASI_FORMAT_3);
    }
}

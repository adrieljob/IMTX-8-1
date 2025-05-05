// SnmpController.java
package com.snmp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/snmp")
@CrossOrigin(origins = "*") // Permite requisições do front-end
public class SnmpCheckController {

    @Autowired
    private SnmpCheck snmpCheck;

    @GetMapping("/status/{txId}")
    public int getStatus(@PathVariable String txId) {
        try {
            return snmpCheck.getStatusByTxId(txId);
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}

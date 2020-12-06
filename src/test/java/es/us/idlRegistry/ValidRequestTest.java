package es.us.idlRegistry;

import es.us.idlRegistry.web3j.SmartContractIntegrator;
import es.us.idlRegistry.web3j.util.Constants;
import es.us.idlRegistry.web3j.util.RequestEntity;
import es.us.isa.idlreasoner.analyzer.Analyzer;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidRequestTest {

    @Test
    public void one_dep_complex_invalid() {
        //Parameters
        Map<String, String> request = new HashMap<>();
        request.put("p1", "false");
        request.put("p2", "string");
        request.put("p3", "-1000");

        //Request
        RequestEntity req = new RequestEntity(Constants.REQUEST_IS_VALID, "oas","one_dep_complex.idl", "./src/test/resources/OAS_test_suite.yaml", "/oneDependency", "get", request, "");

        SmartContractIntegrator smartContractIntegrator = new SmartContractIntegrator();
        boolean res = smartContractIntegrator.register(req);
        assertFalse(res, "The request should be NOT valid");
        System.out.println("Test passed: one_dep_complex_invalid.");
    }

    @Test
    public void one_dep_complex_valid() {
        //Parameters
        Map<String, String> request = new HashMap<>();
        request.put("p1", "false");
        request.put("p2", "string");
        request.put("p4", "value1");
        request.put("p5", "4");

        //Request
        RequestEntity req = new RequestEntity(Constants.REQUEST_IS_VALID, "oas","one_dep_complex.idl", "./src/test/resources/OAS_test_suite.yaml", "/oneDependency", "get", request, "");

        SmartContractIntegrator smartContractIntegrator = new SmartContractIntegrator();
        boolean res = smartContractIntegrator.register(req);
        assertTrue(res, "The request should be VALID");
    }
}

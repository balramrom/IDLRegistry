package es.us.idlRegistry.web3j.util;

import java.util.List;
import java.util.Map;

public class RequestEntity {

    private String idOperation;

    private String specificationType;

    private String idlPath;

    private String apiSpecificationPath;

    private String operationPath;

    private String operationType;

    private String result;

    private Map<String, String> request;

    public RequestEntity(String idOperation, String specificationType, String idlPath, String apiSpecificationPath, String operationPath, String operationType, Map<String, String> request, String result) {
        this.idOperation = idOperation;
        this.specificationType = specificationType;
        this.idlPath = idlPath;
        this.apiSpecificationPath = apiSpecificationPath;
        this.operationPath = operationPath;
        this.operationType = operationType;
        this.result = result;
        this.request = request;
    }

    public String getIdOperation() {
        return idOperation;
    }

    public String getSpecificationType() {
        return specificationType;
    }

    public String getIdlPath() {
        return idlPath;
    }

    public String getApiSpecificationPath() {
        return apiSpecificationPath;
    }

    public String getOperationPath() {
        return operationPath;
    }

    public String getOperationType() {
        return operationType;
    }

    public String getResult() {
        return result;
    }

    public Map<String, String> getRequest() {
        return request;
    }

    public void setIdOperation(String idOperation) {
        this.idOperation = idOperation;
    }

    public void setSpecificationType(String specificationType) {
        this.specificationType = specificationType;
    }

    public void setIdlPath(String idlPath) {
        this.idlPath = idlPath;
    }

    public void setApiSpecificationPath(String apiSpecificationPath) {
        this.apiSpecificationPath = apiSpecificationPath;
    }

    public void setOperationPath(String operationPath) {
        this.operationPath = operationPath;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setRequest(Map<String, String> request) {
        this.request = request;
    }
}

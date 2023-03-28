package pl.programautomatycy.cart.service.test;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;


// not designed for running, only example
class H_PUTandPATCHmethods {

    private final ServiceHelper serviceHelper = new ServiceHelper();
    @Test
    public void updateProductPut(){
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("key1", "value1");
        bodyRequest.put("key2", "value2");
        bodyRequest.put("key3", "value3");

        String endpoint = "/cocart/v1/someEndpoint";
        serviceHelper.sendPutRequest(bodyRequest.toString(), endpoint);
    }

    @Test
    public void updateProductPatch(){
        JSONObject bodyRequest = new JSONObject();
        bodyRequest.put("key1", "value1");
        bodyRequest.put("key2", "value2");
        bodyRequest.put("key3", "value3");

        String endpoint = "/cocart/v1/someEndpoint";
        serviceHelper.sendPatchRequest(bodyRequest.toString(), endpoint);
    }
}

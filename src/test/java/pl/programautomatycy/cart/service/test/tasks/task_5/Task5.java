package pl.programautomatycy.cart.service.test.tasks.task_5;

/*
Kroki do wykonania:
Wyślij Request metodą GET na endpoint “/cocart/v1/totals” z parametrem “html” z wartością “true” umieszczonym w adresie URL.
Wydrukuj Response
 */

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import pl.programautomatycy.cart.service.test.ServiceHelper;

class Task5 {
    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void getTotalsMethodTask5 () {

        String endpoint = "/cocart/v1/totals";
        boolean html = true;

        Response response = serviceHelper.sendGetRequest(endpoint + "?html=" + html);
        response.getBody().prettyPrint();
    }

    @Test
    public void getTotalsAnotherMethodTask5 () {

        String endpoint = "cocart/v1/totals";
        String params = "?html=";
        boolean html = true;

        Response response = serviceHelper.sendGetRequest(endpoint + params + html);
        response.getBody().prettyPrint();
    }
}

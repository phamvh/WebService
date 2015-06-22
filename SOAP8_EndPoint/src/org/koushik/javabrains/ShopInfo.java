package org.koushik.javabrains;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * This example demonstrates how to publish a webservice without using glassfish.
 * The reason we can do this is we can just use JDK to publish a webservice.
 * Glassfish is bundled with Metro - a lib that handles publishing web services. Interestingly enough, JDK is also
 * bundled with Metro.
 *
 * See class ShopInfoPublisher for details.
 */
@WebService

@SOAPBinding(style = SOAPBinding.Style.RPC )
public class ShopInfo {

    @WebMethod
    @WebResult(partName = "lookupOutput")

    public String getShopInfo(@WebParam(partName = "lookupInput") String property) {
        String response=null;
        if(property.toLowerCase().equals("shopname"))
            response = "Test Mart";
        else if (property.toLowerCase().equals("since"))
            response = "Since 2012";
        else {
            response = "Welcome to ShopInfo. We do not have information about "+property;
        }

        return response;
    }
}

package org.koushik.javabrains;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * This example demonstrates how to handle exception.
 * Specifically, when an exception happens, how to let webservice know about it.
 */
@WebService

@SOAPBinding(style = SOAPBinding.Style.RPC )
public class ShopInfo {

    @WebMethod
    @WebResult(partName = "lookupOutput")
    /**
     * This method now can throw an exception.
     * THe wsdl then will have an extra element like this:
     *
     * <operation name="getShopInfo">
         <input wsam:Action="http://javabrains.koushik.org/ShopInfo/getShopInfoRequest" message="tns:getShopInfo"/>
         <output wsam:Action="http://javabrains.koushik.org/ShopInfo/getShopInfoResponse" message="tns:getShopInfoResponse"/>
         <fault message="tns:InvalidPropertyException" name="InvalidPropertyException" wsam:Action="http://javabrains.koushik.org/ShopInfo/getShopInfo/Fault/InvalidPropertyException"/>
       </operation>
     */
    public String getShopInfo(@WebParam(partName = "lookupInput") String property) throws InvalidPropertyException {
        String response=null;
        if(property.toLowerCase().equals("shopname"))
            response = "Test Mart";
        else if (property.toLowerCase().equals("since"))
            response = "Since 2012";
        else {
            throw new InvalidPropertyException("Invalid Input", property + " is not a valid input.");
        }

        return response;
    }
}

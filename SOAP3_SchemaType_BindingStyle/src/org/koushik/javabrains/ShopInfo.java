package org.koushik.javabrains;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by van on 6/19/15.
 */
@WebService
/**
 * This style parameter (SOAPBinding.Style.RPC) overwrites the default behavior (SOAPBinding.Style.DOCUMENT)
 * Basically, this allows the types to be defined within the main WSDL file, instead of defining types
 * in a separate xml and referring to this separate xml from the main WSDL.
 * Things look cleaner.
 *
 * However, DOCUMENT is recommended for more complex types as in the separate document, you can specify more conditions for input,
 * such as minOccurs, etc.
 */
@SOAPBinding(style = SOAPBinding.Style.RPC )
public class ShopInfo {

    @WebMethod
    /**
     * The annotations @WebResult and @WebParam are used to give names to arguments for this method in the WSDL.
     * By default, the "lookupInput" would be "arg0" instead, and "lookupOutput" would be "return".
     * Using these annotations with parameter "partName" give a more readable names in the WSDL.
     *
     * So instead of this:
         *      <message name="getShopInfo">
                     <part name="arg0" type="xsd:string"/>
                     </message>
                     <message name="getShopInfoResponse">
                     <part name="return" type="xsd:string"/>
                </message>

     We have this:
                 <message name="getShopInfo">
                     <part name="lookupInput" type="xsd:string"/>
                     </message>
                     <message name="getShopInfoResponse">
                     <part name="lookupOutput" type="xsd:string"/>
                 </message>
     */
    @WebResult(partName = "lookupOutput")
    public String getShopInfo(@WebParam(partName = "lookupInput") String property){
        String defaultResponse = "Invalid Property";
        String response="";
        if(property.toLowerCase().equals("shopName"))
            response = "Test Mart";
        else if (property.toLowerCase().equals("since"))
            response = "Since 2012";

        return defaultResponse;
    }
}

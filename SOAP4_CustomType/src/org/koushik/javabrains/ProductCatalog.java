package org.koushik.javabrains;

import org.koushik.javabrains.business.ProductServiceImpl;
import org.koushik.javabrains.model.Product;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.List;


@WebService(name = "TestMartCatalog",
        portName = "TestMartCatalogPort",
        serviceName = "TestMartCatalogService",
        targetNamespace = "http://www.testmart.com")
public class ProductCatalog {
    ProductServiceImpl productService = new ProductServiceImpl();


    /**
     * Compared to TestMart (without parameters), TestMart2 (with parameters) makes following changes in WSDL:
     *
     * <input wsam:Action="http://javabrains.koushik.org/ProductCatalog/getProductCategoriesRequest"  vs  <input wsam:Action="fetch_categories"
     * <operation name="getProductCategories">                                                        vs  <operation name="fetchCategories">
     *
     *
     */
    @WebMethod(action = "fetch_categories", operationName = "fetchCategories")
    public List<String> getProductCategories(){

        return productService.getProductCategories();
    }

    @WebMethod
    public List<String> getProducts(String category){
        return productService.getProducts(category);
    }

    /**
     * This method demonstrates a custom return type, which is a List of Product(s), instead
     * of a List of String.
     * As a result, when we use SOAP, the result will be packaged in an XML as follows:
     *
     *<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/" xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
         <SOAP-ENV:Header/>
             <S:Body>
                 <ns2:getProducts_version2Response xmlns:ns2="http://www.testmart.com">
                     <return>
                         <name>Java Brains Book</name>
                         <price>9999.99</price>
                         <sku>1234</sku>
                     </return>
                     <return>
                         <name>Python Brains Book</name>
                         <price>12.25</price>
                         <sku>ABC</sku>
                     </return>
                 </ns2:getProducts_version2Response>
             </S:Body>
         </S:Envelope>
     *
     */
    @WebMethod
    public List<Product> getProducts_Version2(String category){
        return productService.getProducts_version2(category);
    }


    @WebMethod
    public boolean addProduct(String category, String product){

        return productService.addProduct(category,product);
    }
}

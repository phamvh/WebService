package org.koushik.javabrains;

import org.koushik.javabrains.business.ProductServiceImpl;
import org.koushik.javabrains.model.Product;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

/**
 * In this tutorial, we use JAXB (Java Architecture for XML Binding) to customize how the data from
 * our webservice class' object is transformed to XML. In other words, to customize the xml data
 * returned by SOAP.
 *
 * Refer to the Product class to see the details. Basically, the method getProducts_Version2 returns a list
 * of Product(s), each of which will be packaged in an XML element. By default, SOAP will automatically convert a Product
 * into an XML like this:
 *
 *   <return>
         <name>Java Brains Book</name>
         <price>9999.99</price>
         <sku>1234</sku>
     </return>

     The question is now we want to customize this XML. The way to achieve that is to use JAXB (See Product class)
 *
 *
 */
@WebService(name = "TestMartCatalog",
        portName = "TestMartCatalogPort",
        serviceName = "TestMartCatalogService",
        targetNamespace = "http://www.testmart.com")
public class ProductCatalog {
    ProductServiceImpl productService = new ProductServiceImpl();



    @WebMethod
    @WebResult(name = "Product")
    public List<Product> getProducts_Version2(String category){

        return productService.getProducts_version2(category);
    }

}

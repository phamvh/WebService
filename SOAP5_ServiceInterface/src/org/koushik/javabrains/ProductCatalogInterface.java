package org.koushik.javabrains;

import org.koushik.javabrains.model.Product;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 *  This interface was extracted from class ProductCatalog.
 *  In the old style of SOAP, a @WebService class had to implement an interface, which is also
 *  annotated as @WebService like this one. This is still recommended now.
 *
 *  All the classes that implement this interface need to have the annotation in order to become a Web Service:
 *      @WebService(endpointInterface = "org.koushik.javabrains.ProductCatalogInterface")
 *  The advantage of having this interface is we can decouple the implementation from service declarations.
 *
 *  Note that we only have one parameter "targetNamespace" in here. All the other parameters (name, portName, serviceName)
 *  need to be declared in the implementing class, not here, because even if we put them here, they will not have any effect.
 *  This is strange, as Koushik pointed out, but it kinda makes sense because if we have two implementing classes, they would end up
 *  having the same name, portName, etc, and therefore these params need to be specific to a class.
 *

 */

@WebService(targetNamespace = "http://www.testmart.com")
public interface ProductCatalogInterface {
    @WebMethod(action = "fetch_categories", operationName = "fetchCategories")
    List<String> getProductCategories();

    @WebMethod
    List<String> getProducts(String category);

    @WebMethod
    List<Product> getProducts_Version2(String category);

    @WebMethod
    boolean addProduct(String category, String product);
}

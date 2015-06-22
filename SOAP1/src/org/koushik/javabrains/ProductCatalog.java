package org.koushik.javabrains;

import org.koushik.javabrains.business.ProductServiceImpl;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * This single annotation indicates that this class is a web service.
 * This annotation is all you need to make a simple web service SOAP.
 *
 */
@WebService
public class ProductCatalog {
    ProductServiceImpl productService = new ProductServiceImpl();


    /**
     * This annotation is optional because, by default, all public methods
     * of a class, which is annotated as @WebService, are web methods.
     */
    @WebMethod
    public List<String> getProductCategories(){

        return productService.getProductCategories();
    }

    public List<String> getProducts(String category){

        return productService.getProducts(category);
    }

    /**
     * This method will add a service method so that users can add info.
     * This also shows that the same instance productService is used across multiple requests.
     * @param category
     * @param product
     * @return
     */
    public boolean addProduct(String category, String product){

        return productService.addProduct(category,product);
    }
}

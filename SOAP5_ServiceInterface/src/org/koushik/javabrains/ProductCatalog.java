package org.koushik.javabrains;

import org.koushik.javabrains.business.ProductServiceImpl;
import org.koushik.javabrains.model.Product;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * This is the old style, when the @WebService class has to implement an interface, which is also annotated as @WebService.
 * The interface acts as the end-point interface on the server side (which is also the same as the end-point interface
 * on the client side.
 *
 * Note that now not all the public methods are service methods.
 * Only those that are declared in the interface become web methods.
 */
@WebService(endpointInterface = "org.koushik.javabrains.ProductCatalogInterface",
        name = "TestMartCatalog",
        portName = "TestMartCatalogPort",
        serviceName = "TestMartCatalogService")
public class ProductCatalog implements ProductCatalogInterface {
    ProductServiceImpl productService = new ProductServiceImpl();



    public List<String> getProductCategories(){

        return productService.getProductCategories();
    }


    public List<String> getProducts(String category){
        return productService.getProducts(category);
    }


    public List<Product> getProducts_Version2(String category){
        return productService.getProducts_version2(category);
    }

    public boolean addProduct(String category, String product){

        return productService.addProduct(category,product);
    }
}

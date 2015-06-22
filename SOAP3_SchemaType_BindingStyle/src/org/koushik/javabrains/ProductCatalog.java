package org.koushik.javabrains;

import org.koushik.javabrains.business.ProductServiceImpl;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * The parameters of the annotation will overwrite the default names in the WSDL file.
 * The difference in the generated WSDL between TestMart module and TestMart2 module are following
 * (effects are shown in the orders of the parameters inside the annotation):
 *
 *   TestSmart (without parameters)                       TestSmart2 (with parameters)
 *
 *   <portType name="ProductCatalog">                     <portType name="TestMartCatalog">
 *   <port name="ProductCatalogPort" ...                  <port name="TestMartCatalogPort"...
 *   <service name="ProductCatalogService">               <service name="TestMartCatalogService">
 *   targetNamespace="http://javabrains.koushik.org/      targetNamespace="http://www.testmart.com"
 *
 *   In addition, the URL used to access the webservice also changed (from ProductCatalogService to TestMartCatalogService):
 *
 *   Old (in TestSmart) :   http://vans-macbook-pro.local:8080/Testmart/ProductCatalogService:
 *   New (in TestSmart2):   http://vans-macbook-pro.local:8080/TestSmart2/TestMartCatalogService
 *
 *
 */
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

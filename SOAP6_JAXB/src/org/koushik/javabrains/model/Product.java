package org.koushik.javabrains.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Each of the product returned will be packaged in an xml element, whose name is "Product".
 * Without this, the name of the root will have name "return", which is odd.
 *
 * Actually, this has NO effect. NOT sure why. But in order to make the root element have name "Product",
 * we can go to the method in ProductCatalog and use @WebResult. See class ProductCatalog for details.
 */
@XmlRootElement(name = "Product")
/**
 * This @XmlType annotation specifies the order, in which the properties of an object appear in the
 * SOAP message (XML element Product).
 *
 * Also, note that when we change the order like this, we need to provide a no-args constructor.
 * THis is because JAXB needs to convert xml to Java object too, and it does not know which xml element
 * is matched to which variable. Here we have two string vars.
 * Therefore, a no-args constructor needs to be  provided and JAXB will (probably) use setters to set content to objects.
 *
 */
@XmlType(propOrder = {"price","sku","name"})
public class Product {

    private String name;
    private String sku;
    private double price;

    public Product(){

    }

    public Product(String name, String sku, double price) {
        this.name = name;
        this.sku = sku;
        this.price = price;
    }

    /**
     *
     * This annotation will overwrite the default name of the variable.
     * By default, the name of the var is used as the name of the xml element containing the var's value,
     * This annotation gives the name "ProductName" (as compared to the default "name").
     */
    @XmlElement(name = "ProductName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}

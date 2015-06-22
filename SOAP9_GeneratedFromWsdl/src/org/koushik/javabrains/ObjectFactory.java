
package org.koushik.javabrains;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.koushik.javabrains package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _InvalidPropertyException_QNAME = new QName("http://javabrains.koushik.org/", "InvalidPropertyException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.koushik.javabrains
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InvalidPropertyException }
     * 
     */
    public InvalidPropertyException createInvalidPropertyException() {
        return new InvalidPropertyException();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidPropertyException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://javabrains.koushik.org/", name = "InvalidPropertyException")
    public JAXBElement<InvalidPropertyException> createInvalidPropertyException(InvalidPropertyException value) {
        return new JAXBElement<InvalidPropertyException>(_InvalidPropertyException_QNAME, InvalidPropertyException.class, null, value);
    }

}

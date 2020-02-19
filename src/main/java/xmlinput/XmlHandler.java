package xmlinput;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class XmlHandler extends DefaultHandler {

    ArrayList<Product> products = new ArrayList<Product>();  // ArrayList of all Products
    Product currentProduct = null;  // Reference to the current Product

    //String name, isbn, price, type;


    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        System.out.println("Start element");

//        System.out.println("qname:" + qName);
//        for (int i=0; i<attributes.getLength(); i++){
//            System.out.println("attributes" + attributes.getQName(i)) + ":" + attributes.getValue(i);
//        }

        // Check if this is an opening element for a product
        if (qName.equals("product")) {
            // If so, store each of its attribute values
           String name = attributes.getValue("name");
           String isbn = attributes.getValue("isbn");
           String price = attributes.getValue("unitPrice");
           String type = attributes.getValue("taxable");

            // Determine type of product (taxable vs. nontaxable)
            if (attributes.getValue("taxable") !=null && type.contentEquals("true")){
                currentProduct = new TaxableProduct(name, isbn, Double.parseDouble(price));

            } else {
                currentProduct = new NonTaxableProduct(name, isbn, Double.parseDouble(price));
            }
        }
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End element");

        // check if this is a closing element for a product
        if (qName.equals("product")){

        // If so, add product to array list
            products.add(currentProduct);
        }
    }
    // Return a reference to array list
    public ArrayList<Product> getProducts() {
        System.out.println(products);
        return products;
    }
}



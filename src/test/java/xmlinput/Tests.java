/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package xmlinput;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Tests {

    @BeforeAll
    static void buildRandomXml() {
        System.out.println("Build an random xml file");
    }


    @Test
    void readProducts1() {
        XmlReader xr = null;
        try {
            xr = new XmlReader("./src/test/java/xmlinput/products-1.xml");
        } catch (Exception e) {
            //System.out.println("Exception-jpe: " + e);
            fail("Could not initialize an XmlReader");
        }
        assertNotNull(xr, "Could not initialize XmlReader");

        // Try to get products array
        Product[] products = null;
        try {
            products = xr.getProducts();
        } catch (Exception e) {
            System.out.println("Products array exception");
        }

        assertNotNull(products, "Could not get Product array");

        String[] expected = {"Snickers:123-456-78:0.99:taxable"};

        this.compareProducts(expected, products);
    }

    @Test
    void readProducts2() {
        XmlReader xr = null;
        try {
            xr = new XmlReader("./src/test/java/xmlinput/products-2.xml");
        } catch (Exception e) {
            //System.out.println("Exception-jpe: " + e);
            fail("Could not initialize an XmlReader");
            //assertNotNull(xr1, "Could not initialize an XmlReader");
        }
        assertNotNull(xr, "Could not initialize XmlReader");

        // Try to get products array
        Product[] products = null;
        try {
            products = xr.getProducts();
        } catch (Exception e) {
            System.out.println("Products array exception");
        }

        assertNotNull(products, "Could not get Product array");

        String[] expected = {"Snickers:123-456-78:0.99:taxable",
        "Milky Way:234-567-89:0.98:nontaxable"};

        this.compareProducts(expected, products);

    }


    @Test
    void readProducts10() {
        XmlReader xr = null;
        try {
            xr = new XmlReader("./src/test/java/xmlinput/products-10.xml");
        } catch (Exception e) {
            //System.out.println("Exception-jpe: " + e);
            fail("Could not initialize an XmlReader");
        }
        assertNotNull(xr, "Could not initialize XmlReader");

        // Try to get products array
        Product[] products = null;
        try {
            products = xr.getProducts();
        } catch (Exception e) {
            System.out.println("Products array exception");
        }

        assertNotNull(products, "Could not get Product array");

        String[] expected = {"Snickers:123-456-78:0.99:taxable",
                "Milky Way:234-567-89:0.98:nontaxable",
                "M & Ms:345-678-90:0.97:nontaxable",
                "Mounds:456-789-01:0.96:taxable",
                "Reeses:567-890-12:0.95:taxable",
                "Almond Joy:678-901-23:0.94:taxable",
                "Kit Kat:789-012-34:0.93:nontaxable",
                "Mr. Goodbar:890-123-45:0.92:taxable",
                "Hershey Bar:901-234-56:0.91:nontaxable",
                "Cadbury:012-345-67:0.9:nontaxable"};

        this.compareProducts(expected, products);
    }


    private void compareProducts(String[] expected, Product[] actual) {
        // Ensure same length
        if (expected.length != actual.length) {
            // Abort -- different lengths
            fail("Result does not contain the expected number of products");
        }

        // Compare elements
        for (int i = 0; i < expected.length; i++) {
          assertEquals(expected[i], actual[i].values());
        }
    }
}
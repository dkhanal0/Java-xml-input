/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package xmlinput;

public class Main {

    public static void main(String[] args) {

        XmlReader myXmlReader = new XmlReader("products.xml");

        for (Product p: myXmlReader.getProducts()) {
            System.out.println(p.values()); // When ready, use this for testing




        }

    }
}

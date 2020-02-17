# CSC 241 XML Input

In this assignment, we will create an XML file reader that can build an array of Product
objects. Given that the input file is in XML format, you should use the Java Simple API 
for XML, or Java SAX, to read it and process its contents. This is widely considered an 
industry standard for processing XML data. This is also an opportunity for you to get 
experience using event driven programing. The Java SAX documentation can be found here:

http://www.saxproject.org/

And, two nice tutorial examples can be found here:

http://docs.oracle.com/javase/tutorial/jaxp/sax/parsing.html
http://www.journaldev.com/1198/java-sax-parser-example-tutorial-to-parse-xml-to-list-of-objects

Follow the specification below and make the necessary changes and additions.

## Specification

### Product
Reuse the code from the previous assignment. Add a new *abstract* method called `values()` 
that returns a `String`.
 

### TaxableProduct and NonTaxableProduct
Reuse the code from the previous assignment. Implement the `values()` method in each class, 
as needed.  Each method should return a `String` with the following format:
`<productName>:<isbn>:<unitPrice>:taxable|nontaxable`. Here is an example using the supplied
`products.xml` input file:

`Snickers:123-456-78:0.99:taxable`

### XmlReader
This new class builds an XML handler based on an input file name string. No modifications
to this file should be necessary.

### XmlHandler
This new class is used to build an XML handler with specific rules that govern actions
when starting and ending XML tags are encounterd. Update each of these methods
- startElement - Examine the `qName` parameter to check if it is a tag referencing a 
product. If so, extract the attribute values and use these to instantiate a new Product, 
called `currentProduct`. Use the value of the `taxable` attribute to determine if this is 
a taxable or nontaxable product. NOTE: If the `taxable` attribute is missing, assume the 
product is nontaxable.
- endElement - This method signals that we have all the information we are going to get 
about a specific product. At this point, add `currentProduct` to an ArrayList of Products.
- getProducts - This method should return the ArrayList of all Products generated from
the input file.

## Testing
When you push your code back to your repository, GitHub will initiate a series of
tests to verify the correct operation of each of the required methods.

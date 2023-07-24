package package_background;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateXmlFile {

    // Instance variables
    private String selectedMasterrecordType = "placeholder";
    private String headerSource;
    private String headerDestination;
    private int headerSequence;
    private String headerRecordTypeName;
    private String headerOrderType;
    private String filePath;
    private String selectedOrderType;

    // Constructor to initialize the instance variables
    public GenerateXmlFile(String selectedMasterrecordType, String selectedOrderType, String headerSource, String headerDestination,
                           String headerRecordTypeName, int headerSequence, String headerOrderType, String filePath) {
        this.selectedMasterrecordType = selectedMasterrecordType;
        this.selectedOrderType = selectedOrderType;
        this.headerSource = headerSource;
        this.headerDestination = headerDestination;
        this.headerSequence = headerSequence;
        this.headerRecordTypeName = headerRecordTypeName;
        this.headerOrderType = headerOrderType;
        this.filePath = filePath;
    }

    // Method to generate XML file
    public void generateXmlFile() {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            // Create a new XML document
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // Root element: "Masterrecords"
            Element rootElement = doc.createElement("Masterrecords");
            doc.appendChild(rootElement);

            // Create "header" element and its sub-elements
            Element headerElement = doc.createElement("header");
            rootElement.appendChild(headerElement);

            Element headerSourceElement = doc.createElement("HEADER_SOURCE");
            headerSourceElement.appendChild(doc.createTextNode(headerSource));
            headerElement.appendChild(headerSourceElement);

            Element headerDestinationElement = doc.createElement("HEADER_DESTINATION");
            headerDestinationElement.appendChild(doc.createTextNode(headerDestination));
            headerElement.appendChild(headerDestinationElement);

            Element headerSequenceElement = doc.createElement("HEADER_SEQUENCE");
            headerSequenceElement.appendChild(doc.createTextNode(String.valueOf(headerSequence)));
            headerElement.appendChild(headerSequenceElement);

            Element headerCreationTimeElement = doc.createElement("HEADER_CREATIONTIME");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            headerCreationTimeElement.appendChild(doc.createTextNode(dateFormat.format(new Date())));
            headerElement.appendChild(headerCreationTimeElement);

            Element headerRecordTypeNameElement = doc.createElement("HEADER_RECORDTYPENAME");
            headerRecordTypeNameElement.appendChild(doc.createTextNode(headerRecordTypeName));
            headerElement.appendChild(headerRecordTypeNameElement);

            Element headerOrderTypeElement = doc.createElement("HEADER_ORDERTYPE");
            headerOrderTypeElement.appendChild(doc.createTextNode(headerOrderType));
            headerElement.appendChild(headerOrderTypeElement);

            // Create "Masterrecord" element and set its "Type" attribute
            Element masterrecordElement = doc.createElement("Masterrecord");
            rootElement.appendChild(masterrecordElement);
            masterrecordElement.setAttribute("Type", selectedMasterrecordType);

            // Create "OrderType" element and set its "Type" attribute
            Element orderTypeElement = doc.createElement("OrderType");
            rootElement.appendChild(orderTypeElement);
            orderTypeElement.setAttribute("Type", selectedOrderType);

            // Add additional fields for the Masterrecord (Replace with actual values)
            Element field1Element = doc.createElement("Field1");
            field1Element.appendChild(doc.createTextNode("Value1")); // Replace with field1Value
            masterrecordElement.appendChild(field1Element);

            Element field2Element = doc.createElement("Field2");
            field2Element.appendChild(doc.createTextNode("123")); // Replace with field2Value
            masterrecordElement.appendChild(field2Element);

            // Prepare and write the XML to the specified file path
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

            System.out.println("XML file generated.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Input parameters
        String selectedMasterrecordType = "MasterrecordType1";
        String selectedOrderType = "OrderType1";
        String headerSource = "HOST";
        String headerDestination = "WAMAS";
        int headerSequence = 0;
        String headerRecordTypeName = selectedMasterrecordType;
        String headerOrderType = selectedOrderType;
        String filePath = "C:\\wamas\\workspace\\Telegrammgenerator Material\\XML_Test.xml";

        // Create an instance of GenerateXmlFile and generate the XML
        GenerateXmlFile generator = new GenerateXmlFile(selectedMasterrecordType, selectedOrderType, headerSource, headerDestination, headerRecordTypeName,
                headerSequence, headerOrderType, filePath);
        generator.generateXmlFile();
    }
}

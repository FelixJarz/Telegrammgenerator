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
    private String selectedMasterrecordType;
    private String headerSource;
    private String headerDestination;
    private int headerSequence;
    private String headerRecordTypeName;
    private String headerOrderType;
    private String filePath;
    //private String selectedOrderType;
    private String selectedSubrecordType; 

    // Constructor to initialize the instance variables
    public GenerateXmlFile(String selectedMasterrecordType, String selectedOrderType, String headerSource, String headerDestination,
                           String headerRecordTypeName, int headerSequence, String headerOrderType, String filePath, String selectedSubrecordType) {
        this.selectedMasterrecordType = selectedMasterrecordType;
        //this.selectedOrderType = selectedOrderType; -> Rename to selected Master Record Type 
        this.selectedSubrecordType = selectedSubrecordType;
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

//1st Highest hierarchy 
            
            
            // Root element: Document Name
            Element rootElement = doc.createElement("Name of Document"); //actually document name
            doc.appendChild(rootElement);

//2nd Highest hierarchy
            
            // Create "header" element and its sub-elements
            Element headerElement = doc.createElement("header");
            rootElement.appendChild(headerElement);
            
            Element bodyElement = doc.createElement("body");
            rootElement.appendChild(bodyElement);
            
//3rd Highest hierarchy 
            
            Element fullElement = doc.createElement("FULL");
            headerElement.appendChild(fullElement);
            
            Element masterrecordElement = doc.createElement(selectedMasterrecordType);
            bodyElement.appendChild(masterrecordElement);
            
//4th Highest hierarchy
            
  //Header (maybe read all reqiered field from a file) 
            
            Element headerSourceElement = doc.createElement("HEADER_SOURCE");
            headerSourceElement.appendChild(doc.createTextNode(headerSource));
            fullElement.appendChild(headerSourceElement);

            Element headerDestinationElement = doc.createElement("HEADER_DESTINATION");
            headerDestinationElement.appendChild(doc.createTextNode(headerDestination));
            fullElement.appendChild(headerDestinationElement);

            Element headerSequenceElement = doc.createElement("HEADER_SEQUENCE");
            headerSequenceElement.appendChild(doc.createTextNode(String.valueOf(headerSequence)));
            fullElement.appendChild(headerSequenceElement);

            Element headerCreationTimeElement = doc.createElement("HEADER_CREATIONTIME");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            headerCreationTimeElement.appendChild(doc.createTextNode(dateFormat.format(new Date())));
            fullElement.appendChild(headerCreationTimeElement);

            Element headerRecordTypeNameElement = doc.createElement("HEADER_RECORDTYPENAME");
            headerRecordTypeNameElement.appendChild(doc.createTextNode(headerRecordTypeName));
            fullElement.appendChild(headerRecordTypeNameElement);

            Element headerOrderTypeElement = doc.createElement("HEADER_ORDERTYPE");
            headerOrderTypeElement.appendChild(doc.createTextNode(headerOrderType));
            fullElement.appendChild(headerOrderTypeElement);
            
  //Body (add fields for masterrecord)
            
            // Create SelectedSubrecordType(s)
            Element subrecordElement = doc.createElement(selectedSubrecordType);
            masterrecordElement.appendChild(subrecordElement);

//5th Highest hierarchy (add fields to subrecord)
            
            // Add additional fields for the Masterrecord/Subrecords (Replace with actual values)
            Element field1Element = doc.createElement("Field1");
            field1Element.appendChild(doc.createTextNode("Value1")); // Replace with field1Value
            field1Element.appendChild(field1Element);

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

package package_background;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;



public class GenerateXmlFile {

    // Instance variables
    private String filePath;
    
	SessionData_Singleton sessionData = SessionData_Singleton.getInstance(); 
	FileContentReader fileContentReader = new FileContentReader();


    // Constructor to initialize the instance variables
    public GenerateXmlFile(String filePath) {
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
            Element rootElement = doc.createElement(sessionData.getSelectedProject()); 
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
            
            Element masterrecordElement = doc.createElement(sessionData.getSelectedRecordtype());
            bodyElement.appendChild(masterrecordElement);
            
//4th Highest hierarchy
            
  //Header
            
            Element headerSourceElement = doc.createElement("HEADER_SOURCE");
            headerSourceElement.appendChild(doc.createTextNode(sessionData.getHeaderSource()));
            fullElement.appendChild(headerSourceElement);

            Element headerDestinationElement = doc.createElement("HEADER_DESTINATION");
            headerDestinationElement.appendChild(doc.createTextNode(sessionData.getHeaderDestination()));
            fullElement.appendChild(headerDestinationElement);

            Element headerSequenceElement = doc.createElement("HEADER_SEQUENCE");
            headerSequenceElement.appendChild(doc.createTextNode(String.valueOf(sessionData.getHeaderSequence())));
            fullElement.appendChild(headerSequenceElement);

            Element headerCreationTimeElement = doc.createElement("HEADER_CREATIONTIME");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            headerCreationTimeElement.appendChild(doc.createTextNode(dateFormat.format(new Date())));
            fullElement.appendChild(headerCreationTimeElement);

            Element headerRecordTypeNameElement = doc.createElement("HEADER_RECORDTYPENAME");
            headerRecordTypeNameElement.appendChild(doc.createTextNode(sessionData.getSelectedRecordtype()));
            fullElement.appendChild(headerRecordTypeNameElement);

  //Body
            
            for(int j = 0; j < sessionData.getSelectedSubrecords().size(); j++) {
  			    Element subrecordElement = doc.createElement(sessionData.getSelectedSubrecords().get(j));
  			    masterrecordElement.appendChild(subrecordElement); 
            }
            
            //masterrec tags
    		String pathMaster = sessionData.getSelectedProjectPath() + sessionData.INCOMING + File.separator + sessionData.getSelectedRecordtype(); 
  			fileContentReader.ReadContent(pathMaster.replace(".xsd", ".csv"));
            for(int i = 0; i < (sessionData.getTotalEntries()-1); i++) {
                Element subrecordTag = doc.createElement(sessionData.getMasterrecordShortnames().get(i));
                subrecordTag.appendChild(doc.createTextNode(/*enter text from user*/sessionData.getMasterrecordList(i))); //not sure if it works 
                masterrecordElement.appendChild(subrecordTag); 
            }
            

//5th Highest hierarchy (add fields to subrecord)
            
            //maybe works
            for(int j = 0; j < sessionData.getSelectedSubrecords().size(); j++) {
  			    String pathSub = sessionData.getSelectedProjectPath() + sessionData.INCOMING + File.separator + sessionData.getSelectedSubrecords().get(j); 
            	fileContentReader.ReadContent(pathSub.replace(".xsd", ".csv"));
            	for(int i = 0; i < (sessionData.getTotalEntries()-1); i++) {
                	Element subrecordTag = doc.createElement(sessionData.getMasterrecordShortnames().get(i));
                	subrecordTag.appendChild(doc.createTextNode(/*enter text from user*/null));
                	masterrecordElement.appendChild(subrecordTag); 
                }
            }

            
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
}

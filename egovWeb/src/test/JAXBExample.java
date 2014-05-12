package test;
 
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
 
public class JAXBExample {
	public static void main(String[] args) {
 
	  Customer customer1 = new Customer();
	  customer1.setId(100);
	  customer1.setName("mkyong");
	  customer1.setAge(29);
	  
	  Customer customer2 = new Customer();
	  customer2.setId(102);
	  customer2.setName("mkyong1");
	  customer2.setAge(33);
	  
	  CustomerList customers = new CustomerList(); 
	  customers.getCustomers().add(customer1);
	  customers.getCustomers().add(customer2);
 
	  try {
 
		File file = new File("C:/test/file.xml");
		String xmlStr= new String();
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); 
		JAXBContext jaxbContext = JAXBContext.newInstance(CustomerList.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
 
		// output pretty printed
		//jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
		jaxbMarshaller.marshal(customers, byteArrayOutputStream);
//		jaxbMarshaller.marshal(customers, System.out);
		xmlStr = byteArrayOutputStream.toString();
		System.out.println("******* \n"+xmlStr);
		
		//****//
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xmlStr.getBytes());
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		CustomerList unmarshalledCustomerList = (CustomerList) jaxbUnmarshaller.unmarshal(byteArrayInputStream);
		System.out.println("length: "+unmarshalledCustomerList.getCustomers().size());
		
 
	      } catch (JAXBException e) {
		e.printStackTrace();
	      }
 
	}
}
package test;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="customerList")
public class CustomerList {

	
	private List<Customer> customers  ;

	/**
	 * @return the customers
	 */
	@XmlElement(name="Customer")
	public List<Customer> getCustomers() {
		if(customers == null){
			customers = new ArrayList<Customer>();
		}
		return customers;
	}

	/**
	 * @param customers the customers to set
	 */
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	} 
	
	
}

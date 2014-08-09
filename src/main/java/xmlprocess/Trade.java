package xmlprocess;

import java.math.BigDecimal;

@javax.xml.bind.annotation.XmlRootElement(name="trade")
public class Trade {

	String isin;
	
	BigDecimal quantity;
	
	String customer;
	
	BigDecimal price;
	
	public String getCustomer() {
		return customer;
	}

	@javax.xml.bind.annotation.XmlElement(name="customer")
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public BigDecimal getPrice() {
		return price;
	}
	
	@javax.xml.bind.annotation.XmlElement(name="price")
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getIsin() {
		return isin;
	}
	@javax.xml.bind.annotation.XmlElement(name="isin")
	public void setIsin(String isin) {
		this.isin = isin;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}

	@javax.xml.bind.annotation.XmlElement(name="quantity")
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return String.format("customer:%s, price:%f, isin:%s, qty:%f", getCustomer(), getPrice(), getIsin(), getQuantity());
	}
	
	
}

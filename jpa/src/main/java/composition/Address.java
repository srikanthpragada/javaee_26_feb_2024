package composition;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	@Column(name = "street", length = 20)
	private String street;
	@Column(name = "city", length = 20)
	private String city;

	public Address() {
		super();
	}
 
	public Address(String street, String city) {
		super();
		this.street = street;
		this.city = city;
	}

}

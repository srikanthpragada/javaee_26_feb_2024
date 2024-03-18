package inh;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "inh.Singer")
@DiscriminatorValue("s")
public class Singer extends Person {
	private String lang;

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

}

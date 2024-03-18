package inh.tps;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "inh.tps.Singer")
@Table(name = "tps_singler")
public class Singer extends Person {
	private String lang;

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

}

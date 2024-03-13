package composition;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "players")
@Entity(name = "composition.Player")
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pid")
	private int id;
	@Column(name = "pname", length = 20)
	private String name;

	@Embedded
	private Address home;

	public Player(String name, Address home) {
		super();
		this.name = name;
		this.home = home;
	}

}

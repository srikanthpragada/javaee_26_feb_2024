package inh;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "inh.Player")
@DiscriminatorValue ("p")
public class Player extends Person{
	@Column(length = 20)
    private String game;

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}
	
	
}

package inh.tps;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "inh.tps.Player")
@Table(name = "tps_players")
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

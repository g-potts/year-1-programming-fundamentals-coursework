package lab6_exercise2;

public class Halfbacks {
	
	private Player[] players;
	
	public Halfbacks() {
		this.players = new Player[2];
	}
	
	public void assignHalfback(Player player) {
		switch (player.getPosition()) {
		case SCRUMHALF:
			players[0] = player;
			break;
		case FLYHALF:
			players[1] = player;
			break;
		default:
			break;
		}	
	}
	
	public String displayElements() {
		StringBuffer output = new StringBuffer();
		for (int i = 0; i < players.length; i++) {
			output.append(i + " - ");
			if (players[i] != null) {
				output.append(players[i].getName() + " " +  players[i].getPosition());
			}
			output.append("\n");

		}
		return output.toString();
	}
	
	public String getPlayer(RugbyPosition position) {
		switch (position) {
		case SCRUMHALF:
			return this.players[0].getName();
		case FLYHALF:
			return this.players[1].getName();
		default:
			return null;
		}
	}
	
}

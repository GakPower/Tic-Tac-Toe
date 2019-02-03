import java.util.ArrayList;

class Player
{
	private static Player currentPlayer;
	private static ArrayList<Player> players = new ArrayList<>();

	private String symbol;

	public Player(String symbol)
	{
		this.symbol = symbol;
		players.add(this);
	}

	void placeInField(Field field){
		field.setValue(symbol);
	}

	static Player getCurrentPlayer(){
		return currentPlayer;
	}

	static void setCurrentPlayer(Player player){
		currentPlayer = player;
	}

	String getSymbol(){
		return this.symbol;
	}

	static void changePlayer(){
		if (players.indexOf(currentPlayer) == 0){
			currentPlayer = players.get(1);
		}else{
			currentPlayer = players.get(0);
		}
	}

	static String getLabelOfCurrentPlayer(){
		if (players.indexOf(currentPlayer) == 0){
			return "Player One("+currentPlayer.getSymbol()+")";
		}
		return "Player Two("+currentPlayer.getSymbol()+")";
	}

	static void resetCurrentPlayer(){
		setCurrentPlayer(players.get(0));
	}
}

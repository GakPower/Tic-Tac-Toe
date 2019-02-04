class GameData {

	private String data;

	GameData(Player player1, Player player2, Board board)
	{
		StringBuilder stringBuilder = new StringBuilder();
		for (Field field : board.getFields())
		{
			int stateMove;
			if (field.getValue().equals(player1.getSymbol()))
			{
				stateMove = 1;
			}else if(field.getValue().equals(player2.getSymbol()))
			{
				stateMove = 2;
			}else{
				stateMove = 0;
			}
			stringBuilder.append(stateMove);
			stringBuilder.append(' ');
		}
		stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(" "));
		stringBuilder.append('\n');
		this.data = stringBuilder.toString();
	}

	String getData()
	{
		return data;
	}
}

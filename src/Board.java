import com.jfoenix.controls.JFXButton;

import java.util.ArrayList;

class Board
{
	private Field[] fields;
	private static boolean gameOver =false;

	Board(JFXButton[] textFields)
	{
		ArrayList<Field> fields = new ArrayList<>();
		for (JFXButton textField: textFields) {
			fields.add(new Field(textField));
		}

		this.fields = fields.toArray(new Field[0]);
	}

	boolean playerWon(Player player)
	{
		if (fields[0].getValue().equals(fields[1].getValue())
				&& fields[0].getValue().equals(fields[2].getValue())
				&& !fields[0].getValue().equals(" ")
				&& fields[0].getValue().equals(player.getSymbol()))
		{
			fields[0].setStyle("-fx-background-color: rgba(220, 8, 10, 0.74);");
			fields[1].setStyle("-fx-background-color: rgba(220, 8, 10, 0.74);");
			fields[2].setStyle("-fx-background-color: rgba(220, 8, 10, 0.74);");

			gameOver = true;
			return true;
		}else if (fields[0].getValue().equals(fields[3].getValue())
				&& fields[0].getValue().equals(fields[6].getValue())
				&& !fields[0].getValue().equals(" ")
				&& fields[0].getValue().equals(player.getSymbol()))
		{
			fields[0].setStyle("-fx-background-color: rgba(220, 8, 10, 0.74);");
			fields[3].setStyle("-fx-background-color: rgba(220, 8, 10, 0.74);");
			fields[6].setStyle("-fx-background-color: rgba(220, 8, 10, 0.74);");

			gameOver = true;
			return true;
		}else if (fields[0].getValue().equals(fields[4].getValue())
				&& fields[0].getValue().equals(fields[8].getValue())
				&& !fields[0].getValue().equals(" ")
				&& fields[0].getValue().equals(player.getSymbol()))
		{
			fields[0].setStyle("-fx-background-color: rgba(220, 8, 10, 0.74);");
			fields[4].setStyle("-fx-background-color: rgba(220, 8, 10, 0.74);");
			fields[8].setStyle("-fx-background-color: rgba(220, 8, 10, 0.74);");

			gameOver = true;
			return true;
		}else if (fields[1].getValue().equals(fields[4].getValue())
				&& fields[1].getValue().equals(fields[7].getValue())
				&& !fields[1].getValue().equals(" ")
				&& fields[1].getValue().equals(player.getSymbol()))
		{
			fields[1].setStyle("-fx-background-color: rgba(220, 8, 10, 0.74);");
			fields[4].setStyle("-fx-background-color: rgba(220, 8, 10, 0.74);");
			fields[7].setStyle("-fx-background-color: rgba(220, 8, 10, 0.74);");

			gameOver = true;
			return true;
		}else if (fields[2].getValue().equals(fields[5].getValue())
				&& fields[2].getValue().equals(fields[8].getValue())
				&& !fields[2].getValue().equals(" ")
				&& fields[2].getValue().equals(player.getSymbol()))
		{
			fields[2].setStyle("-fx-background-color: rgba(220, 8, 10, 0.74);");
			fields[5].setStyle("-fx-background-color: rgba(220, 8, 10, 0.74);");
			fields[8].setStyle("-fx-background-color: rgba(220, 8, 10, 0.74);");

			gameOver = true;
			return true;
		}else if (fields[3].getValue().equals(fields[4].getValue())
				&& fields[3].getValue().equals(fields[5].getValue())
				&& !fields[3].getValue().equals(" ")
				&& fields[3].getValue().equals(player.getSymbol()))
		{
			fields[3].setStyle("-fx-background-color: rgba(220, 8, 10, 0.74);");
			fields[4].setStyle("-fx-background-color: rgba(220, 8, 10, 0.74);");
			fields[5].setStyle("-fx-background-color: rgba(220, 8, 10, 0.74);");

			gameOver = true;
			return true;
		}else if (fields[6].getValue().equals(fields[7].getValue())
				&& fields[6].getValue().equals(fields[8].getValue())
				&& !fields[6].getValue().equals(" ")
				&& fields[6].getValue().equals(player.getSymbol()))
		{
			fields[6].setStyle("-fx-background-color: rgba(220, 8, 10, 0.74);");
			fields[7].setStyle("-fx-background-color: rgba(220, 8, 10, 0.74);");
			fields[8].setStyle("-fx-background-color: rgba(220, 8, 10, 0.74);");

			gameOver = true;
			return true;
		}else if (fields[2].getValue().equals(fields[4].getValue())
				&& fields[2].getValue().equals(fields[6].getValue())
				&& !fields[2].getValue().equals(" ")
				&& fields[2].getValue().equals(player.getSymbol()))
		{
			fields[2].setStyle("-fx-background-color: rgba(220, 8, 10, 0.74);");
			fields[4].setStyle("-fx-background-color: rgba(220, 8, 10, 0.74);");
			fields[6].setStyle("-fx-background-color: rgba(220, 8, 10, 0.74);");

			gameOver = true;
			return true;
		}
		return false;
	}

	void resetBoard(){
		for (Field field: fields) {
			field.setValue(" ");
			field.setStyle("-fx-background-color: #fff");
			gameOver = false;
		}
		Player.resetCurrentPlayer();
	}

	Field getFieldWithID(int id)
	{
		return fields[id];
	}

	Field[] getFields(){
		return fields;
	}

	boolean isGameOver(){
		return gameOver;
	}

	void setGameOver(boolean bool){
		gameOver = bool;
	}

	boolean noCellsLeft()
	{
		for (Field field: fields)
		{
			if (field.getValue().equals(" ")){
				return false;
			}
		}
		return true;
	}
}

import com.jfoenix.controls.JFXButton;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.util.Duration;
import org.python.util.PythonInterpreter;
import org.python.core.*;

public class App {

	@FXML private JFXButton resetButton;
	@FXML private Label currentPlayerLabel;

	@FXML private JFXButton textField00;
	@FXML private JFXButton textField01;
	@FXML private JFXButton textField03;

	@FXML private JFXButton textField10;
	@FXML private JFXButton textField11;
	@FXML private JFXButton textField12;

	@FXML private JFXButton textField20;
	@FXML private JFXButton textField21;
	@FXML private JFXButton textField22;

	private Player player1 = new Player("X");
	private Player player2 = new Player("O");
	private Board board;

	@FXML private void initialize()
	{
		JFXButton[] array = new JFXButton[9];
		array[0] = textField00;
		array[1] = textField01;
		array[2] = textField03;

		array[3] = textField10;
		array[4] = textField11;
		array[5] = textField12;

		array[6] = textField20;
		array[7] = textField21;
		array[8] = textField22;

		board = new Board(array);

		resetButton.setOnAction((event -> {
			board.resetBoard();
			currentPlayerLabel.setText(Player.getLabelOfCurrentPlayer());
		}));

		Player.setCurrentPlayer(player1);
		currentPlayerLabel.setText(Player.getLabelOfCurrentPlayer());

		for (Field field: board.getFields()) {
			field.getButton().setOnAction((event -> {
				if (field.getValue().equals(" ") && !board.isGameOver())
				{
					playAndCheck(player1, field);
					if (!board.isGameOver()){
						playAndCheck(player2, field);
					}
				}
			}));
		}
	}

	void playAndCheck(Player player, Field field){

		if (player == player1){
			Player.getCurrentPlayer().placeInField(field);
		}else{
			AIMove(player2);
		}

		if (board.playerWon(player1)){
			currentPlayerLabel.setText("Won("+player1.getSymbol()+")");
		} else if(board.playerWon(player2)){
			currentPlayerLabel.setText("Won("+player2.getSymbol()+")");
		} else if (board.noCellsLeft()){
			board.setGameOver(true);
			currentPlayerLabel.setText("Draw");
			for (Field fieldd : board.getFields()) {
				fieldd.setStyle("-fx-background-color: rgba(204, 71, 72, 0.74)");
			}
		}else{
			currentPlayerLabel.setText(Player.getLabelOfCurrentPlayer());
		}
	}

	int getAIMove()
	{
		String data = new GameData(player1, player2, board).getData();
		String s = null;
		try {
			Runtime rt = Runtime.getRuntime();
			String command = ("python C:\\Users\\alani\\IdeaProjects\\Tic-Tac-Toe\\src\\TicTacToeAI.py "+ data);
			Process proc = rt.exec(command);

			BufferedReader stdInput = new BufferedReader(new
					InputStreamReader(proc.getInputStream()));

			s = stdInput.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*if (!board.getFieldWithID(Integer.valueOf(s)).getValue().equals(" ")){
			s = String.valueOf(getAIMove());
		}*/

		return Integer.valueOf(s);
	}

	void AIMove(Player player2)
	{
		board.getFieldWithID(getAIMove()).setValue(player2.getSymbol());
	}
}

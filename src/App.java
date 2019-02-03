import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

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

		Board board = new Board(array);
		Player player1 = new Player("X");
		Player player2 = new Player("O");

		resetButton.setOnAction((event -> {
			board.resetBoard();
		}));

		Player.setCurrentPlayer(player1);
		currentPlayerLabel.setText(Player.getLabelOfCurrentPlayer());

		for (Field field: board.getFields()) {
			field.getButton().setOnAction((event -> {
				if (field.getValue().equals(" "))
				{
					Player.getCurrentPlayer().placeInField(field);
					if (board.playerWon(Player.getCurrentPlayer())){
						currentPlayerLabel.setText("Won");
					}else{
						Player.changePlayer();
						currentPlayerLabel.setText(Player.getLabelOfCurrentPlayer());
					}

				}
			}));
		}

	}
}

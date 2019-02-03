import com.jfoenix.controls.JFXButton;

class Field
{
	private int id;
	private JFXButton button;

	private static int idCounter = 0;

	Field(JFXButton button)
	{
		this.id = idCounter++;
		this.button = button;
	}

	void setValue(String symbol){
		this.button.setText(symbol);
	}
	String getValue(){
		return this.button.getText();
	}

	void setStyle(String style){
		this.button.setStyle(style);
	}

	JFXButton getButton(){
		return button;
	}

	int getId(){
		return id;
	}
}
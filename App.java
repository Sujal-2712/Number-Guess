import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class App extends Application {
    @FXML
    private Button GuessBtn;

    @FXML
    private TextField inputNumber;

    @FXML
    private Label message;

    int randomNumber = (int) (Math.random() * 100) + 1;
    int attempts = 0;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void checkGuess() {

        String input = inputNumber.getText();
        int Number;
        try {
            Number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            message.setText("Invalid input!");
            return;
        }
        attempts++;
        if (Number == randomNumber) {
            message.setText("You guessed the number in " + attempts + " attempts.");
        } else if (Number < randomNumber) {
            message.setText("Please Enter the Higher Value \n Guesses :" + attempts);
        } else {
            message.setText("Please Enter the Lower Value \n Guesses :" + attempts);
        }
        inputNumber.clear();

    }

}

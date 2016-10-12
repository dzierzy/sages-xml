package pl.com.sages.jprog.javafx.guess;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by marcin on 29.06.2016.
 */
public class GuessNumberApp extends Application {

    private SecretNumber secret = new SecretNumber();

    private TextField guessField;

    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Guess My Number");

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(25, 25, 25, 25));
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHalignment(HPos.CENTER);
        pane.getColumnConstraints().add(column1);

        Scene scene = new Scene(pane, 400, 200);

        pane.add(new Text("There is a number to guess! It's bettwen 1 and 100."), 0, 0);

        Label guessLabel = new Label("Your guess: ");
        pane.add(guessLabel, 0, 1);

        guessField = new TextField();
        pane.add(guessField, 0, 2);

        Button button = new Button("Check !");
        pane.add(button, 0, 3);

        button.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Result");
            alert.setHeaderText("Verifying...");

            int guess = Integer.parseInt(guessField.getText());

            String message = secret.guess(guess)==0 ? "Right!" :
                    (secret.guess(guess)>0 ? "Too little..." : "Too big...");

            alert.setContentText(message);
            alert.showAndWait();
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}

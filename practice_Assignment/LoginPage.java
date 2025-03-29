package practice_Assignment;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoginPage extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create UI components
        Label lblTitle = new Label("Login Assignment");
        lblTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        
        Label lblUsername = new Label("Username:");
        TextField txtUsername = new TextField();
        txtUsername.setPrefWidth(200);
        txtUsername.setMaxWidth(200);
        
        Label lblPassword = new Label("Password:");
        PasswordField txtPassword = new PasswordField();
        txtPassword.setPrefWidth(200);
        txtPassword.setMaxWidth(200);
        
        Button btnLogin = new Button("Login");
        btnLogin.setPrefWidth(100);
        btnLogin.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        
        // Login button action
        btnLogin.setOnAction(e -> {
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            
            // Validation
            if (username.isEmpty() || password.isEmpty()) {
                lblTitle.setText("Login - Please enter credentials!");
                lblTitle.setTextFill(Color.RED);
            } else {
                // Typically check credentials
                lblTitle.setText("Login - Success!");
                lblTitle.setTextFill(Color.GREEN);
                System.out.println("Login try with: " + username + "/" + password);
            }
        });
        
        // Layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(
            lblTitle,
            lblUsername,
            txtUsername,
            lblPassword,
            txtPassword,
            btnLogin
        );
        
        // Scene and stage setup
        Scene scene = new Scene(root, 300, 300);
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
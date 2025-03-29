package practice_Assignment;

import java.awt.Color;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    private String currentInput = "";
    private double firstOperand = 0;
    private String operator = "";
    private boolean startNewInput = true;
    private Label display;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Declare
        Label lblTitle;
        Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
        Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnEquals, btnClear, btnDecimal;

        // Initialize
        lblTitle = new Label("Calculator");
        lblTitle.relocate(50, 0);
        Font font = new Font("Arial", 20);
        lblTitle.setFont(font);

        display = new Label("0");
        display.relocate(50, 40);
        display.setFont(new Font("Arial", 24));
        display.setPrefWidth(200);

        // Number buttons
        btn7 = new Button("7");
        btn7.relocate(50, 90);
        btn7.setPrefSize(50, 50);

        btn8 = new Button("8");
        btn8.relocate(110, 90);
        btn8.setPrefSize(50, 50);

        btn9 = new Button("9");
        btn9.relocate(170, 90);
        btn9.setPrefSize(50, 50);

        btn4 = new Button("4");
        btn4.relocate(50, 150);
        btn4.setPrefSize(50, 50);

        btn5 = new Button("5");
        btn5.relocate(110, 150);
        btn5.setPrefSize(50, 50);

        btn6 = new Button("6");
        btn6.relocate(170, 150);
        btn6.setPrefSize(50, 50);

        btn1 = new Button("1");
        btn1.relocate(50, 210);
        btn1.setPrefSize(50, 50);

        btn2 = new Button("2");
        btn2.relocate(110, 210);
        btn2.setPrefSize(50, 50);

        btn3 = new Button("3");
        btn3.relocate(170, 210);
        btn3.setPrefSize(50, 50);

        btn0 = new Button("0");
        btn0.relocate(50, 270);
        btn0.setPrefSize(110, 50);

        btnDecimal = new Button(".");
        btnDecimal.relocate(170, 270);
        btnDecimal.setPrefSize(50, 50);

        // Operation buttons
        btnAdd = new Button("+");
        btnAdd.relocate(230, 90);
        btnAdd.setPrefSize(50, 50);

        btnSubtract = new Button("-");
        btnSubtract.relocate(230, 150);
        btnSubtract.setPrefSize(50, 50);

        btnMultiply = new Button("*");
        btnMultiply.relocate(230, 210);
        btnMultiply.setPrefSize(50, 50);

        btnDivide = new Button("/");
        btnDivide.relocate(230, 270);
        btnDivide.setPrefSize(50, 50);

        btnEquals = new Button("=");
        btnEquals.relocate(290, 90);
        btnEquals.setPrefSize(50, 110);

        btnClear = new Button("C");
        btnClear.relocate(290, 210);
        btnClear.setPrefSize(50, 110);

        // Event Handlers for number buttons
        EventHandler<ActionEvent> numberHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (startNewInput) {
                    currentInput = "";
                    startNewInput = false;
                }
                currentInput += ((Button) event.getSource()).getText();
                display.setText(currentInput);
            }
        };

        btn0.setOnAction(numberHandler);
        btn1.setOnAction(numberHandler);
        btn2.setOnAction(numberHandler);
        btn3.setOnAction(numberHandler);
        btn4.setOnAction(numberHandler);
        btn5.setOnAction(numberHandler);
        btn6.setOnAction(numberHandler);
        btn7.setOnAction(numberHandler);
        btn8.setOnAction(numberHandler);
        btn9.setOnAction(numberHandler);
        btnDecimal.setOnAction(numberHandler);
        
      

        // Event Handlers for operation buttons
        EventHandler<ActionEvent> operatorHandler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!currentInput.isEmpty()) {
                    firstOperand = Double.parseDouble(currentInput);
                    operator = ((Button) event.getSource()).getText();
                    startNewInput = true;
                }
            }
        };

        btnAdd.setOnAction(operatorHandler);
        btnSubtract.setOnAction(operatorHandler);
        btnMultiply.setOnAction(operatorHandler);
        btnDivide.setOnAction(operatorHandler);

        // Equals button
        btnEquals.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!operator.isEmpty() && !currentInput.isEmpty()) {
                    double secondOperand = Double.parseDouble(currentInput);
                    double result = 0;
                    
                    switch (operator) {
                        case "+":
                            result = firstOperand + secondOperand;
                            break;
                        case "-":
                            result = firstOperand - secondOperand;
                            break;
                        case "*":
                            result = firstOperand * secondOperand;
                            break;
                        case "/":
                            result = firstOperand / secondOperand;
                            break;
                    }
                    
                    display.setText(String.valueOf(result));
                    currentInput = String.valueOf(result);
                    operator = "";
                    startNewInput = true;
                }
            }
        });

        // Clear button
        btnClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                currentInput = "";
                firstOperand = 0;
                operator = "";
                display.setText("0");
                startNewInput = true;
            }
        });

        Pane pane = new Pane();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setWidth(400);
        primaryStage.setHeight(400);
        primaryStage.setTitle("Calculator");

        pane.getChildren().add(lblTitle);
        pane.getChildren().add(display);
        pane.getChildren().addAll(btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9);
        pane.getChildren().addAll(btnAdd, btnSubtract, btnMultiply, btnDivide, btnEquals, btnClear, btnDecimal);
        
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
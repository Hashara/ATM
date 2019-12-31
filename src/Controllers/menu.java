package Controllers;

import Objects.ATMCard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import static javafx.geometry.Pos.CENTER_LEFT;
import static javafx.geometry.Pos.CENTER_RIGHT;

public class menu extends pin {
//    private ATMCard atmcard;
//
    public menu(BorderPane pane, ATMCard atmCard) {
        super(pane, atmCard);
    }


    @Override
    public void InitialDisplay(BorderPane pane){
        GridPane display = new GridPane();
        pane.setCenter(display);



        Label balanceLabel = new Label("Check Balance");
        balanceLabel.setMinSize(360,60);
        display.add(balanceLabel,1,0);


        Label WithdrawLabel = new Label("Cash withdrawal");
        WithdrawLabel.setMinSize(360,60);
        display.add(WithdrawLabel,2,0);
    }

    @Override
    public void LeftSidePane(BorderPane pane){

        GridPane g = new GridPane();
        pane.setLeft(g);

        leftButton.setDefaultButton(true);
        leftButton.setPrefSize(180,60);
        g.add(leftButton,1,4);

        LeftSideButtonController( pane, leftButton);
    }

    @Override
    public void RightSidePane(BorderPane pane){
        GridPane g1 = new GridPane();
        pane.setRight(g1);

        rightButton.setDefaultButton(true);
        rightButton.setPrefSize(180,60);
        g1.add(rightButton,1,4);

        RightSideButtonController( pane, rightButton);
    }
    @Override
    public void LeftSideButtonController(BorderPane parentPane, Button leftButton) {
        System.out.println("hi");
        leftButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("left");
            }
        });
    }

    @Override
    public void RightSideButtonController(BorderPane parentPane, Button rightButton) {
        rightButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("right");
            }
        });
    }
}

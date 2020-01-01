package Controllers;

import Objects.ATMCard;
import Objects.Account;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class Balance extends menu {

    private Account account;
    public ATMCard atmCard;

    public Balance(BorderPane pane, ATMCard atmCard, Account account) {
        super(pane, atmCard);
        this.account = account;
        this.atmCard = atmCard;
    }

    @Override
    public void InitialDisplay(BorderPane pane) {
        GridPane display = new GridPane();
        pane.setCenter(display);

        Label balanceLabel = new Label("Your balance is");
        balanceLabel.setMinSize(360,60);
        display.add(balanceLabel,1,0);


        Label WithdrawLabel = new Label(account.getBalance());
        WithdrawLabel.setMinSize(360,60);
        display.add(WithdrawLabel,1,1);
    }

    @Override
    public void LeftSidePane(BorderPane pane) {
        GridPane g = new GridPane();
        pane.setLeft(g);

        leftButton.setDefaultButton(true);
        leftButton.setPrefSize(180,60);
        g.add(leftButton,1,10);

        LeftSideButtonController( pane, leftButton);
    }

    @Override
    public void RightSidePane(BorderPane pane) {
        GridPane g1 = new GridPane();
        pane.setRight(g1);

        rightButton.setDefaultButton(true);
        rightButton.setPrefSize(180,60);
        g1.add(rightButton,1,10);

        RightSideButtonController( pane, rightButton);
    }

    @Override
    public void LeftSideButtonController(BorderPane parentPane, Button leftButton) {

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

    @Override
    public void BottomControllerKeys(BorderPane parentPane, Button enter, Button cancel, Button clear) {
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                menu Menu = new menu(parentPane,atmCard);
                Menu.InitialDisplay(parentPane);
                Menu.LeftSidePane(parentPane);
                Menu.RightSidePane(parentPane);
            }
        });

        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

//
                menu Menu = new menu(parentPane, atmCard);
                Menu.InitialDisplay(parentPane);
                Menu.LeftSidePane(parentPane);
                Menu.RightSidePane(parentPane);
            }
        });
    }
}

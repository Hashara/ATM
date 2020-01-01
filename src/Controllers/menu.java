package Controllers;

import Models.savings_accountModel;
import Objects.ATMCard;
import Objects.Account;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class menu extends pin {

    private Account account = new Account();
    private savings_accountModel model = new savings_accountModel();
    private ATMCard atmCard;

    public menu(BorderPane pane, ATMCard atmCard) {
        super(pane, atmCard);
        this.atmCard = atmCard;
        account.setAccountNum(atmCard.getAccountNumber());
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
        g.add(leftButton,1,10);

        LeftSideButtonController( pane, leftButton);
    }

    @Override
    public void RightSidePane(BorderPane pane){
        GridPane g1 = new GridPane();
        pane.setRight(g1);

        rightButton.setDefaultButton(true);
        rightButton.setPrefSize(180,60);
        g1.add(rightButton,1,10);

        RightSideButtonController( pane, rightButton);
    }
    @Override
    public void LeftSideButtonController(BorderPane parentPane, Button leftButton) {
        System.out.println("hi");
        leftButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("left");

                account.setBalance(model.getBalance(account));

                Balance balance =  new Balance( parentPane,atmCard,  account);
                balance.InitialDisplay(parentPane);
                balance.LeftSidePane(parentPane);
                balance.RightSidePane(parentPane);

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

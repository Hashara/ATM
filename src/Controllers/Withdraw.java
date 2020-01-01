package Controllers;

import Models.atm_withdrawModel;
import Models.debit_cardModel;
import Objects.ATMCard;
import Objects.Account;
import Objects.WithdrawObject;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

import java.util.ArrayList;

public class Withdraw extends menu{

    private Account account;
    public ATMCard atmCard;
    private String amount = "";
    private float FlaotAmount;

    public Withdraw(BorderPane pane, ATMCard atmCard, Account account) {
        super(pane, atmCard);
        this.account = account;
        this.atmCard = atmCard;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
        FlaotAmount = Float.parseFloat(getAmount());
        if (FlaotAmount>50000){
            this.amount = "";
            FlaotAmount = 0;
        }
//        System.out.println(FlaotAmount);
    }

    @Override
    public void InitialDisplay(BorderPane pane) {
        GridPane display = new GridPane();
        pane.setCenter(display);

        Label balanceLabel = new Label("Enter the withdrawal amount");
        balanceLabel.setMinSize(360,60);
        display.add(balanceLabel,1,0);



        Label WithdrawLabel = new Label("RS " + getAmount()+".00");
        WithdrawLabel.setMinSize(360,60);
        display.add(WithdrawLabel,1,1);

        Label confirmLabel =  new Label("Confirm");
        confirmLabel.setMinSize(360,60);
        display.add(confirmLabel,1,2);

        Label cancelLabel = new Label("Cancel");
        cancelLabel.setMinSize(360,60);
        display.add(cancelLabel,2,2);


    }

    @Override
    public void BottomPane(BorderPane pane){
        BottomKeyPad(bottomBorderPane,pane);

        BottomController(bottomBorderPane,pane);
        pane.setBottom(bottomBorderPane);

//        panes[1] = bottomBorderPane;

    }

    @Override
    public void BottomKeyPad(BorderPane pane,BorderPane parentPane){
        GridPane bottomKeyPad = new GridPane();
        pane.setLeft(bottomKeyPad);
        //Key Pad
//        Button Button1 = new Button("1");
        Button1.setDefaultButton(true);
        Button1.setPrefSize(60,60);
        bottomKeyPad.add(Button1,1,1);

//        Button Button2 = new Button("2");
        Button2.setDefaultButton(true);
        Button2.setPrefSize(60,60);
        bottomKeyPad.add(Button2,2,1);

//        Button Button3 = new Button("3");
        Button3.setDefaultButton(true);
        Button3.setPrefSize(60,60);
        bottomKeyPad.add(Button3,3,1);

//        Button Button4 = new Button("4");
        Button4.setDefaultButton(true);
        Button4.setPrefSize(60,60);
        bottomKeyPad.add(Button4,1,2);

//        Button Button5 = new Button("5");
        Button5.setDefaultButton(true);
        Button5.setPrefSize(60,60);
        bottomKeyPad.add(Button5,2,2);

//        Button Button6 = new Button("6");
        Button6.setDefaultButton(true);
        Button6.setPrefSize(60,60);
        bottomKeyPad.add(Button6,3,2);

//        Button Button7 = new Button("7");
        Button7.setDefaultButton(true);
        Button7.setPrefSize(60,60);
        bottomKeyPad.add(Button7,1,3);

//        Button Button8 = new Button("8");
        Button8.setDefaultButton(true);
        Button8.setPrefSize(60,60);
        bottomKeyPad.add(Button8,2,3);

//        Button Button9 = new Button("9");
        Button9.setDefaultButton(true);
        Button9.setPrefSize(60,60);
        bottomKeyPad.add(Button9,3,3);

        Button DummyButton = new Button("");
        DummyButton.setDefaultButton(true);
        DummyButton.setPrefSize(60,60);
        bottomKeyPad.add(DummyButton,1,4);

//        Button Button0 = new Button("0");
        Button0.setDefaultButton(true);
        Button0.setPrefSize(60,60);
        bottomKeyPad.add(Button0,2,4);

        Button DummyButton1 = new Button("");
        DummyButton1.setDefaultButton(true);
        DummyButton1.setPrefSize(60,60);
        bottomKeyPad.add(DummyButton1,3,4);


        keyPadController(parentPane, Button0,  Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8, Button9);



    }

    @Override
    public void BottomController(BorderPane pane,BorderPane parentPane){
        GridPane bottomController = new GridPane();
        pane.setRight(bottomController);

        /*cancel clear enter*/

        //Enter button
        Button enter = new Button("ENTER");
        enter.setDefaultButton(true);
        enter.setPrefSize(180,60);
        bottomController.add(enter,4,1);

        //cancel button
        Button cancel = new Button("CANCEL");
        cancel.setDefaultButton(true);
        cancel.setPrefSize(180,60);
        bottomController.add(cancel,4,2);

        //clear button
        Button clear = new Button("CLEAR");
        clear.setDefaultButton(true);
        clear.setPrefSize(180,60);
        bottomController.add(clear,4,3);

        BottomControllerKeys(parentPane,enter, cancel, clear);
    }

    @Override
    public void BottomControllerKeys(BorderPane parentPane, Button enter, Button cancel, Button clear){
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

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


            }
        });

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
    public void LeftSideButtonController(BorderPane parentPane,Button leftButton){

    }

    @Override
    public void RightSideButtonController(BorderPane parentPane,Button rightButton){
        rightButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                System.out.println("right");

                WithdrawObject wobj = new WithdrawObject();
                wobj.setCardNumber(atmCard.getCardNumber());
                wobj.setAmount(amount);

                atm_withdrawModel model = new atm_withdrawModel();
                String res = model.WithdrawMoney(wobj);
                System.out.println(res);

            }
        });
    }
    @Override
    public void keyPadController(BorderPane parentPane, Button Button0, Button Button1, Button Button2, Button Button3, Button Button4, Button Button5, Button Button6, Button Button7, Button Button8, Button Button9) {
        Button0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setAmount(getAmount()+"0");
                InitialDisplay(parentPane);
            }
        });

        Button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setAmount(getAmount()+"1");
                InitialDisplay(parentPane);
            }
        });

        Button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setAmount(getAmount()+"2");
                InitialDisplay(parentPane);
            }
        });

        Button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setAmount(getAmount()+"3");
                InitialDisplay(parentPane);
            }
        });

        Button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setAmount(getAmount()+"4");
                InitialDisplay(parentPane);
            }
        });

        Button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setAmount(getAmount()+"5");
                InitialDisplay(parentPane);
            }
        });

        Button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setAmount(getAmount()+"6");
                InitialDisplay(parentPane);
            }
        });

        Button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setAmount(getAmount()+"7");
                InitialDisplay(parentPane);
            }
        });

        Button8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setAmount(getAmount()+"8");
                InitialDisplay(parentPane);
            }
        });

        Button9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setAmount(getAmount()+"9");
                InitialDisplay(parentPane);
            }
        });
    }


}

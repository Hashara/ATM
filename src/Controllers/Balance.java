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

        Label exitLabel = new Label("EXIT");
        exitLabel.setMinSize(360, 60);
        display.add(exitLabel, 1, 3);

        Label moreLabel = new Label("MORE");
        moreLabel.setMinSize(360, 60);
        display.add(moreLabel, 2, 3);
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
                /*exit*/
                /*go to first page*/
                card c = new card();
                c.addUIControls(parentPane);
                c.InitialDisplay(parentPane);
                c.BottomPane(parentPane);
                c.LeftSidePane(parentPane);
                c.RightSidePane(parentPane);


            }
        });
    }

    @Override
    public void RightSideButtonController(BorderPane parentPane, Button rightButton) {
        rightButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("right");
                menu Menu = new menu(parentPane, atmCard);
                Menu.InitialDisplay(parentPane);
                Menu.LeftSidePane(parentPane);
                Menu.RightSidePane(parentPane);

            }
        });
    }

    @Override
    public void BottomControllerKeys(BorderPane parentPane, Button enter, Button cancel, Button clear) {
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                System.out.println("balance cancel");
                menu Menu = new menu(parentPane,atmCard);
                Menu.InitialDisplay(parentPane);
                Menu.LeftSidePane(parentPane);
                Menu.RightSidePane(parentPane);
            }
        });

        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("clear balance");
            }
        });

        enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                System.out.println("enter balance");
                menu Menu = new menu(parentPane, atmCard);
                Menu.InitialDisplay(parentPane);
                Menu.LeftSidePane(parentPane);
                Menu.RightSidePane(parentPane);
            }
        });
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
    public void keyPadController(BorderPane parentPane, Button Button0, Button Button1, Button Button2,Button Button3, Button Button4, Button Button5,Button Button6, Button Button7, Button Button8,Button Button9){
        Button0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        Button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        Button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        Button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        Button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        Button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        Button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        Button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        Button8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        Button9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
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


}

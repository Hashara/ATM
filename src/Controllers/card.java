package Controllers;

import Models.debit_cardModel;
import Objects.ATMCard;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javax.smartcardio.Card;
import java.util.ArrayList;

public class card extends Application{

    private Pane panes[] =new Pane[2];
    private String cardNumber = "";
    Button Button0 = new Button("0");
    Button Button1 = new Button("1");
    Button Button2 = new Button("2");
    Button Button3 = new Button("3");
    Button Button4 = new Button("4");
    Button Button5 = new Button("5");
    Button Button6 = new Button("6");
    Button Button7 = new Button("7");
    Button Button8 = new Button("8");
    Button Button9 = new Button("9");

    Button leftButton = new Button();
    Button rightButton = new Button();

    ATMCard atmcard = new ATMCard();
    debit_cardModel model = new debit_cardModel();

    BorderPane bottomBorderPane = new BorderPane();

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("");

        BorderPane pane = new BorderPane();
        addUIControls(pane);
        InitialDisplay(pane);
        BottomPane(pane);
        LeftSidePane(pane);
        RightSidePane(pane);

        Scene scene = new Scene(pane);

        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setScene(scene);
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        primaryStage.setMaxWidth(bounds.getWidth() * 2);
        primaryStage.show();
    }

    private void addUIControls(BorderPane pane){

        //Top pane
        HBox topAnchorPane = new HBox();
        topAnchorPane.setPrefSize(1196,88);
        pane.setTop(topAnchorPane);
        panes[0] = topAnchorPane;
        Region region1 = new Region();
        HBox.setHgrow(region1, Priority.ALWAYS);

        //Home Title
        Label homeLabel = new Label("Bank Of Sri Lanka");
        homeLabel.setFont(Font.font("Cambria", FontWeight.BOLD, 35));

        topAnchorPane.getChildren().addAll(homeLabel,region1);

    }

    public void BottomPane(BorderPane pane){
        BottomKeyPad(bottomBorderPane,pane);

        BottomController(bottomBorderPane,pane);
        pane.setBottom(bottomBorderPane);

        panes[1] = bottomBorderPane;

    }

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

    public void keyPadController(BorderPane parentPane, Button Button0, Button Button1, Button Button2,Button Button3, Button Button4, Button Button5,Button Button6, Button Button7, Button Button8,Button Button9){
        Button0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setCardNumber(getCardNumber()+"0");
                InitialDisplay(parentPane);
            }
        });

        Button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setCardNumber(getCardNumber()+"1");
                InitialDisplay(parentPane);
            }
        });

        Button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setCardNumber(getCardNumber()+"2");
                InitialDisplay(parentPane);
            }
        });

        Button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setCardNumber(getCardNumber()+"3");
                InitialDisplay(parentPane);
            }
        });

        Button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setCardNumber(getCardNumber()+"4");
                InitialDisplay(parentPane);
            }
        });

        Button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setCardNumber(getCardNumber()+"5");
                InitialDisplay(parentPane);
            }
        });

        Button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setCardNumber(getCardNumber()+"6");
                InitialDisplay(parentPane);
            }
        });

        Button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setCardNumber(getCardNumber()+"7");
                InitialDisplay(parentPane);
            }
        });

        Button8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setCardNumber(getCardNumber()+"8");
                InitialDisplay(parentPane);
            }
        });

        Button9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setCardNumber(getCardNumber()+"9");
                InitialDisplay(parentPane);
            }
        });
    }

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


    public ArrayList<Button> BottomControllerReturn(BorderPane pane, BorderPane parentPane){
        GridPane bottomController = new GridPane();
        pane.setRight(bottomController);
        ArrayList<Button> bottomButtons = new ArrayList<Button>();
        /*cancel clear enter*/

        //Enter button
        Button enter = new Button("ENTER");
        enter.setDefaultButton(true);
        enter.setPrefSize(180,60);
        bottomController.add(enter,4,1);
        bottomButtons.add(enter);

        //cancel button
        Button cancel = new Button("CANCEL");
        cancel.setDefaultButton(true);
        cancel.setPrefSize(180,60);
        bottomController.add(cancel,4,2);
        bottomButtons.add(cancel);

        //clear button
        Button clear = new Button("CLEAR");
        clear.setDefaultButton(true);
        clear.setPrefSize(180,60);
        bottomController.add(clear,4,3);
        bottomButtons.add(clear);

        return bottomButtons;
    }


    public void BottomControllerKeys(BorderPane parentPane, Button enter, Button cancel, Button clear){
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setCardNumber("");
                InitialDisplay(parentPane);
            }
        });

        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setCardNumber("");
                InitialDisplay(parentPane);
            }
        });

        enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (getCardNumber().length()==16){

                    atmcard.setCardNumber(getCardNumber());

                    debit_cardModel model = new debit_cardModel();
                    String result = model.IsCardNumberValid(atmcard);
                    System.out.println(result);
                    System.out.println(result =="success !");
                    if ( result.equals("success !")){
                        pin pinUi = new pin(parentPane, atmcard);
                        pinUi.InitialDisplay(parentPane);
                        pinUi.BottomControllerKeys(parentPane,enter, cancel, clear);
                        pinUi. keyPadController(parentPane, Button0,  Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8, Button9);
                    }else{
                        Alert a = new Alert(Alert.AlertType.ERROR);
                        a.setContentText(result);
                        a.show();
                        setCardNumber("");
                    }
                }
            }
        });

    }


    public void InitialDisplay(BorderPane pane){

        Alert a = new Alert(Alert.AlertType.ERROR);

        if (getCardNumber().length()>16){
            a.setContentText("Invalid card length");
            a.show();
            setCardNumber("");
        }

        GridPane display = new GridPane();
        pane.setCenter(display);

        display.setHgap(8);
        display.setVgap(8);
        display.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);

        //label
        Label headText = new Label("Enter the card number");
        display.add(headText,1,0,4,1);

        Label cardNumber = new Label(getCardNumber());
        display.add(cardNumber,1,2,4,1);




    }

    public void LeftSidePane(BorderPane pane){

        GridPane g = new GridPane();
        pane.setLeft(g);

        leftButton.setDefaultButton(true);
        leftButton.setPrefSize(180,60);
        g.add(leftButton,1,10);

        LeftSideButtonController( pane, leftButton);
    }

    public void RightSidePane(BorderPane pane){
        GridPane g1 = new GridPane();
        pane.setRight(g1);

        rightButton.setDefaultButton(true);
        rightButton.setPrefSize(180,60);
        g1.add(rightButton,1,10);

        RightSideButtonController( pane, rightButton);
    }

    public void LeftSideButtonController(BorderPane parentPane,Button leftButton){

    }

    public void RightSideButtonController(BorderPane parentPane,Button rightButton){

    }

    public void disableKeyPad(Button Button0, Button Button1,Button Button2,Button Button3,Button Button4,Button Button5,Button Button6,Button Button7,Button Button8,Button Button9){
        Button0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("disabled");
            }
        });

        Button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("disabled");
            }
        });

        Button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("disabled");
            }
        });

        Button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("disabled");
            }
        });

        Button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("disabled");
            }
        });

        Button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("disabled");
            }
        });

        Button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("disabled");
            }
        });

        Button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("disabled");
            }
        });

        Button8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("disabled");
            }
        });

        Button9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("disabled");
            }
        });
    }
}

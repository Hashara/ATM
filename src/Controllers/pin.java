package Controllers;

import Models.debit_cardModel;
import Objects.ATMCard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;

public class pin extends card {

    private BorderPane pane;
    private String pinNumber = "";
    private String stars = "";
    private ATMCard atmcard;
    private Label alertLabel;

    public pin(BorderPane pane, ATMCard atmCard) {
        this.pane = pane;
        this.atmcard = atmCard;
    }

    public String getPinNumber() {
        return pinNumber;
    }

    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    @Override
    public void keyPadController(BorderPane parentPane, Button Button0, Button Button1, Button Button2, Button Button3, Button Button4, Button Button5, Button Button6, Button Button7, Button Button8, Button Button9) {
        Button0.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setPinNumber(getPinNumber()+"0");
                setStars(getStars()+"*");
                InitialDisplay(parentPane);
            }
        });

        Button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setPinNumber(getPinNumber()+"1");
                setStars(getStars()+"*");
                InitialDisplay(parentPane);
            }
        });

        Button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setPinNumber(getPinNumber()+"2");
                setStars(getStars()+"*");
                InitialDisplay(parentPane);
            }
        });

        Button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setPinNumber(getPinNumber()+"3");
                setStars(getStars()+"*");
                InitialDisplay(parentPane);
            }
        });

        Button4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setPinNumber(getPinNumber()+"4");
                setStars(getStars()+"*");
                InitialDisplay(parentPane);
            }
        });

        Button5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setPinNumber(getPinNumber()+"5");
                setStars(getStars()+"*");
                InitialDisplay(parentPane);
            }
        });

        Button6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setPinNumber(getPinNumber()+"6");
                setStars(getStars()+"*");
                InitialDisplay(parentPane);
            }
        });

        Button7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setPinNumber(getPinNumber()+"7");
                setStars(getStars()+"*");
                InitialDisplay(parentPane);
            }
        });

        Button8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setPinNumber(getPinNumber()+"8");
                setStars(getStars()+"*");
                InitialDisplay(parentPane);
            }
        });

        Button9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setPinNumber(getPinNumber()+"9");
                setStars(getStars()+"*");
                InitialDisplay(parentPane);
            }
        });
    }

    @Override
    public void InitialDisplay(BorderPane pane){

        Alert a = new Alert(Alert.AlertType.ERROR);

        if (getPinNumber().length()>4){
            a.setContentText("Invalid pin length");
            a.show();
            setPinNumber("");
            setStars("");
        }

        GridPane display = new GridPane();
        pane.setCenter(display);

        display.setHgap(8);
        display.setVgap(8);
        display.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);

        //label
        Label headText = new Label("Enter the pin number");
        display.add(headText,1,0,4,1);

        Label starText = new Label(getStars());
        display.add(starText,1,2,4,1);

//        Label pinNumber = new Label(getPinNumber());
//        display.add(pinNumber,1,3,4,1



    }

    @Override
    public void BottomControllerKeys(BorderPane parentPane, Button enter, Button cancel, Button clear) {
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                setPinNumber("");
                InitialDisplay(parentPane);
            }
        });

        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setPinNumber("");
                InitialDisplay(parentPane);
            }
        });

        enter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (getPinNumber().length()==4){
//                    ATMCard atmcard = new ATMCard();
                    atmcard.setPinNumber(getPinNumber());


                    String result1 = model.IsPinNumberValid(atmcard);
                    System.out.println(result1);
                    if(result1.equals("Invalid pin Number!")){
                        setPinNumber("");
                        InitialDisplay(parentPane);
                    }else{
                        atmcard.setAccountNumber(model.getAccountNumber(atmcard));
//                        System.out.println(atmcard.getAccountNumber());

//                        disableKeyPad(Button0,  Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8, Button9);
                        menu Menu = new menu(parentPane,atmcard);
                        Menu.InitialDisplay(parentPane);
                        Menu.LeftSidePane(parentPane);
                        Menu.RightSidePane(parentPane);
                        Menu.BottomPane(parentPane);

                    }

                }
            }
        });

    }


}

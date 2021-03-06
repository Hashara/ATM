package Controllers;

import Objects.ATMCard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class pin extends card {

    private BorderPane pane;
    private String pinNumber = "";
    private String stars = "";
    private ATMCard atmcard;
    private String pinErrorText = "";

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

    public String getPinErrorText() {
        return pinErrorText;
    }

    public void setPinErrorText(String pinErrorText) {
        this.pinErrorText = pinErrorText;
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

        if (getPinNumber().length()>4){
            setPinErrorText("Invalid pin length");
            setPinNumber("");
            setStars("");
        }

        GridPane display = new GridPane();
        pane.setCenter(display);

        display.setHgap(8);
        display.setVgap(8);
        display.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);

        display.add(displayLeft,0,0);
        display.add(displayRight,2,0);

        //label
        Label headText = new Label("Enter the pin number");
        headText.setFont(Font.font("Cambria", FontWeight.BOLD, 30));
        display.add(headText,1,0,4,1);

        Label starText = new Label(getStars());
        starText.setFont(Font.font("Cambria", FontWeight.BOLD, 25));
        display.add(starText,1,2,4,1);

        Label errorLabel = new Label(getPinErrorText());
        errorLabel.setFont(Font.font("Cambria", FontWeight.BOLD, 30));
        display.add(errorLabel,1,4,4,1);



    }

    @Override
    public void BottomControllerKeys(BorderPane parentPane, Button enter, Button cancel, Button clear) {
        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                setPinNumber("");
                setStars("");
                InitialDisplay(parentPane);
            }
        });

        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setPinNumber("");
                setStars("");
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
                    setPinErrorText(result1);
                    if(result1.equals("Invalid pin Number!")){
                        setPinNumber("");
                        setStars("");
                        System.out.println("hi from if");
                        InitialDisplay(parentPane);
                    }else{
                        atmcard.setAccountNumber(model.getAccountNumber(atmcard));
//                        System.out.println(atmcard.getAccountNumber());
//
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

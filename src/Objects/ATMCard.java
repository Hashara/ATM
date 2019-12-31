package Objects;

public class ATMCard {

    private String CardNumber;
    private String PinNumber;
    private String AccountNumber;

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }

    public void setPinNumber(String pinNumber) {
        PinNumber = pinNumber;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public String getPinNumber() {
        return PinNumber;
    }
}

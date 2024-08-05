package walletone;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Card extends Account {

    // Constructor to initialize virtual card properties
    public Card(String fullName, String zipCode) {
        super(fullName, zipCode);
    }

    // List any methods specific to virtual cards
    public String generateCardNumber() {
        // random 6-digit CapOne prefix + (6-digit index + first 3 zip) + 1 random digit
        String cardNumber;
        String firstThreeOfZipCode = zipCode.substring(0, 3);
        int randomNumOf10 = (int) (Math.random() * 10);

        cardNumber = randomBinNumber + accountIndex + firstThreeOfZipCode + randomNumOf10;
        return cardNumber;
    }

    // Generate expiration date
    public String generateExpirationDate() {
        LocalDate dateToday = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");

        String expirationDate;
        expirationDate = dateToday.plusYears(2).format(formatter);

        return expirationDate;
    }

    // Generate 3-digit CVV
    public int generateCvv() {
        int cVV;
        cVV = (int) (Math.random() * 1000);
        return cVV;
    }

    public void showCardInfo() {
        super.showCardInfo();
        System.out.println("Card number: " + generateCardNumber());
        System.out.println("Expiration date: " + generateExpirationDate());
        System.out.println("CVV: " + generateCvv());
    }

}

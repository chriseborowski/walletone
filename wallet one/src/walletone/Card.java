package walletone;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Card extends Account {
    private final List<String> cardUsers;
    private final String cardNumber;

    // Constructor to initialize virtual card properties
    public Card(String fullName, String zipCode) {
        super(fullName, zipCode);
        this.cardUsers = new ArrayList<>();
        this.cardNumber = generateCardNumber();
    }

    // Getters and setters
    public String getCardNumber() {
        return cardNumber.replaceAll("\\s|-", "");
    }

    public void addCardUser(String user, String zipCode) {
        cardUsers.add(user);
    }

    public List<String> getCardUsers() {
        return cardUsers;
    }

    @Override
    public String toString() {
        return "Full name: " + fullName + "\nZip code: " + zipCode + "\nCard users: " + cardUsers;
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

    // Show card users
    public void showCardUsers() {
        if (cardUsers.isEmpty()) {
            System.out.println("No card users associated with this card.");
        } else {
            System.out.println("Card users associated with this card:");
            for (String cardUser : cardUsers) {
                System.out.println(cardUser);
            }
        }
    }

    // Show card info method
    public void showCardInfo() {
        super.showCardInfo();
        System.out.println("Card number: " + getCardNumber());
        System.out.println("Expiration date: " + generateExpirationDate());
        System.out.println("CVV: " + generateCvv());
        showCardUsers();
    }

}

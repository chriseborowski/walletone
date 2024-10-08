package walletone;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Card extends Account {
    private final List<String> cardUsers;
    private final String cardNumber;
    private final int cvv;

    // Constructor to initialize virtual card properties
    public Card(String fullName, String zipCode) {
        super(fullName, zipCode);
        this.cardUsers = new ArrayList<>();
        this.cardNumber = generateCardNumber();
        this.cvv = generateCvv();
    }

    public void addCardUser(String user, String zipCode) {
        cardUsers.add(user);
    }

    public boolean removeCardUser(String fullName) {
        for (int i = 0; i < cardUsers.size(); ++i) {
            if (cardUsers.get(i).equals(fullName)) {
                cardUsers.remove(i);
                return true;
            }
        }
        return false;
    }

    // Getters and setters
    public String getCardNumber() {
        return cardNumber.replaceAll("\\s|-", "");
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
        return 100 + (int) (Math.random() * 900);
    }

    // CVV getter
    public int getCvv() {
        return cvv;
    }

    // Show card users
    public void showCardUsers() {
        if (cardUsers.isEmpty()) {
            System.out.println("No card users associated with this card.");
        } else {
            System.out.println("Card users associated with this card: ");
            for (int j = 0; j < cardUsers.size(); ++j) {
                System.out.println((j + 1) + ". " + cardUsers.get(j));
            }
        }
    }

    // Show card info method
    public void showCardInfo() {
        super.showCardInfo();
        System.out.println("Card number: " + getCardNumber());
        System.out.println("Expiration date: " + generateExpirationDate());
        System.out.println("CVV: " + cvv);
        showCardUsers();
    }

}

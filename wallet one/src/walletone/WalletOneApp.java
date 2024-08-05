package walletone;

import java.util.Scanner;

public class WalletOneApp {

    public static void main(String[] args) {

        Card card = new Card("Jane Doe", "22102");
        card.showCardInfo();

        // Read user input, create new cards based on user input
        Scanner scanner = new Scanner(System.in);
        String fullName;
        String zipCode;

        System.out.println("Enter your full name: ");
        fullName = scanner.nextLine();

        System.out.println("Enter your ZIP code: ");
        zipCode = scanner.next();

        Card userCard = new Card(fullName, zipCode);
        userCard.showCardInfo();

        System.out.println("Regenerate your card number? (Y for yes)");
        String userAnswer;
        userAnswer = scanner.next();

        if (userAnswer.equals("Y") | userAnswer.equals("y")) {
            Card newUserCard = new Card(fullName, zipCode);
            newUserCard.showCardInfo();
        }

    }
}

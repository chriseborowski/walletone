package walletone;

import java.util.Scanner;

public class WalletOneApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CardManager cardManager = new CardManager();

//        Card card = new Card("Jane Doe", "22102");
        cardManager.addNewCard("Jane Doe", "22102");

        // Display menu of options
        while (true) {
            System.out.println("Select your option by pressing 1, 2, 3, 4 or 9");
            System.out.println("1. Display Card Details" +
                    "\n2. Display Card Users" +
                    "\n3. Add Another Card" +
                    "\n4. Add Card User" +
                    "\n9. Exit");
            System.out.println("Your selection: ");

            int optionNum = scanner.nextInt();
            System.out.println("You selected " + optionNum);

            switch (optionNum) {
                case 1:
                    System.out.println("Enter the card number to display details (no spaces):");
                    String cardNumber = scanner.nextLine();
                    Card card = cardManager.findCardByNumber();

                    if (card != null) {
                        card.showCardInfo();
                    }
                    else {
                        System.out.println("Card not found.");
                    }
                    break;
                case 2:
                    cardManager.showCardUsers();
                    break;
                case 3:
                    cardManager.generateCardNumber();
                    cardManager.showCardInfo();
                    break;
                case 4:
                    System.out.println("Enter another user's full name: ");
                    Scanner newUserScanner = new Scanner(System.in);
                    String newCardUser = newUserScanner.nextLine();

                    System.out.println("Enter another user's ZIP code: ");
                    Scanner newZipScanner = new Scanner(System.in);
                    String newZipCode = newZipScanner.nextLine();

                    cardManager.addCardUser(newCardUser, newZipCode);

                    System.out.println("Card users associated with this card: " + cardManager.getCardUsers());
                    break;
                case 9:
                    System.out.println("Exiting now. Thank you for using Wallet One.");
                    return;
                default:
                    System.out.println("Invalid option. Please select the correct option.");
            }

        }

    }
}

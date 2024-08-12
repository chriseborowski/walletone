package walletone;

import java.util.Scanner;

public class WalletOneApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CardManager cardManager = new CardManager();

        cardManager.addNewCard("Jane Doe", "22102");

        // Display menu of options
        while (true) {
            System.out.println("Select your option by pressing 1, 2, 3, 4 or 9");
            System.out.println("1. Display Card Details" +
                    "\n2. Display Card Users" +
                    "\n3. Add Another Card" +
                    "\n4. Add Card User" +
                    "\n5. Show All Cards" +
                    "\n9. Exit");
            System.out.println("Your selection: ");

            int optionNum = scanner.nextInt();
            scanner.nextLine(); // Extra scanner line to consume leftover newline
            System.out.println("You selected " + optionNum);

            switch (optionNum) {
                case 1:
                    System.out.println("Enter the card number to display details (no spaces):");
                    String cardNumber = scanner.nextLine();
                    Card card = cardManager.findCardByNumber(cardNumber);

                    if (card != null) {
                        card.showCardInfo();
                    }
                    else {
                        System.out.println("Card not found.");
                    }
                    break;
                case 2:
                    System.out.println("Enter the card number to display all users: ");
                    String cardNumberAllUsers = scanner.nextLine();
                    Card cardNumberUsers = cardManager.findCardByNumber(cardNumberAllUsers);

                    if (cardNumberUsers != null) {
                        cardNumberUsers.showCardUsers();
                    }
                    else {
                        System.out.println("Card not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter the card user's full name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter the card user's ZIP code: ");
                    String zip = scanner.nextLine();
                    Card newCard = cardManager.addNewCard(name, zip);
                    System.out.println("----------");
                    cardManager.showAllCards();
                    break;
                case 4:
                    System.out.println("Enter the card number to add a user: ");
                    String cardNumberForUser = scanner.nextLine();
                    Card cardForUser = cardManager.findCardByNumber(cardNumberForUser);
                    if (cardForUser != null) {
                        System.out.println("Enter another user's full name: ");
                        String newCardUser = scanner.nextLine();
                        System.out.println("Enter another user's ZIP code: ");
                        String newZipCode = scanner.nextLine();

                        cardForUser.addCardUser(newCardUser, newZipCode);
                        System.out.println("Card users associated with this card: " + cardForUser.getCardUsers());
                    }
                    else {
                        System.out.println("Card not found.");
                    }
                    break;
                case 5:
                    cardManager.showAllCards();
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

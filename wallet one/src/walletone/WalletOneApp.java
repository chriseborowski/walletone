package walletone;

import java.util.Scanner;

public class WalletOneApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CardManager cardManager = new CardManager();

        cardManager.addNewCard("Jane Doe", "22102");

        // Display menu of options
        while (true) {
            System.out.println("Select your option by pressing 1, 2, 3, 4, 5 or 9");
            System.out.println("1. Display Card Details" +
                    "\n2. Display Card Users" +
                    "\n3. Add Another Card" +
                    "\n4. Add Card User" +
                    "\n5. Show All Cards" +
                    "\n9. Exit");
            System.out.print("Your selection: ");

            int optionNum = scanner.nextInt();
            scanner.nextLine(); // Extra scanner line to consume leftover newline

            switch (optionNum) {
                case 1:
                    System.out.println("You selected to display card details.");
                    System.out.println("Enter the card number (no spaces):");
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
                    System.out.println("You selected to display all card users.");
                    System.out.println("Enter the card number (no spaces):");
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
                    System.out.println("You selected to add a new card.");
                    System.out.println("Enter the full name of the user associated with this card: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter the user's ZIP code: ");
                    String zip = scanner.nextLine();
                    Card newCard = cardManager.addNewCard(name, zip);
                    System.out.println("----------");
                    newCard.showCardInfo();
                    break;
                case 4:
                    System.out.println("You selected to add a new card user.");
                    System.out.println("Enter the card number to add a user: ");
                    String cardNumberForUser = scanner.nextLine();
                    Card cardForUser = cardManager.findCardByNumber(cardNumberForUser);
                    if (cardForUser != null) {
                        System.out.println("Enter another user's full name: ");
                        String newCardUser = scanner.nextLine();
                        System.out.println("Enter another user's ZIP code: ");
                        String newZipCode = scanner.nextLine();

                        cardForUser.addCardUser(newCardUser, newZipCode);
//                        System.out.println("Card users associated with this card: ");
                        cardForUser.showCardUsers();
                    }
                    else {
                        System.out.println("Card not found.");
                    }
                    break;
                case 5:
                    System.out.println("You selected to display all existing cards.\n");
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

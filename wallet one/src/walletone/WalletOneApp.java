package walletone;

import java.util.List;
import java.util.Scanner;

public class WalletOneApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CardManager cardManager = new CardManager();

        cardManager.addNewCard("Jane Doe", "22102");

        // Display menu of options
        while (true) {
            System.out.println("\nSelect your option or press 0 to exit:");
            System.out.println("1. Display Card Details" +
                    "\n2. Display Card Users" +
                    "\n3. Add Another Card" +
                    "\n4. Add Card User" +
                    "\n5. Show All Cards" +
                    "\n6. Remove Card" +
                    "\n7. Remove Card User" +
                    "\n8. Search Cards By ZIP Code" +
                    "\n9. Search Cards By Name" +
                    "\n0. Exit");
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

                        cardManager.addUserToCard(cardNumberForUser, newCardUser, newZipCode);
                        cardForUser.showCardUsers();
                    }
                    else {
                        System.out.println("Card not found.");
                    }
                    break;
                case 5:
                    System.out.println("You selected to display all existing cards.");
                    cardManager.showAllCards();
                    break;
                case 6:
                    System.out.println("You selected to remove a card.\nEnter the card number to remove (no spaces): ");
                    String cardNumberToRemove = scanner.nextLine();
                    boolean removedCard = cardManager.removeCard(cardNumberToRemove);

                    if (removedCard) {
                        System.out.println("Card successfully removed.");
                    }
                    else {
                        System.out.println("Card not found.");
                    }
                    break;
                case 7:
                    System.out.println("You selected to remove a user.\nEnter the associated card number (no spaces): ");
                    String cardNumberForUserRemoval = scanner.nextLine();
                    Card cardForUserRemoval = cardManager.findCardByNumber(cardNumberForUserRemoval);
                    if (cardForUserRemoval != null) {
                        System.out.println("Enter the full name of the user to remove: ");
                        String userToRemove = scanner.nextLine();
                        boolean removedUser = cardForUserRemoval.removeCardUser(userToRemove);

                        if (removedUser) {
                            System.out.println("User successfully removed.");
                        }
                        else {
                            System.out.println("User not found.");
                        }
                    }
                    break;
                case 8:
                    System.out.println("You selected to search cards by ZIP code.\nEnter the ZIP code you are looking for:");
                    String zipCode = scanner.nextLine();
                    List<User> usersByZip = cardManager.searchByZip(zipCode);

                    if (usersByZip.isEmpty()) {
                        System.out.println("No card users found with ZIP code " + zipCode);
                    }
                    else {
                        System.out.println("Card users found with ZIP code " + zipCode + ":");
                        for (User user : usersByZip) {
                            System.out.println("Name: " + (user != null ? user.getName() : ""));
                        }
                    }
                    break;
                case 9:
                    System.out.println("You selected to search cards by name.\nEnter the full name you are looking for:");
                    String fullName = scanner.nextLine();
                    List<User> usersByName = cardManager.searchByName(fullName);

                    if (usersByName.isEmpty()) {
                        System.out.println("No card users found with name " + fullName);
                    }
                    else {
                        System.out.println("Card users found with name " + fullName + ":");
                        for (User user : usersByName) {
                            for (Card searchCard : cardManager.getCards()) {
                                if (searchCard.getCardUsers().contains(user.getName())) {
                                    System.out.println("Card Number: " + searchCard.getCardNumber());
                                }
                            }
                        }
                    }
                    break;
                case 0:
                    System.out.println("Exiting now. Thank you for using Wallet One.");
                    return;
                default:
                    System.out.println("Invalid option. Please select the correct option.");
            }

        }

    }
}

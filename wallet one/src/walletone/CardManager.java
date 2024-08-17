package walletone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CardManager {
    private final List<Card> cards;
    private final HashMap<String, Card> cardHashMap;
    private final HashMap<String, List<User>> nameHashMap = new HashMap<>();
    private final HashMap<String, List<User>> zipHashMap = new HashMap<>();

    public CardManager() {
        this.cards = new ArrayList<>();
        this.cardHashMap = new HashMap<>();
    }

    public Card addNewCard(String fullName, String zipCode) {
        Card newCard = new Card(fullName, zipCode);
        newCard.generateCardNumber();
        newCard.addCardUser(fullName, zipCode);
        cards.add(newCard);

        cardHashMap.put(newCard.getCardNumber(), newCard);
        User user = new User(fullName, zipCode);
        nameHashMap.computeIfAbsent(fullName, k -> new ArrayList<>()).add(user);
        zipHashMap.computeIfAbsent(zipCode, k -> new ArrayList<>()).add(user);

        System.out.println("Success! New credit card added.\nCard details:\n");
        newCard.showCardInfo();
        return newCard;
    }

    public void addUserToCard(String cardNumber, String fullName, String zipCode) {
        Card card = findCardByNumber(cardNumber);

        if (card != null) {
            card.addCardUser(fullName, zipCode);
            User newUser = new User(fullName, zipCode);
            zipHashMap.computeIfAbsent(zipCode, k -> new ArrayList<>()).add(newUser);
            nameHashMap.computeIfAbsent(fullName, k -> new ArrayList<>()).add(newUser);
            System.out.println("New card user successfully added.");
        }
        else {
            System.out.println("Card not found.");
        }
    }

    public boolean removeCard(String cardNumber) {
        Card cardToRemove = findCardByNumber(cardNumber);
        if (cardToRemove != null) {
            cards.remove(cardToRemove);
            cardHashMap.remove(cardNumber);
            removeUserFromZipHashMap(cardToRemove);
            return true;
        }
        return false;
    }

    private void removeUserFromZipHashMap(Card card) {
        String zipCode = card.getZipCode();
        List<User> users = zipHashMap.get(zipCode);

        if (users != null) {
            users.removeIf(user -> user.getName().equals(card.getFullName()));
            if (users.isEmpty()) {
                zipHashMap.remove(zipCode);
            }
        }
    }

    public void showAllCards() {
        if (cards.isEmpty()) {
            System.out.println("No credit cards to display.");
        }
        else {
            System.out.println("List of current credit cards: \n");

            for (Card card : cards) {
                card.showCardInfo();
            }
        }
    }

    public Card findCardByNumber(String cardNumber) {
        return cardHashMap.get(cardNumber);
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<User> searchByName(String name) {
        return nameHashMap.getOrDefault(name, new ArrayList<>());
    }

    public List<User> searchByZip(String zipCode) {
        return zipHashMap.getOrDefault(zipCode, new ArrayList<>());
    }

}

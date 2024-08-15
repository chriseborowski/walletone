package walletone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CardManager {
    private final List<Card> cards;
    private final HashMap<String, Card> cardHashMap;

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
        System.out.println("Success! New credit card added.\nCard details:\n");
        newCard.showCardInfo();
        return newCard;
    }

    public boolean removeCard(String cardNumber) {
        Card cardToRemove = findCardByNumber(cardNumber);
        if (cardToRemove != null) {
            cards.remove(cardToRemove);
            cardHashMap.remove(cardNumber);
            return true;
        }
        return false;
    }

    public void showAllCards() {
        if (cards.isEmpty()) {
            System.out.println("No credit cards to display.");
        }
        else {
            System.out.println("List of current credit cards: \n");

            for (Card card : cards) {
                card.showCardInfo();
                System.out.println("----------");
            }
        }
    }

    public Card findCardByNumber(String cardNumber) {
        return cardHashMap.get(cardNumber);
    }

    public List<Card> getCards() {
        return cards;
    }
}

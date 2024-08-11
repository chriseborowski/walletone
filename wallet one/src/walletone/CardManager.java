package walletone;

import java.util.ArrayList;
import java.util.List;

public class CardManager {
    private final List<Card> cards;

    public CardManager() {
        this.cards = new ArrayList<>();
    }

    public void addNewCard(String fullName, String zipCode) {
        Card newCard = new Card(fullName, zipCode);
        cards.add(newCard);
        System.out.println("Success! New credit card added.");
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
        for (Card card : cards) {
            if (card.getCardNumber().equals(cardNumber)) {
                return card;
            }
        }
        return null;
    }

    public List<Card> getCards() {
        return cards;
    }
}

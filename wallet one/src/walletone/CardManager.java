package walletone;

import java.util.ArrayList;
import java.util.List;

public class CardManager {
    private final List<Card> cards;
    private String fullName;
    private String zipCode;

    public CardManager() {
        this.cards = new ArrayList<>();
    }

    public void addNewCard() {
        Card newCard = new Card(fullName, zipCode);
        newCard.generateCardNumber();
        cards.add(newCard);
        System.out.println("Success! New credit card added.");
    }

    public void showAllCards() {
        if (cards.isEmpty()) {
            System.out.println("No credit cards to display.");
        }
        else {
            System.out.println("List of current credit cards: ");

            for (Card card : cards) {
                card.showCardInfo();
                System.out.println("----------");
            }
        }
    }
}

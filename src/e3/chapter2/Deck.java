package e3.chapter2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> aCards = new ArrayList<>();

    public Deck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                aCards.add(new Card(rank, suit));
            }
        }
        Collections.shuffle(aCards);
    }

    public void shuffle() {
        aCards.clear();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                aCards.add(new Card(rank, suit));
            }
        }
        Collections.shuffle(aCards);
    }

    public void push(Card pCard) {
        assert pCard != null;
        aCards.add(pCard);
    }

    public Card draw() {
        assert !isEmpty();
        return aCards.removeLast();
    }

    public boolean isEmpty() {
        return aCards.isEmpty();
    }

    public List<Card> cards() {
        return Collections.unmodifiableList(aCards);
    }
}
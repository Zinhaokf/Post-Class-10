package exercise1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import e3.chapter2.Card;
import e3.chapter2.Rank;
import e3.chapter2.Suit;

public class ObservableDeck {

    private final List<Card> aCards = new ArrayList<>();
    private final List<DeckObserver> aObservers = new ArrayList<>();

    public ObservableDeck() {
        shuffle();
    }

    public void addObserver(DeckObserver pObserver) {
        assert pObserver != null;
        aObservers.add(pObserver);
    }

    public void shuffle() {
        aCards.clear();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                aCards.add(new Card(rank, suit));
            }
        }
        Collections.shuffle(aCards);
        for (DeckObserver observer : aObservers) {
            observer.shuffled();
        }
    }

    public void push(Card pCard) {
        assert pCard != null;
        aCards.add(pCard);
        for (DeckObserver observer : aObservers) {
            observer.cardPushed(pCard);
        }
    }

    public Card draw() {
        assert !isEmpty();
        Card card = aCards.remove(aCards.size() - 1);
        for (DeckObserver observer : aObservers) {
            observer.cardDrawn(card);
        }
        return card;
    }

    public boolean isEmpty() {
        return aCards.isEmpty();
    }
}
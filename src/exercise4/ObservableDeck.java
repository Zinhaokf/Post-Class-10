package exercise4;

import java.util.ArrayList;
import java.util.List;

import e3.chapter2.Card;
import e3.chapter2.Deck;

public class ObservableDeck extends Deck {

    private final List<exercise1.DeckObserver> aObservers = new ArrayList<>();

    public void addObserver(exercise1.DeckObserver pObserver) {
        assert pObserver != null;
        aObservers.add(pObserver);
    }

    @Override
    public void shuffle() {
        super.shuffle();
        for (exercise1.DeckObserver observer : aObservers) {
            observer.shuffled();
        }
    }

    @Override
    public Card draw() {
        Card card = super.draw();
        for (exercise1.DeckObserver observer : aObservers) {
            observer.cardDrawn(card);
        }
        return card;
    }
}
package exercise1;

import e3.chapter2.Card;

public interface DeckObserver {
    void shuffled();
    void cardDrawn(Card pCard);
    void cardPushed(Card pCard);
}
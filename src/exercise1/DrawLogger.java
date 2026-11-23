package exercise1;

import e3.chapter2.Card;

public class DrawLogger implements DeckObserver {

    @Override
    public void shuffled() {}

    @Override
    public void cardDrawn(Card pCard) {
        IO.println(pCard + " drawn");
    }

    @Override
    public void cardPushed(Card pCard) {}
}
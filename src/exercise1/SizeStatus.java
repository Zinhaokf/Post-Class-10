package exercise1;

import e3.chapter2.Card;

public class SizeStatus implements DeckObserver {

    private int aSize = -1;

    @Override
    public void shuffled() {
        aSize = 52;
        printSize();
    }

    @Override
    public void cardDrawn(Card pCard) {
        if (aSize >= 0) {
            aSize--;
        }
        printSize();
    }

    @Override
    public void cardPushed(Card pCard) {
        if (aSize >= 0) {
            aSize++;
        }
        printSize();
    }

    private void printSize() {
        if (aSize >= 0) {
            IO.println("Size: " + aSize);
        } else {
            IO.println("Size unknown");
        }
    }
}
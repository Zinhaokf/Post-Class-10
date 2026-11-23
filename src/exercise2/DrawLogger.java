package exercise2;

public class DrawLogger implements DeckObserver {

    @Override
    public void shuffled(DeckView pDeckView) {}

    @Override
    public void cardDrawn(DeckView pDeckView) {
        IO.println(pDeckView.getLastDrawn() + " drawn");
    }

    @Override
    public void cardPushed(DeckView pDeckView) {}
}
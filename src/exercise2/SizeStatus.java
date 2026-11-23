package exercise2;

public class SizeStatus implements DeckObserver {

    @Override
    public void shuffled(DeckView pDeckView) {
        IO.println(pDeckView.size());
    }

    @Override
    public void cardDrawn(DeckView pDeckView) {
        IO.println(pDeckView.size());
    }

    @Override
    public void cardPushed(DeckView pDeckView) {
        IO.println(pDeckView.size());
    }
}
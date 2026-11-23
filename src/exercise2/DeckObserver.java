package exercise2;

public interface DeckObserver {

    void shuffled(DeckView pDeckView);

    void cardDrawn(DeckView pDeckView);

    void cardPushed(DeckView pDeckView);
}
package exercise2;

import java.util.List;

import e3.chapter2.Card;

public interface DeckView {

    List<Card> getCards();

    boolean isEmpty();

    Card getLastDrawn();

    default int size() {
        return getCards().size();
    }
}
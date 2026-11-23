package exercise3;

import java.util.Optional;

import e3.chapter2.Card;

public class DeckChangeEvent {

    private final DeckChangeType aChangeType;
    private final Optional<Card> aCard;

    public DeckChangeEvent(DeckChangeType pType) {
        aChangeType = pType;
        aCard = Optional.empty();
    }

    public DeckChangeEvent(DeckChangeType pType, Card pCard) {
        aChangeType = pType;
        aCard = Optional.of(pCard);
    }

    public DeckChangeType getChangeType() {
        return aChangeType;
    }

    public Optional<Card> getCard() {
        return aCard;
    }
}
package exercise3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;

import e3.chapter2.Card;
import e3.chapter2.Rank;
import e3.chapter2.Suit;

@SuppressWarnings("deprecation")
public class ObservableDeck extends Observable {

    private final List<Card> aCards = new ArrayList<>();

    public ObservableDeck() {
        shuffle();
    }

    public void shuffle() {
        aCards.clear();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                aCards.add(new Card(rank, suit));
            }
        }
        Collections.shuffle(aCards);
        setChanged();
        notifyObservers(DeckChangeType.SHUFFLED);
    }

    public void push(Card pCard) {
        assert pCard != null;
        aCards.add(pCard);
        setChanged();
        notifyObservers(new DeckChangeEvent(DeckChangeType.CARD_PUSHED, pCard));
    }

    public Card draw() {
        assert !isEmpty();
        Card card = aCards.remove(aCards.size() - 1);
        setChanged();
        notifyObservers(new DeckChangeEvent(DeckChangeType.CARD_DRAWN, card));
        return card;
    }

    public boolean isEmpty() {
        return aCards.isEmpty();
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(aCards);
    }
}
package exercise2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import e3.chapter2.Card;
import e3.chapter2.Rank;
import e3.chapter2.Suit;

public class ObservableDeck implements DeckView {

    private final List<Card> aCards = new ArrayList<>();
    private final List<DeckObserver> aObservers = new ArrayList<>();
    private Optional<Card> aLastDrawn = Optional.empty();

    public ObservableDeck() {
        shuffle();
    }

    public void addObserver(DeckObserver pObserver) {
        assert pObserver != null;
        aObservers.add(pObserver);
    }

    public void shuffle() {
        aCards.clear();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                aCards.add(new Card(rank, suit));
            }
        }
        Collections.shuffle(aCards);
        for (DeckObserver observer : aObservers) {
            observer.shuffled(this);
        }
    }

    public void push(Card pCard) {
        assert pCard != null;
        aCards.add(pCard);
        for (DeckObserver observer : aObservers) {
            observer.cardPushed(this);
        }
    }

    public Card draw() {
        assert !isEmpty();
        Card card = aCards.remove(aCards.size() - 1);
        aLastDrawn = Optional.of(card);
        for (DeckObserver observer : aObservers) {
            observer.cardDrawn(this);
        }
        return card;
    }

    @Override
    public boolean isEmpty() {
        return aCards.isEmpty();
    }

    @Override
    public List<Card> getCards() {
        return Collections.unmodifiableList(aCards);
    }

    @Override
    public Card getLastDrawn() {
        return aLastDrawn.get();
    }
}
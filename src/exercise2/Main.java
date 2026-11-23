package exercise2;

import e3.chapter2.Card;
import e3.chapter2.Rank;
import e3.chapter2.Suit;

public class Main {

    public static void main(String[] args) {
        ObservableDeck deck = new ObservableDeck();
        deck.addObserver(new DrawLogger());
        deck.addObserver(new SizeStatus());

        deck.shuffle();
        deck.draw();
        deck.draw();
        deck.push(new Card(Rank.ACE, Suit.SPADES));
    }
}
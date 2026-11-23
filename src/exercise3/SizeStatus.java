package exercise3;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class SizeStatus implements Observer {

    @Override
    public void update(Observable pDeck, Object pEvent) {
        IO.println(((ObservableDeck) pDeck).getCards().size());
    }
}
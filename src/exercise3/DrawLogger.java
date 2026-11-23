package exercise3;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class DrawLogger implements Observer {

    @Override
    public void update(Observable pDeck, Object pEvent) {
        if (pEvent instanceof DeckChangeEvent event
                && event.getChangeType() == DeckChangeType.CARD_DRAWN) {
            IO.println(event.getCard().get() + " drawn");
        }
    }
}
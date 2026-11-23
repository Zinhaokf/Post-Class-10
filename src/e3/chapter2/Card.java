package e3.chapter2;

public class Card {

    private Rank aRank;
    private Suit aSuit;

    public Card(Rank pRank, Suit pSuit) {
        assert pRank != null && pSuit != null;
        aRank = pRank;
        aSuit = pSuit;
    }

    public Rank rank() {
        return aRank;
    }

    public Suit suit() {
        return aSuit;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", aRank, aSuit);
    }
}
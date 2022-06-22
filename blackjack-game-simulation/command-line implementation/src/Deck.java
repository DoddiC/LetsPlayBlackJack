
import java.util.*;

public class Deck extends Card {

    private Card[] myCards;
    private int numCards = 52;
    List<String> suits = Arrays.asList("Clubs", "Diamonds", "Spades","Hearts");
    Iterator<String> itr = suits.iterator();

    /**
     * Default constructor to create a deck and fill it with cards.
     */

    public Deck(){

        super();

        this.myCards = new Card[this.numCards];
        int card_index = 0;

        while(itr.hasNext()){
            String element = (String) itr.next();
            for (int n = 1; n <= 13; n++) {

                this.myCards[card_index] = new Card(element, n);
                card_index++;

            }
        }
            this.shuffle();
    }

    /**
     * randomizes the cards in the deck defined in the default constructor
     */

    public void shuffle(){

        Random rand = new Random();
        Card temp;

        int  x;
        for(int i = 0; i < this.numCards; i++){
            x = rand.nextInt(this.numCards);

            temp = this.myCards[i];

            this.myCards[i] = this.myCards[x];
            this.myCards[x] = temp;

        }
    }

    /**
     * Gives the user a card
     * @return - the next card in the deck
     */

    public Card deal(){

        Card top = this.myCards[0];
        for(int i = 1; i < this.numCards; i++){
            this.myCards[i-1] = this.myCards[i];
        }
        this.myCards[this.numCards-1] = null;

        this.numCards--;

        return top;
    }

}

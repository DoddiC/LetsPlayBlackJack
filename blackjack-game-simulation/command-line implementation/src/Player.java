
public class Player {

    private String name;

    private Card hand[] = new Card[10];

    private int numCards;

    /**
     * Default constructor
     *
     */

    public Player(){

        this.name = "Your";
        this.emptyHand();

    }

    /**
     * A constructor that also takes in a user's name
     * @param name1 - name of the player
     */

    public Player(String name1){

        this.name = name1;
        this.emptyHand();

    }

    /**
     * Resets a player's hand to blank cards
     */

    public void emptyHand(){

        for(int i = 0; i < 10; i++){
            this.hand[i] = null;
        }
        this.numCards = 0;

    }

    /**
     * Adds card to the hand of the player
     * @param newCard - the card that is going to be added to the player's hand
     * @return - true or false depending on if adding the card makes the user's total go over 21.
     */
    public boolean addCard(Card newCard){
        if(this.numCards == 10){
            System.err.printf("%s's hand already has the 10 cards\n", this.name);
            System.exit(1);
        }

        this.hand[this.numCards] = newCard;
        this.numCards++;

        return(this.getHandSum() <= 21);
    }

    /**
     * calculates the sum of the cards in the user's hand
     * @return - the sum of the cards in the user's hand
     */

    public int getHandSum(){

        int handSum = 0;
        int cardNum;

        for(int i = 0; i < this.numCards ; i++) {

            cardNum = this.hand[i].getNumber();

            if (cardNum > 10) {
                handSum += 10;
            } else {
                handSum += cardNum;
            }
        }

        return handSum;
    }

    /**
     * prints the user's hand
     * @param showFirstHand - if the cards should be printed or if hidden should be printed.
     */

    public void printHand(boolean showFirstHand) {

        System.out.printf("%s cards: \n", this.name);
        for (int i = 0; i < this.numCards; i++) {

            if (!showFirstHand) {

                System.out.println("[hidden]");

            } else {

                System.out.printf(" %s\n", this.hand[i].toString());

            }
        }
    }

}

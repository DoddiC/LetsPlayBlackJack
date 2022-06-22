
public class Card {

    private String mySuit;
    private int myNumber;

    /**
     * Default constructor that defines an empty card with zero value.
     */

    public Card(){

        this.mySuit = " ";
        this.myNumber = 0;

    }

    /**
     * Secondary Constructor that defines a card with given suit and number
     * @param aSuit - a string of the type of suit
     * @param aNumber - a number between 1 and 13
     */

    public Card(String aSuit, int aNumber){

        this.mySuit = aSuit;

        if(aNumber >= 1 && aNumber <=13) {

            this.myNumber = aNumber;

        } else {

            System.err.println(aNumber + " is not a valid Card number");
            System.exit(1);

        }
    }

    /**
     * Returns the number of the card
     * @return - the number of the card
     */

    public int getNumber(){

        return myNumber;
    }

    /**
     * Creates a correctly formatted string of the card type. 
     * @return - the card with name and suit formatted correctly
     */

    public String toString(){

        String finalstr = "Error";

        switch(this.myNumber) {
            case 2:
                finalstr = "Two";
                break;
            case 3:
                finalstr = "Three";
                break;
            case 4:
                finalstr = "Four";
                break;
            case 5:
                finalstr = "Five";
                break;
            case 6:
                finalstr = "Six";
                break;
            case 7:
                finalstr = "Seven";
                break;
            case 8:
                finalstr = "Eight";
                break;
            case 9:
                finalstr = "Nine";
                break;
            case 10:
                finalstr = "Ten";
                break;
            case 11:
                finalstr = "Jack";
                break;
            case 12:
                finalstr = "Queen";
                break;
            case 13:
                finalstr = "King";
                break;
            case 1:
                finalstr = "Ace";
                break;
        }
        return finalstr + " of " + mySuit.toString();
    }
}


import java.util.*;
public abstract class Blackjack {

    /**
     * Plays the whole game using the methods and classes created before this.
     * @param args
     */

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //initial variable declaration
        int cash_total = 10000;
        int option = 3;
        System.out.println("Welcome to blackjack, you currently have " + "$" + cash_total + "\n");

        while (option != 0 && cash_total > 0) {

            Deck gameDeck = new Deck();

            System.out.println("How much do you want to bet?");
            long bet_amount = scan.nextInt();

            while (bet_amount > cash_total || bet_amount < 0){
                System.out.println("You can't bet that please enter a bet less than " + cash_total);
                bet_amount = scan.nextInt();
            }

            Player player = new Player();
            Player cpu = new Player("cpu");

            player.addCard(gameDeck.deal());
            cpu.addCard(gameDeck.deal());

            player.addCard(gameDeck.deal());
            cpu.addCard(gameDeck.deal());

            System.out.println("The cards have been dealt:");
            player.printHand(true);
            cpu.printHand(false);
            System.out.println("\n");

            boolean isPlayerDone = false;
            boolean isCpuDone = false;
            String doubleDown;
            String ans;

            while (!isPlayerDone || !isCpuDone) {

                if (!isPlayerDone) {

                    System.out.println("Hit or Stay (Hit gives you another card and stay does nothing): Enter H or S");
                    ans = scan.next();
                    while (ans.compareToIgnoreCase("H") != 0 && ans.compareToIgnoreCase("S") != 0){
                        System.out.println("Not a valid option. Please enter H or S");
                        ans = scan.next();
                    }
                    if (ans.compareToIgnoreCase("H") == 0) {
                        isPlayerDone = !player.addCard(gameDeck.deal());
                        System.out.println("\n");
                        player.printHand(true);
                    } else {
                        isPlayerDone = true;
                        System.out.println("Would you like to double your bet? Enter Y or N");
                        doubleDown = scan.next();
                        if(doubleDown.compareToIgnoreCase("Y") == 0) {
                            bet_amount*=2;
                        }
                    }

                }

                if (!isCpuDone) {

                    if (cpu.getHandSum() < 17) {
                        System.out.println("I will hit\n");
                        isPlayerDone = !cpu.addCard(gameDeck.deal());
                        cpu.printHand(false);
                    } else {
                        System.out.println("I will stay.");
                        isCpuDone = true;
                    }

                }

                System.out.println();

            }

            System.out.println("Here are the final cards:\n");
            player.printHand(true);
            System.out.println("Final Score: " + player.getHandSum()+"\n");
            cpu.printHand(true);
            System.out.println("Final Socre: " + cpu.getHandSum()+"\n");

            if ((player.getHandSum() > cpu.getHandSum() && player.getHandSum() <= 21) || (cpu.getHandSum() > 21 && player.getHandSum() <= 21) ) {
                System.out.println("You win!");
                cash_total += bet_amount;
            } else if (player.getHandSum() == cpu.getHandSum()) {

            } else {
                System.out.println("Sorry you lose.");
                cash_total -= bet_amount;
            }

            if(cash_total <= 0){
                System.out.println("You're out of money, you can't play anymore.");
                option = 0;
                break;
            }

            System.out.println("Your total cash is: " + cash_total + "\nEnter a number other than 0 if you want to play again.");
            try{
                option = scan.nextInt();
            } catch (InputMismatchException e){
                System.err.println("InputMismatchException: " + e.getMessage());
            }
            
            scan.close();

        }

    }

}

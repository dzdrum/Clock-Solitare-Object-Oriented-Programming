import java.util.Random;
/**
 * This class is used to create an array of 52 card objects. This will effectively represent a 
 * deck of cards. This deck of cards will have methods to shuffle and mix up the cards so that 
 * the game can be played correctly. 
 * 
 * @author Dylan Drum
 * @Version v1, 4/2/17
 */
public class Deck {

    private int index = 0;//this is used to keep track of what location you are at in the deck

    Card [] deck = new Card[52];//create an empty deck of null card objects

    /**
     * This default constructor will initialize the array of 52 null card objects. This will
     * run through all locations and fill them with cards with fields. 
     */
    public Deck (){

        String[] suitName = {"Hearts", "Diomonds", "Spades", "Clubs"};
        String[] cardValue = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        int x = 0;
        for ( int i = 0; i < suitName.length; i++ ){
            for ( int j = 0; j < cardValue.length; j++ ){

                deck[x] = new Card (suitName[i],cardValue[j]);
                x++;

            }
        }   
    }

    /**
     * This method shuffle will be used to take the deck of cards and randomly 
     * move around the cards so that it is shuffled for the game
     */
    public void shuffle()
    {
        Random rnd = new Random();
        for(int i=0; i<1000; i++)
        {
            int swap1=rnd.nextInt(52);
            int swap2=rnd.nextInt(52);
            Card temp=deck[swap1];
            deck[swap1]=deck[swap2];
            deck[swap2]=temp;
        }
    }

    /**
     * The dealCard method is used to take a card in the deck at a certain index
     * and return that card and then increase the index for the next time it is called. 
     * This method will be used to fill the board of cards in future classes
     * @return Card - This will return a card from the deck 
     */
    public Card dealCard () {
        return deck[this.index++];
    }

    /**
     * This method is used to tell the number of cards that have not yet been dealt out of the deck yet
     * @return int - The integer value of the number of cards left to still be dealt
     */
    public int cardsLeft () {
        return 52 - this.index;
    }

    /**
     * This method is used to return a textual representation of the fields of this class
     * @return String - This string will return the textual representation of all the cards that 
     * make up a full deck of 52 cards. 
     */
    public String toString () {

        for ( int i = 0; i < deck.length; i++ ){

            System.out.print(""+deck[i].toString()+" ");

        }
        System.out.println("\n");
        return "";
    }
}


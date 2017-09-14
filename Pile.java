
/**
 * The Pile class is used to create a group of 4 cards. This will be used in the clocksolitaire
 * class so that the game board can be created.
 * 
 * @author Dylan Drum
 * @version v1, 2/4/17
 */
public class Pile {
    Card [] p1 = new Card [4];//create a pile of 4 null cards
    
    /**
     * This default contructor will be used in the game class to initially set
     * the 4 cards in a pile to their default values. 
     */
    public Pile ()
    {

    }
    
    /**
     * This loaded constructor takes in an array of cards and takes a for loop 
     * through the array and makes each index of this objects array of careds equal to the parameters
     * @param Card[] card - This is an array of cards that is used to copy each card object to 
     * an index of this objects pile field
     */
    public Pile ( Card [] card )
    {
        for( int i = 0; i < this.p1.length; i++ ){
            
            p1[i] = card[i];
            
        }
    }

    /**
     * This method is used to take in a card and an index as parameters and
     * add that card parameter to the index specified in this objects
     * pile field face down
     * @param Card card - This is a card object that will be used to fill the spot
     * in an index of this objects pile field
     * @param int index - This is an integer value that will be used to  designate the 
     * index of this objects pile class that the card parameter will be going in
     */
    public void addCardFaceDown( Card card, int index )
    {
        
        if( index == 4 ){
            
        }
        else{
            this.p1[index] = card;  
        }
              
        //set faceup == false
    }
    
    /**
     * This method is used to take in a card and an index as parameters and
     * add that card parameter to the index specified in this objects
     * pile field face down
     * @param Card card - This is a card object that will be used to fill the spot
     * in an index of this objects pile field
     * @param int index - This is an integer value that will be used to  designate the 
     * index of this objects pile class that the card parameter will be going in
     */
    public void addCardFaceUp( Card card, int index )
    {
        
        if( index == 4 ){
            
        }
        else{
            this.p1[index] = card;  
        }
              
        
    }
    
    /**
     * This method will be used to essentially copy the card that is at 
     * a specified index of this objects pile class. This method will be used so that you can
     * copy what card is there and replace it or 'remove' it 
     * @param int index - This is to represent the spot in this objects pile field that 
     * is being replaced
     * @return card - This will return a card object that is located at the index specified
     * by the parameter value
     */
    public Card removeCard ( int index ) 
    {
        
        Card returnCard = new Card();
        
        if( index == 4 ){
            
        }
        else{
            
            p1[index].setFaceDown(false);
            returnCard = p1[index];
            p1[index] = null;
        }
        return returnCard;
    }

    public Card getCard(int index)
    {
        Card returnCard = new Card();
        
        if( index == 4 ){
            
        }
        else{
            
            p1[index].setFaceDown(false);
            returnCard = p1[index];
        }
        return returnCard;
    }
    
    /**
     * This method will return the number of cards that are still face up
     * @return int - the integer value that represents the number of cards face up
     */
    public int getNumberOfFaceUp()
    {
        int count = 0;
        for( int i = 0; i < p1.length; i++ ){
            
            if( p1[i].isFaceDown() == false ){
                
                count++;
            }
        }
        return count;
    }
    
    /**
     * This method will return the number of cards that are still face down
     * @return int - the integer value that represents the number of cards face down
     */
    public int getNumberOfFaceDown()
    {
        int count = 0;
        for( int i = 0; i < p1.length; i++ ){
            
            if( p1[i].isFaceDown() == true ){
                
                count++;
            }
        }
        return count;
    }
    
    /**
     * This method is used for printing out the cards in the pile
     */
    public void printPile()
    {
        for ( int i = 0; i < p1.length; i++ ){
            
            System.out.println(""+p1[i].toString());
            
        }
    }
    
    /**
     * This method prints a textual representation of the class
     * @return string - This is a string that has all the 
     * values of the classes private variables to show
     * its current state
     */
    public String toString()
    {
        
        System.out.println("Face Down:");
        for ( int i = 0; i < p1.length; i++ ){
            
            if( p1[i].isFaceDown() == true ){
                
                System.out.println(""+p1[i].toString());
            }
        }
        
        System.out.println("Face UP:");
        for ( int i = 0; i < p1.length; i++ ){
            
            if( p1[i].isFaceDown() == false ){
                
                System.out.println(""+p1[i].toString());
            }
        }
        
        return "";
    }

}

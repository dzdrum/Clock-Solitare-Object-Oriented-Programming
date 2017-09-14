/**
 * This card class is used to create a card object. This class will be used to create a deck of 52 cards
 * and also a pile which is a group of 4 cards. 
 * @author Dylan Drum
 * @version v1, 4/2/17
 */
public class Card {

    private String SuitName;//string representation for the name of the suit
    private String CardValue;//String representation for the value of the card
    private boolean faceDown;//boolean value to represent if the card is face up or down

    
    /**
     * This default constructor will be used to set all String values to their default
     * values. This constructor is used in the clocksolitaire class when creating
     * a blank card that will be used as a temperary variable.
     */
    public Card (){

    }

    /**
     * This is a copy constructor that takes in a card as a parameter
     * and will copy all of its private fields to this objects private fields
     * @param Card card - This is an object of type card that will be used to copy its fields to this object
     */
    public Card ( Card card ){

        this.CardValue = card.getValue();
        this.SuitName = card.getSuit();
        this.faceDown = true;

    }

    /**
     * This is a loaded constuctor that will allow two string values to come in as parameters that will be used to 
     * set equal to this objects private fields
     * @param String SuitName - This is a string that will be used to set the Suit field of this object
     * @param String CardValue - This is a string that will be used to set the Card value field
     */
    public Card(String SuitName, String CardValue) {

        this.SuitName = SuitName;
        this.CardValue = CardValue;
        this.faceDown = true;
    }

    /**
     * This getValue method will be used to return the CardValue field of this object
     * @return String - This will return the String value of the CardValue field
     */
    public String getValue() {
        return CardValue;
    }

    /**
     * This getSuit method will be used to return the SuitName field of this object
     * @return String - This is the String value of the SuitName field of the object
     */
    public String getSuit() {
        return SuitName;
    }

    /**
     * This setCardValue method will be used to take in an entered value and then set the CardValue field to the entered value
     * @param String CardValue - This is a string that will be used to set the CardValue field of this object equal to the string
     */
    public void setCardValue(String CardValue) {
        this.CardValue = CardValue;
    }

    /**
     * This method will take in a String as a parameter and set this objects SuitName field equal to that string
     * @param String SuitName - This String parameter will be used to set the Suit name of this objects field to the string
     */
    public void setSuitName(String SuitName) {
        this.SuitName = SuitName;
    }

    /**
     * This method will take in a boolean parameter and set this objects faceDown field to the boolean value
     * @param boolean faceDown - This boolean parameter will be used to set this objects faceDown 
     * field equal to the boolean value
     */
    public void setFaceDown( boolean faceDown) {
        this.faceDown = faceDown;
    }

    /**
     * This method is used to tell whether or not a card is faceDown or not
     * @return boolean - This will return true if the card is face down and
     * false if the card is actually face up
     */
    public boolean isFaceDown() {
        return faceDown;
    }


    /**
     * This method is used to show a textual representation of the class
     * @return String - This string will return the textual representation of 
     * the fields of this class. It will make the card look compact like 
     * for example AH, 2D
     */
    public String toString() {

        return ""+this.CardValue.charAt(0)+""+this.SuitName.charAt(0);
    }

    
}

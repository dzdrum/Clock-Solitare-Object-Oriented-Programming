
import java.util.*;
import java.text.*;
/**
 * create thirteen Piles of cards
 * create and shuffle a Deck of Cards
 * deal out the deck to populate (initialize) the thirteen Piles with four face-down cards each
 * remove (top, face-down) card from Pile 13, the Kings Pile
 * add it, face-up, to the (“bottom” of the) correct Pile
 * remove (top, face-down) card from that same Pile
 * once the game is over print out the final score
 * and percentages of each pile out of the total number of games
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClockSolitaire
{
    public static void main(String[] args) {
        int firstArg=0;//keeps track of the first user input
        String mode="";//makes a string variable for the mode of the game
        int numGames=0;//keeps track of the number of games

        //if they only type in verbose
        if(args.length==1 && args[0]=="verbose")
        {
            firstArg=1;
            mode="verbose";
        }
        
        //if they only type in normal
        if(args.length==1 && args[0]=="normal")
        {
            firstArg=1;
            mode="normal";
        }
        
        //if they only typ ein silent
        if(args.length==1 && args[0]=="silent")
        {
            firstArg=1;
            mode="silent";
        }
        
        //if the user enters two thing into the console then the first is the game mode and the second is the number of games
        if(args.length==2)
        {
            mode=args[0];
            firstArg=Integer.parseInt(args[1]);
        }

        //if the mode is not silent and not verbose then it is default 
        if(!mode.equals("silent") && !mode.equals("verbose"))
        {
            mode="normal";
        }

        //if the user enters nothing then it will be one game in default mode
        if(firstArg == 0)
        {
            firstArg=1;
            mode="normal";
        }

        numGames= firstArg;
        System.out.println("You want to play " + numGames + " games in " + mode + " mode");

        int totalScore;//this will be used to keep track of the overall score of one game
        int[] scoresArray= new int[numGames];//an array of the number of time each score happens in the total number of games played
        double[] percentage= new double[13];//used to make the percentages of times each score happens in the total number of games
        DecimalFormat df = new DecimalFormat("##.##");//this is used to format the percentage numbers
        int stepCounter;//this is to keep track of how many turns of turning over cards you have done

        //for loop to play the number of games that the user chooses
        for(int w=1;w<=numGames;w++){
            stepCounter=0;
            totalScore=13;
            System.out.println("The game " + w + " is played\n");

            String[] cardValue = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
            Pile[] board = new Pile[13];//new board
            Deck D1 = new Deck();//new deck of cards
            Card cards;//
            int[] score = new int[13];//array of scores for each pile
            Card ancard ;
            Pile pile= new Pile();

            if(mode.equals("verbose") || mode.equals("normal"))
            {
                System.out.println("Deck (Un-shuffeled:)");
                D1.toString();//print out the unshuffled deck

                System.out.println("\nshuffled");
                D1.shuffle();
                D1.toString();//print out the shuffled deck
            }
            else
            {
                D1.shuffle();
            }

            Card [] card = new Card[4];
            int position = 1;//used for labeling the piles/clock times

            //for loop that intializes the whole board
            for ( int i = 0; i < 13; i++ )
            {
                for( int j = 0; j < 4; j++ )
                {
                    card[j] =  D1.dealCard() ;
                }
                board[i] = new Pile( card );

            }

            //print out the whole board
            if(mode.equals("verbose"))
            {
                System.out.println("The 13 piles before the game as been played");
                for ( int i = 0; i < 13; i++ ){
                    System.out.println(""+position+"oClock");
                    for( int j = 0; j < 4; j++ ){

                        System.out.print(board[i].p1[j].toString());
                        System.out.print("\t");
                    }
                    System.out.println("\n");

                    position++;
                }
            }
            System.out.println("The score of the board before the game is: " + totalScore);

            int loopControl = 0;
            int [] currentIndex = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };//used to see how many face up cards are in the pile
            Card tempCard1 = new Card ();//variable used for copying to move cards from pile to pile once turned face up
            Card temp; //variable used for copying to move cards from pile to pile once turned face up
            char [] checkCardValue = new char [] {'2', '3', '4', '5','6', '7', '8', '9','1'};//this is used when checking cards other than ace, jack, king, queen
            Card tempCopy = new Card();//this is used to make sure the first card in the king pile does not remain null throughout the game
            do {
                tempCard1 = board[12].removeCard(currentIndex[12]);//checking the first card in the 13th pile
                tempCopy=tempCard1;
                board[12].p1[currentIndex[12]]=tempCopy;
                while( tempCard1.getValue().charAt(0) != 'K' )//while the card that is turned over isnt a king then search which card it is
                {
                    //if the card is a queen and there are less than 4 face up cards in the queen pile
                    if( tempCard1.getValue().charAt(0) == 'Q' &&  currentIndex[11] < 4 )
                    {

                        temp = board[11].removeCard(currentIndex[11]);//setting temp equal to the card at the top of the queen pile
                        board[11].addCardFaceUp(tempCard1, currentIndex[11]);//adds the queen card to the queen pile
                        currentIndex[11]++;//increase the count of queen cards face up in the queen pile
                        tempCard1 = temp;//tempCard now equals the card at the top of the queen pile
                        stepCounter++; //increase the number of moves taken
                        if(mode.equals("verbose"))
                        {
                            System.out.println("MOVE #" + stepCounter);//print out the current move they are one
                            System.out.println("\n");
                            //print out the board
                            if(mode.equals("verbose"))
                            {
                                position=1;
                                for ( int i = 0; i < 13; i++ ){
                                    System.out.println(""+position+"oClock");
                                    for( int j = 0; j < 4; j++ ){

                                        System.out.print(board[i].p1[j].toString());
                                        System.out.print("\t");
                                    }
                                    System.out.println("\n");

                                    position++;
                                }
                            }
                        }
                    }
                    //if the card is a jack and there are less than 4 face up cards in the jack pile
                    else if ( tempCard1.getValue().charAt(0) == 'J' && currentIndex[10] < 4 ) 
                    {
                        temp = board[10].removeCard(currentIndex[10]); //setting temp equal to the card at the top of the jack pile
                        board[10].addCardFaceUp(tempCard1, currentIndex[10]); //adds the jack card to the jack pile
                        currentIndex[10]++; //increase the count of jack cards face up in the jack pile
                        tempCard1 = temp;//tempCard now equals the card at the top of the jack pile
                        stepCounter++; //increase the number of moves taken
                        if(mode.equals("verbose"))
                        {
                            System.out.println("MOVE #" + stepCounter);//print out the current move they are one
                            System.out.println("\n");
                            //print out the board
                            if(mode.equals("verbose"))
                            {
                                position=1;
                                for ( int i = 0; i < 13; i++ ){
                                    System.out.println(""+position+"oClock");
                                    for( int j = 0; j < 4; j++ ){

                                        System.out.print(board[i].p1[j].toString());
                                        System.out.print("\t");
                                    }
                                    System.out.println("\n");

                                    position++;
                                }
                            }
                        }
                    }
                    //if the card is an Ace and there are less than 4 face up cards in the Ace pile
                    else if( tempCard1.getValue().charAt(0) == 'A' && currentIndex[0] < 4 ) 
                    {

                        temp = board[0].removeCard(currentIndex[0]); //setting temp equal to the card at the top of the ace pile
                        board[0].addCardFaceUp(tempCard1, currentIndex[0]); //adds the Ace card to the Ace pile
                        currentIndex[0]++; //increase the count of ace cards face up in the ace pile
                        tempCard1 = temp; //tempCard now equals the card at the top of the ace pile
                        stepCounter++; //increase the number of moves taken
                        if(mode.equals("verbose"))
                        {
                            System.out.println("MOVE #" + stepCounter);//print out the current move they are one
                            System.out.println("\n");
                            //print out the board
                            if(mode.equals("verbose"))
                            {
                                position=1;
                                for ( int i = 0; i < 13; i++ ){
                                    System.out.println(""+position+"oClock");
                                    for( int j = 0; j < 4; j++ ){

                                        System.out.print(board[i].p1[j].toString());
                                        System.out.print("\t");
                                    }
                                    System.out.println("\n");

                                    position++;
                                }
                            }
                        }
                    }
                    //if the card is not an ace, queen, jack, or king
                    else 
                    {
                        //for loop that checks each card based off the checkCardValue array to see which pile is should go into
                        for( int k = 0; k < checkCardValue.length; k++ )
                        {
                            if( tempCard1.getValue().charAt(0) == checkCardValue[k] && currentIndex[k+1] < 4 ) //k +1 is there bc k=0 is the Ace pile
                            {
                                temp = board[k+1].removeCard(currentIndex[k+1]); //setting temp equal to the card at the top of the appropriate pile
                                board[k+1].addCardFaceUp(tempCard1, currentIndex[k+1]); //adds the correct card to it's correct pile pile
                                currentIndex[k+1]++; //increase the count of appropriate cards face up in its own pile
                                tempCard1 = temp; //tempCard now equals the card at the top of the pile of the card that was just chosen
                                stepCounter++; //increase the number of moves taken
                                //print out the board
                                if(mode.equals("verbose"))
                                {
                                    System.out.println("MOVE #" + stepCounter);//print out the current move they are one
                                    System.out.println("\n");
                                    if(mode.equals("verbose"))
                                    {
                                        position=1;
                                        for ( int i = 0; i < 13; i++ ){
                                            System.out.println(""+position+"oClock");
                                            for( int j = 0; j < 4; j++ ){

                                                System.out.print(board[i].p1[j].toString());
                                                System.out.print("\t");
                                            }
                                            System.out.println("\n");

                                            position++;
                                        }
                                    }
                                }
                                break;
                            }
                        }
                    }

                }
                //all of this happens if it is a king
                board[12].addCardFaceUp(tempCard1, currentIndex[12]);//puts the king card into the king pile
                currentIndex[12]++;//increases the number of face up kings in the king pile
                loopControl++; //this counter keeps track of how many face up kings
                stepCounter++;//increases the number of moves
                if(mode.equals("verbose"))
                {
                    System.out.println("MOVE #" + stepCounter);//print out the current move they are one
                    System.out.println("\n");
                    //print out the board
                    if(mode.equals("verbose"))
                    {
                        position=1;
                        for ( int i = 0; i < 13; i++ ){
                            System.out.println(""+position+"oClock");
                            for( int j = 0; j < 4; j++ ){

                                System.out.print(board[i].p1[j].toString());
                                System.out.print("\t");
                            }
                            System.out.println("\n");

                            position++;
                        }
                    }
                }

                //if there are 4 face up kings in the king pile then break out of the loop to end the game
                if(currentIndex[12]==4){
                    System.out.println("Game is over because king has 4 king cards");
                    break;
                }

            } while ( loopControl < 4 ); //only run while there are less than 4 face up cards in the king pile

            //run through the currentIndex array and whenever the value in an index is 4 then decrease the total score by one
            for(int  i =0; i<13;i++){
                if(currentIndex[i]==4){
                    totalScore--;
                }
                else{
                    continue;
                }
            }
            System.out.println("It took you " + stepCounter + " moves");//print out how many moves it took you

            //if it is verbose or default print out the board after the game has been finished
            if(mode.equals("verbose") || mode.equals("normal"))
            {
                System.out.println("The 13 piles after the game has been played");
                System.out.println("\n");
                position=1;
                //print out the board
                for ( int i = 0; i < 13; i++ ){
                    System.out.println(""+position+"oClock");
                    for( int j = 0; j < 4; j++ ){
                        System.out.print(board[i].p1[j].toString());
                        System.out.print("\t");
                    }
                    System.out.println("\n");
                    position++;
                }
            }

            System.out.println("\n");
            System.out.println("The total score is: " + totalScore);
            //print out the result of winning or loosing the game based off their total score
            if(totalScore==0)
            {
                System.out.println("You have won the game since you have a score of 0!");
            }
            else
            {
                System.out.println("You have lost the game since you did not have a score of 0 ):");
            }
            System.out.println("\n");

            scoresArray[w-1]=totalScore;//take the total score of the game and put it into an array of all the total scores to be used later for percentages
        }
        //switch case that will run through the scoresArray and increase the counter for each of the 13 possible scores to be used later for percentages
        for(int i=0; i<scoresArray.length; i++)
        {
            switch(scoresArray[i])
            {
                case 0:
                percentage[0]++;
                break;
                case 1:
                percentage[1]++;
                break;
                case 2:
                percentage[2]++;
                break;
                case 3:
                percentage[3]++;
                break;
                case 4:
                percentage[4]++;
                break;
                case 5:
                percentage[5]++;
                break;
                case 6:
                percentage[6]++;
                break;
                case 7:
                percentage[7]++;
                break;
                case 8:
                percentage[8]++;
                break;
                case 9:
                percentage[9]++;
                break;
                case 10:
                percentage[10]++;
                break;
                case 11:
                percentage[11]++;
                break;
                case 12:
                percentage[12]++;
                break;
            }
        }

        System.out.println("The number of games played is " + numGames);
        //This will run through the percentages array and print out the number of times they got each score as well as the percent of times out of the total games
        for(int i=0; i<percentage.length;i++)
        {

            System.out.println("You scored a " + i + ", " + (int)(percentage[i]) + " times, " + df.format((percentage[i]/numGames)*100) + "% of the games.");
            System.out.println("\n");
        }
    }
}

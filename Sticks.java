import java.util.Scanner;

//reader nextdouble takes a value from the user//
// braces {} in if statements are only if there is more than the true/false statement//

public class Main
{
    public static void main (String[] args) { //void in public static meansa it does not return anything, just runs//
    
    Scanner reader = new Scanner(System.in);
    int sticks = (int)(Math.random()*10) + 21; //do something 15 times//
     //the parenthesis puts the int cast after//
    System.out.println("There are " + sticks + " sticks"); // the + connects the variables//
    System.out.println("Select 1 to go first, Select 2 to go second");
   
    boolean turn; //true means player's turn, false is computer's// //boolean can only be true or false//
    if(reader.nextInt() == 1) // == is a question; is something equal?, = is assigning a value//
        turn = true;
    else
        turn = false;
    
    //game will only stop when there's 0 sticks, will continue if there's any more or less//
    while (sticks > 0){ 
        if(turn)
            sticks = playerMove(sticks, reader);
        else
            sticks = computerMove(sticks);
        System.out.println("There are " + sticks + " sticks left");
            if (sticks == 0 && turn) //&& means and//
                System.out.println("Player wins!"); 
            if (sticks == 0 && !turn) //! means false//
                System.out.println("Computer wins!"); //because the player's turn "turn" is currently false with 0 sticks, the computer wins//
                turn = !turn; //this sets turn to the opposite value, setting only to false will forever make it false//
    }
}
    
//public static int means the user must return an int value//

    public static int playerMove(int sticks, Scanner reader){
        System.out.println("Select how many sticks to take");
        int take = reader.nextInt();
        if (take < 1) //gets rid of all weird possibilities and replaces with a certain range of values to input//
            take = 1;
        if (take > 3)//ensures it can't take more than 3//
            take = 3;
        if (take > sticks)
            take = sticks;
        System.out.println("You took " + sticks + "sticks");
        return sticks - take; //returns in the code the amount of sticks left//
    }

    public static int computerMove(int sticks){
        int take;
        if (sticks % 4 != 0) //if sticks is not a multiple of 4//                //% sign means mod, the remainder of division//
            take = sticks % 4; 
        else //number of sticks is a multiple of 4//
            take = (int)(Math.random()*3) + 1; //*3 is the range of values, the + 1 makes it 1 2 3, without it it would be 0 1 2 as the range of possibilities//
        System.out.println("The computer took " + sticks + " sticks");
        return sticks - take;
    }
}

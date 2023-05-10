import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        char[][] board = new char[3][3];

//empty board;

        for(int row=0; row<board.length; row++)
        {
            for(int col=0; col<board[row].length; col++)
            {
                board[row][col] = ' ';
            }
        }

        //input the element - current player

        char player = 'x';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);


        while(!gameOver)
        {
            //print the board
            printBoard(board);

            //input from the player
            System.out.println("Enter your moves like \n 0 0, 1 1, 2 10 0");
            System.out.println("Player "+player+" enter you move:");
            int row = sc.nextInt();
            int col = sc.nextInt();
            
            //check whether the entered row and col is empty or not

            if(board[row][col] == ' ')
            {
                   board[row][col] = player; //place the choice of the player
                   gameOver = hasWon(board, player);  //who has won?
                    
                   if(gameOver)
                   System.out.println("Player "+player+" has won");
                   else
                   {
                      player = (player == 'x')? 'o' : 'x';
                   }
            }
            else
            System.out.println("Invalid move, Try Again!");
        }
        printBoard(board);
    }

    public static void printBoard(char[][] board) 
    {
        for(int row=0; row<board.length; row++)
        {
            for(int col=0; col<board[row].length; col++)
            {
                System.out.print(board[row][col]+" | ");
            }
            System.out.println();
        }
    }

    public static boolean hasWon(char[][] board, char player)
    {
       //check the rows
       for(int row=0; row<board.length; row++)
       {
           if(board[row][0] == player && board[row][1] == player && board[row][2] == player)
           return true;
       }   

       //check the cols
       for(int col=0; col<board[0].length; col++)
       {
           if(board[0][col] == player && board[1][col] == player && board[2][col] == player)
           return true;
       } 

       //check the diagonal
       if(board[0][0] == player && board[1][1] == player && board[2][2] == player)
       return true;

       if(board[0][2] == player && board[1][1] == player && board[2][0] == player)
       return true;

       return false;
    }
}

import java.util.*;

public class Tic_Tac_Toe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        boolean haswinner = false;
        Scanner cin = new Scanner(System.in);
        int counter = 1;
        do {
            display(board);
            if (counter == 10) {
                    System.out.println("It's a tie!!");
                    break;
            }
            System.out.println();
            if (counter % 2 != 0) {
                System.out.println("""
                                   X it is your turn. Pick where you want to place your X
                                   by entering 'top', 'middle', or 'bottom' for the row
                                   and 'left', 'middle', or 'right' for the column
                                   separated by a space""");
            }
            else {
                System.out.println("""
                                   O it is your turn. Pick where you want to place your X
                                   by entering 'top', 'middle', or 'bottom' for the row
                                   and 'left', 'middle', or 'right' for the column
                                   separated by a space""");
            }
            int row = 0;
            int column = 0;
            boolean ans = false;
            while (ans == false) {
                String rowInput = cin.next();
                String columnInput = cin.next();
                if (determineRow(rowInput) == -1 || determineColumn(columnInput) == -1) {
                    System.out.println("Please type either 'top', middle', or 'bottom' for the row "
                                        + "and 'left', 'middle', or 'right' for the column");
                }
                else {
                    row = determineRow(rowInput);
                    column = determineColumn(columnInput);
                    ans = true;
                }
            }
            if (row > 2 || row < 0 || column < 0 || column > 2) {
                System.out.println("Please enter a number between 0 and 2");
            }
            else if (occupied(board[row][column]) == true) {
                System.out.println("\nThis space is filled, please try another\n");
            }
            else {
                System.out.println();
                if (counter % 2 != 0) {
                    board[row][column] = 'X';
                }
                else {
                    board[row][column] = 'O';
                }

                if (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X' ||                   
                    board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X' ||                
                    board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X' ||                     
                    board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X' || 
                    board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X' || 
                    board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X' || 
                    board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X' || 
                    board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X')
                {
                    haswinner = true;
                    display(board);
                    System.out.println();
                    System.out.println("Congratulations player X you are the winner!!");
                }
                else if(board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O' ||                   
                        board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O' ||                
                        board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O' ||                     
                        board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O' || 
                        board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O' || 
                        board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O' || 
                        board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O' || 
                        board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O')
                {
                    haswinner = true;                    
                    display(board);
                    System.out.println();
                    System.out.println("Congratulations player O you are the winner!!");
                }
                else {
                    counter++;
                }
            }
        } while(haswinner == false);
    }
    
    public static boolean occupied(char tto) {
        if (tto == 'X' || tto == 'O') {
            return true;
        }
        else    
            return false;
    }
    
    public static void display(char[][] board) {
        System.out.println(board[0][0]+"   |"+board[0][1]+"   |"+board[0][2]);
        System.out.println("- - - - - -");
        System.out.println(board[1][0]+"   |"+board[1][1]+"   |"+board[1][2]);
        System.out.println("- - - - - -");
        System.out.println(board[2][0]+"   |"+board[2][1]+"   |"+board[2][2]);
    }
    
    public static int determineRow(String ans) {
        int result;
        if (ans.equalsIgnoreCase("top")) {
            result = 0;
        }
        else if(ans.equalsIgnoreCase("middle")) {
            result = 1;
        }
        else if (ans.equalsIgnoreCase("bottom")) {
            result = 2;
        }
        else {
            result = -1;
        }
        return result;
        
    }
    
    public static int determineColumn(String ans) {
        int result;
        if (ans.equalsIgnoreCase("left")) {
            result = 0;
        }
        else if(ans.equalsIgnoreCase("middle")) {
            result = 1;
        }
        else if (ans.equalsIgnoreCase("right")) {
            result = 2;
        }
        else {
            result = -1;
        }
        return result;
    }
}
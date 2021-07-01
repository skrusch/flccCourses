/*
@Author: Stephanie Krusch
@FileName: Magic.java
@Purpose: Allow user to create a square matrix, and check if matrix is a magic square
@Date: 6/26/2021
 */

import java.util.*;

public class Magic {
    public static void main(String[] args) {

        //Create scanner object
        Scanner scanner = new Scanner(System.in);

        //Prompt user for input
        System.out.println("Please enter a matrix size: ");

        //Accept user input into the variable
        int size = scanner.nextInt();

        //create a two-dimensional array
        int[][] board = new int[size][size];

        //call the create array method
        createArray(board, size, scanner);

        //call the toString method and print out the array string object
        System.out.println(toString(board));

        //Show user if matrix is a magic square
        isMagic(board, size);
    }

    public static int[][] createArray(int[][] board, int size, Scanner scanner) {

        //Ask user what each number should be in the matrix
        System.out.println("\nEnter the desired value for each element in the matrix: ");

        //accept user input into the matrix
        for (int i = 0; i <= board.length - 1; i++) {
            for (int j = 0; j <= board[i].length - 1; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        //display the matrix
        System.out.print("\nMagic Square?");
        System.out.println("\n-------------");

        return board;

    }

    public static String toString(int[][] board) {

        //create StringBuilder Object
        StringBuilder boardString = new StringBuilder();
        if (board == null) {
            return null;
        } else {
            //display the array
            for (int i = 0; i <= board.length - 1; i++) {
                for (int j = 0; j <= board[i].length - 1; j++) {

                    boardString.append(board[i][j] + " ");
                }
                boardString.append("\n");
            }
        }

        return boardString.toString();

    }

    public static boolean isMagic(int[][] board, int size) {

            /*
            if all rows, columns, and diagonals equal the same sum,
            there is a magic square
             */

            //assess sums of the diagonals in the matrix
            int sumDiag1 = 0;
            int sumDiag2 = 0;

            for (int i = 0; i < size; i++) {
                sumDiag1 += board[i][i];
                sumDiag2 += board[i][size - 1 - i];
            }

            int rowSum = 0;
            int columnSum = 0;
            //assess sums of the rows and columns in the matrix
            for (int i = 0; i < size; i++) {

                rowSum = 0;
                columnSum = 0;

                for (int j = 0; j < size; j++) {
                    rowSum += board[i][j];
                    columnSum += board[j][i];
                }
            }

            System.out.println("The sum of the first diagonal is: " + sumDiag1);
            System.out.println("The sum of the second diagonal is: " + sumDiag2);
            System.out.println("The sum of each row is: " + rowSum);
            System.out.println("The sum of each column is: " + columnSum);

            if(sumDiag1 == sumDiag2 && rowSum == columnSum) {
                System.out.println("The matrix is a magic square.");
                return true;
            } else {
                System.out.println("The matrix is not a magic square.");
                return false;
            }
    }

}

/*
    This lab was more straightforward than I originally believed as I did not have to create a Object definition outside of
the main method. Instead, I was able to write multiple methods to fulfill the program's requirements.
    I was able to discover that although the row sum and column sum can be declared outside of the for loop, they must be assigned a value of 0 inside the loop. This prevents all rows being added together all at once, and adds the numbers in each row one row at a time. This means that instead of an erroneous result of 45, which is the sum of all elements in the matrix, the row sum is 15, which means each row's elements were added together separately.
    It was interesting to me that Java has a built-in StringBuilder class which helped me convert my array into a String object. I also appreciated that I could use my print array code with some simple edits to allow the String object to be built.
    I decided to use an additional method, createArray, which made my code more concise, and allowed me to write a significantly shorter main method.
 */
import java.util.*;
/*
1.    Purpose: Purpose of the program is gain experience with multi-dimensional arrays and generic algorithms.
2.    There are four problems we need to solve:
a.    Asking the user for a dimension input and print out two matrices with the size of the input but at least 25. Generating random numbers (1-30) for every cell of matrix.
Solution:  Use scanner class to get input and wrap them inside a do-while loop to get at least 25. Then use the random class to get random number form 1-30 and to nested loop to print out two matrices.
b.    Taking those two matrices and add them.
Solution: Use two nested loop to add those two matrices and display.
c.    Taking those two matrices multiply with each other.
Solution: Using three nested loops to multiply two matrices and print out the result.
d.    Asking user if they want to repeat the program.
Solution: Inside the main method I create a do-while loop; inside the do while loop I create an instance object to run methods and asking the user if they want to repeat the program. If the user’s response satisfies a condition in a do-while loop the program will repeat.
e.    Show how long it takes to add and multiply two matrices:
Solution: Add a clock before and after each of 2 methods, then we can find the elapse time and display them on screen.
3.    Data Structures: Array
4.    First of all program asks user to input an integer number which is represented the side of 2 square arrays, but at least 25 otherwise a program will keep asking until it gets the right input. Then program automatically generate two random square arrays and print them to screen. Then the computer adds them up and prints the result. Same thing with multiplication. After all, it will ask the user if they want to repeat the program.
5.    There are 1 class and three methods inside. 
a.    printMatrice: printing 2 square matrices with random numbers (1-30) each cell.
b.    addMatrice: Add 2 matrices and print result.
c.    mulMatrice: Multiply 2 matrices and print result.
d.    Main method: Creating an object to call those three above methods. Asking the user if they want to repeat the program.
*/

public class matrix{
  int r; 
  int m1[][], m2[][], m3[][], m4[][]; // declare variables
  
  //Multiplication method
  public void mulMatrice(){
    long start = System.currentTimeMillis();// start time
    System.out.println("Multiplication: ");
    m4 = new int[r][r];
    //compute result
    for (int i=0; i<r ; i++ ) {
      for (int j=0; j<r ; j++ ) {
        for (int k=0; k<m2.length ; k++ ) {
          m4[i][j] += (m1[i][k]*m2[k][j]);
        }
      }
    }
    //display result
    for (int i=0; i<m4.length ; i++ ) {
      for (int j=0; j<m4[i].length ; j++ ) {
        System.out.printf("[%4d]", m4[i][j]);
      }
      System.out.println();
    }

    long elapsedTimeMillis = System.currentTimeMillis()- start; //the period time
    System.out.println("It takes " + elapsedTimeMillis + " mili seconds to multiply 2 matrices.");
    System.out.println(); 
  }

  //Adding method
  public void addMatrice(){
    long start2 = System.currentTimeMillis();
    System.out.println("Addition: ");
    m3 = new int[r][r];
    //add and display result
    for (int i=0; i<r ; i++ ) {
      for (int j=0; j<r ; j++ ) {
        m3[i][j] = m1[i][j] + m2[i][j];
        System.out.printf("[%2d]", m3[i][j]); 
      }
      System.out.println();
    }
    long elapsedTimeMillis2 = System.currentTimeMillis()- start2;
    System.out.println("It takes " + elapsedTimeMillis2 + " mili seconds to add 2 matrices.");
    System.out.println();
  }

  //Print 2 matrice method
  public void printMatrice() { 
    do { 
      System.out.println("Enter the size of matrice, at least 25: ");
      Scanner input = new Scanner(System.in);
      r = input.nextInt();
      if (r < 25) {
        System.out.print("Please try again!");
      }
      System.out.println();     
    } while (r<25);//getting valid user input. 
    //display matrix 1
    System.out.println("Matrix1: ");
    m1 = new int[r][r];
    Random rand = new Random();
    for (int i=0; i<m1.length ; i++ ) {
      for (int j=0; j<m1[i].length ; j++ ) {
        m1[i][j] = rand.nextInt(30) + 1;
        System.out.printf("[%2d]", m1[i][j]);
      }
      System.out.println();
    }
    //display matrix2
    System.out.println();
    System.out.println("Matrix2: ");
    m2 = new int[r][r];
    for (int i=0; i<m2.length ; i++ ) {
      for (int j=0; j<m2[i].length ; j++ ) {
        m2[i][j] = rand.nextInt(30) + 1;
        System.out.printf("[%2d]",m2[i][j]);
      }
      System.out.println();
    }
    System.out.println();
  }

  public static void main(String[] args){
    String a = "";
    do { 
      matrix o = new matrix();
      o.printMatrice();
      o.addMatrice();
      o.mulMatrice();
      System.out.println("Repeat the program?(type yes):" );
      Scanner input2 = new Scanner(System.in);
      a = input2.next();
    } while (a.equals("yes"));//repeat the program. 
  }
}

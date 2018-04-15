/*
Name: Hoa Pham
Csc 2720

1. The purpose of the program is to To gain experience with Binary Search Trees and building your own LinkedList.
2. Using basic loop, if-else statement to solve.
3. Data structure used: Binary Search Tree, LinkedList
4.  
    1. Generate 100 random integer numbers ranging from 1 – 99.
    2. Store these numbers in a data structure of your choice and display the data on the screen. DO NOT SORT THIS DATA STRUCTURE.
    3. Now build a Binary Search Tree using this set of numbers. You MUST insert the values into the tree starting from the first element of your Data Structure and go sequentially.
    4. After building the tree, use an infix recursive method to display the data on the screen. 
5. There is only 3 classes do every thing.
    1. BST class contains all the methods.
    2. Bnode class is a binary tree.
    3. BSTree class is to assign random number and display on screen.

*/

import java.util.Random;
import java.util.Scanner;

/* Class BinarySearchTree */
public class BSTree {
    public static void main(String[] args) {
       /* Creating object of BST */
        BST newbst = new BST();

        int numbers[] = new int[100];
        Random random = new Random();
        int low = 1, high = 99;
        for (int i = 0; i < 100; i++) {
            int randomNum = random.nextInt((high - low) + 1) + low;
            numbers[i] = randomNum;
        }

        System.out.println("Random Numbers are :");
        for (int i = 0; i < 100; i++) {
            System.out.print(numbers[i] + " ");
        }

        for (int i = 0; i < 100; i++) {
            newbst.insert(numbers[i]);
        }
        System.out.println("\nInfix recursive :");
        newbst.inorder();

    }

}
/*
Name: Hoa Pham
Csc 2720

1. The purpose of the program is to simulates a bank. We can gain experience with Queues, library functions that generates random numbers, provide time, and use arrays. 
2. Using basic loop, if-else statement to solve.
3. Data structure used: array, queue.
4. The program will prompt the user asking if they want to run the program again. If yes, then start the program over. If no, then terminate the program. 
The execution phase run for 2 minutes during which time customers will arrive randomly between 2 - 6 seconds and be placed into a queue. Each customer will have a property relating to the amount of time he/she wants to spend with a teller, which is to be randomly generated to be between 2 and 5 seconds.
There would be a maximum of 5 tellers to attend to the customers. When you start the simulation, each teller is occupied.You will need to generate a random time for each of the first 5 customers occupying the tellers at the begining of the 2 minutes simulation. 
Out put: number of customer each teller se
5. There is only 1 bank class do every thing.

*/
import java.io.*;
import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Bank
{
    public static void main(String[] args)
   {
       Scanner myScan = new Scanner(System.in);
       while(true)
       {
           System.out.println("Want to run the program?.. Enter \"yes\" or \"no\": ");
           String choice = myScan.nextLine();
           choice.toLowerCase();
       if (choice.equals("yes") || choice.equals("y"))
       {
       Runnable bankRunnable = new Runnable()
       {
           Random bank_rd = new Random();
           Queue<Integer> bank_queue = new LinkedList<Integer>();
           boolean bankteller_1,bankteller_2,bankteller_3,bankteller_4,bankteller_5 = false;
           boolean[] bank_Array = {bankteller_1, bankteller_2, bankteller_3, bankteller_4, bankteller_5};
           int[] bank_Arraytwo = {(bank_rd.nextInt(5 - 2) + 2),(bank_rd.nextInt(5 - 2) + 2),(bank_rd.nextInt(5 - 2) + 2),(bank_rd.nextInt(5 - 2) + 2),(bank_rd.nextInt(5 - 2) + 2)};
           int bi = 0;
           int bank_a1, bank_b1, bank_c1, bank_d1, bank_e1;
           int customer_Servedone, customer_Servedtwo, customer_Servedthree, customer_Servedfour, customer_Servedfive = 0;
           int occupied_Timeone, occupied_Timetwo, occupied_Timethree, occupied_Timefour, occupied_Timefive = 0;
           int bank_f1, bank_g1, bank_h1, bank_i1, bank_j1 = 1;
        public void run()
        {
                  if(bi == 120)
                  {
                      System.out.println("The total amount of customers " + (customer_Servedone + customer_Servedtwo+ customer_Servedthree

                      + customer_Servedfour + customer_Servedfive + 5 + bank_queue.size()) + " customers.");
                      System.out.println("The total amount of customers that each teller helped.: ");
                      System.out.println("Teller 1: " + (customer_Servedone + 1));
                      System.out.println("Teller 2: " + (customer_Servedtwo + 1));
                      System.out.println("Teller 3: " + (customer_Servedthree + 1));
                      System.out.println("Teller 4: " + (customer_Servedfour + 1));
                      System.out.println("Teller 5: " + (customer_Servedfive + 1));
                      System.out.println("Total teller time of " + (customer_Servedone + customer_Servedtwo + customer_Servedthree
                      + customer_Servedfour + customer_Servedfive + 5) + " customers.");
                      System.out.println("The total amount of time that each teller was occupied.: " + (occupied_Timeone + occupied_Timetwo + occupied_Timethree
                      + occupied_Timefour + occupied_Timefive) + " seconds.");
                      System.out.println("The total amount of customers that did not get to see a teller: " + bank_queue.size() + " customers");
                      System.exit(0);
                  }
                  else
                  {
                   if(bank_rd.nextInt(4) < 6)
                   {
                       int b_time = (bank_rd.nextInt(5 - 2) + 3);
                       bank_queue.add(b_time);
                   }
                   while(bank_f1 == 1)
                   {  
                       bank_a1 = bi;
                       bank_f1 = 0;
                   }
                   if ((bi - bank_a1) >= bank_Arraytwo[0])
                   {
                       bank_Array[0] = true;
                       if (bank_Array[0] == true && bank_queue.isEmpty() == false)
                       {
                           occupied_Timeone += bank_Arraytwo[0];
                           bank_Arraytwo[0] = bank_queue.poll();
                           bank_f1 = 1;
                           customer_Servedone++;
                       }
                   }
                   while(bank_g1 == 1)
                   {
                       bank_b1 = bi;
                       bank_g1 = 0;
                   }
                   if ((bi - bank_b1) >= bank_Arraytwo[1])
                   {
                       bank_Array[1] = true;
                       if (bank_Array[1] == true && bank_queue.isEmpty() == false)
                       {
                           occupied_Timetwo += bank_Arraytwo[1];
                           bank_Arraytwo[1] = bank_queue.poll();
                           bank_g1 = 1;
                           customer_Servedtwo++;
                       }
                   }
                   while(bank_h1 == 1)
                   {
                       bank_c1 = bi;
                       bank_h1 = 0;
                   }
                   if ((bi - bank_c1) >= bank_Arraytwo[2])
                   {
                       bank_Array[2] = true;
                       if (bank_Array[2] == true && bank_queue.isEmpty() == false)
                       {
                           occupied_Timethree += bank_Arraytwo[2];
                           bank_Arraytwo[2] = bank_queue.poll();
                           bank_h1 = 1;
                           customer_Servedthree++;
                       }
                   }
                   while(bank_i1 == 1)
                   {
                       bank_d1 = bi;
                       bank_i1 = 0;
                   }
                   if ((bi - bank_d1) >= bank_Arraytwo[3])
                   {
                       bank_Array[3] = true;
                       if (bank_Array[3] == true && bank_queue.isEmpty() == false)
                       {
                           occupied_Timefour += bank_Arraytwo[3];
                           bank_Arraytwo[3] = bank_queue.poll();
                           bank_i1 = 1;
                           customer_Servedfour++;
                       }
                   }
                 while(bank_j1 == 1)
                   {
                       bank_e1 = bi;
                       bank_j1 = 0;
                   }
                   if ((bi - bank_e1) >= bank_Arraytwo[4])
                   {
                       bank_Array[4] = true;
                       if (bank_Array[4] == true && bank_queue.isEmpty() == false)
                       {
                           occupied_Timefive += bank_Arraytwo[4];
                           bank_Arraytwo[4] = bank_queue.poll();
                           bank_j1 = 1;
                           customer_Servedfive++;
                       }
                   }
                   bi++;
                   if(bank_queue.size() == 1)
                   {
                       System.out.println("There is " + bank_queue.size() + " person exist in the queue.");
                   }
                   else
                   {
                       System.out.println("There are " + bank_queue.size() + " people exist in the queue.");
                   }
                   System.out.println("There are " + (120 - bi) + " seconds left in the simulation.");
               }
           }
       };
       ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);
       exec.scheduleAtFixedRate(bankRunnable, 0, 1, TimeUnit.SECONDS);
    }
    else if (choice.equals("no") || choice.equals("n"))
      {
        System.exit(0);     
      }
    else
      {     
        System.out.println("Incorrect input. Enter \"yes\" or \"no\": ");
      }
    }
  }

}
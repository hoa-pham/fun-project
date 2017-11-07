/*
Author: Hoa Pham
Documentation:

1. The purpose of this program is maintain a list of contacts using LinkedList
 * data structure invokes from the library. Each node in Linkedlist is an object
 * which contains a person's last, first name, and phone number. We are able to
 * add, remove, modify records in the list by prompting user for commands.
 * 2. Before we make any changes in the list, we would like to make sure that the
 * list is not empty. When adding a new record, we should first check if that
 * record exists in the list by traversing through each object in the List, then
 * compare its first, last name, and phone number with the new record. This step
 * allows us to find the appropriate location for the new record (alphabetically),
 * also check whether the new record is a duplicate. When user want to select
 * remove command,he/she must select a record to become the current record deletion
 * if currentRecord does not point to a node. Remove procedure can be done by
 * invoking remove() method from library. In order to change any data in an object
 * of the LinkedList, I decided to create a temp node that contains updated information,
 * then remove the currentRecord before adding the temp node to the list.
 * Algorithms to be used in this program is searching by looping into the list and
 * compare each element (in an object) to the data we want to search for.
 * 3. Data structure to be used in my solution is LinkedList.
 * 4. To use the program, user can select a command from the menu as he/she wishes.
 * Each command will have its behavior discription on the right. The menu will be
 * redisplayed on the screen every time the prorgam completes a task. The program
 * will stop running only if the user selects "q", which is to quit.
 * 5. Records class is developed for providing methods to maintain the LinkedList,
 * such as add, remove, modify, and display. Its data fields would be a LinkedList
 * to hold records, and a Profiles object to keep track of the currentRecord.
 * Class Profiles contains people's information such as their first names, last names,
 * and phone numbers. We can get or set an object of Profiles by calling its getter
 * or setter.
 * phonedir is the driver class. This class will take care of passing a command
 * chosen by user to the method action() in Records class. From there, it will
 * call an appropriate method which corresponding to the behavior of the command.
*/
import java.util.*;
public class phonedir {
	LinkedList<Contact> list = new LinkedList<Contact>();
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		phonedir obj = new phonedir();
		String cmd;
// The do while loop display the menu, getting input to excute command.
		do {			
			System.out.println("A program to keep a phoen Directory");
			System.out.println("a     Show all records");
			System.out.println("d     Delete the current record ");
			System.out.println("f     Change the first name in the current record");
			System.out.println("l     Change the last name in the current record");
			System.out.println("n    Add a new record");
			System.out.println("p    Change the phone number in the current record");
			System.out.println("q			Quit");
			System.out.println("s     Select a record from the record list to become the current record");
			System.out.println("Enter a command from the list above (q to quit)");
			cmd = input.nextLine(); 
			if (cmd.equals("n")) {
				System.out.println("Enter first name: ");
				String f = input.nextLine();
				System.out.println("Enter last name: ");
				String l = input.nextLine();
				System.out.println("Enter phone number: ");
				String p = input.nextLine();
				obj.addNew(f, l, p);
			} else if (cmd.equals("p")) {
				obj.changPhone();
			}	else if (cmd.equals("d")) {
				obj.del();
			}	else if (cmd.equals("f")) {
				obj.changeFirst();
			}	else if (cmd.equals("l")) {
				obj.changeLast();
			} else if (cmd.equals("a")) {
				obj.show();
			} else if (cmd.equals("s")) {
				obj.select();
			} else {
				System.out.println("Illegal command!");
			}
		}while(!cmd.equals("q"));
	}
	//get name and phone number and dislay current record
	public void addNew(String fname, String lname, String phone) {
		Contact a = new Contact(fname, lname, phone);
		list.add(a);
		myAdd(a);
		System.out.println("Current rocord is: " + a.toString());
	}
	//changing phone number of current record
	public void changPhone() {
		Scanner input = new Scanner(System.in);
		System.out.println("Add a new phone number: ");
		String np = input.nextLine();
		list.getLast().setPhone(np);
		System.out.println(list);
	}
	//delete information in a current record
	public void del() {
		System.out.println("Deleted: " + list.getLast());
		list.removeLast();
		System.out.println(list);
	}
	//change first name of a current record
	public void changeFirst() {
		if (list.size()==0) {
			System.out.println("No current record");
		} else {
			System.out.println("Enter the new first name: ");
			Scanner input = new Scanner(System.in);
			String f = input.nextLine();
			list.getLast().setFname(f);
			System.out.println(list.getLast());
			System.out.println("Current record is: " + list.getLast().toString());			
		}
	}
	//change last name of a current record
	public void changeLast() {
		if (list.size() ==0) {
			System.out.println("No current record");
		} else {			
			System.out.println("Enter the new last name: ");
			Scanner input = new Scanner(System.in);
			String l = input.nextLine();
			list.getLast().setLname(l);
			System.out.println("Current record is: " + list.getLast().toString());
			// myAdd(list.getLast());
		}
	}
	//show the phone book
	public void show() {
		System.out.println("First Name" + "     Last Name" + "     Phone Number");
		int i;
		for (i = list.size() -1 ; i >= 0 ; i-- ) {
			System.out.println(list.get(i).getFname() + "          " + list.get(i).getLname()+ "             " +list.get(i).getPhone());	
		}	
		if (list.size() == 0) {
			System.out.println("No Contact Found");
		}
	}
	//Select a record from the record list to become the current record
	public void select() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter first name: ");
		String f = input.nextLine();
		System.out.println("Enter last name: ");
		String l = input.nextLine();
		for (int i = 0; i < list.size() ; i++ ) {
			if (list.get(i).getFname().equals(f) && list.get(i).getLname().equals(l)) {
				list.addLast(list.get(i));
				list.remove(i);
			} else {
				System.out.println("No matching found!");
			}
		}
	}
	public void myAdd(Contact c) {
	boolean add = true;
	  if (list.size() == 0) {
	    list.add(c);
	  } else {
      boolean stop = false;
      int i = 0;
      while (!stop && i < list.size()) {
        Contact a = list.get(i);
        if (a.compareTo(c) > 0) {
          list.add(i, c);
          stop = true;
          } else if (a.compareTo(c) == 0) {
            if ((a.getPhone()).equals(c.getPhone())) {
              System.out.println("Profile has been existed in your directory.");
              add = false;
              stop = true;
            } else {
              	list.add(i, c);
                stop = true;
            }
          }
          i++;
	    }
	      //add to the last of LinkedList if temp.lastName is the greatest
	      if (!stop) {
	        list.addLast(c);
	      }
	  }
	  // if (add) {
	  //   currentRecord = newProfile;
	  //   System.out.println("Current record is: " + currentRecord + "\n");
	  // }
	}
}

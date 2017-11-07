import java.util.*;
public class Test {
	LinkedList<Contact> list = new LinkedList<Contact>();
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		phonedir obj = new phonedir();
		String cmd;

		System.out.println("A program to keep a phone Directory");
		System.out.println("a     Show all records");
		System.out.println("d     Delete the current record ");
		System.out.println("f     Change the first name in the current record");
		System.out.println("l     Change the last name in the current record");
		System.out.println("n    Add a new record");
		System.out.println("p    Change the phone number in the current record");
		System.out.println("q			Quit");
		System.out.println("s     Select a record from the record list to become the current record");
		do {			
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
				obj.sortL();
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
				System.out.println("Please enter again!");
			}
		}while(!cmd.equals("q"));
	}
	public void addNew(String fname, String lname, String phone) {
		Contact a = new Contact(fname, lname, phone);
		list.add(a);
		System.out.println("Current rocord is: " + a.toString());
	}
	public void changPhone() {
		Scanner input = new Scanner(System.in);
		System.out.println("Add a new phone number: ");
		String np = input.nextLine();
		list.getLast().setPhone(np);
		System.out.println(list);
	}
	public void del() {
		System.out.println("Deleted: " + list.getLast());
		list.removeLast();
		System.out.println(list);
	}
	public void changeFirst() {
		System.out.println("Enter the new first name: ");
		Scanner input = new Scanner(System.in);
		String f = input.nextLine();
		list.getLast().setFname(f);
		System.out.println(list.getLast());
	}
	public void changeLast() {
		System.out.println("Enter the new last name: ");
		Scanner input = new Scanner(System.in);
		String l = input.nextLine();
		list.getLast().setLname(l);
		System.out.println(list.getLast());
	}
	public void show() {
		System.out.println("First Name" + " Last Name" + " Phone Number");
		int i;
		for (i = list.size() -1 ; i >= 0 ; i-- ) {
			System.out.println(list.get(i).getFname() + "          " + list.get(i).getLname()+ "             " +list.get(i).getPhone());	
		}	
		if (list.size() == 0) {
			System.out.println("No Contact Found");
		}
	}
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
			}
		}
	}
	// public void sortL() {
	// 	Collections.sort(list, new Comparator<String>() {
	//     @Override
	//     public int compare(Contact o1, Contact o2) {
	//       return Collator.getInstance().compare(o1, o2);
	//     }
	//   });
	// }
}

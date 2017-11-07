public class Contact implements Comparable<Contact> {
	public String fName;
	public String lName;
	public String phone;
	
	public Contact() {
	}

	public Contact(String fName, String lName, String phone) {
		this.fName = fName;
		this.lName = lName;
		this.phone = phone;
	}

	public String getFname() {
		return fName;
	}
	public void setFname(String fName) {
		this.fName = fName;
	}
	public String getLname() {
		return lName;
	}
	public void setLname(String lName) {
		this.lName = lName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String toString() {
		return String.format(fName + " " +lName + " "+ phone);
	}
	public int compareTo(Contact c2) {
		return this.lName.compareTo(c2.lName);
	}
}
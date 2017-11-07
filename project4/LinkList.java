public class LinkList() {
	public NewNode head;
	public void addNew(Contact c) {
		NewNode node = new NewNode(c);
		NewNode current = head;
		while (current.next != null) {
			current = current.next;
		}
	}
}
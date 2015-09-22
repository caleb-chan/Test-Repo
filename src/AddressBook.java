import java.util.ArrayList;


public class AddressBook {
	private ArrayList<BuddyInfo> buddies;
	
	public AddressBook(){
		buddies = new ArrayList<BuddyInfo>();
	}
	
	public void addBuddy(BuddyInfo info){
		buddies.add(info);
	}
	
	public BuddyInfo removeBuddy(int index){
		return buddies.remove(index);
	}
	
	public static void main(String args[]){
		AddressBook book = new AddressBook();
		BuddyInfo buddy = new BuddyInfo("Tom", "Carleton", "1234");
		book.addBuddy(buddy);
		book.removeBuddy(0);
	}
}

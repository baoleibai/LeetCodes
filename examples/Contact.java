package examples;

public class Contact implements Comparable {

	private String phonenumber;
	private String firstName, lastName;
	
	public Contact(String firstName, String lastName, String number) {
		// TODO Auto-generated constructor stub
		this.phonenumber = number;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Contact target = (Contact)o;
		if (this.lastName.equals(target.lastName)) {
			return this.firstName.compareTo(target.firstName);
		} else {
			return this.lastName.compareTo(target.lastName);
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return firstName + " " + lastName + " " + phonenumber;
	}
}

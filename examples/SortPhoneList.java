package examples;

import searchingandsorting.SortingandSearching;

public class SortPhoneList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contact[] friends = initFriends();

		int test = 2351;
		String string =String.valueOf(test);
		char tc = string.charAt(3);
		int nn = Character.digit(tc, 10);
		
		System.out.println(tc + " " + nn);
		// SortingandSearching.selectionSort(friends);
		// SortingandSearching.insertionSort(friends);
		//SortingandSearching.BubbleSort(friends);
		SortingandSearching.mergeSort(friends, 0, friends.length - 1);
		
		for (int index = 0; index < friends.length; index++) {
			System.out.println(friends[index].toString());
		}
		System.out.println("=============");
		friends = initFriends();
		SortingandSearching.quickSort(friends, 0, friends.length - 1);
		for (int index = 0; index < friends.length; index++) {
			System.out.println(friends[index].toString());
		}
		System.out.println("=============");
		SortPhoneList sorter = new SortPhoneList();
        int[] input2 = {24,2,45,20,56,75,2,55,34,53,12};
        for(int i:input2){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        SortingandSearching.quickSortNew(input2, 0, input2.length -1);
        for(int i:input2){
            System.out.print(i);
            System.out.print(" ");
        }
        
        
	}

	private static Contact[] initFriends() {
		Contact[] friends =new Contact[7];
		friends[0] = new Contact("John", "Smith", "610-555-7384");
		friends[1] = new Contact("Sarah", "Barnes", "215-555-3827");
		friends[2] = new Contact("Mark", "Riley", "733-555-2969");
		friends[3] = new Contact("Laura", "Getz", "663-555-3984");
		friends[4] = new Contact("Larry", "Smith", "464-555-3489");
		friends[5] = new Contact("Frank", "Phelps", "322-555-2284");
		friends[6] = new Contact("Marsha", "Grant", "243-555-2837");
		return friends;
	}
}

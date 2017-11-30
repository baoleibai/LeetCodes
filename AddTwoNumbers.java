
public class AddTwoNumbers {

	//https://leetcode.com/problems/add-two-numbers/
	/**
	 * You are given two non-empty linked lists representing two non-negative integers. 
	 * The digits are stored in reverse order and each of their nodes contain a single digit. 
	 * Add the two numbers and return it as a linked list.
	 * 
	 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	 * Output: 7 -> 0 -> 8
	 * @author bbai
	 *
	 */
	public class ListNode {
		int val;
		ListNode next;
		
		public ListNode(int val) {
			this.val = val;
		}
	}
	public AddTwoNumbers() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 51ms
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbersQuick(ListNode l1, ListNode l2) {
		int carry = 0;
        ListNode p = new ListNode(0);
        ListNode head = p;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry%10);
            carry = carry/10;
            p = p.next;
        }
        if (carry != 0) {
            p.next = new ListNode(1);
        }
        return head.next;
   }
	/**
	 * ~60 ms
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1,ListNode l2) {
		ListNode head = new ListNode(-1);
		ListNode p = head;
		int carry = 0;
		
		while (l1 != null || l2 != null || carry > 0) {
			int b = 0;
			int a = 0;
			if (l1 != null) {
				a = l1.val;
				ListNode temp = l1;
				l1 = l1.next;
				temp.next = null;
				temp = null;
			}
			if (l2 != null) {
				b = l2.val;
				ListNode temp = l2;
				l2 = l2.next;
				temp.next = null;
				temp = null;
				
			}
			int sum = a + b+ carry;
			int result = sum % 10 ;
			
			ListNode node = new ListNode(result);
			p.next = node;
			p = node;
			carry = sum / 10;
		}
		return head.next;
	}
	
	public static void main(String[] args) {
		
	}

}

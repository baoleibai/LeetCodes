import java.util.Arrays;
import java.util.HashMap;

public class Solution {

	private int[] result = {-1,-1};
    class Pair implements Comparable<Pair> {
        int value;
        int index;
        public Pair(int idx, int val) {
            index = idx;
            value = val;
        }
        public int compareTo(Pair other) {
			return this.value - other.value;
		}
    }
    
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        Pair[] pairs = new Pair[n];
        for (int i =0; i < n; i++) {
            pairs[i] = new Pair(i, numbers[i]);
        }
       Arrays.sort(pairs);
		
		int begin = 0;
		int end = n - 1;
		while (begin < end) {
            int temp = (pairs[begin].value + pairs[end].value);
			if (temp > target) {
				end--;
			} else if (temp < target) {
				begin++;
			} else {
				result[0] = pairs[begin].index;
                result[1] = pairs[end].index;
                break;
			}
		}
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String styr = "~bc";
		char[] chars = styr.toCharArray();
		System.out.println("abc " + (int)chars[0]);
	}

}

import java.util.Arrays;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/description/
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * @author baibaolei
 *
 */
public class TwoSum {

	private static boolean DEBUG = true;
	private int[] result = new int[2];

	public TwoSum() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 这个解法的优点是只使用了一次循环，缺点是如果nums的长度很大的话，会导致HashMap的size变大。 空间换时间
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] hashMapTwoSum(int[] nums, int target) {
		HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; ++i) {
			if (m.containsKey(target - nums[i])) {
				result[1] = i;
				result[0] = m.get(target - nums[i]);
				break;
			}
			m.put(nums[i], i);
		}
		return result;
	}

	public int[] twoSumByArray(int[] numbers, int target) {
		int n = numbers.length;
		Pair[] pairs = new Pair[n];
		for (int i = 0; i < n; ++i) {
			pairs[i] = new Pair(numbers[i], i);
		}
		Arrays.sort(pairs);

		int begin = 0;
		int end = n - 1;
		while (begin < end) {
			System.out.println("x y " + (pairs[begin].number + pairs[end].number) + " " + begin + " " + end);
			int temp = pairs[begin].number + pairs[end].number;
			if ((temp) > target) {
				end--;
			} else if (temp < target) {
				begin++;
			} else {
				result[0] = pairs[begin].idx;
				result[1] = pairs[end].idx;
				System.out.println("x y " + pairs[begin].idx + pairs[end].idx);
				break;
			}
		}
		return result;
	}

	/**
	 * 1.如果传进来的数组已经是排好序的了，就不需要执行Arrays.sort，可以提高效率；
	 * 2.下面的函数返回的是角标；如果要返回所有a+b=n的a和b的话。不需要构造pairs数组。
	 * 
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] numbers, int target) {
		int n = numbers.length;
		Pair[] pairs = new Pair[n];
		for (int i = 0; i < n; ++i) {
			pairs[i] = new Pair(numbers[i], i + 1);
		}
		Arrays.sort(pairs);

		System.out.println(pairs.toString());
		for (int i = 0; i < pairs.length; i++) {
			System.out.print(pairs[i].number + " ");
		}
		System.out.println(pairs.toString());

		int[] result = new int[2];
		int begin = 0;
		int end = n - 1;
		while (begin < end) {
			int temp = pairs[begin].number + pairs[end].number;
			if (temp < target) {
				begin++;
			} else if (temp > target) {
				end--;
			} else {
				result[0] = pairs[begin].idx;
				result[1] = pairs[end].idx;
				break;
			}

		}
		if (DEBUG) {
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i] + " ");
			}
		}
		return result;
	}

	class Pair implements Comparable<Pair> {
		public int number;
		public int idx;

		public Pair(int number, int idx) {
			this.number = number;
			this.idx = idx;
		}

		public int compareTo(Pair other) {
			return this.number - other.number;
		}
	}

	public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();
		int[] arr = { 3, 2, 4 };
		// twoSum.twoSum(arr, 0);
		twoSum.twoSumByArray(arr, 6);
	}
}

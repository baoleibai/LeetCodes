import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	private static boolean DEBUG = true;

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
		int[] res = new int[2];
		for (int i = 0; i < nums.length; ++i) {
			if (m.containsKey(target - nums[i])) {
				res[0] = i;
				res[1] = m.get(target - nums[i]);
				break;
			}
			m.put(nums[i], i);
		}
		return res;
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
		int[] arr = { 0, 4, 3, 0 };
		twoSum.twoSum(arr, 0);
	}
}

import com.sun.swing.internal.plaf.metal.resources.metal;

/**
 * 
 * @author baibaolei
 *
 */
public class MedianOfTwoSortedArray {

	public double findMedianSortedArrays(int[] A1, int[] A2) {
		int m = A1.length, n = A2.length;
		int medianLeft = (m + n + 1) / 2, medianRigth = (m + n + 2) / 2;
		if ((m + n) % 2 == 0) {
			return (findKth(A1, 0, m, A2, 0, n, medianLeft) + findKth(A1, 0, m, A2, 0, n, medianRigth)) / 2;
		} else {
			return findKth(A1, 0, m, A2, 0, n, medianLeft);
		}
	}

	private double findKth(int[] A1, int s1, int m, int[] A2, int s2, int n, int k) {
		if (m > n) {
			// 确保左侧的数组长度比右侧的小。为什么要这么做呢？
			// 因为A1和A2都有可能是长度小的那个。如果不换的话，m==0时和n==0时都需要判断。加上数组长度小的放在左侧可以少一个判断
			return findKth(A2, s2, n, A1, s1, m, k);
		}
		if (m == 0) {
			// 左侧数组为空，因为都是有序数组，所以Kth就是A2的s2+k-1。
			return A2[s2 + k - 1];
		}
		if (k == 1) {
			//仅剩一个元素就是要查找的k元素，从两个数组中找最小的那个。
			return Math.min(A1[s1], A2[s2]);
		}
		// 为什么要用k/2呢，下面会解释。
		int midLeft = Math.min(m, k / 2), midRight = Math.min(n, k / 2);
		/**
		 * 因为A1和A2都为有序数组，而我们现在要找到A1和A2合并到一起后的有序数组A的第K个值(如果index从0开始，index为K-1的值)。
		 * 如果(A1[s1 + midLeft - 1] < A2[s2 + midRight - 1])为TRUE？表示A1[s1+midLeft
		 * -1]向左侧的midLeft个元素一定比在A数组的K元素小，所以
		 * 我们将A1的左侧数组的S1+midLeft元素移除，并将K更新为K-midLeft，再次进行查询。 反之亦然。
		 */
		/**
		 * We have two arrays:
		 * nums1[0], nums1[1]....nums1[m - 1];
		 * nums2[0], nums2[2]....nums2[n - 1];
		 * the result after merging:
		 * num[0],num[1],num[2]...num[m + n - 1];
		 * Let‘s compare nums1[k / 2 - 1] and nums2[k / 2 - 1]
		 * if nums1[k / 2 - 1] < nums2 [k / 2 - 1]
		 * then the nums1[k / 2 - 1] and it's left side elements must smaller than kth number in num arrary(num[k - 1]). 
		 */
		if (A1[s1 + midLeft - 1] < A2[s2 + midRight - 1]) {
			return findKth(A1, s1 + midLeft, m - midLeft, A2, s2, n, k - midLeft);
		} else {
			return findKth(A1, s1, m, A2, s2 + midRight, n - midRight, k - midRight);
		}
	}
	
	public double findMedianSortedArraysMyOwn(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 ==null || (nums1.length == 0 && nums2.length==0)) {
			return 0.0;
		}
		int N = nums1.length + nums2.length;
		
		//偶数数组
		if (N%2 == 0) { 
			return (findKthMyOwn(nums1, 0, nums1.length, nums2, 0, nums2.length, (N + 1)/2)
					+ findKthMyOwn(nums1, 0, nums1.length, nums2, 0, nums2.length, (N + 2)/2)) / 2.0;
		} else {
			return findKthMyOwn(nums1, 0, nums1.length, nums2, 0, nums2.length, (N + 1)/2);
		}
	}
	
	/**
	 * find the K -1 th element int the combined sorted array of a1 and b1
	 * @param a1
	 * @param a1Start
	 * @param a1SizeLeft
	 * @param b1
	 * @param b1Start
	 * @param b1SizeLeft
	 * @param remainingK
	 * @return
	 */
	private int findKthMyOwn(int[] a1, int a1Start, int a1SizeLeft, int[] b1, int b1Start, int b1SizeLeft, int remainingK) {
		if (b1SizeLeft < a1SizeLeft) {
			return findKthMyOwn(b1, b1Start, b1SizeLeft, a1, a1Start, a1SizeLeft, remainingK);
		}
		if (a1SizeLeft == 0) {
			return b1[b1Start + remainingK -1];
		}
		if (remainingK == 1) {
			return Math.min(a1[a1Start], b1[b1Start]);
		}
		
		int a1mid = Math.min(a1SizeLeft, remainingK/2), b1mid = Math.min(b1SizeLeft, remainingK/2);
		
		if (a1[a1Start + a1mid - 1] < b1[b1Start + b1mid - 1]) {
			return findKthMyOwn(a1, a1Start + remainingK/2, a1SizeLeft - remainingK/2, b1, b1Start, b1SizeLeft, remainingK - remainingK/2);
		} else {
			return findKthMyOwn(a1, a1Start, a1SizeLeft, b1, b1Start  + remainingK/2, b1SizeLeft  - remainingK/2, remainingK - remainingK/2);
		}
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 3 };
		int[] nums2 = { 2 };
		MedianOfTwoSortedArray medianOfTwoSubstring = new MedianOfTwoSortedArray();
		medianOfTwoSubstring.findMedianSortedArrays(nums1, nums2);
		medianOfTwoSubstring.findMedianSortedArraysMyOwn(nums1, nums2);
	}
}

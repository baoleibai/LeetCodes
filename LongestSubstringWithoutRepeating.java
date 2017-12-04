import java.util.Arrays;
import java.util.HashMap;

public class LongestSubstringWithoutRepeating {

	/**
	 * Given a string, find the length of the longest substring without repeating
	 * characters. Examples: Given "abcabcbb", the answer is "abc", which the length
	 * is 3. Given "bbbbb", the answer is "b", with the length of 1. Given "pwwkew",
	 * the answer is "wke", with the length of 3. Note that the answer must be a
	 * substring, "pwke" is a subsequence and not a substring.
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0) {
			return 0;
		}
		HashMap<Character, Integer> hashMap = new HashMap();
		int maxLength = 0;
		for (int index = 0, start = 0; index < s.length(); index++) {
			if (hashMap.containsKey(s.charAt(index))) {
				// 使用max方法的理由：例如abba的情况，应该从最右侧的即index最大的重复位置计算新的maxLength，
				start = Math.max(start, hashMap.get(s.charAt(index)) + 1);
			}
			hashMap.put(s.charAt(index), index);
			maxLength = Math.max(maxLength, index - start + 1);
		}
		return maxLength;
	}

	/**
	 * 快速的方案
	 * ASCII表的码用10进制整数表示时最大的值是129,最小值是0(NULL)
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstringFastest(String s) {
		int maxLength = 0;
		int[] map = new int[256];
		Arrays.fill(map, -1);
		char[] sc = s.toCharArray();
		int head = 0;
		for (int index = 0; index < sc.length; index++) {
			//只要是非空的字符，都比0大
			//map[sc[index]]：sc[index]是char字符的整数形式，map[sc[index]]记录的是上次相同字符出现的index。
			//map[sc[index]]>=head表示在新的index出现的char在数组map[sc[index]]中是在head后面的位置重复，更新head。
			if (map[sc[index]] >= head) {//2层含义：1，出现了重复字符；2，且重复字符的位置在当前head后面
				head = map[sc[index]] + 1;//将head从出现重复字符的位置向后移动一位
			}
			//map[sc[index]]记录的是上次相同字符出现的位置。
			map[sc[index]] = index;
			maxLength = Math.max(maxLength, index - head + 1);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringWithoutRepeating as = new LongestSubstringWithoutRepeating();
		System.out.println(" " + as.lengthOfLongestSubstring("pwwkew"));
		System.out.println(" " + as.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(" " + as.lengthOfLongestSubstring("abba"));
	}
}

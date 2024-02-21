package org.example;

import java.util.*;

public class Solutions {
  // Swaps
  static int[] buildArray(int[] nums) {
    aPermutation(nums,0);

    return nums;
  }
  static void aPermutation(int[] nums,int start){
    if(start < nums.length){
      int tempo = nums[start];
      int result = nums[tempo];
      aPermutation(nums,start+1);
      nums[start] = result;
    }
  }

  // Split
  static String defangIPaddr(String adress) {
    return adress.replace(".", "[.]");
  }

  // Max achievable
  static int theMaximumAchievableX(int num, int t) {
    return num + (t * 2);
  }

  // Pairs
  static int numIdenticalPairs(int[] nums) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int ans = 0;

    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        ans += map.get(nums[i]);
        map.replace(nums[i], map.get(nums[i]) + 1);
      } else {
        map.put(nums[i], 1);
      }
    }

    return ans;
  }

  // Sum of two
  static public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement) && map.get(complement) != i) {
        return new int[] { i, map.get(complement) };
      }
    }
    // In case there is no solution, we'll just return null
    return null;
  }

  // https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
  static public int finalValueAfterOperations(String[] operations) {
    int ans = 0;
    for (String item: operations) {
      if (item.contains("--")) {
        ans--;
      } else {
        ans++;
      }
    }
    return ans;
  }

  //https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
  static public int minPartitions(String n) {
    //    int max = 0;
//    for (char item: n.toCharArray()) {
//      if (item > max) {
//        max = item;
//        if (max == 57) {
//          return 9;
//        }
//      }
//    }
//    return max - 48; 94 65

    for (int i = 9; i > 0; --i) {
      if (n.contains(Integer.toString(i))) {
        return i;
      }
    }
    return 0;
  }

  //convertTemperature
  static public double[] convertTemperature(double celsius) {
    return new double[]{celsius +273.15d, celsius * 1.8d + 32.00d};
  }

  // Palindrome Number
  // https://leetcode.com/problems/palindrome-number/solutions/3213890/fastest-java-solution/
  public static int getIntLen(long number) {
    return (int)Math.log10(number) + 1;
  }

  public static long getNumByIndex(long number, int index) {
    int len = getIntLen(number);
    if (len < index || index < 1) {
      return -1;
    }
    if (number == 0) {
      return 1;
    }
    return number / (long)Math.pow(10.0, index - 1) % 10;
  }

  // Number palindrome check

  static public boolean isIntPalindromeWithoutConverting(long number) {
    if (number < 0) {
      return false;
    }

    if (getIntLen(number) == 2) {
      if (number / 10 == number % 10) {
        return true;
      } else {
        return false;
      }
    }

    int len = getIntLen(number);
    for (int i = 1; i <= ((len % 2 == 1)? len / 2 + 1: len / 2); i++) {
      if (getNumByIndex(number, i) != getNumByIndex(number, len - i + 1)) {
        return false;
      }
    }
    return true;
  }

  static public boolean isIntPalindromeToString(int number) {
    String string = String.valueOf(number);
    int str_len = string.length();
    for (int i = 0; i < str_len / 2; i++) {
      if (string.charAt(i) != string.charAt(str_len - i - 1)) {
        return false;
      }
    }
    return true;
  }

  static public boolean isIntPalindromeIdeal(int number) {
    if (number < 0 || (number != 0 && number % 10 == 0)) {
      return false;
    }
    int reverse = 0;

    // Mirroring the number till middle.
    while (number > reverse) {
      // Move to add another digit of number and then adding a digit of number to reverse.
      reverse = reverse * 10 + number % 10;
      number /= 10;
    }

    return (number == reverse || number == reverse / 10);
  }

  static public boolean lastPalindrome(int number) {
    String str = Integer.toString(number);
    StringBuffer reversed_str_buf = new StringBuffer(str);
    reversed_str_buf.reverse();
    String s = reversed_str_buf.toString();
    if(str.equals(s)){
      return true;
    }
    return false;
  }

  //shuffle
  static public int[] shuffle(int[] nums, int n) {
    int[] ans = new int[n*2];
    for (int i = 0; i < n; ++i) {
      ans[i*2] = nums[i];
      ans[(i*2) + 1] = nums[i+n];
    }
    return ans;
  }

  // Jevels
  static public int numJewelsInStones(String jewels, String stones) {
    char[] jew = jewels.toCharArray();
    Map<Integer, Character> map = new HashMap<Integer, Character>();
    for (int i = 0; i < jew.length; i++) {
      map.put(i, jew[i]);
    }

    char[] sto = stones.toCharArray();

    int ans = 0;
    for (int i = 0; i < sto.length; i++) {
      if (map.containsValue(sto[i])) {
        ans++;
      }
    }

    return ans;
  }

  // Find words containing char
  static public List<Integer> findWordsContaining(String[] words, char x) {
    List<Integer> ans_list = new ArrayList<>();
    for (int i = 0; i < words.length; i++) {
      if (words[i].contains(Character.toString(x))) {
        ans_list.add(i);
      }
    }
    return ans_list;
  }

  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  static public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode root = new ListNode(0);
    ListNode working_node = root;
    int memo = 0;
    while (l1 != null || l2 != null || memo != 0) {
      if (l1 != null && l2 != null) {
        int sum = l1.val + l2.val;
        memo = (working_node.val + sum) / 10;
        working_node.val = (working_node.val + sum) % 10;
        l1 = l1.next;
        l2 = l2.next;
      } else if (l1 != null) {
        memo = (working_node.val + l1.val) / 10;
        working_node.val = (working_node.val + l1.val) % 10;;
        l1 = l1.next;
      } else if (l2 != null) {
        memo = (working_node.val + l2.val) / 10;
        working_node.val = (working_node.val + l2.val) % 10;
        l2 = l2.next;
      } else if (memo != 0) {
        working_node.val = memo;
        return root;
      }
      if (l1 != null || l2 != null || memo != 0) {
        working_node.next = new ListNode(memo);
        working_node = working_node.next;
      }
    }
    return root;
  }

  public static int lengthOfLongestSubstring(String s) {
    int len = s.length();
    int max_len = 0;

    Map<Character, Integer> map = new HashMap<Character, Integer>();

    int left = 0;

    for (int right = 0; right < len; right++) {
      if ((!map.containsKey(s.charAt(right))) || (map.get(s.charAt(right)) < left)) {
        map.put(s.charAt(right), right);
        max_len = Math.max(max_len, right - left + 1);
      } else {
        left = map.get(s.charAt(right)) + 1;
        map.put(s.charAt(right), right);
      }
    }

    return max_len;
  }

  public static int reverseInt(int x) {
    boolean sign = true;
    if (x < 0) {
      x *= -1;
      sign = false;
    }
    int reverse = 0;
    while (x > 0) {
      int tempo = x % 10;
      x = x / 10;

      if ((reverse > Integer.MAX_VALUE/10)) {
        return 0;
      }
      if ((reverse < Integer.MIN_VALUE/10)) {
        return 0;
      }

      reverse = reverse * 10 + tempo;
    }

    return sign ? reverse:reverse * (-1);
  }

  // https://leetcode.com/problems/contains-duplicate/
  static public boolean containsDuplicate(int[] nums) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    for (int item: nums) {
      if (!map.containsKey(item)) {
        map.put(item, 1);
      } else {
        return true;
      }
    }

    return false;
  }

  // https://leetcode.com/problems/valid-anagram/
  static public boolean isAnagram(String s, String t) {
    HashMap<Character, Integer> s_map = new HashMap<Character, Integer>();
    HashMap<Character, Integer> t_map = new HashMap<Character, Integer>();

    for (int i = 0; i < s.length(); i++) {
      if (s_map.containsKey(s.charAt(i))) {
        s_map.put(s.charAt(i), s_map.get(s.charAt(i)) + 1);
      } else {
        s_map.put(s.charAt(i), 1);
      }
    }

    for (int i = 0; i < t.length(); i++) {
      if (t_map.containsKey(t.charAt(i))) {
        t_map.put(t.charAt(i), t_map.get(t.charAt(i)) + 1);
      } else {
        t_map.put(t.charAt(i), 1);
      }
    }

    return s_map.equals(t_map);
  }

  // https://leetcode.com/problems/group-anagrams/
  static public List<List<String>> groupAnagrams(String[] strs) {
    List<HashMap<Character, Integer>> maps = new ArrayList<HashMap<Character, Integer>>();

    for (int i = 0; i < strs.length; i++) {
      maps.add(new HashMap<Character, Integer>());
      for (int j = 0; j < strs[i].length(); j++) {
        maps.get(i).put(strs[i].charAt(j), maps.get(i).getOrDefault(strs[i].charAt(j), 1));
      }
    }
    List<List<String>> ans = new ArrayList<List<String>>();

    Set<HashMap<Character, Integer>> set = new HashSet<HashMap<Character, Integer>>(maps);


    return ans;
  }
}


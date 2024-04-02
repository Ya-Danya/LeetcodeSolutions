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

  static public boolean isAnagramCharArr(String s, String t) {
    char[] first = s.toCharArray();
    Arrays.sort(first);

    char[] second = t.toCharArray();
    Arrays.sort(second);

    return Arrays.equals(first, second);
  }

  // https://leetcode.com/problems/group-anagrams/
  static public List<List<String>> groupAnagrams(String[] strs) {

    // map  |palindrome chars         |  palindromes |
    HashMap<HashMap<Character, Integer>, List<String>> ans_map = new HashMap<>();

    for (int i = 0; i < strs.length; i++) {
      HashMap<Character, Integer> map = new HashMap<Character, Integer>();

      for (int j = 0; j < strs[i].length(); j++) {
        if (map.containsKey(strs[i].charAt(j))) {
          map.put(strs[i].charAt(j), map.get(strs[i].charAt(j)) + 1);
        } else {
          map.put(strs[i].charAt(j), 1);
        }
      }

      if (!ans_map.containsKey(map)) {
        ans_map.put(map, new ArrayList<>());
      }
      ans_map.get(map).add(strs[i]);
    }

    return new ArrayList<>(ans_map.values());
  }

  static public List<List<String>> groupAnagramsCharArr(String[] strs) {
    HashMap<String, List<String>> map = new HashMap<>();

    for (String word: strs) {
      char[] char_word = word.toCharArray();
      Arrays.sort(char_word);
      String sorted_word = new String(char_word);

      if (!map.containsKey(sorted_word)) {
        map.put(sorted_word, new ArrayList<>());
      }

      map.get(sorted_word).add(sorted_word);
    }

    return new ArrayList<>(map.values());
  }


  public static boolean checkCol(char[][] board, int row, int col) {
    char val = board[row][col];
    for (int i = 0; i < 9; i++) {
      if ((board[i][col] == val) && (i != row)) {
        return false;
      }
    }
    return true;
  }

  public static boolean checkRow(char[][] board, int row, int col) {
    char val = board[row][col];
    for (int i = 0; i < 9; i++) {
      if ((board[row][i] == val) && (i != col)) {
        return false;
      }
    }
    return true;
  }



  public static boolean checkSector(char[][] board, int row, int col) {
    char val = board[row][col];

    int sector_row = row / 3, sector_col = col / 3;

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if ((board[i + (sector_row * 3)][j + (sector_col * 3)] == val) &&
                (i + (sector_row * 3) != row) && (j + (sector_col * 3) != col)) {
          return false;
        }
      }
    }

    return true;
  }
  static public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != '.') {
          if (!((checkCol(board, i, j)) && checkRow(board, i, j) && checkSector(board, i, j))) {
            return false;
          }
        }
      }
    }

    return true;
  }


  // https://leetcode.com/problems/top-k-frequent-elements/description/
  public static int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> frequencies = new HashMap<>();
    List<Integer>[] frequencies_with_keys = new List[nums.length + 1];

    for (int num : nums) {
      if (!frequencies.containsKey(num)) {
        frequencies.put(num, 1);
      } else {
        frequencies.put(num, frequencies.get(num) + 1);
      }
    }

    for (int key: frequencies.keySet()) {
      int frequency = frequencies.get(key);
      if (frequencies_with_keys[frequency] == null) {
        frequencies_with_keys[frequency] = new ArrayList<>();
      }
      frequencies_with_keys[frequency].add(key);
    }

    int[] ans = new int[k];
    int index = k;

    for (int i = frequencies_with_keys.length - 1; i >= 0; i--) {
      if (frequencies_with_keys[i] != null) {
        List<Integer> list = frequencies_with_keys[i];
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        int size = array.length;

        // Переносим элементы из array в ans, уменьшая index
        for (int j = size - 1; j >= 0 && index > 0; j--) {
          ans[--index] = array[j];
        }
      }
    }

    return ans;
  }

  // https://leetcode.com/problems/product-of-array-except-self/
  public static int[] productExceptSelf(int[] nums) {
    int[] prefix_mult = new int[nums.length];
    int[] suffix_mult = new int[nums.length];

    prefix_mult[0] = 0;
    prefix_mult[1] = nums[0];
    for (int i = 2; i < nums.length; i++) {
      prefix_mult[i] = prefix_mult[i - 1] * nums[i - 1];
    }

    suffix_mult[suffix_mult.length - 1] = 0;
    suffix_mult[suffix_mult.length - 2] = nums[nums.length - 1];
    for (int i = nums.length - 3; i > -1; i--) {
      suffix_mult[i] = suffix_mult[i + 1] * nums[i + 1];
    }

    int[] ans = new int[nums.length];
    ans[0] = suffix_mult[0];
    ans[ans.length - 1] = prefix_mult[prefix_mult.length - 1];

    for (int i = 1; i < nums.length - 1; i++) {
      ans[i] = prefix_mult[i] * suffix_mult[i];
    }

    return ans;
  }


  // https://leetcode.com/problems/longest-consecutive-sequence/
  public static int longestConsecutive(int[] nums) {

    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return 1;
    }
    Arrays.sort(nums);

    int max = 0;
    int local_max = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] + 1 == nums[i + 1]) {
        local_max++;
      } else if (nums[i] == nums[i + 1]) {

      } else if((max <= local_max)) {
        max = local_max;
        local_max = 0;
      } else {
        local_max = 0;
      }
    }

    if (max < local_max) {
      return local_max + 1;
    } else {
      return max + 1;
    }
  }

  //https://leetcode.com/problems/valid-parentheses/description/
  static public boolean isValid(String s) {
    if (s.length() % 2 != 0) {
      return false;
    }

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char new_char = s.charAt(i);
      if (!stack.empty()) {
        char peek_char = stack.peek();
        if ((new_char - peek_char == 1) || (new_char - peek_char == 2)) {
          stack.pop();
        } else {
          stack.add(new_char);
        }
      } else {
        stack.add(new_char);
      }
    }

    return stack.empty();
  }

  public static boolean isValidAlter(String s) {
    Stack<Character> stack = new Stack<>();

    for (char character: s.toCharArray()) {
      if (character == '(') {
        stack.push(')');
      } else if (character == '{') {
        stack.push('}');
      } else if (character == '[') {
        stack.push(']');
      } else if (stack.isEmpty() || stack.pop() != character) {
        return false;
      }
    }

    return stack.isEmpty();
  }

  // https://leetcode.com/problems/min-stack/submissions/1186776133/
  class Pair {
    int value, minVal;
    Pair(int value, int minVal) {
      this.value = value;
      this.minVal = minVal;
    }
  }
  class MinStack {
    Stack<Pair> stack;
    public MinStack() {
      stack = new Stack<>();
    }

    public void push(int val) {
      if (stack.isEmpty()) {
        stack.push(new Pair(val, val));
      } else  {
        stack.push(new Pair(val, Math.min(stack.peek().minVal, val)));
      }
    }

    public void pop() {
      stack.pop();
    }

    public int top() {
      return stack.peek().value;
    }

    public int getMin() {
      return stack.peek().minVal;
    }
  }

  public int[] dailyTemperatures(int[] temperatures) {


    return new int[]{1};
  }
}

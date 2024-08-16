package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionsTest {
  static class TwoSumTest{
    @Test
    public void resultInBeginning() {
      int[] nums = {2,7,11,15};
      int target = 9;
      assertArrayEquals(Solutions.twoSum(nums, target), new int[]{0,1});
    }
    @Test
    public void resultInEnding() {
      int[] nums = {3,2,4};
      int target = 6;
      assertArrayEquals(Solutions.twoSum(nums, target), new int[]{1,2});
    }
    @Test
    public void repeatingNumbers() {
      int[] nums = {3,3};
      int target = 6;
      assertArrayEquals(Solutions.twoSum(nums, target), new int[]{0,1});
    }

    @Test
    public void noSuchAValue() {
      int[] nums = {1,2,3,4,5};
      int target = 0;
      assertArrayEquals(Solutions.twoSum(nums, target), null);
    }
  }

  static class PermutationArrayTest{
    @Test
    public void ordinaryCase1() {
      int[] nums = {0,2,1,5,3,4};
      int[] ans = {0,1,2,4,5,3};
      assertArrayEquals(Solutions.buildArray(nums), ans);
    }

    @Test
    public void ordinaryCase2() {
      int[] nums = {5,0,1,2,3,4};
      int[] ans = {4,5,0,1,2,3};
      assertArrayEquals(Solutions.buildArray(nums), ans);
    }

    @Test
    public void emptyArrayCase() {
      int[] nums = {};
      int[] ans = {};
      assertArrayEquals(Solutions.buildArray(nums), ans);
    }

    @Test
    public void theOnlyElemCase() {
      int[] nums = {0};
      int[] ans = {0};
      assertArrayEquals(Solutions.buildArray(nums), ans);
    }
  }

  public static class MaxAchievableTest{
    @Test
    public void casualTest1() {
      int num = 4;
      int t = 1;
      int ans = 6;
      assertEquals(Solutions.theMaximumAchievableX(num, t), ans);
    }

    @Test
    public void casualTest2() {
      int num = 3;
      int t = 2;
      int ans = 7;
      assertEquals(Solutions.theMaximumAchievableX(num, t), ans);
    }
  }
  public static class DefangingIPAddressTest {
    @Test
    public void simpleTest() {
      String address = "1.1.1.1";
      String ans = "1[.]1[.]1[.]1";
      assertEquals(Solutions.defangingIPAddress(address), ans);
    }

    @Test
    public void casualTest() {
      String address = "255.100.50.0";
      String ans = "255[.]100[.]50[.]0";
      assertEquals(Solutions.defangingIPAddress(address), ans);
    }
  }

  static class MaxWidthOfVerticalAreaTest{
    @Test
    public void example() {
      int[][] points = new int[][]{{3,1},{9,0},{1,0},{1,4},{5,3},{8,8}};

      assertEquals(Solutions.maxWidthOfVerticalArea(points), 3);
    }

    @Test
    public void exampleTwo() {
      int[][] points = new int[][]{{8,7},{9,9},{7,4},{9,7}};

      assertEquals(Solutions.maxWidthOfVerticalArea(points), 1);
    }
  }

  static class WeatherTest{
    @Test
    public void basicCase() {
      int[] forecast = {73,74,75,71,69,72,76,73};
      assertArrayEquals(Solutions.dailyTemperatures(forecast), new int[] {1, 1, 4, 2, 1, 1, 0, 0});
    }
  }

  static class StringPalindromeTest{
    @Test
    public void basicTest() {
      String st = "0P";
      assertEquals(Solutions.isPalindrome(st), false);
    }

  }

  static class IsPalindromeOptimizedTest {
    @Test
    public void basicTest() {
      String str = "asSsa";
      assertTrue(Solutions.isPalindromeOptimized(str));
    }
    @Test
    public void raceACar() {
      String str = "race a car";
      assertFalse(Solutions.isPalindromeOptimized(str));
    }

    @Test
    public void zeroP() {
      String str = "0P";
      assertFalse(Solutions.isPalindromeOptimized(str));
    }
  }

  static class GenerateParenthesesTest{
    @Test
    void test() {
      List<String> ans = new ArrayList<>();
      ans.add("((()))");
      ans.add("(()())");
      ans.add("(())()");
      ans.add("()(())");
      ans.add("()()()");
      assertEquals(Solutions.generateParentheses(3), ans);
    }
  }

  static class EvalRPNTest{
    @Test
    void test() {
      String[] tokens = new String[]{"2","1","+","3","*"};
//      System.out.println((int)'*');
//      System.out.println((int)'/');
//      System.out.println((int)'-');
//      System.out.println((int)'+');
      assertEquals(Solutions.evalRPN(tokens), 9);
    }
    @Test
    void test2() {
      String[] tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

      assertEquals(Solutions.evalRPN(tokens), 22);
    }
  }


  static class CarFleetTest{
    @Test
    void test0() {
      int target = 12;
      int[] pos = {10,8,0,5,3};
      int[] speed = {2,4,1,1,3};

      assertEquals(Solutions.carFleet(target, pos, speed), 3);
    }

    @Test
    void test1() {
      int target = 10;
      int[] pos = {3};
      int[] speed = {3};

      assertEquals(Solutions.carFleet(target, pos, speed), 1);
    }

    @Test
    void test2() {
      int target = 100;
      int[] pos = {0,2,4};
      int[] speed = {4,2,1};

      assertEquals(Solutions.carFleet(target, pos, speed), 1);
    }

    @Test
    void test3() {
      int target = 10;
      int[] pos = {8,3,7,4,6,5};
      int[] speed = {4,4,4,4,4,4};

      assertEquals(Solutions.carFleet(target, pos, speed), 6);
    }
  }

  static class LargestRectTests{
    @Test
    void increasingSeq() {
      int[] seq = new int[] {1,2,3,4};

      assertEquals(Solutions.largestRectangleArea(seq), 6);
    }

    @Test
    void increasingDecreasingSeq() {
      int[] seq = new int[] {1,2,3,4,3,2,1};

      assertEquals(Solutions.largestRectangleArea(seq), 10);
    }

    @Test
    void example1(){
      int[] seq = new int[] {2,1,5,6,2,3};

      assertEquals(Solutions.largestRectangleArea(seq), 10);
    }

    @Test
    void example2(){
      int[] seq = new int[] {2,4};

      assertEquals(Solutions.largestRectangleArea(seq), 4);
    }

    @Test
    void twoHeightsDeq(){
      int[] seq = new int[] {2,2,2,2,2,1,1,1,1,1,1,1,1,1,1};

      assertEquals(Solutions.largestRectangleArea(seq), 15);
    }

    @Test
    void twoHeightsInc(){
      int[] seq = new int[] {1,1,1,1,1,1,1,1,1,1,2,2,2,2,2};

      assertEquals(Solutions.largestRectangleArea(seq), 15);
    }
    @Test
    void changingSameHeight(){
      int[] seq = new int[] {1,2,2,2,2,2,1,1,1,1,1,1,1,1,1,1};

      assertEquals(Solutions.largestRectangleArea(seq), 16);
    }
  }

  static class TwoSumSortedTest{
    @Test
    void test() {
      int[] arr = new int[] {2,7,11,15};
      int target = 9;
      assertArrayEquals(Solutions.twoSumSorted(arr, target), new int[] {1,2});
    }
  }

  static class TreeSumSortedTest{
    @Test
    void test() {
      int[] arr = new int[] {-1,0,1,2,-1,-4};
      List<List<Integer>> ans = new ArrayList<>();
      List<Integer> e1 = new ArrayList<>();
      e1.add(-1);
      e1.add(-1);
      e1.add(2);

      List<Integer> e2 = new ArrayList<>();
      e1.add(-1);
      e2.add(0);
      e2.add(1);

      ans.add(e1);
      ans.add(e2);

      assertEquals(Solutions.threeSum(arr), ans);
    }

    @Test
    void zeroes() {
      int[] arr = new int[] {0,0,0};
      List<List<Integer>> ans = new ArrayList<>();

      List<Integer> e1 = new ArrayList<>();
      e1.add(0);
      e1.add(0);
      e1.add(0);

      ans.add(e1);

      assertEquals(Solutions.threeSum(arr), ans);
    }
  }

  static class BinSearchTests{
    @Test
    void casual() {
      int[] arr = {1,2,3,4,5,6,7,8,9,10};

      assertEquals(Solutions.binSearch(arr, 8), 7);
    }

    @Test
    void casual2() {
      int[] arr = {1,2,3,4,5,6,7,8,9,10};

      assertEquals(Solutions.binSearch(arr, 6), 5);
    }

    @Test
    void casual3() {
      int[] arr = {1,2,3,4,5,6,7,8,9,10};

      assertEquals(Solutions.binSearch(arr, 10), 9);
    }

    @Test
    void casual4() {
      int[] arr = {-1,0,3,5,9,12};

      assertEquals(Solutions.binSearch(arr, 9), 4);
    }

    @Test
    void casual5() {
      int[] arr = {-1,0,3,5,9,12};

      assertEquals(Solutions.binSearch(arr, 2), -1);
    }

    @Test
    void casual6() {
      int[] arr = {-1,0,3,5,9,12};

      assertEquals(Solutions.binSearch(arr, 13), -1);
    }
  }

  static class BinSearchMatrixTests{
    @Test
    void casual() {
      int[][] arr = {{0,1,2,3},{4,5,6,7},{8,9,10,11}};

      assertTrue(Solutions.searchMatrix(arr, 5));
    }

    @Test
    void casual2() {
      int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};

      assertTrue(Solutions.searchMatrix(arr, 3));
    }
  }

  static class MaxProfitTest{
    @Test
    void casual() {
      int[] prices = {7,1,5,3,6,4};

      assertEquals(Solutions.maxProfit(prices), 5);
    }

    @Test
    void casual2() {
      int[] prices = {7,6,4,3,1};

      assertEquals(Solutions.maxProfit(prices), 0);
    }
  }

  static class ReverseLinkedListTests {
    @Test
    void test1 () {
      Solutions.ListNode node4 = new Solutions.ListNode(5);
      Solutions.ListNode node3 = new Solutions.ListNode(4, node4);
      Solutions.ListNode node2 = new Solutions.ListNode(3, node3);
      Solutions.ListNode node1 = new Solutions.ListNode(2, node2);
      Solutions.ListNode head = new Solutions.ListNode(1, node1);

      Solutions.ListNode ans_node4 = new Solutions.ListNode(1);
      Solutions.ListNode ans_node3 = new Solutions.ListNode(2, ans_node4);
      Solutions.ListNode ans_node2 = new Solutions.ListNode(3, ans_node3);
      Solutions.ListNode ans_node1 = new Solutions.ListNode(4, ans_node2);
      Solutions.ListNode ans_head = new Solutions.ListNode(5, ans_node1);


      assertEquals(Solutions.reverseList(head), ans_head);
    }
  }

  static class MergeTwoLinkedListsTests {
    @Test
    void test1 () {
      Solutions.ListNode first_node2 = new Solutions.ListNode(4);
      Solutions.ListNode first_node1 = new Solutions.ListNode(2, first_node2);
      Solutions.ListNode first_head = new Solutions.ListNode(1, first_node1);

      Solutions.ListNode second_node2 = new Solutions.ListNode(4);
      Solutions.ListNode second_node1 = new Solutions.ListNode(3, second_node2);
      Solutions.ListNode second_head = new Solutions.ListNode(1, second_node1);

      Solutions.ListNode ans_node5 = new Solutions.ListNode(4);
      Solutions.ListNode ans_node4 = new Solutions.ListNode(4, ans_node5);
      Solutions.ListNode ans_node3 = new Solutions.ListNode(3, ans_node4);
      Solutions.ListNode ans_node2 = new Solutions.ListNode(2, ans_node3);
      Solutions.ListNode ans_node1 = new Solutions.ListNode(1, ans_node2);
      Solutions.ListNode ans_head = new Solutions.ListNode(1, ans_node1);


      Solutions.ListNode res = Solutions.mergeTwoLists(first_head, second_head);
      assertEquals(res, ans_head);
    }

    @Test
    void emptyTest() {

      Solutions.ListNode first_head = new Solutions.ListNode();
      first_head.next = null;


      Solutions.ListNode second_head = new Solutions.ListNode();
      second_head.next = null;

      Solutions.ListNode ans_head = new Solutions.ListNode();
      ans_head.next = null;

      Solutions.ListNode res = Solutions.mergeTwoLists(first_head, second_head);
      assertEquals(res, ans_head);
    }

    @Test
    void lengthOneTest() {

      Solutions.ListNode first_head = new Solutions.ListNode(2, null);


      Solutions.ListNode second_head = new Solutions.ListNode(1,null);

      Solutions.ListNode ans_node1 = new Solutions.ListNode(2, null);
      Solutions.ListNode ans_head = new Solutions.ListNode(1,ans_node1);


      Solutions.ListNode res = Solutions.mergeTwoLists(first_head, second_head);
      assertEquals(res, ans_head);
    }
  }

  static class MaxWaterContainerTest{
    @Test
    void test1() {
      int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};

      assertEquals(Solutions.maxArea(heights), 49);
    }
  }

  static class RemoveNthFromEndTest{
    @Test
    void fromZeroToTen() {
      Solutions.ListNode head = new Solutions.ListNode(0, null);

      Solutions.ListNode cur = head;
      for (int i = 1; i < 10; i++) {
        cur.next = new Solutions.ListNode(i, null);
        cur = cur.next;
      }

      Solutions.removeNthFromEnd(head, 1);
      System.out.println("ads");
    }
  }

  static class ReorderListTests{
    @Test
    void fromZeroToNine() {
      Solutions.ListNode node8 = new Solutions.ListNode(9, null);
      Solutions.ListNode node7 = new Solutions.ListNode(8, node8);
      Solutions.ListNode node6 = new Solutions.ListNode(7, node7);
      Solutions.ListNode node5 = new Solutions.ListNode(6, node6);
      Solutions.ListNode node4 = new Solutions.ListNode(5, node5);
      Solutions.ListNode node3 = new Solutions.ListNode(4, node4);
      Solutions.ListNode node2 = new Solutions.ListNode(3, node3);
      Solutions.ListNode node1 = new Solutions.ListNode(2, node2);
      Solutions.ListNode node0 = new Solutions.ListNode(1, node1);
      Solutions.ListNode head = new Solutions.ListNode(0, node0);

      Solutions.ListNode ans_node8 = new Solutions.ListNode(5, null);
      Solutions.ListNode ans_node7 = new Solutions.ListNode(4, ans_node8);
      Solutions.ListNode ans_node6 = new Solutions.ListNode(6, ans_node7);
      Solutions.ListNode ans_node5 = new Solutions.ListNode(3, ans_node6);
      Solutions.ListNode ans_node4 = new Solutions.ListNode(7, ans_node5);
      Solutions.ListNode ans_node3 = new Solutions.ListNode(2, ans_node4);
      Solutions.ListNode ans_node2 = new Solutions.ListNode(8, ans_node3);
      Solutions.ListNode ans_node1 = new Solutions.ListNode(1, ans_node2);
      Solutions.ListNode ans_node0 = new Solutions.ListNode(9, ans_node1);
      Solutions.ListNode ans_head = new Solutions.ListNode(0, ans_node0);

      Solutions.reorderList(head);
      assertEquals(head, ans_head);
    }

    @Test
    void fromZeroToTen() {
      Solutions.ListNode node9 = new Solutions.ListNode(10, null);
      Solutions.ListNode node8 = new Solutions.ListNode(9, node9);
      Solutions.ListNode node7 = new Solutions.ListNode(8, node8);
      Solutions.ListNode node6 = new Solutions.ListNode(7, node7);
      Solutions.ListNode node5 = new Solutions.ListNode(6, node6);
      Solutions.ListNode node4 = new Solutions.ListNode(5, node5);
      Solutions.ListNode node3 = new Solutions.ListNode(4, node4);
      Solutions.ListNode node2 = new Solutions.ListNode(3, node3);
      Solutions.ListNode node1 = new Solutions.ListNode(2, node2);
      Solutions.ListNode node0 = new Solutions.ListNode(1, node1);
      Solutions.ListNode head = new Solutions.ListNode(0, node0);

      Solutions.ListNode ans_node9 = new Solutions.ListNode(5, null);
      Solutions.ListNode ans_node8 = new Solutions.ListNode(6, ans_node9);
      Solutions.ListNode ans_node7 = new Solutions.ListNode(4, ans_node8);
      Solutions.ListNode ans_node6 = new Solutions.ListNode(7, ans_node7);
      Solutions.ListNode ans_node5 = new Solutions.ListNode(3, ans_node6);
      Solutions.ListNode ans_node4 = new Solutions.ListNode(8, ans_node5);
      Solutions.ListNode ans_node3 = new Solutions.ListNode(2, ans_node4);
      Solutions.ListNode ans_node2 = new Solutions.ListNode(9, ans_node3);
      Solutions.ListNode ans_node1 = new Solutions.ListNode(1, ans_node2);
      Solutions.ListNode ans_node0 = new Solutions.ListNode(10, ans_node1);
      Solutions.ListNode ans_head = new Solutions.ListNode(0, ans_node0);

      Solutions.reorderList(head);
      assertEquals(head, ans_head);
    }
  }
}
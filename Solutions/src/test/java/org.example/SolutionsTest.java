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

}
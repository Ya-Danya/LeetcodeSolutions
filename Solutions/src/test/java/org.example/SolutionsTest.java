package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionsTest {
  static class MaxWidthOfVerticalArea{
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
}
package darkRealm;

import java.util.Arrays;

public class AssignCookies {

//  Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie. Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.
//
//  Note:
//  You may assume the greed factor is always positive.
//  You cannot assign more than one cookie to one child.
//
//  Example 1:
//  Input: [1,2,3], [1,1]
//
//  Output: 1
//
//  Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
//  And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
//  You need to output 1.
//  Example 2:
//  Input: [1,2], [1,2,3]
//
//  Output: 2
//
//  Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
//  You have 3 cookies and their sizes are big enough to gratify all of the children,
//  You need to output 2.

  public static int assignCookies(int[] greedyFactor, int[] sizes) {
    if (null == greedyFactor || null == sizes) return 0;
    Arrays.sort(greedyFactor);
    Arrays.sort(sizes);
    int satisfied = 0;
    for (int i = 0, j = 0; i < greedyFactor.length && j < sizes.length; ) {
      while (j < sizes.length && sizes[j] < greedyFactor[i]) j++;
      if (j < sizes.length && sizes[j] >= greedyFactor[i]) {
        satisfied++;
        i++;
        j++;
      }
    }
    return satisfied;
  }

  public static void main(String[] args) {
//    int[] greedyFactor = new int[]{1, 2, 3};
//    int[] sizes = new int[]{1, 1};

//    int[] greedyFactor = new int[]{1, 2, 3, 4};
//    int[] sizes = new int[]{1, 1, 4};

//    int[] greedyFactor = new int[]{10, 9, 8, 7, 12, 11};
//    int[] sizes = new int[]{5, 6, 7, 8, 14, 13};

//    int[] sizes = new int[]{10, 9, 8, 7};
//    int[] greedyFactor = new int[]{5, 6, 7, 8};

    int[] greedyFactor = new int[]{10, 9, 8, 7};
    int[] sizes = new int[]{5, 6, 3, 6};

    int res = assignCookies(greedyFactor, sizes);
    System.out.println("G: " + Arrays.toString(greedyFactor));
    System.out.println("S: " + Arrays.toString(sizes));
    System.out.println("R: " + res);
  }
}
// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
  public static void main(String args[]) throws IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(read.readLine());
    while (t-- > 0) {
      String input[] = read.readLine().split(" ");
      String text = input[0];
      String pattern = input[1];
      Solution ob = new Solution();
      System.out.println(ob.search(text, pattern));
    }
  }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
  int search(String text, String pat) {
    int j = 0;
    int M = pat.length();
    int[] lps = new int[M];
    computeLPS(pat, lps);

    int i = 0;
    int N = text.length();
    while (i < N) {
      if (text.charAt(i) == pat.charAt(j)) {
        i++;
        j++;
      }
      if (j == M) {
        return 1;
      } else if (i < N && text.charAt(i) != pat.charAt(j)) {
        if (j > 0) {
          j = lps[j - 1];
        } else {
          i++;
        }
      }
    }
    return 0;
  }

  void computeLPS(String pat, int[] lps) {
    int i = 1;
    int len = 0;
    int N = pat.length();
    lps[0] = 0;
    while (i < N) {
      if (pat.charAt(i) == pat.charAt(len)) {
        lps[i++] = ++len;
      } else {
        if (len > 0) {
          len = lps[len - 1];
        } else {
          lps[i++] = 0;
        }
      }
    }
  }
}
;

package bloomberg.dynamicProgramming;

import java.util.Scanner;

public class LongestPalindromicSubsequence {
    public static String longestPalindrome(String s){
        if(s.length() <1 || s==null) return "";
        int start=0, end=0;
        for(int i =0;i<s.length();i++){
            int len1=expand(s, i, i);
            int len2=expand(s, i, i+1);
            int len= Math.max(len1,len2);
            if(len > end-start){
                start = i -(len-1)/2;
                end = i+len/2;
            }
        }
        return s.substring(start, end+1);
    }

    public static int expand(String s, int start, int end){
        if(s == null || start >end) return 0;
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end)){
            start--;
            end++;
        }
        return end-start-1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String result = longestPalindrome(str);
        System.out.println(result);
        scanner.close();
    }
}

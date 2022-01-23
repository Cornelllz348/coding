package leetcode;

public class P0058_Length_Of_Last_Word {
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        int count = 0;
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }
        while (index >= 0 && s.charAt(index) != ' ') {
            count++;
            index--;
        }
        return count;
    }
}
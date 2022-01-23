package leetcode;

public class P0043_Multiply_Strings {
	
    public static String multiply(String num1, String num2) {
    	if (num1.equals("0") || num2.equals("0")) return "0";
        if (num2.length() > num1.length()) {
        	return multiply(num2, num1);
        }
        String[] strs = new String[num2.length()];
        for (int i = num2.length() - 1; i >= 0; i--) {
        	int d1 = Character.getNumericValue(num2.charAt(i));
        	int carry = 0, d = 0, d2 = 0;
        	StringBuilder sb = new StringBuilder();
        	for (int j = num1.length() - 1; j >= 0; j--) {
        		d2 = Character.getNumericValue(num1.charAt(j));
        		d = (d1 * d2 + carry) % 10;
        		carry = (d1 * d2 + carry) / 10;
        		sb.append(Integer.toString(d));
        	}
        	if (carry > 0) sb.append(Integer.toString(carry));
        	sb = sb.reverse();
        	for (int j = 0; j < num2.length() - i - 1; j++) {
        		sb.append("0");
        	}
        	strs[num2.length() - i - 1] = sb.toString();
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
        	result = addTwoStrings(result, strs[i]);
        }
        return result;
    }
    
    public static String addTwoStrings(String num1, String num2) {
    	int carry = 0;
    	StringBuilder sb = new StringBuilder();
    	int l1 = num1.length(), l2 = num2.length();
    	for (int i = 0; i < l1 || i < l2; i++) {
    		int d1 = i < l1 ? Character.getNumericValue(num1.charAt(l1 - i - 1)) : 0;
    		int d2 = i < l2 ? Character.getNumericValue(num2.charAt(l2 - i - 1)) : 0;
    		int sum = d1 + d2 + carry;
    		carry = sum / 10;
    		sb.append(sum % 10);
    	}
    	if (carry > 0) {
    		sb.append(carry);
    	}
    	return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
    	String num1 = "1234";
    	String num2 = "5876";
    	System.out.println(multiply(num1, num2));
    }
}

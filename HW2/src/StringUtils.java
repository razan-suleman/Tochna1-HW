import java.util.Arrays;

public class StringUtils {
	public static void main(String[] args) {
		
	}
	public static String findSortedSequence(String str) {
	    int n = str.length();
	    int i = 0;

	    String max_str = "";
	    int max_len = 0;

	    String curr = "";
	    int curr_len = 0;

	    String prevWord = null;

	    while (i < n) {
	        String word = "";
	        while (i < n && str.charAt(i) != ' ') {
	            word += str.charAt(i);
	            i++;
	        }
	        if (i < n && str.charAt(i) == ' ') i++;

	        if (prevWord == null || word.compareTo(prevWord) >= 0) {
	            if (curr_len > 0) curr += " ";
	            curr += word;
	            curr_len++;
	        } else {
	            if (curr_len > max_len || (curr_len == max_len && curr_len > 0)) {
	                max_len = curr_len;
	                max_str = curr;
	            }
	            curr = word;
	            curr_len = 1;
	        }
	        prevWord = word;
	    }

	    if (curr_len > max_len || (curr_len == max_len && curr_len > 0)) {
	        max_len = curr_len;
	        max_str = curr;
	    }

	    if (max_len < 2) return "";
	    return max_str;
	}
	public static boolean isEditDistanceOne(String a, String b) {
	    int n = a.length(), m = b.length();
	    if (n - m > 1 || m - n > 1) return false;

	    int i = 0, j = 0, edits = 0;
	    while (i < n && j < m) {
	        char ca = a.charAt(i), cb = b.charAt(j);
	        if (ca == cb) { i++; j++; }
	        else {
	            if (++edits > 1) return false;
	            if (n > m) i++;
	            else if (m > n) j++;
	            else { i++; j++; }
	        }
	    }
	    if (i < n || j < m) edits++;
	    return edits == 1;
	}

		
	
}

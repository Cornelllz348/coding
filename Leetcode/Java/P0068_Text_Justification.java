package leetcode;

import java.util.*;

public class P0068_Text_Justification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length, index = 0, width = 0, count = 0;
        while (index < n) {
            if (width + words[index].length() <= maxWidth) {
                width += words[index].length() + 1;
                index++;
                count++;
            } else {
                StringBuilder sb = new StringBuilder();
                int space = 0, extra = 0;
                if (count > 1) {
                    space = (maxWidth - width + count) / (count - 1);
                    extra = (maxWidth - width + count) % (count - 1);
                    for (int i = index - count; i < index; i++) {
                        sb.append(words[i]);
                        if (extra > 0) {
                            for (int j = 0; j < space + 1; j++) {
                                sb.append(" ");
                            }
                            extra--;
                        } else {
                            for (int j = 0; j < space; j++) {
                                sb.append(" ");
                            }
                        }
                    }
                } else {
                    sb.append(words[index - 1]);
                    space = maxWidth - words[index - 1].length();
                    for (int i = 0; i < space; i++) {
                        sb.append(" ");
                    }
                }
                result.add(sb.toString().substring(0, maxWidth));
                count = 0;
                width = 0;
            }
        }
        if (count > 0) {
            StringBuilder sb = new StringBuilder();
            while (count > 0) {
                sb.append(words[n - count]);
                sb.append(" ");
                count--;
            }
            for (int i = 0; i < maxWidth; i++) sb.append(" ");
            result.add(sb.toString().substring(0, maxWidth));
        }
        return result;
    }
}
package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wsh
 * @date 2024/8/6
 */
public class RestoreIPAddressesNo93 {

    List<String> result = new ArrayList<>();

    LinkedList<String> path = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0 || s.trim().length() == 0) {
            return new ArrayList<>();
        }
        backtracking(s, 0, 0 );
        return result;
    }


    public void backtracking(String s, int index, int count) {
        if (count == 3) {
            // 判断尾段是否合法
            String ipSeg = s.substring(index);
            if (isValidIpSeg(s, index, s.length() - 1)) {
                path.add(ipSeg);
                result.add(String.join(".", path));
                path.removeLast();
            }
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String ipSeg = s.substring(index, i + 1);
            if (!isValidIpSeg(s, index, i)) {
                continue;
            }
            path.add(ipSeg);
            backtracking(s, i + 1, count + 1);
            path.removeLast();
        }
    }

    public boolean isValidIpSeg(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            int digit = s.charAt(i) - '0';
            num = num * 10 + digit;
            if (num > 255) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        RestoreIPAddressesNo93 r = new RestoreIPAddressesNo93();
//        List<String> strings = r.restoreIpAddresses("25525511135");
//        for (int i = 0; i < strings.size(); i++) {
//            System.out.println(strings.get(i));
//        }

        r.isValidIpSeg("23333", 0, 4);
    }
}

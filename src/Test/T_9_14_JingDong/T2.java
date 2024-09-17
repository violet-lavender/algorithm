package Test.T_9_14_JingDong;

import java.util.*;

public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String rank = in.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < rank.length(); i++) {
            map.put(rank.charAt(i), i);
        }
        int n = Integer.parseInt(in.nextLine());
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = in.nextLine();
        }
        Arrays.sort(strs, (Comparator<String>) (o1, o2) -> {
            int len = Math.min(o1.length(), o2.length());
            for (int i = 0; i < len; i++) {
                if (!map.get(o1.charAt(i)).equals(map.get(o2.charAt(i)))) {
                    return map.get(o1.charAt(i)) - map.get(o2.charAt(i));
                }
            }
            return o1.length() - o2.length();
        });
        for (String str : strs) {
            System.out.println(str);
        }
    }
}

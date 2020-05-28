package com.codeforlife.lax.leetcode;

import java.util.*;

public class LStrOps {

    public void longestSubStringWithKDistinctChar() {
        String str = "ccaabbb";
        int l = 0, r = 0;
        int c = 0;
        while (r < str.length()) {

            char ch = str.charAt(l);
            while (c <= 2 && r < str.length()) {
                if (ch != str.charAt(r)) {
                    c++;
                } else {
                    r++;
                }
            }
        }
    }

    public void longestSubString() {
        String str = "eceaakxababbbb";
        Set<Character> distinct = new HashSet<>();
        Map<Character, Integer> counter = new HashMap<>();

        // o(n)
        for (char ch : str.toCharArray()) {

            if (counter.containsKey(ch)) {
                counter.put(ch, 2);
            } else {
                counter.put(ch, 1);
            }
        }

        // o(n)
        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            if (entry.getValue() == 1) {
                distinct.add(entry.getKey());
            }
        }

        System.out.println(distinct.toString());
        System.out.println("***");
        // o(n2)
        int maxLen = 0;
        for (int i = 0; i < str.length(); i++) {
            int c = 0;
            int len = 0;
            for (int j = i; j < str.length(); j++) {
                if (distinct.contains(str.charAt(j))) {
                    c++;
                }
                if (c <= 2) {

                    len = Math.max(len, (j - i));
                    System.out.println(j + " - " + i + " , " + len);
                }
            }
            maxLen = Math.max(maxLen, len);
        }


        System.out.println(maxLen);
    }

    public static class EncodingDecoding {

        public String encode(List<String> list) {

            return null;
        }

        public List<String> decode(String string) {

            return null;
        }
    }

    public void encodeDecode() {
        List list = new LinkedList();
        list.add("HELLO");
        list.add("WORLD");
        list.add("CODE");
        list.add("FOR");
        list.add("LIFE");
        EncodingDecoding encodingDecoding = new EncodingDecoding();
        String msg = encodingDecoding.encode(list);
        encodingDecoding.decode(msg);
    }

    public void nextClosetTime() {
        String[] strings = new String[]{"19:34", "23:59", "00:00", "00:59", "10:59"};
        for (String s : strings) {
            System.out.println(nextClosestTime(s));
        }
    }

    public String nextClosestTime(String time) {
        int cur = 60 * Integer.parseInt(time.substring(0, 2));
        cur += Integer.parseInt(time.substring(3));
        Set<Integer> allowed = new HashSet();
        for (char c : time.toCharArray()) {
            if (c != ':') {
                allowed.add(c - '0');
            }
        }

        while (true) {
            cur = (cur + 1) % (24 * 60);
            int[] digits = new int[]{cur / 60 / 10, cur / 60 % 10, cur % 60 / 10, cur % 60 % 10};
            search:
            {
                for (int d : digits) if (!allowed.contains(d)) break search;
                return String.format("%02d:%02d", cur / 60, cur % 60);
            }
        }
    }

    public void uniqueEmailAddress() {
        String[] strings = new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        Set<String> list = new LinkedHashSet<>();
        for (String s : strings) {
            String[] arr = getDomainNameAndEmail(s);
            String email = arr[0];
            String domain = arr[1];
            String finalOutput = removeDots(email) + domain;
            list.add(finalOutput);
        }
        System.out.println(list.size());
    }

    private String[] getDomainNameAndEmail(String string) {
        return string.split("@");
    }

    private String removeDots(String txt) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char ch : txt.toCharArray()) {
            if (ch != '.') {
                stringBuilder.append(ch);
            }
            if (ch == '+') {
                return stringBuilder.toString();
            }
        }
        return stringBuilder.toString();
    }

}


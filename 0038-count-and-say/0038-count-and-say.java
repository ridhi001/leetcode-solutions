class Solution {
    public String countAndSay(int n) {
        String s = "1";

        for (int k = 1; k < n; k++) {
            String result = "";

            for (int i = 0; i < s.length(); ) {
                char ch = s.charAt(i);
                int count = 0;

                while (i < s.length() && s.charAt(i) == ch) {
                    count++;
                    i++;
                }

                result += count + "" + ch;
            }

            s = result;
        }

        return s;
    }
}
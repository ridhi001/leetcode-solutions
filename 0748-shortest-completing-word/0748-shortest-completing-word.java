class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String plate = licensePlate.toLowerCase();
        int[] count = new int[26];
        for (int i = 0; i < plate.length(); i++) {
            char c = plate.charAt(i);
            if (c >= 'a' && c <= 'z') {
                count[c - 'a']++;
            }
        }
        String result = "";
        for (int i = 0; i < words.length; i++) {
            int[] freq = new int[26];
            String word = words[i].toLowerCase();

            for (int j = 0; j < word.length(); j++) {
                freq[word.charAt(j) - 'a']++;
            }
            boolean valid = true;
            for (int j = 0; j < 26; j++) {
                if (freq[j] < count[j]) {
                    valid = false;
                    break;
                }
            }
            if (valid && (result.equals("") || word.length() < result.length())) {
                result = words[i];
            }
        }
        return result;
    }
}
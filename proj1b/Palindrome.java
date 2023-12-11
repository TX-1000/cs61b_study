public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        ArrayDeque<Character> char_deque = new ArrayDeque<Character>();
        for (int i = 0 ; i < word.length() ; i++) {
            char_deque.addLast(word.charAt(i));
        }
        return char_deque;
    }

    public boolean isPalindrome(String word) {
        Deque chars = wordToDeque(word);
        while (chars.size()>1) {
            if (chars.removeFirst() != chars.removeLast()) return false;
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> chars = wordToDeque(word);
        while (chars.size()>1) {
            char x = chars.removeFirst();
            char y = chars.removeLast();
            if (cc.equalChars(x,y)) return false;
        }
        return true;
    }
}

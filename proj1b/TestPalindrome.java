public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    public static void assertEquals(String str, String actual) {
        if (str.compareTo(actual) != 0) System.out.println("Except " + str + " but got " + actual);
        else System.out.println("pass");
    }

    public static void assertEquals(boolean flag, boolean actual) {
        if (flag != actual) System.out.println("Except " + flag + " but got " + actual);
        else System.out.println("pass");
    }
    

    static Palindrome palindrome = new Palindrome();

    public static void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    public static void testIsPalindrome() {
        boolean isP1 = palindrome.isPalindrome("abcbbcba");
        boolean isP2 = palindrome.isPalindrome("abc123! --d-- !321cba");
        boolean isP3 = palindrome.isPalindrome("");
        boolean isP4 = palindrome.isPalindrome("@");
        boolean isP5 = palindrome.isPalindrome("12345432");
        assertEquals(true, isP1);
        assertEquals(true, isP2);
        assertEquals(true, isP3);
        assertEquals(true, isP4);
        assertEquals(false, isP5);
    }

    public static void main(String[] args) {
        testWordToDeque();
        testIsPalindrome();
    }
}

public class TestOffByOne {
    
    public static void assertEquals(boolean flag, boolean actual) {
        if (flag != actual) System.out.println("Except " + flag + " but got " + actual);
        else System.out.println("pass");
    }
    
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    public static void main(String[] args) {
        assertEquals(true, offByOne.equalChars('a', 'b'));
        assertEquals(false, offByOne.equalChars('a', 'A'));
        
    }
    /* Uncomment this class once you've created your CharacterComparator interface and OffByOne class. * */
}

package PalindromeFinder;

import java.util.Stack;

public class PalindromeFinder {
    private String inputString;
    private Stack<Character> charStack;

    public PalindromeFinder(String inputString) {
        this.inputString = inputString;
        fillStack();
    }

    private void fillStack() {
        for (int i = 0; i < inputString.length(); i++) {
            charStack.push(inputString.charAt(i));
        }
    }

    private String buildReverse() {
        StringBuilder sb = new StringBuilder();
        while (!charStack.empty()) {
            sb.append(charStack.pop());
        }
        return sb.toString();
    }

    public boolean isPalindrome() {
        return inputString.equalsIgnoreCase(buildReverse());
    }
}

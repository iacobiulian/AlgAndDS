package ro.iim.ds.stack;

import java.util.EmptyStackException;

public class Stack {
    private String[] stackArray;
    private int stackSize;
    private int topOfStackIndex;

    public Stack(int stackSize) {
        this.stackSize = stackSize;

        stackArray = new String[stackSize];

        topOfStackIndex = -1;
    }

    public void push(String input) {
        //if we have space add item
        if (!isFull()) {

            stackArray[++topOfStackIndex] = input;

            //System.out.println("Item added to stack");
        } else {
            System.out.println("Stack is full");
        }
    }

    public String pop() {
        if (!isEmpty()) {
            String poppedItem = stackArray[topOfStackIndex];
            stackArray[topOfStackIndex] = null;
            topOfStackIndex--;
            return poppedItem;
        }

        throw new EmptyStackException();
    }

    public String peek() {
        return stackArray[topOfStackIndex];
    }

    public void displayStack() {
        if (stackSize < 1) {
            return;
        }

        for (String item : stackArray) {
            if (item != null)
                System.out.println(item);
        }
    }

    public boolean isEmpty() {
        return (topOfStackIndex == -1);
    }

    public boolean isFull() {
        return (topOfStackIndex == stackSize - 1);
    }

    public void pushMany(String[] multipleValues) {
        for (String item : multipleValues) {
            push(item);
        }
    }

    public String[] popAll() {
        String[] poppedItems = new String[topOfStackIndex + 1];
        for (int i = topOfStackIndex; i >= 0; i--) {
            poppedItems[i] = pop();
        }

        return poppedItems;
    }

    public static String reverseString(String input) {
        String output = "";
        Stack stack = new Stack(input.length());

        for (int i = 0; i < input.length(); i++) {
            String ch = String.valueOf(input.charAt(i));
            stack.push(ch);
        }

        while (!stack.isEmpty()) {
            String ch = stack.pop();
            output += ch;
        }

        return output;
    }

    public static boolean bracketsCheck(String input) {
        Stack stack = new Stack(input.length());

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(String.valueOf(ch));
                    break;
                case ')':
                case ']':
                case '}':
                    if (!stack.isEmpty()) {
                        String poppedCh = stack.pop();
                        char chx = poppedCh.charAt(0);
                        if ((ch == ')' && chx != '(') ||
                                (ch == ']' && chx != '[') ||
                                (ch == '}' && chx != '{')) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                default:
                    break;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }
}

package com.haapp.module01;

import java.util.Scanner;
import java.util.Stack;

public class Module01 {

    private static final String OPEN_BRACKETS = "({[<";
    private static final String CLOSE_BRACKETS = ")}]>";
    private static final String SEPARATOR_LINE = "------------------------------------------------------------------";

    public static void main(String[] args) {

        separate();
        System.out.println("Please, type a string with some brackets and press ENTER:");

        Scanner in = new Scanner(System.in);
        String inComeLineFromConsole = in.nextLine();
        char[] inCome = inComeLineFromConsole.toCharArray();

        Stack<Character> bracketStack = new Stack<Character>();
        Stack<Integer> positionStack = new Stack<Integer>();

        int position = 0;

        for (Character character:inCome) {
            position++;
            if (OPEN_BRACKETS.contains(character.toString())){
                bracketStack.push(character);
                positionStack.push(position);
            }
            if (CLOSE_BRACKETS.contains(character.toString())){
                if (bracketStack.isEmpty()){
                    System.out.println("ERROR01: Unexpected bracket '" + character + "' in position " + position);
                    return;
                }
                if ((character - bracketStack.pop()) > 2){
                    System.out.println("ERROR02: Unexpected bracket '" + character + "' in position " + position);
                    return;
                };
                positionStack.pop();
            }
        }
        if (bracketStack.isEmpty()){
            System.out.println("INFO: The brackets are placed correctly in your string: " + inComeLineFromConsole);
        }
        while (!bracketStack.isEmpty()){
            System.out.println("ERROR03: Not closes bracket '" + bracketStack.pop() + "' in position " + positionStack.pop());
        }
        separate();
        in.close();
    }

    private static void separate (){
        System.out.println(SEPARATOR_LINE);
    }
}

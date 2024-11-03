/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author josea
 */
abstract public class ExtraMechanics {
    Scanner scanner = new Scanner(System.in);
    
    class Colors {
        public static final String RESET = "\u001B[0m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String MAGENTA = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";
        public static final String WHITE = "\u001B[37m";
    }
    
    Colors color = new Colors();
    
    public int winOrLose(Characters mainChar, int bossHp) {
            if (bossHp <= 0) {
                System.out.println(color.GREEN + "YOU WON!" + color.RESET);
                return 1;
            } else if (mainChar.hp <= 0 || mainChar.stamina <= 0) {
                System.out.println(color.RED + "You lost..." + color.RESET);
                System.out.println(color.MAGENTA + "...And they chose you to play the hero..." + color.RESET);
                return 1;
            }

            if (mainChar.stamina <= 40) {
                System.out.println(color.RED + "WARNING: you have low Stamina!" + color.RESET);
            }
            if (mainChar.hp <= 40) {
                System.out.println(color.RED + "WARNING: you have low Health!" + color.RESET);
            }

            System.out.print("\nCharacter health: " + (mainChar.hp <= 40 ? color.RED + mainChar.hp + color.RESET : mainChar.hp));
            System.out.println("\nCharacter Stamina: " + (mainChar.stamina <= 40 ? color.RED + mainChar.stamina + color.RESET : mainChar.stamina));
            return 0;
    }
    
    public Characters chooseCharacter(boolean isChar, Characters mainChar) {
        int chooseChar = 0;
        CharInfo getChar = new CharInfo();
        
        OUTER:
        do {
            do {
                try {
                    System.out.println("1. Fighter\n2. Wizard\n3. Tank\n4. Healer");
                    System.out.print("Choose character: ");
                    chooseChar = scanner.nextInt();
                    if (chooseChar > 4 || chooseChar < 1) { // Ensure character is valid (1-4)
                        System.out.println("Invalid! Please choose a valid Character!");
                    } else {
                        isChar = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("InputMismatchException! Please choose a valid Character!");
                    scanner.next();
                }
            } while (!isChar);

            isChar = false;

            switch (chooseChar) {
                case 1:
                    mainChar = getChar.getFirstChar();
                    System.out.println("You've Chosen Kent The Fighter!");
                    isChar = true;
                    break OUTER;
                case 2:
                    mainChar = getChar.getSecondChar();
                    System.out.println("You've Chosen Cedi The Wizard!");
                    isChar = true;
                    break OUTER;
                case 3:
                    mainChar = getChar.getThirdChar();
                    System.out.println("You've Chosen Axille The Tank!");
                    isChar = true;
                    break OUTER;
                case 4:
                    mainChar = getChar.getFourthChar();
                    System.out.println("You've Chosen Healer!");
                    isChar = true;
                    break OUTER;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (!isChar);
        return mainChar;
    }
    
    abstract void startGame();
}

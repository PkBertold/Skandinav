/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package skandinav;

import java.io.*; 
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/**
@author Crosshair
 */
public class Skandinav {
  public static void main(String[] args) {
    
    List<Integer> winningNumbers = new ArrayList<>();
    
    Random random = new Random();
    
    for (int i = 0; i < 6; i++) {
      while (true) {
        int winningNumber = random.nextInt(35) + 1;
        if (!winningNumbers.contains(winningNumber)) {
          winningNumbers.add(winningNumber);
          break;
        }
      }
    }
    
    // Debug módhoz a nyertes számok mutatása. (Vedd ki a kommentet az alábbi sorból)
    //System.out.println(winningNumbers);
    
    System.out.println("Bertold bot: Kérlek adj egy megy számot 1 és 35 között:");
    
    Scanner scanner = new Scanner(System.in);
    
    List<Integer> guessedNumbers = new ArrayList<>();
    for (int i = 0; i < 7; i++) {
      System.out.println("Bertold bot: Az eddigi számaid: " + guessedNumbers);
      System.out.println("Bertold bot: Adj meg egy számot(1-35):");
      while (true) {
        try {
          String numberString = scanner.nextLine();
          int number = Integer.parseInt(numberString);
          if (number >= 1 && number <= 35) {
            guessedNumbers.add(number);
            break;
          }
          else {
            System.out.println("Bertold bot: A " + number + " nincs 1 és 35 között!");
          }
        }
        catch (NumberFormatException nfe) {
          System.out.println("Számot adj meg");
        }
      }
    }
    
    System.out.println("Bertold bot: Ezek voltak a nyertes számok: " + winningNumbers);
    System.out.println("Választott számok: " + guessedNumbers);
    
    guessedNumbers.retainAll(winningNumbers);
    System.out.println("Eltalált számok : " + guessedNumbers);
    System.out.println("Sorsolt számok: " + winningNumbers);
    
    if (guessedNumbers.containsAll(winningNumbers)) {
      System.out.println("Bertold bot: Nyertél! Hihetetlen!");
    }
    else {
      System.out.println("Bertold bot: Nem nyert!");
    }
    
    
    scanner.close();
  }
}
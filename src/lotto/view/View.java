/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotto.view;

import java.io.Closeable;
import java.util.InputMismatchException;
import java.util.Scanner;
import lotto.model.OutOfRangeException;

/**
 * A class that is responsible for the input that user can do.
 * It is responsible for the output too.
 * 
 * @author Mateusz Herok
 * @version 1.0
 */

public class View
{
    
    /** stream connector */
    private Scanner scanner = new Scanner(System.in);
    
    /** user input with numbers to draws table */
    private int[] drawNumbersArray = new int[5];
    
    /**
     * prints message for user input to get number of draws
     */
    public void printMessageNumberOfDraws()
    {
        System.out.println("Wpisz ilosc losowan: ");
    }
    
    /**
     * prints message for user input to get numbers for the lottery
     */
    public void printMessageDrawNumbers() 
    {
        System.out.println("Wypisz 5 wybranych liczb:");
    }

    /**
     * I use this function to flush from the input buffor all not usefull characters.
     * It helps with resuming of the work after wrong user input.
     */

    public void flushInput()
    {
        scanner.nextLine();
    }

    /**
     * takes user input for draw numbers.
     * 
     * @return returns draw numbers
     * @throws InputMismatchException checks for wrong input
     */
    public int getNumberOfDraws() throws InputMismatchException
    {
        return scanner.nextInt();
    }

    /**
     * This function takes from the user 5 random numbers of his choice.
     * It checks also if they don't go beyond the scope.
     * 
     * @return returns table with numbers from user
     * @throws InputMismatchException checks for wrong input
     * @throws OutOfRangeException checks for numbers out of range in input
     */

    
    public int[] getDrawNumbersArray() throws InputMismatchException, OutOfRangeException
    {
        for(int i = 0; i < 5; ++i)
        {
            drawNumbersArray[i] = scanner.nextInt();
            
            if((drawNumbersArray[i] < 0) || (drawNumbersArray[i] > 100))
                throw new OutOfRangeException("Liczba spoza zakresu");
        }
        
        return drawNumbersArray;
    }
    
    /**
     * prints out a table with the the amount hits for specific numbers
     * 
     * @param tableResult           table with amount of hits
     * @param tableUserInput        table with numbers choosen by the user
     */
    public void showResult(int[] tableResult, int[] tableUserInput)
    {
        System.out.println("\nWyniki losowania!");
        
        for(int i = 0; i < 5; ++i)
        {
            System.out.println("Liczba " + tableUserInput[i] + " zostala wylosowana " + tableResult[i] + " razy.");
        }
        
        scanner.close();
    }
    
    /**
     * generates a error message
     * 
     * @param error
     */
    public void showErrorMessage(String error){  
        
        System.err.println(error); 
    }
}

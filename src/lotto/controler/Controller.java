/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotto.controler;

import java.util.InputMismatchException;
import lotto.model.OutOfRangeException;
import lotto.model.WinChecker;
import lotto.view.View;


/**
 * The controler class, is guiding all actions in the program.
 * 
 * @author Mateusz Herok
 * @version 3.0
 */

public class Controller {
    
    /** this variable holds the amount of draws */
    private int numberOfDraws;

    /** this table holds 5 numbers chosen by the user */
    private int[] drawNumbersArray = new int[5];

    /** this table holds the information how many times did we draw the numbers */
    private int[] gameResultArray = new int[5];

    /** checks of parameter list is correct */
    private boolean hasToCheckInput = false;

    /** looks forward to not throw twice the same exception */
    private boolean hasToManyErrorMessage = false;

    /** cancels the do while loop */
    private boolean hasWrongInput = false;
    
    /** for user interaction */
    private View view = new View();

    /** checking if the numbers choosen win */
    private WinChecker model = new WinChecker();

    /**
     * This function support all user actions.
     * Runs after the run(String[]) function.
     * Checks mistakes that have been taken while user input.
     * Controls the operations of each part of the program.
     * 
     * @param hasNoParametersAtStart checks if parameters been added
     */
    
    public void run(boolean hasNoParametersAtStart)
    {
        if(hasToCheckInput || hasNoParametersAtStart)
        {
            do
            {
                view.printMessageNumberOfDraws();

                hasToManyErrorMessage = false;

                try
                {
                    numberOfDraws = view.getNumberOfDraws();
                }
                catch (InputMismatchException e)
                {
                    view.flushInput();
                    view.showErrorMessage("Prosze podac prawidlowa ilosc losowan.");
                    hasToManyErrorMessage = true;
                }

                if(!hasToManyErrorMessage)
                    if(numberOfDraws <= 0)
                        view.showErrorMessage("Prosze podac prawidlowa ilosc losowan.");

            }while(numberOfDraws <= 0);

            do
            {
                view.printMessageDrawNumbers();

                hasWrongInput = false;
                try{
                    drawNumbersArray = view.getDrawNumbersArray();
                }
                catch(InputMismatchException e)
                {
                    view.flushInput();
                    view.showErrorMessage("Prosze podac prawidlowa ilosc losowan.");
                    hasWrongInput = true;
                }
                catch(OutOfRangeException e)
                {
                    view.showErrorMessage(e.getMessage());
                    hasWrongInput = true;
                }
            }while(hasWrongInput);
        }
        
        gameResultArray = model.countingRepeatingNumbers(numberOfDraws, drawNumbersArray);
        
        view.showResult(gameResultArray, drawNumbersArray);
        
        view.close();
    }

    /**
     * A polimorphic function, that takes under consideration the parameters entered by the user.
     * Checks mistakes that have been taken while user input.
     * Transfers the data to the previous function (run(boolean)).
     * 
     * @param arguments
     */

    
    public void run(String[] arguments)
    {
        try
        {     
            numberOfDraws = Integer.parseInt(arguments[0]);
        }
        catch(NumberFormatException e)
        {
            view.showErrorMessage("Prosze podac prawidlowa ilosc losowan.");
            hasToManyErrorMessage = true;
            hasToCheckInput = true;
            
            if(!hasToManyErrorMessage)
                if(numberOfDraws <= 0)
                    view.showErrorMessage("Prosze podac prawidlowa ilosc losowan.");
            
            run(false);
        }
        
        try
        {
            for(int i = 0; i < 5; ++i)
            {
                drawNumbersArray[i] = Integer.parseInt(arguments[i + 1]);
                
                if(drawNumbersArray[i] < 0 || drawNumbersArray[i] > 100)
                {
                    view.showErrorMessage("Prosze wpisac prawidlowa liczbe do losowania.");
                    hasToCheckInput = true;
                    break;
                }
                    
            }
        }
        catch(NumberFormatException e)
        {
            view.showErrorMessage("Prosze wpisac prawidlowa liczbe do losowania.");
            hasToCheckInput = true;
        }
        
        run(false);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotto.model;

/**
 * A class that is responsible for checking how many times did the user hit certain chosen numbers.
 * 
 * @author Mateusz Herok
 * @version 2.0
 */

public class WinChecker {
    
    /** generates random table */
    RandomTableGenerator randomTable = new RandomTableGenerator();

    /**
     * A function that is counting how many times does a certain chosen number occur in the draws.
     * 
     * @param numberOfDraws         user input of how many draws do we want to make
     * @param userNumbersTable      table with numbers choosen from the user
     * @return                      returns a table how many times did we hit a specific number
     */

    
    public int[] countingRepeatingNumbers(int numberOfDraws, int[] userNumbersTable)
    {
        
	int[] resultTable = new int[5];
        
        int[][] allRandomDrawsTable = generateDraws(numberOfDraws);
        
        for (int i = 0; i < 5; ++i)
	{
            for (int[] j : allRandomDrawsTable)
            {
                for (int k : j)
		{
                    if (k == userNumbersTable[i])
                        resultTable[i]++;
		}
            }
	}
	
        return resultTable;
    }

    /**
     * A function that is creating an 2D array of all draws.
     * 
     * @param numberOfDraws         how many draws do we want to make
     * @return                      returns a 2D array of all draws
     */

    
    private int[][] generateDraws(int numberOfDraws)
    {
        int[][] allRandomDrawsTable = new int[numberOfDraws][5];
        
	for (int i = 0; i < numberOfDraws; ++i)
	{
            allRandomDrawsTable[i] = randomTable.generateResultTable();
	}
        
	return allRandomDrawsTable;
    }
    
}

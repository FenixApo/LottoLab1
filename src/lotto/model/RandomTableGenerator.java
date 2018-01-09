/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotto.model;

import java.util.Random;


/**
 * A class that is responsible for generating an array of five random numbers.
 * 
 * @author Mateusz Herok
 * @version 1.0
 */

public class RandomTableGenerator {
    
    /** an array that holds all the drawn numbers */
    private int[] randomTable = new int[5];

    /** generates random number */
    private Random randomGenerator = new Random();
    
    /**
     * This method generates a result table with drawn numbers times howmany draws do we want to make.
     * 
     * @return returns a table with matches
     */
    
    public int[] generateResultTable()
    {
        boolean hasToCheckNumber = false;
        int tempChecker;
        
        /*
            A loop that is adding random numbers to the table "randomTable"
        */
        
        for(int i = 0; i < 5;)
        {
            int j = i - 1;
            
            tempChecker = getRandomInt();
            
            /*
                A loop that is checking if this certain numbers isn't already in the array.
            */
            
            while(j >= 0)
            {
                if(randomTable[j] == tempChecker)
                {
                    hasToCheckNumber = true;
                    break;
                }
                --j;
            }
            
            /*
                End of the checking loop.
            */
            
            
            /*
                If the drawn numbers isn't the same, we add it to the table and continue
            */
            
            if(hasToCheckNumber == true)
            {
                hasToCheckNumber = false;
            }
            else
            {
                randomTable[i] = tempChecker;
                ++i;
            }  
        }
        
        return randomTable;
    }

    /**
     * Random number generator.
     * 
     * @return random number
     */

    
    private int getRandomInt()
    {   
        return randomGenerator.nextInt(5);
    }
}

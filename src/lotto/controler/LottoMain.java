/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotto.controler;

/**
 * Main class of the program start the controler object.
 * Containing the main function.
 * 
 * @author Mateusz Herok
 * @version 1.0
 */
public class LottoMain {

    /**
     * starts controler
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        Controller controler = new Controller();
        
        if(args.length == 6)
        {
            controler.run(args);
        }
        else
        {
            controler.run(true);
        }
    }
}

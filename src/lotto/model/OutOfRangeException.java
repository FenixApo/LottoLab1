/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lotto.model;

/**
 * A class that generates an exception about the number being out of the allowed range.
 * 
 * @author Mateusz Herok
 * @version 1.0
 */
public class OutOfRangeException extends Exception
{

    /**
     * Creates an exception when number is out of range.
     * 
     * @param message
     */
    public OutOfRangeException(String message){
        super(message);
    }
}

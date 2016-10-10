/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg3.largestprimefactor;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Alec
 */
public class LargestPrimeFactor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //This number is too large to use 
        //Therefore a long is required
        Long numberToBeFactorised;
        numberToBeFactorised = 600851475143L;
        
        ArrayList<Long> factorsToCheck = calculateFactorsForInput(numberToBeFactorised);
        Long greatestPrimeFactor = findGreatestPrimeFactor(factorsToCheck);
        System.out.println("Greatest Prime Factor is " + greatestPrimeFactor);
        // Get Factors
        
        
        
        
    }
    
    //Factors Calculation
    public static ArrayList<Long> calculateFactorsForInput(Long input){
        /**
        * @param input this is the Long integer whose factors will be found
        * and returned as the result
        */
        Long curMaxFactor = input;
        System.out.println(curMaxFactor);
        //Loop through all numbers up to  
        ArrayList<Long> listHighFactors = new ArrayList<>();
        ArrayList<Long> listLowFactors = new ArrayList<>();
        ArrayList<Long> listAllFactors = new ArrayList<>();
        for(Long i = 2L;i < curMaxFactor;i++){
            //update current max factor every time a new factor is identified
            //This is to reduce execution time.
            //Allows us to create two lists in tandem from bottom up and top down
            //These lists must then be amalgamated correctly
            if(input % i == 0L){
                curMaxFactor = input/i;
                
                //Add to top down list
                listHighFactors.add(curMaxFactor);
                
                //Add to bottom up list
                listLowFactors.add(i);
            }    
        }
        //add listLowFactors to allFactors list
        
        listAllFactors.addAll(listLowFactors);
        
        //Now add the high list to the "ListAllFactors" in reverse order 
        //as it is a top down list
        for(int j = (listHighFactors.size() - 1 );j>=0;j--){
            listAllFactors.add(listHighFactors.get(j));
        }
        
        //debug show all factors
        for (Long listAllFactor : listAllFactors) {
            System.out.println(listAllFactor);
        }
        
        return listAllFactors;
    }
    
    
    public static Long findGreatestPrimeFactor(ArrayList<Long> inputListNums){
        /**
        * @param inputListNums This is Array list of Longs whose list items will be 
        * tested to be Primes, the largest Prime number will be returned.
        */
        
        //This will calculate the prime numbers from the list of factors we have recovered
        //nested loop to check for each factor,we loop to find if it's a prime
        ArrayList<Long> primeFactors = new ArrayList<>();
        for (Long num : inputListNums) {
            if(isPrime(num)){
                primeFactors.add(num);
            }
        }
        return (primeFactors.get(primeFactors.size()-1));
    }
    
    public static boolean isPrime(Long num){
        /**
        * @param num This function will simply return true or false depending on whether
        * the input "num" is a prime or not.
        */
        
        //This will loop through every
        for(Long i = 1L;i<num;i++){
            if(num % i == 0 && i != 1L && i != num){
                //System.out.println(num + " is not a prime number.");
                return false;
            }
        }
        //System.out.println(num + " is a prime number!");
        return true;
    }
    
}

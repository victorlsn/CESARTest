package br.com.victorlsn.questions1_4;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by victorlsn on 27/08/18.
 */

public class Questions {

    // Question 1 (Complexity: O(nˆ2))
    public static char[] replaceCharsInPlace(char[] array, int trueLength) {
        int index = 0;

        while (index < trueLength) {
            if (array[index] == ' ') {
                for (int i = trueLength-1; i > index; i--) {
                    array[i+2] = array[i];
                }
                array[index] = '&';
                array[index+1] = '3';
                array[index+2] = '2';

                trueLength += 2;

                index += 3;
            }
            else {
                index++;
            }
        }

        return array;
    }


    // Question 2 (Complexity: O(n))
    public static boolean isPartialPermutation(String word, String permutation) {
        word = word.toLowerCase();
        permutation = permutation.toLowerCase();

        // Empty String check;
        if(word.isEmpty() || permutation.isEmpty()) return false;

        // Same String size check;
        if(word.length() > permutation.length() || permutation.length() > word.length()) return false;

        // First char check;
        if (word.charAt(0) != permutation.charAt(0)) return false;

        // Same chars check;
        char[] wordArray = word.toCharArray();
        char[] permutationArray = permutation.toCharArray();
        Arrays.sort(wordArray);
        Arrays.sort(permutationArray);
        for (int i = 0 ; i < wordArray.length-1; i++) {
            if (wordArray[i] != permutationArray[i]) return false;
        }

        // Jumble count check;
        int jumbleCount = 0;
        for (int i = 0; i <= word.length()-1; i++) {
            if (word.charAt(i) != permutation.charAt(i)) {
                jumbleCount++;
            }

            if (jumbleCount > ((double) word.length())*2/3) {
                return false;
            }
        }

        return true;
    }

    // Question 3 (Complexity: O(n))
    public static boolean hasZeroOrOneTypos(String word, String typo) {
        word = word.toLowerCase();
        typo = typo.toLowerCase();

        // Empty String check;
        if(word.isEmpty() || typo.isEmpty()) return true;

        // Size check;
        if (Math.abs(word.length() - typo.length()) > 1) return false;

        int typos = 0;

        int wordChar = 0;
        int typoChar = 0;

        // Typos check;
        for (int i = 0; i <= word.length()-1; i++) {
            if (typo.length() == word.length()) {
                if (word.charAt(wordChar) != typo.charAt(typoChar)) {
                    typos++;
                }
                wordChar++;
                typoChar++;
            }
            else if (word.length() < typo.length()) {
                if (typo.charAt(typoChar) != word.charAt(wordChar)) {
                    typos++;
                    typoChar++;
                }
                else {
                    wordChar++;
                    typoChar++;
                }
            }
            else {
                if (typo.length()-1 >= i) {
                    if (word.charAt(wordChar) != typo.charAt(typoChar)) {
                        typos++;
                        wordChar++;
                    }
                    else {
                        wordChar++;
                        typoChar++;
                    }
                }
            }

            if (typos > 1) return false;
        }

        return true;
    }
}

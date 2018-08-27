package br.com.victorlsn.questions1_4;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class QuestionsUnitTest {

    @Test
    public void isReplaceCharsInPlaceCorrect() throws Exception {
        char[] array1 = { 'U', 's', 'e', 'r', ' ', 'i', 's', ' ', 'n', 'o', 't', ' ', 'a', 'l', 'l', 'o', 'w', 'e', 'd', ' ', ' ', ' ', ' ', ' ', ' '};
        char[] response1 = Questions.replaceCharsInPlace(array1, 19);

        assertEquals("User&32is&32not&32allowed", String.valueOf(response1));

        char[] array2 = { 'U', 's', 'e', 'r', ' ', 'i', 's', ' ', 'a', 'l', 'l', 'o', 'w', 'e', 'd', ' ', ' ', ' ', ' '};
        char[] response2 = Questions.replaceCharsInPlace(array2, 15);

        assertEquals("User&32is&32allowed", String.valueOf(response2));

        char[] array3 = { 'U', 's', 'e', 'r', ' ', 'h', 'a', 's', ' ', 'b', 'e', 'e', 'n', ' ', 'r', 'e', 'm', 'o', 'v', 'e', 'd', ' ', 'b', 'y', ' ', 'a', 'd', 'm', 'i', 'n', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        char[] response3 = Questions.replaceCharsInPlace(array3, 30);

        assertEquals("User&32has&32been&32removed&32by&32admin", String.valueOf(response3));
    }

    @Test
    public void isPartialPermutationCorrect() throws Exception {
        assertEquals(true, Questions.isPartialPermutation("you", "yuo"));
        assertEquals(true, Questions.isPartialPermutation("probably", "porbalby"));
        assertEquals(true, Questions.isPartialPermutation("despite", "desptie"));

        assertEquals(false, Questions.isPartialPermutation("moon", "nmoo"));
        assertEquals(false, Questions.isPartialPermutation("moon", "noon"));
        assertEquals(false, Questions.isPartialPermutation("misspellings", "mpeissngslli"));
        assertEquals(false, Questions.isPartialPermutation("test", "tes"));
        assertEquals(false, Questions.isPartialPermutation("", ""));
        assertEquals(false, Questions.isPartialPermutation("testing", "testang"));
    }

    @Test
    public void isHasZeroOrOneTyposCorrect() throws Exception {
        assertEquals(true, Questions.hasZeroOrOneTypos("pale", "ple"));
        assertEquals(true, Questions.hasZeroOrOneTypos("pale", "pales"));
        assertEquals(true, Questions.hasZeroOrOneTypos("pale", "bale"));
        assertEquals(true, Questions.hasZeroOrOneTypos("pale", "pae"));

        assertEquals(false, Questions.hasZeroOrOneTypos("pale", "pael"));
        assertEquals(false, Questions.hasZeroOrOneTypos("pale", "pl"));
        assertEquals(false, Questions.hasZeroOrOneTypos("pale", "bake"));
        assertEquals(false, Questions.hasZeroOrOneTypos("pale", "pakek"));
    }
}
package woordenapplicatie.gui;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class WordSorterTest {

    private final String INPUT = "AB Bb Cc Dd Ee \n Ab bB cC";
    private static WordSorter wc;

    @BeforeAll
    static void setUp(){
        wc = new WordSorter();
    }


    @Test
    void sortWords() throws ExecutionException, InterruptedException {
        Assert.assertEquals("cC\n" +
                        "bB\n" +
                        "Ee\n" +
                        "Dd\n" +
                        "Cc\n" +
                        "Bb\n" +
                        "Ab\n" +
                        "AB\n" +
                        "\n",
                wc.sortWords(INPUT));    }

    @Test
    void countConcordancy() throws ExecutionException, InterruptedException {
        Assert.assertEquals("Ab : 1\n" +
                        "AB : 0\n" +
                        "cC : 1\n" +
                        "bB : 1\n" +
                        " : 1\n" +
                        "Ee : 0\n" +
                        "Dd : 0\n" +
                        "Cc : 0\n" +
                        "Bb : 0\n",
                wc.countConcordancy(INPUT));
    }

}
package woordenapplicatie.gui;


import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

class WordCounterTest {


    private final String INPUT = "DA NIET NIET Yas Yas Yas Jeb Jin Jin Jin";
    private static WordCounter wc;

    @BeforeAll
    static void setUp(){
        wc = new WordCounter();
    }

    @Test
    void countWords() throws ExecutionException, InterruptedException {
          Assert.assertEquals("Total number of words: 10\nTotal number of unique words: 5",
                  wc.countWords(INPUT));
    }

    @Test
    void countFrequencyOfWords() throws ExecutionException, InterruptedException {
        Assert.assertEquals("NIET : 2\nJin : 3\nDA : 1\nYas : 3\nJeb : 1\n", wc.countFrequencyOfWords(INPUT));
    }

}
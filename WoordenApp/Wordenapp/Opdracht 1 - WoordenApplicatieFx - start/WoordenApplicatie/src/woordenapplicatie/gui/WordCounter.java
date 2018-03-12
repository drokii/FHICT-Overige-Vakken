package woordenapplicatie.gui;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WordCounter {

    private ArrayList<String> words;
    private HashSet<String> uniqueWords;
    private HashMap<String, Integer> freequencyWords;

    public String countWords(String input) throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFuture
                = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            words = InputToCollectionProcessor.processInputIntoArrayList(input);
            uniqueWords = new HashSet<>();
            uniqueWords.addAll(words);

            completableFuture.complete("Total number of words: " +
                    words.size() + "\n" + "Total number of unique words: " +
                    uniqueWords.size());
            return null;
        });

        Future<String> result = completableFuture;

        return result.get();

    }

    public String countFrequencyOfWords(String input) throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFuture
                = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            words = InputToCollectionProcessor.processInputIntoArrayList(input);
            freequencyWords = new HashMap<>();

            for (int i = 0; i < words.size(); i++) {
                freequencyWords.compute(words.get(i), (k, v) -> v == null ? 1 : v + 1 );
            }
            Map<String, Integer> sortedMap = WordSorter.sortByValue(freequencyWords);
            Iterator i = sortedMap.entrySet().iterator();
            String freequencyString="";

            while (i.hasNext()){
                Map.Entry pair = (Map.Entry) i.next();
                freequencyString = pair.getKey() + " : " + pair.getValue().toString() + "\n" + freequencyString;
            }

            completableFuture.complete(freequencyString);
            return null;
        });

        Future<String> result = completableFuture;

        return result.get();
    }



}

package woordenapplicatie.gui;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WordSorter {

    private ArrayList<String> words;
    private HashMap<String, Integer> wordMap;
    private TreeSet<String> wordTreeSet;
    private TreeMap<String, ArrayList<Integer>> concordancyMap;

    public String sortWords(String input) throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFuture
                = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            words = InputToCollectionProcessor.processInputIntoArrayList(input);

            wordTreeSet = new TreeSet<>();
            wordTreeSet.addAll(words);

            String organizedWordsDecreasing = "";

            for (Iterator i = wordTreeSet.iterator(); i.hasNext(); ) {

                organizedWordsDecreasing = i.next() + "\n" + organizedWordsDecreasing;
            }

            completableFuture.complete(organizedWordsDecreasing);
            return null;
        });

        Future<String> result = completableFuture;

        return result.get();

    }

    public String countConcordancy(String input) throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFuture
                = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            wordMap = InputToCollectionProcessor.processInputIntoHashMap(input);

            Iterator i = wordMap.entrySet().iterator();
            String concordancyString="";

            while (i.hasNext()){
                Map.Entry pair = (Map.Entry) i.next();
                concordancyString = pair.getKey() + " : " + pair.getValue().toString() + "\n" + concordancyString;
            }
            completableFuture.complete(concordancyString);
            return null;

        });

        Future<String> result = completableFuture;

        return result.get();

    }



}

package woordenapplicatie.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class InputToCollectionProcessor {

    public static ArrayList<String> processInputIntoArrayList(String res) {

        ArrayList<String> arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(res.split("[\\W]")));
        return arrayList;
    }

    public static HashMap<String, Integer> processInputIntoHashMap(String res) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        List<String> theWholeText = new ArrayList<>(Arrays.asList(res.split("\\n")));

        int lineNumber = 0;
        for (String s : theWholeText) {

            String[] wordsPerLine = s.split("[\\W]");

            for (String s2 : wordsPerLine) {
                hashMap.put(s2, lineNumber);
            }

            ++lineNumber;
        }

        return hashMap;
    }
}

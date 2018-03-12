package com.huffmancompressor;

import java.util.*;

public class HuffmanCompressor {

    private HashMap<Character, Integer> computeFreequency(String input) {
        char[] chars = input.toCharArray();

        HashMap<Character, Integer> freequencyChars = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            freequencyChars.compute(chars[i], (k, v) -> v == null ? 1 : v + 1);
        }

        return freequencyChars;
    }

    public HuffmanNode buildTree(String input) {

        HashMap source = computeFreequency(input);
        List<HuffmanNode> nodeList = new LinkedList<>();
        Iterator i = source.entrySet().iterator();

        while (i.hasNext()) {
            Map.Entry pair = (Map.Entry) i.next();
            HuffmanNode node = new HuffmanNode((int) pair.getValue(), (char) pair.getKey());
            nodeList.add(node);
        }

        Comparator<HuffmanNode> sortPerFreequency = Comparator.comparing(HuffmanNode::getFrequency);
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(nodeList.size(), sortPerFreequency);
        queue.addAll(nodeList);
        HuffmanNode huffmanTree = null;

        while (queue.size() != 0) {

            if (queue.size() != 1) {

                HuffmanNode a = queue.poll();
                HuffmanNode b = queue.poll();
                HuffmanNode parentNode = new HuffmanNode(a.getFrequency() + b.getFrequency(), null);

                parentNode.setLeftChild(a);
                parentNode.setRightChild(b);
                queue.add(parentNode);

            } else {
                huffmanTree = queue.poll();
                System.out.println("Done");
            }

        }
        return huffmanTree;


    }

    public String encode(HuffmanNode tree, String str) {
        String encodedMessage = "";
        char[] listChars = str.toCharArray();
        HashMap<Character, String> codeMap = new HashMap<>();

        getCodesFromTree(tree, "", codeMap);

        for (Character c : listChars
                ) {
            encodedMessage = encodedMessage + codeMap.get(c);
        }
        System.out.println(encodedMessage);
        return encodedMessage;
    }


    public void getCodesFromTree(HuffmanNode node, String code, Map<Character, String> codes) {

        if (node == null) {
            return;
        }
        if (node.getCharacter() != null) {
            codes.put(node.getCharacter(), code);
        } else {
            getCodesFromTree(node.getLeftChild(), code + "0", codes);
            getCodesFromTree(node.getRightChild(), code + "1", codes);
        }
    }

    public String decode(String input, HuffmanNode tree) {


        char[] charInput = input.toCharArray();
        String decodedMessage = "";

        HashMap<Character, String> codeMap = new HashMap<>();
        HashMap<String, Character> reversedCodeMap = new HashMap<>();

        String code = "";
        getCodesFromTree(tree, code, codeMap);

        for (Map.Entry<Character, String> entry : codeMap.entrySet()) {
            reversedCodeMap.put(entry.getValue(), entry.getKey());
        }

        code = "";

        for (char c :
                charInput) {

            code = code + c;

            if (codeMap.containsValue(code)) {
                decodedMessage = decodedMessage + reversedCodeMap.get(code);
                code = "";
            }

        }
        System.out.println(decodedMessage);
        return decodedMessage;
    }


}


package com.huffmancompressor;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Waiting for input...");
        String input = scanner.nextLine();
        HuffmanCompressor hc = new HuffmanCompressor();
        HuffmanNode n = hc.buildTree(input);
        hc.decode(hc.encode(n, input), n);

    }
}

package com.huffmancompressor;

import java.io.Serializable;

public class HuffmanNode implements Serializable {

    private int frequency;
    private HuffmanNode rightChild;
    private HuffmanNode leftChild;
    private Character character;
    private boolean hasChildren = false;


    public HuffmanNode(int frequency, Character character) {
        this.frequency = frequency;
        this.character = character;
    }

    public int getFrequency() {
        return frequency;
    }

    public HuffmanNode getRightChild() {
        hasChildren = true;
        return rightChild;
    }

    public HuffmanNode getLeftChild() {
        hasChildren = true;
        return leftChild;
    }

    public Character getCharacter() {
        return character;
    }

    public void setRightChild(HuffmanNode rightChild) {
        this.rightChild = rightChild;
    }

    public void setLeftChild(HuffmanNode leftChild) {
        this.leftChild = leftChild;
    }

}

package com.java.datastructure.CH06;

public class ThreadNode {
    int value;
    int leftThread;
    int rightThread;
    ThreadNode leftNode;
    ThreadNode rightNode;

    public ThreadNode(int value) {
        this.value = value;
        this.leftThread = 0;
        this.leftNode = null;
        this.rightThread = 0;
        this.rightNode = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append("value:").append(this.value).append(",leftThread:").append(this.leftThread)
                .append(",leftNode:").append(this.leftNode != null ? this.leftNode.value : "").append(",rightThread:")
                .append(this.rightThread).append(",rightNode:").append(this.rightNode != null ? rightNode.value : "")
                .append("]");
        return sb.toString();
    }
}

package com.java.datastructure.CH06;

public class ThreadedBinaryTree {
    public ThreadNode rootNode;
    public static ThreadNode preNode = null;;

    public ThreadedBinaryTree() {
        this.rootNode = null;
    }

    public ThreadedBinaryTree(int[] value) {
        for (int i = 0; i < value.length; i++) {
            addNodeToTree(value[i]);
        }
    }

    public void addNodeToTree(int data) {
        ThreadNode newNode = new ThreadNode(data);
        if (this.rootNode == null) {
            this.rootNode = newNode;
        } else {
            ThreadNode currentNode = this.rootNode;
            while (true) {
                if (data < currentNode.value) {
                    if (currentNode.leftNode == null) {
                        currentNode.leftNode = newNode;
                        break;
                    } else {
                        currentNode = currentNode.leftNode;
                    }
                } else {
                    if (currentNode.rightNode == null) {
                        currentNode.rightNode = newNode;
                        break;
                    } else {
                        currentNode = currentNode.rightNode;
                    }
                }
            }
        }
    }

    public static ThreadNode createBinaryTree(int[] array, int index) {
        ThreadNode node = null;
        if (index < array.length) {
            System.out.println(index + ":" + array[index]);
            node = new ThreadNode(array[index]);
            ThreadNode left = createBinaryTree(array, index * 2 + 1);
            if (left == null) {
                node.leftThread = 1;
            } else {
                node.leftNode = left;
            }
            ThreadNode right = createBinaryTree(array, index * 2 + 2);
            if (left == null) {
                node.rightThread = 1;
            } else {
                node.rightNode = right;
            }
        }
        return node;
    }

    public static void preThreadOrder(ThreadNode node) {
        if (node == null) {
            return;
        }
        System.out.println("preThreadOrder start node:" + node.toString());
        if (preNode == null) {
            System.out.println("preThreadOrder start preNode:");
        } else {
            System.out.println("preThreadOrder start preNode:" + preNode.toString());
        }

        if (node.leftNode == null) {
            node.leftNode = preNode;
            node.leftThread = 1;
        }
        if (preNode != null && preNode.rightNode == null) {
            preNode.rightNode = node;
            preNode.rightThread = 1;
        }
        if (preNode == null) {
            System.out.println("preThreadOrder end preNode:");
        } else {
            System.out.println("preThreadOrder end preNode:" + preNode.toString());
        }
        preNode = node;

        if (node.leftThread == 0) {
            preThreadOrder(node.leftNode);
        }
        if (node.rightThread == 0) {
            preThreadOrder(node.rightNode);
        }
        System.out.println("preThreadOrder end node:" + node.toString());
    }

    public void preThreadList(ThreadNode node) {
        while (node != null) {
            while (node.leftThread == 0) {
                System.out.print(node.value + ", ");
                node = node.leftNode;
            }
            System.out.print(node.value + ", ");
            node = node.rightNode;
        }
    }

    public static void inThreadOrder(ThreadNode node) {
        if (node == null) {
            return;
        }
        System.out.println("inThreadOrder start node:" + node.toString());

        if (node.leftThread == 0) {
            inThreadOrder(node.leftNode);
        }
        if (preNode == null) {
            System.out.println("inThreadOrder start preNode:");
        } else {
            System.out.println("inThreadOrder start preNode:" + preNode.toString());
        }

        if (node.leftNode == null) {
            node.leftNode = preNode;
            node.leftThread = 1;
        }
        if (preNode != null && preNode.rightNode == null) {
            preNode.rightNode = node;
            preNode.rightThread = 1;
        }
        if (preNode == null) {
            System.out.println("inThreadOrder end preNode:");
        } else {
            System.out.println("inThreadOrder end preNode:" + preNode.toString());
        }

        preNode = node;
        if (node.rightThread == 0) {
            inThreadOrder(node.rightNode);
        }
        System.out.println("inThreadOrder end node:" + node.toString());
    }

    public void inThreadList(ThreadNode node) {
        while (node.leftThread == 0) {
            node = node.leftNode;
        }
        while (node != null) {
            System.out.print(node.value + " ");
            if (node.rightThread ==  1) {
                node = node.rightNode;
            } else {
                node = node.rightNode;
                while (node != null && node.leftThread == 0) {
                    node = node.leftNode;
                }
            }
        }
    }
}

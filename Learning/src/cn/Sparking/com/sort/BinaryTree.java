package cn.Sparking.com.sort;


import java.util.ArrayList;
import java.util.Arrays;

public class BinaryTree {
    private TreeNode root;
    private int size = 0;

    public BinaryTree() {
        // TODO Auto-generated constructor stub
    }

    public BinaryTree(int value) {
        // TODO Auto-generated constructor stub
        this.root = new TreeNode(value);
        this.size = 1;
    }

    public TreeNode getRoot() {
        return root;
    }

    public int getMax() {
        TreeNode node = root;
        while (node.rightChildNode != null) {
            node = node.rightChildNode;
        }
        return node.value;
    }

    public int getMin() {
        TreeNode node = root;
        while (node.leftChildNode != null) {
            node = node.leftChildNode;
        }
        return node.value;
    }

    public void preOrderTreeWalk(TreeNode node, ArrayList<Integer> container) {
        if (node != null) {
            container.add(node.value);
            preOrderTreeWalk(node.leftChildNode, container);
            preOrderTreeWalk(node.rightChildNode, container);
        }
    }

    public void midOrderTreeWalk(TreeNode node, ArrayList<Integer> container) {
        if (node != null) {
            midOrderTreeWalk(node.leftChildNode, container);
            container.add(node.value);
            midOrderTreeWalk(node.rightChildNode, container);
        }
    }

    public void postOrderTreeWalk(TreeNode node, ArrayList<Integer> container) {
        if (node != null) {
            postOrderTreeWalk(node.leftChildNode, container);
            postOrderTreeWalk(node.rightChildNode, container);
            container.add(node.value);
        }
    }

    public TreeNode search(int value) {
        TreeNode node = root;
        while (node.value != value) {
            if (value < node.value) {
                node = node.leftChildNode;
            } else {
                node = node.rightChildNode;
            }
            if (node == null) {
                node = null;
            }
        }
        return node;
    }

    private TreeNode findParentNode(int value) {
        TreeNode parent = null;
        TreeNode node = root;
        while (node.value != value) {
            parent = node;
            if (value < node.value) {
                node = node.leftChildNode;
            } else {
                node = node.rightChildNode;
            }
            if (node == null) {
                node = null;
                parent = null;
            }
        }
        return parent;
    }

    public void createBinaryTree(int[] data) {
        if (data != null) {
            for (int i : data) {
                insert(i);
            }
        }
    }

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            TreeNode curNode = root;
            TreeNode parentNode;
            while (true) {
                parentNode = curNode;
                if (value < curNode.value) {
                    curNode = curNode.leftChildNode;
                    if (curNode == null) {
                        parentNode.leftChildNode = new TreeNode(value);
                        parentNode.leftChildNode.leftOrRight = -1;
                        break;
                    }
                } else {
                    curNode = curNode.rightChildNode;
                    if (curNode == null) {
                        parentNode.rightChildNode = new TreeNode(value);
                        parentNode.rightChildNode.leftOrRight = 1;
                        break;
                    }
                }
            }
        }
        ++size;
    }

    public boolean delete(int value) {
        boolean flag = false;
        TreeNode node = search(value);
        TreeNode parent = findParentNode(value);
        if (node != null) {
            if (node.equals(root)) {
                root = null;
            }
            if (node.leftChildNode == null && node.rightChildNode == null) {
                if (node.leftOrRight == 1) {
                    node = null;
                    parent.rightChildNode = null;
                }
                if (node.leftOrRight == -1) {
                    node = null;
                    parent.leftChildNode = null;
                }
            } else if (node.leftChildNode != null
                    && node.rightChildNode != null) {
                TreeNode successor = findSuccessor(node);
                if (node.leftOrRight == -1) {
                    parent.leftChildNode = successor;
                    parent.leftChildNode.leftOrRight = -1;
                }
                if (node.leftOrRight == 1) {
                    parent.rightChildNode = successor;
                    parent.rightChildNode.leftOrRight = 1;
                }
                successor.leftChildNode = node.leftChildNode;
            } else {
                if (node.leftChildNode != null) {
                    if (node.leftOrRight == 1) {
                        parent.rightChildNode = node.leftChildNode;
                    }
                    if (node.leftOrRight == -1) {
                        parent.leftChildNode = node.leftChildNode;
                    }
                }
                if (node.rightChildNode != null) {
                    if (node.leftOrRight == 1) {
                        parent.rightChildNode = node.rightChildNode;
                    }
                    if (node.leftOrRight == -1) {
                        parent.leftChildNode = node.rightChildNode;
                    }
                }
                node = null;
            }
            flag = true;
            --size;
        }
        return flag;
    }

    private TreeNode findSuccessor(TreeNode delNode) {
        TreeNode parent = delNode;
        TreeNode successor = delNode;
        TreeNode curNode = delNode.rightChildNode;

        while (curNode != null) {
            parent = successor;
            successor = curNode;
            curNode = curNode.leftChildNode;
        }
        if (!successor.equals(delNode.rightChildNode)) {
            parent.leftChildNode = successor.rightChildNode;
            successor.rightChildNode = delNode.rightChildNode;
        }
        return successor;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size == 0;
    }

    public class TreeNode {
        int leftOrRight = 0;// 0: root;-1:left child node;1, right childe node;
        Integer value;
        TreeNode leftChildNode;
        TreeNode rightChildNode;

        public TreeNode(Integer value) {
            // TODO Auto-generated constructor stub
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            // TODO Auto-generated method stub
            if (obj instanceof TreeNode) {
                TreeNode node = (TreeNode) obj;
                return node.value == this.value;
            }
            return false;
        }

        @Override
        public String toString() {
            return "TreeNode [leftOrRight="
                    + leftOrRight
                    + ", value="
                    + value
                    + (leftChildNode != null ? ", leftChildNode="
                            + leftChildNode : "")
                    + (rightChildNode != null ? ", rightChildNode="
                            + rightChildNode : "") + "]";
        }
    }
    

        /**
         * @param args
         */
        public static void main(String[] args) {
            // TODO Auto-generated method stub
            int[] data = { 21, 25, 16, 32, 22, 19, 13, 20 };
            System.out.println("input: " + Arrays.toString(data));
            BinaryTree bTree = new BinaryTree();
            System.out.println(bTree.isEmpty() + "--" + bTree.size());
            bTree.createBinaryTree(data);
            System.out.println(bTree.isEmpty() + "--" + bTree.size());
            ArrayList<Integer> container = new ArrayList<Integer>();
            TreeNode root = bTree.getRoot();
            container.clear();
            bTree.preOrderTreeWalk(root, container);
            System.out.println("pre Order Binary Tree Walk: "
                    + container.toString());
            container.clear();
            bTree.midOrderTreeWalk(root, container);
            System.out.println("mid Order Binary Tree Walk: "
                    + container.toString());
            container.clear();
            bTree.postOrderTreeWalk(root, container);
            System.out.println("post Order Binary Tree Walk: "
                    + container.toString());
            System.out.println("Max Value: " + bTree.getMax());
            System.out.println("Max Value: " + bTree.getMin());
            // change the function findParentNode() to be private
            // TreeNode parent = bTree.findParentNode(25);
            // if (parent != null) {
            // System.out.println("Parent Value: " + parent.toString());
            // }
            // delete a node which has no child nodes, successfully
            // bTree.delete(13);
            // container.clear();
            // bTree.midOrderTreeWalk(root, container);
            // System.out.println("mid Order Binary Tree Walk: "
            // + container.toString());
            // container.clear();
            // bTree.postOrderTreeWalk(root, container);
            // System.out.println("post Order Binary Tree Walk: "
            // + container.toString());
            // delete a node which has a right child node, successfully
            // bTree.delete(19);
            // container.clear();
            // bTree.preOrderTreeWalk(root, container);
            // System.out.println("pre Order Binary Tree Walk: "
            // + container.toString());
            // container.clear();
            // bTree.midOrderTreeWalk(root, container);
            // System.out.println("mid Order Binary Tree Walk: "
            // + container.toString());

            // delete a node which has a right child node, successfully
            bTree.delete(16);
            container.clear();
            bTree.preOrderTreeWalk(root, container);
            System.out.println("pre Order Binary Tree Walk: "
                    + container.toString());
            container.clear();
            bTree.midOrderTreeWalk(root, container);
            System.out.println("mid Order Binary Tree Walk: "
                    + container.toString());
        }
}
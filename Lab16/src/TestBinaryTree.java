import java.util.*;


class TestBinaryTree {
    public static void main(String[] args) {
        BinarySearchTree bt1 = new BinarySearchTree();

        //insertRec
        bt1.insert(39);
        bt1.insert(27);
        bt1.insert(18);
        bt1.insert(9);
        bt1.insert(10);
        bt1.insert(21);
        bt1.insert(19);
        bt1.insert(29);
        bt1.insert(28);
        bt1.insert(36);
        bt1.insert(45);
        bt1.insert(40);
        bt1.insert(54);
        bt1.insert(59);
        bt1.insert(65);
        bt1.insert(60);
        System.out.println(bt1);

        //preorder
        System.out.println("Pre order :");
        bt1.preorder(bt1.root);

        //inorder
        System.out.println("\nIn order :");
        bt1.inorder(bt1.root);

        //postorder
        System.out.println("\nPost order :");
        bt1.postorder(bt1.root);
    }
}


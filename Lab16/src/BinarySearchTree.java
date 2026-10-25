class BinarySearchTree {
    Node root;

    @Override
    public String toString() {
        return printTree(root);
    }
    public String printTree(Node root) {
        if (root != null) {
            int x = (int) root.key;
            String str = Integer.toString(x) + ",";
            return str + printTree(root.left) + printTree(root.right)   ;
        }
        else return "";
    }

    // แทรกโหนดใหม่
    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    // ค้นหาโหนด
    boolean search(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;
        return key < root.key ? search(root.left, key) : search(root.right, key);
    }

    // ลบโหนด
    Node delete(Node root, int key) {
        if (root == null) return root;

        if (key < root.key)
            root.left = delete(root.left, key);
        else if (key > root.key)
            root.right = delete(root.right, key);
        else {
            // กรณีไม่มีลูกหรือมีลูกเดียว
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // กรณีมีลูกสองคน → หา inorder successor
            root.key = minValue(root.right);
            root.right = delete(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // Traversal ทั้ง 3 แบบ
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key + " ");
        }
    }
}

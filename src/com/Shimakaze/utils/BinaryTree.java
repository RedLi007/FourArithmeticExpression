package com.Shimakaze.utils;

import java.util.ArrayList;

public class BinaryTree {

    private TreeNode root;
    private int numOperator;
    private ArrayList<TreeNode> operatorList = new ArrayList<TreeNode>();

    public BinaryTree(int numOperator) {
        this.numOperator = numOperator;
    }

    public int getNum() {
        return numOperator;
    }

    public void setNum(int numOperator) {
        this.numOperator = numOperator;
    }

    public void setTreeNode(TreeNode root) {
        this.root = root;
    }


    //计算并验证表达式
    public String CalAndVal() {
        return root.getResult();
    }

    //获取最终的表达式，必须在CalAndVal()方法后调用
    public String Expression() {
        String str = root.Brackets();
        str = str.substring(1, str.length() - 1); //去掉首位括号
        return str;
    }

    // 计算二叉树的深度(层数)
    public int getDeep() {
        int deep = 2; //最少1个符号2层
        if (this.numOperator == 2 || this.numOperator == 3) deep = 3;
        return deep;
    }

/*生成二叉树(3种情况)
 	     +                  +               +
	   /   \              /   \            / \
      ×     ×            ×     3          1   2
     / \   / \          / \
    1  2   3  4        1   2

 */

    public void createBTree(int rangeNumber) {
        TreeNode lchild, rchild, lnode, rnode;

        if (numOperator == 1) {
            lchild = new TreeNode(String.valueOf(getOPERATORandNUMBER.getNumber(rangeNumber)), null, null);
            rchild = new TreeNode(String.valueOf(getOPERATORandNUMBER.getNumber(rangeNumber)), null, null);
            root = new TreeNode(String.valueOf(getOPERATORandNUMBER.getOperator()), lchild, rchild);
        } else {
            int num1 = 0;
            int n = getDeep() - 3;
            boolean[] position = getOPERATORandNUMBER.getChildPosition(numOperator);
            root = new TreeNode(String.valueOf(getOPERATORandNUMBER.getOperator()), null, null);
            operatorList.add(root);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < (int) Math.pow(2, i); j++, num1++) {
                    lchild = new TreeNode(String.valueOf(getOPERATORandNUMBER.getOperator()), null, null);
                    rchild = new TreeNode(String.valueOf(getOPERATORandNUMBER.getOperator()), null, null);
                    operatorList.get(j + num1).setChild(lchild, rchild);
                    operatorList.add(lchild);
                    operatorList.add(rchild);
                }
            }

            for (int i = 0; i < position.length; i++) {
                if (position[i]) {
                    lnode = new TreeNode(String.valueOf(getOPERATORandNUMBER.getNumber(rangeNumber)), null, null);
                    rnode = new TreeNode(String.valueOf(getOPERATORandNUMBER.getNumber(rangeNumber)), null, null);
                    if (i % 2 == 0) {
                        lchild = new TreeNode(String.valueOf(getOPERATORandNUMBER.getOperator()), lnode, rnode);
                        operatorList.add(lchild);
                        operatorList.get(num1).setLchild(lchild);
                    } else {
                        rchild = new TreeNode(String.valueOf(getOPERATORandNUMBER.getOperator()), lnode, rnode);
                        operatorList.add(rchild);
                        operatorList.get(num1).setRchild(rchild);
                    }
                } else {
                    if (i % 2 == 0) {
                        lchild = new TreeNode(String.valueOf(getOPERATORandNUMBER.getNumber(rangeNumber)), null, null);
                        operatorList.get(num1).setLchild(lchild);
                    } else {
                        rchild = new TreeNode(String.valueOf(getOPERATORandNUMBER.getNumber(rangeNumber)), null, null);
                        operatorList.get(num1).setRchild(rchild);
                    }
                }
                num1 = num1 + i % 2;
            }
        }
    }

}

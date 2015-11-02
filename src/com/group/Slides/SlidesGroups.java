/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group.Slides;

import com.group.BST.BST;
import com.group.DoubleLinkedList.DoubleLinkedList;
import com.group.Tools.Answer;

/**
 *
 * @author admin
 */
public class SlidesGroups {

    public static DoubleLinkedList<Slide> welcome = new DoubleLinkedList<Slide>(); 
    public static DoubleLinkedList<Slide> BSTTutorial = new DoubleLinkedList<Slide>(); 
    
    
    
    static{ //static call
        init();
    }
    
    public static void init(){
        

        BST<Integer> tree = new BST<>();
        
        tree.insert(50);
       
         for (int i = 0; i < 17; i++) {
            tree.insert((int) (Math.random() * 100));
            
        }
        
        /***********************************************************************
         * a welcome slide to start the program. With kind of and introduction
         ***********************************************************************/
        Slide welcomeSlide = new Slide(
                "Welcome to the tutorial about Binary Search Trees",
                Answer.NONE,
                tree,
                false,
                false
        );
        
        welcome.addFront(welcomeSlide); //adding slides to the welcome group
        
        
         /***********************************************************************
         * Here starts the creation of the trees that are gonna be used in the 
         * Tutorial
         ***********************************************************************/
        
        BST<Integer> BSTSlide_1_tree = new BST<>(); //first slide tree
        
        BSTSlide_1_tree.insert(50);
        BSTSlide_1_tree.insert(25);
        BSTSlide_1_tree.insert(75);
        
        BST<Integer> BSTSlide_2_tree = new BST<>(); //second slide tree
        
        BSTSlide_2_tree.insert(50);
        BSTSlide_2_tree.insert(25);
        BSTSlide_2_tree.insert(75);
        BSTSlide_2_tree.insert(15);
        BSTSlide_2_tree.insert(30);
        BSTSlide_2_tree.insert(65);
        BSTSlide_2_tree.insert(85);
        
        BST<Integer> BSTSlide_3_tree = new BST<>(); //third slide tree
        
        BSTSlide_3_tree.insert(50);
        BSTSlide_3_tree.insert(25);
        BSTSlide_3_tree.insert(75);
        BSTSlide_3_tree.insert(15);
        BSTSlide_3_tree.insert(30);
        BSTSlide_3_tree.insert(65);
        BSTSlide_3_tree.insert(85);
        BSTSlide_3_tree.insert(12);
        BSTSlide_3_tree.insert(16);
        BSTSlide_3_tree.insert(90);
        
        BST<Integer> BSTSlide_4_tree = new BST<>(); //fourth slide tree
        
        BST<Integer> BSTSlide_5_tree = BSTSlide_3_tree;
        
        BST<Integer> BSTSlide_6_tree = BSTSlide_5_tree;
        
        BST<Integer> BSTSlide_7_tree = new BST<>();
        
        BSTSlide_7_tree.insert(50);
        BSTSlide_7_tree.insert(25);
        BSTSlide_7_tree.insert(75);
        BSTSlide_7_tree.insert(15);
        BSTSlide_7_tree.insert(30);
        BSTSlide_7_tree.insert(65);
        
        BST<Integer> BSTSlide_8_tree = new BST<>();
        
        BSTSlide_8_tree.insert(67);
        BSTSlide_8_tree.insert(35);
        BSTSlide_8_tree.insert(28);
        BSTSlide_8_tree.insert(33);
        BSTSlide_8_tree.insert(89);
        BSTSlide_8_tree.insert(82);
        BSTSlide_8_tree.insert(12);
        BSTSlide_8_tree.insert(26);
        BSTSlide_8_tree.insert(34);
        
        
        BST<Integer> BSTSlide_9_tree = new BST<>();
        
        BSTSlide_9_tree.insert(25);
        BSTSlide_9_tree.insert(33);
        BSTSlide_9_tree.insert(15);
        BSTSlide_9_tree.insert(16);
        BSTSlide_9_tree.insert(10);
        
        BST<Integer> BSTSlide_10_tree = new BST<>();
        
        BSTSlide_10_tree.insert(25);
        BSTSlide_10_tree.insert(98);
        BSTSlide_10_tree.insert(12);
        BSTSlide_10_tree.insert(23);
        BSTSlide_10_tree.insert(45);
        BSTSlide_10_tree.insert(43);
        BSTSlide_10_tree.insert(22);
        BSTSlide_10_tree.insert(11);
        BSTSlide_10_tree.insert(67);
        BSTSlide_10_tree.insert(78);
        BSTSlide_10_tree.insert(3);
        
        BST<Integer> BSTSlide_11_tree = new BST<>();
        
        BSTSlide_11_tree.insert(56);
        BSTSlide_11_tree.insert(22);
        BSTSlide_11_tree.insert(11);
        BSTSlide_11_tree.insert(30);
        BSTSlide_11_tree.insert(88);
        BSTSlide_11_tree.insert(78);
        BSTSlide_11_tree.insert(90);
        BSTSlide_11_tree.insert(99);
        
        BST<Integer> BSTSlide_12_tree = new BST<>();
         
        BSTSlide_12_tree.insert(56);
        BSTSlide_12_tree.insert(24);
        BSTSlide_12_tree.insert(60);
        BSTSlide_12_tree.insert(12);
        BSTSlide_12_tree.insert(26);
        
        BST<Integer> BSTSlide_13_tree = BSTSlide_12_tree;
        
        BST<Integer> BSTSlide_14_tree = BSTSlide_13_tree;
        
        BST<Integer> BSTSlide_15_tree = new BST<>();
        
        BSTSlide_15_tree.insert(56);
        BSTSlide_15_tree.insert(76);
        BSTSlide_15_tree.insert(78);
        BSTSlide_15_tree.insert(60);
        BSTSlide_15_tree.insert(34);
        BSTSlide_15_tree.insert(38);
        BSTSlide_15_tree.insert(12);
        
        BST<Integer> BSTSlide_16_tree = new BST<>();
        
        BSTSlide_16_tree.insert(25);
        BSTSlide_16_tree.insert(33);
        BSTSlide_16_tree.insert(10);
        
        BST<Integer> BSTSlide_17_tree = new BST<>();
        
        BSTSlide_17_tree.insert(25);
        BSTSlide_17_tree.insert(33);
        BSTSlide_17_tree.insert(10);
        BSTSlide_17_tree.insert(11);
        
        BST<Integer> BSTSlide_18_tree = new BST<>();
        
        BSTSlide_18_tree.insert(25);
        BSTSlide_18_tree.insert(34);
        BSTSlide_18_tree.insert(10);
        BSTSlide_18_tree.insert(15);
        BSTSlide_18_tree.insert(8);
        BSTSlide_18_tree.insert(16);
        BSTSlide_18_tree.insert(50);
        BSTSlide_18_tree.insert(5);
        BSTSlide_18_tree.insert(8);
        BSTSlide_18_tree.insert(35);
        BSTSlide_18_tree.insert(60);
        BSTSlide_18_tree.insert(11);
         
        BST<Integer> BSTSlide_19_tree = new BST<>();
        
        BSTSlide_19_tree.insert(30);
        BSTSlide_19_tree.insert(50);
        BSTSlide_19_tree.insert(25);
        BSTSlide_19_tree.insert(12);
        BSTSlide_19_tree.insert(8);
        BSTSlide_19_tree.insert(15);
        BSTSlide_19_tree.insert(80);
        BSTSlide_19_tree.insert(90);
        BSTSlide_19_tree.insert(95);
        
        BST<Integer> BSTSlide_20_tree = new BST<>();
        
        BSTSlide_20_tree.insert(30);
        BSTSlide_20_tree.insert(50);
        BSTSlide_20_tree.insert(25);
        BSTSlide_20_tree.insert(12);
        BSTSlide_20_tree.insert(8);
        BSTSlide_20_tree.insert(15);
        BSTSlide_20_tree.insert(80);
        BSTSlide_20_tree.insert(90);
        
        BST<Integer> BSTSlide_21_tree = new BST<>();
        
        BSTSlide_21_tree.insert(30);
        BSTSlide_21_tree.insert(50);
        BSTSlide_21_tree.insert(25);
        BSTSlide_21_tree.insert(12);
        BSTSlide_21_tree.insert(8);
        BSTSlide_21_tree.insert(15);
        BSTSlide_21_tree.insert(90);
        
        BST<Integer> BSTSlide_22_tree = new BST<>();
        
        BSTSlide_22_tree.insert(30);
        BSTSlide_22_tree.insert(50);
        BSTSlide_22_tree.insert(25);
        BSTSlide_22_tree.insert(8);
        BSTSlide_22_tree.insert(15);
        BSTSlide_22_tree.insert(90);
        
        BST<Integer> BSTSlide_23_tree = new BST<>();
        
        BSTSlide_23_tree.insert(30);
        BSTSlide_23_tree.insert(20);
        BSTSlide_23_tree.insert(26);
        BSTSlide_23_tree.insert(29);
        BSTSlide_23_tree.insert(13);
        BSTSlide_23_tree.insert(56);
        
        BST<Integer> BSTSlide_24_tree = new BST<>();
        
        BSTSlide_24_tree.insert(2);
        BSTSlide_24_tree.insert(1);
        BSTSlide_24_tree.insert(4);
        BSTSlide_24_tree.insert(3);
        BSTSlide_24_tree.insert(5);
        BSTSlide_24_tree.insert(6);
        
        BST<Integer> BSTSlide_25_tree = new BST<>();
         
        BSTSlide_25_tree.insert(4);
        BSTSlide_25_tree.insert(2);
        BSTSlide_25_tree.insert(1);
        BSTSlide_25_tree.insert(3);
        BSTSlide_25_tree.insert(5);
        BSTSlide_25_tree.insert(6);       
        
        BST<Integer> BSTSlide_26_tree = new BST<>();
        
        BSTSlide_26_tree.insert(45);
        BSTSlide_26_tree.insert(33);
        BSTSlide_26_tree.insert(67);
        BSTSlide_26_tree.insert(20);
        BSTSlide_26_tree.insert(40);
        BSTSlide_26_tree.insert(10);
        
        BST<Integer> BSTSlide_27_tree = new BST<>();
        
        BSTSlide_27_tree.insert(45);
        BSTSlide_27_tree.insert(12);
        BSTSlide_27_tree.insert(67);
        BSTSlide_27_tree.insert(80);
        BSTSlide_27_tree.insert(55);
        BSTSlide_27_tree.insert(54);
        
        BST<Integer> BSTSlide_28_tree = new BST<>();
        
        BSTSlide_28_tree.insert(55);
        BSTSlide_28_tree.insert(45);
        BSTSlide_28_tree.insert(12);
        BSTSlide_28_tree.insert(54);
        BSTSlide_28_tree.insert(67);
        BSTSlide_28_tree.insert(80);
        
        
        

        /***********************************************************************
         * Here starts the creation of the tutorial's Slides
         ***********************************************************************/
        
        Slide BSTSlide_1 = new Slide(
                "Binary Tree:\n     A Binary Tree is a data structure made up of elements called nodes,"
                     + " usually containing a node called root as its main node.",
                Answer.NONE,
                BSTSlide_1_tree,
                false,
                false
                
        );
        
        Slide BSTSlide_2 = new Slide(
                "Which Node is the parent node with value 15? \n\n"
                        + "A.) The node with value 30 \n"
                        + "B.) The node with value 75 \n"
                        + "C.) The node with value 25 \n"
                        + "D.) The node with value 50 \n",
                Answer.C,
                BSTSlide_2_tree,
                true,
                false
                
        );
        
        Slide BSTSlide_3 = new Slide(
                "Binary Search Trees: \n     A binary search tree(BST) is a special type of Binary Tree that"
                        + "has three conditions:\n\n"
                        + "1.) All nodes stored in the left subtree of a node "
                        + "whose root must be of value less than or equal to the "
                        + "value in the root node. \n"
                        + "2.) All nodes stored in the right subtree of a node "
                        + "(int n) must be of value more than . \n"
                        + "3.) No Duplicate values",
                Answer.NONE,
                BSTSlide_3_tree,
                false,
                false
                
        );
        
        Slide BSTSlide_4 = new Slide(
                 "Is this a Binary Search Tree? \n\n"
                         + "A.) True \n"
                         + "B.) False",
                 Answer.B,
                 BSTSlide_4_tree,
                 false,
                 true

         );
       
        Slide BSTSlide_5 = new Slide(
                 "Binary Trees: Height:\n     The height of a Binary Tree is simply the MAXIMUM distance when"
                         + " traveling from the root to the node. An easy way to "
                         + "find the height is to cound the number of \"Edges\" "
                         + "in the path from the root to the node. \n"
                         + "     If a tree only "
                         + "has one node then the height of the tree is zero, due "
                         + "to the fact that the root does not have any other node "
                         + "to travel to. For example, the height of node 75 is one"
                         + " due to the fact that the "
                         + "distance the root must travel or the amount of edges "
                         + "the root passed through to reach node 75 is one.",
                 Answer.NONE,
                 BSTSlide_5_tree,
                 false,
                 false

         );

        Slide BSTSlide_6 = new Slide(
                 "     What is the height of the WHOLE tree? \n\n"
                         + "A.) The height is 3 \n"
                         + "B.) The height is 2 \n"
                         + "C.) The height is 0 \n"
                         + "D.) The height is 1 \n",
                 Answer.A,
                 BSTSlide_6_tree,
                 true,
                 false

         );

        Slide BSTSlide_7 = new Slide(
                 "Binary Trees: Level:\n     The level of the binary tree is simply the amount of nodes "
                         + "travesed through when traveling from the root to "
                         + "the bottom most node. For example, the level of "
                         + "this tree is three because the root must traverse "
                         + "through three nodes before reaching the last node of the tree.",
                 Answer.NONE,
                 BSTSlide_7_tree,
                 false,
                 false

         );
        
        Slide BSTSlide_8 = new Slide(
                 "     What level is node 12? \n\n"
                         + "A.) The level is 1 \n"
                         + "B.) The level is 2 \n"
                         + "C.) The level is 3 \n"
                         + "D.) The level is 4 \n",
                 Answer.C,
                 BSTSlide_8_tree,
                 true,
                 false

         );
        
        Slide BSTSlide_9 = new Slide(
                 "Leaf Nodes:\n     A leaf node is a node with no children "
                         + "attached to it. For example, the leaf nodes in this "
                         + "tree are 10, 16, 33.",
                 Answer.NONE,
                 BSTSlide_9_tree,
                 false,
                 false

         );
        
        Slide BSTSlide_10 = new Slide(
                 "     What are the leaf node(s) of this tree? \n\n"
                         + "A.) The leaf are 12 y 98\n"
                         + "B.) The leaf are 3, 22, 43, 78 \n"
                         + "C.) The leaf are 3, 22, 78\n"
                         + "D.) The leaf are 3, 22\n",
                 Answer.B,
                 BSTSlide_10_tree,
                 true,
                 false

         );
        
        Slide BSTSlide_11 = new Slide(
                 "Balanced and Unbalanced Trees:\n     A Balanced tree is a tree "
                         + "where the height of the left and right subtrees at "
                         + "most differ by one. Where as an unbalanced tree the "
                         + "height of the left and right subtrees differ by more "
                         + "than one. For example, this tree is an unbalanced tree "
                         + "due to the height of the left subtree is one while the "
                         + "height of the right subtree is three.",
                 Answer.NONE,
                 BSTSlide_11_tree,
                 false,
                 false

         );
        
        Slide BSTSlide_12 = new Slide(
                 "Tree Traversal: Preorder:\n     Preorder traversal is a way to "
                         + "traverse and output the values stored in a tree. To "
                         + "traverse a tree in a preordered fashion you must first "
                         + "get the value of the root, next get the value of the "
                         + "left subtree and finally the value of the right. For "
                         + "example, if you were to traverse this tree in a preordered "
                         + "fashion the outputted values will be: 56, 24, 12, 26, 60.",
                 Answer.NONE,
                 BSTSlide_12_tree,
                 false,
                 false

         );
        
        Slide BSTSlide_13 = new Slide(
                 "Tree Traversal: Postorder:\n     Postorder traversal is another "
                         + "way to traverse a tree. Unlike preorder traversal, "
                         + "postorder traversal outputs the root of the tree LAST "
                         + "instead of first like pre-ordered. For example, if one "
                         + "were to traverse and output the contents of this tree "
                         + "in a postordered fashion the output would be: 12, 26, 24, 60, 56.",
                 Answer.NONE,
                 BSTSlide_13_tree,
                 false,
                 false

         );
        
        Slide BSTSlide_14 = new Slide(
                 "Tree Traversal: In-Order:\n     The final way to traverse a "
                         + "tree that will be covered in this tutorial is "
                         + "In-order traversal. In-order traversal is different "
                         + "from both postorder and preorder traversal in that the "
                         + "root is outputted second, after the left and before "
                         + "the right. When this tree is traversed in an in-ordered"
                         + " fashion the output would be: 12, 24, 26, 56, 60.",
                 Answer.NONE,
                 BSTSlide_14_tree,
                 false,
                 false

         );
        
        Slide BSTSlide_15 = new Slide(
                 "     What values will be outputted when this tree is traversed "
                         + "in postorder? \n\n"
                         + "A.) 12, 34, 56, 76, 78, 38, 60\n"
                         + "B.) 12, 34, 38, 56, 60, 76, 78\n"
                         + "C.) 12, 38, 34, 60, 78, 76, 56\n"
                         + "D.) 12, 38, 60, 78\n",
                 Answer.C,
                 BSTSlide_15_tree,
                 true,
                 false

         );
        
         Slide BSTSlide_16 = new Slide(
                 "Inserting Nodes in a Binary Search Tree:\n     To insert a node "
                         + "into a Binary Search Tree first you must compare the "
                         + "value of the root node with the value of the node you "
                         + "wish to insert. if the node is smaller than the root "
                         + "of the left subtree will be checked in the same way as "
                         + "the root. This process will continue until we reach a "
                         + "leaf node where a final check will occur. To see an "
                         + "example of this press the \"next\" button below to see "
                         + "where the number 11 gets added to this tree.",
                 Answer.NONE,
                 BSTSlide_16_tree,
                 false,
                 false

         );
         
         Slide BSTSlide_17 = new Slide(
                 "Inserting Nodes in a Binary Search Tree:\n     Here we can "
                         + "appreciate how the 11 has been inserting to "
                         + "the right side of 10. We compared to 25 "
                         + "and we go left because is smaller. then we compare to 10 "
                         + "and we go right because is bigger. Because we have no other "
                         + "nodes to compare to we insert it in that position",
                 Answer.NONE,
                 BSTSlide_17_tree,
                 false,
                 false

         );
         
         Slide BSTSlide_18 = new Slide(
                 "Where would the value 31 be added in this Binary Search Tree?\n\n"
                         + "A.) It is not allow to insert it\n"
                         + "B.) left side of 5\n"
                         + "C.) right side of 16\n"
                         + "D.) Left side of 34\n",
                 Answer.D,
                 BSTSlide_18_tree,
                 true,
                 false

         );
         
         Slide BSTSlide_19 = new Slide(
                 "Removing Node From Tree:\n     Deleting a node is a bit more "
                         + "complicated than inserting a node. This is mainly on "
                         + "the fact that there are three different scenarios to consider:\n\n"
                         + "1.)     The node you want to delete is a leaf node then "
                         + "the node is just simply deleted\n"
                         + "2.)     If the node you want to delete has only one child "
                         + "node attached to it than after you delete the node "
                         + "you want to delete you must change the pointer that "
                         + "was originally pointing to the child elsewhere that is appropriate\n"
                         + "3.)     If the node you want to delete has two child nodes "
                         + "than after you delete the node you want to delete you"
                         + " must replace the node you are going to delete with "
                         + "either the smallest element in the right subtree OR the "
                         + "largest element in the left subtree. After you replace the "
                         + "two nodes you can now delete the node. To see an example of "
                         + "each case press \"next\".\n",
                 Answer.NONE,
                 BSTSlide_19_tree,
                 false,
                 false

         );
         
        Slide BSTSlide_20 = new Slide(
                 "Case 1:\n     Deleting node 95 that is a leaf",
                 Answer.NONE,
                 BSTSlide_20_tree,
                 false,
                 false

         );
        
         Slide BSTSlide_21 = new Slide(
                 "Case 2:\n     Deleting node 80 that has only one child",
                 Answer.NONE,
                 BSTSlide_21_tree,
                 false,
                 false

         );
         
         Slide BSTSlide_22 = new Slide(
                 "Case 3:\n     Deleting node 12 with two children",
                 Answer.NONE,
                 BSTSlide_22_tree,
                 false,
                 false

         );
         
         Slide BSTSlide_23 = new Slide(
                 "     In this Binary Search Tree when node 20 gets deleted which node takes its place? \n\n"
                         + "A.) Node 30 takes its place\n"
                         + "B.) Node 26 takes its place and on the left side of it goes 13.\n"
                         + "C.) Node 29 takes its place. on the right side goes 26 and on the left side 13\n"
                         + "D.) Node 26 takes its place and 13 goes on the right side of 29\n",
                 Answer.B,
                 BSTSlide_23_tree,
                 true,
                 false

         );
         
         Slide BSTSlide_24 = new Slide(
                 "Single Rotation:\n     Rotations are used to balance previously "
                         + "unbalanced trees there are two kinds of rotations; Single "
                         + "Rotations and Double Rotations. A single rotation switches "
                         + "the roles of the parent and child nodes while maintaining the "
                         + "search order of the tree. Single rotations handle two different cases:\n\n"
                         + "1.)     When a node is inserted into the left subtree of the "
                         + "left child of the node that will be rebalanced \n"
                         + "2.)When a node is inserted into the right Subtree of "
                         + "the right child of the node that will be rebalanced\n\n"
                         + " An example of a single rotation will be seen in the next slide. "
                         + "Where the current unbalanced right subtree will be rotated so as to balance it.",
                 Answer.NONE,
                 BSTSlide_24_tree,
                 false,
                 false

         );
         
         Slide BSTSlide_25 = new Slide(
                 "As you can see here the right subtree was rotated and now node "
                         + "4 is now the parent of node 2",
                 Answer.NONE,
                 BSTSlide_25_tree,
                 false,
                 false

         );

         Slide BSTSlide_26 = new Slide(
                 "Which Subtree is unbalanced and which \"direction\" will that "
                         + "subtree be rotated in to balance it?\n\n"
                         + "A.) Left subtree, left \n" 
                         + "B.) Left subtree, right \n" 
                         + "C.) Right subtree, left \n" 
                         + "D.) Right subtree, right ",
                 Answer.B,
                 BSTSlide_26_tree,
                 true,
                 false

         );
         
         Slide BSTSlide_27 = new Slide(
                 "Double Rotation:\n     Double rotation is used to balance a "
                         + "tree just like single rotation except Double rotation "
                         + "has is used in two different cases where a single rotation will not be enough.\n\n"
                         + "1.) When a node is inserted in the right subtree of the left child of the node that will be rebalanced \n"
                         + "2.) When a node is inserted in the left subtree of the right child of the node that will be rebalanced \n\n"
                         + "In the two cases stated above single rotation will "
                         + "not suffice and we must use a double rotation in order "
                         + "to re-balance the binary tree. A double rotation in practice "
                         + "is simply just two single rotations. One to rotate the node"
                         + " we need to rebalance and then another rotation on the now "
                         + "rotated subtree. This unbalced tree illustrated here will be "
                         + "re-balanced using double rotation in the next slide. (Press \"next\") ",
                 Answer.NONE,
                 BSTSlide_27_tree,
                 false,
                 false

         );
         
         Slide BSTSlide_28 = new Slide(
                 "As you can see here the right subtree where 67 is the root was "
                         + "rotated to the right being now 55 the root. Then the "
                         + "subtree where 45 is the root was rotated to the left "
                         + "being now 55 the root.",
                 Answer.NONE,
                 BSTSlide_28_tree,
                 false,
                 false

         );
        /***********************************************************************
         * Here we add the slides to the BSTTutorial group
         ***********************************************************************/
        
        BSTTutorial.addFront(BSTSlide_1);
        BSTTutorial.addFront(BSTSlide_2);
        BSTTutorial.addFront(BSTSlide_3);
        BSTTutorial.addFront(BSTSlide_4);
        BSTTutorial.addFront(BSTSlide_5);
        BSTTutorial.addFront(BSTSlide_6);
        BSTTutorial.addFront(BSTSlide_7);
        BSTTutorial.addFront(BSTSlide_8);
        BSTTutorial.addFront(BSTSlide_9);
        BSTTutorial.addFront(BSTSlide_10);
        BSTTutorial.addFront(BSTSlide_11);
        BSTTutorial.addFront(BSTSlide_12);
        BSTTutorial.addFront(BSTSlide_13);
        BSTTutorial.addFront(BSTSlide_14);
        BSTTutorial.addFront(BSTSlide_15);
        BSTTutorial.addFront(BSTSlide_16);
        BSTTutorial.addFront(BSTSlide_17);
        BSTTutorial.addFront(BSTSlide_18);
        BSTTutorial.addFront(BSTSlide_19);
        BSTTutorial.addFront(BSTSlide_20);
        BSTTutorial.addFront(BSTSlide_21);
        BSTTutorial.addFront(BSTSlide_22);
        BSTTutorial.addFront(BSTSlide_23);
        BSTTutorial.addFront(BSTSlide_24);
        BSTTutorial.addFront(BSTSlide_25);
        BSTTutorial.addFront(BSTSlide_26);
        BSTTutorial.addFront(BSTSlide_27);
        BSTTutorial.addFront(BSTSlide_28);
    }
    
    
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group.graphics;

import com.group.BST.BST;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 *
 * @author Carlos
 */
public class GUIJFrame extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    int frameWidth = (int) screenSize.getWidth() * 2 / 3;
    int frameHeight = (int) screenSize.getHeight() * 2 / 3;

    
    public static JPanel tutorialPanel = new JPanel();
    public static JPanel buttonPanel = new JPanel();
    public static TreeDrawingPanel drawPanel = new TreeDrawingPanel();
    
    JRadioButton jbtChoice1 = new JRadioButton("A) Node B") ;
    JRadioButton jbtChoice2 = new JRadioButton("B) Node C") ;
    JRadioButton jbtChoice3 = new JRadioButton("C) Node D") ;
    JRadioButton jbtChoice4 = new JRadioButton("D) Node E") ;
    
    ButtonGroup JrbtnGroup = new ButtonGroup() ;
    
    JButton btPrev = new JButton("Prev") ;
    JButton btNext = new JButton ("Next") ;
    JButton btSubmit = new JButton("Submit") ;
    
    JMenuBar tutorialBar = new JMenuBar() ;
    JMenu tutorialMenu = new JMenu("Menu") ;
    JMenuItem aboutMenu = new JMenuItem("About") ;
    JMenuItem Menu_Item_Exit = new JMenuItem("Exit");
    JMenuItem printMenu = new JMenuItem("Print");
//    JTextArea tutorialText = new JTextArea("Dummy text") ;
    

    public GUIJFrame() {
        super();
        
        init();
        setResizable(false);
        pack();
        setVisible(true);
    }
    
     public GUIJFrame(String title) throws HeadlessException {       
        super(title);
        
        init();
        setResizable(false);
        pack();
        setVisible(true);

    }
    
    public void init(){
        setLayout(new GridBagLayout());
        buttonPanel.setLayout(new GridBagLayout());
        
        //GridBag for the drawing panel
        GridBagConstraints gbc_drawingJPanel = new GridBagConstraints();
        
        //GridBag for the textPanel
        GridBagConstraints gbc_tutorialPanel = new GridBagConstraints();
        
        //GridBag for the Bottom Panel
        GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
        
        //GridBag for the first Radio Button
        GridBagConstraints gbc_Jrbtn_1 = new GridBagConstraints();
        
        //GridBag for the second Radio Button
        GridBagConstraints gbc_Jrbtn_2 = new GridBagConstraints();
        
        //GridBag for the third Radio Button
        GridBagConstraints gbc_Jrbtn_3 = new GridBagConstraints();
        
        //GridBag for the fourth Radio Button
        GridBagConstraints gbc_Jrbtn_4 = new GridBagConstraints();
        
        //GridBag for the "Previous" button
        GridBagConstraints gbc_Btn_Prev = new GridBagConstraints();
        
        //GridBag for the "Submit" button
        GridBagConstraints gbc_Btn_Submit = new GridBagConstraints();
        
        //GridBag for the "Next" button
        GridBagConstraints gbc_Btn_Next = new GridBagConstraints();
        

        //add the drawing frame
        gbc_drawingJPanel.gridx = 0;
        gbc_drawingJPanel.gridy = 0;

        drawPanel.setPenColor(Color.BLACK);
        drawPanel.line(0, 0, 1, 1);
        drawPanel.setCanvasSize(frameWidth * 3 / 5, frameHeight * 2 / 3);

        //Tutorial frame location
        gbc_tutorialPanel.gridx = 1;
        gbc_tutorialPanel.gridy = 0;
        tutorialPanel.setPreferredSize(null);
        //tutorialPanel.setPreferredSize(new Dimension(frameWidth *3/8 , frameHeight*2/3 ));
        
        //ButtonJPanel Location
        gbc_buttonPanel.gridx = 0;
        gbc_buttonPanel.gridy = 1;
        gbc_buttonPanel.gridwidth = 3;
        gbc_buttonPanel.gridheight= 10;
        gbc_buttonPanel.gridheight= 10;
        
        buttonPanel.setPreferredSize(new Dimension(frameWidth, frameHeight * 1 / 3));
        
        /***********************************************************************
         * Adding elements to the Bottom Panel
         ***********************************************************************/
        
        gbc_Jrbtn_1.gridx = 1;
        gbc_Jrbtn_1.gridy = 1;
        buttonPanel.add(jbtChoice1,gbc_Jrbtn_1);
        
        gbc_Jrbtn_2.gridx = 1 ;
        gbc_Jrbtn_2.gridy = 2 ;
        buttonPanel.add(jbtChoice2, gbc_Jrbtn_2) ;
        
        gbc_Jrbtn_3.gridx = 1 ;
        gbc_Jrbtn_3.gridy = 3 ;
        buttonPanel.add(jbtChoice3, gbc_Jrbtn_3) ;
        
        gbc_Jrbtn_4.gridx = 1 ;
        gbc_Jrbtn_4.gridy = 4 ;
        buttonPanel.add(jbtChoice4, gbc_Jrbtn_4) ;
        
        gbc_Jrbtn_1.gridx = 0 ;
        gbc_Jrbtn_1.gridy = 1 ;
        buttonPanel.add(btPrev, gbc_Jrbtn_1) ;
        
        gbc_Jrbtn_2.gridx = 1 ; 
        gbc_Jrbtn_2.gridy = 7 ;
        buttonPanel.add(btSubmit, gbc_Jrbtn_2) ;
        
        gbc_Jrbtn_4.gridx = 5 ;
        gbc_Jrbtn_4.gridy = 1 ;
        buttonPanel.add(btNext, gbc_Jrbtn_4) ;
        
        /***********************************************************************
        * Puts radioButtons in a group
        ***********************************************************************/
        JrbtnGroup.add(jbtChoice1);
        JrbtnGroup.add(jbtChoice2);
        JrbtnGroup.add(jbtChoice3);
        JrbtnGroup.add(jbtChoice4);
        
         /***********************************************************************
        * Adding ActionListeners to buttons
        ***********************************************************************/
        jbtChoice1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Action executed when button is pressed.
               // System.out.println("Choice 1 was clicked");
            }
        });
        
        jbtChoice2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Action executed when button is pressed.
              //  System.out.println("Choice 2 was clicked");
            }
        });
        
        jbtChoice3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Action executed when button is pressed.
                //System.out.println("Choice 3 was clicked");
            }
        });
        
        jbtChoice4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Action executed when button is pressed.
               // System.out.println("Choice 4 was clicked");
            }
        });
        
        btPrev.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Action executed when button is pressed.
                System.out.println("'Previous' button was clicked");
            }
        });
        
        btSubmit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(jbtChoice1.isSelected())
                {
                    System.out.println("Choice A was submitted");
                }
                if(jbtChoice2.isSelected())
                {
                    System.out.println("Choice B was submitted");
                }
                if(jbtChoice3.isSelected())
                {
                    System.out.println("Choice C was submitted");
                }
                if(jbtChoice4.isSelected())
                {
                    System.out.println("Choice D was submitted");
                }
            }
        });
        
        btNext.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                 
                drawPanel.clear();
                drawPanel.paintTree(treeWithThreeLeaves());
                
                tutorialPanel.removeAll();
     
                        
                        String text = "Correct Answer!";
        JTextPane jtext = new JTextPane();
        jtext.setSize(25, 25);
        jtext.setText(text);
        jtext.setEditable(false);
       // jtext.setContentType("text/html");
        tutorialPanel.add(jtext);
            }
            
            
        });
        
        
        aboutMenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Action executed when button is pressed.
                 JOptionPane.showMessageDialog(null, "This tutorial was made for"
                         + " COP 3530 and was created by:\n Manuel Garcia \n"
                         + " Carlos Cueto \n Fernando Serrano\n Miguel Espinal "
                         + "\n Carlos Martinez");
            }
        });
        
        Menu_Item_Exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Action executed when button is pressed.
                dispose();
            }
        });
        
        printMenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Action executed when button is pressed.
                printComponent();
            }
        });
        
        
        /***********************************************************************
        * Building JMenuBar
        ***********************************************************************/
        tutorialBar.add(tutorialMenu) ;
        
        tutorialBar.add(aboutMenu) ;

        /***********************************************************************
        *Building tutorialMenu
        ***********************************************************************/
        tutorialMenu.add(Menu_Item_Exit) ;
        tutorialMenu.add((printMenu));
        
        /***********************************************************************
         * Adding elements to the Frame
         ***********************************************************************/
        setJMenuBar(tutorialBar) ;
        add(buttonPanel,gbc_buttonPanel);
        add(tutorialPanel, gbc_tutorialPanel);
        add(drawPanel, gbc_drawingJPanel);
        
        /***********************************************************************
         * Adding tree to drawPanel
         ***********************************************************************/
        
        drawPanel.setXscale(0,15);
        drawPanel.setYscale(0,15);
        
        
        /***********************************************************************
         * Adding text to tutorialPane
         ***********************************************************************/
        String text = "A Binary Tree is a data structure made up of elements called nodes, "
                    + "usually containing a node called root as its main node.\n" +
                    "Binary Trees contain left and right nodes, which are usually called subtrees. "
                    + "The nodes to the left and to the right of each node\n (if any) are " +
                    "called the children of that node. Consequently, that node is the parent of its "
                +   "left and right child.\n\n"
                + "Question # 1\n" +
"Which of the nodes below is the child of node A?\n";
        JTextPane jtext = new JTextPane();
        jtext.setSize(25, 25);
        jtext.setText(text);
        jtext.setEditable(false);
       // jtext.setContentType("text/html");
        tutorialPanel.add(jtext);

      }  
    
    public BST treeWithThreeLeaves()
    {
        
        BST tree = new BST();
             tree.insert(30);
             tree.insert(20);
             tree.insert(10);
             tree.insert(8);
             tree.insert(11);
             tree.insert(21);
             tree.insert(34);
                
             drawPanel.clear();
             drawPanel.paintTree(tree);
             
             
      return tree;
    }
    
    public void printComponent(){
         
  PrinterJob pj = PrinterJob.getPrinterJob();
  pj.setJobName(" Print Component ");

  pj.setPrintable (new Printable() {    
    public int print(Graphics pg, PageFormat pf, int pageNum){
      if (pageNum > 0){
      return Printable.NO_SUCH_PAGE;
      }

      Graphics2D g2 = (Graphics2D) pg;
      g2.translate(pf.getImageableX(), pf.getImageableY());
      GUIJFrame.buttonPanel.paint(g2);
      GUIJFrame.tutorialPanel.paint(g2);
      GUIJFrame.drawPanel.paint(g2);
      return Printable.PAGE_EXISTS;
    }

  });
  if (pj.printDialog() == false)
  return;

  try {
        pj.print();
  } catch (PrinterException ex) {
        // handle exception
  }
}
    
    //public BST treeWith
        
    
    

}

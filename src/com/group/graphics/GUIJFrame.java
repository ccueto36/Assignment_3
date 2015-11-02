/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group.graphics;

import com.group.DoubleLinkedList.LinkedListNode;
import com.group.Slides.Slide;
import com.group.Slides.SlidesGroups;
import com.group.Tools.Answer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Carlos
 */
public class GUIJFrame extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    int frameWidth = (int) screenSize.getWidth() * 2 / 6;
    int frameHeight = (int) screenSize.getHeight() * 2 / 3;
    int answerChoice = Answer.NONE;
    int attemptCount = 0 ;
    int overallCount = 0 ;
    
    public static JPanel textPanel = new JPanel();
    public static JPanel buttonPanel = new JPanel();
    public static TreeDrawingPanel drawPanel = new TreeDrawingPanel();
    
    JRadioButton jbtChoice1 = new JRadioButton("A.)") ;
    JRadioButton jbtChoice2 = new JRadioButton("B.)") ;
    JRadioButton jbtChoice3 = new JRadioButton("C.)") ;
    JRadioButton jbtChoice4 = new JRadioButton("D.)") ;
    
    ButtonGroup JrbtnGroup = new ButtonGroup() ;
    
    JButton btnPrev = new JButton("Prev") ;
    JButton btnNext = new JButton ("Next") ;
    JButton btnSubmit = new JButton("Submit") ;
    
    JMenuBar tutorialBar = new JMenuBar() ;
    JMenu menu = new JMenu("Menu") ;
    JMenu helpMenu = new JMenu("Help") ;
    JMenuItem aboutItem = new JMenuItem("About") ;
    JMenuItem BSTTutorialMenu = new JMenuItem("Binary Search Tree Tutorial") ;
    JMenu tutorialsMenu = new JMenu("Tutorials") ;
    JMenuItem exitItem = new JMenuItem("Exit") ;
    
    JTextArea tutorialText = new JTextArea("") ;
    
    JScrollPane scroll = new JScrollPane(tutorialText) ;
    
    private static Slide currentSlide = null;
    private static LinkedListNode<Slide> currentNode = null;

    public GUIJFrame() {
        super();
        
        init();
        loadSlide(SlidesGroups.welcome.getBack().getNext());
        setResizable(false);
        pack();
        setVisible(true);
    }
    
     public GUIJFrame(String title) throws HeadlessException {       
        super(title);
        
        init();
        loadSlide(SlidesGroups.welcome.getBack().getNext());
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
        drawPanel.setXscale(0,30);
        drawPanel.setYscale(0,30);
        drawPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        drawPanel.setPreferredSize(new Dimension(frameWidth * 5/8, frameHeight * 2 / 3));
        drawPanel.setCanvasSize(frameWidth * 5/8, frameHeight * 2 / 3);

        //Tutorial frame location
        gbc_tutorialPanel.gridx = 1;
        gbc_tutorialPanel.gridy = 0;
        textPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        textPanel.setPreferredSize(new Dimension(frameWidth * 3/8, frameHeight * 2 / 3));
        textPanel.setLayout(new BorderLayout());
        
        //ButtonJPanel Location
        gbc_buttonPanel.gridx = 0;
        gbc_buttonPanel.gridy = 1;
        gbc_buttonPanel.gridwidth = 2;
        buttonPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        buttonPanel.setPreferredSize(new Dimension(frameWidth, frameHeight * 1 / 3));
        
        //working with the text area
//        tutorialText.setPreferredSize(new Dimension(frameWidth * 3/8, frameHeight * 2 / 3));
        tutorialText.setEditable(false);
        tutorialText.setFont(new Font("SansSerif", Font.BOLD, 15));
        tutorialText.setLineWrap(true);
        tutorialText.setWrapStyleWord(true);

        
        /***********************************************************************
        * giving textArea ScrollBar and lineWrap
        ***********************************************************************/
        
        
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//        scroll.setPreferredSize(new Dimension(frameWidth * 49/100 , frameHeight * 67/100));
        scroll.setPreferredSize(new Dimension(frameWidth * 1/2 , frameHeight * 2/3));
        
        /***********************************************************************
         * Adding elements to the TextPanel
         ***********************************************************************/
        textPanel.add(scroll,BorderLayout.CENTER);
        
        /***********************************************************************
         * Adding elements to the Bottom Panel
         ***********************************************************************/
        
        gbc_Jrbtn_1.gridx = 0;
        gbc_Jrbtn_1.gridy = 0;
        gbc_Jrbtn_1.weightx = 0.05;
        gbc_Jrbtn_1.insets = new Insets(0,10,0,0);
        gbc_Jrbtn_1.anchor = GridBagConstraints.WEST;
        buttonPanel.add(jbtChoice1,gbc_Jrbtn_1);
        
        gbc_Jrbtn_2.gridx = 1 ;
        gbc_Jrbtn_2.gridy = 0 ;
        gbc_Jrbtn_2.weightx = 0.05;
        gbc_Jrbtn_2.anchor = GridBagConstraints.WEST;
        buttonPanel.add(jbtChoice2, gbc_Jrbtn_2) ;
        
        gbc_Jrbtn_3.gridx = 2 ;
        gbc_Jrbtn_3.gridy = 0 ;
        gbc_Jrbtn_3.weightx = 0.05;
        gbc_Jrbtn_3.anchor = GridBagConstraints.WEST;
        buttonPanel.add(jbtChoice3, gbc_Jrbtn_3) ;
        
        gbc_Jrbtn_4.gridx = 3 ;
        gbc_Jrbtn_4.gridy = 0 ;
        gbc_Jrbtn_4.weightx = 0.90;
        gbc_Jrbtn_4.anchor = GridBagConstraints.WEST;
        buttonPanel.add(jbtChoice4, gbc_Jrbtn_4) ;
        
        gbc_Btn_Prev.gridx = 0 ;
        gbc_Btn_Prev.gridy = 1 ;
        gbc_Btn_Prev.insets = new Insets(10,10,0,0);
        gbc_Btn_Prev.anchor = GridBagConstraints.WEST;
        buttonPanel.add(btnPrev, gbc_Btn_Prev) ;
        
        gbc_Btn_Submit.gridx = 1 ; 
        gbc_Btn_Submit.gridy = 1 ;
        gbc_Btn_Submit.insets = new Insets(10,0,0,0);
        buttonPanel.add(btnSubmit, gbc_Btn_Submit) ;
        
        gbc_Btn_Next.gridx = 4 ;
        gbc_Btn_Next.gridy = 1 ;
        gbc_Btn_Next.insets = new Insets(10,0,0,10);
        gbc_Btn_Next.anchor = GridBagConstraints.EAST;
        buttonPanel.add(btnNext, gbc_Btn_Next) ;
        
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
                answerChoice = Answer.A ;
                System.out.println("Choice 1 was clicked");
            }
        });
        
        jbtChoice2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Action executed when button is pressed.
                answerChoice = Answer.B ;
                System.out.println("Choice 2 was clicked");
            }
        });
        
        jbtChoice3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Action executed when button is pressed.
                answerChoice = Answer.C ;
                System.out.println("Choice 3 was clicked");
            }
        });
        
        jbtChoice4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Action executed when button is pressed.
                answerChoice = Answer.D ;
                System.out.println("Choice 4 was clicked");
            }
        });
        
        btnPrev.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                loadSlide(currentNode.getPrevious());
                attemptCount = 0;
                System.out.println("'Previous' button was clicked");
            }
        });
        
        btnSubmit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Action executed when button is pressed.
                System.out.println("'Submit' button was clicked");
                if(attemptCount == 2 && answerChoice != currentNode.getData().getAnswer())
                {
                    String output = "" ;
                    if(currentNode.getData().getAnswer() == Answer.A )
                    {
                        output = "A" ;
                    }
                    else if(currentNode.getData().getAnswer() == Answer.B )
                    {
                        output = "B" ;
                    }
                    else if(currentNode.getData().getAnswer() == Answer.C )
                    {
                        output = "C" ;
                    }
                    else if(currentNode.getData().getAnswer() == Answer.D )
                    {
                        output = "D" ;
                    }
                    JOptionPane.showMessageDialog(null, "Sorry, you have ran out"
                            + "of attempts the answer is: " + output );
                }
                else if(jbtChoice1.isSelected())
                {
                    if(answerChoice == currentNode.getData().getAnswer())
                    {
                        JOptionPane.showMessageDialog(null, "Correct!");
                        attemptCount = 0;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Sorry Wrong Answer!");
                        attemptCount++ ;
                        overallCount++ ;
                    }
                    
                }
                else if(jbtChoice2.isSelected()) 
                {
                    if(answerChoice == currentNode.getData().getAnswer())
                    {
                        JOptionPane.showMessageDialog(null, "Correct!");
                        attemptCount = 0;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Sorry Wrong Answer!");
                        attemptCount++ ;
                        overallCount++ ;
                    }
                }
                else if(jbtChoice3.isSelected())
                {
                    if(answerChoice == currentNode.getData().getAnswer())
                    {
                        JOptionPane.showMessageDialog(null, "Correct!");
                        attemptCount = 0;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Sorry Wrong Answer!");
                        attemptCount++ ;
                        overallCount++ ;
                    }
                }
                else if(jbtChoice4.isSelected())
                {
                    if(answerChoice == currentNode.getData().getAnswer())
                    {
                        JOptionPane.showMessageDialog(null, "Correct!");
                        attemptCount = 0;
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Sorry Wrong Answer!");
                        attemptCount++ ;
                        overallCount++ ;
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please select an answer");
                }
            }
        });
        
        btnNext.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                loadSlide(currentNode.getNext());
                attemptCount = 0;
                System.out.println("'Next' button was clicked");
            }
        });
        
        aboutItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Action executed when button is pressed.
                 JOptionPane.showMessageDialog(null, "This tutorial was made for"
                         + "COP 3530 and was created by:\n Manuel Garcia \n"
                         + " Carlos Cuerto \n Fernando Serrano\n Miguel Espinal "
                         + "\n Carlos Martinez");
            }
        });
        
        
        BSTTutorialMenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Action executed when button is pressed.
                loadSlide(SlidesGroups.BSTTutorial.getBack().getNext());
            }
        });
        
        exitItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Action executed when button is pressed.
                dispose();
            }
        });
        
        
        
        /***********************************************************************
        * Building JMenuBar
        ***********************************************************************/
        tutorialBar.add(menu) ;
        tutorialBar.add(helpMenu);
        

        /***********************************************************************
        *Building Menu
        ***********************************************************************/
        menu.add(tutorialsMenu);
        menu.addSeparator();
        menu.add(exitItem) ;
        
        /***********************************************************************
        *Building sub-menus 
        ***********************************************************************/
        
        helpMenu.add(aboutItem);
        tutorialsMenu.add(BSTTutorialMenu);
        
        /***********************************************************************
         * Adding elements to the Frame
         ***********************************************************************/
        setJMenuBar(tutorialBar) ;
        add(buttonPanel,gbc_buttonPanel);
        add(textPanel, gbc_tutorialPanel);
        add(drawPanel, gbc_drawingJPanel);
    }    
    
    private void loadSlide(LinkedListNode<Slide> node){
        currentNode = node;
        //if there is no previous slide set the previous button to disable
        //if there is a previous slide set the previous button to enable
        if (node.getPrevious().getData() == null) 
            btnPrev.setEnabled(false);
        else
            btnPrev.setEnabled(true);
        
        //if there is no next slide set the next button to disable
        //if there is a next slide set the next button to enable
        if (node.getNext().getData() == null) 
            btnNext.setEnabled(false);
        else
            btnNext.setEnabled(true);
      
        //load the Node's slide into the currentSlide variable        
        currentSlide = node.getData();
        
        //if the slide has showControls to false we hide the radio buttons and
        //the submit button
        if (currentSlide.getShowAllControls()) {
            btnSubmit.setVisible(true);
            jbtChoice1.setVisible(true);
            jbtChoice2.setVisible(true);
            jbtChoice3.setVisible(true);
            jbtChoice4.setVisible(true);
            
        }
        else if(currentSlide.getShowBooleanControls()){
            btnSubmit.setVisible(true);
            jbtChoice1.setVisible(true);
            jbtChoice2.setVisible(true);
            jbtChoice3.setVisible(false);
            jbtChoice4.setVisible(false);
        }
        else{
            btnSubmit.setVisible(false);
            jbtChoice1.setVisible(false);
            jbtChoice2.setVisible(false);
            jbtChoice3.setVisible(false);
            jbtChoice4.setVisible(false);
        }
        
        //loads the tree into the drawPanel
        if ((currentSlide.getTree() != null) && (currentSlide.getTree().getRoot() != null)) {
            drawPanel.clear();
            drawPanel.setScale(0, 18);
            drawPanel.paintTree(currentSlide.getTree());
        }
        else //if there is no tree clears the drawPanel
            drawPanel.clear();
        
        //Inserting text in the TutorialText
        
        tutorialText.setText(currentSlide.getTextToShow());
        
        
    }

}

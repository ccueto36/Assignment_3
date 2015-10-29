/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

/**
 *
 * @author Carlos
 */
public class GUIJFrame extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    int frameWidth = (int) screenSize.getWidth() * 2 / 5;
    int frameHeight = (int) screenSize.getHeight() * 2 / 3;

    
    public static JPanel tutorialPanel = new JPanel();
    public static JPanel buttonPanel = new JPanel();


    //Radio Buttons Creation
    JRadioButton jbtChoice1 = new JRadioButton("A.)") ;
    JRadioButton jbtChoice2 = new JRadioButton("B.)") ;
    JRadioButton jbtChoice3 = new JRadioButton("C.)") ;
    JRadioButton jbtChoice4 = new JRadioButton("D.)") ;
    
    ButtonGroup Jrbtn_Group = new ButtonGroup() ;
    
    JButton btPrev = new JButton("Prev") ;
    JButton btNext = new JButton ("Next") ;
    JButton btSubmit = new JButton("Submit") ;
    
    JMenuBar tutorialMenu = new JMenuBar() ;
    JMenu menu = new JMenu("Menu") ;
    JMenu help = new JMenu("Help") ;
    JMenuItem about = new JMenuItem("About") ;
    
    JTextArea tutorialText = new JTextArea("Dummy text") ;
    public static TreeDrawingPanel drawPanel = new TreeDrawingPanel();

   

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
        drawPanel.setCanvasSize(frameWidth * 1/2, frameHeight * 2 / 3);

        //Tutorial frame location
        gbc_tutorialPanel.gridx = 1;
        gbc_tutorialPanel.gridy = 0;
        tutorialText.setPreferredSize(new Dimension(frameWidth * 1/2 , frameHeight * 2 / 3));
        
        
        //ButtonJPanel Location
        gbc_buttonPanel.gridx = 0;
        gbc_buttonPanel.gridy = 1;
        gbc_buttonPanel.gridwidth = 2;
        buttonPanel.setPreferredSize(new Dimension(frameWidth, frameHeight * 1 / 3));
        /***********************************************************************
        * giving textArea ScrollBar and lineWrap
        ***********************************************************************/
        JScrollPane scroll = new JScrollPane(tutorialText) ;
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setPreferredSize(new Dimension(frameWidth * 49/100 , frameHeight * 67/100));
        
        tutorialText.setLineWrap(true);
        tutorialText.setWrapStyleWord(true);
        /***********************************************************************
         * Adding elements to the Bottom Panel
         ***********************************************************************/
        
        gbc_Jrbtn_1.gridx = 0;
        gbc_Jrbtn_1.gridy = 0;
        gbc_Jrbtn_1.anchor = GridBagConstraints.WEST;
        gbc_Jrbtn_1.weightx = 0.05;
        buttonPanel.add(jbtChoice1,gbc_Jrbtn_1);
        
        gbc_Jrbtn_2.gridx = 1 ;
        gbc_Jrbtn_2.gridy = 0 ;
        gbc_Jrbtn_2.anchor = GridBagConstraints.WEST;
        gbc_Jrbtn_2.weightx = 0.05;
        buttonPanel.add(jbtChoice2, gbc_Jrbtn_2) ;
        
        gbc_Jrbtn_3.gridx = 2 ;
        gbc_Jrbtn_3.gridy = 0 ;
        gbc_Jrbtn_3.anchor = GridBagConstraints.WEST;
        gbc_Jrbtn_3.weightx = 0.05;
        buttonPanel.add(jbtChoice3, gbc_Jrbtn_3) ;
        
        gbc_Jrbtn_4.gridx = 3 ;
        gbc_Jrbtn_4.gridy = 0 ;
        gbc_Jrbtn_4.anchor = GridBagConstraints.WEST;
        gbc_Jrbtn_4.weightx = 0.90;
        buttonPanel.add(jbtChoice4, gbc_Jrbtn_4) ;
        
        gbc_Btn_Prev.gridx = 0 ;
        gbc_Btn_Prev.gridy = 1 ;
        gbc_Btn_Prev.insets = new Insets(30,0,0,0);
        gbc_Btn_Prev.anchor = GridBagConstraints.WEST;
        buttonPanel.add(btPrev, gbc_Btn_Prev) ;
        
        gbc_Btn_Submit.gridx = 1 ; 
        gbc_Btn_Submit.gridy = 1 ;
        gbc_Btn_Submit.insets = new Insets(30,0,0,0);
        buttonPanel.add(btSubmit, gbc_Btn_Submit) ;
        
        gbc_Btn_Next.gridx = 4 ;
        gbc_Btn_Next.gridy = 1 ;
        gbc_Btn_Next.insets = new Insets(30,0,0,0);
        gbc_Btn_Next.anchor =  GridBagConstraints.EAST;
        buttonPanel.add(btNext, gbc_Btn_Next) ;
        
        /***********************************************************************
        * Adding buttons to button group
        ***********************************************************************/
        Jrbtn_Group.add(jbtChoice1);
        Jrbtn_Group.add(jbtChoice2);
        Jrbtn_Group.add(jbtChoice3);
        Jrbtn_Group.add(jbtChoice4);
        
        /***********************************************************************
        * Building menuBar
        ***********************************************************************/
        tutorialMenu.add(menu) ;
        tutorialMenu.add(help) ;
        
        /***********************************************************************
        * Building menu 
        ***********************************************************************/
        JMenuItem exit = new JMenuItem("exit") ;
        menu.add(exit) ;
        help.add(about) ;
        
        /***********************************************************************
        * Adding actionListeners to all buttons
        ***********************************************************************/
        jbtChoice1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("'Choice 1' was selected");
            }
        });
        
        jbtChoice2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("'Choice 2' was selected");
            }
        });
        
        jbtChoice3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("'Choice 3' was selected");
            }
        });
        
        jbtChoice4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("'Choice 4' was selected");
            }
        });
        
        btPrev.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("'Prev' was selected");
            }
        });
        
        btSubmit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                if(jbtChoice1.isSelected())
                {
                    System.out.println("'Choice 1' was submitted as an answer");
                }
                else if(jbtChoice2.isSelected())
                {
                    System.out.println("'Choice 2' was submitted as an answer");
                }
                else if(jbtChoice3.isSelected())
                {
                    System.out.println("'Choice 3' was submitted as an answer");
                }
                else if(jbtChoice4.isSelected())
                {
                    System.out.println("'Choice 4' was submitted as an answer");
                }
                else
                {
                    System.out.println("Nothing was submitted");
                }
            }
        });
        
        btNext.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("'Next' was selected");
            }
        });
        
        about.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
               JOptionPane.showMessageDialog(null, "This tutorial was made for"
                       + " Professor Davis's COP 3530 class and was made by:"
                       + "\n Manuel"
                       + " Garcia\n Carlos Cuerto\n Fernando Serrano\n Miguel"
                       + " Espinal\n Carlos Martinez", "About", 
                       JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int exitResult = JOptionPane.showConfirmDialog(null, 
                        "Would you really"
                        + " like to close the tutorial?", "Exit", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.WARNING_MESSAGE) ;
                
                if(exitResult == 0)
                {
                    dispose();
                }
            }
        });
        
        /***********************************************************************
         * Adding elements to the Frame
         ***********************************************************************/
        add(buttonPanel,gbc_buttonPanel);
        add(scroll, gbc_tutorialPanel) ;
        add(drawPanel, gbc_drawingJPanel);
        setJMenuBar(tutorialMenu);
    }    

}

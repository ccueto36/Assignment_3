package com.group.graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author StdDraw authors, Manuel Garcia
 */

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import java.awt.image.BufferedImage;
import java.awt.image.DirectColorModel;
import java.awt.image.WritableRaster;

import java.io.File;
import java.io.IOException;

import java.net.URL;

import java.util.LinkedList;
import java.util.TreeSet;
import java.util.NoSuchElementException;

import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import javax.swing.JPanel;

public class StdDrawJPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener, KeyListener {

    /**
     *  The color black.
     */
    public static final Color BLACK = Color.BLACK;

    /**
     *  The color blue.
     */
    public static final Color BLUE = Color.BLUE;

    /**
     *  The color cyan.
     */
    public static final Color CYAN = Color.CYAN;

    /**
     *  The color dark gray.
     */
    public static final Color DARK_GRAY = Color.DARK_GRAY;

    /**
     *  The color gray.
     */
    public static final Color GRAY = Color.GRAY;

    /**
     *  The color green.
     */
    public static final Color GREEN  = Color.GREEN;

    /**
     *  The color light gray.
     */
    public static final Color LIGHT_GRAY = Color.LIGHT_GRAY;

    /**
     *  The color magenta.
     */
    public static final Color MAGENTA = Color.MAGENTA;

    /**
     *  The color orange.
     */
    public static final Color ORANGE = Color.ORANGE;

    /**
     *  The color pink.
     */
    public static final Color PINK = Color.PINK;

    /**
     *  The color red.
     */
    public static final Color RED = Color.RED;

    /**
     *  The color white.
     */
    public static final Color WHITE = Color.WHITE;

    /**
     *  The color yellow.
     */
    public static final Color YELLOW = Color.YELLOW;

    /**
     * Shade of blue used in <em>Introduction to Programming in Java</em>.
     * It is Pantone 300U. The RGB values are approximately (9, 90, 166).
     */
    public static final Color BOOK_BLUE = new Color(9, 90, 166);

    /**
     * Shade of light blue used in <em>Introduction to Programming in Java</em>.
     * The RGB values are approximately (103, 198, 243).
     */
    public static final Color BOOK_LIGHT_BLUE = new Color(103, 198, 243);

    /**
     * Shade of red used in <em>Algorithms, 4th edition</em>.
     * It is Pantone 1805U. The RGB values are approximately (150, 35, 31).
     */
    public static final Color BOOK_RED = new Color(150, 35, 31);

    // default colors
    private static final Color DEFAULT_PEN_COLOR   = BLACK;
    private static final Color DEFAULT_CLEAR_COLOR = WHITE;
    
    // default canvas size is DEFAULT_SIZE-by-DEFAULT_SIZE
    private static final int DEFAULT_SIZE = 512*2;
    
     // default pen radius
    private static final double DEFAULT_PEN_RADIUS = 0.002;
    
    // boundary of drawing canvas, 0% border
    // private static final double BORDER = 0.05;
    private static final double BORDER = 0.00;
    private static final double DEFAULT_XMIN = 0.0;
    private static final double DEFAULT_XMAX = 1.0;
    private static final double DEFAULT_YMIN = 0.0;
    private static final double DEFAULT_YMAX = 1.0;
    
     // default font
    private static final Font DEFAULT_FONT = new Font("SansSerif", Font.PLAIN, 16);
    
    // mouse state
    private static boolean mousePressed = false;
    private static double mouseX = 0;
    private static double mouseY = 0;
    
    // queue of typed key characters
    private static LinkedList<Character> keysTyped = new LinkedList<Character>();

    // set of key codes currently pressed down
    private static TreeSet<Integer> keysDown = new TreeSet<Integer>();

    // time in milliseconds (from currentTimeMillis()) when we can draw again
    // used to control the frame rate
    private static long nextDraw = -1;  
    
    // for synchronization
    private static Object mouseLock = new Object();
    private static Object keyLock = new Object();
    
    private double xmin, ymin, xmax, ymax;
    // current pen color
    private Color penColor;
    
    // current pen radius
    private double penRadius;
    
    // show we draw immediately or wait until next show?
    private boolean defer;
    
    // current font
    private static Font font;
    
    // double buffered graphics
    private BufferedImage offscreenImage, onscreenImage;
    private Graphics2D offscreen, onscreen;
    
    private int width;
    private int height;
    
    /***************************************************************************
     * Methods
     ***************************************************************************/
    
    /**
     * Sets the canvas (drawing area) to be 512-by-512 pixels.
     * This also erases the current drawing and resets the coordinate system,
     * pen radius, pen color, and font back to their default values.
     * Ordinarly, this method is called once, at the very beginning
     * of a program.
     */
    public void setCanvasSize() {
        setCanvasSize(DEFAULT_SIZE, DEFAULT_SIZE);
    }
    
    /**
     * Sets the canvas (drawing area) to be <em>width</em>-by-<em>height</em> pixels.
     * This also erases the current drawing and resets the coordinate system,
     * pen radius, pen color, and font back to their default values.
     * Ordinarly, this method is called once, at the very beginning
     * of a program.
     *
     * @param  canvasWidth the width as a number of pixels
     * @param  canvasHeight the height as a number of pixels
     * @throws IllegalArgumentException unless both {@code width} and
     *         {@code height} are positive
     */
    public void setCanvasSize(int canvasWidth, int canvasHeight) {
        if (width <= 0 || height <= 0) throw new IllegalArgumentException("width and height must be positive");
        width = canvasWidth;
        height = canvasHeight;
        init();
    }
    
    private void init(){      
        
        //setPreferredSize(new Dimension(width, height));
        
        offscreenImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        onscreenImage  = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        offscreen = offscreenImage.createGraphics();
        onscreen  = onscreenImage.createGraphics();
        setXscale();
        setYscale();
        
        offscreen.setColor(DEFAULT_CLEAR_COLOR);
        offscreen.fillRect(0, 0, width, height);  
        
        setPenColor();
        setPenRadius();
        
        setFont();
        
       
        
        clear();
        
        
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                                                  RenderingHints.VALUE_ANTIALIAS_ON);
        hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        offscreen.addRenderingHints(hints);
        
        //Jpanel stuff
        ImageIcon icon = new ImageIcon(onscreenImage);
        JLabel draw = new JLabel(icon);
        
        
        draw.addMouseListener(this);
        draw.addMouseMotionListener(this);
        
        removeAll();
        add(draw,BorderLayout.CENTER); 
        
 
        
        
    }
    
    /***************************************************************************
    *  User and screen coordinate systems.
    ***************************************************************************/

    /**
     * Sets the <em>x</em>-scale to be the default (between 0.0 and 1.0).
     */
    public void setXscale() {
        setXscale(DEFAULT_XMIN, DEFAULT_XMAX);
    }

    /**
     * Sets the <em>y</em>-scale to be the default (between 0.0 and 1.0).
     */
    public void setYscale() {
        setYscale(DEFAULT_YMIN, DEFAULT_YMAX);
    }

    /**
     * Sets the <em>x</em>-scale and <em>y</em>-scale to be the default
     * (between 0.0 and 1.0).
     */
    public void setScale() {
        setXscale();
        setYscale();
    }

    /**
     * Sets the <em>x</em>-scale to the specified range.
     *
     * @param  min the minimum value of the <em>x</em>-scale
     * @param  max the maximum value of the <em>x</em>-scale
     * @throws IllegalArgumentException if {@code (max == min)}
     */
    public void setXscale(double min, double max) {
        double size = max - min;
        if (size == 0.0) throw new IllegalArgumentException("the min and max are the same");
        synchronized (mouseLock) {
            xmin = min - BORDER * size;
            xmax = max + BORDER * size;
        }
        
        clear();
    }

    /**
     * Sets the <em>y</em>-scale to the specified range.
     *
     * @param  min the minimum value of the <em>y</em>-scale
     * @param  max the maximum value of the <em>y</em>-scale
     * @throws IllegalArgumentException if {@code (max == min)}
     */
    public void setYscale(double min, double max) {
        double size = max - min;
        if (size == 0.0) throw new IllegalArgumentException("the min and max are the same");
        synchronized (mouseLock) {
            ymin = min - BORDER * size;
            ymax = max + BORDER * size;
        }
        
        clear();
    }

    /**
     * Sets both the <em>x</em>-scale and <em>y</em>-scale to the (same) specified range.
     *
     * @param  min the minimum value of the <em>x</em>- and <em>y</em>-scales
     * @param  max the maximum value of the <em>x</em>- and <em>y</em>-scales
     * @throws IllegalArgumentException if {@code (max == min)}
     */
    public void setScale(double min, double max) {
        double size = max - min;
        if (size == 0.0) throw new IllegalArgumentException("the min and max are the same");
        synchronized (mouseLock) {
            xmin = min - BORDER * size;
            xmax = max + BORDER * size;
            ymin = min - BORDER * size;
            ymax = max + BORDER * size;
        }
        
        clear();
    }

    /**
     * 
     * @return the max X value in the scale
     */
    public double getMaxX(){
        return xmax;
    }
    
    /**
     * 
     * @return the max Y value in the scale
     */
    public double getMaxY(){
        return xmax;
    }
    // helper functions that scale from user coordinates to screen coordinates and back
    private double  scaleX(double x) { return (width  * (x - xmin) / (xmax - xmin)); }
    private double  scaleY(double y) { return (height - (height * (ymax - y) / (ymax - ymin))); }
    private double factorX(double w) { return w * width  / Math.abs(xmax - xmin);  }
    private double factorY(double h) { return h * height / Math.abs(ymax - ymin);  }
    private double   userX(double x) { return xmin + x * (xmax - xmin) / width;    }
    private double   userY(double y) { return ymax - y * (ymax - ymin) / height;   }
    
     /**
     * Clears the screen to the default color (white).
     */
    public void clear() {
        clear(DEFAULT_CLEAR_COLOR);
    }

    /**
     * Clears the screen to the specified color.
     *
     * @param color the color to make the background
     */
    public void clear(Color color) {
        offscreen.setColor(color);
        offscreen.fillRect(0, 0, width, height);
        offscreen.setColor(penColor);
        draw();
    }
    
    /**
     * Returns the current pen radius.
     *
     * @return the current value of the pen radius
     */
    public double getPenRadius() {
        return penRadius;
    }
    
     /**
     * Sets the pen size to the default size (0.002).
     * The pen is circular, so that lines have rounded ends, and when you set the
     * pen radius and draw a point, you get a circle of the specified radius.
     * The pen radius is not affected by coordinate scaling.
     */
    public void setPenRadius() {
        setPenRadius(DEFAULT_PEN_RADIUS);
    }

    /**
     * Sets the radius of the pen to the specified size.
     * The pen is circular, so that lines have rounded ends, and when you set the
     * pen radius and draw a point, you get a circle of the specified radius.
     * The pen radius is not affected by coordinate scaling.
     *
     * @param  radius the radius of the pen
     * @throws IllegalArgumentException if {@code radius} is negative
     */
    public void setPenRadius(double radius) {
        if (!(radius >= 0)) throw new IllegalArgumentException("pen radius must be nonnegative");
        penRadius = radius;
        float scaledPenRadius = (float) (radius * DEFAULT_SIZE);
        BasicStroke stroke = new BasicStroke(scaledPenRadius, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        // BasicStroke stroke = new BasicStroke(scaledPenRadius);
        offscreen.setStroke(stroke);
    }
    
    /**
     * Returns the current pen color.
     *
     * @return the current pen color
     */
    public Color getPenColor() {
        return penColor;
    }
    
    /**
     * Set the pen color to the default color (black).
     */
    public void setPenColor() {
        setPenColor(DEFAULT_PEN_COLOR);
    }
    
    /**
     * Sets the pen color to the specified color.
     * <p>
     * The predefined pen colors are
     * <tt>StdDraw.BLACK</tt>, <tt>StdDraw.BLUE</tt>, <tt>StdDraw.CYAN</tt>,
     * <tt>StdDraw.DARK_GRAY</tt>, <tt>StdDraw.GRAY</tt>, <tt>StdDraw.GREEN</tt>,
     * <tt>StdDraw.LIGHT_GRAY</tt>, <tt>StdDraw.MAGENTA</tt>, <tt>StdDraw.ORANGE</tt>,
     * <tt>StdDraw.PINK</tt>, <tt>StdDraw.RED</tt>, <tt>StdDraw.WHITE</tt>, and
     * <tt>StdDraw.YELLOW</tt>.
     *
     * @param color the color to make the pen
     */
    public void setPenColor(Color color) {
        if (color == null) throw new NullPointerException();
        penColor = color;
        offscreen.setColor(penColor);
    }

    /**
     * Sets the pen color to the specified RGB color.
     *
     * @param  red the amount of red (between 0 and 255)
     * @param  green the amount of green (between 0 and 255)
     * @param  blue the amount of blue (between 0 and 255)
     * @throws IllegalArgumentException if {@code red}, {@code green},
     *         or {@code blue} is outside its prescribed range
     */
    public void setPenColor(int red, int green, int blue) {
        if (red   < 0 || red   >= 256) throw new IllegalArgumentException("amount of red must be between 0 and 255");
        if (green < 0 || green >= 256) throw new IllegalArgumentException("amount of green must be between 0 and 255");
        if (blue  < 0 || blue  >= 256) throw new IllegalArgumentException("amount of blue must be between 0 and 255");
        setPenColor(new Color(red, green, blue));
    }
    
    /**
     * Returns the current font.
     *
     * @return the current font
     */
    public Font getFont() {
        return font;
    }
    
    /**
     * Sets the font to the default font (sans serif, 16 point).
     */
    public void setFont() {
        setFont(DEFAULT_FONT);
    }
    
    /**
     * Sets the font to the specified value.
     *
     * @param font the font
     */
    public void setFont(Font font) {
        if (font == null) throw new NullPointerException();
        this.font = font;
    }
    
    /***************************************************************************
    *  Drawing geometric shapes.
    ***************************************************************************/

    /**
     * Draws a line segment between (<em>x</em><sub>0</sub>, <em>y</em><sub>0</sub>) and
     * (<em>x</em><sub>1</sub>, <em>y</em><sub>1</sub>).
     *
     * @param  x0 the <em>x</em>-coordinate of one endpoint
     * @param  y0 the <em>y</em>-coordinate of one endpoint
     * @param  x1 the <em>x</em>-coordinate of the other endpoint
     * @param  y1 the <em>y</em>-coordinate of the other endpoint
     */
    public void line(double x0, double y0, double x1, double y1) {
        offscreen.draw(new Line2D.Double(scaleX(x0), scaleY(y0), scaleX(x1), scaleY(y1)));
        draw();
    }

    /**
     * Draws one pixel at (<em>x</em>, <em>y</em>).
     * This method is private because pixels depend on the display.
     * To achieve the same effect, set the pen radius to 0 and call {@code point()}.
     *
     * @param  x the <em>x</em>-coordinate of the pixel
     * @param  y the <em>y</em>-coordinate of the pixel
     */
    private void pixel(double x, double y) {
        offscreen.fillRect((int) Math.round(scaleX(x)), (int) Math.round(scaleY(y)), 1, 1);
    }
    
     /**
     * Draws a point centered at (<em>x</em>, <em>y</em>).
     * The point is a filled circle whose radius is equal to the pen radius.
     * To draw a single-pixel point, first set the pen radius to 0.
     *
     * @param x the <em>x</em>-coordinate of the point
     * @param y the <em>y</em>-coordinate of the point
     */
    public void point(double x, double y) {
        double xs = scaleX(x);
        double ys = scaleY(y);
        double r = penRadius;
        float scaledPenRadius = (float) (r * DEFAULT_SIZE);

        // double ws = factorX(2*r);
        // double hs = factorY(2*r);
        // if (ws <= 1 && hs <= 1) pixel(x, y);
        if (scaledPenRadius <= 1) pixel(x, y);
        else offscreen.fill(new Ellipse2D.Double(xs - scaledPenRadius/2, ys - scaledPenRadius/2,
                                                 scaledPenRadius, scaledPenRadius));
        draw();
    }
    
    /**
     * Draws a circle of the specified radius, centered at (<em>x</em>, <em>y</em>).
     *
     * @param  x the <em>x</em>-coordinate of the center of the circle
     * @param  y the <em>y</em>-coordinate of the center of the circle
     * @param  radius the radius of the circle
     * @throws IllegalArgumentException if {@code radius} is negative
     */
    public void circle(double x, double y, double radius) {
        if (!(radius >= 0)) throw new IllegalArgumentException("radius must be nonnegative");
        double xs = scaleX(x);
        double ys = scaleY(y);
        double ws = factorX(2*radius);
        double hs = factorY(2*radius);
        if (ws <= 1 && hs <= 1) pixel(x, y);
        else offscreen.draw(new Ellipse2D.Double(xs - ws/2, ys - hs/2, ws, hs));
        draw();
    }

    /**
     * Draws a filled circle of the specified radius, centered at (<em>x</em>, <em>y</em>).
     *
     * @param  x the <em>x</em>-coordinate of the center of the circle
     * @param  y the <em>y</em>-coordinate of the center of the circle
     * @param  radius the radius of the circle
     * @throws IllegalArgumentException if {@code radius} is negative
     */
    public void filledCircle(double x, double y, double radius) {
        if (!(radius >= 0)) throw new IllegalArgumentException("radius must be nonnegative");
        double xs = scaleX(x);
        double ys = scaleY(y);
        double ws = factorX(2*radius);
        double hs = factorY(2*radius);
        if (ws <= 1 && hs <= 1) pixel(x, y);
        else offscreen.fill(new Ellipse2D.Double(xs - ws/2, ys - hs/2, ws, hs));
        draw();
    }
    
    /**
     * Draws an ellipse with the specified semimajor and semiminor axes,
     * centered at (<em>x</em>, <em>y</em>).
     *
     * @param  x the <em>x</em>-coordinate of the center of the ellipse
     * @param  y the <em>y</em>-coordinate of the center of the ellipse
     * @param  semiMajorAxis is the semimajor axis of the ellipse
     * @param  semiMinorAxis is the semiminor axis of the ellipse
     * @throws IllegalArgumentException if either {@code semiMajorAxis}
     *         or {@code semiMinorAxis} is negative
     */
    public void ellipse(double x, double y, double semiMajorAxis, double semiMinorAxis) {
        if (!(semiMajorAxis >= 0)) throw new IllegalArgumentException("ellipse semimajor axis must be nonnegative");
        if (!(semiMinorAxis >= 0)) throw new IllegalArgumentException("ellipse semiminor axis must be nonnegative");
        double xs = scaleX(x);
        double ys = scaleY(y);
        double ws = factorX(2*semiMajorAxis);
        double hs = factorY(2*semiMinorAxis);
        if (ws <= 1 && hs <= 1) pixel(x, y);
        else offscreen.draw(new Ellipse2D.Double(xs - ws/2, ys - hs/2, ws, hs));
        draw();
    }
    
    /**
     * Draws an ellipse with the specified semimajor and semiminor axes,
     * centered at (<em>x</em>, <em>y</em>).
     *
     * @param  x the <em>x</em>-coordinate of the center of the ellipse
     * @param  y the <em>y</em>-coordinate of the center of the ellipse
     * @param  semiMajorAxis is the semimajor axis of the ellipse
     * @param  semiMinorAxis is the semiminor axis of the ellipse
     * @throws IllegalArgumentException if either {@code semiMajorAxis}
     *         or {@code semiMinorAxis} is negative
     */
    public void filledEllipse(double x, double y, double semiMajorAxis, double semiMinorAxis) {
        if (!(semiMajorAxis >= 0)) throw new IllegalArgumentException("ellipse semimajor axis must be nonnegative");
        if (!(semiMinorAxis >= 0)) throw new IllegalArgumentException("ellipse semiminor axis must be nonnegative");
        double xs = scaleX(x);
        double ys = scaleY(y);
        double ws = factorX(2*semiMajorAxis);
        double hs = factorY(2*semiMinorAxis);
        if (ws <= 1 && hs <= 1) pixel(x, y);
        else offscreen.fill(new Ellipse2D.Double(xs - ws/2, ys - hs/2, ws, hs));
        draw();
    }
    
    /**
     * Draws a circular arc of the specified radius,
     * centered at (<em>x</em>, <em>y</em>), from angle1 to angle2 (in degrees).
     *
     * @param  x the <em>x</em>-coordinate of the center of the circle
     * @param  y the <em>y</em>-coordinate of the center of the circle
     * @param  radius the radius of the circle
     * @param  angle1 the starting angle. 0 would mean an arc beginning at 3 o'clock.
     * @param  angle2 the angle at the end of the arc. For example, if
     *         you want a 90 degree arc, then angle2 should be angle1 + 90.
     * @throws IllegalArgumentException if {@code radius} is negative
     */
    public void arc(double x, double y, double radius, double angle1, double angle2) {
        if (radius < 0) throw new IllegalArgumentException("arc radius must be nonnegative");
        while (angle2 < angle1) angle2 += 360;
        double xs = scaleX(x);
        double ys = scaleY(y);
        double ws = factorX(2*radius);
        double hs = factorY(2*radius);
        if (ws <= 1 && hs <= 1) pixel(x, y);
        else offscreen.draw(new Arc2D.Double(xs - ws/2, ys - hs/2, ws, hs, angle1, angle2 - angle1, Arc2D.OPEN));
        draw();
    }
    
     /**
     * Draws a square of side length 2r, centered at (<em>x</em>, <em>y</em>).
     *
     * @param  x the <em>x</em>-coordinate of the center of the square
     * @param  y the <em>y</em>-coordinate of the center of the square
     * @param  halfLength one half the length of any side of the square
     * @throws IllegalArgumentException if {@code halfLength} is negative
     */
    public void square(double x, double y, double halfLength) {
        if (!(halfLength >= 0)) throw new IllegalArgumentException("half length must be nonnegative");
        double xs = scaleX(x);
        double ys = scaleY(y);
        double ws = factorX(2*halfLength);
        double hs = factorY(2*halfLength);
        if (ws <= 1 && hs <= 1) pixel(x, y);
        else offscreen.draw(new Rectangle2D.Double(xs - ws/2, ys - hs/2, ws, hs));
        draw();
    }
    
    /**
     * Draws a filled square of the specified size, centered at (<em>x</em>, <em>y</em>).
     *
     * @param  x the <em>x</em>-coordinate of the center of the square
     * @param  y the <em>y</em>-coordinate of the center of the square
     * @param  halfLength one half the length of any side of the square
     * @throws IllegalArgumentException if {@code halfLength} is negative
     */
    public void filledSquare(double x, double y, double halfLength) {
        if (!(halfLength >= 0)) throw new IllegalArgumentException("half length must be nonnegative");
        double xs = scaleX(x);
        double ys = scaleY(y);
        double ws = factorX(2*halfLength);
        double hs = factorY(2*halfLength);
        if (ws <= 1 && hs <= 1) pixel(x, y);
        else offscreen.fill(new Rectangle2D.Double(xs - ws/2, ys - hs/2, ws, hs));
        draw();
    }
    
    /**
     * Draws a rectangle of the specified size, centered at (<em>x</em>, <em>y</em>).
     *
     * @param  x the <em>x</em>-coordinate of the center of the rectangle
     * @param  y the <em>y</em>-coordinate of the center of the rectangle
     * @param  halfWidth one half the width of the rectangle
     * @param  halfHeight one half the height of the rectangle
     * @throws IllegalArgumentException if either {@code halfWidth} or {@code halfHeight} is negative
     */
    public void rectangle(double x, double y, double halfWidth, double halfHeight) {
        if (!(halfWidth  >= 0)) throw new IllegalArgumentException("half width must be nonnegative");
        if (!(halfHeight >= 0)) throw new IllegalArgumentException("half height must be nonnegative");
        double xs = scaleX(x);
        double ys = scaleY(y);
        double ws = factorX(2*halfWidth);
        double hs = factorY(2*halfHeight);
        if (ws <= 1 && hs <= 1) pixel(x, y);
        else offscreen.draw(new Rectangle2D.Double(xs - ws/2, ys - hs/2, ws, hs));
        draw();
    }
    
    /**
     * Draws a filled rectangle of the specified size, centered at (<em>x</em>, <em>y</em>).
     *
     * @param  x the <em>x</em>-coordinate of the center of the rectangle
     * @param  y the <em>y</em>-coordinate of the center of the rectangle
     * @param  halfWidth one half the width of the rectangle
     * @param  halfHeight one half the height of the rectangle
     * @throws IllegalArgumentException if either {@code halfWidth} or {@code halfHeight} is negative
     */
    public void filledRectangle(double x, double y, double halfWidth, double halfHeight) {
        if (!(halfWidth  >= 0)) throw new IllegalArgumentException("half width must be nonnegative");
        if (!(halfHeight >= 0)) throw new IllegalArgumentException("half height must be nonnegative");
        double xs = scaleX(x);
        double ys = scaleY(y);
        double ws = factorX(2*halfWidth);
        double hs = factorY(2*halfHeight);
        if (ws <= 1 && hs <= 1) pixel(x, y);
        else offscreen.fill(new Rectangle2D.Double(xs - ws/2, ys - hs/2, ws, hs));
        draw();
    }
    
    /**
     * Draws a polygon with the vertices 
     * (<em>x</em><sub>0</sub>, <em>y</em><sub>0</sub>),
     * (<em>x</em><sub>1</sub>, <em>y</em><sub>1</sub>), ...,
     * (<em>x</em><sub><em>n</em>&minus;1</sub>, <em>y</em><sub><em>n</em>&minus;1</sub>).
     *
     * @param  x an array of all the <em>x</em>-coordinates of the polygon
     * @param  y an array of all the <em>y</em>-coordinates of the polygon
     * @throws IllegalArgumentException unless {@code x[]} and {@code y[]}
     *         are of the same length
     */
    public void polygon(double[] x, double[] y) {
        if (x == null) throw new NullPointerException();
        if (y == null) throw new NullPointerException();
        int n1 = x.length;
        int n2 = y.length;
        if (n1 != n2) throw new IllegalArgumentException("arrays must be of the same length");
        int n = n1;
        GeneralPath path = new GeneralPath();
        path.moveTo((float) scaleX(x[0]), (float) scaleY(y[0]));
        for (int i = 0; i < n; i++)
            path.lineTo((float) scaleX(x[i]), (float) scaleY(y[i]));
        path.closePath();
        offscreen.draw(path);
        draw();
    }
    
    /**
     * Draws a polygon with the vertices 
     * (<em>x</em><sub>0</sub>, <em>y</em><sub>0</sub>),
     * (<em>x</em><sub>1</sub>, <em>y</em><sub>1</sub>), ...,
     * (<em>x</em><sub><em>n</em>&minus;1</sub>, <em>y</em><sub><em>n</em>&minus;1</sub>).
     *
     * @param  x an array of all the <em>x</em>-coordinates of the polygon
     * @param  y an array of all the <em>y</em>-coordinates of the polygon
     * @throws IllegalArgumentException unless {@code x[]} and {@code y[]}
     *         are of the same length
     */
    public void filledPolygon(double[] x, double[] y) {
        if (x == null) throw new NullPointerException();
        if (y == null) throw new NullPointerException();
        int n1 = x.length;
        int n2 = y.length;
        if (n1 != n2) throw new IllegalArgumentException("arrays must be of the same length");
        int n = n1;
        GeneralPath path = new GeneralPath();
        path.moveTo((float) scaleX(x[0]), (float) scaleY(y[0]));
        for (int i = 0; i < n; i++)
            path.lineTo((float) scaleX(x[i]), (float) scaleY(y[i]));
        path.closePath();
        offscreen.fill(path);
        draw();
    }
    
    /***************************************************************************
    *  Drawing images.
    ***************************************************************************/

    // get an image from the given filename
    private static Image getImage(String filename) {
        if (filename == null) throw new NullPointerException();

        // to read from file
        ImageIcon icon = new ImageIcon(filename);

        // try to read from URL
        if ((icon == null) || (icon.getImageLoadStatus() != MediaTracker.COMPLETE)) {
            try {
                URL url = new URL(filename);
                icon = new ImageIcon(url);
            }
            catch (Exception e) {
                /* not a url */
            }
        }
//        // in case file is inside a .jar (classpath relative to StdDraw)
//        if ((icon == null) || (icon.getImageLoadStatus() != MediaTracker.COMPLETE)) {
//            URL url = StdDraw.class.getResource(filename);
//            if (url != null)
//                icon = new ImageIcon(url);
//        }
//
//        // in case file is inside a .jar (classpath relative to root of jar)
//        if ((icon == null) || (icon.getImageLoadStatus() != MediaTracker.COMPLETE)) {
//            URL url = StdDraw.class.getResource("/" + filename);
//            if (url == null) throw new IllegalArgumentException("image " + filename + " not found");
//            icon = new ImageIcon(url);
//        }

        return icon.getImage();
    }
    
    /**
     * Draws the specified image centered at (<em>x</em>, <em>y</em>).
     * The supported image formats are JPEG, PNG, and GIF.
     * As an optimization, the picture is cached, so there is no performance
     * penalty for redrawing the same image multiple times (e.g., in an animation).
     * However, if you change the picture file after drawing it, subsequent
     * calls will draw the original picture.
     *
     * @param  x the center <em>x</em>-coordinate of the image
     * @param  y the center <em>y</em>-coordinate of the image
     * @param  filename the name of the image/picture, e.g., "ball.gif"
     * @throws IllegalArgumentException if the image filename is invalid
     */
    public void picture(double x, double y, String filename) {
        Image image = getImage(filename);
        double xs = scaleX(x);
        double ys = scaleY(y);
        int ws = image.getWidth(null);
        int hs = image.getHeight(null);
        if (ws < 0 || hs < 0) throw new IllegalArgumentException("image " + filename + " is corrupt");

        offscreen.drawImage(image, (int) Math.round(xs - ws/2.0), (int) Math.round(ys - hs/2.0), null);
        draw();
    }
    
    /**
     * Draws the specified image centered at (<em>x</em>, <em>y</em>),
     * rotated given number of degrees.
     * The supported image formats are JPEG, PNG, and GIF.
     *
     * @param  x the center <em>x</em>-coordinate of the image
     * @param  y the center <em>y</em>-coordinate of the image
     * @param  filename the name of the image/picture, e.g., "ball.gif"
     * @param  degrees is the number of degrees to rotate counterclockwise
     * @throws IllegalArgumentException if the image filename is invalid
     */
    public void picture(double x, double y, String filename, double degrees) {
        Image image = getImage(filename);
        double xs = scaleX(x);
        double ys = scaleY(y);
        int ws = image.getWidth(null);
        int hs = image.getHeight(null);
        if (ws < 0 || hs < 0) throw new IllegalArgumentException("image " + filename + " is corrupt");

        offscreen.rotate(Math.toRadians(-degrees), xs, ys);
        offscreen.drawImage(image, (int) Math.round(xs - ws/2.0), (int) Math.round(ys - hs/2.0), null);
        offscreen.rotate(Math.toRadians(+degrees), xs, ys);

        draw();
    }
    
    /**
     * Draws the specified image centered at (<em>x</em>, <em>y</em>),
     * rescaled to the specified bounding box.
     * The supported image formats are JPEG, PNG, and GIF.
     *
     * @param  x the center <em>x</em>-coordinate of the image
     * @param  y the center <em>y</em>-coordinate of the image
     * @param  filename the name of the image/picture, e.g., "ball.gif"
     * @param  scaledWidth the width of the scaled image in pixels
     * @param  scaledHeight the height of the scaled image in pixels
     * @throws IllegalArgumentException if either {@code scaledWidth}
     *         or {@code scaledHeight} is negative
     * @throws IllegalArgumentException if the image filename is invalid
     */
    public void picture(double x, double y, String filename, double scaledWidth, double scaledHeight) {
        Image image = getImage(filename);
        if (scaledWidth < 0) throw new IllegalArgumentException("width is negative: " + scaledWidth);
        if (scaledHeight < 0) throw new IllegalArgumentException("height is negative: " + scaledHeight);
        double xs = scaleX(x);
        double ys = scaleY(y);
        double ws = factorX(scaledWidth);
        double hs = factorY(scaledHeight);
        if (ws < 0 || hs < 0) throw new IllegalArgumentException("image " + filename + " is corrupt");
        if (ws <= 1 && hs <= 1) pixel(x, y);
        else {
            offscreen.drawImage(image, (int) Math.round(xs - ws/2.0),
                                       (int) Math.round(ys - hs/2.0),
                                       (int) Math.round(ws),
                                       (int) Math.round(hs), null);
        }
        draw();
    }

     /**
     * Draws the specified image centered at (<em>x</em>, <em>y</em>), rotated
     * given number of degrees, and rescaled to the specified bounding box.
     * The supported image formats are JPEG, PNG, and GIF.
     *
     * @param  x the center <em>x</em>-coordinate of the image
     * @param  y the center <em>y</em>-coordinate of the image
     * @param  filename the name of the image/picture, e.g., "ball.gif"
     * @param  scaledWidth the width of the scaled image in pixels
     * @param  scaledHeight the height of the scaled image in pixels
     * @param  degrees is the number of degrees to rotate counterclockwise
     * @throws IllegalArgumentException if either {@code scaledWidth}
     *         or {@code scaledHeight} is negative
     * @throws IllegalArgumentException if the image filename is invalid
     */
    public void picture(double x, double y, String filename, double scaledWidth, double scaledHeight, double degrees) {
        if (scaledWidth < 0) throw new IllegalArgumentException("width is negative: " + scaledWidth);
        if (scaledHeight < 0) throw new IllegalArgumentException("height is negative: " + scaledHeight);
        Image image = getImage(filename);
        double xs = scaleX(x);
        double ys = scaleY(y);
        double ws = factorX(scaledWidth);
        double hs = factorY(scaledHeight);
        if (ws < 0 || hs < 0) throw new IllegalArgumentException("image " + filename + " is corrupt");
        if (ws <= 1 && hs <= 1) pixel(x, y);

        offscreen.rotate(Math.toRadians(-degrees), xs, ys);
        offscreen.drawImage(image, (int) Math.round(xs - ws/2.0),
                                   (int) Math.round(ys - hs/2.0),
                                   (int) Math.round(ws),
                                   (int) Math.round(hs), null);
        offscreen.rotate(Math.toRadians(+degrees), xs, ys);

        draw();
    }

    /***************************************************************************
    *  Drawing text.
    ***************************************************************************/

    /**
     * Write the given text string in the current font, centered at (<em>x</em>, <em>y</em>).
     *
     * @param  x the center <em>x</em>-coordinate of the text
     * @param  y the center <em>y</em>-coordinate of the text
     * @param  text the text to write
     */
    public void text(double x, double y, String text) {
        if (text == null) throw new NullPointerException();
        offscreen.setFont(font);
        FontMetrics metrics = offscreen.getFontMetrics();
        double xs = scaleX(x);
        double ys = scaleY(y);
        int ws = metrics.stringWidth(text);
        int hs = metrics.getDescent();
        offscreen.drawString(text, (float) (xs - ws/2.0), (float) (ys + hs));
        draw();
    }

    /**
     * Write the given text string in the current font, centered at (<em>x</em>, <em>y</em>) and
     * rotated by the specified number of degrees.
     * @param  x the center <em>x</em>-coordinate of the text
     * @param  y the center <em>y</em>-coordinate of the text
     * @param  text the text to write
     * @param  degrees is the number of degrees to rotate counterclockwise
     */
    public void text(double x, double y, String text, double degrees) {
        if (text == null) throw new NullPointerException();
        double xs = scaleX(x);
        double ys = scaleY(y);
        offscreen.rotate(Math.toRadians(-degrees), xs, ys);
        text(x, y, text);
        offscreen.rotate(Math.toRadians(+degrees), xs, ys);
    }

    /**
     * Write the given text string in the current font, left-aligned at (<em>x</em>, <em>y</em>).
     * @param  x the <em>x</em>-coordinate of the text
     * @param  y the <em>y</em>-coordinate of the text
     * @param  text the text
     */
    public void textLeft(double x, double y, String text) {
        if (text == null) throw new NullPointerException();
        offscreen.setFont(font);
        FontMetrics metrics = offscreen.getFontMetrics();
        double xs = scaleX(x);
        double ys = scaleY(y);
        int hs = metrics.getDescent();
        offscreen.drawString(text, (float) xs, (float) (ys + hs));
        draw();
    }
    
     /**
     * Write the given text string in the current font, right-aligned at (<em>x</em>, <em>y</em>).
     *
     * @param  x the <em>x</em>-coordinate of the text
     * @param  y the <em>y</em>-coordinate of the text
     * @param  text the text to write
     */
    public void textRight(double x, double y, String text) {
        if (text == null) throw new NullPointerException();
        offscreen.setFont(font);
        FontMetrics metrics = offscreen.getFontMetrics();
        double xs = scaleX(x);
        double ys = scaleY(y);
        int ws = metrics.stringWidth(text);
        int hs = metrics.getDescent();
        offscreen.drawString(text, (float) (xs - ws), (float) (ys + hs));
        draw();
    }
    
     /**
     * Display on screen, pause for t milliseconds, and turn on
     * <em>animation mode</em>: subsequent calls to
     * drawing methods such as {@code line()}, {@code circle()}, and {@code square()}
     * will not be displayed on screen until the next call to {@code show()}.
     * This is useful for producing animations (clear the screen, draw a bunch of shapes,
     * display on screen for a fixed amount of time, and repeat). It also speeds up
     * drawing a huge number of shapes (call {@code show(0)} to defer drawing
     * on screen, draw the shapes, and call {@code show(0)} to display them all
     * on screen at once).
     * @param t number of milliseconds
     */
    public void show(int t) {
        // sleep until the next time we're allowed to draw
        long millis = System.currentTimeMillis();
        if (millis < nextDraw) {
            try {
                Thread.sleep(nextDraw - millis);
            }
            catch (InterruptedException e) {
                System.out.println("Error sleeping");
            }
            millis = nextDraw;
        }

        defer = false;
        draw();
        defer = true;

        // when are we allowed to draw again
        nextDraw = millis + t;
    }
    
    /**
     * Display on-screen and turn off animation mode:
     * subsequent calls to
     * drawing methods such as {@code line()}, {@code circle()},
     * and {@code square()} will be displayed on screen when called.
     * This is the default.
     */
    public void show() {
        defer = false;
        nextDraw = -1;
        draw();
    }
    
    // draw onscreen if defer is false
    private void draw() {
        if (defer) return;
        onscreen.drawImage(offscreenImage, 0, 0, null);
        
        repaint();
    }

   
   
    
    
    /***************************************************************************
     * Constructor
     ***************************************************************************/
    
    public StdDrawJPanel(){
        super();
        defer = false;
        width = DEFAULT_SIZE;
        height = DEFAULT_SIZE;
        mouseX = 0;
        mouseY = 0;
        mousePressed = false;
        init();

    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /***************************************************************************
    *  Mouse interactions.
    ***************************************************************************/

    /**
     * Returns true if the mouse is being pressed.
     *
     * @return <tt>true</tt> if the mouse is being pressed; <tt>false</tt> otherwise
     */
    public static boolean mousePressed() {
        synchronized (mouseLock) {
            return mousePressed;
        }
    }

    /**
     * Returns the <em>x</em>-coordinate of the mouse.
     *
     * @return the <em>x</em>-coordinate of the mouse
     */
    public static double mouseX() {
        synchronized (mouseLock) {
            return mouseX;
        }
    }

    /**
     * Returns the <em>y</em>-coordinate of the mouse.
     *
     * @return <em>y</em>-coordinate of the mouse
     */
    public static double mouseY() {
        synchronized (mouseLock) {
            return mouseY;
        }
    }


    /**
     * This method cannot be called directly.
     */
    @Override
    public void mouseClicked(MouseEvent e) { }

    /**
     * This method cannot be called directly.
     */
    @Override
    public void mouseEntered(MouseEvent e) { }

    /**
     * This method cannot be called directly.
     */
    @Override
    public void mouseExited(MouseEvent e) { }

    /**
     * This method cannot be called directly.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        synchronized (mouseLock) {
            mouseX = userX(e.getX());
            mouseY = userY(e.getY());
            mousePressed = true;
        }
    }

    /**
     * This method cannot be called directly.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        synchronized (mouseLock) {
            mousePressed = false;
        }
    }

    /**
     * This method cannot be called directly.
     */
    @Override
    public void mouseDragged(MouseEvent e)  {
        synchronized (mouseLock) {
            mouseX = userX(e.getX());
            mouseY = userY(e.getY());
        }
    }

    /**
     * This method cannot be called directly.
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        synchronized (mouseLock) {
            mouseX = userX(e.getX());
            mouseY = userY(e.getY());
        }
    }
    
    /***************************************************************************
    *  Keyboard interactions.
    ***************************************************************************/

    /**
     * Returns true if the user has typed a key (that has not yet been processed).
     *
     * @return <tt>true</tt> if the user has typed a key (that has not yet been processed
     *         by {@link #nextKeyTyped()}; <tt>false</tt> otherwise
     */
    public static boolean hasNextKeyTyped() {
        synchronized (keyLock) {
            return !keysTyped.isEmpty();
        }
    }

    /**
     * Returns the next key that was typed by the user (that your program has not already processed).
     * This method should be preceded by a call to {@link #hasNextKeyTyped()} to ensure
     * that there is a next key to process.
     * This method returns a Unicode character corresponding to the key
     * typed (such as {@code 'a'} or {@code 'A'}).
     * It cannot identify action keys (such as F1 and arrow keys)
     * or modifier keys (such as control).
     *
     * @return the next key typed by the user (that your program has not already processed).
     * @throws NoSuchElementException if there is no remaining key
     */
    public static char nextKeyTyped() {
        synchronized (keyLock) {
            if (keysTyped.isEmpty()) {
                throw new NoSuchElementException("your program has already processed all keystrokes");
            }
            return keysTyped.removeLast();
        }
    }

    /**
     * Returns true if the given key is being pressed.
     * <p>
     * This method takes the keycode (corresponding to a physical key)
    *  as an argument. It can handle action keys
     * (such as F1 and arrow keys) and modifier keys (such as shift and control).
     * See {@link KeyEvent} for a description of key codes.
     *
     * @param  keycode the key to check if it is being pressed
     * @return <tt>true</tt> if {@code keycode} is currently being pressed;
     *         <tt>false</tt> otherwise
     */
    public static boolean isKeyPressed(int keycode) {
        synchronized (keyLock) {
            return keysDown.contains(keycode);
        }
    }


    /**
     * This method cannot be called directly.
     */
    @Override
    public void keyTyped(KeyEvent e) {
        synchronized (keyLock) {
            keysTyped.addFirst(e.getKeyChar());
        }
    }

    /**
     * This method cannot be called directly.
     */
    @Override
    public void keyPressed(KeyEvent e) {
        synchronized (keyLock) {
            keysDown.add(e.getKeyCode());
        }
    }

    /**
     * This method cannot be called directly.
     */
    @Override
    public void keyReleased(KeyEvent e) {
        synchronized (keyLock) {
            keysDown.remove(e.getKeyCode());
        }
    }
    
}

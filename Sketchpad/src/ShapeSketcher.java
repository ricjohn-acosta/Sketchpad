/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ricjo
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ShapeSketcher extends JPanel implements ActionListener {

    public final int PANEL_WIDTH = 500;
    public final int PANEL_HEIGHT = 600;
    protected ArrayList points;
    private JRadioButton Circle, Oval, Square, Rectangle, Line;
    private JCheckBox Fill;
    private JButton changeColour, clear;
    private ShapeSketcherDrawer drawPanel;
    private ArrayList<Shape> shapeArray;
    private Shape currentShape;
    private Point ptStart, ptEnd;
    private Color colour;

    // Consists an inner class that handles drawings and the ShapeSketcher class
    // holds the JComponents and will listen to itself for events
    public ShapeSketcher() {
        super(new BorderLayout());
        drawPanel = new ShapeSketcherDrawer();
        shapeArray = new ArrayList();
        currentShape = null;
        setBackground(Color.WHITE);

        // South panel contains radio buttons, a checkbox and a button.
        // Create south panel obj reference and an obj reference to group the radio buttons
        JPanel southPanel = new JPanel();
        ButtonGroup group = new ButtonGroup();
        Circle = new JRadioButton("Circle");
        Oval = new JRadioButton("Oval");
        Square = new JRadioButton("Square");
        Rectangle = new JRadioButton("Rectangle");
        Line = new JRadioButton("Line");
        // Add action listeners.
        Circle.addActionListener(this);
        Oval.addActionListener(this);
        Square.addActionListener(this);
        Rectangle.addActionListener(this);
        Line.addActionListener(this);
        // Group radiobuttons together.
        group.add(Circle);
        group.add(Oval);
        group.add(Square);
        group.add(Rectangle);
        group.add(Line);
        // Instantiate JButton components
        Fill = new JCheckBox("Fill");
        changeColour = new JButton("Change colour");
        clear = new JButton("Clear");
        // Add action listeners for the buttons
        Fill.addActionListener(this);
        changeColour.addActionListener(this);
        clear.addActionListener(this);
        // Add all of the buttons in the south panel.
        southPanel.add(Circle);
        southPanel.add(Oval);
        southPanel.add(Square);
        southPanel.add(Rectangle);
        southPanel.add(Line);
        southPanel.add(Fill);
        southPanel.add(changeColour);
        southPanel.add(clear);
        // Finally add the south panel in the south part of the border layout.
        add(southPanel, BorderLayout.SOUTH);
        add(drawPanel, BorderLayout.CENTER);
    }

    // mouse event handlers
    public class ShapeSketcherDrawer extends JPanel implements MouseListener, MouseMotionListener {

        public ShapeSketcherDrawer() {
            setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
            setBackground(Color.WHITE);
            addMouseListener(this);
            addMouseMotionListener(this);
            currentShape = null;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            ptStart = e.getPoint();
            if (Line.isSelected()) {
                if (Fill.isSelected()) {
                    JOptionPane.showMessageDialog(this, "Line cannot be filled");
                } else {
                    currentShape = new Line(ptStart);
                    currentShape.setColour(colour);
                }

            } else if (Oval.isSelected()) {
                if (Fill.isSelected()) {
                    currentShape = new Oval(ptStart);
                    currentShape.setColour(colour);
                    EnclosesRegion fill = (EnclosesRegion) currentShape;
                    fill.setFilled(true);
                    currentShape = (Shape) fill;
                } else {
                    currentShape = new Oval(ptStart);
                    currentShape.setColour(colour);
                }
            } else if (Circle.isSelected()) {
                if (Fill.isSelected()) {
                    currentShape = new Circle(ptStart);
                    currentShape.setColour(colour);
                    EnclosesRegion fill = (EnclosesRegion) currentShape;
                    fill.setFilled(true);
                    currentShape = (Shape) fill;
                } else {
                    currentShape = new Circle(ptStart);
                    currentShape.setColour(colour);
                }
            } else if (Square.isSelected()) {
                if (Fill.isSelected()) {
                    currentShape = new Square(ptStart);
                    currentShape.setColour(colour);
                    EnclosesRegion fill = (EnclosesRegion) currentShape;
                    fill.setFilled(true);
                    currentShape = (Shape) fill;
                } else {
                    currentShape = new Square(ptStart);
                    currentShape.setColour(colour);
                }
            } else if (Rectangle.isSelected()) {
                if (Fill.isSelected()) {
                    currentShape = new Rectangle(ptStart);
                    currentShape.setColour(colour);
                    EnclosesRegion fill = (EnclosesRegion) currentShape;
                    fill.setFilled(true);
                    currentShape = (Shape) fill;
                } else {
                    currentShape = new Rectangle(ptStart);
                    currentShape.setColour(colour);
                }
            // If user clicks on canvas without choosing a shape at the start
            } else {
                JOptionPane.showMessageDialog(this, "Please choose a shape");
            }

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            ptEnd = e.getPoint();
            if (Line.isSelected()) {
                currentShape.setControlPoint(ptEnd);
                repaint();
            } else if (Oval.isSelected()) {
                currentShape.setControlPoint(ptEnd);
                repaint();
            } else if (Circle.isSelected()) {
                currentShape.setControlPoint(ptEnd);
                repaint();
            } else if (Square.isSelected()) {
                currentShape.setControlPoint(ptEnd);
                repaint();
            } else {
                currentShape.setControlPoint(ptEnd);
                repaint();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (currentShape.controlPoint == null) {
                JOptionPane.showMessageDialog(this, "Drag mouse to draw.");
                currentShape = null;
            } else {
                shapeArray.add(currentShape);
                currentShape = null;
            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //unused
        }

        @Override
        public void mouseExited(MouseEvent e) {
            //unused
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            //unused
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            //unused
        }

        // Paint component checks what shape type is stored in the array and
        //draws that particular shape.
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Shape shape : shapeArray) {
                shape.draw(g);
            }
            if (currentShape != null) {
                currentShape.setColour(colour);
                currentShape.draw(g);
            }

        }
    }

    // Event handler for the JComponents
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == Line) {
            currentShape = new Line(ptStart);
        } else if (source == Oval) {
            currentShape = new Oval(ptStart);
        } else if (source == Circle) {
            currentShape = new Circle(ptStart);
        } else if (source == Rectangle) {
            currentShape = new Rectangle(ptStart);
        } else if (source == Square) {
            currentShape = new Square(ptStart);
        } else if (source == clear){
            shapeArray.clear();
            currentShape = null;
            drawPanel.repaint();
        } else if (source == changeColour ) {
            colour = JColorChooser.showDialog(ShapeSketcher.this, "Choose colour", Color.BLACK);
        } else {
            System.out.println("Fill ticked");
        }
    }

    public static void main(String[] args) {
        // set up frame
        JFrame frame = new JFrame("Sketch Pad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ShapeSketcher());
        frame.pack();
        // set up dimension of frame
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenDimension = tk.getScreenSize();
        Dimension frameDimension = frame.getSize();
        frame.setLocation((screenDimension.width - frameDimension.width) / 2,
                (screenDimension.height - frameDimension.height) / 2);
        frame.setVisible(true);
    }
}

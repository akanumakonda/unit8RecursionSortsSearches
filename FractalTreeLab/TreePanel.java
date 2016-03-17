import java.awt.*;
import javax.swing.JPanel;

public class TreePanel extends JPanel
{
   private final int PANEL_WIDTH = 400;
   private final int PANEL_HEIGHT = 500;

   private final double SQ = Math.sqrt(3.0) / 6;

   private final int TOPX = 150, TOPY = 150;
   private final int LEFTX = 20, LEFTY = 300;
   private final double THETAL = 45.0;
   private final double THETAR =  45.0;
   private int current; //current order

   //-----------------------------------------------------------------
   //  Sets the initial fractal order to the value specified.
   //-----------------------------------------------------------------
   public TreePanel (int currentOrder)
   {
      current = currentOrder;
      setBackground (Color.black);
      setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
   }

   //-----------------------------------------------------------------
   //  Draws the fractal recursively. Base case is an order of 1 for
   //  which a simple straight line is drawn. Otherwise three
   //  intermediate points are computed, and each line segment is
   //  drawn as a fractal.
   //-----------------------------------------------------------------
   public void drawFractal (double theta, double x, double y, double length, Graphics page, int order)
   {
      double leftX, leftY, rightX, rightY, newThetaL, newThetaR, newLength;
      // need previous angle to do theta previous + current theta to 
      if (order >= 15)
         return;
      else
      {
         newThetaL = theta + THETAL;
         newThetaR = theta - THETAR;
         newLength = length * 2/3;  // two thirds
         leftX = (newLength * Math.sin(newThetaL))+ x;
         leftY = y -(newLength * Math.cos(newThetaL));
         rightX = (newLength * Math.sin(newThetaR)) + x;
         rightY = y -(newLength * Math.cos(newThetaR));
         order++;
         page.setColor(Color.red);
         page.drawLine((int) x, (int) y, (int) leftX, (int) leftY);
         page.setColor(Color.gray);
         page.drawLine((int) x,(int) y,(int) rightX, (int) rightY);
         drawFractal(newThetaL, leftX, leftY, newLength, page, order);
         drawFractal(newThetaR, rightX, rightY, newLength, page, order);
      }
   }

   //-----------------------------------------------------------------
   //  Performs the initial calls to the drawFractal method.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
      super.paintComponent (page);

      page.setColor (Color.red);
      page.drawLine(250,250, 250, 200);
      drawFractal (0.0, 250, 200, 50, page, 1);
   }

   //-----------------------------------------------------------------
   //  Sets the fractal order to the value specified.
   //-----------------------------------------------------------------
   public void setOrder (int order)
   {
      current = order;
   }

   //-----------------------------------------------------------------
   //  Returns the current order.
   //-----------------------------------------------------------------
   public int getOrder ()
   {
      return current;
   }
}

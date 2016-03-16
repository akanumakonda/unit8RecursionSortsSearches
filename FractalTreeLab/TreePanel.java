import java.awt.*;
import javax.swing.JPanel;

public class TreePanel extends JPanel
{
   private final int PANEL_WIDTH = 400;
   private final int PANEL_HEIGHT = 400;

   private final double SQ = Math.sqrt(3.0) / 6;

   private final int TOPX = 200, TOPY = 20;
   private final int LEFTX = 60, LEFTY = 300;
   private final int RIGHTX = 340, RIGHTY = 300;
   private final double THETA = 45.0;
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
   public void drawFractal (double theta, double x, double y, double length, Graphics page, int order, double oldx, double oldy)
   {
      double leftX, leftY, rightX, rightY, newThetaL, newThetaR, newLength;
      // need previous angle to do theta previous + current theta to 
      if (order == 1)
         return;
      else
      {
         newThetaL = theta + THETA;
         newThetaR = theta - THETA;
         newLength = length * 2/3;  // two thirds
         leftX = (newLength * sine(newThetaL))+ x1;
         leftY = (newLength * cos(newThetaL)) + y1;
         rightX = (newLength * sine(newThetaR)) + x1;
         rightY = (newLength * cos(newThetaR)) + y1;
         order--;
         page.drawLine
         drawFractal (newTheta, leftX, leftY, newLength, page, order);
         drawFractal (newTheta, rightX, rightY, newLength, page, order);
      }
   }

   //-----------------------------------------------------------------
   //  Performs the initial calls to the drawFractal method.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
      super.paintComponent (page);

      page.setColor (Color.green);

      drawFractal (current, TOPX, TOPY, LEFTX, LEFTY, page);
      drawFractal (current, LEFTX, LEFTY, RIGHTX, RIGHTY, page);
      drawFractal (current, RIGHTX, RIGHTY, TOPX, TOPY, page);
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

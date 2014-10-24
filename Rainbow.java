// Chapter 6 Question 19

// Mark Duanmu

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rainbow extends JPanel
{
	
	Color skyColor = Color.CYAN; //private field skyColor, initialized to Cyan color
  public Rainbow()
  {
    setBackground(skyColor); //sets background to skyColor (cyan)
  }

  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    int width = getWidth();    //variable width = width of window
    int height = getHeight(); //variable height = height of window
    int xCenter = (int)((double)width/2); //xCenter is 1/2 of width
    int yCenter = (int)((double)height*0.75); //yCenter is 3/4 of height down
    System.out.println("xCenter: " +xCenter+ ", yCenter: " + yCenter);

 
    int largeRadius = (int)(width/4); //declares local variable largeRadius, equal 1/4 of window width
    g.setColor(Color.RED); //selects color red
    g.fillArc(xCenter-largeRadius, yCenter-largeRadius, 2*largeRadius, 2*largeRadius, 0, 180); // fills largest semicircle with red, using largeRadius
    
    int smallRadius = height/4; //declares local variable smallRadius, equal to 1/4 of height
    int mediumRadius = (int)Math.sqrt(smallRadius*largeRadius); //declares local variable mediumRadius, geometric mean of small and large ones
    
    g.setColor(Color.GREEN); //selects the green color
    g.fillArc(xCenter-mediumRadius, yCenter-mediumRadius, 2*mediumRadius, 2*mediumRadius, 0, 180); //fills in medium semicircle with green, using mediumRadius
    
    g.setColor(Color.MAGENTA); //selects magenta color
    g.fillArc(xCenter-smallRadius, yCenter-smallRadius, 2*smallRadius, 2*smallRadius, 0, 180); //fills in smallest semicircle with magenta, using smallRadius
    
    int evenSmallerRadius = 3*(smallRadius) - 3*(mediumRadius) + largeRadius; //declares local variable evenSmallerRadius, which sets the width of the green arc equal to the arithmetic mean of the magenta and red arcs. Derived as follows:
/*
	mediumW=mediumR-smallR
	smallW=smallR-evensmallerR
	largeW=largeR-mediumR
	&
	mediumW = (smallW + largeW)/2
	
	Therefore (using substitution):

	mediumR-smallR = (smallR-evensmallerR + largeR - mediumR)/2

	(mediumR-smallR)*2 = smallR - evensmallerR + largeR - mediumR

	(mediumR-smallR)*2 - smallR - largeR + mediumR = -even Smaller

	-(medium-small)*2 + small + large - medium = evenSmaller

	smallR*3 - mediumR*3 + largeR = evenSmallerR 
**/
    
    g.setColor(skyColor); //selects background (sky) color, which is cyan
    g.fillArc(xCenter-evenSmallerRadius, yCenter-evenSmallerRadius, 2*evenSmallerRadius, 2*evenSmallerRadius, 0, 180); //fills in the "evensmaller" arc, which fills in area under the rainbow with backgrond color (cyan)
 
  }

  public static void main(String[] args) //main method, executes program and sets bounds
  {
    JFrame w = new JFrame("Rainbow");
    w.setBounds(300, 300, 300, 200);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = w.getContentPane();
    c.add(new Rainbow());
    w.setVisible(true);
  }
}

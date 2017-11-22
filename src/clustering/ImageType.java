/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clustering;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Roberto Cruz Leija
 */
public class ImageType {
    
    
    public static Image toImage(BufferedImage bi){
     
       return bi.getScaledInstance(bi.getWidth(), bi.getHeight(), BufferedImage.TYPE_INT_RGB);
    
    }
    
    public static BufferedImage toBufferedImage(Image img){
    if (img instanceof BufferedImage)
    {
        return (BufferedImage) img;
    }

    // Create a buffered image with transparency
    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);

    // Draw the image on to the buffered image
    Graphics2D bGr = bimage.createGraphics();
    bGr.drawImage(img, 0, 0, null);
    bGr.dispose();

    // Return the buffered image
    return bimage;
  }
    
  
  
  
 

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clustering;


import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Roberto Cruz Leija
 */
public class IOImage {
    
    
    public static Image abrirImagen(){
     
        try {
            // definir los fltros de los tipos de imagenes
            FileNameExtensionFilter filtro =
                    new FileNameExtensionFilter("Imagenes","png","jpg","bmp");
            // declarar e inicializar la venta de seleccion
            JFileChooser seleccion = new JFileChooser();
            seleccion.addChoosableFileFilter(filtro);
            // especificamos que solo puede abrir archivos
            seleccion.setFileSelectionMode(JFileChooser.FILES_ONLY);
            
            // ejecutar el selector de archivos
            int resutlado = seleccion.showOpenDialog(null);
            // si el evento fue cancelar
            if (resutlado== JFileChooser.CANCEL_OPTION){
                return null;
            }
            File archivo = seleccion.getSelectedFile();
            BufferedImage bfi = ImageIO.read(archivo);
            Color color = new Color(bfi.getRGB(250, 280)) ;
            int red = color.getRed();
            int green = color.getGreen();
            int blue = color.getBlue();
            Color rosa = new Color(251,1,150);
            for(int x=0; x<bfi.getWidth();x++)
                for(int y=0; y<bfi.getHeight();y++){
                 if(color.getRGB()==bfi.getRGB(x, y))
                    bfi.setRGB(x, y, rosa.getRGB());
                }
            
            System.out.println();
            return bfi.getScaledInstance(bfi.getWidth(),bfi.getHeight(),BufferedImage.TYPE_INT_RGB);
        } catch (IOException ex) {
            Logger.getLogger(IOImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public static void guardarImagen(Image imagen) throws IOException{
        // convertimos a buffered
        BufferedImage bi = ImageType.toBufferedImage(imagen);
        // declaramos la ventana para seleccionar la ruta 
        JFileChooser ventana = new JFileChooser();
        int res = ventana.showSaveDialog(null);
        if (res == JFileChooser.APPROVE_OPTION){
           File archivo = ventana.getSelectedFile();
           ImageIO.write(bi,"jpg", archivo);
        }
          
    }


    
}

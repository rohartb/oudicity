package Oudicity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

public class AireBarre extends JComponent{
BufferedImage image;

public AireBarre(){
    try {
        image = ImageIO.read(getImage("fond.png"));
    }catch (IOException e) {
        e.printStackTrace();
    }
}

    @Override
public void paintComponent(Graphics g){
    Graphics2D drawable = (Graphics2D)g;
    drawable.drawImage(image, 0, 0, 200, 340, null);


}

    private URL getImage(String nom) {
        ClassLoader cl = getClass().getClassLoader();
        return cl.getResource("Image/"+nom);
    }
}

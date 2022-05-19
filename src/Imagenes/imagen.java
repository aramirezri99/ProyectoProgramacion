package Imagenes;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class imagen extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        Dimension tam=getSize();
        ImageIcon img=new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/logo.jpg")).getImage());
        g.drawImage(img.getImage(), 0, 0, tam.width, tam.height, null);
    }
}

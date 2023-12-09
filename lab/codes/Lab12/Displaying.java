

import javax.swing.*;
import java.awt.*;

public class Displaying {
    public static void main(String[] args)
    {
        JFrame window=new JFrame(); //create a Frame
        window.setSize(400,400); //set the size of the window
        ImageIcon picture=new ImageIcon("C:\\Users\\Lynchrocket\\Desktop\\java\\la\\src\\HomeBackground.jpg");
//load a picture from computer
        picture.setImage(picture.getImage().getScaledInstance((int) (0.5*window.getWidth()), (int) (0.5*window.getHeight()), Image.SCALE_DEFAULT));//图片自适应窗口大小
        JLabel label=new JLabel(picture); //add the picture to a label
        window.add(label); //add the label to the frame
        window.setVisible(true); //Set the window to visible

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //let the window can be close by click "x"
    }
}

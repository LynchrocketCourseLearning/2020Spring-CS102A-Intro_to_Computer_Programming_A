package minesweeper;

import LAN.LanStartFrame;
import controller.GameController;
import controller.Load;
import sound.Music;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//主界面
public class HomeFrame extends JFrame {
    public static Music music;
    public HomeFrame() {
        music = new Music();
        music.setMusic("src\\asserts\\Music\\Chase.wav");
        music.playMusic();
        music.controlMusic(1);
        music.controlMusic(3);
        //jFrame中的各种属性
        JFrame hFrame = new JFrame();
        hFrame.setBounds(100, 40, 1080, 720);
        hFrame.setTitle("MINESWEEPER");
        hFrame.setResizable(false);//窗口不可调整大小

        //jPanel中各种属性
        JPanel jpanel = new HomePanel();
        jpanel.setLayout(null);
        hFrame.add(jpanel);

        //加入New game按钮
        JButton hbtn1 = ButtonInitSetter(true,
                "src\\asserts\\HomeFrame buttons\\before press\\Startgame.jpg");//初始按钮设置
        hbtn1.setLocation(280, 290);
        ButtonSelectedSetter(true, hbtn1,
                "src\\asserts\\HomeFrame buttons\\selected\\Startgame.jpg");//选中按钮设置
        hbtn1.addActionListener(e -> {
            music.controlMusic(2);
            StartFrame startFrame = new StartFrame();
            GamePanel.isFirstStep=true;
        });//"Start" 监听器设置，lambda表达式
        jpanel.add(hbtn1);

        //LAN game按钮
        JButton hbtn2 = ButtonInitSetter(true,
                "src\\asserts\\HomeFrame buttons\\before press\\LANgame.jpg");//初始按钮设置
        hbtn2.setLocation(280, 360);
        ButtonSelectedSetter(true, hbtn2,
                "src\\asserts\\HomeFrame buttons\\selected\\LANgame.jpg");//选中按钮设置
        hbtn2.addActionListener(e -> new LanStartFrame());
        jpanel.add(hbtn2);

        //Load game按钮
        JButton hbtn3 = ButtonInitSetter(true,
                "src\\asserts\\HomeFrame buttons\\before press\\Loadgame.jpg");//初始按钮设置
        hbtn3.setLocation(280, 430);
        ButtonSelectedSetter(true, hbtn3,
                "src\\asserts\\HomeFrame buttons\\selected\\Loadgame.jpg");//选中按钮设置
        hbtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = JOptionPane.showInputDialog(this, "input here");
                System.out.println("fileName :" + fileName);
                Load load=new Load();
                load.readFileData(fileName);//    读档
            }
        });
        jpanel.add(hbtn3);

        //Option按钮
        JButton hbtn4 = ButtonInitSetter(false,
                "src\\asserts\\HomeFrame buttons\\before press\\Option.jpg");//初始按钮设置
        hbtn4.setLocation(280, 530);
        ButtonSelectedSetter(false, hbtn4,
                "src\\asserts\\HomeFrame buttons\\selected\\Option.jpg");//选中按钮设置
        hbtn4.addActionListener(e -> { OptionFrame optionFrame = new OptionFrame(); });//"Option" 监听器设置,lambda表达式
        jpanel.add(hbtn4);

        //Exit game按钮
        JButton hbtn5 = ButtonInitSetter(false,
                "src\\asserts\\HomeFrame buttons\\before press\\Exitgame.jpg");//初始按钮设置
        hbtn5.setLocation(550, 530);//位置设置
        ButtonSelectedSetter(false, hbtn5,
                "src\\asserts\\HomeFrame buttons\\selected\\Exitgame.jpg");//选中按钮设置
        hbtn5.addActionListener(e -> System.exit(0));//"Exit Game" 监听器设置,lambda表达式
        jpanel.add(hbtn5);

        hFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hFrame.setVisible(true);
    }

    //设置初始按钮,str是图片地址，che是用来检测哪种按钮
    public JButton ButtonInitSetter(boolean che, String str) {
        JButton btn = new JButton();
        if (che) {
            btn.setSize(new Dimension(500, 50));
        } else {
            btn.setSize(new Dimension(230, 50));
        }
        ImageIcon icon = new ImageIcon(str);
        //根据按钮大小改变图片大小
        Image inter = icon.getImage().getScaledInstance(btn.getWidth(), btn.getHeight(), icon.getImage().SCALE_DEFAULT);
        icon = new ImageIcon(inter);
        btn.setIcon(icon);
        return btn;
    }

    //设置选中按钮,str是图片地址，che是用来检测哪种按钮,btn是需要设置的按钮
    public JButton ButtonSelectedSetter(boolean che, JButton btn, String str) {
        if (che) {
            btn.setSize(new Dimension(500, 50));
        } else {
            btn.setSize(new Dimension(230, 50));
        }
        ImageIcon icon = new ImageIcon(str);
        //根据按钮大小改变图片大小
        Image inter = icon.getImage().getScaledInstance(btn.getWidth(), btn.getHeight(), icon.getImage().SCALE_DEFAULT);
        icon = new ImageIcon(inter);
        btn.setRolloverIcon(icon);
        return btn;
    }

    //设置主界面背景图片
    public class HomePanel extends JPanel {
        ImageIcon icon;
        Image img;
        // 提取图片
        public HomePanel() {
            icon = new ImageIcon("src\\asserts\\HomeBackground.jpg");
            img = icon.getImage();
        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //背景图片可以跟随窗口自行调整大小，可以设置成固定大小
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}

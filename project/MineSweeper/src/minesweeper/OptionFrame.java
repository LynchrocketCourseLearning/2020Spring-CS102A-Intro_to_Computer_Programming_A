package minesweeper;

import entity.GameMode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionFrame extends JFrame {
    public OptionFrame() {
        //界面
        JFrame oFrame = new JFrame();
        oFrame.setBounds(100, 40, 1080, 720);
        oFrame.setTitle("OPTION");
        oFrame.setResizable(false);//窗口不可调整大小

        //背景图
        JPanel oPanel = new OptionPanel();
        oPanel.setLayout(new GridLayout(11, 1, 0, 0));
        oFrame.add(oPanel);


        JLabel olabel1 = BackgroundSetter(
                "src\\asserts\\OptionFrame\\Option.png");//抬头标题
        oPanel.add(olabel1);

        //返回键
        JButton back = ButtonInitSetter(
                false,"src\\asserts\\StartFrame\\back.jpg");
        ButtonSelectedSetter(false, back,"src\\asserts\\StartFrame\\back1.jpg");
        back.setLocation(20,10);
        back.addActionListener(e ->
                {oFrame.dispose();
                }
        );
        olabel1.add(back);

        JLabel occupylabel1 = new JLabel();//占位
        oPanel.add(occupylabel1);

        //难度
        JLabel olabel2 = BackgroundSetter(
                "src\\asserts\\OptionFrame\\Difficulty.png");
        oPanel.add(olabel2);

        JPanel opanel1 = new OptionPanel();//难度按钮
        opanel1.setLayout(new GridLayout(1, 4, 50, 50));
        oPanel.add(opanel1);

        JLabel occupylabel2 = new JLabel();//占位
        oPanel.add(occupylabel2);

        //音量
        JLabel olabel3 = BackgroundSetter(
                "src\\asserts\\OptionFrame\\Volume.png");
        oPanel.add(olabel3);

        JSlider oslider = new JSlider();//音量滑条
        oslider.setOpaque(false);
        oPanel.add(oslider);

        JLabel occupylabel3 = new JLabel();//占位
        oPanel.add(occupylabel3);

        //开发者
        JLabel olabel4 = BackgroundSetter(
                "src\\asserts\\OptionFrame\\developer.png");
        oPanel.add(olabel4);

        JLabel olabel5 = BackgroundSetter(
                "src\\asserts\\OptionFrame\\baobao.png");
        oPanel.add(olabel5);

        JLabel olabel6 = BackgroundSetter(
                "src\\pro\\OptionFrame\\rocket.png");
        oPanel.add(olabel6);

        //加入难度按钮
        //ToDo：想要修改gamemode，直接调用即可，已经设置为静态变量；
        //举例：MainFrame.gameMode= GameMode.Easy;
        JButton obtn1 = ButtonInitSetter(true,
                "src\\asserts\\OptionFrame\\before press\\easy.jpg");//easy按钮设置

        ButtonSelectedSetter(true, obtn1,
                "src\\asserts\\OptionFrame\\selected\\easy.jpg");//选中按钮设置
        obtn1.addActionListener(e -> {
            MainFrame.gameMode = GameMode.Easy;
            JOptionPane.showMessageDialog(null, "Easy mode is set");
        });
        opanel1.add(obtn1);

        JButton obtn2 = ButtonInitSetter(true,
                "src\\asserts\\OptionFrame\\before press\\medium.jpg");//medium按钮设置

        ButtonSelectedSetter(true, obtn2,
                "src\\asserts\\OptionFrame\\selected\\medium.jpg");//选中按钮设置
        obtn2.addActionListener(e -> {
            MainFrame.gameMode = GameMode.Medium;
            JOptionPane.showMessageDialog(null, "Medium mode is set");
        });
        opanel1.add(obtn2);

        JButton obtn3 = ButtonInitSetter(true,
                "src\\asserts\\OptionFrame\\before press\\hard.jpg");//hard按钮设置

        ButtonSelectedSetter(true, obtn3,
                "src\\asserts\\OptionFrame\\selected\\hard.jpg");//选中按钮设置
        obtn3.addActionListener(e -> {
            MainFrame.gameMode = GameMode.Hard;
            JOptionPane.showMessageDialog(null, "Hard mode is set");
        });
        opanel1.add(obtn3);

        JButton obtn4 = ButtonInitSetter(true,
                "src\\asserts\\OptionFrame\\before press\\custom.jpg");//custom按钮设置

        ButtonSelectedSetter(true, obtn4,
                "src\\asserts\\OptionFrame\\selected\\custom.jpg");//选中按钮设置
        obtn4.addActionListener(e -> {
            MainFrame.gameMode = GameMode.Custom;
            MainFrame.gameMode.Custom();
        });
        opanel1.add(obtn4);

        oFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//关闭后释放，不影响上一级
        oFrame.setVisible(true);
    }

    //设置初始按钮,str是图片地址，che是用来检测哪种按钮
    public JButton ButtonInitSetter(boolean che, String str) {
        JButton btn = new JButton();
        if(che){
            btn.setSize(new Dimension(230, 60));
        } else{
            btn.setSize(new Dimension(115, 30));
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
        if(che) {
            btn.setSize(new Dimension(230, 60));
        }else{
            btn.setSize(new Dimension(115, 30));
        }
        ImageIcon icon = new ImageIcon(str);
        //根据按钮大小改变图片大小
        Image inter = icon.getImage().getScaledInstance(btn.getWidth(), btn.getHeight(), icon.getImage().SCALE_DEFAULT);
        icon = new ImageIcon(inter);
        btn.setRolloverIcon(icon);
        return btn;
    }

    public JLabel BackgroundSetter(String str) {
        JLabel lab = new JLabel();
        lab.setSize(new Dimension(1080, 60));
        ImageIcon icon = new ImageIcon(str);
        //根据按钮大小改变图片大小
        Image inter = icon.getImage().getScaledInstance(lab.getWidth(), lab.getHeight(), icon.getImage().SCALE_DEFAULT);
        icon = new ImageIcon(inter);
        lab.setIcon(icon);
        return lab;
    }

    //设置设置背景图片
    public class OptionPanel extends JPanel {
        ImageIcon icon;
        Image img;

        // 提取图片
        public OptionPanel() {
            icon = new ImageIcon("src\\asserts\\tu1080.jpg");
            img = icon.getImage();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //背景图片可以跟随窗口自行调整大小，可以设置成固定大小
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}

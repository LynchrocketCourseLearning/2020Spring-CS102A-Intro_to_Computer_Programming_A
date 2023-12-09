package LAN;

import controller.GameController;
import entity.Player;
import entity.Role;
import minesweeper.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class LanStartFrame extends JFrame {
    public static GameController controller;
    private boolean ready1 = false;
    private boolean ready2 = false;
    private Role role = Role.CocoGoat;

    //开始界面
    public LanStartFrame() {
//        Client.SendBroadCast("Player is connected","10.17.76.216");
        if (Host.ReceiveBroadCast()!=null){
            System.out.println("Player is connected!");
            Client.SendBroadCast("Player is connected","10.17.76.216");
        }
        //可能要重写，决定是否传参（玩家名
        Player p1 = new Player();
        Player p2 = new Player();
        controller = new GameController(p1, p2);
        controller.setOnTurn(p1);

        JFrame sFrame = new JFrame();
        sFrame.setBounds(100, 40, 1080, 720);
        sFrame.setLayout(new GridLayout(1, 2));
        sFrame.setTitle("START");
        sFrame.setResizable(false);//窗口不可调整大小

        //人物按钮图以及用户名输入panel
        JPanel sPanel = new StartPanel();
        sPanel.setLayout(null);
        sFrame.add(sPanel);

        //背景图label
        JLabel slabel = new JLabel();
        slabel.setSize(540, 720);
        ImageIcon icon = new ImageIcon("src\\asserts\\tu.jpg");//默认图片:背景图
        //根据slabel大小改变图片大小
        Image inter = icon.getImage().getScaledInstance(slabel.getWidth(), slabel.getHeight(), icon.getImage().SCALE_DEFAULT);
        slabel.setIcon(new ImageIcon(inter));
        slabel.setLayout(null);
        sFrame.add(slabel);

        //人物技能描述
        JLabel slabel1 = new JLabel();//具体内容以及加入sPanel将在监听器里设置
        slabel1.setBackground(Color.WHITE);
        slabel1.setOpaque(true);
        slabel1.setBounds(20, 200, 200, 50);

        //第一个人物按键
        JButton sbtn1 = ButtonInitSetter(false, "src\\asserts\\StartFrame\\kath head.png");
        sbtn1.setBounds(20, 20, 80, 80);
        sbtn1.addActionListener(e -> {
            ImageIcon icon1 = new ImageIcon("src\\asserts\\StartFrame\\role1.jpg");
            //根据slabel大小改变图片大小
            Image inter1 = icon1.getImage().getScaledInstance(slabel.getWidth(), slabel.getHeight(), icon1.getImage().SCALE_DEFAULT);
            slabel.setIcon(new ImageIcon(inter1));
            slabel1.setText("   Katheryne:  Reduce one mistake");//kath的技能，减少一次mistake
            sPanel.add(slabel1);
            role = Role.Katheryne;
        });
        sPanel.add(sbtn1);

        //第二个人物按键
        JButton sbtn2 = ButtonInitSetter(false, "src\\asserts\\StartFrame\\coco head.png");
        sbtn2.setBounds(190, 20, 80, 80);
        sbtn2.addActionListener(e -> {
            ImageIcon icon12 = new ImageIcon("src\\asserts\\StartFrame\\role2.jpg");
            //根据slabel大小改变图片大小
            Image inter12 = icon12.getImage().getScaledInstance(slabel.getWidth(), slabel.getHeight(), icon12.getImage().SCALE_DEFAULT);
            slabel.setIcon(new ImageIcon(inter12));
            slabel1.setText("   CocoGoat:  add a score");//coco的技能，加1分
            sPanel.add(slabel1);
            role = Role.CocoGoat;
        });
        sPanel.add(sbtn2);

        //返回键
        JButton sbtn3 = ButtonInitSetter(true, "src\\asserts\\StartFrame\\back.jpg");
        sbtn3.setLocation(20, 580);
        ButtonSelectedSetter(sbtn3, "src\\asserts\\StartFrame\\back1.jpg");
        sbtn3.addActionListener(e -> sFrame.dispose());
        sPanel.add(sbtn3);

        //player
        JPanel sPanel1 = new JPanel(new GridLayout(1, 2));
        sPanel1.setBounds(20, 400, 400, 50);
        JTextField sText1 = new JTextField("User#" + (new Random().nextInt(9000) + 1000));
        sPanel1.add(sText1);
        sPanel.add(sPanel1);

        //player确认键
        JButton sbtnp1 = ButtonInitSetter(true,"src\\asserts\\StartFrame\\ready.jpg");
        sbtnp1.setLocation(420, 400);
        ButtonSelectedSetter(sbtnp1, "src\\asserts\\StartFrame\\ready1.jpg");
        sbtnp1.addActionListener(e -> {
            ready1 = true;
            System.out.println("player is OK");
            sbtnp1.setVisible(false);
            controller.getP1().setUserName(sText1.getText());//设置获取p1用户名
            controller.getP1().setRole(role);
            String Message = Host.ReceiveBroadCast();//等待接受另外一位玩家的玩家名称
            if (Message!=null){
                System.out.println("Another player's name is received!");
                Client.SendBroadCast(controller.getP1().getUserName(),"10.17.76.216");//将本地玩家名字发送给另外一位玩家
            }
            //等待另一位玩家的角色
            String p2Message = Host.ReceiveBroadCast();
            if (p2Message!=null){
                if (p2Message.charAt(0)=='C') {
                p2.setRole(Role.CocoGoat);
                ready2=true;
                System.out.println("Another player is ready!");
            } else if (p2Message.charAt(0)=='K') {
                p2.setRole(Role.Katheryne);
                ready2=true;
                System.out.println("Another player is ready!");
            }
                Client.SendBroadCast(role.getName(),"10.17.76.216");//将玩家选择的角色发送给另外一位玩家
            }
            if (ready1 & ready2) {
                MainFrame.controller=controller;
                MainFrame mainFrame = new MainFrame();//开始
                MainFrame.OnLAN=true;
                sFrame.dispose();
            }

        });
        sPanel1.add(sbtnp1);

        //接受另外

//        //player2
//        JPanel sPanel2 = new JPanel(new GridLayout(1, 2));
//        sPanel2.setBounds(20, 450, 400, 50);
//        JTextField sText2 = new JTextField("User#" + (new Random().nextInt(9000) + 1000));
//        sPanel2.add(sText2);
//        sPanel.add(sPanel2);
//
//        //p2确认键
//        JButton sbtnp2 = ButtonInitSetter(true, "src\\asserts\\StartFrame\\ready.jpg");
//        sbtnp2.setBounds(420, 500, 230, 50);
//        ButtonSelectedSetter(sbtnp2, "src\\asserts\\StartFrame\\ready1.jpg");
//        sbtnp2.addActionListener(e -> {
//            ready2 = true;
//            System.out.println("p2 is OK");
//            sbtnp2.setVisible(false);
//            controller.getP2().setUserName(sText2.getText());//设置获取p2用户名
//            controller.getP2().setRole(role);
//            if (ready1 & ready2) {
//                MainFrame.controller=controller;
//                MainFrame mainFrame = new MainFrame();//开始
//                sFrame.dispose();
//            }
//        });
//        sPanel2.add(sbtnp2);


        sFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//关闭后释放，不影响上一级
        sFrame.setVisible(true);
    }


    public class StartPanel extends JPanel {
        ImageIcon icon;
        Image img;

        // 提取图片
        public StartPanel() {
            icon = new ImageIcon("src\\asserts\\tu.jpg");
            img = icon.getImage();
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //背景图片可以跟随窗口自行调整大小，可以设置成固定大小
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }

    //设置初始按钮,str是图片地址
    public JButton ButtonInitSetter(boolean che, String str) {
        JButton btn = new JButton();
        if (che) {
            btn.setSize(new Dimension(230, 50));
        } else {
            btn.setSize(new Dimension(80, 80));
        }

        //按钮图
        ImageIcon icon = new ImageIcon(str);
        //根据按钮大小改变图片大小
        Image inter = icon.getImage().getScaledInstance(btn.getWidth(), btn.getHeight(), icon.getImage().SCALE_DEFAULT);
        icon = new ImageIcon(inter);
        btn.setIcon(icon);
        return btn;
    }

    //设置选中按钮,str是图片地址,btn是需要设置的按钮
    public JButton ButtonSelectedSetter(JButton btn, String str) {
        btn.setSize(new Dimension(230, 50));

        //按钮图
        ImageIcon icon = new ImageIcon(str);
        //根据按钮大小改变图片大小
        Image inter = icon.getImage().getScaledInstance(btn.getWidth(), btn.getHeight(), icon.getImage().SCALE_DEFAULT);
        icon = new ImageIcon(inter);
        btn.setRolloverIcon(icon);
        return btn;
    }

}
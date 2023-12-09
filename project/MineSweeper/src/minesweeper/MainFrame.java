package minesweeper;


import components.GridComponent;
import controller.CountTimer;
import controller.GameController;
import controller.Load;
import entity.GameMode;
import entity.Player;
import entity.Role;
import sound.Music;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private int xCount;
    private int yCount;
    private int mineCount;
    public static GameController controller;
    public static GameMode gameMode = GameMode.Easy;
    public static boolean OnLAN = false;
    public static JFrame mFrame;
    public static Music music;

    ScoreBoard scoreBoard;
    public void SetGame(GameMode gameMode) {//或许可以删除？改为在PlayBoard设置
        //todo: change the count of xCount, yCount and mineCount by passing parameters from constructor
        xCount = gameMode.getXcount();//grid of row
        yCount = gameMode.getYcount();// grid of column
        mineCount = gameMode.getMinecount();// mine count
    }
    public MainFrame() {
        music = new Music();
        music.setMusic("src\\asserts\\Music\\Light.wav");
        music.playMusic();
        music.controlMusic(1);
        music.controlMusic(3);

        SetGame(gameMode);
        //设置
        GamePanel gamePanel = new GamePanel(xCount, yCount, mineCount, gameMode.isCheat());
        JOptionPane.showMessageDialog(null, controller.getOnTurnPlayer().getUserName() + " goes first!");
        controller.setGamePanel(gamePanel);

        mFrame = new JFrame();
        mFrame.setTitle("MINESWEEPER");
        mFrame.setLayout(null);//无布局
        mFrame.setSize(yCount * GridComponent.gridSize + 400, xCount * GridComponent.gridSize + 300);//按照格子数设置雷区
        mFrame.setLocationRelativeTo(null);//相对位置，null就是默认中央位置
        mFrame.setResizable(false);

        //底层界面包括：雷区（下面有计时器、save、load、next），两个人物板（含有计分板）
        gamePanel.setLocation(200, 0);
        JPanel funPanel = FunBoard();//中间界面，包括Board、Timer、Save、Load、Next
        funPanel.setLocation(200, xCount * GridComponent.gridSize);
        //加入中间界面
        mFrame.add(gamePanel);
        mFrame.add(funPanel);

        JPanel mPanel1 = PlayerBoard(controller.getP1());//p1人物板（包含角色图、技能、步数计分板）
        JPanel mPanel2 = PlayerBoard(controller.getP2());//p2人物板（包含角色图、技能、步数计分板）
        mPanel1.setLocation(0, 0);
        mPanel2.setLocation(yCount * GridComponent.gridSize + 200, 0);
        mFrame.add(mPanel1);
        mFrame.add(mPanel2);

        mFrame.setVisible(true);//可视化
        mFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);//设置关闭,关闭后释放，不影响上一级
    }

    public JPanel FunBoard() {
        //PlayBoard界面包括：计时器、save、load、next
        JPanel mPanel = new JPanel();//中间界面，包括Timer、Save、Load、Next
        mPanel.setLayout(new GridLayout(3, 1));
        mPanel.setSize(yCount * GridComponent.gridSize, 300);

        //存档键
        JButton clickBtn1 = new JButton("Save");
        clickBtn1.setSize(80, 30);
        clickBtn1.addActionListener(e -> {
            CountTimer.timer.stop();
            StartFrame.music. controlMusic(2);
            String fileName = JOptionPane.showInputDialog(this, "input here");
            System.out.println("fileName :" + fileName);
            controller.writeDataToFile(fileName);   // 存档
            MainFrame.mFrame.dispose();
            HomeFrame.music.controlMusic(1);
        });

        //读档键
        JButton clickBtn2 = new JButton("Load");
        clickBtn2.setSize(80, 30);
        clickBtn2.addActionListener(e -> {
            String fileName = JOptionPane.showInputDialog(this, "input here");
            System.out.println("fileName :" + fileName);
            mFrame.dispose();
            Load load = new Load();
            load.readFileData(fileName);      //    读档
        });

        //跳过键，该键的监听器在CountTimer中实现
        JButton clickBtn3 = new JButton("Next");
        clickBtn3.setSize(80, 30);

        //设置计分板
        scoreBoard = new ScoreBoard(controller.getP1(), controller.getP2(), xCount, yCount);
        controller.setScoreBoard(scoreBoard);
        mPanel.add(controller.getScoreBoard());

        //计时器
        CountTimer timer = new CountTimer();
        timer.setButton(clickBtn3);//将计时器中的对应按钮设成clickBtn3
        JPanel timerPanel = timer.CountdownTimer();
        //计时器的位置和大小
        timerPanel.setBounds(0, xCount * GridComponent.gridSize,
                gameMode.getYcount() * GridComponent.gridSize, 50);
        mPanel.add(timerPanel);


        //设置三个按钮的位置
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel.add(clickBtn1);
        buttonPanel.add(clickBtn2);
        buttonPanel.add(clickBtn3);
        buttonPanel.setLocation(0, 130 + xCount * GridComponent.gridSize);
        mPanel.add(buttonPanel);

        return mPanel;
    }

    public JPanel PlayerBoard(Player p) {
        JPanel playerPanel = new JPanel(){
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon img = new ImageIcon("src\\asserts\\tu.jpg");
                g.drawImage(img.getImage(),0,0,this.getWidth(),this.getHeight(),this);
            }
        };//人物板（包含角色图、技能）
        playerPanel.setLayout(null);
        playerPanel.setSize(300, xCount * GridComponent.gridSize + 300);
        //xCount * GridComponent.gridSize + 300
        //设置玩家role大图
        JLabel roleLabel = new JLabel();
        roleLabel.setBounds(0, 0, 200, xCount * GridComponent.gridSize + 200);
        ImageIcon icon;
        if (p.getRole() == Role.CocoGoat) {
            icon = new ImageIcon("src\\asserts\\MainFrame\\MainFrame role2.jpg");
        } else {
            icon = new ImageIcon("src\\asserts\\MainFrame\\MainFrame role1.jpg");
        }
        //根据roleLabel大小改变图片大小
        Image inter = icon.getImage().getScaledInstance(roleLabel.getWidth(), roleLabel.getHeight(), icon.getImage().SCALE_DEFAULT);
        roleLabel.setIcon(new ImageIcon(inter));
        playerPanel.add(roleLabel);

        //设置技能键
        JButton skillButton = new JButton();
        skillButton.setBounds(10, xCount * GridComponent.gridSize + 205, 160, 50);
        ImageIcon skill = new ImageIcon("src\\asserts\\MainFrame\\Skill_.jpg");
        //根据skillButton大小改变图片大小
        Image sinter = skill.getImage().getScaledInstance(220, 50, skill.getImage().SCALE_DEFAULT);
        skillButton.setIcon(new ImageIcon(sinter));
        if (p.getRole() == Role.CocoGoat) {
            skillButton.addActionListener(e -> {
                controller.getOnTurnPlayer().setScore(controller.getOnTurnPlayer().getScore() + 1);
                scoreBoard.update();
                skillButton.setVisible(false);
            });
        } else {
            skillButton.addActionListener(e -> {
                controller.getOnTurnPlayer().setMistake(controller.getOnTurnPlayer().getMistake() - 1);
                scoreBoard.update();
                skillButton.setVisible(false);
            });
        }
        playerPanel.add(skillButton);

        return playerPanel;
    }
}

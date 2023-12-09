package controller;

import LAN.Host;
import components.GridComponent;
import entity.GameMode;
import minesweeper.GamePanel;
import minesweeper.MainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CountTimer implements ActionListener, ChangeListener {
    JPanel panel = new JPanel() {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon img = new ImageIcon("src\\asserts\\tu.jpg");
            g.drawImage(img.getImage(), 0, 0, panel.getWidth(),panel.getHeight(),panel);
        }
    };
    JProgressBar progressbar;
    JLabel label;
    public static Timer timer;
    private JButton button;
    public static int max=10;



    public JPanel CountdownTimer() {
        label = new JLabel(" ", JLabel.CENTER);    //创建显示进度信息的文本标签
        panel.add(label, BorderLayout.SOUTH);

        progressbar = new JProgressBar();    //创建一个进度条
        progressbar.setOrientation(JProgressBar.HORIZONTAL);
        progressbar.setMinimum(0);
        progressbar.setMaximum(max);
        progressbar.setValue(max);
        progressbar.setStringPainted(true);

        progressbar.addChangeListener(this);    //添加事件监听器,this指的是CountTimer

        //设置进度条的几何形状
        progressbar.setPreferredSize(new Dimension(300, 20));
        progressbar.setBorderPainted(true);
        progressbar.setBackground(Color.CYAN);
        panel.add(progressbar, BorderLayout.NORTH);

        //添加事件监听器
        button.addActionListener(this);
        panel.add(button);
        timer = new Timer(1000, this);    //创建一个计时器，计时间隔为100毫秒
        return panel;
    }

    //todo：在按下按钮时玩家回合切换,还需要添加计时结束的回合切换
    //实现事件监听器接口中的方法
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            MainFrame.controller.nextTurn();
            progressbar.setValue(max);
//            if (GamePanel.isFirstStep){
//                for (int i=0;i<GamePanel.mineField.length;i++){
//                    String Message =Host.ReceiveBroadCast();
//                    String[] str=Message.split(" ");
//                    for (int j =0;i<GamePanel.mineField[i].length;j++){
//                        GamePanel.mineField[i][j].setContent(Integer.parseInt(str[j]));
//                    }
//                }
//            }
        }
        if (e.getSource() == timer) {
            int value = progressbar.getValue();
            if (value > 0) {
                progressbar.setValue(--value);
            } else {
                timer.stop();
                MainFrame.controller.nextTurn();
                progressbar.setValue(max);
                timer.start();
            }
        }
    }

    //实现事件监听器接口中的方法
    public void stateChanged(ChangeEvent e1) {
        int value = progressbar.getValue();
        if (e1.getSource() == progressbar) {
            label.setText("It remains " + value + " seconds.");
            label.setForeground(Color.white);
        }
    }

    public void setButton(JButton button) {
        this.button = button;
    }

}
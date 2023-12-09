package entity;
/**
 * 添加了开发者模式(Cheat)，并添加了三种基础模式的雷数，还有一些getter和setter
 **/

import controller.CountTimer;

import javax.swing.*;
import java.awt.*;

/** 添加了custom自定义游戏构造 **/
public enum GameMode {
    Easy(9, 9, 10),
    Medium(16, 16, 40),
    Hard(16, 30, 99),
    //自定义不能超过24×30，雷数不能超过总格子数的一半
    Custom();

    private int Xcount;
    private int Ycount;
    private int Minecount;
    private boolean isCheat;

    GameMode(int x, int y, int z) {
        this.Xcount = x;
        this.Ycount = y;
        this.Minecount = z;
        isCheat = false;
    }

    GameMode() {
    }

    public void Custom() {
        int che = 3;
        String y = JOptionPane.showInputDialog("Please input the width of the board y：");
        if (Integer.parseInt(y) > 24) {
            JOptionPane.showMessageDialog(null,"Too long!");
            che--;
        }

        String x = JOptionPane.showInputDialog("Please input the height of the board x：");
        if (Integer.parseInt(x) > 30) {
            JOptionPane.showMessageDialog(null,"Too long!");
            che--;
        }

        String mine = JOptionPane.showInputDialog("Please input the number of the mines：");
        if (Integer.parseInt(mine) > 0.5 * Integer.parseInt(x) * Integer.parseInt(y)) {
            JOptionPane.showMessageDialog(null,"Too many mines!");
            che--;
        }

        String time = JOptionPane.showInputDialog("Please input the max time of one turn：");
        if (Integer.parseInt(time) > 0) {
            CountTimer.max = Integer.parseInt(time);
        }

        if(che==3){
            Xcount = Integer.parseInt(x);
            Ycount = Integer.parseInt(y);
            Minecount = Integer.parseInt(mine);
            System.out.print(che);
        }else{
            Custom();
        }
    }

    public int getXcount() {
        return Xcount;
    }

    public void setXcount(int xcount) {
        Xcount = xcount;
    }

    public int getYcount() {
        return Ycount;
    }

    public void setYcount(int ycount) {
        Ycount = ycount;
    }

    public int getMinecount() {
        return Minecount;
    }

    public void setMinecount(int minecount) {
        Minecount = minecount;
    }

    public boolean isCheat() {
        return isCheat;
    }

    public void setCheat(boolean cheat) {
        isCheat = cheat;
    }
}


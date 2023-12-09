package controller;

import components.GridComponent;
import entity.GameMode;
import entity.GridStatus;
import entity.Role;
import minesweeper.*;
import entity.Player;

import javax.swing.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;


public class GameController {

    private Player p1;
    private Player p2;

    public void setOnTurn(Player onTurn) {
        this.onTurn = onTurn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    private Player onTurn;
    private int turn = 1;

    private GamePanel gamePanel;
    private ScoreBoard scoreBoard;

    public GameController(Player p1, Player p2) {
        this.init(p1, p2);
    }

    /**
     * 初始化游戏。在开始游戏前，应先调用此方法，给予游戏必要的参数。
     *
     * @param p1 玩家1
     * @param p2 玩家2
     */
    public void init(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        if (new Random().nextInt(2) == 0) {
            onTurn = p1;
            p1.setHasMoved(false);
        } else {
            onTurn = p2;
            p2.setHasMoved(false);
        }

        //TODO: 在初始化游戏的时候，还需要做什么？--用随机数决定哪个玩家优先,并把玩家操作状态重置为“未操作”
    }

    /**
     * 进行下一个回合时应调用本方法。
     * 在这里执行每个回合结束时需要进行的操作。
     * <p>
     * (目前这里没有每个玩家进行n回合的计数机制的，请自行修改完成哦~）
     */

    //将判断胜负的方法抽象了出来
    public boolean judge() {
        boolean toReturn = false;
        //分差大于剩余雷数
        if (p1.getScore() > p2.getScore() && p1.getScore() - p2.getScore() > (GamePanel.mineCount - GridComponent.shownMine)) {
            System.out.println("p1 won the game");
            JOptionPane.showMessageDialog(null, p1.getUserName()+" won the game");
            toReturn = true;
        }
        if (p2.getScore() > p1.getScore() && p2.getScore() - p1.getScore() > (GamePanel.mineCount - GridComponent.shownMine)) {
            System.out.println("p2 won the game");
            JOptionPane.showMessageDialog(null, p2.getUserName()+" won the game");
            toReturn = true;
        }
        //所有雷都被扫出来了
        if (GridComponent.shownMine == GamePanel.mineCount | (!p1.isHasMoved() & !p2.isHasMoved())) {
            if (p1.getScore() > p2.getScore()) {
                System.out.println("p1 won the game");
                JOptionPane.showMessageDialog(null, p1.getUserName()+" won the game！");
                toReturn = true;
            }
            if (p2.getScore() > p1.getScore()) {
                System.out.println("p2 won the game");
                JOptionPane.showMessageDialog(null, p2.getUserName()+" won the game！");
                toReturn = true;
            }
            if (p1.getScore() == p2.getScore()) {
                if (p1.getMistake() < p2.getMistake()) {
                    System.out.println("p1 won the game");
                    JOptionPane.showMessageDialog(null, p1.getUserName()+" won the game！");
                    toReturn = true;
                }
                if (p2.getMistake() < p1.getMistake()) {
                    System.out.println("p2 won the game");
                    JOptionPane.showMessageDialog(null, p2.getUserName()+" won the game！");
                    toReturn = true;
                }
                if (p2.getMistake() == p1.getMistake()) {
                    System.out.println("Draw");
                    JOptionPane.showMessageDialog(null, "Draw！Well played");
                    toReturn = true;
                }
            }
        }
        if (toReturn){
            CountTimer.timer.stop();
            StartFrame.music. controlMusic(2);
            MainFrame.mFrame.dispose();
            HomeFrame.music.controlMusic(1);
            if (MainFrame.gameMode.isCheat()){
                MainFrame.gameMode.setCheat(false);
                GridComponent.shownMine=0;
        }
        }

        return toReturn;
    }

    public void nextTurn() {
        if (!p1.isHasMoved() & !p2.isHasMoved()) {
            MainFrame.controller.judge();
            System.out.println("Game over");
            CountTimer.timer.stop();
        } else {
            //未结束，执行轮次切换
            if (onTurn == p1) {
                onTurn = p2;
                p2.setHasMoved(false);
            } else if (onTurn == p2) {
                onTurn = p1;
                p1.setHasMoved(false);
            }
            System.out.println("Now it is " + onTurn.getUserName() + "'s turn.");
            turn++;
            System.out.println("Now it is turn." + turn);
            scoreBoard.update();
            CountTimer.timer.start();
            //TODO: 在每个回合结束的时候，还需要做什么 ---检查游戏是否结束（已写）
        }
    }


    /**
     * 获取正在进行当前回合的玩家。
     *
     * @return 正在进行当前回合的玩家
     */
    public Player getOnTurnPlayer() {
        return onTurn;
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    public String writeGameMode(GameMode gameMode){
        String toReturn=null;
        if (gameMode==GameMode.Easy){
            toReturn="Easy";
        }
        if (gameMode==GameMode.Medium){
            toReturn="Medium";
        }if (gameMode==GameMode.Hard){
            toReturn="Hard";
        }if (gameMode==GameMode.Custom){
            toReturn="Custom "+gameMode.getXcount()+" "+gameMode.getYcount()+" "+gameMode.getMinecount();
        }
        if (gameMode.isCheat()){
            toReturn+=" T";
        }
        else toReturn+=" F";
        return toReturn;
    }
//    public GameMode readGameMode(String str){
//        String[] str1=str.split(" ");
//        GameMode toReturn=null ;
//        switch (str1[0]){
//            case "Easy":toReturn=GameMode.Easy;break;
//            case "Medium":toReturn= GameMode.Medium;break;
//            case "Hard":toReturn= GameMode.Hard;break;
//            case "Custom":{
//                toReturn = GameMode.Custom;
//                toReturn.setXcount(Integer.parseInt(str1[1]));
//                toReturn.setYcount(Integer.parseInt(str1[2]));
//                toReturn.setMinecount(Integer.parseInt(str1[3]));
//                break;}
//        }
//        if (str1[4].equals("T")){
//            toReturn.setCheat(true);
//        }
//        else if (str1[4].equals("F")){
//            toReturn.setCheat(false);
//        }
//        return toReturn;
//    }
//
//    //用txt文档存取（File类
    public void writeDataToFile(String fileName) {
        //todo: write data into file 存档
        try {
            File file = new File("src\\saveFile\\" + fileName + ".txt");
            if (!file.exists()) {
                file.createNewFile();//判断是否有重名文档，若无则创建
            }else {
                JOptionPane.showMessageDialog(null,"The file has existed!");
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));

            bw.write(String.format("%s\r\n",writeGameMode(MainFrame.gameMode)));
            bw.write(String.format("%s %s %d %d\r\n", p1.getUserName(), p1.getRole().getName(), p1.getScore(), p1.getMistake()));
            bw.write(String.format("%s %s %d %d\r\n", p2.getUserName(), p2.getRole().getName(), p2.getScore(), p2.getMistake()));
            bw.write(String.format("%s\r\n",onTurn.getUserName()));
            bw.write(String.format("%d\r\n",turn));

            //存雷区底层，也即数字状态（附近有多少雷）
            for (int i = 0; i < GamePanel.mineField.length; i++) {
                for (int j = 0; j < GamePanel.mineField[i].length; j++) {
                    bw.write(GamePanel.mineField[i][j].getContent() + " ");
                }
                bw.write("\r\n");
            }

            //存雷区表层，也即开格子的状态
            for (int i = 0; i < GamePanel.mineField.length; i++) {
                for (int j = 0; j < GamePanel.mineField[i].length; j++) {
                    bw.write(GamePanel.mineField[i][j].status.getName() + " ");
                }
                bw.write("\r\n");
            }


            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Illegal file!");
        }
    }

//    public void readFileData(String fileName) {
//        //todo: read date from file 读档
//        try {
//            File file = new File(fileName + ".txt");
//            BufferedReader br = new BufferedReader(new FileReader(file));
//
//            MainFrame.gameMode=readGameMode(br.readLine());
//
//
//            String p1Message = br.readLine();
//            String[] p1M = p1Message.split(" ");
//            if (p1M[2].equals("CocoGoat")) {
//                this.p1 = new Player(p1M[1], Role.CocoGoat, Integer.parseInt(p1M[3]), Integer.parseInt(p1M[4]));
//            } else if (p1M[2].equals("Katheryne")) {
//                this.p1 = new Player(p1M[1], Role.Katheryne, Integer.parseInt(p1M[3]), Integer.parseInt(p1M[4]));
//            } else {
//                JOptionPane.showMessageDialog(null, "Illegal player1 load file!");
//            }
//
//            String p2Message = br.readLine();
//            String[] p2M = p2Message.split(" ");
//            if (p2M[2].equals("CocoGoat")) {
//                this.p2 = new Player(p2M[1], Role.CocoGoat, Integer.parseInt(p2M[3]), Integer.parseInt(p2M[4]));
//            } else if (p2M[2].equals("Katheryne")) {
//                this.p2 = new Player(p2M[1], Role.Katheryne, Integer.parseInt(p2M[3]), Integer.parseInt(p2M[4]));
//            } else {
//                JOptionPane.showMessageDialog(null, "Illegal player2 load file!");
//            }
//
//            String ontrunMessage = br.readLine();
//            if (ontrunMessage.equals(p1.getUserName())) {
//                onTurn = p1;
//            } else if (ontrunMessage.equals(p2.getUserName())) {
//                onTurn = p2;
//            } else {
//                JOptionPane.showMessageDialog(null, "Illegal onturn load file!");
//            }
//            MainFrame.controller=this;
//            MainFrame mainFrame=new MainFrame();
//
//            //读取雷区尺寸
//            int rowNum = MainFrame.gameMode.getXcount();
//            int colNum = MainFrame.gameMode.getYcount();
//
//            //读取雷区底层，也即数字状态（附近有多少雷）
//            String grid = br.readLine();
//            String[] str = grid.split(" ");
//            for (int i = 0; i < rowNum; i++) {
//                for (int j = 0; j < colNum; j++) {
//                    GamePanel.mineField[i][j].setContent(Integer.parseInt(str[j]));
//                }
//                grid = br.readLine();
//                str = grid.split(" ");
//            }
//
//            //读取雷区表层，也即开格子的状态
//            grid = br.readLine();
//            str = grid.split(" ");
//            for (int i = 0; i < rowNum; i++) {
//                for (int j = 0; j < colNum; j++) {
//                    switch (str[j]){
//                        case "C": GamePanel.mineField[i][j].status = GridStatus.Covered;break;
//                        case "F":GamePanel.mineField[i][j].status = GridStatus.Flag;break;
//                        case "U":GamePanel.mineField[i][j].status = GridStatus.Clicked;break;
//                        case "M":GamePanel.mineField[i][j].status = GridStatus.Mine;break;
//                        case "Cheat":GamePanel.mineField[i][j].status = GridStatus.cheat;break;
//                    }
//                }
//                grid = br.readLine();
//                str = grid.split(" ");
//            }
//
//            MainFrame.controller=this;
//
//            br.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Illegal file!");
//        }
//    }


}

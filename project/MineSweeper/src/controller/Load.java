package controller;

import components.GridComponent;
import entity.GameMode;
import entity.GridStatus;
import entity.Player;
import entity.Role;
import minesweeper.GamePanel;
import minesweeper.MainFrame;
import minesweeper.StartFrame;

import javax.swing.*;
import java.io.*;

import static entity.GameMode.*;

public class Load {
    private Player p1;
    private Player p2;
    private Player onTurn;
    private int turn = 1;

//    public String writeGameMode(GameMode gameMode) {
//        String toReturn = null;
//        switch (gameMode) {
//            case Easy:
//                toReturn = "Easy";
//                break;
//            case Medium:
//                toReturn = "Medium";
//                break;
//            case Hard:
//                toReturn = "Hard";
//                break;
//            case Custom:
//                toReturn = "Custom " + gameMode.getXcount() + " " + gameMode.getYcount() + " " + gameMode.getMinecount();
//                break;
//        }
//        if (gameMode.isCheat()) {
//            toReturn += " T";
//        } else {
//            toReturn += " F";
//        }
//
//        return toReturn;
//    }

    public GameMode readGameMode(String str) {
        String[] str1 = str.split(" ");
        GameMode toReturn = null;
        switch (str1[0]) {
            case "Easy":
                toReturn = Easy;
                break;
            case "Medium":
                toReturn = Medium;
                break;
            case "Hard":
                toReturn = Hard;
                break;
            case "Custom": {
                toReturn = Custom;
                toReturn.setXcount(Integer.parseInt(str1[1]));
                toReturn.setYcount(Integer.parseInt(str1[2]));
                toReturn.setMinecount(Integer.parseInt(str1[3]));
                if (str1[4].equals("T")) {
                    toReturn.setCheat(true);
                } else if (str1[4].equals("F")) {
                    toReturn.setCheat(false);
                }
                break;
            }
        }
        if (str1[1].equals("T")) {
            toReturn.setCheat(true);
        } else if (str1[1].equals("F")) {
            toReturn.setCheat(false);
        }
        return toReturn;
    }

//    //用txt文档存取（File类
//    public void writeDataToFile(String fileName) {
//        //todo: write data into file 存档
//        try {
//            File file = new File("src\\saveFile\\" + fileName + ".txt");
//            if (!file.exists()) {
//                file.createNewFile();//判断是否有重名文档，若无则创建
//            } else {
//                JOptionPane.showMessageDialog(null, "The file has existed!");
//            }
//
//            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//
//            bw.write(String.format("%s\r\n", writeGameMode(MainFrame.gameMode)));
//            bw.write(String.format("%s %s %d %d\r\n", p1.getUserName(), p1.getRole().getName(), p1.getScore(), p1.getMistake()));
//            bw.write(String.format("%s %s %d %d\r\n", p2.getUserName(), p2.getRole().getName(), p2.getScore(), p2.getMistake()));
//            bw.write(String.format("%s\r\n", onTurn.getUserName()));
//            bw.write(String.format("%d\r\n", turn));
//
//            //存雷区底层，也即数字状态（附近有多少雷）
//            for (int i = 0; i < GamePanel.mineField.length; i++) {
//                for (int j = 0; j < GamePanel.mineField[i].length; j++) {
//                    bw.write(GamePanel.mineField[i][j].getContent() + " ");
//                }
//                bw.write("\r\n");
//            }
//
//            //存雷区表层，也即开格子的状态
//            for (int i = 0; i < GamePanel.mineField.length; i++) {
//                for (int j = 0; j < GamePanel.mineField[i].length; j++) {
//                    bw.write(GamePanel.mineField[i][j].status.getName() + " ");
//                }
//                bw.write("\r\n");
//            }
//
//
//            bw.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Illegal file!");
//        }
//    }

    public void readFileData(String fileName) {
        //todo: read date from file 读档
        try {
            File file = new File("src\\saveFile\\" + fileName + ".txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            MainFrame.gameMode = readGameMode(br.readLine());


            String p1Message = br.readLine();
            String[] p1M = p1Message.split(" ");
            if (p1M[1].equals("CocoGoat")) {
                this.p1 = new Player(p1M[0], Role.CocoGoat, Integer.parseInt(p1M[2]), Integer.parseInt(p1M[3]));
            } else if (p1M[1].equals("Katheryne")) {
                this.p1 = new Player(p1M[0], Role.Katheryne, Integer.parseInt(p1M[2]), Integer.parseInt(p1M[3]));
            } else {
                JOptionPane.showMessageDialog(null, "Illegal player1 load file!");
            }

            String p2Message = br.readLine();
            String[] p2M = p2Message.split(" ");
            if (p2M[1].equals("CocoGoat")) {
                this.p2 = new Player(p2M[0], Role.CocoGoat, Integer.parseInt(p2M[2]), Integer.parseInt(p2M[3]));
            } else if (p2M[1].equals("Katheryne")) {
                this.p2 = new Player(p2M[0], Role.Katheryne, Integer.parseInt(p2M[2]), Integer.parseInt(p2M[3]));
            } else {
                JOptionPane.showMessageDialog(null, "Illegal player2 load file!");
            }


            String ontrunMessage = br.readLine();
            if (ontrunMessage.equals(p1.getUserName())) {
                onTurn = p1;
            } else if (ontrunMessage.equals(p2.getUserName())) {
                onTurn = p2;
            } else {
                JOptionPane.showMessageDialog(null, "Illegal onturn load file!");
            }

            String turns = br.readLine();
            turn = Integer.parseInt(turns);

            MainFrame.controller = new GameController(p1, p2);
            MainFrame.controller.setOnTurn(onTurn);
            MainFrame.controller.setTurn(turn);
            GamePanel.isFirstStep = false;
            MainFrame mainFrame = new MainFrame();

            //读取雷区尺寸
            int rowNum = MainFrame.gameMode.getXcount();
            int colNum = MainFrame.gameMode.getYcount();

            //读取雷区底层，也即数字状态（附近有多少雷）
            for (int i = 0; i < rowNum; i++) {
                String grid = br.readLine();
                String[] str = grid.split(" ");
                for (int j = 0; j < colNum; j++) {
                    GamePanel.mineField[i][j].setContent(Integer.parseInt(str[j]));
                }
            }

            //读取雷区表层，也即开格子的状态
//            grid = br.readLine();
//            str = grid.split(" ");
            for (int i = 0; i < rowNum; i++) {
                String grid = br.readLine();
                String[] str = grid.split(" ");
                for (int j = 0; j < colNum; j++) {
                    switch (str[j]) {
                        case "C":
                            GamePanel.mineField[i][j].status = GridStatus.Covered;
                            break;
                        case "F":
                            GamePanel.mineField[i][j].status = GridStatus.Flag;
                            break;
                        case "U":
                            GamePanel.mineField[i][j].status = GridStatus.Clicked;
                            break;
                        case "M":
                            GamePanel.mineField[i][j].status = GridStatus.Mine;
                            break;
                        case "Cheat":
                            GamePanel.mineField[i][j].status = GridStatus.cheat;
                            break;
                    }
                    GamePanel.mineField[i][j].repaint();
                }
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "All Illegal file!");
        }
    }
}

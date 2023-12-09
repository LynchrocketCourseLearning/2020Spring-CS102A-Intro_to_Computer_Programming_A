package components;

import LAN.Client;
import controller.CountTimer;
import entity.GridStatus;
import entity.Player;
import minesweeper.GamePanel;
import minesweeper.MainFrame;

import javax.swing.*;
import java.awt.*;

public class GridComponent extends BasicComponent {
    public static int gridSize = 30;
    private int row;
    private int col;
    public  GridStatus status = GridStatus.Covered;
    private int content = 0;
    public static int shownMine=0;

    public GridComponent(int x, int y) {
        this.setSize(gridSize, gridSize);
        this.row = x;
        this.col = y;
    }

    //方法命变动，之前是draw
    public  void show(GridComponent[][] a, int x, int y){
        if (a[x][y].status == GridStatus.Covered|a[x][y].status == GridStatus.cheat){
            a[x][y].status = GridStatus.Clicked;
            if(a[x][y].content==0) {
                if (x - 1 >= 0 && y - 1 >= 0 && a[x - 1][y - 1].content !=-1 ) show(a, x - 1, y - 1);//左上
                if (x - 1 >= 0 &&  a[x - 1][y].content != -1) show(a, x - 1, y);              //上
                if (x - 1 > 0 && y + 1 < a[x].length  && a[x - 1][y+1].content != -1) show(a, x - 1, y + 1);  //右上
                if (y - 1 >= 0 &&  a[x][y - 1].content != -1) show(a, x, y - 1);          //左
                if (y + 1 <a[x].length  && a[x][y+1].content != -1) show(a, x, y + 1);  //右
                if (x + 1 < a.length && y - 1 > 0 && a[x][y - 1].content != -1) show(a, x + 1, y - 1);   //左下
                if (x + 1 < a.length  && a[x+1][y].content != -1) show(a, x + 1, y);//下
                if (x + 1 < a.length && y + 1 < a[x].length  && a[x][y].content != -1) show(a, x + 1, y + 1);//右下
            }
            a[x][y].repaint();
        }
    }
    public  String getChessBroad (int i){
        String toReturn = "";
        for (int j =0;j<GamePanel.mineField[i].length;j++){
            toReturn+=GamePanel.mineField[i][j].getContent()+" ";
        }
        return toReturn;
    }

    @Override
    public void onMouseLeftClicked() {
        System.out.printf("Gird (%d,%d) is left-clicked.\n", row, col);
        if (GamePanel.isFirstStep){
            CountTimer.timer.start();
            GamePanel.isFirstStep=false;
            GamePanel.realInitialGame(GamePanel.xCount,GamePanel.yCount,GamePanel.mineCount,row,col);
            if (MainFrame.OnLAN){
                for (int i=0;i<GamePanel.mineField.length;i++){
                    Client.SendBroadCast(getChessBroad(i),"10.17.76.216");
                }
            }
        }
        //if语句执行踩雷后当前轮次的玩家减分并展示雷
        if ((status==GridStatus.Covered|status == GridStatus.cheat)&&content==-1){
            //如果是炸弹，则转化格子状态为炸弹状态（格子点开的前提下）
            status=GridStatus.Mine;
            shownMine+=1;
            Player player=MainFrame.controller.getOnTurnPlayer();
            MainFrame.controller.getOnTurnPlayer().setScore(player.getScore()-1);
            repaint();
            System.out.println("Player stepped on a Mine.Score -1");
        }
        //未踩雷，则执行点开格子的代码
        else if (status==GridStatus.Covered|status == GridStatus.cheat){
            show(GamePanel.mineField,row,col);
            System.out.println("Player stepped on a normal grid");
        }
        MainFrame.controller.getScoreBoard().update();
        MainFrame.controller.getOnTurnPlayer().setHasMoved(true);//表示当前轮次的玩家已经进行过操作
        MainFrame.controller.judge();
    }

    //TODO: 在左键点击一个格子的时候，还需要做什么-----判断是否雷，进行分数变化，并执行点开格子的代码，已写。

    @Override
    public void onMouseRightClicked() {
        //未点击转换成点击的状态
        System.out.printf("Gird (%d,%d) is right-clicked.\n", row, col);
        //if语句判断插旗位置是雷，显示旗帜并对玩家加分；
        if ((status==GridStatus.Covered|status == GridStatus.cheat)&&content==-1) {
            shownMine+=1;
            Player player=MainFrame.controller.getOnTurnPlayer();
            player.setScore(player.getScore()+1);
            this.status = GridStatus.Flag;
            repaint();
            System.out.println("Player swept a mine successfully.Score +1");
        }
        //else语句执行插旗位置不是雷，则记一次失误分,并执行点开格子的代码
        else if (status == GridStatus.Covered|status == GridStatus.cheat){
            Player player=MainFrame.controller.getOnTurnPlayer();
            player.setMistake(player.getMistake()+1);
            show(GamePanel.mineField,row,col);
            System.out.println("Player took a normal grid as a mine. Mistake +1");
        }
        MainFrame.controller.getScoreBoard().update();
        MainFrame.controller.getOnTurnPlayer().setHasMoved(true);//表示当前轮次的玩家已经进行过操作
        MainFrame.controller.judge();
        //TODO: 在右键点击一个格子的时候，还需要做什么？---判断是否雷，进行分数变化，已写。
        if (MainFrame.OnLAN){
            for (int i=0;i<GamePanel.mineField.length;i++){
                Client.SendBroadCast(getChessBroad(i),"10.17.76.216");
            }
        }
    }

    //TODO:张秦博改动 在draw方法中加入 格子状态对应的图片，并添加炸弹状态！！！！！（已添加状态，需要添加状态对应的图片）
    //todo:二次改动，添加了透视的格子状态 与炸弹显示相似，但是属于未点击的状态；
    public void draw(Graphics g) {
        //添加透视状态
        if (this.status==GridStatus.cheat){
            ImageIcon icon = new ImageIcon("src\\asserts\\Grid\\cheat.jpg");
            g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        }
        //添加的炸弹状态
        if (this.status==GridStatus.Mine){
            ImageIcon icon = new ImageIcon("src\\asserts\\Grid\\TNT.jpg");
            g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        }

        //草方块
        if (this.status == GridStatus.Covered) {
            ImageIcon icon = new ImageIcon("src\\asserts\\Grid\\cao.jpg");
            g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        }

        //土方块
        if (this.status == GridStatus.Clicked) {
            ImageIcon icon = new ImageIcon("src\\asserts\\Grid\\tu.jpg");
            g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
            g.setColor(Color.WHITE);
            if(content!=0){
                g.drawString(Integer.toString(content), getWidth() / 2 - 5, getHeight() / 2 + 5);
            }
       }

        //稿子
        if (this.status == GridStatus.Flag) {
            ImageIcon icon = new ImageIcon("src\\asserts\\Grid\\flag.jpg");
            g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.printComponents(g);
        draw(g);
    }

    public void setContent(int content) {
        this.content = content;
    }

    public int getContent() {
        return content;
    }
}

package minesweeper;

import components.GridComponent;
import entity.GridStatus;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {
    public static GridComponent[][] mineField;
    public static int[][] chessboard;
    private static final Random random = new Random();
    private static boolean isCheat=false;
    public static boolean isFirstStep=true;
    public static int xCount;
    public static int yCount;
    public static int mineCount;

    /**
     * 初始化一个具有指定行列数格子、并埋放了指定雷数的雷区。
     *
     * @param xCount    count of grid in column
     * @param yCount    count of grid in row
     * @param mineCount mine count
     */
    //todo:张秦博改动，游戏开始时只会生成一堆按钮，再按下第一个按钮后才生成雷区
    public GamePanel(int xCount, int yCount, int mineCount,boolean ischeat) {
        this.xCount=xCount;
        this.yCount=yCount;
        this.mineCount=mineCount;
        this.setVisible(true);
        this.setFocusable(true);
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setSize(GridComponent.gridSize * yCount, GridComponent.gridSize * xCount);
        isCheat=ischeat;
        fakeInitialGame(xCount, yCount);
        repaint();
    }


    //todo：张秦博改动，在初始化游戏时针对开发者模式进行雷透视
    public static void realInitialGame(int xCount, int yCount, int mineCount,int row,int col) {
        generateChessBoard(xCount, yCount, mineCount,row,col);
        for (int i = 0; i < xCount; i++) {
            for (int j = 0; j < yCount; j++) {
                mineField[i][j].setContent(chessboard[i][j]);
                if (isCheat&chessboard[i][j]==-1){
                    mineField[i][j].status= GridStatus.cheat;
                }
                mineField[i][j].repaint();
            }
        }
    }

    public void fakeInitialGame(int xCount,int yCount){
        mineField = new GridComponent[xCount][yCount];
        for (int i = 0; i < xCount; i++) {
            for (int j = 0; j < yCount; j++) {
                GridComponent gridComponent = new GridComponent(i, j);
                gridComponent.setLocation(j * GridComponent.gridSize, i * GridComponent.gridSize);
                mineField[i][j] = gridComponent;
                this.add(mineField[i][j]);
            }
        }
    }

    //生成雷区
    public static void setMine(int xCount, int yCount, int mineCount,int row,int col) {
        int i = 0;
        //通过循环的方式来生成雷
        do {
            //获得一个随机的行坐标
            int x = random.nextInt(xCount);
            //获得一个随机的列坐标
            int y = random.nextInt(yCount);
            //判断当前随机位置的格子内容是否是雷,如果不是就布雷
            if (chessboard[x][y] != -1&&!(x==row&&y==col)) {
                //获得当前坐标位置的格子对象
                chessboard[x][y] = -1;
                i++;
            }
        } while (i < mineCount);
    }

    //检查是否生成密集雷区
    public static boolean checkMine(int xCount, int yCount) {
        boolean toReturn = false;
        int n = xCount, m = yCount;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int judge = 0;
                if (chessboard[i][j] == -1) {
                    if (i - 1 >= 0) {
                        if (chessboard[i - 1][j] == -1) {
                            judge += 1;
                        }
                    }
                    if (j - 1 >= 0) {
                        if (chessboard[i][j - 1] == -1) {
                            judge += 1;
                        }
                    }
                    if (i + 1 < n) {
                        if (chessboard[i + 1][j] == -1) {
                            judge += 1;
                        }
                    }
                    if (j + 1 < m) {
                        if (chessboard[i][j + 1] == -1) {
                            judge += 1;
                        }
                    }
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        if (chessboard[i - 1][j - 1] == -1) {
                            judge += 1;
                        }
                    }
                    if (i - 1 >= 0 && j + 1 < m) {
                        if (chessboard[i - 1][j + 1] == -1) {
                            judge += 1;
                        }
                    }
                    if (i + 1 < n && j - 1 >= 0) {
                        if (chessboard[i + 1][j - 1] == -1) {
                            judge += 1;
                        }
                    }
                    if (i + 1 < n && j + 1 < m) {
                        if (chessboard[i + 1][j + 1] == -1) {
                            judge += 1;
                        }
                    }
                }
                if (judge == 8) {
                    toReturn = true;
                    break;
                }
            }
        }
        return toReturn;
    }

    //生成每一格子对应的数字
    public static void generateNumber(int xCount, int yCount) {
        int n = xCount, m = yCount;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int judge = 0;
                if (chessboard[i][j] == 0) {
                    if (i - 1 >= 0) {
                        if (chessboard[i - 1][j] == -1) {
                            judge += 1;
                        }
                    }
                    if (j - 1 >= 0) {
                        if (chessboard[i][j - 1] == -1) {
                            judge += 1;
                        }
                    }
                    if (i + 1 < n) {
                        if (chessboard[i + 1][j] == -1) {
                            judge += 1;
                        }
                    }
                    if (j + 1 < m) {
                        if (chessboard[i][j + 1] == -1) {
                            judge += 1;
                        }
                    }
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        if (chessboard[i - 1][j - 1] == -1) {
                            judge += 1;
                        }
                    }
                    if (i - 1 >= 0 && j + 1 < m) {
                        if (chessboard[i - 1][j + 1] == -1) {
                            judge += 1;
                        }
                    }
                    if (i + 1 < n && j - 1 >= 0) {
                        if (chessboard[i + 1][j - 1] == -1) {
                            judge += 1;
                        }
                    }
                    if (i + 1 < n && j + 1 < m) {
                        if (chessboard[i + 1][j + 1] == -1) {
                            judge += 1;
                        }
                    }
                    chessboard[i][j] = judge;
                }
            }
        }
    }


    public static void generateChessBoard(int xCount, int yCount, int mineCount,int row,int col) {
        //todo: generate chessboard by your own algorithm
        chessboard = new int[xCount][yCount];
        do {
            setMine(xCount, yCount, mineCount,row,col);
        } while (checkMine(xCount, yCount));
        generateNumber(xCount, yCount);
    }

    /**
     * 获取一个指定坐标的格子。
     * 注意请不要给一个棋盘之外的坐标哦~
     *
     * @param x 第x列
     * @param y 第y行
     * @return 该坐标的格子
     */
    public static GridComponent getGrid(int x, int y) {
        try {
            return mineField[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}

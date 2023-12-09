package entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//todo：张秦博改动，增加了一个表示玩家是否进行行动的变量 @hasMoved
public class Player {
    private static Random ran = new Random();//生成用户名

    public boolean isHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    private boolean hasMoved = true;//检测玩家是否行动
    private String userName;
    private Role role;
    private int score = 0;//分数
    private int mistake = 0;//错误次数
    //游戏胜负判断

    /**
     * 通过特定名字初始化一个玩家对象。
     *
     * @param userName 玩家的名字
     */
    public Player(String userName, Role role) {
        this.userName = userName;
        this.role = role;
    }//文本框玩家输入名字

    /**
     * 通过默认名字初始化一个玩家对象。
     */
    public Player() {
        this.userName = "User#" + (ran.nextInt(9000) + 1000);
        this.role = Role.CocoGoat;
    }//无输名，提供随机按钮生成名字

    public Player(String userName, Role role, int score, int mistake) {
        this.userName = userName;
        this.role = role;
        this.score = score;
        this.mistake = mistake;
    }//用于读档

    /**
     * 为玩家加一分。
     */
    public void addScore() {
        score++;
    }

    /**
     * 为玩家扣一分。
     */
    public void costScore() {
        score--;
    }

    /**
     * 为玩家增加一次失误数。
     */
    public void addMistake() {
        mistake++;
    }


    public int getScore() {
        return score;
    }

    public String getUserName() {
        return userName;
    }

    public int getMistake() {
        return mistake;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setMistake(int mistake) {
        this.mistake = mistake;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

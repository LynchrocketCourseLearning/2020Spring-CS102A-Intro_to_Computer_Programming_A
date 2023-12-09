package LAN;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    //发送广播 str是坐标tostring ipstr是ip地址
    public static void SendBroadCast(String str, String ipStr) {
        try {
            InetAddress ip;
            if (ipStr == null) {
                ip = InetAddress.getByName("255.255.255.255");
            } else {
                ip = InetAddress.getByName(ipStr);
            }
            DatagramSocket ds = new DatagramSocket();
            DatagramPacket dp = new DatagramPacket(str.getBytes(), str.getBytes().length, ip, 6666);
            ds.send(dp);
            ds.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Can't send broadcast!");
        }// 创建用来发送数据报包的套接字
    }
}

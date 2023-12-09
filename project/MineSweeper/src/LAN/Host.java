package LAN;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
//接收广播
public class Host {
    public static String ReceiveBroadCast() {
        String rec = null;
        try {
            DatagramSocket socket = new DatagramSocket(8888);// 创建接收数据报套接字并将其绑定到本地主机上的指定端口
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            socket.receive(dp);//阻塞式接受包裹
            rec = new String(buf);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rec;
    }
}

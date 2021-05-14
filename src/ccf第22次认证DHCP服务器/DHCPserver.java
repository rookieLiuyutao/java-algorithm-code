package ccf第22次认证DHCP服务器;

import java.util.Scanner;

/**
 * @see 模拟题 https://www.acwing.com/problem/content/description/3416/
 */
public class DHCPserver {
//-------------------------------------------------------------------------------
    /**
     * 为了 DHCP 服务器能够正确分配 IP 地址，DHCP 需要接受如下配置：
     * 地址池大小 N：表示能够分配给客户端的 IP 地址的数目，且能分配的 IP 地址是 1,2,…,N；
     * 默认过期时间 Tdef：表示分配给客户端的 IP 地址的默认的过期时间长度；
     * 过期时间的上限和下限 Tmax、Tmin：表示分配给客户端的 IP 地址的最长过期时间长度和最短过期时间长度，客户端不能请求比这个更长或更短的过期时间；
     * 本机名称 H：表示运行 DHCP 服务器的主机名。
     */
    static int N = 10010;
    static int addressPoolSize, defaultExpirationTime, tMax, tMin, msgNum;
    static String localName;
//-------------------------------------------------------------------------

    /**
     * 在 DHCP 启动时，首先初始化 IP 地址池，将所有地址设置状态为未分配，占用者为空，并清零过期时刻。其中地址的状态有未分配、待分配、占用、过期四种。
     * 处于未分配状态的 IP 地址没有占用者，而其余三种状态的 IP 地址均有一名占用者。
     */
    class IP {
        //address值可取以下4种：0.未分配、1.待分配、2.占用、3.过期
        int addressState;
        //
        int expireTime;

        String owner;
    }

    static IP[] ips = new IP[N];

    static void updateIpsState(int receivedTime) {
        for (int i = 1; i <= msgNum; i++) {
            if (ips[i].expireTime != 0 && ips[i].expireTime <= receivedTime) {
                if (ips[i].addressState == 1) {
                    ips[i].addressState = 0;
                    ips[i].owner = "";
                    ips[i].expireTime = 0;
                } else {
                    ips[i].addressState = 3;
                    ips[i].expireTime = 0;
                }

            }else {
                ips[i].expireTime = 0;
            }
        }

    }


    static void getIpByState(int state) {


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//------------处理输入---------------
        addressPoolSize = sc.nextInt();
        defaultExpirationTime = sc.nextInt();
        tMax = sc.nextInt();
        tMin = sc.nextInt();
        localName = sc.nextLine();
        msgNum = sc.nextInt();
        while (msgNum-- != 0) {
            int receivedTime;
            String sendingHost, receivingHost, messageType;
            int ipAddress, expirationTime;
            receivedTime = sc.nextInt();
            sendingHost = sc.next();
            receivingHost = sc.next();
            messageType = sc.next();
            ipAddress = sc.nextInt();
            expirationTime = sc.nextInt();
//------------------------------------------------------
            if (!receivingHost.equals(localName) && !"*".equals(receivingHost)) {
                if (!"REQ".equals(messageType)) continue;

            }
            if (!("REQ".equals(messageType) || "DIS".equals(messageType))) continue;

            if (("*".equals(receivingHost) && !"DIS".equals(messageType)) || (localName.equals(receivingHost) && "DIS".equals(messageType)))
                continue;

            updateIpsState(receivedTime);
            if ("DIS".equals(messageType)){
//                if ()


            }


        }

    }

}

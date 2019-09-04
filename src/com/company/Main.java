package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
            //System.out.println("设置红包总金额：");
            double amount = sc.nextDouble();  //红包金额
            //System.out.println("设置红包个数：");
            int count = sc.nextInt();  //红包个数
            //System.out.println("抢红包人数：");
            int userAmount = sc.nextInt();  //抢红包人数


        RedEnvelope redEnvelope = new RedEnvelope(amount,count);
        UserThread userThread = new UserThread(redEnvelope);

        for (int i=0;i<userAmount;i++){  //模拟抢红包线程
            new Thread(userThread).start();

        }
    }
}

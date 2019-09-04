package com.company;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 红包类
 */
public class RedEnvelope {

    private double amount;
    private int remainAmount;
    private int count;  //红包个数
    private List<Double> valList;  //存储小红包金额的集合，用户按顺序读取

    public RedEnvelope(double amount, int count) {

        this.remainAmount = (int)amount*100;  //保证单个红包金额有两位小数点
        this.count = count;
        this.valList = new ArrayList<Double>();

        //拼手气红包
        for (int i=count;i>0;i--){
            int eachVal = 0;

            if (i != 0 && remainAmount/i == 1){  //当红包还没分完但是剩下的金额只够每个人分0.01元时
                eachVal = 1;
                remainAmount = remainAmount - eachVal;
                valList.add(eachVal/100.0);

            }

            if (i <= 0){  //如果已经抢完
                System.out.println("这里已经抢完了");
                eachVal = 0;
            }else if (i == 1){  //如果剩下最后一个人
                eachVal = remainAmount;  //剩余的红包金额都发给他
                System.out.println("这里只剩下一个人了");
            }else {

                int halfRemainCount = (int) Math.floor(count / 2);
                int temp;  //剩余金额

               while (true) {
                   eachVal = new Random().nextInt(remainAmount / halfRemainCount);  //生成单个小红包金额
                   temp = remainAmount - eachVal;
                   if (eachVal > 0 && temp*1.0/(i - 1) >= 1) {  //如果生成的小红包金额大于0并且之后每个人都可以分到0.01元以上
                       System.out.println("这里继续生成小红包");
                       break;
                   }
               }
               remainAmount = remainAmount - eachVal;  //减去生成的小红包金额

            }
            valList.add(eachVal/100.0);
        }

    }


    public synchronized double getMoney(){
        double money = 0;
        double sum = 0;
        int size = valList.size();
        for (int i=0;i<size;i++){
            sum += valList.get(i);
        }
        System.out.println("sum=====" + sum);
        System.out.println("size=====" + size);
        System.out.println("count=====" + count);

        if (count > 0){
            money = valList.get(count-1)/1.0;
        }
        count--;
        return money;
    }

}

package com.company;

public class UserThread implements Runnable{
    private RedEnvelope redEnvelope;
    public UserThread(RedEnvelope redEnvelope){
        this.redEnvelope = redEnvelope;
    }

    @Override
    public void run() {
        double money = redEnvelope.getMoney();

        if (money == 0){  //如果从红包生成方法拿到的小红包金额为0，则证明红包已经被抢完了
            System.out.println(Thread.currentThread().getName() + "红包已经被抢完了~");
        }else {
            System.out.println(Thread.currentThread().getName() + "抢到了" + money + "元红包！");
        }
    }

}

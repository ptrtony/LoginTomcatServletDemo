package cn.itcat.day04.demo01;

import java.util.ArrayList;

public class Manager extends User{
    public Manager(int money, String name) {
        super(money, name);
    }

    public ArrayList<Integer> send(int totalMoney,int count){
        ArrayList<Integer> moneyList = new ArrayList<>();
        int hasSendMoney = super.getMoney();
        if (hasSendMoney<totalMoney){
            System.out.println("余额不足");
            return moneyList;
        }

        //用户余额
        int delta = super.getMoney() - totalMoney;
        super.setMoney(delta);
        int avg = totalMoney / count;
        int mod = totalMoney % count;
        for (int i = 0; i < count - 1; i++) {
            moneyList.add(avg);
        }
        moneyList.add(avg + mod);
        return moneyList;
    }

}

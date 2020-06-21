package cn.itcat.day04.demo01;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User{
    public Member(int money, String name) {
        super(money, name);
    }

    public void receive(ArrayList<Integer> moneyList){
        int index = new Random().nextInt(moneyList.size());
        int money = moneyList.get(index);
        moneyList.remove(index);
        super.setMoney(super.getMoney() + money);
    }
}

package cn.itcat.day04.demo01;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        Manager manager = new Manager(100,"群主");
        Member one = new Member(200,"普通员工");
        Member two = new Member(300,"普通员工");
        Member three = new Member(200,"普通员工");
        manager.show();
        one.show();
        two.show();
        three.show();
        System.out.println("==============");
        ArrayList<Integer> sendMoney = manager.send(20, 3);
        one.receive(sendMoney);
        two.receive(sendMoney);
        three.receive(sendMoney);
        manager.show();
        one.show();
        two.show();
        three.show();
    }
}

package cn.itcat.day04.demo01;

public class User {
    private int money;
    private String name;
    public User(){

    }

    public void show(){
        System.out.println("我叫："+name+"我有："+money);
    }
    public User(int money, String name) {
        this.money = money;
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

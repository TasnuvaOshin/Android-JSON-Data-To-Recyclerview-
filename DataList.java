package net.skillbooster.normaljsontest;

public class DataList {
    String age;
    String color;
    String owner;
    String partner;
    String name;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataList(String age, String color, String owner, String partner, String name) {
        this.age = age;
        this.color = color;
        this.owner = owner;
        this.partner = partner;
        this.name = name;
    }

    public DataList() {
    }
}

package com.example.casestudy.model;

public class Pet {
    private int id;
    private String name;
    private String age;
    private int price;
    private PetSpecial special;
    private String image;
    private String status = "Còn hàng";

    public Pet() {
    }

    public Pet(String name, String age, int price, PetSpecial special, String image) {
        this.name = name;
        this.age = age;
        this.price = price;
        this.special = special;
        this.image = image;
    }

    public Pet(int id, String name, String age, int price, PetSpecial special, String image, String status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.price = price;
        this.special = special;
        this.image = image;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public PetSpecial getspecial() {
        return special;
    }

    public void setspecial(PetSpecial special) {
        this.special = special;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", price=" + price +
                ", special='" + special + '\'' +
                ", image='" + image + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

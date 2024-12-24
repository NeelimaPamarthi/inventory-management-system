package model;

public class Product{
    private int id;
    private String name;
    private int quantity;
    private double price;

    public Product(int id, String name, int quantity, double price){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getQuantity(){
        return quantity;
    }

    public double getPrice(){
        return price;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setPrice(double price){
        this.price = price;
    }

    @Override
    public String toString(){
        return String.format("ID: %d, Name: %s, Quantity: %d, Price: %.2f", id, name, quantity, price);
    }

    public static Product fromString(String data){
        String[] fileds = data.split(",");
        return new Product(Integer.parseInt(fileds[0]), fileds[1], Integer.parseInt(fileds[2]), Double.parseDouble(fileds[3]));
    }

}
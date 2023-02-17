package lesson21.pattern.template.method;

public class NetOrder extends OrderProcessTemplate {
    @Override
    public void selectGoods() {
        System.out.println("Item added to online shopping cart");
        System.out.println("Get gift wrap preference");
        System.out.println("Get delivery address.");
    }

    @Override
    public void payment() {
        System.out.println("Online Payment through Netbanking, card or Paytm");
    }

    @Override
    public void delivery() {
        System.out.println("Ship the item through post to delivery address");
    }

}
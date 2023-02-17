package lesson21.pattern.template.method;

abstract class OrderProcessTemplate {
    private boolean isGift;

    public final void processOrder(boolean isGift) {
        selectGoods();
        payment();
        if (isGift) {
            giftWrap();
        }
        delivery();
    }

    protected abstract void selectGoods();

    protected abstract void payment();

    protected abstract void delivery();

    private void giftWrap() {
        try {
            System.out.println("Gift wrap successful");
        } catch (Exception e) {
            System.out.println("Gift wrap unsuccessful");
        }
    }

    public boolean isGift() {
        return isGift;
    }

    public void setGift(boolean isGift) {
        this.isGift = isGift;
    }
}
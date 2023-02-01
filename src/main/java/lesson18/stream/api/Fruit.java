package lesson18.stream.api;

import java.time.LocalDate;
import java.util.List;

/**
 * @author spasko
 */
public class Fruit {
    private FruitType fruitType;
    private int dayToLive;
    private LocalDate deliveryDate;
    private int price;
    private List<Vitamin> vitamin;

    public Fruit(FruitType fruitType, int dayToLive, LocalDate deliveryDate, int price, List<Vitamin> vitamin) {
        this.fruitType = fruitType;
        this.dayToLive = dayToLive;
        this.deliveryDate = deliveryDate;
        this.price = price;
        this.vitamin = vitamin;
    }

    public FruitType getFruitType() {
        return fruitType;
    }

    public void setFruitType(FruitType fruitType) {
        this.fruitType = fruitType;
    }

    public int getDayToLive() {
        return dayToLive;
    }

    public void setDayToLive(int dayToLive) {
        this.dayToLive = dayToLive;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Vitamin> getVitamins() {
        return vitamin;
    }

    public void setVitamins(List<Vitamin> vitamin) {
        this.vitamin = vitamin;
    }

    @Override
    public String toString() {
        return "Fruit [fruitType=" + fruitType + ", dayToLive=" + dayToLive + ", deliveryDate=" + deliveryDate
                + ", price=" + price + ", vitamins=" + vitamin + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + dayToLive;
        result = prime * result + ((deliveryDate == null) ? 0 : deliveryDate.hashCode());
        result = prime * result + ((fruitType == null) ? 0 : fruitType.hashCode());
        result = prime * result + price;
        result = prime * result + ((vitamin == null) ? 0 : vitamin.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Fruit other = (Fruit) obj;
        if (dayToLive != other.dayToLive)
            return false;
        if (deliveryDate == null) {
            if (other.deliveryDate != null)
                return false;
        } else if (!deliveryDate.equals(other.deliveryDate))
            return false;
        if (fruitType != other.fruitType)
            return false;
        if (price != other.price)
            return false;
        if (vitamin == null) {
            if (other.vitamin != null)
                return false;
        } else if (!vitamin.equals(other.vitamin))
            return false;
        return true;
    }

}

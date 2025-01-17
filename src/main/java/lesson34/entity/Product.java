package lesson34.entity;
// Generated 13 Mar 2023, 17:53:22 by Hibernate Tools 4.3.5.Final

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Products generated by hbm2java
 */
@Entity
@Table(name = "products", catalog = "classicmodels")
public class Product {

    private String productCode;
    private Productline productline;
    private String productName;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private short quantityInStock;
    private BigDecimal buyPrice;
    private BigDecimal msrp;
    private Set<Order> orders = new HashSet<>(0);

    public Product() {
    }

    public Product(String productCode, Productline productline, String productName, String productScale,
            String productVendor, String productDescription, short quantityInStock, BigDecimal buyPrice,
            BigDecimal msrp) {
        this.productCode = productCode;
        this.productline = productline;
        this.productName = productName;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.productDescription = productDescription;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
        this.msrp = msrp;
    }

    public Product(String productCode, Productline productline, String productName, String productScale,
            String productVendor, String productDescription, short quantityInStock, BigDecimal buyPrice,
            BigDecimal msrp, Set<Order> orders) {
        this.productCode = productCode;
        this.productline = productline;
        this.productName = productName;
        this.productScale = productScale;
        this.productVendor = productVendor;
        this.productDescription = productDescription;
        this.quantityInStock = quantityInStock;
        this.buyPrice = buyPrice;
        this.msrp = msrp;
        this.orders = orders;
    }

    @Id

    @Column(name = "productCode", unique = true, nullable = false, length = 15)
    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productLine", nullable = false)
    public Productline getProductline() {
        return this.productline;
    }

    public void setProductline(Productline productline) {
        this.productline = productline;
    }

    @Column(name = "productName", nullable = false, length = 70)
    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column(name = "productScale", nullable = false, length = 10)
    public String getProductScale() {
        return this.productScale;
    }

    public void setProductScale(String productScale) {
        this.productScale = productScale;
    }

    @Column(name = "productVendor", nullable = false, length = 50)
    public String getProductVendor() {
        return this.productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    @Column(name = "productDescription", nullable = false, length = 65535)
    public String getProductDescription() {
        return this.productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Column(name = "quantityInStock", nullable = false)
    public short getQuantityInStock() {
        return this.quantityInStock;
    }

    public void setQuantityInStock(short quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Column(name = "buyPrice", nullable = false, precision = 10)
    public BigDecimal getBuyPrice() {
        return this.buyPrice;
    }

    public void setBuyPrice(BigDecimal buyPrice) {
        this.buyPrice = buyPrice;
    }

    @Column(name = "MSRP", nullable = false, precision = 10)
    public BigDecimal getMsrp() {
        return this.msrp;
    }

    public void setMsrp(BigDecimal msrp) {
        this.msrp = msrp;
    }

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
    public Set<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

}

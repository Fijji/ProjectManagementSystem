package net.jdbc.pms.model;

import javax.persistence.*;
/**
 * @author Kyryl Potapenko
 */
@Entity
@Table(name = "Customers")
public class Customers implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customer_id;
    @Column(name = "customer_name")
    private String customer_name;

    public Customers(int customer_id, String customer_name) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
    }

    public Customers() {

    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customer_id=" + customer_id +
                ", customer_name='" + customer_name + '\'' +
                '}';
    }
}

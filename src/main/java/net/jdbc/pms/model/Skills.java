package net.jdbc.pms.model;

import javax.persistence.*;
/**
 * @author Kyryl Potapenko
 */
@Entity
@Table(name = "Skills")
public class Skills implements Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sk_id")
    private int sk_id;
    @Column(name = "sk_name")
    private String sk_name;

    public Skills(int sk_id, String sk_name) {
        this.sk_id = sk_id;
        this.sk_name = sk_name;
    }

    public Skills() {

    }

    public int getSk_id() {
        return sk_id;
    }

    public void setSk_id(int sk_id) {
        this.sk_id = sk_id;
    }

    public String getSk_name() {
        return sk_name;
    }

    public void setSk_name(String sk_name) {
        this.sk_name = sk_name;
    }

    @Override
    public String toString() {
        return "Skills{" +
                "sk_id=" + sk_id +
                ", sk_name='" + sk_name + '\'' +
                '}';
    }
}

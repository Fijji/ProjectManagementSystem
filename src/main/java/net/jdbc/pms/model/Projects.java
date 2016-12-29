package net.jdbc.pms.model;

import javax.persistence.*;
/**
 * @author Kyryl Potapenko
 */
@Entity
@Table(name = "Projects")
public class Projects implements Model{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "pj_id")
    private int pj_id;
    @Column(name = "pj_name")
    private String pj_name;
    @Column(name = "pj_desc")
    private String pj_desc;
    @Column(name = "pj_cost")
    private int pj_cost;

    public Projects(int pj_id, String pj_name, String pj_desc, int pj_cost) {
        this.pj_id = pj_id;
        this.pj_name = pj_name;
        this.pj_desc = pj_desc;
        this.pj_cost = pj_cost;
    }
    public Projects(){

    }

    public int getPj_id() {
        return pj_id;
    }

    public void setPj_id(int pj_id) {
        this.pj_id = pj_id;
    }

    public String getPj_name() {
        return pj_name;
    }

    public void setPj_name(String pj_name) {
        this.pj_name = pj_name;
    }

    public String getPj_desc() {
        return pj_desc;
    }

    public void setPj_desc(String pj_desc) {
        this.pj_desc = pj_desc;
    }

    public int getPj_cost() {
        return pj_cost;
    }

    public void setPj_cost(int pj_cost) {
        this.pj_cost = pj_cost;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "pj_id=" + pj_id +
                ", pj_name='" + pj_name + '\'' +
                ", pj_desc='" + pj_desc + '\'' +
                ", pj_cost=" + pj_cost +
                '}';
    }
}

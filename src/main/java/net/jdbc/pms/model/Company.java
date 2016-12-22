package net.jdbc.pms.model;

public class Company implements Model {
private int com_id;
private String com_name;

    public Company(int com_id, String com_name) {
        this.com_id = com_id;
        this.com_name = com_name;
    }
    public Company(){

    }

    public int getCom_id() {
        return com_id;
    }

    public void setCom_id(int com_id) {
        this.com_id = com_id;
    }

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "com_id=" + com_id +
                ", com_name='" + com_name + '\'' +
                '}';
    }
}

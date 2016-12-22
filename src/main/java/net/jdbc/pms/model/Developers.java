package net.jdbc.pms.model;

public class Developers implements Model {
private int dev_id;
private  String dev_name;
private int dev_salary;

    public Developers(int dev_id, String dev_name, int dev_salary) {
        this.dev_id = dev_id;
        this.dev_name = dev_name;
        this.dev_salary = dev_salary;
    }

    public Developers(){

    }

    public int getDev_id() {
        return dev_id;
    }

    public void setDev_id(int dev_id) {
        this.dev_id = dev_id;
    }

    public String getDev_name() {
        return dev_name;
    }

    public void setDev_name(String dev_name) {
        this.dev_name = dev_name;
    }

    public int getDev_salary() {
        return dev_salary;
    }

    public void setDev_salary(int dev_salary) {
        this.dev_salary = dev_salary;
    }

    @Override
    public String toString() {
        return "Developers{" +
                "dev_id=" + dev_id +
                ", dev_name='" + dev_name + '\'' +
                ", dev_salary=" + dev_salary +
                '}';
    }
}

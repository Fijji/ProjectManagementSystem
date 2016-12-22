package net.jdbc.pms.model;

public class Skills implements Model {

    private int sk_id;
    private String sk_name;

    public Skills(int sk_id, String sk_name) {
        this.sk_id = sk_id;
        this.sk_name = sk_name;
    }
    public Skills(){

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

package hra;

public abstract class Command {
    protected String prikaz;

    public void setPrikaz(String prikaz) {
        this.prikaz = prikaz;
    }

    public abstract String proved();

    public abstract boolean konec();


}
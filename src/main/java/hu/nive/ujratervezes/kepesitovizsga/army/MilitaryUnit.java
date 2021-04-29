package hu.nive.ujratervezes.kepesitovizsga.army;

public abstract class MilitaryUnit {
    private int hitPoints;
    private int damage;
    private final boolean armour;

    public MilitaryUnit(int hitPoints, int damage, boolean armour) {
        this.hitPoints = hitPoints;
        this.damage = damage;
        this.armour = armour;
    }

    public abstract int doDamage();

    public abstract int sufferDamage(int damage);

    public int getDamage() {
        return damage;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public boolean isArmour() {
        return armour;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

}

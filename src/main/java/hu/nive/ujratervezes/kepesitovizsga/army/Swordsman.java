package hu.nive.ujratervezes.kepesitovizsga.army;

public class Swordsman extends MilitaryUnit {
    private boolean firstDamage;

    public Swordsman(boolean armour) {
        super(100, 10, armour);
        firstDamage = true;
    }

    @Override
    public int doDamage() {
        return getDamage();
    }

    @Override
    public int sufferDamage(int damage) {
        if (firstDamage) {
            firstDamage = false;
        } else {
            if (isArmour()) {
                setHitPoints(getHitPoints() - (damage / 2));
            } else {
                setHitPoints(getHitPoints() - damage);
            }
        }
        return getHitPoints();
    }

}

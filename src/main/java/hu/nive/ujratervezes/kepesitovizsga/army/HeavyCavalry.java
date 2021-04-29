package hu.nive.ujratervezes.kepesitovizsga.army;

public class HeavyCavalry extends MilitaryUnit {
    private int counter;

    public HeavyCavalry() {
        super(150, 20, true);
        counter = 0;
    }

    @Override
    public int doDamage() {
        counter++;
        if (counter == 1) {
            return 3 * getDamage();
        } else {
            return getDamage();
        }
    }

    @Override
    public int sufferDamage(int damage) {
        setHitPoints(getHitPoints() - (damage / 2));
        return getHitPoints();
    }

}

package hu.nive.ujratervezes.kepesitovizsga.army;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Army {
    private final List<MilitaryUnit> units = new ArrayList<>();

    public int getArmySize() {
        return units.size();
    }

    public void addUnit(MilitaryUnit militaryUnit) {
        units.add(militaryUnit);
    }

    public int getArmyDamage() {
        int sumOfAbilityToDoDamage = 0;
        for (MilitaryUnit u : units) {
            sumOfAbilityToDoDamage += u.doDamage();
        }
        return sumOfAbilityToDoDamage;
    }

    public void damageAll(int damage) {
        for (Iterator<MilitaryUnit> it = units.iterator(); it.hasNext(); ) {
            MilitaryUnit u = it.next();
            u.sufferDamage(damage);
            if (u.getHitPoints() < 25) {
                it.remove();
            }
        }
    }

}

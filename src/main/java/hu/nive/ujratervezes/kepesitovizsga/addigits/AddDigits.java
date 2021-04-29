package hu.nive.ujratervezes.kepesitovizsga.addigits;

public class AddDigits {

    public int addDigits(String input){
        if(input == null || "".equals(input)){
            return -1;
        }
        int sum = 0;
        for(Character c : input.toCharArray()){
            if (Character.isDigit(c)){
                sum += Integer.parseInt(String.valueOf(c));
            }
        }
        return sum;
    }

}

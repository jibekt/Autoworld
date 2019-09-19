package be.vdab.util;

public enum Maat {
    /*CENTIMETER(1), DECIMETER(10), METER(100);

    private int factor;
    Maat (int factor){
        this.factor=factor;
    }

    public long getMaat() {
        return (long)factor*factor*factor;
    }*/

    CENTIMETER("cm3"), DECIMETER("dm3"), METER("m3");

    private String value;
    Maat (String value){
        this.value=value;
    }

    public String getValue() {
        return value;
    }
}

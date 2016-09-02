package ru.sbertech.tradehouse.domain;

/**
 * Created by anton on 8/29/16.
 */
public class HiTechProduct extends Product
{
    private Double power;

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }

    public String toString() {
        return getProductId() + ":" + getProductName() +":" + power;
//        return super.toString() +":" + power;
    }
}

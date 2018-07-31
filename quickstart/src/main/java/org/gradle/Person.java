package org.gradle;

import org.apache.commons.collections.list.GrowthList;

public class Person {
    private final String name;
    private final String lastName;
    private final int age;
    private final String eyeColor;
    private final String ci;
    private final String cellphone;
    private final String petName;
    private final String address;

    public Person(String name, String lastName, int age, String eyeColor, String ci, String cellphone, String petName, String address) {
        this.name = name;
        this.age = age;
        this.lastName = lastName;
        this.eyeColor = eyeColor;
        this.ci = ci;
        this.cellphone = cellphone;
        this.petName = petName;
        this.address = address;
        new GrowthList();
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getCi() {
        return ci;
    }

    public String getCellphone() {
        return cellphone;
    }

    public String getPetname() {
        return petName;
    }

    public String getCompleteName() {
        return name + " " + lastName;
    }

    public String getAddionalDataOfAperson() {
        return age + " " + eyeColor + " " + ci + " " + cellphone;
    }

    public String getAddress() {
        return address;
    }
}

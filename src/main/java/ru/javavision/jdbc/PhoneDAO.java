package ru.javavision.jdbc;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Map;

/**
 * Author : Pavel Ravvich.
 * Created : 03/11/2017.
 */
public interface PhoneDAO {

    int addModel(String mark);

    int getModelIdByName(String model);

    void addSale(Phone phone);

    BigInteger getRevenue(Timestamp from, Timestamp to);

    BigInteger getRevenue(String model, Timestamp from, Timestamp to);

    Map<String, BigInteger> getMarkSumLess(BigInteger sum, Timestamp from, Timestamp to);

    /**
     * Default method Java 8 only.
     */
    default void starter() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Не забудте устоновить плагин lombok для IDE.
     * IntelliJ IDEA -> Preferences -> Plugins ->  в поиске : lombok -> Install.
     * Анотация @Data добавляет геттеры и сеттеры ко всем полям.
     */
    @Data
    class Phone {

        private int id;

        private BigInteger prise;

        private Timestamp saleDate;

        private PhoneModel phoneModel;

        private int ownerId;
    }

    @Data
    class PhoneModel {

        private int id;

        private String name;
    }
}

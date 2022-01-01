package com.nadherarroum.proj_ds.repositories;

import com.nadherarroum.proj_ds.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    /*
    a) Tested in MySQL
    SELECT DISTINCT(it.description), (ord_d.qty*it.price) AS Prix_HT, ord_d.tax AS TAX,
    ROUND( ((ord_d.qty*it.price)+(ord_d.qty*it.price)* ord_d.tax),2) AS Total
    FROM orderdetail_entity as ord_d, item_entity as it
    WHERE ord_d.item_id = it.id;
     */
    @Query("SELECT DISTINCT(it.description)," +
            "(ord_d.qty*it.price) AS Prix_HT," +
            "ord_d.tax AS TAX," +
            "((ord_d.qty*it.price)+(ord_d.qty*it.price)* ord_d.tax) AS Total " +
            "FROM OrderDetail as ord_d, Item as it " +
            "WHERE ord_d.item = it.orderDetails ")
    void calculateTotal();

    /*
    b) Tested in MySQL
    SELECT SUM(ROUND( (it.weight * ord_d.qty), 2)) AS Poids_TOTAL
    FROM item_entity as it, orderdetail_entity ord_d
    WHERE it.id = ord_d.item_id;
     */
    @Query("SELECT SUM((it.weight * ord_d.qty)) AS Poids_TOTAL "+
            "FROM Item as it, OrderDetail ord_d " +
            "WHERE it.orderDetails = ord_d.item")
    void calculateWeight();

    /*
    e) Tested in MySQL
    SELECT c.name, c.contact, COUNT(c.id) AS Nbr_Order
    FROM order_entity ord, orderdetail_entity ord_d, customer_entity c
    WHERE ord.id = ord_d.order_id AND c.id = ord.customer_id
    GROUP BY c.name
    ORDER BY Nbr_Order DESC
    LIMIT 5;
     */
    @Query("SELECT c.name, c.contact, COUNT(c.id) AS Nbr_Order " +
          "FROM order_entity ord, orderdetail_entity ord_d, customer_entity c " +
          "WHERE ord.id = ord_d.order_id AND c.id = ord.customer_id" +
          "GROUP BY c.name ORDER BY Nbr_Order DESC LIMIT 5")
    void top5_nbrCommand();

    /*
    f) Tested in MySQL
    SELECT c.name, c.contact, SUM( it.price * ord_d.qty ) AS Nbr_depense
    FROM item_entity it, orderdetail_entity ord_d, customer_entity c, order_entity ord
    WHERE ord_d.order_id = ord.id AND c.id = ord.customer_id AND it.id = ord_d.item_id
    GROUP BY c.name ORDER BY Nbr_depense DESC LIMIT 5;
     */
    @Query("SELECT c.name, c.contact, SUM( it.price * ord_d.qty ) AS Nbr_depense " +
            "FROM Item it, OrderDetail ord_d, Customer c, Order ord " +
            "WHERE ord_d.order = ord.orderDetails " +
            "AND c.id = ord.customer AND it.id = ord_d.item " +
            "GROUP BY c.name ORDER BY Nbr_depense DESC LIMIT 5")
    void top5_montantDepose();

    /*
    g) Tested in MySQL
    SELECT c.name, c.contact, ROUND(SUM(it.weight * ord_d.qty),2) AS Poids_TOTAL
    FROM customer_entity c, item_entity it, orderdetail_entity ord_d, order_entity ord
    WHERE ord_d.order_id = ord.id AND ord.customer_id = c.id AND it.id = ord_d.item_id
    GROUP BY c.name
    ORDER BY Poids_TOTAL DESC;
     */
    @Query("SELECT c.name, c.contact, SUM(it.weight * ord_d.qty) AS Poids_TOTAL " +
            "FROM Customer c, Item it, OrderDetail ord_d, Order ord " +
            "WHERE ord_d.order = ord.orderDetails AND ord.customer = c.orders " +
            "AND it.orderDetails = ord_d.item " +
            "GROUP BY c.name ORDER BY Poids_TOTAL DESC")
    void order_sup_10Kg();
}

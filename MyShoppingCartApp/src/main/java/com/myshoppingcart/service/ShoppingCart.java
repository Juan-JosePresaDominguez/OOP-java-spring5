package com.myshoppingcart.service;

import com.myshoppingcart.exception.ProductNotFoundException;
import com.myshoppingcart.model.Compra;
import com.myshoppingcart.model.Producto;
import com.myshoppingcart.persistence.CompraDBRepository;
import com.myshoppingcart.persistence.ICompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Component
public class ShoppingCart {

    @Autowired
    private ArrayList<Producto> items;
    @Autowired
    private ICompraRepository repoCompras;

    public ShoppingCart() throws Exception {
        items = new ArrayList<>();
        repoCompras = new CompraDBRepository();
    }

    public double getBalance() {
        double balance = 0.00;
        for (Iterator i = items.iterator(); i.hasNext(); ) {
            Producto item = (Producto) i.next();
            balance += item.getPrecio();
        }
        return balance;
    }

    public void addItem(Producto item) {
        items.add(item);
    }

    public void removeItem(Producto item)
            throws ProductNotFoundException {
        if (!items.remove(item)) {
            throw new ProductNotFoundException();
        }
    }

    public int getItemCount() {
        return items.size();
    }

    public void empty() {
        items.clear();
    }

    public void comprar() {
        for (Producto item : items) {
            System.out.println("prod:" + item);
            try {
                Compra compra = new Compra(null, 1, item.getMid(), 1, LocalDate.now());
                repoCompras.insertCompra(compra);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

}
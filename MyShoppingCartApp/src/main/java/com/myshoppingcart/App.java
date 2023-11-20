package com.myshoppingcart;

import com.myshoppingcart.model.Producto;
import com.myshoppingcart.service.ShoppingCart;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "My shopping cart" );

        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/beans.xml");

        ShoppingCart servicioEstudiantes= context.getBean(ShoppingCart.class);

//        Producto unProducto = ShoppingCart.getBa(3);
//        System.out.println(unProducto);
//
//        Student otroProducto = servicioEstudiantes.getStudentById(3L);
//        System.out.println(otroProducto);
    }
}

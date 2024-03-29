package com.myshoppingcart.persistence;

import com.myshoppingcart.config.SpringConfig;
import com.myshoppingcart.model.Compra;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = {ProductoDBRepository.class, CompraDBRepository.class, ShoppingCart.class})
@ContextConfiguration(classes = {SpringConfig.class})
public class CompraDBRepositoryTest {

    @Autowired
    private ICompraRepository repo;

    @BeforeEach
    void sepUp() throws IOException {
        repo = new CompraDBRepository();
    }

    @Test
    void testBeans() {
        assertNotNull(repo);
    }

    @Test
    public void dadaCompraValida_cuandoinsertCompra_entoncesOK() throws Exception {
        Compra compra = new Compra(null, 1, 1, 3, LocalDate.now());

        Compra ncompra = repo.insertCompra(compra);

        assertThat(ncompra.getCid(), greaterThan(1));

    }

    @Test
    public void dadaCompraProductoNoValido_cuandoinsertCompra_entoncesExcepcion() throws Exception {
        Compra compra = new Compra(null, 1, 1034, 3, LocalDate.now());
        assertThrows(Exception.class, ()->{
            Compra ncompra = repo.insertCompra(compra);
        });
    }

    @Test
    public void dadaCompraProductoSinexistenciasSuficients_cuandoinsertCompra_entoncesExcepcion() throws Exception {
        Compra compra = new Compra(null, 1, 1, 300, LocalDate.now());
        assertThrows(Exception.class, ()->{
            Compra ncompra = repo.insertCompra(compra);
        });
    }
}

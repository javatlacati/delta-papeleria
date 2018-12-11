/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import presentacion.JdVenta;
import presentacion.JdVentaNuevo;
import presentacion.JfPrincipal;
import repositorios.ClienteRepository;
import repositorios.NDetalleVenta;
import repositorios.NProducto;
import repositorios.NVenta;
import util.DataProvider;

/**
 * @author vehimar
 */

@Log
@SpringBootApplication
@EntityScan("entidades")
@EnableJpaRepositories("repositorios")
public class NCliente {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    NProducto nProducto;

    @Autowired
    NVenta nVenta;
    @Autowired
    NDetalleVenta nDetalleVenta;
    @Autowired
    ClienteRepository nCliente;

    @Autowired
    DataProvider dataProvider;


    @Bean
    DataProvider dataProviders() {
        return new DataProvider(clienteRepository, nProducto, frame(), principal());
    }

    @Bean
    public formClientes frame() {
        return new formClientes(clienteRepository);
    }

    @Bean
    public JdVentaNuevo ventaNuevo() {
        return new JdVentaNuevo(null, true, nVenta, nCliente, nDetalleVenta, nProducto);
    }

    @Bean
    public JfPrincipal principal() {
        return new JfPrincipal();
    }

    public static void main(String[] args) {
//        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(NCliente.class)
//                .headless(false).run(args);
//
//        EventQueue.invokeLater(() -> {
//            NCliente ex = ctx.getBean(NCliente.class);
//            ex.setVisible(true);
//        });
//        SpringApplication.run(NCliente.class, args);
        new SpringApplicationBuilder(NCliente.class)
                .headless(false)
                .web(false)
                .run(args);

    }


}

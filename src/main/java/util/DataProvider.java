package util;

import entidades.Cliente;
import entidades.Producto;
import lombok.AllArgsConstructor;
import negocio.formClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import presentacion.JfPrincipal;
import repositorios.ClienteRepository;
import repositorios.NProducto;

@Component
@AllArgsConstructor
public class DataProvider implements CommandLineRunner {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    NProducto nProducto;

    /**
     * Pull in the JFrame to be displayed.
     */
    @Autowired
    private formClientes frame;

    @Autowired
    private JfPrincipal principal;


    @Transactional
    @Override
    public void run(String... args) throws Exception {
        clienteRepository.save(new Cliente("Ruslan"));
        nProducto.save(new Producto("cuaderno", 5));

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                System.out.println("showing frame");
                //frame.setVisible(true);
                principal.setVisible(true);
            }
        });
    }
}

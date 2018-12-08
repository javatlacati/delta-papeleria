package repositorios;

import entidades.Detalleventa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NDetalleVenta extends JpaRepository<Detalleventa, Integer> {
    @Query("select d from Detalleventa d where d.venta.id = ?1")
    List<Detalleventa> listarDetallePVenta(int codigo);
}
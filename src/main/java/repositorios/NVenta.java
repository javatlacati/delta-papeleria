package repositorios;

import entidades.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NVenta extends JpaRepository<Venta, Integer> {

    @Query("select v from Venta v where v.id = (select max(v1.id) from Venta v1)")
    Venta obtenerUltimo();
}
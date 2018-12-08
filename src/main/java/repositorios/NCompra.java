package repositorios;

import entidades.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NCompra extends JpaRepository<Compra, Integer> {
    @Query("Select c from Compra c where c.id = ?1")
    Compra buscarCompraPorCodigo(Integer codigoNotaCompra);

    @Query("Select c from Compra c where c.fecha = ?1")
    List<Compra> buscarCompraPorFecha(String strFecha);

    @Query("Select c\n" +
            "from Compra c\n" +
            "join Detallecompra dc\n" +
            "join Producto p\n" +
            "where p.id = ?1 ")
    List<Compra> buscarCompraPorProducto(int codigoProducto);
}
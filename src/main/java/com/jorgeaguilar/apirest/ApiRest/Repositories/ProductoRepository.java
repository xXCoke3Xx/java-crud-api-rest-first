package com.jorgeaguilar.apirest.ApiRest.Repositories;

import com.jorgeaguilar.apirest.ApiRest.Entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long>{
}

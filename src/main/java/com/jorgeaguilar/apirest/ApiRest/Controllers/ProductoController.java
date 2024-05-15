package com.jorgeaguilar.apirest.ApiRest.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jorgeaguilar.apirest.ApiRest.Entities.Producto;
import com.jorgeaguilar.apirest.ApiRest.Repositories.ProductoRepository;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productRepository;

    // ---- GET ----
    @GetMapping
    public List<Producto> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Producto getProductById(@PathVariable Long id){
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID: " + id));
    }

    // ---- POST ----
    @PostMapping
    public Producto createProduct(@RequestBody Producto producto){
        return productRepository.save(producto);
    }

    // ---- PUT ----
    @PutMapping("/{id}")
    public Producto updateProduct(@PathVariable Long id, @RequestBody Producto productoDetails){
        Producto producto =  productRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID: " + id));

        producto.setNombre(productoDetails.getNombre());
        producto.setPrecio(productoDetails.getPrecio());

        return productRepository.save(producto);
    }

    // ---- DELETE ----
    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Long id){
        Producto producto =  productRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el producto con el ID: " + id));

        productRepository.delete(producto);
        return "El producto con el ID: " + id + " ha sido eliminado con exito";
    }

}

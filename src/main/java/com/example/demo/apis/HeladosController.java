package com.example.demo.apis;

import com.example.demo.model.Helados;
import com.example.demo.services.IHeladosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HeladosController {
    IHeladosServices heladosServices;

    @Autowired
    public HeladosController(IHeladosServices heladosServices){
        this.heladosServices=heladosServices;
    }

    @GetMapping("/Helados")
    public List<Helados> getAll(){
        return heladosServices.GetAllProductos();
    }

    @GetMapping("/Helados/{id}")
    public Helados getAll(@PathVariable int id){
        return heladosServices.FindProductoById(id);
    }

    @PostMapping("/Helados")
    public Helados saveProducto(@RequestBody Helados entity){
        return heladosServices.SaveProducto(entity);
    }

    @PutMapping("/Helados/{id}")
    public Helados updateProducto(@PathVariable int id, @RequestBody Helados updateProducto){
        return heladosServices.UpdateProducto(id, updateProducto);
    }

    @DeleteMapping("/Helados/{id}")
    public String deleteProducto(@PathVariable int id){
        heladosServices.DeleteProducto(id);
        return "Producto eliminado con éxito";
    }
}

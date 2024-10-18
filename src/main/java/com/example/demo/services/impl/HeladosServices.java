package com.example.demo.services.impl;

import com.example.demo.model.Helados;
import com.example.demo.repository.IHeladosRepository;
import com.example.demo.services.IHeladosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeladosServices implements IHeladosServices {

    IHeladosRepository _producto2Repository;

    @Autowired
    public HeladosServices(IHeladosRepository producto2Repository){
        _producto2Repository = producto2Repository;
    }

    @Override
    public List<Helados> GetAllProductos() {
        return _producto2Repository.findAll();
    }

    @Override
    public Helados FindProductoById(int code) {
        Optional<Helados> rowinDB = _producto2Repository.findById(code);
        if (rowinDB.isPresent()) {
            return rowinDB.get();
        } else
            return new Helados();
    }

    @Override
    public Helados SaveProducto(Helados entity) {
        Helados productoSaved = _producto2Repository.save(entity);
        return productoSaved;
    }

    @Override
    public List<Helados> SearchProducto(int code) {
        return List.of();
    }

    @Override
    public Helados UpdateProducto(int code, Helados newProductData) {
        Optional<Helados> productoExists = _producto2Repository.findById(code);

        if (productoExists.isPresent()){
            Helados producto = productoExists.get();

            producto.setName(newProductData.getName());
            producto.setStock(newProductData.getStock());
            producto.setPrice(newProductData.getPrice());

            return _producto2Repository.save(producto);
        }else {
            throw new RuntimeException("Producto no encontrado con codigo :" + code);
        }
    }

    @Override
    public void DeleteProducto(int code) {
        Optional<Helados>productoExits = _producto2Repository.findById(code);
        if (productoExits.isPresent()){
            _producto2Repository.deleteById(code);
        }else{
            throw new RuntimeException("Producto no encontrado con codigo: " + code);
        }
    }
}

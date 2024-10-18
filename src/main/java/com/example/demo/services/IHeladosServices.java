package com.example.demo.services;

import com.example.demo.model.Helados;

import java.util.List;

public interface IHeladosServices {
    List<Helados> GetAllProductos();
    Helados FindProductoById(int id);
    Helados SaveProducto(Helados entity);
    List<Helados> SearchProducto(int id);
    Helados UpdateProducto(int id, Helados newProductData);
    void DeleteProducto(int id);
}

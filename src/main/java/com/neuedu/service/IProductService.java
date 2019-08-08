package com.neuedu.service;

import com.neuedu.exception.MyException;
import com.neuedu.pojo.Category;
import com.neuedu.pojo.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tao on 2019/8/7.
 */

public interface IProductService {

    public List<Product> findAll() throws MyException;

    public int updateProduct(Product product) throws MyException;

    public Product findProductById(int productId);

    public int deleteProduct(int productId) throws MyException;

    int add(Product product);


}

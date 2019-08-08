package com.neuedu.service.Impl;

import com.neuedu.dao.ProductMapper;
import com.neuedu.exception.MyException;
import com.neuedu.pojo.Product;
import com.neuedu.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tao on 2019/8/7.
 */

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductMapper productMapper;


    @Override
    public List<Product> findAll() {
        return productMapper.selectAll();
    }

    @Override
    public int updateProduct(Product product) throws MyException {
        return productMapper.updateByPrimaryKey(product);
    }

    @Override
    public Product findProductById(int productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    @Override
    public int deleteProduct(int productId) throws MyException {
        return productMapper.deleteByPrimaryKey(productId);
    }

    @Override
    public int add(Product product) {
        if(product==null){
            throw new MyException("参数为空");
        }
        if(product.getCategoryId()==null||product.getDetail()==null||product.getMainImage()==null
                ||product.getName()==null||product.getPrice()==null||
                product.getStatus()==null||product.getStock()==null||product.getSubImages()==null
                ||product.getSubtitle()==null){
            throw new MyException("请填写商品信息");
        }

        return productMapper.insert(product);
    }
}

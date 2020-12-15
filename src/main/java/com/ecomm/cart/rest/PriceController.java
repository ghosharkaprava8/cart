package com.ecomm.cart.rest;

import com.ecomm.cart.entity.Product;
import com.ecomm.cart.entity.ProductPrice;
import com.ecomm.cart.service.ProductPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/price/")
public class PriceController {

    ProductPriceService productPriceService;

    @Autowired
    PriceController(ProductPriceService theproductPriceService){
        this.productPriceService= theproductPriceService;
    }

    @GetMapping("/getallprices")
    public List<ProductPrice> getAllPrices(){

        return productPriceService.findAll();
    }

    @GetMapping("/getitemprice/{productId}")
    public ProductPrice getPrice(@PathVariable int productId){

        ProductPrice productPrice= productPriceService.findById(productId);

        if(productPrice== null){
            throw new RuntimeException("No Product of Id : "+ productId);
        }
        return productPrice;
    }

    @PostMapping("/insertprice")
    public ProductPrice insertPrice(ProductPrice theproductPrice){

        theproductPrice.setProductId(0);
        productPriceService.save(theproductPrice);

        return theproductPrice;
    }

    @DeleteMapping("/deleteprice")
    public String deletePrice(int productId){

        ProductPrice tempPrice = productPriceService.findById(productId);

        if(tempPrice== null){

            throw new RuntimeException("No product found by Id : "+ productId );
        }

        productPriceService.deleteById(productId);

        return "Successfully deleted " + productId;

    }

}

package com.ecomm.cart.rest;

import com.ecomm.cart.entity.Discount;
import com.ecomm.cart.entity.Product;
import com.ecomm.cart.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/discount")
public class DiscountController {

    DiscountService discountService;

    @Autowired
    DiscountController(DiscountService theDiscountService){
        this.discountService= theDiscountService;
    }

   @GetMapping("/alldiscounts")
    public List<Discount> findall(){

        return discountService.findAll();
    }

    @GetMapping("/getdiscount/{productId}")
    public Discount getDiscount(@PathVariable int productId){

       Discount discount= discountService.findById(productId);

        if (discount == null) {
            throw new RuntimeException("Employee id not found - " + productId);
        }

        return discount;
    }

    @PostMapping("/insertdiscount")
    public Discount putDiscount(Discount theDiscount){

        theDiscount.setId(0);
       discountService.save(theDiscount);

       return theDiscount;
    }

    @DeleteMapping("/deletediscount/{productId}")
    public String deleteDiscount( @PathVariable int productId){

        Discount tempDiscount= discountService.findById(productId);

        if(tempDiscount== null){

            throw new RuntimeException("No product found of the Id :" + productId);
        }

        discountService.deleteById(productId);

        return "Deleted Discount with Product Id : "+ productId;


    }
}

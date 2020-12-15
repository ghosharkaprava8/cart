package com.ecomm.cart.rest;

import java.util.List;

import com.ecomm.cart.entity.Product;
import com.ecomm.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private ProductService productService;
	
	@Autowired
	public EmployeeRestController(ProductService theProductService) {
		productService = theProductService;
	}
	
	// expose "/employees" and return list of employees
	@GetMapping("/employees")
	public List<Product> findAll() {
		return productService.findAll();
	}

	// add mapping for GET /employees/{employeeId}
	
	@GetMapping("/employees/{employeeId}")
	public Product getEmployee(@PathVariable int employeeId) {
		
		Product theProduct = productService.findById(employeeId);
		
		if (theProduct == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		return theProduct;
	}
	
	// add mapping for POST /employees - add new employee
	
	@PostMapping("/employees")
	public Product addEmployee(@RequestBody Product theProduct) {
		
		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update
		
		theProduct.setId(0);
		
		productService.save(theProduct);
		
		return theProduct;
	}
	
	// add mapping for PUT /employees - update existing employee
	
	@PutMapping("/employees")
	public Product updateEmployee(@RequestBody Product theProduct) {
		
		productService.save(theProduct);
		
		return theProduct;
	}
	
	// add mapping for DELETE /employees/{employeeId} - delete employee
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Product tempProduct = productService.findById(employeeId);
		
		// throw exception if null
		
		if (tempProduct == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		productService.deleteById(employeeId);
		
		return "Deleted employee id - " + employeeId;
	}
	
}











package com.kneotrino.assesment.controller;

import com.kneotrino.assesment.constant.ResponseStatusEnum;
import com.kneotrino.assesment.exception.ResourceNotFoundException;
import com.kneotrino.assesment.model.ProductModel;
import com.kneotrino.assesment.repository.ProductRepository;
import com.kneotrino.assesment.response.EntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Kneotrino
 * @date 19/12/19
 */

@RestController
@RequestMapping("v1/products")
public class ProductController {

  @Autowired
  ProductRepository productRepository;


  @GetMapping()
  public EntityResponse<java.util.List<ProductModel>> getProductAll() {
    return new EntityResponse<>(ResponseStatusEnum.OK.name(), productRepository.findAll());
  }

  @GetMapping("/page")
  public EntityResponse<Page<ProductModel>> getProductByPageable(
      @SortDefault.SortDefaults({
          @SortDefault(sort = "id", direction = Sort.Direction.DESC)})
          Pageable pageable) {
    return new EntityResponse<>(ResponseStatusEnum.OK.name(), productRepository.findAll(pageable));
  }

  @GetMapping("/{id}")
  public EntityResponse<ProductModel> getProductById(@PathVariable Long id) {
    return new EntityResponse(ResponseStatusEnum.OK.name(), productRepository.findById(id));
  }

  @DeleteMapping("/{id}")
  public EntityResponse deleteProductById(@PathVariable Long id) throws ResourceNotFoundException {
    return productRepository.findById(id)
        .map(question -> {
          productRepository.delete(question);
          return new EntityResponse(ResponseStatusEnum.RESOURCE_NOT_FOUND.name(), "Deleted Product with id successfully");
        }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id " + id));
  }

//  @PutMapping("/{id}")
//  public EntityResponse<ProductModel> updateProductById(@PathVariable Long id,
//                                                        @Valid @RequestBody ProductModel ProductModel) throws ResourceNotFoundException {
//    ProductModel updated = productRepository.findById(id)
//        .map(model -> productRepository.save(ProductModel.toBuilder().id(id).build())).orElseThrow(() -> new ResourceNotFoundException("ProductModel not found with id " + id));
//    return new EntityResponse<>(ResponseStatusEnum.OK.name(), productRepository.findById(id).get());
//  }

  @PostMapping("")
  public EntityResponse insertProduct(@Valid @RequestBody ProductModel ProductModel) {
    return new EntityResponse(ResponseStatusEnum.OK.name(), productRepository.save(ProductModel));
  }


}

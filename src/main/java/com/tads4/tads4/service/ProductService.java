package com.tads4.tads4.service;

import com.tads4.tads4.dto.ProductDTO;
import com.tads4.tads4.entities.Product;
import com.tads4.tads4.repositories.ProductRepository;
import com.tads4.tads4.service.exceptions.DatabaseException;
import com.tads4.tads4.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public ProductDTO findById(Long id) {
        /*Optional<Product> result = repository.findById(id);
        Product product = result.get();
        ProductDTO dto = new ProductDTO(product);
        return dto;*/
        Product product = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Recusro não encontrado"));
        return new ProductDTO(product);
    }

    @Transactional (readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        /*Optional<Product> result = repository.findById(id);
        Product product = result.get();
        ProductDTO dto = new ProductDTO(product);
        return dto;*/
        Page<Product> result = repository.findAll(pageable);
        return result.map(x-> new ProductDTO(x));
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto) {
        Product entity = new Product();
        copyDtoToEntity(dto, entity);
        entity =repository.save(entity);
        return new ProductDTO(entity);
    }

    /*@Transactional
    public ProductDTO update (Long id, ProductDTO dto) {
        Product entity = repository.getReferenceById(id);
        copyDtoToEntity(dto, entity);
        return new ProductDTO(entity);
    }*/
    @Transactional
    public ProductDTO update (Long id, ProductDTO dto) {

        try{
            Product entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            return new ProductDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

    }

    /*@Transactional
    public void delete(Long id) {
         repository.deleteById(id);
      }*/

    @Transactional (propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        try{
            repository.deleteById(id);
        } catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Recurso não encontrado");
        } catch(DataIntegrityViolationException e){
            throw new DatabaseException("Falha de integrigadade referencial");
        }

    }

    private void copyDtoToEntity(ProductDTO dto, Product entity) {
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImgUrl(dto.getImgUrl());

    }


}
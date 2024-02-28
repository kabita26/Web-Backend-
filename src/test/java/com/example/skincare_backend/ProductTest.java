package com.example.skincare_backend;

import com.example.skincare_backend.entity.product;
import com.example.skincare_backend.repository.productRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:h2:mem:testdb",
        "spring.datasource.driver-class-name=org.h2.Driver",
        "spring.datasource.username=sa",
        "spring.datasource.password=password",
        "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect"
})
public class ProductTest {
    @Autowired
    private productRepo productRepo;

    @Test
    public void saveItem() {
        product product = new product();
        product.setDescription("Testing Description");
        product.setItemName("Name");
        product.setPrice("1200");
        product.setImage("image");
        product savedProduct = productRepo.save(product);
        Assertions.assertThat(savedProduct.getId()).isNotNull();
    }

    @Test
    public void findById(){
        product product = productRepo.save(new product());
        product foundProduct = productRepo.findById(product.getId()).orElse(null);
        Assertions.assertThat(foundProduct).isNotNull();
    }

    @Test
    public void findAll() {
        List<product> productList = productRepo.findAll();
        Assertions.assertThat(productList.size()).isEqualTo(0);
    }

    @Test
    public void updateProduct() {
        product product = productRepo.save(new product());
        product.setItemName("Updated Item Name");
        product updatedProduct = productRepo.save(product);
        Assertions.assertThat(updatedProduct.getItemName()).isEqualTo("Updated Item Name");
    }
    @Test
    public void deletById(){
        productRepo.deleteById(1);
        product product1 =null;
        Optional<product> product= productRepo.findById(1);

        if(product.isPresent()){
            product1=product.get();
        }

        Assertions.assertThat(product1).isNull();


}
}
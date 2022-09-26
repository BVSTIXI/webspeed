package de.hsba.bi.webshop.webspeed;

import de.hsba.bi.webshop.webspeed.product.Product;
import de.hsba.bi.webshop.webspeed.product.ProductRepository;
import de.hsba.bi.webshop.webspeed.product.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

@MockitoSettings
public class ProductUnitTests {

    @Mock
    private ProductRepository productRepositoryMock;

    @InjectMocks
    private ProductService productServiceMock;

    @Test
    public Product findProductById(){
        Long id = 3L;
        if(productRepositoryMock.findById(id).isPresent()) return productRepositoryMock.findById(id).get();
        else return null;
    }

}

package features.product.application;

import features.product.domain.Product;
import features.product.domain.ProductRepository;
import features.product.presentation.ProductCreateInput;
import features.product.presentation.ProductPublishInput;

public class ProductPublishUsecase {

    public void run(ProductPublishInput input) {
        Product product = new ProductRepository().findById(input.getId());
        product.publish();
        new ProductRepository().save(product);
    }
}

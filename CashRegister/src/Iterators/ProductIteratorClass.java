package Iterators;

import Bill.Product;

/**
 * @author Nélio Lacerda
 */
public class ProductIteratorClass implements ProductIterator {
    private Product[] products;
    private int size, nextIndex;

    public ProductIteratorClass(Product[] products, int size){
        this.products = products;
        this.size = size;
        this.nextIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return this.nextIndex < size;
    }

    @Override
    public Product next() {
        return products[nextIndex++];
    }
}

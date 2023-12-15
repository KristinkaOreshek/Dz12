package org.example;

public class ShopRepository {

    private Product[] products = new org.example.Product[0];


    private org.example.Product[] addToArray(org.example.Product[] current, org.example.Product product) {
        org.example.Product[] tmp = new org.example.Product[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }

    
    public <Product> void add(Product product) {
        products = addToArray(products, (org.example.Product) product);
    }

    public Product[] findAll() {
        return products;
    }

    // Этот способ мы рассматривали в теории в теме про композицию
    public void remove(int id) {
        Product foundProduct = findById(id);
        if (foundProduct == null) {
            throw new NotFoundException("Продукт с ID: " + id + "не найден.");
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    public org.example.Product findById(int id) {
        for (org.example.Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
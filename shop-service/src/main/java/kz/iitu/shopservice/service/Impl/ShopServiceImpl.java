package kz.iitu.shopservice.service.Impl;

import kz.iitu.shopservice.model.Product;
import kz.iitu.shopservice.model.Shop;
import kz.iitu.shopservice.repository.ShopRepository;
import kz.iitu.shopservice.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public List<Shop> findAllShops() {
        return shopRepository.findAll();
    }

    @Override
    public List<Product> getShopProducts(Long id) {

        List<Product> productList  = restTemplate.getForObject("http://productservice/products/shop/"+ id, List.class);
        return productList;
    }

    @Override
    public Shop findShopById(Long id) {
        return shopRepository.findById(id).get();
    }

    @Override
    public void addShop(Shop shop) {
        shopRepository.save(shop);
    }

    @Override
    public void deleteShop(Long id) {
        shopRepository.deleteById(id);
    }

    @Override
    public void updateShop(Shop shop) {
        Optional<Shop> shopOptional = shopRepository.findById(shop.getId());

        if (shopOptional.isPresent()) {
            Shop dbShop = shopOptional.get();
            dbShop.setName(shop.getName());
            dbShop.setAddress(shop.getAddress());
            dbShop.setContactPhone(shop.getContactPhone());
            shopRepository.saveAndFlush(dbShop);
        }
    }
}

package kz.iitu.shopservice.service;

import kz.iitu.shopservice.model.Shop;

import java.util.List;

public interface ShopService {
    public List<Shop> findAllShops();

    public Shop findShopById(Long id);

    public void addShop(Shop shop);

    public void deleteShop(Long id);

    public void updateShop(Shop shop);
}

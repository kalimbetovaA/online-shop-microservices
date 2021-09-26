package kz.iitu.shopservice.controller;

import kz.iitu.shopservice.model.Shop;
import kz.iitu.shopservice.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shops")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("")
    public ResponseEntity<?> getAllShops() {
        return ResponseEntity.ok(shopService.findAllShops());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getShopById(@PathVariable Long id) {
        return ResponseEntity.ok(shopService.findShopById(id));
    }

    @PostMapping("")
    public ResponseEntity<?> addShop(@RequestBody Shop shop) {
        shopService.addShop(shop);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteShop(@PathVariable Long id) {
        shopService.deleteShop(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody Shop shop) {
        shop.setId(id);
        shopService.updateShop(shop);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}

package com.hungpham.ecommerce.controller;

import com.hungpham.ecommerce.model.entity.Item;
import com.hungpham.ecommerce.service.impl.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.create(item);
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable Long id) {
        return itemService.get(id);
    }

//    @PutMapping("/{idItem}/product/{idProduct}")
//    public Item addItemToProduct(@PathVariable Long idItem, @PathVariable Integer idProduct) {
//        return itemService.addItemToProduct(idItem, idProduct);
//    }
}

package com.hungpham.ecommerce.service.impl;

import com.hungpham.ecommerce.model.entity.Item;

public interface ItemService {
    Item create(Item item);
    Item get(Long id);
    //Item addItemToProduct(Long idItem, Integer idProduct);
}

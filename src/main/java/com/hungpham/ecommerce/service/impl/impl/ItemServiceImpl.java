package com.hungpham.ecommerce.service.impl.impl;

import com.hungpham.ecommerce.exception.BusinessException;
import com.hungpham.ecommerce.exception.ErrorCode;
import com.hungpham.ecommerce.model.entity.Item;
import com.hungpham.ecommerce.repository.ItemRepository;
import com.hungpham.ecommerce.service.impl.ItemService;
import com.hungpham.ecommerce.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ProductService productService;

    @Override
    public Item create(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item get(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new BusinessException(ErrorCode.ITEM_NOT_FOUND_ERROR));
    }
//
//    @Override
//    public Item addItemToProduct(Long idItem, Integer idProduct) {
//        Item item = get(idItem);
//        Product product = productService.findById(idProduct);
//        item.setProduct(product);
//        return itemRepository.save(item);
//    }
}

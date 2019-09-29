package com.hungpham.ecommerce.exception;

public interface ErrorCode {
    BusinessErrorCode INTERNAL_SERVER_ERROR =
            new BusinessErrorCode("ECOMMERCE-2001", "Internal Server Error", 500);

    BusinessErrorCode PRODUCT_NOT_FOUND_ERROR =
            new BusinessErrorCode("ECOMMERCE-1000", "Product Not Found Error", 404);

    BusinessErrorCode INPUT_DATA_FORMAT_ERROR =
            new BusinessErrorCode("ECOMMERCE-1001", "Input Data Input Format Error", 404);

    BusinessErrorCode ITEM_NOT_FOUND_ERROR =
            new BusinessErrorCode("ECOMMERCE-1002", "Item Not Found Error", 404);
}

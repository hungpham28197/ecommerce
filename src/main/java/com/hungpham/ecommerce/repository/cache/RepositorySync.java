package com.hungpham.ecommerce.repository.cache;

public interface RepositorySync<T, ID> {
    <S extends T> S save(S var1);
    void delete(T var1);
}

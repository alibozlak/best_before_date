package dev.bozlak.bbd.dtos.store;

public record CreateStoreRequestDto(
        String storeName,
        String storeCode,
        Integer adminId,
        Integer userId
) {
}

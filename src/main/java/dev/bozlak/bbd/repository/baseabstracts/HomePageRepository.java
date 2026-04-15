package dev.bozlak.bbd.repository.baseabstracts;

import dev.bozlak.bbd.utilities.dtos.RemovalDateSection;

import java.util.List;

public interface HomePageRepository {

    List<RemovalDateSection> getCurrentBbdList(Integer storeId);
}

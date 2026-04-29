package dev.bozlak.bbd.repository.baseabstracts;

import dev.bozlak.bbd.dtos.homepage.HomePageWholeList;

public interface HomePageRepository {

    HomePageWholeList getCurrentBbdList(Integer storeId);
}

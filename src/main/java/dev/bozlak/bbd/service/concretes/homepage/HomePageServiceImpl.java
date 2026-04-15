package dev.bozlak.bbd.service.concretes.homepage;

import dev.bozlak.bbd.service.abstracts.HomePageService;
import dev.bozlak.bbd.utilities.dtos.RemovalDateSection;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class HomePageServiceImpl implements HomePageService {

    @Override
    public List<RemovalDateSection> getCurrentBbdList(Integer userId) {
        return List.of();
    }
}

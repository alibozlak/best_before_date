package dev.bozlak.bbd.service.abstracts;

import dev.bozlak.bbd.utilities.dtos.RemovalDateSection;

import java.util.List;

public interface HomePageService {

    List<RemovalDateSection> getCurrentBbdList(Integer userId);
}

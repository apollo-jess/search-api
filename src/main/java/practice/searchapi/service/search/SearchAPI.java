package practice.searchapi.service.search;

import practice.searchapi.entity.Places;

public interface SearchAPI {

    Places searchPlaces(String query);
}

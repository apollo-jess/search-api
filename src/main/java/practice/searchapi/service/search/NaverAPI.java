package practice.searchapi.service.search;

import okhttp3.OkHttpClient;
import practice.searchapi.entity.Places;
import practice.searchapi.service.api.NaverSearchAPI;
import practice.searchapi.service.dto.NaverSearchResponseDTO;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NaverAPI implements SearchAPI {

    private static final int SEARCH_LIMIT_COUNT = 5;

    private static NaverSearchAPI createNaverSearchAPI() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://openapi.naver.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        return retrofit.create(NaverSearchAPI.class);
    }

    @Override
    public Places searchPlaces(String query) {
        NaverSearchAPI naverSearchAPI = createNaverSearchAPI();
        Call<NaverSearchResponseDTO> callSync = naverSearchAPI.getPlaces(query, SEARCH_LIMIT_COUNT);

        try {
            Response<NaverSearchResponseDTO> response = callSync.execute();
            if (response.body() == null) {
                throw new Exception("검색 오류 발생");
            }
            return new Places(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Places(NaverSearchResponseDTO.builder().total(0).build());
    }
}

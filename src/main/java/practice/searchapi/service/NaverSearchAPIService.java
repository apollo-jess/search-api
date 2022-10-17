package practice.searchapi.service;

import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;
import practice.searchapi.service.api.NaverSearchAPI;
import practice.searchapi.service.dto.NaverSearchResponseDTO;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class NaverSearchAPIService {

    private static final int SEARCH_LIMIT_COUNT = 5;

    public NaverSearchResponseDTO search(String query) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://openapi.naver.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        NaverSearchAPI naverSearchAPI = retrofit.create(NaverSearchAPI.class);
        Call<NaverSearchResponseDTO> callSync = naverSearchAPI.getPlaces(query, SEARCH_LIMIT_COUNT);

        try {
            Response<NaverSearchResponseDTO> response = callSync.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
            return NaverSearchResponseDTO.builder().total(0).build();
        }
    }
}

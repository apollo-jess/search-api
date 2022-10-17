package practice.searchapi.service;

import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;
import practice.searchapi.service.api.KakaoSearchAPI;
import practice.searchapi.service.dto.KakaoSearchResponseDTO;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class KakaoSearchAPIService {

    private static final int SEARCH_LIMIT_COUNT = 5;

    public void search(String query) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dapi.kakao.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        KakaoSearchAPI kakaoSearchAPI = retrofit.create(KakaoSearchAPI.class);
        Call<KakaoSearchResponseDTO> callSync = kakaoSearchAPI.getPlaces(query, SEARCH_LIMIT_COUNT);

        try {
            Response<KakaoSearchResponseDTO> response = callSync.execute();
            KakaoSearchResponseDTO kakaoSearchResponseDTO = response.body();
            System.out.println(kakaoSearchResponseDTO.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

package practice.searchapi.service;

import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Service;
import practice.searchapi.service.api.KakaoSearchAPI;
import practice.searchapi.service.dto.KakaoSearchResponseDTO;
import practice.searchapi.service.dto.KakaoSearchResponseMetaDTO;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class KakaoSearchAPIService {

    private static final int SEARCH_LIMIT_COUNT = 5;

    public KakaoSearchResponseDTO search(String query) {
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
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
            return KakaoSearchResponseDTO.builder()
                    .meta(KakaoSearchResponseMetaDTO.builder().totalCount(0).build())
                    .build();
        }
    }

}

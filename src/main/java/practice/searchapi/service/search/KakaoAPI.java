package practice.searchapi.service.search;

import okhttp3.OkHttpClient;
import practice.searchapi.entity.Places;
import practice.searchapi.service.api.KakaoSearchAPI;
import practice.searchapi.service.dto.KakaoSearchResponseDTO;
import practice.searchapi.service.dto.KakaoSearchResponseMetaDTO;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class KakaoAPI implements SearchAPI {

    private static final int SEARCH_LIMIT_COUNT = 5;

    @Override
    public Places searchPlaces(String query) {
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
            if (response.body() == null) {
                throw new Exception("검색 오류 발생");
            }
            return new Places(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Places(KakaoSearchResponseDTO.builder()
                .meta(KakaoSearchResponseMetaDTO.builder().totalCount(0).build())
                .build());
    }
}

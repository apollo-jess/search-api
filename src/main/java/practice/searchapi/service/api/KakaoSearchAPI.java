package practice.searchapi.service.api;

import practice.searchapi.service.dto.KakaoSearchResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface KakaoSearchAPI {

    @Headers({
            "Accept-Type: application/json",
            "Authorization: KakaoAK 3de6d3fa070fe7f9254d00b1b87b9eac"
    })
    @GET("/v2/local/search/keyword.json")
    public Call<KakaoSearchResponseDTO> getPlaces(
            @Query("query") String query,
            @Query("size") int size);
}

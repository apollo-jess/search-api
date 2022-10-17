package practice.searchapi.service.api;

import practice.searchapi.service.dto.NaverSearchResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface NaverSearchAPI {

    @Headers({
            "X-Naver-Client-Id: A8EGIqc0Y4l_34__wIA_",
            "X-Naver-Client-Secret: ivfu8BLxXh",
            "Accept-Type: application/json"
    })
    @GET("/v1/search/local")
    public Call<NaverSearchResponseDTO> getPlaces(
            @Query("query") String query,
            @Query("display") int display);

}

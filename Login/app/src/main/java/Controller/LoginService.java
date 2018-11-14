package Controller;

import Model.UserEntity;
import retrofit2.Call;
import retrofit2.http.GET;

public interface LoginService {

    @GET("user")
    Call<UserEntity> basicLogin();

}
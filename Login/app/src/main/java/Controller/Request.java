package Controller;

import android.content.Context;
import android.util.Log;

import Model.LoginResponse;
import Model.UserEntity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Request {

    public void loginCredentialsRequest(String username, String password, final Context context) {
        LoginService loginService = ServiceGenerator.createService(LoginService.class, username, password);
        Call<UserEntity> call = loginService.basicLogin();
        /*
        try {
            Response<UserEntity> response = call.execute();
            UserEntity userEntity = response.body();

            String token = response.raw().request().headers().get("Authorization");

            loginResponse.setName(userEntity.getName());
            loginResponse.setToken(token);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        call.enqueue(new Callback<UserEntity>() {
            @Override
            public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {
                if (response.isSuccessful()) {
                    LoginResponse session = new LoginResponse(context);

                    UserEntity userEntity = response.body();
                    String token = response.raw().request().headers().get("Authorization");

                    session.setName(userEntity.getName());
                    session.setToken(token);
                }
            }

            @Override
            public void onFailure(Call<UserEntity> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });

        /*
        Disposable disposable = call
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribeWith(new DisposableObserver<Response<UserEntity>>(){

                    @Override
                    public void onNext(Response<UserEntity> response) {
                        UserEntity userEntity = response.body();
                        String token = response.raw().request().headers().get("Authorization");

                        loginResponse.setName(userEntity.getName());
                        loginResponse.setToken(token);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        call.delay(5000, MILLISECONDS).take(1);
        disposable.dispose();
        */

        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            Log.d("Error", e.getMessage());
        }
    }

        public void loginTokenRequest(String token, final Context context) {
            LoginService loginService = ServiceGenerator.createService(LoginService.class, token);
            Call<UserEntity> call = loginService.basicLogin();

            call.enqueue(new Callback<UserEntity>() {
                @Override
                public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {
                    if (response.isSuccessful()) {
                        LoginResponse session = new LoginResponse(context);

                        UserEntity userEntity = response.body();
                        String token = response.raw().request().headers().get("Authorization");

                        session.setName(userEntity.getName());
                        session.setToken(token);
                    }
                }

                @Override
                public void onFailure(Call<UserEntity> call, Throwable t) {
                    Log.d("Error", t.getMessage());
                }
            });

            try {
                Thread.sleep(5000);
            } catch(InterruptedException e) {
                Log.d("Error", e.getMessage());
        }
    }
}

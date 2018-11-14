package Model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class LoginResponse {

    private SharedPreferences prefs;

    public LoginResponse(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setName(String name) {
        prefs.edit().putString("name", name).commit();
    }

    public String getName() {
        String name = prefs.getString("name","");
        return name;
    }

    public void setToken(String token) {
        prefs.edit().putString("token", token).commit();
    }

    public String getToken() {
        String token = prefs.getString("token","");
        return token;
    }

    public void setRemember(String remember) {
        prefs.edit().putString("remember", remember).commit();
    }

    public String getRemember() {
        String remember = prefs.getString("remember","");
        return remember;
    }
}

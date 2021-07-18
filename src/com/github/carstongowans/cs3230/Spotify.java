package com.github.carstongowans.cs3230;
import java.net.*;
import java.net.URL;
import java.io.IOException;
import okhttp3.OkHttpClinet;
import okhttp3.Request;
imoprt okhttp3.Response;

public class Spotify {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://api.spotify.com/v1/recommendations/available-genre-seeds");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestProperty("Accept", "application/json");
        http.setRequestProperty("Content-Type", "application/json");
        http.setRequestProperty("Authorization", "Bearer BQCDyd2-QNofVQXG0mKmC2vvAzKHD6rzKl9kqJps8BtG9Qf6Xt_CH5NuyfyaR5dlO8MlYaxRafGhwTj88DyBrdkbPTUzvX3jdM4dLY2d4QZx1Pv0yh4-a82oDaYpw9CW8-PEG1hfoCx6qjO20yRNZHxfqxANTjnQCUufwt2TOZrzdAjI1omjJcb-o-SWrvMMDfeBA1CdDZSuMNjNkhPu6bnGFh8NMfVvg1e5IeprtPmJFfL1JYE-4VK6D-f3uAuupeki3YS_kKT99cskpHfCI3I");

        System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
        System.out.println("getContent" + http.getContent());
        var contentInformation = http.getHeaderField("genres");

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.spotify.com/v1/recommendations/available-genre-seeds")
                .method("GET", null)
                .addHeader("Authorization", "Bearer BQC8mfIEijqzCd9DE2pTK88Q4yB0Nm9bpdRb2aVhshEbwp0YSPD2va1972pYDvqDtw2Siqi90RAOJnbGIaYvjoh3YcLmNewVlftqcnLcu28T7TF8k-Jk3JhhhFZ56w5pAMcHPdyu7ZgNAUHoeRN_6qcObX1_ELZ7O0GbgZxHlVyofV8CSsBwY3EmQoEZNFiibV90ytq-VGW1gWbEioiTopu53l8ZTcIftE5sAd-OLEo2sWpm3jTkQfXYfVyQ9LIZrETUVwPhfvFU_Fmr53eOh38")
                .build();
        Response response = client.newCall(request).execute();
        http.disconnect();
    }
}

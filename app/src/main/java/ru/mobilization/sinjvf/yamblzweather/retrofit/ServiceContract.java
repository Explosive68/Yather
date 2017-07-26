package ru.mobilization.sinjvf.yamblzweather.retrofit;

import com.google.gson.Gson;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import ru.mobilization.sinjvf.yamblzweather.retrofit.data.WeatherResponse;

/**
 * Created by Sinjvf on 15.07.2017.
 * Describes server configuration
 */

class ServiceContract {

    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private static final String WEATHER = "weather";

    static final String FIELD_APP_KEY = "appid";
    static final String FIELD_CITY_ID = "id";
    static final String FIELD_UNITS = "units";
    static final String FIELD_LAT = "lat";
    static final String FIELD_LON = "lon";


    static final String UNITS_METRIC = "metric";

    interface WeatherAPI {
        @GET(WEATHER)
        Observable<WeatherResponse> getWeather(@QueryMap Map<String, String> map);
    }


    private static class ServiceGenerator {
        private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        static Gson gson = new Gson();
        private static Retrofit.Builder builder =
                new Retrofit.Builder()
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .baseUrl(ServiceContract.BASE_URL);

        private static <S> S createService(Class<S> serviceClass) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient.addInterceptor(logging);

            OkHttpClient client = httpClient.build();
            Retrofit retrofit;
            retrofit = builder.client(client).build();
            return retrofit.create(serviceClass);
        }
    }

    public static ServiceContract.WeatherAPI getService() {
        return ServiceContract.ServiceGenerator.createService(ServiceContract.WeatherAPI.class);
    }
}
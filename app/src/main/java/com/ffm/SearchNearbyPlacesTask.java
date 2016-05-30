package com.ffm;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by guilhermemg on 18/05/16.
 */
public class SearchNearbyPlacesTask extends AsyncTask<URL, Integer, Long> {

    private final String LOG_TAG = "SearchNearbyPlacesTask";

    @Override
    protected Long doInBackground(URL... urls) {
        try {
            String charset = "UTF-8";

            URLConnection connection = urls[0].openConnection();
            connection.setRequestProperty("Accept-Charset", charset);
            Log.d(LOG_TAG, "Connection content: " + connection.getContent());

            InputStream response = connection.getInputStream();

            Log.d(LOG_TAG, "Response: " + response.toString());

//            // Convert to a JSON object to print data
//            JsonParser jp = new JsonParser(); //from gson
//            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
//            JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
//            zipcode = rootobj.get("zip_code").getAsString(); //just grab the zipcode
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0L;
    }

}

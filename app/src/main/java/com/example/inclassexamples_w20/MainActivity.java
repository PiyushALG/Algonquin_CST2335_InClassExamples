package com.example.inclassexamples_w20;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temp = findViewById(R.id.temp);
        MyHTTPRequest req = new MyHTTPRequest();
        req.execute("http://carapiet.com/files/CST2335_XML.xml");  //Type 1
    }

    //Type1     Type2   Type3
    private class MyHTTPRequest extends AsyncTask<String, Integer, String> {
        //Type3                Type1
        public String doInBackground(String... args) {
            try {

                //create a URL object of what server to contact:
                URL url = new URL(args[0]);

                //open the connection
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

                //wait for data:
                InputStream response = urlConnection.getInputStream();


                //From part 3: slide 19
                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                factory.setNamespaceAware(false);
                XmlPullParser xpp = factory.newPullParser();
                xpp.setInput(response, "UTF-8");


            } catch (Exception e) {
                return "Exception occurred while parsing XML call. " + e.toString();
            }

            return "XML call Done";
        }

        //Type 2
        public void onProgressUpdate(Integer... args) {

        }

        //Type3
        public void onPostExecute(String fromDoInBackground) {
            temp.setText(fromDoInBackground);
            Log.i("HTTP", fromDoInBackground);
        }
    }
}

package net.skillbooster.normaljsontest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<DataList> lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       lists = new ArrayList<DataList>();
       jsonTask jsonTask = new jsonTask();
       jsonTask.execute();
    }

    public class jsonTask extends AsyncTask<String,String,String>{
          URL url;
          HttpURLConnection httpURLConnection = null;
          InputStream inputStream;
          BufferedReader bufferedReader;
          StringBuffer stringBuffer = new StringBuffer();
        @Override
        protected String doInBackground(String... strings) {
            try {
                url = new URL("https://api.myjson.com/bins/r7dj6");
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                inputStream = httpURLConnection.getInputStream();

               bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
               String line =" ";

               while ((line = bufferedReader.readLine()) != null){
                   stringBuffer.append(line);

               }

               String fullfile = stringBuffer.toString();

                JSONObject jsonObject = new JSONObject(fullfile);
                JSONObject jsonObjectchild = jsonObject.getJSONObject("Apartment");

                for (Iterator key = jsonObjectchild.keys(); key.hasNext();) {
                    JSONObject flatName = (JSONObject) jsonObjectchild.get((String) key.next());

                    String name = flatName.getString("name");
                    String color = flatName.getString("color");
                    String owner = flatName.getString("owner");
                    String partner = flatName.getString("partner");
                    String age  = flatName.getString("age");
                    lists.add(new DataList(age,color,owner,partner,name));

                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            RecycelerViewAdapter recycelerViewAdapter  = new RecycelerViewAdapter(lists,getApplicationContext());
            recyclerView.setAdapter(recycelerViewAdapter);
        }
    }
}

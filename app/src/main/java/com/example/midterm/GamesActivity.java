package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.midterm.DataModel.Games;
import com.example.midterm.Paser.JSONParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GamesActivity extends AppCompatActivity {

    private ListView lvGameListView;
    private ArrayList<Games> ArrayGames = new ArrayList<>();
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        this.getActionBar().hide();

        lvGameListView = findViewById(R.id.lv_GameListView);

        new GetDataTask().execute();

        adapter = new Adapter(ArrayGames,this);

        lvGameListView.setAdapter(adapter);
        lvGameListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Games games = (Games) parent.getAdapter().getItem(position);

                Intent i = new Intent(GamesActivity.this, GameProfileActivity.class);
                i.putExtra("name", games.getName());
                i.putExtra("rate", games.getRate());
                i.putExtra("price", games.getPrice());
                i.putExtra("des",games.getDES());

                startActivity(i);
            }
        });

    }

    class GetDataTask extends AsyncTask<Void, Void, Void>{

        protected  void onPreExecute(){
            super.onPreExecute();
        }

        protected Void doInBackground(Void... params) {

            JSONObject jsonObject = JSONParser.getDataFromWeb();

            try {
                if (jsonObject != null) {
                    if(jsonObject.length() > 0) {
                        JSONArray array = jsonObject.getJSONArray("Game");
                        int lenArray = array.length();
                        if(lenArray > 0) {
                            for(int jIndex = 0; jIndex < lenArray; jIndex++) {
                                Games games = new Games();
                                JSONObject game = array.getJSONObject(jIndex);
                                String name = game.getString("name");
                                String rate = game.getString("rate");
                                String price = game.getString("price");
                                String DES = game.getString("description");

                                games.setName(name);
                                games.setRate(rate);
                                games.setPrice(price);
                                games.setDES(DES);

                                ArrayGames.add(games);
                            }
                        }
                    }
                } else {

                }
            } catch (JSONException je) {
                Log.i(JSONParser.TAG, "" + je.getLocalizedMessage());
            }
            return null;
        }
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if(ArrayGames.size() > 0) {
                adapter.notifyDataSetChanged();
            }
        }

    }
}

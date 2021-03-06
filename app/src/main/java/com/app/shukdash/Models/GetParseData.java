package com.app.shukdash.Models;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.parse.ParseException;
import com.parse.ParseQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danielT on 10/08/2015.
 */
public class GetParseData extends Activity {


    int catL1=0, catL2=0, catL3=0, catL4=0, catL5=0,catL6=0;

   public  Context contextOfApp;

    public GetParseData(Context contextOfApp){
        this.contextOfApp = contextOfApp;
    }

    SharedPreferences sharedPrefs;

    public boolean parseQuery()  throws ParseException {

        List<CatDetailsData> missions = new ArrayList<CatDetailsData>();

        List<InitDashData> cat1 = new ArrayList<InitDashData>();
        List<InitDashData> cat2 = new ArrayList<InitDashData>();
        List<InitDashData> cat3 = new ArrayList<InitDashData>();
        List<InitDashData> cat4 = new ArrayList<InitDashData>();
        List<InitDashData> cat5 = new ArrayList<InitDashData>();
        List<InitDashData> cat6 = new ArrayList<InitDashData>();

        List<InitDashData> parseData = new ArrayList<InitDashData>();
        ParseQuery<InitDashData> query = new ParseQuery<InitDashData>("shukDashJerDetails");
        ShukDashDB db = new ShukDashDB(contextOfApp);


        try {

            parseData = query.find();
            int i = parseData.size();
            Log.i("Parse query", "size is: " + String.valueOf(i));

            for (InitDashData info : parseData) {

                CatDetailsData newData = new CatDetailsData();
                newData.setCategoryCode(info.getCategoryCode());
                newData.setCategoryName(info.getCategoryName());
                newData.setCatLength(info.getCategoryLength());
                newData.setNumTasks(info.getTaskNumber());
                newData.setDescription(info.getDescription());
                newData.setPoints(info.getPoints());
                missions.add(newData);



            }

            db.inputInitialMissions(missions);


/*
            for (InitDashData info : parseData) {

                if (info.getCategoryCode() == 1) {



                    InitDashData newData = new InitDashData();
                    newData.setCategoryName(info.getCategoryName());
                    newData.setDescription(info.getDescription());
                    newData.setPoints(info.getPoints());
                    catL1 = info.getCategoryLength();
                    Log.i("Parse cat length ", String.valueOf(catL1));
                    String catName = info.getCategoryName();
                    String descrip = info.getDescription();
                    Log.i("Parse Data Info", "cat code 1");
                    Log.i("Parse Data Info", catName + " " + descrip);
                    ///there may be one mission missing from this section on the parse database?????
                    cat1.add(newData);


                }


                if (info.getCategoryCode() == 2) {
                    InitDashData newData = new InitDashData();
                    newData.setCategoryName(info.getCategoryName());
                    newData.setDescription(info.getDescription());
                    newData.setPoints(info.getPoints());
                    catL2 = info.getCategoryLength();
                    String catName = info.getCategoryName();
                    String descrip = info.getDescription();
                    Log.i("Parse Data Info", "cat code 2");
                    Log.i("Parse Data Info", catName + " " + descrip);
                    cat2.add(newData);

                }
                if (info.getCategoryCode() == 3) {
                    InitDashData newData = new InitDashData();
                    newData.setCategoryName(info.getCategoryName());
                    newData.setDescription(info.getDescription());
                    newData.setPoints(info.getPoints());
                    catL3 = info.getCategoryLength();
                    String catName = info.getCategoryName();
                    String descrip = info.getDescription();
                    Log.i("Parse Data Info", "cat code 3");
                    Log.i("Parse Data Info", catName + " " + descrip);

                    cat3.add(newData);

                }
                if (info.getCategoryCode() == 4) {
                    InitDashData newData = new InitDashData();
                    newData.setCategoryName(info.getCategoryName());
                    newData.setDescription(info.getDescription());
                    newData.setPoints(info.getPoints());
                    catL4 = info.getCategoryLength();
                    String catName = info.getCategoryName();
                    String descrip = info.getDescription();
                    Log.i("Parse Data Info", "cat code 4");
                    Log.i("Parse Data Info", catName + " " + descrip);

                    cat4.add(newData);

                }
                if (info.getCategoryCode() == 5) {

                    InitDashData newData = new InitDashData();
                    newData.setCategoryName(info.getCategoryName());
                    newData.setDescription(info.getDescription());
                    newData.setPoints(info.getPoints());
                    catL5 = info.getCategoryLength();
                    String catName = info.getCategoryName();
                    String descrip = info.getDescription();
                    Log.i("Parse Data Info", "cat code 5");
                    Log.i("Parse Data Info", catName + " " + descrip);

                    cat5.add(newData);

                }
                if (info.getCategoryCode() == 6) {

                    InitDashData newData = new InitDashData();
                    newData.setCategoryName(info.getCategoryName());
                    newData.setDescription(info.getDescription());
                    newData.setPoints(info.getPoints());
                    catL6 = info.getCategoryLength();
                    String catName = info.getCategoryName();
                    String descrip = info.getDescription();
                    Log.i("Parse Data Info", "cat code 6");
                    Log.i("Parse Data Info", catName + " " + descrip);

                    cat6.add(newData);

                }

            }


            createSharedPrefs(cat1, catL1, 1);
            createSharedPrefs(cat2, catL2, 2);
            createSharedPrefs(cat3, catL3, 3);
            createSharedPrefs(cat4, catL4, 4);
            createSharedPrefs(cat5, catL5, 5);
            createSharedPrefs(cat6, catL6, 6);

            int pdSaize = parseData.size();
            Log.i("Parse Data size", String.valueOf(pdSaize));

            Log.i("Parse Data size", "end of GetParseData activity class");

            */
            return true;
        }
        catch (ParseException e){
            Log.i("Parse exception", e.toString());
            return false;
        }

        }



    public void createSharedPrefs(List<InitDashData> catData, int catLength, int catNum) {

        Log.i("Parse Create SharedPref", "details "+String.valueOf(catNum)+" "+String.valueOf(catLength));

        switch (catNum){
            case 1:
                sharedPrefs = contextOfApp.getSharedPreferences("category1", Context.MODE_APPEND);
                Log.i("Parse Create SharedPref","number "+String.valueOf(catNum));
                break;
            case 2:
                sharedPrefs = contextOfApp.getSharedPreferences("category2", Context.MODE_APPEND);
                Log.i("Parse Create SharedPref","number "+String.valueOf(catNum));
                break;
            case 3:
                sharedPrefs = contextOfApp.getSharedPreferences("category3", Context.MODE_APPEND);
                Log.i("Parse Create SharedPref","number "+String.valueOf(catNum));
                break;
            case 4:
                sharedPrefs = contextOfApp.getSharedPreferences("category4", Context.MODE_APPEND);
                Log.i("Parse Create SharedPref","number "+String.valueOf(catNum));
                break;
            case 5:
                sharedPrefs = contextOfApp.getSharedPreferences("category5", Context.MODE_APPEND);
                Log.i("Parse Create SharedPref","number "+String.valueOf(catNum));
                break;
            case 6:
                sharedPrefs = contextOfApp.getSharedPreferences("category6", Context.MODE_APPEND);
                Log.i("Parse Create SharedPref","number "+String.valueOf(catNum));
                break;
            default:
                break;
        }

        if (sharedPrefs==null) {
            Log.i("ShukDash ", "Presenter Parse Cat sharedprefs ==null");
            SharedPreferences.Editor edit = sharedPrefs.edit();
            edit.putInt("catLength", catLength);
            edit.putInt("catPointsTotal", 0);
            Log.i("Presenter Parse Cat", "for loop");
            for (int i = 0; i < catLength; i++) {

                Log.i("Presenter Parse Cat", "begining shared pref");

                edit.putString("Name" + i, catData.get(i).getCategoryName().toString());
                edit.putString("Description" + i, catData.get(i).getDescription().toString());
                edit.putInt("Points" + i, catData.get(i).getPoints());
                edit.putBoolean("Ticked" + i, false);
                edit.commit();

                Log.i("Presenter Parse Cat", "end shared pref");
            }

        }
    }


 /*   public List<CatDetailsData> getCategoryDetails(){

        List<CatDetailsData> categDetails;
        ParseQuery<CatDetailsData> catData  = new ParseQuery<CatDetailsData>("CategoryDetails");
        categDetails = new ArrayList<CatDetailsData>();

        try {
            categDetails = catData.find();
            int in = categDetails.size();
            Log.i("Parse catDetails", "size " + String.valueOf(in));

        }
        catch (ParseException e)
        {
            Log.i("Parse Exception ", e.toString());
        }

        return categDetails;


    }

    */
}


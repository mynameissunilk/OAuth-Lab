package sunil.oauthlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity {

    EditText edittext;
    Button button;
    ListView listview;

    public static String CONSUMER_KEY="tJF1TxJoPHGrjyTMzIAGqjpaE";
    public static String CONSUMER_SECRET="T8IuaJBtYACzTRuWcPtIuVxEFDEFK6tgapgOqDbrS8IcGNu2NZ";
    public static String KEY_CONCAT=CONSUMER_KEY+":"+CONSUMER_SECRET;
    public static String REQUEST_URI="https://api.twitter.com/1.1/";
    public static String KEY_BASE64;
    private static String token;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittext = (EditText) findViewById(R.id.search_edittext);
        button = (Button) findViewById(R.id.search_button);
        listview = (ListView) findViewById(R.id.listview);

        byte[]concatArray = KEY_CONCAT.getBytes();
        KEY_BASE64 = Base64.encodeToString(concatArray,Base64.DEFAULT); // try NO_WRAP if it doesn't work


    }

    private void getAccessToucan(String toucan){

        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("Authorization",KEY_BASE64)
                .add("Content-Type","application/x-www-form-urlencoded:char")
                .add("grant_type","client_credentials")
                .build();
        //https://api.twitter.com/oauth2/token
        Request request = new Request.Builder()
                .url("https://api.twitter.com/oauth2/token")
                .post(formBody)
                .build();
        client.newCall(request);
    }
}

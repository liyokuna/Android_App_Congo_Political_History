package eduuserslmukunaciowelapersonalwebsite.missouriwestern.httpwebservices.project_final;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseIntArray;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.MediaController;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import android.media.SoundPool;
import android.media.AudioManager;
import android.media.MediaPlayer;


import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    private LinearLayout mLinearLayout;
    private SoundPool soundPool;
    private SparseIntArray soundMap;
    private MediaPlayer mMediaPlayer;
    private MediaController nMediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Reference to the scrollable layout strucutre n main screen
        mLinearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        // fill the scrollable layout structure with paintings
        fillPaintGallery();

        //confugure sounds
        configureSounds();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void fillPaintGallery() {
        ImageButton buttonItem;

        for (int i = 0; i < Congodatabase.description.length; i++) {
            buttonItem = new ImageButton(this);
            Random rand = new Random();
            int n = rand.nextInt(2) + 1;
            Drawing drawing = new
                    Drawing(Congodatabase.description[i], Congodatabase.id[i][n], Congodatabase.audio[i]);

            buttonItem.setContentDescription(drawing.getmDescription());

            buttonItem.setImageDrawable(getResources().getDrawable(drawing.getmId()));

            buttonItem.setOnClickListener(displayDrawing);

            mLinearLayout.addView(buttonItem);
        }
    }

    private void configureSounds(){

        soundPool = new SoundPool(1,AudioManager.STREAM_MUSIC,0);
        soundMap = new SparseIntArray(4);
        soundMap.put(1, soundPool.load(this,R.raw.joseph_ksv,1));
        soundMap.put(2, soundPool.load(this,R.raw.lumumba,1));
        soundMap.put(3, soundPool.load(this,R.raw.mobutu,1));
        soundMap.put(4, soundPool.load(this,R.raw.kabila,1));
        soundMap.put(5, soundPool.load(this,R.raw.joseph,1));
        soundMap.put(6, soundPool.load(this,R.raw.matata,1));
        soundMap.put(7, soundPool.load(this,R.raw.etienne,1));
        soundMap.put(8, soundPool.load(this,R.raw.moise,1));
        soundMap.put(9, soundPool.load(this,R.raw.dondo,1));
        soundMap.put(10, soundPool.load(this,R.raw.vital,1));

        //mMediaPlayer = MediaPlayer.create(this,R.raw.vital)

    }

    private View.OnClickListener displayDrawing =
            new View.OnClickListener() {
                public void onClick(View btn) {
                    String drawingDescription = (String) btn.getContentDescription();

                    if(drawingDescription.contentEquals("First President of The Republic of Congo")){

                        soundPool.play(1,1,1,1,0,1.0f);
                    }
                    else if(drawingDescription.contentEquals("The First Prime minister of The Congo-Kinshasa")){

                        soundPool.play(2,1,1,1,0,1.0f);
                    }else if(drawingDescription.contentEquals("The second President of The Republic of Congo and The Zaire")){

                        soundPool.play(3,1,1,1,0,1.0f);
                    }else if(drawingDescription.contentEquals("The third President of Democratic Republic of Congo")){

                        soundPool.play(4,1,1,1,0,1.0f);
                    }else if(drawingDescription.contentEquals("The current President of Democratic Republic of Congo")){

                        soundPool.play(5,1,1,1,0,1.0f);
                    }else if(drawingDescription.contentEquals("The current Prime minister of Democratic Republic of Congo")){

                        soundPool.play(6,1,1,1,0,1.0f);
                    }else if(drawingDescription.contentEquals("The main leader of the political opposition")){

                        soundPool.play(7,1,1,1,0,1.0f);
                    }else if(drawingDescription.contentEquals("The chairman of TP Mazembe")){

                        soundPool.play(8,1,1,1,0,1.0f);
                    }else if(drawingDescription.contentEquals("The current President of The Senat")){

                        soundPool.play(9,1,1,1,0,1.0f);
                    }else if(drawingDescription.contentEquals("One of popular opposition leader")){

                        soundPool.play(10,1,1,1,0,1.0f);
                    }


                    displayToast(drawingDescription);
                }
            };
    private void displayToast(String drawingDescription){

        Toast.makeText(this, drawingDescription,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://eduuserslmukunaciowelapersonalwebsite.missouriwestern.httpwebservices.project_final/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://eduuserslmukunaciowelapersonalwebsite.missouriwestern.httpwebservices.project_final/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}

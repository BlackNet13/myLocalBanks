package sg.rp.edu.rp.c346.id22038845.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    LinearLayout layoutBg;
    TextView dbs;
    TextView ocbc;
    TextView uob;
    Menu optionsMenu;
    Menu contextMenu;

    int lang = 1;
    int state[] ={0,0,0};

    String tvClicked="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutBg=findViewById(R.id.bgMain);
        dbs=findViewById(R.id.dbsTv);
        ocbc=findViewById(R.id.ocbcTv);
        uob=findViewById(R.id.uobTv);


        layoutBg.getBackground().setAlpha(100);
        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);

    }

    @Override //context Menu for bank icon
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);



        //menu.setHeaderTitle(getResources().getString(R.string.choice));

        if(lang == 1) {
            menu.setHeaderTitle(getResources().getString(R.string.choice));
            if(v == dbs){
                if(state[0]==0){
                    menu.add(0,0,0,getResources().getString(R.string.fav));
                }else{
                    menu.add(0,0,0,getResources().getString(R.string.unFav));
                }
                menu.add(0,1,1,getResources().getString(R.string.website));
                menu.add(0,2,2,getResources().getString(R.string.contact_the_bank));
            }else if(v ==ocbc){
                if(state[1]==0){
                    menu.add(1,0,0,getResources().getString(R.string.fav));
                }else{
                    menu.add(1,0,0,getResources().getString(R.string.unFav));
                }
                menu.add(1,1,1,getResources().getString(R.string.website));
                menu.add(1,2,2,getResources().getString(R.string.contact_the_bank));
            }else if(v ==uob){
                if(state[2]==0){
                    menu.add(2,0,0,getResources().getString(R.string.fav));
                }else{
                    menu.add(2,0,0,getResources().getString(R.string.unFav));
                }
                menu.add(2,1,1,getResources().getString(R.string.website));
                menu.add(2,2,2,getResources().getString(R.string.contact_the_bank));
            }

        }else if(lang == 2){
            menu.setHeaderTitle(getResources().getString(R.string.choiceC));
            if(v == dbs){
                if(state[0]==0){
                    menu.add(0,0,0,getResources().getString(R.string.favC));
                }else{
                    menu.add(0,0,0,getResources().getString(R.string.unFavC));
                }
                menu.add(0,1,1,getResources().getString(R.string.websiteC));
                menu.add(0,2,2,getResources().getString(R.string.contactTBC));
            }else if(v ==ocbc){
                if(state[1]==0){
                    menu.add(1,0,0,getResources().getString(R.string.favC));
                }else{
                    menu.add(1,0,0,getResources().getString(R.string.unFavC));
                }
                menu.add(1,1,1,getResources().getString(R.string.websiteC));
                menu.add(1,2,2,getResources().getString(R.string.contactTBC));
            }else if(v ==uob){
                if(state[2]==0){
                    menu.add(2,0,0,getResources().getString(R.string.favC));
                }else{
                    menu.add(2,0,0,getResources().getString(R.string.unFavC));
                }
                menu.add(2,1,1,getResources().getString(R.string.websiteC));
                menu.add(2,2,2,getResources().getString(R.string.contactTBC));
            }
        }

    }

    @Override //optionsMenu for language settings
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        optionsMenu = menu;
        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        int id = item.getItemId();
        int gId= item.getGroupId();
        //float textV[]= {dbs.getY(),ocbc.getY(),uob.getY()};;


        if (gId == 0){ //dbs
            if (id == 0) { //fav
                if(state[0]==0){
                    dbs.setTextColor(Color.parseColor("#ff0303"));
                    state[0]=1;
                }else{
                    dbs.setTextColor(Color.parseColor("#FF000000"));
                    state[0]=0;
                }
                return true;
            } else if (id == 1) { //web
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/personal/default.page"));
                startActivity(intentWeb);
                return true;
            }else if(id==2){//contact
                String x = getResources().getString(R.string.dbsN);
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+x));
                startActivity(intentCall);
                return true;
            }

        }else if(item.getGroupId()==1){ //ocbc
            if (item.getItemId() == 0) { //fav
                if(state[1]==0){
                    ocbc.setTextColor(Color.parseColor("#ff0303"));
                    state[1]=1;
                }else{
                    ocbc.setTextColor(Color.parseColor("#FF000000"));
                    state[1]=0;
                }
                return true;
            } else if (item.getItemId() == 1) {//web
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/personal-banking/"));
                startActivity(intentWeb);
                return true;
            }else if(item.getItemId()==2){//contact
                String x = getResources().getString(R.string.ocbcN);
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+x));
                startActivity(intentCall);
                return true;
            }
        }else if(item.getGroupId()==2){ //uob
            if (item.getItemId() == 0) { //fav
                if(state[2]==0){
                    uob.setTextColor(Color.parseColor("#ff0303"));
                    state[2]=1;
                }else{
                    uob.setTextColor(Color.parseColor("#FF000000"));
                    state[2]=0;
                }
                return true;
            } else if (item.getItemId() == 1) {//web
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg/personal/digital-banking/pib/index.page"));
                startActivity(intentWeb);
                return true;
            }else if(item.getItemId()==2){//contact
                String x = getResources().getString(R.string.uobN);
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+x));
                startActivity(intentCall);

                return true;
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();
        MenuItem menuI1 = optionsMenu.findItem(R.id.englishBtn);
        MenuItem menuI2 = optionsMenu.findItem(R.id.chineseBtn);

        if (id == R.id.englishBtn) {
            getSupportActionBar().setTitle(getResources().getString(R.string.app_name)); //overwrites text in actionbar for app title
            dbs.setText(getResources().getString(R.string.dbs));
            ocbc.setText(getResources().getString(R.string.ocbc));
            uob.setText(getResources().getString(R.string.uob));
            menuI1.setTitle(getResources().getString(R.string.english));
            menuI2.setTitle(getResources().getString(R.string.chinese));
            lang=1;

            return true;
        } else if (id == R.id.chineseBtn) {
            getSupportActionBar().setTitle(getResources().getString(R.string.appNameC)); //overwrites text in actionbar for app title
            dbs.setText(getResources().getString(R.string.dbsC));
            ocbc.setText(getResources().getString(R.string.ocbcC));
            uob.setText(getResources().getString(R.string.uobC));
            menuI1.setTitle(getResources().getString(R.string.englishC));
            menuI2.setTitle(getResources().getString(R.string.chineseC));
            lang = 2;
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
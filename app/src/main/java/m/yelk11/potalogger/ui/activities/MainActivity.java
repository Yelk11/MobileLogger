package m.yelk11.potalogger.ui.activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import m.yelk11.potalogger.R;



public class MainActivity extends AppCompatActivity {


    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar_taco);

        setSupportActionBar(myToolbar);

//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setCustomView(R.layout.toolbar);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);



//        AppBarConfiguration appBarConfiguration =
//                new AppBarConfiguration.Builder(navController.getGraph()).build();
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        NavigationUI.setupWithNavController(
//                toolbar, navController, appBarConfiguration);

    }



    @Override
    public boolean onSupportNavigateUp() {

        navController.navigateUp();
        return super.onSupportNavigateUp();
    }

}







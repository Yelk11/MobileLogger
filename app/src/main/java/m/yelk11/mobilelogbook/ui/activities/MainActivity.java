package m.yelk11.mobilelogbook.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Bundle;

import m.yelk11.mobilelogbook.R;
import m.yelk11.mobilelogbook.dbc.entity.Book;


public class MainActivity extends AppCompatActivity {


    private NavController navController;
    private Book curentBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);


        navController = Navigation.findNavController(this, R.id.nav_host_fragment);

    }



    @Override
    public boolean onSupportNavigateUp() {

        navController.navigateUp();
        return super.onSupportNavigateUp();
    }

    public Book getCurrentBook(){
        return new Book();
    }
    public void setCurrentBook(Book newBook){
        this.curentBook = newBook;
    }

}







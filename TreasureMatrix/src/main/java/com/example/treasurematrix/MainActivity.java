package com.example.treasurematrix;

import android.app.AlertDialog;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMatrix();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_new_game:
                initMatrix();
                return true;
            case R.id.action_about:
                AlertDialog.Builder aboutDialog = new AlertDialog.Builder(this);
                aboutDialog.setTitle("Treasure Matrix")
                           .setMessage( "An open source puzzle game.\n\n" +
                                        "neizod studio © 2013" )
                           .show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    // TODO: make they elegant in their own class.
    private int rows = 9;
    private int cols = 6;
    private int[][] matrix = { {  1,  1,  2,  4,  7, 11 },
                               {  1,  3,  3,  8, 17, 22 },
                               {  2,  5,  9, 15, 23, 23 },
                               {  3,  8, 12, 16, 29, 40 },
                               {  5, 18, 21, 23, 43, 55 },
                               {  8, 29, 38, 42, 61, 77 },
                               { 13, 32, 44, 63, 79, 82 },
                               { 21, 37, 51, 65, 83, 90 },
                               { 34, 46, 71, 88, 97, 99 } };
    private void initMatrix() {
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                int id = getResources().getIdentifier("button_" + i + j, "id", getPackageName());
                final String cell = Integer.toString(matrix[i][j]);
                final Button btn = (Button) findViewById(id);
                btn.setEnabled(true);
                btn.setText("");
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        btn.setEnabled(false);
                        btn.setText(cell);
                    }
                });
            }
        }
    }

}

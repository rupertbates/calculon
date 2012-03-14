package com.test.calculon;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import com.test.calculon.R;

public class MyActivity extends Activity implements AdapterView.OnItemClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView listView = (ListView) findViewById(android.R.id.list);
        ListAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_item, android.R.id.text1, new String[]{"One", "Two", "Three"});
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);
        Log.d("calculon.test", "on create");
    }

    public void onClick(View view){
        CharSequence text = ((TextView) view.findViewById(android.R.id.text1)).getText();
        ((TextView) findViewById(R.id.text)).setText(text);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.d("calculon.test", "Item clicked");
        CharSequence text = ((TextView) view.findViewById(android.R.id.text1)).getText();
        ((TextView) findViewById(R.id.text)).setText(text);
    }
}

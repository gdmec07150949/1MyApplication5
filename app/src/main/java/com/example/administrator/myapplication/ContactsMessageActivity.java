package com.example.administrator.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

/**
 * Created by yusiqing on 2016/10/27.
 */
public class ContactsMessageActivity  extends AppCompatActivity{
    private EditText nameEditText;
    private EditText mobileEditText;
    private EditText qqEditText;
    private EditText danweiEditText;
    private EditText addressEditText;
    private Uesr uesr;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_message);
        setTitle("联系人信息");
        nameEditText = (EditText) findViewById(R.id.name);
        mobileEditText = (EditText) findViewById(R.id.mobile);
        danweiEditText = (EditText) findViewById(R.id.danwei);
        qqEditText = (EditText) findViewById(R.id.qq);
        addressEditText = (EditText) findViewById(R.id.address);
        Bundle localBundle = getIntent().getExtras();
        int id = localBundle.getInt("user_ID");
        ContactsTable ct=new ContactsTable(this);

        uesr = ct.getUserByID(id);
        nameEditText.setText("姓名:"+uesr.getNAME());
        mobileEditText.setText("电话："+uesr.getMOBILE());
        danweiEditText.setText("单位："+uesr.getDANWEI());
        qqEditText.setText("QQ："+uesr.getQQ());
        addressEditText.setText("地址："+uesr.getADDRESS());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,1,Menu.NONE,"返回");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
package com.kiraz.smsgonderme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {

    List<Model> list;
    Context context;
    Activity activity;

    public Adapter(List<Model> list, Context context,Activity activity) {
        this.list = list;
        this.context = context;
        this.activity=activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.mesaj_listview_layout,viewGroup,false);
        final EditText editText=(EditText) view.findViewById(R.id.mesajIcerik);
        Button button=(Button) view.findViewById(R.id.buton);
        final TextView tel=(TextView) view.findViewById(R.id.tel);
        TextView isim=(TextView) view.findViewById(R.id.isim);

        tel.setText(list.get(i).getTel());
        isim.setText(list.get(i).getIsim());
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String mesajIcerik =editText.getText().toString();
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+tel));
                intent.putExtra("sms_body",mesajIcerik);
                activity.startActivity(intent);
            }
        });


        return view;
    }
}

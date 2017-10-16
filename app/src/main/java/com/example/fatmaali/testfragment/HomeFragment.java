package com.example.fatmaali.testfragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Fatma Ali on 30/09/2017.
 */

public class HomeFragment extends Fragment {
    ListView listViewHome;
    int images[] = {R.drawable.ic_info_24dp, R.drawable.ic_assignment_black_24dp, R.drawable.ic_pest_control1,
            R.drawable.ic_cleaning, R.drawable.ic_video_library_24dp, R.drawable.ic_contacts};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_home,container,false);
        listViewHome = (ListView)view1.findViewById(R.id.listHome);
        final String[] indexHome = getResources().getStringArray(R.array.indexHome);
        ArrayList<listitem> listImages = new ArrayList<>();
        for (int k = 0; k < indexHome.length; k++) {
            listImages.add(new listitem(k, images[k], indexHome[k]));
        }
        ListAdapter1 listAdapter = new ListAdapter1(listImages);
        listViewHome.setAdapter(listAdapter);
        listViewHome.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                for (int j = 0; j < indexHome.length; j++) {
                    if (i ==  R.id.nav_camera) {
                       Fragment f1 = new HomeFragment();
                    }
                    if (i == 1) {
                    }
                    if (i == 2) {

                    }
                    if (i == 3) {
                    }
                    if (i == 4) {
                    }
                    if (i == 5) {
                    }
                    if (i == 6) {
                    }
                }

            }
        });
        return view1;

    }
 private  void displaySelectedScreen(int id){
     Fragment fragment=null;
    switch(id){
        case R.id.nav_camera:
            fragment=new HomeFragment();
            break;
        case R.id.nav_gallery:
            fragment=new AboutUsFragment();
     }
     if (fragment !=null){

     }
 }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle(R.string.action_settings);

    }
    class ListAdapter1 extends BaseAdapter {
        ArrayList<listitem> list = new ArrayList<>();

        public ListAdapter1(ArrayList<listitem> listitems) {
            this.list = listitems;
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
            return i;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View view1 = layoutInflater.inflate(R.layout.row_item, null);
            TextView id = (TextView) view1.findViewById(R.id.textItemId);
            TextView title = (TextView) view1.findViewById(R.id.textItem);
            ImageView img = (ImageView) view1.findViewById(R.id.imageView_RowItem);
            id.setText(String.valueOf(list.get(i).id));
            title.setText(list.get(i).title);
            img.setImageResource(list.get(i).img);
            return view1;
        }
    }

    private void setLocal(String language) {
        Locale myLocale = new Locale(language);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        SharedPreferences preferences = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("lang", language);
        editor.commit();
        editor.putBoolean("isChooseLang", true);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }

    public void English(View view) {
        setLocal("en");
    }

    public void Arabic(View view) {
        setLocal("ar");
    }

}

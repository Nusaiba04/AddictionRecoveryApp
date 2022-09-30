package com.example.london;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
//import android.widget.Toast;


public class LifestyleActivity extends AppCompatActivity {



    public class ImageAdapterGridView extends BaseAdapter {
        private Context mContext;

        public ImageAdapterGridView(Context c) {
            mContext = c;
        }

        public int getCount() {
            return imageIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView mImageView;

            if (convertView == null) {
                mImageView = new ImageView(mContext);
                mImageView.setLayoutParams(new GridView.LayoutParams(500, 500));
                mImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                mImageView.setPadding(33, 10, 10, 10);
            } else {
                mImageView = (ImageView) convertView;
            }
            mImageView.setImageResource(imageIds[position]);
            return mImageView;
        }
    }




    // Array of strings...
    String[] lifestyleArray = {"Healthy Diet","Exercise","Meditation And Yoga"};
    String[] lifestyleArrayTexts = {"An eating plan that helps manage your weight includes a variety of healthy foods. Add an array of colors to your plate and think of it as eating the rainbow. Dark, leafy greens, oranges, and tomatoes—even fresh herbs—are loaded with vitamins, fiber, and minerals. Adding frozen peppers, broccoli, or onions to stews and omelets gives them a quick and convenient boost of color and nutrients.\n\n" +
            "Emphasizes fruits, vegetables, whole grains, and fat-free or low-fat milk and milk products\n\n" +
            "Includes a variety of protein foods such as seafood, lean meats and poultry, eggs, legumes (beans and peas), soy products, nuts, and seeds.\n\n" +
            "Is low in added sugars, sodium, saturated fats, trans fats, and cholesterol.\n\n" +
            "Stays within your daily calorie needs",
            "Exercise is the miracle cure we've always had, but for too long we've neglected to take our recommended dose. Our health is now suffering as a consequence.\n\n" +
                    "This is no snake oil. Whatever your age, there's strong scientific evidence that being physically active can help you lead a healthier and happier life.\n\n" +
                    "People who exercise regularly have a lower risk of developing many long-term (chronic) conditions, such as heart disease, type 2 diabetes, stroke, and some cancers.\n\n" +
                    "Research shows that physical activity can also boost self-esteem, mood, sleep quality and energy, as well as reducing your risk of stress, clinical depression, dementia and Alzheimer's disease.",
            "Yoga is an ancient spiritual practice from India that uses breath control, physical exercise, and meditative postures. The practice of yoga uses “asanas” or various physical poses to achieve a divine connection with the universe. In fact, the word yoga means “union” in Sanskrit. Some people refer to yoga as moving meditation, where you calm your mind and create awareness through doing the poses."};
//    String[] laptopArray = getResources().getStringArray(R.array.laptops);

    ArrayAdapter adapter;

    int imageIds[]={R.drawable.balanced_diet_hero_image,R.drawable.exercise_image,
            R.drawable.relaxation,R.drawable.hobbies_image};
    String arr1[]={"Healthy Diet","Exercise","Meditation And Yoga"};

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifestyle);

        adapter = new ArrayAdapter<String>(this, R.layout.grid_view_item, lifestyleArray);

        gridView = findViewById(R.id.gridViewID);

        gridView.setAdapter(new ImageAdapterGridView(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), "You clicked " + deviceArray[position] + "!", Toast.LENGTH_SHORT).show();


                if(position==3){
                    Intent intent0 = new Intent(LifestyleActivity.this, HobbiesActivity.class);
                    startActivity(intent0);
                }
                else {
                    Intent intent = new Intent(LifestyleActivity.this, com.example.london.LifestyleDetailsActivity.class);
                    intent.putExtra("keyName", lifestyleArray[position]);
                    intent.putExtra("keyText", lifestyleArrayTexts[position]);


                    startActivity(intent);
                }
            }
        });

    }

}


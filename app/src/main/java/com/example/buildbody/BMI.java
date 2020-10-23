package com.example.buildbody;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class BMI extends AppCompatActivity {

    EditText height,weight;
    TextView result,before,breakfast,lunch,tea,dinner,bedtime,work;
    Button button;
    String bmiLabel = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        initialise();
        setListener();
    }

    public void initialise(){
        height = findViewById(R.id.height);
        weight =  findViewById(R.id.weight);
        result=findViewById(R.id.bmiresult);
        button =  findViewById(R.id.button);
        before = findViewById(R.id.before);
        breakfast =  findViewById(R.id.breakfast);
        lunch=findViewById(R.id.lunch);
        tea =  findViewById(R.id.tea);
        work=findViewById(R.id.work);
        dinner=findViewById(R.id.dinner);
        bedtime =  findViewById(R.id.bedtime);

    }
    public void setListener(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String heightStr = height.getText().toString();
                String weightStr = weight.getText().toString();

                if (heightStr != null && !"".equals(heightStr)
                        && weightStr != null && !"".equals(weightStr)) {
                    float heightValue = Float.parseFloat(heightStr) / 100;
                    float weightValue = Float.parseFloat(weightStr);

                    float bmi = weightValue / (heightValue * heightValue);

                    displayBMI(bmi);


                }
            }
        });
    }

    private void displayBMI(float bmi) {

        if (Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = "Underweight";
        } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 24.9f) <= 0) {
            bmiLabel = "Normal";
        } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 29.9f) <= 0) {
            bmiLabel = "Overweight";
        }
        else {
            bmiLabel = "Obese";
        }

        String result1 = bmi + "\n" + bmiLabel;
        result.setText(result1);
        diet(bmiLabel);
    }

    public void diet(String bmiLabel){
        if("underweight".equalsIgnoreCase(bmiLabel)){

            before.setText("1 cup of tea or coffee with \nfull-cream milk,2 t of sugar \nand 2 biscuits.");
            breakfast.setText("Fruit or fruit juice, cereal with \nmilk and sugar, boiled egg or \nbacon or sausage wholewheat \ntoast or roll with butter \nand jam beverage ");
            lunch.setText("Soup,meat,fish or poultry potato\nvegetable or salad with dressing\n,pudding,roll with butter and \ncheese,beverage");
            tea.setText("Sandwiches with filling or cake or \nbiscuits tea with milk and sugar.");
            dinner.setText("Fruit juice,meat or fish or \ncheese or eggs vegetable or \nsalad with dressing,starch, \npudding, beverage");
            bedtime.setText("Milk drink , biscuits");
            work.setText("1. Strength Training\n2. Cardiovascular Exercise\n3. Diet Considerations");

        }
        else if(bmiLabel.equalsIgnoreCase("Normal")){
            before.setText("3 whole eggs \n 3 egg whites.");
            breakfast.setText("8 oz. low-fat cottage \ncheese + 1 cup sliced \npineapple, 6 whole-wheat crackers \n+ 1 Tbsp. peanut butter");
            lunch.setText("8 oz. turkey deli meat\n4 slices whole-wheat bread\n(make sandwiches; feel free to \nadd low-fat mayoe and/or \nmustard) 2 cups green salad \n+2 Tbsp. low-fat balsamic \nvinaigrette");
            tea.setText("Sandwiches with filling or cake or \nbiscuits tea with milk and sugar.");
            dinner.setText("8 oz. top sirloin \n1 large sweet potato \n1 cup chopped broccoli");
            bedtime.setText("Milk drink , biscuits");
            work.setText("1. 30-40 mins full body workout\n2. Deck of cards workout\n3. Optional targeted workouts");
        }
        else if(bmiLabel.equalsIgnoreCase("Overweight")){
            before.setText("1 cup of tea or coffee made \nfrom low fat skimmed milk \n2 fibre-rich biscuits.");
            breakfast.setText("fresh fruit such as \nan apple or orange \nsprouted moong with poha or upma");
            lunch.setText("Homemade dal or legumes\nroti, veggies with soup and \nsalad and raita or curd.");
            tea.setText("Protein shake, nuts and seeds,\nveg sandwich or milk and apple.");
            dinner.setText("Dal, veggies, with brown rice or \nroti and vegetable soup");
            bedtime.setText("Milk drink , biscuits");
            work.setText("1. Walking\n2. Aqua Jogging\n3. Group classes exercises");

        }
        else if(bmiLabel.equalsIgnoreCase("Obese")){
            before.setText("1 cup of tea or coffee made \nfrom low fat skimmed milk \n2 fibre-rich biscuits.");
            breakfast.setText("fresh fruit such as \nan apple or orange \nsprouted moong with poha or upma");
            lunch.setText("Homemade dal or legumes\nroti, veggies with soup and \nsalad and raita or curd.");
            tea.setText("Protein shake, nuts and seeds,\nveg sandwich or milk and apple.");
            dinner.setText("Dal, veggies, with brown rice or \nroti and vegetable soup");
            bedtime.setText("Milk drink , biscuits");
            work.setText("1. Walking\n2. Aqua Jogging\n3. Group classes exercises");
        }
    }
}

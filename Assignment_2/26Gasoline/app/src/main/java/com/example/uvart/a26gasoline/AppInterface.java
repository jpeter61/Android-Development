package com.example.uvart.a26gasoline;

import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class AppInterface extends RelativeLayout {
    //Interaction
    private EditText priceText;
    private EditText gallonsText;
    private TextView costText;
    private Button button;

    public AppInterface(Context context){
        super(context);
        //Get DP value
        final int DP = (int)(getResources().getDisplayMetrics().density);

        //Price Label
        TextView priceLabel = new TextView(context);
        priceLabel.setId(TextView.generateViewId());
        priceLabel.setTextColor(Color.parseColor("#000000"));
        priceLabel.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        priceLabel.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        priceLabel.setText("Price");
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(0,0);
        params.width = LayoutParams.WRAP_CONTENT;
        params.height = LayoutParams.WRAP_CONTENT;
        params.leftMargin = 20*DP;
        params.topMargin = 20*DP;
        priceLabel.setLayoutParams(params);
        addView(priceLabel);

        //price input
        priceText = new EditText(context);
        priceText.setId(EditText.generateViewId());
        priceText.setTextColor(Color.parseColor("#000000"));
        priceText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        priceText.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        priceText.setHint("0.0");
        priceText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        params = new RelativeLayout.LayoutParams(0, 0);
        params.width = LayoutParams.WRAP_CONTENT;
        params.height = LayoutParams.WRAP_CONTENT;
        params.addRule(RelativeLayout.RIGHT_OF, priceLabel.getId());
        params.addRule(RelativeLayout.ALIGN_BOTTOM, priceLabel.getId());
        priceText.setLayoutParams(params);
        addView(priceText);

        //Gallons Label
        TextView gallonsLabel = new TextView(context);
        gallonsLabel.setId(TextView.generateViewId());
        gallonsLabel.setTextColor(Color.parseColor("#000000"));
        gallonsLabel.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        gallonsLabel.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        gallonsLabel.setText("Gallons");
        params = new RelativeLayout.LayoutParams(0,0);
        params.width = LayoutParams.WRAP_CONTENT;
        params.height = LayoutParams.WRAP_CONTENT;
        params.addRule(RelativeLayout.BELOW, priceLabel.getId());
        params.addRule(RelativeLayout.ALIGN_LEFT, priceLabel.getId());
        gallonsLabel.setLayoutParams(params);
        addView(gallonsLabel);

        //gallons input
        gallonsText = new EditText(context);
        gallonsText.setId(EditText.generateViewId());
        gallonsText.setTextColor(Color.parseColor("#000000"));
        gallonsText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        gallonsText.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        gallonsText.setHint("0");
        gallonsText.setInputType(InputType.TYPE_CLASS_NUMBER);
        params = new RelativeLayout.LayoutParams(0, 0);
        params.width = LayoutParams.WRAP_CONTENT;
        params.height = LayoutParams.WRAP_CONTENT;
        params.addRule(RelativeLayout.RIGHT_OF, gallonsLabel.getId());
        params.addRule(RelativeLayout.ALIGN_BOTTOM, gallonsLabel.getId());
        gallonsText.setLayoutParams(params);
        addView(gallonsText);

        //Cost label
        TextView costLabel = new TextView(context);
        costLabel.setId(TextView.generateViewId());
        costLabel.setTextColor(Color.parseColor("#000000"));
        costLabel.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        costLabel.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        costLabel.setText("Cost");
        params = new RelativeLayout.LayoutParams(0,0);
        params.width = LayoutParams.WRAP_CONTENT;
        params.height = LayoutParams.WRAP_CONTENT;
        params.addRule(RelativeLayout.BELOW, gallonsLabel.getId());
        params.addRule(RelativeLayout.ALIGN_LEFT, gallonsLabel.getId());
        costLabel.setLayoutParams(params);
        addView(costLabel);

        //Cost output
        costText = new TextView(context);
        costText.setId(TextView.generateViewId());
        costText.setTextColor(Color.parseColor("#000000"));
        costText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        costText.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        costText.setText("$0.00");
        params = new RelativeLayout.LayoutParams(0, 0);
        params.width = LayoutParams.WRAP_CONTENT;
        params.height = LayoutParams.WRAP_CONTENT;
        params.addRule(RelativeLayout.RIGHT_OF, costLabel.getId());
        params.addRule(RelativeLayout.ALIGN_BOTTOM, costLabel.getId());
        costText.setLayoutParams(params);
        addView(costText);

        //Button
        button = new Button(context);
        button.setId(Button.generateViewId());
        button.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        button.setText("Submit");
        params = new RelativeLayout.LayoutParams(0,0);
        params.width = LayoutParams.WRAP_CONTENT;
        params.height = LayoutParams.WRAP_CONTENT;
        params.topMargin = 40*DP;
        params.addRule(RelativeLayout.BELOW, costLabel.getId());
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        button.setLayoutParams(params);
        addView(button);
    }
    //Set Button Listener
    public void setEventHandlers(View.OnClickListener buttonHandler){
        button.setOnClickListener(buttonHandler);
    }
    //Get price
    public float getPrice(){
        String priceString = priceText.getText().toString();
        float price;
        try{
            price = Float.parseFloat(priceString);
        }catch (NumberFormatException e){
            price =(float) 0.0;
        }
        return price;
    }
    //Get gallons
    public int getGallons(){
        String gallonsString = gallonsText.getText().toString();
        int gallons;
        try{
            gallons = Integer.parseInt(gallonsString);
        }catch (NumberFormatException e){
            gallons = 0;
        }
        return gallons;
    }
    //Set Cost
    public void setCost(float cost){
        costText.setText("$"+cost);
    }
}

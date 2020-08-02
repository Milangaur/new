package com.example.new2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class payment extends AppCompatActivity implements PaymentResultListener {

    private EditText orderamount;
    private static final String TAG = payment.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Button startpayment = findViewById(R.id.start_payment);
        orderamount = findViewById(R.id.order_amount);
        Checkout.preload(getApplicationContext());
        startpayment.setOnClickListener(new View.OnClickListener() {
           @Override
        public void onClick(View view) {
            if (orderamount.getText().toString().equals(""))
            { Toast.makeText(payment.this, "Amount is empty", Toast.LENGTH_LONG).show(); }
            else
                { startPayment(); }
        }
        });
    }

    public void startPayment() {
        Checkout checkout = new Checkout();

        /**
         * Reference to current activity
         */
        final Activity activity = this;

        /**
         * Pass your payment options to the Razorpay Checkout as a JSONObject
         */
        try {
            JSONObject options = new JSONObject();
            options.put("name", "Merchant Name");
            options.put("description", "Reference No. #123456");
            options.put("currency", "INR");
            options.put("amount", "50000");//pass amount in currency subunits
            String paymentnow = orderamount.getText().toString();
            // amount is in paise so please multiple it by 100
            //Payment failed Invalid amount (should be passed in integer paise. Minimum value is 100 paise, i.e. ₹ 1)
            double total = Double.parseDouble(paymentnow);
            total = total * 100;
            options.put("amount", total);

            JSONObject preFill = new JSONObject();
            preFill.put("email", "kamal.bunkar07@gmail.com");
            preFill.put("contact", "9144040888");

            options.put("prefill", preFill);
            checkout.open(activity, options);
        } catch(Exception e)
        { Log.e(TAG, "Error in starting Razorpay Checkout", e); }
    }


    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText(payment.this, "Payment successfully done! " +s, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPaymentError(int i, String s) {
        Log.e(TAG,  "error code "+String.valueOf(i)+" -- Payment failed "+s.toString()  );
        try {
            Toast.makeText(payment.this, "Payment error please try again", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Log.e("OnPaymentError", "Exception in onPaymentError", e);
        }

    }
}

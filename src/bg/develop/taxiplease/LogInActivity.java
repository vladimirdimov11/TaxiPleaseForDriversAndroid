package bg.develop.taxiplease;

import java.util.HashMap;

import org.json.JSONObject;

import bg.develop.taxiplease.config.AppController;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class LogInActivity extends Activity {

	EditText etEmail, etPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

	}

	public void Login(View v) {
		
		// Tag used to cancel the request
		String tag_json_obj = "json_obj_req";
		 
		String url = "http://api.androidhive.info/volley/person_object.json";
		         
		final ProgressDialog pDialog = new ProgressDialog(this);
		pDialog.setMessage("Loading...");
		pDialog.show();     
		         
		        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.POST,
		                url, null,
		                new Response.Listener<JSONObject>() {
		 
		                    @Override
		                    public void onResponse(JSONObject response) {
		                        Log.d("RESPONSE TAG", response.toString());
		                        pDialog.hide();
		                    }
		                }, new Response.ErrorListener() {
		 
		                    

							@Override
							public void onErrorResponse(VolleyError error) {
								// TODO Auto-generated method stub
								VolleyLog.d("ERROR TAG", "Error: " + error.getMessage());
		                        pDialog.hide();
							}
		                }) {
		 
		            @Override
		            protected HashMap<String, String> getParams() {
		            	HashMap<String, String> params = new HashMap<String, String>();
		                params.put("name", "Androidhive");
		                params.put("email", "abc@androidhive.info");
		                params.put("password", "password123");
		 
		                return params;
		            }
		 
		        };
		        
		        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
		        
//		Intent map = new Intent(getApplicationContext(), Map.class);
//		map.putExtra("latitude", (float)43.117024);
//		map.putExtra("longitude", (float)27.308578);
//		startActivity(map);
	}
	
	public void RegisterDriver(View v) {
		Intent map = new Intent(getApplicationContext(), RegisterDriverActivity.class);
		startActivity(map);
	}

}

package pl.krzysztofsikora.thugsoundbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import static com.facebook.FacebookSdk.getApplicationContext;


public class Tab1Welcome extends Fragment {

    CallbackManager callbackManager;
    private Context mContext;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext = container.getContext();
        facebookSDKInitialize();

        View rootView = inflater.inflate(R.layout.tab1welcome, container, false);

        LoginButton loginButton = (LoginButton) rootView.findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");
        getLoginDetails(loginButton);


        return rootView;





    }

    @Override
    public void onResume() {
        super.onResume();
        // Logs 'install' and 'app activate' App Events.<br />
        AppEventsLogger.activateApp(mContext);
    }


    @Override
    public void onPause() {
        super.onPause();
        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(mContext);
    }



    protected void facebookSDKInitialize() {
        FacebookSdk.sdkInitialize(mContext);
        callbackManager = CallbackManager.Factory.create();
    }



    /*
     Register a callback function with LoginButton to respond to the login result.
    */
    protected void getLoginDetails(LoginButton login_button){
        Log.d("getLoginDetails","ready");

        // Callback registration
        login_button.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult login_result) {
                Log.d("onSuccess","ready");
//                Intent intent = new Intent(mContext, Tab2Sound.class);
//                startActivity(intent);
            }
            @Override
            public void onCancel() {
                Log.d("onCancel","ready");

                // code for cancellation
            }
            @Override
            public void onError(FacebookException exception) {
                Log.d("onError","ready");
                //  code to handle error
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        Log.e("data",data.toString());
    }

}

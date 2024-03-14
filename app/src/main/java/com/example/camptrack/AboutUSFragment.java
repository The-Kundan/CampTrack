package com.example.camptrack;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;


public class AboutUSFragment extends Fragment {

     private WebView webView;
    private ProgressBar pgBar;

    public AboutUSFragment() {
        // Required empty public constructor
    }

    public void onViewCreated( View view,  Bundle savedInstanceState) {
        webView = view.findViewById(R.id.webView);
        pgBar = view.findViewById(R.id.pgBar);

        webView.loadUrl("https://www.cgc.ac.in/");
        webView.setWebViewClient(new WebViewClient()
        {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                return super.shouldOverrideUrlLoading(view, request);
//            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                pgBar.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                pgBar.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about_u_s, container, false);
    }
}
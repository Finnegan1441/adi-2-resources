package generalassembly.yuliyakaleda.usabilitytestingstartercode;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class DetailsFragment extends Fragment {
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //TODO: Inflate the view and change the return type;
        view = inflater.inflate(R.layout.details_fragment_layout, container, false);

        return view;
    }

    public void updateContent(String sign) {
        // TODO: Finish the method which will open a webview and redirect the user to the website
        // TODO: to read about the sign that was clicked in the ListView

        WebView webView = (WebView) view.findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new webClient());

        webView.loadUrl(sign);


    }


    private class webClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            return false;

        }
    }
}

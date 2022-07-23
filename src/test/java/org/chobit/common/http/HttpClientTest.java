package org.chobit.common.http;

import org.apache.http.HttpHost;
import org.junit.Test;

/**
 * @author robin
 */
public class HttpClientTest {



    @Test
    public void proxy(){
        String proxyHost = "127.0.0.1";
        int proxyPort = 1081;

        String url = "https://www.google.com/";
        HttpHost proxy = new HttpHost(proxyHost, proxyPort);

        HttpResult result = HttpClient.get(url, proxy);
        System.out.println(result.getContent());

    }



}

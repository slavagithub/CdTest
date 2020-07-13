import org.apache.http.HttpEntity
import org.apache.http.HttpHeaders
import org.apache.http.client.methods.CloseableHttpResponse
import org.apache.http.client.methods.HttpGet
import org.apache.http.conn.ssl.TrustSelfSignedStrategy
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClientBuilder
import org.apache.http.impl.client.HttpClients
import org.apache.http.ssl.SSLContextBuilder
import org.apache.http.util.EntityUtils

import javax.net.ssl.HostnameVerifier
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.X509TrustManager
import java.security.KeyStore

@Grab(group='com.squareup.okhttp3', module='okhttp', version='4.4.1')
@Grab(group='org.apache.httpcomponents', module='httpclient', version='4.5.12')



public static void main(String[] args) {

//    ConfigFilesManager.addRulesPackages("OmniExpress2",     "oe2.333,oe2.111.888.hoop.rt")

    println "hello"
    doSsl()

    def UpdateDetails details = new UpdateDetails()
    details.lob = "NEW_GOOD"
    details.rulesPackages = ["adsf.sdf.s","sdf2.sdf.sdf2"]
    details.email = "AGOOD_DL"
    details.copyServersFromLob = "UHCCS"

    IConfigProcessor grs = new JsonIConfig_Routing_GRS()
//    grs.setContent(new File('C:\\Slava\\repositories\\getter\\data\\JsonConfig_Routing_GRS.json').text)

    def configProcessors = [grs]

//    new RoutingProcessor()]//[new RoutingRulesListProcessor(), new AnotherProcessor()]

//    for(nextProcessor in configProcessors){
//        nextProcessor.setUpdateDetails(details)
//        nextProcessor.setContent(Getter.getConfig().toString())
//        nextProcessor.updateContent()
//        def updatedContent = nextProcessor.getUpdated()
//        def content = new JsonBuilder(updatedContent).toPrettyString()
//        def prettifiedContent = content.replaceAll("\n","\\\\n")
//        prettifiedContent = prettifiedContent.replaceAll("\"", '\\\\"')
//        Getter.saveConfig(prettifiedContent)
//        println updatedContent
//    }




//  \n
//   def content = """{"AA1"
//:BBD}"""
//////    println " {\"config\": {\"stapler-class\": \"org.jenkinsci.plugins.configfiles.json.JsonConfig\", \"id\": \"e87b8ccb-d30e-4b2c-9018-2d759c4383a7\", \"providerId\": \"org.jenkinsci.plugins.configfiles.json.JsonConfig\", \"name\": \"JsonConfig\", \"comment\": \"\", \"content\":${content}, \"Jenkins-Crumb\": \"117486bb7d8e2a49d688968be1d85d682267bbdc73470d646201321f53dfddb7\"}"
//    def prettifiedContent = content.replaceAll("\n","\\\\n")
//    prettifiedContent = prettifiedContent.replaceAll("\"", '\\\\"')
//    Getter.saveConfig(prettifiedContent)

//    Getter.saveConfig(""" {[RULE_APP_LISTS:[AARPHealth_AppName:[AARPHealth], AOF_AppName:[AOF], COVID19_AppName:[WIN]}""")
}

static doSsl(){

    def username = "Slava"
    def password = "11e110cc052863bb70d5775e14888c2718"
    TrustManager[] trustAllCerts = new TrustManager[1]
    trustAllCerts[0] = new TrustManager()
    SSLContext sc = SSLContext.getInstance("SSL");
    sc.init(null, trustAllCerts, new java.security.SecureRandom());
    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

    def json = "http://localhost:8080/job/Routing%20Engeniering/job/addJob/config.xml".toURL().
            getText(requestProperties: [Accept: 'application/json', Authorization:  "Basic ${"$username:$password".bytes.encodeBase64()}"])
    println json
}

static doRequest(){
//    CloseableHttpClient httpClient = HttpClients.createDefault();
//    @Grab(group='org.apache.httpcomponents', module='httpclient', version='4.5.12')

    HttpClientBuilder cb = HttpClientBuilder.create();
    SSLContextBuilder sslcb = new SSLContextBuilder();
    sslcb.loadTrustMaterial(KeyStore.getInstance(KeyStore.getDefaultType()), new TrustSelfSignedStrategy());
    cb.setSslcontext(sslcb.build());
    CloseableHttpClient httpClient = cb.build();

    def username = "Slava"
    def password = "11e110cc052863bb70d5775e14888c2718"

    try {

        HttpGet request = new HttpGet("http://localhost:8080/job/Routing%20Engeniering/job/addJob/config.xml");

        // add request headers
        request.addHeader("custom-key", "mkyong");
        request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");
        request.addHeader("Authorization",  "Basic ${"$username:$password".bytes.encodeBase64()}")


        CloseableHttpResponse response = httpClient.execute(request);

        try {

            // Get HttpResponse Status
            System.out.println(response.getProtocolVersion());              // HTTP/1.1
            System.out.println(response.getStatusLine().getStatusCode());   // 200
            System.out.println(response.getStatusLine().getReasonPhrase()); // OK
            System.out.println(response.getStatusLine().toString());        // HTTP/1.1 200 OK

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }

        } finally {
            response.close();
        }
    } finally {
        httpClient.close();
    }

}

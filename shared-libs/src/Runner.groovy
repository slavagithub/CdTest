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
//    doSsl()

    addJob()


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
//        def prettifiedContent = content.replaceAll("","\\\")
//        prettifiedContent = prettifiedContent.replaceAll("\"", '\\\\"')
//        Getter.saveConfig(prettifiedContent)
//        println updatedContent
//    }




//  
//   def content = """{"AA1"
//:BBD}"""
//////    println " {\"config\": {\"stapler-class\": \"org.jenkinsci.plugins.configfiles.json.JsonConfig\", \"id\": \"e87b8ccb-d30e-4b2c-9018-2d759c4383a7\", \"providerId\": \"org.jenkinsci.plugins.configfiles.json.JsonConfig\", \"name\": \"JsonConfig\", \"comment\": \"\", \"content\":${content}, \"Jenkins-Crumb\": \"117486bb7d8e2a49d688968be1d85d682267bbdc73470d646201321f53dfddb7\"}"
//    def prettifiedContent = content.replaceAll("","\\\")
//    prettifiedContent = prettifiedContent.replaceAll("\"", '\\\\"')
//    Getter.saveConfig(prettifiedContent)

//    Getter.saveConfig(""" {[RULE_APP_LISTS:[AARPHealth_AppName:[AARPHealth], AOF_AppName:[AOF], COVID19_AppName:[WIN]}""")
}

static addJob(){
    def initialSize = 4096
    def out = new ByteArrayOutputStream(initialSize)
    def err = new ByteArrayOutputStream(initialSize)
    def xmlbody = """<?xml version='1.1' encoding='UTF-8'?>
<flow-definition plugin="workflow-job@2.39">
    <actions>
        <org.jenkinsci.plugins.pipeline.modeldefinition.actions.DeclarativeJobAction plugin="pipeline-model-definition@1.7.0"/>
        <org.jenkinsci.plugins.pipeline.modeldefinition.actions.DeclarativeJobPropertyTrackerAction plugin="pipeline-model-definition@1.7.0">
            <jobProperties/>
            <triggers/>
            <parameters>
                <string>BuildConfiguration</string>
            </parameters>
            <options/>
        </org.jenkinsci.plugins.pipeline.modeldefinition.actions.DeclarativeJobPropertyTrackerAction>
    </actions>
    <description>h</description>
    <keepDependencies>false</keepDependencies>
    <properties>
        <hudson.model.ParametersDefinitionProperty>
            <parameterDefinitions>
                <hudson.model.StringParameterDefinition>
                    <name>BuildConfiguration</name>
                    <description>Configuration to build (Debug/Release/...)</description>
                    <defaultValue>Release</defaultValue>
                    <trim>false</trim>
                </hudson.model.StringParameterDefinition>
            </parameterDefinitions>
        </hudson.model.ParametersDefinitionProperty>
    </properties>
    <definition class="org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition" plugin="workflow-cps@2.80">
        <script>import groovy.json.JsonSlurper

            static void doit(String[] args) {
            //    Example.sum(5, 8)
            //     sum(5, 7)
            def jsonSlurper = new JsonSlurper()
            def object = jsonSlurper.parseText(&apos;{ &quot;name&quot;: &quot;John Doe&quot;, &quot;sdk&quot;:[&quot;marvel&quot;, &quot;lamer&quot;] }&apos;)
            object.sdk.add(&quot;another&quot;)
            object.put(&quot;AnotherPackage&quot;,Eval.me(&quot;[&apos;one&apos;,&apos;two&apos;]&quot;))
            println object;

            }

            pipeline {
            agent any;
            parameters {
            string( name: &apos;BuildConfiguration&apos;,
            defaultValue: &apos;Release&apos;,
            description: &apos;Configuration to build (Debug/Release/...)&apos;)
            list( name: &apos;BuildConfiguration1&apos;,
            defaultValue: &apos;Release1&apos;,
            description: &apos;Configuration to build (Debug/Release/...)&apos;)
            }

            stages {
            stage(&apos;Build&apos;) {
            steps {
            echo &quot;Building configuration: &quot; + params.BuildConfiguration
            }
            }
            stage(&apos;Test&apos;){
            steps{
            doit();
            }
            }
            }


            }
            echo &quot;Building configuration: &quot; + params.BuildConfiguration</script>
        <sandbox>true</sandbox>
    </definition>
    <triggers/>
    <disabled>false</disabled>
</flow-definition>"""


def proc = [ "curl","--location","-v","-k","-X","POST","-H", "Content-Type: application/xml","-d", "@config.xml","http://Slava:11e110cc052863bb70d5775e14888c2718@localhost:8080/job/Routing/job/DEV2Deploy/createItem?name=Ao2" ].execute()

    proc.consumeProcessOutput(out, err)
    proc.waitFor()
    println out
    println err
    writeToFile("config.xml",xmlbody)
}

static void writeToFile(def fileName, def content) {
    new File("$fileName").write(content)
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

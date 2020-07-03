@Grab(group='com.squareup.okhttp3', module='okhttp', version='4.4.1')

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response


class JobCreator{

    static String getNewJobXml(String dir, String subDir, String name, String lob, String email){

        String content = getJobXml(dir, subDir, name)
        return replaceFields(content, lob, email)

    }
    static replaceFields(String content, String lob, String email){

        def replacedWithLobName = content.replaceAll("first commit", lob)
        def contentWithEmailSet = replacedWithLobName.replaceAll("README", email)
        return contentWithEmailSet
    }

    static String getJobXml(String dir, String subDir, String name){
        def username = "Slava"
        def password = "11e110cc052863bb70d5775e14888c2718"
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http://localhost:8080/job/${dir}/job/${subDir}/job/${name}/config.xml")
                .method("GET", null)
                .addHeader("Cookie", "JSESSIONID.b1305f6e=node016bienql94kr62spbibbh9v7p5.node0")
                .addHeader("Authorization",  "Basic ${"$username:$password".bytes.encodeBase64()}")
                .build();
        Response response = client.newCall(request).execute();

        return response.body().string()
    }
    static String addJob(String folderName, String subFolderName, String name, String lob, String email){
        def jenkins = Jenkins.instance
        def item = jenkins.getItemByFullName("JF")
        def workspacePath = jenkins.getWorkspaceFor (item)

        String content = getNewJobXml(folderName, subFolderName, name, lob, email)

        def xmlStream = new ByteArrayInputStream(content.getBytes( 'UTF-16' ) )

        def folder = jenkins.getItem(folderName)
        def subFolder = folder.getItem(subFolderName)

        def newName = name.replaceAll("New", "Existing")

        subFolder.createProjectFromXML(newName, xmlStream)
        return newName+ " job successfully created"
    }

    static String(){
        return """<?xml version='1.1' encoding='UTF-8'?>
<flow-definition plugin="workflow-job@2.39">
  <actions>
    <org.jenkinsci.plugins.pipeline.modeldefinition.actions.DeclarativeJobAction plugin="pipeline-model-definition@1.7.0"/>
    <org.jenkinsci.plugins.pipeline.modeldefinition.actions.DeclarativeJobPropertyTrackerAction plugin="pipeline-model-definition@1.7.0">
      <jobProperties/>
      <triggers/>
      <parameters>
        <string>name</string>
      </parameters>
      <options/>
    </org.jenkinsci.plugins.pipeline.modeldefinition.actions.DeclarativeJobPropertyTrackerAction>
  </actions>
  <description></description>
  <keepDependencies>false</keepDependencies>
  <properties>
    <hudson.model.ParametersDefinitionProperty>
      <parameterDefinitions>
        <hudson.model.StringParameterDefinition>
          <name>name</name>
          <description>Repository name</description>
          <defaultValue>tests</defaultValue>
          <trim>false</trim>
        </hudson.model.StringParameterDefinition>
      </parameterDefinitions>
    </hudson.model.ParametersDefinitionProperty>
  </properties>
  <definition class="org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition" plugin="workflow-cps@2.80">
    <script>pipeline {
    agent any
    parameters {
        string( name: &apos;name&apos;,
                defaultValue: &apos;tests&apos;,
                description: &apos;Repository name&apos;)
     }
    environment {
        password = &quot;QXNkZmdoMTk4MA==&quot;
    }

    stages {
        stage(&apos;Create new repo&apos;) {
            steps {

                addRepo(decrypt(env.password), params.name.split(&apos;,&apos;))

            }
        }
    }
}

def addRepo(pass, list) {
    list.each { item -&gt;
        bat &quot;&quot;&quot;
                    mkdir ${item}
                    cd ${item}
                    dir
                    echo # ${item} &gt;EMAIL.md
                    echo ${item} repository &gt;&gt;EMAIL.md
                    git init
                    git add -A
                    git commit -m \\&quot;LOB\\&quot;
                    git remote add origin https://slava.pl1980:${pass}@gitlab.com/slava.pl1980/${item}
                    git push -u origin master
                    &quot;&quot;&quot;
    }
}
static String decrypt(String s){
    byte[] decrypted = s.decodeBase64()
    return new String(decrypted)
}</script>
    <sandbox>true</sandbox>
  </definition>
  <triggers/>
  <disabled>false</disabled>
</flow-definition>"""
    }
}

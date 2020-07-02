import groovy.json.JsonSlurper
import jenkins.model.*
import java.util.Map
import jenkins.*
import hudson.*
import hudson.model.*


static String getPaht(){

    def jenkins = Jenkins.instance
    def item = jenkins.getItemByFullName("JF")
    println item
// get workspacePath for the job Item
    def workspacePath = jenkins.getWorkspaceFor (item)
    println workspacePath

    def file = new File(workspacePath.toString()+"\\myjob.xml")


    def xmlStream = new ByteArrayInputStream( file.getBytes() )



    Jenkins.instance.createProjectFromXML("my-new-job", xmlStream)


    return "PATH IS "+sourceUri.toString()

}

static void doJob(){


    def version = readFile "myjob.xml"

    @SourceURI
    URI sourceUri
    println "PATH IS"
    println sourceUri.toString()

    def jobName = "my-new-job"
    def configXml = new File( "myjob.xml").text

    def xmlStream = new ByteArrayInputStream( configXml.getBytes() )

    Jenkins.instance.createProjectFromXML(jobName, xmlStream)
}

pipeline {
    agent any;
    parameters {
        string( name: 'BuildConfiguration',
                defaultValue: 'Release',
                description: 'Configuration to build (Debug/Release/...)')
        string( name: 'BuildConfiguration1',
                defaultValue: 'Release1',
                description: 'Configuration to build (Debug/Release/...)')
    }

    stages {
        stage('Build') {
            steps {
                echo "Building configuration: " + params.BuildConfiguration
            }
        }
        stage('Test'){
            steps{
                echo getPaht()
            }
        }
        stage('Git'){
            steps{
                bat("dir")
            }
        }


    }


}
echo "Building configuration: " + params.BuildConfiguration
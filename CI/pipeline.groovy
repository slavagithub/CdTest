import groovy.json.JsonSlurper
import jenkins.model.*
import groovy.transform.SourceURI
import java.util.Map
import jenkins.*
import hudson.*
import hudson.model.*   

static void doit(String[] args) {
//    Example.sum(5, 8)
//     sum(5, 7)
    def jsonSlurper = new JsonSlurper()
    def object = jsonSlurper.parseText('{ "name": "John Doe", "sdk":["marvel", "lamer"] }')
    object.sdk.add("another")
    object.put("AnotherPackage",Eval.me("['one','two']"))
    println object;

}

static String getPaht(){
@SourceURI
URI sourceUri
println "PATH IS"

try{
//get Jenkins instance
    def jenkins = Jenkins.instance
//get job Item
    def item = jenkins.getItemByFullName("The_JOB_NAME")
    println item
// get workspacePath for the job Item
    def workspacePath = jenkins.getWorkspaceFor (item)
    println workspacePath

    def file = new File(workspacePath.toString()+"\\myjob.xml")


} catch (Exception ex){
    println ex.message
}


return "PATH IS "+sourceUri.toString()

}

static void doJob(){


def version = readFile "myjob.xml"

@SourceURI
URI sourceUri
println "PATH IS"
println sourceUri.toString()

def jobName = "my-new-job"
def configXml = new File( "${env.WORKSPACE}/myjob.xml").text 

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
		
		stage('New job'){
		steps{

		doJob()

		}
		}
  }
  
  
}
  echo "Building configuration: " + params.BuildConfiguration